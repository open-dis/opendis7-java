package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 431 marshal size 8<br>
 * Platform-Land-Single Unit Utility Emergency Truck Subcategories<br>
 * Subcategories for Land Platform Category 84
 */
public enum PlatformLandSingleUnitUtilityEmergencyTruckSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Ambulance Truck */
    AMBULANCE_TRUCK (1, "Ambulance Truck"),
    /** Fire/Paramedic Truck */
    FIRE_PARAMEDIC_TRUCK (2, "Fire/Paramedic Truck"),
    /** Ambulance, Advanced Life Support */
    AMBULANCE_ADVANCED_LIFE_SUPPORT (3, "Ambulance, Advanced Life Support"),
    /** Fire Engine */
    FIRE_ENGINE (10, "Fire Engine"),
    /** Aerial Ladder Fire Engine */
    AERIAL_LADDER_FIRE_ENGINE (11, "Aerial Ladder Fire Engine"),
    /** Airport Fire Engine */
    AIRPORT_FIRE_ENGINE (12, "Airport Fire Engine"),
    /** Wildland Fire Engine */
    WILDLAND_FIRE_ENGINE (13, "Wildland Fire Engine"),
    /** Fire Chief */
    FIRE_CHIEF (14, "Fire Chief"),
    /** Police Paddy Wagon */
    POLICE_PADDY_WAGON (20, "Police Paddy Wagon"),
    /** Police, SWAT */
    POLICE_SWAT (21, "Police, SWAT"),
    /** Police, Bomb Squad */
    POLICE_BOMB_SQUAD (22, "Police, Bomb Squad"),
    /** Police, Pickup Truck */
    POLICE_PICKUP_TRUCK (23, "Police, Pickup Truck"),
    /** Hazmat */
    HAZMAT (30, "Hazmat"),
    /** Wrecker, Normal Hook and Chain */
    WRECKER_NORMAL_HOOK_AND_CHAIN (40, "Wrecker, Normal Hook and Chain"),
    /** Wrecker, Normal Boom */
    WRECKER_NORMAL_BOOM (41, "Wrecker, Normal Boom"),
    /** Wrecker, Normal Wheel Lift */
    WRECKER_NORMAL_WHEEL_LIFT (42, "Wrecker, Normal Wheel Lift"),
    /** Wrecker, Normal Flatbed */
    WRECKER_NORMAL_FLATBED (43, "Wrecker, Normal Flatbed"),
    /** Wrecker, Normal Integrated */
    WRECKER_NORMAL_INTEGRATED (44, "Wrecker, Normal Integrated"),
    /** Wrecker, Heavy Hook and Chain */
    WRECKER_HEAVY_HOOK_AND_CHAIN (45, "Wrecker, Heavy Hook and Chain"),
    /** Wrecker, Heavy Boom */
    WRECKER_HEAVY_BOOM (46, "Wrecker, Heavy Boom"),
    /** Wrecker, Heavy Wheel Lift */
    WRECKER_HEAVY_WHEEL_LIFT (47, "Wrecker, Heavy Wheel Lift"),
    /** Wrecker, Heavy Flatbed */
    WRECKER_HEAVY_FLATBED (48, "Wrecker, Heavy Flatbed"),
    /** Wrecker, Heavy Integrated */
    WRECKER_HEAVY_INTEGRATED (49, "Wrecker, Heavy Integrated"),
    /** Postal Truck */
    POSTAL_TRUCK (60, "Postal Truck"),
    /** Street Sweeper */
    STREET_SWEEPER (70, "Street Sweeper"),
    /** Street Sweeper, Three Wheeled */
    STREET_SWEEPER_THREE_WHEELED (71, "Street Sweeper, Three Wheeled"),
    /** Waste Collection, Other */
    WASTE_COLLECTION_OTHER (80, "Waste Collection, Other"),
    /** Waste Collection, Front Loader */
    WASTE_COLLECTION_FRONT_LOADER (81, "Waste Collection, Front Loader"),
    /** Waste Collection, Rear Loader */
    WASTE_COLLECTION_REAR_LOADER (82, "Waste Collection, Rear Loader"),
    /** Waste Collection, Automated Side Loader */
    WASTE_COLLECTION_AUTOMATED_SIDE_LOADER (83, "Waste Collection, Automated Side Loader"),
    /** Waste Collection, Pneumatic Collection */
    WASTE_COLLECTION_PNEUMATIC_COLLECTION (84, "Waste Collection, Pneumatic Collection"),
    /** Waste Collection, Grapple */
    WASTE_COLLECTION_GRAPPLE (85, "Waste Collection, Grapple"),
    /** Utility Truck */
    UTILITY_TRUCK (90, "Utility Truck"),
    /** Utility Truck w/ Boom */
    UTILITY_TRUCK_W_BOOM (91, "Utility Truck w/ Boom"),
    /** Aerial Work Platform, Other */
    AERIAL_WORK_PLATFORM_OTHER (100, "Aerial Work Platform, Other"),
    /** Aerial Work Platform, Scissor Lift */
    AERIAL_WORK_PLATFORM_SCISSOR_LIFT (101, "Aerial Work Platform, Scissor Lift"),
    /** Aerial Work Platform, Telescoping */
    AERIAL_WORK_PLATFORM_TELESCOPING (102, "Aerial Work Platform, Telescoping"),
    /** Maintenance Truck */
    MAINTENANCE_TRUCK (120, "Maintenance Truck"),
    /** Decontamination Truck */
    DECONTAMINATION_TRUCK (121, "Decontamination Truck"),
    /** Water Cannon Truck */
    WATER_CANNON_TRUCK (122, "Water Cannon Truck"),
    /** Water Purification Truck */
    WATER_PURIFICATION_TRUCK (123, "Water Purification Truck"),
    /** Smoke Generator Truck */
    SMOKE_GENERATOR_TRUCK (124, "Smoke Generator Truck"),
    /** Auto Rickshaw */
    AUTO_RICKSHAW (150, "Auto Rickshaw");

    private int value;
    private final String description;

    PlatformLandSingleUnitUtilityEmergencyTruckSubcategories(int value, String description)
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

    public static PlatformLandSingleUnitUtilityEmergencyTruckSubcategories getEnumForValue(int i)
    {
       for(PlatformLandSingleUnitUtilityEmergencyTruckSubcategories val: PlatformLandSingleUnitUtilityEmergencyTruckSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandSingleUnitUtilityEmergencyTruckSubcategories");
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

    public static PlatformLandSingleUnitUtilityEmergencyTruckSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformLandSingleUnitUtilityEmergencyTruckSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformLandSingleUnitUtilityEmergencyTruckSubcategories: " + name() + ": " + getValue(); 
    }
}
