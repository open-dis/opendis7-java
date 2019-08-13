package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 120 marshal size 8<br>
 * Subcategories for Subsurface Category 200 - Fish
 */
public enum SubcategoriesforSubsurfaceCategory200Fish implements SubCategory
{
    /** Forage Fish, Small Schooling, 1-29  Small size schooling (forage) fish (herring-like, sardines, squid, krill) */
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
    MEDIUM_SCHOOLING_FISH (30, "Medium Schooling Fish"),
    /** Hake */
    HAKE (31, "Hake"),
    /** Cod */
    COD (32, "Cod"),
    /** Haddock */
    HADDOCK (33, "Haddock"),
    /** Mackerel */
    MACKEREL (34, "Mackerel"),
    /** Large Schooling Fish, 60-89 Large size schooling fish (tuna) */
    LARGE_SCHOOLING_FISH (60, "Large Schooling Fish"),
    /** Tuna */
    TUNA (61, "Tuna"),
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

    SubcategoriesforSubsurfaceCategory200Fish(int value, String description)
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

    public static SubcategoriesforSubsurfaceCategory200Fish getEnumForValue(int i)
    {
       for(SubcategoriesforSubsurfaceCategory200Fish val: SubcategoriesforSubsurfaceCategory200Fish.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforSubsurfaceCategory200Fish");
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

    public static SubcategoriesforSubsurfaceCategory200Fish unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static SubcategoriesforSubsurfaceCategory200Fish unmarshalEnum(ByteBuffer buff) throws Exception
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
