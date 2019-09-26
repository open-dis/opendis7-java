package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 443 marshal size 8<br>
 * Platform-Surface Tanker Subcategories<br>
 * Subcategories for Surface Platform Category 82.
 */
public enum PlatformSurfaceTankerSubcategories implements SubCategory
{

    /** Liquid Petroleum Gas (LPG)Tanker */
    LIQUID_PETROLEUM_GAS_LPGTANKER (1, "Liquid Petroleum Gas (LPG)Tanker"),
    /** Chemical Tanker */
    CHEMICAL_TANKER (2, "Chemical Tanker"),
    /** Liquid Natural Gas (LNG) Tanker */
    LIQUID_NATURAL_GAS_LNG_TANKER (3, "Liquid Natural Gas (LNG) Tanker"),
    /** Coastal Trading Vessel (Coaster) */
    COASTAL_TRADING_VESSEL_COASTER (4, "Coastal Trading Vessel (Coaster)"),
    /** Crude Oil Tanker (up to 159,999 DWT) */
    CRUDE_OIL_TANKER_UP_TO_159_999_DWT (5, "Crude Oil Tanker (up to 159,999 DWT)"),
    /** Liquid Bulk Tanker */
    LIQUID_BULK_TANKER (6, "Liquid Bulk Tanker"),
    /** Very Large Crude Carrier (160,000–319,999 DWT) */
    VERY_LARGE_CRUDE_CARRIER_160_000_319_999_DWT (7, "Very Large Crude Carrier (160,000–319,999 DWT)"),
    /** Ultra Large Crude Carrier (320,000–549,999 DWT) */
    ULTRA_LARGE_CRUDE_CARRIER_320_000_549_999_DWT (8, "Ultra Large Crude Carrier (320,000–549,999 DWT)"),
    /** Condensate Storage Tanker */
    CONDENSATE_STORAGE_TANKER (9, "Condensate Storage Tanker");

    private int value;
    private final String description;

    PlatformSurfaceTankerSubcategories(int value, String description)
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

    public static PlatformSurfaceTankerSubcategories getEnumForValue(int i)
    {
       for(PlatformSurfaceTankerSubcategories val: PlatformSurfaceTankerSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfaceTankerSubcategories");
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

    public static PlatformSurfaceTankerSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformSurfaceTankerSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformSurfaceTankerSubcategories: " + name() + ": " + getValue(); 
    }
}
