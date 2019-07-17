package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 212 marshal size 16<br>
 * IsPartOf-Station Name
 */
public enum IsPartOfStationName 
{
    /** Other */
    OTHER (0, "Other"),
    /** Aircraft Wingstation */
    AIRCRAFT_WINGSTATION (1, "Aircraft Wingstation"),
    /** Ship's Forward Gunmount (Starboard) */
    SHIPS_FORWARD_GUNMOUNT_STARBOARD (2, "Ship's Forward Gunmount (Starboard)"),
    /** Ship's Forward Gunmount (Port) */
    SHIPS_FORWARD_GUNMOUNT_PORT (3, "Ship's Forward Gunmount (Port)"),
    /** Ship's Forward Gunmount (Centerline) */
    SHIPS_FORWARD_GUNMOUNT_CENTERLINE (4, "Ship's Forward Gunmount (Centerline)"),
    /** Ship's Aft Gunmount (Starboard) */
    SHIPS_AFT_GUNMOUNT_STARBOARD (5, "Ship's Aft Gunmount (Starboard)"),
    /** Ship's Aft Gunmount (Port) */
    SHIPS_AFT_GUNMOUNT_PORT (6, "Ship's Aft Gunmount (Port)"),
    /** Ship's Aft Gunmount (Centerline) */
    SHIPS_AFT_GUNMOUNT_CENTERLINE (7, "Ship's Aft Gunmount (Centerline)"),
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
    AERIAL_REFUELING_RECEPTACLE (18, "Aerial Refueling Receptacle");

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

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static IsPartOfStationName unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static IsPartOfStationName unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
