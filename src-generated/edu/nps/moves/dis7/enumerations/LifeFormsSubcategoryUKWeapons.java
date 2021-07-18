package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 18 marshal size 8<br>
 * LifeFormsSubcategoryUKWeapons
 */
public enum LifeFormsSubcategoryUKWeapons implements SubCategory
{
    /** LAW 80 */
    LAW_80 (1, "LAW 80"),
    /** Blowpipe */
    BLOWPIPE (2, "Blowpipe"),
    /** Javelin */
    JAVELIN (3, "Javelin"),
    /** 51-mm mortar */
    _51_MM_MORTAR (4, "51-mm mortar"),
    /** SLR 7.62-mm rifle */
    SLR_762_MM_RIFLE (5, "SLR 7.62-mm rifle"),
    /** Sterling 9-mm submachine gun */
    STERLING_9_MM_SUBMACHINE_GUN (6, "Sterling 9-mm submachine gun"),
    /** L7A2 general purpose MG */
    L7A2_GENERAL_PURPOSE_MG (7, "L7A2 general purpose MG"),
    /** L6 Wombat Recoilless rifle, */
    L6_WOMBAT_RECOILLESS_RIFLE_ (8, "L6 Wombat Recoilless rifle,"),
    /** Carl Gustav 89-mm recoilless rifle */
    CARL_GUSTAV_89_MM_RECOILLESS_RIFLE (9, "Carl Gustav 89-mm recoilless rifle"),
    /** SA80 Individual/light support weapon */
    SA80_INDIVIDUAL_LIGHT_SUPPORT_WEAPON (10, "SA80 Individual/light support weapon"),
    /** Trigat */
    TRIGAT (11, "Trigat"),
    /** Milan AT missile */
    MILAN_AT_MISSILE (12, "Milan AT missile");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormsSubcategoryUKWeapons(int value, String description)
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
    public static LifeFormsSubcategoryUKWeapons getEnumForValue(int i)
    {
       for(LifeFormsSubcategoryUKWeapons val: LifeFormsSubcategoryUKWeapons.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormsSubcategoryUKWeapons");
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
    public static LifeFormsSubcategoryUKWeapons unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormsSubcategoryUKWeapons unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "LifeFormsSubcategoryUKWeapons " + padding + getValue() + " " + name();
    }
}
