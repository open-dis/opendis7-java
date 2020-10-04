package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 277 marshal size 8<br>
 * PlatformAirCivilianFixedWingAircraftSubcategories<br>
 * Subcategories for Air Platform Categories 84-88. Subcategory values have the type of engine in the 10s digit and the number of engines in the 1s digit.
 */
public enum PlatformAirCivilianFixedWingAircraftSubcategories implements SubCategory
{

    /** Single Piston Engine */
    SINGLE_PISTON_ENGINE (11, "Single Piston Engine"),
    /** Twin Piston Engine */
    TWIN_PISTON_ENGINE (12, "Twin Piston Engine"),
    /** Single Engine Turboprop */
    SINGLE_ENGINE_TURBOPROP (21, "Single Engine Turboprop"),
    /** Twin Engine Turboprop */
    TWIN_ENGINE_TURBOPROP (22, "Twin Engine Turboprop"),
    /** Four Engine Turboprop */
    FOUR_ENGINE_TURBOPROP (24, "Four Engine Turboprop"),
    /** Twin Jet */
    TWIN_JET (32, "Twin Jet"),
    /** Tri Jet */
    TRI_JET (33, "Tri Jet"),
    /** Four Engine Jet */
    FOUR_ENGINE_JET (34, "Four Engine Jet");

    private int value;
    private final String description;

    PlatformAirCivilianFixedWingAircraftSubcategories(int value, String description)
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

    public static PlatformAirCivilianFixedWingAircraftSubcategories getEnumForValue(int i)
    {
       for(PlatformAirCivilianFixedWingAircraftSubcategories val: PlatformAirCivilianFixedWingAircraftSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCivilianFixedWingAircraftSubcategories");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    public static PlatformAirCivilianFixedWingAircraftSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformAirCivilianFixedWingAircraftSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "PlatformAirCivilianFixedWingAircraftSubcategories " + getValue() + " " + name(); 
    }
}
