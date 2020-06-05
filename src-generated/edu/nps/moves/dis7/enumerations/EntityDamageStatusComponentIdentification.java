package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 314 marshal size 8<br>
 * Entity Damage Status-Component Identification
 */
public enum EntityDamageStatusComponentIdentification 
{
    /** Entity Center (No Specific Component) */
    ENTITY_CENTER_NO_SPECIFIC_COMPONENT (0, "Entity Center (No Specific Component)"),
    /** Entity Structure */
    ENTITY_STRUCTURE (1, "Entity Structure"),
    /** Control System */
    CONTROL_SYSTEM (2, "Control System"),
    /** Control Surface */
    CONTROL_SURFACE (3, "Control Surface"),
    /** Engine / Propulsion System */
    ENGINE_PROPULSION_SYSTEM (4, "Engine / Propulsion System"),
    /** Crew Member */
    CREW_MEMBER (5, "Crew Member"),
    /** Fuse */
    FUSE (6, "Fuse"),
    /** Acquisition Sensor */
    ACQUISITION_SENSOR (7, "Acquisition Sensor"),
    /** Tracking Sensor */
    TRACKING_SENSOR (8, "Tracking Sensor"),
    /** Fuel Tank / Solid Rocket Motor */
    FUEL_TANK_SOLID_ROCKET_MOTOR (9, "Fuel Tank / Solid Rocket Motor");

    private int value;
    private final String description;

    EntityDamageStatusComponentIdentification(int value, String description)
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

    public static EntityDamageStatusComponentIdentification getEnumForValue(int i)
    {
       for(EntityDamageStatusComponentIdentification val: EntityDamageStatusComponentIdentification.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityDamageStatusComponentIdentification");
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

    public static EntityDamageStatusComponentIdentification unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static EntityDamageStatusComponentIdentification unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "EntityDamageStatusComponentIdentification: " + name() + ": " + getValue(); 
    }
}
