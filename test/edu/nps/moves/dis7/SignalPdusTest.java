/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nps.moves.dis7;

import edu.nps.moves.dis7.enumerations.*;
import edu.nps.moves.dis7.util.DisNetworking;
import edu.nps.moves.dis7.util.PduFactory;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Signal Pdus Test")
public class SignalPdusTest
{
  @BeforeAll
  public static void setUpClass()
  {
  }

  @AfterAll
  public static void tearDownClass()
  {
  }

  @BeforeEach
  public void setUp()
  {
  }

  @AfterEach
  public void tearDown()
  {
  }

  private Pdu receivedPdu;

  @Test
  public void testRoundTrip()
  {
    PduFactory factory = new PduFactory();
    SignalPdu sigPdu = factory.makeSignalPdu();  // empty contents

    SignalPdu sigPdu2 = factory.makeSignalPdu();
    sigPdu2.setEncodingScheme((short) 0x1111);
    sigPdu2.setSampleRate(0x22222222);
    sigPdu2.setSamples((short) 0x3333);
    sigPdu2.setData(new String("SignalPdu-testdata").getBytes());

    IntercomSignalPdu isig = factory.makeIntercomSignalPdu();
    IntercomSignalPdu isig2 = factory.makeIntercomSignalPdu();
    isig2.setEncodingScheme((short) 0x1111);
    isig2.setSampleRate(0x22222222);
    isig2.setSamples((short) 0x3333);
    isig2.setData(new String("IntercomSignalPdu-testdata").getBytes());
    
    setUpReceiver();

    try {
      Thread.sleep(250l); // make sure receiver is listening
      DisNetworking disnet = new DisNetworking();
      disnet.sendPdu(sigPdu);
      disnet.sendPdu(sigPdu2);
      disnet.sendPdu(isig);
      disnet.sendPdu(isig2);
      
      Thread.sleep(1000l); //(180*1000l));//waiter.wait();
    }
    catch (Exception ex) {
      System.err.println("Error sending Multicast: " + ex.getLocalizedMessage());
      System.exit(1);
    }

    // Compare
    // If we made it this far, we've sent and received.  Now compare.
    if (receivedPdu.equals(sigPdu))
      System.out.println("passed test");
    else
      System.err.println("failed test");
  }

  private void setUpReceiver()
  {
    Thread rcvThread = new Thread(() -> {
      try {
        receivedPdu = new DisNetworking().receivePdu();  // blocks
      }
      catch (IOException ex) {
        System.err.println("Error receiving Multicast: " + ex.getLocalizedMessage());
        System.exit(1);
      }
      //   waiter.notify();
    });

    rcvThread.setPriority(Thread.NORM_PRIORITY);
    rcvThread.setDaemon(true);
    rcvThread.start();
  }

  public static void main(String[] args)
  {
    new SignalPdusTest().testRoundTrip();
  }

}
