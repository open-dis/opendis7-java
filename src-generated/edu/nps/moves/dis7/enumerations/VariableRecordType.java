package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 66 marshal size 32<br>
 * Variable Record Types
 */
public enum VariableRecordType 
{
    /** DDCP Join Transaction Join Request Message */
    DDCP_JOIN_TRANSACTION_JOIN_REQUEST_MESSAGE (1001, "DDCP Join Transaction Join Request Message"),
    /** DDCP Set Playback Window Transaction Set Playback Window Request Message */
    DDCP_SET_PLAYBACK_WINDOW_TRANSACTION_SET_PLAYBACK_WINDOW_REQUEST_MESSAGE (1002, "DDCP Set Playback Window Transaction Set Playback Window Request Message"),
    /** DDCP Load Mission Recording Transaction Load Mission Recording Request Message */
    DDCP_LOAD_MISSION_RECORDING_TRANSACTION_LOAD_MISSION_RECORDING_REQUEST_MESSAGE (1003, "DDCP Load Mission Recording Transaction Load Mission Recording Request Message"),
    /** DDCP Cue Transaction Cue Request Message */
    DDCP_CUE_TRANSACTION_CUE_REQUEST_MESSAGE (1004, "DDCP Cue Transaction Cue Request Message"),
    /** DDCP Play Transaction Play Request Message */
    DDCP_PLAY_TRANSACTION_PLAY_REQUEST_MESSAGE (1005, "DDCP Play Transaction Play Request Message"),
    /** DDCP Stop Transaction Stop Request Message */
    DDCP_STOP_TRANSACTION_STOP_REQUEST_MESSAGE (1006, "DDCP Stop Transaction Stop Request Message"),
    /** DDCP Pause Transaction Pause Request Message */
    DDCP_PAUSE_TRANSACTION_PAUSE_REQUEST_MESSAGE (1007, "DDCP Pause Transaction Pause Request Message"),
    /** DDCP End Transaction End Request Message */
    DDCP_END_TRANSACTION_END_REQUEST_MESSAGE (1009, "DDCP End Transaction End Request Message"),
    /** DDCP Join Response Message */
    DDCP_JOIN_RESPONSE_MESSAGE (1051, "DDCP Join Response Message"),
    /** DDCP Request Receipt Message */
    DDCP_REQUEST_RECEIPT_MESSAGE (1052, "DDCP Request Receipt Message"),
    /** DDCP Playback Window Confirmed Message */
    DDCP_PLAYBACK_WINDOW_CONFIRMED_MESSAGE (1053, "DDCP Playback Window Confirmed Message"),
    /** DDCP Mission Recording Loaded Message */
    DDCP_MISSION_RECORDING_LOADED_MESSAGE (1054, "DDCP Mission Recording Loaded Message"),
    /** DDCP Cue Confirmed Message */
    DDCP_CUE_CONFIRMED_MESSAGE (1055, "DDCP Cue Confirmed Message"),
    /** DDCP Time to Complete Message */
    DDCP_TIME_TO_COMPLETE_MESSAGE (1056, "DDCP Time to Complete Message"),
    /** DDCP Play Commenced Message */
    DDCP_PLAY_COMMENCED_MESSAGE (1057, "DDCP Play Commenced Message"),
    /** DDCP Stop Confirmed Message */
    DDCP_STOP_CONFIRMED_MESSAGE (1058, "DDCP Stop Confirmed Message"),
    /** DDCP Pause Confirmed Message */
    DDCP_PAUSE_CONFIRMED_MESSAGE (1059, "DDCP Pause Confirmed Message"),
    /** DDCP End Response Message */
    DDCP_END_RESPONSE_MESSAGE (1061, "DDCP End Response Message"),
    /** DDCP Master Announce Message */
    DDCP_MASTER_ANNOUNCE_MESSAGE (1111, "DDCP Master Announce Message"),
    /** DDCP Device Announce Message */
    DDCP_DEVICE_ANNOUNCE_MESSAGE (1112, "DDCP Device Announce Message"),
    /** DDCP Device Exit Message */
    DDCP_DEVICE_EXIT_MESSAGE (1114, "DDCP Device Exit Message"),
    /** DDCP Device Heartbeat Message */
    DDCP_DEVICE_HEARTBEAT_MESSAGE (1115, "DDCP Device Heartbeat Message"),
    /** DDCP Master Time Sync Message */
    DDCP_MASTER_TIME_SYNC_MESSAGE (1116, "DDCP Master Time Sync Message"),
    /** DDCP Error Message */
    DDCP_ERROR_MESSAGE (1118, "DDCP Error Message"),
    /** DDCP Master Stop Sync Message */
    DDCP_MASTER_STOP_SYNC_MESSAGE (1119, "DDCP Master Stop Sync Message"),
    /** DDCP Master Transition Message */
    DDCP_MASTER_TRANSITION_MESSAGE (1120, "DDCP Master Transition Message"),
    /** Mission Time */
    MISSION_TIME (1200, "Mission Time"),
    /** High Fidelity HAVE QUICK Radio */
    HIGH_FIDELITY_HAVE_QUICK_RADIO (3000, "High Fidelity HAVE QUICK Radio"),
    /** Blanking Sector attribute record */
    BLANKING_SECTOR_ATTRIBUTE_RECORD (3500, "Blanking Sector attribute record"),
    /** Angle Deception attribute record */
    ANGLE_DECEPTION_ATTRIBUTE_RECORD (3501, "Angle Deception attribute record"),
    /** False Targets attribute record */
    FALSE_TARGETS_ATTRIBUTE_RECORD (3502, "False Targets attribute record"),
    /** DE Precision Aimpoint record */
    DE_PRECISION_AIMPOINT_RECORD (4000, "DE Precision Aimpoint record"),
    /** DE Area Aimpoint record */
    DE_AREA_AIMPOINT_RECORD (4001, "DE Area Aimpoint record"),
    /** Directed Energy Damage Description record */
    DIRECTED_ENERGY_DAMAGE_DESCRIPTION_RECORD (4500, "Directed Energy Damage Description record"),
    /** Crypto Control */
    CRYPTO_CONTROL (5000, "Crypto Control"),
    /** Mode 5/S Transponder Location */
    MODE_5_S_TRANSPONDER_LOCATION (5001, "Mode 5/S Transponder Location"),
    /** Mode 5/S Transponder Location Error */
    MODE_5_S_TRANSPONDER_LOCATION_ERROR (5002, "Mode 5/S Transponder Location Error"),
    /** Squitter Airborne Position Report */
    SQUITTER_AIRBORNE_POSITION_REPORT (5003, "Squitter Airborne Position Report"),
    /** Squitter Airborne Velocity Report */
    SQUITTER_AIRBORNE_VELOCITY_REPORT (5004, "Squitter Airborne Velocity Report"),
    /** Squitter Surface Position Report */
    SQUITTER_SURFACE_POSITION_REPORT (5005, "Squitter Surface Position Report"),
    /** Squitter Identification Report */
    SQUITTER_IDENTIFICATION_REPORT (5006, "Squitter Identification Report"),
    /** GICB */
    GICB (5007, "GICB"),
    /** Squitter Event-Driven Report */
    SQUITTER_EVENT_DRIVEN_REPORT (5008, "Squitter Event-Driven Report"),
    /** Antenna Location */
    ANTENNA_LOCATION (5009, "Antenna Location"),
    /** Basic Interactive */
    BASIC_INTERACTIVE (5010, "Basic Interactive"),
    /** Interactive Mode 4 Reply */
    INTERACTIVE_MODE_4_REPLY (5011, "Interactive Mode 4 Reply"),
    /** Interactive Mode 5 Reply */
    INTERACTIVE_MODE_5_REPLY (5012, "Interactive Mode 5 Reply"),
    /** Interactive Basic Mode 5 */
    INTERACTIVE_BASIC_MODE_5 (5013, "Interactive Basic Mode 5"),
    /** Interactive Basic Mode S */
    INTERACTIVE_BASIC_MODE_S (5014, "Interactive Basic Mode S"),
    /** IO Effect */
    IO_EFFECT (5500, "IO Effect"),
    /** IO Communications Node */
    IO_COMMUNICATIONS_NODE (5501, "IO Communications Node"),
    /** Identification */
    IDENTIFICATION (10000, "Identification"),
    /** Trainer Initial Conditions Filename */
    TRAINER_INITIAL_CONDITIONS_FILENAME (10010, "Trainer Initial Conditions Filename"),
    /** Increment 3.1 Mission Data Load Name */
    INCREMENT_31_MISSION_DATA_LOAD_NAME (10020, "Increment 3.1 Mission Data Load Name"),
    /** Increment 2 Mission Data Load Name */
    INCREMENT_2_MISSION_DATA_LOAD_NAME (10030, "Increment 2 Mission Data Load Name"),
    /** Set Markpoint Command */
    SET_MARKPOINT_COMMAND (10110, "Set Markpoint Command"),
    /** Markpoint ID */
    MARKPOINT_ID (10115, "Markpoint ID"),
    /** Reaction Level */
    REACTION_LEVEL (10140, "Reaction Level"),
    /** Weapon Reload */
    WEAPON_RELOAD (10150, "Weapon Reload"),
    /** CES Entity Set / Clear Status */
    CES_ENTITY_SET_CLEAR_STATUS (10157, "CES Entity Set / Clear Status"),
    /** Activate Entity */
    ACTIVATE_ENTITY (10160, "Activate Entity"),
    /** Disengage / Reengage */
    DISENGAGE_REENGAGE (10170, "Disengage / Reengage"),
    /** Fuel Freeze */
    FUEL_FREEZE (10190, "Fuel Freeze"),
    /** Fire Launch Dispense */
    FIRE_LAUNCH_DISPENSE (10250, "Fire Launch Dispense"),
    /** Target Assignment */
    TARGET_ASSIGNMENT (10254, "Target Assignment"),
    /** CIC Enable */
    CIC_ENABLE (10256, "CIC Enable"),
    /** Shoot Inhibit */
    SHOOT_INHIBIT (10258, "Shoot Inhibit"),
    /** Posture */
    POSTURE (10259, "Posture"),
    /** Jammer State */
    JAMMER_STATE (10262, "Jammer State"),
    /** Jammer Type */
    JAMMER_TYPE (10263, "Jammer Type"),
    /** Dynamic Targeting */
    DYNAMIC_TARGETING (10264, "Dynamic Targeting"),
    /** Manual Jamming On Override */
    MANUAL_JAMMING_ON_OVERRIDE (10267, "Manual Jamming On Override"),
    /** SOJ Axis */
    SOJ_AXIS (10268, "SOJ Axis"),
    /** Emitter Override */
    EMITTER_OVERRIDE (10280, "Emitter Override"),
    /** Shields */
    SHIELDS (10290, "Shields"),
    /** Crash Override */
    CRASH_OVERRIDE (10300, "Crash Override"),
    /** Stop Buzzer */
    STOP_BUZZER (10306, "Stop Buzzer"),
    /** Target Lasing - On / Off */
    TARGET_LASING_ON_OFF (10307, "Target Lasing - On / Off"),
    /** Target Lasing - Laser Code */
    TARGET_LASING_LASER_CODE (10308, "Target Lasing - Laser Code"),
    /** Power Plant */
    POWER_PLANT (10310, "Power Plant"),
    /** Tactical Lighting On / Off Control - Light Control */
    TACTICAL_LIGHTING_ON_OFF_CONTROL_LIGHT_CONTROL (10311, "Tactical Lighting On / Off Control - Light Control"),
    /** Tactical Lighting Blinker Control - Blinker Value */
    TACTICAL_LIGHTING_BLINKER_CONTROL_BLINKER_VALUE (10312, "Tactical Lighting Blinker Control - Blinker Value"),
    /** Tactical Lighting On / Off Control - Light Control Type */
    TACTICAL_LIGHTING_ON_OFF_CONTROL_LIGHT_CONTROL_TYPE (10313, "Tactical Lighting On / Off Control - Light Control Type"),
    /** Park Vehicle */
    PARK_VEHICLE (10314, "Park Vehicle"),
    /** Signaling On / Off */
    SIGNALING_ON_OFF (10315, "Signaling On / Off"),
    /** Signaling Device */
    SIGNALING_DEVICE (10316, "Signaling Device"),
    /** Ownship ID */
    OWNSHIP_ID (10400, "Ownship ID"),
    /** State Change */
    STATE_CHANGE (10600, "State Change"),
    /** Entity Type */
    ENTITY_TYPE (11000, "Entity Type"),
    /** Concatenated */
    CONCATENATED (11100, "Concatenated"),
    /** Kind */
    KIND (11110, "Kind"),
    /** Domain */
    DOMAIN (11120, "Domain"),
    /** Country */
    COUNTRY (11130, "Country"),
    /** Category */
    CATEGORY (11140, "Category"),
    /** Subcategory */
    SUBCATEGORY (11150, "Subcategory"),
    /** Specific */
    SPECIFIC (11160, "Specific"),
    /** Extra */
    EXTRA (11170, "Extra"),
    /** Force ID */
    FORCE_ID (11180, "Force ID"),
    /** Force ID */
    FORCE_ID_2 (11200, "Force ID"),
    /** Description */
    DESCRIPTION (11300, "Description"),
    /** Tanker Boom Control */
    TANKER_BOOM_CONTROL (11500, "Tanker Boom Control"),
    /** Airport Lights */
    AIRPORT_LIGHTS (11501, "Airport Lights"),
    /** Weather Post */
    WEATHER_POST (11502, "Weather Post"),
    /** Localizer and GlideSlope */
    LOCALIZER_AND_GLIDESLOPE (11503, "Localizer and GlideSlope"),
    /** TACAN NavAids */
    TACAN_NAVAIDS (11504, "TACAN NavAids"),
    /** Alternative Entity Type */
    ALTERNATIVE_ENTITY_TYPE (12000, "Alternative Entity Type"),
    /** Kind */
    KIND_2 (12110, "Kind"),
    /** Domain */
    DOMAIN_2 (12120, "Domain"),
    /** Country */
    COUNTRY_2 (12130, "Country"),
    /** Category */
    CATEGORY_2 (12140, "Category"),
    /** Subcategory */
    SUBCATEGORY_2 (12150, "Subcategory"),
    /** Specific */
    SPECIFIC_2 (12160, "Specific"),
    /** Extra */
    EXTRA_2 (12170, "Extra"),
    /** Description */
    DESCRIPTION_2 (12300, "Description"),
    /** Entity Marking */
    ENTITY_MARKING (13000, "Entity Marking"),
    /** Entity Marking Characters */
    ENTITY_MARKING_CHARACTERS (13100, "Entity Marking Characters"),
    /** Crew ID */
    CREW_ID (13200, "Crew ID"),
    /** Task Organization */
    TASK_ORGANIZATION (14000, "Task Organization"),
    /** Regiment Name */
    REGIMENT_NAME (14200, "Regiment Name"),
    /** Battalion Name */
    BATTALION_NAME (14300, "Battalion Name"),
    /** Company Name */
    COMPANY_NAME (14400, "Company Name"),
    /** Platoon Name */
    PLATOON_NAME (14500, "Platoon Name"),
    /** Squad Name */
    SQUAD_NAME (14520, "Squad Name"),
    /** Team Name */
    TEAM_NAME (14540, "Team Name"),
    /** Bumper Number */
    BUMPER_NUMBER (14600, "Bumper Number"),
    /** Vehicle Number */
    VEHICLE_NUMBER (14700, "Vehicle Number"),
    /** Unit Number */
    UNIT_NUMBER (14800, "Unit Number"),
    /** DIS Identity */
    DIS_IDENTITY (15000, "DIS Identity"),
    /** DIS Site ID */
    DIS_SITE_ID (15100, "DIS Site ID"),
    /** DIS Host ID */
    DIS_HOST_ID (15200, "DIS Host ID"),
    /** DIS Entity ID */
    DIS_ENTITY_ID (15300, "DIS Entity ID"),
    /** Mount Intent */
    MOUNT_INTENT (15400, "Mount Intent"),
    /** Tether-Unthether Command ID */
    TETHER_UNTHETHER_COMMAND_ID (15500, "Tether-Unthether Command ID"),
    /** Teleport Entity Data Record */
    TELEPORT_ENTITY_DATA_RECORD (15510, "Teleport Entity Data Record"),
    /** DIS Aggregate ID (Set if communication to aggregate) */
    DIS_AGGREGATE_ID_SET_IF_COMMUNICATION_TO_AGGREGATE (15600, "DIS Aggregate ID (Set if communication to aggregate)"),
    /** Ownership Status */
    OWNERSHIP_STATUS (15800, "Ownership Status"),
    /** Reconstitute */
    RECONSTITUTE (19177, "Reconstitute"),
    /** Loads */
    LOADS (20000, "Loads"),
    /** Crew Members */
    CREW_MEMBERS (21000, "Crew Members"),
    /** Crew Member ID */
    CREW_MEMBER_ID (21100, "Crew Member ID"),
    /** Health */
    HEALTH (21200, "Health"),
    /** Job Assignment */
    JOB_ASSIGNMENT (21300, "Job Assignment"),
    /** Fuel */
    FUEL (23000, "Fuel"),
    /** Quantity */
    QUANTITY (23100, "Quantity"),
    /** Quantity */
    QUANTITY_2 (23105, "Quantity"),
    /** Ammunition */
    AMMUNITION (24000, "Ammunition"),
    /** 120-mm HEAT, quantity */
    $120_MM_HEAT_QUANTITY (24001, "120-mm HEAT, quantity"),
    /** 120-mm SABOT, quantity */
    $120_MM_SABOT_QUANTITY (24002, "120-mm SABOT, quantity"),
    /** 12.7-mm M8, quantity */
    $127_MM_M8_QUANTITY (24003, "12.7-mm M8, quantity"),
    /** 12.7-mm M20, quantity */
    $127_MM_M20_QUANTITY (24004, "12.7-mm M20, quantity"),
    /** 7.62-mm M62, quantity */
    $762_MM_M62_QUANTITY (24005, "7.62-mm M62, quantity"),
    /** M250 UKL8A1, quantity */
    M250_UKL8A1_QUANTITY (24006, "M250 UKL8A1, quantity"),
    /** M250 UKL8A3, quantity */
    M250_UKL8A3_QUANTITY (24007, "M250 UKL8A3, quantity"),
    /** 7.62-mm M80, quantity */
    $762_MM_M80_QUANTITY (24008, "7.62-mm M80, quantity"),
    /** 12.7-mm, quantity */
    $127_MM_QUANTITY (24009, "12.7-mm, quantity"),
    /** 7.62-mm, quantity */
    $762_MM_QUANTITY (24010, "7.62-mm, quantity"),
    /** Mines, quantity */
    MINES_QUANTITY (24060, "Mines, quantity"),
    /** Type */
    TYPE (24100, "Type"),
    /** Kind */
    KIND_3 (24110, "Kind"),
    /** Domain */
    DOMAIN_3 (24120, "Domain"),
    /** Country */
    COUNTRY_3 (24130, "Country"),
    /** Category */
    CATEGORY_3 (24140, "Category"),
    /** Subcategory */
    SUBCATEGORY_3 (24150, "Subcategory"),
    /** Extra */
    EXTRA_3 (24160, "Extra"),
    /** Description */
    DESCRIPTION_3 (24300, "Description"),
    /** Cargo */
    CARGO (25000, "Cargo"),
    /** Vehicle Mass */
    VEHICLE_MASS (26000, "Vehicle Mass"),
    /** Supply Quantity */
    SUPPLY_QUANTITY (27000, "Supply Quantity"),
    /** Armament */
    ARMAMENT (28000, "Armament"),
    /** Status */
    STATUS (30000, "Status"),
    /** Activate entity */
    ACTIVATE_ENTITY_2 (30010, "Activate entity"),
    /** Subscription State */
    SUBSCRIPTION_STATE (30100, "Subscription State"),
    /** Round trip time delay */
    ROUND_TRIP_TIME_DELAY (30300, "Round trip time delay"),
    /** TADIL J message count (label 0) */
    TADIL_J_MESSAGE_COUNT_LABEL_0 (30400, "TADIL J message count (label 0)"),
    /** TADIL J message count (label 1) */
    TADIL_J_MESSAGE_COUNT_LABEL_1 (30401, "TADIL J message count (label 1)"),
    /** TADIL J message count (label 2) */
    TADIL_J_MESSAGE_COUNT_LABEL_2 (30402, "TADIL J message count (label 2)"),
    /** TADIL J message count (label 3) */
    TADIL_J_MESSAGE_COUNT_LABEL_3 (30403, "TADIL J message count (label 3)"),
    /** TADIL J message count (label 4) */
    TADIL_J_MESSAGE_COUNT_LABEL_4 (30404, "TADIL J message count (label 4)"),
    /** TADIL J message count (label 5) */
    TADIL_J_MESSAGE_COUNT_LABEL_5 (30405, "TADIL J message count (label 5)"),
    /** TADIL J message count (label 6) */
    TADIL_J_MESSAGE_COUNT_LABEL_6 (30406, "TADIL J message count (label 6)"),
    /** TADIL J message count (label 7) */
    TADIL_J_MESSAGE_COUNT_LABEL_7 (30407, "TADIL J message count (label 7)"),
    /** TADIL J message count (label 8) */
    TADIL_J_MESSAGE_COUNT_LABEL_8 (30408, "TADIL J message count (label 8)"),
    /** TADIL J message count (label 9) */
    TADIL_J_MESSAGE_COUNT_LABEL_9 (30409, "TADIL J message count (label 9)"),
    /** TADIL J message count (label 10) */
    TADIL_J_MESSAGE_COUNT_LABEL_10 (30410, "TADIL J message count (label 10)"),
    /** TADIL J message count (label 11) */
    TADIL_J_MESSAGE_COUNT_LABEL_11 (30411, "TADIL J message count (label 11)"),
    /** TADIL J message count (label 12) */
    TADIL_J_MESSAGE_COUNT_LABEL_12 (30412, "TADIL J message count (label 12)"),
    /** TADIL J message count (label 13) */
    TADIL_J_MESSAGE_COUNT_LABEL_13 (30413, "TADIL J message count (label 13)"),
    /** TADIL J message count (label 14) */
    TADIL_J_MESSAGE_COUNT_LABEL_14 (30414, "TADIL J message count (label 14)"),
    /** TADIL J message count (label 15) */
    TADIL_J_MESSAGE_COUNT_LABEL_15 (30415, "TADIL J message count (label 15)"),
    /** TADIL J message count (label 16) */
    TADIL_J_MESSAGE_COUNT_LABEL_16 (30416, "TADIL J message count (label 16)"),
    /** TADIL J message count (label 17) */
    TADIL_J_MESSAGE_COUNT_LABEL_17 (30417, "TADIL J message count (label 17)"),
    /** TADIL J message count (label 18) */
    TADIL_J_MESSAGE_COUNT_LABEL_18 (30418, "TADIL J message count (label 18)"),
    /** TADIL J message count (label 19) */
    TADIL_J_MESSAGE_COUNT_LABEL_19 (30419, "TADIL J message count (label 19)"),
    /** TADIL J message count (label 20) */
    TADIL_J_MESSAGE_COUNT_LABEL_20 (30420, "TADIL J message count (label 20)"),
    /** TADIL J message count (label 21) */
    TADIL_J_MESSAGE_COUNT_LABEL_21 (30421, "TADIL J message count (label 21)"),
    /** TADIL J message count (label 22) */
    TADIL_J_MESSAGE_COUNT_LABEL_22 (30422, "TADIL J message count (label 22)"),
    /** TADIL J message count (label 23) */
    TADIL_J_MESSAGE_COUNT_LABEL_23 (30423, "TADIL J message count (label 23)"),
    /** TADIL J message count (label 24) */
    TADIL_J_MESSAGE_COUNT_LABEL_24 (30424, "TADIL J message count (label 24)"),
    /** TADIL J message count (label 25) */
    TADIL_J_MESSAGE_COUNT_LABEL_25 (30425, "TADIL J message count (label 25)"),
    /** TADIL J message count (label 26) */
    TADIL_J_MESSAGE_COUNT_LABEL_26 (30426, "TADIL J message count (label 26)"),
    /** TADIL J message count (label 27) */
    TADIL_J_MESSAGE_COUNT_LABEL_27 (30427, "TADIL J message count (label 27)"),
    /** TADIL J message count (label 28) */
    TADIL_J_MESSAGE_COUNT_LABEL_28 (30428, "TADIL J message count (label 28)"),
    /** TADIL J message count (label 29) */
    TADIL_J_MESSAGE_COUNT_LABEL_29 (30429, "TADIL J message count (label 29)"),
    /** TADIL J message count (label 30) */
    TADIL_J_MESSAGE_COUNT_LABEL_30 (30430, "TADIL J message count (label 30)"),
    /** TADIL J message count (label 31) */
    TADIL_J_MESSAGE_COUNT_LABEL_31 (30431, "TADIL J message count (label 31)"),
    /** Position */
    POSITION (31000, "Position"),
    /** Route (Waypoint) type */
    ROUTE_WAYPOINT_TYPE (31010, "Route (Waypoint) type"),
    /** MilGrid10 */
    MILGRID10 (31100, "MilGrid10"),
    /** Geocentric Coordinates */
    GEOCENTRIC_COORDINATES (31200, "Geocentric Coordinates"),
    /** X */
    X (31210, "X"),
    /** Y */
    Y (31220, "Y"),
    /** Z */
    Z (31230, "Z"),
    /** Latitude */
    LATITUDE (31300, "Latitude"),
    /** Longitude */
    LONGITUDE (31400, "Longitude"),
    /** Line of Sight */
    LINE_OF_SIGHT (31500, "Line of Sight"),
    /** X */
    X_2 (31510, "X"),
    /** Y */
    Y_2 (31520, "Y"),
    /** Z */
    Z_2 (31530, "Z"),
    /** Altitude */
    ALTITUDE (31600, "Altitude"),
    /** Destination Latitude */
    DESTINATION_LATITUDE (31700, "Destination Latitude"),
    /** Destination Longitude */
    DESTINATION_LONGITUDE (31800, "Destination Longitude"),
    /** Destination Altitude */
    DESTINATION_ALTITUDE (31900, "Destination Altitude"),
    /** Orientation */
    ORIENTATION (32000, "Orientation"),
    /** Hull Heading Angle */
    HULL_HEADING_ANGLE (32100, "Hull Heading Angle"),
    /** Hull Pitch Angle */
    HULL_PITCH_ANGLE (32200, "Hull Pitch Angle"),
    /** Roll Angle */
    ROLL_ANGLE (32300, "Roll Angle"),
    /** X */
    X_3 (32500, "X"),
    /** Y */
    Y_3 (32600, "Y"),
    /** Z */
    Z_3 (32700, "Z"),
    /** Appearance */
    APPEARANCE (33000, "Appearance"),
    /** Ambient Lighting */
    AMBIENT_LIGHTING (33100, "Ambient Lighting"),
    /** Lights */
    LIGHTS (33101, "Lights"),
    /** Paint Scheme */
    PAINT_SCHEME (33200, "Paint Scheme"),
    /** Smoke */
    SMOKE (33300, "Smoke"),
    /** Trailing Effects */
    TRAILING_EFFECTS (33400, "Trailing Effects"),
    /** Flaming */
    FLAMING (33500, "Flaming"),
    /** Marking */
    MARKING (33600, "Marking"),
    /** Mine Plows Attached */
    MINE_PLOWS_ATTACHED (33710, "Mine Plows Attached"),
    /** Mine Rollers Attached */
    MINE_ROLLERS_ATTACHED (33720, "Mine Rollers Attached"),
    /** Tank Turret Azimuth */
    TANK_TURRET_AZIMUTH (33730, "Tank Turret Azimuth"),
    /** Failures and Malfunctions */
    FAILURES_AND_MALFUNCTIONS (34000, "Failures and Malfunctions"),
    /** Age */
    AGE (34100, "Age"),
    /** Kilometers */
    KILOMETERS (34110, "Kilometers"),
    /** Damage */
    DAMAGE (35000, "Damage"),
    /** Cause */
    CAUSE (35050, "Cause"),
    /** Mobility Kill */
    MOBILITY_KILL (35100, "Mobility Kill"),
    /** Fire-Power Kill */
    FIRE_POWER_KILL (35200, "Fire-Power Kill"),
    /** Personnel Casualties */
    PERSONNEL_CASUALTIES (35300, "Personnel Casualties"),
    /** Velocity */
    VELOCITY (36000, "Velocity"),
    /** X-velocity */
    X_VELOCITY (36100, "X-velocity"),
    /** Y-velocity */
    Y_VELOCITY (36200, "Y-velocity"),
    /** Z-velocity */
    Z_VELOCITY (36300, "Z-velocity"),
    /** Speed */
    SPEED (36400, "Speed"),
    /** Acceleration */
    ACCELERATION (37000, "Acceleration"),
    /** X-acceleration */
    X_ACCELERATION (37100, "X-acceleration"),
    /** Y-acceleration */
    Y_ACCELERATION (37200, "Y-acceleration"),
    /** Z-acceleration */
    Z_ACCELERATION (37300, "Z-acceleration"),
    /** Engine Status */
    ENGINE_STATUS (38100, "Engine Status"),
    /** Primary Target Line (PTL) */
    PRIMARY_TARGET_LINE_PTL (39000, "Primary Target Line (PTL)"),
    /** Exercise */
    EXERCISE (40000, "Exercise"),
    /** Exercise State */
    EXERCISE_STATE (40010, "Exercise State"),
    /** Restart/Refresh */
    RESTART_REFRESH (40015, "Restart/Refresh"),
    /** AFATDS File Name */
    AFATDS_FILE_NAME (40020, "AFATDS File Name"),
    /** Terrain Database */
    TERRAIN_DATABASE (41000, "Terrain Database"),
    /** Missions */
    MISSIONS (42000, "Missions"),
    /** Mission ID */
    MISSION_ID (42100, "Mission ID"),
    /** Mission Type */
    MISSION_TYPE (42200, "Mission Type"),
    /** Mission Request Time Stamp */
    MISSION_REQUEST_TIME_STAMP (42300, "Mission Request Time Stamp"),
    /** Exercise Description */
    EXERCISE_DESCRIPTION (43000, "Exercise Description"),
    /** Name */
    NAME (43100, "Name"),
    /** Entities */
    ENTITIES (43200, "Entities"),
    /** Version */
    VERSION (43300, "Version"),
    /** Guise Mode */
    GUISE_MODE (43410, "Guise Mode"),
    /** Simulation Application Active Status */
    SIMULATION_APPLICATION_ACTIVE_STATUS (43420, "Simulation Application Active Status"),
    /** Simulation Application Role Record */
    SIMULATION_APPLICATION_ROLE_RECORD (43430, "Simulation Application Role Record"),
    /** Simulation Application State */
    SIMULATION_APPLICATION_STATE (43440, "Simulation Application State"),
    /** Visual Output Mode */
    VISUAL_OUTPUT_MODE (44000, "Visual Output Mode"),
    /** Simulation Manager Role */
    SIMULATION_MANAGER_ROLE (44100, "Simulation Manager Role"),
    /** Simulation Manager Site ID */
    SIMULATION_MANAGER_SITE_ID (44110, "Simulation Manager Site ID"),
    /** Simulation Manager Applic. ID */
    SIMULATION_MANAGER_APPLIC_ID (44120, "Simulation Manager Applic. ID"),
    /** Simulation Manager Entity ID */
    SIMULATION_MANAGER_ENTITY_ID (44130, "Simulation Manager Entity ID"),
    /** Simulation Manager Active Status */
    SIMULATION_MANAGER_ACTIVE_STATUS (44140, "Simulation Manager Active Status"),
    /** After Active Review Role */
    AFTER_ACTIVE_REVIEW_ROLE (44200, "After Active Review Role"),
    /** After Active Review Site ID */
    AFTER_ACTIVE_REVIEW_SITE_ID (44210, "After Active Review Site ID"),
    /** After Active Applic. ID */
    AFTER_ACTIVE_APPLIC_ID (44220, "After Active Applic. ID"),
    /** After Active Review Entity ID */
    AFTER_ACTIVE_REVIEW_ENTITY_ID (44230, "After Active Review Entity ID"),
    /** After Active Review Active Status */
    AFTER_ACTIVE_REVIEW_ACTIVE_STATUS (44240, "After Active Review Active Status"),
    /** Exercise Logger Role */
    EXERCISE_LOGGER_ROLE (44300, "Exercise Logger Role"),
    /** Exercise Logger Site ID */
    EXERCISE_LOGGER_SITE_ID (44310, "Exercise Logger Site ID"),
    /** Exercise Logger Applic. ID */
    EXERCISE_LOGGER_APPLIC_ID (44320, "Exercise Logger Applic. ID"),
    /** Exercise Entity ID */
    EXERCISE_ENTITY_ID (44330, "Exercise Entity ID"),
    /** Exercise Logger Active Status */
    EXERCISE_LOGGER_ACTIVE_STATUS (44340, "Exercise Logger Active Status"),
    /** Synthetic Environment Manager Role */
    SYNTHETIC_ENVIRONMENT_MANAGER_ROLE (44400, "Synthetic Environment Manager Role"),
    /** Synthetic Environment Manager Site ID */
    SYNTHETIC_ENVIRONMENT_MANAGER_SITE_ID (44410, "Synthetic Environment Manager Site ID"),
    /** Synthetic Environment Manager Applic. ID */
    SYNTHETIC_ENVIRONMENT_MANAGER_APPLIC_ID (44420, "Synthetic Environment Manager Applic. ID"),
    /** Synthetic Environment Manager Entity ID */
    SYNTHETIC_ENVIRONMENT_MANAGER_ENTITY_ID (44430, "Synthetic Environment Manager Entity ID"),
    /** Synthetic Environment Manager Active Status */
    SYNTHETIC_ENVIRONMENT_MANAGER_ACTIVE_STATUS (44440, "Synthetic Environment Manager Active Status"),
    /** SIMNET-DIS Translator Role */
    SIMNET_DIS_TRANSLATOR_ROLE (44500, "SIMNET-DIS Translator Role"),
    /** SIMNET-DIS Translator Site ID */
    SIMNET_DIS_TRANSLATOR_SITE_ID (44510, "SIMNET-DIS Translator Site ID"),
    /** SIMNET-DIS Translator Applic. ID */
    SIMNET_DIS_TRANSLATOR_APPLIC_ID (44520, "SIMNET-DIS Translator Applic. ID"),
    /** SIMNET-DIS Translator Entity ID */
    SIMNET_DIS_TRANSLATOR_ENTITY_ID (44530, "SIMNET-DIS Translator Entity ID"),
    /** SIMNET-DIS Translator Active Status */
    SIMNET_DIS_TRANSLATOR_ACTIVE_STATUS (44540, "SIMNET-DIS Translator Active Status"),
    /** Application Rate */
    APPLICATION_RATE (45000, "Application Rate"),
    /** Application Time */
    APPLICATION_TIME (45005, "Application Time"),
    /** Application Timestep */
    APPLICATION_TIMESTEP (45010, "Application Timestep"),
    /** Feedback Time */
    FEEDBACK_TIME (45020, "Feedback Time"),
    /** Simulation Rate */
    SIMULATION_RATE (45030, "Simulation Rate"),
    /** Simulation Time */
    SIMULATION_TIME (45040, "Simulation Time"),
    /** Simulation Timestep */
    SIMULATION_TIMESTEP (45050, "Simulation Timestep"),
    /** Time Interval */
    TIME_INTERVAL (45060, "Time Interval"),
    /** Time Latency */
    TIME_LATENCY (45070, "Time Latency"),
    /** Time Scheme */
    TIME_SCHEME (45080, "Time Scheme"),
    /** Exercise Elapsed Time */
    EXERCISE_ELAPSED_TIME (46000, "Exercise Elapsed Time"),
    /** Elapsed Time */
    ELAPSED_TIME (46010, "Elapsed Time"),
    /** Environment */
    ENVIRONMENT (50000, "Environment"),
    /** Scenario Date */
    SCENARIO_DATE (50103, "Scenario Date"),
    /** Time and Date Valid */
    TIME_DATE_VALID (50106, "Time & Date Valid"),
    /** Scenario Time */
    SCENARIO_TIME (50118, "Scenario Time"),
    /** Snow Enable/Disable */
    SNOW_ENABLE_DISABLE (50120, "Snow Enable/Disable"),
    /** Weather Attributes Request */
    WEATHER_ATTRIBUTES_REQUEST (50124, "Weather Attributes Request"),
    /** MET Heartbeat Message */
    MET_HEARTBEAT_MESSAGE (50126, "MET Heartbeat Message"),
    /** Contrails Enable */
    CONTRAILS_ENABLE (50600, "Contrails Enable"),
    /** Contrail Altitudes */
    CONTRAIL_ALTITUDES (50700, "Contrail Altitudes"),
    /** Weather */
    WEATHER (51000, "Weather"),
    /** Weather Condition */
    WEATHER_CONDITION (51010, "Weather Condition"),
    /** Thermal Condition */
    THERMAL_CONDITION (51100, "Thermal Condition"),
    /** Thermal Visibility */
    THERMAL_VISIBILITY (51110, "Thermal Visibility"),
    /** Thermal Visibility */
    THERMAL_VISIBILITY_2 (51111, "Thermal Visibility"),
    /** Time */
    TIME (52000, "Time"),
    /** Time */
    TIME_2 (52001, "Time"),
    /** Time of Day, Discrete */
    TIME_OF_DAY_DISCRETE (52100, "Time of Day, Discrete"),
    /** Time of Day, Continuous */
    TIME_OF_DAY_CONTINUOUS (52200, "Time of Day, Continuous"),
    /** Time Mode */
    TIME_MODE (52300, "Time Mode"),
    /** Time Scene */
    TIME_SCENE (52305, "Time Scene"),
    /** Current Hour */
    CURRENT_HOUR (52310, "Current Hour"),
    /** Current Minute */
    CURRENT_MINUTE (52320, "Current Minute"),
    /** Current Second */
    CURRENT_SECOND (52330, "Current Second"),
    /** Azimuth */
    AZIMUTH (52340, "Azimuth"),
    /** Maximum Elevation */
    MAXIMUM_ELEVATION (52350, "Maximum Elevation"),
    /** Time Zone */
    TIME_ZONE (52360, "Time Zone"),
    /** Time Rate */
    TIME_RATE (52370, "Time Rate"),
    /** The number of simulation seconds since the start of the exercise (simulation time) */
    THE_NUMBER_OF_SIMULATION_SECONDS_SINCE_THE_START_OF_THE_EXERCISE_SIMULATION_TIME (52380, "The number of simulation seconds since the start of the exercise (simulation time)"),
    /** Time Sunrise Enabled */
    TIME_SUNRISE_ENABLED (52400, "Time Sunrise Enabled"),
    /** Sunrise Hour */
    SUNRISE_HOUR (52410, "Sunrise Hour"),
    /** Sunrise Minute */
    SUNRISE_MINUTE (52420, "Sunrise Minute"),
    /** Sunrise Second */
    SUNRISE_SECOND (52430, "Sunrise Second"),
    /** Sunrise Azimuth */
    SUNRISE_AZIMUTH (52440, "Sunrise Azimuth"),
    /** Time Sunset Enabled */
    TIME_SUNSET_ENABLED (52500, "Time Sunset Enabled"),
    /** Sunset Hour */
    SUNSET_HOUR (52510, "Sunset Hour"),
    /** Sunset Hour */
    SUNSET_HOUR_2 (52511, "Sunset Hour"),
    /** Sunset Minute */
    SUNSET_MINUTE (52520, "Sunset Minute"),
    /** Sunset Second */
    SUNSET_SECOND (52530, "Sunset Second"),
    /** Date */
    DATE (52600, "Date"),
    /** Date (European) */
    DATE_EUROPEAN (52601, "Date (European)"),
    /** Date (US) */
    DATE_US (52602, "Date (US)"),
    /** Month */
    MONTH (52610, "Month"),
    /** Day */
    DAY (52620, "Day"),
    /** Year */
    YEAR (52630, "Year"),
    /** Clouds */
    CLOUDS (53000, "Clouds"),
    /** Cloud Layer Enable */
    CLOUD_LAYER_ENABLE (53050, "Cloud Layer Enable"),
    /** Cloud Layer Selection */
    CLOUD_LAYER_SELECTION (53060, "Cloud Layer Selection"),
    /** Visibility */
    VISIBILITY (53100, "Visibility"),
    /** Base Altitude */
    BASE_ALTITUDE (53200, "Base Altitude"),
    /** Base Altitude */
    BASE_ALTITUDE_2 (53250, "Base Altitude"),
    /** Ceiling */
    CEILING (53300, "Ceiling"),
    /** Ceiling */
    CEILING_2 (53350, "Ceiling"),
    /** Characteristics */
    CHARACTERISTICS (53400, "Characteristics"),
    /** Concentration Length */
    CONCENTRATION_LENGTH (53410, "Concentration Length"),
    /** Transmittance */
    TRANSMITTANCE (53420, "Transmittance"),
    /** Radiance */
    RADIANCE (53430, "Radiance"),
    /** Precipitation */
    PRECIPITATION (54000, "Precipitation"),
    /** Rain */
    RAIN (54100, "Rain"),
    /** Fog */
    FOG (55000, "Fog"),
    /** Visibility */
    VISIBILITY_2 (55100, "Visibility"),
    /** Visibility */
    VISIBILITY_3 (55101, "Visibility"),
    /** Visibility */
    VISIBILITY_4 (55105, "Visibility"),
    /** Density */
    DENSITY (55200, "Density"),
    /** Base */
    BASE (55300, "Base"),
    /** View Layer from above. */
    VIEW_LAYER_FROM_ABOVE (55401, "View Layer from above."),
    /** Transition Range */
    TRANSITION_RANGE (55410, "Transition Range"),
    /** Bottom */
    BOTTOM (55420, "Bottom"),
    /** Bottom */
    BOTTOM_2 (55425, "Bottom"),
    /** Ceiling */
    CEILING_3 (55430, "Ceiling"),
    /** Ceiling */
    CEILING_4 (55435, "Ceiling"),
    /** Heavenly Bodies */
    HEAVENLY_BODIES (56000, "Heavenly Bodies"),
    /** Sun */
    SUN (56100, "Sun"),
    /** Sun Visible */
    SUN_VISIBLE (56105, "Sun Visible"),
    /** Position */
    POSITION_2 (56110, "Position"),
    /** Sun Position Elevation, Degrees */
    SUN_POSITION_ELEVATION_DEGREES (56111, "Sun Position Elevation, Degrees"),
    /** Position Azimuth */
    POSITION_AZIMUTH (56120, "Position Azimuth"),
    /** Sun Position Azimuth, Degrees */
    SUN_POSITION_AZIMUTH_DEGREES (56121, "Sun Position Azimuth, Degrees"),
    /** Position Elevation */
    POSITION_ELEVATION (56130, "Position Elevation"),
    /** Position Intensity */
    POSITION_INTENSITY (56140, "Position Intensity"),
    /** Moon */
    MOON (56200, "Moon"),
    /** Moon Visible */
    MOON_VISIBLE (56205, "Moon Visible"),
    /** Position */
    POSITION_3 (56210, "Position"),
    /** Position Azimuth */
    POSITION_AZIMUTH_2 (56220, "Position Azimuth"),
    /** Moon Position Azimuth, Degrees */
    MOON_POSITION_AZIMUTH_DEGREES (56221, "Moon Position Azimuth, Degrees"),
    /** Position Elevation */
    POSITION_ELEVATION_2 (56230, "Position Elevation"),
    /** Moon Position Elevation, Degrees */
    MOON_POSITION_ELEVATION_DEGREES (56231, "Moon Position Elevation, Degrees"),
    /** Position Intensity */
    POSITION_INTENSITY_2 (56240, "Position Intensity"),
    /** Horizon */
    HORIZON (56310, "Horizon"),
    /** Horizon Azimuth */
    HORIZON_AZIMUTH (56320, "Horizon Azimuth"),
    /** Horizon Elevation */
    HORIZON_ELEVATION (56330, "Horizon Elevation"),
    /** Horizon Heading */
    HORIZON_HEADING (56340, "Horizon Heading"),
    /** Horizon Intensity */
    HORIZON_INTENSITY (56350, "Horizon Intensity"),
    /** Humidity */
    HUMIDITY (57200, "Humidity"),
    /** Visibility */
    VISIBILITY_5 (57300, "Visibility"),
    /** Winds */
    WINDS (57400, "Winds"),
    /** Speed */
    SPEED_2 (57410, "Speed"),
    /** Wind Speed, Knots */
    WIND_SPEED_KNOTS (57411, "Wind Speed, Knots"),
    /** Wind Direction */
    WIND_DIRECTION (57420, "Wind Direction"),
    /** Wind Direction, Degrees */
    WIND_DIRECTION_DEGREES (57421, "Wind Direction, Degrees"),
    /** Rainsoak */
    RAINSOAK (57500, "Rainsoak"),
    /** Tide Speed */
    TIDE_SPEED (57610, "Tide Speed"),
    /** Tide Speed, Knots */
    TIDE_SPEED_KNOTS (57611, "Tide Speed, Knots"),
    /** Tide Direction */
    TIDE_DIRECTION (57620, "Tide Direction"),
    /** Tide Direction, Degrees */
    TIDE_DIRECTION_DEGREES (57621, "Tide Direction, Degrees"),
    /** Haze */
    HAZE (58000, "Haze"),
    /** Visibility */
    VISIBILITY_6 (58100, "Visibility"),
    /** Visibility */
    VISIBILITY_7 (58105, "Visibility"),
    /** Density */
    DENSITY_2 (58200, "Density"),
    /** Ceiling */
    CEILING_5 (58430, "Ceiling"),
    /** Ceiling */
    CEILING_6 (58435, "Ceiling"),
    /** Contaminants and Obscurants */
    CONTAMINANTS_AND_OBSCURANTS (59000, "Contaminants and Obscurants"),
    /** Contaminant/Obscurant Type */
    CONTAMINANT_OBSCURANT_TYPE (59100, "Contaminant/Obscurant Type"),
    /** Persistence */
    PERSISTENCE (59110, "Persistence"),
    /** Chemical Dosage */
    CHEMICAL_DOSAGE (59115, "Chemical Dosage"),
    /** Chemical Air Concentration */
    CHEMICAL_AIR_CONCENTRATION (59120, "Chemical Air Concentration"),
    /** Chemical Ground Deposition */
    CHEMICAL_GROUND_DEPOSITION (59125, "Chemical Ground Deposition"),
    /** Chemical Maximum Ground Deposition */
    CHEMICAL_MAXIMUM_GROUND_DEPOSITION (59130, "Chemical Maximum Ground Deposition"),
    /** Chemical Dosage Threshold */
    CHEMICAL_DOSAGE_THRESHOLD (59135, "Chemical Dosage Threshold"),
    /** Biological Dosage */
    BIOLOGICAL_DOSAGE (59140, "Biological Dosage"),
    /** Biological Air Concentration */
    BIOLOGICAL_AIR_CONCENTRATION (59145, "Biological Air Concentration"),
    /** Biological Dosage Threshold */
    BIOLOGICAL_DOSAGE_THRESHOLD (59150, "Biological Dosage Threshold"),
    /** Biological Binned Particle Count */
    BIOLOGICAL_BINNED_PARTICLE_COUNT (59155, "Biological Binned Particle Count"),
    /** Radiological Dosage */
    RADIOLOGICAL_DOSAGE (59160, "Radiological Dosage"),
    /** Communications */
    COMMUNICATIONS (60000, "Communications"),
    /** Fire Bottle Reload */
    FIRE_BOTTLE_RELOAD (61005, "Fire Bottle Reload"),
    /** Channel Type */
    CHANNEL_TYPE (61100, "Channel Type"),
    /** Channel Type */
    CHANNEL_TYPE_2 (61101, "Channel Type"),
    /** Channel Identification */
    CHANNEL_IDENTIFICATION (61200, "Channel Identification"),
    /** Alpha Identification */
    ALPHA_IDENTIFICATION (61300, "Alpha Identification"),
    /** Radio Identification */
    RADIO_IDENTIFICATION (61400, "Radio Identification"),
    /** Land Line Identification */
    LAND_LINE_IDENTIFICATION (61500, "Land Line Identification"),
    /** Intercom Identification */
    INTERCOM_IDENTIFICATION (61600, "Intercom Identification"),
    /** Group Network Channel Number */
    GROUP_NETWORK_CHANNEL_NUMBER (61700, "Group Network Channel Number"),
    /** Radio Communications Status */
    RADIO_COMMUNICATIONS_STATUS (62100, "Radio Communications Status"),
    /** Boom Interphone */
    BOOM_INTERPHONE (62101, "Boom Interphone"),
    /** Stationary Radio Transmitters Default Time */
    STATIONARY_RADIO_TRANSMITTERS_DEFAULT_TIME (62200, "Stationary Radio Transmitters Default Time"),
    /** Moving Radio Transmitters Default Time */
    MOVING_RADIO_TRANSMITTERS_DEFAULT_TIME (62300, "Moving Radio Transmitters Default Time"),
    /** Stationary Radio Signals Default Time */
    STATIONARY_RADIO_SIGNALS_DEFAULT_TIME (62400, "Stationary Radio Signals Default Time"),
    /** Moving Radio Signal Default Time */
    MOVING_RADIO_SIGNAL_DEFAULT_TIME (62500, "Moving Radio Signal Default Time"),
    /** Radio Initialization Transec Security Key */
    RADIO_INITIALIZATION_TRANSEC_SECURITY_KEY (63101, "Radio Initialization Transec Security Key"),
    /** Radio Initialization Internal Noise Level */
    RADIO_INITIALIZATION_INTERNAL_NOISE_LEVEL (63102, "Radio Initialization Internal Noise Level"),
    /** Radio Initialization Squelch Threshold */
    RADIO_INITIALIZATION_SQUELCH_THRESHOLD (63103, "Radio Initialization Squelch Threshold"),
    /** Radio Initialization Antenna Location */
    RADIO_INITIALIZATION_ANTENNA_LOCATION (63104, "Radio Initialization Antenna Location"),
    /** Radio Initialization Antenna Pattern Type */
    RADIO_INITIALIZATION_ANTENNA_PATTERN_TYPE (63105, "Radio Initialization Antenna Pattern Type"),
    /** Radio Initialization Antenna Pattern Length */
    RADIO_INITIALIZATION_ANTENNA_PATTERN_LENGTH (63106, "Radio Initialization Antenna Pattern Length"),
    /** Radio Initialization Beam Definition */
    RADIO_INITIALIZATION_BEAM_DEFINITION (63107, "Radio Initialization Beam Definition"),
    /** Radio Initialization Transmit Heartbeat Time */
    RADIO_INITIALIZATION_TRANSMIT_HEARTBEAT_TIME (63108, "Radio Initialization Transmit Heartbeat Time"),
    /** Radio Initialization Transmit Distance Threshold Variable Record */
    RADIO_INITIALIZATION_TRANSMIT_DISTANCE_THRESHOLD_VARIABLE_RECORD (63109, "Radio Initialization Transmit Distance Threshold Variable Record"),
    /** Radio Channel Initialization Lockout ID */
    RADIO_CHANNEL_INITIALIZATION_LOCKOUT_ID (63110, "Radio Channel Initialization Lockout ID"),
    /** Radio Channel Initialization Hopset ID */
    RADIO_CHANNEL_INITIALIZATION_HOPSET_ID (63111, "Radio Channel Initialization Hopset ID"),
    /** Radio Channel Initialization Preset Frequency */
    RADIO_CHANNEL_INITIALIZATION_PRESET_FREQUENCY (63112, "Radio Channel Initialization Preset Frequency"),
    /** Radio Channel Initialization Frequency Sync Time */
    RADIO_CHANNEL_INITIALIZATION_FREQUENCY_SYNC_TIME (63113, "Radio Channel Initialization Frequency Sync Time"),
    /** Radio Channel Initialization Comsec Key */
    RADIO_CHANNEL_INITIALIZATION_COMSEC_KEY (63114, "Radio Channel Initialization Comsec Key"),
    /** Radio Channel Initialization Alpha */
    RADIO_CHANNEL_INITIALIZATION_ALPHA (63115, "Radio Channel Initialization Alpha"),
    /** Algorithm Parameters */
    ALGORITHM_PARAMETERS (70000, "Algorithm Parameters"),
    /** Dead Reckoning Algorithm (DRA) */
    DEAD_RECKONING_ALGORITHM_DRA (71000, "Dead Reckoning Algorithm (DRA)"),
    /** DRA Location Threshold */
    DRA_LOCATION_THRESHOLD (71100, "DRA Location Threshold"),
    /** DRA Orientation Threshold */
    DRA_ORIENTATION_THRESHOLD (71200, "DRA Orientation Threshold"),
    /** DRA Time Threshold */
    DRA_TIME_THRESHOLD (71300, "DRA Time Threshold"),
    /** Simulation Management Parameters */
    SIMULATION_MANAGEMENT_PARAMETERS (72000, "Simulation Management Parameters"),
    /** Checkpoint Interval */
    CHECKPOINT_INTERVAL (72100, "Checkpoint Interval"),
    /** Transmitter Time Threshold */
    TRANSMITTER_TIME_THRESHOLD (72600, "Transmitter Time Threshold"),
    /** Receiver Time Threshold */
    RECEIVER_TIME_THRESHOLD (72700, "Receiver Time Threshold"),
    /** Interoperability Mode */
    INTEROPERABILITY_MODE (73000, "Interoperability Mode"),
    /** SIMNET Data Collection, The variable-datum-value field consists of:32-bit unsigned integer, Data Collection Type; 32-bit unused; and multiple of 64 bits, SIMNET Data Collection Variant. */
    SIMNET_DATA_COLLECTION (74000, "SIMNET Data Collection"),
    /** Event ID */
    EVENT_ID (75000, "Event ID"),
    /** Source Site ID */
    SOURCE_SITE_ID (75100, "Source Site ID"),
    /** Source Host ID */
    SOURCE_HOST_ID (75200, "Source Host ID"),
    /** Articulated Parts */
    ARTICULATED_PARTS (90000, "Articulated Parts"),
    /** Part ID */
    PART_ID (90050, "Part ID"),
    /** EntityCapabilityTypes */    INDEX_2 (90070, "Index"),
    /** Position */
    POSITION_4 (90100, "Position"),
    /** Position Rate */
    POSITION_RATE (90200, "Position Rate"),
    /** Extension */
    EXTENSION (90300, "Extension"),
    /** Extension Rate */
    EXTENSION_RATE (90400, "Extension Rate"),
    /** X */
    X_4 (90500, "X"),
    /** X-rate */
    X_RATE (90600, "X-rate"),
    /** Y */
    Y_4 (90700, "Y"),
    /** Y-rate */
    Y_RATE (90800, "Y-rate"),
    /** Z */
    Z_4 (90900, "Z"),
    /** Z-rate */
    Z_RATE (91000, "Z-rate"),
    /** Azimuth */
    AZIMUTH_2 (91100, "Azimuth"),
    /** Azimuth Rate */
    AZIMUTH_RATE (91200, "Azimuth Rate"),
    /** Elevation */
    ELEVATION (91300, "Elevation"),
    /** Elevation Rate */
    ELEVATION_RATE (91400, "Elevation Rate"),
    /** Rotation */
    ROTATION (91500, "Rotation"),
    /** Rotation Rate */
    ROTATION_RATE (91600, "Rotation Rate"),
    /** DRA Angular X-Velocity */
    DRA_ANGULAR_X_VELOCITY (100001, "DRA Angular X-Velocity"),
    /** DRA Angular Y-Velocity */
    DRA_ANGULAR_Y_VELOCITY (100002, "DRA Angular Y-Velocity"),
    /** DRA Angular Z-Velocity */
    DRA_ANGULAR_Z_VELOCITY (100003, "DRA Angular Z-Velocity"),
    /** Appearance, Trailing Effects */
    APPEARANCE_TRAILING_EFFECTS (100004, "Appearance, Trailing Effects"),
    /** Appearance, Hatch */
    APPEARANCE_HATCH (100005, "Appearance, Hatch"),
    /** Appearance, Character Set */
    APPEARANCE_CHARACTER_SET (100008, "Appearance, Character Set"),
    /** Capability, Ammunition Supplier */
    CAPABILITY_AMMUNITION_SUPPLIER (100010, "Capability, Ammunition Supplier"),
    /** Capability, Miscellaneous Supplier */
    CAPABILITY_MISCELLANEOUS_SUPPLIER (100011, "Capability, Miscellaneous Supplier"),
    /** Capability, Repair Provider */
    CAPABILITY_REPAIR_PROVIDER (100012, "Capability, Repair Provider"),
    /** Articulation Parameter */
    ARTICULATION_PARAMETER (100014, "Articulation Parameter"),
    /** Articulation Parameter Type */
    ARTICULATION_PARAMETER_TYPE (100047, "Articulation Parameter Type"),
    /** Articulation Parameter Value */
    ARTICULATION_PARAMETER_VALUE (100048, "Articulation Parameter Value"),
    /** Time of Day-Scene */
    TIME_OF_DAY_SCENE (100058, "Time of Day-Scene"),
    /** Latitude-North (Location of weather cell) */
    LATITUDE_NORTH_LOCATION_OF_WEATHER_CELL (100061, "Latitude-North (Location of weather cell)"),
    /** Longitude-East (Location of weather cell) */
    LONGITUDE_EAST_LOCATION_OF_WEATHER_CELL (100063, "Longitude-East (Location of weather cell)"),
    /** Tactical Driver Status */
    TACTICAL_DRIVER_STATUS (100068, "Tactical Driver Status"),
    /** Sonar System Status */
    SONAR_SYSTEM_STATUS (100100, "Sonar System Status"),
    /** Upper latitude */
    UPPER_LATITUDE (100161, "Upper latitude"),
    /** Latitude-South (Location of weather cell) */
    LATITUDE_SOUTH_LOCATION_OF_WEATHER_CELL (100162, "Latitude-South (Location of weather cell)"),
    /** Western longitude */
    WESTERN_LONGITUDE (100163, "Western longitude"),
    /** Longitude-West (location of weather cell) */
    LONGITUDE_WEST_LOCATION_OF_WEATHER_CELL (100164, "Longitude-West (location of weather cell)"),
    /** Accomplished accept */
    ACCOMPLISHED_ACCEPT (100160, "Accomplished accept"),
    /** CD ROM Number (Disk ID for terrain) */
    CD_ROM_NUMBER_DISK_ID_FOR_TERRAIN (100165, "CD ROM Number (Disk ID for terrain)"),
    /** DTED disk ID */
    DTED_DISK_ID (100166, "DTED disk ID"),
    /** Altitude */
    ALTITUDE_2 (100167, "Altitude"),
    /** Tactical System Status */
    TACTICAL_SYSTEM_STATUS (100169, "Tactical System Status"),
    /** JTIDS Status */
    JTIDS_STATUS (100170, "JTIDS Status"),
    /** TADIL-J Status */
    TADIL_J_STATUS (100171, "TADIL-J Status"),
    /** DSDD Status */
    DSDD_STATUS (100172, "DSDD Status"),
    /** Weapon System Status */
    WEAPON_SYSTEM_STATUS (100200, "Weapon System Status"),
    /** Subsystem status */
    SUBSYSTEM_STATUS (100205, "Subsystem status"),
    /** Number of interceptors fired */
    NUMBER_OF_INTERCEPTORS_FIRED (100206, "Number of interceptors fired"),
    /** Number of interceptor detonations */
    NUMBER_OF_INTERCEPTOR_DETONATIONS (100207, "Number of interceptor detonations"),
    /** Number of message buffers dropped */
    NUMBER_OF_MESSAGE_BUFFERS_DROPPED (100208, "Number of message buffers dropped"),
    /** Satellite sensor background (year, day) */
    SATELLITE_SENSOR_BACKGROUND_YEAR_DAY (100213, "Satellite sensor background (year, day)"),
    /** Satellite sensor background (hour, minute) */
    SATELLITE_SENSOR_BACKGROUND_HOUR_MINUTE (100214, "Satellite sensor background (hour, minute)"),
    /** Script Number */
    SCRIPT_NUMBER (100218, "Script Number"),
    /** Entity/Track/Update Data */
    ENTITY_TRACK_UPDATE_DATA (100300, "Entity/Track/Update Data"),
    /** Local/Force Training */
    LOCAL_FORCE_TRAINING (100400, "Local/Force Training"),
    /** Entity/Track Identity Data */
    ENTITY_TRACK_IDENTITY_DATA (100500, "Entity/Track Identity Data"),
    /** Entity for Track Event */
    ENTITY_FOR_TRACK_EVENT (100510, "Entity for Track Event"),
    /** IFF (Friend-Foe) status */
    IFF_FRIEND_FOE_STATUS (100520, "IFF (Friend-Foe) status"),
    /** Engagement Data */
    ENGAGEMENT_DATA (100600, "Engagement Data"),
    /** Target Latitude */
    TARGET_LATITUDE (100610, "Target Latitude"),
    /** Target Longitude */
    TARGET_LONGITUDE (100620, "Target Longitude"),
    /** Area of Interest (Ground Impact Circle) Center Latitude */
    AREA_OF_INTEREST_GROUND_IMPACT_CIRCLE_CENTER_LATITUDE (100631, "Area of Interest (Ground Impact Circle) Center Latitude"),
    /** Area of Interest (Ground Impact Circle) Center Longitude */
    AREA_OF_INTEREST_GROUND_IMPACT_CIRCLE_CENTER_LONGITUDE (100632, "Area of Interest (Ground Impact Circle) Center Longitude"),
    /** Area of Interest (Ground Impact Circle) Radius */
    AREA_OF_INTEREST_GROUND_IMPACT_CIRCLE_RADIUS (100633, "Area of Interest (Ground Impact Circle) Radius"),
    /** Area of Interest Type */
    AREA_OF_INTEREST_TYPE (100634, "Area of Interest Type"),
    /** Target Aggregate ID */
    TARGET_AGGREGATE_ID (100640, "Target Aggregate ID"),
    /** GIC Identification Number */
    GIC_IDENTIFICATION_NUMBER (100650, "GIC Identification Number"),
    /** Estimated Time of Flight to TBM Impact */
    ESTIMATED_TIME_OF_FLIGHT_TO_TBM_IMPACT (100660, "Estimated Time of Flight to TBM Impact"),
    /** Estimated Intercept Time */
    ESTIMATED_INTERCEPT_TIME (100661, "Estimated Intercept Time"),
    /** Estimated Time of Flight to Next Waypoint */
    ESTIMATED_TIME_OF_FLIGHT_TO_NEXT_WAYPOINT (100662, "Estimated Time of Flight to Next Waypoint"),
    /** Entity/Track Equipment Data */
    ENTITY_TRACK_EQUIPMENT_DATA (100700, "Entity/Track Equipment Data"),
    /** Emission/EW Data */
    EMISSION_EW_DATA (100800, "Emission/EW Data"),
    /** Appearance Data */
    APPEARANCE_DATA (100900, "Appearance Data"),
    /** Command/Order Data */
    COMMAND_ORDER_DATA (101000, "Command/Order Data"),
    /** Environmental Data */
    ENVIRONMENTAL_DATA (101100, "Environmental Data"),
    /** Significant Event Data */
    SIGNIFICANT_EVENT_DATA (101200, "Significant Event Data"),
    /** Operator Action Data */
    OPERATOR_ACTION_DATA (101300, "Operator Action Data"),
    /** ADA Engagement Mode */
    ADA_ENGAGEMENT_MODE (101310, "ADA Engagement Mode"),
    /** ADA Shooting Status */
    ADA_SHOOTING_STATUS (101320, "ADA Shooting Status"),
    /** ADA Mode */
    ADA_MODE (101321, "ADA Mode"),
    /** ADA Radar Status */
    ADA_RADAR_STATUS (101330, "ADA Radar Status"),
    /** Shoot Command */
    SHOOT_COMMAND (101340, "Shoot Command"),
    /** ADA Weapon Status */
    ADA_WEAPON_STATUS (101350, "ADA Weapon Status"),
    /** ADA Firing Disciple */
    ADA_FIRING_DISCIPLE (101360, "ADA Firing Disciple"),
    /** Order Status */
    ORDER_STATUS (101370, "Order Status"),
    /** Time Synchronization */
    TIME_SYNCHRONIZATION (101400, "Time Synchronization"),
    /** Tomahawk Data */
    TOMAHAWK_DATA (101500, "Tomahawk Data"),
    /** Number of Detonations */
    NUMBER_OF_DETONATIONS (102100, "Number of Detonations"),
    /** Number of Intercepts */
    NUMBER_OF_INTERCEPTS (102200, "Number of Intercepts"),
    /** OBT Control MT-201 */
    OBT_CONTROL_MT_201 (200201, "OBT Control MT-201"),
    /** Sensor Data MT-202 */
    SENSOR_DATA_MT_202 (200202, "Sensor Data MT-202"),
    /** Environmental Data MT-203 */
    ENVIRONMENTAL_DATA_MT_203 (200203, "Environmental Data MT-203"),
    /** Ownship Data MT-204 */
    OWNSHIP_DATA_MT_204 (200204, "Ownship Data MT-204"),
    /** Acoustic Contact Data MT-205 */
    ACOUSTIC_CONTACT_DATA_MT_205 (200205, "Acoustic Contact Data MT-205"),
    /** Sonobuoy Data MT-207 */
    SONOBUOY_DATA_MT_207 (200207, "Sonobuoy Data MT-207"),
    /** Sonobuoy Contact Data MT-210 */
    SONOBUOY_CONTACT_DATA_MT_210 (200210, "Sonobuoy Contact Data MT-210"),
    /** Helo Control MT-211 */
    HELO_CONTROL_MT_211 (200211, "Helo Control MT-211"),
    /** ESM Control Data */
    ESM_CONTROL_DATA (200213, "ESM Control Data"),
    /** ESM Contact Data MT-214 */
    ESM_CONTACT_DATA_MT_214 (200214, "ESM Contact Data MT-214"),
    /** ESM Emitter Data MT-215 */
    ESM_EMITTER_DATA_MT_215 (200215, "ESM Emitter Data MT-215"),
    /** Weapon Definition Data MT-217 */
    WEAPON_DEFINITION_DATA_MT_217 (200216, "Weapon Definition Data MT-217"),
    /** Weapon Preset Data MT-217 */
    WEAPON_PRESET_DATA_MT_217 (200217, "Weapon Preset Data MT-217"),
    /** OBT Control MT-301 */
    OBT_CONTROL_MT_301 (200301, "OBT Control MT-301"),
    /** Sensor Data MT-302 */
    SENSOR_DATA_MT_302 (200302, "Sensor Data MT-302"),
    /** Environmental Data MT-303m */
    ENVIRONMENTAL_DATA_MT_303M (200303, "Environmental Data MT-303m"),
    /** Ownship Data MT-304 */
    OWNSHIP_DATA_MT_304 (200304, "Ownship Data MT-304"),
    /** Acoustic Contact Data MT-305 */
    ACOUSTIC_CONTACT_DATA_MT_305 (200305, "Acoustic Contact Data MT-305"),
    /** Sonobuoy Data MT-307 */
    SONOBUOY_DATA_MT_307 (200307, "Sonobuoy Data MT-307"),
    /** Sonobuoy Contact Data MT-310 */
    SONOBUOY_CONTACT_DATA_MT_310 (200310, "Sonobuoy Contact Data MT-310"),
    /** Helo Scenario / Equipment Status */
    HELO_SCENARIO_EQUIPMENT_STATUS (200311, "Helo Scenario / Equipment Status"),
    /** ESM Control Data MT-313 */
    ESM_CONTROL_DATA_MT_313 (200313, "ESM Control Data MT-313"),
    /** ESM Contact Data MT-314 */
    ESM_CONTACT_DATA_MT_314 (200314, "ESM Contact Data MT-314"),
    /** ESM Emitter Data MT-315 */
    ESM_EMITTER_DATA_MT_315 (200315, "ESM Emitter Data MT-315"),
    /** Weapon Definition Data MT-316 */
    WEAPON_DEFINITION_DATA_MT_316 (200316, "Weapon Definition Data MT-316"),
    /** Weapon Preset Data MT-317 */
    WEAPON_PRESET_DATA_MT_317 (200317, "Weapon Preset Data MT-317"),
    /** Pairing/Association (eMT-56) */
    PAIRING_ASSOCIATION_EMT_56 (200400, "Pairing/Association (eMT-56)"),
    /** Pointer (eMT-57) */
    POINTER_EMT_57 (200401, "Pointer (eMT-57)"),
    /** Reporting Responsibility (eMT-58) */
    REPORTING_RESPONSIBILITY_EMT_58 (200402, "Reporting Responsibility (eMT-58)"),
    /** Track Number (eMT-59) */
    TRACK_NUMBER_EMT_59 (200403, "Track Number (eMT-59)"),
    /** ID for Link-11 Reporting (eMT-60) */
    ID_FOR_LINK_11_REPORTING_EMT_60 (200404, "ID for Link-11 Reporting (eMT-60)"),
    /** Remote Track (eMT-62) */
    REMOTE_TRACK_EMT_62 (200405, "Remote Track (eMT-62)"),
    /** Link-11 Error Rate (eMT-63) */
    LINK_11_ERROR_RATE_EMT_63 (200406, "Link-11 Error Rate (eMT-63)"),
    /** Track Quality (eMT-64) */
    TRACK_QUALITY_EMT_64 (200407, "Track Quality (eMT-64)"),
    /** Gridlock (eMT-65) */
    GRIDLOCK_EMT_65 (200408, "Gridlock (eMT-65)"),
    /** Kill (eMT-66) */
    KILL_EMT_66 (200409, "Kill (eMT-66)"),
    /** Track ID Change / Resolution (eMT-68) */
    TRACK_ID_CHANGE_RESOLUTION_EMT_68 (200410, "Track ID Change / Resolution (eMT-68)"),
    /** Weapons Status (eMT-69) */
    WEAPONS_STATUS_EMT_69 (200411, "Weapons Status (eMT-69)"),
    /** Link-11 Operator (eMT-70) */
    LINK_11_OPERATOR_EMT_70 (200412, "Link-11 Operator (eMT-70)"),
    /** Force Training Transmit (eMT-71) */
    FORCE_TRAINING_TRANSMIT_EMT_71 (200413, "Force Training Transmit (eMT-71)"),
    /** Force Training Receive (eMT-72) */
    FORCE_TRAINING_RECEIVE_EMT_72 (200414, "Force Training Receive (eMT-72)"),
    /** Interceptor Amplification (eMT-75) */
    INTERCEPTOR_AMPLIFICATION_EMT_75 (200415, "Interceptor Amplification (eMT-75)"),
    /** Consumables (eMT-78) */
    CONSUMABLES_EMT_78 (200416, "Consumables (eMT-78)"),
    /** Link-11 Local Track Quality (eMT-95) */
    LINK_11_LOCAL_TRACK_QUALITY_EMT_95 (200417, "Link-11 Local Track Quality (eMT-95)"),
    /** DLRP (eMT-19) */
    DLRP_EMT_19 (200418, "DLRP (eMT-19)"),
    /** Force Order (eMT-52) */
    FORCE_ORDER_EMT_52 (200419, "Force Order (eMT-52)"),
    /** Wilco / Cantco (eMT-53) */
    WILCO_CANTCO_EMT_53 (200420, "Wilco / Cantco (eMT-53)"),
    /** EMC Bearing (eMT-54) */
    EMC_BEARING_EMT_54 (200421, "EMC Bearing (eMT-54)"),
    /** Change Track Eligibility (eMT-55) */
    CHANGE_TRACK_ELIGIBILITY_EMT_55 (200422, "Change Track Eligibility (eMT-55)"),
    /** Land Mass Reference Point */
    LAND_MASS_REFERENCE_POINT (200423, "Land Mass Reference Point"),
    /** System Reference Point */
    SYSTEM_REFERENCE_POINT (200424, "System Reference Point"),
    /** PU Amplification */
    PU_AMPLIFICATION (200425, "PU Amplification"),
    /** Set/Drift */
    SET_DRIFT (200426, "Set/Drift"),
    /** Begin Initialization (MT-1) */
    BEGIN_INITIALIZATION_MT_1 (200427, "Begin Initialization (MT-1)"),
    /** Status and Control (MT-3) */
    STATUS_AND_CONTROL_MT_3 (200428, "Status and Control (MT-3)"),
    /** Scintillation Change (MT-39) */
    SCINTILLATION_CHANGE_MT_39 (200429, "Scintillation Change (MT-39)"),
    /** Link 11 ID Control (MT-61) */
    LINK_11_ID_CONTROL_MT_61 (200430, "Link 11 ID Control (MT-61)"),
    /** PU Guard List */
    PU_GUARD_LIST (200431, "PU Guard List"),
    /** Winds Aloft (MT-14) */
    WINDS_ALOFT_MT_14 (200432, "Winds Aloft (MT-14)"),
    /** Surface Winds (MT-15) */
    SURFACE_WINDS_MT_15 (200433, "Surface Winds (MT-15)"),
    /** Sea State (MT-17) */
    SEA_STATE_MT_17 (200434, "Sea State (MT-17)"),
    /** Magnetic Variation (MT-37) */
    MAGNETIC_VARIATION_MT_37 (200435, "Magnetic Variation (MT-37)"),
    /** Track Eligibility (MT-29) */
    TRACK_ELIGIBILITY_MT_29 (200436, "Track Eligibility (MT-29)"),
    /** Training Track Notification */
    TRAINING_TRACK_NOTIFICATION (200437, "Training Track Notification"),
    /** Tacan Data (MT-32) */
    TACAN_DATA_MT_32 (200501, "Tacan Data (MT-32)"),
    /** Interceptor Amplification (MT-75) */
    INTERCEPTOR_AMPLIFICATION_MT_75 (200502, "Interceptor Amplification (MT-75)"),
    /** Tacan Assignment (MT-76) */
    TACAN_ASSIGNMENT_MT_76 (200503, "Tacan Assignment (MT-76)"),
    /** Autopilot Status (MT-77) */
    AUTOPILOT_STATUS_MT_77 (200504, "Autopilot Status (MT-77)"),
    /** Consumables (MT-78) */
    CONSUMABLES_MT_78 (200505, "Consumables (MT-78)"),
    /** Downlink (MT-79) */
    DOWNLINK_MT_79 (200506, "Downlink (MT-79)"),
    /** TIN Report (MT-80) */
    TIN_REPORT_MT_80 (200507, "TIN Report (MT-80)"),
    /** Special Point Control (MT-81) */
    SPECIAL_POINT_CONTROL_MT_81 (200508, "Special Point Control (MT-81)"),
    /** Control Discretes (MT-82) */
    CONTROL_DISCRETES_MT_82 (200509, "Control Discretes (MT-82)"),
    /** Request Target Discretes(MT-83) */
    REQUEST_TARGET_DISCRETESMT_83 (200510, "Request Target Discretes(MT-83)"),
    /** Target Discretes (MT-84) */
    TARGET_DISCRETES_MT_84 (200511, "Target Discretes (MT-84)"),
    /** Reply Discretes (MT-85) */
    REPLY_DISCRETES_MT_85 (200512, "Reply Discretes (MT-85)"),
    /** Command Maneuvers (MT-86) */
    COMMAND_MANEUVERS_MT_86 (200513, "Command Maneuvers (MT-86)"),
    /** Target Data (MT-87) */
    TARGET_DATA_MT_87 (200514, "Target Data (MT-87)"),
    /** Target Pointer (MT-88) */
    TARGET_POINTER_MT_88 (200515, "Target Pointer (MT-88)"),
    /** Intercept Data (MT-89) */
    INTERCEPT_DATA_MT_89 (200516, "Intercept Data (MT-89)"),
    /** Decrement Missile Inventory (MT-90) */
    DECREMENT_MISSILE_INVENTORY_MT_90 (200517, "Decrement Missile Inventory (MT-90)"),
    /** Link-4A Alert (MT-91) */
    LINK_4A_ALERT_MT_91 (200518, "Link-4A Alert (MT-91)"),
    /** Strike Control (MT-92) */
    STRIKE_CONTROL_MT_92 (200519, "Strike Control (MT-92)"),
    /** Speed Change (MT-25) */
    SPEED_CHANGE_MT_25 (200521, "Speed Change (MT-25)"),
    /** Course Change (MT-26) */
    COURSE_CHANGE_MT_26 (200522, "Course Change (MT-26)"),
    /** Altitude Change (MT-27) */
    ALTITUDE_CHANGE_MT_27 (200523, "Altitude Change (MT-27)"),
    /** ACLS AN/SPN-46 Status */
    ACLS_AN_SPN_46_STATUS (200524, "ACLS AN/SPN-46 Status"),
    /** ACLS Aircraft Report */
    ACLS_AIRCRAFT_REPORT (200525, "ACLS Aircraft Report"),
    /** SPS-67 Radar Operator Functions */
    SPS_67_RADAR_OPERATOR_FUNCTIONS (200600, "SPS-67 Radar Operator Functions"),
    /** SPS-55 Radar Operator Functions */
    SPS_55_RADAR_OPERATOR_FUNCTIONS (200601, "SPS-55 Radar Operator Functions"),
    /** SPQ-9A Radar Operator Functions */
    SPQ_9A_RADAR_OPERATOR_FUNCTIONS (200602, "SPQ-9A Radar Operator Functions"),
    /** SPS-49 Radar Operator Functions */
    SPS_49_RADAR_OPERATOR_FUNCTIONS (200603, "SPS-49 Radar Operator Functions"),
    /** MK-23 Radar Operator Functions */
    MK_23_RADAR_OPERATOR_FUNCTIONS (200604, "MK-23 Radar Operator Functions"),
    /** SPS-48 Radar Operator Functions */
    SPS_48_RADAR_OPERATOR_FUNCTIONS (200605, "SPS-48 Radar Operator Functions"),
    /** SPS-40 Radar Operator Functions */
    SPS_40_RADAR_OPERATOR_FUNCTIONS (200606, "SPS-40 Radar Operator Functions"),
    /** MK-95 Radar Operator Functions */
    MK_95_RADAR_OPERATOR_FUNCTIONS (200607, "MK-95 Radar Operator Functions"),
    /** Kill/No Kill */
    KILL_NO_KILL (200608, "Kill/No Kill"),
    /** CMT pc */
    CMT_PC (200609, "CMT pc"),
    /** CMC4AirGlobalData */
    CMC4AIRGLOBALDATA (200610, "CMC4AirGlobalData"),
    /** CMC4GlobalData */
    CMC4GLOBALDATA (200611, "CMC4GlobalData"),
    /** LINKSIM_COMMENT_PDU */
    LINKSIM_COMMENT_PDU (200612, "LINKSIM_COMMENT_PDU"),
    /** NSST Ownship Control */
    NSST_OWNSHIP_CONTROL (200613, "NSST Ownship Control"),
    /** Other */
    OTHER (240000, "Other"),
    /** Mass Of The Vehicle */
    MASS_OF_THE_VEHICLE (240001, "Mass Of The Vehicle"),
    /** Force ID */
    FORCE_ID_3 (240002, "Force ID"),
    /** Entity Type Kind */
    ENTITY_TYPE_KIND (240003, "Entity Type Kind"),
    /** Entity Type Domain */
    ENTITY_TYPE_DOMAIN (240004, "Entity Type Domain"),
    /** Entity Type Country */
    ENTITY_TYPE_COUNTRY (240005, "Entity Type Country"),
    /** Entity Type Category */
    ENTITY_TYPE_CATEGORY (240006, "Entity Type Category"),
    /** Entity Type Sub Category */
    ENTITY_TYPE_SUB_CATEGORY (240007, "Entity Type Sub Category"),
    /** Entity Type Specific */
    ENTITY_TYPE_SPECIFIC (240008, "Entity Type Specific"),
    /** Entity Type Extra */
    ENTITY_TYPE_EXTRA (240009, "Entity Type Extra"),
    /** Alternative Entity Type Kind */
    ALTERNATIVE_ENTITY_TYPE_KIND (240010, "Alternative Entity Type Kind"),
    /** Alternative Entity Type Domain */
    ALTERNATIVE_ENTITY_TYPE_DOMAIN (240011, "Alternative Entity Type Domain"),
    /** Alternative Entity Type Country */
    ALTERNATIVE_ENTITY_TYPE_COUNTRY (240012, "Alternative Entity Type Country"),
    /** Alternative Entity Type Category */
    ALTERNATIVE_ENTITY_TYPE_CATEGORY (240013, "Alternative Entity Type Category"),
    /** Alternative Entity Type Sub Category */
    ALTERNATIVE_ENTITY_TYPE_SUB_CATEGORY (240014, "Alternative Entity Type Sub Category"),
    /** Alternative Entity Type Specific */
    ALTERNATIVE_ENTITY_TYPE_SPECIFIC (240015, "Alternative Entity Type Specific"),
    /** Alternative Entity Type Extra */
    ALTERNATIVE_ENTITY_TYPE_EXTRA (240016, "Alternative Entity Type Extra"),
    /** Entity Location X */
    ENTITY_LOCATION_X (240017, "Entity Location X"),
    /** Entity Location Y */
    ENTITY_LOCATION_Y (240018, "Entity Location Y"),
    /** Entity Location Z */
    ENTITY_LOCATION_Z (240019, "Entity Location Z"),
    /** Entity Linear Velocity X */
    ENTITY_LINEAR_VELOCITY_X (240020, "Entity Linear Velocity X"),
    /** Entity Linear Velocity Y */
    ENTITY_LINEAR_VELOCITY_Y (240021, "Entity Linear Velocity Y"),
    /** Entity Linear Velocity Z */
    ENTITY_LINEAR_VELOCITY_Z (240022, "Entity Linear Velocity Z"),
    /** Entity Orientation Psi */
    ENTITY_ORIENTATION_PSI (240023, "Entity Orientation Psi"),
    /** Entity Orientation Theta */
    ENTITY_ORIENTATION_THETA (240024, "Entity Orientation Theta"),
    /** Entity Orientation Phi */
    ENTITY_ORIENTATION_PHI (240025, "Entity Orientation Phi"),
    /** Dead Reckoning Algorithm */
    DEAD_RECKONING_ALGORITHM (240026, "Dead Reckoning Algorithm"),
    /** Dead Reckoning Linear Acceleration X */
    DEAD_RECKONING_LINEAR_ACCELERATION_X (240027, "Dead Reckoning Linear Acceleration X"),
    /** Dead Reckoning Linear Acceleration Y */
    DEAD_RECKONING_LINEAR_ACCELERATION_Y (240028, "Dead Reckoning Linear Acceleration Y"),
    /** Dead Reckoning Linear Acceleration Z */
    DEAD_RECKONING_LINEAR_ACCELERATION_Z (240029, "Dead Reckoning Linear Acceleration Z"),
    /** Dead Reckoning Angular Velocity X */
    DEAD_RECKONING_ANGULAR_VELOCITY_X (240030, "Dead Reckoning Angular Velocity X"),
    /** Dead Reckoning Angular Velocity Y */
    DEAD_RECKONING_ANGULAR_VELOCITY_Y (240031, "Dead Reckoning Angular Velocity Y"),
    /** Dead Reckoning Angular Velocity Z */
    DEAD_RECKONING_ANGULAR_VELOCITY_Z (240032, "Dead Reckoning Angular Velocity Z"),
    /** Entity Appearance */
    ENTITY_APPEARANCE (240033, "Entity Appearance"),
    /** Entity Marking Character Set */
    ENTITY_MARKING_CHARACTER_SET (240034, "Entity Marking Character Set"),
    /** Entity Marking 11 Bytes */
    ENTITY_MARKING_11_BYTES (240035, "Entity Marking 11 Bytes"),
    /** Capability */
    CAPABILITY (240036, "Capability"),
    /** Number Articulation Parameters */
    NUMBER_ARTICULATION_PARAMETERS (240037, "Number Articulation Parameters"),
    /** Articulation Parameter ID */
    ARTICULATION_PARAMETER_ID (240038, "Articulation Parameter ID"),
    /** Articulation Parameter Type */
    ARTICULATION_PARAMETER_TYPE_2 (240039, "Articulation Parameter Type"),
    /** Articulation Parameter Value */
    ARTICULATION_PARAMETER_VALUE_2 (240040, "Articulation Parameter Value"),
    /** Type Of Stores */
    TYPE_OF_STORES (240041, "Type Of Stores"),
    /** Quantity Of Stores */
    QUANTITY_OF_STORES (240042, "Quantity Of Stores"),
    /** Fuel Quantity */
    FUEL_QUANTITY (240043, "Fuel Quantity"),
    /** Radar System Status */
    RADAR_SYSTEM_STATUS (240044, "Radar System Status"),
    /** Radio Communication System Status */
    RADIO_COMMUNICATION_SYSTEM_STATUS (240045, "Radio Communication System Status"),
    /** Default Time For Radio Transmission For Stationary Transmitters */
    DEFAULT_TIME_FOR_RADIO_TRANSMISSION_FOR_STATIONARY_TRANSMITTERS (240046, "Default Time For Radio Transmission For Stationary Transmitters"),
    /** Default Time For Radio Transmission For Moving Transmitters */
    DEFAULT_TIME_FOR_RADIO_TRANSMISSION_FOR_MOVING_TRANSMITTERS (240047, "Default Time For Radio Transmission For Moving Transmitters"),
    /** Body Part Damaged Ratio */
    BODY_PART_DAMAGED_RATIO (240048, "Body Part Damaged Ratio"),
    /** Name Of The Terrain Database File */
    NAME_OF_THE_TERRAIN_DATABASE_FILE (240049, "Name Of The Terrain Database File"),
    /** Name Of Local File */
    NAME_OF_LOCAL_FILE (240050, "Name Of Local File"),
    /** Aimpoint Bearing */
    AIMPOINT_BEARING (240051, "Aimpoint Bearing"),
    /** Aimpoint Elevation */
    AIMPOINT_ELEVATION (240052, "Aimpoint Elevation"),
    /** Aimpoint Range */
    AIMPOINT_RANGE (240053, "Aimpoint Range"),
    /** Air Speed */
    AIR_SPEED (240054, "Air Speed"),
    /** Altitude */
    ALTITUDE_3 (240055, "Altitude"),
    /** Application Status */
    APPLICATION_STATUS (240056, "Application Status"),
    /** Auto Iff */
    AUTO_IFF (240057, "Auto Iff"),
    /** Beacon Delay */
    BEACON_DELAY (240058, "Beacon Delay"),
    /** Bingo Fuel Setting */
    BINGO_FUEL_SETTING (240059, "Bingo Fuel Setting"),
    /** Cloud Bottom */
    CLOUD_BOTTOM (240060, "Cloud Bottom"),
    /** Cloud Top */
    CLOUD_TOP (240061, "Cloud Top"),
    /** Direction */
    DIRECTION (240062, "Direction"),
    /** End Action */
    END_ACTION (240063, "End Action"),
    /** Frequency */
    FREQUENCY (240064, "Frequency"),
    /** Freeze */
    FREEZE (240065, "Freeze"),
    /** Heading */
    HEADING (240066, "Heading"),
    /** Identification */
    IDENTIFICATION_2 (240067, "Identification"),
    /** Initial Point Data */
    INITIAL_POINT_DATA (240068, "Initial Point Data"),
    /** Latitude */
    LATITUDE_2 (240069, "Latitude"),
    /** Lights */
    LIGHTS_2 (240070, "Lights"),
    /** Linear */
    LINEAR (240071, "Linear"),
    /** Longitude */
    LONGITUDE_2 (240072, "Longitude"),
    /** Low Altitude */
    LOW_ALTITUDE (240073, "Low Altitude"),
    /** Mfd Formats */
    MFD_FORMATS (240074, "Mfd Formats"),
    /** Nctr */
    NCTR (240075, "Nctr"),
    /** Number Projectiles */
    NUMBER_PROJECTILES (240076, "Number Projectiles"),
    /** Operation Code */
    OPERATION_CODE (240077, "Operation Code"),
    /** Pitch */
    PITCH (240078, "Pitch"),
    /** Profiles */
    PROFILES (240079, "Profiles"),
    /** Quantity */
    QUANTITY_3 (240080, "Quantity"),
    /** Radar Modes */
    RADAR_MODES (240081, "Radar Modes"),
    /** Radar Search Volume */
    RADAR_SEARCH_VOLUME (240082, "Radar Search Volume"),
    /** Roll */
    ROLL (240083, "Roll"),
    /** Rotation */
    ROTATION_2 (240084, "Rotation"),
    /** Scale Factor X */
    SCALE_FACTOR_X (240085, "Scale Factor X"),
    /** Scale Factor Y */
    SCALE_FACTOR_Y (240086, "Scale Factor Y"),
    /** Shields */
    SHIELDS_2 (240087, "Shields"),
    /** Steerpoint */
    STEERPOINT (240088, "Steerpoint"),
    /** Spare1 */
    SPARE1 (240089, "Spare1"),
    /** Spare2 */
    SPARE2 (240090, "Spare2"),
    /** Team */
    TEAM (240091, "Team"),
    /** Text */
    TEXT (240092, "Text"),
    /** Time Of Day */
    TIME_OF_DAY (240093, "Time Of Day"),
    /** Trail Flag */
    TRAIL_FLAG (240094, "Trail Flag"),
    /** Trail Size */
    TRAIL_SIZE (240095, "Trail Size"),
    /** Type Of Projectile */
    TYPE_OF_PROJECTILE (240096, "Type Of Projectile"),
    /** Type Of Target */
    TYPE_OF_TARGET (240097, "Type Of Target"),
    /** Type Of Threat */
    TYPE_OF_THREAT (240098, "Type Of Threat"),
    /** Uhf Frequency */
    UHF_FREQUENCY (240099, "Uhf Frequency"),
    /** Utm Altitude */
    UTM_ALTITUDE (240100, "Utm Altitude"),
    /** Utm Latitude */
    UTM_LATITUDE (240101, "Utm Latitude"),
    /** Utm Longitude */
    UTM_LONGITUDE (240102, "Utm Longitude"),
    /** Vhf Frequency */
    VHF_FREQUENCY (240103, "Vhf Frequency"),
    /** Visibility Range */
    VISIBILITY_RANGE (240104, "Visibility Range"),
    /** Void Aaa Hit */
    VOID_AAA_HIT (240105, "Void Aaa Hit"),
    /** Void Collision */
    VOID_COLLISION (240106, "Void Collision"),
    /** Void Earth Hit */
    VOID_EARTH_HIT (240107, "Void Earth Hit"),
    /** Void Friendly */
    VOID_FRIENDLY (240108, "Void Friendly"),
    /** Void Gun Hit */
    VOID_GUN_HIT (240109, "Void Gun Hit"),
    /** Void Rocket Hit */
    VOID_ROCKET_HIT (240110, "Void Rocket Hit"),
    /** Void Sam Hit */
    VOID_SAM_HIT (240111, "Void Sam Hit"),
    /** Weapon Data */
    WEAPON_DATA (240112, "Weapon Data"),
    /** Weapon Type */
    WEAPON_TYPE (240113, "Weapon Type"),
    /** Weather */
    WEATHER_2 (240114, "Weather"),
    /** Wind Direction */
    WIND_DIRECTION_2 (240115, "Wind Direction"),
    /** Wind Speed */
    WIND_SPEED (240116, "Wind Speed"),
    /** Wing Station */
    WING_STATION (240117, "Wing Station"),
    /** Yaw */
    YAW (240118, "Yaw"),
    /** Memory Offset */
    MEMORY_OFFSET (240119, "Memory Offset"),
    /** Memory Data */
    MEMORY_DATA (240120, "Memory Data"),
    /** VASI */
    VASI (240121, "VASI"),
    /** Beacon */
    BEACON (240122, "Beacon"),
    /** Strobe */
    STROBE (240123, "Strobe"),
    /** Culture */
    CULTURE (240124, "Culture"),
    /** Approach */
    APPROACH (240125, "Approach"),
    /** Runway End */
    RUNWAY_END (240126, "Runway End"),
    /** Obstruction */
    OBSTRUCTION (240127, "Obstruction"),
    /** Runway Edge */
    RUNWAY_EDGE (240128, "Runway Edge"),
    /** Ramp Taxiway */
    RAMP_TAXIWAY (240129, "Ramp Taxiway"),
    /** Laser Bomb Code */
    LASER_BOMB_CODE (240130, "Laser Bomb Code"),
    /** Rack Type */
    RACK_TYPE (240131, "Rack Type"),
    /** HUD */
    HUD (240132, "HUD"),
    /** RoleFileName */
    ROLEFILENAME (240133, "RoleFileName"),
    /** PilotName */
    PILOTNAME (240134, "PilotName"),
    /** PilotDesignation */
    PILOTDESIGNATION (240135, "PilotDesignation"),
    /** Model Type */
    MODEL_TYPE (240136, "Model Type"),
    /** DIS Type */
    DIS_TYPE (240137, "DIS Type"),
    /** Class */
    CLASS (240138, "Class"),
    /** Channel */
    CHANNEL (240139, "Channel"),
    /** Entity Type */
    ENTITY_TYPE_2 (240140, "Entity Type"),
    /** Alternative Entity Type */
    ALTERNATIVE_ENTITY_TYPE_2 (240141, "Alternative Entity Type"),
    /** Entity Location */
    ENTITY_LOCATION (240142, "Entity Location"),
    /** Entity Linear Velocity */
    ENTITY_LINEAR_VELOCITY (240143, "Entity Linear Velocity"),
    /** Entity Orientation */
    ENTITY_ORIENTATION (240144, "Entity Orientation"),
    /** Dead Reckoning */
    DEAD_RECKONING (240145, "Dead Reckoning"),
    /** Failure Symptom */
    FAILURE_SYMPTOM (240146, "Failure Symptom"),
    /** Max Fuel */
    MAX_FUEL (240147, "Max Fuel"),
    /** Refueling Boom Connect */
    REFUELING_BOOM_CONNECT (240148, "Refueling Boom Connect"),
    /** Altitude AGL */
    ALTITUDE_AGL (240149, "Altitude AGL"),
    /** Calibrated Airspeed */
    CALIBRATED_AIRSPEED (240150, "Calibrated Airspeed"),
    /** TACAN Channel */
    TACAN_CHANNEL (240151, "TACAN Channel"),
    /** TACAN Band */
    TACAN_BAND (240152, "TACAN Band"),
    /** TACAN Mode */
    TACAN_MODE (240153, "TACAN Mode"),
    /** Fuel Flow Rate (kg/min) */
    FUEL_FLOW_RATE_KG_MIN (270115, "Fuel Flow Rate (kg/min)"),
    /** Fuel Temperature (degC) */
    FUEL_TEMPERATURE_DEGC (270116, "Fuel Temperature (degC)"),
    /** Fuel Pressure (Pa) */
    FUEL_PRESSURE_PA (270117, "Fuel Pressure (Pa)"),
    /** SKE Slot */
    SKE_SLOT (270150, "SKE Slot"),
    /** SKE Lead */
    SKE_LEAD (270151, "SKE Lead"),
    /** SKE Frequency */
    SKE_FREQUENCY (270152, "SKE Frequency"),
    /** FCI Cmd */
    FCI_CMD (270153, "FCI Cmd"),
    /** FCI Num */
    FCI_NUM (270154, "FCI Num"),
    /** SKE Bit Field */
    SKE_BIT_FIELD (270155, "SKE Bit Field"),
    /** Formation Position */
    FORMATION_POSITION (270156, "Formation Position"),
    /** Formation Number */
    FORMATION_NUMBER (270157, "Formation Number"),
    /** FFS Mode Active */
    FFS_MODE_ACTIVE (270158, "FFS Mode Active"),
    /** FFS Role */
    FFS_ROLE (270159, "FFS Role"),
    /** FFS VCAS */
    FFS_VCAS (270160, "FFS VCAS"),
    /** FFS Bit Field */
    FFS_BIT_FIELD (270161, "FFS Bit Field"),
    /** FFS Call Sign */
    FFS_CALL_SIGN (270162, "FFS Call Sign"),
    /** FFS Guidance Data */
    FFS_GUIDANCE_DATA (270163, "FFS Guidance Data"),
    /** FFS Text Data */
    FFS_TEXT_DATA (270164, "FFS Text Data"),
    /** FFS Airdrop Request Data */
    FFS_AIRDROP_REQUEST_DATA (270165, "FFS Airdrop Request Data"),
    /** FFS Airdrop Data */
    FFS_AIRDROP_DATA (270166, "FFS Airdrop Data"),
    /** Link 16 Command Variety 1 */
    LINK_16_COMMAND_VARIETY_1 (301100, "Link 16 Command Variety 1"),
    /** Push */
    PUSH (301130, "Push"),
    /** Rolex */
    ROLEX (301140, "Rolex"),
    /** Terminate Intercept */
    TERMINATE_INTERCEPT (301150, "Terminate Intercept"),
    /** Heal Damage */
    HEAL_DAMAGE (301151, "Heal Damage"),
    /** Destroy */
    DESTROY (301152, "Destroy"),
    /** Transfer Control Management */
    TRANSFER_CONTROL_MANAGEMENT (301160, "Transfer Control Management"),
    /** Link 16 Controls - PPLI Enable */
    LINK_16_CONTROLS_PPLI_ENABLE (301170, "Link 16 Controls - PPLI Enable"),
    /** Link 16 Controls - Command and Control Enable */
    LINK_16_CONTROLS_COMMAND_CONTROL_ENABLE (301171, "Link 16 Controls - Command & Control Enable"),
    /** Link 16 Reference Point Message Initiation */
    LINK_16_REFERENCE_POINT_MESSAGE_INITIATION (301174, "Link 16 Reference Point Message Initiation"),
    /** Assign External Entity Link 16 Track Number */
    ASSIGN_EXTERNAL_ENTITY_LINK_16_TRACK_NUMBER (301175, "Assign External Entity Link 16 Track Number"),
    /** Link 16 Intelligence Info */
    LINK_16_INTELLIGENCE_INFO (301176, "Link 16 Intelligence Info"),
    /** Link 16 Track Management */
    LINK_16_TRACK_MANAGEMENT (301177, "Link 16 Track Management"),
    /** Link 16 Controls - CES Global PPLI Publish */
    LINK_16_CONTROLS_CES_GLOBAL_PPLI_PUBLISH (301178, "Link 16 Controls - CES Global PPLI Publish"),
    /** Link 16 Controls - CES Global Surveillance Publish */
    LINK_16_CONTROLS_CES_GLOBAL_SURVEILLANCE_PUBLISH (301179, "Link 16 Controls - CES Global Surveillance Publish"),
    /** Request Global Link 16 Configuration */
    REQUEST_GLOBAL_LINK_16_CONFIGURATION (301180, "Request Global Link 16 Configuration"),
    /** Link 16 Controls - Surveillance Enable */
    LINK_16_CONTROLS_SURVEILLANCE_ENABLE (301181, "Link 16 Controls - Surveillance Enable"),
    /** Link 16 Pointer */
    LINK_16_POINTER (301182, "Link 16 Pointer"),
    /** Link 16 Vector */
    LINK_16_VECTOR (301183, "Link 16 Vector"),
    /** Link 16 Control Unit Change */
    LINK_16_CONTROL_UNIT_CHANGE (301184, "Link 16 Control Unit Change"),
    /** Link 16 Text */
    LINK_16_TEXT (301185, "Link 16 Text"),
    /** Request Link 16 Objects */
    REQUEST_LINK_16_OBJECTS (301186, "Request Link 16 Objects"),
    /** Link 16 Ref Object Name List */
    LINK_16_REF_OBJECT_NAME_LIST (301187, "Link 16 Ref Object Name List"),
    /** Total Number of PDUs in Link 16 Ref Objects Response */
    TOTAL_NUMBER_OF_PDUS_IN_LINK_16_REF_OBJECTS_RESPONSE (301189, "Total Number of PDUs in Link 16 Ref Objects Response"),
    /** PDU Number in Link 16 Ref Objects Response */
    PDU_NUMBER_IN_LINK_16_REF_OBJECTS_RESPONSE (301190, "PDU Number in Link 16 Ref Objects Response"),
    /** Total Number of Link 16 Ref Objects */
    TOTAL_NUMBER_OF_LINK_16_REF_OBJECTS (301191, "Total Number of Link 16 Ref Objects"),
    /** Link 16 Controls - F2F A Enable */
    LINK_16_CONTROLS_F2F_A_ENABLE (301197, "Link 16 Controls - F2F A Enable"),
    /** Link 16 Controls - F2F B Enable */
    LINK_16_CONTROLS_F2F_B_ENABLE (301198, "Link 16 Controls - F2F B Enable"),
    /** STN of Formation Leader */
    STN_OF_FORMATION_LEADER (301199, "STN of Formation Leader"),
    /** Formation Name */
    FORMATION_NAME (301200, "Formation Name"),
    /** Formation Role */
    FORMATION_ROLE (301201, "Formation Role"),
    /** Surveillance Contributor Sensor Based Detection */
    SURVEILLANCE_CONTRIBUTOR_SENSOR_BASED_DETECTION (301202, "Surveillance Contributor Sensor Based Detection"),
    /** F2F A NPG */
    F2F_A_NPG (301220, "F2F A NPG"),
    /** Link 16 Controls - F2F A Net */
    LINK_16_CONTROLS_F2F_A_NET (301221, "Link 16 Controls - F2F A Net"),
    /** F2F B NPG */
    F2F_B_NPG (301222, "F2F B NPG"),
    /** Link 16 Controls - F2F B Net */
    LINK_16_CONTROLS_F2F_B_NET (301223, "Link 16 Controls - F2F B Net"),
    /** Surveillance Enabled NPB */
    SURVEILLANCE_ENABLED_NPB (301224, "Surveillance Enabled NPB"),
    /** Surveillance Enabled Net */
    SURVEILLANCE_ENABLED_NET (301225, "Surveillance Enabled Net"),
    /** Control Unit Enabled */
    CONTROL_UNIT_ENABLED (301226, "Control Unit Enabled"),
    /** Control Unit Enabled NPG */
    CONTROL_UNIT_ENABLED_NPG (301227, "Control Unit Enabled NPG"),
    /** Control Unit Enabled Net */
    CONTROL_UNIT_ENABLED_NET (301228, "Control Unit Enabled Net"),
    /** Voice Frequency */
    VOICE_FREQUENCY (301229, "Voice Frequency"),
    /** Link 16 JTIDS Voice Callsign */
    LINK_16_JTIDS_VOICE_CALLSIGN (301234, "Link 16 JTIDS Voice Callsign"),
    /** Entity ID of Control Unit */
    ENTITY_ID_OF_CONTROL_UNIT (301237, "Entity ID of Control Unit"),
    /** STN of Control Unit */
    STN_OF_CONTROL_UNIT (301238, "STN of Control Unit"),
    /** NTR Participation Level */
    NTR_PARTICIPATION_LEVEL (301239, "NTR Participation Level"),
    /** Link 16 Controls - CES Global PPLI Subscribe */
    LINK_16_CONTROLS_CES_GLOBAL_PPLI_SUBSCRIBE (301240, "Link 16 Controls - CES Global PPLI Subscribe"),
    /** Link 16 Controls - CES Global Surveillance Subscribe */
    LINK_16_CONTROLS_CES_GLOBAL_SURVEILLANCE_SUBSCRIBE (301241, "Link 16 Controls - CES Global Surveillance Subscribe"),
    /** NTR in Mission */
    NTR_IN_MISSION (301242, "NTR in Mission"),
    /** NTR Marking */
    NTR_MARKING (301243, "NTR Marking"),
    /** NTR Receipt/Compliance */
    NTR_RECEIPT_COMPLIANCE (301244, "NTR Receipt/Compliance"),
    /** Formation F2F NPG */
    FORMATION_F2F_NPG (301255, "Formation F2F NPG"),
    /** Formation F2F Channel */
    FORMATION_F2F_CHANNEL (301256, "Formation F2F Channel"),
    /** Munition */
    MUNITION (500001, "Munition"),
    /** Engine Fuel */
    ENGINE_FUEL (500002, "Engine Fuel"),
    /** Storage Fuel */
    STORAGE_FUEL (500003, "Storage Fuel"),
    /** Not Used */
    NOT_USED (500004, "Not Used"),
    /** Expendable */
    EXPENDABLE (500005, "Expendable"),
    /** Total Record Sets */
    TOTAL_RECORD_SETS (500006, "Total Record Sets"),
    /** Launched Munition */
    LAUNCHED_MUNITION (500007, "Launched Munition"),
    /** Association */
    ASSOCIATION (500008, "Association"),
    /** Sensor */
    SENSOR (500009, "Sensor"),
    /** Munition Reload */
    MUNITION_RELOAD (500010, "Munition Reload"),
    /** Engine Fuel Reload */
    ENGINE_FUEL_RELOAD (500011, "Engine Fuel Reload"),
    /** Storage Fuel Reload */
    STORAGE_FUEL_RELOAD (500012, "Storage Fuel Reload"),
    /** Expendable Reload */
    EXPENDABLE_RELOAD (500013, "Expendable Reload"),
    /** IFF Change Control - Mode 1 Code */
    IFF_CHANGE_CONTROL_MODE_1_CODE (500014, "IFF Change Control - Mode 1 Code"),
    /** IFF Change Control - Mode 2 Code */
    IFF_CHANGE_CONTROL_MODE_2_CODE (500015, "IFF Change Control - Mode 2 Code"),
    /** IFF Change Control - Mode 3 Code */
    IFF_CHANGE_CONTROL_MODE_3_CODE (500016, "IFF Change Control - Mode 3 Code"),
    /** IFF Change Control - Mode 4 Code */
    IFF_CHANGE_CONTROL_MODE_4_CODE (500017, "IFF Change Control - Mode 4 Code"),
    /** IFF Change Control - Mode 5 Code */
    IFF_CHANGE_CONTROL_MODE_5_CODE (500018, "IFF Change Control - Mode 5 Code"),
    /** IFF Change Control - Mode 6 Code */
    IFF_CHANGE_CONTROL_MODE_6_CODE (500019, "IFF Change Control - Mode 6 Code"),
    /** Link 16 Data */
    LINK_16_DATA (500021, "Link 16 Data"),
    /** ARM Alert */
    ARM_ALERT (500022, "ARM Alert"),
    /** IFF Change Control - Mode On/Off */
    IFF_CHANGE_CONTROL_MODE_ON_OFF (500023, "IFF Change Control - Mode On/Off"),
    /** Weapon Status Data */
    WEAPON_STATUS_DATA (500024, "Weapon Status Data"),
    /** Expendable Status Data */
    EXPENDABLE_STATUS_DATA (500025, "Expendable Status Data"),
    /** Tactic Status Data */
    TACTIC_STATUS_DATA (500026, "Tactic Status Data"),
    /** Emitter/Sensor Data */
    EMITTER_SENSOR_DATA (500027, "Emitter/Sensor Data"),
    /** IOS Control Data */
    IOS_CONTROL_DATA (500028, "IOS Control Data"),
    /** Static Status Data */
    STATIC_STATUS_DATA (500029, "Static Status Data"),
    /** Request Inactive Entities */
    REQUEST_INACTIVE_ENTITIES (500200, "Request Inactive Entities"),
    /** Inactive Entity Quantity */
    INACTIVE_ENTITY_QUANTITY (500201, "Inactive Entity Quantity"),
    /** Inactive Entity ID */
    INACTIVE_ENTITY_ID (500202, "Inactive Entity ID"),
    /** Inactive Entity Type */
    INACTIVE_ENTITY_TYPE (500203, "Inactive Entity Type"),
    /** Activation Trigger Type */
    ACTIVATION_TRIGGER_TYPE (500204, "Activation Trigger Type"),
    /** Activation Trigger Value */
    ACTIVATION_TRIGGER_VALUE (500205, "Activation Trigger Value"),
    /** Air-to-Air Missile Qty */
    AIR_TO_AIR_MISSILE_QTY (551001, "Air-to-Air Missile Qty"),
    /** AIM-7 Missile Qty */
    AIM_7_MISSILE_QTY (551002, "AIM-7 Missile Qty"),
    /** AIM-9 Missile Qty */
    AIM_9_MISSILE_QTY (551003, "AIM-9 Missile Qty"),
    /** AIM-120 Missile Qty */
    AIM_120_MISSILE_QTY (551004, "AIM-120 Missile Qty"),
    /** Air-to-Ground Missile Qty */
    AIR_TO_GROUND_MISSILE_QTY (551005, "Air-to-Ground Missile Qty"),
    /** Surface-to-Air Missile Qty */
    SURFACE_TO_AIR_MISSILE_QTY (551006, "Surface-to-Air Missile Qty"),
    /** Bullet Qty */
    BULLET_QTY (551007, "Bullet Qty"),
    /** Chaff Qty */
    CHAFF_QTY (552001, "Chaff Qty"),
    /** Flare Qty */
    FLARE_QTY (552002, "Flare Qty"),
    /** Fuel Level */
    FUEL_LEVEL (553001, "Fuel Level"),
    /** Route Type */
    ROUTE_TYPE (553002, "Route Type"),
    /** Threat Mode */
    THREAT_MODE (553003, "Threat Mode"),
    /** Target Occluded */
    TARGET_OCCLUDED (553004, "Target Occluded"),
    /** Terrain Height */
    TERRAIN_HEIGHT (553005, "Terrain Height"),
    /** Entity Status */
    ENTITY_STATUS (553006, "Entity Status"),
    /** Marshal Status */
    MARSHAL_STATUS (553007, "Marshal Status"),
    /** Power Plant Status */
    POWER_PLANT_STATUS (553008, "Power Plant Status"),
    /** Nav Light Status */
    NAV_LIGHT_STATUS (553009, "Nav Light Status"),
    /** Interior Light Status */
    INTERIOR_LIGHT_STATUS (553010, "Interior Light Status"),
    /** Landing Light Status */
    LANDING_LIGHT_STATUS (553011, "Landing Light Status"),
    /** Formation Light Status */
    FORMATION_LIGHT_STATUS (553012, "Formation Light Status"),
    /** Anti-Collision Light Status */
    ANTI_COLLISION_LIGHT_STATUS (553013, "Anti-Collision Light Status"),
    /** Nav/Formation Flash Rate */
    NAV_FORMATION_FLASH_RATE (553014, "Nav/Formation Flash Rate"),
    /** Anti-Col. 'On' Duration */
    ANTI_COL_ON_DURATION (553015, "Anti-Col. 'On' Duration"),
    /** Anti-Col. 'Off' Duration */
    ANTI_COL_OFF_DURATION (553016, "Anti-Col. 'Off' Duration"),
    /** Intercept Status */
    INTERCEPT_STATUS (553017, "Intercept Status"),
    /** LifeForm Signaling Device Type */
    LIFEFORM_SIGNALING_DEVICE_TYPE (553018, "LifeForm Signaling Device Type"),
    /** LifeForm Movement Type */
    LIFEFORM_MOVEMENT_TYPE (553019, "LifeForm Movement Type"),
    /** LifeForm In Vehicle */
    LIFEFORM_IN_VEHICLE (553020, "LifeForm In Vehicle"),
    /** Mobility Kill */
    MOBILITY_KILL_2 (553021, "Mobility Kill"),
    /** Firepower Kill */
    FIREPOWER_KILL (553022, "Firepower Kill"),
    /** Tanker Enabled/Disabled */
    TANKER_ENABLED_DISABLED (553028, "Tanker Enabled/Disabled"),
    /** Threat Status Tactic OK to Shoot Down Weapons */
    THREAT_STATUS_TACTIC_OK_TO_SHOOT_DOWN_WEAPONS (553029, "Threat Status Tactic OK to Shoot Down Weapons"),
    /** TACAN Channel */
    TACAN_CHANNEL_2 (554001, "TACAN Channel"),
    /** TACAN Band */
    TACAN_BAND_2 (554002, "TACAN Band"),
    /** TACAN Mode */
    TACAN_MODE_2 (554003, "TACAN Mode"),
    /** RWR Status */
    RWR_STATUS (554004, "RWR Status"),
    /** UHF Radio Frequency */
    UHF_RADIO_FREQUENCY (554005, "UHF Radio Frequency"),
    /** Emit Jamming Status */
    EMIT_JAMMING_STATUS (554006, "Emit Jamming Status"),
    /** Emit Jamming Type */
    EMIT_JAMMING_TYPE (554007, "Emit Jamming Type"),
    /** Receive Jamming Status */
    RECEIVE_JAMMING_STATUS (554008, "Receive Jamming Status"),
    /** RADAR Mode */
    RADAR_MODE (554009, "RADAR Mode"),
    /** Available RADAR Modes */
    AVAILABLE_RADAR_MODES (554010, "Available RADAR Modes"),
    /** Jammer Pod Enumeration */
    JAMMER_POD_ENUMERATION (554100, "Jammer Pod Enumeration"),
    /** Jammer Pod Behavior */
    JAMMER_POD_BEHAVIOR (554101, "Jammer Pod Behavior"),
    /** Jammer Pod Programs */
    JAMMER_POD_PROGRAMS (554102, "Jammer Pod Programs"),
    /** Jammer Pod Receiver Sensitivity */
    JAMMER_POD_RECEIVER_SENSITIVITY (554103, "Jammer Pod Receiver Sensitivity"),
    /** Jammer Pod Receiver Frequency Minimum */
    JAMMER_POD_RECEIVER_FREQUENCY_MINIMUM (554104, "Jammer Pod Receiver Frequency Minimum"),
    /** Jammer Pod Receiver Frequency Maximum */
    JAMMER_POD_RECEIVER_FREQUENCY_MAXIMUM (554105, "Jammer Pod Receiver Frequency Maximum"),
    /** Jammer Pod Power */
    JAMMER_POD_POWER (554106, "Jammer Pod Power"),
    /** Jammer Pod Variability */
    JAMMER_POD_VARIABILITY (554107, "Jammer Pod Variability"),
    /** Jammer Pod Number of False Targets */
    JAMMER_POD_NUMBER_OF_FALSE_TARGETS (554108, "Jammer Pod Number of False Targets"),
    /** Jammer Pod Jammer Knob */
    JAMMER_POD_JAMMER_KNOB (554109, "Jammer Pod Jammer Knob"),
    /** Jammer Pod Missile Jamming */
    JAMMER_POD_MISSILE_JAMMING (554110, "Jammer Pod Missile Jamming"),
    /** Emitter Override */
    EMITTER_OVERRIDE_2 (555001, "Emitter Override"),
    /** Jammer Override */
    JAMMER_OVERRIDE (555002, "Jammer Override"),
    /** Disengage / Reengage */
    DISENGAGE_REENGAGE_2 (555003, "Disengage / Reengage"),
    /** Heading Override */
    HEADING_OVERRIDE (555004, "Heading Override"),
    /** Altitude Override */
    ALTITUDE_OVERRIDE (555005, "Altitude Override"),
    /** Speed Override */
    SPEED_OVERRIDE (555006, "Speed Override"),
    /** Verbose Override */
    VERBOSE_OVERRIDE (555007, "Verbose Override"),
    /** Occlusion Override */
    OCCLUSION_OVERRIDE (555008, "Occlusion Override"),
    /** Commit Range */
    COMMIT_RANGE (556001, "Commit Range"),
    /** Current Scenario IFF Mode 4A Code for This Threat's Affiliation */
    CURRENT_SCENARIO_IFF_MODE_4A_CODE_FOR_THIS_THREATS_AFFILIATION (556007, "Current Scenario IFF Mode 4A Code for This Threat's Affiliation"),
    /** Current Scenario IFF Mode 4B Code for This Threat's Affiliation */
    CURRENT_SCENARIO_IFF_MODE_4B_CODE_FOR_THIS_THREATS_AFFILIATION (556008, "Current Scenario IFF Mode 4B Code for This Threat's Affiliation"),
    /** Ok to Engage Waypoint Number */
    OK_TO_ENGAGE_WAYPOINT_NUMBER (556016, "Ok to Engage Waypoint Number"),
    /** Max Speed at Sea Level */
    MAX_SPEED_AT_SEA_LEVEL (556017, "Max Speed at Sea Level"),
    /** Max Speed */
    MAX_SPEED (556018, "Max Speed"),
    /** Current Waypoint Number */
    CURRENT_WAYPOINT_NUMBER (556019, "Current Waypoint Number"),
    /** Route Information */
    ROUTE_INFORMATION (556020, "Route Information"),
    /** Threat Status Static Multi Target Track */
    THREAT_STATUS_STATIC_MULTI_TARGET_TRACK (556029, "Threat Status Static Multi Target Track"),
    /** Air-Air IR Missile Qty */
    AIR_AIR_IR_MISSILE_QTY (557001, "Air-Air IR Missile Qty"),
    /** Air-Air Radar Missile Qty */
    AIR_AIR_RADAR_MISSILE_QTY (557002, "Air-Air Radar Missile Qty"),
    /** Air-Ground IR Missile Qty */
    AIR_GROUND_IR_MISSILE_QTY (557003, "Air-Ground IR Missile Qty"),
    /** Air-Ground Radar Missile Qty */
    AIR_GROUND_RADAR_MISSILE_QTY (557004, "Air-Ground Radar Missile Qty"),
    /** Air-Ground Anti-Radiation Missile Qty */
    AIR_GROUND_ANTI_RADIATION_MISSILE_QTY (557005, "Air-Ground Anti-Radiation Missile Qty"),
    /** Air-Ground Bomb Qty */
    AIR_GROUND_BOMB_QTY (557006, "Air-Ground Bomb Qty"),
    /** Air-Ground Rocket Qty */
    AIR_GROUND_ROCKET_QTY (557007, "Air-Ground Rocket Qty"),
    /** Surface-Air IR Missile Qty */
    SURFACE_AIR_IR_MISSILE_QTY (557008, "Surface-Air IR Missile Qty"),
    /** Surface-Air Radar Missile Qty */
    SURFACE_AIR_RADAR_MISSILE_QTY (557009, "Surface-Air Radar Missile Qty"),
    /** Bullet Qty */
    BULLET_QTY_2 (557010, "Bullet Qty"),
    /** PPLI Publish Enabled */
    PPLI_PUBLISH_ENABLED (559001, "PPLI Publish Enabled"),
    /** Surveillance PublishEnabled */
    SURVEILLANCE_PUBLISHENABLED (559002, "Surveillance PublishEnabled"),
    /** NPG */
    NPG (559003, "NPG"),
    /** NPG Channel */
    NPG_CHANNEL (559004, "NPG Channel"),
    /** JTIDS Track Number */
    JTIDS_TRACK_NUMBER (559005, "JTIDS Track Number"),
    /** Link 16 Controls - Surveillance Reportable */
    LINK_16_CONTROLS_SURVEILLANCE_REPORTABLE (559006, "Link 16 Controls - Surveillance Reportable"),
    /** Link 16 Controls - Surveillance Track Quality */
    LINK_16_CONTROLS_SURVEILLANCE_TRACK_QUALITY (559007, "Link 16 Controls - Surveillance Track Quality"),
    /** Link 16 Controls - Target Position Quality */
    LINK_16_CONTROLS_TARGET_POSITION_QUALITY (559008, "Link 16 Controls - Target Position Quality"),
    /** Link 16 Controls - Quality Error Type */
    LINK_16_CONTROLS_QUALITY_ERROR_TYPE (559009, "Link 16 Controls - Quality Error Type"),
    /** Link 16 Controls - Affiliation Determination Rule */
    LINK_16_CONTROLS_AFFILIATION_DETERMINATION_RULE (559010, "Link 16 Controls - Affiliation Determination Rule"),
    /** Link 16 Controls - Reset Entity Affiliation */
    LINK_16_CONTROLS_RESET_ENTITY_AFFILIATION (559011, "Link 16 Controls - Reset Entity Affiliation"),
    /** Link 16 Controls - Reset All Affiliation */
    LINK_16_CONTROLS_RESET_ALL_AFFILIATION (559012, "Link 16 Controls - Reset All Affiliation"),
    /** End of Messages */
    END_OF_MESSAGES (559999, "End of Messages"),
    /** Malfunction Activate/Deactivate Set */
    MALFUNCTION_ACTIVATE_DEACTIVATE_SET (600001, "Malfunction Activate/Deactivate Set"),
    /** Malfunction Status */
    MALFUNCTION_STATUS (600002, "Malfunction Status"),
    /** Request JTIDS Track Numbers */
    REQUEST_JTIDS_TRACK_NUMBERS (600210, "Request JTIDS Track Numbers"),
    /** Track Numbers vs EID */
    TRACK_NUMBERS_VS_EID (600212, "Track Numbers vs EID"),
    /** Total Number of JTIDS Track Numbers */
    TOTAL_NUMBER_OF_JTIDS_TRACK_NUMBERS (600214, "Total Number of JTIDS Track Numbers"),
    /** PDU Number in JTIDS Track Number Response */
    PDU_NUMBER_IN_JTIDS_TRACK_NUMBER_RESPONSE (600215, "PDU Number in JTIDS Track Number Response"),
    /** Total Number of PDUs in JTIDS Track Number Response */
    TOTAL_NUMBER_OF_PDUS_IN_JTIDS_TRACK_NUMBER_RESPONSE (600216, "Total Number of PDUs in JTIDS Track Number Response"),
    /** Air to Air Refueler Entities Request */
    AIR_TO_AIR_REFUELER_ENTITIES_REQUEST (600218, "Air to Air Refueler Entities Request"),
    /** Air to Air Refueling Count */
    AIR_TO_AIR_REFUELING_COUNT (600219, "Air to Air Refueling Count"),
    /** Air To Air Refueler Entity */
    AIR_TO_AIR_REFUELER_ENTITY (600220, "Air To Air Refueler Entity"),
    /** Formation Library Request */
    FORMATION_LIBRARY_REQUEST (600300, "Formation Library Request"),
    /** Total Number Formation Library PDUs */
    TOTAL_NUMBER_FORMATION_LIBRARY_PDUS (600301, "Total Number Formation Library PDUs"),
    /** PDU Number in Formation Library Response */
    PDU_NUMBER_IN_FORMATION_LIBRARY_RESPONSE (600302, "PDU Number in Formation Library Response"),
    /** Total Number Formation Library Items in PDU */
    TOTAL_NUMBER_FORMATION_LIBRARY_ITEMS_IN_PDU (600303, "Total Number Formation Library Items in PDU"),
    /** Formation Library Variable */
    FORMATION_LIBRARY_VARIABLE (600304, "Formation Library Variable"),
    /** Create Runtime Formation */
    CREATE_RUNTIME_FORMATION (600305, "Create Runtime Formation"),
    /** Formation Request Header */
    FORMATION_REQUEST_HEADER (600306, "Formation Request Header"),
    /** Formation Position Absolute */
    FORMATION_POSITION_ABSOLUTE (600307, "Formation Position Absolute"),
    /** Formation Position Relative */
    FORMATION_POSITION_RELATIVE (600308, "Formation Position Relative"),
    /** Expendables Reload */
    EXPENDABLES_RELOAD (610006, "Expendables Reload"),
    /** Position Freeze */
    POSITION_FREEZE (610007, "Position Freeze"),
    /** Activate Ownship */
    ACTIVATE_OWNSHIP (610008, "Activate Ownship"),
    /** Chocks */
    CHOCKS (610009, "Chocks"),
    /** Warm-up Cool-down Override */
    WARM_UP_COOL_DOWN_OVERRIDE (610010, "Warm-up Cool-down Override"),
    /** Ground Power */
    GROUND_POWER (610011, "Ground Power"),
    /** Scramble Start */
    SCRAMBLE_START (610012, "Scramble Start"),
    /** Ownship as a Threat */
    OWNSHIP_AS_A_THREAT (610013, "Ownship as a Threat"),
    /** Fuel External */
    FUEL_EXTERNAL (610015, "Fuel External"),
    /** Fuel Internal */
    FUEL_INTERNAL (610016, "Fuel Internal"),
    /** Fuel Tank Temp */
    FUEL_TANK_TEMP (610017, "Fuel Tank Temp"),
    /** Gross Weight */
    GROSS_WEIGHT (610025, "Gross Weight"),
    /** Angle Of Attack */
    ANGLE_OF_ATTACK (610026, "Angle Of Attack"),
    /** G Load */
    G_LOAD (610027, "G Load"),
    /** Weight On Wheels */
    WEIGHT_ON_WHEELS (610029, "Weight On Wheels"),
    /** Stored Energy System Reload */
    STORED_ENERGY_SYSTEM_RELOAD (610032, "Stored Energy System Reload"),
    /** Kill Override */
    KILL_OVERRIDE (610035, "Kill Override"),
    /** Expendables Freeze */
    EXPENDABLES_FREEZE (610036, "Expendables Freeze"),
    /** GPS Satellites Enable/Disable */
    GPS_SATELLITES_ENABLE_DISABLE (610037, "GPS Satellites Enable/Disable"),
    /** Ownship Message Display */
    OWNSHIP_MESSAGE_DISPLAY (610040, "Ownship Message Display"),
    /** Weapon Quantity Freeze */
    WEAPON_QUANTITY_FREEZE (610042, "Weapon Quantity Freeze"),
    /** Global Control - Freeze Weapons Quantity On All Ownships */
    GLOBAL_CONTROL_FREEZE_WEAPONS_QUANTITY_ON_ALL_OWNSHIPS (610043, "Global Control - Freeze Weapons Quantity On All Ownships"),
    /** Global Control - Freeze Fuel Quantity On All Ownships */
    GLOBAL_CONTROL_FREEZE_FUEL_QUANTITY_ON_ALL_OWNSHIPS (610044, "Global Control - Freeze Fuel Quantity On All Ownships"),
    /** Global Control-  Freeze Kill Override On All Ownships */
    GLOBAL_CONTROL_FREEZE_KILL_OVERRIDE_ON_ALL_OWNSHIPS (610045, "Global Control-  Freeze Kill Override On All Ownships"),
    /** Global Control - Freeze Crash Override On All Ownships */
    GLOBAL_CONTROL_FREEZE_CRASH_OVERRIDE_ON_ALL_OWNSHIPS (610046, "Global Control - Freeze Crash Override On All Ownships"),
    /** Ownship OFP Block Number */
    OWNSHIP_OFP_BLOCK_NUMBER (610047, "Ownship OFP Block Number"),
    /** Waypoint Information Query */
    WAYPOINT_INFORMATION_QUERY (610048, "Waypoint Information Query"),
    /** Waypoint Information */
    WAYPOINT_INFORMATION (610049, "Waypoint Information"),
    /** Ownship Subsystem Status Data */
    OWNSHIP_SUBSYSTEM_STATUS_DATA (610050, "Ownship Subsystem Status Data"),
    /** Cockpit Switch Status */
    COCKPIT_SWITCH_STATUS (613002, "Cockpit Switch Status"),
    /** Integrated Control Panel Messages */
    INTEGRATED_CONTROL_PANEL_MESSAGES (613003, "Integrated Control Panel Messages"),
    /** Throttle Positions */
    THROTTLE_POSITIONS (613004, "Throttle Positions"),
    /** Current Critical Switch Position */
    CURRENT_CRITICAL_SWITCH_POSITION (613005, "Current Critical Switch Position"),
    /** Correct Critical Switch Position */
    CORRECT_CRITICAL_SWITCH_POSITION (613006, "Correct Critical Switch Position"),
    /** Current Critical Switch Data */
    CURRENT_CRITICAL_SWITCH_DATA (613007, "Current Critical Switch Data"),
    /** Correct Critical Switch Data */
    CORRECT_CRITICAL_SWITCH_DATA (613008, "Correct Critical Switch Data"),
    /** Mission Initial Conditions Set */
    MISSION_INITIAL_CONDITIONS_SET (613013, "Mission Initial Conditions Set"),
    /** Global Control - Malfunction Active on All Ownships */
    GLOBAL_CONTROL_MALFUNCTION_ACTIVE_ON_ALL_OWNSHIPS (613016, "Global Control - Malfunction Active on All Ownships"),
    /** Global Control - Malfunction Clear On All Ownships */
    GLOBAL_CONTROL_MALFUNCTION_CLEAR_ON_ALL_OWNSHIPS (613017, "Global Control - Malfunction Clear On All Ownships"),
    /** Validated Critical Switch Report */
    VALIDATED_CRITICAL_SWITCH_REPORT (613020, "Validated Critical Switch Report"),
    /** SAR Map Pathname */
    SAR_MAP_PATHNAME (613021, "SAR Map Pathname"),
    /** Validated Critical Switch Ownship ID */
    VALIDATED_CRITICAL_SWITCH_OWNSHIP_ID (613022, "Validated Critical Switch Ownship ID"),
    /** Lower Boom Event Report */
    LOWER_BOOM_EVENT_REPORT (613027, "Lower Boom Event Report"),
    /** Raise Boom Event Report */
    RAISE_BOOM_EVENT_REPORT (613028, "Raise Boom Event Report"),
    /** Breakaway Event Report */
    BREAKAWAY_EVENT_REPORT (613029, "Breakaway Event Report"),
    /** Complete Event Report */
    COMPLETE_EVENT_REPORT (613030, "Complete Event Report"),
    /** Aux Comm Panel Frequency Display */
    AUX_COMM_PANEL_FREQUENCY_DISPLAY (613031, "Aux Comm Panel Frequency Display"),
    /** Network Station Information */
    NETWORK_STATION_INFORMATION (615000, "Network Station Information"),
    /** Global Control Select Network Station */
    GLOBAL_CONTROL_SELECT_NETWORK_STATION (615001, "Global Control Select Network Station"),
    /** Network Station Under Global Control */
    NETWORK_STATION_UNDER_GLOBAL_CONTROL (615002, "Network Station Under Global Control"),
    /** Global Control Still Controlling */
    GLOBAL_CONTROL_STILL_CONTROLLING (615003, "Global Control Still Controlling"),
    /** Global Control Release Control of Network Station */
    GLOBAL_CONTROL_RELEASE_CONTROL_OF_NETWORK_STATION (615004, "Global Control Release Control of Network Station"),
    /** Global Control Freeze Weapon Quantity */
    GLOBAL_CONTROL_FREEZE_WEAPON_QUANTITY (615005, "Global Control Freeze Weapon Quantity"),
    /** Global Control Freeze Fuel Quantity */
    GLOBAL_CONTROL_FREEZE_FUEL_QUANTITY (615006, "Global Control Freeze Fuel Quantity"),
    /** Global Control Freeze Kill Override */
    GLOBAL_CONTROL_FREEZE_KILL_OVERRIDE (615007, "Global Control Freeze Kill Override"),
    /** Global Control Freeze Crash Override */
    GLOBAL_CONTROL_FREEZE_CRASH_OVERRIDE (615008, "Global Control Freeze Crash Override"),
    /** Global Control Malfunction Active */
    GLOBAL_CONTROL_MALFUNCTION_ACTIVE (615009, "Global Control Malfunction Active"),
    /** Global Control Malfunction Clear */
    GLOBAL_CONTROL_MALFUNCTION_CLEAR (615010, "Global Control Malfunction Clear"),
    /** Global Control Start Devices */
    GLOBAL_CONTROL_START_DEVICES (615011, "Global Control Start Devices"),
    /** Global Control Freeze Devices */
    GLOBAL_CONTROL_FREEZE_DEVICES (615012, "Global Control Freeze Devices"),
    /** Global Control JTIDS Command */
    GLOBAL_CONTROL_JTIDS_COMMAND (615013, "Global Control JTIDS Command"),
    /** Network Station IC Set Information */
    NETWORK_STATION_IC_SET_INFORMATION (615015, "Network Station IC Set Information"),
    /** Global Control Reset IC Set */
    GLOBAL_CONTROL_RESET_IC_SET (615017, "Global Control Reset IC Set"),
    /** Number of Controlling Units */
    NUMBER_OF_CONTROLLING_UNITS (615018, "Number of Controlling Units"),
    /** Network Station JTIDS Controlling Units */
    NETWORK_STATION_JTIDS_CONTROLLING_UNITS (615019, "Network Station JTIDS Controlling Units"),
    /** Network Station JTIDS Objective Tracks */
    NETWORK_STATION_JTIDS_OBJECTIVE_TRACKS (615020, "Network Station JTIDS Objective Tracks"),
    /** Number of Reference Objects */
    NUMBER_OF_REFERENCE_OBJECTS (615021, "Number of Reference Objects"),
    /** Network Station JTIDS Reference Objects */
    NETWORK_STATION_JTIDS_REFERENCE_OBJECTS (615022, "Network Station JTIDS Reference Objects"),
    /** Networked Station Still Under Control */
    NETWORKED_STATION_STILL_UNDER_CONTROL (615023, "Networked Station Still Under Control"),
    /** Global Control Delete Threat Entities */
    GLOBAL_CONTROL_DELETE_THREAT_ENTITIES (615024, "Global Control Delete Threat Entities"),
    /** Network Station Ownship Callsigns */
    NETWORK_STATION_OWNSHIP_CALLSIGNS (615025, "Network Station Ownship Callsigns"),
    /** Global Control Request Formation Library Data */
    GLOBAL_CONTROL_REQUEST_FORMATION_LIBRARY_DATA (615026, "Global Control Request Formation Library Data"),
    /** Total Number Formation Library PDUs */
    TOTAL_NUMBER_FORMATION_LIBRARY_PDUS_2 (615027, "Total Number Formation Library PDUs"),
    /** PDU Number in Formation Library Response */
    PDU_NUMBER_IN_FORMATION_LIBRARY_RESPONSE_2 (615028, "PDU Number in Formation Library Response"),
    /** Total Number Formation Library Items in PDUs */
    TOTAL_NUMBER_FORMATION_LIBRARY_ITEMS_IN_PDUS (615029, "Total Number Formation Library Items in PDUs"),
    /** Network Station Formation Library Item */
    NETWORK_STATION_FORMATION_LIBRARY_ITEM (615030, "Network Station Formation Library Item"),
    /** Global Control Add Relative Formation */
    GLOBAL_CONTROL_ADD_RELATIVE_FORMATION (615031, "Global Control Add Relative Formation"),
    /** Network Station TIC Filename */
    NETWORK_STATION_TIC_FILENAME (615032, "Network Station TIC Filename"),
    /** Global Control Freeze Warm-up Override */
    GLOBAL_CONTROL_FREEZE_WARM_UP_OVERRIDE (615033, "Global Control Freeze Warm-up Override"),
    /** Global Control Reload SES */
    GLOBAL_CONTROL_RELOAD_SES (615034, "Global Control Reload SES"),
    /** Global Control Reload Weapons */
    GLOBAL_CONTROL_RELOAD_WEAPONS (615035, "Global Control Reload Weapons"),
    /** Global Control Reload Expendables */
    GLOBAL_CONTROL_RELOAD_EXPENDABLES (615036, "Global Control Reload Expendables"),
    /** Global Control Reload Fuel */
    GLOBAL_CONTROL_RELOAD_FUEL (615037, "Global Control Reload Fuel"),
    /** Global Control Reload Firebottle */
    GLOBAL_CONTROL_RELOAD_FIREBOTTLE (615038, "Global Control Reload Firebottle"),
    /** Test Pattern (DORT) */
    TEST_PATTERN_DORT (700000, "Test Pattern (DORT)"),
    /** Audio Test (DORT) */
    AUDIO_TEST_DORT (700001, "Audio Test (DORT)"),
    /** Audio Tone (DORT) */
    AUDIO_TONE_DORT (700002, "Audio Tone (DORT)"),
    /** Calibrate Throttles (DORT) */
    CALIBRATE_THROTTLES_DORT (700003, "Calibrate Throttles (DORT)"),
    /** Operational Limits Event Report */
    OPERATIONAL_LIMITS_EVENT_REPORT (700004, "Operational Limits Event Report"),
    /** Operational Limits */
    OPERATIONAL_LIMITS (700005, "Operational Limits"),
    /** Event Marker Message */
    EVENT_MARKER_MESSAGE (1000620, "Event Marker Message"),
    /** Extended Fire Event Reports */
    EXTENDED_FIRE_EVENT_REPORTS (5005001, "Extended Fire Event Reports"),
    /** Battle Damage Assessment (BDA) Event Report */
    BATTLE_DAMAGE_ASSESSMENT_BDA_EVENT_REPORT (5005002, "Battle Damage Assessment (BDA) Event Report"),
    /** Extended Fire Event Launcher */
    EXTENDED_FIRE_EVENT_LAUNCHER (5005003, "Extended Fire Event Launcher"),
    /** Extended Fire Event Missile */
    EXTENDED_FIRE_EVENT_MISSILE (5005006, "Extended Fire Event Missile"),
    /** Extended Fire Event MRM Weapon */
    EXTENDED_FIRE_EVENT_MRM_WEAPON (5005008, "Extended Fire Event MRM Weapon"),
    /** Extended Fire Event Gun Fire Control */
    EXTENDED_FIRE_EVENT_GUN_FIRE_CONTROL (5005009, "Extended Fire Event Gun Fire Control"),
    /** Extended Fire Event Bomb */
    EXTENDED_FIRE_EVENT_BOMB (5005010, "Extended Fire Event Bomb"),
    /** Extended Fire Event Expendable */
    EXTENDED_FIRE_EVENT_EXPENDABLE (5005011, "Extended Fire Event Expendable"),
    /** Battle Damage Assessment */
    BATTLE_DAMAGE_ASSESSMENT (5005012, "Battle Damage Assessment"),
    /** Extended Fire Pickle Event */
    EXTENDED_FIRE_PICKLE_EVENT (5005014, "Extended Fire Pickle Event"),
    /** Radar Track Report */
    RADAR_TRACK_REPORT (5005055, "Radar Track Report"),
    /** Jammer Report */
    JAMMER_REPORT (5005060, "Jammer Report"),
    /** Jammer False Targets Report */
    JAMMER_FALSE_TARGETS_REPORT (5005061, "Jammer False Targets Report"),
    /** Detect Event Report */
    DETECT_EVENT_REPORT (5005063, "Detect Event Report"),
    /** MALD Beam Report */
    MALD_BEAM_REPORT (5005070, "MALD Beam Report"),
    /** Transmitter Radiation Volume */
    TRANSMITTER_RADIATION_VOLUME (5005080, "Transmitter Radiation Volume");

    private int value;
    private final String description;

    VariableRecordType(int value, String description)
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
      return 32;
    }

    public static VariableRecordType getEnumForValue(int i)
    {
       for(VariableRecordType val: VariableRecordType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration VariableRecordType");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    public void marshal(ByteBuffer buff)
    {
        buff.putInt(getValue());
    }

    public static VariableRecordType unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    public static VariableRecordType unmarshalEnum (ByteBuffer buff)
    {
        return getEnumForValue(buff.getInt());
    }

    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
}
