package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 433 marshal size 8<br>
 * Platform-Land-Multiple Unit Utility Emergency Truck Subcategories<br>
 * Subcategories for Land Platform Category 86
 */
public enum PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Fire Engine, Hook And Ladder */
    FIRE_ENGINE_HOOK_AND_LADDER (1, "Fire Engine, Hook And Ladder");

    private int value;
    private final String description;

    PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories(int value, String description)
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

    public static PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories getEnumForValue(int i)
    {
       for(PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories val: PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories");
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

    public static PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories: " + name() + ": " + getValue(); 
    }
}
