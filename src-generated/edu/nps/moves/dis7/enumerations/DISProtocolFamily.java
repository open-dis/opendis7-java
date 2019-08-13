package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 5 marshal size 8<br>
 * DIS-Protocol Family
 */
public enum DISProtocolFamily 
{
    /** Other */
    OTHER (0, "Other"),
    /** Entity Information/Interaction */
    ENTITY_INFORMATION_INTERACTION (1, "Entity Information/Interaction"),
    /** Warfare */
    WARFARE (2, "Warfare"),
    /** Logistics */
    LOGISTICS (3, "Logistics"),
    /** Radio Communications */
    RADIO_COMMUNICATIONS (4, "Radio Communications"),
    /** Simulation Management */
    SIMULATION_MANAGEMENT (5, "Simulation Management"),
    /** Distributed Emission Regeneration */
    DISTRIBUTED_EMISSION_REGENERATION (6, "Distributed Emission Regeneration"),
    /** Entity Management */
    ENTITY_MANAGEMENT (7, "Entity Management"),
    /** Minefield */
    MINEFIELD (8, "Minefield"),
    /** Synthetic Environment */
    SYNTHETIC_ENVIRONMENT (9, "Synthetic Environment"),
    /** Simulation Management with Reliability */
    SIMULATION_MANAGEMENT_WITH_RELIABILITY (10, "Simulation Management with Reliability"),
    /** Live Entity (LE) Information/Interaction */
    LIVE_ENTITY_LE_INFORMATION_INTERACTION (11, "Live Entity (LE) Information/Interaction"),
    /** Non-Real-Time */
    NON_REAL_TIME (12, "Non-Real-Time"),
    /** Information Operations */
    INFORMATION_OPERATIONS (13, "Information Operations");

    private int value;
    private final String description;

    DISProtocolFamily(int value, String description)
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

    public static DISProtocolFamily getEnumForValue(int i)
    {
       for(DISProtocolFamily val: DISProtocolFamily.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DISProtocolFamily");
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

    public static DISProtocolFamily unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static DISProtocolFamily unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
}
