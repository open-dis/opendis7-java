package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 430 marshal size 8<br>
 * Platform-Land-Single Unit Cargo Truck Subcategories<br>
 * Subcategories for Land Platform Category 83
 */
public enum PlatformLandSingleUnitCargoTruckSubcategories implements SubCategory
{

    /** Other */
    OTHER (0, "Other"),
    /** Pickup Truck, Mini */
    PICKUP_TRUCK_MINI (1, "Pickup Truck, Mini"),
    /** Pickup Truck, Mid-Size */
    PICKUP_TRUCK_MID_SIZE (2, "Pickup Truck, Mid-Size"),
    /** Pickup Truck, Full-Size */
    PICKUP_TRUCK_FULL_SIZE (3, "Pickup Truck, Full-Size"),
    /** Pickup Truck, Crew Cab */
    PICKUP_TRUCK_CREW_CAB (4, "Pickup Truck, Crew Cab"),
    /** Pickup Truck, Extended Cab */
    PICKUP_TRUCK_EXTENDED_CAB (5, "Pickup Truck, Extended Cab"),
    /** Pickup Truck, Long Bed */
    PICKUP_TRUCK_LONG_BED (6, "Pickup Truck, Long Bed"),
    /** Pickup Truck, Cab Forward */
    PICKUP_TRUCK_CAB_FORWARD (7, "Pickup Truck, Cab Forward"),
    /** Cargo Truck */
    CARGO_TRUCK (10, "Cargo Truck"),
    /** Cargo Truck, up to 2.5 Ton */
    CARGO_TRUCK_UP_TO_25_TON (11, "Cargo Truck, up to 2.5 Ton"),
    /** Cargo Truck, up to 5 Ton */
    CARGO_TRUCK_UP_TO_5_TON (12, "Cargo Truck, up to 5 Ton"),
    /** Cargo Truck, up to 7.5 Ton */
    CARGO_TRUCK_UP_TO_75_TON (13, "Cargo Truck, up to 7.5 Ton"),
    /** Cargo Truck, up to 10 Ton */
    CARGO_TRUCK_UP_TO_10_TON (14, "Cargo Truck, up to 10 Ton"),
    /** Cargo Truck, over 10 Ton */
    CARGO_TRUCK_OVER_10_TON (15, "Cargo Truck, over 10 Ton"),
    /** Tanker */
    TANKER (20, "Tanker"),
    /** Semi-Trailer Cab (w/o Trailer) */
    SEMI_TRAILER_CAB_W_O_TRAILER (30, "Semi-Trailer Cab (w/o Trailer)"),
    /** Van */
    VAN (70, "Van"),
    /** Van, Extended */
    VAN_EXTENDED (71, "Van, Extended"),
    /** Van, Compact */
    VAN_COMPACT (72, "Van, Compact"),
    /** Van, Wheelchair */
    VAN_WHEELCHAIR (73, "Van, Wheelchair"),
    /** Van, Delivery */
    VAN_DELIVERY (74, "Van, Delivery"),
    /** Delivery Truck */
    DELIVERY_TRUCK (100, "Delivery Truck"),
    /** Delivery Truck, Box */
    DELIVERY_TRUCK_BOX (101, "Delivery Truck, Box"),
    /** Delivery Truck, Flatbed */
    DELIVERY_TRUCK_FLATBED (102, "Delivery Truck, Flatbed"),
    /** Delivery Truck, Stake Bed */
    DELIVERY_TRUCK_STAKE_BED (103, "Delivery Truck, Stake Bed"),
    /** Mess Truck */
    MESS_TRUCK (104, "Mess Truck"),
    /** Truck, Palletised Load System (PLS), https://en.wikipedia.org/wiki/Palletized_load_system */
    TRUCK_PALLETISED_LOAD_SYSTEM_PLS (105, "Truck, Palletised Load System (PLS)"),
    /** Truck, Petroleum, Oil, and Lubricants (POL) Palletised Load System (PLS) */
    TRUCK_PETROLEUM_OIL_AND_LUBRICANTS_POL_PALLETISED_LOAD_SYSTEM_PLS (106, "Truck, Petroleum, Oil, and Lubricants (POL) Palletised Load System (PLS)"),
    /** Truck, Petroleum, Oil, and Lubricants (POL), Surveillance */
    TRUCK_PETROLEUM_OIL_AND_LUBRICANTS_POL_SURVEILLANCE (107, "Truck, Petroleum, Oil, and Lubricants (POL), Surveillance"),
    /** Refrigerated Truck, Small */
    REFRIGERATED_TRUCK_SMALL (108, "Refrigerated Truck, Small"),
    /** Refrigerated Truck, Medium */
    REFRIGERATED_TRUCK_MEDIUM (109, "Refrigerated Truck, Medium"),
    /** Refrigerated Truck, Large */
    REFRIGERATED_TRUCK_LARGE (110, "Refrigerated Truck, Large");

    private int value;
    private final String description;

    PlatformLandSingleUnitCargoTruckSubcategories(int value, String description)
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

    public static PlatformLandSingleUnitCargoTruckSubcategories getEnumForValue(int i)
    {
       for(PlatformLandSingleUnitCargoTruckSubcategories val: PlatformLandSingleUnitCargoTruckSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandSingleUnitCargoTruckSubcategories");
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

    public static PlatformLandSingleUnitCargoTruckSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PlatformLandSingleUnitCargoTruckSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformLandSingleUnitCargoTruckSubcategories: " + name() + ": " + getValue(); 
    }
}
