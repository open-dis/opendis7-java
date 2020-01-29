package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 146 marshal size 16<br>
 * UA-Active Emission Parameter Index
 */
public enum UAActiveEmissionParameterIndex 
{
    /** Other */
    OTHER (0, "Other");

    private int value;
    private final String description;

    UAActiveEmissionParameterIndex(int value, String description)
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

    public static UAActiveEmissionParameterIndex getEnumForValue(int i)
    {
       for(UAActiveEmissionParameterIndex val: UAActiveEmissionParameterIndex.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration UAActiveEmissionParameterIndex");
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

    public static UAActiveEmissionParameterIndex unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static UAActiveEmissionParameterIndex unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "UAActiveEmissionParameterIndex: " + name() + ": " + getValue(); 
    }
}
