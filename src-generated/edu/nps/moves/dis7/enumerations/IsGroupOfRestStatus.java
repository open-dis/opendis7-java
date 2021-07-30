package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 214 marshal size 8<br>
 * IsGroupOfRestStatus
 */
public enum IsGroupOfRestStatus 
{
    /** Not rested (Has not slept in the last three days) */
    NOT_RESTED_HAS_NOT_SLEPT_IN_THE_LAST_THREE_DAYS (0, "Not rested (Has not slept in the last three days)"),
    /** Has slept an average of 1 hour per day in the last three days. */
    HAS_SLEPT_AN_AVERAGE_OF_1_HOUR_PER_DAY_IN_THE_LAST_THREE_DAYS (1, "Has slept an average of 1 hour per day in the last three days."),
    /** Has slept an average of 2 hours per day in the last three days. */
    HAS_SLEPT_AN_AVERAGE_OF_2_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS (2, "Has slept an average of 2 hours per day in the last three days."),
    /** Has slept an average of 3 hours per day in the last three days. */
    HAS_SLEPT_AN_AVERAGE_OF_3_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS (3, "Has slept an average of 3 hours per day in the last three days."),
    /** Has slept an average of 4 hours per day in the last three days. */
    HAS_SLEPT_AN_AVERAGE_OF_4_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS (4, "Has slept an average of 4 hours per day in the last three days."),
    /** Has slept an average of 5 hours per day in the last three days. */
    HAS_SLEPT_AN_AVERAGE_OF_5_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS (5, "Has slept an average of 5 hours per day in the last three days."),
    /** Has slept an average of 6 hours per day in the last three days. */
    HAS_SLEPT_AN_AVERAGE_OF_6_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS (6, "Has slept an average of 6 hours per day in the last three days."),
    /** Has slept an average of 7 hours per day in the last three days. */
    HAS_SLEPT_AN_AVERAGE_OF_7_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS (7, "Has slept an average of 7 hours per day in the last three days."),
    /** Fully rested (Has slept an average of 8 hours per day in the last three days) */
    FULLY_RESTED_HAS_SLEPT_AN_AVERAGE_OF_8_HOURS_PER_DAY_IN_THE_LAST_THREE_DAYS (8, "Fully rested (Has slept an average of 8 hours per day in the last three days)");

    private int value;
    private final String description;

    /** Constructor */
    IsGroupOfRestStatus(int value, String description)
    {
        this.value = value;
        this.description = description;
    }
    /** Provide enumeration value
      * @return integer value */
    public int getValue()
    {
        return value;
    }

    /** Provide enumeration description
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /** bit width for this enumeration
     * @return number of bits wide
     */
    public static int getEnumBitWidth()
    {
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static IsGroupOfRestStatus getEnumForValue(int i)
    {
       for(IsGroupOfRestStatus val: IsGroupOfRestStatus.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration IsGroupOfRestStatus");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    private boolean TRACE = false;

    /** Set tracing on/off for this object 
     * @param value whether tracing is on or off */
    public void setTRACE (boolean value)
    {
        TRACE = value;
    }

    /** Whether tracing is on or off for this object
     * @return whether tracing is on or off */
    public boolean getTRACE ()
    {
        return TRACE;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static IsGroupOfRestStatus unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static IsGroupOfRestStatus unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        String padding = new String();
        if (this.getClass().getName().endsWith("DisPduType") && (getValue() < 10))
            padding = "0"; // leading zero for column spacing
        String result = "DisPduType " + padding + getValue() + " " + name();
        if (getTRACE())
            System.out.println ("*** enum " + this.getClass().getName() + " name=" + name() + ", value=" + getValue() + "; " +
               result); // debug diagnostic
        return result;
    }
}
