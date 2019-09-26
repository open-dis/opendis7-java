package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 184 marshal size 8<br>
 * Intercom Control-Destination Line State Command
 */
public enum IntercomControlDestinationLineStateCommand 
{
    /** None */
    NONE (0, "None"),
    /** Set Line State - Transmitting */
    SET_LINE_STATE_TRANSMITTING (1, "Set Line State - Transmitting"),
    /** Set Line State - Not Transmitting */
    SET_LINE_STATE_NOT_TRANSMITTING (2, "Set Line State - Not Transmitting"),
    /** Return to Local Line State Control */
    RETURN_TO_LOCAL_LINE_STATE_CONTROL (3, "Return to Local Line State Control");

    private int value;
    private final String description;

    IntercomControlDestinationLineStateCommand(int value, String description)
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

    public static IntercomControlDestinationLineStateCommand getEnumForValue(int i)
    {
       for(IntercomControlDestinationLineStateCommand val: IntercomControlDestinationLineStateCommand.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IntercomControlDestinationLineStateCommand");
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

    public static IntercomControlDestinationLineStateCommand unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static IntercomControlDestinationLineStateCommand unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "IntercomControlDestinationLineStateCommand: " + name() + ": " + getValue(); 
    }
}
