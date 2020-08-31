/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.examples;

import edu.nps.moves.dis7.pdus.Pdu;
import edu.nps.moves.dis7.enumerations.Country;
import edu.nps.moves.dis7.utilities.DisThreadedNetworkInterface;
import edu.nps.moves.dis7.utilities.PduFactory;

/**
 * ThreadedNetExample.java created on Sep 9, 2019
 MOVES Institute Naval Postgraduate School, Monterey, CA, USA www.nps.edu
 
 Shows how to use DisThreadedNetworkInterface from an application class
 * 
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class ThreadedNetExample
{
  public static void main(String[] args)
  {
    // Create an instance of DisThreadedNetworkInterface using default port 3000, mcast 225.4.5.6, use other constructor to specific port and ip
    DisThreadedNetworkInterface netif = new DisThreadedNetworkInterface();
    
    // Internally, the DisThreadeNetIF class has constructed whatever threads it needs to operated
    
    // We want to listen also, so add a listener, using JDK8+ lambda grammar
    netif.addListener(pdu->handleReceivedPdu(pdu));
    
    // Use PduFactory to make pdus, default country = Deutschland, exercise, site, app, absolute timestamps
    
    PduFactory factory = new PduFactory(Country.GERMANY_DEU, (byte) 1, (short) 2, (short) 3, true);
    
    // Make and send 3 pdus with no delay between, testing threaded receiver performance
    netif.send(factory.makeEntityStatePdu());
    System.out.println("Sent EntityStatePdu");
    netif.send(factory.makeFirePdu());
    System.out.println("Sent FirePdu");
    netif.send(factory.makeCollisionPdu());
    System.out.println("Sent CollisionPdu");
    
    // Wait a bit to see output
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
