/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>DIS time units are a pain to work with. DIS time units are arbitrary, and set
 * equal to 2^31 - 1 time units per hour. The DIS time is set to the number of time
 * units since the start of the hour. The timestamp field in the PDU header is
 * four bytes long and is specified to be an unsigned integer value.</p>
 *
 * <p>There are two types of official timestamps in the PDU header: absolute time and
 * relative time. Absolute time is used when the host is synchronized to UTC, i.e. the host
 * has access to UTC via Network Time Protocol (NTP). This time can be legitimately
 * compared to the timestamp of packets received from other hosts, since they all
 * refer to the same universal time.</p>
 *
 * <p>Relative timestamps are used when the host does NOT have access to NTP, and hence
 * the system time might not be coordinated with that of other hosts. This means that
 * a host receiving DIS packets from several hosts might have to set up a per-host
 * table to order packets, and that the PDU timestamp fields from one host is not
 * directly comparable to the PDU timestamp field from another host.</p>
 *
 * <p>Absolute timestamps have their LSB set to 1, and relative timestamps have their
 * LSB set to 0. The idea is to get the current time since the top of the hour,
 * divide by 2^31-1, shift left one bit, then set the LSB to either 0 for relative
 * timestamps or 1 for absolute timestamps.</p>
 *
 * <p>The nature of the data is such that the timestamp fields will roll over once an
 * hour, and simulations must be prepared for that. Ie, at the top of the hour
 * outgoing PDUs will have a timestamp of 1, just before the end of the hour the
 * PDUs will have a timestamp of 2^31 - 1, and then they will roll back over to 1.
 * Receiving applications should expect this behavior, and not simply expect a
 * monotonically increasing timestamp field.</p>
 *
 * <p>The official DIS timestamps don't work all that well in our (NPS's) applications,
 * which often expect a monotonically increasing timestamp field. To get around this,
 * we use hundreds of a second since the start of the year. The maximum value for
 * this field is 3,153,600,000, which can fit into an unsigned int. The resolution is
 * good enough for most applications, and you typically don't have to worry about
 * rollover, instead getting only a monotonically increasing timestamp value.</p>
 *
 * <p>Note that many applications in the wild have been known to completely ignore
 * the standard and to simply put the Unix time (seconds since 1970) into the
 * field. </p>
 *
 * <p>You need to be careful with the shared instance of this class--I'm not at all
 * convinced it is thread safe. If you are using multiple threads, I suggest you
 * create a new instance of the class for each thread to prevent the values from
 * getting stomped on.</p>
 * 
 * Shared singleton removed.  Mike Bailey, 14 June 2019
 * 
 * @author DMcG
 */
public class DisTime
{
    /** mask for absolute timestamps */
    public static final int ABSOLUTE_TIMESTAMP_MASK = 0x00000001;
    /** mask for relative timestamps */
    public static final int RELATIVE_TIMESTAMP_MASK = 0xfffffffe;
    /** calendar instance */
    protected GregorianCalendar calendar;

   // public static DisTime disTime = null;

    /**
     * Shared instance. This is not thread-safe. If you are working in multiple threads,
     * create a new instance for each thread.
     * return singleton instance of DisTime
     */
   /* public static DisTime getInstance()
    {
        if (disTime == null) {
            disTime = new DisTime();
        }

        return disTime;
    }
*/
    public DisTime()
    {
        calendar = new GregorianCalendar();
    }

    /**
     * Returns the number of DIS time units since the top of the hour. there are 2^31-1 DIS time
     * units per hour.
     * @return integer DIS time units since the start of the hour.
     */
    private int getDisTimeUnitsSinceTopOfHour() {
        // set calendar object to current time
        long currentTime = System.currentTimeMillis(); // UTC milliseconds since 1970
        calendar.setTimeInMillis(currentTime);

        // Set calendar to top of the hour, then compute what the calendar object says was milliseconds since 1970
        // at the top of the hour
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long topOfHour = calendar.getTimeInMillis();

        // Milliseconds since the top of the hour
        long diff = currentTime - topOfHour;

        // It turns out that Integer.MAX_VALUE is 2^31-1, which is the time unit value, ie there are
        // 2^31-1 DIS time units in an hour. 3600 sec/hr X 1000 msec/sec divided into the number of
        // msec since the start of the hour gives the percentage of DIS time units in the hour, times
        // the number of DIS time units per hour, equals the time value
        double val = (diff / (3600.0 * 1000.0)) * Integer.MAX_VALUE;
        int ts = (int) val;

        return ts;
    }

    /**
     * Returns the absolute timestamp, assuming that this host is sync'd to NTP.
     * Fix to bitshift by mvormelch.
     * @return DIS time units, get absolute timestamp
     */

    public int getDisAbsoluteTimestamp() {
         int val = this.getDisTimeUnitsSinceTopOfHour();
         val = (val << 1) | ABSOLUTE_TIMESTAMP_MASK; // always flip the lsb to 1
         return val;
    }

    /**
     * Returns the DIS standard relative timestamp, which should be used if this host
     * is not slaved to NTP. Fix to bitshift by mvormelch
     * @return DIS time units, relative
     */
    public int getDisRelativeTimestamp() {
        int val = this.getDisTimeUnitsSinceTopOfHour();
        val = (val << 1) & RELATIVE_TIMESTAMP_MASK; // always flip the lsb to 0
        return val;
    }

    /**
     * Returns a useful timestamp, hundredths of a second since the start of the year.
     * This effectively eliminates the need for receivers to handle timestamp rollover,
     * as long as you're not working on New Year's Eve.
     * @return a timestamp in hundredths of a second since the start of the year
     */
    public long getNpsTimestamp() {
        // set calendar object to current time
        long currentTime = System.currentTimeMillis(); // UTC milliseconds since 1970
        calendar.setTimeInMillis(currentTime);

        // Set calendar to the start of the year
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long startOfYear = calendar.getTimeInMillis();

        // Milliseconds since the top of the hour
        long diff = currentTime - startOfYear;
        diff /= 10; // milliseconds to hundredths of a second

        return diff;
    }

    /**
     * Another option for marshalling with the timestamp field set automatically. The UNIX
     * time is conventionally seconds since January 1, 1970. UTC time is used, and leap seconds
     * are excluded. This approach is popular in the wild, but the time resolution is not very
     * good for high frequency updates, such as aircraft. An entity updating at 30 PDUs/second
     * would see 30 PDUs sent out with the same timestamp, and have 29 of them discarded as
     * duplicate packets.
     *
     * Note that there are other "Unix times", such milliseconds since 1/1/1970, saved in a long.
     * This cannot be used, since the value is saved in a long. Java's System.getCurrentTimeMillis()
     * uses this value.
     *
     * Unix time (in seconds) rolls over in 2038. 
     *
     * Consult <a href="https://en.wikipedia.org/wiki/Unix_time">The Wikipedia page on Unix time for the gory details</a>
     * @return seconds since 1970
     */
    public long getUnixTimestamp() {
        long t = System.currentTimeMillis();
        t /= 1000l;   // NB: integer division, convert milliseconds to seconds
        return t;
    }
    /**
     * Convert timestamp value to string for logging and diagnostics
     * @param timeStamp value in milliseconds
     * @see GregorianCalendar
     * @return string value provided by GregorianCalendar
     */
    public static String timeStampToString(int timeStamp)
    {
        GregorianCalendar newCalendar = new GregorianCalendar();
        newCalendar.setTimeInMillis(timeStamp);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(newCalendar.getTime());
    }
}