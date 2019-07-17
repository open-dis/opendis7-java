package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 600 marshal size 8<br>
 * Supply Domain
 */
public enum SupplyDomain 
{
    /** Not Used */
    NOT_USED (0, "Not Used"),
    /** Class 1 - Subsistence */
    CLASS_1_SUBSISTENCE (1, "Class 1 - Subsistence"),
    /** Class 2 - Clothing, Individual Equipment, Tools, Admin. Supplies */
    CLASS_2_CLOTHING_INDIVIDUAL_EQUIPMENT_TOOLS_ADMIN_SUPPLIES (2, "Class 2 - Clothing, Individual Equipment, Tools, Admin. Supplies"),
    /** Class 3 - Petroleum, Oils, Lubricants */
    CLASS_3_PETROLEUM_OILS_LUBRICANTS (3, "Class 3 - Petroleum, Oils, Lubricants"),
    /** Class 4 - Construction Materials */
    CLASS_4_CONSTRUCTION_MATERIALS (4, "Class 4 - Construction Materials"),
    /** Class 5 - Ammunition, Not used, as it is described in Munitions. */
    CLASS_5_AMMUNITION (5, "Class 5 - Ammunition"),
    /** Class 6 - Personnel Demand Items */
    CLASS_6_PERSONNEL_DEMAND_ITEMS (6, "Class 6 - Personnel Demand Items"),
    /** Class 7 - Major Items, Only used for add on equipment like bomb racks. */
    CLASS_7_MAJOR_ITEMS (7, "Class 7 - Major Items"),
    /** Class 8 - Medical Material */
    CLASS_8_MEDICAL_MATERIAL (8, "Class 8 - Medical Material"),
    /** Class 9 - Repair Parts and Components */
    CLASS_9_REPAIR_PARTS_AND_COMPONENTS (9, "Class 9 - Repair Parts and Components"),
    /** Class 10 - Material to Support Non-Military Programs */
    CLASS_10_MATERIAL_TO_SUPPORT_NON_MILITARY_PROGRAMS (10, "Class 10 - Material to Support Non-Military Programs"),
    /** Class 11 - Supplies (Non Doctrinal) */
    CLASS_11_SUPPLIES_NON_DOCTRINAL (11, "Class 11 - Supplies (Non Doctrinal)"),
    /** Class 12 - Sling Loads (Non Doctrinal) */
    CLASS_12_SLING_LOADS_NON_DOCTRINAL (12, "Class 12 - Sling Loads (Non Doctrinal)");

    private int value;
    private final String description;

    SupplyDomain(int value, String description)
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

    public static SupplyDomain getEnumForValue(int i)
    {
       for(SupplyDomain val: SupplyDomain.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SupplyDomain");
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

    public static SupplyDomain unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static SupplyDomain unmarshalEnum(ByteBuffer buff) throws Exception
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
