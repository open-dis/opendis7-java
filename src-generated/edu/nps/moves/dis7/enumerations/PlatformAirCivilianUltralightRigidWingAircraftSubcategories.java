package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 275 marshal size 8<br>
 * PlatformAirCivilianUltralightRigidWingAircraftSubcategories<br>
 * Subcategories for Air Platform Category 81
 */
public enum PlatformAirCivilianUltralightRigidWingAircraftSubcategories implements SubCategory
{

    /** Weight-shift control */
    WEIGHT_SHIFT_CONTROL (1, "Weight-shift control"),
    /** Control surface (elevator, rudder, aileron) control */
    CONTROL_SURFACE_ELEVATOR_RUDDER_AILERON_CONTROL (2, "Control surface (elevator, rudder, aileron) control");

    private int value;
    private final String description;

    PlatformAirCivilianUltralightRigidWingAircraftSubcategories(int value, String description)
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

    public static PlatformAirCivilianUltralightRigidWingAircraftSubcategories getEnumForValue(int i)
    {
       for(PlatformAirCivilianUltralightRigidWingAircraftSubcategories val: PlatformAirCivilianUltralightRigidWingAircraftSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCivilianUltralightRigidWingAircraftSubcategories");
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

    public static PlatformAirCivilianUltralightRigidWingAircraftSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformAirCivilianUltralightRigidWingAircraftSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "PlatformAirCivilianUltralightRigidWingAircraftSubcategories " + getValue() + " " + name(); 
    }
}
