package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 4 marshal size 8<br>
 * DIS-PDU Type
 */
public enum DISPDUType 
{
    /** Other */
    OTHER (0, "Other"),
    /** Entity State */
    ENTITY_STATE (1, "Entity State"),
    /** Fire */
    FIRE (2, "Fire"),
    /** Detonation */
    DETONATION (3, "Detonation"),
    /** Collision */
    COLLISION (4, "Collision"),
    /** Service Request */
    SERVICE_REQUEST (5, "Service Request"),
    /** Resupply Offer */
    RESUPPLY_OFFER (6, "Resupply Offer"),
    /** Resupply Received */
    RESUPPLY_RECEIVED (7, "Resupply Received"),
    /** Resupply Cancel */
    RESUPPLY_CANCEL (8, "Resupply Cancel"),
    /** Repair Complete */
    REPAIR_COMPLETE (9, "Repair Complete"),
    /** Repair Response */
    REPAIR_RESPONSE (10, "Repair Response"),
    /** Create Entity */
    CREATE_ENTITY (11, "Create Entity"),
    /** Remove Entity */
    REMOVE_ENTITY (12, "Remove Entity"),
    /** Start/Resume */
    START_RESUME (13, "Start/Resume"),
    /** Stop/Freeze */
    STOP_FREEZE (14, "Stop/Freeze"),
    /** Acknowledge */
    ACKNOWLEDGE (15, "Acknowledge"),
    /** Action Request */
    ACTION_REQUEST (16, "Action Request"),
    /** Action Response */
    ACTION_RESPONSE (17, "Action Response"),
    /** Data Query */
    DATA_QUERY (18, "Data Query"),
    /** Set Data */
    SET_DATA (19, "Set Data"),
    /** Data */
    DATA (20, "Data"),
    /** Event Report */
    EVENT_REPORT (21, "Event Report"),
    /** Comment */
    COMMENT (22, "Comment"),
    /** Electromagnetic Emission */
    ELECTROMAGNETIC_EMISSION (23, "Electromagnetic Emission"),
    /** Designator */
    DESIGNATOR (24, "Designator"),
    /** Transmitter */
    TRANSMITTER (25, "Transmitter"),
    /** Signal */
    SIGNAL (26, "Signal"),
    /** Receiver */
    RECEIVER (27, "Receiver"),
    /** IFF */
    IDENTIFICATION_FRIEND_OR_FOE (28, "IFF"),
    /** Underwater Acoustic */
    UNDERWATER_ACOUSTIC (29, "Underwater Acoustic"),
    /** Supplemental Emission / Entity State */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Supplemental Emission / Entity State"),
    /** Intercom Signal */
    INTERCOM_SIGNAL (31, "Intercom Signal"),
    /** Intercom Control */
    INTERCOM_CONTROL (32, "Intercom Control"),
    /** Aggregate State */
    AGGREGATE_STATE (33, "Aggregate State"),
    /** IsGroupOf */
    ISGROUPOF (34, "IsGroupOf"),
    /** Transfer Ownership */
    TRANSFER_OWNERSHIP (35, "Transfer Ownership"),
    /** IsPartOf */
    ISPARTOF (36, "IsPartOf"),
    /** Minefield State */
    MINEFIELD_STATE (37, "Minefield State"),
    /** Minefield Query */
    MINEFIELD_QUERY (38, "Minefield Query"),
    /** Minefield Data */
    MINEFIELD_DATA (39, "Minefield Data"),
    /** Minefield Response NACK */
    MINEFIELD_RESPONSE_NACK (40, "Minefield Response NACK"),
    /** Environmental Process */
    ENVIRONMENTAL_PROCESS (41, "Environmental Process"),
    /** Gridded Data */
    GRIDDED_DATA (42, "Gridded Data"),
    /** Point Object State */
    POINT_OBJECT_STATE (43, "Point Object State"),
    /** Linear Object State */
    LINEAR_OBJECT_STATE (44, "Linear Object State"),
    /** Areal Object State */
    AREAL_OBJECT_STATE (45, "Areal Object State"),
    /** TSPI */
    TIME_SPACE_POSITION_INFORMATION (46, "TSPI"),
    /** Appearance */
    APPEARANCE (47, "Appearance"),
    /** Articulated Parts */
    ARTICULATED_PARTS (48, "Articulated Parts"),
    /** LE Fire */
    LIVE_ENTITY_FIRE (49, "LE Fire"),
    /** LE Detonation */
    LIVE_ENTITY_DETONATION (50, "LE Detonation"),
    /** Create Entity-R */
    CREATE_ENTITY_RELIABLE (51, "Create Entity-R"),
    /** Remove Entity-R */
    REMOVE_ENTITY_RELIABLE (52, "Remove Entity-R"),
    /** Start/Resume-R */
    START_RESUME_RELIABLE (53, "Start/Resume-R"),
    /** Stop/Freeze-R */
    STOP_FREEZE_RELIABLE (54, "Stop/Freeze-R"),
    /** Acknowledge-R */
    ACKNOWLEDGE_RELIABLE (55, "Acknowledge-R"),
    /** Action Request-R */
    ACTION_REQUEST_RELIABLE (56, "Action Request-R"),
    /** Action Response-R */
    ACTION_RESPONSE_RELIABLE (57, "Action Response-R"),
    /** Data Query-R */
    DATA_QUERY_RELIABLE (58, "Data Query-R"),
    /** Set Data-R */
    SET_DATA_RELIABLE (59, "Set Data-R"),
    /** Data-R */
    DATA_RELIABLE (60, "Data-R"),
    /** Event Report-R */
    EVENT_REPORT_RELIABLE (61, "Event Report-R"),
    /** Comment-R */
    COMMENT_RELIABLE (62, "Comment-R"),
    /** Record-R */
    RECORD_RELIABLE (63, "Record-R"),
    /** Set Record-R */
    SET_RECORD_RELIABLE	 (64, "Set Record-R"),
    /** Record Query-R */
    RECORD_QUERY_RELIABLE (65, "Record Query-R"),
    /** Collision-Elastic */
    COLLISION_ELASTIC (66, "Collision-Elastic"),
    /** Entity State Update */
    ENTITY_STATE_UPDATE (67, "Entity State Update"),
    /** Directed Energy Fire */
    DIRECTED_ENERGY_FIRE (68, "Directed Energy Fire"),
    /** Entity Damage Status */
    ENTITY_DAMAGE_STATUS (69, "Entity Damage Status"),
    /** Information Operations Action */
    INFORMATION_OPERATIONS_ACTION (70, "Information Operations Action"),
    /** Information Operations Report */
    INFORMATION_OPERATIONS_REPORT (71, "Information Operations Report"),
    /** Attribute */
    ATTRIBUTE (72, "Attribute");

    private int value;
    private final String description;

    DISPDUType(int value, String description)
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

    public static DISPDUType getEnumForValue(int i)
    {
       for(DISPDUType val: DISPDUType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DISPDUType");
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

    public static DISPDUType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static DISPDUType unmarshalEnum(ByteBuffer buff) throws Exception
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
    
    @Override
    public String toString()
    {
        return "DISPDUType: " + name() + ": " + getValue(); 
    }
}
