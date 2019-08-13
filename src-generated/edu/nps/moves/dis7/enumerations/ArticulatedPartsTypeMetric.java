package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 58 marshal size 5<br>
 * Articulated Parts-Type Metric
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
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
    }

    public static ArticulatedPartsTypeMetric unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static ArticulatedPartsTypeMetric unmarshalEnum(ByteBuffer buff) throws Exception
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
}
