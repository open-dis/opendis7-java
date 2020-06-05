package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 611 marshal size 8<br>
 * Class 11 Supply Category - Supplies (Non Doctrinal)
 */
public enum Class11SupplyCategorySuppliesNonDoctrinal implements Category
{
    /** Other */
    OTHER (1, "Other"),
    /** Pallets */
    PALLETS (2, "Pallets"),
    /** Fuel Tanks, Drums and Bladders */
    FUEL_TANKS_DRUMS_AND_BLADDERS (3, "Fuel Tanks, Drums and Bladders"),
    /** Chests */
    CHESTS (4, "Chests"),
    /** Boxes */
    BOXES (5, "Boxes");

    private int value;
    private final String description;

    Class11SupplyCategorySuppliesNonDoctrinal(int value, String description)
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

    public static Class11SupplyCategorySuppliesNonDoctrinal getEnumForValue(int i)
    {
       for(Class11SupplyCategorySuppliesNonDoctrinal val: Class11SupplyCategorySuppliesNonDoctrinal.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Class11SupplyCategorySuppliesNonDoctrinal");
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

    public static Class11SupplyCategorySuppliesNonDoctrinal unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Class11SupplyCategorySuppliesNonDoctrinal unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Class11SupplyCategorySuppliesNonDoctrinal: " + name() + ": " + getValue(); 
    }
}
