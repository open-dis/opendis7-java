package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 285 marshal size 16<br>
 * _________________________
 */
public enum IOActionIOWarfareType 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Electronic Warfare (EW) */
    ELECTRONIC_WARFARE_EW (1, "Electronic Warfare (EW)"),
    /** Computer Network Operations (CNO) */
    COMPUTER_NETWORK_OPERATIONS_CNO (2, "Computer Network Operations (CNO)"),
    /** Psychological Operations (PSYOPS) */
    PSYCHOLOGICAL_OPERATIONS_PSYOPS (3, "Psychological Operations (PSYOPS)"),
    /** Military Deception (MILDEC) */
    MILITARY_DECEPTION_MILDEC (4, "Military Deception (MILDEC)"),
    /** Operations Security (OPSEC) */
    OPERATIONS_SECURITY_OPSEC (5, "Operations Security (OPSEC)"),
    /** Physical Attack */
    PHYSICAL_ATTACK (6, "Physical Attack");

    private int value;
    private final String description;

    IOActionIOWarfareType(int value, String description)
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

    public static IOActionIOWarfareType getEnumForValue(int i)
    {
       for(IOActionIOWarfareType val: IOActionIOWarfareType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IOActionIOWarfareType");
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

    public static IOActionIOWarfareType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static IOActionIOWarfareType unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "IOActionIOWarfareType: " + name() + ": " + getValue(); 
    }
}
