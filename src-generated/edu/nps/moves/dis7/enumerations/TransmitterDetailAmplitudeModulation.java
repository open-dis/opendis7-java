package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 156 marshal size 16<br>
 * Transmitter-Detail-Amplitude Modulation
 */
public enum TransmitterDetailAmplitudeModulation 
{
    /** Other */
    OTHER (0, "Other"),
    /** AFSK (Audio Frequency Shift Keying) */
    AFSK_AUDIO_FREQUENCY_SHIFT_KEYING (1, "AFSK (Audio Frequency Shift Keying)"),
    /** AM (Amplitude Modulation) */
    AM_AMPLITUDE_MODULATION (2, "AM (Amplitude Modulation)"),
    /** CW (Continuous Wave Modulation) */
    CW_CONTINUOUS_WAVE_MODULATION (3, "CW (Continuous Wave Modulation)"),
    /** DSB (Double Sideband) */
    DSB_DOUBLE_SIDEBAND (4, "DSB (Double Sideband)"),
    /** ISB (Independent Sideband) */
    ISB_INDEPENDENT_SIDEBAND (5, "ISB (Independent Sideband)"),
    /** LSB (Single Band Suppressed Carrier, Lower Sideband Mode) */
    LSB_SINGLE_BAND_SUPPRESSED_CARRIER_LOWER_SIDEBAND_MODE (6, "LSB (Single Band Suppressed Carrier, Lower Sideband Mode)"),
    /** SSB-Full (Single Sideband Full Carrier) */
    SSB_FULL_SINGLE_SIDEBAND_FULL_CARRIER (7, "SSB-Full (Single Sideband Full Carrier)"),
    /** SSB-Reduc (Single Band Reduced Carrier) */
    SSB_REDUC_SINGLE_BAND_REDUCED_CARRIER (8, "SSB-Reduc (Single Band Reduced Carrier)"),
    /** USB (Single Band Suppressed Carrier, Upper Sideband Mode) */
    USB_SINGLE_BAND_SUPPRESSED_CARRIER_UPPER_SIDEBAND_MODE (9, "USB (Single Band Suppressed Carrier, Upper Sideband Mode)"),
    /** VSB (Vestigial Sideband) */
    VSB_VESTIGIAL_SIDEBAND (10, "VSB (Vestigial Sideband)");

    private int value;
    private final String description;

    TransmitterDetailAmplitudeModulation(int value, String description)
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

    public static TransmitterDetailAmplitudeModulation getEnumForValue(int i)
    {
       for(TransmitterDetailAmplitudeModulation val: TransmitterDetailAmplitudeModulation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterDetailAmplitudeModulation");
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

    public static TransmitterDetailAmplitudeModulation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static TransmitterDetailAmplitudeModulation unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "TransmitterDetailAmplitudeModulation: " + name() + ": " + getValue(); 
    }
}
