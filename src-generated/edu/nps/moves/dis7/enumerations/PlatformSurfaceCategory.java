package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 11 marshal size 8<br>
 * PlatformSurfaceCategory
 */
public enum PlatformSurfaceCategory implements Category
{
    /** Other */
    OTHER (0, "Other"),
    /** Carrier */
    CARRIER (1, "Carrier"),
    /** Command Ship/Cruiser */
    COMMAND_SHIP_CRUISER (2, "Command Ship/Cruiser"),
    /** Guided Missile Cruiser */
    GUIDED_MISSILE_CRUISER (3, "Guided Missile Cruiser"),
    /** Guided Missile Destroyer (DDG) */
    GUIDED_MISSILE_DESTROYER_DDG (4, "Guided Missile Destroyer (DDG)"),
    /** Destroyer (DD) */
    DESTROYER_DD (5, "Destroyer (DD)"),
    /** Guided Missile Frigate (FFG) */
    GUIDED_MISSILE_FRIGATE_FFG (6, "Guided Missile Frigate (FFG)"),
    /** Light/Patrol Craft */
    LIGHT_PATROL_CRAFT (7, "Light/Patrol Craft"),
    /** Mine Countermeasure Ship/Craft */
    MINE_COUNTERMEASURE_SHIP_CRAFT (8, "Mine Countermeasure Ship/Craft"),
    /** Dock Landing Ship */
    DOCK_LANDING_SHIP (9, "Dock Landing Ship"),
    /** Tank Landing Ship */
    TANK_LANDING_SHIP (10, "Tank Landing Ship"),
    /** Landing Craft */
    LANDING_CRAFT (11, "Landing Craft"),
    /** Light Carrier */
    LIGHT_CARRIER (12, "Light Carrier"),
    /** Cruiser/Helicopter Carrier */
    CRUISER_HELICOPTER_CARRIER (13, "Cruiser/Helicopter Carrier"),
    /** Hydrofoil */
    HYDROFOIL (14, "Hydrofoil"),
    /** Air Cushion/Surface Effect */
    AIR_CUSHION_SURFACE_EFFECT (15, "Air Cushion/Surface Effect"),
    /** Auxiliary */
    AUXILIARY (16, "Auxiliary"),
    /** Auxiliary, Merchant Marine */
    AUXILIARY_MERCHANT_MARINE (17, "Auxiliary, Merchant Marine"),
    /** Utility */
    UTILITY (18, "Utility"),
    /** Unmanned Surface Vehicle (USV) */
    UNMANNED_SURFACE_VEHICLE_USV (19, "Unmanned Surface Vehicle (USV)"),
    /** Littoral Combat Ships (LCS) */
    LITTORAL_COMBAT_SHIPS_LCS (20, "Littoral Combat Ships (LCS)"),
    /** Surveillance Ship */
    SURVEILLANCE_SHIP (21, "Surveillance Ship"),
    /** Frigate (including Corvette) */
    LIVE_ENTITY_DETONATION (50, "Frigate (including Corvette)"),
    /** Battleship */
    CREATE_ENTITY_RELIABLE (51, "Battleship"),
    /** Heavy Cruiser */
    REMOVE_ENTITY_RELIABLE (52, "Heavy Cruiser"),
    /** Destroyer Tender */
    START_RESUME_RELIABLE (53, "Destroyer Tender"),
    /** Amphibious Assault Ship */
    STOP_FREEZE_RELIABLE (54, "Amphibious Assault Ship"),
    /** Amphibious Cargo Ship */
    ACKNOWLEDGE_RELIABLE (55, "Amphibious Cargo Ship"),
    /** Amphibious Transport Dock */
    ACTION_REQUEST_RELIABLE (56, "Amphibious Transport Dock"),
    /** Ammunition Ship */
    ACTION_RESPONSE_RELIABLE (57, "Ammunition Ship"),
    /** Combat Stores Ship */
    DATA_QUERY_RELIABLE (58, "Combat Stores Ship"),
    /** Surveillance Towed Array Sonar System (SURTASS) */
    SET_DATA_RELIABLE (59, "Surveillance Towed Array Sonar System (SURTASS)"),
    /** Fast Combat Support Ship */
    DATA_RELIABLE (60, "Fast Combat Support Ship"),
    /** Non-Combatant Ship */
    EVENT_REPORT_RELIABLE (61, "Non-Combatant Ship"),
    /** Coast Guard Cutters */
    COMMENT_RELIABLE (62, "Coast Guard Cutters"),
    /** Coast Guard Boats */
    RECORD_RELIABLE (63, "Coast Guard Boats"),
    /** Fast Attack Craft */
    SET_RECORD_RELIABLE	 (64, "Fast Attack Craft"),
    /** PlatformSurfacePassengerVesselSubcategories */    PASSENGER_VESSEL_GROUP_1_MERCHANT_2 (80, "Passenger Vessel (Group 1 Merchant)"),
    /** PlatformSurfaceDryCargoShipSubcategories */    DRY_CARGO_SHIP_GROUP_2_MERCHANT_2 (81, "Dry Cargo Ship (Group 2 Merchant)"),
    /** PlatformSurfaceTankerSubcategories */    TANKER_GROUP_3_MERCHANT_2 (82, "Tanker (Group 3 Merchant)"),
    /** PlatformSurfaceSupportVesselSubcategories */    SUPPORT_VESSEL_2 (83, "Support Vessel"),
    /** PlatformSurfacePrivateMotorboatSubcategories */    PRIVATE_MOTORBOAT_2 (84, "Private Motorboat"),
    /** PlatformSurfacePrivateSailboatSubcategories */    PRIVATE_SAILBOAT_2 (85, "Private Sailboat"),
    /** PlatformSurfaceFishingVesselSubcategories */    FISHING_VESSEL_2 (86, "Fishing Vessel"),
    /** PlatformSurfaceOtherVesselsSubcategories */    OTHER_VESSELS_2 (87, "Other Vessels"),
    /** Search and Rescue Vessels */
    SEARCH_AND_RESCUE_VESSELS (100, "Search and Rescue Vessels"),
    /** LifeSavingEquipment */    LIFE_SAVING_EQUIPMENT_2 (101, "Life-Saving Equipment");

    private int value;
    private final String description;

    /** Constructor */
    PlatformSurfaceCategory(int value, String description)
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
    public static PlatformSurfaceCategory getEnumForValue(int i)
    {
       for(PlatformSurfaceCategory val: PlatformSurfaceCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfaceCategory");
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
    public static PlatformSurfaceCategory unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformSurfaceCategory unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "PlatformSurfaceCategory " + padding + getValue() + " " + name();
    }
}
