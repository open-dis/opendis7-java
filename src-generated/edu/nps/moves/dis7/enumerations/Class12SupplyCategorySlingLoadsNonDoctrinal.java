package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 612 marshal size 8<br>
 * Class12SupplyCategorySlingLoads(NonDoctrinal)
 */
public enum Class12SupplyCategorySlingLoadsNonDoctrinal implements Category
{
    /** Other */
    OTHER (1, "Other"),
    /** Sling Load, Blivet */
    SLING_LOAD_BLIVET (2, "Sling Load, Blivet"),
    /** Sling Load, Crate */
    SLING_LOAD_CRATE (3, "Sling Load, Crate"),
    /** Sling Load, Water Bucket */
    SLING_LOAD_WATER_BUCKET (4, "Sling Load, Water Bucket"),
    /** Sling Load, Vehicles */
    SLING_LOAD_VEHICLES (5, "Sling Load, Vehicles"),
    /** Sling Load, Howitzer */
    SLING_LOAD_HOWITZER (6, "Sling Load, Howitzer"),
    /** Sling Load, Collapsible */
    SLING_LOAD_COLLAPSIBLE (7, "Sling Load, Collapsible"),
    /** Sling Load, Bladder */
    SLING_LOAD_BLADDER (8, "Sling Load, Bladder"),
    /** Sling Load, Pallet of Crates */
    SLING_LOAD_PALLET_OF_CRATES (9, "Sling Load, Pallet of Crates"),
    /** Sling Load, Helicopters */
    SLING_LOAD_HELICOPTERS (10, "Sling Load, Helicopters"),
    /** Sling Load, Hoist */
    SLING_LOAD_HOIST (11, "Sling Load, Hoist"),
    /** Sling Load, Concrete Block */
    SLING_LOAD_CONCRETE_BLOCK (12, "Sling Load, Concrete Block");

    private int value;
    private final String description;

    /** Constructor */
    Class12SupplyCategorySlingLoadsNonDoctrinal(int value, String description)
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
    public static Class12SupplyCategorySlingLoadsNonDoctrinal getEnumForValue(int i)
    {
       for(Class12SupplyCategorySlingLoadsNonDoctrinal val: Class12SupplyCategorySlingLoadsNonDoctrinal.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration Class12SupplyCategorySlingLoadsNonDoctrinal");
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
    public static Class12SupplyCategorySlingLoadsNonDoctrinal unmarshalEnum (DataInputStream dis) throws Exception
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
    public static Class12SupplyCategorySlingLoadsNonDoctrinal unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "Class12SupplyCategorySlingLoadsNonDoctrinal " + padding + getValue() + " " + name();
    }
}
