package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 444 marshal size 8<br>
 * Platform-Surface Support Vessel Subcategories<br>
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
    FIREBOAT (5, "Fireboat");

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
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
    }

    public static PlatformSurfaceSupportVesselSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformSurfaceSupportVesselSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
