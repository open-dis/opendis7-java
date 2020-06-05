package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 427 marshal size 8<br>
 * Platform-Land-Motorcycle Subcategories<br>
 * Subcategories for Land Platform Category 80
 */
public enum PlatformLandMotorcycleSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Scooter (Small) */
    SCOOTER_SMALL (1, "Scooter (Small)"),
    /** Sport/Street (Mid-Size) */
    SPORT_STREET_MID_SIZE (2, "Sport/Street (Mid-Size)"),
    /** Cruiser (Large) */
    CRUISER_LARGE (3, "Cruiser (Large)"),
    /** Dirt Bike */
    DIRT_BIKE (4, "Dirt Bike");

    private int value;
    private final String description;

    PlatformLandMotorcycleSubcategories(int value, String description)
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

    public static PlatformLandMotorcycleSubcategories getEnumForValue(int i)
    {
       for(PlatformLandMotorcycleSubcategories val: PlatformLandMotorcycleSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandMotorcycleSubcategories");
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

    public static PlatformLandMotorcycleSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformLandMotorcycleSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformLandMotorcycleSubcategories: " + name() + ": " + getValue(); 
    }
}
