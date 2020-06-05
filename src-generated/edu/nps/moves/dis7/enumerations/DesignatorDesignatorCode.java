package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 81 marshal size 16<br>
 * Designator-Designator Code<br>
 * UID table only for historical purposes. Do not add new entries
 */
public enum DesignatorDesignatorCode 
{

    /** Other */
    OTHER (0, "Other");

    private int value;
    private final String description;

    DesignatorDesignatorCode(int value, String description)
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
      return 16;
    }

    public static DesignatorDesignatorCode getEnumForValue(int i)
    {
       for(DesignatorDesignatorCode val: DesignatorDesignatorCode.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DesignatorDesignatorCode");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static DesignatorDesignatorCode unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static DesignatorDesignatorCode unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "DesignatorDesignatorCode: " + name() + ": " + getValue(); 
    }
}
