package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 133 marshal size 8<br>
 * Add Specific Dimension Enumerations for Subsurface Area Size<br>
 * The gaps in enumeration values are intentional and are reserved for future additions.
 */
public enum AddSpecificDimensionEnumerationsforSubsurfaceAreaSize 
{

    /** Small School (.5km long x 250m wide x 83m deep - 1km x .5km x 166m) */
    SMALL_SCHOOL_5KM_LONG_X_250M_WIDE_X_83M_DEEP_1KM_X_5KM_X_166M (222, "Small School (.5km long x 250m wide x 83m deep - 1km x .5km x 166m)"),
    /** Small School, Dense (.5km long x 250m wide x 83m deep - 1km x .5km x 166m) */
    SMALL_SCHOOL_DENSE_5KM_LONG_X_250M_WIDE_X_83M_DEEP_1KM_X_5KM_X_166M (223, "Small School, Dense (.5km long x 250m wide x 83m deep - 1km x .5km x 166m)"),
    /** Medium School (.5km x 1km x 125m - 1km x 2km x 500m) */
    MEDIUM_SCHOOL_5KM_X_1KM_X_125M_1KM_X_2KM_X_500M (224, "Medium School (.5km x 1km x 125m - 1km x 2km x 500m)"),
    /** Medium School, Dense (.5km x 1km x 125m  - 1km x 2km x 500m) */
    MEDIUM_SCHOOL_DENSE_5KM_X_1KM_X_125M_1KM_X_2KM_X_500M (225, "Medium School, Dense (.5km x 1km x 125m  - 1km x 2km x 500m)"),
    /** Large School (5km x 2km x 500m - 10km x 4km x 1km) */
    LARGE_SCHOOL_5KM_X_2KM_X_500M_10KM_X_4KM_X_1KM (226, "Large School (5km x 2km x 500m - 10km x 4km x 1km)"),
    /** Large School, Dense (5km x 2km x 500m - 10km x 4km x 1km) */
    LARGE_SCHOOL_DENSE_5KM_X_2KM_X_500M_10KM_X_4KM_X_1KM (227, "Large School, Dense (5km x 2km x 500m - 10km x 4km x 1km)");

    private int value;
    private final String description;

    AddSpecificDimensionEnumerationsforSubsurfaceAreaSize(int value, String description)
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

    public static AddSpecificDimensionEnumerationsforSubsurfaceAreaSize getEnumForValue(int i)
    {
       for(AddSpecificDimensionEnumerationsforSubsurfaceAreaSize val: AddSpecificDimensionEnumerationsforSubsurfaceAreaSize.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AddSpecificDimensionEnumerationsforSubsurfaceAreaSize");
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

    public static AddSpecificDimensionEnumerationsforSubsurfaceAreaSize unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static AddSpecificDimensionEnumerationsforSubsurfaceAreaSize unmarshalEnum(ByteBuffer buff) throws Exception
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
    
    @Override
    public String toString()
    {
        return "AddSpecificDimensionEnumerationsforSubsurfaceAreaSize: " + name() + ": " + getValue(); 
    }
}
