package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 300 marshal size 8<br>
 * EE Attribute-State Indicator
 */
public enum EEAttributeStateIndicator 
{
    /** Heartbeat Update */
    HEARTBEAT_UPDATE (0, "Heartbeat Update"),
    /** Changed Data */
    CHANGED_DATA (1, "Changed Data"),
    /** Has Ceased */
    HAS_CEASED (2, "Has Ceased");

    private int value;
    private final String description;

    EEAttributeStateIndicator(int value, String description)
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

    public static EEAttributeStateIndicator getEnumForValue(int i)
    {
       for(EEAttributeStateIndicator val: EEAttributeStateIndicator.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EEAttributeStateIndicator");
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

    public static EEAttributeStateIndicator unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static EEAttributeStateIndicator unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "EEAttributeStateIndicator: " + name() + ": " + getValue(); 
    }
}
