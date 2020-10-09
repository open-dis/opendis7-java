package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 347 marshal size 3<br>
 * ModeSInterrogatorStatusTransmitState
 */
public enum ModeSInterrogatorStatusTransmitState 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Roll-Call */
    ROLL_CALL (1, "Roll-Call"),
    /** All Call */
    ALL_CALL (2, "All Call"),
    /** Lockout Override */
    LOCKOUT_OVERRIDE (3, "Lockout Override"),
    /** Temporary Lockout */
    TEMPORARY_LOCKOUT (4, "Temporary Lockout"),
    /** Intermittent Lockout */
    INTERMITTENT_LOCKOUT (5, "Intermittent Lockout");

    private int value;
    private final String description;

    ModeSInterrogatorStatusTransmitState(int value, String description)
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
      return 3;
    }

    public static ModeSInterrogatorStatusTransmitState getEnumForValue(int i)
    {
       for(ModeSInterrogatorStatusTransmitState val: ModeSInterrogatorStatusTransmitState.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ModeSInterrogatorStatusTransmitState");
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

    public static ModeSInterrogatorStatusTransmitState unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static ModeSInterrogatorStatusTransmitState unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "ModeSInterrogatorStatusTransmitState " + getValue() + " " + name(); 
    }
}
