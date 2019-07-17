package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 387 marshal size 3<br>
 * Appearance-Canopy
 */
public enum AppearanceCanopy 
{
    /** Not Applicable */
    NOT_APPLICABLE (0, "Not Applicable"),
    /** Single Canopy/Single Troop Door Closed */
    SINGLE_CANOPY_SINGLE_TROOP_DOOR_CLOSED (1, "Single Canopy/Single Troop Door Closed"),
    /** Front and Rear Canopy/Left and Right Troop Door Closed */
    FRONT_AND_REAR_CANOPY_LEFT_AND_RIGHT_TROOP_DOOR_CLOSED (2, "Front and Rear Canopy/Left and Right Troop Door Closed"),
    /** Front Canopy/Left Troop Door Open */
    FRONT_CANOPY_LEFT_TROOP_DOOR_OPEN (3, "Front Canopy/Left Troop Door Open"),
    /** Single Canopy/Single Troop Door Open */
    SINGLE_CANOPY_SINGLE_TROOP_DOOR_OPEN (4, "Single Canopy/Single Troop Door Open"),
    /** Rear Canopy/Right Troop Door Open */
    REAR_CANOPY_RIGHT_TROOP_DOOR_OPEN (5, "Rear Canopy/Right Troop Door Open"),
    /** Front and Rear Canopy/Left and Right Troop Door Open */
    FRONT_AND_REAR_CANOPY_LEFT_AND_RIGHT_TROOP_DOOR_OPEN (6, "Front and Rear Canopy/Left and Right Troop Door Open");

    private int value;
    private final String description;

    AppearanceCanopy(int value, String description)
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
      return 3;
    }

    public static AppearanceCanopy getEnumForValue(int i)
    {
       for(AppearanceCanopy val: AppearanceCanopy.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AppearanceCanopy");
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

    public static AppearanceCanopy unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static AppearanceCanopy unmarshalEnum(ByteBuffer buff) throws Exception
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
