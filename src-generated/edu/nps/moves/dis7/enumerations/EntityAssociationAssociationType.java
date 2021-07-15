package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 330 marshal size 8<br>
 * EntityAssociationAssociationType
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

    /** Constructor */
    EntityAssociationAssociationType(int value, String description)
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
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static EntityAssociationAssociationType getEnumForValue(int i)
    {
       for(EntityAssociationAssociationType val: EntityAssociationAssociationType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityAssociationAssociationType");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EntityAssociationAssociationType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EntityAssociationAssociationType unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        String padding = new String();
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "EntityAssociationAssociationType " + padding + getValue() + " " + name();
    }
}
