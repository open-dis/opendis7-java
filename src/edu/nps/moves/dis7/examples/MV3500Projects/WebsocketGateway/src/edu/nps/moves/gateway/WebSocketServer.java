package edu.nps.moves.gateway;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a full-blown web server that happens to also handle websocket
 * connections on the server side. Websocket connections are handed off
 * to a subclass for handling.
 * 
 * Lifted from http://amilamanoj.blogspot.com/2013/06/secure-websockets-with-jetty.html
 * 
 * @author DMcG
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=edu.nps.moves.gateway.WebSocketServer"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
public class WebSocketServer 
{
    /** The default port the webserver listens on. */
    private static final int DEFAULT_WEBSERVER_PORT = 8282;
    
    /** The web server we're creating */
    private Server server;
    
    /** The handlers--the type of content the web server can serve up */
    private List<Handler> webSocketHandlerList = new ArrayList<>();
    
    /** DIS binary repeater */
    private DisNative listener;

    /** New instance of WebSocketServer */
    private WebSocketServer() {
        try {
            init();
        } catch (Exception ex) {
            Logger.getLogger(WebSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void init() throws Exception  {
        
        // Get config properties
        Properties config = new Properties();
        try (InputStream in = new FileInputStream("GatewayConfiguration.properties")) {
            config.load(in);
        }
        
        System.out.println("Gateway configuration properties loaded");

        // Basic Jetty server
        server = new Server();
        server.setStopAtShutdown(true);
        
        // Add handlers for the various things a web server can do: basic
        // http, websockets, etc.
        
        // Http server
        HttpConfiguration httpConfiguration = new HttpConfiguration();
        ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(httpConfiguration));
        int webserverPort = DEFAULT_WEBSERVER_PORT;
        try
        {
            webserverPort = Integer.parseInt(config.getProperty("webserverPort"));
        }
        catch(NumberFormatException e)
        {
            System.err.println("webserver port not specified in GatewayConfiguration.properties, using default of " + DEFAULT_WEBSERVER_PORT);
        }
        http.setPort(webserverPort);
        
        // Tell server about connections
        Connector[] connectors = {http};
        server.setConnectors(connectors);
        
        // Set up a websocket handler. Incoming requests to ws://
        // will be handed off to this class.
        WebSocketHandler wsHandler = new WebSocketHandler() 
        {
            @Override
            public void configure(WebSocketServletFactory webSocketServletFactory) 
            {
                webSocketServletFactory.register(WebPageConnection.class);
            }
        };
        
        // Add it to the handler list
        ContextHandler wsContextHandler = new ContextHandler();
        wsContextHandler.setHandler(wsHandler);
        webSocketHandlerList.add(wsHandler);
        
        // Add a static content (html) handler. Html and other files
        // go in the content directory.
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[] {"index.html", "index.htm"} );
        resourceHandler.setResourceBase("./content");
        webSocketHandlerList.add(resourceHandler);
        
        // Add a JSP handler. JSP can be handy for determining the internal
        // state of this server from a web page and displaying it to the user
        WebAppContext jspContext = new WebAppContext();
        jspContext.setWelcomeFiles(new String[] {"index.jsp"});
        jspContext.setResourceBase("./content");
        jspContext.setContextPath("/");
        webSocketHandlerList.add(jspContext);
        
        // Create a default handler for everything else
        DefaultHandler defaultHandler = new DefaultHandler();
        webSocketHandlerList.add(defaultHandler);
        
        // Logging
        RequestLogHandler requestLogHandler = new RequestLogHandler();
        webSocketHandlerList.add(requestLogHandler);
        
        RequestLogWriter writer = new RequestLogWriter("./logs/jetty-yyyy_mm_dd.request.log");
        CustomRequestLog requestLog = new CustomRequestLog(writer,  CustomRequestLog.EXTENDED_NCSA_FORMAT);
        writer.setRetainDays(90);
        writer.setAppend(true);
        requestLogHandler.setRequestLog(requestLog);
        
        // Add the handlers we created above to the server. The order in which they're
        // added is significant; the web server travels down the handler list until
        // it finds a match.
        HandlerCollection handlerCollection = new HandlerCollection();
        handlerCollection.setHandlers(webSocketHandlerList.toArray(new Handler[0]));
        server.setHandler(handlerCollection);

        // We've configured the web server to manage several types of content: html,
        // jsp pages, and web sockets.
        
        // Start listening for native DIS on the local TCP/IP network.
        int port = Integer.parseInt(config.getProperty("disPort"));
        String mcastString = config.getProperty("multicastAddress");
        MulticastSocket s = DisSocketFactory.getDisSocket(port, mcastString); // bcast if null
        
        // No mcast group specified in config file? Use bcast.
        if(mcastString == null)
        {
            listener = new DisNative(s, null, port);
        }
        else
        {
            InetAddress mcast = InetAddress.getByName(mcastString);
            listener = new DisNative(s, mcast, port);
        }
        
        // Add the native DIS network to the list of things that will be notified
        // if a packet arrives from a web client
        ConnectionManager.getConnectionManager().addConnection(listener);
        
        // Run the native listening thread 
        Thread aThread = new Thread(listener, listener.getClass().getName());
        aThread.setDaemon(true);
        aThread.start();
        System.out.println("Started listening for DIS on UDP port " + port);
        
        // Start the http server
        System.out.println("Starting websocket server on TCP port " + webserverPort);
        server.start();
    }
    
    /** 
     * Entry point.Create a new Server class, initialize it, and start it. Give
     * user a clean way to exit program gracefully by typing a "q" on the
     * command line.
     * @param args program entry arguments (if any)
     */
    public static void main(String[] args)
    {
        WebSocketServer wss = new WebSocketServer();
        
        Runnable r = () -> {

            Scanner scan  = new Scanner(System.in);
            String line;
            while (true) {
                System.out.println("Type q/enter to quit");
                line = scan.nextLine();
                if (line.equalsIgnoreCase("q")) {
                    
                    // This should clear the queue for the ConnectionManager
                    ConnectionManager.getConnectionManager().removeConnection(wss.listener);
                    wss.listener.quit();
                    
                    System.out.println("... QUIT");
                    
                    try {
                        wss.server.stop();
                        wss.server.join();
                    } catch (Exception ex) {
                        Logger.getLogger(WebSocketServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    wss.webSocketHandlerList.clear();
                    break;
                }
            }
        };
        
        Thread t = new Thread(r, "Quit Thread");
        t.setDaemon(true);
        t.start();
        
        try {
            wss.server.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(WebSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
