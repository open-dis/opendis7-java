package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 330 marshal size 8<br>
 * Entity Association-Association Type
 */
public enum EntityAssociationAssociationType 
{
    /** Other */
    OTHER (0, "Other"),
    /** Target Entity */
    TARGET_ENTITY (1, "Target Entity"),
    /** Target Location */
    TARGET_LOCATION (2, "Target Location"),
    /** Home Base Location */
    HOME_BASE_LOCATION (3, "Home Base Location"),
    /** CAP Point Location */
    CAP_POINT_LOCATION (4, "CAP Point Location"),
    /** Flight Leader */
    FLIGHT_LEADER (5, "Flight Leader"),
    /** Flight Member */
    FLIGHT_MEMBER (6, "Flight Member"),
    /** IP Point */
    IP_POINT (7, "IP Point"),
    /** Rendezvous Point */
    RENDEZVOUS_POINT (8, "Rendezvous Point"),
    /** On-Station Location */
    ON_STATION_LOCATION (9, "On-Station Location"),
    /** Landing Zone Location */
    LANDING_ZONE_LOCATION (10, "Landing Zone Location"),
    /** Downed Pilot */
    DOWNED_PILOT (11, "Downed Pilot"),
    /** Tanker Entity that Is Currently Refueling the Transferred Entity */
    TANKER_ENTITY_THAT_IS_CURRENTLY_REFUELING_THE_TRANSFERRED_ENTITY (12, "Tanker Entity that Is Currently Refueling the Transferred Entity"),
    /** Tanker Entity the Transferred Entity Is Headed towards to Refuel */
    TANKER_ENTITY_THE_TRANSFERRED_ENTITY_IS_HEADED_TOWARDS_TO_REFUEL (13, "Tanker Entity the Transferred Entity Is Headed towards to Refuel"),
    /** Entity Headed towards to Join Up With */
    ENTITY_HEADED_TOWARDS_TO_JOIN_UP_WITH (14, "Entity Headed towards to Join Up With");

    private int value;
    private final String description;

    EntityAssociationAssociationType(int value, String description)
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

    public static EntityAssociationAssociationType getEnumForValue(int i)
    {
       for(EntityAssociationAssociationType val: EntityAssociationAssociationType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityAssociationAssociationType");
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

    public static EntityAssociationAssociationType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static EntityAssociationAssociationType unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
}
