package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
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

    /** Constructor */
    DISProtocolVersion(int value, String description)
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
    public static DISProtocolVersion getEnumForValue(int i)
    {
       for(DISProtocolVersion val: DISProtocolVersion.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DISProtocolVersion");
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

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static DISProtocolVersion unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "DISProtocolVersion " + padding + getValue() + " " + name();
    }
}
