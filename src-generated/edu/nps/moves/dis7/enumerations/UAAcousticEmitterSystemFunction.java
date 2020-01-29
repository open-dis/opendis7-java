package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 145 marshal size 8<br>
 * UA-Acoustic Emitter System Function
 */
public enum UAAcousticEmitterSystemFunction 
{
    /** Other */
    OTHER (0, "Other"),
    /** Platform search/detect/track */
    PLATFORM_SEARCH_DETECT_TRACK (1, "Platform search/detect/track"),
    /** Navigation */
    NAVIGATION (2, "Navigation"),
    /** Mine hunting */
    MINE_HUNTING (3, "Mine hunting"),
    /** Weapon search/detect/track/detect */
    WEAPON_SEARCH_DETECT_TRACK_DETECT (4, "Weapon search/detect/track/detect");

    private int value;
    private final String description;

    UAAcousticEmitterSystemFunction(int value, String description)
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

    public static UAAcousticEmitterSystemFunction getEnumForValue(int i)
    {
       for(UAAcousticEmitterSystemFunction val: UAAcousticEmitterSystemFunction.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration UAAcousticEmitterSystemFunction");
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

    public static UAAcousticEmitterSystemFunction unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static UAAcousticEmitterSystemFunction unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "UAAcousticEmitterSystemFunction: " + name() + ": " + getValue(); 
    }
}
