package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 446 marshal size 8<br>
 * Platform-Surface Private Sailboat Subcategories<br>
 * Subcategories for Surface Platform Category 85.
 */
public enum PlatformSurfacePrivateSailboatSubcategories implements SubCategory
{

    /** Small Sailboat (up to 26ft/7.9m) */
    SMALL_SAILBOAT_UP_TO_26FT_79M (1, "Small Sailboat (up to 26ft/7.9m)"),
    /** Medium Sailboat (up to 39ft/11.9m) */
    MEDIUM_SAILBOAT_UP_TO_39FT_119M (2, "Medium Sailboat (up to 39ft/11.9m)"),
    /** Large Sailboat (up to 65ft/19.8m) */
    LARGE_SAILBOAT_UP_TO_65FT_198M (3, "Large Sailboat (up to 65ft/19.8m)"),
    /** Very Large Sailboat (greater than 65ft/19.8m) */
    VERY_LARGE_SAILBOAT_GREATER_THAN_65FT_198M (4, "Very Large Sailboat (greater than 65ft/19.8m)");

    private int value;
    private final String description;

    PlatformSurfacePrivateSailboatSubcategories(int value, String description)
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

    public static PlatformSurfacePrivateSailboatSubcategories getEnumForValue(int i)
    {
       for(PlatformSurfacePrivateSailboatSubcategories val: PlatformSurfacePrivateSailboatSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfacePrivateSailboatSubcategories");
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

    public static PlatformSurfacePrivateSailboatSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformSurfacePrivateSailboatSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
