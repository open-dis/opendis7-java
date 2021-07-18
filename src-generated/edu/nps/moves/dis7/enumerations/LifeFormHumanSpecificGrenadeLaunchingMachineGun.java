package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 517 marshal size 8<br>
 * LifeFormHumanSpecificGrenadeLaunchingMachineGun
 */
public enum LifeFormHumanSpecificGrenadeLaunchingMachineGun 
{
    /** Other */
    OTHER (0, "Other"),
    /** 40x53mm HK GMG */
    _40X53MM_HK_GMG (20, "40x53mm HK GMG"),
    /** 40x53mm Mk47 Striker */
    _40X53MM_MK47_STRIKER (25, "40x53mm Mk47 Striker"),
    /** 40mm M75 */
    _40MM_M75 (26, "40mm M75"),
    /** 40mm M129 */
    _40MM_M129 (27, "40mm M129"),
    /** 40x46mm XM 174 */
    IDENTIFICATION_FRIEND_OR_FOE (28, "40x46mm XM 174"),
    /** 40x46mm Mk18 Mod 0 */
    _40X46MM_MK18_MOD_0 (29, "40x46mm Mk18 Mod 0"),
    /** 40x53mm Mk19 */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "40x53mm Mk19"),
    /** 40x46mm Mk20 Mod 0 */
    _40X46MM_MK20_MOD_0 (31, "40x46mm Mk20 Mod 0"),
    /** 30x29mm RAG-30/SAG-30 */
    _30X29MM_RAG_30_SAG_30 (40, "30x29mm RAG-30/SAG-30"),
    /** 30x29mm AGS-17 Plamya */
    _30X29MM_AGS_17_PLAMYA (41, "30x29mm AGS-17 Plamya"),
    /** 30x29mm AGS-30 Atlant */
    _30X29MM_AGS_30_ATLANT (42, "30x29mm AGS-30 Atlant"),
    /** 40mm VOG AGS-40 Balkan */
    _40MM_VOG_AGS_40_BALKAN (43, "40mm VOG AGS-40 Balkan"),
    /** 40x53mm SB LAG 40 */
    _40X53MM_SB_LAG_40 (44, "40x53mm SB LAG 40"),
    /** 40x53mm Vektor Y3 */
    LIVE_ENTITY_DETONATION (50, "40x53mm Vektor Y3"),
    /** 40x53mm CIS 40 */
    ACKNOWLEDGE_RELIABLE (55, "40x53mm CIS 40"),
    /** 40x56mm Howa Type-96 */
    DATA_RELIABLE (60, "40x56mm Howa Type-96"),
    /** 40x53mm Daewoo Precision Industries K4 */
    RECORD_QUERY_RELIABLE (65, "40x53mm Daewoo Precision Industries K4"),
    /** 25x59mm XM307 Advanced Crew Served Weapon */
    _25X59MM_XM307_ADVANCED_CREW_SERVED_WEAPON (70, "25x59mm XM307 Advanced Crew Served Weapon"),
    /** 35x32mm QLZ87 */
    _35X32MM_QLZ87 (80, "35x32mm QLZ87");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificGrenadeLaunchingMachineGun(int value, String description)
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
    public static LifeFormHumanSpecificGrenadeLaunchingMachineGun getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificGrenadeLaunchingMachineGun val: LifeFormHumanSpecificGrenadeLaunchingMachineGun.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificGrenadeLaunchingMachineGun");
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
    public static LifeFormHumanSpecificGrenadeLaunchingMachineGun unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormHumanSpecificGrenadeLaunchingMachineGun unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "LifeFormHumanSpecificGrenadeLaunchingMachineGun " + padding + getValue() + " " + name();
    }
}
