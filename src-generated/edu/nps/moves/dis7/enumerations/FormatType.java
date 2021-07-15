package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 363 marshal size 5<br>
 * FormatType
 */
public enum FormatType 
{
    /** No Data */
    NO_DATA (0, "No Data"),
    /** Identity Format */
    IDENTITY_FORMAT (4, "Identity Format"),
    /** Surface Format, 5 meter RNP */
    SURFACE_FORMAT_5_METER_RNP (5, "Surface Format, 5 meter RNP"),
    /** Surface Format, 100 meter RNP */
    SURFACE_FORMAT_100_METER_RNP (6, "Surface Format, 100 meter RNP"),
    /** Airborne Format, 5 meter RNP, 25-foot Barometric Altitude */
    AIRBORNE_FORMAT_5_METER_RNP_25_FOOT_BAROMETRIC_ALTITUDE (7, "Airborne Format, 5 meter RNP, 25-foot Barometric Altitude"),
    /** Airborne Format, 100 meter RNP, 25-foot Barometric Altitude */
    AIRBORNE_FORMAT_100_METER_RNP_25_FOOT_BAROMETRIC_ALTITUDE (8, "Airborne Format, 100 meter RNP, 25-foot Barometric Altitude"),
    /** Airborne Format, 0.25 nmi RNP, 25-foot Barometric Altitude */
    AIRBORNE_FORMAT_025_NMI_RNP_25_FOOT_BAROMETRIC_ALTITUDE (9, "Airborne Format, 0.25 nmi RNP, 25-foot Barometric Altitude"),
    /** Airborne Format, 1.0 nmi RNP, 25-foot Barometric Altitude */
    AIRBORNE_FORMAT_10_NMI_RNP_25_FOOT_BAROMETRIC_ALTITUDE (10, "Airborne Format, 1.0 nmi RNP, 25-foot Barometric Altitude"),
    /** Airborne Format, 5 meter RNP, 100-foot Barometric Altitude */
    AIRBORNE_FORMAT_5_METER_RNP_100_FOOT_BAROMETRIC_ALTITUDE (11, "Airborne Format, 5 meter RNP, 100-foot Barometric Altitude"),
    /** Airborne Format, 100 meter RNP, 100-foot Barometric Altitude */
    AIRBORNE_FORMAT_100_METER_RNP_100_FOOT_BAROMETRIC_ALTITUDE (12, "Airborne Format, 100 meter RNP, 100-foot Barometric Altitude"),
    /** Airborne Format, 0.25 nmi RNP, 100-foot Barometric Altitude */
    AIRBORNE_FORMAT_025_NMI_RNP_100_FOOT_BAROMETRIC_ALTITUDE (13, "Airborne Format, 0.25 nmi RNP, 100-foot Barometric Altitude"),
    /** Airborne Format, 1.0 nmi RNP, 100-foot Barometric Altitude */
    AIRBORNE_FORMAT_10_NMI_RNP_100_FOOT_BAROMETRIC_ALTITUDE (14, "Airborne Format, 1.0 nmi RNP, 100-foot Barometric Altitude"),
    /** Airborne Format, 5 meter RNP, GPS Height */
    AIRBORNE_FORMAT_5_METER_RNP_GPS_HEIGHT (15, "Airborne Format, 5 meter RNP, GPS Height"),
    /** Airborne Format, 100 meter RNP, GPS Height */
    AIRBORNE_FORMAT_100_METER_RNP_GPS_HEIGHT (16, "Airborne Format, 100 meter RNP, GPS Height");

    private int value;
    private final String description;

    /** Constructor */
    FormatType(int value, String description)
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
    public static FormatType getEnumForValue(int i)
    {
       for(FormatType val: FormatType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration FormatType");
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
    public static FormatType unmarshalEnum (DataInputStream dis) throws Exception
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
    public static FormatType unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "FormatType " + padding + getValue() + " " + name();
    }
}
