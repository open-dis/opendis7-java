package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 10 marshal size 8<br>
 * PlatformAirCategory
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
    LIVE_ENTITY_DETONATION (50, "Unmanned"),
    /** Non-Combatant Commercial Aircraft */
    ACTION_RESPONSE_RELIABLE (57, "Non-Combatant Commercial Aircraft"),
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

    /** Constructor */
    PlatformAirCategory(int value, String description)
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
    public static PlatformAirCategory getEnumForValue(int i)
    {
       for(PlatformAirCategory val: PlatformAirCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCategory");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    private boolean TRACE = false;

    /** Set tracing on/off for this object 
     * @param value whether tracing is on or off */
    public void setTRACE (boolean value)
    {
        TRACE = value;
    }

    /** Whether tracing is on or off for this object
     * @return whether tracing is on or off */
    public boolean getTRACE ()
    {
        return TRACE;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static PlatformAirCategory unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        if (this.getClass().getName().endsWith("DisPduType") && (getValue() < 10))
            padding = "0"; // leading zero for column spacing
        String result = "DisPduType " + padding + getValue() + " " + name();
        if (getTRACE())
            System.out.println ("*** enum " + this.getClass().getName() + " name=" + name() + ", value=" + getValue() + "; " +
               result); // debug diagnostic
        return result;
    }
}
