package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 602 marshal size 8<br>
 * Class 2 Supply Category - Clothing, Individual Equipment, Tools, Admin. Supplies
 */
public enum Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies implements Category
{
    /** Other */
    OTHER (1, "Other"),
    /** A - Air */
    A_AIR (2, "A - Air"),
    /** B - Ground Support Materiel */
    B_GROUND_SUPPORT_MATERIEL (3, "B - Ground Support Materiel"),
    /** E - General Supplies */
    E_GENERAL_SUPPLIES (4, "E - General Supplies"),
    /** F - Clothing */
    F_CLOTHING (5, "F - Clothing"),
    /** G - Electronics */
    G_ELECTRONICS (6, "G - Electronics"),
    /** M - Weapons  (Humans) */
    M_WEAPONS_HUMANS (7, "M - Weapons  (Humans)"),
    /** T - Industrial Supplies */
    T_INDUSTRIAL_SUPPLIES (8, "T - Industrial Supplies");

    private int value;
    private final String description;

    Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies(int value, String description)
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

    public static Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies getEnumForValue(int i)
    {
       for(Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies val: Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies");
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

    public static Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Class2SupplyCategoryClothingIndividualEquipmentToolsAdminSupplies: " + name() + ": " + getValue(); 
    }
}
