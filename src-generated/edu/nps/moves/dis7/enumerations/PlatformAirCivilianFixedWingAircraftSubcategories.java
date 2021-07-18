package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 277 marshal size 8<br>
 * PlatformAirCivilianFixedWingAircraftSubcategories<br>
 * Subcategories for Air Platform Categories 84-88. Subcategory values have the type of engine in the 10s digit and the number of engines in the 1s digit.
 */
public enum PlatformAirCivilianFixedWingAircraftSubcategories implements SubCategory
{

    /** Single Piston Engine */
    SINGLE_PISTON_ENGINE (11, "Single Piston Engine"),
    /** Twin Piston Engine */
    TWIN_PISTON_ENGINE (12, "Twin Piston Engine"),
    /** Single Engine Turboprop */
    SINGLE_ENGINE_TURBOPROP (21, "Single Engine Turboprop"),
    /** Twin Engine Turboprop */
    TWIN_ENGINE_TURBOPROP (22, "Twin Engine Turboprop"),
    /** Four Engine Turboprop */
    FOUR_ENGINE_TURBOPROP (24, "Four Engine Turboprop"),
    /** Twin Jet */
    TWIN_JET (32, "Twin Jet"),
    /** Tri Jet */
    TRI_JET (33, "Tri Jet"),
    /** Four Engine Jet */
    FOUR_ENGINE_JET (34, "Four Engine Jet");

    private int value;
    private final String description;

    /** Constructor */
    PlatformAirCivilianFixedWingAircraftSubcategories(int value, String description)
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
    public static PlatformAirCivilianFixedWingAircraftSubcategories getEnumForValue(int i)
    {
       for(PlatformAirCivilianFixedWingAircraftSubcategories val: PlatformAirCivilianFixedWingAircraftSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCivilianFixedWingAircraftSubcategories");
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
    public static PlatformAirCivilianFixedWingAircraftSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformAirCivilianFixedWingAircraftSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "PlatformAirCivilianFixedWingAircraftSubcategories " + padding + getValue() + " " + name();
    }
}
