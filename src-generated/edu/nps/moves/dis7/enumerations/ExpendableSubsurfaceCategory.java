package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 27 marshal size 8<br>
 * ExpendableSubsurfaceCategory
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
    
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    public static ExpendableSubsurfaceCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static ExpendableSubsurfaceCategory unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "ExpendableSubsurfaceCategory " + getValue() + " " + name(); 
    }
}
