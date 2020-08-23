package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 131 marshal size 8<br>
 * __________________________________________________<br>
 * The gaps in enumeration values are intentional and are reserved for future additions.
 */
public enum SpecificDimensionEnumerationsforLandAreaSize 
{

    /** Small Area (2,000m2 - 4,000m2 / .5 to 1 sq. acre ) */
    SMALL_AREA_2_000M2_4_000M2_5_TO_1_SQ_ACRE_ (222, "Small Area (2,000m2 - 4,000m2 / .5 to 1 sq. acre )"),
    /** Small Area, Dense (2,000m2 - 4,000m2 / .5 to1 sq. acre) */
    SMALL_AREA_DENSE_2_000M2_4_000M2_5_TO1_SQ_ACRE (223, "Small Area, Dense (2,000m2 - 4,000m2 / .5 to1 sq. acre)"),
    /** Medium Area (20,000m2 - 41,000m2 / 10 to 20 sq. acres) */
    MEDIUM_AREA_20_000M2_41_000M2_10_TO_20_SQ_ACRES (224, "Medium Area (20,000m2 - 41,000m2 / 10 to 20 sq. acres)"),
    /** Medium Area, Dense (20,000m2 - 41,000m2 / 10 to 20 sq. acres) */
    MEDIUM_AREA_DENSE_20_000M2_41_000M2_10_TO_20_SQ_ACRES (225, "Medium Area, Dense (20,000m2 - 41,000m2 / 10 to 20 sq. acres)"),
    /** Large Area (40,000m2 - 81,000m2 / 20 to 40 sq. acres) */
    LARGE_AREA_40_000M2_81_000M2_20_TO_40_SQ_ACRES (226, "Large Area (40,000m2 - 81,000m2 / 20 to 40 sq. acres)"),
    /** Large Area, Dense (40,000m2 - 81,000m2 / 20 to 40 sq. acres) */
    LARGE_AREA_DENSE_40_000M2_81_000M2_20_TO_40_SQ_ACRES (227, "Large Area, Dense (40,000m2 - 81,000m2 / 20 to 40 sq. acres)");

    private int value;
    private final String description;

    SpecificDimensionEnumerationsforLandAreaSize(int value, String description)
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

    public static SpecificDimensionEnumerationsforLandAreaSize getEnumForValue(int i)
    {
       for(SpecificDimensionEnumerationsforLandAreaSize val: SpecificDimensionEnumerationsforLandAreaSize.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SpecificDimensionEnumerationsforLandAreaSize");
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

    public static SpecificDimensionEnumerationsforLandAreaSize unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SpecificDimensionEnumerationsforLandAreaSize unmarshalEnum(ByteBuffer buff) throws Exception
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

    /** Returns the size of this serialized object in bytes
     *@return size in bytes*/  
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "SpecificDimensionEnumerationsforLandAreaSize: " + name() + ": " + getValue(); 
    }
}
