package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 392 marshal size 4<br>
 * AppearanceLifeFormPosture
 */
public enum AppearanceLifeFormPosture 
{
    /** Not Specified */
    NOT_SPECIFIED (0, "Not Specified"),
    /** Upright, Standing Still */
    UPRIGHT_STANDING_STILL (1, "Upright, Standing Still"),
    /** Upright, Walking */
    UPRIGHT_WALKING (2, "Upright, Walking"),
    /** Upright, Running */
    UPRIGHT_RUNNING (3, "Upright, Running"),
    /** Kneeling */
    KNEELING (4, "Kneeling"),
    /** Prone */
    PRONE (5, "Prone"),
    /** Crawling */
    CRAWLING (6, "Crawling"),
    /** Swimming */
    SWIMMING (7, "Swimming"),
    /** Parachuting */
    PARACHUTING (8, "Parachuting"),
    /** Jumping */
    JUMPING (9, "Jumping"),
    /** Sitting */
    SITTING (10, "Sitting"),
    /** Squatting */
    SQUATTING (11, "Squatting"),
    /** Crouching */
    CROUCHING (12, "Crouching"),
    /** Wading */
    WADING (13, "Wading"),
    /** Surrender */
    SURRENDER (14, "Surrender"),
    /** Detained */
    DETAINED (15, "Detained");

    private int value;
    private final String description;

    AppearanceLifeFormPosture(int value, String description)
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

    public static AppearanceLifeFormPosture getEnumForValue(int i)
    {
       for(AppearanceLifeFormPosture val: AppearanceLifeFormPosture.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AppearanceLifeFormPosture");
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

    public static AppearanceLifeFormPosture unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static AppearanceLifeFormPosture unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "AppearanceLifeFormPosture " + getValue() + " " + name(); 
    }
}
