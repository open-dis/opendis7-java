/**
 * Copyright (c) 2008-2026, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.test;

import edu.nps.moves.dis7.utilities.stream.PduRecorder;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PduRecorder utility class.
 * Tests configuration, encoding options, and parameter access
 * without requiring network access.
 */
@DisplayName("PduRecorderTest")
public class PduRecorderTest
{
    private static boolean verbose = true;

    /** default constructor */
    public PduRecorderTest() {}

    @BeforeAll
    public static void setUpClass()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest setUpClass()");
    }

    @AfterAll
    public static void tearDownClass()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest tearDownClass()");
    }

    @Test
    public void testFullConstructor()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testFullConstructor()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        assertNotNull(recorder, "PduRecorder should not be null");
        assertEquals("239.1.2.3", recorder.getAddress(), "mismatched address");
        assertEquals(3000, recorder.getPort(), "mismatched port");
    }

    @Test
    public void testDefaultAddress()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testDefaultAddress()");

        assertEquals("239.1.2.3", PduRecorder.DEFAULT_DIS_ADDRESS, "mismatched default DIS address");
    }

    @Test
    public void testDefaultPort()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testDefaultPort()");

        assertEquals(3000, PduRecorder.DEFAULT_DIS_PORT, "mismatched default DIS port");
    }

    @Test
    public void testSetAddress()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testSetAddress()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setAddress("239.1.2.4");
        assertEquals("239.1.2.4", recorder.getAddress(), "mismatched address after set");
    }

    @Test
    public void testSetPort()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testSetPort()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setPort(4000);
        assertEquals(4000, recorder.getPort(), "mismatched port after set");
    }

    @Test
    public void testSetDescriptor()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testSetDescriptor()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setDescriptor("test recorder");
        assertEquals("test recorder", recorder.getDescriptor(), "mismatched descriptor after set");
    }

    @Test
    public void testDefaultEncoding()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testDefaultEncoding()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        assertEquals(PduRecorder.ENCODING_PLAINTEXT, recorder.getEncodingPduLog(), "mismatched default encoding");
    }

    @Test
    public void testSetEncodingBase64()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testSetEncodingBase64()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setEncodingPduLog(PduRecorder.ENCODING_BASE64);
        assertEquals(PduRecorder.ENCODING_BASE64, recorder.getEncodingPduLog(), "mismatched encoding after set to BASE64");
    }

    @Test
    public void testSetEncodingBinary()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testSetEncodingBinary()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setEncodingPduLog(PduRecorder.ENCODING_BINARY);
        assertEquals(PduRecorder.ENCODING_BINARY, recorder.getEncodingPduLog(), "mismatched encoding after set to BINARY");
    }

    @Test
    public void testUnsupportedEncodingIgnored()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testUnsupportedEncodingIgnored()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        String originalEncoding = recorder.getEncodingPduLog();
        recorder.setEncodingPduLog(PduRecorder.ENCODING_XML); // TODO encoding, not yet supported
        assertEquals(originalEncoding, recorder.getEncodingPduLog(), "encoding should be unchanged for unsupported type");
    }

    @Test
    public void testSetLogFileName()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testSetLogFileName()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setLogFileName("custom_log.dislog");
        assertEquals("custom_log.dislog", recorder.getLogFileName(), "mismatched log file name after set");
    }

    @Test
    public void testDefaultLogFileName()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testDefaultLogFileName()");

        assertEquals("PduCaptureLog.dislog", PduRecorder.DEFAULT_FILE_NAME, "mismatched default file name");
    }

    @Test
    public void testSetOutputDirectory()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testSetOutputDirectory()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setOutputDirectory("./customDir");
        assertEquals("./customDir", recorder.getOutputDirectory(), "mismatched output directory after set");
        assertNotNull(recorder.getOutputDirectoryPath(), "output directory path should not be null");
    }

    @Test
    public void testVerboseSettings()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testVerboseSettings()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setVerbose(false);
        assertFalse(recorder.hasVerboseOutput(), "verbose should be false after set");
        assertFalse(recorder.hasVerboseReceipt(), "verboseReceipt should be false after setVerbose(false)");
        assertFalse(recorder.hasVerboseSending(), "verboseSending should be false after setVerbose(false)");

        recorder.setVerbose(true);
        assertTrue(recorder.hasVerboseOutput(), "verbose should be true after set");
    }

    @Test
    public void testVerboseReceiptSetting()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testVerboseReceiptSetting()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setVerboseReceipt(false);
        assertFalse(recorder.hasVerboseReceipt(), "verboseReceipt should be false after set");

        recorder.setVerboseReceipt(true);
        assertTrue(recorder.hasVerboseReceipt(), "verboseReceipt should be true after set");
    }

    @Test
    public void testVerboseSendingSetting()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testVerboseSendingSetting()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setVerboseSending(false);
        assertFalse(recorder.hasVerboseSending(), "verboseSending should be false after set");

        recorder.setVerboseSending(true);
        assertTrue(recorder.hasVerboseSending(), "verboseSending should be true after set");
    }

    @Test
    public void testVerboseTimestampSetting()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testVerboseTimestampSetting()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        recorder.setVerboseIncludesTimestamp(true);
        assertTrue(recorder.hasVerboseOutputIncludesTimestamp(), "verboseIncludesTimestamp should be true after set");

        recorder.setVerboseIncludesTimestamp(false);
        assertFalse(recorder.hasVerboseOutputIncludesTimestamp(), "verboseIncludesTimestamp should be false after set");
    }

    @Test
    public void testReadableTimeStampSetting()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testReadableTimeStampSetting()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        assertTrue(recorder.includesReadableTimeStamp(), "readableTimeStamp should default to true");

        recorder.setReadableTimeStamp(false);
        assertFalse(recorder.includesReadableTimeStamp(), "readableTimeStamp should be false after set");
    }

    @Test
    public void testZeroBasedTimeStampSetting()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testZeroBasedTimeStampSetting()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        assertTrue(recorder.isZeroBasedTimeStamp(), "zeroBasedTimeStamp should default to true");

        recorder.setZeroBasedTimeStamp(false);
        assertFalse(recorder.isZeroBasedTimeStamp(), "zeroBasedTimeStamp should be false after set");
    }

    @Test
    public void testIncludeHeadersSetting()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testIncludeHeadersSetting()");

        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        // default with plaintext encoding should include headers
        assertTrue(recorder.isIncludeHeaders(), "includeHeaders should default to true for plaintext encoding");

        recorder.setIncludeHeaders(false);
        assertFalse(recorder.isIncludeHeaders(), "includeHeaders should be false after set");
    }

    @Test
    public void testEncodingConstants()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testEncodingConstants()");

        assertEquals("ENCODING_PLAINTEXT", PduRecorder.ENCODING_PLAINTEXT, "mismatched ENCODING_PLAINTEXT");
        assertEquals("ENCODING_BASE64", PduRecorder.ENCODING_BASE64, "mismatched ENCODING_BASE64");
        assertEquals("ENCODING_BINARY", PduRecorder.ENCODING_BINARY, "mismatched ENCODING_BINARY");
        assertEquals("ENCODING_XML", PduRecorder.ENCODING_XML, "mismatched ENCODING_XML");
        assertEquals("ENCODING_EXI", PduRecorder.ENCODING_EXI, "mismatched ENCODING_EXI");
        assertEquals("ENCODING_CDIS", PduRecorder.ENCODING_CDIS, "mismatched ENCODING_CDIS");
        assertEquals("ENCODING_JSON", PduRecorder.ENCODING_JSON, "mismatched ENCODING_JSON");
    }

    @Test
    public void testEncodingOptionsList()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testEncodingOptionsList()");

        // trigger initialization by creating a recorder
        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        assertNotNull(PduRecorder.ENCODING_OPTIONS_LIST, "ENCODING_OPTIONS_LIST should not be null");
        assertTrue(PduRecorder.ENCODING_OPTIONS_LIST.contains(PduRecorder.ENCODING_PLAINTEXT), "list should contain PLAINTEXT");
        assertTrue(PduRecorder.ENCODING_OPTIONS_LIST.contains(PduRecorder.ENCODING_BASE64), "list should contain BASE64");
        assertTrue(PduRecorder.ENCODING_OPTIONS_LIST.contains(PduRecorder.ENCODING_BINARY), "list should contain BINARY");
    }

    @Test
    public void testCommentMarker()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testCommentMarker()");

        assertEquals("#", PduRecorder.COMMENT_MARKER, "mismatched comment marker");
    }

    @Test
    public void testProgressiveSetters()
    {
        if (verbose)
            System.out.println("*** PduRecorderTest testProgressiveSetters()");

        // test fluent/progressive setter chaining
        PduRecorder recorder = new PduRecorder("./testOutput", "239.1.2.3", 3000);
        PduRecorder result = recorder
            .setAddress("239.1.2.5")
            .setPort(5000)
            .setDescriptor("chained")
            .setLogFileName("chained.dislog")
            .setVerbose(false);

        assertNotNull(result, "progressive setter chain should return non-null");
        assertEquals("239.1.2.5", result.getAddress(), "mismatched address after chained set");
        assertEquals(5000, result.getPort(), "mismatched port after chained set");
        assertEquals("chained", result.getDescriptor(), "mismatched descriptor after chained set");
        assertEquals("chained.dislog", result.getLogFileName(), "mismatched log file name after chained set");
    }

    /** Command-line invocation (CLI) of program, execution starts here
     * @param args command-line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("PduRecorderTest start");
        PduRecorderTest test = new PduRecorderTest();
        setUpClass();
        test.testFullConstructor();
        test.testDefaultAddress();
        test.testDefaultPort();
        test.testSetAddress();
        test.testSetPort();
        test.testSetDescriptor();
        test.testDefaultEncoding();
        test.testSetEncodingBase64();
        test.testSetEncodingBinary();
        test.testUnsupportedEncodingIgnored();
        test.testSetLogFileName();
        test.testDefaultLogFileName();
        test.testSetOutputDirectory();
        test.testVerboseSettings();
        test.testVerboseReceiptSetting();
        test.testVerboseSendingSetting();
        test.testVerboseTimestampSetting();
        test.testReadableTimeStampSetting();
        test.testZeroBasedTimeStampSetting();
        test.testIncludeHeadersSetting();
        test.testEncodingConstants();
        test.testEncodingOptionsList();
        test.testCommentMarker();
        test.testProgressiveSetters();
        tearDownClass();
        System.out.println("PduRecorderTest complete");
    }
}
