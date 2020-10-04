package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 375 marshal size 2<br>
 * ComponentVisualDamageStatusSmoke
 */
public enum ComponentVisualDamageStatusSmoke 
{
    /** No Smoke */
    NO_SMOKE (0, "No Smoke"),
    /** Light Smoke */
    LIGHT_SMOKE (1, "Light Smoke"),
    /** Moderate Smoke */
    MODERATE_SMOKE (2, "Moderate Smoke"),
    /** Heavy Smoke */
    HEAVY_SMOKE (3, "Heavy Smoke");

    private int value;
    private final String description;

    ComponentVisualDamageStatusSmoke(int value, String description)
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
      return 2;
    }

    public static ComponentVisualDamageStatusSmoke getEnumForValue(int i)
    {
       for(ComponentVisualDamageStatusSmoke val: ComponentVisualDamageStatusSmoke.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ComponentVisualDamageStatusSmoke");
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

    public static ComponentVisualDamageStatusSmoke unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static ComponentVisualDamageStatusSmoke unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "ComponentVisualDamageStatusSmoke " + getValue() + " " + name(); 
    }
}
