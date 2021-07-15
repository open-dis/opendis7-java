package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
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

    /** Constructor */
    ArticulatedPartsTypeMetric(int value, String description)
    {
        this.value = value;
        this.description = description;
    }
    /** Provide enumeration value
      * @return integer value */
    public int getValue()
    {
        return value;
    }

    /** Provide enumeration description
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /** bit width for this enumeration
     * @return number of bits wide
     */
    public static int getEnumBitWidth()
    {
      return 5;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static ArticulatedPartsTypeMetric getEnumForValue(int i)
    {
       for(ArticulatedPartsTypeMetric val: ArticulatedPartsTypeMetric.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ArticulatedPartsTypeMetric");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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
        String padding = new String();
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "ArticulatedPartsTypeMetric " + padding + getValue() + " " + name();
    }
}
