/**
 * Copyright (c) 2008-2022, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.stream.PduPlayer;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/** Class to leverage the {@link edu.nps.moves.dis7.utilities.stream.PduPlayer} 
 * with PDU log playback console controls for resume, pause and quit.
 * 
 * PduSaver.java created on Aug 21, 2019
 * Renamed PduReaderPlayer
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class PduReaderPlayer
{
  private final static String DEFAULT_OUTPUT_DIRECTORY = "./pduLog";
/** Default multicast group address we send on.
  * @see <a href="https://en.wikipedia.org/wiki/Multicast_address">https://en.wikipedia.org/wiki/Multicast_address</a> */
  public static final String  DEFAULT_MULTICAST_ADDRESS = DisThreadedNetworkInterface.DEFAULT_DIS_ADDRESS;
  /** Default multicast port we send on.
  * @see <a href="https://en.wikipedia.org/wiki/Port_(computer_networking)">https://en.wikipedia.org/wiki/Port_(computer_networking)</a> */
  public static final int     DEFAULT_MULTICAST_PORT    = DisThreadedNetworkInterface.DEFAULT_DIS_PORT;

  private enum mystate
  {
    RUNNING,
    PAUSED;
  }
  
  /** default constructor */
  public PduReaderPlayer ()
  {
      // initialization code here
  }

  /** Command-line invocation (CLI) of program, execution starts here
    * @param args command-line arguments
    */
  public static void main(String[] args)
  {
    String  outputDirectory = DEFAULT_OUTPUT_DIRECTORY;
    String multicastAddress = DEFAULT_MULTICAST_ADDRESS;
    int       multicastPort = DEFAULT_MULTICAST_PORT;
    boolean       sendToNet = true;

    System.out.println("edu.nps.moves.dis7.examples.PduReaderPlayer started...");

    switch (args.length) {
      case 0:
        break;
      case 1:
        outputDirectory = args[0];
        sendToNet = Boolean.valueOf(args[1]);
        break;
      case 3:
        outputDirectory = args[0];
        multicastAddress = args[1];
        multicastPort = Integer.parseInt(args[2]);
        sendToNet = Boolean.valueOf(args[3]);
        break;
      default:
        System.err.println("Usage: PduReaderPlayer() or \n"
                + "PduReaderPlayer(\"outputdir\", \"sendToNet true/false\") or \n"
                + "PduReaderPlayer(\"outputdir\", \"ipPort\", \"sendToNet true/false\") or \n"
                + "PduReaderPlayer(\"outputdir\", \"multicast address\", \"ipPort\", \"sendToNet true/false\"");
        System.exit(1);
    }

    System.out.println("Beginning PduReaderPlayer (" + multicastAddress + ":" + multicastPort + ") to directory " + outputDirectory);
    try 
    {
      mystate state = mystate.RUNNING;
      Scanner terminalKeyboardScanner = new Scanner(System.in);
      PduPlayer pduPlayer = new PduPlayer(multicastAddress, multicastPort, Path.of(outputDirectory), sendToNet);
      pduPlayer.startResume();

      while (true) // monitor user input via keyboard
      {
        System.out.println("Type p/enter to pause, r/enter to resume, q/enter to quit");
        String line = terminalKeyboardScanner.nextLine();
        if (line.equalsIgnoreCase("p") && state == mystate.RUNNING) {
          pduPlayer.stopPause();
          state = mystate.PAUSED;
        }
        else if (line.equalsIgnoreCase("r") && state == mystate.PAUSED) {
          pduPlayer.startResume();
          state = mystate.RUNNING;
        }
        else if (line.equalsIgnoreCase("q")) {
          System.out.println("... QUIT");
          pduPlayer.end();
          break;
        }
      }
      System.out.println("Ending pdu files playback for directory " + outputDirectory);
      System.out.println("edu.nps.moves.dis7.examples.PduReaderPlayer complete.");
      System.exit(0); // TODO not sure why this is necessary with Netbeans...
    }
    catch (IOException ex) {
      System.err.println("Exception: " + ex.getClass().getSimpleName() + ": " + ex.getLocalizedMessage());
    }
  }
}
