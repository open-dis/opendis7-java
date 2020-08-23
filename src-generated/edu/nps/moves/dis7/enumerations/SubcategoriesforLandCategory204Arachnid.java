package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 104 marshal size 8<br>
 * ______________________________________________
 */
public enum SubcategoriesforLandCategory204Arachnid implements SubCategory
{
    /** Spider, 1-19 Spider */
    SPIDER (1, "Spider"),
    /** Tick, 20-29 Tick */
    TICK (20, "Tick"),
    /** Scorpion, 30-39 Scorpion */
    SCORPION (30, "Scorpion"),
    /** Harvestmen, 40-49 Harvestmen */
    HARVESTMEN (40, "Harvestmen"),
    /** Mite, 50-59 Mite */
    MITE (50, "Mite");

    private int value;
    private final String description;

    SubcategoriesforLandCategory204Arachnid(int value, String description)
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

    public static SubcategoriesforLandCategory204Arachnid getEnumForValue(int i)
    {
       for(SubcategoriesforLandCategory204Arachnid val: SubcategoriesforLandCategory204Arachnid.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforLandCategory204Arachnid");
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

    public static SubcategoriesforLandCategory204Arachnid unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SubcategoriesforLandCategory204Arachnid unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "SubcategoriesforLandCategory204Arachnid: " + name() + ": " + getValue(); 
    }
}
