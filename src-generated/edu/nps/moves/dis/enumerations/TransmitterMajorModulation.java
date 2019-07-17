package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 155 marshal size 16<br>
 * Transmitter-Major Modulation
 */
public enum TransmitterMajorModulation 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** TransmitterDetailAmplitudeModulation */    AMPLITUDE (1, "Amplitude"),
    /** TransmitterDetailAmplitudeandAngleModulation */    AMPLITUDE_AND_ANGLE (2, "Amplitude and Angle"),
    /** TransmitterDetailAnglemodulation */    ANGLE (3, "Angle"),
    /** TransmitterDetailCombinationModulation */    COMBINATION (4, "Combination"),
    /** TransmitterDetailPulseModulation */    PULSE (5, "Pulse"),
    /** TransmitterDetailUnmodulatedModulation */    UNMODULATED (6, "Unmodulated"),
    /** TransmitterDetailCarrierPhaseShiftModulation */    CARRIER_PHASE_SHIFT_MODULATION_CPSM (7, "Carrier Phase Shift Modulation (CPSM)"),
    /** TransmitterDetailSATCOMModulation */    SATCOM (8, "SATCOM");

    private int value;
    private final String description;

    TransmitterMajorModulation(int value, String description)
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

    public static TransmitterMajorModulation getEnumForValue(int i)
    {
       for(TransmitterMajorModulation val: TransmitterMajorModulation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterMajorModulation");
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

    public static TransmitterMajorModulation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static TransmitterMajorModulation unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
