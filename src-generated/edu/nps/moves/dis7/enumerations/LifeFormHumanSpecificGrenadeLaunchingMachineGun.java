package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 517 marshal size 8<br>
 * Life Form-Human-Specific-Grenade Launching Machine Gun
 */
public enum LifeFormHumanSpecificGrenadeLaunchingMachineGun 
{
    /** Other */
    OTHER (0, "Other"),
    /** 40x53mm HK GMG */
    $40X53MM_HK_GMG (20, "40x53mm HK GMG"),
    /** 40x53mm Mk47 Striker */
    $40X53MM_MK47_STRIKER (25, "40x53mm Mk47 Striker"),
    /** 40mm M75 */
    $40MM_M75 (26, "40mm M75"),
    /** 40mm M129 */
    $40MM_M129 (27, "40mm M129"),
    /** 40x46mm XM 174 */
    $40X46MM_XM_174 (28, "40x46mm XM 174"),
    /** 40x46mm Mk18 Mod 0 */
    $40X46MM_MK18_MOD_0 (29, "40x46mm Mk18 Mod 0"),
    /** 40x53mm Mk19 */
    $40X53MM_MK19 (30, "40x53mm Mk19"),
    /** 40x46mm Mk20 Mod 0 */
    $40X46MM_MK20_MOD_0 (31, "40x46mm Mk20 Mod 0"),
    /** 30x29mm RAG-30/SAG-30 */
    $30X29MM_RAG_30_SAG_30 (40, "30x29mm RAG-30/SAG-30"),
    /** 30x29mm AGS-17 Plamya */
    $30X29MM_AGS_17_PLAMYA (41, "30x29mm AGS-17 Plamya"),
    /** 30x29mm AGS-30 Atlant */
    $30X29MM_AGS_30_ATLANT (42, "30x29mm AGS-30 Atlant"),
    /** 40mm VOG AGS-40 Balkan */
    $40MM_VOG_AGS_40_BALKAN (43, "40mm VOG AGS-40 Balkan"),
    /** 40x53mm SB LAG 40 */
    $40X53MM_SB_LAG_40 (44, "40x53mm SB LAG 40"),
    /** 40x53mm Vektor Y3 */
    $40X53MM_VEKTOR_Y3 (50, "40x53mm Vektor Y3"),
    /** 40x53mm CIS 40 */
    $40X53MM_CIS_40 (55, "40x53mm CIS 40"),
    /** 40x56mm Howa Type-96 */
    $40X56MM_HOWA_TYPE_96 (60, "40x56mm Howa Type-96"),
    /** 40x53mm Daewoo Precision Industries K4 */
    $40X53MM_DAEWOO_PRECISION_INDUSTRIES_K4 (65, "40x53mm Daewoo Precision Industries K4"),
    /** 25x59mm XM307 Advanced Crew Served Weapon */
    $25X59MM_XM307_ADVANCED_CREW_SERVED_WEAPON (70, "25x59mm XM307 Advanced Crew Served Weapon"),
    /** 35x32mm QLZ87 */
    $35X32MM_QLZ87 (80, "35x32mm QLZ87");

    private int value;
    private final String description;

    LifeFormHumanSpecificGrenadeLaunchingMachineGun(int value, String description)
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

    public static LifeFormHumanSpecificGrenadeLaunchingMachineGun getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificGrenadeLaunchingMachineGun val: LifeFormHumanSpecificGrenadeLaunchingMachineGun.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificGrenadeLaunchingMachineGun");
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

    public static LifeFormHumanSpecificGrenadeLaunchingMachineGun unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormHumanSpecificGrenadeLaunchingMachineGun unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormHumanSpecificGrenadeLaunchingMachineGun: " + name() + ": " + getValue(); 
    }
}
