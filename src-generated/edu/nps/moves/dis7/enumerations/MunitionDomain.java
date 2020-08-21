package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 14 marshal size 8<br>
 * MunitionDomain
 */
public enum MunitionDomain 
{
    /** Other */
    OTHER (0, "Other"),
    /** Anti-Air */
    ANTI_AIR (1, "Anti-Air"),
    /** Anti-Armor */
    ANTI_ARMOR (2, "Anti-Armor"),
    /** Anti-Guided Weapon */
    ANTI_GUIDED_WEAPON (3, "Anti-Guided Weapon"),
    /** Anti-Radar */
    ANTI_RADAR (4, "Anti-Radar"),
    /** Anti-Satellite */
    ANTI_SATELLITE (5, "Anti-Satellite"),
    /** Anti-Ship */
    ANTI_SHIP (6, "Anti-Ship"),
    /** Anti-Submarine */
    ANTI_SUBMARINE (7, "Anti-Submarine"),
    /** Anti-Personnel */
    ANTI_PERSONNEL (8, "Anti-Personnel"),
    /** Battlefield Support */
    BATTLEFIELD_SUPPORT (9, "Battlefield Support"),
    /** Strategic */
    STRATEGIC (10, "Strategic"),
    /** Tactical */
    TACTICAL (11, "Tactical"),
    /** Directed Energy (DE) Weapon */
    DIRECTED_ENERGY_DE_WEAPON (12, "Directed Energy (DE) Weapon");

    private int value;
    private final String description;

    MunitionDomain(int value, String description)
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

    public static MunitionDomain getEnumForValue(int i)
    {
       for(MunitionDomain val: MunitionDomain.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MunitionDomain");
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

    public static MunitionDomain unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static MunitionDomain unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "MunitionDomain: " + name() + ": " + getValue(); 
    }
}
