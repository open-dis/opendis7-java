package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 56 marshal size 8<br>
 * VariableParameterRecordType
 */
public enum VariableParameterRecordType 
{
    /** Articulated Part */
    ARTICULATED_PART (0, "Articulated Part"),
    /** Attached Part */
    ATTACHED_PART (1, "Attached Part"),
    /** Separation */
    SEPARATION (2, "Separation"),
    /** Entity Type */
    ENTITY_TYPE (3, "Entity Type"),
    /** Entity Association */
    ENTITY_ASSOCIATION (4, "Entity Association");

    private int value;
    private final String description;

    VariableParameterRecordType(int value, String description)
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

    public static VariableParameterRecordType getEnumForValue(int i)
    {
       for(VariableParameterRecordType val: VariableParameterRecordType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration VariableParameterRecordType");
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

    public static VariableParameterRecordType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static VariableParameterRecordType unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "VariableParameterRecordType: " + name() + ": " + getValue(); 
    }
}
