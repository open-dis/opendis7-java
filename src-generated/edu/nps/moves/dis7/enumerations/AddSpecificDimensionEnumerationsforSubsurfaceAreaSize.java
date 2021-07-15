package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 133 marshal size 8<br>
 * AddSpecificDimensionEnumerationsforSubsurfaceAreaSize<br>
 * The gaps in enumeration values are intentional and are reserved for future additions.
 */
public enum AddSpecificDimensionEnumerationsforSubsurfaceAreaSize 
{

    /** Small School (.5km long x 250m wide x 83m deep - 1km x .5km x 166m) */
    SMALL_SCHOOL_5KM_LONG_X_250M_WIDE_X_83M_DEEP_1KM_X_5KM_X_166M (222, "Small School (.5km long x 250m wide x 83m deep - 1km x .5km x 166m)"),
    /** Small School, Dense (.5km long x 250m wide x 83m deep - 1km x .5km x 166m) */
    SMALL_SCHOOL_DENSE_5KM_LONG_X_250M_WIDE_X_83M_DEEP_1KM_X_5KM_X_166M (223, "Small School, Dense (.5km long x 250m wide x 83m deep - 1km x .5km x 166m)"),
    /** Medium School (.5km x 1km x 125m - 1km x 2km x 500m) */
    MEDIUM_SCHOOL_5KM_X_1KM_X_125M_1KM_X_2KM_X_500M (224, "Medium School (.5km x 1km x 125m - 1km x 2km x 500m)"),
    /** Medium School, Dense (.5km x 1km x 125m - 1km x 2km x 500m) */
    MEDIUM_SCHOOL_DENSE_5KM_X_1KM_X_125M_1KM_X_2KM_X_500M (225, "Medium School, Dense (.5km x 1km x 125m - 1km x 2km x 500m)"),
    /** Large School (5km x 2km x 500m - 10km x 4km x 1km) */
    LARGE_SCHOOL_5KM_X_2KM_X_500M_10KM_X_4KM_X_1KM (226, "Large School (5km x 2km x 500m - 10km x 4km x 1km)"),
    /** Large School, Dense (5km x 2km x 500m - 10km x 4km x 1km) */
    LARGE_SCHOOL_DENSE_5KM_X_2KM_X_500M_10KM_X_4KM_X_1KM (227, "Large School, Dense (5km x 2km x 500m - 10km x 4km x 1km)");

    private int value;
    private final String description;

    /** Constructor */
    AddSpecificDimensionEnumerationsforSubsurfaceAreaSize(int value, String description)
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
    public static AddSpecificDimensionEnumerationsforSubsurfaceAreaSize getEnumForValue(int i)
    {
       for(AddSpecificDimensionEnumerationsforSubsurfaceAreaSize val: AddSpecificDimensionEnumerationsforSubsurfaceAreaSize.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AddSpecificDimensionEnumerationsforSubsurfaceAreaSize");
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
    public static AddSpecificDimensionEnumerationsforSubsurfaceAreaSize unmarshalEnum (DataInputStream dis) throws Exception
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
    public static AddSpecificDimensionEnumerationsforSubsurfaceAreaSize unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "AddSpecificDimensionEnumerationsforSubsurfaceAreaSize " + padding + getValue() + " " + name();
    }
}
