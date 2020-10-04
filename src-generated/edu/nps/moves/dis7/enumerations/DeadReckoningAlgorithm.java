package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 44 marshal size 8<br>
 * DeadReckoningAlgorithm
 */
public enum DeadReckoningAlgorithm 
{
    /** Other */
    OTHER (0, "Other"),
    /** Static - Non-moving Entity */
    STATIC_NON_MOVING_ENTITY (1, "Static - Non-moving Entity"),
    /** DRM (FPW) - Constant Velocity / Low Acceleration Linear Motion Entity */
    DRM_FPW_CONSTANT_VELOCITY_LOW_ACCELERATION_LINEAR_MOTION_ENTITY (2, "DRM (FPW) - Constant Velocity / Low Acceleration Linear Motion Entity"),
    /** DRM (RPW) - Constant Velocity / Low Acceleration Linear Motion Entity with Extrapolation of Orientation */
    DRM_RPW_CONSTANT_VELOCITY_LOW_ACCELERATION_LINEAR_MOTION_ENTITY_WITH_EXTRAPOLATION_OF_ORIENTATION (3, "DRM (RPW) - Constant Velocity / Low Acceleration Linear Motion Entity with Extrapolation of Orientation"),
    /** DRM (RVW) - High Speed or Maneuvering Entity with Extrapolation of Orientation */
    DRM_RVW_HIGH_SPEED_OR_MANEUVERING_ENTITY_WITH_EXTRAPOLATION_OF_ORIENTATION (4, "DRM (RVW) - High Speed or Maneuvering Entity with Extrapolation of Orientation"),
    /** DRM (FVW) - High Speed or Maneuvering Entity */
    DRM_FVW_HIGH_SPEED_OR_MANEUVERING_ENTITY (5, "DRM (FVW) - High Speed or Maneuvering Entity"),
    /** DRM (FPB) - Similar to FPW except in Body Coordinates */
    DRM_FPB_SIMILAR_TO_FPW_EXCEPT_IN_BODY_COORDINATES (6, "DRM (FPB) - Similar to FPW except in Body Coordinates"),
    /** DRM (RPB) - Similar to RPW except in Body Coordinates */
    DRM_RPB_SIMILAR_TO_RPW_EXCEPT_IN_BODY_COORDINATES (7, "DRM (RPB) - Similar to RPW except in Body Coordinates"),
    /** DRM (RVB) - Similar to RVW except in Body Coordinates */
    DRM_RVB_SIMILAR_TO_RVW_EXCEPT_IN_BODY_COORDINATES (8, "DRM (RVB) - Similar to RVW except in Body Coordinates"),
    /** DRM (FVB) - Similar to FVW except in Body Coordinates */
    DRM_FVB_SIMILAR_TO_FVW_EXCEPT_IN_BODY_COORDINATES (9, "DRM (FVB) - Similar to FVW except in Body Coordinates");

    private int value;
    private final String description;

    DeadReckoningAlgorithm(int value, String description)
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

    public static DeadReckoningAlgorithm getEnumForValue(int i)
    {
       for(DeadReckoningAlgorithm val: DeadReckoningAlgorithm.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DeadReckoningAlgorithm");
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

    public static DeadReckoningAlgorithm unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static DeadReckoningAlgorithm unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "DeadReckoningAlgorithm " + getValue() + " " + name(); 
    }
}
