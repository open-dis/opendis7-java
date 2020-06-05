package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 519 marshal size 8<br>
 * Life Form-Human-Specific-Anti Tank Missiles
 */
public enum LifeFormHumanSpecificAntiTankMissiles 
{
    /** Other */
    OTHER (0, "Other"),
    /** 120mm Type 64 MAT KAM-3 */
    $120MM_TYPE_64_MAT_KAM_3 (30, "120mm Type 64 MAT KAM-3"),
    /** 153mm Type 79 Jyu-MAT KAM-9 */
    $153MM_TYPE_79_JYU_MAT_KAM_9 (31, "153mm Type 79 Jyu-MAT KAM-9"),
    /** 120mm Type 87 Chu-MAT */
    $120MM_TYPE_87_CHU_MAT (32, "120mm Type 87 Chu-MAT"),
    /** 140mm Type 01 LMAT */
    $140MM_TYPE_01_LMAT (33, "140mm Type 01 LMAT"),
    /** 140mm M47 Dragon */
    $140MM_M47_DRAGON (58, "140mm M47 Dragon"),
    /** 140mm Saeghe 1-2 */
    $140MM_SAEGHE_1_2 (59, "140mm Saeghe 1-2"),
    /** 127mm FGM-148 Javelin */
    $127MM_FGM_148_JAVELIN (60, "127mm FGM-148 Javelin"),
    /** 139mm FGM-172 SRAW */
    $139MM_FGM_172_SRAW (63, "139mm FGM-172 SRAW"),
    /** 139mm FGM-172B SRAW-MPV */
    $139MM_FGM_172B_SRAW_MPV (64, "139mm FGM-172B SRAW-MPV"),
    /** 152mm BGM-71 TOW */
    $152MM_BGM_71_TOW (68, "152mm BGM-71 TOW"),
    /** 152mm Orev TOW II */
    $152MM_OREV_TOW_II (69, "152mm Orev TOW II"),
    /** 120mm Vickers Vigilant / Clevite */
    $120MM_VICKERS_VIGILANT_CLEVITE (75, "120mm Vickers Vigilant / Clevite"),
    /** 110mm Bantam (Rb 53) */
    $110MM_BANTAM_RB_53 (80, "110mm Bantam (Rb 53)"),
    /** 150mm RBS-56 BILL 1 */
    $150MM_RBS_56_BILL_1 (81, "150mm RBS-56 BILL 1"),
    /** 150mm RBS-56-2 BILL 2 */
    $150MM_RBS_56_2_BILL_2 (82, "150mm RBS-56-2 BILL 2"),
    /** 130mm Spike SR */
    $130MM_SPIKE_SR (85, "130mm Spike SR"),
    /** 130mm Spike MR (CLU) */
    $130MM_SPIKE_MR_CLU (86, "130mm Spike MR (CLU)"),
    /** 130mm Spike LR (CLU) */
    $130MM_SPIKE_LR_CLU (87, "130mm Spike LR (CLU)"),
    /** 60mm Mosquito */
    $60MM_MOSQUITO (95, "60mm Mosquito"),
    /** 160mm SS.10 */
    $160MM_SS10 (98, "160mm SS.10"),
    /** 103mm MILAN */
    $103MM_MILAN (100, "103mm MILAN"),
    /** 115mm MILAN 2 */
    $115MM_MILAN_2 (101, "115mm MILAN 2"),
    /** 115mm MILAN 2T */
    $115MM_MILAN_2T (102, "115mm MILAN 2T"),
    /** 115mm MILAN 3 */
    $115MM_MILAN_3 (103, "115mm MILAN 3"),
    /** 115mm MILAN ER */
    $115MM_MILAN_ER (104, "115mm MILAN ER"),
    /** 136mm ERYX */
    $136MM_ERYX (105, "136mm ERYX"),
    /** 152mm Entac */
    $152MM_ENTAC (107, "152mm Entac"),
    /** 125mm RAAD */
    $125MM_RAAD (110, "125mm RAAD"),
    /** 125mm I-RAAD-T */
    $125MM_I_RAAD_T (111, "125mm I-RAAD-T"),
    /** 152mm Toophan */
    $152MM_TOOPHAN (112, "152mm Toophan"),
    /** 152mm Toophan 2 */
    $152MM_TOOPHAN_2 (113, "152mm Toophan 2"),
    /** 152mm Toophan 5 */
    $152MM_TOOPHAN_5 (114, "152mm Toophan 5"),
    /** 136mm Bumbar */
    $136MM_BUMBAR (120, "136mm Bumbar"),
    /** 130mm Shershen PK-2 */
    $130MM_SHERSHEN_PK_2 (125, "130mm Shershen PK-2"),
    /** 152mm Shershen-Q P-2B */
    $152MM_SHERSHEN_Q_P_2B (126, "152mm Shershen-Q P-2B"),
    /** 130mm Mectron MSS-1.2 */
    $130MM_MECTRON_MSS_12 (130, "130mm Mectron MSS-1.2"),
    /** 120mm HJ-8 */
    $120MM_HJ_8 (140, "120mm HJ-8"),
    /** 120mm HJ-8A */
    $120MM_HJ_8A (141, "120mm HJ-8A"),
    /** 120mm HJ-8B */
    $120MM_HJ_8B (142, "120mm HJ-8B"),
    /** 120mm HJ-8C */
    $120MM_HJ_8C (143, "120mm HJ-8C"),
    /** 120mm HJ-8D */
    $120MM_HJ_8D (144, "120mm HJ-8D"),
    /** 120mm HJ-8E */
    $120MM_HJ_8E (145, "120mm HJ-8E"),
    /** 120mm HJ-8F */
    $120MM_HJ_8F (146, "120mm HJ-8F"),
    /** 120mm HJ-8FAE */
    $120MM_HJ_8FAE (147, "120mm HJ-8FAE"),
    /** 120mm HJ-8L */
    $120MM_HJ_8L (148, "120mm HJ-8L"),
    /** 120mm HJ-8H */
    $120MM_HJ_8H (149, "120mm HJ-8H"),
    /** 120mm HJ-8S */
    $120MM_HJ_8S (150, "120mm HJ-8S"),
    /** 120mm Baktar-Shikan */
    $120MM_BAKTAR_SHIKAN (151, "120mm Baktar-Shikan"),
    /** 120mm HJ-11 (AFT-11) */
    $120MM_HJ_11_AFT_11 (152, "120mm HJ-11 (AFT-11)"),
    /** 152mm HJ-9A */
    $152MM_HJ_9A (153, "152mm HJ-9A"),
    /** 135mm HJ-12 Red Arrow */
    $135MM_HJ_12_RED_ARROW (154, "135mm HJ-12 Red Arrow"),
    /** 125mm HJ-73 MCLOS */
    $125MM_HJ_73_MCLOS (155, "125mm HJ-73 MCLOS"),
    /** 125mm HJ-73B SACLOS */
    $125MM_HJ_73B_SACLOS (156, "125mm HJ-73B SACLOS"),
    /** 125mm HJ-73C SACLOS ERA */
    $125MM_HJ_73C_SACLOS_ERA (157, "125mm HJ-73C SACLOS ERA"),
    /** 125mm AT-3 Sagger A/9M14 Malyutka */
    $125MM_AT_3_SAGGER_A_9M14_MALYUTKA (170, "125mm AT-3 Sagger A/9M14 Malyutka"),
    /** 125mm AT-3B Sagger B/9M14M Malyutka-M */
    $125MM_AT_3B_SAGGER_B_9M14M_MALYUTKA_M (171, "125mm AT-3B Sagger B/9M14M Malyutka-M"),
    /** 125mm AT-3C Sagger C/9M14P Malyutka-P */
    $125MM_AT_3C_SAGGER_C_9M14P_MALYUTKA_P (172, "125mm AT-3C Sagger C/9M14P Malyutka-P"),
    /** 125mm AT-3D Sagger D/9M14-2 Malyutka-2 */
    $125MM_AT_3D_SAGGER_D_9M14_2_MALYUTKA_2 (173, "125mm AT-3D Sagger D/9M14-2 Malyutka-2"),
    /** 125mm Susong-Po */
    $125MM_SUSONG_PO (174, "125mm Susong-Po"),
    /** 125mm AT-3C POLK */
    $125MM_AT_3C_POLK (175, "125mm AT-3C POLK"),
    /** 125mm Kun Wu 1 */
    $125MM_KUN_WU_1 (176, "125mm Kun Wu 1"),
    /** 125mm Maliutka M2T */
    $125MM_MALIUTKA_M2T (177, "125mm Maliutka M2T"),
    /** 120mm AT-4A Spigot A/9M111 Fagot */
    $120MM_AT_4A_SPIGOT_A_9M111_FAGOT (178, "120mm AT-4A Spigot A/9M111 Fagot"),
    /** 120mm AT-4B Spigot B/9M111-2 Fagot */
    $120MM_AT_4B_SPIGOT_B_9M111_2_FAGOT (179, "120mm AT-4B Spigot B/9M111-2 Fagot"),
    /** 120mm AT-4C Spigot C/9M111M Faktoriya */
    $120MM_AT_4C_SPIGOT_C_9M111M_FAKTORIYA (180, "120mm AT-4C Spigot C/9M111M Faktoriya"),
    /** 135mm AT-5A Spandrel/9M113 Kronkurs */
    $135MM_AT_5A_SPANDREL_9M113_KRONKURS (181, "135mm AT-5A Spandrel/9M113 Kronkurs"),
    /** 135mm AT-5B Spandrel/9M113M Kronkurs-M */
    $135MM_AT_5B_SPANDREL_9M113M_KRONKURS_M (182, "135mm AT-5B Spandrel/9M113M Kronkurs-M"),
    /** 135mm Tosan */
    $135MM_TOSAN (183, "135mm Tosan"),
    /** 94mm AT-7 Saxhorn/9K115 Metis */
    $94MM_AT_7_SAXHORN_9K115_METIS (184, "94mm AT-7 Saxhorn/9K115 Metis"),
    /** 130mm AT-13 Saxhorn-2/9K115-2 Metis-M */
    $130MM_AT_13_SAXHORN_2_9K115_2_METIS_M (185, "130mm AT-13 Saxhorn-2/9K115-2 Metis-M"),
    /** 152mm AT-14 Spriggan/9M133 Kornet */
    $152MM_AT_14_SPRIGGAN_9M133_KORNET (186, "152mm AT-14 Spriggan/9M133 Kornet"),
    /** 152mm Dehlavie */
    $152MM_DEHLAVIE (187, "152mm Dehlavie"),
    /** 102mm Mathogo */
    $102MM_MATHOGO (200, "102mm Mathogo");

    private int value;
    private final String description;

    LifeFormHumanSpecificAntiTankMissiles(int value, String description)
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

    public static LifeFormHumanSpecificAntiTankMissiles getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificAntiTankMissiles val: LifeFormHumanSpecificAntiTankMissiles.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificAntiTankMissiles");
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

    public static LifeFormHumanSpecificAntiTankMissiles unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormHumanSpecificAntiTankMissiles unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormHumanSpecificAntiTankMissiles: " + name() + ": " + getValue(); 
    }
}
