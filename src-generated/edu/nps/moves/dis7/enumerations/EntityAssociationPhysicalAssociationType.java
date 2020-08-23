package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 323 marshal size 8<br>
 * ____________________________________________
 */
public enum EntityAssociationPhysicalAssociationType 
{
    /** Not Specified */
    NOT_SPECIFIED (0, "Not Specified"),
    /** Towed in Air (Single Hook, Not Specified) */
    TOWED_IN_AIR_SINGLE_HOOK_NOT_SPECIFIED (1, "Towed in Air (Single Hook, Not Specified)"),
    /** Towed on Land */
    TOWED_ON_LAND (2, "Towed on Land"),
    /** Towed on Water Surface */
    TOWED_ON_WATER_SURFACE (3, "Towed on Water Surface"),
    /** Towed Underwater */
    TOWED_UNDERWATER (4, "Towed Underwater"),
    /** Mounted Attached */
    MOUNTED_ATTACHED (5, "Mounted Attached"),
    /** Mounted Unattached and Unsupported */
    MOUNTED_UNATTACHED_AND_UNSUPPORTED (6, "Mounted Unattached and Unsupported"),
    /** Mounted Unattached and Supported */
    MOUNTED_UNATTACHED_AND_SUPPORTED (7, "Mounted Unattached and Supported"),
    /** Towed in Air (Center Hook) */
    TOWED_IN_AIR_CENTER_HOOK (8, "Towed in Air (Center Hook)"),
    /** Towed in Air (Forward Hook) */
    TOWED_IN_AIR_FORWARD_HOOK (9, "Towed in Air (Forward Hook)"),
    /** Towed in Air (Aft Hook) */
    TOWED_IN_AIR_AFT_HOOK (10, "Towed in Air (Aft Hook)"),
    /** Towed in Air (Tandem Hook - Fore and Aft) */
    TOWED_IN_AIR_TANDEM_HOOK_FORE_AND_AFT (11, "Towed in Air (Tandem Hook - Fore and Aft)"),
    /** Towed in Air (Mismanaged Tandem - Fore and Center) */
    TOWED_IN_AIR_MISMANAGED_TANDEM_FORE_AND_CENTER (12, "Towed in Air (Mismanaged Tandem - Fore and Center)"),
    /** Towed in Air (Mismanaged Tandem - Center and Aft) */
    TOWED_IN_AIR_MISMANAGED_TANDEM_CENTER_AND_AFT (13, "Towed in Air (Mismanaged Tandem - Center and Aft)"),
    /** Towed in Air (All Hooks) */
    TOWED_IN_AIR_ALL_HOOKS (14, "Towed in Air (All Hooks)"),
    /** Hoisted */
    HOISTED (15, "Hoisted"),
    /** Restrained to a Lifeform */
    RESTRAINED_TO_A_LIFEFORM (30, "Restrained to a Lifeform"),
    /** Restrained to a Platform */
    RESTRAINED_TO_A_PLATFORM (31, "Restrained to a Platform"),
    /** Restrained to an Object */
    RESTRAINED_TO_AN_OBJECT (32, "Restrained to an Object"),
    /** Refueling Operation */
    REFUELING_OPERATION (61, "Refueling Operation"),
    /** Search and Rescue Basket */
    SEARCH_AND_RESCUE_BASKET (62, "Search and Rescue Basket"),
    /** Search and Rescue Rescue Collar */
    SEARCH_AND_RESCUE_RESCUE_COLLAR (63, "Search and Rescue Rescue Collar"),
    /** Engagement/Object 2 is Being Engaged */
    ENGAGEMENT_OBJECT_2_IS_BEING_ENGAGED (64, "Engagement/Object 2 is Being Engaged"),
    /** Return To Base/Object 2 is the Destination Object */
    RETURN_TO_BASE_OBJECT_2_IS_THE_DESTINATION_OBJECT (65, "Return To Base/Object 2 is the Destination Object"),
    /** Line between Communication Towers */
    LINE_BETWEEN_COMMUNICATION_TOWERS (90, "Line between Communication Towers"),
    /** Line Between Power Towers */
    LINE_BETWEEN_POWER_TOWERS (91, "Line Between Power Towers"),
    /** Indoors */
    INDOORS (92, "Indoors"),
    /** Roof */
    ROOF (93, "Roof");

    private int value;
    private final String description;

    EntityAssociationPhysicalAssociationType(int value, String description)
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

    public static EntityAssociationPhysicalAssociationType getEnumForValue(int i)
    {
       for(EntityAssociationPhysicalAssociationType val: EntityAssociationPhysicalAssociationType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityAssociationPhysicalAssociationType");
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

    public static EntityAssociationPhysicalAssociationType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static EntityAssociationPhysicalAssociationType unmarshalEnum(ByteBuffer buff) throws Exception
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

    /** Returns the size of this serialized object in bytes
     *@return size in bytes*/  
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "EntityAssociationPhysicalAssociationType: " + name() + ": " + getValue(); 
    }
}
