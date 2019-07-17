package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 715 marshal size 16<br>
 * Island Subcategory
 */
public enum IslandSubcategory implements SubCategory
{
    /** Other */
    OTHER (0, "Other"),
    /** Islands 1,000-2,499 km2 (386-965 sq mi) */
    ISLANDS_1_000_2_499_KM2_386_965_SQ_MI (1, "Islands 1,000-2,499 km2 (386-965 sq mi)"),
    /** Islands 2,500-4,999 km2 (965-1,930 sq mi) */
    ISLANDS_2_500_4_999_KM2_965_1_930_SQ_MI (2, "Islands 2,500-4,999 km2 (965-1,930 sq mi)"),
    /** Islands 5,000-9,999 km2 (1,931-3,861 sq mi) */
    ISLANDS_5_000_9_999_KM2_1_931_3_861_SQ_MI (3, "Islands 5,000-9,999 km2 (1,931-3,861 sq mi)"),
    /** Islands 10,000-24,999 km2 (3,861-9,652 sq mi) */
    ISLANDS_10_000_24_999_KM2_3_861_9_652_SQ_MI (4, "Islands 10,000-24,999 km2 (3,861-9,652 sq mi)"),
    /** Islands 25,000-99,999 km2 (9,653-38,610 sq mi) */
    ISLANDS_25_000_99_999_KM2_9_653_38_610_SQ_MI (5, "Islands 25,000-99,999 km2 (9,653-38,610 sq mi)"),
    /** Islands 100,000 km2 (39,000 sq mi) and Greater */
    ISLANDS_100_000_KM2_39_000_SQ_MI_AND_GREATER (6, "Islands 100,000 km2 (39,000 sq mi) and Greater");

    private int value;
    private final String description;

    IslandSubcategory(int value, String description)
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
      return 16;
    }

    public static IslandSubcategory getEnumForValue(int i)
    {
       for(IslandSubcategory val: IslandSubcategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IslandSubcategory");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static IslandSubcategory unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static IslandSubcategory unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
