package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 208 marshal size 8<br>
 * ___________________________
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

    AggregateStateSubcategory(int value, String description)
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

    public static AggregateStateSubcategory getEnumForValue(int i)
    {
       for(AggregateStateSubcategory val: AggregateStateSubcategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AggregateStateSubcategory");
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

    public static AggregateStateSubcategory unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AggregateStateSubcategory: " + name() + ": " + getValue(); 
    }
}
