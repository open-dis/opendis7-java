package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 103 marshal size 8<br>
 * ____________________________________________
 */
public enum SubcategoriesforLandCategory203Insect implements SubCategory
{
    /** Beetle, 1-59 Beetle/Weevil */
    BEETLE (1, "Beetle"),
    /** Mantis, 60-69 Mantis */
    MANTIS (60, "Mantis"),
    /** Cockroach, 70-79 Cockroach */
    COCKROACH (70, "Cockroach"),
    /** Army Ant, 80-89 Ant */
    ARMY_ANT (80, "Army Ant"),
    /** Fire Ant */
    FIRE_ANT (81, "Fire Ant"),
    /** Grasshopper, 90-99 Grasshopper/Cricket/Katydid */
    GRASSHOPPER (90, "Grasshopper"),
    /** Centipede, 100-109 Centipede/Millipede */
    CENTIPEDE (100, "Centipede");

    private int value;
    private final String description;

    SubcategoriesforLandCategory203Insect(int value, String description)
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

    public static SubcategoriesforLandCategory203Insect getEnumForValue(int i)
    {
       for(SubcategoriesforLandCategory203Insect val: SubcategoriesforLandCategory203Insect.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforLandCategory203Insect");
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

    public static SubcategoriesforLandCategory203Insect unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SubcategoriesforLandCategory203Insect unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "SubcategoriesforLandCategory203Insect: " + name() + ": " + getValue(); 
    }
}
