package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 183 marshal size 8<br>
 * ____________________________________
 */
public enum IntercomControlTransmitLineState 
{
    /** Transmit Line State not applicable */
    TRANSMIT_LINE_STATE_NOT_APPLICABLE (0, "Transmit Line State not applicable"),
    /** Not Transmitting */
    NOT_TRANSMITTING (1, "Not Transmitting"),
    /** Transmitting */
    TRANSMITTING (2, "Transmitting");

    private int value;
    private final String description;

    IntercomControlTransmitLineState(int value, String description)
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

    public static IntercomControlTransmitLineState getEnumForValue(int i)
    {
       for(IntercomControlTransmitLineState val: IntercomControlTransmitLineState.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IntercomControlTransmitLineState");
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

    public static IntercomControlTransmitLineState unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static IntercomControlTransmitLineState unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "IntercomControlTransmitLineState: " + name() + ": " + getValue(); 
    }
}
