package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 508 marshal size 8<br>
 * Platform-Subsurface-Civilian Semi-Submersibles-Subcategories<br>
 * Subcategories for Subsurface Platform Category 82
 */
public enum PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories implements SubCategory
{

    /** Narco-Submarine */
    NARCO_SUBMARINE (1, "Narco-Submarine");

    private int value;
    private final String description;

    PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories(int value, String description)
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

    public static PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories getEnumForValue(int i)
    {
       for(PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories val: PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories");
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

    public static PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformSubsurfaceCivilianSemiSubmersiblesSubcategories: " + name() + ": " + getValue(); 
    }
}
