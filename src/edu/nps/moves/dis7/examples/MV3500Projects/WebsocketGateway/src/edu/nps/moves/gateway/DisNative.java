package edu.nps.moves.gateway;

import edu.nps.moves.dis7.pdus.EntityID;
import edu.nps.moves.dis7.pdus.EntityStatePdu;
import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.utilities.PduFactory;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reads and writes DIS from a native socket on the local network. This
 * implements the DISEndpoint interface, which allows it to interoperate with
 * the ConnectionManager.
 *
 * @author DMcG
 */
public class DisNative implements Runnable, DISEndpoint {

    private static final int PORT = 3000;

    /**
     * Max size of UDP DIS packets to receive. May need to be bigger for bundled
     * PDUs, in which multiple PDUs are placed in one UDP packet. VBS2 sends
     * some large-ish packets with a lot of articulation parameters, which can
     * blow past the typical UDP MTU packet size of 1500 bytes.
     */
    private static final int MAX_UDP_PACKET_SIZE = 8 * 1024;

    /**
     * socket can be used for either bcast or multicast
     */
    private MulticastSocket multicastSocket;

    /**
     * If reading from multicast, use this address
     */
    private InetAddress multicastAddress;

    /**
     * Port socket listens on for DIS traffic
     */
    private int port;

    /**
     * Used for performance instrumentation
     */
    private int messageCount = 0;

    /**
     * Used for performance instrumentation
     */
    private Date startTime = new Date();

    /**
     * 255.255.255.255 is by definition the bcast address on whatever network
     * you're on, no matter what the subnet mask
     */
    private InetAddress broadcastAddress;

    /**
     * Converts IEEE binary DIS to a Java DIS PDU object
     */
    private PduFactory pduFactory = new PduFactory();

    /**
     * Unique ID placed in the padding of PDUs sent. This is a cheat, intended
     * to prevent routing loops. We want the gateway ID to be non-zero.
     */
    private short gatewayID = (short) ((Math.random() * 254) + 1);
    
    private boolean quit = false;

    /**
     * Constructor
     *
     * @param socket socket we read and write on.
     * @param multicastAddress If null we read &amp; write bcast. Otherwise mcast on
     * this address
     * @param port port number
     */
    public DisNative(MulticastSocket socket, InetAddress multicastAddress, int port) {
        this.multicastSocket = socket;
        this.multicastAddress = multicastAddress;
        this.port = port;
        try {
            this.broadcastAddress = InetAddress.getByName("255.255.255.255");
        } catch (UnknownHostException e) {
            System.err.println(e);
            e.printStackTrace(System.err);
        }

        // Some OSes require the socket to explictly be put into bcast mode
        try {
            if (multicastAddress == null && !multicastSocket.getBroadcast()) {
                this.multicastSocket.setBroadcast(true);
            }
        } catch (SocketException e) {
            System.err.println("Cant put socket into bcast mode " + e);
            e.printStackTrace(System.err);
        }
    }

