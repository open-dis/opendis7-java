package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 71 marshal size 32<br>
 * ActionRequestActionID
 */
public enum ActionRequestActionID 
{
    /** Other */
    OTHER (0, "Other"),
    /** Local storage of the requested information */
    LOCAL_STORAGE_OF_THE_REQUESTED_INFORMATION (1, "Local storage of the requested information"),
    /** Inform SM of event ran out of ammunition */
    INFORM_SM_OF_EVENT_RAN_OUT_OF_AMMUNITION (2, "Inform SM of event ran out of ammunition"),
    /** Inform SM of event killed in action */
    INFORM_SM_OF_EVENT_KILLED_IN_ACTION (3, "Inform SM of event killed in action"),
    /** Inform SM of event damage */
    INFORM_SM_OF_EVENT_DAMAGE (4, "Inform SM of event damage"),
    /** Inform SM of event mobility disabled */
    INFORM_SM_OF_EVENT_MOBILITY_DISABLED (5, "Inform SM of event mobility disabled"),
    /** Inform SM of event fire disabled */
    INFORM_SM_OF_EVENT_FIRE_DISABLED (6, "Inform SM of event fire disabled"),
    /** Inform SM of event ran out of fuel */
    INFORM_SM_OF_EVENT_RAN_OUT_OF_FUEL (7, "Inform SM of event ran out of fuel"),
    /** Recall checkpoint data */
    RECALL_CHECKPOINT_DATA (8, "Recall checkpoint data"),
    /** Recall initial parameters */
    RECALL_INITIAL_PARAMETERS (9, "Recall initial parameters"),
    /** Initiate tether-lead */
    INITIATE_TETHER_LEAD (10, "Initiate tether-lead"),
    /** Initiate tether-follow */
    INITIATE_TETHER_FOLLOW (11, "Initiate tether-follow"),
    /** Unthether */
    UNTHETHER (12, "Unthether"),
    /** Initiate service station resupply */
    INITIATE_SERVICE_STATION_RESUPPLY (13, "Initiate service station resupply"),
    /** Initiate tailgate resupply */
    INITIATE_TAILGATE_RESUPPLY (14, "Initiate tailgate resupply"),
    /** Initiate hitch lead */
    INITIATE_HITCH_LEAD (15, "Initiate hitch lead"),
    /** Initiate hitch follow */
    INITIATE_HITCH_FOLLOW (16, "Initiate hitch follow"),
    /** Unhitch */
    UNHITCH (17, "Unhitch"),
    /** Mount */
    MOUNT (18, "Mount"),
    /** Dismount */
    DISMOUNT (19, "Dismount"),
    /** Start DRC (Daily Readiness Check) */
    START_DRC_DAILY_READINESS_CHECK (20, "Start DRC (Daily Readiness Check)"),
    /** Stop DRC */
    STOP_DRC (21, "Stop DRC"),
    /** Data Query */
    DATA_QUERY (22, "Data Query"),
    /** Status Request */
    STATUS_REQUEST (23, "Status Request"),
    /** Send Object State Data */
    SEND_OBJECT_STATE_DATA (24, "Send Object State Data"),
    /** Reconstitute */
    RECONSTITUTE (25, "Reconstitute"),
    /** Lock Site Configuration */
    LOCK_SITE_CONFIGURATION (26, "Lock Site Configuration"),
    /** Unlock Site Configuration */
    UNLOCK_SITE_CONFIGURATION (27, "Unlock Site Configuration"),
    /** Update Site Configuration */
    IDENTIFICATION_FRIEND_OR_FOE (28, "Update Site Configuration"),
    /** Query Site Configuration */
    QUERY_SITE_CONFIGURATION (29, "Query Site Configuration"),
    /** Tethering Information */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Tethering Information"),
    /** Mount Intent */
    MOUNT_INTENT (31, "Mount Intent"),
    /** Accept Subscription */
    ACCEPT_SUBSCRIPTION (33, "Accept Subscription"),
    /** Unsubscribe */
    UNSUBSCRIBE (34, "Unsubscribe"),
    /** Teleport entity */
    TELEPORT_ENTITY (35, "Teleport entity"),
    /** Change aggregate state */
    CHANGE_AGGREGATE_STATE (36, "Change aggregate state"),
    /** Request Start PDU */
    REQUEST_START_PDU (37, "Request Start PDU"),
    /** Wakeup get ready for initialization */
    WAKEUP_GET_READY_FOR_INITIALIZATION (38, "Wakeup get ready for initialization"),
    /** Initialize internal parameters */
    INITIALIZE_INTERNAL_PARAMETERS (39, "Initialize internal parameters"),
    /** Send plan data */
    SEND_PLAN_DATA (40, "Send plan data"),
    /** Synchronize internal clocks */
    SYNCHRONIZE_INTERNAL_CLOCKS (41, "Synchronize internal clocks"),
    /** Run */
    RUN (42, "Run"),
    /** Save internal parameters */
    SAVE_INTERNAL_PARAMETERS (43, "Save internal parameters"),
    /** Simulate malfunction */
    SIMULATE_MALFUNCTION (44, "Simulate malfunction"),
    /** Join exercise */
    JOIN_EXERCISE (45, "Join exercise"),
    /** Resign exercise */
    TIME_SPACE_POSITION_INFORMATION (46, "Resign exercise"),
    /** Time advance */
    TIME_ADVANCE (47, "Time advance"),
    /** TACCSF LOS Request-Type 1 */
    TACCSF_LOS_REQUEST_TYPE_1 (100, "TACCSF LOS Request-Type 1"),
    /** TACCSF LOS Request-Type 2 */
    TACCSF_LOS_REQUEST_TYPE_2 (101, "TACCSF LOS Request-Type 2"),
    /** Airmount Mount Request */
    AIRMOUNT_MOUNT_REQUEST (4303, "Airmount Mount Request"),
    /** Airmount Dismount Request */
    AIRMOUNT_DISMOUNT_REQUEST (4304, "Airmount Dismount Request"),
    /** Airmount Information Request */
    AIRMOUNT_INFORMATION_REQUEST (4305, "Airmount Information Request");

    private int value;
    private final String description;

    /** Constructor */
    ActionRequestActionID(int value, String description)
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
      return 32;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static ActionRequestActionID getEnumForValue(int i)
    {
       for(ActionRequestActionID val: ActionRequestActionID.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration ActionRequestActionID");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output */
    public void marshal(ByteBuffer byteBuffer)
    {
        byteBuffer.putInt(getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static ActionRequestActionID unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @return enumeration of interest */
    public static ActionRequestActionID unmarshalEnum (ByteBuffer byteBuffer)
    {
        return getEnumForValue(byteBuffer.getInt());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
    
    @Override
    public String toString()
    {
        return "ActionRequestActionID: " + getValue() + " " + name();
    }
}
