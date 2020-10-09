package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
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

    IsPartOfStationName(int value, String description)
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

    public static IsPartOfStationName getEnumForValue(int i)
    {
       for(IsPartOfStationName val: IsPartOfStationName.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IsPartOfStationName");
       return null;
    }

 
   public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }

    public static IsPartOfStationName unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

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
