package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 84 marshal size 8<br>
 * IFFSystemMode
 */
public enum IFFSystemMode 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Off */
    OFF (1, "Off"),
    /** Standby */
    STANDBY (2, "Standby"),
    /** Normal */
    NORMAL (3, "Normal"),
    /** Emergency */
    EMERGENCY (4, "Emergency"),
    /** Low or Low Sensitivity */
    LOW_OR_LOW_SENSITIVITY (5, "Low or Low Sensitivity");

    private int value;
    private final String description;

    IFFSystemMode(int value, String description)
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

    public static IFFSystemMode getEnumForValue(int i)
    {
       for(IFFSystemMode val: IFFSystemMode.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IFFSystemMode");
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

    public static IFFSystemMode unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static IFFSystemMode unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "IFFSystemMode: " + name() + ": " + getValue(); 
    }
}
