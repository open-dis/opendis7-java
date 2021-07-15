package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 425 marshal size 6<br>
 * MinefieldPaintSchemePaintScheme
 */
public enum MinefieldPaintSchemePaintScheme 
{
    /** Other */
    OTHER (0, "Other"),
    /** Standard */
    STANDARD (1, "Standard"),
    /** Camouflage Desert */
    CAMOUFLAGE_DESERT (2, "Camouflage Desert"),
    /** Camouflage Jungle */
    CAMOUFLAGE_JUNGLE (3, "Camouflage Jungle"),
    /** Camouflage Snow */
    CAMOUFLAGE_SNOW (4, "Camouflage Snow"),
    /** Camouflage Gravel */
    CAMOUFLAGE_GRAVEL (5, "Camouflage Gravel"),
    /** Camouflage Pavement */
    CAMOUFLAGE_PAVEMENT (6, "Camouflage Pavement"),
    /** Camouflage Sand */
    CAMOUFLAGE_SAND (7, "Camouflage Sand"),
    /** Natural Wood */
    NATURAL_WOOD (8, "Natural Wood"),
    /** Clear */
    CLEAR (9, "Clear"),
    /** Red */
    RED (10, "Red"),
    /** Blue */
    BLUE (11, "Blue"),
    /** Green */
    GREEN (12, "Green"),
    /** Olive */
    OLIVE (13, "Olive"),
    /** White */
    WHITE (14, "White"),
    /** Tan */
    TAN (15, "Tan"),
    /** Black */
    BLACK (16, "Black"),
    /** Yellow */
    YELLOW (17, "Yellow"),
    /** Brown */
    BROWN (18, "Brown");

    private int value;
    private final String description;

    /** Constructor */
    MinefieldPaintSchemePaintScheme(int value, String description)
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
      return 6;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static MinefieldPaintSchemePaintScheme getEnumForValue(int i)
    {
       for(MinefieldPaintSchemePaintScheme val: MinefieldPaintSchemePaintScheme.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MinefieldPaintSchemePaintScheme");
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
    public static MinefieldPaintSchemePaintScheme unmarshalEnum (DataInputStream dis) throws Exception
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
    public static MinefieldPaintSchemePaintScheme unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "MinefieldPaintSchemePaintScheme " + padding + getValue() + " " + name();
    }
}
