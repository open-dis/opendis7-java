package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 67 marshal size 8<br>
 * StopFreezeReason
 */
public enum StopFreezeReason 
{
    /** Other */
    OTHER (0, "Other"),
    /** Recess */
    RECESS (1, "Recess"),
    /** Termination */
    TERMINATION (2, "Termination"),
    /** System Failure */
    SYSTEM_FAILURE (3, "System Failure"),
    /** Security Violation */
    SECURITY_VIOLATION (4, "Security Violation"),
    /** Entity Reconstitution */
    ENTITY_RECONSTITUTION (5, "Entity Reconstitution"),
    /** Stop for reset */
    STOP_FOR_RESET (6, "Stop for reset"),
    /** Stop for restart */
    STOP_FOR_RESTART (7, "Stop for restart"),
    /** Abort Training Return to Tactical Operations */
    ABORT_TRAINING_RETURN_TO_TACTICAL_OPERATIONS (8, "Abort Training Return to Tactical Operations");

    private int value;
    private final String description;

    StopFreezeReason(int value, String description)
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

    public static StopFreezeReason getEnumForValue(int i)
    {
       for(StopFreezeReason val: StopFreezeReason.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration StopFreezeReason");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    public static StopFreezeReason unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static StopFreezeReason unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "StopFreezeReason " + getValue() + " " + name(); 
    }
}
