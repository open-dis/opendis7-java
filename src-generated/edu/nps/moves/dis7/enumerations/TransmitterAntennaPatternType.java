package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 167 marshal size 16<br>
 * TransmitterAntennaPatternType
 */
public enum TransmitterAntennaPatternType 
{
    /** Omni-directional */
    OMNI_DIRECTIONAL (0, "Omni-directional"),
    /** Beam */
    BEAM (1, "Beam"),
    /** Spherical harmonic */
    SPHERICAL_HARMONIC (2, "Spherical harmonic"),
    /** Transmitter Radiation Volume */
    TRANSMITTER_RADIATION_VOLUME (4, "Transmitter Radiation Volume"),
    /** Beam and Transmitter Radiation Volume */
    BEAM_AND_TRANSMITTER_RADIATION_VOLUME (5, "Beam and Transmitter Radiation Volume");

    private int value;
    private final String description;

    TransmitterAntennaPatternType(int value, String description)
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
      return 16;
    }

    public static TransmitterAntennaPatternType getEnumForValue(int i)
    {
       for(TransmitterAntennaPatternType val: TransmitterAntennaPatternType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterAntennaPatternType");
       return null;
    }

 
   public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }

    public static TransmitterAntennaPatternType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static TransmitterAntennaPatternType unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "TransmitterAntennaPatternType " + getValue() + " " + name(); 
    }
}
