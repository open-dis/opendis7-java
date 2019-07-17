package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 181 marshal size 7<br>
 * Intercom Control-Communications Type
 */
public enum IntercomControlCommunicationsType 
{
    /** Reserved */
    RESERVED (0, "Reserved"),
    /** Connection FDX */
    CONNECTION_FDX (1, "Connection FDX"),
    /** Connection HDX - Destination is Receive Only */
    CONNECTION_HDX_DESTINATION_IS_RECEIVE_ONLY (2, "Connection HDX - Destination is Receive Only"),
    /** Connection HDX - Destination is Transmit Only */
    CONNECTION_HDX_DESTINATION_IS_TRANSMIT_ONLY (3, "Connection HDX - Destination is Transmit Only"),
    /** Connection HDX */
    CONNECTION_HDX (4, "Connection HDX");

    private int value;
    private final String description;

    IntercomControlCommunicationsType(int value, String description)
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
      return 7;
    }

    public static IntercomControlCommunicationsType getEnumForValue(int i)
    {
       for(IntercomControlCommunicationsType val: IntercomControlCommunicationsType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IntercomControlCommunicationsType");
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

    public static IntercomControlCommunicationsType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static IntercomControlCommunicationsType unmarshalEnum(ByteBuffer buff) throws Exception
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
