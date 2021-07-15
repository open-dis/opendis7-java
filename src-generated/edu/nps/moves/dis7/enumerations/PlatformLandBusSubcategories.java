package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 429 marshal size 8<br>
 * PlatformLandBusSubcategories<br>
 * Subcategories for Land Platform Category 82
 */
public enum PlatformLandBusSubcategories 
{

    /** Other */
    OTHER (0, "Other"),
    /** Commuter (Flat Nose) */
    COMMUTER_FLAT_NOSE (1, "Commuter (Flat Nose)"),
    /** Commuter (Snout Nose) */
    COMMUTER_SNOUT_NOSE (2, "Commuter (Snout Nose)"),
    /** Shuttle */
    SHUTTLE (3, "Shuttle"),
    /** Double Decker */
    DOUBLE_DECKER (4, "Double Decker"),
    /** Guided */
    GUIDED (5, "Guided"),
    /** Kneeling */
    KNEELING (6, "Kneeling"),
    /** Midibus */
    MIDIBUS (7, "Midibus"),
    /** Minibus */
    MINIBUS (8, "Minibus"),
    /** Mini Wheelchair */
    MINI_WHEELCHAIR (9, "Mini Wheelchair"),
    /** Motorcoach */
    MOTORCOACH (10, "Motorcoach"),
    /** Prison Bus */
    PRISON_BUS (11, "Prison Bus"),
    /** Schoolbus */
    SCHOOLBUS (12, "Schoolbus"),
    /** School Wheelchair */
    SCHOOL_WHEELCHAIR (13, "School Wheelchair"),
    /** Tour */
    TOUR (14, "Tour"),
    /** Tram Parking Lot */
    TRAM_PARKING_LOT (15, "Tram Parking Lot"),
    /** Trolley */
    TROLLEY (16, "Trolley"),
    /** Airport Transport */
    AIRPORT_TRANSPORT (17, "Airport Transport"),
    /** Articulated (Multi-Unit) */
    ARTICULATED_MULTI_UNIT (18, "Articulated (Multi-Unit)");

    private int value;
    private final String description;

    /** Constructor */
    PlatformLandBusSubcategories(int value, String description)
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
    public static PlatformLandBusSubcategories getEnumForValue(int i)
    {
       for(PlatformLandBusSubcategories val: PlatformLandBusSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandBusSubcategories");
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
    public static PlatformLandBusSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformLandBusSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "PlatformLandBusSubcategories " + padding + getValue() + " " + name();
    }
}
