package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
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

    /** Constructor */
    MinefieldSensorTypesOptical(int value, String description)
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
      return 12;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static MinefieldSensorTypesOptical getEnumForValue(int i)
    {
       for(MinefieldSensorTypesOptical val: MinefieldSensorTypesOptical.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration MinefieldSensorTypesOptical");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static MinefieldSensorTypesOptical unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static MinefieldSensorTypesOptical unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        return "MinefieldSensorTypesOptical " + getValue() + " " + name(); 
    }
}
