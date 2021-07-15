package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 210 marshal size 16<br>
 * IsPartOfNature
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

    /** Constructor */
    IsPartOfNature(int value, String description)
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
    public static IsPartOfNature getEnumForValue(int i)
    {
       for(IsPartOfNature val: IsPartOfNature.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IsPartOfNature");
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
    public static IsPartOfNature unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static IsPartOfNature unmarshalEnum (ByteBuffer byteBuffer) throws Exception
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
        return "IsPartOfNature " + getValue() + " " + name(); 
    }
}
