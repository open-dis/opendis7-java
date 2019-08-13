package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 17 marshal size 8<br>
 * Life Forms-Subcategory-C.I.S. Weapons
 */
public enum LifeFormsSubcategoryCISWeapons implements SubCategory
{
    /** Automatic (APS) 9-mm, Stechkin */
    AUTOMATIC_APS_9_MM_STECHKIN (201, "Automatic (APS) 9-mm, Stechkin"),
    /** PSM 5.45-mm */
    PSM_545_MM (202, "PSM 5.45-mm"),
    /** Self-loading (PM) 9-mm, Makarov */
    SELF_LOADING_PM_9_MM_MAKAROV (203, "Self-loading (PM) 9-mm, Makarov"),
    /** TT-33 7.62-mm, Tokarev */
    TT_33_762_MM_TOKAREV (204, "TT-33 7.62-mm, Tokarev"),
    /** Assault rifle AK and AKM, 7.62-mm */
    ASSAULT_RIFLE_AK_AND_AKM_762_MM (205, "Assault rifle AK and AKM, 7.62-mm"),
    /** Assault rifle AK-74 and AKS-74, 5.45-mm */
    ASSAULT_RIFLE_AK_74_AND_AKS_74_545_MM (206, "Assault rifle AK-74 and AKS-74, 5.45-mm"),
    /** Self-loading rifle (SKS), 7.62-mm, Simonov */
    SELF_LOADING_RIFLE_SKS_762_MM_SIMONOV (207, "Self-loading rifle (SKS), 7.62-mm, Simonov"),
    /** Sniper rifle SVD 7.62-mm, Dragunov */
    SNIPER_RIFLE_SVD_762_MM_DRAGUNOV (208, "Sniper rifle SVD 7.62-mm, Dragunov"),
    /** AKSU-74 5.45-mm */
    AKSU_74_545_MM (209, "AKSU-74 5.45-mm"),
    /** PPS-43 7.62-mm */
    PPS_43_762_MM (210, "PPS-43 7.62-mm"),
    /** PPSh-41 7.62-mm */
    PPSH_41_762_MM (211, "PPSh-41 7.62-mm"),
    /** General purpose PK 7.62-mm */
    GENERAL_PURPOSE_PK_762_MM (212, "General purpose PK 7.62-mm"),
    /** Heavy DShK-38 and Model 38/46 12.7-mm, Degtyarev */
    HEAVY_DSHK_38_AND_MODEL_38_46_127_MM_DEGTYAREV (213, "Heavy DShK-38 and Model 38/46 12.7-mm, Degtyarev"),
    /** Heavy NSV 12.7-mm */
    HEAVY_NSV_127_MM (214, "Heavy NSV 12.7-mm"),
    /** Light RPD 7.62-mm */
    LIGHT_RPD_762_MM (215, "Light RPD 7.62-mm"),
    /** Light RPK 7.62-mm */
    LIGHT_RPK_762_MM (216, "Light RPK 7.62-mm"),
    /** Light RPK-74 5.45-mm */
    LIGHT_RPK_74_545_MM (217, "Light RPK-74 5.45-mm"),
    /** Hand grenade M75 */
    HAND_GRENADE_M75 (218, "Hand grenade M75"),
    /** Hand grenade RGD-5 */
    HAND_GRENADE_RGD_5 (219, "Hand grenade RGD-5"),
    /** AP hand grenade F1 */
    AP_HAND_GRENADE_F1 (220, "AP hand grenade F1"),
    /** AT hand grenade RKG-3 */
    AT_HAND_GRENADE_RKG_3 (221, "AT hand grenade RKG-3"),
    /** AT hand grenade RKG-3M */
    AT_HAND_GRENADE_RKG_3M (222, "AT hand grenade RKG-3M"),
    /** AT hand grenade RKG-3T */
    AT_HAND_GRENADE_RKG_3T (223, "AT hand grenade RKG-3T"),
    /** Fragmentation hand grenade RGN */
    FRAGMENTATION_HAND_GRENADE_RGN (224, "Fragmentation hand grenade RGN"),
    /** Fragmentation hand grenade RGO */
    FRAGMENTATION_HAND_GRENADE_RGO (225, "Fragmentation hand grenade RGO"),
    /** Smoke hand grenade RDG-1 */
    SMOKE_HAND_GRENADE_RDG_1 (226, "Smoke hand grenade RDG-1"),
    /** Plamya launcher, 30-mm AGS-17 */
    PLAMYA_LAUNCHER_30_MM_AGS_17 (227, "Plamya launcher, 30-mm AGS-17"),
    /** Rifle-mounted launcher, BG-15 40-mm */
    RIFLE_MOUNTED_LAUNCHER_BG_15_40_MM (228, "Rifle-mounted launcher, BG-15 40-mm"),
    /** LPO-50 */
    LPO_50 (229, "LPO-50"),
    /** ROKS-3 */
    ROKS_3 (230, "ROKS-3"),
    /** Cart-mounted TPO-50 */
    CART_MOUNTED_TPO_50 (231, "Cart-mounted TPO-50"),
    /** Gimlet SA-16 */
    GIMLET_SA_16 (232, "Gimlet SA-16"),
    /** Grail SA-7 */
    GRAIL_SA_7 (233, "Grail SA-7"),
    /** Gremlin SA-14 */
    GREMLIN_SA_14 (234, "Gremlin SA-14"),
    /** Sagger AT-3 (MCLOS) */
    SAGGER_AT_3_MCLOS (235, "Sagger AT-3 (MCLOS)"),
    /** Saxhorn AT-7 */
    SAXHORN_AT_7 (236, "Saxhorn AT-7"),
    /** Spigot A/B AT-14 */
    SPIGOT_A_B_AT_14 (237, "Spigot A/B AT-14"),
    /** SA-18 */
    SA_18 (238, "SA-18"),
    /** SA-19 */
    SA_19 (239, "SA-19"),
    /** Grad-1P manportable tripod rocket launcher, 122-mm (for Spesnatz and other specialists; aka 9P132) */
    GRAD_1P_MANPORTABLE_TRIPOD_ROCKET_LAUNCHER_122_MM_FOR_SPESNATZ_AND_OTHER_SPECIALISTS_AKA_9P132 (240, "Grad-1P manportable tripod rocket launcher, 122-mm (for Spesnatz and other specialists; aka 9P132)"),
    /** Light Anti-Armor weapon RPG-18 */
    LIGHT_ANTI_ARMOR_WEAPON_RPG_18 (241, "Light Anti-Armor weapon RPG-18"),
    /** Light Anti-Tank weapon RPG-22 */
    LIGHT_ANTI_TANK_WEAPON_RPG_22 (242, "Light Anti-Tank weapon RPG-22"),
    /** MG and RPG */
    MG_RPG (243, "MG & RPG"),
    /** Portable rocket launcher RPG-16 */
    PORTABLE_ROCKET_LAUNCHER_RPG_16 (244, "Portable rocket launcher RPG-16"),
    /** Recoilless gun 73-mm SPG-9 */
    RECOILLESS_GUN_73_MM_SPG_9 (245, "Recoilless gun 73-mm SPG-9"),
    /** VAT rocket launcher RPG-7 */
    VAT_ROCKET_LAUNCHER_RPG_7 (246, "VAT rocket launcher RPG-7"),
    /** Mon-50 Anti-Personnel mine */
    MON_50_ANTI_PERSONNEL_MINE (248, "Mon-50 Anti-Personnel mine"),
    /** RPG-29 Vampir */
    RPG_29_VAMPIR (249, "RPG-29 Vampir"),
    /** Laser Designator */
    LASER_DESIGNATOR (250, "Laser Designator"),
    /** AT-4 Spigot */
    AT_4_SPIGOT (251, "AT-4 Spigot"),
    /** SA-24 Igla-S */
    SA_24_IGLA_S (252, "SA-24 Igla-S"),
    /** Type 69 RPG */
    TYPE_69_RPG (253, "Type 69 RPG");

    private int value;
    private final String description;

    LifeFormsSubcategoryCISWeapons(int value, String description)
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

    public static LifeFormsSubcategoryCISWeapons getEnumForValue(int i)
    {
       for(LifeFormsSubcategoryCISWeapons val: LifeFormsSubcategoryCISWeapons.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormsSubcategoryCISWeapons");
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

    public static LifeFormsSubcategoryCISWeapons unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static LifeFormsSubcategoryCISWeapons unmarshalEnum(ByteBuffer buff) throws Exception
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
