package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 225 marshal size 8<br>
 * ObjectKind
 */
public enum ObjectKind 
{
    /** Other */
    OTHER (0, "Other"),
    /** Obstacle */
    OBSTACLE (1, "Obstacle"),
    /** Prepared Position */
    PREPARED_POSITION (2, "Prepared Position"),
    /** Cultural Feature */
    CULTURAL_FEATURE (3, "Cultural Feature"),
    /** Passageway */
    PASSAGEWAY (4, "Passageway"),
    /** Tactical Smoke */
    TACTICAL_SMOKE (5, "Tactical Smoke"),
    /** Obstacle Marker */
    OBSTACLE_MARKER (6, "Obstacle Marker"),
    /** Obstacle Breach */
    OBSTACLE_BREACH (7, "Obstacle Breach"),
    /** Environmental Object */
    ENVIRONMENTAL_OBJECT (8, "Environmental Object");

    private int value;
    private final String description;

    ObjectKind(int value, String description)
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

    public static ObjectKind getEnumForValue(int i)
    {
       for(ObjectKind val: ObjectKind.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ObjectKind");
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

    public static ObjectKind unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static ObjectKind unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "ObjectKind " + getValue() + " " + name(); 
    }
}
