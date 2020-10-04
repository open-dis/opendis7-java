package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 165 marshal size 8<br>
 * TransmitterInputSource
 */
public enum TransmitterInputSource 
{
    /** Other */
    OTHER (0, "Other"),
    /** Pilot */
    PILOT (1, "Pilot"),
    /** Copilot */
    COPILOT (2, "Copilot"),
    /** First Officer */
    FIRST_OFFICER (3, "First Officer"),
    /** Driver */
    DRIVER (4, "Driver"),
    /** Loader */
    LOADER (5, "Loader"),
    /** Gunner */
    GUNNER (6, "Gunner"),
    /** Commander */
    COMMANDER (7, "Commander"),
    /** Digital Data Device */
    DIGITAL_DATA_DEVICE (8, "Digital Data Device"),
    /** Intercom */
    INTERCOM (9, "Intercom"),
    /** Audio Jammer */
    AUDIO_JAMMER (10, "Audio Jammer"),
    /** Data Jammer */
    DATA_JAMMER (11, "Data Jammer"),
    /** GPS Jammer */
    GPS_JAMMER (12, "GPS Jammer"),
    /** GPS Meaconer */
    GPS_MEACONER (13, "GPS Meaconer"),
    /** SATCOM Uplink Jammer */
    SATCOM_UPLINK_JAMMER (14, "SATCOM Uplink Jammer");

    private int value;
    private final String description;

    TransmitterInputSource(int value, String description)
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

    public static TransmitterInputSource getEnumForValue(int i)
    {
       for(TransmitterInputSource val: TransmitterInputSource.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterInputSource");
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

    public static TransmitterInputSource unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static TransmitterInputSource unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "TransmitterInputSource " + getValue() + " " + name(); 
    }
}
