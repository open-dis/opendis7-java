package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 193 marshal size 4<br>
 * Minefield-Sensor Types
 */
public enum MinefieldSensorTypes 
{
    /** Other */
    OTHER (0, "Other"),
    /** MinefieldSensorTypesOptical */    OPTICAL_2 (1, "Optical"),
    /** MinefieldSensorTypesFLIR */    FLIR_2 (2, "FLIR"),
    /** MinefieldSensorTypesRADAR */    RADAR_2 (3, "RADAR"),
    /** MinefieldSensorTypesMagnetic */    MAGNETIC_2 (4, "Magnetic"),
    /** MinefieldSensorTypesLaser */    LASER_2 (5, "Laser"),
    /** MinefieldSensorTypesSONAR */    SONAR_2 (6, "SONAR"),
    /** MinefieldSensorTypesPhysical */    PHYSICAL_2 (7, "Physical"),
    /** MinefieldSensorTypesMultispectral */    MULTISPECTRAL_2 (8, "Multispectral");

    private int value;
    private final String description;

    MinefieldSensorTypes(int value, String description)
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
      return 4;
    }

    public static MinefieldSensorTypes getEnumForValue(int i)
    {
       for(MinefieldSensorTypes val: MinefieldSensorTypes.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MinefieldSensorTypes");
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

    public static MinefieldSensorTypes unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static MinefieldSensorTypes unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "MinefieldSensorTypes: " + name() + ": " + getValue(); 
    }
}
