package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 130 marshal size 8<br>
 * AnimalLifeformGroupSizeRangeEnumerationforallDomains<br>
 * The gaps in enumeration values are intentional and are reserved for future additions.
 */
public enum AnimalLifeformGroupSizeRangeEnumerationforallDomains 
{

    /** Number of animals range from 201 to 249 */
    NUMBER_OF_ANIMALS_RANGE_FROM_201_TO_249 (201, "Number of animals range from 201 to 249"),
    /** Number of animals range from 250 to 299 */
    NUMBER_OF_ANIMALS_RANGE_FROM_250_TO_299 (202, "Number of animals range from 250 to 299"),
    /** Number of animals range from 300 to 399 */
    NUMBER_OF_ANIMALS_RANGE_FROM_300_TO_399 (203, "Number of animals range from 300 to 399"),
    /** Number of animals range from 400 to 499 */
    NUMBER_OF_ANIMALS_RANGE_FROM_400_TO_499 (204, "Number of animals range from 400 to 499"),
    /** Number of animals range from 500 to 999 */
    NUMBER_OF_ANIMALS_RANGE_FROM_500_TO_999 (205, "Number of animals range from 500 to 999"),
    /** Number of animals range from 1,000 to 1,499 */
    NUMBER_OF_ANIMALS_RANGE_FROM_1_000_TO_1_499 (206, "Number of animals range from 1,000 to 1,499"),
    /** Number of animals range from 1,500 to 1,999 */
    NUMBER_OF_ANIMALS_RANGE_FROM_1_500_TO_1_999 (207, "Number of animals range from 1,500 to 1,999"),
    /** Number of animals range from 2,000 to 2,999 */
    NUMBER_OF_ANIMALS_RANGE_FROM_2_000_TO_2_999 (208, "Number of animals range from 2,000 to 2,999"),
    /** Number of animals range from 3,000 to 4,999 */
    NUMBER_OF_ANIMALS_RANGE_FROM_3_000_TO_4_999 (210, "Number of animals range from 3,000 to 4,999"),
    /** Number of animals range from 5,000 to 6,999 */
    NUMBER_OF_ANIMALS_RANGE_FROM_5_000_TO_6_999 (212, "Number of animals range from 5,000 to 6,999"),
    /** Number of animals range from 7,000 to 9,999 */
    NUMBER_OF_ANIMALS_RANGE_FROM_7_000_TO_9_999 (214, "Number of animals range from 7,000 to 9,999"),
    /** Number of animals range from 10,000 to 19,999 */
    NUMBER_OF_ANIMALS_RANGE_FROM_10_000_TO_19_999 (216, "Number of animals range from 10,000 to 19,999"),
    /** Number of animals range from 20,000 to 50,000 */
    NUMBER_OF_ANIMALS_RANGE_FROM_20_000_TO_50_000 (218, "Number of animals range from 20,000 to 50,000"),
    /** Number of animals range greater than 50,000 */
    NUMBER_OF_ANIMALS_RANGE_GREATER_THAN_50_000 (220, "Number of animals range greater than 50,000");

    private int value;
    private final String description;

    /** Constructor */
    AnimalLifeformGroupSizeRangeEnumerationforallDomains(int value, String description)
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
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static AnimalLifeformGroupSizeRangeEnumerationforallDomains getEnumForValue(int i)
    {
       for(AnimalLifeformGroupSizeRangeEnumerationforallDomains val: AnimalLifeformGroupSizeRangeEnumerationforallDomains.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration AnimalLifeformGroupSizeRangeEnumerationforallDomains");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    private boolean TRACE = false;

    /** Set tracing on/off for this object 
     * @param value whether tracing is on or off */
    public void setTRACE (boolean value)
    {
        TRACE = value;
    }

    /** Whether tracing is on or off for this object
     * @return whether tracing is on or off */
    public boolean getTRACE ()
    {
        return TRACE;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static AnimalLifeformGroupSizeRangeEnumerationforallDomains unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static AnimalLifeformGroupSizeRangeEnumerationforallDomains unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        String padding = new String();
        if (this.getClass().getName().endsWith("DisPduType") && (getValue() < 10))
            padding = "0"; // leading zero for column spacing
        String result = "DisPduType " + padding + getValue() + " " + name();
        if (getTRACE())
            System.out.println ("*** enum " + this.getClass().getName() + " name=" + name() + ", value=" + getValue() + "; " +
               result); // debug diagnostic
        return result;
    }
}
