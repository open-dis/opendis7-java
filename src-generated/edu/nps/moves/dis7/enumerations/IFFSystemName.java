package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 83 marshal size 16<br>
 * IFF-System Name
 */
public enum IFFSystemName 
{
    /** Not Used (Invalid Value) */
    NOT_USED_INVALID_VALUE (0, "Not Used (Invalid Value)"),
    /** Generic Mark X */
    GENERIC_MARK_X (1, "Generic Mark X"),
    /** Generic Mark XII */
    GENERIC_MARK_XII (2, "Generic Mark XII"),
    /** Generic ATCRBS */
    GENERIC_ATCRBS (3, "Generic ATCRBS"),
    /** Generic Soviet */
    GENERIC_SOVIET (4, "Generic Soviet"),
    /** Generic Mode S */
    GENERIC_MODE_S (5, "Generic Mode S"),
    /** Generic Mark X/XII/ATCRBS */
    GENERIC_MARK_X_XII_ATCRBS (6, "Generic Mark X/XII/ATCRBS"),
    /** Generic Mark X/XII/ATCRBS/Mode S */
    GENERIC_MARK_X_XII_ATCRBS_MODE_S (7, "Generic Mark X/XII/ATCRBS/Mode S"),
    /** ARI 5954 (RRB) */
    ARI_5954_RRB (8, "ARI 5954 (RRB)"),
    /** ARI 5983 (RRB) */
    ARI_5983_RRB (9, "ARI 5983 (RRB)"),
    /** Generic RRB */
    GENERIC_RRB (10, "Generic RRB"),
    /** Generic Mark XIIA */
    GENERIC_MARK_XIIA (11, "Generic Mark XIIA"),
    /** Generic Mode 5 */
    GENERIC_MODE_5 (12, "Generic Mode 5"),
    /** Generic Mark XIIA Combined Interrogator/Transponder (CIT) */
    GENERIC_MARK_XIIA_COMBINED_INTERROGATOR_TRANSPONDER_CIT (13, "Generic Mark XIIA Combined Interrogator/Transponder (CIT)"),
    /** Generic Mark XII Combined Interrogator/Transponder (CIT) */
    GENERIC_MARK_XII_COMBINED_INTERROGATOR_TRANSPONDER_CIT (14, "Generic Mark XII Combined Interrogator/Transponder (CIT)"),
    /** Generic TCAS I/ACAS I Transceiver */
    GENERIC_TCAS_I_ACAS_I_TRANSCEIVER (15, "Generic TCAS I/ACAS I Transceiver"),
    /** Generic TCAS II/ACAS II Transceiver */
    GENERIC_TCAS_II_ACAS_II_TRANSCEIVER (16, "Generic TCAS II/ACAS II Transceiver"),
    /** Generic Mark X (A) */
    GENERIC_MARK_X_A (17, "Generic Mark X (A)"),
    /** Generic Mark X (SIF) */
    GENERIC_MARK_X_SIF (18, "Generic Mark X (SIF)");

    private int value;
    private final String description;

    IFFSystemName(int value, String description)
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

    public static IFFSystemName getEnumForValue(int i)
    {
       for(IFFSystemName val: IFFSystemName.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IFFSystemName");
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

    public static IFFSystemName unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static IFFSystemName unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "IFFSystemName: " + name() + ": " + getValue(); 
    }
}
