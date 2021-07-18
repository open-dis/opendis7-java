package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 177 marshal size 32<br>
 * SignalUserProtocolIdentificationNumber
 */
public enum SignalUserProtocolIdentificationNumber 
{
    /** CCSIL */
    CCSIL (1, "CCSIL"),
    /** A2ATD SINCGARS ERF */
    A2ATD_SINCGARS_ERF (5, "A2ATD SINCGARS ERF"),
    /** A2ATD CAC2 */
    A2ATD_CAC2 (6, "A2ATD CAC2"),
    /** Battle Command */
    BATTLE_COMMAND (20, "Battle Command"),
    /** AFIWC IADS Track Report */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "AFIWC IADS Track Report"),
    /** AFIWC IADS Comm C2 Message */
    AFIWC_IADS_COMM_C2_MESSAGE (31, "AFIWC IADS Comm C2 Message"),
    /** AFIWC IADS Ground Control Interceptor (GCI) Command */
    AFIWC_IADS_GROUND_CONTROL_INTERCEPTOR_GCI_COMMAND (32, "AFIWC IADS Ground Control Interceptor (GCI) Command"),
    /** AFIWC Voice Text Message */
    AFIWC_VOICE_TEXT_MESSAGE (35, "AFIWC Voice Text Message"),
    /** ModSAF Text Radio */
    MODSAF_TEXT_RADIO (177, "ModSAF Text Radio"),
    /** CCTT SINCGARS ERF-LOCKOUT */
    CCTT_SINCGARS_ERF_LOCKOUT (200, "CCTT SINCGARS ERF-LOCKOUT"),
    /** CCTT SINCGARS ERF-HOPSET */
    CCTT_SINCGARS_ERF_HOPSET (201, "CCTT SINCGARS ERF-HOPSET"),
    /** CCTT SINCGARS OTAR */
    CCTT_SINCGARS_OTAR (202, "CCTT SINCGARS OTAR"),
    /** CCTT SINCGARS DATA */
    CCTT_SINCGARS_DATA (203, "CCTT SINCGARS DATA"),
    /** ModSAF FWA Forward Air Controller */
    MODSAF_FWA_FORWARD_AIR_CONTROLLER (546, "ModSAF FWA Forward Air Controller"),
    /** ModSAF Threat ADA C3 */
    MODSAF_THREAT_ADA_C3 (832, "ModSAF Threat ADA C3"),
    /** F-16 MTC AFAPD Protocol */
    F_16_MTC_AFAPD_PROTOCOL (1000, "F-16 MTC AFAPD Protocol"),
    /** F-16 MTC IDL Protocol */
    F_16_MTC_IDL_PROTOCOL (1100, "F-16 MTC IDL Protocol"),
    /** Automatic Identification System (AIS) */
    AUTOMATIC_IDENTIFICATION_SYSTEM_AIS (1371, "Automatic Identification System (AIS)"),
    /** ModSAF Artillery Fire Control */
    MODSAF_ARTILLERY_FIRE_CONTROL (4570, "ModSAF Artillery Fire Control"),
    /** AGTS */
    AGTS (5361, "AGTS"),
    /** GC3 */
    GC3 (6000, "GC3"),
    /** WNCP data */
    WNCP_DATA (6010, "WNCP data"),
    /** Spoken text message */
    SPOKEN_TEXT_MESSAGE (6020, "Spoken text message"),
    /** Longbow IDM message */
    LONGBOW_IDM_MESSAGE (6661, "Longbow IDM message"),
    /** Comanche IDM message */
    COMANCHE_IDM_MESSAGE (6662, "Comanche IDM message"),
    /** Longbow Airborne TACFIRE Message */
    LONGBOW_AIRBORNE_TACFIRE_MESSAGE (6663, "Longbow Airborne TACFIRE Message"),
    /** Longbow Ground TACFIRE Message */
    LONGBOW_GROUND_TACFIRE_MESSAGE (6664, "Longbow Ground TACFIRE Message"),
    /** Longbow AFAPD Message */
    LONGBOW_AFAPD_MESSAGE (6665, "Longbow AFAPD Message"),
    /** Longbow ERF message */
    LONGBOW_ERF_MESSAGE (6666, "Longbow ERF message"),
    /** VMF IDM */
    VMF_IDM (7000, "VMF IDM"),
    /** CSAR Radio Survivor Message */
    CSAR_RADIO_SURVIVOR_MESSAGE (7010, "CSAR Radio Survivor Message"),
    /** CSAR Radio Interrogator Message */
    CSAR_RADIO_INTERROGATOR_MESSAGE (7020, "CSAR Radio Interrogator Message"),
    /** Image File Transfer Message */
    IMAGE_FILE_TRANSFER_MESSAGE (7030, "Image File Transfer Message"),
    /** Geotag Data Message */
    GEOTAG_DATA_MESSAGE (7040, "Geotag Data Message"),
    /** Tactical Video Regeneration Data */
    TACTICAL_VIDEO_REGENERATION_DATA (7050, "Tactical Video Regeneration Data");

    private int value;
    private final String description;

    /** Constructor */
    SignalUserProtocolIdentificationNumber(int value, String description)
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
      return 32;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static SignalUserProtocolIdentificationNumber getEnumForValue(int i)
    {
       for(SignalUserProtocolIdentificationNumber val: SignalUserProtocolIdentificationNumber.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration SignalUserProtocolIdentificationNumber");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output */
    public void marshal(ByteBuffer byteBuffer)
    {
        byteBuffer.putInt(getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static SignalUserProtocolIdentificationNumber unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @return enumeration of interest */
    public static SignalUserProtocolIdentificationNumber unmarshalEnum (ByteBuffer byteBuffer)
    {
        return getEnumForValue(byteBuffer.getInt());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
    
    @Override
    public String toString()
    {
        return "SignalUserProtocolIdentificationNumber: " + getValue() + " " + name();
    }
}
