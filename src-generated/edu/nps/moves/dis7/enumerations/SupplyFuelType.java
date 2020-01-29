package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 413 marshal size 8<br>
 * Supply-Fuel Type<br>
 * Specific values for Supply Subcategory Fuels (1).
 */
public enum SupplyFuelType 
{

    /** Other */
    OTHER (0, "Other"),
    /** Gasoline */
    GASOLINE (1, "Gasoline"),
    /** Diesel Fuel (F-54/DF-2) */
    DIESEL_FUEL_F_54_DF_2 (2, "Diesel Fuel (F-54/DF-2)"),
    /** JP-4 (F-40/JET B) */
    JP_4_F_40_JET_B (3, "JP-4 (F-40/JET B)"),
    /** Fuel Oil */
    FUEL_OIL (4, "Fuel Oil"),
    /** JP-8 (F-34/JET A-1) */
    JP_8_F_34_JET_A_1 (5, "JP-8 (F-34/JET A-1)"),
    /** Fog Oil */
    FOG_OIL (6, "Fog Oil"),
    /** Multi-Spectral Fog Oil */
    MULTI_SPECTRAL_FOG_OIL (7, "Multi-Spectral Fog Oil"),
    /** JP-5 (F-44/JET A) */
    JP_5_F_44_JET_A (8, "JP-5 (F-44/JET A)"),
    /** JPTS */
    JPTS (9, "JPTS"),
    /** TS-1 (Russia (RUS)) */
    TS_1_RUSSIA_RUS (10, "TS-1 (Russia (RUS))");

    private int value;
    private final String description;

    SupplyFuelType(int value, String description)
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

    public static SupplyFuelType getEnumForValue(int i)
    {
       for(SupplyFuelType val: SupplyFuelType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SupplyFuelType");
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

    public static SupplyFuelType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static SupplyFuelType unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "SupplyFuelType: " + name() + ": " + getValue(); 
    }
}
