package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 293 marshal size 16<br>
 * IOEffectsRecordIOProcess
 */
public enum IOEffectsRecordIOProcess 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement");

    private int value;
    private final String description;

    IOEffectsRecordIOProcess(int value, String description)
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
      return 16;
    }

    public static IOEffectsRecordIOProcess getEnumForValue(int i)
    {
       for(IOEffectsRecordIOProcess val: IOEffectsRecordIOProcess.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IOEffectsRecordIOProcess");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static IOEffectsRecordIOProcess unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static IOEffectsRecordIOProcess unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "IOEffectsRecordIOProcess: " + name() + ": " + getValue(); 
    }
}
