package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 430 marshal size 8<br>
 * PlatformLandSingleUnitCargoTruckSubcategories<br>
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
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Semi-Trailer Cab (w/o Trailer)"),
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

    /** Constructor */
    PlatformLandSingleUnitCargoTruckSubcategories(int value, String description)
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
    public static PlatformLandSingleUnitCargoTruckSubcategories getEnumForValue(int i)
    {
       for(PlatformLandSingleUnitCargoTruckSubcategories val: PlatformLandSingleUnitCargoTruckSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandSingleUnitCargoTruckSubcategories");
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

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static PlatformLandSingleUnitCargoTruckSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
