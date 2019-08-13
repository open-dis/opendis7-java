package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 23 marshal size 16<br>
 * Radio Subcategory<br>
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
    JETDS_FRC_SET_2 (28, "JETDS FRC Set 2"),
    /** JETDS FRC Set 3 */
    JETDS_FRC_SET_3 (29, "JETDS FRC Set 3"),
    /** JETDS FRC Set 4 */
    JETDS_FRC_SET_4 (30, "JETDS FRC Set 4"),
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
    JETDS_PRC_SET_4 (46, "JETDS PRC Set 4"),
    /** JETDS SRC Set 1 */
    JETDS_SRC_SET_1 (47, "JETDS SRC Set 1"),
    /** JETDS SRC Set 2 */
    JETDS_SRC_SET_2 (48, "JETDS SRC Set 2"),
    /** JETDS SRC Set 3 */
    JETDS_SRC_SET_3 (49, "JETDS SRC Set 3"),
    /** JETDS SRC Set 4 */
    JETDS_SRC_SET_4 (50, "JETDS SRC Set 4"),
    /** JETDS TRC Set 1 */
    JETDS_TRC_SET_1 (51, "JETDS TRC Set 1"),
    /** JETDS TRC Set 2 */
    JETDS_TRC_SET_2 (52, "JETDS TRC Set 2"),
    /** JETDS TRC Set 3 */
    JETDS_TRC_SET_3 (53, "JETDS TRC Set 3"),
    /** JETDS TRC Set 4 */
    JETDS_TRC_SET_4 (54, "JETDS TRC Set 4"),
    /** JETDS VRC Set 1 */
    JETDS_VRC_SET_1 (55, "JETDS VRC Set 1"),
    /** JETDS VRC Set 2 */
    JETDS_VRC_SET_2 (56, "JETDS VRC Set 2"),
    /** JETDS VRC Set 3 */
    JETDS_VRC_SET_3 (57, "JETDS VRC Set 3"),
    /** JETDS VRC Set 4 */
    JETDS_VRC_SET_4 (58, "JETDS VRC Set 4"),
    /** JETDS WRC Set 1 */
    JETDS_WRC_SET_1 (59, "JETDS WRC Set 1"),
    /** JETDS WRC Set 2 */
    JETDS_WRC_SET_2 (60, "JETDS WRC Set 2"),
    /** JETDS WRC Set 3 */
    JETDS_WRC_SET_3 (61, "JETDS WRC Set 3"),
    /** JETDS WRC Set 4 */
    JETDS_WRC_SET_4 (62, "JETDS WRC Set 4"),
    /** JETDS ZRC Set 1 */
    JETDS_ZRC_SET_1 (63, "JETDS ZRC Set 1"),
    /** JETDS ZRC Set 2 */
    JETDS_ZRC_SET_2 (64, "JETDS ZRC Set 2"),
    /** JETDS ZRC Set 3 */
    JETDS_ZRC_SET_3 (65, "JETDS ZRC Set 3"),
    /** JETDS ZRC Set 4 */
    JETDS_ZRC_SET_4 (66, "JETDS ZRC Set 4");

    private int value;
    private final String description;

    RadioSubcategory(int value, String description)
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
      return 16;
    }

    public static RadioSubcategory getEnumForValue(int i)
    {
       for(RadioSubcategory val: RadioSubcategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration RadioSubcategory");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static RadioSubcategory unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static RadioSubcategory unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
