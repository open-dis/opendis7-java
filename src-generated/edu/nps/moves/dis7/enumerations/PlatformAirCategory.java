package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 10 marshal size 8<br>
 * Platform-Air Category
 */
public enum PlatformAirCategory implements Category
{
    /** Other */
    OTHER (0, "Other"),
    /** Fighter/Air Defense */
    FIGHTER_AIR_DEFENSE (1, "Fighter/Air Defense"),
    /** Attack/Strike */
    ATTACK_STRIKE (2, "Attack/Strike"),
    /** Bomber */
    BOMBER (3, "Bomber"),
    /** Cargo/Tanker */
    CARGO_TANKER (4, "Cargo/Tanker"),
    /** ASW/Patrol/Observation */
    ASW_PATROL_OBSERVATION (5, "ASW/Patrol/Observation"),
    /** Electronic Warfare (EW) */
    ELECTRONIC_WARFARE_EW (6, "Electronic Warfare (EW)"),
    /** Reconnaissance */
    RECONNAISSANCE (7, "Reconnaissance"),
    /** Surveillance/C2 (Airborne Early Warning) */
    SURVEILLANCE_C2_AIRBORNE_EARLY_WARNING (8, "Surveillance/C2 (Airborne Early Warning)"),
    /** Air-Sea Rescue (ASR) */
    AIR_SEA_RESCUE_ASR (9, "Air-Sea Rescue (ASR)"),
    /** Attack Helicopter */
    ATTACK_HELICOPTER (20, "Attack Helicopter"),
    /** Utility Helicopter */
    UTILITY_HELICOPTER (21, "Utility Helicopter"),
    /** Anti-Submarine Warfare/Patrol Helicopter */
    ANTI_SUBMARINE_WARFARE_PATROL_HELICOPTER (22, "Anti-Submarine Warfare/Patrol Helicopter"),
    /** Cargo Helicopter */
    CARGO_HELICOPTER (23, "Cargo Helicopter"),
    /** Observation Helicopter */
    OBSERVATION_HELICOPTER (24, "Observation Helicopter"),
    /** Special Operations Helicopter */
    SPECIAL_OPERATIONS_HELICOPTER (25, "Special Operations Helicopter"),
    /** Trainer */
    TRAINER (40, "Trainer"),
    /** Unmanned */
    UNMANNED (50, "Unmanned"),
    /** Non-Combatant Commercial Aircraft */
    NON_COMBATANT_COMMERCIAL_AIRCRAFT (57, "Non-Combatant Commercial Aircraft"),
    /** PlatformAirCivilianUltralightNonrigidWingAircraftSubcategories */    CIVILIAN_ULTRALIGHT_AIRCRAFT_NON_RIGID_WING_2 (80, "Civilian Ultralight Aircraft, Non-rigid Wing"),
    /** PlatformAirCivilianUltralightRigidWingAircraftSubcategories */    CIVILIAN_ULTRALIGHT_AIRCRAFT_RIGID_WING_2 (81, "Civilian Ultralight Aircraft, Rigid Wing"),
    /** PlatformAirCivilianGliderSubcategories */    CIVILIAN_FIXED_WING_AIRCRAFT_GLIDER_2 (83, "Civilian Fixed Wing Aircraft, Glider"),
    /** PlatformAirCivilianFixedWingAircraftSubcategories */    CIVILIAN_FIXED_WING_AIRCRAFT_LIGHT_SPORT_UP_TO_1320_LBS_600_KG_2 (84, "Civilian Fixed Wing Aircraft, Light Sport (up to 1320 lbs / 600 kg)"),
    /** PlatformAirCivilianFixedWingAircraftSubcategories */    CIVILIAN_FIXED_WING_AIRCRAFT_SMALL_UP_TO_12_500_LBS_5_670_KG_2 (85, "Civilian Fixed Wing Aircraft, Small (up to 12,500 lbs / 5,670 kg)"),
    /** PlatformAirCivilianFixedWingAircraftSubcategories */    CIVILIAN_FIXED_WING_AIRCRAFT_MEDIUM_UP_TO_41_000_LBS_18_597_KG_2 (86, "Civilian Fixed Wing Aircraft, Medium (up to 41,000 lbs / 18,597 kg)"),
    /** PlatformAirCivilianFixedWingAircraftSubcategories */    CIVILIAN_FIXED_WING_AIRCRAFT_LARGE_UP_TO_255_000_LBS_115_666_KG_2 (87, "Civilian Fixed Wing Aircraft, Large (up to 255,000 lbs / 115,666 kg)"),
    /** PlatformAirCivilianFixedWingAircraftSubcategories */    CIVILIAN_FIXED_WING_AIRCRAFT_HEAVY_ABOVE_255_000_LBS_115_666_KG_2 (88, "Civilian Fixed Wing Aircraft, Heavy (above 255,000 lbs / 115,666 kg)"),
    /** PlatformAirCivilianHelicopterSubcategories */    CIVILIAN_HELICOPTER_SMALL_UP_TO_7_000_LBS_3_175_KG_2 (90, "Civilian Helicopter, Small (up to 7,000 lbs / 3,175 kg)"),
    /** PlatformAirCivilianHelicopterSubcategories */    CIVILIAN_HELICOPTER_MEDIUM_UP_TO_20_000_LBS_9_072_KG_2 (91, "Civilian Helicopter, Medium (up to 20,000 lbs / 9,072 kg)"),
    /** PlatformAirCivilianHelicopterSubcategories */    CIVILIAN_HELICOPTER_LARGE_ABOVE_20_000_LBS_9_072_KG_2 (92, "Civilian Helicopter, Large (above 20,000 lbs / 9,072 kg)"),
    /** Civilian Autogyro */
    CIVILIAN_AUTOGYRO (93, "Civilian Autogyro"),
    /** PlatformAirCivilianLighterthanAirBalloonSubcategories */    CIVILIAN_LIGHTER_THAN_AIR_BALLOON_2 (100, "Civilian Lighter than Air, Balloon"),
    /** PlatformAirCivilianLighterthanAirAirshipSubcategories */    CIVILIAN_LIGHTER_THAN_AIR_AIRSHIP_2 (101, "Civilian Lighter than Air, Airship");

    private int value;
    private final String description;

    PlatformAirCategory(int value, String description)
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

    public static PlatformAirCategory getEnumForValue(int i)
    {
       for(PlatformAirCategory val: PlatformAirCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCategory");
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

    public static PlatformAirCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformAirCategory unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformAirCategory: " + name() + ": " + getValue(); 
    }
}
