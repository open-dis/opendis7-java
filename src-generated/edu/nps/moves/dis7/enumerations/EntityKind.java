package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 7 marshal size 8<br>
 * EntityKind
 */
public enum EntityKind 
{
    /** Other */
    OTHER (0, "Other"),
    /** Platform */
    PLATFORM (1, "Platform"),
    /** Munition */
    MUNITION (2, "Munition"),
    /** Life form */
    LIFE_FORM (3, "Life form"),
    /** Environmental */
    ENVIRONMENTAL (4, "Environmental"),
    /** Cultural feature */
    CULTURAL_FEATURE (5, "Cultural feature"),
    /** Supply */
    SUPPLY (6, "Supply"),
    /** Radio */
    RADIO (7, "Radio"),
    /** Expendable */
    EXPENDABLE (8, "Expendable"),
    /** Sensor/Emitter */
    SENSOR_EMITTER (9, "Sensor/Emitter");

    private int value;
    private final String description;

    EntityKind(int value, String description)
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

    public static EntityKind getEnumForValue(int i)
    {
       for(EntityKind val: EntityKind.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityKind");
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

    public static EntityKind unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static EntityKind unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "EntityKind: " + name() + ": " + getValue(); 
    }
}
