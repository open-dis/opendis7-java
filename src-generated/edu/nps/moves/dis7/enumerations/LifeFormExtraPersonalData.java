package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 477 marshal size 8<br>
 * LifeFormExtraPersonalData<br>
 * The 1s digit is reserved for Race/Ethnicity and the enumerations are taken from the U.S. OMB. The 10s digit is reserved for general age group. The 100s digit is reserved for gender, where 0 is Male and 1 is Female.
 */
public enum LifeFormExtraPersonalData 
{

    /** Not Specified (Male) */
    NOT_SPECIFIED_MALE (0, "Not Specified (Male)"),
    /** Asian (Male) */
    ASIAN_MALE (1, "Asian (Male)"),
    /** Pacific Islander (Male) */
    PACIFIC_ISLANDER_MALE (2, "Pacific Islander (Male)"),
    /** Black (Male) */
    BLACK_MALE (3, "Black (Male)"),
    /** East Asian (Male) */
    EAST_ASIAN_MALE (4, "East Asian (Male)"),
    /** Hispanic (Male) */
    HISPANIC_MALE (5, "Hispanic (Male)"),
    /** White (Male) */
    WHITE_MALE (6, "White (Male)"),
    /** Arab (Male) */
    ARAB_MALE (7, "Arab (Male)"),
    /** Homogenous Country Code (Male) */
    HOMOGENOUS_COUNTRY_CODE_MALE (8, "Homogenous Country Code (Male)"),
    /** Indigenous Country Code (Male) */
    INDIGENOUS_COUNTRY_CODE_MALE (9, "Indigenous Country Code (Male)"),
    /** Infant (0 months-1 year) (Male) */
    INFANT_0_MONTHS_1_YEAR_MALE (10, "Infant (0 months-1 year) (Male)"),
    /** Toddler (1-3 years) (Male) */
    TODDLER_1_3_YEARS_MALE (20, "Toddler (1-3 years) (Male)"),
    /** Child (3-10 years) (Male) */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Child (3-10 years) (Male)"),
    /** Adolescent (10-12 years) (Male) */
    ADOLESCENT_10_12_YEARS_MALE (40, "Adolescent (10-12 years) (Male)"),
    /** Teenager (13-16 years) (Male) */
    LIVE_ENTITY_DETONATION (50, "Teenager (13-16 years) (Male)"),
    /** Young Adult (17-25 years) (Male) */
    DATA_RELIABLE (60, "Young Adult (17-25 years) (Male)"),
    /** Adult (25-55 years) (Male) */
    ADULT_25_55_YEARS_MALE (70, "Adult (25-55 years) (Male)"),
    /** Senior Adult (55-70 years) (Male) */
    SENIOR_ADULT_55_70_YEARS_MALE (80, "Senior Adult (55-70 years) (Male)"),
    /** Elderly (71+ years) (Male) */
    ELDERLY_71PLUS_YEARS_MALE (90, "Elderly (71+ years) (Male)"),
    /** Female */
    FEMALE (100, "Female"),
    /** Asian (Female) */
    ASIAN_FEMALE (101, "Asian (Female)"),
    /** Pacific Islander (Female) */
    PACIFIC_ISLANDER_FEMALE (102, "Pacific Islander (Female)"),
    /** Black (Female) */
    BLACK_FEMALE (103, "Black (Female)"),
    /** East Asian (Female) */
    EAST_ASIAN_FEMALE (104, "East Asian (Female)"),
    /** Hispanic (Female) */
    HISPANIC_FEMALE (105, "Hispanic (Female)"),
    /** White (Female) */
    WHITE_FEMALE (106, "White (Female)"),
    /** Arab (Female) */
    ARAB_FEMALE (107, "Arab (Female)"),
    /** Homogenous Country Code (Female) */
    HOMOGENOUS_COUNTRY_CODE_FEMALE (108, "Homogenous Country Code (Female)"),
    /** Indigenous Country Code (Female) */
    INDIGENOUS_COUNTRY_CODE_FEMALE (109, "Indigenous Country Code (Female)"),
    /** Infant (0 months-1 year) (Female) */
    INFANT_0_MONTHS_1_YEAR_FEMALE (110, "Infant (0 months-1 year) (Female)"),
    /** Toddler (1-3 years) (Female) */
    TODDLER_1_3_YEARS_FEMALE (120, "Toddler (1-3 years) (Female)"),
    /** Child (3-10 years) (Female) */
    CHILD_3_10_YEARS_FEMALE (130, "Child (3-10 years) (Female)"),
    /** Adolescent (10-12 years) (Female) */
    ADOLESCENT_10_12_YEARS_FEMALE (140, "Adolescent (10-12 years) (Female)"),
    /** Teenager (13-16 years) (Female) */
    TEENAGER_13_16_YEARS_FEMALE (150, "Teenager (13-16 years) (Female)"),
    /** Young Adult (17-25 years) (Female) */
    YOUNG_ADULT_17_25_YEARS_FEMALE (160, "Young Adult (17-25 years) (Female)"),
    /** Adult (25-55 years) (Female) */
    ADULT_25_55_YEARS_FEMALE (170, "Adult (25-55 years) (Female)"),
    /** Senior Adult (55-70 years) (Female) */
    SENIOR_ADULT_55_70_YEARS_FEMALE (180, "Senior Adult (55-70 years) (Female)"),
    /** Elderly (71+ years) (Female) */
    ELDERLY_71PLUS_YEARS_FEMALE (190, "Elderly (71+ years) (Female)");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormExtraPersonalData(int value, String description)
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
    public static LifeFormExtraPersonalData getEnumForValue(int i)
    {
       for(LifeFormExtraPersonalData val: LifeFormExtraPersonalData.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormExtraPersonalData");
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
    public static LifeFormExtraPersonalData unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormExtraPersonalData unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
