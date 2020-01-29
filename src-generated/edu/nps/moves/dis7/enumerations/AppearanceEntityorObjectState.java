package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 386 marshal size 1<br>
 * Appearance-Entity or Object State
 */
public enum AppearanceEntityorObjectState 
{
    /** Active */
    ACTIVE (0, "Active"),
    /** Deactivated */
    DEACTIVATED (1, "Deactivated");

    private int value;
    private final String description;

    AppearanceEntityorObjectState(int value, String description)
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
      return 1;
    }

    public static AppearanceEntityorObjectState getEnumForValue(int i)
    {
       for(AppearanceEntityorObjectState val: AppearanceEntityorObjectState.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AppearanceEntityorObjectState");
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

    public static AppearanceEntityorObjectState unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static AppearanceEntityorObjectState unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AppearanceEntityorObjectState: " + name() + ": " + getValue(); 
    }
}
