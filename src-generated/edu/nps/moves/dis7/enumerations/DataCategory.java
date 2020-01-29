package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 369 marshal size 8<br>
 * Data Category
 */
public enum DataCategory 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Functional Data */
    FUNCTIONAL_DATA (1, "Functional Data"),
    /** Transponder/Interrogator Data Link Messages */
    TRANSPONDER_INTERROGATOR_DATA_LINK_MESSAGES (2, "Transponder/Interrogator Data Link Messages");

    private int value;
    private final String description;

    DataCategory(int value, String description)
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

    public static DataCategory getEnumForValue(int i)
    {
       for(DataCategory val: DataCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DataCategory");
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

    public static DataCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static DataCategory unmarshalEnum(ByteBuffer buff) throws Exception
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
    
    @Override
    public String toString()
    {
        return "DataCategory: " + name() + ": " + getValue(); 
    }
}
