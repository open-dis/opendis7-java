package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 110 marshal size 8<br>
 * SubcategoriesforAirCategory200Bird
 */
public enum SubcategoriesforAirCategory200Bird implements SubCategory
{
    /** Penguin, 1-49 Marine Birds */
    PENGUIN (1, "Penguin"),
    /** Seagull */
    SEAGULL (2, "Seagull"),
    /** Pelican */
    PELICAN (3, "Pelican"),
    /** Albatross */
    ALBATROSS (4, "Albatross"),
    /** Swan */
    SWAN (5, "Swan"),
    /** Cormorant */
    CORMORANT (6, "Cormorant"),
    /** Heron */
    HERON (7, "Heron"),
    /** Crane */
    CRANE (8, "Crane"),
    /** Osprey */
    OSPREY (9, "Osprey"),
    /** Loon */
    LOON (10, "Loon"),
    /** Stork */
    STORK (11, "Stork"),
    /** Flamingo */
    FLAMINGO (12, "Flamingo"),
    /** Duck */
    DUCK (13, "Duck"),
    /** Ostrich, 20-29 Flightless Land Birds */
    OSTRICH (20, "Ostrich"),
    /** Emu */
    EMU (21, "Emu"),
    /** Chicken */
    CHICKEN (22, "Chicken"),
    /** Black Bird, 30-39 Small birds that fly in large flocks */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Black Bird"),
    /** Starling */
    STARLING (31, "Starling"),
    /** Budgerigar (Parakeet) */
    BUDGERIGAR_PARAKEET (32, "Budgerigar (Parakeet)"),
    /** Canadian Goose, 40-49 Large birds that fly in large flocks */
    CANADIAN_GOOSE (40, "Canadian Goose"),
    /** Crow */
    CROW (41, "Crow"),
    /** Eagle, 50-99 Birds of prey */
    LIVE_ENTITY_DETONATION (50, "Eagle"),
    /** Vulture */
    ACKNOWLEDGE_RELIABLE (55, "Vulture"),
    /** Falcon */
    DATA_RELIABLE (60, "Falcon"),
    /** Hawk */
    RECORD_QUERY_RELIABLE (65, "Hawk"),
    /** Owl */
    OWL (70, "Owl"),
    /** Kite */
    KITE (80, "Kite");

    private int value;
    private final String description;

    /** Constructor */
    SubcategoriesforAirCategory200Bird(int value, String description)
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
    public static SubcategoriesforAirCategory200Bird getEnumForValue(int i)
    {
       for(SubcategoriesforAirCategory200Bird val: SubcategoriesforAirCategory200Bird.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SubcategoriesforAirCategory200Bird");
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
    public static SubcategoriesforAirCategory200Bird unmarshalEnum (DataInputStream dis) throws Exception
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
    public static SubcategoriesforAirCategory200Bird unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "SubcategoriesforAirCategory200Bird " + padding + getValue() + " " + name();
    }
}
