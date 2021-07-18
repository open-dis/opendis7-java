package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 387 marshal size 3<br>
 * AppearanceCanopy
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

    /** Constructor */
    AppearanceCanopy(int value, String description)
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
      return 3;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static AppearanceCanopy getEnumForValue(int i)
    {
       for(AppearanceCanopy val: AppearanceCanopy.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration AppearanceCanopy");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static AppearanceCanopy unmarshalEnum (DataInputStream dis) throws Exception
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
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static AppearanceCanopy unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        return "AppearanceCanopy " + padding + getValue() + " " + name();
    }
}
