package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 482 marshal size 8<br>
 * Life Form-Human-Specific-Sub Machine Gun
 */
public enum LifeFormHumanSpecificSubMachineGun 
{
    /** Other */
    OTHER (0, "Other"),
    /** 5.45mm AKS-74U (AKSU-74) */
    $545MM_AKS_74U_AKSU_74 (10, "5.45mm AKS-74U (AKSU-74)"),
    /** 5.56mm Daewoo K1A */
    $556MM_DAEWOO_K1A (20, "5.56mm Daewoo K1A"),
    /** 9mm Daewoo K7 */
    $9MM_DAEWOO_K7 (60, "9mm Daewoo K7"),
    /** 9mm MAC-10 */
    $9MM_MAC_10 (61, "9mm MAC-10"),
    /** 9mm Madsen MK II */
    $9MM_MADSEN_MK_II (62, "9mm Madsen MK II"),
    /** 9mm Mini-Uzi */
    $9MM_MINI_UZI (63, "9mm Mini-Uzi"),
    /** 9mm Model 83 Skorpion SMG */
    $9MM_MODEL_83_SKORPION_SMG (64, "9mm Model 83 Skorpion SMG"),
    /** 9mm MP5A2 */
    $9MM_MP5A2 (65, "9mm MP5A2"),
    /** 9mm MP5-N */
    $9MM_MP5_N (66, "9mm MP5-N"),
    /** 9mm Sterling SMG */
    $9MM_STERLING_SMG (67, "9mm Sterling SMG"),
    /** 9mm Type CF-05 */
    $9MM_TYPE_CF_05 (68, "9mm Type CF-05"),
    /** 9mm Uzi */
    $9MM_UZI (69, "9mm Uzi");

    private int value;
    private final String description;

    LifeFormHumanSpecificSubMachineGun(int value, String description)
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

    public static LifeFormHumanSpecificSubMachineGun getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificSubMachineGun val: LifeFormHumanSpecificSubMachineGun.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificSubMachineGun");
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

    public static LifeFormHumanSpecificSubMachineGun unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static LifeFormHumanSpecificSubMachineGun unmarshalEnum(ByteBuffer buff) throws Exception
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
