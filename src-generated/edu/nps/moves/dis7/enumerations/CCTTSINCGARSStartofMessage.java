package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 170 marshal size 8<br>
 * CCTT SINCGARS-Start of Message
 */
public enum CCTTSINCGARSStartofMessage 
{
    /** Not start of message */
    NOT_START_OF_MESSAGE (0, "Not start of message"),
    /** Start of Message */
    START_OF_MESSAGE (1, "Start of Message");

    private int value;
    private final String description;

    CCTTSINCGARSStartofMessage(int value, String description)
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

    public static CCTTSINCGARSStartofMessage getEnumForValue(int i)
    {
       for(CCTTSINCGARSStartofMessage val: CCTTSINCGARSStartofMessage.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration CCTTSINCGARSStartofMessage");
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

    public static CCTTSINCGARSStartofMessage unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static CCTTSINCGARSStartofMessage unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "CCTTSINCGARSStartofMessage: " + name() + ": " + getValue(); 
    }
}
