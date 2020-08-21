package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 732 marshal size 8<br>
 * Link11DataSignallingRate
 */
public enum Link11DataSignallingRate 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** 1364 bps */
    NAME_1364_BPS (1, "1364 bps"),
    /** 2250 bps */
    NAME_2250_BPS (2, "2250 bps"),
    /** 1200 bps */
    NAME_1200_BPS (3, "1200 bps"),
    /** 2400 bps */
    NAME_2400_BPS (4, "2400 bps");

    private int value;
    private final String description;

    Link11DataSignallingRate(int value, String description)
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

    public static Link11DataSignallingRate getEnumForValue(int i)
    {
       for(Link11DataSignallingRate val: Link11DataSignallingRate.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link11DataSignallingRate");
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

    public static Link11DataSignallingRate unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Link11DataSignallingRate unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Link11DataSignallingRate: " + name() + ": " + getValue(); 
    }
}
