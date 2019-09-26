package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 19 marshal size 8<br>
 * Life Forms-Subcategory-French Weapons
 */
public enum LifeFormsSubcategoryFrenchWeapons implements SubCategory
{
    /** ACL-STRIM */
    ACL_STRIM (1, "ACL-STRIM"),
    /** Mistral missile */
    MISTRAL_MISSILE (2, "Mistral missile"),
    /** Milan AT missile */
    MILAN_AT_MISSILE (3, "Milan AT missile"),
    /** LRAC F1 89-mm AT rocket launcher */
    LRAC_F1_89_MM_AT_ROCKET_LAUNCHER (4, "LRAC F1 89-mm AT rocket launcher"),
    /** FA-MAS rifle */
    FA_MAS_RIFLE (5, "FA-MAS rifle"),
    /** AA-52 machine gun */
    AA_52_MACHINE_GUN (6, "AA-52 machine gun"),
    /** 58-mm rifle grenade */
    $58_MM_RIFLE_GRENADE (7, "58-mm rifle grenade"),
    /** FR-F1 sniper rifle */
    FR_F1_SNIPER_RIFLE (8, "FR-F1 sniper rifle");

    private int value;
    private final String description;

    LifeFormsSubcategoryFrenchWeapons(int value, String description)
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

    public static LifeFormsSubcategoryFrenchWeapons getEnumForValue(int i)
    {
       for(LifeFormsSubcategoryFrenchWeapons val: LifeFormsSubcategoryFrenchWeapons.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormsSubcategoryFrenchWeapons");
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

    public static LifeFormsSubcategoryFrenchWeapons unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static LifeFormsSubcategoryFrenchWeapons unmarshalEnum(ByteBuffer buff) throws Exception
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
    
    @Override
    public String toString()
    {
        return "LifeFormsSubcategoryFrenchWeapons: " + name() + ": " + getValue(); 
    }
}
