package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 312 marshal size 8<br>
 * DEFirePulseShape
 */
public enum DEFirePulseShape 
{
    /** Other */
    OTHER (0, "Other"),
    /** Square Wave */
    SQUARE_WAVE (1, "Square Wave"),
    /** Continuous Wave */
    CONTINUOUS_WAVE (2, "Continuous Wave"),
    /** Gaussian */
    GAUSSIAN (3, "Gaussian");

    private int value;
    private final String description;

    DEFirePulseShape(int value, String description)
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

    public static DEFirePulseShape getEnumForValue(int i)
    {
       for(DEFirePulseShape val: DEFirePulseShape.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DEFirePulseShape");
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

    public static DEFirePulseShape unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static DEFirePulseShape unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "DEFirePulseShape: " + name() + ": " + getValue(); 
    }
}
