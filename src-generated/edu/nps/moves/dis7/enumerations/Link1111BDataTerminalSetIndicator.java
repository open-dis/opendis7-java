package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 469 marshal size 8<br>
 * Link 11/11B Data Terminal Set Indicator
 */
public enum Link1111BDataTerminalSetIndicator 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Transmit */
    TRANSMIT (1, "Transmit"),
    /** Receive */
    RECEIVE (2, "Receive"),
    /** Net Busy */
    NET_BUSY (3, "Net Busy"),
    /** Transmit Data Error */
    TRANSMIT_DATA_ERROR (4, "Transmit Data Error"),
    /** Receive Data Error */
    RECEIVE_DATA_ERROR (5, "Receive Data Error"),
    /** Code Error */
    CODE_ERROR (6, "Code Error"),
    /** Synchronization Complete */
    SYNCHRONIZATION_COMPLETE (7, "Synchronization Complete");

    private int value;
    private final String description;

    Link1111BDataTerminalSetIndicator(int value, String description)
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

    public static Link1111BDataTerminalSetIndicator getEnumForValue(int i)
    {
       for(Link1111BDataTerminalSetIndicator val: Link1111BDataTerminalSetIndicator.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link1111BDataTerminalSetIndicator");
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

    public static Link1111BDataTerminalSetIndicator unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Link1111BDataTerminalSetIndicator unmarshalEnum(ByteBuffer buff) throws Exception
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

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "Link1111BDataTerminalSetIndicator: " + name() + ": " + getValue(); 
    }
}
