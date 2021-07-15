package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 271 marshal size 14<br>
 * SignalEncodingType
 */
public enum SignalEncodingType 
{
    /** 8-bit mu-law (ITU-T G.711) */
    _8_BIT_MU_LAW_ITU_T_G711 (1, "8-bit mu-law (ITU-T G.711)"),
    /** CVSD (MIL-STD-188-113), There are variants of CVSD encoding types that exist in the DIS community. These are not compatible with each other. At least two additional types of CVSD, known as CCTT CVSD and CECOM CVSD, also use Enumeration value 2.  Make sure that if you are using CVSD that your system is compatible with other systems playing in an exercise. */
    CVSD_MIL_STD_188_113 (2, "CVSD (MIL-STD-188-113)"),
    /** ADPCM (ITU-T G.726) */
    ADPCM_ITU_T_G726 (3, "ADPCM (ITU-T G.726)"),
    /** 16-bit Linear PCM 2’s complement, Big Endian */
    _16_BIT_LINEAR_PCM_2S_COMPLEMENT_BIG_ENDIAN (4, "16-bit Linear PCM 2’s complement, Big Endian"),
    /** 8-bit Linear PCM, unsigned */
    _8_BIT_LINEAR_PCM_UNSIGNED (5, "8-bit Linear PCM, unsigned"),
    /** VQ (Vector Quantization) */
    VQ_VECTOR_QUANTIZATION (6, "VQ (Vector Quantization)"),
    /** (unavailable for use) */
    UNAVAILABLE_FOR_USE (7, "(unavailable for use)"),
    /** GSM Full-Rate (ETSI 06.10) */
    GSM_FULL_RATE_ETSI_0610 (8, "GSM Full-Rate (ETSI 06.10)"),
    /** GSM Half-Rate (ETSI 06.20) */
    GSM_HALF_RATE_ETSI_0620 (9, "GSM Half-Rate (ETSI 06.20)"),
    /** Speex Narrow Band, http://www.speex.org/ */
    SPEEX_NARROW_BAND (10, "Speex Narrow Band"),
    /** Opus, https://tools.ietf.org/html/rfc6716 */
    OPUS (11, "Opus"),
    /** 16-bit Linear PCM 2’s complement, Little Endian */
    _16_BIT_LINEAR_PCM_2S_COMPLEMENT_LITTLE_ENDIAN (100, "16-bit Linear PCM 2’s complement, Little Endian"),
    /** (unavailable for use) */
    UNAVAILABLE_FOR_USE_2 (255, "(unavailable for use)");

    private int value;
    private final String description;

    /** Constructor */
    SignalEncodingType(int value, String description)
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
      return 14;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static SignalEncodingType getEnumForValue(int i)
    {
       for(SignalEncodingType val: SignalEncodingType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SignalEncodingType");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static SignalEncodingType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static SignalEncodingType unmarshalEnum (ByteBuffer byteBuffer) throws Exception
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
        return "SignalEncodingType " + getValue() + " " + name(); 
    }
}
