package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 370 marshal size 16<br>
 * T/I Link Type
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

    TILinkType(int value, String description)
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

    public static TILinkType getEnumForValue(int i)
    {
       for(TILinkType val: TILinkType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TILinkType");
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

    public static TILinkType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static TILinkType unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "TILinkType: " + name() + ": " + getValue(); 
    }
}
