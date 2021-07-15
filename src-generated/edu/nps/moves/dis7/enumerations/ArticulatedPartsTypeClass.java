package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 59 marshal size 32<br>
 * ArticulatedPartsTypeClass
 */
public enum ArticulatedPartsTypeClass 
{
    /** Not Specified */
    NOT_SPECIFIED (0, "Not Specified"),
    /** Rudder */
    RUDDER (1024, "Rudder"),
    /** Left Flap */
    LEFT_FLAP (1056, "Left Flap"),
    /** Right Flap */
    RIGHT_FLAP (1088, "Right Flap"),
    /** Left Aileron */
    LEFT_AILERON (1120, "Left Aileron"),
    /** Right Aileron */
    RIGHT_AILERON (1152, "Right Aileron"),
    /** Helicopter - Main Rotor */
    HELICOPTER_MAIN_ROTOR (1184, "Helicopter - Main Rotor"),
    /** Helicopter - Tail Rotor */
    HELICOPTER_TAIL_ROTOR (1216, "Helicopter - Tail Rotor"),
    /** Other Aircraft Control Surfaces Defined as Needed */
    OTHER_AIRCRAFT_CONTROL_SURFACES_DEFINED_AS_NEEDED (1248, "Other Aircraft Control Surfaces Defined as Needed"),
    /** Propeller Number 1 */
    PROPELLER_NUMBER_1 (1280, "Propeller Number 1"),
    /** Propeller Number 2 */
    PROPELLER_NUMBER_2 (1312, "Propeller Number 2"),
    /** Propeller Number 3 */
    PROPELLER_NUMBER_3 (1344, "Propeller Number 3"),
    /** Propeller Number 4 */
    PROPELLER_NUMBER_4 (1376, "Propeller Number 4"),
    /** Left Stabilator (Stabilator Number 1) */
    LEFT_STABILATOR_STABILATOR_NUMBER_1 (1408, "Left Stabilator (Stabilator Number 1)"),
    /** Right Stabilator (Stabilator Number 2) */
    RIGHT_STABILATOR_STABILATOR_NUMBER_2 (1440, "Right Stabilator (Stabilator Number 2)"),
    /** Left Ruddervator (Ruddervator Number 1) */
    LEFT_RUDDERVATOR_RUDDERVATOR_NUMBER_1 (1472, "Left Ruddervator (Ruddervator Number 1)"),
    /** Right Ruddervator (Ruddervator Number 2) */
    RIGHT_RUDDERVATOR_RUDDERVATOR_NUMBER_2 (1504, "Right Ruddervator (Ruddervator Number 2)"),
    /** Left Leading Edge Flap/Slat */
    LEFT_LEADING_EDGE_FLAP_SLAT (1536, "Left Leading Edge Flap/Slat"),
    /** Right Leading Edge Flap/Slat */
    RIGHT_LEADING_EDGE_FLAP_SLAT (1568, "Right Leading Edge Flap/Slat"),
    /** Left Elevator */
    LEFT_ELEVATOR (1600, "Left Elevator"),
    /** Right Elevator */
    RIGHT_ELEVATOR (1632, "Right Elevator"),
    /** Canard (left) */
    CANARD_LEFT (1664, "Canard (left)"),
    /** Canard (right) */
    CANARD_RIGHT (1696, "Canard (right)"),
    /** Elevon Inner (left) */
    ELEVON_INNER_LEFT (1728, "Elevon Inner (left)"),
    /** Elevon Inner (right) */
    ELEVON_INNER_RIGHT (1760, "Elevon Inner (right)"),
    /** Elevon Middle (left) */
    ELEVON_MIDDLE_LEFT (1792, "Elevon Middle (left)"),
    /** Elevon Middle (right) */
    ELEVON_MIDDLE_RIGHT (1824, "Elevon Middle (right)"),
    /** Elevon Outer (left) */
    ELEVON_OUTER_LEFT (1856, "Elevon Outer (left)"),
    /** Elevon Outer (right) */
    ELEVON_OUTER_RIGHT (1888, "Elevon Outer (right)"),
    /** Canopy (Aircraft) */
    CANOPY_AIRCRAFT (1920, "Canopy (Aircraft)"),
    /** Periscope */
    PERISCOPE (2048, "Periscope"),
    /** Generic Antenna */
    GENERIC_ANTENNA (2080, "Generic Antenna"),
    /** Snorkel */
    SNORKEL (2112, "Snorkel"),
    /** Other Extendible Parts Defined as Needed */
    OTHER_EXTENDIBLE_PARTS_DEFINED_AS_NEEDED (2144, "Other Extendible Parts Defined as Needed"),
    /** Dive Plane (Sail) - Left */
    DIVE_PLANE_SAIL_LEFT (2176, "Dive Plane (Sail) - Left"),
    /** Dive Plane (Sail) - Right */
    DIVE_PLANE_SAIL_RIGHT (2208, "Dive Plane (Sail) - Right"),
    /** Dive Plane (Bow) - Left */
    DIVE_PLANE_BOW_LEFT (2240, "Dive Plane (Bow) - Left"),
    /** Dive Plane (Bow) - Right */
    DIVE_PLANE_BOW_RIGHT (2272, "Dive Plane (Bow) - Right"),
    /** Dive Plane (Stern) - Left */
    DIVE_PLANE_STERN_LEFT (2304, "Dive Plane (Stern) - Left"),
    /** Dive Plane (Stern) - Right */
    DIVE_PLANE_STERN_RIGHT (2336, "Dive Plane (Stern) - Right"),
    /** Landing Gear, Nose and Left/Right Main move in unison; intended for low-fidelity simulations and not to be used if the others are used. */
    LANDING_GEAR (3072, "Landing Gear"),
    /** Tail Hook */
    TAIL_HOOK (3104, "Tail Hook"),
    /** Speed Brake */
    SPEED_BRAKE (3136, "Speed Brake"),
    /** Left Door of Primary Weapon Bay */
    LEFT_DOOR_OF_PRIMARY_WEAPON_BAY (3168, "Left Door of Primary Weapon Bay"),
    /** Right Door of Primary Weapon Bay */
    RIGHT_DOOR_OF_PRIMARY_WEAPON_BAY (3200, "Right Door of Primary Weapon Bay"),
    /** Tank or APC Hatch */
    TANK_OR_APC_HATCH (3232, "Tank or APC Hatch"),
    /** Wingsweep */
    WINGSWEEP (3264, "Wingsweep"),
    /** Bridge Launcher */
    BRIDGE_LAUNCHER (3296, "Bridge Launcher"),
    /** Bridge Section 1 */
    BRIDGE_SECTION_1 (3328, "Bridge Section 1"),
    /** Bridge Section 2 */
    BRIDGE_SECTION_2 (3360, "Bridge Section 2"),
    /** Bridge Section 3 */
    BRIDGE_SECTION_3 (3392, "Bridge Section 3"),
    /** Primary Blade 1 */
    PRIMARY_BLADE_1 (3424, "Primary Blade 1"),
    /** Primary Blade 2 */
    PRIMARY_BLADE_2 (3456, "Primary Blade 2"),
    /** Primary Boom */
    PRIMARY_BOOM (3488, "Primary Boom"),
    /** Primary Launcher Arm */
    PRIMARY_LAUNCHER_ARM (3520, "Primary Launcher Arm"),
    /** Other Fixed Position Parts Defined as Needed */
    OTHER_FIXED_POSITION_PARTS_DEFINED_AS_NEEDED (3552, "Other Fixed Position Parts Defined as Needed"),
    /** Landing Gear - Nose */
    LANDING_GEAR_NOSE (3584, "Landing Gear - Nose"),
    /** Landing Gear - Left Main */
    LANDING_GEAR_LEFT_MAIN (3616, "Landing Gear - Left Main"),
    /** Landing Gear - Right Main */
    LANDING_GEAR_RIGHT_MAIN (3648, "Landing Gear - Right Main"),
    /** Doors of Left Side Weapon Bay */
    DOORS_OF_LEFT_SIDE_WEAPON_BAY (3680, "Doors of Left Side Weapon Bay"),
    /** Doors of Right Side Weapon Bay */
    DOORS_OF_RIGHT_SIDE_WEAPON_BAY (3712, "Doors of Right Side Weapon Bay"),
    /** Spot/Search Light #1 */
    SPOT_SEARCH_LIGHT_1 (3744, "Spot/Search Light #1"),
    /** Spot/Search Light #2 */
    SPOT_SEARCH_LIGHT_2 (3776, "Spot/Search Light #2"),
    /** Spot/Search Light #3 */
    SPOT_SEARCH_LIGHT_3 (3808, "Spot/Search Light #3"),
    /** Spot/Search Light #4 */
    SPOT_SEARCH_LIGHT_4 (3840, "Spot/Search Light #4"),
    /** Landing Light */
    LANDING_LIGHT (3872, "Landing Light"),
    /** Primary Turret Number 1 */
    PRIMARY_TURRET_NUMBER_1 (4096, "Primary Turret Number 1"),
    /** Primary Turret Number 2 */
    PRIMARY_TURRET_NUMBER_2 (4128, "Primary Turret Number 2"),
    /** Primary Turret Number 3 */
    PRIMARY_TURRET_NUMBER_3 (4160, "Primary Turret Number 3"),
    /** Primary Turret Number 4 */
    PRIMARY_TURRET_NUMBER_4 (4192, "Primary Turret Number 4"),
    /** Primary Turret Number 5 */
    PRIMARY_TURRET_NUMBER_5 (4224, "Primary Turret Number 5"),
    /** Primary Turret Number 6 */
    PRIMARY_TURRET_NUMBER_6 (4256, "Primary Turret Number 6"),
    /** Primary Turret Number 7 */
    PRIMARY_TURRET_NUMBER_7 (4288, "Primary Turret Number 7"),
    /** Primary Turret Number 8 */
    PRIMARY_TURRET_NUMBER_8 (4320, "Primary Turret Number 8"),
    /** Primary Turret Number 9 */
    PRIMARY_TURRET_NUMBER_9 (4352, "Primary Turret Number 9"),
    /** Primary Turret Number 10 */
    PRIMARY_TURRET_NUMBER_10 (4384, "Primary Turret Number 10"),
    /** Primary Gun Number 1 */
    PRIMARY_GUN_NUMBER_1 (4416, "Primary Gun Number 1"),
    /** Primary Gun Number 2 */
    PRIMARY_GUN_NUMBER_2 (4448, "Primary Gun Number 2"),
    /** Primary Gun Number 3 */
    PRIMARY_GUN_NUMBER_3 (4480, "Primary Gun Number 3"),
    /** Primary Gun Number 4 */
    PRIMARY_GUN_NUMBER_4 (4512, "Primary Gun Number 4"),
    /** Primary Gun Number 5 */
    PRIMARY_GUN_NUMBER_5 (4544, "Primary Gun Number 5"),
    /** Primary Gun Number 6 */
    PRIMARY_GUN_NUMBER_6 (4576, "Primary Gun Number 6"),
    /** Primary Gun Number 7 */
    PRIMARY_GUN_NUMBER_7 (4608, "Primary Gun Number 7"),
    /** Primary Gun Number 8 */
    PRIMARY_GUN_NUMBER_8 (4640, "Primary Gun Number 8"),
    /** Primary Gun Number 9 */
    PRIMARY_GUN_NUMBER_9 (4672, "Primary Gun Number 9"),
    /** Primary Gun Number 10 */
    PRIMARY_GUN_NUMBER_10 (4704, "Primary Gun Number 10"),
    /** Primary Launcher 1 */
    PRIMARY_LAUNCHER_1 (4736, "Primary Launcher 1"),
    /** Primary Launcher 2 */
    PRIMARY_LAUNCHER_2 (4768, "Primary Launcher 2"),
    /** Primary Launcher 3 */
    PRIMARY_LAUNCHER_3 (4800, "Primary Launcher 3"),
    /** Primary Launcher 4 */
    PRIMARY_LAUNCHER_4 (4832, "Primary Launcher 4"),
    /** Primary Launcher 5 */
    PRIMARY_LAUNCHER_5 (4864, "Primary Launcher 5"),
    /** Primary Launcher 6 */
    PRIMARY_LAUNCHER_6 (4896, "Primary Launcher 6"),
    /** Primary Launcher 7 */
    PRIMARY_LAUNCHER_7 (4928, "Primary Launcher 7"),
    /** Primary Launcher 8 */
    PRIMARY_LAUNCHER_8 (4960, "Primary Launcher 8"),
    /** Primary Launcher 9 */
    PRIMARY_LAUNCHER_9 (4992, "Primary Launcher 9"),
    /** Primary Launcher 10 */
    PRIMARY_LAUNCHER_10 (5024, "Primary Launcher 10"),
    /** Primary Defense Systems 1, Point defense systems like Phalanx guns, or visible chaff, flare, or smoke dispensers. */
    PRIMARY_DEFENSE_SYSTEMS_1 (5056, "Primary Defense Systems 1"),
    /** Primary Defense Systems 2 */
    PRIMARY_DEFENSE_SYSTEMS_2 (5088, "Primary Defense Systems 2"),
    /** Primary Defense Systems 3 */
    PRIMARY_DEFENSE_SYSTEMS_3 (5120, "Primary Defense Systems 3"),
    /** Primary Defense Systems 4 */
    PRIMARY_DEFENSE_SYSTEMS_4 (5152, "Primary Defense Systems 4"),
    /** Primary Defense Systems 5 */
    PRIMARY_DEFENSE_SYSTEMS_5 (5184, "Primary Defense Systems 5"),
    /** Primary Defense Systems 6 */
    PRIMARY_DEFENSE_SYSTEMS_6 (5216, "Primary Defense Systems 6"),
    /** Primary Defense Systems 7 */
    PRIMARY_DEFENSE_SYSTEMS_7 (5248, "Primary Defense Systems 7"),
    /** Primary Defense Systems 8 */
    PRIMARY_DEFENSE_SYSTEMS_8 (5280, "Primary Defense Systems 8"),
    /** Primary Defense Systems 9 */
    PRIMARY_DEFENSE_SYSTEMS_9 (5312, "Primary Defense Systems 9"),
    /** Primary Defense Systems 10 */
    PRIMARY_DEFENSE_SYSTEMS_10 (5344, "Primary Defense Systems 10"),
    /** Primary Radar 1, Any radar dish or movable antenna or sensor. */
    PRIMARY_RADAR_1 (5376, "Primary Radar 1"),
    /** Primary Radar 2 */
    PRIMARY_RADAR_2 (5408, "Primary Radar 2"),
    /** Primary Radar 3 */
    PRIMARY_RADAR_3 (5440, "Primary Radar 3"),
    /** Primary Radar 4 */
    PRIMARY_RADAR_4 (5472, "Primary Radar 4"),
    /** Primary Radar 5 */
    PRIMARY_RADAR_5 (5504, "Primary Radar 5"),
    /** Primary Radar 6 */
    PRIMARY_RADAR_6 (5536, "Primary Radar 6"),
    /** Primary Radar 7 */
    PRIMARY_RADAR_7 (5568, "Primary Radar 7"),
    /** Primary Radar 8 */
    PRIMARY_RADAR_8 (5600, "Primary Radar 8"),
    /** Primary Radar 9 */
    PRIMARY_RADAR_9 (5632, "Primary Radar 9"),
    /** Primary Radar 10 */
    PRIMARY_RADAR_10 (5664, "Primary Radar 10"),
    /** Secondary Turret Number 1 */
    SECONDARY_TURRET_NUMBER_1 (5696, "Secondary Turret Number 1"),
    /** Secondary Turret Number 2 */
    SECONDARY_TURRET_NUMBER_2 (5728, "Secondary Turret Number 2"),
    /** Secondary Turret Number 3 */
    SECONDARY_TURRET_NUMBER_3 (5760, "Secondary Turret Number 3"),
    /** Secondary Turret Number 4 */
    SECONDARY_TURRET_NUMBER_4 (5792, "Secondary Turret Number 4"),
    /** Secondary Turret Number 5 */
    SECONDARY_TURRET_NUMBER_5 (5824, "Secondary Turret Number 5"),
    /** Secondary Turret Number 6 */
    SECONDARY_TURRET_NUMBER_6 (5856, "Secondary Turret Number 6"),
    /** Secondary Turret Number 7 */
    SECONDARY_TURRET_NUMBER_7 (5888, "Secondary Turret Number 7"),
    /** Secondary Turret Number 8 */
    SECONDARY_TURRET_NUMBER_8 (5920, "Secondary Turret Number 8"),
    /** Secondary Turret Number 9 */
    SECONDARY_TURRET_NUMBER_9 (5952, "Secondary Turret Number 9"),
    /** Secondary Turret Number 10 */
    SECONDARY_TURRET_NUMBER_10 (5984, "Secondary Turret Number 10"),
    /** Secondary Gun Number 1 */
    SECONDARY_GUN_NUMBER_1 (6016, "Secondary Gun Number 1"),
    /** Secondary Gun Number 2 */
    SECONDARY_GUN_NUMBER_2 (6048, "Secondary Gun Number 2"),
    /** Secondary Gun Number 3 */
    SECONDARY_GUN_NUMBER_3 (6080, "Secondary Gun Number 3"),
    /** Secondary Gun Number 4 */
    SECONDARY_GUN_NUMBER_4 (6112, "Secondary Gun Number 4"),
    /** Secondary Gun Number 5 */
    SECONDARY_GUN_NUMBER_5 (6144, "Secondary Gun Number 5"),
    /** Secondary Gun Number 6 */
    SECONDARY_GUN_NUMBER_6 (6176, "Secondary Gun Number 6"),
    /** Secondary Gun Number 7 */
    SECONDARY_GUN_NUMBER_7 (6208, "Secondary Gun Number 7"),
    /** Secondary Gun Number 8 */
    SECONDARY_GUN_NUMBER_8 (6240, "Secondary Gun Number 8"),
    /** Secondary Gun Number 9 */
    SECONDARY_GUN_NUMBER_9 (6272, "Secondary Gun Number 9"),
    /** Secondary Gun Number 10 */
    SECONDARY_GUN_NUMBER_10 (6304, "Secondary Gun Number 10"),
    /** Secondary Launcher 1 */
    SECONDARY_LAUNCHER_1 (6336, "Secondary Launcher 1"),
    /** Secondary Launcher 2 */
    SECONDARY_LAUNCHER_2 (6368, "Secondary Launcher 2"),
    /** Secondary Launcher 3 */
    SECONDARY_LAUNCHER_3 (6400, "Secondary Launcher 3"),
    /** Secondary Launcher 4 */
    SECONDARY_LAUNCHER_4 (6432, "Secondary Launcher 4"),
    /** Secondary Launcher 5 */
    SECONDARY_LAUNCHER_5 (6464, "Secondary Launcher 5"),
    /** Secondary Launcher 6 */
    SECONDARY_LAUNCHER_6 (6496, "Secondary Launcher 6"),
    /** Secondary Launcher 7 */
    SECONDARY_LAUNCHER_7 (6528, "Secondary Launcher 7"),
    /** Secondary Launcher 8 */
    SECONDARY_LAUNCHER_8 (6560, "Secondary Launcher 8"),
    /** Secondary Launcher 9 */
    SECONDARY_LAUNCHER_9 (6592, "Secondary Launcher 9"),
    /** Secondary Launcher 10 */
    SECONDARY_LAUNCHER_10 (6624, "Secondary Launcher 10"),
    /** Secondary Defense Systems 1 */
    SECONDARY_DEFENSE_SYSTEMS_1 (6656, "Secondary Defense Systems 1"),
    /** Secondary Defense Systems 2 */
    SECONDARY_DEFENSE_SYSTEMS_2 (6688, "Secondary Defense Systems 2"),
    /** Secondary Defense Systems 3 */
    SECONDARY_DEFENSE_SYSTEMS_3 (6720, "Secondary Defense Systems 3"),
    /** Secondary Defense Systems 4 */
    SECONDARY_DEFENSE_SYSTEMS_4 (6752, "Secondary Defense Systems 4"),
    /** Secondary Defense Systems 5 */
    SECONDARY_DEFENSE_SYSTEMS_5 (6784, "Secondary Defense Systems 5"),
    /** Secondary Defense Systems 6 */
    SECONDARY_DEFENSE_SYSTEMS_6 (6816, "Secondary Defense Systems 6"),
    /** Secondary Defense Systems 7 */
    SECONDARY_DEFENSE_SYSTEMS_7 (6848, "Secondary Defense Systems 7"),
    /** Secondary Defense Systems 8 */
    SECONDARY_DEFENSE_SYSTEMS_8 (6880, "Secondary Defense Systems 8"),
    /** Secondary Defense Systems 9 */
    SECONDARY_DEFENSE_SYSTEMS_9 (6912, "Secondary Defense Systems 9"),
    /** Secondary Defense Systems 10 */
    SECONDARY_DEFENSE_SYSTEMS_10 (6944, "Secondary Defense Systems 10"),
    /** Secondary Radar 1 */
    SECONDARY_RADAR_1 (6976, "Secondary Radar 1"),
    /** Secondary Radar 2 */
    SECONDARY_RADAR_2 (7008, "Secondary Radar 2"),
    /** Secondary Radar 3 */
    SECONDARY_RADAR_3 (7040, "Secondary Radar 3"),
    /** Secondary Radar 4 */
    SECONDARY_RADAR_4 (7072, "Secondary Radar 4"),
    /** Secondary Radar 5 */
    SECONDARY_RADAR_5 (7104, "Secondary Radar 5"),
    /** Secondary Radar 6 */
    SECONDARY_RADAR_6 (7136, "Secondary Radar 6"),
    /** Secondary Radar 7 */
    SECONDARY_RADAR_7 (7168, "Secondary Radar 7"),
    /** Secondary Radar 8 */
    SECONDARY_RADAR_8 (7200, "Secondary Radar 8"),
    /** Secondary Radar 9 */
    SECONDARY_RADAR_9 (7232, "Secondary Radar 9"),
    /** Secondary Radar 10 */
    SECONDARY_RADAR_10 (7264, "Secondary Radar 10"),
    /** Deck Elevator #1 */
    DECK_ELEVATOR_1 (7296, "Deck Elevator #1"),
    /** Deck Elevator #2 */
    DECK_ELEVATOR_2 (7328, "Deck Elevator #2"),
    /** Catapult #1 */
    CATAPULT_1 (7360, "Catapult #1"),
    /** Catapult #2 */
    CATAPULT_2 (7392, "Catapult #2"),
    /** Jet Blast Deflector #1 */
    JET_BLAST_DEFLECTOR_1 (7424, "Jet Blast Deflector #1"),
    /** Jet Blast Deflector #2 */
    JET_BLAST_DEFLECTOR_2 (7456, "Jet Blast Deflector #2"),
    /** Arrestor Wires #1 */
    ARRESTOR_WIRES_1 (7488, "Arrestor Wires #1"),
    /** Arrestor Wires #2 */
    ARRESTOR_WIRES_2 (7520, "Arrestor Wires #2"),
    /** Arrestor Wires #3 */
    ARRESTOR_WIRES_3 (7552, "Arrestor Wires #3"),
    /** Wing (or Rotor) Fold */
    WING_OR_ROTOR_FOLD (7584, "Wing (or Rotor) Fold"),
    /** Fuselage Fold */
    FUSELAGE_FOLD (7616, "Fuselage Fold"),
    /** Main Cargo Door */
    MAIN_CARGO_DOOR (7648, "Main Cargo Door"),
    /** Cargo Ramp */
    CARGO_RAMP (7680, "Cargo Ramp"),
    /** Air-to-Air Refueling Boom */
    AIR_TO_AIR_REFUELING_BOOM (7712, "Air-to-Air Refueling Boom"),
    /** Primary Aerial Refueling Receptacle Door */
    PRIMARY_AERIAL_REFUELING_RECEPTACLE_DOOR (7744, "Primary Aerial Refueling Receptacle Door"),
    /** Secondary Aerial Refueling Receptacle Door */
    SECONDARY_AERIAL_REFUELING_RECEPTACLE_DOOR (7776, "Secondary Aerial Refueling Receptacle Door"),
    /** Aerial Refueling Receptacle Latch */
    AERIAL_REFUELING_RECEPTACLE_LATCH (7808, "Aerial Refueling Receptacle Latch"),
    /** Cargo Door #1 */
    CARGO_DOOR_1 (7840, "Cargo Door #1"),
    /** Cargo Door #2 */
    CARGO_DOOR_2 (7872, "Cargo Door #2"),
    /** Cargo Door #3 */
    CARGO_DOOR_3 (7904, "Cargo Door #3"),
    /** Cargo Door #4 */
    CARGO_DOOR_4 (7936, "Cargo Door #4"),
    /** Cargo Door #5 */
    CARGO_DOOR_5 (7968, "Cargo Door #5"),
    /** Cargo Door #6 */
    CARGO_DOOR_6 (8000, "Cargo Door #6"),
    /** Cargo Door #7 */
    CARGO_DOOR_7 (8032, "Cargo Door #7"),
    /** Cargo Door #8 */
    CARGO_DOOR_8 (8064, "Cargo Door #8"),
    /** Cargo Door #9 */
    CARGO_DOOR_9 (8096, "Cargo Door #9"),
    /** Cargo Door #10 */
    CARGO_DOOR_10 (8128, "Cargo Door #10"),
    /** Centre Refuelling Drogue */
    CENTRE_REFUELLING_DROGUE (8160, "Centre Refuelling Drogue"),
    /** Port Refuelling Drogue */
    PORT_REFUELLING_DROGUE (8192, "Port Refuelling Drogue"),
    /** Starboard Refuelling Drogue */
    STARBOARD_REFUELLING_DROGUE (8224, "Starboard Refuelling Drogue"),
    /** Submarine Engine Exhaust Mast */
    SUBMARINE_ENGINE_EXHAUST_MAST (8256, "Submarine Engine Exhaust Mast"),
    /** Submarine Mast #1, Masts are numbered from forward to aft, masts that are side by side are numbered from port to starboard */
    SUBMARINE_MAST_1 (8288, "Submarine Mast #1"),
    /** Submarine Mast #2 */
    SUBMARINE_MAST_2 (8320, "Submarine Mast #2"),
    /** Submarine Mast #3 */
    SUBMARINE_MAST_3 (8352, "Submarine Mast #3"),
    /** Submarine Mast #4 */
    SUBMARINE_MAST_4 (8384, "Submarine Mast #4"),
    /** Submarine Mast #5 */
    SUBMARINE_MAST_5 (8416, "Submarine Mast #5"),
    /** Submarine Mast #6 */
    SUBMARINE_MAST_6 (8448, "Submarine Mast #6"),
    /** Submarine Mast #7 */
    SUBMARINE_MAST_7 (8480, "Submarine Mast #7"),
    /** Submarine Mast #8 */
    SUBMARINE_MAST_8 (8512, "Submarine Mast #8"),
    /** Submarine Mast #9 */
    SUBMARINE_MAST_9 (8544, "Submarine Mast #9"),
    /** Submarine Mast #10 */
    SUBMARINE_MAST_10 (8576, "Submarine Mast #10"),
    /** Vectored Thrust Nozzle */
    VECTORED_THRUST_NOZZLE (8608, "Vectored Thrust Nozzle"),
    /** Left Door of the Left Weapon Bay */
    LEFT_DOOR_OF_THE_LEFT_WEAPON_BAY (8640, "Left Door of the Left Weapon Bay"),
    /** Right Door of the Left Weapon Bay */
    RIGHT_DOOR_OF_THE_LEFT_WEAPON_BAY (8672, "Right Door of the Left Weapon Bay"),
    /** Left Door of the Right Weapon Bay */
    LEFT_DOOR_OF_THE_RIGHT_WEAPON_BAY (8704, "Left Door of the Right Weapon Bay"),
    /** Right Door of the Right Weapon Bay */
    RIGHT_DOOR_OF_THE_RIGHT_WEAPON_BAY (8736, "Right Door of the Right Weapon Bay"),
    /** Gun Door */
    GUN_DOOR (8768, "Gun Door"),
    /** Countermeasure Door Left */
    COUNTERMEASURE_DOOR_LEFT (8800, "Countermeasure Door Left"),
    /** Countermeasure Door Right */
    COUNTERMEASURE_DOOR_RIGHT (8832, "Countermeasure Door Right"),
    /** Hook Door Forward */
    HOOK_DOOR_FORWARD (8864, "Hook Door Forward"),
    /** Hook Door Aft */
    HOOK_DOOR_AFT (8896, "Hook Door Aft"),
    /** Lift Fan Upper Door */
    LIFT_FAN_UPPER_DOOR (8928, "Lift Fan Upper Door"),
    /** Lift Fan Lower Door Left */
    LIFT_FAN_LOWER_DOOR_LEFT (8960, "Lift Fan Lower Door Left"),
    /** Lift Fan Lower Door Right */
    LIFT_FAN_LOWER_DOOR_RIGHT (8992, "Lift Fan Lower Door Right"),
    /** Refuel Probe Door */
    REFUEL_PROBE_DOOR (9024, "Refuel Probe Door"),
    /** Left Engine Nacelle */
    LEFT_ENGINE_NACELLE (9056, "Left Engine Nacelle"),
    /** Right Engine Nacelle */
    RIGHT_ENGINE_NACELLE (9088, "Right Engine Nacelle"),
    /** 1st Left Wheel, May be a sprocket, idler, or road wheel */
    _1ST_LEFT_WHEEL (9120, "1st Left Wheel"),
    /** 1st Right Wheel */
    _1ST_RIGHT_WHEEL (9152, "1st Right Wheel"),
    /** 2nd Left Wheel */
    _2ND_LEFT_WHEEL (9184, "2nd Left Wheel"),
    /** 2nd Right Wheel */
    _2ND_RIGHT_WHEEL (9216, "2nd Right Wheel"),
    /** 3rd Left Wheel */
    _3RD_LEFT_WHEEL (9248, "3rd Left Wheel"),
    /** 3rd Right Wheel */
    _3RD_RIGHT_WHEEL (9280, "3rd Right Wheel"),
    /** 4th Left Wheel */
    _4TH_LEFT_WHEEL (9312, "4th Left Wheel"),
    /** 4th Right Wheel */
    _4TH_RIGHT_WHEEL (9344, "4th Right Wheel"),
    /** 5th Left Wheel */
    _5TH_LEFT_WHEEL (9376, "5th Left Wheel"),
    /** 5th Right Wheel */
    _5TH_RIGHT_WHEEL (9408, "5th Right Wheel"),
    /** 6th Left Wheel */
    _6TH_LEFT_WHEEL (9440, "6th Left Wheel"),
    /** 6th Right Wheel */
    _6TH_RIGHT_WHEEL (9472, "6th Right Wheel"),
    /** 7th Left Wheel */
    _7TH_LEFT_WHEEL (9504, "7th Left Wheel"),
    /** 7th Right Wheel */
    _7TH_RIGHT_WHEEL (9536, "7th Right Wheel"),
    /** 8th Left Wheel */
    _8TH_LEFT_WHEEL (9568, "8th Left Wheel"),
    /** 8th Right Wheel */
    _8TH_RIGHT_WHEEL (9600, "8th Right Wheel"),
    /** 9th Left Wheel */
    _9TH_LEFT_WHEEL (9632, "9th Left Wheel"),
    /** 9th Right Wheel */
    _9TH_RIGHT_WHEEL (9664, "9th Right Wheel"),
    /** 10th Left Wheel */
    _10TH_LEFT_WHEEL (9696, "10th Left Wheel"),
    /** 10th Right Wheel */
    _10TH_RIGHT_WHEEL (9728, "10th Right Wheel"),
    /** Refueling Probe */
    REFUELING_PROBE (9760, "Refueling Probe"),
    /** Steering Wheel */
    STEERING_WHEEL (9792, "Steering Wheel");

    private int value;
    private final String description;

    /** Constructor */
    ArticulatedPartsTypeClass(int value, String description)
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
    public static ArticulatedPartsTypeClass getEnumForValue(int i)
    {
       for(ArticulatedPartsTypeClass val: ArticulatedPartsTypeClass.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ArticulatedPartsTypeClass");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output */
    public void marshal(ByteBuffer byteBuffer)
    {
        byteBuffer.putInt(getValue());
    }

    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static ArticulatedPartsTypeClass unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @return enumeration of interest */
    public static ArticulatedPartsTypeClass unmarshalEnum (ByteBuffer byteBuffer)
    {
        return getEnumForValue(byteBuffer.getInt());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
    
    @Override
    public String toString()
    {
        return "ArticulatedPartsTypeClass: " + getValue() + " " + name();
    }
}
