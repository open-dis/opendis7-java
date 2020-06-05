package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 604 marshal size 8<br>
 * Class 4 Supply Category - Construction Materials
 */
public enum Class4SupplyCategoryConstructionMaterials implements Category
{
    /** Other */
    OTHER (1, "Other"),
    /** A - Construction */
    A_CONSTRUCTION (2, "A - Construction"),
    /** B - Barrier */
    B_BARRIER (3, "B - Barrier");

    private int value;
    private final String description;

    Class4SupplyCategoryConstructionMaterials(int value, String description)
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

    public static Class4SupplyCategoryConstructionMaterials getEnumForValue(int i)
    {
       for(Class4SupplyCategoryConstructionMaterials val: Class4SupplyCategoryConstructionMaterials.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Class4SupplyCategoryConstructionMaterials");
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

    public static Class4SupplyCategoryConstructionMaterials unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Class4SupplyCategoryConstructionMaterials unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Class4SupplyCategoryConstructionMaterials: " + name() + ": " + getValue(); 
    }
}
