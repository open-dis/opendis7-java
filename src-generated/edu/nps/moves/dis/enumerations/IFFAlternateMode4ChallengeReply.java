package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 96 marshal size 8<br>
 * IFF-Alternate Mode 4 Challenge/Reply
 */
public enum IFFAlternateMode4ChallengeReply 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Valid */
    VALID (1, "Valid"),
    /** Invalid */
    INVALID (2, "Invalid"),
    /** No response */
    NO_RESPONSE (3, "No response"),
    /** Unable to Verify */
    UNABLE_TO_VERIFY (4, "Unable to Verify");

    private int value;
    private final String description;

    IFFAlternateMode4ChallengeReply(int value, String description)
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

    public static IFFAlternateMode4ChallengeReply getEnumForValue(int i)
    {
       for(IFFAlternateMode4ChallengeReply val: IFFAlternateMode4ChallengeReply.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IFFAlternateMode4ChallengeReply");
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

    public static IFFAlternateMode4ChallengeReply unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static IFFAlternateMode4ChallengeReply unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
}
