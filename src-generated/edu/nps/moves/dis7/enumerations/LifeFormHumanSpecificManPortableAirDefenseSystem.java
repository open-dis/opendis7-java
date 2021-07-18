package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 520 marshal size 8<br>
 * LifeFormHumanSpecificManPortableAirDefenseSystem
 */
public enum LifeFormHumanSpecificManPortableAirDefenseSystem 
{
    /** Other */
    OTHER (0, "Other"),
    /** 70mm FIM-43 Redeye */
    _70MM_FIM_43_REDEYE (1, "70mm FIM-43 Redeye"),
    /** 70mm FIM-92 Stinger */
    _70MM_FIM_92_STINGER (2, "70mm FIM-92 Stinger"),
    /** 76mm Blowpipe */
    _76MM_BLOWPIPE (10, "76mm Blowpipe"),
    /** 76mm Starburst (Javelin S-15) */
    _76MM_STARBURST_JAVELIN_S_15 (11, "76mm Starburst (Javelin S-15)"),
    /** 130mm Starstreak HVM */
    _130MM_STARSTREAK_HVM (12, "130mm Starstreak HVM"),
    /** 90mm Mistral */
    _90MM_MISTRAL (15, "90mm Mistral"),
    /** 72mm 9K32M Strela-2 (SA-7) */
    _72MM_9K32M_STRELA_2_SA_7 (20, "72mm 9K32M Strela-2 (SA-7)"),
    /** 72mm 9K36 Strela-3 (SA-14) */
    _72MM_9K36_STRELA_3_SA_14 (21, "72mm 9K36 Strela-3 (SA-14)"),
    /** 72mm 9K38 Igla (SA-18) */
    _72MM_9K38_IGLA_SA_18 (22, "72mm 9K38 Igla (SA-18)"),
    /** 72mm 9K310 Igla-M (SA-16) */
    _72MM_9K310_IGLA_M_SA_16 (23, "72mm 9K310 Igla-M (SA-16)"),
    /** 72mm 9K333 Verba (SA-25) */
    _72MM_9K333_VERBA_SA_25 (24, "72mm 9K333 Verba (SA-25)"),
    /** 72mm 9K338 Igla-S (SA-24 Grinch) */
    _72MM_9K338_IGLA_S_SA_24_GRINCH (25, "72mm 9K338 Igla-S (SA-24 Grinch)"),
    /** 72mm HN-5 Hong-Ying-5 */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "72mm HN-5 Hong-Ying-5"),
    /** 72mm QW-1 Vanguard */
    _72MM_QW_1_VANGUARD (31, "72mm QW-1 Vanguard"),
    /** 72mm QW-2 Vanguard 2 */
    _72MM_QW_2_VANGUARD_2 (32, "72mm QW-2 Vanguard 2"),
    /** 90mm QW-3 */
    _90MM_QW_3 (33, "90mm QW-3"),
    /** 72mm FN-6 */
    _72MM_FN_6 (34, "72mm FN-6"),
    /** 71mm Misagh-1 */
    _71MM_MISAGH_1 (45, "71mm Misagh-1"),
    /** 71mm Misagh-2 */
    TIME_SPACE_POSITION_INFORMATION (46, "71mm Misagh-2"),
    /** 80mm Type-91 Kin-SAM */
    LIVE_ENTITY_DETONATION (50, "80mm Type-91 Kin-SAM"),
    /** 80mm KP-SAM Shun-Gung (Chiron) */
    ACKNOWLEDGE_RELIABLE (55, "80mm KP-SAM Shun-Gung (Chiron)"),
    /** 106mm RBS-70 */
    DATA_RELIABLE (60, "106mm RBS-70");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificManPortableAirDefenseSystem(int value, String description)
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
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static LifeFormHumanSpecificManPortableAirDefenseSystem getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificManPortableAirDefenseSystem val: LifeFormHumanSpecificManPortableAirDefenseSystem.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificManPortableAirDefenseSystem");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static LifeFormHumanSpecificManPortableAirDefenseSystem unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static LifeFormHumanSpecificManPortableAirDefenseSystem unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        String padding = new String();
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "LifeFormHumanSpecificManPortableAirDefenseSystem " + padding + getValue() + " " + name();
    }
}
