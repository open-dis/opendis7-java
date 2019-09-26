package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 288 marshal size 16<br>
 * IO Action-IO Action Phase
 */
public enum IOActionIOActionPhase 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Start Attack Profile */
    START_ATTACK_PROFILE (1, "Start Attack Profile"),
    /** End Attack Profile */
    END_ATTACK_PROFILE (2, "End Attack Profile"),
    /** Continue Attack Profile with Changes */
    CONTINUE_ATTACK_PROFILE_WITH_CHANGES (3, "Continue Attack Profile with Changes"),
    /** Start Attack Effects */
    START_ATTACK_EFFECTS (4, "Start Attack Effects"),
    /** End Attacked Effects */
    END_ATTACKED_EFFECTS (5, "End Attacked Effects"),
    /** Continue Attack Effects with Changes */
    CONTINUE_ATTACK_EFFECTS_WITH_CHANGES (6, "Continue Attack Effects with Changes");

    private int value;
    private final String description;

    IOActionIOActionPhase(int value, String description)
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

    public static IOActionIOActionPhase getEnumForValue(int i)
    {
       for(IOActionIOActionPhase val: IOActionIOActionPhase.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IOActionIOActionPhase");
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

    public static IOActionIOActionPhase unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static IOActionIOActionPhase unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "IOActionIOActionPhase: " + name() + ": " + getValue(); 
    }
}
