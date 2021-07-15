package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 482 marshal size 8<br>
 * LifeFormHumanSpecificSubMachineGun
 */
public enum LifeFormHumanSpecificSubMachineGun 
{
    /** Other */
    OTHER (0, "Other"),
    /** 5.45mm AKS-74U (AKSU-74) */
    _545MM_AKS_74U_AKSU_74 (10, "5.45mm AKS-74U (AKSU-74)"),
    /** 5.56mm Daewoo K1A */
    _556MM_DAEWOO_K1A (20, "5.56mm Daewoo K1A"),
    /** 9mm Daewoo K7 */
    DATA_RELIABLE (60, "9mm Daewoo K7"),
    /** 9mm MAC-10 */
    EVENT_REPORT_RELIABLE (61, "9mm MAC-10"),
    /** 9mm Madsen MK II */
    COMMENT_RELIABLE (62, "9mm Madsen MK II"),
    /** 9mm Mini-Uzi */
    RECORD_RELIABLE (63, "9mm Mini-Uzi"),
    /** 9mm Model 83 Skorpion SMG */
    SET_RECORD_RELIABLE	 (64, "9mm Model 83 Skorpion SMG"),
    /** 9mm MP5A2 */
    RECORD_QUERY_RELIABLE (65, "9mm MP5A2"),
    /** 9mm MP5-N */
    _9MM_MP5_N (66, "9mm MP5-N"),
    /** 9mm Sterling SMG */
    _9MM_STERLING_SMG (67, "9mm Sterling SMG"),
    /** 9mm Type CF-05 */
    _9MM_TYPE_CF_05 (68, "9mm Type CF-05"),
    /** 9mm Uzi */
    _9MM_UZI (69, "9mm Uzi");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificSubMachineGun(int value, String description)
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
    public static LifeFormHumanSpecificSubMachineGun getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificSubMachineGun val: LifeFormHumanSpecificSubMachineGun.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificSubMachineGun");
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
    public static LifeFormHumanSpecificSubMachineGun unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormHumanSpecificSubMachineGun unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "LifeFormHumanSpecificSubMachineGun " + padding + getValue() + " " + name();
    }
}
