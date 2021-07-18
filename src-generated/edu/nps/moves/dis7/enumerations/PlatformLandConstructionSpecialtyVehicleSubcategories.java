package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 434 marshal size 8<br>
 * PlatformLandConstructionSpecialtyVehicleSubcategories<br>
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
    IDENTIFICATION_FRIEND_OR_FOE (28, "Dump Truck, Off Road"),
    /** Paver */
    PAVER (29, "Paver"),
    /** Drilling Machine */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Drilling Machine"),
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
    TIME_SPACE_POSITION_INFORMATION (46, "Transloader"),
    /** Truck, Water, Construction */
    TRUCK_WATER_CONSTRUCTION (47, "Truck, Water, Construction"),
    /** Truck, Fuel Delivery */
    TRUCK_FUEL_DELIVERY (48, "Truck, Fuel Delivery"),
    /** Truck, Sawmill */
    LIVE_ENTITY_FIRE (49, "Truck, Sawmill"),
    /** Truck, Line Marking, Construction */
    LIVE_ENTITY_DETONATION (50, "Truck, Line Marking, Construction"),
    /** Tractor, Industrial */
    CREATE_ENTITY_RELIABLE (51, "Tractor, Industrial"),
    /** Compactor, High Speed */
    REMOVE_ENTITY_RELIABLE (52, "Compactor, High Speed"),
    /** Truck, Drilling */
    START_RESUME_RELIABLE (53, "Truck, Drilling"),
    /** Truck, Drilling Support */
    STOP_FREEZE_RELIABLE (54, "Truck, Drilling Support"),
    /** Crane, Construction */
    ACKNOWLEDGE_RELIABLE (55, "Crane, Construction");

    private int value;
    private final String description;

    /** Constructor */
    PlatformLandConstructionSpecialtyVehicleSubcategories(int value, String description)
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
    public static PlatformLandConstructionSpecialtyVehicleSubcategories getEnumForValue(int i)
    {
       for(PlatformLandConstructionSpecialtyVehicleSubcategories val: PlatformLandConstructionSpecialtyVehicleSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandConstructionSpecialtyVehicleSubcategories");
       System.err.flush(); // ensure contiguous console outputs
       return null;
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
    public static PlatformLandConstructionSpecialtyVehicleSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformLandConstructionSpecialtyVehicleSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "PlatformLandConstructionSpecialtyVehicleSubcategories " + padding + getValue() + " " + name();
    }
}
