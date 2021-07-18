package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 82 marshal size 16<br>
 * IFFSystemType
 */
public enum IFFSystemType 
{
    /** Not Used (Invalid Value) */
    NOT_USED_INVALID_VALUE (0, "Not Used (Invalid Value)"),
    /** Mark X/XII/ATCRBS Transponder */
    MARK_X_XII_ATCRBS_TRANSPONDER (1, "Mark X/XII/ATCRBS Transponder"),
    /** Mark X/XII/ATCRBS Interrogator */
    MARK_X_XII_ATCRBS_INTERROGATOR (2, "Mark X/XII/ATCRBS Interrogator"),
    /** Soviet Transponder */
    SOVIET_TRANSPONDER (3, "Soviet Transponder"),
    /** Soviet Interrogator */
    SOVIET_INTERROGATOR (4, "Soviet Interrogator"),
    /** RRB Transponder */
    RRB_TRANSPONDER (5, "RRB Transponder"),
    /** Mark XIIA Interrogator */
    MARK_XIIA_INTERROGATOR (6, "Mark XIIA Interrogator"),
    /** Mode 5 Interrogator */
    MODE_5_INTERROGATOR (7, "Mode 5 Interrogator"),
    /** Mode S Interrogator */
    MODE_S_INTERROGATOR (8, "Mode S Interrogator"),
    /** Mark XIIA Transponder */
    MARK_XIIA_TRANSPONDER (9, "Mark XIIA Transponder"),
    /** Mode 5 Transponder */
    MODE_5_TRANSPONDER (10, "Mode 5 Transponder"),
    /** Mode S Transponder */
    MODE_S_TRANSPONDER (11, "Mode S Transponder"),
    /** Mark XIIA Combined Interrogator/Transponder (CIT) */
    MARK_XIIA_COMBINED_INTERROGATOR_TRANSPONDER_CIT (12, "Mark XIIA Combined Interrogator/Transponder (CIT)"),
    /** Mark XII Combined Interrogator/Transponder (CIT) */
    MARK_XII_COMBINED_INTERROGATOR_TRANSPONDER_CIT (13, "Mark XII Combined Interrogator/Transponder (CIT)"),
    /** TCAS/ACAS Transceiver */
    TCAS_ACAS_TRANSCEIVER (14, "TCAS/ACAS Transceiver");

    private int value;
    private final String description;

    /** Constructor */
    IFFSystemType(int value, String description)
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
      return 16;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static IFFSystemType getEnumForValue(int i)
    {
       for(IFFSystemType val: IFFSystemType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration IFFSystemType");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static IFFSystemType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static IFFSystemType unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        return "IFFSystemType " + getValue() + " " + name(); 
    }
}
