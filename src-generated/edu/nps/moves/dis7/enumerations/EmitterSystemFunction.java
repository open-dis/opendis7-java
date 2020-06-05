package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 76 marshal size 8<br>
 * Emitter System Function
 */
public enum EmitterSystemFunction 
{
    /** Other */
    OTHER (0, "Other"),
    /** Multi-function */
    MULTI_FUNCTION (1, "Multi-function"),
    /** Early Warning/Surveillance */
    EARLY_WARNING_SURVEILLANCE (2, "Early Warning/Surveillance"),
    /** Height Finder */
    HEIGHT_FINDER (3, "Height Finder"),
    /** Fire Control */
    FIRE_CONTROL (4, "Fire Control"),
    /** Acquisition/Detection */
    ACQUISITION_DETECTION (5, "Acquisition/Detection"),
    /** Tracker */
    TRACKER (6, "Tracker"),
    /** Guidance/Illumination */
    GUIDANCE_ILLUMINATION (7, "Guidance/Illumination"),
    /** Firing point/launch point location */
    FIRING_POINT_LAUNCH_POINT_LOCATION (8, "Firing point/launch point location"),
    /** Range-Only */
    RANGE_ONLY (9, "Range-Only"),
    /** Radar Altimeter */
    RADAR_ALTIMETER (10, "Radar Altimeter"),
    /** Imaging */
    IMAGING (11, "Imaging"),
    /** Motion Detection */
    MOTION_DETECTION (12, "Motion Detection"),
    /** Navigation */
    NAVIGATION (13, "Navigation"),
    /** Weather / Meteorological */
    WEATHER_METEOROLOGICAL (14, "Weather / Meteorological"),
    /** Instrumentation */
    INSTRUMENTATION (15, "Instrumentation"),
    /** Identification/Classification (including IFF) */
    IDENTIFICATION_CLASSIFICATION_INCLUDING_IFF (16, "Identification/Classification (including IFF)"),
    /** AAA (Anti-Aircraft Artillery) Fire Control */
    AAA_ANTI_AIRCRAFT_ARTILLERY_FIRE_CONTROL (17, "AAA (Anti-Aircraft Artillery) Fire Control"),
    /** Air Search/Bomb */
    AIR_SEARCH_BOMB (18, "Air Search/Bomb"),
    /** Air Intercept */
    AIR_INTERCEPT (19, "Air Intercept"),
    /** Altimeter */
    ALTIMETER (20, "Altimeter"),
    /** Air Mapping */
    AIR_MAPPING (21, "Air Mapping"),
    /** Air Traffic Control */
    AIR_TRAFFIC_CONTROL (22, "Air Traffic Control"),
    /** Beacon */
    BEACON (23, "Beacon"),
    /** Battlefield Surveillance */
    BATTLEFIELD_SURVEILLANCE (24, "Battlefield Surveillance"),
    /** Ground Control Approach */
    GROUND_CONTROL_APPROACH (25, "Ground Control Approach"),
    /** Ground Control Intercept */
    GROUND_CONTROL_INTERCEPT (26, "Ground Control Intercept"),
    /** Coastal Surveillance */
    COASTAL_SURVEILLANCE (27, "Coastal Surveillance"),
    /** Decoy/Mimic */
    DECOY_MIMIC (28, "Decoy/Mimic"),
    /** Data Transmission */
    DATA_TRANSMISSION (29, "Data Transmission"),
    /** Earth Surveillance */
    EARTH_SURVEILLANCE (30, "Earth Surveillance"),
    /** Gun Lay Beacon */
    GUN_LAY_BEACON (31, "Gun Lay Beacon"),
    /** Ground Mapping */
    GROUND_MAPPING (32, "Ground Mapping"),
    /** Harbor Surveillance */
    HARBOR_SURVEILLANCE (33, "Harbor Surveillance"),
    /** IFF (Identify Friend or Foe) */
    IFF_IDENTIFY_FRIEND_OR_FOE (34, "IFF (Identify Friend or Foe)"),
    /** ILS (Instrument Landing System) */
    ILS_INSTRUMENT_LANDING_SYSTEM (35, "ILS (Instrument Landing System)"),
    /** Ionospheric Sound */
    IONOSPHERIC_SOUND (36, "Ionospheric Sound"),
    /** Interrogator */
    INTERROGATOR (37, "Interrogator"),
    /** Barrage Jamming */
    BARRAGE_JAMMING (38, "Barrage Jamming"),
    /** Click Jamming */
    CLICK_JAMMING (39, "Click Jamming"),
    /** Deceptive Jamming */
    DECEPTIVE_JAMMING (40, "Deceptive Jamming"),
    /** Frequency Swept Jamming */
    FREQUENCY_SWEPT_JAMMING (41, "Frequency Swept Jamming"),
    /** Jammer */
    JAMMER (42, "Jammer"),
    /** Noise Jamming */
    NOISE_JAMMING (43, "Noise Jamming"),
    /** Pulsed Jamming */
    PULSED_JAMMING (44, "Pulsed Jamming"),
    /** Repeater Jamming */
    REPEATER_JAMMING (45, "Repeater Jamming"),
    /** Spot Noise Jamming */
    SPOT_NOISE_JAMMING (46, "Spot Noise Jamming"),
    /** Missile Acquisition */
    MISSILE_ACQUISITION (47, "Missile Acquisition"),
    /** Missile Downlink */
    MISSILE_DOWNLINK (48, "Missile Downlink"),
    /** Meteorological */
    METEOROLOGICAL (49, "Meteorological"),
    /** Space */
    SPACE (50, "Space"),
    /** Surface Search */
    SURFACE_SEARCH (51, "Surface Search"),
    /** Shell Tracking */
    SHELL_TRACKING (52, "Shell Tracking"),
    /** Television */
    TELEVISION (56, "Television"),
    /** Unknown */
    UNKNOWN (57, "Unknown"),
    /** Video Remoting */
    VIDEO_REMOTING (58, "Video Remoting"),
    /** Experimental or Training */
    EXPERIMENTAL_OR_TRAINING (59, "Experimental or Training"),
    /** Missile Guidance */
    MISSILE_GUIDANCE (60, "Missile Guidance"),
    /** Missile Homing */
    MISSILE_HOMING (61, "Missile Homing"),
    /** Missile Tracking */
    MISSILE_TRACKING (62, "Missile Tracking"),
    /** Jamming, noise */
    JAMMING_NOISE (64, "Jamming, noise"),
    /** Jamming, deception */
    JAMMING_DECEPTION (65, "Jamming, deception"),
    /** Decoy */
    DECOY (66, "Decoy"),
    /** Navigation/Distance Measuring Equipment */
    NAVIGATION_DISTANCE_MEASURING_EQUIPMENT (71, "Navigation/Distance Measuring Equipment"),
    /** Terrain Following */
    TERRAIN_FOLLOWING (72, "Terrain Following"),
    /** Weather Avoidance */
    WEATHER_AVOIDANCE (73, "Weather Avoidance"),
    /** Proximity Fuse */
    PROXIMITY_FUSE (74, "Proximity Fuse"),
    /** Instrumentation */
    INSTRUMENTATION_2 (75, "Instrumentation"),
    /** Radiosonde */
    RADIOSONDE (76, "Radiosonde"),
    /** Sonobuoy */
    SONOBUOY (77, "Sonobuoy"),
    /** Bathythermal Sensor */
    BATHYTHERMAL_SENSOR (78, "Bathythermal Sensor"),
    /** Towed Counter Measure */
    TOWED_COUNTER_MEASURE (79, "Towed Counter Measure"),
    /** Dipping Sonar */
    DIPPING_SONAR (80, "Dipping Sonar"),
    /** Towed Acoustic Sensor */
    TOWED_ACOUSTIC_SENSOR (81, "Towed Acoustic Sensor"),
    /** Weapon, non-lethal */
    WEAPON_NON_LETHAL (96, "Weapon, non-lethal"),
    /** Weapon, lethal */
    WEAPON_LETHAL (97, "Weapon, lethal"),
    /** Test Equipment */
    TEST_EQUIPMENT (98, "Test Equipment"),
    /** Acquisition Track */
    ACQUISITION_TRACK (99, "Acquisition Track"),
    /** Track Guidance */
    TRACK_GUIDANCE (100, "Track Guidance"),
    /** Guidance Illumination Track Acquisition */
    GUIDANCE_ILLUMINATION_TRACK_ACQUISITION (101, "Guidance Illumination Track Acquisition"),
    /** Search Acquisition */
    SEARCH_ACQUISITION (102, "Search Acquisition");

    private int value;
    private final String description;

    EmitterSystemFunction(int value, String description)
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

    public static EmitterSystemFunction getEnumForValue(int i)
    {
       for(EmitterSystemFunction val: EmitterSystemFunction.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EmitterSystemFunction");
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

    public static EmitterSystemFunction unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static EmitterSystemFunction unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "EmitterSystemFunction: " + name() + ": " + getValue(); 
    }
}
