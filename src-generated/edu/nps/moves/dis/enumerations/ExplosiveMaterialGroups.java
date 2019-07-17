package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 309 marshal size 8<br>
 * Explosive Material Groups
 */
public enum ExplosiveMaterialGroups 
{
    /** General */
    GENERAL (0, "General"),
    /** Liquid - Aviation/Missile Fuels */
    LIQUID_AVIATION_MISSILE_FUELS (1, "Liquid - Aviation/Missile Fuels"),
    /** Liquid - Other Fuels */
    LIQUID_OTHER_FUELS (2, "Liquid - Other Fuels"),
    /** Liquid Explosive Material */
    LIQUID_EXPLOSIVE_MATERIAL (3, "Liquid Explosive Material"),
    /** Solid */
    SOLID (4, "Solid"),
    /** Gaseous */
    GASEOUS (5, "Gaseous"),
    /** Dust Material */
    DUST_MATERIAL (6, "Dust Material");

    private int value;
    private final String description;

    ExplosiveMaterialGroups(int value, String description)
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

    public static ExplosiveMaterialGroups getEnumForValue(int i)
    {
       for(ExplosiveMaterialGroups val: ExplosiveMaterialGroups.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ExplosiveMaterialGroups");
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

    public static ExplosiveMaterialGroups unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static ExplosiveMaterialGroups unmarshalEnum(ByteBuffer buff) throws Exception
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
