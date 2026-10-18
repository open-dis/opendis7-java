
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.ServletWebServer;
import org.apache.xmlrpc.webserver.WebServer;
import org.apache.xmlrpc.webserver.XmlRpcServlet;

/** Based on the Apache XML RPC server example: https://ws.apache.org/xmlrpc/server.html
 *
 * @author <a href="mailto:tdnorbra@nps.edu?subject=.RpcServer">Terry Norbraten, NPS MOVES</a>
 */
public class RpcServer {

    static WebServer ws = null;

    public static void main(String[] args) {

        XmlRpcServer xmlRpcServer;
        XmlRpcServerConfigImpl config;
        XmlRpcServlet servlet = new XmlRpcServlet();
        PropertyHandlerMapping mapping = new PropertyHandlerMapping();
        try {
            ws = new ServletWebServer(servlet, 8080);
            xmlRpcServer = ws.getXmlRpcServer();

            mapping.addHandler("SavageSearch", SavageSearch.class);
            xmlRpcServer.setHandlerMapping(mapping);

            config = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            config.setEnabledForExtensions(true);
            config.setContentLengthOptional(false);
            config.setKeepAliveEnabled(false);

            ws.start();
            System.out.println(RpcServer.class.getName() + " started: " + new Date().toString());
        } catch (XmlRpcException | IOException | ServletException ex) {
            if (ws != null) {
                ws.log(ex);
                ws.shutdown();
            } else
                System.err.println(ex);
        }
    }

} // end class RpcServer
