package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 178 marshal size 16<br>
 * Signal-TDL Type
 */
public enum SignalTDLType 
{
    /** Other */
    OTHER (0, "Other"),
    /** PADIL */
    PADIL (1, "PADIL"),
    /** NATO Link-1 */
    NATO_LINK_1 (2, "NATO Link-1"),
    /** ATDL-1 */
    ATDL_1 (3, "ATDL-1"),
    /** Link 11B (TADIL B) */
    LINK_11B_TADIL_B (4, "Link 11B (TADIL B)"),
    /** Situational Awareness Data Link (SADL) */
    SITUATIONAL_AWARENESS_DATA_LINK_SADL (5, "Situational Awareness Data Link (SADL)"),
    /** Link 16 Legacy Format (JTIDS/TADIL-J) */
    LINK_16_LEGACY_FORMAT_JTIDS_TADIL_J (6, "Link 16 Legacy Format (JTIDS/TADIL-J)"),
    /** Link 16 Legacy Format (JTIDS/FDL/TADIL-J) */
    LINK_16_LEGACY_FORMAT_JTIDS_FDL_TADIL_J (7, "Link 16 Legacy Format (JTIDS/FDL/TADIL-J)"),
    /** Link 11A (TADIL A) */
    LINK_11A_TADIL_A (8, "Link 11A (TADIL A)"),
    /** IJMS */
    IJMS (9, "IJMS"),
    /** Link 4A (TADIL C) */
    LINK_4A_TADIL_C (10, "Link 4A (TADIL C)"),
    /** Link 4C */
    LINK_4C (11, "Link 4C"),
    /** TIBS */
    TIBS (12, "TIBS"),
    /** ATL */
    ATL (13, "ATL"),
    /** Constant Source */
    CONSTANT_SOURCE (14, "Constant Source"),
    /** Abbreviated Command and Control */
    ABBREVIATED_COMMAND_AND_CONTROL (15, "Abbreviated Command and Control"),
    /** MILSTAR */
    MILSTAR (16, "MILSTAR"),
    /** ATHS */
    ATHS (17, "ATHS"),
    /** OTHGOLD */
    OTHGOLD (18, "OTHGOLD"),
    /** TACELINT */
    TACELINT (19, "TACELINT"),
    /** Weapons Data Link (AWW-13) */
    WEAPONS_DATA_LINK_AWW_13 (20, "Weapons Data Link (AWW-13)"),
    /** Abbreviated Command and Control */
    ABBREVIATED_COMMAND_AND_CONTROL_2 (21, "Abbreviated Command and Control"),
    /** Enhanced Position Location Reporting System (EPLRS) */
    ENHANCED_POSITION_LOCATION_REPORTING_SYSTEM_EPLRS (22, "Enhanced Position Location Reporting System (EPLRS)"),
    /** Position Location Reporting System (PLRS) */
    POSITION_LOCATION_REPORTING_SYSTEM_PLRS (23, "Position Location Reporting System (PLRS)"),
    /** SINCGARS */
    SINCGARS (24, "SINCGARS"),
    /** Have Quick I */
    HAVE_QUICK_I (25, "Have Quick I"),
    /** Have Quick II */
    HAVE_QUICK_II (26, "Have Quick II"),
    /** Have Quick IIA (Saturn) */
    HAVE_QUICK_IIA_SATURN (27, "Have Quick IIA (Saturn)"),
    /** Intra-Flight Data Link 1 */
    INTRA_FLIGHT_DATA_LINK_1 (28, "Intra-Flight Data Link 1"),
    /** Intra-Flight Data Link 2 */
    INTRA_FLIGHT_DATA_LINK_2 (29, "Intra-Flight Data Link 2"),
    /** Improved Data Modem (IDM) */
    IMPROVED_DATA_MODEM_IDM (30, "Improved Data Modem (IDM)"),
    /** Air Force Application Program Development (AFAPD) */
    AIR_FORCE_APPLICATION_PROGRAM_DEVELOPMENT_AFAPD (31, "Air Force Application Program Development (AFAPD)"),
    /** Cooperative Engagement Capability (CEC) */
    COOPERATIVE_ENGAGEMENT_CAPABILITY_CEC (32, "Cooperative Engagement Capability (CEC)"),
    /** Forward Area Air Defense (FAAD) Data Link (FDL) */
    FORWARD_AREA_AIR_DEFENSE_FAAD_DATA_LINK_FDL (33, "Forward Area Air Defense (FAAD) Data Link (FDL)"),
    /** Ground Based Data Link (GBDL) */
    GROUND_BASED_DATA_LINK_GBDL (34, "Ground Based Data Link (GBDL)"),
    /** Intra Vehicular Info System (IVIS) */
    INTRA_VEHICULAR_INFO_SYSTEM_IVIS (35, "Intra Vehicular Info System (IVIS)"),
    /** Marine Tactical System (MTS) */
    MARINE_TACTICAL_SYSTEM_MTS (36, "Marine Tactical System (MTS)"),
    /** Tactical Fire Direction System (TACFIRE) */
    TACTICAL_FIRE_DIRECTION_SYSTEM_TACFIRE (37, "Tactical Fire Direction System (TACFIRE)"),
    /** Integrated Broadcast Service (IBS) */
    INTEGRATED_BROADCAST_SERVICE_IBS (38, "Integrated Broadcast Service (IBS)"),
    /** Airborne Information Transfer (ABIT) */
    AIRBORNE_INFORMATION_TRANSFER_ABIT (39, "Airborne Information Transfer (ABIT)"),
    /** Advanced Tactical Airborne Reconnaissance System (ATARS) Data Link */
    ADVANCED_TACTICAL_AIRBORNE_RECONNAISSANCE_SYSTEM_ATARS_DATA_LINK (40, "Advanced Tactical Airborne Reconnaissance System (ATARS) Data Link"),
    /** Battle Group Passive Horizon Extension System (BGPHES) Data Link */
    BATTLE_GROUP_PASSIVE_HORIZON_EXTENSION_SYSTEM_BGPHES_DATA_LINK (41, "Battle Group Passive Horizon Extension System (BGPHES) Data Link"),
    /** Common High Bandwidth Data Link (CHBDL) */
    COMMON_HIGH_BANDWIDTH_DATA_LINK_CHBDL (42, "Common High Bandwidth Data Link (CHBDL)"),
    /** Guardrail Interoperable Data Link (IDL) */
    GUARDRAIL_INTEROPERABLE_DATA_LINK_IDL (43, "Guardrail Interoperable Data Link (IDL)"),
    /** Guardrail Common Sensor System One (CSS1) Data Link */
    GUARDRAIL_COMMON_SENSOR_SYSTEM_ONE_CSS1_DATA_LINK (44, "Guardrail Common Sensor System One (CSS1) Data Link"),
    /** Guardrail Common Sensor System Two (CSS2) Data Link */
    GUARDRAIL_COMMON_SENSOR_SYSTEM_TWO_CSS2_DATA_LINK (45, "Guardrail Common Sensor System Two (CSS2) Data Link"),
    /** Guardrail CSS2 Multi-Role Data Link (MRDL) */
    GUARDRAIL_CSS2_MULTI_ROLE_DATA_LINK_MRDL (46, "Guardrail CSS2 Multi-Role Data Link (MRDL)"),
    /** Guardrail CSS2 Direct Air to Satellite Relay (DASR) Data Link */
    GUARDRAIL_CSS2_DIRECT_AIR_TO_SATELLITE_RELAY_DASR_DATA_LINK (47, "Guardrail CSS2 Direct Air to Satellite Relay (DASR) Data Link"),
    /** Line of Sight (LOS) Data Link Implementation (LOS tether) */
    LINE_OF_SIGHT_LOS_DATA_LINK_IMPLEMENTATION_LOS_TETHER (48, "Line of Sight (LOS) Data Link Implementation (LOS tether)"),
    /** Lightweight CDL (LWCDL) */
    LIGHTWEIGHT_CDL_LWCDL (49, "Lightweight CDL (LWCDL)"),
    /** L-52M (SR-71) */
    L_52M_SR_71 (50, "L-52M (SR-71)"),
    /** Rivet Reach/Rivet Owl Data Link */
    RIVET_REACH_RIVET_OWL_DATA_LINK (51, "Rivet Reach/Rivet Owl Data Link"),
    /** Senior Span */
    SENIOR_SPAN (52, "Senior Span"),
    /** Senior Spur */
    SENIOR_SPUR (53, "Senior Spur"),
    /** Senior Stretch. */
    SENIOR_STRETCH (54, "Senior Stretch."),
    /** Senior Year Interoperable Data Link (IDL) */
    SENIOR_YEAR_INTEROPERABLE_DATA_LINK_IDL (55, "Senior Year Interoperable Data Link (IDL)"),
    /** Space CDL */
    SPACE_CDL (56, "Space CDL"),
    /** TR-1 mode MIST Airborne Data Link */
    TR_1_MODE_MIST_AIRBORNE_DATA_LINK (57, "TR-1 mode MIST Airborne Data Link"),
    /** Ku-band SATCOM Data Link Implementation (UAV) */
    KU_BAND_SATCOM_DATA_LINK_IMPLEMENTATION_UAV (58, "Ku-band SATCOM Data Link Implementation (UAV)"),
    /** Mission Equipment Control Data link (MECDL) */
    MISSION_EQUIPMENT_CONTROL_DATA_LINK_MECDL (59, "Mission Equipment Control Data link (MECDL)"),
    /** Radar Data Transmitting Set Data Link */
    RADAR_DATA_TRANSMITTING_SET_DATA_LINK (60, "Radar Data Transmitting Set Data Link"),
    /** Surveillance and Control Data Link (SCDL) */
    SURVEILLANCE_AND_CONTROL_DATA_LINK_SCDL (61, "Surveillance and Control Data Link (SCDL)"),
    /** Tactical UAV Video */
    TACTICAL_UAV_VIDEO (62, "Tactical UAV Video"),
    /** UHF SATCOM Data Link Implementation (UAV) */
    UHF_SATCOM_DATA_LINK_IMPLEMENTATION_UAV (63, "UHF SATCOM Data Link Implementation (UAV)"),
    /** Tactical Common Data Link (TCDL) */
    TACTICAL_COMMON_DATA_LINK_TCDL (64, "Tactical Common Data Link (TCDL)"),
    /** Low Level Air Picture Interface (LLAPI) */
    LOW_LEVEL_AIR_PICTURE_INTERFACE_LLAPI (65, "Low Level Air Picture Interface (LLAPI)"),
    /** Weapons Data Link (AGM-130) */
    WEAPONS_DATA_LINK_AGM_130 (66, "Weapons Data Link (AGM-130)"),
    /** Automatic Identification System (AIS) */
    AUTOMATIC_IDENTIFICATION_SYSTEM_AIS (67, "Automatic Identification System (AIS)"),
    /** Weapons Data Link (AIM-120) */
    WEAPONS_DATA_LINK_AIM_120 (68, "Weapons Data Link (AIM-120)"),
    /** Weapons Data Link (AIM-9) */
    WEAPONS_DATA_LINK_AIM_9 (69, "Weapons Data Link (AIM-9)"),
    /** Weapons Data Link (CAMM) */
    WEAPONS_DATA_LINK_CAMM (70, "Weapons Data Link (CAMM)"),
    /** GC3 */
    GC3 (99, "GC3"),
    /** Link 16 Standardized Format (JTIDS/MIDS/TADIL J) */
    LINK_16_STANDARDIZED_FORMAT_JTIDS_MIDS_TADIL_J (100, "Link 16 Standardized Format (JTIDS/MIDS/TADIL J)"),
    /** Link 16 Enhanced Data Rate (EDR JTIDS/MIDS/TADIL-J) */
    LINK_16_ENHANCED_DATA_RATE_EDR_JTIDS_MIDS_TADIL_J (101, "Link 16 Enhanced Data Rate (EDR JTIDS/MIDS/TADIL-J)"),
    /** JTIDS/MIDS Net Data Load (TIMS/TOMS) */
    JTIDS_MIDS_NET_DATA_LOAD_TIMS_TOMS (102, "JTIDS/MIDS Net Data Load (TIMS/TOMS)"),
    /** Link 22 */
    LINK_22 (103, "Link 22"),
    /** AFIWC IADS Communications Links */
    AFIWC_IADS_COMMUNICATIONS_LINKS (104, "AFIWC IADS Communications Links"),
    /** F-22 Intra-Flight Data Link (IFDL) */
    F_22_INTRA_FLIGHT_DATA_LINK_IFDL (105, "F-22 Intra-Flight Data Link (IFDL)"),
    /** L-Band SATCOM */
    L_BAND_SATCOM (106, "L-Band SATCOM"),
    /** TSAF Communications Link */
    TSAF_COMMUNICATIONS_LINK (107, "TSAF Communications Link"),
    /** Enhanced SINCGARS 7.3 */
    ENHANCED_SINCGARS_73 (108, "Enhanced SINCGARS 7.3"),
    /** F-35 Multifunction Advanced Data Link (MADL) */
    F_35_MULTIFUNCTION_ADVANCED_DATA_LINK_MADL (109, "F-35 Multifunction Advanced Data Link (MADL)"),
    /** Cursor on Target */
    CURSOR_ON_TARGET (110, "Cursor on Target"),
    /** All Purpose Structured Eurocontrol Surveillance Information Exchange (ASTERIX) */
    ALL_PURPOSE_STRUCTURED_EUROCONTROL_SURVEILLANCE_INFORMATION_EXCHANGE_ASTERIX (111, "All Purpose Structured Eurocontrol Surveillance Information Exchange (ASTERIX)"),
    /** Variable Message Format (VMF) over Combat Net Radio (VMF over CNR) */
    VARIABLE_MESSAGE_FORMAT_VMF_OVER_COMBAT_NET_RADIO_VMF_OVER_CNR (112, "Variable Message Format (VMF) over Combat Net Radio (VMF over CNR)"),
    /** Link 16 Surrogate for Non-NATO TDL, Using Link 16 and SISO-STD-002 to simulate a non-NATO TDL system */
    LINK_16_SURROGATE_FOR_NON_NATO_TDL (113, "Link 16 Surrogate for Non-NATO TDL"),
    /** MQ-1/9 C-Band LOS Uplink */
    MQ_1_9_C_BAND_LOS_UPLINK (114, "MQ-1/9 C-Band LOS Uplink"),
    /** MQ-1/9 C-Band LOS Downlink */
    MQ_1_9_C_BAND_LOS_DOWNLINK (115, "MQ-1/9 C-Band LOS Downlink"),
    /** MQ-1/9 Ku-Band SATCOM Uplink */
    MQ_1_9_KU_BAND_SATCOM_UPLINK (116, "MQ-1/9 Ku-Band SATCOM Uplink"),
    /** MQ-1/9 Ku-Band SATCOM Downlink */
    MQ_1_9_KU_BAND_SATCOM_DOWNLINK (117, "MQ-1/9 Ku-Band SATCOM Downlink"),
    /** Weapons Datalink (SDB II) */
    WEAPONS_DATALINK_SDB_II (118, "Weapons Datalink (SDB II)"),
    /** Common Interactive Broadcast (CIB) */
    COMMON_INTERACTIVE_BROADCAST_CIB (120, "Common Interactive Broadcast (CIB)"),
    /** Joint Range Extension Application Protocol A (JREAP A) */
    JOINT_RANGE_EXTENSION_APPLICATION_PROTOCOL_A_JREAP_A (121, "Joint Range Extension Application Protocol A (JREAP A)"),
    /** JPALS Data Link */
    JPALS_DATA_LINK (125, "JPALS Data Link"),
    /** OneSAF IADS Communications Link */
    ONESAF_IADS_COMMUNICATIONS_LINK (126, "OneSAF IADS Communications Link");

    private int value;
    private final String description;

    SignalTDLType(int value, String description)
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

    public static SignalTDLType getEnumForValue(int i)
    {
       for(SignalTDLType val: SignalTDLType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SignalTDLType");
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

    public static SignalTDLType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static SignalTDLType unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "SignalTDLType: " + name() + ": " + getValue(); 
    }
}
