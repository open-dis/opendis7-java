package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 45 marshal size 8<br>
 * Entity Marking-Character Set
 */
public enum EntityMarkingCharacterSet 
{
    /** Unused */
    UNUSED (0, "Unused"),
    /** ASCII */
    ASCII (1, "ASCII"),
    /** U.S. Army Marking */
    US_ARMY_MARKING (2, "U.S. Army Marking"),
    /** Digit Chevron */
    DIGIT_CHEVRON (3, "Digit Chevron");

    private int value;
    private final String description;

    EntityMarkingCharacterSet(int value, String description)
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

    public static EntityMarkingCharacterSet getEnumForValue(int i)
    {
       for(EntityMarkingCharacterSet val: EntityMarkingCharacterSet.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityMarkingCharacterSet");
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

    public static EntityMarkingCharacterSet unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static EntityMarkingCharacterSet unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "EntityMarkingCharacterSet: " + name() + ": " + getValue(); 
    }
}
