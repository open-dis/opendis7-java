package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 5 marshal size 8<br>
 * DISProtocolFamily
 */
public enum DISProtocolFamily 
{
    /** Other */
    OTHER (0, "Other"),
    /** Entity Information/Interaction */
    ENTITY_INFORMATION_INTERACTION (1, "Entity Information/Interaction"),
    /** Warfare */
    WARFARE (2, "Warfare"),
    /** Logistics */
    LOGISTICS (3, "Logistics"),
    /** Radio Communications */
    RADIO_COMMUNICATIONS (4, "Radio Communications"),
    /** Simulation Management */
    SIMULATION_MANAGEMENT (5, "Simulation Management"),
    /** Distributed Emission Regeneration */
    DISTRIBUTED_EMISSION_REGENERATION (6, "Distributed Emission Regeneration"),
    /** Entity Management */
    ENTITY_MANAGEMENT (7, "Entity Management"),
    /** Minefield */
    MINEFIELD (8, "Minefield"),
    /** Synthetic Environment */
    SYNTHETIC_ENVIRONMENT (9, "Synthetic Environment"),
    /** Simulation Management with Reliability */
    SIMULATION_MANAGEMENT_WITH_RELIABILITY (10, "Simulation Management with Reliability"),
    /** Live Entity (LE) Information/Interaction */
    LIVE_ENTITY_LE_INFORMATION_INTERACTION (11, "Live Entity (LE) Information/Interaction"),
    /** Non-Real-Time */
    NON_REAL_TIME (12, "Non-Real-Time"),
    /** Information Operations */
    INFORMATION_OPERATIONS (13, "Information Operations");

    private int value;
    private final String description;

    /** Constructor */
    DISProtocolFamily(int value, String description)
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
    public static DISProtocolFamily getEnumForValue(int i)
    {
       for(DISProtocolFamily val: DISProtocolFamily.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DISProtocolFamily");
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
    public static DISProtocolFamily unmarshalEnum (DataInputStream dis) throws Exception
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
    public static DISProtocolFamily unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "DISProtocolFamily " + padding + getValue() + " " + name();
    }
}
