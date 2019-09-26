package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 110 marshal size 8<br>
 * Subcategories for Air Category 200 - Bird
 */
public enum SubcategoriesforAirCategory200Bird implements SubCategory
{
    /** Penguin, 1-49 Marine Birds */
    PENGUIN (1, "Penguin"),
    /** Seagull */
    SEAGULL (2, "Seagull"),
    /** Pelican */
    PELICAN (3, "Pelican"),
    /** Albatross */
    ALBATROSS (4, "Albatross"),
    /** Swan */
    SWAN (5, "Swan"),
    /** Cormorant */
    CORMORANT (6, "Cormorant"),
    /** Heron */
    HERON (7, "Heron"),
    /** Crane */
    CRANE (8, "Crane"),
    /** Osprey */
    OSPREY (9, "Osprey"),
    /** Loon */
    LOON (10, "Loon"),
    /** Stork */
    STORK (11, "Stork"),
    /** Flamingo */
    FLAMINGO (12, "Flamingo"),
    /** Duck */
    DUCK (13, "Duck"),
    /** Ostrich, 20-29 Flightless Land Birds */
    OSTRICH (20, "Ostrich"),
    /** Emu */
    EMU (21, "Emu"),
    /** Chicken */
    CHICKEN (22, "Chicken"),
    /** Black Bird, 30-39 Small birds that fly in large flocks */
    BLACK_BIRD (30, "Black Bird"),
    /** Starling */
    STARLING (31, "Starling"),
    /** Budgerigar (Parakeet) */
    BUDGERIGAR_PARAKEET (32, "Budgerigar (Parakeet)"),
    /** Canadian Goose, 40-49 Large birds that fly in large flocks */
    CANADIAN_GOOSE (40, "Canadian Goose"),
    /** Crow */
    CROW (41, "Crow"),
    /** Eagle, 50-99 Birds of prey */
    EAGLE (50, "Eagle"),
    /** Vulture */
    VULTURE (55, "Vulture"),
    /** Falcon */
    FALCON (60, "Falcon"),
    /** Hawk */
    HAWK (65, "Hawk"),
    /** Owl */
    OWL (70, "Owl"),
    /** Kite */
    KITE (80, "Kite");

    private int value;
    private final String description;

    SubcategoriesforAirCategory200Bird(int value, String description)
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

    public static SubcategoriesforAirCategory200Bird getEnumForValue(int i)
    {
       for(SubcategoriesforAirCategory200Bird val: SubcategoriesforAirCategory200Bird.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforAirCategory200Bird");
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

    public static SubcategoriesforAirCategory200Bird unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static SubcategoriesforAirCategory200Bird unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "SubcategoriesforAirCategory200Bird: " + name() + ": " + getValue(); 
    }
}
