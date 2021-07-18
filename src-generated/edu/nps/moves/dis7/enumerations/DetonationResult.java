package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 62 marshal size 8<br>
 * DetonationResult
 */
public enum DetonationResult 
{
    /** Other */
    OTHER (0, "Other"),
    /** Entity Impact */
    ENTITY_IMPACT (1, "Entity Impact"),
    /** Entity Proximate Detonation */
    ENTITY_PROXIMATE_DETONATION (2, "Entity Proximate Detonation"),
    /** Ground Impact */
    GROUND_IMPACT (3, "Ground Impact"),
    /** Ground Proximate Detonation */
    GROUND_PROXIMATE_DETONATION (4, "Ground Proximate Detonation"),
    /** Detonation */
    DETONATION (5, "Detonation"),
    /** None or No Detonation (Dud) */
    NONE_OR_NO_DETONATION_DUD (6, "None or No Detonation (Dud)"),
    /** HE hit, small */
    HE_HIT_SMALL (7, "HE hit, small"),
    /** HE hit, medium */
    HE_HIT_MEDIUM (8, "HE hit, medium"),
    /** HE hit, large */
    HE_HIT_LARGE (9, "HE hit, large"),
    /** Armor-piercing hit */
    ARMOR_PIERCING_HIT (10, "Armor-piercing hit"),
    /** Dirt blast, small */
    DIRT_BLAST_SMALL (11, "Dirt blast, small"),
    /** Dirt blast, medium */
    DIRT_BLAST_MEDIUM (12, "Dirt blast, medium"),
    /** Dirt blast, large */
    DIRT_BLAST_LARGE (13, "Dirt blast, large"),
    /** Water blast, small */
    WATER_BLAST_SMALL (14, "Water blast, small"),
    /** Water blast, medium */
    WATER_BLAST_MEDIUM (15, "Water blast, medium"),
    /** Water blast, large */
    WATER_BLAST_LARGE (16, "Water blast, large"),
    /** Air hit */
    AIR_HIT (17, "Air hit"),
    /** Building hit, small */
    BUILDING_HIT_SMALL (18, "Building hit, small"),
    /** Building hit, medium */
    BUILDING_HIT_MEDIUM (19, "Building hit, medium"),
    /** Building hit, large */
    BUILDING_HIT_LARGE (20, "Building hit, large"),
    /** Mine-clearing line charge */
    MINE_CLEARING_LINE_CHARGE (21, "Mine-clearing line charge"),
    /** Environment object impact */
    ENVIRONMENT_OBJECT_IMPACT (22, "Environment object impact"),
    /** Environment object proximate detonation */
    ENVIRONMENT_OBJECT_PROXIMATE_DETONATION (23, "Environment object proximate detonation"),
    /** Water Impact */
    WATER_IMPACT (24, "Water Impact"),
    /** Air Burst */
    AIR_BURST (25, "Air Burst"),
    /** Kill with fragment type 1 */
    KILL_WITH_FRAGMENT_TYPE_1 (26, "Kill with fragment type 1"),
    /** Kill with fragment type 2 */
    KILL_WITH_FRAGMENT_TYPE_2 (27, "Kill with fragment type 2"),
    /** Kill with fragment type 3 */
    IDENTIFICATION_FRIEND_OR_FOE (28, "Kill with fragment type 3"),
    /** Kill with fragment type 1 after fly-out failure */
    KILL_WITH_FRAGMENT_TYPE_1_AFTER_FLY_OUT_FAILURE (29, "Kill with fragment type 1 after fly-out failure"),
    /** Kill with fragment type 2 after fly-out failure */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Kill with fragment type 2 after fly-out failure"),
    /** Miss due to fly-out failure */
    MISS_DUE_TO_FLY_OUT_FAILURE (31, "Miss due to fly-out failure"),
    /** Miss due to end-game failure */
    MISS_DUE_TO_END_GAME_FAILURE (32, "Miss due to end-game failure"),
    /** Miss due to fly-out and end-game failure */
    MISS_DUE_TO_FLY_OUT_AND_END_GAME_FAILURE (33, "Miss due to fly-out and end-game failure");

    private int value;
    private final String description;

    /** Constructor */
    DetonationResult(int value, String description)
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
    public static DetonationResult getEnumForValue(int i)
    {
       for(DetonationResult val: DetonationResult.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration DetonationResult");
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
    public static DetonationResult unmarshalEnum (DataInputStream dis) throws Exception
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
    public static DetonationResult unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "DetonationResult " + padding + getValue() + " " + name();
    }
}
