package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 60 marshal size 16<br>
 * MunitionDescriptorWarhead
 */
public enum MunitionDescriptorWarhead 
{
    /** Other */
    OTHER (0000, "Other"),
    /** Cargo (Variable Submunitions) */
    CARGO_VARIABLE_SUBMUNITIONS (0010, "Cargo (Variable Submunitions)"),
    /** Fuel/Air Explosive */
    FUEL_AIR_EXPLOSIVE (0020, "Fuel/Air Explosive"),
    /** Glass Beads */
    GLASS_BEADS (0030, "Glass Beads"),
    /** 1 um */
    _1_UM (0031, "1 um"),
    /** 5 um */
    _5_UM (0032, "5 um"),
    /** 10 um */
    _10_UM (0033, "10 um"),
    /** High Explosive (HE) */
    HIGH_EXPLOSIVE_HE (1000, "High Explosive (HE)"),
    /** HE, Plastic */
    HE_PLASTIC (1100, "HE, Plastic"),
    /** HE, Incendiary */
    HE_INCENDIARY (1200, "HE, Incendiary"),
    /** HE, Fragmentation */
    HE_FRAGMENTATION (1300, "HE, Fragmentation"),
    /** HE, Anti-Tank */
    HE_ANTI_TANK (1400, "HE, Anti-Tank"),
    /** HE, Bomblets */
    HE_BOMBLETS (1500, "HE, Bomblets"),
    /** HE, Shaped Charge */
    HE_SHAPED_CHARGE (1600, "HE, Shaped Charge"),
    /** HE, Continuous Rod */
    HE_CONTINUOUS_ROD (1610, "HE, Continuous Rod"),
    /** HE, Tungsten Ball */
    HE_TUNGSTEN_BALL (1615, "HE, Tungsten Ball"),
    /** HE, Blast Fragmentation */
    HE_BLAST_FRAGMENTATION (1620, "HE, Blast Fragmentation"),
    /** HE, Steerable Darts with HE */
    HE_STEERABLE_DARTS_WITH_HE (1625, "HE, Steerable Darts with HE"),
    /** HE, Darts */
    HE_DARTS (1630, "HE, Darts"),
    /** HE, Flechettes */
    HE_FLECHETTES (1635, "HE, Flechettes"),
    /** HE, Directed Fragmentation */
    HE_DIRECTED_FRAGMENTATION (1640, "HE, Directed Fragmentation"),
    /** HE, Semi-Armor Piercing (SAP) */
    HE_SEMI_ARMOR_PIERCING_SAP (1645, "HE, Semi-Armor Piercing (SAP)"),
    /** HE, Shaped Charge Fragmentation */
    HE_SHAPED_CHARGE_FRAGMENTATION (1650, "HE, Shaped Charge Fragmentation"),
    /** HE, Semi-Armor Piercing, Fragmentation */
    HE_SEMI_ARMOR_PIERCING_FRAGMENTATION (1655, "HE, Semi-Armor Piercing, Fragmentation"),
    /** HE, Hollow Charge */
    HE_HOLLOW_CHARGE (1660, "HE, Hollow Charge"),
    /** HE, Double Hollow Charge */
    HE_DOUBLE_HOLLOW_CHARGE (1665, "HE, Double Hollow Charge"),
    /** HE, General Purpose */
    HE_GENERAL_PURPOSE (1670, "HE, General Purpose"),
    /** HE, Blast Penetrator */
    HE_BLAST_PENETRATOR (1675, "HE, Blast Penetrator"),
    /** HE, Rod Penetrator */
    HE_ROD_PENETRATOR (1680, "HE, Rod Penetrator"),
    /** HE, Anti-Personnel */
    HE_ANTI_PERSONNEL (1685, "HE, Anti-Personnel"),
    /** HE, Shaped Charge, Fragmentation, Incendiary */
    HE_SHAPED_CHARGE_FRAGMENTATION_INCENDIARY (1690, "HE, Shaped Charge, Fragmentation, Incendiary"),
    /** HE, Penetrator, Blast, Fragmentation */
    HE_PENETRATOR_BLAST_FRAGMENTATION (1695, "HE, Penetrator, Blast, Fragmentation"),
    /** Smoke */
    SMOKE (2000, "Smoke"),
    /** WP (White Phosphorus) */
    WP_WHITE_PHOSPHORUS (2005, "WP (White Phosphorus)"),
    /** FOGO (Fog Oil) */
    FOGO_FOG_OIL (2010, "FOGO (Fog Oil)"),
    /** HC (HexaChloroEthane) */
    HC_HEXACHLOROETHANE (2015, "HC (HexaChloroEthane)"),
    /** Illumination */
    ILLUMINATION (3000, "Illumination"),
    /** Practice */
    PRACTICE (4000, "Practice"),
    /** Blank */
    BLANK (4001, "Blank"),
    /** Dummy */
    DUMMY (4002, "Dummy"),
    /** Kinetic */
    KINETIC (5000, "Kinetic"),
    /** Mines */
    MINES (6000, "Mines"),
    /** Nuclear */
    NUCLEAR (7000, "Nuclear"),
    /** Nuclear, IMT */
    NUCLEAR_IMT (7010, "Nuclear, IMT"),
    /** Chemical, General */
    CHEMICAL_GENERAL (8000, "Chemical, General"),
    /** Chemical, Blister Agent */
    CHEMICAL_BLISTER_AGENT (8100, "Chemical, Blister Agent"),
    /** HD (Mustard) */
    HD_MUSTARD (8110, "HD (Mustard)"),
    /** Thickened HD (Mustard) */
    THICKENED_HD_MUSTARD (8115, "Thickened HD (Mustard)"),
    /** Dusty HD (Mustard) */
    DUSTY_HD_MUSTARD (8120, "Dusty HD (Mustard)"),
    /** L (Lewisite) */
    L_LEWISITE (8125, "L (Lewisite)"),
    /** HN3 (Nitrogen Mustard) */
    HN3_NITROGEN_MUSTARD (8130, "HN3 (Nitrogen Mustard)"),
    /** HL (Mustard/Lewisite) */
    HL_MUSTARD_LEWISITE (8135, "HL (Mustard/Lewisite)"),
    /** CX (Phosgene Oxime) */
    CX_PHOSGENE_OXIME (8140, "CX (Phosgene Oxime)"),
    /** DMMP (Phosphate Dimethyl Hydrogen) */
    DMMP_PHOSPHATE_DIMETHYL_HYDROGEN (8145, "DMMP (Phosphate Dimethyl Hydrogen)"),
    /** DMHP (Phosphite) */
    DMHP_PHOSPHITE (8150, "DMHP (Phosphite)"),
    /** DMA (Dimethyl Acrylate) */
    DMA_DIMETHYL_ACRYLATE (8155, "DMA (Dimethyl Acrylate)"),
    /** DEM */
    DEM (8160, "DEM"),
    /** PX (P-xlene) */
    PX_P_XLENE (8165, "PX (P-xlene)"),
    /** Chemical, Blood Agent */
    CHEMICAL_BLOOD_AGENT (8200, "Chemical, Blood Agent"),
    /** AC (HCN) */
    AC_HCN (8210, "AC (HCN)"),
    /** CK (CNCI) */
    CK_CNCI (8215, "CK (CNCI)"),
    /** CG (Phosgene) */
    CG_PHOSGENE (8220, "CG (Phosgene)"),
    /** Chemical, Nerve Agent */
    CHEMICAL_NERVE_AGENT (8300, "Chemical, Nerve Agent"),
    /** VX */
    VX (8310, "VX"),
    /** Thickened VX */
    THICKENED_VX (8315, "Thickened VX"),
    /** Dusty VX */
    DUSTY_VX (8320, "Dusty VX"),
    /** GA (Tabun) */
    GA_TABUN (8325, "GA (Tabun)"),
    /** Thickened GA (Tabun) */
    THICKENED_GA_TABUN (8330, "Thickened GA (Tabun)"),
    /** Dusty GA (Tabun) */
    DUSTY_GA_TABUN (8335, "Dusty GA (Tabun)"),
    /** GB (Sarin) */
    GB_SARIN (8340, "GB (Sarin)"),
    /** Thickened GB (Sarin) */
    THICKENED_GB_SARIN (8345, "Thickened GB (Sarin)"),
    /** Dusty GB (Sarin) */
    DUSTY_GB_SARIN (8350, "Dusty GB (Sarin)"),
    /** GD (Soman) */
    GD_SOMAN (8355, "GD (Soman)"),
    /** Thickened GD (Soman) */
    THICKENED_GD_SOMAN (8360, "Thickened GD (Soman)"),
    /** Dusty GD (Soman) */
    DUSTY_GD_SOMAN (8365, "Dusty GD (Soman)"),
    /** GF */
    GF (8370, "GF"),
    /** Thickened GF */
    THICKENED_GF (8375, "Thickened GF"),
    /** Dusty GF */
    DUSTY_GF (8380, "Dusty GF"),
    /** SVX (Soviet VX) */
    SVX_SOVIET_VX (8385, "SVX (Soviet VX)"),
    /** BIS */
    BIS (8410, "BIS"),
    /** TCP */
    TCP (8415, "TCP"),
    /** MS (Methyl Salicylate) */
    MS_METHYL_SALICYLATE (8425, "MS (Methyl Salicylate)"),
    /** TEP */
    TEP (8430, "TEP"),
    /** H2O (Water) */
    H2O_WATER (8445, "H2O (Water)"),
    /** TO1 (Toxic Organic 1) */
    TO1_TOXIC_ORGANIC_1 (8450, "TO1 (Toxic Organic 1)"),
    /** TO2 (Toxic Organic 2) */
    TO2_TOXIC_ORGANIC_2 (8455, "TO2 (Toxic Organic 2)"),
    /** TO3 (Toxic Organic 3) */
    TO3_TOXIC_ORGANIC_3 (8460, "TO3 (Toxic Organic 3)"),
    /** Sulfur Hexafluoride */
    SULFUR_HEXAFLUORIDE (8465, "Sulfur Hexafluoride"),
    /** AA (Acetic Acid) */
    AA_ACETIC_ACID (8470, "AA (Acetic Acid)"),
    /** HF (Hydrofluoric Acid) */
    HF_HYDROFLUORIC_ACID (8475, "HF (Hydrofluoric Acid)"),
    /** Biological */
    BIOLOGICAL (9000, "Biological"),
    /** Biological, Virus */
    BIOLOGICAL_VIRUS (9100, "Biological, Virus"),
    /** Biological, Bacteria */
    BIOLOGICAL_BACTERIA (9200, "Biological, Bacteria"),
    /** Biological, Rickettsia */
    BIOLOGICAL_RICKETTSIA (9300, "Biological, Rickettsia"),
    /** Biological, Genetically Modified Micro-organisms */
    BIOLOGICAL_GENETICALLY_MODIFIED_MICRO_ORGANISMS (9400, "Biological, Genetically Modified Micro-organisms"),
    /** Biological, Toxin */
    BIOLOGICAL_TOXIN (9500, "Biological, Toxin");

    private int value;
    private final String description;

    MunitionDescriptorWarhead(int value, String description)
    {
        this.value = value;
        this.description = description;
    }

    public int getValue()
    {
        return value;
    }

    public String getDescription()
    {
        return description;
    }
    
    public static int getEnumBitWidth()
    {
      return 16;
    }

    public static MunitionDescriptorWarhead getEnumForValue(int i)
    {
       for(MunitionDescriptorWarhead val: MunitionDescriptorWarhead.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MunitionDescriptorWarhead");
       return null;
    }

 
   public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }

    public static MunitionDescriptorWarhead unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static MunitionDescriptorWarhead unmarshalEnum (ByteBuffer byteBuffer) throws Exception
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
        return "MunitionDescriptorWarhead " + getValue() + " " + name(); 
    }
}
