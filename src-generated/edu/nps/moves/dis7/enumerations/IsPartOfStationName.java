package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 212 marshal size 16<br>
 * IsPartOfStationName
 */
public enum IsPartOfStationName 
{
    /** Other */
    OTHER (0, "Other"),
    /** Aircraft Wingstation */
    AIRCRAFT_WINGSTATION (1, "Aircraft Wingstation"),
    /** Ships Forward Gunmount (Starboard) */
    SHIPS_FORWARD_GUNMOUNT_STARBOARD (2, "Ships Forward Gunmount (Starboard)"),
    /** Ships Forward Gunmount (Port) */
    SHIPS_FORWARD_GUNMOUNT_PORT (3, "Ships Forward Gunmount (Port)"),
    /** Ships Forward Gunmount (Centerline) */
    SHIPS_FORWARD_GUNMOUNT_CENTERLINE (4, "Ships Forward Gunmount (Centerline)"),
    /** Ships Aft Gunmount (Starboard) */
    SHIPS_AFT_GUNMOUNT_STARBOARD (5, "Ships Aft Gunmount (Starboard)"),
    /** Ships Aft Gunmount (Port) */
    SHIPS_AFT_GUNMOUNT_PORT (6, "Ships Aft Gunmount (Port)"),
    /** Ships Aft Gunmount (Centerline) */
    SHIPS_AFT_GUNMOUNT_CENTERLINE (7, "Ships Aft Gunmount (Centerline)"),
    /** Forward Torpedo Tube */
    FORWARD_TORPEDO_TUBE (8, "Forward Torpedo Tube"),
    /** Aft Torpedo Tube */
    AFT_TORPEDO_TUBE (9, "Aft Torpedo Tube"),
    /** Bomb Bay */
    BOMB_BAY (10, "Bomb Bay"),
    /** Cargo Bay */
    CARGO_BAY (11, "Cargo Bay"),
    /** Truck Bed */
    TRUCK_BED (12, "Truck Bed"),
    /** Trailer Bed */
    TRAILER_BED (13, "Trailer Bed"),
    /** Well Deck */
    WELL_DECK (14, "Well Deck"),
    /** On Station Range and Bearing */
    ON_STATION_RANGE_AND_BEARING (15, "On Station Range and Bearing"),
    /** On Station xyz */
    ON_STATION_XYZ (16, "On Station xyz"),
    /** Air-to-Air Refueling Boom */
    AIR_TO_AIR_REFUELING_BOOM (17, "Air-to-Air Refueling Boom"),
    /** Aerial Refueling Receptacle */
    AERIAL_REFUELING_RECEPTACLE (18, "Aerial Refueling Receptacle"),
    /** Port Side Refueling Drogue */
    PORT_SIDE_REFUELING_DROGUE (19, "Port Side Refueling Drogue"),
    /** Starboard Side Refueling Drogue */
    STARBOARD_SIDE_REFUELING_DROGUE (20, "Starboard Side Refueling Drogue"),
    /** Center Refueling Drogue */
    CENTER_REFUELING_DROGUE (21, "Center Refueling Drogue"),
    /** Air Refueling Probe */
    AIR_REFUELING_PROBE (22, "Air Refueling Probe");

    private int value;
    private final String description;

    /** Constructor */
    IsPartOfStationName(int value, String description)
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
      return 16;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static IsPartOfStationName getEnumForValue(int i)
    {
       for(IsPartOfStationName val: IsPartOfStationName.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IsPartOfStationName");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static IsPartOfStationName unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static IsPartOfStationName unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "IsPartOfStationName " + getValue() + " " + name(); 
    }
}
