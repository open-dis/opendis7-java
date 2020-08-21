package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 150 marshal size 16<br>
 * UAAdditionalPassiveActivityParameterIndex
 */
public enum UAAdditionalPassiveActivityParameterIndex 
{
    /** Other */
    OTHER (0, "Other");

    private int value;
    private final String description;

    UAAdditionalPassiveActivityParameterIndex(int value, String description)
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

    public static UAAdditionalPassiveActivityParameterIndex getEnumForValue(int i)
    {
       for(UAAdditionalPassiveActivityParameterIndex val: UAAdditionalPassiveActivityParameterIndex.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration UAAdditionalPassiveActivityParameterIndex");
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

    public static UAAdditionalPassiveActivityParameterIndex unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static UAAdditionalPassiveActivityParameterIndex unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "UAAdditionalPassiveActivityParameterIndex: " + name() + ": " + getValue(); 
    }
}
