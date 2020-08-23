package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 185 marshal size 16<br>
 * ____________________________
 */
public enum IntercomControlRecordType 
{
    /** Specific Destination record */
    SPECIFIC_DESTINATION_RECORD (1, "Specific Destination record"),
    /** Group Destination record */
    GROUP_DESTINATION_RECORD (2, "Group Destination record"),
    /** Group Assignment record */
    GROUP_ASSIGNMENT_RECORD (3, "Group Assignment record");

    private int value;
    private final String description;

    IntercomControlRecordType(int value, String description)
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

    public static IntercomControlRecordType getEnumForValue(int i)
    {
       for(IntercomControlRecordType val: IntercomControlRecordType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IntercomControlRecordType");
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

    public static IntercomControlRecordType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static IntercomControlRecordType unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "IntercomControlRecordType: " + name() + ": " + getValue(); 
    }
}
