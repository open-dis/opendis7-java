package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 161 marshal size 16<br>
 * Transmitter-Detail-Unmodulated Modulation
 */
public enum TransmitterDetailUnmodulatedModulation 
{
    /** Other */
    OTHER (0, "Other"),
    /** Continuous Wave emission of an unmodulated carrier */
    CONTINUOUS_WAVE_EMISSION_OF_AN_UNMODULATED_CARRIER (1, "Continuous Wave emission of an unmodulated carrier");

    private int value;
    private final String description;

    TransmitterDetailUnmodulatedModulation(int value, String description)
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

    public static TransmitterDetailUnmodulatedModulation getEnumForValue(int i)
    {
       for(TransmitterDetailUnmodulatedModulation val: TransmitterDetailUnmodulatedModulation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterDetailUnmodulatedModulation");
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

    public static TransmitterDetailUnmodulatedModulation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static TransmitterDetailUnmodulatedModulation unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
