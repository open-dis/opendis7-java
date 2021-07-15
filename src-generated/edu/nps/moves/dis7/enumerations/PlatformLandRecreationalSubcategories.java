package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 437 marshal size 8<br>
 * PlatformLandRecreationalSubcategories<br>
 * Subcategories for Land Platform Category 90
 */
public enum PlatformLandRecreationalSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** ATV, 2X4 */
    ATV_2X4 (1, "ATV, 2X4"),
    /** ATV, 4X4 */
    ATV_4X4 (2, "ATV, 4X4"),
    /** ATV, 6X6 */
    ATV_6X6 (3, "ATV, 6X6"),
    /** ATV, 3-wheeled */
    ATV_3_WHEELED (4, "ATV, 3-wheeled"),
    /** Toy, Other */
    TOY_OTHER (5, "Toy, Other"),
    /** Toy, Car */
    TOY_CAR (6, "Toy, Car"),
    /** Toy, ATV */
    TOY_ATV (7, "Toy, ATV"),
    /** Golf Cart */
    GOLF_CART (8, "Golf Cart"),
    /** Snowmobile */
    SNOWMOBILE (9, "Snowmobile"),
    /** Recreational Vehicle */
    RECREATIONAL_VEHICLE (10, "Recreational Vehicle"),
    /** Recreational Vehicle, Type A Motorhome */
    RECREATIONAL_VEHICLE_TYPE_A_MOTORHOME (11, "Recreational Vehicle, Type A Motorhome"),
    /** Recreational Vehicle, Type B Motorhome */
    RECREATIONAL_VEHICLE_TYPE_B_MOTORHOME (12, "Recreational Vehicle, Type B Motorhome"),
    /** Recreational Vehicle, Type C Motorhome */
    RECREATIONAL_VEHICLE_TYPE_C_MOTORHOME (13, "Recreational Vehicle, Type C Motorhome"),
    /** Conversion Van */
    CONVERSION_VAN (14, "Conversion Van");

    private int value;
    private final String description;

    /** Constructor */
    PlatformLandRecreationalSubcategories(int value, String description)
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
    public static PlatformLandRecreationalSubcategories getEnumForValue(int i)
    {
       for(PlatformLandRecreationalSubcategories val: PlatformLandRecreationalSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandRecreationalSubcategories");
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
    public static PlatformLandRecreationalSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformLandRecreationalSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "PlatformLandRecreationalSubcategories " + padding + getValue() + " " + name();
    }
}
