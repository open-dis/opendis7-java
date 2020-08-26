/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.utilities.DisThreadedNetIF;
import edu.nps.moves.dis7.utilities.stream.PduRecorder;
import java.io.IOException;
import java.util.Scanner;

/** Class to leverage the {@link edu.nps.moves.dis7.utilities.stream.PduRecorder} 
 * with PDU log saving console controls for resume, pause and quit.
 * 
 * PduSaver.java created on Aug 21, 2019
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class PduListenerSaver
{
  private final static String DEFAULT_OUTPUT_DIRECTORY = "./pduLog";

  private enum mystate
  {
    RUNNING,
    PAUSED;
  }

  public static void main(String[] args)
  {
    String outputDirectoryPath = DEFAULT_OUTPUT_DIRECTORY;
    String multicastAddress    = DisThreadedNetIF.DEFAULT_MULTICAST_ADDRESS;
    int    port                = DisThreadedNetIF.DEFAULT_DIS_PORT;

    switch (args.length) {
      case 0:
        // use default values
        break;
      case 1:
        outputDirectoryPath = args[0];
        break;
      case 3:
        outputDirectoryPath   = args[0];
        multicastAddress      = args[1];
        port = Integer.parseInt(args[2]);
        break;
      default:
        System.err.println("Usage: PduListenerSaver() or PduListenerSaver(\"outputdir\") or PduListenerSaver(\"outputdir\",\"multicast address\", ipPort");
        System.exit(1);
    }

    System.out.println("Beginning pdu save to directory " + outputDirectoryPath);
    try {
      PduRecorder recorder = new PduRecorder(outputDirectoryPath, multicastAddress, port); // assumes save
      mystate state = mystate.RUNNING;
      Scanner scan  = new Scanner(System.in);

      while (true) 
      {
        System.out.println("Type p/enter to pause, r/enter to resume, q/enter to quit");
        String line = scan.nextLine();
        if (line.equalsIgnoreCase("p") && state == mystate.RUNNING) 
        {
          recorder.stopPause();
          state = mystate.PAUSED;
          System.out.println("... state is now PAUSED");
        }
        else if (line.equalsIgnoreCase("p")) 
        {
          recorder.stopPause();
          state = mystate.PAUSED;
          System.out.println("... state is still PAUSED");
        }
        else if (line.equalsIgnoreCase("r") && state == mystate.PAUSED) 
        {
          recorder.startResume();
          state = mystate.RUNNING;
          System.out.println("... state is now RUNNING");
        }
        else if (line.equalsIgnoreCase("r")) 
        {
          recorder.startResume();
          state = mystate.RUNNING;
          System.out.println("... state is still RUNNING");
        }
        else if (line.equalsIgnoreCase("q")) 
        {
          recorder.end();
          System.out.println("... QUIT");
          break;
        }
      }
      System.out.println("Ending pdu save to log file " + recorder.getLogFilePath());
    }
    catch (IOException ex)
    {
      System.err.println("Exception: " + ex.getClass().getSimpleName() + ": " + ex.getLocalizedMessage());
    }
  }
}
