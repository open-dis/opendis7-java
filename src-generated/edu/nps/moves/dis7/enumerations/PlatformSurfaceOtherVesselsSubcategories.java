package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 448 marshal size 8<br>
 * PlatformSurfaceOtherVesselsSubcategories<br>
 * Subcategories for Surface Platform Category 87.
 */
public enum PlatformSurfaceOtherVesselsSubcategories implements SubCategory
{

    /** Go-Fast Boat */
    GO_FAST_BOAT (1, "Go-Fast Boat"),
    /** Research Vessel */
    RESEARCH_VESSEL (2, "Research Vessel"),
    /** Hydrofoil Vessel */
    HYDROFOIL_VESSEL (3, "Hydrofoil Vessel"),
    /** Cable Layer Vessel */
    CABLE_LAYER_VESSEL (4, "Cable Layer Vessel"),
    /** Dredger Vessel */
    DREDGER_VESSEL (5, "Dredger Vessel"),
    /** Junk/Dhow Vessel */
    JUNK_DHOW_VESSEL (6, "Junk/Dhow Vessel"),
    /** Catamaran */
    CATAMARAN (7, "Catamaran"),
    /** Pontoon */
    PONTOON (8, "Pontoon"),
    /** Personal Water Craft */
    PERSONAL_WATER_CRAFT (9, "Personal Water Craft"),
    /** Refugee Raft */
    REFUGEE_RAFT (10, "Refugee Raft");

    private int value;
    private final String description;

    /** Constructor */
    PlatformSurfaceOtherVesselsSubcategories(int value, String description)
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
    public static PlatformSurfaceOtherVesselsSubcategories getEnumForValue(int i)
    {
       for(PlatformSurfaceOtherVesselsSubcategories val: PlatformSurfaceOtherVesselsSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfaceOtherVesselsSubcategories");
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
    public static PlatformSurfaceOtherVesselsSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformSurfaceOtherVesselsSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "PlatformSurfaceOtherVesselsSubcategories " + padding + getValue() + " " + name();
    }
}
