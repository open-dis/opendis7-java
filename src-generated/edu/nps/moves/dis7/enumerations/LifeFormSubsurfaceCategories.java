package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 479 marshal size 8<br>
 * Life Form Subsurface Categories
 */
public enum LifeFormSubsurfaceCategories 
{
    /** SubcategoriesforSubsurfaceCategory200Fish */    FISH_2 (200, "Fish"),
    /** SubcategoriesforSubsurfaceCategory201Mammal */    MAMMAL_2 (201, "Mammal"),
    /** SubcategoriesforSubsurfaceCategory202Mollusk */    MOLLUSK_2 (202, "Mollusk"),
    /** SubcategoriesforSubsurfaceCategory203Crustacean */    CRUSTACEAN_2 (203, "Crustacean"),
    /** SubcategoriesforSubsurfaceCategory204Insect */    INSECT_2 (204, "Insect");

    private int value;
    private final String description;

    LifeFormSubsurfaceCategories(int value, String description)
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

    public static LifeFormSubsurfaceCategories getEnumForValue(int i)
    {
       for(LifeFormSubsurfaceCategories val: LifeFormSubsurfaceCategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormSubsurfaceCategories");
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

    public static LifeFormSubsurfaceCategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormSubsurfaceCategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormSubsurfaceCategories: " + name() + ": " + getValue(); 
    }
}
