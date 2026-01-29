/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.utilities.DisTime;
import edu.nps.moves.dis7.utilities.DisTime.TimestampStyle;
import edu.nps.moves.dis7.utilities.DisTime.TimeFormatterType;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for DisTime utility class.
 * Validates timestamp styles, formatters, epoch handling, and conversions.
 */
@DisplayName("DisTimeTest")
public class DisTimeTest
{
    private static boolean verbose = true;

    /** default constructor */
    public DisTimeTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** DisTimeTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** DisTimeTest tearDownClass()");
        // restore defaults
        DisTime.setTimestampStyle(TimestampStyle.IEEE_ABSOLUTE);
        DisTime.setHostClockSynchronized(true);
        DisTime.clearEpochLvc();
    }

    @Test
    public void testDefaultTimestampStyle()
    {
        if (verbose)
            System.out.println("*** DisTimeTest testDefaultTimestampStyle()");

        assertEquals(TimestampStyle.IEEE_ABSOLUTE, DisTime.TIMESTAMP_STYLE_DEFAULT, "mismatched default timestamp style");
    }

    @Test
    public void testSetGetTimestampStyle()
    {
        if (verbose)
            System.out.println("*** DisTimeTest testSetGetTimestampStyle()");

        DisTime.setTimestampStyle(TimestampStyle.IEEE_RELATIVE);
        assertEquals(TimestampStyle.IEEE_RELATIVE, DisTime.getTimestampStyle(), "mismatched timestamp style after set");

        DisTime.setTimestampStyle(TimestampStyle.UNIX);
        assertEquals(TimestampStyle.UNIX, DisTime.getTimestampStyle(), "mismatched timestamp style after set to UNIX");

        DisTime.setTimestampStyle(TimestampStyle.IEEE_ABSOLUTE);
    }

    @Test
    public void testHostClockSynchronized()
    {
        if (verbose)
            System.out.println("*** DisTimeTest testHostClockSynchronized()");

        DisTime.setHostClockSynchronized(true);
        assertTrue(DisTime.isHostClockSynchronized(), "host clock should be synchronized");

        DisTime.setHostClockSynchronized(false);
        assertFalse(DisTime.isHostClockSynchronized(), "host clock should not be synchronized");

        DisTime.setHostClockSynchronized(true);
    }

    @Test
    public void testGetCurrentDisTimestamp()
    {
        if (verbose)
            System.out.println("*** DisTimeTest testGetCurrentDisTimestamp()");

        DisTime.setTimestampStyle(TimestampStyle.IEEE_ABSOLUTE);
        int timestamp = DisTime.getCurrentDisTimestamp();
        assertTrue(timestamp != 0, "IEEE_ABSOLUTE timestamp should not be zero");
        // absolute timestamps have LSB set to 1
        assertEquals(1, timestamp & DisTime.ABSOLUTE_TIMESTAMP_MASK, "absolute timestamp LSB should be 1");

        DisTime.setTimestampStyle(TimestampStyle.IEEE_RELATIVE);
        int relTimestamp = DisTime.getCurrentDisTimestamp();
        // relative timestamps have LSB set to 0
        assertEquals(0, relTimestamp & DisTime.ABSOLUTE_TIMESTAMP_MASK, "relative timestamp LSB should be 0");

        DisTime.setTimestampStyle(TimestampStyle.IEEE_ABSOLUTE);
    }

    @Test
    public void testTimestampMasks()
    {
        if (verbose)
            System.out.println("*** DisTimeTest testTimestampMasks()");

        assertEquals(0x00000001, DisTime.ABSOLUTE_TIMESTAMP_MASK, "mismatched absolute timestamp mask");
        assertEquals(0xfffffffe, DisTime.RELATIVE_TIMESTAMP_MASK, "mismatched relative timestamp mask");
    }

    @Test
    public void testEpochLvc()
    {
        if (verbose)
            System.out.println("*** DisTimeTest testEpochLvc()");

        DisTime.clearEpochLvc();
        assertFalse(DisTime.hasEpochLvc(), "epoch should not be active after clear");

        DisTime.setEpochLvcNow();
        assertTrue(DisTime.hasEpochLvc(), "epoch should be active after setEpochLvcNow");
        assertNotNull(DisTime.getEpochLvc(), "epoch instant should not be null");

        Instant custom = Instant.parse("2026-01-01T00:00:00Z");
        DisTime.setEpochLvc(custom);
        assertEquals(custom, DisTime.getEpochLvc(), "mismatched custom epoch");

        DisTime.clearEpochLvc();
    }

    @Test
    public void testTimeFormatters()
    {
        if (verbose)
            System.out.println("*** DisTimeTest testTimeFormatters()");

        assertNotNull(DisTime.timeFormatterSeconds, "seconds formatter should not be null");
        assertNotNull(DisTime.timeFormatterTenthSeconds, "tenth seconds formatter should not be null");
        assertNotNull(DisTime.timeFormatterHundredthSeconds, "hundredth seconds formatter should not be null");
        assertNotNull(DisTime.timeFormatterMilliSeconds, "milliseconds formatter should not be null");
        assertNotNull(DisTime.timeFormatterMicroSeconds, "microseconds formatter should not be null");
        assertNotNull(DisTime.timeFormatterNanoSeconds, "nanoseconds formatter should not be null");
    }

    @Test
    public void testSetTimeFormatter()
    {
        if (verbose)
            System.out.println("*** DisTimeTest testSetTimeFormatter()");

        DisTime.setTimeFormatter(TimeFormatterType.MILLISECONDS);
        DateTimeFormatter formatter = DisTime.getTimeFormatter();
        assertNotNull(formatter, "formatter should not be null after set");

        DisTime.setTimeFormatter(TimeFormatterType.TENTHSECONDS);
    }

    @Test
    public void testConvertToString()
    {
        if (verbose)
            System.out.println("*** DisTimeTest testConvertToString()");

        DisTime.setTimestampStyle(TimestampStyle.IEEE_ABSOLUTE);
        int timestamp = DisTime.getCurrentDisTimestamp();
        String timeString = DisTime.convertToString(timestamp);
        assertNotNull(timeString, "converted string should not be null");
        assertFalse(timeString.isEmpty(), "converted string should not be empty");

        DisTime.setTimestampStyle(TimestampStyle.IEEE_ABSOLUTE);
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("DisTimeTest start");
        DisTimeTest test = new DisTimeTest();
        setUpClass();
        test.testDefaultTimestampStyle();
        test.testSetGetTimestampStyle();
        test.testHostClockSynchronized();
        test.testGetCurrentDisTimestamp();
        test.testTimestampMasks();
        test.testEpochLvc();
        test.testTimeFormatters();
        test.testSetTimeFormatter();
        test.testConvertToString();
        tearDownClass();
        System.out.println("DisTimeTest complete");
    }
}
