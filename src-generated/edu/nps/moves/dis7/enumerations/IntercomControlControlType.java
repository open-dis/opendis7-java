package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 180 marshal size 8<br>
 * Intercom Control-Control Type
 */
public enum IntercomControlControlType 
{
    /** Reserved */
    RESERVED (0, "Reserved"),
    /** Status */
    STATUS (1, "Status"),
    /** Request - Acknowledge Required */
    REQUEST_ACKNOWLEDGE_REQUIRED (2, "Request - Acknowledge Required"),
    /** Request - No Acknowledge */
    REQUEST_NO_ACKNOWLEDGE (3, "Request - No Acknowledge"),
    /** Ack - Request Granted */
    ACK_REQUEST_GRANTED (4, "Ack - Request Granted"),
    /** Nack - Request Denied */
    NACK_REQUEST_DENIED (5, "Nack - Request Denied");

    private int value;
    private final String description;

    IntercomControlControlType(int value, String description)
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

    public static IntercomControlControlType getEnumForValue(int i)
    {
       for(IntercomControlControlType val: IntercomControlControlType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IntercomControlControlType");
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

    public static IntercomControlControlType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static IntercomControlControlType unmarshalEnum(ByteBuffer buff) throws Exception
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
    
    @Override
    public String toString()
    {
        return "IntercomControlControlType: " + name() + ": " + getValue(); 
    }
}
