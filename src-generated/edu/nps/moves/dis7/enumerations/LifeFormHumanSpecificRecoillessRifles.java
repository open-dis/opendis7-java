package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 521 marshal size 8<br>
 * Life Form-Human-Specific-Recoilless Rifles
 */
public enum LifeFormHumanSpecificRecoillessRifles 
{
    /** Other */
    OTHER (0, "Other"),
    /** 84mm M136 AT-4 CS */
    $84MM_M136_AT_4_CS (15, "84mm M136 AT-4 CS"),
    /** 57mm M18 RR */
    $57MM_M18_RR (20, "57mm M18 RR"),
    /** 75mm M20 RR */
    $75MM_M20_RR (21, "75mm M20 RR"),
    /** 120mm M-28 Davy Crockett */
    $120MM_M_28_DAVY_CROCKETT (22, "120mm M-28 Davy Crockett"),
    /** 155mm M-29 Davy Crockett */
    $155MM_M_29_DAVY_CROCKETT (23, "155mm M-29 Davy Crockett"),
    /** 106mm M40 Recoilless Rifle */
    $106MM_M40_RECOILLESS_RIFLE (24, "106mm M40 Recoilless Rifle"),
    /** 82mm M60 RR */
    $82MM_M60_RR (25, "82mm M60 RR"),
    /** 90mm M67 RR */
    $90MM_M67_RR (26, "90mm M67 RR"),
    /** 84mm M1 Carl Gustav */
    $84MM_M1_CARL_GUSTAV (30, "84mm M1 Carl Gustav"),
    /** 84mm M2 Carl Gustav */
    $84MM_M2_CARL_GUSTAV (31, "84mm M2 Carl Gustav"),
    /** 84mm M3 Carl Gustav */
    $84MM_M3_CARL_GUSTAV (32, "84mm M3 Carl Gustav"),
    /** 84mm M4 Carl Gustav */
    $84MM_M4_CARL_GUSTAV (33, "84mm M4 Carl Gustav"),
    /** 74mm Pansarskott m/68 Miniman */
    $74MM_PANSARSKOTT_M_68_MINIMAN (35, "74mm Pansarskott m/68 Miniman"),
    /** 84mm ALAC */
    $84MM_ALAC (40, "84mm ALAC"),
    /** 82mm B-10 RR */
    $82MM_B_10_RR (45, "82mm B-10 RR"),
    /** 107mm B-11 RR */
    $107MM_B_11_RR (46, "107mm B-11 RR"),
    /** 80mm Breda Folgore */
    $80MM_BREDA_FOLGORE (50, "80mm Breda Folgore"),
    /** 120mm BAT RR */
    $120MM_BAT_RR (55, "120mm BAT RR"),
    /** 73mm SPG-9 Kopye */
    $73MM_SPG_9_KOPYE (60, "73mm SPG-9 Kopye"),
    /** 88mm RCL 3.45in */
    $88MM_RCL_345IN (65, "88mm RCL 3.45in"),
    /** 90mm Pvpj 110 */
    $90MM_PVPJ_110 (70, "90mm Pvpj 110"),
    /** 50mm Jagdfaust */
    $50MM_JAGDFAUST (75, "50mm Jagdfaust"),
    /** 30mm Rheinmetall RMK30 */
    $30MM_RHEINMETALL_RMK30 (80, "30mm Rheinmetall RMK30"),
    /** 88mm 55 S 55 Raikka */
    $88MM_55_S_55_RAIKKA (90, "88mm 55 S 55 Raikka"),
    /** 95mm 95 S 58-61 */
    $95MM_95_S_58_61 (91, "95mm 95 S 58-61"),
    /** 73mm LG40 */
    $73MM_LG40 (95, "73mm LG40"),
    /** 105mm LG40 */
    $105MM_LG40 (96, "105mm LG40"),
    /** 105mm LG42 */
    $105MM_LG42 (97, "105mm LG42");

    private int value;
    private final String description;

    LifeFormHumanSpecificRecoillessRifles(int value, String description)
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

    public static LifeFormHumanSpecificRecoillessRifles getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificRecoillessRifles val: LifeFormHumanSpecificRecoillessRifles.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificRecoillessRifles");
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

    public static LifeFormHumanSpecificRecoillessRifles unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static LifeFormHumanSpecificRecoillessRifles unmarshalEnum(ByteBuffer buff) throws Exception
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
