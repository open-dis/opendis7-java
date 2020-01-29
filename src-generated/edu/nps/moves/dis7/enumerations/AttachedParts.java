package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 57 marshal size 32<br>
 * Attached Parts
 */
public enum AttachedParts 
{
    /** Nothing, Empty */
    NOTHING_EMPTY (0, "Nothing, Empty"),
    /** M16A42 rifle */
    M16A42_RIFLE (896, "M16A42 rifle"),
    /** M249 SAW */
    M249_SAW (897, "M249 SAW"),
    /** M60 Machine gun */
    M60_MACHINE_GUN (898, "M60 Machine gun"),
    /** M203 Grenade Launcher */
    M203_GRENADE_LAUNCHER (899, "M203 Grenade Launcher"),
    /** M136 AT4 */
    M136_AT4 (900, "M136 AT4"),
    /** M47 Dragon */
    M47_DRAGON (901, "M47 Dragon"),
    /** AAWS-M Javelin */
    AAWS_M_JAVELIN (902, "AAWS-M Javelin"),
    /** M18A1 Claymore Mine */
    M18A1_CLAYMORE_MINE (903, "M18A1 Claymore Mine"),
    /** MK19 Grenade Launcher */
    MK19_GRENADE_LAUNCHER (904, "MK19 Grenade Launcher"),
    /** M2 Machine Gun */
    M2_MACHINE_GUN (905, "M2 Machine Gun");

    private int value;
    private final String description;

    AttachedParts(int value, String description)
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
      return 32;
    }

    public static AttachedParts getEnumForValue(int i)
    {
       for(AttachedParts val: AttachedParts.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AttachedParts");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    public void marshal(ByteBuffer buff)
    {
        buff.putInt(getValue());
    }

    public static AttachedParts unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    public static AttachedParts unmarshalEnum (ByteBuffer buff)
    {
        return getEnumForValue(buff.getInt());
    }

    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
    
    @Override
    public String toString()
    {
        return "AttachedParts: " + name() + ": " + getValue();
    }
}
