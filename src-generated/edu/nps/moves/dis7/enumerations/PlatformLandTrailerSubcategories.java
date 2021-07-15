package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 436 marshal size 8<br>
 * PlatformLandTrailerSubcategories<br>
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
    TRAILER_ULTRALIGHT_AIRCRAFT (26, "Trailer, UltraLight Aircraft"),
    /** Trailer, Heavy Equipment */
    TRAILER_HEAVY_EQUIPMENT (27, "Trailer, Heavy Equipment");

    private int value;
    private final String description;

    /** Constructor */
    PlatformLandTrailerSubcategories(int value, String description)
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
    public static PlatformLandTrailerSubcategories getEnumForValue(int i)
    {
       for(PlatformLandTrailerSubcategories val: PlatformLandTrailerSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandTrailerSubcategories");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static PlatformLandTrailerSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static PlatformLandTrailerSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        return "PlatformLandTrailerSubcategories " + padding + getValue() + " " + name();
    }
}
