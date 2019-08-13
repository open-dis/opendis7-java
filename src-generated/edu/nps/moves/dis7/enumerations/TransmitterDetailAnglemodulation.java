package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 158 marshal size 16<br>
 * Transmitter-Detail-Angle modulation
 */
public enum TransmitterDetailAnglemodulation 
{
    /** Other */
    OTHER (0, "Other"),
    /** FM (Frequency Modulation) */
    FM_FREQUENCY_MODULATION (1, "FM (Frequency Modulation)"),
    /** FSK (Frequency Shift Keying) */
    FSK_FREQUENCY_SHIFT_KEYING (2, "FSK (Frequency Shift Keying)"),
    /** PM (Phase Modulation) */
    PM_PHASE_MODULATION (3, "PM (Phase Modulation)");

    private int value;
    private final String description;

    TransmitterDetailAnglemodulation(int value, String description)
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

    public static TransmitterDetailAnglemodulation getEnumForValue(int i)
    {
       for(TransmitterDetailAnglemodulation val: TransmitterDetailAnglemodulation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterDetailAnglemodulation");
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

    public static TransmitterDetailAnglemodulation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static TransmitterDetailAnglemodulation unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
