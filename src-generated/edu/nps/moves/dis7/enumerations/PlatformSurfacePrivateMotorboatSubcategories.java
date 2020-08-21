package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 445 marshal size 8<br>
 * PlatformSurfacePrivateMotorboatSubcategories<br>
 * Subcategories for Surface Platform Category 84.
 */
public enum PlatformSurfacePrivateMotorboatSubcategories implements SubCategory
{

    /** Small Motorboat (up to 26ft/7.9m) */
    SMALL_MOTORBOAT_UP_TO_26FT_79M (1, "Small Motorboat (up to 26ft/7.9m)"),
    /** Medium Motorboat (up to 39ft/11.9m) */
    MEDIUM_MOTORBOAT_UP_TO_39FT_119M (2, "Medium Motorboat (up to 39ft/11.9m)"),
    /** Large Motorboat (up to 65ft/19.8m) */
    LARGE_MOTORBOAT_UP_TO_65FT_198M (3, "Large Motorboat (up to 65ft/19.8m)"),
    /** Very Large Motorboat (greater than 65ft/19.8m) */
    VERY_LARGE_MOTORBOAT_GREATER_THAN_65FT_198M (4, "Very Large Motorboat (greater than 65ft/19.8m)");

    private int value;
    private final String description;

    PlatformSurfacePrivateMotorboatSubcategories(int value, String description)
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

    public static PlatformSurfacePrivateMotorboatSubcategories getEnumForValue(int i)
    {
       for(PlatformSurfacePrivateMotorboatSubcategories val: PlatformSurfacePrivateMotorboatSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfacePrivateMotorboatSubcategories");
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

    public static PlatformSurfacePrivateMotorboatSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformSurfacePrivateMotorboatSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformSurfacePrivateMotorboatSubcategories: " + name() + ": " + getValue(); 
    }
}
