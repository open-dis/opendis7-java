package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 374 marshal size 1<br>
 * DE Fire-Flags-State/Update Flag
 */
public enum DEFireFlagsStateUpdateFlag 
{
    /** Update Due to Heartbeat Timer */
    UPDATE_DUE_TO_HEARTBEAT_TIMER (0, "Update Due to Heartbeat Timer"),
    /** State Change */
    STATE_CHANGE (1, "State Change");

    private int value;
    private final String description;

    DEFireFlagsStateUpdateFlag(int value, String description)
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
      return 1;
    }

    public static DEFireFlagsStateUpdateFlag getEnumForValue(int i)
    {
       for(DEFireFlagsStateUpdateFlag val: DEFireFlagsStateUpdateFlag.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DEFireFlagsStateUpdateFlag");
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

    public static DEFireFlagsStateUpdateFlag unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static DEFireFlagsStateUpdateFlag unmarshalEnum(ByteBuffer buff) throws Exception
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
