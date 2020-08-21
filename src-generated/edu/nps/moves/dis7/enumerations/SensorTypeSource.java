package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 414 marshal size 8<br>
 * SensorTypeSource
 */
public enum SensorTypeSource 
{
    /** Other Active Sensors */
    OTHER_ACTIVE_SENSORS (0, "Other Active Sensors"),
    /** Electromagnetic */
    ELECTROMAGNETIC (1, "Electromagnetic"),
    /** Passive Sensors */
    PASSIVE_SENSORS (2, "Passive Sensors"),
    /** Minefield Sensors */
    MINEFIELD_SENSORS (3, "Minefield Sensors"),
    /** Underwater Acoustics */
    UNDERWATER_ACOUSTICS (4, "Underwater Acoustics"),
    /** Lasers */
    LASERS (5, "Lasers");

    private int value;
    private final String description;

    SensorTypeSource(int value, String description)
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

    public static SensorTypeSource getEnumForValue(int i)
    {
       for(SensorTypeSource val: SensorTypeSource.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SensorTypeSource");
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

    public static SensorTypeSource unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SensorTypeSource unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "SensorTypeSource: " + name() + ": " + getValue(); 
    }
}
