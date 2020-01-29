package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 436 marshal size 8<br>
 * Platform-Land-Trailer Subcategories<br>
 * Subcategories for Land Platform Category 89
 */
public enum PlatformLandTrailerSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Trailer, Flatbed */
    TRAILER_FLATBED (1, "Trailer, Flatbed"),
    /** Trailer, Container */
    TRAILER_CONTAINER (2, "Trailer, Container"),
    /** Trailer, Container, Refrigerated */
    TRAILER_CONTAINER_REFRIGERATED (3, "Trailer, Container, Refrigerated"),
    /** Trailer, Double */
    TRAILER_DOUBLE (4, "Trailer, Double"),
    /** Trailer, Auto Transport */
    TRAILER_AUTO_TRANSPORT (5, "Trailer, Auto Transport"),
    /** Trailer, Articulated */
    TRAILER_ARTICULATED (6, "Trailer, Articulated"),
    /** Trailer, Tanker */
    TRAILER_TANKER (7, "Trailer, Tanker"),
    /** Trailer, Tanker, Small */
    TRAILER_TANKER_SMALL (8, "Trailer, Tanker, Small"),
    /** Trailer, Tanker, Large */
    TRAILER_TANKER_LARGE (9, "Trailer, Tanker, Large"),
    /** Trailer, Tanker, Gasoline */
    TRAILER_TANKER_GASOLINE (10, "Trailer, Tanker, Gasoline"),
    /** Trailer, Tanker, Milk */
    TRAILER_TANKER_MILK (11, "Trailer, Tanker, Milk"),
    /** Trailer, Tanker, Water */
    TRAILER_TANKER_WATER (12, "Trailer, Tanker, Water"),
    /** Trailer, Tanker, Septic */
    TRAILER_TANKER_SEPTIC (13, "Trailer, Tanker, Septic"),
    /** Trailer, Boat */
    TRAILER_BOAT (14, "Trailer, Boat"),
    /** Trailer, Boat, Small */
    TRAILER_BOAT_SMALL (15, "Trailer, Boat, Small"),
    /** Trailer, Boat, Large */
    TRAILER_BOAT_LARGE (16, "Trailer, Boat, Large"),
    /** Trailer, Recreational */
    TRAILER_RECREATIONAL (17, "Trailer, Recreational"),
    /** Trailer, Recreational, Conventional */
    TRAILER_RECREATIONAL_CONVENTIONAL (18, "Trailer, Recreational, Conventional"),
    /** Trailer, Recreational, Travel Expandable */
    TRAILER_RECREATIONAL_TRAVEL_EXPANDABLE (19, "Trailer, Recreational, Travel Expandable"),
    /** Trailer, Recreational, Fifth Wheel Travel */
    TRAILER_RECREATIONAL_FIFTH_WHEEL_TRAVEL (20, "Trailer, Recreational, Fifth Wheel Travel"),
    /** Trailer, Recreational, Folding Camping */
    TRAILER_RECREATIONAL_FOLDING_CAMPING (21, "Trailer, Recreational, Folding Camping"),
    /** Trailer, Recreational, Truck Camper */
    TRAILER_RECREATIONAL_TRUCK_CAMPER (22, "Trailer, Recreational, Truck Camper"),
    /** Trailer, Aerostat Mooring Platform */
    TRAILER_AEROSTAT_MOORING_PLATFORM (23, "Trailer, Aerostat Mooring Platform"),
    /** Trailer, Household */
    TRAILER_HOUSEHOLD (24, "Trailer, Household"),
    /** Trailer, Kitchen */
    TRAILER_KITCHEN (25, "Trailer, Kitchen"),
    /** Trailer, UltraLight Aircraft */
    TRAILER_ULTRALIGHT_AIRCRAFT (26, "Trailer, UltraLight Aircraft");

    private int value;
    private final String description;

    PlatformLandTrailerSubcategories(int value, String description)
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

    public static PlatformLandTrailerSubcategories getEnumForValue(int i)
    {
       for(PlatformLandTrailerSubcategories val: PlatformLandTrailerSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandTrailerSubcategories");
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

    public static PlatformLandTrailerSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformLandTrailerSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformLandTrailerSubcategories: " + name() + ": " + getValue(); 
    }
}
