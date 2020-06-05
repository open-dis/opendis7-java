package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 441 marshal size 8<br>
 * Platform-Surface-Passenger Vessel Subcategories<br>
 * Subcategories for Surface Platform Category 80.
 */
public enum PlatformSurfacePassengerVesselSubcategories implements SubCategory
{

    /** Cruise Ship */
    CRUISE_SHIP (1, "Cruise Ship"),
    /** Cruise Ferry */
    CRUISE_FERRY (2, "Cruise Ferry"),
    /** High Speed Ferry */
    HIGH_SPEED_FERRY (3, "High Speed Ferry"),
    /** Ferry */
    FERRY (4, "Ferry"),
    /** Ocean Liner */
    OCEAN_LINER (5, "Ocean Liner");

    private int value;
    private final String description;

    PlatformSurfacePassengerVesselSubcategories(int value, String description)
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

    public static PlatformSurfacePassengerVesselSubcategories getEnumForValue(int i)
    {
       for(PlatformSurfacePassengerVesselSubcategories val: PlatformSurfacePassengerVesselSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfacePassengerVesselSubcategories");
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

    public static PlatformSurfacePassengerVesselSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformSurfacePassengerVesselSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformSurfacePassengerVesselSubcategories: " + name() + ": " + getValue(); 
    }
}
