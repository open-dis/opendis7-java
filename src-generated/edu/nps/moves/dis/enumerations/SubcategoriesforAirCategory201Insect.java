package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 111 marshal size 8<br>
 * Subcategories for Air Category 201 - Insect
 */
public enum SubcategoriesforAirCategory201Insect implements SubCategory
{
    /** Moth, 1-19 Moth/Butterfly */
    MOTH (1, "Moth"),
    /** Butterfly */
    BUTTERFLY (2, "Butterfly"),
    /** Fly, 20-29 Fly/Midge */
    FLY (20, "Fly"),
    /** Mosquito, 30-39 Mosquito/Gnat */
    MOSQUITO (30, "Mosquito"),
    /** Wasp, 40-49 Wasp/Hornet */
    WASP (40, "Wasp"),
    /** Bee, 50-59 Bee */
    BEE (50, "Bee"),
    /** Beetle, 60-69 Beetle */
    BEETLE (60, "Beetle"),
    /** Dragonfly, 70-79 Dragonfly/Damselfly */
    DRAGONFLY (70, "Dragonfly"),
    /** Locust, 80-89 Locust */
    LOCUST (80, "Locust");

    private int value;
    private final String description;

    SubcategoriesforAirCategory201Insect(int value, String description)
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

    public static SubcategoriesforAirCategory201Insect getEnumForValue(int i)
    {
       for(SubcategoriesforAirCategory201Insect val: SubcategoriesforAirCategory201Insect.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforAirCategory201Insect");
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

    public static SubcategoriesforAirCategory201Insect unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static SubcategoriesforAirCategory201Insect unmarshalEnum(ByteBuffer buff) throws Exception
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
}
