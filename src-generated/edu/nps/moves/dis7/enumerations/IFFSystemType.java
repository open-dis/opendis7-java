package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 82 marshal size 16<br>
 * IFF-System Type
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

    IFFSystemType(int value, String description)
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

    public static IFFSystemType getEnumForValue(int i)
    {
       for(IFFSystemType val: IFFSystemType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IFFSystemType");
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

    public static IFFSystemType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static IFFSystemType unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "IFFSystemType: " + name() + ": " + getValue(); 
    }
}
