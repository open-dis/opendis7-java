package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 440 marshal size 8<br>
 * _________________________________________________<br>
 * Subcategories for Land Platform Category 93
 */
public enum PlatformLandUtilityEmergencyCarSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Ambulance Car */
    AMBULANCE_CAR (1, "Ambulance Car"),
    /** Police Car */
    POLICE_CAR (2, "Police Car"),
    /** Police Chief */
    POLICE_CHIEF (3, "Police Chief"),
    /** Hearse */
    HEARSE (4, "Hearse"),
    /** Taxi */
    TAXI (5, "Taxi");

    private int value;
    private final String description;

    PlatformLandUtilityEmergencyCarSubcategories(int value, String description)
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

    public static PlatformLandUtilityEmergencyCarSubcategories getEnumForValue(int i)
    {
       for(PlatformLandUtilityEmergencyCarSubcategories val: PlatformLandUtilityEmergencyCarSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandUtilityEmergencyCarSubcategories");
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

    public static PlatformLandUtilityEmergencyCarSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformLandUtilityEmergencyCarSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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

    /** Returns the size of this serialized object in bytes
     *@return size in bytes*/  
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "PlatformLandUtilityEmergencyCarSubcategories: " + name() + ": " + getValue(); 
    }
}
