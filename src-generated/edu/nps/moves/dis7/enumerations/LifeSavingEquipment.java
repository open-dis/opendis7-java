package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 633 marshal size 8<br>
 * LifeSavingEquipment<br>
 * Subcategories for Surface Platform Category 101. For Subcategory 1-3. Use the Extra field to specify the capacity 1-255 persons.
 */
public enum LifeSavingEquipment implements SubCategory
{

    /** Lifeboat */
    LIFEBOAT (1, "Lifeboat"),
    /** Liferaft */
    LIFERAFT (2, "Liferaft"),
    /** MOB Boat */
    MOB_BOAT (3, "MOB Boat"),
    /** Lifebuoy */
    LIFEBUOY (4, "Lifebuoy");

    private int value;
    private final String description;

    LifeSavingEquipment(int value, String description)
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

    public static LifeSavingEquipment getEnumForValue(int i)
    {
       for(LifeSavingEquipment val: LifeSavingEquipment.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeSavingEquipment");
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

    public static LifeSavingEquipment unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeSavingEquipment unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeSavingEquipment: " + name() + ": " + getValue(); 
    }
}
