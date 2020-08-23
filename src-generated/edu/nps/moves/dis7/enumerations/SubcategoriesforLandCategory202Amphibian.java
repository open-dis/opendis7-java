package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 102 marshal size 8<br>
 * _______________________________________________
 */
public enum SubcategoriesforLandCategory202Amphibian implements SubCategory
{
    /** Frog, 1-169 Frog/Toad */
    FROG (1, "Frog"),
    /** Toad */
    TOAD (2, "Toad"),
    /** Salamander, 170-229 Salamander/Newt */
    SALAMANDER (170, "Salamander"),
    /** Caecilian, 230-255 Caecilian */
    CAECILIAN (230, "Caecilian");

    private int value;
    private final String description;

    SubcategoriesforLandCategory202Amphibian(int value, String description)
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

    public static SubcategoriesforLandCategory202Amphibian getEnumForValue(int i)
    {
       for(SubcategoriesforLandCategory202Amphibian val: SubcategoriesforLandCategory202Amphibian.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforLandCategory202Amphibian");
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

    public static SubcategoriesforLandCategory202Amphibian unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SubcategoriesforLandCategory202Amphibian unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "SubcategoriesforLandCategory202Amphibian: " + name() + ": " + getValue(); 
    }
}
