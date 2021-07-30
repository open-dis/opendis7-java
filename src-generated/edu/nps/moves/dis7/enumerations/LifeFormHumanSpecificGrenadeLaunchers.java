package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 515 marshal size 8<br>
 * LifeFormHumanSpecificGrenadeLaunchers
 */
public enum LifeFormHumanSpecificGrenadeLaunchers 
{
    /** Other */
    OTHER (0, "Other"),
    /** 40x46mm Arsenal UGGL-M1 */
    _40X46MM_ARSENAL_UGGL_M1 (1, "40x46mm Arsenal UGGL-M1"),
    /** 40x46mm Arsenal MSGL */
    _40X46MM_ARSENAL_MSGL (2, "40x46mm Arsenal MSGL"),
    /** 40mm VOG Arsenal MSGL */
    _40MM_VOG_ARSENAL_MSGL (3, "40mm VOG Arsenal MSGL"),
    /** 40x46mm Arsenal UBGL-M16 */
    _40X46MM_ARSENAL_UBGL_M16 (4, "40x46mm Arsenal UBGL-M16"),
    /** 40x46mm Arsenal UBGL-M8 */
    _40X46MM_ARSENAL_UBGL_M8 (5, "40x46mm Arsenal UBGL-M8"),
    /** 40x46mm Arsenal UBGL-M7 */
    _40X46MM_ARSENAL_UBGL_M7 (6, "40x46mm Arsenal UBGL-M7"),
    /** 30mm BS-1 Tishina */
    _30MM_BS_1_TISHINA (10, "30mm BS-1 Tishina"),
    /** 40mm BTS-203 */
    _40MM_BTS_203 (11, "40mm BTS-203"),
    /** 40mm Indumil IMC-40 */
    _40MM_INDUMIL_IMC_40 (12, "40mm Indumil IMC-40"),
    /** 40mm VOG BG-15 */
    _40MM_VOG_BG_15 (20, "40mm VOG BG-15"),
    /** 40mm VOG GP-25 Kostoyor */
    _40MM_VOG_GP_25_KOSTOYOR (21, "40mm VOG GP-25 Kostoyor"),
    /** 40mm VOG GP-30 Obuvka */
    _40MM_VOG_GP_30_OBUVKA (22, "40mm VOG GP-30 Obuvka"),
    /** 40mm VOG GP-34 */
    _40MM_VOG_GP_34 (23, "40mm VOG GP-34"),
    /** 40mm VOG RGM-40 Kastet */
    _40MM_VOG_RGM_40_KASTET (24, "40mm VOG RGM-40 Kastet"),
    /** 40mm VOG RG-6 */
    _40MM_VOG_RG_6 (25, "40mm VOG RG-6"),
    /** 40x46mm M79 */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "40x46mm M79"),
    /** 40x46mm M203 */
    _40X46MM_M203 (31, "40x46mm M203"),
    /** 40x36mm M320 */
    _40X36MM_M320 (32, "40x36mm M320"),
    /** 40x46mm CIS 40 GL */
    _40X46MM_CIS_40_GL (35, "40x46mm CIS 40 GL"),
    /** 40x46mm EAGLE GL */
    _40X46MM_EAGLE_GL (36, "40x46mm EAGLE GL"),
    /** 40x46mm HK AG36 */
    _40X46MM_HK_AG36 (37, "40x46mm HK AG36"),
    /** 40x46mm HK AG-C/GLM */
    _40X46MM_HK_AG_C_GLM (38, "40x46mm HK AG-C/GLM"),
    /** 40x46mm HK69A1 */
    _40X46MM_HK69A1 (39, "40x46mm HK69A1"),
    /** 40x46mm Beretta GLX 160 */
    _40X46MM_BERETTA_GLX_160 (40, "40x46mm Beretta GLX 160"),
    /** 40x46mm ARDE UBGL */
    _40X46MM_ARDE_UBGL (41, "40x46mm ARDE UBGL"),
    /** 40x46mm XML148 */
    _40X46MM_XML148 (42, "40x46mm XML148"),
    /** 40x46mm China Lake GL */
    _40X46MM_CHINA_LAKE_GL (43, "40x46mm China Lake GL"),
    /** 40x46mm Hawk MM-1 */
    _40X46MM_HAWK_MM_1 (44, "40x46mm Hawk MM-1"),
    /** 25x40mm XM25 CDTE */
    LIVE_ENTITY_DETONATION (50, "25x40mm XM25 CDTE"),
    /** 37mm Milkor37/38 LL Stopper */
    DATA_RELIABLE (60, "37mm Milkor37/38 LL Stopper"),
    /** 40mm Milkor40 GL */
    EVENT_REPORT_RELIABLE (61, "40mm Milkor40 GL"),
    /** 40mm Milkor MGL */
    COMMENT_RELIABLE (62, "40mm Milkor MGL"),
    /** 40x47mm Pallad wz1974 */
    RECORD_QUERY_RELIABLE (65, "40x47mm Pallad wz1974"),
    /** 40x47mm Pallad wz1983 */
    _40X47MM_PALLAD_WZ1983 (66, "40x47mm Pallad wz1983"),
    /** UGL 200 Canister RWGL-3 */
    UGL_200_CANISTER_RWGL_3 (70, "UGL 200 Canister RWGL-3"),
    /** 20x30mm ST Daewoo K11 */
    _20X30MM_ST_DAEWOO_K11 (80, "20x30mm ST Daewoo K11"),
    /** 35mm Type-91 BreechLoad GL */
    _35MM_TYPE_91_BREECHLOAD_GL (90, "35mm Type-91 BreechLoad GL"),
    /** 40x53mm CZW-40 */
    _40X53MM_CZW_40 (95, "40x53mm CZW-40"),
    /** 45mm DP-64 */
    _45MM_DP_64 (100, "45mm DP-64"),
    /** 20x42mm Neopup PAW-20 */
    _20X42MM_NEOPUP_PAW_20 (105, "20x42mm Neopup PAW-20");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificGrenadeLaunchers(int value, String description)
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
    public static LifeFormHumanSpecificGrenadeLaunchers getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificGrenadeLaunchers val: LifeFormHumanSpecificGrenadeLaunchers.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificGrenadeLaunchers");
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
    public static LifeFormHumanSpecificGrenadeLaunchers unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormHumanSpecificGrenadeLaunchers unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
