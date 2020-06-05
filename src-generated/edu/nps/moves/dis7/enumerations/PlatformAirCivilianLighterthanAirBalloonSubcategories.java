package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 279 marshal size 8<br>
 * Platform-Air Civilian Lighter than Air, Balloon Subcategories<br>
 * Subcategories for Air Platform Category 100
 */
public enum PlatformAirCivilianLighterthanAirBalloonSubcategories implements SubCategory
{

    /** Gas-filled, free */
    GAS_FILLED_FREE (1, "Gas-filled, free"),
    /** Gas-filled, tethered */
    GAS_FILLED_TETHERED (2, "Gas-filled, tethered"),
    /** Hot Air */
    HOT_AIR (3, "Hot Air"),
    /** Roziere Balloon */
    ROZIERE_BALLOON (4, "Roziere Balloon"),
    /** Helikite */
    HELIKITE (5, "Helikite");

    private int value;
    private final String description;

    PlatformAirCivilianLighterthanAirBalloonSubcategories(int value, String description)
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

    public static PlatformAirCivilianLighterthanAirBalloonSubcategories getEnumForValue(int i)
    {
       for(PlatformAirCivilianLighterthanAirBalloonSubcategories val: PlatformAirCivilianLighterthanAirBalloonSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCivilianLighterthanAirBalloonSubcategories");
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

    public static PlatformAirCivilianLighterthanAirBalloonSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformAirCivilianLighterthanAirBalloonSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformAirCivilianLighterthanAirBalloonSubcategories: " + name() + ": " + getValue(); 
    }
}
