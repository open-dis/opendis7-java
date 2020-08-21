package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 442 marshal size 8<br>
 * PlatformSurfaceDryCargoShipSubcategories<br>
 * Subcategories for Surface Platform Category 81.
 */
public enum PlatformSurfaceDryCargoShipSubcategories implements SubCategory
{

    /** Common Dry Cargo Ship */
    COMMON_DRY_CARGO_SHIP (1, "Common Dry Cargo Ship"),
    /** Dry Bulk Cargo Ship */
    DRY_BULK_CARGO_SHIP (2, "Dry Bulk Cargo Ship"),
    /** Container Ship */
    CONTAINER_SHIP (3, "Container Ship"),
    /** Reefer Ship (Refrigerator Ship) */
    REEFER_SHIP_REFRIGERATOR_SHIP (4, "Reefer Ship (Refrigerator Ship)"),
    /** Ro-Ro Ship (Roll-on/Roll-off Ship) */
    RO_RO_SHIP_ROLL_ON_ROLL_OFF_SHIP (5, "Ro-Ro Ship (Roll-on/Roll-off Ship)"),
    /** Barge */
    BARGE (6, "Barge"),
    /** Heavy Lift Ship */
    HEAVY_LIFT_SHIP (7, "Heavy Lift Ship");

    private int value;
    private final String description;

    PlatformSurfaceDryCargoShipSubcategories(int value, String description)
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

    public static PlatformSurfaceDryCargoShipSubcategories getEnumForValue(int i)
    {
       for(PlatformSurfaceDryCargoShipSubcategories val: PlatformSurfaceDryCargoShipSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfaceDryCargoShipSubcategories");
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

    public static PlatformSurfaceDryCargoShipSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformSurfaceDryCargoShipSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformSurfaceDryCargoShipSubcategories: " + name() + ": " + getValue(); 
    }
}
