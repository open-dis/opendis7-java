package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 196 marshal size 12<br>
 * MinefieldSensorTypesRADAR
 */
public enum MinefieldSensorTypesRADAR 
{
    /** Generic */
    GENERIC (0, "Generic"),
    /** Generic GPR */
    GENERIC_GPR (1, "Generic GPR"),
    /** GSTAMIDS I */
    GSTAMIDS_I (2, "GSTAMIDS I"),
    /** GSTAMIDS II */
    GSTAMIDS_II (3, "GSTAMIDS II"),
    /** HSTAMIDS I */
    HSTAMIDS_I (4, "HSTAMIDS I"),
    /** HSTAMIDS II */
    HSTAMIDS_II (5, "HSTAMIDS II");

    private int value;
    private final String description;

    MinefieldSensorTypesRADAR(int value, String description)
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
      return 12;
    }

    public static MinefieldSensorTypesRADAR getEnumForValue(int i)
    {
       for(MinefieldSensorTypesRADAR val: MinefieldSensorTypesRADAR.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MinefieldSensorTypesRADAR");
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

    public static MinefieldSensorTypesRADAR unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static MinefieldSensorTypesRADAR unmarshalEnum (ByteBuffer byteBuffer) throws Exception
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
        return "MinefieldSensorTypesRADAR " + getValue() + " " + name(); 
    }
}
