package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 144 marshal size 16<br>
 * UAAcousticSystemName
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

    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }

    public static UAAcousticSystemName unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static UAAcousticSystemName unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "UAAcousticSystemName " + getValue() + " " + name(); 
    }
}
