package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 481 marshal size 8<br>
 * LifeFormHumanSpecificSniper
 */
public enum LifeFormHumanSpecificSniper 
{
    /** Other */
    OTHER (0, "Other"),
    /** 5.8mm QBU-88 (Type 88) */
    _58MM_QBU_88_TYPE_88 (1, "5.8mm QBU-88 (Type 88)"),
    /** 7.62mm C3 */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "7.62mm C3"),
    /** 7.62mm FR F2 */
    _762MM_FR_F2 (31, "7.62mm FR F2"),
    /** 7.62mm AWM-F (G22) */
    _762MM_AWM_F_G22 (32, "7.62mm AWM-F (G22)"),
    /** 7.62mm G3 SG/1 */
    _762MM_G3_SG_1 (33, "7.62mm G3 SG/1"),
    /** 7.62mm Galil Sniper */
    _762MM_GALIL_SNIPER (34, "7.62mm Galil Sniper"),
    /** 7.62mm L96A1 */
    _762MM_L96A1 (35, "7.62mm L96A1"),
    /** 7.62mm M14 DMR */
    _762MM_M14_DMR (36, "7.62mm M14 DMR"),
    /** 7.62mm M24 Sniper Weapon System (SWS) */
    _762MM_M24_SNIPER_WEAPON_SYSTEM_SWS (37, "7.62mm M24 Sniper Weapon System (SWS)"),
    /** 7.62mm M40A1/A3 */
    _762MM_M40A1_A3 (38, "7.62mm M40A1/A3"),
    /** 7.62mm Steyr SSG 69 */
    _762MM_STEYR_SSG_69 (39, "7.62mm Steyr SSG 69"),
    /** 7.62mm SVD (Dragunov) */
    _762MM_SVD_DRAGUNOV (40, "7.62mm SVD (Dragunov)"),
    /** 7.62mm TYPE 79 */
    _762MM_TYPE_79 (41, "7.62mm TYPE 79"),
    /** 7.62mm SR-25 MK11 */
    _762MM_SR_25_MK11 (42, "7.62mm SR-25 MK11"),
    /** 7.62mm AW SR-98 */
    _762MM_AW_SR_98 (43, "7.62mm AW SR-98"),
    /** 7.62mm Blaser R93 */
    _762MM_BLASER_R93 (44, "7.62mm Blaser R93"),
    /** 7.7mm TYPE 99 */
    _77MM_TYPE_99 (100, "7.7mm TYPE 99"),
    /** 8.58mm Blaser R93 Tactical 2 */
    _858MM_BLASER_R93_TACTICAL_2 (105, "8.58mm Blaser R93 Tactical 2"),
    /** 9mm VSS Vintorez */
    _9MM_VSS_VINTOREZ (110, "9mm VSS Vintorez"),
    /** 12.7mm Steyr HS .50 */
    _127MM_STEYR_HS_50 (170, "12.7mm Steyr HS .50"),
    /** 12.7mm M82A1A Special Applications Scoped Rifle (SASR) */
    _127MM_M82A1A_SPECIAL_APPLICATIONS_SCOPED_RIFLE_SASR (171, "12.7mm M82A1A Special Applications Scoped Rifle (SASR)"),
    /** 12.7mm NSV */
    _127MM_NSV (172, "12.7mm NSV"),
    /** 12.7mm OSV-96 */
    _127MM_OSV_96 (173, "12.7mm OSV-96"),
    /** 12.7mm Rangemaster 50 */
    _127MM_RANGEMASTER_50 (174, "12.7mm Rangemaster 50"),
    /** 12.7mm V94 */
    _127MM_V94 (175, "12.7mm V94"),
    /** 20mm Denel NTW-20 */
    _20MM_DENEL_NTW_20 (200, "20mm Denel NTW-20");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificSniper(int value, String description)
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
    public static LifeFormHumanSpecificSniper getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificSniper val: LifeFormHumanSpecificSniper.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificSniper");
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
    public static LifeFormHumanSpecificSniper unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormHumanSpecificSniper unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
