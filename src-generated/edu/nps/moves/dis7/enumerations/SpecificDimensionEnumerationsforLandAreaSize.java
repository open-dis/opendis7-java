package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 131 marshal size 8<br>
 * SpecificDimensionEnumerationsforLandAreaSize<br>
 * The gaps in enumeration values are intentional and are reserved for future additions.
 */
public enum SpecificDimensionEnumerationsforLandAreaSize 
{

    /** Small Area (2,000m2 - 4,000m2 / .5 to 1 sq. acre ) */
    SMALL_AREA_2_000M2_4_000M2_5_TO_1_SQ_ACRE_ (222, "Small Area (2,000m2 - 4,000m2 / .5 to 1 sq. acre )"),
    /** Small Area, Dense (2,000m2 - 4,000m2 / .5 to1 sq. acre) */
    SMALL_AREA_DENSE_2_000M2_4_000M2_5_TO1_SQ_ACRE (223, "Small Area, Dense (2,000m2 - 4,000m2 / .5 to1 sq. acre)"),
    /** Medium Area (20,000m2 - 41,000m2 / 10 to 20 sq. acres) */
    MEDIUM_AREA_20_000M2_41_000M2_10_TO_20_SQ_ACRES (224, "Medium Area (20,000m2 - 41,000m2 / 10 to 20 sq. acres)"),
    /** Medium Area, Dense (20,000m2 - 41,000m2 / 10 to 20 sq. acres) */
    MEDIUM_AREA_DENSE_20_000M2_41_000M2_10_TO_20_SQ_ACRES (225, "Medium Area, Dense (20,000m2 - 41,000m2 / 10 to 20 sq. acres)"),
    /** Large Area (40,000m2 - 81,000m2 / 20 to 40 sq. acres) */
    LARGE_AREA_40_000M2_81_000M2_20_TO_40_SQ_ACRES (226, "Large Area (40,000m2 - 81,000m2 / 20 to 40 sq. acres)"),
    /** Large Area, Dense (40,000m2 - 81,000m2 / 20 to 40 sq. acres) */
    LARGE_AREA_DENSE_40_000M2_81_000M2_20_TO_40_SQ_ACRES (227, "Large Area, Dense (40,000m2 - 81,000m2 / 20 to 40 sq. acres)");

    private int value;
    private final String description;

    /** Constructor */
    SpecificDimensionEnumerationsforLandAreaSize(int value, String description)
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
    public static SpecificDimensionEnumerationsforLandAreaSize getEnumForValue(int i)
    {
       for(SpecificDimensionEnumerationsforLandAreaSize val: SpecificDimensionEnumerationsforLandAreaSize.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration SpecificDimensionEnumerationsforLandAreaSize");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    private boolean TRACE = false;

    /** Set tracing on/off for this object 
     * @param value whether tracing is on or off */
    public void setTRACE (boolean value)
    {
        TRACE = value;
    }

    /** Whether tracing is on or off for this object
     * @return whether tracing is on or off */
    public boolean getTRACE ()
    {
        return TRACE;
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
    public static SpecificDimensionEnumerationsforLandAreaSize unmarshalEnum (DataInputStream dis) throws Exception
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
    public static SpecificDimensionEnumerationsforLandAreaSize unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        if (this.getClass().getName().endsWith("DisPduType") && (getValue() < 10))
            padding = "0"; // leading zero for column spacing
        String result = "DisPduType " + padding + getValue() + " " + name();
        if (getTRACE())
            System.out.println ("*** enum " + this.getClass().getName() + " name=" + name() + ", value=" + getValue() + "; " +
               result); // debug diagnostic
        return result;
    }
}
