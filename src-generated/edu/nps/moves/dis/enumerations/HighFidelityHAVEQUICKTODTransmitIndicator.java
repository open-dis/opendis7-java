package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 297 marshal size 8<br>
 * High Fidelity HAVE QUICK-TOD Transmit Indicator
 */
public enum HighFidelityHAVEQUICKTODTransmitIndicator 
{
    /** No TOD Is Being Transmitted */
    NO_TOD_IS_BEING_TRANSMITTED (0, "No TOD Is Being Transmitted"),
    /** TOD Transmission in Progress */
    TOD_TRANSMISSION_IN_PROGRESS (1, "TOD Transmission in Progress");

    private int value;
    private final String description;

    HighFidelityHAVEQUICKTODTransmitIndicator(int value, String description)
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

    public static HighFidelityHAVEQUICKTODTransmitIndicator getEnumForValue(int i)
    {
       for(HighFidelityHAVEQUICKTODTransmitIndicator val: HighFidelityHAVEQUICKTODTransmitIndicator.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration HighFidelityHAVEQUICKTODTransmitIndicator");
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

    public static HighFidelityHAVEQUICKTODTransmitIndicator unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static HighFidelityHAVEQUICKTODTransmitIndicator unmarshalEnum(ByteBuffer buff) throws Exception
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
