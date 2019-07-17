package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 137 marshal size 8<br>
 * Add Variants for Air Category 201 - Insect
 */
public enum AddVariantsforAirCategory201Insect 
{
    /** Vertical Shaped Insect Swarm */
    VERTICAL_SHAPED_INSECT_SWARM (1, "Vertical Shaped Insect Swarm"),
    /** Circular Shaped Insect Swarm */
    CIRCULAR_SHAPED_INSECT_SWARM (2, "Circular Shaped Insect Swarm"),
    /** Irregular Shaped Insect Swarm */
    IRREGULAR_SHAPED_INSECT_SWARM (3, "Irregular Shaped Insect Swarm");

    private int value;
    private final String description;

    AddVariantsforAirCategory201Insect(int value, String description)
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

    public static AddVariantsforAirCategory201Insect getEnumForValue(int i)
    {
       for(AddVariantsforAirCategory201Insect val: AddVariantsforAirCategory201Insect.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AddVariantsforAirCategory201Insect");
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

    public static AddVariantsforAirCategory201Insect unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static AddVariantsforAirCategory201Insect unmarshalEnum(ByteBuffer buff) throws Exception
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
