package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
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

    CapabilityReport(int value, String description)
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

    public static CapabilityReport getEnumForValue(int i)
    {
       for(CapabilityReport val: CapabilityReport.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration CapabilityReport");
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

    public static CapabilityReport unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "CapabilityReport: " + name() + ": " + getValue(); 
    }
}
