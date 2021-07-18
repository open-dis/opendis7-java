package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 474 marshal size 8<br>
 * LifeFormHumanSpecificAssaultRifles
 */
public enum LifeFormHumanSpecificAssaultRifles 
{
    /** Other */
    OTHER (0, "Other"),
    /** 4.5mm Interdynamics MKR */
    _45MM_INTERDYNAMICS_MKR (1, "4.5mm Interdynamics MKR"),
    /** 5.45mm AK-74 */
    _545MM_AK_74 (10, "5.45mm AK-74"),
    /** 5.45mm AKS-74 */
    _545MM_AKS_74 (11, "5.45mm AKS-74"),
    /** 5.45mm AK-74M */
    _545MM_AK_74M (12, "5.45mm AK-74M"),
    /** 5.45mm Kbk wz. 1988 Tantal */
    _545MM_KBK_WZ_1988_TANTAL (13, "5.45mm Kbk wz. 1988 Tantal"),
    /** 5.56mm AK-101 */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "5.56mm AK-101"),
    /** 5.56mm Diemaco C7, Diemaco is now Colt Canada. */
    _556MM_DIEMACO_C7 (31, "5.56mm Diemaco C7"),
    /** 5.56mm Colt Canada C8 Carbine */
    _556MM_COLT_CANADA_C8_CARBINE (32, "5.56mm Colt Canada C8 Carbine"),
    /** 5.56mm GIAT FAMAS G2 */
    _556MM_GIAT_FAMAS_G2 (33, "5.56mm GIAT FAMAS G2"),
    /** 5.56mm FN FNC */
    _556MM_FN_FNC (34, "5.56mm FN FNC"),
    /** 5.56mm HK G36 */
    _556MM_HK_G36 (35, "5.56mm HK G36"),
    /** 5.56mm IMI Galil */
    _556MM_IMI_GALIL (36, "5.56mm IMI Galil"),
    /** 5.56mm INSAS */
    _556MM_INSAS (37, "5.56mm INSAS"),
    /** 5.56mm Daewoo K1 */
    _556MM_DAEWOO_K1 (38, "5.56mm Daewoo K1"),
    /** 5.56mm Daewoo K2 */
    _556MM_DAEWOO_K2 (39, "5.56mm Daewoo K2"),
    /** 5.56mm M16A1 */
    _556MM_M16A1 (40, "5.56mm M16A1"),
    /** 5.56mm M16A2/A3/A4 */
    _556MM_M16A2_A3_A4 (41, "5.56mm M16A2/A3/A4"),
    /** 5.56mm Colt M4 */
    _556MM_COLT_M4 (42, "5.56mm Colt M4"),
    /** 5.56mm Colt M4 Special Operations Peculiar Modification (SOPMOD) */
    _556MM_COLT_M4_SPECIAL_OPERATIONS_PECULIAR_MODIFICATION_SOPMOD (43, "5.56mm Colt M4 Special Operations Peculiar Modification (SOPMOD)"),
    /** 5.56mm Ruger Mini-14 */
    _556MM_RUGER_MINI_14 (44, "5.56mm Ruger Mini-14"),
    /** 5.56mm Enfield SA-80A2 */
    _556MM_ENFIELD_SA_80A2 (45, "5.56mm Enfield SA-80A2"),
    /** 5.56mm Pindad SS1 V1 */
    TIME_SPACE_POSITION_INFORMATION (46, "5.56mm Pindad SS1 V1"),
    /** 5.56mm Pindad SS1 V2 */
    _556MM_PINDAD_SS1_V2 (47, "5.56mm Pindad SS1 V2"),
    /** 5.56mm Pindad SS1 V3 */
    _556MM_PINDAD_SS1_V3 (48, "5.56mm Pindad SS1 V3"),
    /** 5.56mm Steyr AUG A1 */
    LIVE_ENTITY_FIRE (49, "5.56mm Steyr AUG A1"),
    /** 5.56mm T65 */
    LIVE_ENTITY_DETONATION (50, "5.56mm T65"),
    /** 5.56mm T91 */
    CREATE_ENTITY_RELIABLE (51, "5.56mm T91"),
    /** 5.56mm Tavor TAR-21 */
    REMOVE_ENTITY_RELIABLE (52, "5.56mm Tavor TAR-21"),
    /** 5.56mm Type CQ / M311 */
    START_RESUME_RELIABLE (53, "5.56mm Type CQ / M311"),
    /** 5.56mm Daewoo K11 */
    STOP_FREEZE_RELIABLE (54, "5.56mm Daewoo K11"),
    /** 5.56mm Austeyr F88 */
    ACKNOWLEDGE_RELIABLE (55, "5.56mm Austeyr F88"),
    /** 5.56mm Austeyr F88-GLA */
    ACTION_REQUEST_RELIABLE (56, "5.56mm Austeyr F88-GLA"),
    /** 5.56mm Austeyr F88-S-A1 */
    ACTION_RESPONSE_RELIABLE (57, "5.56mm Austeyr F88-S-A1"),
    /** 5.56mm Austeyr F88-S-A2 */
    DATA_QUERY_RELIABLE (58, "5.56mm Austeyr F88-S-A2"),
    /** 5.56mm Austeyr F88-C */
    SET_DATA_RELIABLE (59, "5.56mm Austeyr F88-C"),
    /** 5.56mm Austeyr F88-S-A1C */
    DATA_RELIABLE (60, "5.56mm Austeyr F88-S-A1C"),
    /** 5.56mm Austeyr F88-S-A1 LTR */
    EVENT_REPORT_RELIABLE (61, "5.56mm Austeyr F88-S-A1 LTR"),
    /** 5.56mm Austeyr EF88 */
    COMMENT_RELIABLE (62, "5.56mm Austeyr EF88"),
    /** 5.56mm Bushmaster XM15 */
    RECORD_RELIABLE (63, "5.56mm Bushmaster XM15"),
    /** 5.56mm HK416 */
    SET_RECORD_RELIABLE	 (64, "5.56mm HK416"),
    /** 5.56mm F90 */
    RECORD_QUERY_RELIABLE (65, "5.56mm F90"),
    /** 5.56mm F90(G) */
    _556MM_F90G (66, "5.56mm F90(G)"),
    /** 5.56mm F90M */
    _556MM_F90M (67, "5.56mm F90M"),
    /** 5.56mm F90M(G) */
    _556MM_F90MG (68, "5.56mm F90M(G)"),
    /** 5.56mm F90CQB */
    _556MM_F90CQB (69, "5.56mm F90CQB"),
    /** 5.8mm QBZ-95 (Type 95) */
    _58MM_QBZ_95_TYPE_95 (100, "5.8mm QBZ-95 (Type 95)"),
    /** 7.62mm AK-103 */
    _762MM_AK_103 (110, "7.62mm AK-103"),
    /** 7.62mm AK-104 */
    _762MM_AK_104 (111, "7.62mm AK-104"),
    /** 7.62mm AK-47 */
    _762MM_AK_47 (112, "7.62mm AK-47"),
    /** 7.62mm AKM */
    _762MM_AKM (113, "7.62mm AKM"),
    /** 7.62mm AKS-47 */
    _762MM_AKS_47 (114, "7.62mm AKS-47"),
    /** 7.62mm HK G3A3 */
    _762MM_HK_G3A3 (115, "7.62mm HK G3A3"),
    /** 7.62mm IMI Galil */
    _762MM_IMI_GALIL (116, "7.62mm IMI Galil"),
    /** 7.62mm KLS */
    _762MM_KLS (117, "7.62mm KLS"),
    /** 7.62mm SKS */
    _762MM_SKS (118, "7.62mm SKS"),
    /** 7.62mm Type 56 */
    _762MM_TYPE_56 (119, "7.62mm Type 56"),
    /** 7.62mm Type 63/68 */
    _762MM_TYPE_63_68 (120, "7.62mm Type 63/68"),
    /** 7.62mm Type 81 */
    _762MM_TYPE_81 (121, "7.62mm Type 81"),
    /** 8mm Lebel M16 */
    _8MM_LEBEL_M16 (240, "8mm Lebel M16");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificAssaultRifles(int value, String description)
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
    public static LifeFormHumanSpecificAssaultRifles getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificAssaultRifles val: LifeFormHumanSpecificAssaultRifles.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificAssaultRifles");
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
    public static LifeFormHumanSpecificAssaultRifles unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormHumanSpecificAssaultRifles unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "LifeFormHumanSpecificAssaultRifles " + padding + getValue() + " " + name();
    }
}
