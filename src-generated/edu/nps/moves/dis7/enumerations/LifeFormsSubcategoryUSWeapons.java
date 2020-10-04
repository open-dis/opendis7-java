package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 16 marshal size 8<br>
 * LifeFormsSubcategoryUSWeapons
 */
public enum LifeFormsSubcategoryUSWeapons implements SubCategory
{
    /** Assault machine pistol, KF-AMP */
    ASSAULT_MACHINE_PISTOL_KF_AMP (1, "Assault machine pistol, KF-AMP"),
    /** Automatic model 1911A1 .45 */
    AUTOMATIC_MODEL_1911A1_45 (2, "Automatic model 1911A1 .45"),
    /** Combat Master Mark VI .45, Detronics */
    COMBAT_MASTER_MARK_VI_45_DETRONICS (3, "Combat Master Mark VI .45, Detronics"),
    /** De-cocker KP90DC .45 */
    DE_COCKER_KP90DC_45 (4, "De-cocker KP90DC .45"),
    /** De-cocker KP91DC .40 */
    DE_COCKER_KP91DC_40 (5, "De-cocker KP91DC .40"),
    /** General officers Model 15 .45 */
    GENERAL_OFFICERS_MODEL_15_45 (6, "General officers Model 15 .45"),
    /** Nova 9-mm, LaFrance */
    NOVA_9_MM_LAFRANCE (7, "Nova 9-mm, LaFrance"),
    /** Personal Defense Weapon MP5K-PDW 9-mm */
    PERSONAL_DEFENSE_WEAPON_MP5K_PDW_9_MM (8, "Personal Defense Weapon MP5K-PDW 9-mm"),
    /** Silenced Colt .45, LaFrance */
    SILENCED_COLT_45_LAFRANCE (9, "Silenced Colt .45, LaFrance"),
    /** 5900-series 9-mm, Smith and Wesson (SandW) */
    _5900_SERIES_9_MM_SMITH_WESSON_SW (10, "5900-series 9-mm, Smith & Wesson (S&W)"),
    /** M9 */
    M9 (11, "M9"),
    /** Model 1911A1, Springfield Armory */
    MODEL_1911A1_SPRINGFIELD_ARMORY (12, "Model 1911A1, Springfield Armory"),
    /** Model 2000 9-mm */
    MODEL_2000_9_MM (13, "Model 2000 9-mm"),
    /** P-9 9-mm, Springfield Armory */
    P_9_9_MM_SPRINGFIELD_ARMORY (14, "P-9 9-mm, Springfield Armory"),
    /** P-12 9-mm */
    P_12_9_MM (15, "P-12 9-mm"),
    /** P-85 Mark II 9-mm, Ruger */
    P_85_MARK_II_9_MM_RUGER (16, "P-85 Mark II 9-mm, Ruger"),
    /** Advanced Combat Rifle 5.56-mm, AAI */
    ADVANCED_COMBAT_RIFLE_556_MM_AAI (17, "Advanced Combat Rifle 5.56-mm, AAI"),
    /** Commando assault rifle, Model 733 5.56-mm, Colt */
    COMMANDO_ASSAULT_RIFLE_MODEL_733_556_MM_COLT (18, "Commando assault rifle, Model 733 5.56-mm, Colt"),
    /** Infantry rifle, Mini-14/20 GB 5.56-mm, Ruger */
    INFANTRY_RIFLE_MINI_14_20_GB_556_MM_RUGER (19, "Infantry rifle, Mini-14/20 GB 5.56-mm, Ruger"),
    /** Mini-14 5.56-mm, Ruger */
    MINI_14_556_MM_RUGER (20, "Mini-14 5.56-mm, Ruger"),
    /** Mini Thirty 7.62-mm, Ruger */
    MINI_THIRTY_762_MM_RUGER (21, "Mini Thirty 7.62-mm, Ruger"),
    /** Semi-automatic model 82A2 .50, Barrett */
    SEMI_AUTOMATIC_MODEL_82A2_50_BARRETT (22, "Semi-automatic model 82A2 .50, Barrett"),
    /** Sniper Weapon System M24 7.62-mm */
    SNIPER_WEAPON_SYSTEM_M24_762_MM (23, "Sniper Weapon System M24 7.62-mm"),
    /** Sniping rifle M21, Springfield Armory */
    SNIPING_RIFLE_M21_SPRINGFIELD_ARMORY (24, "Sniping rifle M21, Springfield Armory"),
    /** Sniping rifle M40A1 7.62-mm */
    SNIPING_RIFLE_M40A1_762_MM (25, "Sniping rifle M40A1 7.62-mm"),
    /** Sniping rifle M600 7.62-mm */
    SNIPING_RIFLE_M600_762_MM (26, "Sniping rifle M600 7.62-mm"),
    /** AR-15 (M16) 5.56-mm */
    AR_15_M16_556_MM (27, "AR-15 (M16) 5.56-mm"),
    /** M1 .30 */
    M1_30 (28, "M1 .30"),
    /** M14 7.62-mm, NATO */
    M14_762_MM_NATO (29, "M14 7.62-mm, NATO"),
    /** M14 (M1A, M1A1-A1), Springfield Armory */
    M14_M1A_M1A1_A1_SPRINGFIELD_ARMORY (30, "M14 (M1A, M1A1-A1), Springfield Armory"),
    /** M14K assault rifle, LaFrance */
    M14K_ASSAULT_RIFLE_LAFRANCE (31, "M14K assault rifle, LaFrance"),
    /** M16A2 assault rifle 5.56-mm, Colt */
    M16A2_ASSAULT_RIFLE_556_MM_COLT (32, "M16A2 assault rifle 5.56-mm, Colt"),
    /** M21 7.62-mm, U.S. */
    M21_762_MM_US (33, "M21 7.62-mm, U.S."),
    /** M77 Mark II 5.56-mm, Ruger */
    M77_MARK_II_556_MM_RUGER (34, "M77 Mark II 5.56-mm, Ruger"),
    /** M77V 7.62-mm, Ruger */
    M77V_762_MM_RUGER (35, "M77V 7.62-mm, Ruger"),
    /** S-16 7.62 x 36-mm, Grendel */
    S_16_762_X_36_MM_GRENDEL (36, "S-16 7.62 x 36-mm, Grendel"),
    /** SAR-8 7.62-mm */
    SAR_8_762_MM (37, "SAR-8 7.62-mm"),
    /** SAR-4800 7.62-mm */
    SAR_4800_762_MM (38, "SAR-4800 7.62-mm"),
    /** Assault carbine M16K, LaFrance */
    ASSAULT_CARBINE_M16K_LAFRANCE (39, "Assault carbine M16K, LaFrance"),
    /** M1 .30 */
    M1_30_2 (40, "M1 .30"),
    /** M4 (Model 720) 5.56-mm, Colt */
    M4_MODEL_720_556_MM_COLT (41, "M4 (Model 720) 5.56-mm, Colt"),
    /** M-900 9-mm, Calico */
    M_900_9_MM_CALICO (42, "M-900 9-mm, Calico"),
    /** AC-556F 5.56-mm, Ruger */
    AC_556F_556_MM_RUGER (43, "AC-556F 5.56-mm, Ruger"),
    /** M3 .45 */
    M3_45 (44, "M3 .45"),
    /** M11, Cobray */
    M11_COBRAY (45, "M11, Cobray"),
    /** M951 9-mm, Calico */
    M951_9_MM_CALICO (46, "M951 9-mm, Calico"),
    /** MP5/10 10-mm */
    MP5_10_10_MM (47, "MP5/10 10-mm"),
    /** 9-mm, Colt */
    _9_MM_COLT (48, "9-mm, Colt"),
    /** Ingram */
    INGRAM (49, "Ingram"),
    /** Externally powered (EPG) 7.62-mm, Ares */
    EXTERNALLY_POWERED_EPG_762_MM_ARES (50, "Externally powered (EPG) 7.62-mm, Ares"),
    /** GECAL 50 */
    GECAL_50 (51, "GECAL 50"),
    /** General purpose M60 7.62-mm */
    GENERAL_PURPOSE_M60_762_MM (52, "General purpose M60 7.62-mm"),
    /** Heavy M2HB-QCB .50, RAMO */
    HEAVY_M2HB_QCB_50_RAMO (53, "Heavy M2HB-QCB .50, RAMO"),
    /** Light assault M60E3 (Enhanced) 7.62-mm */
    LIGHT_ASSAULT_M60E3_ENHANCED_762_MM (54, "Light assault M60E3 (Enhanced) 7.62-mm"),
    /** Light M16A2 5.56-mm, Colt */
    LIGHT_M16A2_556_MM_COLT (55, "Light M16A2 5.56-mm, Colt"),
    /** Light 5.56-mm, Ares */
    LIGHT_556_MM_ARES (56, "Light 5.56-mm, Ares"),
    /** Lightweight M2 .50, RAMO */
    LIGHTWEIGHT_M2_50_RAMO (57, "Lightweight M2 .50, RAMO"),
    /** Lightweight assault M60E3 7.62-mm */
    LIGHTWEIGHT_ASSAULT_M60E3_762_MM (58, "Lightweight assault M60E3 7.62-mm"),
    /** Minigun M134 7.62-mm, General Electric */
    MINIGUN_M134_762_MM_GENERAL_ELECTRIC (59, "Minigun M134 7.62-mm, General Electric"),
    /** MG system MK19 Mod 3, 40-mm */
    MG_SYSTEM_MK19_MOD_3_40_MM (60, "MG system MK19 Mod 3, 40-mm"),
    /** MG system (or kit) M2HB QCB .50, Saco Defense */
    MG_SYSTEM_OR_KIT_M2HB_QCB_50_SACO_DEFENSE (61, "MG system (or kit) M2HB QCB .50, Saco Defense"),
    /** M1919A4 .30-cal, Browning */
    M1919A4_30_CAL_BROWNING (62, "M1919A4 .30-cal, Browning"),
    /** .50-cal, Browning */
    _50_CAL_BROWNING (63, ".50-cal, Browning"),
    /** Colored-smoke hand grenade M18 */
    COLORED_SMOKE_HAND_GRENADE_M18 (64, "Colored-smoke hand grenade M18"),
    /** Colored-smoke grenades, Federal Laboratories */
    COLORED_SMOKE_GRENADES_FEDERAL_LABORATORIES (65, "Colored-smoke grenades, Federal Laboratories"),
    /** Infrared smoke grenade M76 */
    INFRARED_SMOKE_GRENADE_M76 (66, "Infrared smoke grenade M76"),
    /** Smoke hand grenade AN-M8 HC */
    SMOKE_HAND_GRENADE_AN_M8_HC (67, "Smoke hand grenade AN-M8 HC"),
    /** Delay fragmentation hand grenade M61 */
    DELAY_FRAGMENTATION_HAND_GRENADE_M61 (68, "Delay fragmentation hand grenade M61"),
    /** Delay fragmentation hand grenade M67 */
    DELAY_FRAGMENTATION_HAND_GRENADE_M67 (69, "Delay fragmentation hand grenade M67"),
    /** Impact fragmentation hand grenade M57 */
    IMPACT_FRAGMENTATION_HAND_GRENADE_M57 (70, "Impact fragmentation hand grenade M57"),
    /** Impact fragmentation hand grenade M68 */
    IMPACT_FRAGMENTATION_HAND_GRENADE_M68 (71, "Impact fragmentation hand grenade M68"),
    /** Incendiary hand grenade AN-M14 TH3 */
    INCENDIARY_HAND_GRENADE_AN_M14_TH3 (72, "Incendiary hand grenade AN-M14 TH3"),
    /** Launcher I-M203 40-mm */
    LAUNCHER_I_M203_40_MM (73, "Launcher I-M203 40-mm"),
    /** Launcher M79 40-mm */
    LAUNCHER_M79_40_MM (74, "Launcher M79 40-mm"),
    /** Multiple grenade launcher MM-1 40-mm */
    MULTIPLE_GRENADE_LAUNCHER_MM_1_40_MM (75, "Multiple grenade launcher MM-1 40-mm"),
    /** Multi-shot portable flame weapon M202A2 66-mm */
    MULTI_SHOT_PORTABLE_FLAME_WEAPON_M202A2_66_MM (76, "Multi-shot portable flame weapon M202A2 66-mm"),
    /** Portable ABC-M9-7 */
    PORTABLE_ABC_M9_7 (77, "Portable ABC-M9-7"),
    /** Portable M2A1-7 */
    PORTABLE_M2A1_7 (78, "Portable M2A1-7"),
    /** Portable M9E1-7 */
    PORTABLE_M9E1_7 (79, "Portable M9E1-7"),
    /** Dragon medium Anti-Armor missile, M47, FGM-77A */
    DRAGON_MEDIUM_ANTI_ARMOR_MISSILE_M47_FGM_77A (80, "Dragon medium Anti-Armor missile, M47, FGM-77A"),
    /** Javelin AAWS-M */
    JAVELIN_AAWS_M (81, "Javelin AAWS-M"),
    /** Light Anti-Tank Weapon M72 (LAW II) */
    LIGHT_ANTI_TANK_WEAPON_M72_LAW_II (82, "Light Anti-Tank Weapon M72 (LAW II)"),
    /** Redeye, FIM-43, General Dynamics */
    REDEYE_FIM_43_GENERAL_DYNAMICS (83, "Redeye, FIM-43, General Dynamics"),
    /** Saber dual-purpose missile system */
    SABER_DUAL_PURPOSE_MISSILE_SYSTEM (84, "Saber dual-purpose missile system"),
    /** Stinger, FIM-92, General Dynamics */
    STINGER_FIM_92_GENERAL_DYNAMICS (85, "Stinger, FIM-92, General Dynamics"),
    /** TOW heavy Anti-Tank weapon */
    TOW_HEAVY_ANTI_TANK_WEAPON (86, "TOW heavy Anti-Tank weapon"),
    /** Bear Trap AP device, Pancor */
    BEAR_TRAP_AP_DEVICE_PANCOR (87, "Bear Trap AP device, Pancor"),
    /** Chain Gun automatic weapon EX-34 7.62-mm */
    CHAIN_GUN_AUTOMATIC_WEAPON_EX_34_762_MM (88, "Chain Gun automatic weapon EX-34 7.62-mm"),
    /** Close Assault Weapon System (CAWS), AAI */
    CLOSE_ASSAULT_WEAPON_SYSTEM_CAWS_AAI (89, "Close Assault Weapon System (CAWS), AAI"),
    /** CAWS, Olin/Heckler and Koch */
    CAWS_OLIN_HECKLER_AND_KOCH (90, "CAWS, Olin/Heckler and Koch"),
    /** Crossfire SAM Model 88 */
    CROSSFIRE_SAM_MODEL_88 (91, "Crossfire SAM Model 88"),
    /** Dragon and M16 */
    DRAGON_AND_M16 (92, "Dragon and M16"),
    /** Firing port weapon M231, 5.56-mm, Colt */
    FIRING_PORT_WEAPON_M231_556_MM_COLT (93, "Firing port weapon M231, 5.56-mm, Colt"),
    /** Foxhole Digger Explosive Kit (EXFODA) */
    FOXHOLE_DIGGER_EXPLOSIVE_KIT_EXFODA (94, "Foxhole Digger Explosive Kit (EXFODA)"),
    /** Infantry Support Weapon ASP-30 {RM} 30-mm */
    INFANTRY_SUPPORT_WEAPON_ASP_30_RM_30_MM (95, "Infantry Support Weapon ASP-30 {RM} 30-mm"),
    /** Jackhammer Mk 3-A2, Pancor */
    JACKHAMMER_MK_3_A2_PANCOR (96, "Jackhammer Mk 3-A2, Pancor"),
    /** Light Anti-Armor weapon M136 (AT4) */
    LIGHT_ANTI_ARMOR_WEAPON_M136_AT4 (97, "Light Anti-Armor weapon M136 (AT4)"),
    /** M26A2 */
    M26A2 (98, "M26A2"),
    /** Master Key S */
    MASTER_KEY_S (99, "Master Key S"),
    /** Minigun 5.56-mm */
    MINIGUN_556_MM (100, "Minigun 5.56-mm"),
    /** Multipurpose Individual Munition (MPIM), Marquardt */
    MULTIPURPOSE_INDIVIDUAL_MUNITION_MPIM_MARQUARDT (101, "Multipurpose Individual Munition (MPIM), Marquardt"),
    /** Multipurpose weapon AT8 */
    MULTIPURPOSE_WEAPON_AT8 (102, "Multipurpose weapon AT8"),
    /** Recoilless rifle M40, M40A2, and M40A4; 106-mm */
    RECOILLESS_RIFLE_M40_M40A2_AND_M40A4_106_MM (103, "Recoilless rifle M40, M40A2, and M40A4; 106-mm"),
    /** Recoilless rifle M67, 90-mm */
    RECOILLESS_RIFLE_M67_90_MM (104, "Recoilless rifle M67, 90-mm"),
    /** Revolver, SP 101 */
    REVOLVER_SP_101 (105, "Revolver, SP 101"),
    /** Revolver, Super Redhawk .44 magnum, Ruger */
    REVOLVER_SUPER_REDHAWK_44_MAGNUM_RUGER (106, "Revolver, Super Redhawk .44 magnum, Ruger"),
    /** RAW rocket, 140-mm, Brunswick */
    RAW_ROCKET_140_MM_BRUNSWICK (107, "RAW rocket, 140-mm, Brunswick"),
    /** Rifle-launcher Anti-Armor Munition (RAAM), Olin */
    RIFLE_LAUNCHER_ANTI_ARMOR_MUNITION_RAAM_OLIN (108, "Rifle-launcher Anti-Armor Munition (RAAM), Olin"),
    /** Rocket launcher M-20 3.5-in */
    ROCKET_LAUNCHER_M_20_35_IN (109, "Rocket launcher M-20 3.5-in"),
    /** Rocket launcher, Enhanced M72 E series HEAT, 66-mm */
    ROCKET_LAUNCHER_ENHANCED_M72_E_SERIES_HEAT_66_MM (110, "Rocket launcher, Enhanced M72 E series HEAT, 66-mm"),
    /** Selective fire weapon AC-556 5.56-mm, Ruger */
    SELECTIVE_FIRE_WEAPON_AC_556_556_MM_RUGER (111, "Selective fire weapon AC-556 5.56-mm, Ruger"),
    /** Selective fire weapon AC-556F 5.56-mm, Ruger */
    SELECTIVE_FIRE_WEAPON_AC_556F_556_MM_RUGER (112, "Selective fire weapon AC-556F 5.56-mm, Ruger"),
    /** Shotgun M870 Mk 1 (U.S. Marine Corps), Remington */
    SHOTGUN_M870_MK_1_US_MARINE_CORPS_REMINGTON (113, "Shotgun M870 Mk 1 (U.S. Marine Corps), Remington"),
    /** SMAW Mk 193, 83-mm, McDonnell-Douglas */
    SMAW_MK_193_83_MM_MCDONNELL_DOUGLAS (114, "SMAW Mk 193, 83-mm, McDonnell-Douglas"),
    /** SMAW-D: Disposable SMAW */
    SMAW_D_DISPOSABLE_SMAW (115, "SMAW-D: Disposable SMAW"),
    /** Squad Automatic Weapon (SAW) M249 5.56-mm */
    SQUAD_AUTOMATIC_WEAPON_SAW_M249_556_MM (116, "Squad Automatic Weapon (SAW) M249 5.56-mm"),
    /** Tactical Support Weapon 50/12, .50-cal, Peregrine */
    TACTICAL_SUPPORT_WEAPON_50_12_50_CAL_PEREGRINE (117, "Tactical Support Weapon 50/12, .50-cal, Peregrine"),
    /** Telescoped Ammunition Revolver Gun (TARG) .50-cal, Ares */
    TELESCOPED_AMMUNITION_REVOLVER_GUN_TARG_50_CAL_ARES (118, "Telescoped Ammunition Revolver Gun (TARG) .50-cal, Ares"),
    /** Ultimate over-under combination, Ciener */
    ULTIMATE_OVER_UNDER_COMBINATION_CIENER (119, "Ultimate over-under combination, Ciener"),
    /** M18A1 Claymore mine */
    M18A1_CLAYMORE_MINE (120, "M18A1 Claymore mine"),
    /** Mortar 81-mm */
    MORTAR_81_MM (121, "Mortar 81-mm"),
    /** Machinegun M240 7.62mm */
    MACHINEGUN_M240_762MM (134, "Machinegun M240 7.62mm");

    private int value;
    private final String description;

    LifeFormsSubcategoryUSWeapons(int value, String description)
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

    public static LifeFormsSubcategoryUSWeapons getEnumForValue(int i)
    {
       for(LifeFormsSubcategoryUSWeapons val: LifeFormsSubcategoryUSWeapons.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormsSubcategoryUSWeapons");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    public static LifeFormsSubcategoryUSWeapons unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormsSubcategoryUSWeapons unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        return "LifeFormsSubcategoryUSWeapons " + getValue() + " " + name(); 
    }
}
