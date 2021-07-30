package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 9 marshal size 8<br>
 * PlatformLandCategory
 */
public enum PlatformLandCategory implements Category
{
    /** Other */
    OTHER (0, "Other"),
    /** Tank */
    TANK (1, "Tank"),
    /** Armored Fighting Vehicle, FV, APC, SP mortars, armored cars, chemical reconnaissance, Anti-Tank guided missile launchers, etc. */
    ARMORED_FIGHTING_VEHICLE (2, "Armored Fighting Vehicle"),
    /** Armored Utility Vehicle, Engineering vehicle, tracked load carriers, towing vehicles, recovery vehicles, AVLB, etc. */
    ARMORED_UTILITY_VEHICLE (3, "Armored Utility Vehicle"),
    /** Self-Propelled Artillery */
    SELF_PROPELLED_ARTILLERY (4, "Self-Propelled Artillery"),
    /** Towed Artillery, Anti-Tank guns, guns and howitzers */
    TOWED_ARTILLERY (5, "Towed Artillery"),
    /** Small Wheeled Utility Vehicle, 0-1.25 tons */
    SMALL_WHEELED_UTILITY_VEHICLE (6, "Small Wheeled Utility Vehicle"),
    /** Large Wheeled Utility Vehicle, Greater than 1.25 tons */
    LARGE_WHEELED_UTILITY_VEHICLE (7, "Large Wheeled Utility Vehicle"),
    /** Small Tracked Utility Vehicle, 0-4999 kg weight load */
    SMALL_TRACKED_UTILITY_VEHICLE (8, "Small Tracked Utility Vehicle"),
    /** Large Tracked Utility Vehicle, Greater than 4999 kg weight load */
    LARGE_TRACKED_UTILITY_VEHICLE (9, "Large Tracked Utility Vehicle"),
    /** Mortar */
    MORTAR (10, "Mortar"),
    /** Mine Plow */
    MINE_PLOW (11, "Mine Plow"),
    /** Mine Rake */
    MINE_RAKE (12, "Mine Rake"),
    /** Mine Roller */
    MINE_ROLLER (13, "Mine Roller"),
    /** Cargo Trailer */
    CARGO_TRAILER (14, "Cargo Trailer"),
    /** Fuel Trailer */
    FUEL_TRAILER (15, "Fuel Trailer"),
    /** Generator Trailer */
    GENERATOR_TRAILER (16, "Generator Trailer"),
    /** Water Trailer */
    WATER_TRAILER (17, "Water Trailer"),
    /** Engineer Equipment */
    ENGINEER_EQUIPMENT (18, "Engineer Equipment"),
    /** Heavy Equipment Transport Trailer */
    HEAVY_EQUIPMENT_TRANSPORT_TRAILER (19, "Heavy Equipment Transport Trailer"),
    /** Maintenance Equipment Trailer */
    MAINTENANCE_EQUIPMENT_TRAILER (20, "Maintenance Equipment Trailer"),
    /** Limber */
    LIMBER (21, "Limber"),
    /** Chemical Decontamination Trailer */
    CHEMICAL_DECONTAMINATION_TRAILER (22, "Chemical Decontamination Trailer"),
    /** Warning System */
    WARNING_SYSTEM (23, "Warning System"),
    /** Train - Engine */
    TRAIN_ENGINE (24, "Train - Engine"),
    /** Train - Car */
    TRAIN_CAR (25, "Train - Car"),
    /** Train - Caboose */
    TRAIN_CABOOSE (26, "Train - Caboose"),
    /** Civilian Vehicle, Civilian land vehicles were moved to a group of Category values starting at 80 */
    CIVILIAN_VEHICLE (27, "Civilian Vehicle"),
    /** Air Defense / Missile Defense Unit Equipment */
    IDENTIFICATION_FRIEND_OR_FOE (28, "Air Defense / Missile Defense Unit Equipment"),
    /** Command, Control, Communications, and Intelligence (C3I) System */
    COMMAND_CONTROL_COMMUNICATIONS_AND_INTELLIGENCE_C3I_SYSTEM (29, "Command, Control, Communications, and Intelligence (C3I) System"),
    /** Operations Facility */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Operations Facility"),
    /** Intelligence Facility */
    INTELLIGENCE_FACILITY (31, "Intelligence Facility"),
    /** Surveillance Facility */
    SURVEILLANCE_FACILITY (32, "Surveillance Facility"),
    /** Communications Facility */
    COMMUNICATIONS_FACILITY (33, "Communications Facility"),
    /** Command Facility */
    COMMAND_FACILITY (34, "Command Facility"),
    /** C4I Facility */
    C4I_FACILITY (35, "C4I Facility"),
    /** Control Facility */
    CONTROL_FACILITY (36, "Control Facility"),
    /** Fire Control Facility */
    FIRE_CONTROL_FACILITY (37, "Fire Control Facility"),
    /** Missile Defense Facility */
    MISSILE_DEFENSE_FACILITY (38, "Missile Defense Facility"),
    /** Field Command Post */
    FIELD_COMMAND_POST (39, "Field Command Post"),
    /** Observation Post */
    OBSERVATION_POST (40, "Observation Post"),
    /** Unmanned */
    LIVE_ENTITY_DETONATION (50, "Unmanned"),
    /** PlatformLandMotorcycleSubcategories */    MOTORCYCLE_2 (80, "Motorcycle"),
    /** PlatformLandCarSubcategories */    CAR_2 (81, "Car"),
    /** PlatformLandBusSubcategories */    BUS_2 (82, "Bus"),
    /** PlatformLandSingleUnitCargoTruckSubcategories */    SINGLE_UNIT_CARGO_TRUCK_2 (83, "Single Unit Cargo Truck"),
    /** PlatformLandSingleUnitUtilityEmergencyTruckSubcategories */    SINGLE_UNIT_UTILITY_EMERGENCY_TRUCK_2 (84, "Single Unit Utility/Emergency Truck"),
    /** PlatformLandMultipleUnitCargoTruckSubcategories */    MULTIPLE_UNIT_CARGO_TRUCK_2 (85, "Multiple Unit Cargo Truck"),
    /** PlatformLandMultipleUnitUtilityEmergencyTruckSubcategories */    MULTIPLE_UNIT_UTILITY_EMERGENCY_TRUCK_2 (86, "Multiple Unit Utility/Emergency Truck"),
    /** PlatformLandConstructionSpecialtyVehicleSubcategories */    CONSTRUCTION_SPECIALTY_VEHICLE_2 (87, "Construction Specialty Vehicle"),
    /** PlatformLandFarmSpecialtyVehicleSubcategories */    FARM_SPECIALTY_VEHICLE_2 (88, "Farm Specialty Vehicle"),
    /** PlatformLandTrailerSubcategories */    TRAILER_2 (89, "Trailer"),
    /** PlatformLandRecreationalSubcategories */    RECREATIONAL_2 (90, "Recreational"),
    /** PlatformLandNonmotorizedSubcategories */    NON_MOTORIZED_2 (91, "Non-motorized"),
    /** PlatformLandTrainsSubcategories */    TRAINS_2 (92, "Trains"),
    /** PlatformLandUtilityEmergencyCarSubcategories */    UTILITY_EMERGENCY_CAR_2 (93, "Utility/Emergency Car");

    private int value;
    private final String description;

    /** Constructor */
    PlatformLandCategory(int value, String description)
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
    public static PlatformLandCategory getEnumForValue(int i)
    {
       for(PlatformLandCategory val: PlatformLandCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandCategory");
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
    public static PlatformLandCategory unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformLandCategory unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
