package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 296 marshal size 8<br>
 * DRParametersType
 */
public enum DRParametersType 
{
    /** None */
    NONE (0, "None"),
    /** Local Euler Angles (Yaw, Pitch, Roll) */
    LOCAL_EULER_ANGLES_YAW_PITCH_ROLL (1, "Local Euler Angles (Yaw, Pitch, Roll)"),
    /** World Orientation Quaternion */
    WORLD_ORIENTATION_QUATERNION (2, "World Orientation Quaternion");

    private int value;
    private final String description;

    DRParametersType(int value, String description)
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

    public static DRParametersType getEnumForValue(int i)
    {
       for(DRParametersType val: DRParametersType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DRParametersType");
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

    public static DRParametersType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static DRParametersType unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "DRParametersType: " + name() + ": " + getValue(); 
    }
}
