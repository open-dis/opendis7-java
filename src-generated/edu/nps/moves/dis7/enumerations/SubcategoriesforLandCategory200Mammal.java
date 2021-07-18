package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 100 marshal size 8<br>
 * SubcategoriesforLandCategory200Mammal<br>
 * 1-199 Domesticated animals, 200-255 Wild animals
 */
public enum SubcategoriesforLandCategory200Mammal implements SubCategory
{

    /** Small Dog, 1-9 Small dog (22cm/4kg) */
    SMALL_DOG (1, "Small Dog"),
    /** Chihuahua */
    CHIHUAHUA (2, "Chihuahua"),
    /** Medium Dog, 10-19 Medium dog (50cm/16kg) */
    MEDIUM_DOG (10, "Medium Dog"),
    /** Australian Cattle Dog */
    AUSTRALIAN_CATTLE_DOG (11, "Australian Cattle Dog"),
    /** Large Dog, 20-29 Large dog (65cm/40kg) */
    LARGE_DOG (20, "Large Dog"),
    /** German Shepherd */
    GERMAN_SHEPHERD (21, "German Shepherd"),
    /** Very Large Dog, 30-39 Very large dog(76cm/61kg) */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Very Large Dog"),
    /** Giant Turkish Kangal */
    GIANT_TURKISH_KANGAL (31, "Giant Turkish Kangal"),
    /** Sheep, 40-49 Small Livestock (sheep/ goat) */
    SHEEP (40, "Sheep"),
    /** Goat */
    GOAT (41, "Goat"),
    /** Pig, 50-59 Pig */
    LIVE_ENTITY_DETONATION (50, "Pig"),
    /** Cow, 60-69 Medium Livestock (cow/steer/bull/oxen) */
    DATA_RELIABLE (60, "Cow"),
    /** Ox */
    EVENT_REPORT_RELIABLE (61, "Ox"),
    /** Ox With Cart, 70-79 Medium Livestock harnessed (cart/plow) */
    OX_WITH_CART (70, "Ox With Cart"),
    /** Horse, 80-89 Horse/mule/donkey */
    HORSE (80, "Horse"),
    /** Donkey */
    DONKEY (81, "Donkey"),
    /** Mule */
    MULE (82, "Mule"),
    /** Horse With Rider, 90-99 Horse/mule/donkey with rider or cargo */
    HORSE_WITH_RIDER (90, "Horse With Rider"),
    /** Horse With Cargo */
    HORSE_WITH_CARGO (91, "Horse With Cargo"),
    /** Donkey With Rider */
    DONKEY_WITH_RIDER (92, "Donkey With Rider"),
    /** Donkey With Cargo */
    DONKEY_WITH_CARGO (93, "Donkey With Cargo"),
    /** Mule With Rider */
    MULE_WITH_RIDER (94, "Mule With Rider"),
    /** Mule With Cargo */
    MULE_WITH_CARGO (95, "Mule With Cargo"),
    /** Camel, 100-109 Camel */
    CAMEL (100, "Camel"),
    /** Dromedary Camel (One Hump) */
    DROMEDARY_CAMEL_ONE_HUMP (101, "Dromedary Camel (One Hump)"),
    /** Bactrian Camel (Two Humps) */
    BACTRIAN_CAMEL_TWO_HUMPS (102, "Bactrian Camel (Two Humps)"),
    /** Dromedary Camel With Rider, 110-119 Camel with rider or cargo */
    DROMEDARY_CAMEL_WITH_RIDER (110, "Dromedary Camel With Rider"),
    /** Dromedary Camel With Cargo */
    DROMEDARY_CAMEL_WITH_CARGO (111, "Dromedary Camel With Cargo"),
    /** Rat, 200-209 Rodent */
    RAT (200, "Rat");

    private int value;
    private final String description;

    /** Constructor */
    SubcategoriesforLandCategory200Mammal(int value, String description)
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
    public static SubcategoriesforLandCategory200Mammal getEnumForValue(int i)
    {
       for(SubcategoriesforLandCategory200Mammal val: SubcategoriesforLandCategory200Mammal.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforLandCategory200Mammal");
       System.err.flush(); // ensure contiguous console outputs
       return null;
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
    public static SubcategoriesforLandCategory200Mammal unmarshalEnum (DataInputStream dis) throws Exception
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
    public static SubcategoriesforLandCategory200Mammal unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "SubcategoriesforLandCategory200Mammal " + padding + getValue() + " " + name();
    }
}
