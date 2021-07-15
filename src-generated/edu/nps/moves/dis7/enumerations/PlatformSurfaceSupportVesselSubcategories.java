package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 444 marshal size 8<br>
 * PlatformSurfaceSupportVesselSubcategories<br>
 * Subcategories for Surface Platform Category 83
 */
public enum PlatformSurfaceSupportVesselSubcategories implements SubCategory
{

    /** Platform Supply Vessel */
    PLATFORM_SUPPLY_VESSEL (1, "Platform Supply Vessel"),
    /** Tender Vessel */
    TENDER_VESSEL (2, "Tender Vessel"),
    /** Tugboat */
    TUGBOAT (3, "Tugboat"),
    /** Dive Support Vessel */
    DIVE_SUPPORT_VESSEL (4, "Dive Support Vessel"),
    /** Fireboat */
    FIREBOAT (5, "Fireboat"),
    /** Well Stimulation Vessel (WSV) */
    WELL_STIMULATION_VESSEL_WSV (6, "Well Stimulation Vessel (WSV)"),
    /** Anchor Handling Tug Supply Vessel (AHTS) */
    ANCHOR_HANDLING_TUG_SUPPLY_VESSEL_AHTS (7, "Anchor Handling Tug Supply Vessel (AHTS)"),
    /** Offshore Construction Vessel (OCV) */
    OFFSHORE_CONSTRUCTION_VESSEL_OCV (8, "Offshore Construction Vessel (OCV)"),
    /** Emergency Response and Rescue Vessel (ERRV) */
    EMERGENCY_RESPONSE_AND_RESCUE_VESSEL_ERRV (9, "Emergency Response and Rescue Vessel (ERRV)");

    private int value;
    private final String description;

    /** Constructor */
    PlatformSurfaceSupportVesselSubcategories(int value, String description)
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
    public static PlatformSurfaceSupportVesselSubcategories getEnumForValue(int i)
    {
       for(PlatformSurfaceSupportVesselSubcategories val: PlatformSurfaceSupportVesselSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfaceSupportVesselSubcategories");
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
    public static PlatformSurfaceSupportVesselSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformSurfaceSupportVesselSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "PlatformSurfaceSupportVesselSubcategories " + padding + getValue() + " " + name();
    }
}
