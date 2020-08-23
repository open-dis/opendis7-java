package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 278 marshal size 8<br>
 * ______________________________________________<br>
 * Subcategories for Air Platform Categories 90-92. Subcategory values have the number of rotors in the 10s digit and the rotor configuration in the 1s digit.
 */
public enum PlatformAirCivilianHelicopterSubcategories implements SubCategory
{

    /** Single Rotor, Piston Engine */
    SINGLE_ROTOR_PISTON_ENGINE (11, "Single Rotor, Piston Engine"),
    /** Single Rotor, Turboshaft Engine, Conventional Tail Rotor */
    SINGLE_ROTOR_TURBOSHAFT_ENGINE_CONVENTIONAL_TAIL_ROTOR (12, "Single Rotor, Turboshaft Engine, Conventional Tail Rotor"),
    /** Single Rotor, Turboshaft Engine, Shrouded Tail Rotor */
    SINGLE_ROTOR_TURBOSHAFT_ENGINE_SHROUDED_TAIL_ROTOR (13, "Single Rotor, Turboshaft Engine, Shrouded Tail Rotor"),
    /** Single Rotor, Turboshaft Engine, No Tail Rotor */
    SINGLE_ROTOR_TURBOSHAFT_ENGINE_NO_TAIL_ROTOR (14, "Single Rotor, Turboshaft Engine, No Tail Rotor"),
    /** Tandem Rotor */
    TANDEM_ROTOR (21, "Tandem Rotor"),
    /** Coaxial Rotor */
    COAXIAL_ROTOR (22, "Coaxial Rotor"),
    /** Intermeshing Rotor */
    INTERMESHING_ROTOR (23, "Intermeshing Rotor");

    private int value;
    private final String description;

    PlatformAirCivilianHelicopterSubcategories(int value, String description)
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

    public static PlatformAirCivilianHelicopterSubcategories getEnumForValue(int i)
    {
       for(PlatformAirCivilianHelicopterSubcategories val: PlatformAirCivilianHelicopterSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCivilianHelicopterSubcategories");
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

    public static PlatformAirCivilianHelicopterSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformAirCivilianHelicopterSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformAirCivilianHelicopterSubcategories: " + name() + ": " + getValue(); 
    }
}
