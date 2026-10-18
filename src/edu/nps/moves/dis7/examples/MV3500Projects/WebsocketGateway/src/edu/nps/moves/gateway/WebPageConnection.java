package edu.nps.moves.gateway;

import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.nio.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;

/**
 * A class that corresponds to one connection to one web page client. This is created when
 * a client connects a websocket to us, one instance per connection. Typically there's one
 * websocket opened from the web page to the server.
 * 
 * Lifted from http://amilamanoj.blogspot.com/2013/06/secure-websockets-with-jetty.html
 * 
 * @author DMcG
 */
@WebSocket
public class WebPageConnection implements DISEndpoint
{
    /** The far side of the connection */
    private RemoteEndpoint remote;
    
    /** Current server session */
    private Session session;
    
    /** Asynchronous message handler */
    private Future<Void> fut = null;

    /** Fired when the websocket from the client connects. Add it to the ConnectionManager's
     * list of connections.
     * 
     * @param session The session with the web client
     */
    @OnWebSocketConnect
    public void onConnect(Session session) 
    {
        System.out.println("WebSocket Opened");
        this.session = session;
        this.remote = session.getRemote();
        
        ConnectionManager.getConnectionManager().addConnection(this);
    }

    /** Fired when the client sends a message. Tell the connection manager to repeat the 
     * message to all other clients, but do not loop it back to the sender.
     * 
     * @param message the (text) message sent from the client to the server, typical in JSON format
     */
    @OnWebSocketMessage
    public void onMessage(String message) 
    {
        //System.out.println("Message from Client: " + message);
        ConnectionManager.getConnectionManager().repeatMessage(message, this);
    }
    
    /** Fired when a client sends a binary message. 
     *
     * @param buf binary data
     * @param offset in array for binary data
     * @param length of binary data in array
     */
    @OnWebSocketMessage
    public void onBinaryMessage(byte buf[], int offset, int length)
    {
       //PduFactory factory = new PduFactory();
       //Pdu aPdu = factory.createPdu(buf);
       //System.out.println("Got web pdu of type " + aPdu.getClass().getName() );
        if (session.isOpen())
            ConnectionManager.getConnectionManager().repeatBinaryMessage(buf, this);
    }
    
    /**
     * Error-handling method
     * @param error Exception of interest
     */
    @OnWebSocketError
    public void onWebSocketError(Throwable error) {
        if (fut != null)
            fut.cancel(true);
        
        System.err.println(error);
    }

    /** Fired when the web socket closes. The client informs us, and we remove
     * the client from the list of active clients in ConnectionManager
     * 
     * @param statusCode reason for closure
     * @param reason string reason for closure
     */
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) 
    {
        if (fut != null)
            fut.cancel(true);
        
        ConnectionManager.getConnectionManager().removeConnection(this);
        System.out.println("WebSocket Closed. Code:" + statusCode + " Reason:" + reason);
    }
    
    /**
     * Sends data in string format to the client. This is typically in
     * JSON format. This is usually called by the ConnectionManager.
     * 
     * @param message data to be sent
     */
    @Override
    public void sendToClient(String message)
    {
        try
        {
            remote.sendString(message);
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
    
    /**
     * Sends data in binary format to the client. The end client is typically
     * another web page.
     * 
     * @param buf binary array containing DIS data
     */
    @Override
    public void sendBinaryToClient(byte[] buf)
    {   
        try
        {
            if (session.isOpen()) {
                fut = remote.sendBytesByFuture(ByteBuffer.wrap(buf));
                fut.get(500, TimeUnit.MILLISECONDS);
//                remote.sendBytes(ByteBuffer.wrap(buf));
            }
        } 
//        catch (IOException ex) {
//            Logger.getLogger(WebPageConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
        catch(InterruptedException | ExecutionException | TimeoutException ex) {
            if (fut != null)
                fut.cancel(true);
            
            Logger.getLogger(WebPageConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
