package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 475 marshal size 8<br>
 * LifeFormHumanSpecificHighPowerRifles
 */
public enum LifeFormHumanSpecificHighPowerRifles 
{
    /** Other */
    OTHER (0, "Other"),
    /** 7.62mm M14 */
    _762MM_M14 (10, "7.62mm M14"),
    /** 7.62mm Remington 700 */
    _762MM_REMINGTON_700 (11, "7.62mm Remington 700"),
    /** 7.62mm SIG-Sauer SSG-2000 */
    _762MM_SIG_SAUER_SSG_2000 (12, "7.62mm SIG-Sauer SSG-2000"),
    /** 7.62mm Stoner SR-25 */
    _762MM_STONER_SR_25 (13, "7.62mm Stoner SR-25"),
    /** 7.62mm Mosin-Nagant Model 1891/30 */
    _762MM_MOSIN_NAGANT_MODEL_1891_30 (14, "7.62mm Mosin-Nagant Model 1891/30"),
    /** 7.62mm HK417 */
    _762MM_HK417 (15, "7.62mm HK417"),
    /** 7.62mm HK417 16 Recce */
    _762MM_HK417_16_RECCE (16, "7.62mm HK417 16 Recce"),
    /** 7.65mm BAR M1918 */
    LIVE_ENTITY_DETONATION (50, "7.65mm BAR M1918"),
    /** 7.65mm M1 Garand */
    CREATE_ENTITY_RELIABLE (51, "7.65mm M1 Garand");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificHighPowerRifles(int value, String description)
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
    public static LifeFormHumanSpecificHighPowerRifles getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificHighPowerRifles val: LifeFormHumanSpecificHighPowerRifles.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificHighPowerRifles");
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
    public static LifeFormHumanSpecificHighPowerRifles unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormHumanSpecificHighPowerRifles unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "LifeFormHumanSpecificHighPowerRifles " + padding + getValue() + " " + name();
    }
}
