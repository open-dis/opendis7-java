package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 274 marshal size 8<br>
 * Platform-Air Civilian Ultralight Non-rigid Wing Aircraft Subcategories<br>
 * Subcategories for Air Platform Category 80
 */
public enum PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories implements SubCategory
{

    /** Hang Glider, Unpowered */
    HANG_GLIDER_UNPOWERED (1, "Hang Glider, Unpowered"),
    /** Hang Glider, Powered */
    HANG_GLIDER_POWERED (2, "Hang Glider, Powered"),
    /** Paraglider, Unpowered */
    PARAGLIDER_UNPOWERED (3, "Paraglider, Unpowered"),
    /** Paraglider, Powered */
    PARAGLIDER_POWERED (4, "Paraglider, Powered"),
    /** Powered Parachute */
    POWERED_PARACHUTE (5, "Powered Parachute");

    private int value;
    private final String description;

    PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories(int value, String description)
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

    public static PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories getEnumForValue(int i)
    {
       for(PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories val: PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories");
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

    public static PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
