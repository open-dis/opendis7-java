package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 392 marshal size 4<br>
 * Appearance-Life Form Posture
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
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
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

    public static AppearanceLifeFormPosture unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AppearanceLifeFormPosture: " + name() + ": " + getValue(); 
    }
}
