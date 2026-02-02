/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.utilities.DisChannel;
import edu.nps.moves.dis7.utilities.DisTime.TimestampStyle;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for DisChannel utility class.
 * Tests configuration and parameter access without requiring network.
 */
@DisplayName("DisChannelTest")
public class DisChannelTest
{
    private static boolean verbose = true;

    /** default constructor */
    public DisChannelTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** DisChannelTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** DisChannelTest tearDownClass()");
    }

    @Test
    public void testDefaultConstructor()
    {
        if (verbose)
            System.out.println("*** DisChannelTest testDefaultConstructor()");

        DisChannel channel = new DisChannel();
        assertNotNull(channel, "channel should not be null");
    }

    @Test
    public void testDescriptorConstructor()
    {
        if (verbose)
            System.out.println("*** DisChannelTest testDescriptorConstructor()");

        DisChannel channel = new DisChannel("test channel");
        assertEquals("test channel", channel.getDescriptor(), "mismatched descriptor");
    }

    @Test
    public void testDefaultNetworkAddress()
    {
        if (verbose)
            System.out.println("*** DisChannelTest testDefaultNetworkAddress()");

        DisChannel channel = new DisChannel();
        assertEquals("239.1.2.3", channel.getNetworkAddress(), "mismatched default network address");
    }

    @Test
    public void testDefaultNetworkPort()
    {
        if (verbose)
            System.out.println("*** DisChannelTest testDefaultNetworkPort()");

        DisChannel channel = new DisChannel();
        assertEquals(3000, channel.getNetworkPort(), "mismatched default network port");
    }

    @Test
    public void testSetNetworkAddress()
    {
        if (verbose)
            System.out.println("*** DisChannelTest testSetNetworkAddress()");

        DisChannel channel = new DisChannel();
        channel.setNetworkAddress("239.1.2.4");
        assertEquals("239.1.2.4", channel.getNetworkAddress(), "mismatched network address after set");
    }

    @Test
    public void testSetNetworkPort()
    {
        if (verbose)
            System.out.println("*** DisChannelTest testSetNetworkPort()");

        DisChannel channel = new DisChannel();
        channel.setNetworkPort(4000);
        assertEquals(4000, channel.getNetworkPort(), "mismatched network port after set");
    }

    @Test
    public void testSetDescriptor()
    {
        if (verbose)
            System.out.println("*** DisChannelTest testSetDescriptor()");

        DisChannel channel = new DisChannel();
        channel.setDescriptor("updated descriptor");
        assertEquals("updated descriptor", channel.getDescriptor(), "mismatched descriptor after set");
    }

    @Test
    public void testTimestampStyle()
    {
        if (verbose)
            System.out.println("*** DisChannelTest testTimestampStyle()");

        DisChannel channel = new DisChannel();
        channel.setTimestampStyle(TimestampStyle.IEEE_RELATIVE);
        assertEquals(TimestampStyle.IEEE_RELATIVE, channel.getTimestampStyle(), "mismatched timestamp style");
    }

    @Test
    public void testGetPduFactory()
    {
        if (verbose)
            System.out.println("*** DisChannelTest testGetPduFactory()");

        DisChannel channel = new DisChannel();
        assertNotNull(channel.getPduFactory(), "PduFactory should not be null");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("DisChannelTest start");
        DisChannelTest test = new DisChannelTest();
        setUpClass();
        test.testDefaultConstructor();
        test.testDescriptorConstructor();
        test.testDefaultNetworkAddress();
        test.testDefaultNetworkPort();
        test.testSetNetworkAddress();
        test.testSetNetworkPort();
        test.testSetDescriptor();
        test.testTimestampStyle();
        test.testGetPduFactory();
        tearDownClass();
        System.out.println("DisChannelTest complete");
    }
}
