package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 147 marshal size 16<br>
 * UA-Scan Pattern
 */
public enum UAScanPattern 
{
    /** Scan pattern not used */
    SCAN_PATTERN_NOT_USED (0, "Scan pattern not used"),
    /** Conical */
    CONICAL (1, "Conical"),
    /** Helical */
    HELICAL (2, "Helical"),
    /** Raster */
    RASTER (3, "Raster"),
    /** Sector search */
    SECTOR_SEARCH (4, "Sector search"),
    /** Continuous search */
    CONTINUOUS_SEARCH (5, "Continuous search");

    private int value;
    private final String description;

    UAScanPattern(int value, String description)
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

    public static UAScanPattern getEnumForValue(int i)
    {
       for(UAScanPattern val: UAScanPattern.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration UAScanPattern");
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

    public static UAScanPattern unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static UAScanPattern unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "UAScanPattern: " + name() + ": " + getValue(); 
    }
}
