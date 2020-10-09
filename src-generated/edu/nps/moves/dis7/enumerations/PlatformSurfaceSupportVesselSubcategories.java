package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
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

    PlatformSurfaceSupportVesselSubcategories(int value, String description)
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

    public static PlatformSurfaceSupportVesselSubcategories getEnumForValue(int i)
    {
       for(PlatformSurfaceSupportVesselSubcategories val: PlatformSurfaceSupportVesselSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfaceSupportVesselSubcategories");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

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
        return "PlatformSurfaceSupportVesselSubcategories " + getValue() + " " + name(); 
    }
}
