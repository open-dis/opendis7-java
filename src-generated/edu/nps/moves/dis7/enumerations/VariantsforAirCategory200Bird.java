package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 136 marshal size 8<br>
 * VariantsforAirCategory200Bird
 */
public enum VariantsforAirCategory200Bird 
{
    /** Bird with Fish */
    BIRD_WITH_FISH (1, "Bird with Fish"),
    /** V-Pattern Flock Shape */
    V_PATTERN_FLOCK_SHAPE (2, "V-Pattern Flock Shape"),
    /** Circular Flock Shape */
    CIRCULAR_FLOCK_SHAPE (3, "Circular Flock Shape"),
    /** Irregular Flock Shape */
    IRREGULAR_FLOCK_SHAPE (4, "Irregular Flock Shape");

    private int value;
    private final String description;

    VariantsforAirCategory200Bird(int value, String description)
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

    public static VariantsforAirCategory200Bird getEnumForValue(int i)
    {
       for(VariantsforAirCategory200Bird val: VariantsforAirCategory200Bird.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration VariantsforAirCategory200Bird");
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

    public static VariantsforAirCategory200Bird unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static VariantsforAirCategory200Bird unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "VariantsforAirCategory200Bird " + getValue() + " " + name(); 
    }
}
