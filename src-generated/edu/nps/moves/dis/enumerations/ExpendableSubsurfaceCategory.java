package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 27 marshal size 8<br>
 * Expendable-Subsurface Category
 */
public enum ExpendableSubsurfaceCategory implements Category
{
    /** Other */
    OTHER (0, "Other"),
    /** Active emitter */
    ACTIVE_EMITTER (4, "Active emitter"),
    /** Passive decoy */
    PASSIVE_DECOY (5, "Passive decoy"),
    /** Signal */
    SIGNAL (7, "Signal"),
    /** Noise-Maker Decoy */
    NOISE_MAKER_DECOY (9, "Noise-Maker Decoy"),
    /** Bubble-Maker Decoy */
    BUBBLE_MAKER_DECOY (10, "Bubble-Maker Decoy"),
    /** Multi-Mode Decoy */
    MULTI_MODE_DECOY (11, "Multi-Mode Decoy");

    private int value;
    private final String description;

    ExpendableSubsurfaceCategory(int value, String description)
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

    public static ExpendableSubsurfaceCategory getEnumForValue(int i)
    {
       for(ExpendableSubsurfaceCategory val: ExpendableSubsurfaceCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ExpendableSubsurfaceCategory");
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

    public static ExpendableSubsurfaceCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static ExpendableSubsurfaceCategory unmarshalEnum(ByteBuffer buff) throws Exception
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
