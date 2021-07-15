package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 195 marshal size 12<br>
 * MinefieldSensorTypesFLIR
 */
public enum MinefieldSensorTypesFLIR 
{
    /** Generic 3-5 */
    GENERIC_3_5 (0, "Generic 3-5"),
    /** Generic 8-12 */
    GENERIC_8_12 (1, "Generic 8-12"),
    /** ASTAMIDS I */
    ASTAMIDS_I (2, "ASTAMIDS I"),
    /** ASTAMIDS II */
    ASTAMIDS_II (3, "ASTAMIDS II"),
    /** GSTAMIDS 3-5 */
    GSTAMIDS_3_5 (4, "GSTAMIDS 3-5"),
    /** GSTAMIDS 8-12 */
    GSTAMIDS_8_12 (5, "GSTAMIDS 8-12"),
    /** HSTAMIDS 3-5 */
    HSTAMIDS_3_5 (6, "HSTAMIDS 3-5"),
    /** HSTAMIDS 8-12 */
    HSTAMIDS_8_12 (7, "HSTAMIDS 8-12"),
    /** COBRA 3-5 */
    COBRA_3_5 (8, "COBRA 3-5"),
    /** COBRA 8-12 */
    COBRA_8_12 (9, "COBRA 8-12");

    private int value;
    private final String description;

    /** Constructor */
    MinefieldSensorTypesFLIR(int value, String description)
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
      return 12;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static MinefieldSensorTypesFLIR getEnumForValue(int i)
    {
       for(MinefieldSensorTypesFLIR val: MinefieldSensorTypesFLIR.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MinefieldSensorTypesFLIR");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static MinefieldSensorTypesFLIR unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static MinefieldSensorTypesFLIR unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "MinefieldSensorTypesFLIR " + getValue() + " " + name(); 
    }
}
