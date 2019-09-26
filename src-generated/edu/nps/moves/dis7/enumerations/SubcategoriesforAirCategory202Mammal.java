package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 112 marshal size 8<br>
 * Subcategories for Air Category 202 - Mammal
 */
public enum SubcategoriesforAirCategory202Mammal implements SubCategory
{
    /** Bat */
    BAT (1, "Bat"),
    /** Flying Squirrel */
    FLYING_SQUIRREL (10, "Flying Squirrel"),
    /** Gliding Possum */
    GLIDING_POSSUM (20, "Gliding Possum");

    private int value;
    private final String description;

    SubcategoriesforAirCategory202Mammal(int value, String description)
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

    public static SubcategoriesforAirCategory202Mammal getEnumForValue(int i)
    {
       for(SubcategoriesforAirCategory202Mammal val: SubcategoriesforAirCategory202Mammal.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforAirCategory202Mammal");
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

    public static SubcategoriesforAirCategory202Mammal unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static SubcategoriesforAirCategory202Mammal unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "SubcategoriesforAirCategory202Mammal: " + name() + ": " + getValue(); 
    }
}
