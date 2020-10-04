package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 325 marshal size 16<br>
 * SensorRecordSensorTypeOtherActiveSensors
 */
public enum SensorRecordSensorTypeOtherActiveSensors 
{
    SELF (0, "SensorRecordSensorTypeOtherActiveSensors details not found in SISO spec"),
;

    private int value;
    private final String description;

    SensorRecordSensorTypeOtherActiveSensors(int value, String description)
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

    public static SensorRecordSensorTypeOtherActiveSensors getEnumForValue(int i)
    {
       for(SensorRecordSensorTypeOtherActiveSensors val: SensorRecordSensorTypeOtherActiveSensors.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SensorRecordSensorTypeOtherActiveSensors");
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

    public static SensorRecordSensorTypeOtherActiveSensors unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static SensorRecordSensorTypeOtherActiveSensors unmarshalEnum (ByteBuffer byteBuffer) throws Exception
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
        return "SensorRecordSensorTypeOtherActiveSensors " + getValue() + " " + name(); 
    }
}
