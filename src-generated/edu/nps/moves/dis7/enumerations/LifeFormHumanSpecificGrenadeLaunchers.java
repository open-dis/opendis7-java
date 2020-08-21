package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 515 marshal size 8<br>
 * LifeFormHumanSpecificGrenadeLaunchers
 */
public enum LifeFormHumanSpecificGrenadeLaunchers 
{
    /** Other */
    OTHER (0, "Other"),
    /** 40x46mm Arsenal UGGL-M1 */
    NAME_40X46MM_ARSENAL_UGGL_M1 (1, "40x46mm Arsenal UGGL-M1"),
    /** 40x46mm Arsenal MSGL */
    NAME_40X46MM_ARSENAL_MSGL (2, "40x46mm Arsenal MSGL"),
    /** 40mm VOG Arsenal MSGL */
    NAME_40MM_VOG_ARSENAL_MSGL (3, "40mm VOG Arsenal MSGL"),
    /** 40x46mm Arsenal UBGL-M16 */
    NAME_40X46MM_ARSENAL_UBGL_M16 (4, "40x46mm Arsenal UBGL-M16"),
    /** 40x46mm Arsenal UBGL-M8 */
    NAME_40X46MM_ARSENAL_UBGL_M8 (5, "40x46mm Arsenal UBGL-M8"),
    /** 40x46mm Arsenal UBGL-M7 */
    NAME_40X46MM_ARSENAL_UBGL_M7 (6, "40x46mm Arsenal UBGL-M7"),
    /** 30mm BS-1 Tishina */
    NAME_30MM_BS_1_TISHINA (10, "30mm BS-1 Tishina"),
    /** 40mm BTS-203 */
    NAME_40MM_BTS_203 (11, "40mm BTS-203"),
    /** 40mm Indumil IMC-40 */
    NAME_40MM_INDUMIL_IMC_40 (12, "40mm Indumil IMC-40"),
    /** 40mm VOG BG-15 */
    NAME_40MM_VOG_BG_15 (20, "40mm VOG BG-15"),
    /** 40mm VOG GP-25 Kostoyor */
    NAME_40MM_VOG_GP_25_KOSTOYOR (21, "40mm VOG GP-25 Kostoyor"),
    /** 40mm VOG GP-30 Obuvka */
    NAME_40MM_VOG_GP_30_OBUVKA (22, "40mm VOG GP-30 Obuvka"),
    /** 40mm VOG GP-34 */
    NAME_40MM_VOG_GP_34 (23, "40mm VOG GP-34"),
    /** 40mm VOG RGM-40 Kastet */
    NAME_40MM_VOG_RGM_40_KASTET (24, "40mm VOG RGM-40 Kastet"),
    /** 40mm VOG RG-6 */
    NAME_40MM_VOG_RG_6 (25, "40mm VOG RG-6"),
    /** 40x46mm M79 */
    NAME_40X46MM_M79 (30, "40x46mm M79"),
    /** 40x46mm M203 */
    NAME_40X46MM_M203 (31, "40x46mm M203"),
    /** 40x36mm M320 */
    NAME_40X36MM_M320 (32, "40x36mm M320"),
    /** 40x46mm CIS 40 GL */
    NAME_40X46MM_CIS_40_GL (35, "40x46mm CIS 40 GL"),
    /** 40x46mm EAGLE GL */
    NAME_40X46MM_EAGLE_GL (36, "40x46mm EAGLE GL"),
    /** 40x46mm HK AG36 */
    NAME_40X46MM_HK_AG36 (37, "40x46mm HK AG36"),
    /** 40x46mm HK AG-C/GLM */
    NAME_40X46MM_HK_AG_C_GLM (38, "40x46mm HK AG-C/GLM"),
    /** 40x46mm HK69A1 */
    NAME_40X46MM_HK69A1 (39, "40x46mm HK69A1"),
    /** 40x46mm Beretta GLX 160 */
    NAME_40X46MM_BERETTA_GLX_160 (40, "40x46mm Beretta GLX 160"),
    /** 40x46mm ARDE UBGL */
    NAME_40X46MM_ARDE_UBGL (41, "40x46mm ARDE UBGL"),
    /** 40x46mm XML148 */
    NAME_40X46MM_XML148 (42, "40x46mm XML148"),
    /** 40x46mm China Lake GL */
    NAME_40X46MM_CHINA_LAKE_GL (43, "40x46mm China Lake GL"),
    /** 40x46mm Hawk MM-1 */
    NAME_40X46MM_HAWK_MM_1 (44, "40x46mm Hawk MM-1"),
    /** 25x40mm XM25 CDTE */
    NAME_25X40MM_XM25_CDTE (50, "25x40mm XM25 CDTE"),
    /** 37mm Milkor37/38 LL Stopper */
    NAME_37MM_MILKOR37_38_LL_STOPPER (60, "37mm Milkor37/38 LL Stopper"),
    /** 40mm Milkor40 GL */
    NAME_40MM_MILKOR40_GL (61, "40mm Milkor40 GL"),
    /** 40mm Milkor MGL */
    NAME_40MM_MILKOR_MGL (62, "40mm Milkor MGL"),
    /** 40x47mm Pallad wz1974 */
    NAME_40X47MM_PALLAD_WZ1974 (65, "40x47mm Pallad wz1974"),
    /** 40x47mm Pallad wz1983 */
    NAME_40X47MM_PALLAD_WZ1983 (66, "40x47mm Pallad wz1983"),
    /** UGL 200 Canister RWGL-3 */
    UGL_200_CANISTER_RWGL_3 (70, "UGL 200 Canister RWGL-3"),
    /** 20x30mm ST Daewoo K11 */
    NAME_20X30MM_ST_DAEWOO_K11 (80, "20x30mm ST Daewoo K11"),
    /** 35mm Type-91 BreechLoad GL */
    NAME_35MM_TYPE_91_BREECHLOAD_GL (90, "35mm Type-91 BreechLoad GL"),
    /** 40x53mm CZW-40 */
    NAME_40X53MM_CZW_40 (95, "40x53mm CZW-40"),
    /** 45mm DP-64 */
    NAME_45MM_DP_64 (100, "45mm DP-64"),
    /** 20x42mm Neopup PAW-20 */
    NAME_20X42MM_NEOPUP_PAW_20 (105, "20x42mm Neopup PAW-20");

    private int value;
    private final String description;

    LifeFormHumanSpecificGrenadeLaunchers(int value, String description)
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

    public static LifeFormHumanSpecificGrenadeLaunchers getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificGrenadeLaunchers val: LifeFormHumanSpecificGrenadeLaunchers.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificGrenadeLaunchers");
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

    public static LifeFormHumanSpecificGrenadeLaunchers unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormHumanSpecificGrenadeLaunchers unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormHumanSpecificGrenadeLaunchers: " + name() + ": " + getValue(); 
    }
}
