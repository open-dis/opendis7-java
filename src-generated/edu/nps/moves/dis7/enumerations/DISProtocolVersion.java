package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 3 marshal size 8<br>
 * DISProtocolVersion
 */
public enum DISProtocolVersion 
{
    /** Other */
    OTHER (0, "Other"),
    /** DIS PDU version 1.0 (May 92) */
    DIS_PDU_VERSION_10_MAY_92 (1, "DIS PDU version 1.0 (May 92)"),
    /** IEEE 1278-1993 */
    IEEE_1278_1993 (2, "IEEE 1278-1993"),
    /** DIS Applications Version 2.0 - Third Draft (28 May 1993), IST-CR-93-15 */
    DIS_APPLICATIONS_VERSION_20_THIRD_DRAFT_28_MAY_1993 (3, "DIS Applications Version 2.0 - Third Draft (28 May 1993)"),
    /** DIS Application Protocols Version 2.0 - Fourth Draft (Revised) (16 March 1994), IST-CR-94-50 */
    DIS_APPLICATION_PROTOCOLS_VERSION_20_FOURTH_DRAFT_REVISED_16_MARCH_1994 (4, "DIS Application Protocols Version 2.0 - Fourth Draft (Revised) (16 March 1994)"),
    /** IEEE 1278.1-1995 */
    IEEE_12781_1995 (5, "IEEE 1278.1-1995"),
    /** IEEE 1278.1A-1998 */
    IEEE_12781A_1998 (6, "IEEE 1278.1A-1998"),
    /** IEEE 1278.1-2012 */
    IEEE_12781_2012 (7, "IEEE 1278.1-2012");

    private int value;
    private final String description;

    DISProtocolVersion(int value, String description)
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
      return 8;
    }

    public static DISProtocolVersion getEnumForValue(int i)
    {
       for(DISProtocolVersion val: DISProtocolVersion.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DISProtocolVersion");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
    }

    public static DISProtocolVersion unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static DISProtocolVersion unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "DISProtocolVersion: " + name() + ": " + getValue(); 
    }
}
