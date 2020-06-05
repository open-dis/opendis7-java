package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 292 marshal size 8<br>
 * IO Effects Record-IO Effect
 */
public enum IOEffectsRecordIOEffect 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Denial */
    DENIAL (1, "Denial"),
    /** Degradation */
    DEGRADATION (2, "Degradation"),
    /** Disruption */
    DISRUPTION (3, "Disruption"),
    /** Terminate Effect */
    TERMINATE_EFFECT (255, "Terminate Effect");

    private int value;
    private final String description;

    IOEffectsRecordIOEffect(int value, String description)
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

    public static IOEffectsRecordIOEffect getEnumForValue(int i)
    {
       for(IOEffectsRecordIOEffect val: IOEffectsRecordIOEffect.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IOEffectsRecordIOEffect");
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

    public static IOEffectsRecordIOEffect unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static IOEffectsRecordIOEffect unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "IOEffectsRecordIOEffect: " + name() + ": " + getValue(); 
    }
}
