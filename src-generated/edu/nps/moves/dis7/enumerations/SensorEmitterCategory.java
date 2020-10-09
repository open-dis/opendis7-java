package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 28 marshal size 8<br>
 * SensorEmitterCategory
 */
public enum SensorEmitterCategory implements Category
{
    /** Other */
    OTHER (0, "Other"),
    /** Multi-spectral */
    MULTI_SPECTRAL (1, "Multi-spectral"),
    /** RF Active */
    RF_ACTIVE (2, "RF Active"),
    /** RF Passive (intercept and DF) */
    RF_PASSIVE_INTERCEPT_AND_DF (3, "RF Passive (intercept and DF)"),
    /** Optical (direct viewing with or without optics) */
    OPTICAL_DIRECT_VIEWING_WITH_OR_WITHOUT_OPTICS (4, "Optical (direct viewing with or without optics)"),
    /** Electro-Optical */
    ELECTRO_OPTICAL (5, "Electro-Optical"),
    /** Seismic */
    SEISMIC (6, "Seismic"),
    /** Chemical, point detector */
    CHEMICAL_POINT_DETECTOR (7, "Chemical, point detector"),
    /** Chemical, standoff */
    CHEMICAL_STANDOFF (8, "Chemical, standoff"),
    /** Thermal (temperature sensing) */
    THERMAL_TEMPERATURE_SENSING (9, "Thermal (temperature sensing)"),
    /** Acoustic, Active */
    ACOUSTIC_ACTIVE (10, "Acoustic, Active"),
    /** Acoustic, Passive */
    ACOUSTIC_PASSIVE (11, "Acoustic, Passive"),
    /** Contact/Pressure (physical, hydrostatic, barometric) */
    CONTACT_PRESSURE_PHYSICAL_HYDROSTATIC_BAROMETRIC (12, "Contact/Pressure (physical, hydrostatic, barometric)"),
    /** Electro-Magnetic Radiation (gamma radiation) */
    ELECTRO_MAGNETIC_RADIATION_GAMMA_RADIATION (13, "Electro-Magnetic Radiation (gamma radiation)"),
    /** Particle Radiation (Neutrons, alpha, beta particles) */
    PARTICLE_RADIATION_NEUTRONS_ALPHA_BETA_PARTICLES (14, "Particle Radiation (Neutrons, alpha, beta particles)"),
    /** Magnetic */
    MAGNETIC (15, "Magnetic"),
    /** Gravitational */
    GRAVITATIONAL (16, "Gravitational");

    private int value;
    private final String description;

    SensorEmitterCategory(int value, String description)
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

    public static SensorEmitterCategory getEnumForValue(int i)
    {
       for(SensorEmitterCategory val: SensorEmitterCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SensorEmitterCategory");
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

    public static SensorEmitterCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SensorEmitterCategory unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "SensorEmitterCategory " + getValue() + " " + name(); 
    }
}
