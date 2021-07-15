package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 80 marshal size 16<br>
 * DesignatorSystemName
 */
public enum DesignatorSystemName 
{
    /** Not Specified */
    NOT_SPECIFIED (0, "Not Specified"),
    /** AN/AAQ-4 */
    AN_AAQ_4 (1000, "AN/AAQ-4"),
    /** AN/AAQ-7 */
    AN_AAQ_7 (1100, "AN/AAQ-7"),
    /** AN/AAQ-8 */
    AN_AAQ_8 (1200, "AN/AAQ-8"),
    /** AN/AAQ-14 LANTIRN */
    AN_AAQ_14_LANTIRN (1300, "AN/AAQ-14 LANTIRN"),
    /** AN/AAQ-19 */
    AN_AAQ_19 (1400, "AN/AAQ-19"),
    /** AN/AAQ-22A; SAFIRE */
    AN_AAQ_22A_SAFIRE (1500, "AN/AAQ-22A; SAFIRE"),
    /** AN/AAQ-22B; SAFIRE LP */
    AN_AAQ_22B_SAFIRE_LP (1600, "AN/AAQ-22B; SAFIRE LP"),
    /** AN/AAQ-22C; Star SAFIRE I */
    AN_AAQ_22C_STAR_SAFIRE_I (1700, "AN/AAQ-22C; Star SAFIRE I"),
    /** AN/AAQ-22D; BRITE Star */
    AN_AAQ_22D_BRITE_STAR (1800, "AN/AAQ-22D; BRITE Star"),
    /** AN/AAQ-24(V) DIRCM; Nemesis */
    AN_AAQ_24V_DIRCM_NEMESIS (1900, "AN/AAQ-24(V) DIRCM; Nemesis"),
    /** AN/AAQ-25 LTS */
    AN_AAQ_25_LTS (2000, "AN/AAQ-25 LTS"),
    /** AN/AAQ-28(V) LITENING II */
    AN_AAQ_28V_LITENING_II (2100, "AN/AAQ-28(V) LITENING II"),
    /** AN/AAQ-30 */
    AN_AAQ_30 (2200, "AN/AAQ-30"),
    /** AN/AAQ-32 */
    AN_AAQ_32 (2300, "AN/AAQ-32"),
    /** AN/AAQ-33; Sniper */
    AN_AAQ_33_SNIPER (2400, "AN/AAQ-33; Sniper"),
    /** AN/AAQ-37 */
    AN_AAQ_37 (2500, "AN/AAQ-37"),
    /** AN/AAQ-38 */
    AN_AAQ_38 (2600, "AN/AAQ-38"),
    /** AN/AAS-32 */
    AN_AAS_32 (2700, "AN/AAS-32"),
    /** AN/AAS-35V */
    AN_AAS_35V (2800, "AN/AAS-35V"),
    /** AN/AAS-37 */
    AN_AAS_37 (2900, "AN/AAS-37"),
    /** AN/AAS-38 */
    AN_AAS_38 (3000, "AN/AAS-38"),
    /** AN/AAS-44(V) */
    AN_AAS_44V (3100, "AN/AAS-44(V)"),
    /** AN/AAS-46 */
    AN_AAS_46 (3200, "AN/AAS-46"),
    /** AN/AAS-49 */
    AN_AAS_49 (3300, "AN/AAS-49"),
    /** AN/AAS-51 */
    AN_AAS_51 (3400, "AN/AAS-51"),
    /** AN/AAS-52; MTS-A */
    AN_AAS_52_MTS_A (3500, "AN/AAS-52; MTS-A"),
    /** AN/ALQ-10 */
    AN_ALQ_10 (3600, "AN/ALQ-10"),
    /** AN/ASQ-228 */
    AN_ASQ_228 (3700, "AN/ASQ-228"),
    /** AN/AVQ-25 */
    AN_AVQ_25 (4400, "AN/AVQ-25"),
    /** AN/AVQ-26 */
    AN_AVQ_26 (4500, "AN/AVQ-26"),
    /** AN/GVS-5 */
    AN_GVS_5 (4600, "AN/GVS-5"),
    /** AN/PED-1 LLDR */
    AN_PED_1_LLDR (4700, "AN/PED-1 LLDR"),
    /** TADS LRF/D */
    TADS_LRF_D (4800, "TADS LRF/D"),
    /** MMS LRF/D */
    MMS_LRF_D (4900, "MMS LRF/D"),
    /** AH-1 C-NITE */
    AH_1_C_NITE (5000, "AH-1 C-NITE"),
    /** MATES */
    MATES (5100, "MATES"),
    /** TCV 115 */
    TCV_115 (5200, "TCV 115"),
    /** TIM */
    TIM (5300, "TIM"),
    /** TMS 303 */
    TMS_303 (5400, "TMS 303"),
    /** TMY 303 */
    TMY_303 (5500, "TMY 303"),
    /** ALRAD */
    ALRAD (5600, "ALRAD"),
    /** RFTDL */
    RFTDL (5700, "RFTDL"),
    /** VVLR */
    VVLR (5800, "VVLR"),
    /** P0705 HELL */
    P0705_HELL (6000, "P0705 HELL"),
    /** P0708 PULSE */
    P0708_PULSE (6100, "P0708 PULSE"),
    /** HELD */
    HELD (6200, "HELD"),
    /** TYPE 105 */
    TYPE_105 (6300, "TYPE 105"),
    /** TYPE 118 */
    TYPE_118 (6400, "TYPE 118"),
    /** TYPE 121 */
    TYPE_121 (6500, "TYPE 121"),
    /** TYPE 126 */
    TYPE_126 (6600, "TYPE 126"),
    /** TYPE 629 */
    TYPE_629 (6700, "TYPE 629"),
    /** CLDS */
    CLDS (6800, "CLDS"),
    /** TAV-38 */
    TAV_38 (6900, "TAV-38"),
    /** TMV 630 */
    TMV_630 (7000, "TMV 630"),
    /** ALTM 1020 */
    ALTM_1020 (7100, "ALTM 1020"),
    /** ALATS */
    ALATS (7200, "ALATS"),
    /** Dark Star/LAMPS */
    DARK_STAR_LAMPS (7300, "Dark Star/LAMPS"),
    /** GLTD II */
    GLTD_II (7400, "GLTD II"),
    /** MBT-ELRF */
    MBT_ELRF (7500, "MBT-ELRF"),
    /** Mark VII */
    MARK_VII (7600, "Mark VII"),
    /** SIRE V */
    SIRE_V (7700, "SIRE V"),
    /** AN/AAQ-16B */
    AN_AAQ_16B (7800, "AN/AAQ-16B"),
    /** AN/AAQ-16D; AESOP */
    AN_AAQ_16D_AESOP (7900, "AN/AAQ-16D; AESOP"),
    /** AN/AAQ-21; Star SAFIRE III */
    AN_AAQ_21_STAR_SAFIRE_III (8000, "AN/AAQ-21; Star SAFIRE III"),
    /** AN/AAQ-22E; BRITE Star */
    AN_AAQ_22E_BRITE_STAR (8100, "AN/AAQ-22E; BRITE Star"),
    /** AN/AAQ-36; Star SAFIRE II */
    AN_AAQ_36_STAR_SAFIRE_II (8200, "AN/AAQ-36; Star SAFIRE II"),
    /** AN/AAS-38A; Nite Hawk */
    AN_AAS_38A_NITE_HAWK (8300, "AN/AAS-38A; Nite Hawk"),
    /** AN/AAS-38B; Nite Hawk */
    AN_AAS_38B_NITE_HAWK (8400, "AN/AAS-38B; Nite Hawk"),
    /** AN/AAS-44C(V) */
    AN_AAS_44CV (8500, "AN/AAS-44C(V)"),
    /** AN/AAS-53; CSP */
    AN_AAS_53_CSP (8600, "AN/AAS-53; CSP"),
    /** AN/ASQ-28 ATFLIR */
    AN_ASQ_28_ATFLIR (8700, "AN/ASQ-28 ATFLIR"),
    /** AN/DAS-1; MTS-B */
    AN_DAS_1_MTS_B (8800, "AN/DAS-1; MTS-B"),
    /** AN/PAQ-1 LTD */
    AN_PAQ_1_LTD (8900, "AN/PAQ-1 LTD"),
    /** AN/PAQ-3 MULE */
    AN_PAQ_3_MULE (9000, "AN/PAQ-3 MULE"),
    /** AN/PEQ-1; SOFLAM */
    AN_PEQ_1_SOFLAM (9090, "AN/PEQ-1; SOFLAM"),
    /** AN/PEQ-3 */
    AN_PEQ_3 (9100, "AN/PEQ-3"),
    /** AN/PEQ-15; ATPIAL */
    AN_PEQ_15_ATPIAL (9140, "AN/PEQ-15; ATPIAL"),
    /** AN/PEQ-18; IZLID 1000P */
    AN_PEQ_18_IZLID_1000P (9150, "AN/PEQ-18; IZLID 1000P"),
    /** AN/TVQ-2 G/VLLD */
    AN_TVQ_2_G_VLLD (9200, "AN/TVQ-2 G/VLLD"),
    /** AN/ZSQ-2(V)1 EOS */
    AN_ZSQ_2V1_EOS (9300, "AN/ZSQ-2(V)1 EOS"),
    /** AN/ZSQ-2(V)2 EOS */
    AN_ZSQ_2V2_EOS (9400, "AN/ZSQ-2(V)2 EOS"),
    /** CIRCM */
    CIRCM (9500, "CIRCM"),
    /** Guardian */
    GUARDIAN (9600, "Guardian"),
    /** IZLID 200P */
    IZLID_200P (9700, "IZLID 200P"),
    /** IZLID 1000P-W */
    IZLID_1000P_W (9800, "IZLID 1000P-W"),
    /** MMS */
    MMS (9900, "MMS"),
    /** M-TADS/PNVS; Arrowhead */
    M_TADS_PNVS_ARROWHEAD (10000, "M-TADS/PNVS; Arrowhead"),
    /** RBS-70 */
    RBS_70 (10100, "RBS-70"),
    /** RBS-90 */
    RBS_90 (10200, "RBS-90"),
    /** TADS/PNVS */
    TADS_PNVS (10300, "TADS/PNVS");

    private int value;
    private final String description;

    /** Constructor */
    DesignatorSystemName(int value, String description)
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
      return 16;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static DesignatorSystemName getEnumForValue(int i)
    {
       for(DesignatorSystemName val: DesignatorSystemName.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DesignatorSystemName");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static DesignatorSystemName unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static DesignatorSystemName unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "DesignatorSystemName " + getValue() + " " + name(); 
    }
}
