package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 58 marshal size 5<br>
 * ArticulatedPartsTypeMetric
 */
public enum ArticulatedPartsTypeMetric 
{
    /** Not Specified */
    NOT_SPECIFIED (0, "Not Specified"),
    /** Position */
    POSITION (1, "Position"),
    /** Position Rate */
    POSITION_RATE (2, "Position Rate"),
    /** Extension */
    EXTENSION (3, "Extension"),
    /** Extension Rate */
    EXTENSION_RATE (4, "Extension Rate"),
    /** X */
    X (5, "X"),
    /** X Rate */
    X_RATE (6, "X Rate"),
    /** Y */
    Y (7, "Y"),
    /** Y Rate */
    Y_RATE (8, "Y Rate"),
    /** Z */
    Z (9, "Z"),
    /** Z Rate */
    Z_RATE (10, "Z Rate"),
    /** Azimuth */
    AZIMUTH (11, "Azimuth"),
    /** Azimuth Rate */
    AZIMUTH_RATE (12, "Azimuth Rate"),
    /** Elevation */
    ELEVATION (13, "Elevation"),
    /** Elevation Rate */
    ELEVATION_RATE (14, "Elevation Rate"),
    /** Rotation */
    ROTATION (15, "Rotation"),
    /** Rotation Rate */
    ROTATION_RATE (16, "Rotation Rate");

    private int value;
    private final String description;

    ArticulatedPartsTypeMetric(int value, String description)
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
      return 5;
    }

    public static ArticulatedPartsTypeMetric getEnumForValue(int i)
    {
       for(ArticulatedPartsTypeMetric val: ArticulatedPartsTypeMetric.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ArticulatedPartsTypeMetric");
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

    public static ArticulatedPartsTypeMetric unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static ArticulatedPartsTypeMetric unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "ArticulatedPartsTypeMetric " + getValue() + " " + name(); 
    }
}
