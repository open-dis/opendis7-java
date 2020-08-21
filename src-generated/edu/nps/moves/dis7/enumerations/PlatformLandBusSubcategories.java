package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 429 marshal size 8<br>
 * PlatformLandBusSubcategories<br>
 * Subcategories for Land Platform Category 82
 */
public enum PlatformLandBusSubcategories 
{

    /** Other */
    OTHER (0, "Other"),
    /** Commuter (Flat Nose) */
    COMMUTER_FLAT_NOSE (1, "Commuter (Flat Nose)"),
    /** Commuter (Snout Nose) */
    COMMUTER_SNOUT_NOSE (2, "Commuter (Snout Nose)"),
    /** Shuttle */
    SHUTTLE (3, "Shuttle"),
    /** Double Decker */
    DOUBLE_DECKER (4, "Double Decker"),
    /** Guided */
    GUIDED (5, "Guided"),
    /** Kneeling */
    KNEELING (6, "Kneeling"),
    /** Midibus */
    MIDIBUS (7, "Midibus"),
    /** Minibus */
    MINIBUS (8, "Minibus"),
    /** Mini Wheelchair */
    MINI_WHEELCHAIR (9, "Mini Wheelchair"),
    /** Motorcoach */
    MOTORCOACH (10, "Motorcoach"),
    /** Prison Bus */
    PRISON_BUS (11, "Prison Bus"),
    /** Schoolbus */
    SCHOOLBUS (12, "Schoolbus"),
    /** School Wheelchair */
    SCHOOL_WHEELCHAIR (13, "School Wheelchair"),
    /** Tour */
    TOUR (14, "Tour"),
    /** Tram Parking Lot */
    TRAM_PARKING_LOT (15, "Tram Parking Lot"),
    /** Trolley */
    TROLLEY (16, "Trolley"),
    /** Airport Transport */
    AIRPORT_TRANSPORT (17, "Airport Transport"),
    /** Articulated (Multi-Unit) */
    ARTICULATED_MULTI_UNIT (18, "Articulated (Multi-Unit)");

    private int value;
    private final String description;

    PlatformLandBusSubcategories(int value, String description)
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

    public static PlatformLandBusSubcategories getEnumForValue(int i)
    {
       for(PlatformLandBusSubcategories val: PlatformLandBusSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandBusSubcategories");
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

    public static PlatformLandBusSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformLandBusSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformLandBusSubcategories: " + name() + ": " + getValue(); 
    }
}
