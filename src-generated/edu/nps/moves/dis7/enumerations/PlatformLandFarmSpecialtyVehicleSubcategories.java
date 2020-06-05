package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 435 marshal size 8<br>
 * Platform-Land-Farm Specialty Vehicle Subcategories<br>
 * Subcategories for Land Platform Category 88
 */
public enum PlatformLandFarmSpecialtyVehicleSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Tractor */
    TRACTOR (1, "Tractor"),
    /** Harvester/Reaper */
    HARVESTER_REAPER (2, "Harvester/Reaper"),
    /** Skidder */
    SKIDDER (3, "Skidder"),
    /** Forwarder */
    FORWARDER (4, "Forwarder"),
    /** Lawn Mower, Other */
    LAWN_MOWER_OTHER (5, "Lawn Mower, Other"),
    /** Lawn Mower, Riding */
    LAWN_MOWER_RIDING (6, "Lawn Mower, Riding"),
    /** Lawn Mower, Standing */
    LAWN_MOWER_STANDING (7, "Lawn Mower, Standing"),
    /** Lawn Mower, Push */
    LAWN_MOWER_PUSH (8, "Lawn Mower, Push");

    private int value;
    private final String description;

    PlatformLandFarmSpecialtyVehicleSubcategories(int value, String description)
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

    public static PlatformLandFarmSpecialtyVehicleSubcategories getEnumForValue(int i)
    {
       for(PlatformLandFarmSpecialtyVehicleSubcategories val: PlatformLandFarmSpecialtyVehicleSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandFarmSpecialtyVehicleSubcategories");
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

    public static PlatformLandFarmSpecialtyVehicleSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformLandFarmSpecialtyVehicleSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformLandFarmSpecialtyVehicleSubcategories: " + name() + ": " + getValue(); 
    }
}
