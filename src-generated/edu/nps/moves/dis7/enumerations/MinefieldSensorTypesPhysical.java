package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 200 marshal size 12<br>
 * _______________________________
 */
public enum MinefieldSensorTypesPhysical 
{
    /** Generic Probe */
    GENERIC_PROBE (0, "Generic Probe"),
    /** Probe, metal content */
    PROBE_METAL_CONTENT (1, "Probe, metal content"),
    /** Probe, no metal content */
    PROBE_NO_METAL_CONTENT (2, "Probe, no metal content");

    private int value;
    private final String description;

    MinefieldSensorTypesPhysical(int value, String description)
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

    public static MinefieldSensorTypesPhysical getEnumForValue(int i)
    {
       for(MinefieldSensorTypesPhysical val: MinefieldSensorTypesPhysical.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MinefieldSensorTypesPhysical");
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

    public static MinefieldSensorTypesPhysical unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static MinefieldSensorTypesPhysical unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "MinefieldSensorTypesPhysical: " + name() + ": " + getValue(); 
    }
}
