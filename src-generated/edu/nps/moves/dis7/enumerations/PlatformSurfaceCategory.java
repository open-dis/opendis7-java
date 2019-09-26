package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 11 marshal size 8<br>
 * Platform-Surface Category
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
    FRIGATE_INCLUDING_CORVETTE (50, "Frigate (including Corvette)"),
    /** Battleship */
    BATTLESHIP (51, "Battleship"),
    /** Heavy Cruiser */
    HEAVY_CRUISER (52, "Heavy Cruiser"),
    /** Destroyer Tender */
    DESTROYER_TENDER (53, "Destroyer Tender"),
    /** Amphibious Assault Ship */
    AMPHIBIOUS_ASSAULT_SHIP (54, "Amphibious Assault Ship"),
    /** Amphibious Cargo Ship */
    AMPHIBIOUS_CARGO_SHIP (55, "Amphibious Cargo Ship"),
    /** Amphibious Transport Dock */
    AMPHIBIOUS_TRANSPORT_DOCK (56, "Amphibious Transport Dock"),
    /** Ammunition Ship */
    AMMUNITION_SHIP (57, "Ammunition Ship"),
    /** Combat Stores Ship */
    COMBAT_STORES_SHIP (58, "Combat Stores Ship"),
    /** Surveillance Towed Array Sonar System (SURTASS) */
    SURVEILLANCE_TOWED_ARRAY_SONAR_SYSTEM_SURTASS (59, "Surveillance Towed Array Sonar System (SURTASS)"),
    /** Fast Combat Support Ship */
    FAST_COMBAT_SUPPORT_SHIP (60, "Fast Combat Support Ship"),
    /** Non-Combatant Ship */
    NON_COMBATANT_SHIP (61, "Non-Combatant Ship"),
    /** Coast Guard Cutters */
    COAST_GUARD_CUTTERS (62, "Coast Guard Cutters"),
    /** Coast Guard Boats */
    COAST_GUARD_BOATS (63, "Coast Guard Boats"),
    /** Fast Attack Craft */
    FAST_ATTACK_CRAFT (64, "Fast Attack Craft"),
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

    PlatformSurfaceCategory(int value, String description)
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

    public static PlatformSurfaceCategory getEnumForValue(int i)
    {
       for(PlatformSurfaceCategory val: PlatformSurfaceCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformSurfaceCategory");
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

    public static PlatformSurfaceCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformSurfaceCategory unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "PlatformSurfaceCategory: " + name() + ": " + getValue(); 
    }
}
