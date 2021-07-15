package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 370 marshal size 16<br>
 * TILinkType
 */
public enum TILinkType 
{
    /** Not Used */
    NOT_USED (0, "Not Used"),
    /** Ground Initiated Communications B (GICB) */
    GROUND_INITIATED_COMMUNICATIONS_B_GICB (1, "Ground Initiated Communications B (GICB)"),
    /** Automatic Dependent Surveillance (ADS) */
    AUTOMATIC_DEPENDENT_SURVEILLANCE_ADS (2, "Automatic Dependent Surveillance (ADS)"),
    /** Global Navigation Satellite System (GNSS) */
    GLOBAL_NAVIGATION_SATELLITE_SYSTEM_GNSS (3, "Global Navigation Satellite System (GNSS)"),
    /** Data Link Initiation Capability (DLIC) */
    DATA_LINK_INITIATION_CAPABILITY_DLIC (4, "Data Link Initiation Capability (DLIC)"),
    /** Aircraft Communications Addressing and Reporting System (ACARS) */
    AIRCRAFT_COMMUNICATIONS_ADDRESSING_AND_REPORTING_SYSTEM_ACARS (5, "Aircraft Communications Addressing and Reporting System (ACARS)"),
    /** ATC Communications Management (ACM) */
    ATC_COMMUNICATIONS_MANAGEMENT_ACM (6, "ATC Communications Management (ACM)"),
    /** VHF Digital Link (VDL) */
    VHF_DIGITAL_LINK_VDL (7, "VHF Digital Link (VDL)"),
    /** Aeronautical Telecommunication Network (ATN) */
    AERONAUTICAL_TELECOMMUNICATION_NETWORK_ATN (8, "Aeronautical Telecommunication Network (ATN)"),
    /** Mode Select (S) */
    MODE_SELECT_S (9, "Mode Select (S)"),
    /** Airborne Collision Avoidance Systems (ACAS) */
    AIRBORNE_COLLISION_AVOIDANCE_SYSTEMS_ACAS (10, "Airborne Collision Avoidance Systems (ACAS)"),
    /** Traffic Collision Avoidance Systems (TCAS) */
    TRAFFIC_COLLISION_AVOIDANCE_SYSTEMS_TCAS (11, "Traffic Collision Avoidance Systems (TCAS)"),
    /** Automatic Dependent Surveillance-B (ADS-B) */
    AUTOMATIC_DEPENDENT_SURVEILLANCE_B_ADS_B (12, "Automatic Dependent Surveillance-B (ADS-B)");

    private int value;
    private final String description;

    /** Constructor */
    TILinkType(int value, String description)
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
    public static TILinkType getEnumForValue(int i)
    {
       for(TILinkType val: TILinkType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TILinkType");
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
    public static TILinkType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static TILinkType unmarshalEnum (ByteBuffer byteBuffer) throws Exception
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
        return "TILinkType " + getValue() + " " + name(); 
    }
}
