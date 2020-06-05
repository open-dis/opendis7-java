package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 134 marshal size 8<br>
 * Add Variants for Land Category 200 - Mammal
 */
public enum AddVariantsforLandCategory200Mammal 
{
    /** Animal with a Male Child Rider */
    ANIMAL_WITH_A_MALE_CHILD_RIDER (1, "Animal with a Male Child Rider"),
    /** Animal with a Female Child Rider */
    ANIMAL_WITH_A_FEMALE_CHILD_RIDER (2, "Animal with a Female Child Rider"),
    /** Animal with an Adult Male Rider */
    ANIMAL_WITH_AN_ADULT_MALE_RIDER (3, "Animal with an Adult Male Rider"),
    /** Animal with an Adult Female Rider */
    ANIMAL_WITH_AN_ADULT_FEMALE_RIDER (4, "Animal with an Adult Female Rider"),
    /** Animal Harnessed to a Plow */
    ANIMAL_HARNESSED_TO_A_PLOW (5, "Animal Harnessed to a Plow"),
    /** Animal Harnessed to a Cart */
    ANIMAL_HARNESSED_TO_A_CART (6, "Animal Harnessed to a Cart");

    private int value;
    private final String description;

    AddVariantsforLandCategory200Mammal(int value, String description)
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

    public static AddVariantsforLandCategory200Mammal getEnumForValue(int i)
    {
       for(AddVariantsforLandCategory200Mammal val: AddVariantsforLandCategory200Mammal.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AddVariantsforLandCategory200Mammal");
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

    public static AddVariantsforLandCategory200Mammal unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static AddVariantsforLandCategory200Mammal unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AddVariantsforLandCategory200Mammal: " + name() + ": " + getValue(); 
    }
}
