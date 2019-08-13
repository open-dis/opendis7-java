package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 395 marshal size 4<br>
 * Appearance-Environmental Density
 */
public enum AppearanceEnvironmentalDensity 
{
    /** Clear */
    CLEAR (0, "Clear"),
    /** Hazy */
    HAZY (1, "Hazy"),
    /** Dense */
    DENSE (2, "Dense"),
    /** Very Dense */
    VERY_DENSE (3, "Very Dense"),
    /** Opaque */
    OPAQUE (4, "Opaque");

    private int value;
    private final String description;

    AppearanceEnvironmentalDensity(int value, String description)
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
      return 4;
    }

    public static AppearanceEnvironmentalDensity getEnumForValue(int i)
    {
       for(AppearanceEnvironmentalDensity val: AppearanceEnvironmentalDensity.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AppearanceEnvironmentalDensity");
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

    public static AppearanceEnvironmentalDensity unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static AppearanceEnvironmentalDensity unmarshalEnum(ByteBuffer buff) throws Exception
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
