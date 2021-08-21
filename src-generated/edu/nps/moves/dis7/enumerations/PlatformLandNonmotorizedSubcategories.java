package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 438 marshal size 8<br>
 * PlatformLandNonmotorizedSubcategories<br>
 * Subcategories for Land Platform Category 91
 */
public enum PlatformLandNonmotorizedSubcategories 
{

    /** Other */
    OTHER (0, "Other"),
    /** Unicycle */
    UNICYCLE (1, "Unicycle"),
    /** Bicycle */
    BICYCLE (2, "Bicycle"),
    /** Bicycle, Mountain */
    BICYCLE_MOUNTAIN (3, "Bicycle, Mountain"),
    /** Bicycle, Racing */
    BICYCLE_RACING (4, "Bicycle, Racing"),
    /** Tricycle */
    TRICYCLE (5, "Tricycle"),
    /** Quadricycle */
    QUADRICYCLE (6, "Quadricycle"),
    /** Rickshaw, Two Person */
    RICKSHAW_TWO_PERSON (7, "Rickshaw, Two Person"),
    /** Rickshaw, One Person */
    RICKSHAW_ONE_PERSON (8, "Rickshaw, One Person"),
    /** Tandem Bicycle */
    TANDEM_BICYCLE (9, "Tandem Bicycle"),
    /** Cycle Trailer */
    CYCLE_TRAILER (10, "Cycle Trailer"),
    /** Cycle Sidecar */
    CYCLE_SIDECAR (11, "Cycle Sidecar"),
    /** Sled */
    SLED (12, "Sled"),
    /** Skis */
    SKIS (13, "Skis"),
    /** Snowboard */
    SNOWBOARD (14, "Snowboard"),
    /** Skateboard */
    SKATEBOARD (15, "Skateboard"),
    /** Skates */
    SKATES (16, "Skates"),
    /** Skates, In-Line */
    SKATES_IN_LINE (17, "Skates, In-Line"),
    /** Wagon Cart */
    WAGON_CART (18, "Wagon Cart"),
    /** Dolly */
    DOLLY (19, "Dolly"),
    /** Handtruck */
    HANDTRUCK (20, "Handtruck"),
    /** Push Cart */
    PUSH_CART (21, "Push Cart"),
    /** Wheelbarrow */
    WHEELBARROW (22, "Wheelbarrow"),
    /** Kick Scooter */
    KICK_SCOOTER (23, "Kick Scooter"),
    /** Wheelchair */
    WHEELCHAIR (24, "Wheelchair");

    private int value;
    private final String description;

    /** Constructor */
    PlatformLandNonmotorizedSubcategories(int value, String description)
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
    public static PlatformLandNonmotorizedSubcategories getEnumForValue(int i)
    {
       for(PlatformLandNonmotorizedSubcategories val: PlatformLandNonmotorizedSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandNonmotorizedSubcategories");
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
    public static PlatformLandNonmotorizedSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformLandNonmotorizedSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
