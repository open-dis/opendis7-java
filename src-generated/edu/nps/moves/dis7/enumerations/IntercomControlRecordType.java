package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 185 marshal size 16<br>
 * Intercom Control-Record Type
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
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static IntercomControlRecordType unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