    /**
     * Entry point for thread. Endlessly loop, reading UDP DIS packets.
     */
    @Override
    public void run() {
        // Get the manager for all things that can read and write DIS, including
        // web pages connected via a web socket and, like this object, a native
        // socket reading and writing DIS from the local network.
        ConnectionManager connectionManager = ConnectionManager.getConnectionManager();

        // Performance monitoring
        Map<EntityID, Pdu> entities = new Hashtable<>();

        // Read DIS from the local network. Send native DIS packets to all web
        // pages that are connected via web sockets.
        ByteBuffer byteBuffer = ByteBuffer.allocate(MAX_UDP_PACKET_SIZE);
        DatagramPacket packet = new DatagramPacket(byteBuffer.array(), byteBuffer.capacity());
        byte[] trimmedData;
        Pdu aPdu;
        EntityStatePdu espdu;
        Date endTime;
        long elapsedTime;
        
        try {
            while (!quit) {
                multicastSocket.receive(packet);

                //byte[] contents = packet.getData();
                //System.out.print( "var data = new Array(" );
                //for(int idx = 0; idx < packet.getLength(); idx++)
                //{
                //   System.out.print(contents[idx] + ", ");
                //}
                //System.out.println(");");
                // getLength() returns the length of the data actually received.
                //System.out.println("Received packet size:" + packet.getLength());
                //System.out.println("Got DIS packet from native network");
                // Turn the DIS binary into a Java object. This is optional,
                // but useful; we can perhaps do filtering based on the location,
                // and right now we only send ESPDU's to web clients. In contrast
                // to JSON, this is pretty cheap in the cosmic scheme of things.
                // Meaning it's not all that effcient, but get a life.
                aPdu = pduFactory.createPdu(packet.getData());

                // Can't interepret the packet? It's probably not DIS, or it's not
                // a supported PDU type, so don't forward it to the web clients.
                if (aPdu == null) {
                    continue;
                }

                // one problem we can have is routing loops. For example, a web
                // client sends a PDU. We receive it and send it out on the native
                // interface. Via the rules of bcast and mcast, we also _receive_
                // that PDU. We may accidentally send another copy to all the
                // web clients. So we set the padding field to contain a value,
                // and discard the pdu if we're the one that sent it.
                if (aPdu.getLength() == gatewayID) {
                    //System.out.println("Discarding looped packet, id=" + gatewayID);
//                    continue;
                }

                messageCount++;
                if (messageCount % 10000 == 0) {
                    endTime = new Date();
                    elapsedTime = endTime.getTime() - startTime.getTime();
                    System.out.println("Elapsed time = " + elapsedTime);
                    System.out.println("Packets per second received, 10K packets: " + 10000.0 / (elapsedTime / 1000.0));
                    System.out.println("Entity world count: " + entities.keySet().size());
                    messageCount = 0;
                    startTime = endTime;
                }

                if (aPdu instanceof EntityStatePdu) {
                    espdu = (EntityStatePdu) aPdu;
                    if (entities.get(espdu.getEntityID()) == null) {
                        entities.put(espdu.getEntityID(), aPdu);
                    }
                }

                // We know this is an PDU. Forward out the PDU to all clients,
                // including any web pages. Limit the size of the binary data
                // to only the length of the data received.
                trimmedData = new byte[packet.getLength()];
                System.arraycopy(byteBuffer.array(), 0, trimmedData, 0, packet.getLength());
                //System.out.println("Sending binary message length" + trimmedData.length);
                //String phonyMessage = "\"{'protocolVersion':6,'exerciseID':1,'pduType':1,'protocolFamily':1,'timestamp':280742925,'pduLength':144,'padding':-18884,'entityID':{'site':7,'application':155,'entity':38008},'forceId':3,'numberOfArticulationParameters':0,'entityType':{'entityKind':1,'domain':3,'country':205,'category':27,'subcategory':4,'spec':0,'extra':6},'alternativeEntityType':{'entityKind':0,'domain':0,'country':0,'category':0,'subcategory':0,'spec':0,'extra':0},'entityLinearVelocity':{'x':-0.18839877843856812,'y':-0.21264395117759705,'z':0.22128817439079285},'entityLocation':{'x':5099250.912415399,'y':-560530.1508509029,'z':3777289.9119291855},'entityOrientation':{'psi':-2.2958126068115234,'theta':-0.6617516875267029,'phi':2.4262077808380127},'entityAppearance':0,'deadReckoningParameters':{'deadReckoningAlgorithm':2,'otherParameters':[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],'entityLinearAcceleration':{'x':0,'y':0,'z':0},'entityAngularVelocity':{'x':0,'y':0,'z':0}},'marking':{'characterSet':1,'characters':[78,74,79,82,68,32,82,0,0,0,0]},'capabilities':0,'articulationParameters':[]}\"";
                //connectionManager.repeatMessage(phonyMessage, null);
                //connectionManager.repeatMessage(phonyMessage, null);
                connectionManager.repeatBinaryMessage(trimmedData, null);
                //connectionManager.repeatBinaryMessage(trimmedData, null);

                // We can also convert this to JSON if we like.
                //JSONObject obj = new JSONObject(aPdu);
                //System.out.println(obj.toString());
                byteBuffer.clear();
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            SocketAddress addr = multicastSocket.getLocalSocketAddress();
            try {
                if (((InetSocketAddress)addr).getAddress().isMulticastAddress()) {
                    NetworkInterface netIf = multicastSocket.getNetworkInterface();
                    multicastSocket.leaveGroup(addr, netIf);
                }
                multicastSocket.disconnect();
                multicastSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(DisNative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Sending strings to the local network is probably a bad idea. For now we
     * simply no-op this because it doesn't make sense to send a non-standard
     * string to the network.
     *
     * @param aMessage string containing message info
     */
    @Override
    public void sendToClient(String aMessage) {
    }

    /**
     * Send native DIS to the local native network. Typically we receive DIS
     * from some web page, and send it to the local network.
     *
     * @param buf DIS data
     */
    @Override
    public void sendBinaryToClient(byte[] buf) {
        // Send out on all bcast addresses on all interfaces, or send out
        // in mcast format.

        Pdu aPdu = pduFactory.createPdu(buf);

        // Not DIS, or at least not decodable by open-dis as DIS? Drop it.
        if (aPdu == null) {
            return;
        }

        // Helps prevent routing loops. We stick a number in an unused portion
        // of the PDU, so when we read it back we know we sent it. This is kind
        // of bogus, but we're combining bridging and routing in one layer, so
        // there's no good way around it.
        aPdu.setLength(gatewayID);
        GregorianCalendar date = new GregorianCalendar();
        aPdu.setTimestamp((int) date.getTime().getTime());
        try {
            byte[] data = aPdu.marshal().array();
            DatagramPacket packet;

            // Send to multicast if we have a multicast address set
            if (multicastAddress != null) {
                packet = new DatagramPacket(data, data.length, multicastAddress, port);
            } else // send bcast
            {
                packet = new DatagramPacket(data, data.length, broadcastAddress, port);
            }
            multicastSocket.send(packet);
        } catch (Exception ex) {
            Logger.getLogger(DisNative.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** set sentinel value to exit infinite loop */
    public void quit() {
        quit = true;
    }
}
