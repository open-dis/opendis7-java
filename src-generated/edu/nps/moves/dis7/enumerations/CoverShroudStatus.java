package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 426 marshal size 2<br>
 * ___________________
 */
public enum CoverShroudStatus 
{
    /** Closed */
    CLOSED (0, "Closed"),
    /** Opening */
    OPENING (1, "Opening"),
    /** Cover/Shroud Blown/Detached */
    COVER_SHROUD_BLOWN_DETACHED (2, "Cover/Shroud Blown/Detached"),
    /** Open/Attached */
    OPEN_ATTACHED (3, "Open/Attached");

    private int value;
    private final String description;

    CoverShroudStatus(int value, String description)
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

    public static CoverShroudStatus getEnumForValue(int i)
    {
       for(CoverShroudStatus val: CoverShroudStatus.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration CoverShroudStatus");
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

    public static CoverShroudStatus unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static CoverShroudStatus unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "CoverShroudStatus: " + name() + ": " + getValue(); 
    }
}
