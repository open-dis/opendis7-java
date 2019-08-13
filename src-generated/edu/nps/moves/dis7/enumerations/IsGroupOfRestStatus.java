package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 214 marshal size 8<br>
 * IsGroupOf-Rest Status
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

    IsGroupOfRestStatus(int value, String description)
    {
        this.value = value;
        this.description = description;
    }

    public int getValue()
    {
        return value;
    }

    public String getDescription()
    {
        return description;
    }
    
    public static int getEnumBitWidth()
    {
      return 8;
    }

    public static IsGroupOfRestStatus getEnumForValue(int i)
    {
       for(IsGroupOfRestStatus val: IsGroupOfRestStatus.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IsGroupOfRestStatus");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
    }

    public static IsGroupOfRestStatus unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static IsGroupOfRestStatus unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
}
