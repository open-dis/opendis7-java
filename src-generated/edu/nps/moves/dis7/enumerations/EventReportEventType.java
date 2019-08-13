package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 73 marshal size 32<br>
 * Event Report-Event Type
 */
public enum EventReportEventType 
{
    /** Other */
    OTHER (0, "Other"),
    /** Ran Out of Ammunition */
    RAN_OUT_OF_AMMUNITION (2, "Ran Out of Ammunition"),
    /** Killed in Action (KIA) */
    KILLED_IN_ACTION_KIA (3, "Killed in Action (KIA)"),
    /** Damage */
    DAMAGE (4, "Damage"),
    /** Mobility Disabled */
    MOBILITY_DISABLED (5, "Mobility Disabled"),
    /** Fire Disabled */
    FIRE_DISABLED (6, "Fire Disabled"),
    /** Ran Out of Fuel */
    RAN_OUT_OF_FUEL (7, "Ran Out of Fuel"),
    /** Entity Initialization */
    ENTITY_INITIALIZATION (8, "Entity Initialization"),
    /** Request for Indirect Fire or CAS Mission */
    REQUEST_FOR_INDIRECT_FIRE_OR_CAS_MISSION (9, "Request for Indirect Fire or CAS Mission"),
    /** Indirect Fire or CAS Fire */
    INDIRECT_FIRE_OR_CAS_FIRE (10, "Indirect Fire or CAS Fire"),
    /** Minefield Entry */
    MINEFIELD_ENTRY (11, "Minefield Entry"),
    /** Minefield Detonation */
    MINEFIELD_DETONATION (12, "Minefield Detonation"),
    /** Vehicle Master Power On */
    VEHICLE_MASTER_POWER_ON (13, "Vehicle Master Power On"),
    /** Vehicle Master Power Off */
    VEHICLE_MASTER_POWER_OFF (14, "Vehicle Master Power Off"),
    /** Aggregate State Change Requested */
    AGGREGATE_STATE_CHANGE_REQUESTED (15, "Aggregate State Change Requested"),
    /** Prevent Collision / Detonation */
    PREVENT_COLLISION_DETONATION (16, "Prevent Collision / Detonation"),
    /** Ownership Report */
    OWNERSHIP_REPORT (17, "Ownership Report"),
    /** Radar Perception */
    RADAR_PERCEPTION (18, "Radar Perception"),
    /** Detect */
    DETECT (19, "Detect");

    private int value;
    private final String description;

    EventReportEventType(int value, String description)
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
      return 32;
    }

    public static EventReportEventType getEnumForValue(int i)
    {
       for(EventReportEventType val: EventReportEventType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EventReportEventType");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    public void marshal(ByteBuffer buff)
    {
        buff.putInt(getValue());
    }

    public static EventReportEventType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    public static EventReportEventType unmarshalEnum (ByteBuffer buff)
    {
        return getEnumForValue(buff.getInt());
    }

    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
}
