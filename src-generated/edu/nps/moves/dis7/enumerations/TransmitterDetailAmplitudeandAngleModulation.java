package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 157 marshal size 16<br>
 * TransmitterDetailAmplitudeandAngleModulation
 */
public enum TransmitterDetailAmplitudeandAngleModulation 
{
    /** Other */
    OTHER (0, "Other"),
    /** Amplitude and Angle */
    AMPLITUDE_AND_ANGLE (1, "Amplitude and Angle");

    private int value;
    private final String description;

    TransmitterDetailAmplitudeandAngleModulation(int value, String description)
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

    public static TransmitterDetailAmplitudeandAngleModulation getEnumForValue(int i)
    {
       for(TransmitterDetailAmplitudeandAngleModulation val: TransmitterDetailAmplitudeandAngleModulation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterDetailAmplitudeandAngleModulation");
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

    public static TransmitterDetailAmplitudeandAngleModulation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static TransmitterDetailAmplitudeandAngleModulation unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "TransmitterDetailAmplitudeandAngleModulation: " + name() + ": " + getValue(); 
    }
}
