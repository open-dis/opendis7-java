package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 194 marshal size 12<br>
 * MinefieldSensorTypesOptical
 */
public enum MinefieldSensorTypesOptical 
{
    /** Unaided Eye, Actively Searching */
    UNAIDED_EYE_ACTIVELY_SEARCHING (0, "Unaided Eye, Actively Searching"),
    /** Unaided Eye, Not Actively Searching */
    UNAIDED_EYE_NOT_ACTIVELY_SEARCHING (1, "Unaided Eye, Not Actively Searching"),
    /** Binoculars */
    BINOCULARS (2, "Binoculars"),
    /** Image Intensifier */
    IMAGE_INTENSIFIER (3, "Image Intensifier"),
    /** HMMWV occupant, Actively Searching */
    HMMWV_OCCUPANT_ACTIVELY_SEARCHING (4, "HMMWV occupant, Actively Searching"),
    /** HMMWV occupant, Not Actively Searching */
    HMMWV_OCCUPANT_NOT_ACTIVELY_SEARCHING (5, "HMMWV occupant, Not Actively Searching"),
    /** Truck occupant, Actively Searching */
    TRUCK_OCCUPANT_ACTIVELY_SEARCHING (6, "Truck occupant, Actively Searching"),
    /** Truck occupant, Not Actively Searching */
    TRUCK_OCCUPANT_NOT_ACTIVELY_SEARCHING (7, "Truck occupant, Not Actively Searching"),
    /** Tracked vehicle occupant, closed hatch, Actively Searching */
    TRACKED_VEHICLE_OCCUPANT_CLOSED_HATCH_ACTIVELY_SEARCHING (8, "Tracked vehicle occupant, closed hatch, Actively Searching"),
    /** Tracked vehicle occupant, closed hatch, Not Actively Searching */
    TRACKED_VEHICLE_OCCUPANT_CLOSED_HATCH_NOT_ACTIVELY_SEARCHING (9, "Tracked vehicle occupant, closed hatch, Not Actively Searching"),
    /** Tracked vehicle occupant, open hatch, Actively Searching */
    TRACKED_VEHICLE_OCCUPANT_OPEN_HATCH_ACTIVELY_SEARCHING (10, "Tracked vehicle occupant, open hatch, Actively Searching"),
    /** Tracked vehicle occupant, open hatch, Not Actively Searching */
    TRACKED_VEHICLE_OCCUPANT_OPEN_HATCH_NOT_ACTIVELY_SEARCHING (11, "Tracked vehicle occupant, open hatch, Not Actively Searching");

    private int value;
    private final String description;

    MinefieldSensorTypesOptical(int value, String description)
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
      return 12;
    }

    public static MinefieldSensorTypesOptical getEnumForValue(int i)
    {
       for(MinefieldSensorTypesOptical val: MinefieldSensorTypesOptical.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MinefieldSensorTypesOptical");
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

    public static MinefieldSensorTypesOptical unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static MinefieldSensorTypesOptical unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "MinefieldSensorTypesOptical: " + name() + ": " + getValue(); 
    }
}
