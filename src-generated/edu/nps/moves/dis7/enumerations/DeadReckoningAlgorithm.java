package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
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

    /** Constructor */
    DeadReckoningAlgorithm(int value, String description)
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
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static DeadReckoningAlgorithm getEnumForValue(int i)
    {
       for(DeadReckoningAlgorithm val: DeadReckoningAlgorithm.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DeadReckoningAlgorithm");
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

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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
        String padding = new String();
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "DeadReckoningAlgorithm " + padding + getValue() + " " + name();
    }
}
