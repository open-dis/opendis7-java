package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 363 marshal size 5<br>
 * Format Type
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

    FormatType(int value, String description)
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

    public static FormatType getEnumForValue(int i)
    {
       for(FormatType val: FormatType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration FormatType");
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

    public static FormatType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static FormatType unmarshalEnum(ByteBuffer buff) throws Exception
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
