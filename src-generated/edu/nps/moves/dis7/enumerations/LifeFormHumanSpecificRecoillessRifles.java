/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
// header autogenerated using string template dis7javalicense.txt

// autogenerated using string template disenumpart1.txt

package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * This <code>enum</code> type is generated from XML,
 *  UID 521,
 * marshal size 8;
 * LifeFormHumanSpecificRecoillessRifles has 29 enumerations total.
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html">Java Tutorials: Enum Types</a>
 * @see java.lang.Enum
 */
public enum LifeFormHumanSpecificRecoillessRifles 
{
    // autogenerated using string template disenumfootnotecomment.txt

    /** Other */
    // autogenerated using string template disenumpart2.txt
    OTHER (0, "Other"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 84mm M136 AT-4 CS */
    // autogenerated using string template disenumpart2.txt
    _84MM_M136_AT_4_CS (15, "84mm M136 AT-4 CS"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 57mm M18 RR */
    // autogenerated using string template disenumpart2.txt
    _57MM_M18_RR (20, "57mm M18 RR"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 75mm M20 RR */
    // autogenerated using string template disenumpart2.txt
    _75MM_M20_RR (21, "75mm M20 RR"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 120mm M-28 Davy Crockett */
    // autogenerated using string template disenumpart2.txt
    _120MM_M_28_DAVY_CROCKETT (22, "120mm M-28 Davy Crockett"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 155mm M-29 Davy Crockett */
    // autogenerated using string template disenumpart2.txt
    _155MM_M_29_DAVY_CROCKETT (23, "155mm M-29 Davy Crockett"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 106mm M40 Recoilless Rifle */
    // autogenerated using string template disenumpart2.txt
    _106MM_M40_RECOILLESS_RIFLE (24, "106mm M40 Recoilless Rifle"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 82mm M60 RR */
    // autogenerated using string template disenumpart2.txt
    _82MM_M60_RR (25, "82mm M60 RR"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 90mm M67 RR */
    // autogenerated using string template disenumpart2.txt
    _90MM_M67_RR (26, "90mm M67 RR"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 84mm M1 Carl Gustav */
    // autogenerated using string template disenumpart2.txt
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "84mm M1 Carl Gustav"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 84mm M2 Carl Gustav */
    // autogenerated using string template disenumpart2.txt
    _84MM_M2_CARL_GUSTAV (31, "84mm M2 Carl Gustav"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 84mm M3 Carl Gustav */
    // autogenerated using string template disenumpart2.txt
    _84MM_M3_CARL_GUSTAV (32, "84mm M3 Carl Gustav"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 84mm M4 Carl Gustav */
    // autogenerated using string template disenumpart2.txt
    _84MM_M4_CARL_GUSTAV (33, "84mm M4 Carl Gustav"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 74mm Pansarskott m/68 Miniman */
    // autogenerated using string template disenumpart2.txt
    _74MM_PANSARSKOTT_M_68_MINIMAN (35, "74mm Pansarskott m/68 Miniman"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 84mm ALAC */
    // autogenerated using string template disenumpart2.txt
    _84MM_ALAC (40, "84mm ALAC"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 82mm B-10 RR */
    // autogenerated using string template disenumpart2.txt
    _82MM_B_10_RR (45, "82mm B-10 RR"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 107mm B-11 RR */
    // autogenerated using string template disenumpart2.txt
    TIME_SPACE_POSITION_INFORMATION (46, "107mm B-11 RR"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 80mm Breda Folgore */
    // autogenerated using string template disenumpart2.txt
    LIVE_ENTITY_DETONATION (50, "80mm Breda Folgore"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 120mm BAT RR */
    // autogenerated using string template disenumpart2.txt
    ACKNOWLEDGE_RELIABLE (55, "120mm BAT RR"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 73mm SPG-9 Kopye */
    // autogenerated using string template disenumpart2.txt
    DATA_RELIABLE (60, "73mm SPG-9 Kopye"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 88mm RCL 3.45in */
    // autogenerated using string template disenumpart2.txt
    RECORD_QUERY_RELIABLE (65, "88mm RCL 3.45in"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 90mm Pvpj 110 */
    // autogenerated using string template disenumpart2.txt
    _90MM_PVPJ_110 (70, "90mm Pvpj 110"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 50mm Jagdfaust */
    // autogenerated using string template disenumpart2.txt
    _50MM_JAGDFAUST (75, "50mm Jagdfaust"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 30mm Rheinmetall RMK30 */
    // autogenerated using string template disenumpart2.txt
    _30MM_RHEINMETALL_RMK30 (80, "30mm Rheinmetall RMK30"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 88mm 55 S 55 Raikka */
    // autogenerated using string template disenumpart2.txt
    _88MM_55_S_55_RAIKKA (90, "88mm 55 S 55 Raikka"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 95mm 95 S 58-61 */
    // autogenerated using string template disenumpart2.txt
    _95MM_95_S_58_61 (91, "95mm 95 S 58-61"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 73mm LG40 */
    // autogenerated using string template disenumpart2.txt
    _73MM_LG40 (95, "73mm LG40"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 105mm LG40 */
    // autogenerated using string template disenumpart2.txt
    _105MM_LG40 (96, "105mm LG40"),
    // autogenerated using string template disenumfootnotecomment.txt

    /** 105mm LG42 */
    // autogenerated using string template disenumpart2.txt
    _105MM_LG42 (97, "105mm LG42");

    // autogenerated using string template disenumpart25.txt

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificRecoillessRifles(int value, String description)
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

    /** 
     * Provide enumeration for a given value
     * @param value integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static LifeFormHumanSpecificRecoillessRifles getEnumForValue(int value)
    {
       for (LifeFormHumanSpecificRecoillessRifles nextEnum : LifeFormHumanSpecificRecoillessRifles.values())
       {
          if (nextEnum.getValue() == value)
              return nextEnum;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No corresponding enumeration found for value " + value + " of enum LifeFormHumanSpecificRecoillessRifles");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    // autogenerated using string template disenumpart3_8.txt

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
    public static LifeFormHumanSpecificRecoillessRifles unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormHumanSpecificRecoillessRifles unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
   * Provide name
   * @return  name
   */
    public String getName()
    {
        return name();
    }

    
  /**
   * Provide simple identifier
   * @return class name, value and name
   */
    @Override
    public String toString()
    {
        String padding = new String();
        if (this.getClass().getName().endsWith("DisPduType") && (getValue() < 10))
            padding = "0"; // leading zero for column spacing
        String result = this.getClass().getSimpleName() + " " + padding + getValue() + " " + name();
        if (getTRACE())
            System.out.println ("*** enum " + this.getClass().getSimpleName() + " name=" + name() + ", value=" + getValue() + "; " +
               result); // debug diagnostic
        return result;
    }
}
