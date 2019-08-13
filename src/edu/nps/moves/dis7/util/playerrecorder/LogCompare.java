package edu.nps.moves.dis7.util.playerrecorder;

import edu.nps.moves.dis7.Pdu;
import edu.nps.moves.dis7.util.PduFactory;
import static edu.nps.moves.dis7.util.playerrecorder.Recorder.COMMENT_MARKER;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Base64;

/**
 * LogCompare.java created on Aug 5, 2019
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class LogCompare
{
  private static String[] paths = {
    "/Users/mike/NetbeansProjects/open-dis7-java/examples/pdulog/Pdusave.dislog",
    "/Users/mike/NetbeansProjects/open-dis7-java/examples/pdulog/Pdusave1.dislog"};

  public static void main(String[] args)
  {
    if (args.length > 0)
      paths[0] = args[0];
    if (args.length > 1)
      paths[1] = args[1];
    main2(paths);
  }

  // Perfect match
  // Match except for time stamp
  // Not same sequence of Pdus
  // Not same number of Pdus
  // Pdu content difference
  public static void main2(String[] args)
  {
    if (args.length < 2) {
      System.out.println("Usage: java LogCompare filepath1 filepath2");
      System.exit(1);
    }

    File file1 = new File(args[0]);
    File file2 = new File(args[1]);
    if (!file1.exists() || !file2.exists()) {
      System.out.println("One of " + args[0] + " or " + args[1] + " does not exist.");
      System.exit(1);
    }

    Base64.Decoder decdr = Base64.getDecoder();
    PduFactory factory = new PduFactory();
    int lineno = 0;
    boolean goodmatch = true;

    try {
      BufferedReader reader1 = new BufferedReader(new FileReader(file1));
      BufferedReader reader2 = new BufferedReader(new FileReader(file2));

      String line1 = reader1.readLine();
      String line2 = reader2.readLine();
      lineno++;

      while (line1 != null && line2 != null) {
        mainblock:
        {
          if (line1.equals(line2))
            break mainblock;

          if (line1.startsWith(COMMENT_MARKER) || line2.startsWith(COMMENT_MARKER))
            break mainblock;

          String[] sa1 = line1.split(",");
          String[] sa2 = line2.split(",");
          if (sa1.length != 2 || sa2.length != 2) {
            System.err.println("Error: parsing error. ASCII 2-part, comma-separated expected. Lines follow.");
            System.err.println(line1);
            System.err.println(line2);
            System.exit(1);
          }

          // Forget the time field (first string) -- not part of pdu
          if (sa1[1].equals(sa2[1]))
            break mainblock;

          byte[] ba1 = decdr.decode(sa1[1]);
          byte[] ba2 = decdr.decode(sa2[1]);

          if (ba1.length != ba2.length) {
            System.out.println("line " + lineno + ": lengths differ. Lines follow.");
            System.out.println(sa1[1]);
            System.out.println(sa2[1]);
            break mainblock;
          }

          Pdu pdu1 = factory.createPdu(ba1);
          Pdu pdu2 = factory.createPdu(ba2);
          if (pdu1.equals(pdu2))  // use generated equals method
            break mainblock;

          // Try equals ignoring header timestamp
          pdu1.setTimestamp(pdu2.getTimestamp());
          if (pdu1.equals(pdu2))
            break mainblock;

          System.out.println("Pdu inequality:");
          System.out.println("  Types: " + pdu1.getPduType() + " and " + pdu2.getPduType());
          System.out.println("");
          goodmatch = false;
        } // end mainblock

        line1 = reader1.readLine();
        line2 = reader2.readLine();
      }

      System.out.println("End of compare. There were " + (goodmatch ? "no" : "one or more ") + "errors");
      System.exit(goodmatch ? 0 : 1);
    }
    catch (Exception ex) {
      System.err.println("Exception reading pdu logs: " + ex.getClass().getSimpleName() + ": " + ex.getLocalizedMessage());
      System.exit(1);
    }
  }
}
