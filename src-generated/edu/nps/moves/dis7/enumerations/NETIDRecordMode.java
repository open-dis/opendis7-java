package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 298 marshal size 2<br>
 * __________________
 */
public enum NETIDRecordMode 
{
    /** A - HAVE QUICK I or HAVE QUICK II COMBAT */
    A_HAVE_QUICK_I_OR_HAVE_QUICK_II_COMBAT (1, "A - HAVE QUICK I or HAVE QUICK II COMBAT"),
    /** B - HAVE QUICK IIA (SATURN) COMBAT */
    B_HAVE_QUICK_IIA_SATURN_COMBAT (2, "B - HAVE QUICK IIA (SATURN) COMBAT"),
    /** T - TRAINING */
    T_TRAINING (3, "T - TRAINING");

    private int value;
    private final String description;

    NETIDRecordMode(int value, String description)
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

    public static NETIDRecordMode getEnumForValue(int i)
    {
       for(NETIDRecordMode val: NETIDRecordMode.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration NETIDRecordMode");
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

    public static NETIDRecordMode unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static NETIDRecordMode unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "NETIDRecordMode: " + name() + ": " + getValue(); 
    }
}
