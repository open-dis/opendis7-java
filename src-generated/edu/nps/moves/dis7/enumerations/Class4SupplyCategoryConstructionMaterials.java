package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 604 marshal size 8<br>
 * Class4SupplyCategoryConstructionMaterials
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
    
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
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

    public static Class4SupplyCategoryConstructionMaterials unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "Class4SupplyCategoryConstructionMaterials " + getValue() + " " + name(); 
    }
}
