package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 101 marshal size 8<br>
 * SubcategoriesforLandCategory201Reptile
 */
public enum SubcategoriesforLandCategory201Reptile implements SubCategory
{
    /** New Zealand Northern Tuatara, 1-29 Lizard/tuatara */
    NEW_ZEALAND_NORTHERN_TUATARA (1, "New Zealand Northern Tuatara"),
    /** Monitor */
    MONITOR (3, "Monitor"),
    /** Gecko */
    GECKO (8, "Gecko"),
    /** Iguana */
    IGUANA (13, "Iguana"),
    /** Chameleon */
    CHAMELEON (17, "Chameleon"),
    /** Non-Venomous Snake, 30-59 Non-venomous snake */
    NON_VENOMOUS_SNAKE (30, "Non-Venomous Snake"),
    /** Boa */
    BOA (31, "Boa"),
    /** Python */
    PYTHON (35, "Python"),
    /** Bullsnake */
    BULLSNAKE (39, "Bullsnake"),
    /** Kingsnake */
    KINGSNAKE (43, "Kingsnake"),
    /** Venomous Snake, 60-89 Venomous snake */
    VENOMOUS_SNAKE (60, "Venomous Snake"),
    /** Rattlesnake */
    RATTLESNAKE (61, "Rattlesnake"),
    /** Copperhead */
    COPPERHEAD (62, "Copperhead"),
    /** Cottonmouth */
    COTTONMOUTH (63, "Cottonmouth"),
    /** Taipan */
    TAIPAN (64, "Taipan"),
    /** Viper */
    VIPER (65, "Viper"),
    /** Cobra */
    COBRA (66, "Cobra"),
    /** Australian Brown Snake */
    AUSTRALIAN_BROWN_SNAKE (67, "Australian Brown Snake"),
    /** Tortoise, 90-119 Turtle/Tortoise */
    TORTOISE (90, "Tortoise"),
    /** Turtle */
    TURTLE (100, "Turtle"),
    /** American Alligator, 120-149 Crocodilian */
    AMERICAN_ALLIGATOR (120, "American Alligator"),
    /** Crocodile */
    CROCODILE (121, "Crocodile"),
    /** Australian Freshwater Crocodile */
    AUSTRALIAN_FRESHWATER_CROCODILE (122, "Australian Freshwater Crocodile");

    private int value;
    private final String description;

    SubcategoriesforLandCategory201Reptile(int value, String description)
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

    public static SubcategoriesforLandCategory201Reptile getEnumForValue(int i)
    {
       for(SubcategoriesforLandCategory201Reptile val: SubcategoriesforLandCategory201Reptile.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforLandCategory201Reptile");
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

    public static SubcategoriesforLandCategory201Reptile unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SubcategoriesforLandCategory201Reptile unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "SubcategoriesforLandCategory201Reptile " + getValue() + " " + name(); 
    }
}
