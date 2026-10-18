package DisShooting;

import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.utilities.DisTime;
import edu.nps.moves.dis7.utilities.PduFactory;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Networking utility working in ipv4 broadcast mode for both send/receive
 * of entity and targeting DIS PDUs.
 *
 * @author DMcG
 * @author &lt;a href="mailto:tdnorbra@nps.edu?subject=mv4503.NetworkComms"&gt;Terry Norbraten, NPS MOVES&lt;/a&gt;
 */
public class NetworkComms implements Runnable
{
    private static final int PORT = 3000;
    private static NetworkComms networkComms = null;
    
    private DatagramSocket socket;
    private InetAddress broadcastAddress = null;
    private PduFactory pduFactory;
    private DatagramPacket sendPacket, receivePacket;
    private ByteBuffer buffSend, buffReceive;
    
    /** people we notify when we receive a PDU */
    private List<PduListener> listeners;
    
    /** provide reference to this object
      * @return reference to this object */
    public static NetworkComms getInstance()
    {
        synchronized(NetworkComms.class)
        {
            if(networkComms == null)
            {
                networkComms = new NetworkComms();
                Thread aThread = new Thread(networkComms);
                aThread.setDaemon(true);
                aThread.start();
            }
        }
        
        return networkComms;
    }
    
    private NetworkComms()
    {
        pduFactory = new PduFactory();
        listeners = new ArrayList<>();
        
        try
        {
            // Some fancy footwork to allow us to open a UDP socket even if
            // anther program has already opened a socket on that port. Opens
            // on the wildcard address, i.e. all configured interfaces, both 
            // wired and wireless, typically.
            socket = new DatagramSocket(null);
            socket.setReuseAddress(true);
            socket.setBroadcast(true);
            socket.bind(new InetSocketAddress(PORT));
            
            broadcastAddress = InetAddress.getByName("255.255.255.255");
            buffSend = ByteBuffer.allocate(1500);
            sendPacket = new DatagramPacket(buffSend.array(), buffSend.array().length, broadcastAddress, PORT);
            buffReceive = ByteBuffer.allocate(1500);
            receivePacket = new DatagramPacket(buffReceive.array(), buffReceive.array().length);
        }
        catch(SocketException | UnknownHostException e)
        {
            buffSend.clear();
            buffReceive.clear();
            socket.close();
            System.err.println(e);
        }
    }
    
    /**
     * Listens for PDUs. Builds a list of all the entities it hears from
     * in the form of ESPDUs.
     */
    @Override
    public void run()
    {
        Pdu aPdu;
        
        try {
            while (true) {
                socket.receive(receivePacket);
                aPdu = pduFactory.createPdu(buffReceive.array());

                // unable to decode data from socket; just continue
                if (aPdu == null)
                    continue;

                notifyListeners(aPdu);
                buffReceive.clear();
            }
        } catch (IOException ex) {
            Logger.getLogger(NetworkComms.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            listeners.clear();
            buffReceive.clear();
            socket.close();
        }
    }
    /** Send a PDU
     * @param aPdu to send */
    public void sendPdu(Pdu aPdu)
    {
        aPdu.setTimestamp(DisTime.getCurrentDisTimestamp());
        try {
            if (!socket.isClosed() && (aPdu.marshal() != null))
            {
                sendPacket.setData(aPdu.marshal().array());
                socket.send(sendPacket);
            }
        } catch (Exception ex) {
            Logger.getLogger(NetworkComms.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            buffSend.clear();
        }
    }
    
    /** add a PduListener, if not already present
     * @param aListener PduListener reference to add */
    public void addListener(PduListener aListener)
    {
        listeners.add(aListener);
    }
    
    /** remove a PduListener, if present
     * @param aListener PduListener reference to remove */
    public void removeListener(PduListener aListener)
    {
        listeners.remove(aListener);
    }
    
    private void notifyListeners(Pdu aPdu)
    {
        for(PduListener aListener: listeners)
        {
            aListener.pduReceived(aPdu);
        }
    }
}
