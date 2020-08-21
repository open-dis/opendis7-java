package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 518 marshal size 8<br>
 * LifeFormHumanSpecificAntiTankRockets
 */
public enum LifeFormHumanSpecificAntiTankRockets 
{
    /** Other */
    OTHER (0, "Other"),
    /** 82mm B-300 */
    NAME_82MM_B_300 (10, "82mm B-300"),
    /** 82mm Shipon */
    NAME_82MM_SHIPON (11, "82mm Shipon"),
    /** 83mm MK153 Mod 0 SMAW */
    NAME_83MM_MK153_MOD_0_SMAW (12, "83mm MK153 Mod 0 SMAW"),
    /** 66mm M72 LAW */
    NAME_66MM_M72_LAW (20, "66mm M72 LAW"),
    /** 66mm M72A1 LAW */
    NAME_66MM_M72A1_LAW (21, "66mm M72A1 LAW"),
    /** 66mm M72A2 LAW */
    NAME_66MM_M72A2_LAW (22, "66mm M72A2 LAW"),
    /** 66mm M72A3 LAW */
    NAME_66MM_M72A3_LAW (23, "66mm M72A3 LAW"),
    /** 66mm M72A4 LAW */
    NAME_66MM_M72A4_LAW (24, "66mm M72A4 LAW"),
    /** 66mm M72A5 LAW */
    NAME_66MM_M72A5_LAW (25, "66mm M72A5 LAW"),
    /** 66mm M72A6 LAW */
    NAME_66MM_M72A6_LAW (26, "66mm M72A6 LAW"),
    /** 66mm M72A7 LAW */
    NAME_66MM_M72A7_LAW (27, "66mm M72A7 LAW"),
    /** 66mm M72E8 LAW */
    NAME_66MM_M72E8_LAW (28, "66mm M72E8 LAW"),
    /** 66mm M72E9 LAW */
    NAME_66MM_M72E9_LAW (29, "66mm M72E9 LAW"),
    /** 66mm M72E10 LAW */
    NAME_66MM_M72E10_LAW (30, "66mm M72E10 LAW"),
    /** 66mm M72AS LAW */
    NAME_66MM_M72AS_LAW (31, "66mm M72AS LAW"),
    /** 94mm LAW 80 */
    NAME_94MM_LAW_80 (35, "94mm LAW 80"),
    /** 60mm M1 Bazooka */
    NAME_60MM_M1_BAZOOKA (40, "60mm M1 Bazooka"),
    /** 60mm M1A1 Bazooka */
    NAME_60MM_M1A1_BAZOOKA (41, "60mm M1A1 Bazooka"),
    /** 60mm M9 Bazooka */
    NAME_60MM_M9_BAZOOKA (42, "60mm M9 Bazooka"),
    /** 60mm M9A1 Bazooka */
    NAME_60MM_M9A1_BAZOOKA (43, "60mm M9A1 Bazooka"),
    /** 89mm M20 Super Bazooka */
    NAME_89MM_M20_SUPER_BAZOOKA (44, "89mm M20 Super Bazooka"),
    /** 89mm M20A1 Super Bazooka */
    NAME_89MM_M20A1_SUPER_BAZOOKA (45, "89mm M20A1 Super Bazooka"),
    /** 89mm M20B1 Super Bazooka */
    NAME_89MM_M20B1_SUPER_BAZOOKA (46, "89mm M20B1 Super Bazooka"),
    /** 89mm M20A1B1 Super Bazooka */
    NAME_89MM_M20A1B1_SUPER_BAZOOKA (47, "89mm M20A1B1 Super Bazooka"),
    /** 89mm M25 Three Shot Bazooka */
    NAME_89MM_M25_THREE_SHOT_BAZOOKA (48, "89mm M25 Three Shot Bazooka"),
    /** 89mm Instalaza M65 */
    NAME_89MM_INSTALAZA_M65 (49, "89mm Instalaza M65"),
    /** 90mm Instalaza C90 */
    NAME_90MM_INSTALAZA_C90 (50, "90mm Instalaza C90"),
    /** 90mm C90-CR (M3) */
    NAME_90MM_C90_CR_M3 (51, "90mm C90-CR (M3)"),
    /** 90mm C90-CR-AM (M3) */
    NAME_90MM_C90_CR_AM_M3 (52, "90mm C90-CR-AM (M3)"),
    /** 90mm C90-CR-BK (M3) */
    NAME_90MM_C90_CR_BK_M3 (53, "90mm C90-CR-BK (M3)"),
    /** 90mm C90-CR-IN (M3) */
    NAME_90MM_C90_CR_IN_M3 (54, "90mm C90-CR-IN (M3)"),
    /** 60mm PzF 3 */
    NAME_60MM_PZF_3 (60, "60mm PzF 3"),
    /** 60mm PzF 3-IT */
    NAME_60MM_PZF_3_IT (61, "60mm PzF 3-IT"),
    /** 60mm PzF 3 Bunkerfaust */
    NAME_60MM_PZF_3_BUNKERFAUST (62, "60mm PzF 3 Bunkerfaust"),
    /** 44mm PzF 44 */
    NAME_44MM_PZF_44 (65, "44mm PzF 44"),
    /** 30mm Panzerfaust 30 */
    NAME_30MM_PANZERFAUST_30 (70, "30mm Panzerfaust 30"),
    /** 50mm Panzerfaust 60 */
    NAME_50MM_PANZERFAUST_60 (71, "50mm Panzerfaust 60"),
    /** 60mm Panzerfaust 100 */
    NAME_60MM_PANZERFAUST_100 (72, "60mm Panzerfaust 100"),
    /** 60mm Panzerfaust 150 */
    NAME_60MM_PANZERFAUST_150 (73, "60mm Panzerfaust 150"),
    /** 88mm Panzerschreck RPzB */
    NAME_88MM_PANZERSCHRECK_RPZB (75, "88mm Panzerschreck RPzB"),
    /** 83mm RL-83 Blindicide */
    NAME_83MM_RL_83_BLINDICIDE (80, "83mm RL-83 Blindicide"),
    /** 100mm RL-100 Blindicide */
    NAME_100MM_RL_100_BLINDICIDE (81, "100mm RL-100 Blindicide"),
    /** 90mm M79 Osa (Wasp) */
    NAME_90MM_M79_OSA_WASP (85, "90mm M79 Osa (Wasp)"),
    /** 64mm M80 Zolja (Wasp) */
    NAME_64MM_M80_ZOLJA_WASP (86, "64mm M80 Zolja (Wasp)"),
    /** 67mm Armburst Crossbow */
    NAME_67MM_ARMBURST_CROSSBOW (90, "67mm Armburst Crossbow"),
    /** 40mm Type-69 RPG */
    NAME_40MM_TYPE_69_RPG (93, "40mm Type-69 RPG"),
    /** 89mm PIAT */
    NAME_89MM_PIAT (95, "89mm PIAT"),
    /** 40mm RPG-2 */
    NAME_40MM_RPG_2 (100, "40mm RPG-2"),
    /** 64mm RPG-18 Mukha */
    NAME_64MM_RPG_18_MUKHA (101, "64mm RPG-18 Mukha"),
    /** 72.5mm RPG-22 Netto */
    NAME_725MM_RPG_22_NETTO (102, "72.5mm RPG-22 Netto"),
    /** 72.5mm RPG-26 Aglen */
    NAME_725MM_RPG_26_AGLEN (103, "72.5mm RPG-26 Aglen"),
    /** 105mm RPG-29 Vampir */
    NAME_105MM_RPG_29_VAMPIR (104, "105mm RPG-29 Vampir"),
    /** 105mm RPG-30 Kryuk */
    NAME_105MM_RPG_30_KRYUK (105, "105mm RPG-30 Kryuk"),
    /** 105mm RPG-32 Nashshab */
    NAME_105MM_RPG_32_NASHSHAB (106, "105mm RPG-32 Nashshab"),
    /** 40mm RPG-7 */
    NAME_40MM_RPG_7 (110, "40mm RPG-7"),
    /** 40mm PSRL-1 (RPG-7USA) */
    NAME_40MM_PSRL_1_RPG_7USA (111, "40mm PSRL-1 (RPG-7USA)"),
    /** 40mm GS-777/PSRL-2 */
    NAME_40MM_GS_777_PSRL_2 (112, "40mm GS-777/PSRL-2"),
    /** 68mm RPG-76 Komar (Mosquito) */
    NAME_68MM_RPG_76_KOMAR_MOSQUITO (120, "68mm RPG-76 Komar (Mosquito)"),
    /** 120mm SEP Dard 120 */
    NAME_120MM_SEP_DARD_120 (125, "120mm SEP Dard 120"),
    /** 58mm WASP 58 */
    NAME_58MM_WASP_58 (128, "58mm WASP 58"),
    /** 73mm LRAC 73-50 */
    NAME_73MM_LRAC_73_50 (130, "73mm LRAC 73-50"),
    /** 89mm LRAC 89-F1 STRIM */
    NAME_89MM_LRAC_89_F1_STRIM (131, "89mm LRAC 89-F1 STRIM"),
    /** 90mm MATADOR (Man-Portable Anti-Tank, Anti-DOoR) */
    NAME_90MM_MATADOR_MAN_PORTABLE_ANTI_TANK_ANTI_DOOR (135, "90mm MATADOR (Man-Portable Anti-Tank, Anti-DOoR)"),
    /** 90mm MATADOR-MP */
    NAME_90MM_MATADOR_MP (136, "90mm MATADOR-MP"),
    /** 90mm MATADOR-WB */
    NAME_90MM_MATADOR_WB (137, "90mm MATADOR-WB"),
    /** 90mm MATADOR-AS */
    NAME_90MM_MATADOR_AS (138, "90mm MATADOR-AS"),
    /** 78mm MARA Anti-Tank Rocket Launcher */
    NAME_78MM_MARA_ANTI_TANK_ROCKET_LAUNCHER (140, "78mm MARA Anti-Tank Rocket Launcher"),
    /** 120mm Type-98 PF98 */
    NAME_120MM_TYPE_98_PF98 (145, "120mm Type-98 PF98");

    private int value;
    private final String description;

    LifeFormHumanSpecificAntiTankRockets(int value, String description)
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

    public static LifeFormHumanSpecificAntiTankRockets getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificAntiTankRockets val: LifeFormHumanSpecificAntiTankRockets.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificAntiTankRockets");
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

    public static LifeFormHumanSpecificAntiTankRockets unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormHumanSpecificAntiTankRockets unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormHumanSpecificAntiTankRockets: " + name() + ": " + getValue(); 
    }
}
