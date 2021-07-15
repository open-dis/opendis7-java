package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 76 marshal size 8<br>
 * EmitterSystemFunction
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
    IDENTIFICATION_FRIEND_OR_FOE (28, "Decoy/Mimic"),
    /** Data Transmission */
    DATA_TRANSMISSION (29, "Data Transmission"),
    /** Earth Surveillance */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Earth Surveillance"),
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
    TIME_SPACE_POSITION_INFORMATION (46, "Spot Noise Jamming"),
    /** Missile Acquisition */
    MISSILE_ACQUISITION (47, "Missile Acquisition"),
    /** Missile Downlink */
    MISSILE_DOWNLINK (48, "Missile Downlink"),
    /** Meteorological */
    LIVE_ENTITY_FIRE (49, "Meteorological"),
    /** Space */
    LIVE_ENTITY_DETONATION (50, "Space"),
    /** Surface Search */
    CREATE_ENTITY_RELIABLE (51, "Surface Search"),
    /** Shell Tracking */
    REMOVE_ENTITY_RELIABLE (52, "Shell Tracking"),
    /** Television */
    ACTION_REQUEST_RELIABLE (56, "Television"),
    /** Unknown */
    ACTION_RESPONSE_RELIABLE (57, "Unknown"),
    /** Video Remoting */
    DATA_QUERY_RELIABLE (58, "Video Remoting"),
    /** Experimental or Training */
    SET_DATA_RELIABLE (59, "Experimental or Training"),
    /** Missile Guidance */
    DATA_RELIABLE (60, "Missile Guidance"),
    /** Missile Homing */
    EVENT_REPORT_RELIABLE (61, "Missile Homing"),
    /** Missile Tracking */
    COMMENT_RELIABLE (62, "Missile Tracking"),
    /** Jamming, noise */
    SET_RECORD_RELIABLE	 (64, "Jamming, noise"),
    /** Jamming, deception */
    RECORD_QUERY_RELIABLE (65, "Jamming, deception"),
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

    /** Constructor */
    EmitterSystemFunction(int value, String description)
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
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static EmitterSystemFunction getEnumForValue(int i)
    {
       for(EmitterSystemFunction val: EmitterSystemFunction.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EmitterSystemFunction");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EmitterSystemFunction unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        String padding = new String();
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "EmitterSystemFunction " + padding + getValue() + " " + name();
    }
}
