package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 23 marshal size 16<br>
 * RadioSubcategory<br>
 * JETDS Specific Series are reserved in the range 11-100. Each set allows for 255 radios.
 */
public enum RadioSubcategory implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Joint Electronics Type Designation System (JETDS) Non-specific Series */
    JOINT_ELECTRONICS_TYPE_DESIGNATION_SYSTEM_JETDS_NON_SPECIFIC_SERIES (1, "Joint Electronics Type Designation System (JETDS) Non-specific Series"),
    /** Manufacturer Designation */
    MANUFACTURER_DESIGNATION (2, "Manufacturer Designation"),
    /** National Designation */
    NATIONAL_DESIGNATION (3, "National Designation"),
    /** JETDS ARC Set 1 */
    JETDS_ARC_SET_1 (11, "JETDS ARC Set 1"),
    /** JETDS ARC Set 2 */
    JETDS_ARC_SET_2 (12, "JETDS ARC Set 2"),
    /** JETDS ARC Set 3 */
    JETDS_ARC_SET_3 (13, "JETDS ARC Set 3"),
    /** JETDS ARC Set 4 */
    JETDS_ARC_SET_4 (14, "JETDS ARC Set 4"),
    /** JETDS BRC Set 1 */
    JETDS_BRC_SET_1 (15, "JETDS BRC Set 1"),
    /** JETDS BRC Set 2 */
    JETDS_BRC_SET_2 (16, "JETDS BRC Set 2"),
    /** JETDS BRC Set 3 */
    JETDS_BRC_SET_3 (17, "JETDS BRC Set 3"),
    /** JETDS BRC Set 4 */
    JETDS_BRC_SET_4 (18, "JETDS BRC Set 4"),
    /** JETDS CRC Set 1 */
    JETDS_CRC_SET_1 (19, "JETDS CRC Set 1"),
    /** JETDS CRC Set 2 */
    JETDS_CRC_SET_2 (20, "JETDS CRC Set 2"),
    /** JETDS CRC Set 3 */
    JETDS_CRC_SET_3 (21, "JETDS CRC Set 3"),
    /** JETDS CRC Set 4 */
    JETDS_CRC_SET_4 (22, "JETDS CRC Set 4"),
    /** JETDS DRC Set 1 */
    JETDS_DRC_SET_1 (23, "JETDS DRC Set 1"),
    /** JETDS DRC Set 2 */
    JETDS_DRC_SET_2 (24, "JETDS DRC Set 2"),
    /** JETDS DRC Set 3 */
    JETDS_DRC_SET_3 (25, "JETDS DRC Set 3"),
    /** JETDS DRC Set 4 */
    JETDS_DRC_SET_4 (26, "JETDS DRC Set 4"),
    /** JETDS FRC Set 1 */
    JETDS_FRC_SET_1 (27, "JETDS FRC Set 1"),
    /** JETDS FRC Set 2 */
    IDENTIFICATION_FRIEND_OR_FOE (28, "JETDS FRC Set 2"),
    /** JETDS FRC Set 3 */
    JETDS_FRC_SET_3 (29, "JETDS FRC Set 3"),
    /** JETDS FRC Set 4 */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "JETDS FRC Set 4"),
    /** JETDS GRC Set 1 */
    JETDS_GRC_SET_1 (31, "JETDS GRC Set 1"),
    /** JETDS GRC Set 2 */
    JETDS_GRC_SET_2 (32, "JETDS GRC Set 2"),
    /** JETDS GRC Set 3 */
    JETDS_GRC_SET_3 (33, "JETDS GRC Set 3"),
    /** JETDS GRC Set 4 */
    JETDS_GRC_SET_4 (34, "JETDS GRC Set 4"),
    /** JETDS KRC Set 1 */
    JETDS_KRC_SET_1 (35, "JETDS KRC Set 1"),
    /** JETDS KRC Set 2 */
    JETDS_KRC_SET_2 (36, "JETDS KRC Set 2"),
    /** JETDS KRC Set 3 */
    JETDS_KRC_SET_3 (37, "JETDS KRC Set 3"),
    /** JETDS KRC Set 4 */
    JETDS_KRC_SET_4 (38, "JETDS KRC Set 4"),
    /** JETDS MRC Set 1 */
    JETDS_MRC_SET_1 (39, "JETDS MRC Set 1"),
    /** JETDS MRC Set 2 */
    JETDS_MRC_SET_2 (40, "JETDS MRC Set 2"),
    /** JETDS MRC Set 3 */
    JETDS_MRC_SET_3 (41, "JETDS MRC Set 3"),
    /** JETDS MRC Set 4 */
    JETDS_MRC_SET_4 (42, "JETDS MRC Set 4"),
    /** JETDS PRC Set 1 */
    JETDS_PRC_SET_1 (43, "JETDS PRC Set 1"),
    /** JETDS PRC Set 2 */
    JETDS_PRC_SET_2 (44, "JETDS PRC Set 2"),
    /** JETDS PRC Set 3 */
    JETDS_PRC_SET_3 (45, "JETDS PRC Set 3"),
    /** JETDS PRC Set 4 */
    TIME_SPACE_POSITION_INFORMATION (46, "JETDS PRC Set 4"),
    /** JETDS SRC Set 1 */
    JETDS_SRC_SET_1 (47, "JETDS SRC Set 1"),
    /** JETDS SRC Set 2 */
    JETDS_SRC_SET_2 (48, "JETDS SRC Set 2"),
    /** JETDS SRC Set 3 */
    LIVE_ENTITY_FIRE (49, "JETDS SRC Set 3"),
    /** JETDS SRC Set 4 */
    LIVE_ENTITY_DETONATION (50, "JETDS SRC Set 4"),
    /** JETDS TRC Set 1 */
    CREATE_ENTITY_RELIABLE (51, "JETDS TRC Set 1"),
    /** JETDS TRC Set 2 */
    REMOVE_ENTITY_RELIABLE (52, "JETDS TRC Set 2"),
    /** JETDS TRC Set 3 */
    START_RESUME_RELIABLE (53, "JETDS TRC Set 3"),
    /** JETDS TRC Set 4 */
    STOP_FREEZE_RELIABLE (54, "JETDS TRC Set 4"),
    /** JETDS VRC Set 1 */
    ACKNOWLEDGE_RELIABLE (55, "JETDS VRC Set 1"),
    /** JETDS VRC Set 2 */
    ACTION_REQUEST_RELIABLE (56, "JETDS VRC Set 2"),
    /** JETDS VRC Set 3 */
    ACTION_RESPONSE_RELIABLE (57, "JETDS VRC Set 3"),
    /** JETDS VRC Set 4 */
    DATA_QUERY_RELIABLE (58, "JETDS VRC Set 4"),
    /** JETDS WRC Set 1 */
    SET_DATA_RELIABLE (59, "JETDS WRC Set 1"),
    /** JETDS WRC Set 2 */
    DATA_RELIABLE (60, "JETDS WRC Set 2"),
    /** JETDS WRC Set 3 */
    EVENT_REPORT_RELIABLE (61, "JETDS WRC Set 3"),
    /** JETDS WRC Set 4 */
    COMMENT_RELIABLE (62, "JETDS WRC Set 4"),
    /** JETDS ZRC Set 1 */
    RECORD_RELIABLE (63, "JETDS ZRC Set 1"),
    /** JETDS ZRC Set 2 */
    SET_RECORD_RELIABLE	 (64, "JETDS ZRC Set 2"),
    /** JETDS ZRC Set 3 */
    RECORD_QUERY_RELIABLE (65, "JETDS ZRC Set 3"),
    /** JETDS ZRC Set 4 */
    JETDS_ZRC_SET_4 (66, "JETDS ZRC Set 4");

    private int value;
    private final String description;

    /** Constructor */
    RadioSubcategory(int value, String description)
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
    public static RadioSubcategory getEnumForValue(int i)
    {
       for(RadioSubcategory val: RadioSubcategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration RadioSubcategory");
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
    public static RadioSubcategory unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static RadioSubcategory unmarshalEnum (ByteBuffer byteBuffer) throws Exception
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
        return "RadioSubcategory " + getValue() + " " + name(); 
    }
}
