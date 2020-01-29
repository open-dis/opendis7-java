package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 195 marshal size 12<br>
 * Minefield-Sensor Types-FLIR
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

    MinefieldSensorTypesFLIR(int value, String description)
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
      return 12;
    }

    public static MinefieldSensorTypesFLIR getEnumForValue(int i)
    {
       for(MinefieldSensorTypesFLIR val: MinefieldSensorTypesFLIR.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MinefieldSensorTypesFLIR");
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

    public static MinefieldSensorTypesFLIR unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static MinefieldSensorTypesFLIR unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "MinefieldSensorTypesFLIR: " + name() + ": " + getValue(); 
    }
}
