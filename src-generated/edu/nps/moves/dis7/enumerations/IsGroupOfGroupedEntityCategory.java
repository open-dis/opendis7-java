package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 213 marshal size 8<br>
 * IsGroupOfGroupedEntityCategory
 */
public enum IsGroupOfGroupedEntityCategory implements Category
{
    /** Undefined */
    UNDEFINED (0, "Undefined"),
    /** Basic Ground Combat Vehicle */
    BASIC_GROUND_COMBAT_VEHICLE (1, "Basic Ground Combat Vehicle"),
    /** Enhanced Ground Combat Vehicle */
    ENHANCED_GROUND_COMBAT_VEHICLE (2, "Enhanced Ground Combat Vehicle"),
    /** Basic Ground Combat Soldier */
    BASIC_GROUND_COMBAT_SOLDIER (3, "Basic Ground Combat Soldier"),
    /** Enhanced Ground Combat Soldier */
    ENHANCED_GROUND_COMBAT_SOLDIER (4, "Enhanced Ground Combat Soldier"),
    /** Basic Rotor Wing Aircraft */
    BASIC_ROTOR_WING_AIRCRAFT (5, "Basic Rotor Wing Aircraft"),
    /** Enhanced Rotor Wing Aircraft */
    ENHANCED_ROTOR_WING_AIRCRAFT (6, "Enhanced Rotor Wing Aircraft"),
    /** Basic Fixed Wing Aircraft */
    BASIC_FIXED_WING_AIRCRAFT (7, "Basic Fixed Wing Aircraft"),
    /** Enhanced Fixed Wing Aircraft */
    ENHANCED_FIXED_WING_AIRCRAFT (8, "Enhanced Fixed Wing Aircraft"),
    /** Ground Logistics Vehicle */
    GROUND_LOGISTICS_VEHICLE (9, "Ground Logistics Vehicle");

    private int value;
    private final String description;

    /** Constructor */
    IsGroupOfGroupedEntityCategory(int value, String description)
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
    public static IsGroupOfGroupedEntityCategory getEnumForValue(int i)
    {
       for(IsGroupOfGroupedEntityCategory val: IsGroupOfGroupedEntityCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration IsGroupOfGroupedEntityCategory");
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
    public static IsGroupOfGroupedEntityCategory unmarshalEnum (DataInputStream dis) throws Exception
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
    public static IsGroupOfGroupedEntityCategory unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
