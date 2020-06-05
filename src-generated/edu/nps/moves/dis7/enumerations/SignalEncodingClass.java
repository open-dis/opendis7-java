package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 270 marshal size 2<br>
 * Signal-Encoding Class
 */
public enum SignalEncodingClass 
{
    /** Encoded audio */
    ENCODED_AUDIO (0, "Encoded audio"),
    /** Raw Binary Data */
    RAW_BINARY_DATA (1, "Raw Binary Data"),
    /** Application-Specific Data */
    APPLICATION_SPECIFIC_DATA (2, "Application-Specific Data"),
    /** Database index */
    DATABASE_INDEX (3, "Database index");

    private int value;
    private final String description;

    SignalEncodingClass(int value, String description)
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
      return 2;
    }

    public static SignalEncodingClass getEnumForValue(int i)
    {
       for(SignalEncodingClass val: SignalEncodingClass.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SignalEncodingClass");
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

    public static SignalEncodingClass unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SignalEncodingClass unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "SignalEncodingClass: " + name() + ": " + getValue(); 
    }
}
