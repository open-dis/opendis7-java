package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 290 marshal size 8<br>
 * ___________________________
 */
public enum IOEffectsRecordIOStatus 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Effect on Sender */
    EFFECT_ON_SENDER (1, "Effect on Sender"),
    /** Effect on Receiver */
    EFFECT_ON_RECEIVER (2, "Effect on Receiver"),
    /** Effect on Sender and Receiver */
    EFFECT_ON_SENDER_AND_RECEIVER (3, "Effect on Sender and Receiver"),
    /** Effect on Message */
    EFFECT_ON_MESSAGE (4, "Effect on Message"),
    /** Effect on Sender and Message */
    EFFECT_ON_SENDER_AND_MESSAGE (5, "Effect on Sender and Message"),
    /** Effect on Receiver and Message */
    EFFECT_ON_RECEIVER_AND_MESSAGE (6, "Effect on Receiver and Message"),
    /** Effect on Sender, Receiver, and Message */
    EFFECT_ON_SENDER_RECEIVER_AND_MESSAGE (7, "Effect on Sender, Receiver, and Message");

    private int value;
    private final String description;

    IOEffectsRecordIOStatus(int value, String description)
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

    public static IOEffectsRecordIOStatus getEnumForValue(int i)
    {
       for(IOEffectsRecordIOStatus val: IOEffectsRecordIOStatus.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IOEffectsRecordIOStatus");
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

    public static IOEffectsRecordIOStatus unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static IOEffectsRecordIOStatus unmarshalEnum(ByteBuffer buff) throws Exception
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

    /** Returns the size of this serialized object in bytes
     *@return size in bytes*/  
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "IOEffectsRecordIOStatus: " + name() + ": " + getValue(); 
    }
}
