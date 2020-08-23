package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 603 marshal size 8<br>
 * _____________________________________________________
 */
public enum Class3SupplyCategoryPetroleumOilsLubricants implements Category
{
    /** Other */
    OTHER (1, "Other"),
    /** A - POL for Air Vehicles */
    A_POL_FOR_AIR_VEHICLES (2, "A - POL for Air Vehicles"),
    /** W - POL for Land Vehicles */
    W_POL_FOR_LAND_VEHICLES (3, "W - POL for Land Vehicles"),
    /** P - Packaged POL */
    P_PACKAGED_POL (4, "P - Packaged POL");

    private int value;
    private final String description;

    Class3SupplyCategoryPetroleumOilsLubricants(int value, String description)
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

    public static Class3SupplyCategoryPetroleumOilsLubricants getEnumForValue(int i)
    {
       for(Class3SupplyCategoryPetroleumOilsLubricants val: Class3SupplyCategoryPetroleumOilsLubricants.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Class3SupplyCategoryPetroleumOilsLubricants");
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

    public static Class3SupplyCategoryPetroleumOilsLubricants unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Class3SupplyCategoryPetroleumOilsLubricants unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Class3SupplyCategoryPetroleumOilsLubricants: " + name() + ": " + getValue(); 
    }
}
