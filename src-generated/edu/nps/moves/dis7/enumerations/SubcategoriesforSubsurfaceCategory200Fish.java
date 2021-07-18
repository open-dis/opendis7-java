package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 120 marshal size 8<br>
 * SubcategoriesforSubsurfaceCategory200Fish
 */
public enum SubcategoriesforSubsurfaceCategory200Fish implements SubCategory
{
    /** Forage Fish, Small Schooling, 1-29 Small size schooling (forage) fish (herring-like, sardines, squid, krill) */
    FORAGE_FISH_SMALL_SCHOOLING (1, "Forage Fish, Small Schooling"),
    /** Herring */
    HERRING (2, "Herring"),
    /** Sardines */
    SARDINES (3, "Sardines"),
    /** Krill */
    KRILL (4, "Krill"),
    /** Squid */
    SQUID (5, "Squid"),
    /** Medium Schooling Fish, 30-59 Medium size schooling fish (cod-like, hake, haddock) */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Medium Schooling Fish"),
    /** Hake */
    HAKE (31, "Hake"),
    /** Cod */
    COD (32, "Cod"),
    /** Haddock */
    HADDOCK (33, "Haddock"),
    /** Mackerel */
    MACKEREL (34, "Mackerel"),
    /** Large Schooling Fish, 60-89 Large size schooling fish (tuna) */
    DATA_RELIABLE (60, "Large Schooling Fish"),
    /** Tuna */
    EVENT_REPORT_RELIABLE (61, "Tuna"),
    /** Small Shark, 90-119 Small shark */
    SMALL_SHARK (90, "Small Shark"),
    /** Dogfish Shark */
    DOGFISH_SHARK (91, "Dogfish Shark"),
    /** Medium Shark, 120-149 Medium shark */
    MEDIUM_SHARK (120, "Medium Shark"),
    /** Mako Shark */
    MAKO_SHARK (121, "Mako Shark"),
    /** Hammerhead Shark */
    HAMMERHEAD_SHARK (122, "Hammerhead Shark"),
    /** Large Shark, 150-179 Large to vary large shark */
    LARGE_SHARK (150, "Large Shark"),
    /** Great White Shark */
    GREAT_WHITE_SHARK (151, "Great White Shark"),
    /** Tiger Shark */
    TIGER_SHARK (152, "Tiger Shark"),
    /** Blue Shark */
    BLUE_SHARK (153, "Blue Shark"),
    /** Whale Shark */
    WHALE_SHARK (154, "Whale Shark"),
    /** Skate, 180-189 Skate/Ray */
    SKATE (180, "Skate"),
    /** Stingray */
    STINGRAY (181, "Stingray"),
    /** Eel, 190-199 Eel */
    EEL (190, "Eel"),
    /** Marlin, 200-255 Other fish */
    MARLIN (200, "Marlin"),
    /** Swordfish */
    SWORDFISH (201, "Swordfish");

    private int value;
    private final String description;

    /** Constructor */
    SubcategoriesforSubsurfaceCategory200Fish(int value, String description)
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
    public static SubcategoriesforSubsurfaceCategory200Fish getEnumForValue(int i)
    {
       for(SubcategoriesforSubsurfaceCategory200Fish val: SubcategoriesforSubsurfaceCategory200Fish.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforSubsurfaceCategory200Fish");
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
    public static SubcategoriesforSubsurfaceCategory200Fish unmarshalEnum (DataInputStream dis) throws Exception
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
    public static SubcategoriesforSubsurfaceCategory200Fish unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "SubcategoriesforSubsurfaceCategory200Fish " + padding + getValue() + " " + name();
    }
}
