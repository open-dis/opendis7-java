package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 474 marshal size 8<br>
 * Life Form-Human-Specific-Assault Rifles
 */
public enum LifeFormHumanSpecificAssaultRifles 
{
    /** Other */
    OTHER (0, "Other"),
    /** 4.5mm Interdynamics MKR */
    $45MM_INTERDYNAMICS_MKR (1, "4.5mm Interdynamics MKR"),
    /** 5.45mm AK-74 */
    $545MM_AK_74 (10, "5.45mm AK-74"),
    /** 5.45mm AKS-74 */
    $545MM_AKS_74 (11, "5.45mm AKS-74"),
    /** 5.45mm AK-74M */
    $545MM_AK_74M (12, "5.45mm AK-74M"),
    /** 5.45mm Kbk wz. 1988 Tantal */
    $545MM_KBK_WZ_1988_TANTAL (13, "5.45mm Kbk wz. 1988 Tantal"),
    /** 5.56mm AK-47 */
    $556MM_AK_47 (30, "5.56mm AK-47"),
    /** 5.56mm Diemaco C7, Diemaco is now Colt Canada. */
    $556MM_DIEMACO_C7 (31, "5.56mm Diemaco C7"),
    /** 5.56mm Colt Canada C8 Carbine */
    $556MM_COLT_CANADA_C8_CARBINE (32, "5.56mm Colt Canada C8 Carbine"),
    /** 5.56mm GIAT FAMAS G2 */
    $556MM_GIAT_FAMAS_G2 (33, "5.56mm GIAT FAMAS G2"),
    /** 5.56mm FN FNC */
    $556MM_FN_FNC (34, "5.56mm FN FNC"),
    /** 5.56mm HK G36 */
    $556MM_HK_G36 (35, "5.56mm HK G36"),
    /** 5.56mm IMI Galil */
    $556MM_IMI_GALIL (36, "5.56mm IMI Galil"),
    /** 5.56mm INSAS */
    $556MM_INSAS (37, "5.56mm INSAS"),
    /** 5.56mm Daewoo K1 */
    $556MM_DAEWOO_K1 (38, "5.56mm Daewoo K1"),
    /** 5.56mm Daewoo K2 */
    $556MM_DAEWOO_K2 (39, "5.56mm Daewoo K2"),
    /** 5.56mm M16A1 */
    $556MM_M16A1 (40, "5.56mm M16A1"),
    /** 5.56mm M16A2/A3/A4 */
    $556MM_M16A2_A3_A4 (41, "5.56mm M16A2/A3/A4"),
    /** 5.56mm Colt M4 */
    $556MM_COLT_M4 (42, "5.56mm Colt M4"),
    /** 5.56mm Colt M4 Special Operations Peculiar Modification (SOPMOD) */
    $556MM_COLT_M4_SPECIAL_OPERATIONS_PECULIAR_MODIFICATION_SOPMOD (43, "5.56mm Colt M4 Special Operations Peculiar Modification (SOPMOD)"),
    /** 5.56mm Ruger Mini-14 */
    $556MM_RUGER_MINI_14 (44, "5.56mm Ruger Mini-14"),
    /** 5.56mm Enfield SA-80A2 */
    $556MM_ENFIELD_SA_80A2 (45, "5.56mm Enfield SA-80A2"),
    /** 5.56mm Pindad SS1 V1 */
    $556MM_PINDAD_SS1_V1 (46, "5.56mm Pindad SS1 V1"),
    /** 5.56mm Pindad SS1 V2 */
    $556MM_PINDAD_SS1_V2 (47, "5.56mm Pindad SS1 V2"),
    /** 5.56mm Pindad SS1 V3 */
    $556MM_PINDAD_SS1_V3 (48, "5.56mm Pindad SS1 V3"),
    /** 5.56mm Steyr AUG A1 */
    $556MM_STEYR_AUG_A1 (49, "5.56mm Steyr AUG A1"),
    /** 5.56mm T65 */
    $556MM_T65 (50, "5.56mm T65"),
    /** 5.56mm T91 */
    $556MM_T91 (51, "5.56mm T91"),
    /** 5.56mm Tavor TAR-21 */
    $556MM_TAVOR_TAR_21 (52, "5.56mm Tavor TAR-21"),
    /** 5.56mm Type CQ / M311 */
    $556MM_TYPE_CQ_M311 (53, "5.56mm Type CQ / M311"),
    /** 5.56mm Daewoo K11 */
    $556MM_DAEWOO_K11 (54, "5.56mm Daewoo K11"),
    /** 5.56mm Austeyr F88 */
    $556MM_AUSTEYR_F88 (55, "5.56mm Austeyr F88"),
    /** 5.56mm Austeyr F88-GLA */
    $556MM_AUSTEYR_F88_GLA (56, "5.56mm Austeyr F88-GLA"),
    /** 5.56mm Austeyr F88-S-A1 */
    $556MM_AUSTEYR_F88_S_A1 (57, "5.56mm Austeyr F88-S-A1"),
    /** 5.56mm Austeyr F88-S-A2 */
    $556MM_AUSTEYR_F88_S_A2 (58, "5.56mm Austeyr F88-S-A2"),
    /** 5.56mm Austeyr F88-C */
    $556MM_AUSTEYR_F88_C (59, "5.56mm Austeyr F88-C"),
    /** 5.56mm Austeyr F88-S-A1C */
    $556MM_AUSTEYR_F88_S_A1C (60, "5.56mm Austeyr F88-S-A1C"),
    /** 5.56mm Austeyr F88-S-A1 LTR */
    $556MM_AUSTEYR_F88_S_A1_LTR (61, "5.56mm Austeyr F88-S-A1 LTR"),
    /** 5.56mm Austeyr EF88 */
    $556MM_AUSTEYR_EF88 (62, "5.56mm Austeyr EF88"),
    /** 5.56mm Bushmaster XM15 */
    $556MM_BUSHMASTER_XM15 (63, "5.56mm Bushmaster XM15"),
    /** 5.56mm HK416 */
    $556MM_HK416 (64, "5.56mm HK416"),
    /** 5.56mm F90 */
    $556MM_F90 (65, "5.56mm F90"),
    /** 5.56mm F90(G) */
    $556MM_F90G (66, "5.56mm F90(G)"),
    /** 5.56mm F90M */
    $556MM_F90M (67, "5.56mm F90M"),
    /** 5.56mm F90M(G) */
    $556MM_F90MG (68, "5.56mm F90M(G)"),
    /** 5.56mm F90CQB */
    $556MM_F90CQB (69, "5.56mm F90CQB"),
    /** 5.8mm QBZ-95 (Type 95) */
    $58MM_QBZ_95_TYPE_95 (100, "5.8mm QBZ-95 (Type 95)"),
    /** 7.62mm AK-103 */
    $762MM_AK_103 (110, "7.62mm AK-103"),
    /** 7.62mm AK-104 */
    $762MM_AK_104 (111, "7.62mm AK-104"),
    /** 7.62mm AK-47 */
    $762MM_AK_47 (112, "7.62mm AK-47"),
    /** 7.62mm AKM */
    $762MM_AKM (113, "7.62mm AKM"),
    /** 7.62mm AKS-47 */
    $762MM_AKS_47 (114, "7.62mm AKS-47"),
    /** 7.62mm HK G3A3 */
    $762MM_HK_G3A3 (115, "7.62mm HK G3A3"),
    /** 7.62mm IMI Galil */
    $762MM_IMI_GALIL (116, "7.62mm IMI Galil"),
    /** 7.62mm KLS */
    $762MM_KLS (117, "7.62mm KLS"),
    /** 7.62mm SKS */
    $762MM_SKS (118, "7.62mm SKS"),
    /** 7.62mm Type 56 */
    $762MM_TYPE_56 (119, "7.62mm Type 56"),
    /** 7.62mm Type 63/68 */
    $762MM_TYPE_63_68 (120, "7.62mm Type 63/68"),
    /** 7.62mm Type 81 */
    $762MM_TYPE_81 (121, "7.62mm Type 81"),
    /** 8mm Lebel M16 */
    $8MM_LEBEL_M16 (240, "8mm Lebel M16");

    private int value;
    private final String description;

    LifeFormHumanSpecificAssaultRifles(int value, String description)
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
      return 8;
    }

    public static LifeFormHumanSpecificAssaultRifles getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificAssaultRifles val: LifeFormHumanSpecificAssaultRifles.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificAssaultRifles");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
    }

    public static LifeFormHumanSpecificAssaultRifles unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static LifeFormHumanSpecificAssaultRifles unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
}
