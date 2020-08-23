package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 62 marshal size 8<br>
 * _________________
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
    KILL_WITH_FRAGMENT_TYPE_3 (28, "Kill with fragment type 3"),
    /** Kill with fragment type 1 after fly-out failure */
    KILL_WITH_FRAGMENT_TYPE_1_AFTER_FLY_OUT_FAILURE (29, "Kill with fragment type 1 after fly-out failure"),
    /** Kill with fragment type 2 after fly-out failure */
    KILL_WITH_FRAGMENT_TYPE_2_AFTER_FLY_OUT_FAILURE (30, "Kill with fragment type 2 after fly-out failure"),
    /** Miss due to fly-out failure */
    MISS_DUE_TO_FLY_OUT_FAILURE (31, "Miss due to fly-out failure"),
    /** Miss due to end-game failure */
    MISS_DUE_TO_END_GAME_FAILURE (32, "Miss due to end-game failure"),
    /** Miss due to fly-out and end-game failure */
    MISS_DUE_TO_FLY_OUT_AND_END_GAME_FAILURE (33, "Miss due to fly-out and end-game failure");

    private int value;
    private final String description;

    DetonationResult(int value, String description)
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

    public static DetonationResult getEnumForValue(int i)
    {
       for(DetonationResult val: DetonationResult.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DetonationResult");
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

    public static DetonationResult unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "DetonationResult: " + name() + ": " + getValue(); 
    }
}
