package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 73 marshal size 32<br>
 * EventReportEventType
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

    /** Constructor */
    EventReportEventType(int value, String description)
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
      return 32;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static EventReportEventType getEnumForValue(int i)
    {
       for(EventReportEventType val: EventReportEventType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EventReportEventType");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output */
    public void marshal(ByteBuffer byteBuffer)
    {
        byteBuffer.putInt(getValue());
    }

    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EventReportEventType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @return enumeration of interest */
    public static EventReportEventType unmarshalEnum (ByteBuffer byteBuffer)
    {
        return getEnumForValue(byteBuffer.getInt());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
    
    @Override
    public String toString()
    {
        return "EventReportEventType: " + getValue() + " " + name();
    }
}
