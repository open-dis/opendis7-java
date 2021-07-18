package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 323 marshal size 8<br>
 * EntityAssociationPhysicalAssociationType
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
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Restrained to a Lifeform"),
    /** Restrained to a Platform */
    RESTRAINED_TO_A_PLATFORM (31, "Restrained to a Platform"),
    /** Restrained to an Object */
    RESTRAINED_TO_AN_OBJECT (32, "Restrained to an Object"),
    /** Refueling Operation */
    EVENT_REPORT_RELIABLE (61, "Refueling Operation"),
    /** Search and Rescue Basket */
    COMMENT_RELIABLE (62, "Search and Rescue Basket"),
    /** Search and Rescue Rescue Collar */
    RECORD_RELIABLE (63, "Search and Rescue Rescue Collar"),
    /** Engagement/Object 2 is Being Engaged */
    SET_RECORD_RELIABLE	 (64, "Engagement/Object 2 is Being Engaged"),
    /** Return To Base/Object 2 is the Destination Object */
    RECORD_QUERY_RELIABLE (65, "Return To Base/Object 2 is the Destination Object"),
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

    /** Constructor */
    EntityAssociationPhysicalAssociationType(int value, String description)
    {
        this.value = value;
        this.description = description;
    }
    /** Provide enumeration value
      * @return integer value */
    public int getValue()
    {
        return value;
    }

    /** Provide enumeration description
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /** bit width for this enumeration
     * @return number of bits wide
     */
    public static int getEnumBitWidth()
    {
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static EntityAssociationPhysicalAssociationType getEnumForValue(int i)
    {
       for(EntityAssociationPhysicalAssociationType val: EntityAssociationPhysicalAssociationType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration EntityAssociationPhysicalAssociationType");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EntityAssociationPhysicalAssociationType unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        String padding = new String();
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "EntityAssociationPhysicalAssociationType " + padding + getValue() + " " + name();
    }
}
