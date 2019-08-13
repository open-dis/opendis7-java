package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 59 marshal size 32<br>
 * Articulated Parts-Type Class
 */
public enum ArticulatedPartsTypeClass 
{
    /** Not Specified */
    NOT_SPECIFIED (0, "Not Specified"),
    /** rudder */
    RUDDER (1024, "rudder"),
    /** left flap */
    LEFT_FLAP (1056, "left flap"),
    /** right flap */
    RIGHT_FLAP (1088, "right flap"),
    /** left aileron */
    LEFT_AILERON (1120, "left aileron"),
    /** right aileron */
    RIGHT_AILERON (1152, "right aileron"),
    /** helicopter - main rotor */
    HELICOPTER_MAIN_ROTOR (1184, "helicopter - main rotor"),
    /** helicopter - tail rotor */
    HELICOPTER_TAIL_ROTOR (1216, "helicopter - tail rotor"),
    /** other Aircraft Control Surfaces defined as needed */
    OTHER_AIRCRAFT_CONTROL_SURFACES_DEFINED_AS_NEEDED (1248, "other Aircraft Control Surfaces defined as needed"),
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
    /** periscope */
    PERISCOPE (2048, "periscope"),
    /** generic antenna */
    GENERIC_ANTENNA (2080, "generic antenna"),
    /** snorkel */
    SNORKEL (2112, "snorkel"),
    /** other extendible parts defined as needed */
    OTHER_EXTENDIBLE_PARTS_DEFINED_AS_NEEDED (2144, "other extendible parts defined as needed"),
    /** Landing Gear, Nose and Left/Right Main move in unison; intended for low-fidelity simulations and not to be used if the others are used. */
    LANDING_GEAR (3072, "Landing Gear"),
    /** tail hook */
    TAIL_HOOK (3104, "tail hook"),
    /** speed brake */
    SPEED_BRAKE (3136, "speed brake"),
    /** Left Door of Primary Weapon Bay */
    LEFT_DOOR_OF_PRIMARY_WEAPON_BAY (3168, "Left Door of Primary Weapon Bay"),
    /** Right Door of Primary Weapon Bay */
    RIGHT_DOOR_OF_PRIMARY_WEAPON_BAY (3200, "Right Door of Primary Weapon Bay"),
    /** tank or APC hatch */
    TANK_OR_APC_HATCH (3232, "tank or APC hatch"),
    /** wingsweep */
    WINGSWEEP (3264, "wingsweep"),
    /** Bridge launcher */
    BRIDGE_LAUNCHER (3296, "Bridge launcher"),
    /** Bridge section 1 */
    BRIDGE_SECTION_1 (3328, "Bridge section 1"),
    /** Bridge section 2 */
    BRIDGE_SECTION_2 (3360, "Bridge section 2"),
    /** Bridge section 3 */
    BRIDGE_SECTION_3 (3392, "Bridge section 3"),
    /** Primary blade 1 */
    PRIMARY_BLADE_1 (3424, "Primary blade 1"),
    /** Primary blade 2 */
    PRIMARY_BLADE_2 (3456, "Primary blade 2"),
    /** Primary boom */
    PRIMARY_BOOM (3488, "Primary boom"),
    /** Primary launcher arm */
    PRIMARY_LAUNCHER_ARM (3520, "Primary launcher arm"),
    /** other fixed position parts defined as needed */
    OTHER_FIXED_POSITION_PARTS_DEFINED_AS_NEEDED (3552, "other fixed position parts defined as needed"),
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
    /** Primary turret number 1 */
    PRIMARY_TURRET_NUMBER_1 (4096, "Primary turret number 1"),
    /** Primary turret number 2 */
    PRIMARY_TURRET_NUMBER_2 (4128, "Primary turret number 2"),
    /** Primary turret number 3 */
    PRIMARY_TURRET_NUMBER_3 (4160, "Primary turret number 3"),
    /** Primary turret number 4 */
    PRIMARY_TURRET_NUMBER_4 (4192, "Primary turret number 4"),
    /** Primary turret number 5 */
    PRIMARY_TURRET_NUMBER_5 (4224, "Primary turret number 5"),
    /** Primary turret number 6 */
    PRIMARY_TURRET_NUMBER_6 (4256, "Primary turret number 6"),
    /** Primary turret number 7 */
    PRIMARY_TURRET_NUMBER_7 (4288, "Primary turret number 7"),
    /** Primary turret number 8 */
    PRIMARY_TURRET_NUMBER_8 (4320, "Primary turret number 8"),
    /** Primary turret number 9 */
    PRIMARY_TURRET_NUMBER_9 (4352, "Primary turret number 9"),
    /** Primary turret number 10 */
    PRIMARY_TURRET_NUMBER_10 (4384, "Primary turret number 10"),
    /** Primary gun number 1 */
    PRIMARY_GUN_NUMBER_1 (4416, "Primary gun number 1"),
    /** Primary gun number 2 */
    PRIMARY_GUN_NUMBER_2 (4448, "Primary gun number 2"),
    /** Primary gun number 3 */
    PRIMARY_GUN_NUMBER_3 (4480, "Primary gun number 3"),
    /** Primary gun number 4 */
    PRIMARY_GUN_NUMBER_4 (4512, "Primary gun number 4"),
    /** Primary gun number 5 */
    PRIMARY_GUN_NUMBER_5 (4544, "Primary gun number 5"),
    /** Primary gun number 6 */
    PRIMARY_GUN_NUMBER_6 (4576, "Primary gun number 6"),
    /** Primary gun number 7 */
    PRIMARY_GUN_NUMBER_7 (4608, "Primary gun number 7"),
    /** Primary gun number 8 */
    PRIMARY_GUN_NUMBER_8 (4640, "Primary gun number 8"),
    /** Primary gun number 9 */
    PRIMARY_GUN_NUMBER_9 (4672, "Primary gun number 9"),
    /** Primary gun number 10 */
    PRIMARY_GUN_NUMBER_10 (4704, "Primary gun number 10"),
    /** Primary launcher 1 */
    PRIMARY_LAUNCHER_1 (4736, "Primary launcher 1"),
    /** Primary launcher 2 */
    PRIMARY_LAUNCHER_2 (4768, "Primary launcher 2"),
    /** Primary launcher 3 */
    PRIMARY_LAUNCHER_3 (4800, "Primary launcher 3"),
    /** Primary launcher 4 */
    PRIMARY_LAUNCHER_4 (4832, "Primary launcher 4"),
    /** Primary launcher 5 */
    PRIMARY_LAUNCHER_5 (4864, "Primary launcher 5"),
    /** Primary launcher 6 */
    PRIMARY_LAUNCHER_6 (4896, "Primary launcher 6"),
    /** Primary launcher 7 */
    PRIMARY_LAUNCHER_7 (4928, "Primary launcher 7"),
    /** Primary launcher 8 */
    PRIMARY_LAUNCHER_8 (4960, "Primary launcher 8"),
    /** Primary launcher 9 */
    PRIMARY_LAUNCHER_9 (4992, "Primary launcher 9"),
    /** Primary launcher 10 */
    PRIMARY_LAUNCHER_10 (5024, "Primary launcher 10"),
    /** Primary defense systems 1, Point defense systems like Phalanx guns, or visible chaff, flare, or smoke dispensers. */
    PRIMARY_DEFENSE_SYSTEMS_1 (5056, "Primary defense systems 1"),
    /** Primary defense systems 2 */
    PRIMARY_DEFENSE_SYSTEMS_2 (5088, "Primary defense systems 2"),
    /** Primary defense systems 3 */
    PRIMARY_DEFENSE_SYSTEMS_3 (5120, "Primary defense systems 3"),
    /** Primary defense systems 4 */
    PRIMARY_DEFENSE_SYSTEMS_4 (5152, "Primary defense systems 4"),
    /** Primary defense systems 5 */
    PRIMARY_DEFENSE_SYSTEMS_5 (5184, "Primary defense systems 5"),
    /** Primary defense systems 6 */
    PRIMARY_DEFENSE_SYSTEMS_6 (5216, "Primary defense systems 6"),
    /** Primary defense systems 7 */
    PRIMARY_DEFENSE_SYSTEMS_7 (5248, "Primary defense systems 7"),
    /** Primary defense systems 8 */
    PRIMARY_DEFENSE_SYSTEMS_8 (5280, "Primary defense systems 8"),
    /** Primary defense systems 9 */
    PRIMARY_DEFENSE_SYSTEMS_9 (5312, "Primary defense systems 9"),
    /** Primary defense systems 10 */
    PRIMARY_DEFENSE_SYSTEMS_10 (5344, "Primary defense systems 10"),
    /** Primary radar 1, Any radar dish or movable antenna or sensor. */
    PRIMARY_RADAR_1 (5376, "Primary radar 1"),
    /** Primary radar 2 */
    PRIMARY_RADAR_2 (5408, "Primary radar 2"),
    /** Primary radar 3 */
    PRIMARY_RADAR_3 (5440, "Primary radar 3"),
    /** Primary radar 4 */
    PRIMARY_RADAR_4 (5472, "Primary radar 4"),
    /** Primary radar 5 */
    PRIMARY_RADAR_5 (5504, "Primary radar 5"),
    /** Primary radar 6 */
    PRIMARY_RADAR_6 (5536, "Primary radar 6"),
    /** Primary radar 7 */
    PRIMARY_RADAR_7 (5568, "Primary radar 7"),
    /** Primary radar 8 */
    PRIMARY_RADAR_8 (5600, "Primary radar 8"),
    /** Primary radar 9 */
    PRIMARY_RADAR_9 (5632, "Primary radar 9"),
    /** Primary radar 10 */
    PRIMARY_RADAR_10 (5664, "Primary radar 10"),
    /** Secondary turret number 1 */
    SECONDARY_TURRET_NUMBER_1 (5696, "Secondary turret number 1"),
    /** Secondary turret number 2 */
    SECONDARY_TURRET_NUMBER_2 (5728, "Secondary turret number 2"),
    /** Secondary turret number 3 */
    SECONDARY_TURRET_NUMBER_3 (5760, "Secondary turret number 3"),
    /** Secondary turret number 4 */
    SECONDARY_TURRET_NUMBER_4 (5792, "Secondary turret number 4"),
    /** Secondary turret number 5 */
    SECONDARY_TURRET_NUMBER_5 (5824, "Secondary turret number 5"),
    /** Secondary turret number 6 */
    SECONDARY_TURRET_NUMBER_6 (5856, "Secondary turret number 6"),
    /** Secondary turret number 7 */
    SECONDARY_TURRET_NUMBER_7 (5888, "Secondary turret number 7"),
    /** Secondary turret number 8 */
    SECONDARY_TURRET_NUMBER_8 (5920, "Secondary turret number 8"),
    /** Secondary turret number 9 */
    SECONDARY_TURRET_NUMBER_9 (5952, "Secondary turret number 9"),
    /** Secondary turret number 10 */
    SECONDARY_TURRET_NUMBER_10 (5984, "Secondary turret number 10"),
    /** Secondary gun number 1 */
    SECONDARY_GUN_NUMBER_1 (6016, "Secondary gun number 1"),
    /** Secondary gun number 2 */
    SECONDARY_GUN_NUMBER_2 (6048, "Secondary gun number 2"),
    /** Secondary gun number 3 */
    SECONDARY_GUN_NUMBER_3 (6080, "Secondary gun number 3"),
    /** Secondary gun number 4 */
    SECONDARY_GUN_NUMBER_4 (6112, "Secondary gun number 4"),
    /** Secondary gun number 5 */
    SECONDARY_GUN_NUMBER_5 (6144, "Secondary gun number 5"),
    /** Secondary gun number 6 */
    SECONDARY_GUN_NUMBER_6 (6176, "Secondary gun number 6"),
    /** Secondary gun number 7 */
    SECONDARY_GUN_NUMBER_7 (6208, "Secondary gun number 7"),
    /** Secondary gun number 8 */
    SECONDARY_GUN_NUMBER_8 (6240, "Secondary gun number 8"),
    /** Secondary gun number 9 */
    SECONDARY_GUN_NUMBER_9 (6272, "Secondary gun number 9"),
    /** Secondary gun number 10 */
    SECONDARY_GUN_NUMBER_10 (6304, "Secondary gun number 10"),
    /** Secondary launcher 1 */
    SECONDARY_LAUNCHER_1 (6336, "Secondary launcher 1"),
    /** Secondary launcher 2 */
    SECONDARY_LAUNCHER_2 (6368, "Secondary launcher 2"),
    /** Secondary launcher 3 */
    SECONDARY_LAUNCHER_3 (6400, "Secondary launcher 3"),
    /** Secondary launcher 4 */
    SECONDARY_LAUNCHER_4 (6432, "Secondary launcher 4"),
    /** Secondary launcher 5 */
    SECONDARY_LAUNCHER_5 (6464, "Secondary launcher 5"),
    /** Secondary launcher 6 */
    SECONDARY_LAUNCHER_6 (6496, "Secondary launcher 6"),
    /** Secondary launcher 7 */
    SECONDARY_LAUNCHER_7 (6528, "Secondary launcher 7"),
    /** Secondary launcher 8 */
    SECONDARY_LAUNCHER_8 (6560, "Secondary launcher 8"),
    /** Secondary launcher 9 */
    SECONDARY_LAUNCHER_9 (6592, "Secondary launcher 9"),
    /** Secondary launcher 10 */
    SECONDARY_LAUNCHER_10 (6624, "Secondary launcher 10"),
    /** Secondary defense systems 1 */
    SECONDARY_DEFENSE_SYSTEMS_1 (6656, "Secondary defense systems 1"),
    /** Secondary defense systems 2 */
    SECONDARY_DEFENSE_SYSTEMS_2 (6688, "Secondary defense systems 2"),
    /** Secondary defense systems 3 */
    SECONDARY_DEFENSE_SYSTEMS_3 (6720, "Secondary defense systems 3"),
    /** Secondary defense systems 4 */
    SECONDARY_DEFENSE_SYSTEMS_4 (6752, "Secondary defense systems 4"),
    /** Secondary defense systems 5 */
    SECONDARY_DEFENSE_SYSTEMS_5 (6784, "Secondary defense systems 5"),
    /** Secondary defense systems 6 */
    SECONDARY_DEFENSE_SYSTEMS_6 (6816, "Secondary defense systems 6"),
    /** Secondary defense systems 7 */
    SECONDARY_DEFENSE_SYSTEMS_7 (6848, "Secondary defense systems 7"),
    /** Secondary defense systems 8 */
    SECONDARY_DEFENSE_SYSTEMS_8 (6880, "Secondary defense systems 8"),
    /** Secondary defense systems 9 */
    SECONDARY_DEFENSE_SYSTEMS_9 (6912, "Secondary defense systems 9"),
    /** Secondary defense systems 10 */
    SECONDARY_DEFENSE_SYSTEMS_10 (6944, "Secondary defense systems 10"),
    /** Secondary radar 1 */
    SECONDARY_RADAR_1 (6976, "Secondary radar 1"),
    /** Secondary radar 2 */
    SECONDARY_RADAR_2 (7008, "Secondary radar 2"),
    /** Secondary radar 3 */
    SECONDARY_RADAR_3 (7040, "Secondary radar 3"),
    /** Secondary radar 4 */
    SECONDARY_RADAR_4 (7072, "Secondary radar 4"),
    /** Secondary radar 5 */
    SECONDARY_RADAR_5 (7104, "Secondary radar 5"),
    /** Secondary radar 6 */
    SECONDARY_RADAR_6 (7136, "Secondary radar 6"),
    /** Secondary radar 7 */
    SECONDARY_RADAR_7 (7168, "Secondary radar 7"),
    /** Secondary radar 8 */
    SECONDARY_RADAR_8 (7200, "Secondary radar 8"),
    /** Secondary radar 9 */
    SECONDARY_RADAR_9 (7232, "Secondary radar 9"),
    /** Secondary radar 10 */
    SECONDARY_RADAR_10 (7264, "Secondary radar 10"),
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
    /** Wing (or rotor) fold */
    WING_OR_ROTOR_FOLD (7584, "Wing (or rotor) fold"),
    /** Fuselage fold */
    FUSELAGE_FOLD (7616, "Fuselage fold"),
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
    $1ST_LEFT_WHEEL (9120, "1st Left Wheel"),
    /** 1st Right Wheel */
    $1ST_RIGHT_WHEEL (9152, "1st Right Wheel"),
    /** 2nd Left Wheel */
    $2ND_LEFT_WHEEL (9184, "2nd Left Wheel"),
    /** 2nd Right Wheel */
    $2ND_RIGHT_WHEEL (9216, "2nd Right Wheel"),
    /** 3rd Left Wheel */
    $3RD_LEFT_WHEEL (9248, "3rd Left Wheel"),
    /** 3rd Right Wheel */
    $3RD_RIGHT_WHEEL (9280, "3rd Right Wheel"),
    /** 4th Left Wheel */
    $4TH_LEFT_WHEEL (9312, "4th Left Wheel"),
    /** 4th Right Wheel */
    $4TH_RIGHT_WHEEL (9344, "4th Right Wheel"),
    /** 5th Left Wheel */
    $5TH_LEFT_WHEEL (9376, "5th Left Wheel"),
    /** 5th Right Wheel */
    $5TH_RIGHT_WHEEL (9408, "5th Right Wheel"),
    /** 6th Left Wheel */
    $6TH_LEFT_WHEEL (9440, "6th Left Wheel"),
    /** 6th Right Wheel */
    $6TH_RIGHT_WHEEL (9472, "6th Right Wheel"),
    /** 7th Left Wheel */
    $7TH_LEFT_WHEEL (9504, "7th Left Wheel"),
    /** 7th Right Wheel */
    $7TH_RIGHT_WHEEL (9536, "7th Right Wheel"),
    /** 8th Left Wheel */
    $8TH_LEFT_WHEEL (9568, "8th Left Wheel"),
    /** 8th Right Wheel */
    $8TH_RIGHT_WHEEL (9600, "8th Right Wheel"),
    /** 9th Left Wheel */
    $9TH_LEFT_WHEEL (9632, "9th Left Wheel"),
    /** 9th Right Wheel */
    $9TH_RIGHT_WHEEL (9664, "9th Right Wheel"),
    /** 10th Left Wheel */
    $10TH_LEFT_WHEEL (9696, "10th Left Wheel"),
    /** 10th Right Wheel */
    $10TH_RIGHT_WHEEL (9728, "10th Right Wheel");

    private int value;
    private final String description;

    ArticulatedPartsTypeClass(int value, String description)
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

    public static ArticulatedPartsTypeClass getEnumForValue(int i)
    {
       for(ArticulatedPartsTypeClass val: ArticulatedPartsTypeClass.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ArticulatedPartsTypeClass");
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

    public static ArticulatedPartsTypeClass unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    public static ArticulatedPartsTypeClass unmarshalEnum (ByteBuffer buff)
    {
        return getEnumForValue(buff.getInt());
    }

    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
}
