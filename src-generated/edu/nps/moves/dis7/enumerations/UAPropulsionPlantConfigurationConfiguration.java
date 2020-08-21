package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 335 marshal size 7<br>
 * UAPropulsionPlantConfigurationConfiguration
 */
public enum UAPropulsionPlantConfigurationConfiguration 
{
    /** Other */
    OTHER (0, "Other"),
    /** Diesel/Electric */
    DIESEL_ELECTRIC (1, "Diesel/Electric"),
    /** Diesel */
    DIESEL (2, "Diesel"),
    /** Battery */
    BATTERY (3, "Battery"),
    /** Turbine Reduction */
    TURBINE_REDUCTION (4, "Turbine Reduction"),
    /** Steam */
    STEAM (6, "Steam"),
    /** Gas Turbine */
    GAS_TURBINE (7, "Gas Turbine");

    private int value;
    private final String description;

    UAPropulsionPlantConfigurationConfiguration(int value, String description)
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
      return 7;
    }

    public static UAPropulsionPlantConfigurationConfiguration getEnumForValue(int i)
    {
       for(UAPropulsionPlantConfigurationConfiguration val: UAPropulsionPlantConfigurationConfiguration.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration UAPropulsionPlantConfigurationConfiguration");
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

    public static UAPropulsionPlantConfigurationConfiguration unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static UAPropulsionPlantConfigurationConfiguration unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "UAPropulsionPlantConfigurationConfiguration: " + name() + ": " + getValue(); 
    }
}
