package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 358 marshal size 8<br>
 * CapabilityReport
 */
public enum CapabilityReport 
{
    /** No Communications Capability (CA) */
    NO_COMMUNICATIONS_CAPABILITY_CA (0, "No Communications Capability (CA)"),
    /** Reserved */
    RESERVED (1, "Reserved"),
    /** Reserved */
    RESERVED_2 (2, "Reserved"),
    /** Reserved */
    RESERVED_3 (3, "Reserved"),
    /** Signifies at Least Comm-A and Comm-B Capability and Ability to Set CA Code 7 and on the Ground */
    SIGNIFIES_AT_LEAST_COMM_A_AND_COMM_B_CAPABILITY_AND_ABILITY_TO_SET_CA_CODE_7_AND_ON_THE_GROUND (4, "Signifies at Least Comm-A and Comm-B Capability and Ability to Set CA Code 7 and on the Ground"),
    /** Signifies at Least Comm-A and Comm-B capability and Ability to Set CA Code 7 and Airborne */
    SIGNIFIES_AT_LEAST_COMM_A_AND_COMM_B_CAPABILITY_AND_ABILITY_TO_SET_CA_CODE_7_AND_AIRBORNE (5, "Signifies at Least Comm-A and Comm-B capability and Ability to Set CA Code 7 and Airborne"),
    /** Signifies at Least Comm-A and Comm-B capability and Ability to Set CA Code 7 and Either Airborne or on the Ground */
    SIGNIFIES_AT_LEAST_COMM_A_AND_COMM_B_CAPABILITY_AND_ABILITY_TO_SET_CA_CODE_7_AND_EITHER_AIRBORNE_OR_ON_THE_GROUND (6, "Signifies at Least Comm-A and Comm-B capability and Ability to Set CA Code 7 and Either Airborne or on the Ground"),
    /** Signifies the Downlink Request (DR) Field Is Not Equal To 0 and The Flight Status (FS) Field Equals 2, 3, 4 or 5, and Either Airborne or on the Ground */
    SIGNIFIES_THE_DOWNLINK_REQUEST_DR_FIELD_IS_NOT_EQUAL_TO_0_AND_THE_FLIGHT_STATUS_FS_FIELD_EQUALS_2_3_4_OR_5_AND_EITHER_AIRBORNE_OR_ON_THE_GROUND (7, "Signifies the Downlink Request (DR) Field Is Not Equal To 0 and The Flight Status (FS) Field Equals 2, 3, 4 or 5, and Either Airborne or on the Ground"),
    /** No Statement */
    NO_STATEMENT (255, "No Statement");

    private int value;
    private final String description;

    /** Constructor */
    CapabilityReport(int value, String description)
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
    public static CapabilityReport getEnumForValue(int i)
    {
       for(CapabilityReport val: CapabilityReport.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration CapabilityReport");
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
    public static CapabilityReport unmarshalEnum (DataInputStream dis) throws Exception
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
    public static CapabilityReport unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
