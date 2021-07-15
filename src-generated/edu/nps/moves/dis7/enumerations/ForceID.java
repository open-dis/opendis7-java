package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 6 marshal size 8<br>
 * ForceID
 */
public enum ForceID 
{
    /** Other */
    OTHER (0, "Other"),
    /** Friendly */
    FRIENDLY (1, "Friendly"),
    /** Opposing */
    OPPOSING (2, "Opposing"),
    /** Neutral */
    NEUTRAL (3, "Neutral"),
    /** Friendly 2 */
    FRIENDLY_2 (4, "Friendly 2"),
    /** Opposing 2 */
    OPPOSING_2 (5, "Opposing 2"),
    /** Neutral 2 */
    NEUTRAL_2 (6, "Neutral 2"),
    /** Friendly 3 */
    FRIENDLY_3 (7, "Friendly 3"),
    /** Opposing 3 */
    OPPOSING_3 (8, "Opposing 3"),
    /** Neutral 3 */
    NEUTRAL_3 (9, "Neutral 3"),
    /** Friendly 4 */
    FRIENDLY_4 (10, "Friendly 4"),
    /** Opposing 4 */
    OPPOSING_4 (11, "Opposing 4"),
    /** Neutral 4 */
    NEUTRAL_4 (12, "Neutral 4"),
    /** Friendly 5 */
    FRIENDLY_5 (13, "Friendly 5"),
    /** Opposing 5 */
    OPPOSING_5 (14, "Opposing 5"),
    /** Neutral 5 */
    NEUTRAL_5 (15, "Neutral 5"),
    /** Friendly 6 */
    FRIENDLY_6 (16, "Friendly 6"),
    /** Opposing 6 */
    OPPOSING_6 (17, "Opposing 6"),
    /** Neutral 6 */
    NEUTRAL_6 (18, "Neutral 6"),
    /** Friendly 7 */
    FRIENDLY_7 (19, "Friendly 7"),
    /** Opposing 7 */
    OPPOSING_7 (20, "Opposing 7"),
    /** Neutral 7 */
    NEUTRAL_7 (21, "Neutral 7"),
    /** Friendly 8 */
    FRIENDLY_8 (22, "Friendly 8"),
    /** Opposing 8 */
    OPPOSING_8 (23, "Opposing 8"),
    /** Neutral 8 */
    NEUTRAL_8 (24, "Neutral 8"),
    /** Friendly 9 */
    FRIENDLY_9 (25, "Friendly 9"),
    /** Opposing 9 */
    OPPOSING_9 (26, "Opposing 9"),
    /** Neutral 9 */
    NEUTRAL_9 (27, "Neutral 9"),
    /** Friendly 10 */
    IDENTIFICATION_FRIEND_OR_FOE (28, "Friendly 10"),
    /** Opposing 10 */
    OPPOSING_10 (29, "Opposing 10"),
    /** Neutral 10 */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Neutral 10");

    private int value;
    private final String description;

    /** Constructor */
    ForceID(int value, String description)
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
    public static ForceID getEnumForValue(int i)
    {
       for(ForceID val: ForceID.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ForceID");
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
    public static ForceID unmarshalEnum (DataInputStream dis) throws Exception
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
    public static ForceID unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "ForceID " + padding + getValue() + " " + name();
    }
}
