package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 271 marshal size 14<br>
 * Signal-Encoding Type
 */
public enum SignalEncodingType 
{
    /** 8-bit mu-law (ITU-T G.711) */
    $8_BIT_MU_LAW_ITU_T_G711 (1, "8-bit mu-law (ITU-T G.711)"),
    /** CVSD (MIL-STD-188-113), There are variants of CVSD encoding types that exist in the DIS community.  These are not compatible with each other.  At least two additional types of CVSD, known as CCTT CVSD and CECOM CVSD, also use Enumeration value 2.  Make sure that if you are using CVSD that your system is compatible with other systems playing in an exercise. */
    CVSD_MIL_STD_188_113 (2, "CVSD (MIL-STD-188-113)"),
    /** ADPCM (ITU-T G.726) */
    ADPCM_ITU_T_G726 (3, "ADPCM (ITU-T G.726)"),
    /** 16-bit Linear PCM 2’s complement, Big Endian */
    $16_BIT_LINEAR_PCM_2S_COMPLEMENT_BIG_ENDIAN (4, "16-bit Linear PCM 2’s complement, Big Endian"),
    /** 8-bit Linear PCM, unsigned */
    $8_BIT_LINEAR_PCM_UNSIGNED (5, "8-bit Linear PCM, unsigned"),
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
    /** 16-bit Linear PCM 2’s complement, Little Endian */
    $16_BIT_LINEAR_PCM_2S_COMPLEMENT_LITTLE_ENDIAN (100, "16-bit Linear PCM 2’s complement, Little Endian"),
    /** (unavailable for use) */
    UNAVAILABLE_FOR_USE_2 (255, "(unavailable for use)");

    private int value;
    private final String description;

    SignalEncodingType(int value, String description)
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
      return 14;
    }

    public static SignalEncodingType getEnumForValue(int i)
    {
       for(SignalEncodingType val: SignalEncodingType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SignalEncodingType");
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

    public static SignalEncodingType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static SignalEncodingType unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "SignalEncodingType: " + name() + ": " + getValue(); 
    }
}
