package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 196 marshal size 12<br>
 * Minefield-Sensor Types-RADAR
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

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static MinefieldSensorTypesRADAR unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static MinefieldSensorTypesRADAR unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "MinefieldSensorTypesRADAR: " + name() + ": " + getValue(); 
    }
}
