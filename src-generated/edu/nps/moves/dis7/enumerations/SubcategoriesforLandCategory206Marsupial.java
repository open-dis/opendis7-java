package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 106 marshal size 8<br>
 * SubcategoriesforLandCategory206Marsupial<br>
 * 1-99 Ameridelphia, 100-250 Australidelphia
 */
public enum SubcategoriesforLandCategory206Marsupial 
{

    /** Brown Four-Eyed Opossum, 1-89 Opossum */
    BROWN_FOUR_EYED_OPOSSUM (1, "Brown Four-Eyed Opossum"),
    /** Bushy-Tailed Opossum */
    BUSHY_TAILED_OPOSSUM (2, "Bushy-Tailed Opossum"),
    /** Tates Shrew Opossum, 90-99 Shrew Opossum */
    TATES_SHREW_OPOSSUM (90, "Tates Shrew Opossum"),
    /** Greater Bilby, 100-109 Bandicoots and Bilbies */
    GREATER_BILBY (100, "Greater Bilby"),
    /** Tasmanian Devil, 110-149 Carnivorous Marsupials */
    TASMANIAN_DEVIL (110, "Tasmanian Devil"),
    /** Brush-Tailed Rock-Wallaby, 150-199 Wallabies, Wallaroos and Kangaroos */
    BRUSH_TAILED_ROCK_WALLABY (150, "Brush-Tailed Rock-Wallaby"),
    /** Eastern Wallaroo */
    EASTERN_WALLAROO (160, "Eastern Wallaroo"),
    /** Red Kangaroo */
    RED_KANGAROO (170, "Red Kangaroo"),
    /** Queensland Koala, 200-204 Koalas */
    QUEENSLAND_KOALA (200, "Queensland Koala"),
    /** Southern Hairy-Nosed Wombat, 205-209 Wombats */
    SOUTHERN_HAIRY_NOSED_WOMBAT (205, "Southern Hairy-Nosed Wombat"),
    /** Brushtail Possum, 210-249 Possums, Gliders, and Cuscus */
    BRUSHTAIL_POSSUM (210, "Brushtail Possum"),
    /** Sugar Glider */
    SUGAR_GLIDER (211, "Sugar Glider");

    private int value;
    private final String description;

    SubcategoriesforLandCategory206Marsupial(int value, String description)
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

    public static SubcategoriesforLandCategory206Marsupial getEnumForValue(int i)
    {
       for(SubcategoriesforLandCategory206Marsupial val: SubcategoriesforLandCategory206Marsupial.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforLandCategory206Marsupial");
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

    public static SubcategoriesforLandCategory206Marsupial unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SubcategoriesforLandCategory206Marsupial unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "SubcategoriesforLandCategory206Marsupial " + getValue() + " " + name(); 
    }
}
