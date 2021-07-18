package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 208 marshal size 8<br>
 * AggregateStateSubcategory
 */
public enum AggregateStateSubcategory implements SubCategory
{
    /** Other */
    OTHER (0, "Other"),
    /** Cavalry Troop */
    CAVALRY_TROOP (1, "Cavalry Troop"),
    /** Armor */
    ARMOR (2, "Armor"),
    /** Infantry */
    INFANTRY (3, "Infantry"),
    /** Mechanized Infantry */
    MECHANIZED_INFANTRY (4, "Mechanized Infantry"),
    /** Cavalry */
    CAVALRY (5, "Cavalry"),
    /** Armored Cavalry */
    ARMORED_CAVALRY (6, "Armored Cavalry"),
    /** Artillery */
    ARTILLERY (7, "Artillery"),
    /** Self-Propelled Artillery */
    SELF_PROPELLED_ARTILLERY (8, "Self-Propelled Artillery"),
    /** Close Air Support */
    CLOSE_AIR_SUPPORT (9, "Close Air Support"),
    /** Engineer */
    ENGINEER (10, "Engineer"),
    /** Air Defense Artillery */
    AIR_DEFENSE_ARTILLERY (11, "Air Defense Artillery"),
    /** Anti-Tank */
    ANTI_TANK (12, "Anti-Tank"),
    /** Army Aviation Fixed-wing */
    ARMY_AVIATION_FIXED_WING (13, "Army Aviation Fixed-wing"),
    /** Army Aviation Rotary-wing */
    ARMY_AVIATION_ROTARY_WING (14, "Army Aviation Rotary-wing"),
    /** Army Attack Helicopter */
    ARMY_ATTACK_HELICOPTER (15, "Army Attack Helicopter"),
    /** Air Cavalry */
    AIR_CAVALRY (16, "Air Cavalry"),
    /** Armor Heavy Task Force */
    ARMOR_HEAVY_TASK_FORCE (17, "Armor Heavy Task Force"),
    /** Motorized Rifle */
    MOTORIZED_RIFLE (18, "Motorized Rifle"),
    /** Mechanized Heavy Task Force */
    MECHANIZED_HEAVY_TASK_FORCE (19, "Mechanized Heavy Task Force"),
    /** Command Post */
    COMMAND_POST (20, "Command Post"),
    /** CEWI */
    CEWI (21, "CEWI"),
    /** Tank only */
    TANK_ONLY (22, "Tank only");

    private int value;
    private final String description;

    /** Constructor */
    AggregateStateSubcategory(int value, String description)
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
    public static AggregateStateSubcategory getEnumForValue(int i)
    {
       for(AggregateStateSubcategory val: AggregateStateSubcategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration AggregateStateSubcategory");
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
    public static AggregateStateSubcategory unmarshalEnum (DataInputStream dis) throws Exception
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
    public static AggregateStateSubcategory unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "AggregateStateSubcategory " + padding + getValue() + " " + name();
    }
}
