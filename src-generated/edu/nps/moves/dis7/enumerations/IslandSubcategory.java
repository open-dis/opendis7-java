package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 715 marshal size 16<br>
 * IslandSubcategory
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

    /** Constructor */
    IslandSubcategory(int value, String description)
    {
        this.value = value;
        this.description = description;
    }
    /** Provide enumeration value
      * @return integer value */
    public int getValue()
    {
        return value;
    }

    /** Provide enumeration description
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /** bit width for this enumeration
     * @return number of bits wide
     */
    public static int getEnumBitWidth()
    {
      return 16;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static IslandSubcategory getEnumForValue(int i)
    {
       for(IslandSubcategory val: IslandSubcategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration IslandSubcategory");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static IslandSubcategory unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static IslandSubcategory unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "IslandSubcategory " + getValue() + " " + name(); 
    }
}
