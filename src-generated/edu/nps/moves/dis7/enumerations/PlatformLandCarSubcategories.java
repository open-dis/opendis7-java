package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 428 marshal size 8<br>
 * PlatformLandCarSubcategories<br>
 * Subcategories for Land Platform Category 81. Subcategory values have the general form/style in the 10s/100s digits and the size in the 1s digit. A zero in the 1s digit indicates an unspecified size.
 */
public enum PlatformLandCarSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Generic, No specific enumerations may be placed in this subcategory */
    GENERIC (10, "Generic"),
    /** Generic, Mini/Microcar (Tiny), ACRISS M, N */
    GENERIC_MINI_MICROCAR_TINY (11, "Generic, Mini/Microcar (Tiny)"),
    /** Generic, Economy/Compact (Small), ACRISS E, H, C, D */
    GENERIC_ECONOMY_COMPACT_SMALL (12, "Generic, Economy/Compact (Small)"),
    /** Generic, Intermediate/Standard (Medium), ACRISS I, J, S, R */
    GENERIC_INTERMEDIATE_STANDARD_MEDIUM (13, "Generic, Intermediate/Standard (Medium)"),
    /** Generic, Full/Premium/Luxury (Large), ACRISS F, G, P, U, L, W */
    GENERIC_FULL_PREMIUM_LUXURY_LARGE (14, "Generic, Full/Premium/Luxury (Large)"),
    /** Generic, Oversize, ACRISS O */
    GENERIC_OVERSIZE (15, "Generic, Oversize"),
    /** 2-Door (Coupe), No specific enumerations may be placed in this subcategory */
    _2_DOOR_COUPE (20, "2-Door (Coupe)"),
    /** 2-Door (Coupe), Mini/Microcar (Tiny) */
    _2_DOOR_COUPE_MINI_MICROCAR_TINY (21, "2-Door (Coupe), Mini/Microcar (Tiny)"),
    /** 2-Door (Coupe), Economy/Compact (Small) */
    _2_DOOR_COUPE_ECONOMY_COMPACT_SMALL (22, "2-Door (Coupe), Economy/Compact (Small)"),
    /** 2-Door (Coupe), Intermediate/Standard (Medium) */
    _2_DOOR_COUPE_INTERMEDIATE_STANDARD_MEDIUM (23, "2-Door (Coupe), Intermediate/Standard (Medium)"),
    /** 3-Door Hatchback, No specific enumerations may be placed in this subcategory */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "3-Door Hatchback"),
    /** 3-Door Hatchback, Mini/Microcar (Tiny) */
    _3_DOOR_HATCHBACK_MINI_MICROCAR_TINY (31, "3-Door Hatchback, Mini/Microcar (Tiny)"),
    /** 3-Door Hatchback, Economy/Compact (Small) */
    _3_DOOR_HATCHBACK_ECONOMY_COMPACT_SMALL (32, "3-Door Hatchback, Economy/Compact (Small)"),
    /** 4-Door Sedan, No specific enumerations may be placed in this subcategory */
    _4_DOOR_SEDAN (40, "4-Door Sedan"),
    /** 4-Door Sedan, Mini/Microcar (Tiny) */
    _4_DOOR_SEDAN_MINI_MICROCAR_TINY (41, "4-Door Sedan, Mini/Microcar (Tiny)"),
    /** 4-Door Sedan, Economy/Compact (Small) */
    _4_DOOR_SEDAN_ECONOMY_COMPACT_SMALL (42, "4-Door Sedan, Economy/Compact (Small)"),
    /** 4-Door Sedan, Intermediate/Standard (Medium) */
    _4_DOOR_SEDAN_INTERMEDIATE_STANDARD_MEDIUM (43, "4-Door Sedan, Intermediate/Standard (Medium)"),
    /** 4-Door Sedan, Full/Premium/Luxury (Large) */
    _4_DOOR_SEDAN_FULL_PREMIUM_LUXURY_LARGE (44, "4-Door Sedan, Full/Premium/Luxury (Large)"),
    /** 4-Door Sedan, Oversize */
    _4_DOOR_SEDAN_OVERSIZE (45, "4-Door Sedan, Oversize"),
    /** 5-Door Hatchback, No specific enumerations may be placed in this subcategory */
    LIVE_ENTITY_DETONATION (50, "5-Door Hatchback"),
    /** 5-Door Hatchback, Mini/Microcar (Tiny) */
    CREATE_ENTITY_RELIABLE (51, "5-Door Hatchback, Mini/Microcar (Tiny)"),
    /** 5-Door Hatchback, Economy/Compact (Small) */
    REMOVE_ENTITY_RELIABLE (52, "5-Door Hatchback, Economy/Compact (Small)"),
    /** 5-Door Hatchback, Intermediate/Standard (Medium) */
    START_RESUME_RELIABLE (53, "5-Door Hatchback, Intermediate/Standard (Medium)"),
    /** 5-Door Hatchback, Full/Premium/Luxury (Large) */
    STOP_FREEZE_RELIABLE (54, "5-Door Hatchback, Full/Premium/Luxury (Large)"),
    /** Wagon, No specific enumerations may be placed in this subcategory */
    DATA_RELIABLE (60, "Wagon"),
    /** Wagon, Economy/Compact (Small) */
    COMMENT_RELIABLE (62, "Wagon, Economy/Compact (Small)"),
    /** Wagon, Intermediate/Standard (Medium) */
    RECORD_RELIABLE (63, "Wagon, Intermediate/Standard (Medium)"),
    /** Wagon, Full/Premium/Luxury (Large) */
    SET_RECORD_RELIABLE	 (64, "Wagon, Full/Premium/Luxury (Large)"),
    /** Minivan, No specific enumerations may be placed in this subcategory */
    MINIVAN (70, "Minivan"),
    /** Limousine, No specific enumerations may be placed in this subcategory */
    LIMOUSINE (80, "Limousine"),
    /** Limousine, Full/Premium/Luxury (Large) */
    LIMOUSINE_FULL_PREMIUM_LUXURY_LARGE (84, "Limousine, Full/Premium/Luxury (Large)"),
    /** Limousine, Oversize */
    LIMOUSINE_OVERSIZE (85, "Limousine, Oversize"),
    /** Sports (High Performance) */
    SPORTS_HIGH_PERFORMANCE (90, "Sports (High Performance)"),
    /** Convertible, No specific enumerations may be placed in this subcategory */
    CONVERTIBLE (100, "Convertible"),
    /** Convertible, Mini/Microcar (Tiny) */
    CONVERTIBLE_MINI_MICROCAR_TINY (101, "Convertible, Mini/Microcar (Tiny)"),
    /** Convertible, Economy/Compact (Small) */
    CONVERTIBLE_ECONOMY_COMPACT_SMALL (102, "Convertible, Economy/Compact (Small)"),
    /** Convertible, Intermediate/Standard (Medium) */
    CONVERTIBLE_INTERMEDIATE_STANDARD_MEDIUM (103, "Convertible, Intermediate/Standard (Medium)"),
    /** Convertible, Full/Premium/Luxury (Large) */
    CONVERTIBLE_FULL_PREMIUM_LUXURY_LARGE (104, "Convertible, Full/Premium/Luxury (Large)"),
    /** Sports Utility Vehicle (SUV), No specific enumerations may be placed in this subcategory */
    SPORTS_UTILITY_VEHICLE_SUV (110, "Sports Utility Vehicle (SUV)"),
    /** Sports Utility Vehicle (SUV), Economy/Compact (Small) */
    SPORTS_UTILITY_VEHICLE_SUV_ECONOMY_COMPACT_SMALL (112, "Sports Utility Vehicle (SUV), Economy/Compact (Small)"),
    /** Sports Utility Vehicle (SUV), Intermediate/Standard (Medium) */
    SPORTS_UTILITY_VEHICLE_SUV_INTERMEDIATE_STANDARD_MEDIUM (113, "Sports Utility Vehicle (SUV), Intermediate/Standard (Medium)"),
    /** Sports Utility Vehicle (SUV), Full/Premium/Luxury (Large) */
    SPORTS_UTILITY_VEHICLE_SUV_FULL_PREMIUM_LUXURY_LARGE (114, "Sports Utility Vehicle (SUV), Full/Premium/Luxury (Large)"),
    /** Sports Utility Vehicle (SUV), Oversize */
    SPORTS_UTILITY_VEHICLE_SUV_OVERSIZE (115, "Sports Utility Vehicle (SUV), Oversize");

    private int value;
    private final String description;

    /** Constructor */
    PlatformLandCarSubcategories(int value, String description)
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
    public static PlatformLandCarSubcategories getEnumForValue(int i)
    {
       for(PlatformLandCarSubcategories val: PlatformLandCarSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandCarSubcategories");
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
    public static PlatformLandCarSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformLandCarSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "PlatformLandCarSubcategories " + padding + getValue() + " " + name();
    }
}
