package edu.nps.moves.gateway;

/**
 * interface for things that can read or send binary or JSON format DIS packets. 
 * This may be a web page connected via a web socket or, on the server side, a 
 * native socket that reads and writes bcast or mcast DIS.
 * 
 * @author DMcG
 */
public interface DISEndpoint 
{
    /** Send binary format DIS to an endpoint.
     * @param buf raw array of DIS data
     */
   void sendBinaryToClient(byte[] buf);
   
   /** Send JSON format DIS to a client
     * @param aMessage string containing message info
     */
   void sendToClient(String aMessage);
}
