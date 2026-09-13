package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.enumerations.*;
import edu.nps.moves.dis7.pdus.*;
import edu.nps.moves.dis7.utilities.DisTime;
import edu.nps.moves.dis7.utilities.PduFactory;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Listen to all kinds of PDUs and report them */
public class AllPduReceiver
{
    /** Default constructor */
    public AllPduReceiver()
    {
        // default constructor
    }
    /** default multicast address
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address" target="_blank">https://en.wikipedia.org/wiki/Multicast_address</a> */
    public static final String  DEFAULT_MULTICAST_ADDRESS = AllPduSender.DEFAULT_MULTICAST_ADDRESS;
    /** default multicast port
     * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)" target="_blank">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> */
    public static final int     DEFAULT_MULTICAST_PORT    = AllPduSender.DEFAULT_MULTICAST_PORT;
    /** TODO whether to use Fast ESPDU */
    public static final boolean USE_FAST_ESPDU = false;
    
	/** Output prefix to identify this class */
    private final static String TRACE_PREFIX = "[" + AllPduReceiver.class.getName() + "] ";

    /**
     * Program invocation, execution starts here
     * @param args command-line arguments
     */
    public static void main(String args[])
    {
        MulticastSocket multicastSocket;
        InetAddress     multicastInetAddress;
        PduFactory      pduFactory = new PduFactory();
        DisTime.TimestampStyle       timestampStyle        = DisTime.TimestampStyle.IEEE_ABSOLUTE;
        DisTime.setTimestampStyle(timestampStyle);

        System.out.println(TRACE_PREFIX + "started...");

        try {
            if (args.length == 2)
            {
                multicastInetAddress = InetAddress.getByName(args[0]);
                multicastSocket  = new MulticastSocket(Integer.parseInt(args[1]));
            }
            else
            {
                System.out.println("Usage:   AllPduReceiver <multicast group address> <port>");
                System.out.println("Default: AllPduReceiver     " + DEFAULT_MULTICAST_ADDRESS + "      " + DEFAULT_MULTICAST_PORT);
                multicastSocket  = new MulticastSocket(DEFAULT_MULTICAST_PORT);
                multicastInetAddress = InetAddress.getByName(DEFAULT_MULTICAST_ADDRESS);
            }
            System.out.println("To quit: stop or kill this process");
    //      multicastSocket.joinGroup(multicastInetAddress); // deprecated

            // =======================================================================
            // new approach using interface
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(multicastInetAddress);
            SocketAddress localMulticastSocketAddress = new InetSocketAddress(multicastInetAddress, DEFAULT_MULTICAST_PORT);
            multicastSocket.joinGroup(localMulticastSocketAddress, networkInterface);
            // =======================================================================

            byte buffer[]  = new byte[1500]; // typical MTU size in bytes

            while (true) // Loop indefinitely, receiving datagrams
            {
                Arrays.fill(buffer, (byte)0);
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length); // reset packet each time
                multicastSocket.receive(datagramPacket);  // process blocks here until receipt of network packet with PDU
        //        datagramPacket.setLength(buffer.length);

        //      Pdu pdu = pduFactory.createPdu(packet.getData()); // packet.getData() returns byte[] array data buffer

                List<Pdu> pduBundle = pduFactory.getPdusFromBundle(datagramPacket.getData(),datagramPacket.getLength());

                if      (pduBundle.isEmpty())
                     System.out.println("Received PDU bundle is empty, packet.getData().length=" + datagramPacket.getData().length + ", error...");
        //      else if (pduBundle.size() == 1)// common case, typically unremarkable
        //           System.out.println("Received PDU bundle size is " + pduBundle.size());
                else if (pduBundle.size() > 1)
                     System.out.println("Received PDU bundle size is " + pduBundle.size());

                for (Pdu nextPdu : pduBundle) // iterator loop through PDU bundle
                {
                    DisPduType currentPduType       = nextPdu.getPduType(); //short  currentPduType = nextPdu.getPduType();
                    String     currentPduTypeName   = nextPdu.getClass().getSimpleName();
                    String     currentPduFamilyName = nextPdu.getClass().getSuperclass().getSimpleName();
                    DISProtocolFamily currentProtocolFamilyID = nextPdu.getProtocolFamily(); //short  currentProtocolFamilyID = nextPdu.getProtocolFamily();

                    StringBuilder message = new StringBuilder();
                    message.append(DisTime.convertToString(nextPdu.getTimestamp())).append(" ");
                    message.append("received new DIS PDU ");
                    String currentPduTypePadded     = String.format("%-48s", currentPduType);     // - indicates right padding of whitespace
                    message.append(currentPduTypePadded);
                    // optional, verbose
        //            String currentPduTypeNamePadded = String.format("%-49s", currentPduTypeName); // - indicates right padding of whitespace
        //            message.append(" of type ").append(currentPduTypeNamePadded); // package.class name
                    message.append(" (").append(currentProtocolFamilyID);
        //          message.append(" ").append(currentPduFamilyName); // class name is also available
                    message.append(")");
                    System.out.println(message.toString()); // diagnostic information helps

                    // additional message information of interest, if any
                    switch (currentPduType) // using enumeration values from edu.​nps.​moves.​dis7.​enumerations.​DisPduType
                    {
                        case COMMENT:
                            CommentPdu commentPdu = (CommentPdu)nextPdu; // cast to precise type
                            ArrayList<VariableDatum> payloadList = (ArrayList<VariableDatum>)commentPdu.getVariableDatums();
                            if (!payloadList.isEmpty())
                                System.out.print  ("   messages: ");
                            for (VariableDatum variableDatum : payloadList)
                            {
                                String nextComment = new String(variableDatum.getVariableDatumValue()); // convert byte[] to String
                                System.out.print  (" \"" + nextComment + "\"");
                            }
                            System.out.println();
                    }
                }
                pduBundle.clear();
            }
        }
        catch (IOException e) {
          System.out.println("Problem with OpenDis7Examples.AllPduReceiver, see exception trace:");
          System.out.println(e);
        }
        finally {
          System.out.println("OpenDis7Examples.AllPduReceiver complete.");
        }
      }
}
