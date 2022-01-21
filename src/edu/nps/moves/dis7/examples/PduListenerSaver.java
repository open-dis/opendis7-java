/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.stream.PduRecorder;
import java.util.Scanner;

/** Class to leverage the {@link edu.nps.moves.dis7.utilities.stream.PduRecorder} 
 * with PDU log saving console controls for resume, pause and quit.
 * 
 * PduSaver.java created on Aug 21, 2019
 * Renamed PduListenerSaver
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class PduListenerSaver
{
    private final static String DEFAULT_OUTPUT_DIRECTORY = "./pduLog";
    
    /** Default multicast group address <code>239.1.2.3</code> for send and receive connections.
     * @see <a href="https://en.wikipedia.org/wiki/Multicast_address">https://en.wikipedia.org/wiki/Multicast_address</a>  */
    public static String DEFAULT_DIS_ADDRESS = DisThreadedNetworkInterface.DEFAULT_DIS_ADDRESS;

    /** Default socket port  <code>3000</code>, matches Wireshark DIS capture default
     * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> */
    public static int DEFAULT_DIS_PORT = DisThreadedNetworkInterface.DEFAULT_DIS_PORT;

    private enum mystate
    {
      RUNNING,
      PAUSED;
    }
    private String  disAddress; 
    private int     disPort;

    /**
     * Object constructor using default multicast address and port
     */
    public PduListenerSaver()
    {
        this(DEFAULT_DIS_ADDRESS, DEFAULT_DIS_PORT);
    }

    /**
     * Object constructor using specified multicast address and port 
     * @param address the multicast group or unicast address to utilize
     * @param port the multicast port to utilize
     */
    public PduListenerSaver(String address, int port)
    {
        disAddress = address;
        disPort    = port;
    }

    /**
     * Command-line invocation (CLI), execution starts here
    * @param args command-line arguments
    */
  public static void main(String[] args)
  {
        String  outputDirectory = DEFAULT_OUTPUT_DIRECTORY;
        String multicastAddress = DEFAULT_DIS_ADDRESS;
        int                port = DEFAULT_DIS_PORT;

        System.out.println("edu.nps.moves.dis.examples.PduListenerSaver started...");

        switch (args.length)
        {
      case 0:
        // use default values
        break;
      case 1:
                outputDirectory = args[0];
        break;
      case 3:
                 outputDirectory = args[0];
                multicastAddress = args[1];
                            port = Integer.parseInt(args[2]);
        break;
      default:
                // Common-sense practice is to print help message if invocation is problematic
                System.err.println("Usage: PduListenerSaver() or PduListenerSaver(\"outputdir\") or PduListenerSaver(\"outputDirectory\",\"multicastAddress\", port");
        System.exit(1);
    }
    System.out.println("Beginning PduListenerSaver (" + multicastAddress + ":" + port + ") to directory " + outputDirectory);

    mystate state = mystate.RUNNING;
    Scanner terminalKeyboardScanner  = new Scanner(System.in);
    PduRecorder pduRecorder = new PduRecorder(outputDirectory, multicastAddress, port); // assumes save
    pduRecorder.setDescriptor("PduListenerSaver");
    pduRecorder.start(); // begin running
    
    while (true) // monitor user input via keyboard
    {
        System.out.println("Type p/enter to pause, r/enter to resume, q/enter to quit");
            String line = terminalKeyboardScanner.nextLine();
        if (line.equalsIgnoreCase("p") && state == mystate.RUNNING) 
        {
            pduRecorder.pause();
            state = mystate.PAUSED;
            System.out.println("... state is now PAUSED");
        }
        else if (line.equalsIgnoreCase("p")) 
        {
            pduRecorder.pause();
            state = mystate.PAUSED;
            System.out.println("... state is still PAUSED");
        }
        else if (line.equalsIgnoreCase("r") && state == mystate.PAUSED) 
        {
            pduRecorder.resume();
            state = mystate.RUNNING;
            System.out.println("... state is now RUNNING");
        }
        else if (line.equalsIgnoreCase("r")) 
        {
            pduRecorder.resume();
            state = mystate.RUNNING;
            System.out.println("... state is still RUNNING");
        }
        else if (line.equalsIgnoreCase("q")) 
        {
            pduRecorder.stop();
            System.out.println("... QUIT");
            break;
        }
    }
        System.out.println("Finished PduListenerSaver pdu recording, saved to file:");
        System.out.println(pduRecorder.getLogFilePath());
  }
}
