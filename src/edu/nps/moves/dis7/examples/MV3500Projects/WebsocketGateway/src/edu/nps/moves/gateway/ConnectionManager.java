package edu.nps.moves.gateway;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Manages the various connections established by web pages. There may be
 * N web pages connected to the gateway. This manages the connections 
 * established by the web pages and provides a central point for sending
 * messages to all connected pages.<p>
 * 
 * We need to be careful about concurrency here--things are happening
 * async and we can be multithreaded. This is a singleton.
 * 
 * @author DMcG
 */
public class ConnectionManager 
{
    /** Singleton */
    public static ConnectionManager connectionManager = null;
    
    /** Every connection established by a web page is kept in this list. This should
     * be a concurrentHashSet, but there doesn't seem to be one out of the box.
     */
    private Map<DISEndpoint, DISEndpoint> connections;
    
    /** Use this to get the single, shared connectionManager instance
     * @return the single, shared instance of ConnectionManager
     */
    public static synchronized ConnectionManager getConnectionManager()
    {
        if(connectionManager == null)
        {
            connectionManager = new ConnectionManager();
        }
        
        return connectionManager;
    }
    
    /** Use the static method above to retrieve the single, shared connection manager
     */
    private ConnectionManager()
    {
        this.connections = new ConcurrentHashMap<>(); 
    }
    
    /**
     * Add a client connection to the list. Messages will be
     * relayed to this client.
     * 
     * @param aConnection a DISEndpoint instance
     * @see DISEndpoint
     */
    public synchronized void addConnection(DISEndpoint aConnection)
    {
        connections.put(aConnection, aConnection);
    }
    
    /**
     * Remove a connection from the list of active connections. This is
     * typically called when a client closes the connection. We remove it
     * from the list of active connections.
     * 
     * @param aConnection a DISEndpoint instance
     * @see DISEndpoint
     */
    public synchronized void removeConnection(DISEndpoint aConnection)
    {
        connections.remove(aConnection);
    }
    
    /**
     * Send a message we have received from the sender out to all the other
     * clients, but do NOT send it back to the client that sent it. Typically
     * the message is in string JSON format.
     * 
     * @param message message received from sender
     * @param sender the client that sent the message. The message is not sent to this client. If the
     * sender is null, the message is sent to all connected clients.
     */
    public void repeatMessage(String message, DISEndpoint sender)
    {
        try
        {
            // Optionally we can convert the string into a Java JSON
            // object and examine it for various reasons, just as 
            // area of interest management. This can be a fairly expensive
            // operation in high traffic environments.

            //JSONObject jsonMessage = new JSONObject(message);

            // Loop through all the connections, repeating the message out
            // (except to the connection that sent it). Note that the 
            // DISEndpoint may actually be a native network DIS connection.

            for (DISEndpoint aConnection : connections.keySet()) {
                // Repeat the message to all clients, except the client that sent it.
                // If the sender is null, always send it to all of the connections
                if(sender == null || !aConnection.equals(sender))
                {
                    aConnection.sendToClient(message);
                }
            }
        }
        catch(Exception e)
        {
           System.err.println(e);
           e.printStackTrace(System.err);
        }
    }
    
    /**
     * Send a binary message we have received from the sender out to all the other
     * clients, but do NOT send it back to the client that sent it. The message
     * is typically in IEEE DIS binary format.
     * 
     * @param data message received from sender
     * @param sender the client that sent the message. The message is not sent to this client.
     * If the sender is null, the message is sent to all clients.
     */
    public void repeatBinaryMessage(byte[] data, DISEndpoint sender)
    {
        try
        {
            // Optionally we can convert the data into a Java object       
            for (DISEndpoint aConnection : connections.keySet()) {
                // Repeat the message to all clients, except the client that sent it.
                // If the sender is null, always send it to all of the connections
                if(sender == null || !aConnection.equals(sender))
                {
                    aConnection.sendBinaryToClient(data);
                }
            }
        }
        catch(Exception e)
        {
           System.err.println(e);
           e.printStackTrace(System.err);
        }
        
    }

}
