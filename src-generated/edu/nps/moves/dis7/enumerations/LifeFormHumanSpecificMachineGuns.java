package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 516 marshal size 8<br>
 * Life Form-Human-Specific-Machine Guns
 */
public enum LifeFormHumanSpecificMachineGuns 
{
    /** Other */
    OTHER (0, "Other"),
    /** 5.56x45mm XM214 Microgun Six-Pak */
    $556X45MM_XM214_MICROGUN_SIX_PAK (10, "5.56x45mm XM214 Microgun Six-Pak"),
    /** 7.62x51mm M134/XM196 Minigun */
    $762X51MM_M134_XM196_MINIGUN (11, "7.62x51mm M134/XM196 Minigun"),
    /** 5.56x45mm M249/FN Minimi SAW/LMG */
    $556X45MM_M249_FN_MINIMI_SAW_LMG (20, "5.56x45mm M249/FN Minimi SAW/LMG"),
    /** 5.56x45mm FN Minimi Mk3 LMG */
    $556X45MM_FN_MINIMI_MK3_LMG (21, "5.56x45mm FN Minimi Mk3 LMG"),
    /** 7.62x51mm FN Minimi 7.62 Mk3 GPMG */
    $762X51MM_FN_MINIMI_762_MK3_GPMG (22, "7.62x51mm FN Minimi 7.62 Mk3 GPMG"),
    /** 7.62x63mm M1941 Johnson */
    $762X63MM_M1941_JOHNSON (25, "7.62x63mm M1941 Johnson"),
    /** 7.62x63mm M1918 BAR */
    $762X63MM_M1918_BAR (26, "7.62x63mm M1918 BAR"),
    /** 7.62x51mm M1919A4/Mk 21 Mod 0 Browning MMG */
    $762X51MM_M1919A4_MK_21_MOD_0_BROWNING_MMG (27, "7.62x51mm M1919A4/Mk 21 Mod 0 Browning MMG"),
    /** 7.62x63mm M1919A6 Browning MMG */
    $762X63MM_M1919A6_BROWNING_MMG (28, "7.62x63mm M1919A6 Browning MMG"),
    /** 7.62x51mm M37 Browning MMG */
    $762X51MM_M37_BROWNING_MMG (29, "7.62x51mm M37 Browning MMG"),
    /** 5.56x45mm Ares Shrike 5.56 LMG */
    $556X45MM_ARES_SHRIKE_556_LMG (30, "5.56x45mm Ares Shrike 5.56 LMG"),
    /** 5.56x45mm LSAT LMG */
    $556X45MM_LSAT_LMG (31, "5.56x45mm LSAT LMG"),
    /** 5.56x45mm CMG-1 LMG */
    $556X45MM_CMG_1_LMG (32, "5.56x45mm CMG-1 LMG"),
    /** 5.56x45mm CMG-2 LMG */
    $556X45MM_CMG_2_LMG (33, "5.56x45mm CMG-2 LMG"),
    /** 5.56x45mm Stoner 63A LMG */
    $556X45MM_STONER_63A_LMG (34, "5.56x45mm Stoner 63A LMG"),
    /** 5.56x45mm Ultimax 100 LMG */
    $556X45MM_ULTIMAX_100_LMG (35, "5.56x45mm Ultimax 100 LMG"),
    /** 5.56x54mm Beretta AS70/90 LMG */
    $556X54MM_BERETTA_AS70_90_LMG (36, "5.56x54mm Beretta AS70/90 LMG"),
    /** 5.56x45mm CETME Ameli LMG */
    $556X45MM_CETME_AMELI_LMG (37, "5.56x45mm CETME Ameli LMG"),
    /** 5.56x45mm IMI Negev LMG */
    $556X45MM_IMI_NEGEV_LMG (38, "5.56x45mm IMI Negev LMG"),
    /** 5.56x45mm INSAS LMG */
    $556X45MM_INSAS_LMG (39, "5.56x45mm INSAS LMG"),
    /** 5.56x45mm AUG LMG */
    $556X45MM_AUG_LMG (40, "5.56x45mm AUG LMG"),
    /** 5.56x45mm AUG HBAR LMG */
    $556X45MM_AUG_HBAR_LMG (41, "5.56x45mm AUG HBAR LMG"),
    /** 5.56x45mm HK MG4 LMG */
    $556X45MM_HK_MG4_LMG (43, "5.56x45mm HK MG4 LMG"),
    /** 5.56x45mm HK23/GR-9 LMG */
    $556X45MM_HK23_GR_9_LMG (44, "5.56x45mm HK23/GR-9 LMG"),
    /** 5.56x45mm M27 IAR SAW */
    $556X45MM_M27_IAR_SAW (46, "5.56x45mm M27 IAR SAW"),
    /** 5.56x45mm L86 LSW */
    $556X45MM_L86_LSW (47, "5.56x45mm L86 LSW"),
    /** 5.56x45mm Daewoo K3 LMG */
    $556X45MM_DAEWOO_K3_LMG (48, "5.56x45mm Daewoo K3 LMG"),
    /** 5.56x45mm Vector Mini SS GPMG */
    $556X45MM_VECTOR_MINI_SS_GPMG (49, "5.56x45mm Vector Mini SS GPMG"),
    /** 7.62x51mm M60 GPMG */
    $762X51MM_M60_GPMG (50, "7.62x51mm M60 GPMG"),
    /** 7.62x51mm M60E3 GPMG */
    $762X51MM_M60E3_GPMG (51, "7.62x51mm M60E3 GPMG"),
    /** 7.62x51mm M60E4 GPMG */
    $762X51MM_M60E4_GPMG (52, "7.62x51mm M60E4 GPMG"),
    /** 7.62x51mm M60E6 GPMG */
    $762X51MM_M60E6_GPMG (53, "7.62x51mm M60E6 GPMG"),
    /** 7.62x51mm Mark 48 GMPG */
    $762X51MM_MARK_48_GMPG (55, "7.62x51mm Mark 48 GMPG"),
    /** 7.62x51mm M240/FN MAG 58 GPMG */
    $762X51MM_M240_FN_MAG_58_GPMG (58, "7.62x51mm M240/FN MAG 58 GPMG"),
    /** 7.62x51mm M240E4/M240B GPMG */
    $762X51MM_M240E4_M240B_GPMG (59, "7.62x51mm M240E4/M240B GPMG"),
    /** 7.62x51mm M240E1/M240D GPMG */
    $762X51MM_M240E1_M240D_GPMG (60, "7.62x51mm M240E1/M240D GPMG"),
    /** 7.62x51mm M240G GPMG */
    $762X51MM_M240G_GPMG (61, "7.62x51mm M240G GPMG"),
    /** 7.62x51mm M240E5/M240H GPMG */
    $762X51MM_M240E5_M240H_GPMG (62, "7.62x51mm M240E5/M240H GPMG"),
    /** 7.62x51mm M240L GPMG */
    $762X51MM_M240L_GPMG (63, "7.62x51mm M240L GPMG"),
    /** 7.62x39mm Kk 62 LMG */
    $762X39MM_KK_62_LMG (65, "7.62x39mm Kk 62 LMG"),
    /** 7.62x51mm Vector SS-77 GPMG */
    $762X51MM_VECTOR_SS_77_GPMG (70, "7.62x51mm Vector SS-77 GPMG"),
    /** 7.62x51mm SIG MG 710-3 GPMG */
    $762X51MM_SIG_MG_710_3_GPMG (71, "7.62x51mm SIG MG 710-3 GPMG"),
    /** 7.62x51mm Sterling 7.62 GMPG */
    $762X51MM_STERLING_762_GMPG (72, "7.62x51mm Sterling 7.62 GMPG"),
    /** 7.62x51mm Sumitomo Type-62 GPMG */
    $762X51MM_SUMITOMO_TYPE_62_GPMG (73, "7.62x51mm Sumitomo Type-62 GPMG"),
    /** 7.62x51mm Daewoo K12 GPMG */
    $762X51MM_DAEWOO_K12_GPMG (74, "7.62x51mm Daewoo K12 GPMG"),
    /** 7.62x51mm MG 51 GPMG */
    $762X51MM_MG_51_GPMG (75, "7.62x51mm MG 51 GPMG"),
    /** 7.62x51mm Rheinmetall MG 3 */
    $762X51MM_RHEINMETALL_MG_3 (76, "7.62x51mm Rheinmetall MG 3"),
    /** 7.62x51mm Rheinmetall MG 3KWS */
    $762X51MM_RHEINMETALL_MG_3KWS (77, "7.62x51mm Rheinmetall MG 3KWS"),
    /** 7.62x51mm MG5/HK121 GPMG */
    $762X51MM_MG5_HK121_GPMG (80, "7.62x51mm MG5/HK121 GPMG"),
    /** 7.62x51mm HK21 GPMG */
    $762X51MM_HK21_GPMG (81, "7.62x51mm HK21 GPMG"),
    /** 7.62x51mm AA-52 GPMP */
    $762X51MM_AA_52_GPMP (85, "7.62x51mm AA-52 GPMP"),
    /** 7.62x51mm UKM-2000 GPMG */
    $762X51MM_UKM_2000_GPMG (86, "7.62x51mm UKM-2000 GPMG"),
    /** 7.62x54mm Uk vz. 59 GPMG */
    $762X54MM_UK_VZ_59_GPMG (88, "7.62x54mm Uk vz. 59 GPMG"),
    /** 7.92x57mm MG 42 GPMG */
    $792X57MM_MG_42_GPMG (89, "7.92x57mm MG 42 GPMG"),
    /** 12.7x99mm M2A1 Browning HMG */
    $127X99MM_M2A1_BROWNING_HMG (100, "12.7x99mm M2A1 Browning HMG"),
    /** 12.7x99mm M2HB Browning HMG */
    $127X99MM_M2HB_BROWNING_HMG (101, "12.7x99mm M2HB Browning HMG"),
    /** 12.7x99mm M2HB-QCB Browning HMG */
    $127X99MM_M2HB_QCB_BROWNING_HMG (102, "12.7x99mm M2HB-QCB Browning HMG"),
    /** 12.7x99mm M85C HMG */
    $127X99MM_M85C_HMG (105, "12.7x99mm M85C HMG"),
    /** 12.7x99mm Rheinmetall RMG.50 HMG */
    $127X99MM_RHEINMETALL_RMG50_HMG (108, "12.7x99mm Rheinmetall RMG.50 HMG"),
    /** 12.7x99mm HK25 HMG */
    $127X99MM_HK25_HMG (110, "12.7x99mm HK25 HMG"),
    /** 12.7x99mm CIS 50MG */
    $127X99MM_CIS_50MG (112, "12.7x99mm CIS 50MG"),
    /** 5.45x39mm IP-2 LMG */
    $545X39MM_IP_2_LMG (120, "5.45x39mm IP-2 LMG"),
    /** 5.45x39mm Nikonov LMG */
    $545X39MM_NIKONOV_LMG (121, "5.45x39mm Nikonov LMG"),
    /** 5.45x39mm M74 RPK */
    $545X39MM_M74_RPK (122, "5.45x39mm M74 RPK"),
    /** 7.62x39mm M43 RPK */
    $762X39MM_M43_RPK (125, "7.62x39mm M43 RPK"),
    /** 7.62x39mm RPD SAW */
    $762X39MM_RPD_SAW (126, "7.62x39mm RPD SAW"),
    /** 7.62x39mm Zastava M72 */
    $762X39MM_ZASTAVA_M72 (127, "7.62x39mm Zastava M72"),
    /** 7.62x39mm Type-81 LMG */
    $762X39MM_TYPE_81_LMG (128, "7.62x39mm Type-81 LMG"),
    /** 7.62x51mm Zastava M77 */
    $762X51MM_ZASTAVA_M77 (135, "7.62x51mm Zastava M77"),
    /** 7.62x54mm PK GPMG */
    $762X54MM_PK_GPMG (140, "7.62x54mm PK GPMG"),
    /** 7.62x54mm AEK-999 GPMP */
    $762X54MM_AEK_999_GPMP (141, "7.62x54mm AEK-999 GPMP"),
    /** 7.62x54mm Pecheneg GPMG */
    $762X54MM_PECHENEG_GPMG (142, "7.62x54mm Pecheneg GPMG"),
    /** 7.62x54mm Zastava M84 */
    $762X54MM_ZASTAVA_M84 (143, "7.62x54mm Zastava M84"),
    /** 7.62x54mm Type-67 GPMG */
    $762X54MM_TYPE_67_GPMG (144, "7.62x54mm Type-67 GPMG"),
    /** 7.62x54mm Type-80 GPMG */
    $762X54MM_TYPE_80_GPMG (145, "7.62x54mm Type-80 GPMG"),
    /** 12.7x108mm NSV HMG */
    $127X108MM_NSV_HMG (150, "12.7x108mm NSV HMG"),
    /** 12.7x108mm Kord HMG */
    $127X108MM_KORD_HMG (151, "12.7x108mm Kord HMG"),
    /** 12.7x108mm KPD-12.7 HMG */
    $127X108MM_KPD_127_HMG (152, "12.7x108mm KPD-12.7 HMG"),
    /** 12.7x108mm Zastava M02 Coyotoe HMG */
    $127X108MM_ZASTAVA_M02_COYOTOE_HMG (153, "12.7x108mm Zastava M02 Coyotoe HMG"),
    /** 12.7x108mm Zastava M87 */
    $127X108MM_ZASTAVA_M87 (154, "12.7x108mm Zastava M87"),
    /** 12.7x108mm Type-77 HMG */
    $127X108MM_TYPE_77_HMG (155, "12.7x108mm Type-77 HMG"),
    /** 12.7x108mm W85 HMG */
    $127X108MM_W85_HMG (156, "12.7x108mm W85 HMG"),
    /** 12.7x108mm Type-90 HMG */
    $127X108MM_TYPE_90_HMG (157, "12.7x108mm Type-90 HMG"),
    /** 5.8x42mm QJY-88 LMG */
    $58X42MM_QJY_88_LMG (164, "5.8x42mm QJY-88 LMG"),
    /** 5.8x42mm QBB-95 DBP87 LMG */
    $58X42MM_QBB_95_DBP87_LMG (165, "5.8x42mm QBB-95 DBP87 LMG"),
    /** 5.56x45mm QBB-95-1 LMG */
    $556X45MM_QBB_95_1_LMG (166, "5.56x45mm QBB-95-1 LMG");

    private int value;
    private final String description;

    LifeFormHumanSpecificMachineGuns(int value, String description)
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

    public static LifeFormHumanSpecificMachineGuns getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificMachineGuns val: LifeFormHumanSpecificMachineGuns.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificMachineGuns");
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

    public static LifeFormHumanSpecificMachineGuns unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormHumanSpecificMachineGuns unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "LifeFormHumanSpecificMachineGuns: " + name() + ": " + getValue(); 
    }
}
