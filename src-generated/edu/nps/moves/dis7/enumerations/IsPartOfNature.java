package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 210 marshal size 16<br>
 * IsPartOf-Nature
 */
public enum IsPartOfNature 
{
    /** Other */
    OTHER (0, "Other"),
    /** Host-fireable munition */
    HOST_FIREABLE_MUNITION (1, "Host-fireable munition"),
    /** Munition carried as cargo */
    MUNITION_CARRIED_AS_CARGO (2, "Munition carried as cargo"),
    /** Fuel carried as cargo */
    FUEL_CARRIED_AS_CARGO (3, "Fuel carried as cargo"),
    /** Gunmount attached to host */
    GUNMOUNT_ATTACHED_TO_HOST (4, "Gunmount attached to host"),
    /** Computer generated forces carried as cargo */
    COMPUTER_GENERATED_FORCES_CARRIED_AS_CARGO (5, "Computer generated forces carried as cargo"),
    /** Vehicle carried as cargo */
    VEHICLE_CARRIED_AS_CARGO (6, "Vehicle carried as cargo"),
    /** Emitter mounted on host */
    EMITTER_MOUNTED_ON_HOST (7, "Emitter mounted on host"),
    /** Mobile command and control entity carried aboard host */
    MOBILE_COMMAND_AND_CONTROL_ENTITY_CARRIED_ABOARD_HOST (8, "Mobile command and control entity carried aboard host"),
    /** Entity stationed at position with respect to host */
    ENTITY_STATIONED_AT_POSITION_WITH_RESPECT_TO_HOST (9, "Entity stationed at position with respect to host"),
    /** Team member in formation with */
    TEAM_MEMBER_IN_FORMATION_WITH (10, "Team member in formation with");

    private int value;
    private final String description;

    IsPartOfNature(int value, String description)
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

    public static IsPartOfNature getEnumForValue(int i)
    {
       for(IsPartOfNature val: IsPartOfNature.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IsPartOfNature");
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

    public static IsPartOfNature unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static IsPartOfNature unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "IsPartOfNature: " + name() + ": " + getValue(); 
    }
}
