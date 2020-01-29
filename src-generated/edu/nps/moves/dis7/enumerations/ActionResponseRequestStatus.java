package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 72 marshal size 32<br>
 * Action Response-Request Status
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

    ActionResponseRequestStatus(int value, String description)
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
      return 32;
    }

    public static ActionResponseRequestStatus getEnumForValue(int i)
    {
       for(ActionResponseRequestStatus val: ActionResponseRequestStatus.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ActionResponseRequestStatus");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    public void marshal(ByteBuffer buff)
    {
        buff.putInt(getValue());
    }

    public static ActionResponseRequestStatus unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    public static ActionResponseRequestStatus unmarshalEnum (ByteBuffer buff)
    {
        return getEnumForValue(buff.getInt());
    }

    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
    
    @Override
    public String toString()
    {
        return "ActionResponseRequestStatus: " + name() + ": " + getValue();
    }
}
