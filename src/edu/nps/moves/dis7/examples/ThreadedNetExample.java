/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.DisTime;
import edu.nps.moves.dis7.utilities.PduFactory;

/**
 * Shows how to use DisThreadedNetworkInterface from an application class.
 * ThreadedNetExample.java created on Sep 9, 2019
 * MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 * 
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class ThreadedNetExample
{
  /** Command-line invocation (CLI)
    * @param args command-line arguments
    */
  public static void main(String[] args)
  {
    // Create an instance of DisThreadedNetworkInterface using default port 3000, mcast 225.4.5.6, use other constructor to specific port and ip
    DisThreadedNetworkInterface netif = new DisThreadedNetworkInterface();
    
    // Internally, the DisThreadedNetworkInterface class has constructed whatever threads it needs to operated
    
    // We want to listen also, so add a listener, using JDK8+ lambda grammar
    netif.addListener(pdu->handleReceivedPdu(pdu));
    
    // Use PduFactory to make pdus, default country = Deutschland, exercise, site, app, absolute timestamps
    
    PduFactory factory = new PduFactory(Country.GERMANY_DEU, (byte) 1, (short) 2, (short) 3, DisTime.TimestampStyle.IEEE_ABSOLUTE);
    
    // Make and sendPDU 3 pdus with no delay between, testing threaded receiver performance
    netif.sendPDU(factory.makeEntityStatePdu());
    System.out.println("Sent EntityStatePdu");
    netif.sendPDU(factory.makeFirePdu());
    System.out.println("Sent FirePdu");
    netif.sendPDU(factory.makeCollisionPdu());
    System.out.println("Sent CollisionPdu");
    
    // Wait a bit to see output.
    // Almost any sender will overwhelm a receiver if not constrained. This
    // slows down the sendPDU rate so the receiver has enough time to process it.
    try { 
        Thread.sleep(250L);
    } catch(InterruptedException ex) {}
    
    System.out.println("End of example");
  }
  
  private static void handleReceivedPdu(Pdu pdu)
  {
    // Do something here with the pdu you received
    System.out.println("Received "+pdu.getClass().getSimpleName());
  }
}
