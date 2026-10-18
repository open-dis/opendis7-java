
import java.net.*;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.XmlRpcException;

/**
 * Simple example of an XML-RPC client that uses Apache XML-RPC 3.x to
 * contact a server and call a method on it.
 *
 * Based on the Apache XML RPC client example: https://ws.apache.org/xmlrpc/client.html
 *
 * @author DMcG
 */
public class RpcClient {

    public static void main(String args[]) {

        Object[] results, params;
        String[] names;
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        XmlRpcClient client = new XmlRpcClient();
        try {

            // Set the configuration to talk to localhost. The servlet should be listening
            // on localhost, with the url of "xmlrpc". This uses the default transport
            // mechanism of java.net.HttpURLConnection. You can also configure other
            // http transport mechanisms, such as XmlRpcCommonsTransportFactory, which
            // is another HTTP transport with a different API but smaller memory footprint.
            config.setServerURL(new URI("http://localhost:8080/SavageSearch").toURL());
            System.out.println("created URL: http://localhost:8080/SavageSearch");
            config.setEnabledForExtensions(true);
            config.setContentLengthOptional(false);
            config.setConnectionTimeout(60 * 1000);
            config.setReplyTimeout(60 * 1000);

            client.setConfig(config);

            // Call the method by putting together an array of parameters and calling
            // the client object. The client object automatically translates the
            // array information and other data into the correct XML format.

            // Parameters to the search() method call; the first argument is
            // the database to be searched, the second is the term to be
            // searched for in that database
            params = new Object[] {"Savage", "Harrier"};
            System.out.println("preparing search for: (Savage, Harrier)");

            results = (Object[]) client.execute("SavageSearch.search", params);

            names = new String[results.length];
            for(int idx = 0; idx < results.length; idx++) {
                names[idx] = (String) results[idx];
                System.out.println("Result " + (idx+1) + " is " + names.getClass().getName() + " " + names[idx]);
            }
        } catch(XmlRpcException | MalformedURLException | URISyntaxException e) {
            System.err.println(e);
        } finally {
            System.exit(0);
        }

    } // End main

}
