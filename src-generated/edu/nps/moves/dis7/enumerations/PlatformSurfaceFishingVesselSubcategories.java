package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 447 marshal size 8<br>
 * PlatformSurfaceFishingVesselSubcategories<br>
 * Subcategories for Surface Platform Category 86.
 */
public enum PlatformSurfaceFishingVesselSubcategories implements SubCategory
{

    /** Small Fishing Vessel (up to 26ft/7.9m) */
    SMALL_FISHING_VESSEL_UP_TO_26FT_79M (1, "Small Fishing Vessel (up to 26ft/7.9m)"),
    /** Medium Fishing Vessel (up to 65ft/19.8m) */
    MEDIUM_FISHING_VESSEL_UP_TO_65FT_198M (2, "Medium Fishing Vessel (up to 65ft/19.8m)"),
    /** Large Fishing Vessel (greater than 65ft/19.8m) */
    LARGE_FISHING_VESSEL_GREATER_THAN_65FT_198M (3, "Large Fishing Vessel (greater than 65ft/19.8m)"),
    /** Fish Processing Vessel */
    FISH_PROCESSING_VESSEL (4, "Fish Processing Vessel"),
    /** Masted Fishing Vessel */
    MASTED_FISHING_VESSEL (5, "Masted Fishing Vessel");

    private int value;
    private final String description;

    PlatformSurfaceFishingVesselSubcategories(int value, String description)
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

    public static PlatformSurfaceFishingVesselSubcategories getEnumForValue(int i)
    {
       for(PlatformSurfaceFishingVesselSubcategories val: PlatformSurfaceFishingVesselSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfaceFishingVesselSubcategories");
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

    public static PlatformSurfaceFishingVesselSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformSurfaceFishingVesselSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "PlatformSurfaceFishingVesselSubcategories: " + name() + ": " + getValue(); 
    }
}
