package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 325 marshal size 16<br>
 * Sensor Record-Sensor Type-Other Active Sensors
 */
public enum SensorRecordSensorTypeOtherActiveSensors 
{
    NOT_SPECIFIED (0, "undefined by SISO spec"),
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

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static SensorRecordSensorTypeOtherActiveSensors unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static SensorRecordSensorTypeOtherActiveSensors unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
