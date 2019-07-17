package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 434 marshal size 8<br>
 * Platform-Land-Construction Specialty Vehicle Subcategories<br>
 * Subcategories for Land Platform Category 87
 */
public enum PlatformLandConstructionSpecialtyVehicleSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Tug */
    TUG (1, "Tug"),
    /** Forklift */
    FORKLIFT (2, "Forklift"),
    /** Loader */
    LOADER (3, "Loader"),
    /** Loader, Backhoe */
    LOADER_BACKHOE (4, "Loader, Backhoe"),
    /** Crane, Tractor Mounted */
    CRANE_TRACTOR_MOUNTED (5, "Crane, Tractor Mounted"),
    /** Crane, Wheeled */
    CRANE_WHEELED (6, "Crane, Wheeled"),
    /** Grader */
    GRADER (7, "Grader"),
    /** Road Roller, Other */
    ROAD_ROLLER_OTHER (8, "Road Roller, Other"),
    /** Road Roller, Double Drum, Smooth */
    ROAD_ROLLER_DOUBLE_DRUM_SMOOTH (9, "Road Roller, Double Drum, Smooth"),
    /** Road Roller, Single Drum, Smooth */
    ROAD_ROLLER_SINGLE_DRUM_SMOOTH (10, "Road Roller, Single Drum, Smooth"),
    /** Road Roller, Double Drum, Sheeps */
    ROAD_ROLLER_DOUBLE_DRUM_SHEEPS (11, "Road Roller, Double Drum, Sheeps"),
    /** Road Roller, Single Drum, Sheeps */
    ROAD_ROLLER_SINGLE_DRUM_SHEEPS (12, "Road Roller, Single Drum, Sheeps"),
    /** Road Roller, Pneumatic Tired */
    ROAD_ROLLER_PNEUMATIC_TIRED (13, "Road Roller, Pneumatic Tired"),
    /** Excavator, Other */
    EXCAVATOR_OTHER (14, "Excavator, Other"),
    /** Excavator, Dragline */
    EXCAVATOR_DRAGLINE (15, "Excavator, Dragline"),
    /** Excavator, Long Reach */
    EXCAVATOR_LONG_REACH (16, "Excavator, Long Reach"),
    /** Excavator, Mobile Tire */
    EXCAVATOR_MOBILE_TIRE (17, "Excavator, Mobile Tire"),
    /** Mini Excavator */
    MINI_EXCAVATOR (18, "Mini Excavator"),
    /** Excavator Giant */
    EXCAVATOR_GIANT (19, "Excavator Giant"),
    /** Bulldozer, Tractor Mounted */
    BULLDOZER_TRACTOR_MOUNTED (20, "Bulldozer, Tractor Mounted"),
    /** Bulldozer, Tracked */
    BULLDOZER_TRACKED (21, "Bulldozer, Tracked"),
    /** Scraper */
    SCRAPER (22, "Scraper"),
    /** Skid Steer */
    SKID_STEER (23, "Skid Steer"),
    /** Dump Truck, Other */
    DUMP_TRUCK_OTHER (24, "Dump Truck, Other"),
    /** Dump Truck, Articulated */
    DUMP_TRUCK_ARTICULATED (25, "Dump Truck, Articulated"),
    /** Dump Truck, Transfer */
    DUMP_TRUCK_TRANSFER (26, "Dump Truck, Transfer"),
    /** Dump Truck, Super */
    DUMP_TRUCK_SUPER (27, "Dump Truck, Super"),
    /** Dump Truck, Off Road */
    DUMP_TRUCK_OFF_ROAD (28, "Dump Truck, Off Road"),
    /** Paver */
    PAVER (29, "Paver"),
    /** Drilling Machine */
    DRILLING_MACHINE (30, "Drilling Machine"),
    /** Concrete Mixer, Other */
    CONCRETE_MIXER_OTHER (31, "Concrete Mixer, Other"),
    /** Concrete Mixer, Rear Discharge */
    CONCRETE_MIXER_REAR_DISCHARGE (32, "Concrete Mixer, Rear Discharge"),
    /** Concrete Mixer, Front Discharge */
    CONCRETE_MIXER_FRONT_DISCHARGE (33, "Concrete Mixer, Front Discharge"),
    /** Concrete Mixer, Six Axle */
    CONCRETE_MIXER_SIX_AXLE (34, "Concrete Mixer, Six Axle"),
    /** Concrete Mixer, Long Reach Boom */
    CONCRETE_MIXER_LONG_REACH_BOOM (35, "Concrete Mixer, Long Reach Boom"),
    /** Concrete Mixer, Volumetric */
    CONCRETE_MIXER_VOLUMETRIC (36, "Concrete Mixer, Volumetric"),
    /** Trencher, Chain */
    TRENCHER_CHAIN (37, "Trencher, Chain"),
    /** Trencher, Rockwheel */
    TRENCHER_ROCKWHEEL (38, "Trencher, Rockwheel"),
    /** Snowcat */
    SNOWCAT (39, "Snowcat"),
    /** Crane, Tracked */
    CRANE_TRACKED (40, "Crane, Tracked"),
    /** Crane, Shovel */
    CRANE_SHOVEL (41, "Crane, Shovel"),
    /** Sweeper, Rotary */
    SWEEPER_ROTARY (42, "Sweeper, Rotary"),
    /** Roller, Vibratory Compactor */
    ROLLER_VIBRATORY_COMPACTOR (43, "Roller, Vibratory Compactor"),
    /** Fork Lift, Truck */
    FORK_LIFT_TRUCK (44, "Fork Lift, Truck"),
    /** Fork Lift, Rought Terrain */
    FORK_LIFT_ROUGHT_TERRAIN (45, "Fork Lift, Rought Terrain"),
    /** Transloader */
    TRANSLOADER (46, "Transloader"),
    /** Truck, Water, Construction */
    TRUCK_WATER_CONSTRUCTION (47, "Truck, Water, Construction"),
    /** Truck, Fuel Delivery */
    TRUCK_FUEL_DELIVERY (48, "Truck, Fuel Delivery"),
    /** Truck, Sawmill */
    TRUCK_SAWMILL (49, "Truck, Sawmill"),
    /** Truck, Line Marking, Construction */
    TRUCK_LINE_MARKING_CONSTRUCTION (50, "Truck, Line Marking, Construction"),
    /** Tractor, Industrial */
    TRACTOR_INDUSTRIAL (51, "Tractor, Industrial"),
    /** Compactor, High Speed */
    COMPACTOR_HIGH_SPEED (52, "Compactor, High Speed"),
    /** Truck, Drilling */
    TRUCK_DRILLING (53, "Truck, Drilling"),
    /** Truck, Drilling Support */
    TRUCK_DRILLING_SUPPORT (54, "Truck, Drilling Support"),
    /** Crane, Construction */
    CRANE_CONSTRUCTION (55, "Crane, Construction");

    private int value;
    private final String description;

    PlatformLandConstructionSpecialtyVehicleSubcategories(int value, String description)
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

    public static PlatformLandConstructionSpecialtyVehicleSubcategories getEnumForValue(int i)
    {
       for(PlatformLandConstructionSpecialtyVehicleSubcategories val: PlatformLandConstructionSpecialtyVehicleSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandConstructionSpecialtyVehicleSubcategories");
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

    public static PlatformLandConstructionSpecialtyVehicleSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformLandConstructionSpecialtyVehicleSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
}
