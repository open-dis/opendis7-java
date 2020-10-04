package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 362 marshal size 1<br>
 * DeltaMode5SAltitudePositiveNegativeIndicator
 */
public enum DeltaMode5SAltitudePositiveNegativeIndicator 
{
    /** Positive */
    POSITIVE (0, "Positive"),
    /** Negative */
    NEGATIVE (1, "Negative");

    private int value;
    private final String description;

    DeltaMode5SAltitudePositiveNegativeIndicator(int value, String description)
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
      return 1;
    }

    public static DeltaMode5SAltitudePositiveNegativeIndicator getEnumForValue(int i)
    {
       for(DeltaMode5SAltitudePositiveNegativeIndicator val: DeltaMode5SAltitudePositiveNegativeIndicator.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DeltaMode5SAltitudePositiveNegativeIndicator");
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

    public static DeltaMode5SAltitudePositiveNegativeIndicator unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static DeltaMode5SAltitudePositiveNegativeIndicator unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "DeltaMode5SAltitudePositiveNegativeIndicator " + getValue() + " " + name(); 
    }
}
