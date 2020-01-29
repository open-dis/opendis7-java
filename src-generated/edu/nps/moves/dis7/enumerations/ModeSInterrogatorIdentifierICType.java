package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 348 marshal size 1<br>
 * Mode S Interrogator Identifier IC Type
 */
public enum ModeSInterrogatorIdentifierICType 
{
    /** II */
    II (0, "II"),
    /** SI */
    SI (1, "SI");

    private int value;
    private final String description;

    ModeSInterrogatorIdentifierICType(int value, String description)
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

    public static ModeSInterrogatorIdentifierICType getEnumForValue(int i)
    {
       for(ModeSInterrogatorIdentifierICType val: ModeSInterrogatorIdentifierICType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ModeSInterrogatorIdentifierICType");
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

    public static ModeSInterrogatorIdentifierICType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static ModeSInterrogatorIdentifierICType unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "ModeSInterrogatorIdentifierICType: " + name() + ": " + getValue(); 
    }
}
