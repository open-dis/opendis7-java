/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
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
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class PduReaderPlayer
{
  private final static String DEFAULT_OUTPUTDIR = "./pduLog";

  private enum mystate
  {
    RUNNING,
    PAUSED;
  }

  public static void main(String[] args)
  {
    String outDir = DEFAULT_OUTPUTDIR;
    String mcast = DisThreadedNetworkInterface.DEFAULT_MULTICAST_ADDRESS;
    int port = DisThreadedNetworkInterface.DEFAULT_DIS_PORT;
    boolean sendToNet = false;

    switch (args.length) {
      case 0:
        break;
      case 1:
        outDir = args[0];
        sendToNet = Boolean.valueOf(args[1]);
        break;
      case 3:
        outDir = args[0];
        mcast = args[1];
        port = Integer.parseInt(args[2]);
        sendToNet = Boolean.valueOf(args[3]);
        break;
      default:
        System.err.println("Usage: PduReaderPlayer() or "
                + "PduReaderPlayer(\"outputdir\", \"sendToNet true/false\") or "
                + "PduReaderPlayer(\"outputdir\", \"multicast address\", \"ipPort\", \"sendToNet true/false\"");
        System.exit(1);
    }

    System.out.println("Beginning pdu playback from directory " + outDir);
    try {
      PduPlayer pduPlayer = new PduPlayer(mcast, port, Path.of(outDir), sendToNet);
      mystate state = mystate.RUNNING;
      Scanner scan = new Scanner(System.in);

      while (true) {
        System.out.println("Type p/enter to pause, r/enter to resume, q/enter to quit");
        String line = scan.nextLine();
        if (line.equalsIgnoreCase("p") && state == mystate.RUNNING) {
          pduPlayer.stopPause();
          state = mystate.PAUSED;
        }
        else if (line.equalsIgnoreCase("r") && state == mystate.PAUSED) {
          pduPlayer.startResume();
          state = mystate.RUNNING;
        }
        else if (line.equalsIgnoreCase("q")) {
          pduPlayer.end();
          break;
        }
      }
      System.out.println("Ending pdu playback from "+outDir);
    }
    catch (IOException ex) {
      System.err.println("Exception: " + ex.getClass().getSimpleName() + ": " + ex.getLocalizedMessage());
    }
  }
}
