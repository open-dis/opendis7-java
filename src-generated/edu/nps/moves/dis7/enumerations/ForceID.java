package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 6 marshal size 8<br>
 * Force ID
 */
public enum ForceID 
{
    /** Other */
    OTHER (0, "Other"),
    /** Friendly */
    FRIENDLY (1, "Friendly"),
    /** Opposing */
    OPPOSING (2, "Opposing"),
    /** Neutral */
    NEUTRAL (3, "Neutral"),
    /** Friendly 2 */
    FRIENDLY_2 (4, "Friendly 2"),
    /** Opposing 2 */
    OPPOSING_2 (5, "Opposing 2"),
    /** Neutral 2 */
    NEUTRAL_2 (6, "Neutral 2"),
    /** Friendly 3 */
    FRIENDLY_3 (7, "Friendly 3"),
    /** Opposing 3 */
    OPPOSING_3 (8, "Opposing 3"),
    /** Neutral 3 */
    NEUTRAL_3 (9, "Neutral 3"),
    /** Friendly 4 */
    FRIENDLY_4 (10, "Friendly 4"),
    /** Opposing 4 */
    OPPOSING_4 (11, "Opposing 4"),
    /** Neutral 4 */
    NEUTRAL_4 (12, "Neutral 4"),
    /** Friendly 5 */
    FRIENDLY_5 (13, "Friendly 5"),
    /** Opposing 5 */
    OPPOSING_5 (14, "Opposing 5"),
    /** Neutral 5 */
    NEUTRAL_5 (15, "Neutral 5"),
    /** Friendly 6 */
    FRIENDLY_6 (16, "Friendly 6"),
    /** Opposing 6 */
    OPPOSING_6 (17, "Opposing 6"),
    /** Neutral 6 */
    NEUTRAL_6 (18, "Neutral 6"),
    /** Friendly 7 */
    FRIENDLY_7 (19, "Friendly 7"),
    /** Opposing 7 */
    OPPOSING_7 (20, "Opposing 7"),
    /** Neutral 7 */
    NEUTRAL_7 (21, "Neutral 7"),
    /** Friendly 8 */
    FRIENDLY_8 (22, "Friendly 8"),
    /** Opposing 8 */
    OPPOSING_8 (23, "Opposing 8"),
    /** Neutral 8 */
    NEUTRAL_8 (24, "Neutral 8"),
    /** Friendly 9 */
    FRIENDLY_9 (25, "Friendly 9"),
    /** Opposing 9 */
    OPPOSING_9 (26, "Opposing 9"),
    /** Neutral 9 */
    NEUTRAL_9 (27, "Neutral 9"),
    /** Friendly 10 */
    FRIENDLY_10 (28, "Friendly 10"),
    /** Opposing 10 */
    OPPOSING_10 (29, "Opposing 10"),
    /** Neutral 10 */
    NEUTRAL_10 (30, "Neutral 10");

    private int value;
    private final String description;

    ForceID(int value, String description)
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

    public static ForceID getEnumForValue(int i)
    {
       for(ForceID val: ForceID.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ForceID");
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

    public static ForceID unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static ForceID unmarshalEnum(ByteBuffer buff) throws Exception
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
