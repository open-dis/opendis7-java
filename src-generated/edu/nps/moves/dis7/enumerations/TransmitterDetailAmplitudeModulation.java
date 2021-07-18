package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 156 marshal size 16<br>
 * TransmitterDetailAmplitudeModulation
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

    /** Constructor */
    TransmitterDetailAmplitudeModulation(int value, String description)
    {
        this.value = value;
        this.description = description;
    }
    /** Provide enumeration value
      * @return integer value */
    public int getValue()
    {
        return value;
    }

    /** Provide enumeration description
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /** bit width for this enumeration
     * @return number of bits wide
     */
    public static int getEnumBitWidth()
    {
      return 16;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static TransmitterDetailAmplitudeModulation getEnumForValue(int i)
    {
       for(TransmitterDetailAmplitudeModulation val: TransmitterDetailAmplitudeModulation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterDetailAmplitudeModulation");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static TransmitterDetailAmplitudeModulation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static TransmitterDetailAmplitudeModulation unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        return "TransmitterDetailAmplitudeModulation " + getValue() + " " + name(); 
    }
}
