package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 72 marshal size 32<br>
 * ActionResponseRequestStatus
 */
public enum ActionResponseRequestStatus 
{
    /** Other */
    OTHER (0, "Other"),
    /** Pending */
    PENDING (1, "Pending"),
    /** Executing */
    EXECUTING (2, "Executing"),
    /** Partially Complete */
    PARTIALLY_COMPLETE (3, "Partially Complete"),
    /** Complete */
    COMPLETE (4, "Complete"),
    /** Request rejected */
    REQUEST_REJECTED (5, "Request rejected"),
    /** Retransmit request now */
    RETRANSMIT_REQUEST_NOW (6, "Retransmit request now"),
    /** Retransmit request later */
    RETRANSMIT_REQUEST_LATER (7, "Retransmit request later"),
    /** Invalid time parameters */
    INVALID_TIME_PARAMETERS (8, "Invalid time parameters"),
    /** Simulation time exceeded */
    SIMULATION_TIME_EXCEEDED (9, "Simulation time exceeded"),
    /** Request done */
    REQUEST_DONE (10, "Request done"),
    /** TACCSF LOS Reply-Type 1 */
    TACCSF_LOS_REPLY_TYPE_1 (100, "TACCSF LOS Reply-Type 1"),
    /** TACCSF LOS Reply-Type 2 */
    TACCSF_LOS_REPLY_TYPE_2 (101, "TACCSF LOS Reply-Type 2"),
    /** Join Exercise Request Rejected */
    JOIN_EXERCISE_REQUEST_REJECTED (201, "Join Exercise Request Rejected");

    private int value;
    private final String description;

    /** Constructor */
    ActionResponseRequestStatus(int value, String description)
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
    public static ActionResponseRequestStatus getEnumForValue(int i)
    {
       for(ActionResponseRequestStatus val: ActionResponseRequestStatus.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration ActionResponseRequestStatus");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output */
    public void marshal(ByteBuffer byteBuffer)
    {
        byteBuffer.putInt(getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static ActionResponseRequestStatus unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @return enumeration of interest */
    public static ActionResponseRequestStatus unmarshalEnum (ByteBuffer byteBuffer)
    {
        return getEnumForValue(byteBuffer.getInt());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
    
    @Override
    public String toString()
    {
        return "ActionResponseRequestStatus: " + getValue() + " " + name();
    }
}
