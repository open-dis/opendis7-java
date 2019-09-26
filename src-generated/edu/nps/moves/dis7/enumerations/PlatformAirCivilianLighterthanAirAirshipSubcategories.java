package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 280 marshal size 8<br>
 * Platform-Air Civilian Lighter than Air, Airship Subcategories<br>
 * Subcategories for Air Platform Category 101
 */
public enum PlatformAirCivilianLighterthanAirAirshipSubcategories implements SubCategory
{

    /** Non-rigid (blimp) */
    NON_RIGID_BLIMP (1, "Non-rigid (blimp)"),
    /** Semi-rigid */
    SEMI_RIGID (2, "Semi-rigid"),
    /** Rigid */
    RIGID (3, "Rigid"),
    /** Hybrid */
    HYBRID (4, "Hybrid");

    private int value;
    private final String description;

    PlatformAirCivilianLighterthanAirAirshipSubcategories(int value, String description)
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

    public static PlatformAirCivilianLighterthanAirAirshipSubcategories getEnumForValue(int i)
    {
       for(PlatformAirCivilianLighterthanAirAirshipSubcategories val: PlatformAirCivilianLighterthanAirAirshipSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCivilianLighterthanAirAirshipSubcategories");
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

    public static PlatformAirCivilianLighterthanAirAirshipSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformAirCivilianLighterthanAirAirshipSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformAirCivilianLighterthanAirAirshipSubcategories: " + name() + ": " + getValue(); 
    }
}
