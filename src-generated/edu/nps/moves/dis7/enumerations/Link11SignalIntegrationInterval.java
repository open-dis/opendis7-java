package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 733 marshal size 8<br>
 * Link11SignalIntegrationInterval<br>
 * UID table only for historical purposes. Do not add new entries
 */
public enum Link11SignalIntegrationInterval 
{

    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** 9 ms */
    NAME_9_MS (1, "9 ms"),
    /** 18 ms */
    NAME_18_MS (2, "18 ms");

    private int value;
    private final String description;

    Link11SignalIntegrationInterval(int value, String description)
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

    public static Link11SignalIntegrationInterval getEnumForValue(int i)
    {
       for(Link11SignalIntegrationInterval val: Link11SignalIntegrationInterval.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link11SignalIntegrationInterval");
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

    public static Link11SignalIntegrationInterval unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Link11SignalIntegrationInterval unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Link11SignalIntegrationInterval: " + name() + ": " + getValue(); 
    }
}
