package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 198 marshal size 12<br>
 * Minefield-Sensor Types-Laser
 */
public enum MinefieldSensorTypesLaser 
{
    /** Generic */
    GENERIC (0, "Generic"),
    /** ASTAMIDS */
    ASTAMIDS (1, "ASTAMIDS");

    private int value;
    private final String description;

    MinefieldSensorTypesLaser(int value, String description)
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

    public static MinefieldSensorTypesLaser getEnumForValue(int i)
    {
       for(MinefieldSensorTypesLaser val: MinefieldSensorTypesLaser.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MinefieldSensorTypesLaser");
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

    public static MinefieldSensorTypesLaser unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static MinefieldSensorTypesLaser unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "MinefieldSensorTypesLaser: " + name() + ": " + getValue(); 
    }
}
