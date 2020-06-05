package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 130 marshal size 8<br>
 * Animal Lifeform Group Size Range Enumeration for all Domains<br>
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

    AnimalLifeformGroupSizeRangeEnumerationforallDomains(int value, String description)
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

    public static AnimalLifeformGroupSizeRangeEnumerationforallDomains getEnumForValue(int i)
    {
       for(AnimalLifeformGroupSizeRangeEnumerationforallDomains val: AnimalLifeformGroupSizeRangeEnumerationforallDomains.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AnimalLifeformGroupSizeRangeEnumerationforallDomains");
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

    public static AnimalLifeformGroupSizeRangeEnumerationforallDomains unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AnimalLifeformGroupSizeRangeEnumerationforallDomains: " + name() + ": " + getValue(); 
    }
}
