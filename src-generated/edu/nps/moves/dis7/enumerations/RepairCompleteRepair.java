package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 64 marshal size 16<br>
 * RepairCompleteRepair
 */
public enum RepairCompleteRepair 
{
    /** no repairs performed */
    NO_REPAIRS_PERFORMED (0, "no repairs performed"),
    /** all requested repairs performed */
    ALL_REQUESTED_REPAIRS_PERFORMED (1, "all requested repairs performed"),
    /** motor / engine */
    MOTOR_ENGINE (10, "motor / engine"),
    /** starter */
    STARTER (20, "starter"),
    /** alternator */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "alternator"),
    /** generator */
    GENERATOR (40, "generator"),
    /** battery */
    LIVE_ENTITY_DETONATION (50, "battery"),
    /** engine-coolant leak */
    DATA_RELIABLE (60, "engine-coolant leak"),
    /** fuel filter */
    FUEL_FILTER (70, "fuel filter"),
    /** transmission-oil leak */
    TRANSMISSION_OIL_LEAK (80, "transmission-oil leak"),
    /** engine-oil leak */
    ENGINE_OIL_LEAK (90, "engine-oil leak"),
    /** pumps */
    PUMPS (100, "pumps"),
    /** filters */
    FILTERS (110, "filters"),
    /** transmission */
    TRANSMISSION (120, "transmission"),
    /** brakes */
    BRAKES (130, "brakes"),
    /** suspension system */
    SUSPENSION_SYSTEM (140, "suspension system"),
    /** oil filter */
    OIL_FILTER (150, "oil filter"),
    /** hull */
    HULL (1000, "hull"),
    /** airframe */
    AIRFRAME (1010, "airframe"),
    /** truck body */
    TRUCK_BODY (1020, "truck body"),
    /** tank body */
    TANK_BODY (1030, "tank body"),
    /** trailer body */
    TRAILER_BODY (1040, "trailer body"),
    /** turret */
    TURRET (1050, "turret"),
    /** propeller */
    PROPELLER (1500, "propeller"),
    /** filters */
    FILTERS_2 (1520, "filters"),
    /** wheels */
    WHEELS (1540, "wheels"),
    /** tire */
    TIRE (1550, "tire"),
    /** track */
    TRACK (1560, "track"),
    /** gun elevation drive */
    GUN_ELEVATION_DRIVE (2000, "gun elevation drive"),
    /** gun stabilization system */
    GUN_STABILIZATION_SYSTEM (2010, "gun stabilization system"),
    /** gunners primary sight (GPS) */
    GUNNERS_PRIMARY_SIGHT_GPS (2020, "gunners primary sight (GPS)"),
    /** commanders extension to the GPS */
    COMMANDERS_EXTENSION_TO_THE_GPS (2030, "commanders extension to the GPS"),
    /** loading mechanism */
    LOADING_MECHANISM (2040, "loading mechanism"),
    /** gunners auxiliary sight */
    GUNNERS_AUXILIARY_SIGHT (2050, "gunners auxiliary sight"),
    /** gunners control panel */
    GUNNERS_CONTROL_PANEL (2060, "gunners control panel"),
    /** gunners control assembly handle(s) */
    GUNNERS_CONTROL_ASSEMBLY_HANDLES (2070, "gunners control assembly handle(s)"),
    /** commanders control handles/assembly */
    COMMANDERS_CONTROL_HANDLES_ASSEMBLY (2090, "commanders control handles/assembly"),
    /** commanders weapon station */
    COMMANDERS_WEAPON_STATION (2100, "commanders weapon station"),
    /** commanders independent thermal viewer (CITV) */
    COMMANDERS_INDEPENDENT_THERMAL_VIEWER_CITV (2110, "commanders independent thermal viewer (CITV)"),
    /** general weapons */
    GENERAL_WEAPONS (2120, "general weapons"),
    /** fuel transfer pump */
    FUEL_TRANSFER_PUMP (4000, "fuel transfer pump"),
    /** fuel lines */
    FUEL_LINES (4010, "fuel lines"),
    /** gauges */
    GAUGES (4020, "gauges"),
    /** general fuel system */
    GENERAL_FUEL_SYSTEM (4030, "general fuel system"),
    /** electronic warfare systems */
    ELECTRONIC_WARFARE_SYSTEMS (4500, "electronic warfare systems"),
    /** detection systems */
    DETECTION_SYSTEMS (4600, "detection systems"),
    /** detection systems, radio frequency */
    DETECTION_SYSTEMS_RADIO_FREQUENCY (4610, "detection systems, radio frequency"),
    /** detection systems, microwave */
    DETECTION_SYSTEMS_MICROWAVE (4620, "detection systems, microwave"),
    /** detection systems, infrared */
    DETECTION_SYSTEMS_INFRARED (4630, "detection systems, infrared"),
    /** detection systems, laser */
    DETECTION_SYSTEMS_LASER (4640, "detection systems, laser"),
    /** range finders */
    RANGE_FINDERS (4700, "range finders"),
    /** range-only radar */
    RANGE_ONLY_RADAR (4710, "range-only radar"),
    /** laser range finder */
    LASER_RANGE_FINDER (4720, "laser range finder"),
    /** electronic systems */
    ELECTRONIC_SYSTEMS (4800, "electronic systems"),
    /** electronics systems, radio frequency */
    ELECTRONICS_SYSTEMS_RADIO_FREQUENCY (4810, "electronics systems, radio frequency"),
    /** electronics systems, microwave */
    ELECTRONICS_SYSTEMS_MICROWAVE (4820, "electronics systems, microwave"),
    /** electronics systems, infrared */
    ELECTRONICS_SYSTEMS_INFRARED (4830, "electronics systems, infrared"),
    /** electronics systems, laser */
    ELECTRONICS_SYSTEMS_LASER (4840, "electronics systems, laser"),
    /** radios */
    RADIOS (5000, "radios"),
    /** communication systems */
    COMMUNICATION_SYSTEMS (5010, "communication systems"),
    /** intercoms */
    INTERCOMS (5100, "intercoms"),
    /** encoders */
    ENCODERS (5200, "encoders"),
    /** encryption devices */
    ENCRYPTION_DEVICES (5250, "encryption devices"),
    /** decoders */
    DECODERS (5300, "decoders"),
    /** decryption devices */
    DECRYPTION_DEVICES (5350, "decryption devices"),
    /** computers */
    COMPUTERS (5500, "computers"),
    /** navigation and control systems */
    NAVIGATION_AND_CONTROL_SYSTEMS (6000, "navigation and control systems"),
    /** fire control systems */
    FIRE_CONTROL_SYSTEMS (6500, "fire control systems"),
    /** air supply */
    AIR_SUPPLY (8000, "air supply"),
    /** filters */
    FILTERS_3 (8010, "filters"),
    /** water supply */
    WATER_SUPPLY (8020, "water supply"),
    /** refrigeration system */
    REFRIGERATION_SYSTEM (8030, "refrigeration system"),
    /** chemical, biological, and radiological protection */
    CHEMICAL_BIOLOGICAL_AND_RADIOLOGICAL_PROTECTION (8040, "chemical, biological, and radiological protection"),
    /** water wash down systems */
    WATER_WASH_DOWN_SYSTEMS (8050, "water wash down systems"),
    /** decontamination systems */
    DECONTAMINATION_SYSTEMS (8060, "decontamination systems"),
    /** water supply */
    WATER_SUPPLY_2 (9000, "water supply"),
    /** cooling system */
    COOLING_SYSTEM (9010, "cooling system"),
    /** winches */
    WINCHES (9020, "winches"),
    /** catapults */
    CATAPULTS (9030, "catapults"),
    /** cranes */
    CRANES (9040, "cranes"),
    /** launchers */
    LAUNCHERS (9050, "launchers"),
    /** life boats */
    LIFE_BOATS (10000, "life boats"),
    /** landing craft */
    LANDING_CRAFT (10010, "landing craft"),
    /** ejection seats */
    EJECTION_SEATS (10020, "ejection seats");

    private int value;
    private final String description;

    /** Constructor */
    RepairCompleteRepair(int value, String description)
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
      return 16;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static RepairCompleteRepair getEnumForValue(int i)
    {
       for(RepairCompleteRepair val: RepairCompleteRepair.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration RepairCompleteRepair");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static RepairCompleteRepair unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static RepairCompleteRepair unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "RepairCompleteRepair " + getValue() + " " + name(); 
    }
}
