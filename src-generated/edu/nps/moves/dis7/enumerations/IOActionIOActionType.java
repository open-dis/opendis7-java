package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 287 marshal size 16<br>
 * IO Action-IO Action Type
 */
public enum IOActionIOActionType 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** IO Attack - Profile Data (Parametrics) */
    IO_ATTACK_PROFILE_DATA_PARAMETRICS (1, "IO Attack - Profile Data (Parametrics)"),
    /** IO Attack - Computed Effects */
    IO_ATTACK_COMPUTED_EFFECTS (2, "IO Attack - Computed Effects");

    private int value;
    private final String description;

    IOActionIOActionType(int value, String description)
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

    public static IOActionIOActionType getEnumForValue(int i)
    {
       for(IOActionIOActionType val: IOActionIOActionType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IOActionIOActionType");
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

    public static IOActionIOActionType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static IOActionIOActionType unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "IOActionIOActionType: " + name() + ": " + getValue(); 
    }
}
