package edu.nps.moves.gateway;

import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;

import java.io.IOException;
import java.net.*;

/**
 * Creates a multicast socket. Uses SO_REUSE_ADDR, so the socket can be
 * opened even if another program is already listening on that port.
 * 
 * @author DMcG
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=edu.nps.moves.gateway.DisSocketFactory"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
public class DisSocketFactory 
{
    /** create a MulticastSocket for DIS traffic
     * @param port internet port of interest
     * @param multicastGroup multicast address of interest
     * @return a MulticastSocket for DIS traffic */
    public static MulticastSocket getDisSocket(int port, String multicastGroup)
    {
        MulticastSocket socket = null;
        
       try
       {
           // Some fancy footwork to allow us to open a UDP socket even if
           // anther program has already opened a socket on that port. Opens
           // on the wildcard address, ie all configured interfaces--both wired
           // and wireless, typically.
           
           // We want do do this because often we have another application on this
           // host generating traffic, or listening for traffic, also on the default 
           // DIS port.
           socket = new MulticastSocket(port);
           socket.setReuseAddress(true);
            
           if(multicastGroup != null)
           {
               InetAddress group = InetAddress.getByName(multicastGroup);
               if(group.isMulticastAddress())
               {
                   SocketAddress mcastaddr = new InetSocketAddress(group, port);
                   socket.joinGroup(mcastaddr, DisThreadedNetworkInterface.findIpv4Interface());
               }
           } else {
               socket.setBroadcast(true);
           }
           
       }
       catch(IOException e)
       {
           System.err.println(e);
       }
       
       return socket;
    }
}
