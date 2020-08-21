package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 735 marshal size 8<br>
 * Link11/11BEncryptionFlag
 */
public enum Link11_11BEncryptionFlag 
{
    /** No Encryption Used */
    NO_ENCRYPTION_USED (0, "No Encryption Used"),
    /** Encryption Used */
    ENCRYPTION_USED (1, "Encryption Used");

    private int value;
    private final String description;

    Link11_11BEncryptionFlag(int value, String description)
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

    public static Link11_11BEncryptionFlag getEnumForValue(int i)
    {
       for(Link11_11BEncryptionFlag val: Link11_11BEncryptionFlag.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link11_11BEncryptionFlag");
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

    public static Link11_11BEncryptionFlag unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Link11_11BEncryptionFlag unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Link11_11BEncryptionFlag: " + name() + ": " + getValue(); 
    }
}
