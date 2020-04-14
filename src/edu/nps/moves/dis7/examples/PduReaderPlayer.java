/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.util.playerrecorder.Player;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * PduSaver.java created on Aug 21, 2019
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class PduReaderPlayer
{
  private final static String DEFAULT_OUTPUTDIR = "./pduLog";
  private final static String MCAST_ADDR = "239.1.2.3";
  private final static int DIS_PORT = 3000;

  private enum mystate
  {
    RUNNING,
    PAUSED;
  }

  public static void main(String[] args)
  {
    String outDir = DEFAULT_OUTPUTDIR;
    String mcast = MCAST_ADDR;
    int port = DIS_PORT;

    switch (args.length) {
      case 0:
        break;
      case 1:
        outDir = args[0];
        break;
      case 3:
        outDir = args[0];
        mcast = args[1];
        port = Integer.parseInt(args[2]);
        break;
      default:
        System.err.println("Usage: PduReaderPlayer() or PduReaderPlayer(\"outputdir\") or PduReaderPlayer(\"outputdir\",\"multicast address\", ipPort");
        System.exit(1);
    }

    System.out.println("Beginning pdu playback from directory " + outDir);
    try {
      Player player = new Player(mcast, port, new File(outDir).toPath());
      player.startResume();
      mystate state = mystate.RUNNING;
      Scanner scan = new Scanner(System.in);

      while (true) {
        System.out.println("Type p/enter to pause, r/enter to resume, q/enter to quit");
        String line = scan.nextLine();
        if (line.equalsIgnoreCase("p") && state == mystate.RUNNING) {
          player.stopPause();
          state = mystate.PAUSED;
        }
        else if (line.equalsIgnoreCase("r") && state == mystate.PAUSED) {
          player.startResume();
          state = mystate.RUNNING;
        }
        else if (line.equalsIgnoreCase("q")) {
          player.end();
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
