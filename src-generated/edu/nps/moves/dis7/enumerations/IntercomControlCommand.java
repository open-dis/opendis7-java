package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 182 marshal size 8<br>
 * ________________________
 */
public enum IntercomControlCommand 
{
    /** No Command */
    NO_COMMAND (0, "No Command"),
    /** Status */
    STATUS (1, "Status"),
    /** Connect */
    CONNECT (2, "Connect"),
    /** Disconnect */
    DISCONNECT (3, "Disconnect"),
    /** Reset */
    RESET (4, "Reset"),
    /** On */
    ON (5, "On"),
    /** Off */
    OFF (6, "Off");

    private int value;
    private final String description;

    IntercomControlCommand(int value, String description)
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

    public static IntercomControlCommand getEnumForValue(int i)
    {
       for(IntercomControlCommand val: IntercomControlCommand.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IntercomControlCommand");
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

    public static IntercomControlCommand unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static IntercomControlCommand unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(buff.get());
    }

    /** Returns the size of this serialized object in bytes
     *@return size in bytes*/  
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "IntercomControlCommand: " + name() + ": " + getValue(); 
    }
}
