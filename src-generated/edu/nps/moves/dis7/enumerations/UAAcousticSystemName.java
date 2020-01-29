package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 144 marshal size 16<br>
 * UA-Acoustic System Name
 */
public enum UAAcousticSystemName 
{
    /** Other */
    OTHER (0, "Other"),
    /** AN/BQQ-5 */
    AN_BQQ_5 (1, "AN/BQQ-5"),
    /** AN/SSQ-62 */
    AN_SSQ_62 (2, "AN/SSQ-62"),
    /** AN/SQS-23 */
    AN_SQS_23 (3, "AN/SQS-23"),
    /** AN/SQS-26 */
    AN_SQS_26 (4, "AN/SQS-26"),
    /** AN/SQS-53 */
    AN_SQS_53 (5, "AN/SQS-53"),
    /** ALFS */
    ALFS (6, "ALFS"),
    /** LFA */
    LFA (7, "LFA"),
    /** AN/AQS-901 */
    AN_AQS_901 (8, "AN/AQS-901"),
    /** AN/AQS-902 */
    AN_AQS_902 (9, "AN/AQS-902");

    private int value;
    private final String description;

    UAAcousticSystemName(int value, String description)
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
      return 16;
    }

    public static UAAcousticSystemName getEnumForValue(int i)
    {
       for(UAAcousticSystemName val: UAAcousticSystemName.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration UAAcousticSystemName");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static UAAcousticSystemName unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static UAAcousticSystemName unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "UAAcousticSystemName: " + name() + ": " + getValue(); 
    }
}
