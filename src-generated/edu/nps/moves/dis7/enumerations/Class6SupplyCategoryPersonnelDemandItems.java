package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 606 marshal size 8<br>
 * Class 6 Supply Category - Personnel Demand Items
 */
public enum Class6SupplyCategoryPersonnelDemandItems implements Category
{
    /** Other */
    OTHER (1, "Other");

    private int value;
    private final String description;

    Class6SupplyCategoryPersonnelDemandItems(int value, String description)
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

    public static Class6SupplyCategoryPersonnelDemandItems getEnumForValue(int i)
    {
       for(Class6SupplyCategoryPersonnelDemandItems val: Class6SupplyCategoryPersonnelDemandItems.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Class6SupplyCategoryPersonnelDemandItems");
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

    public static Class6SupplyCategoryPersonnelDemandItems unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static Class6SupplyCategoryPersonnelDemandItems unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Class6SupplyCategoryPersonnelDemandItems: " + name() + ": " + getValue(); 
    }
}
