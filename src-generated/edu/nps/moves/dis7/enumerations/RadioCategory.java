package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 22 marshal size 8<br>
 * Radio Category
 */
public enum RadioCategory implements Category
{
    /** Other */
    OTHER (0, "Other"),
    /** Voice Transmission/Reception */
    VOICE_TRANSMISSION_RECEPTION (1, "Voice Transmission/Reception"),
    /** Data Link Transmission/Reception */
    DATA_LINK_TRANSMISSION_RECEPTION (2, "Data Link Transmission/Reception"),
    /** Voice and Data Link Transmission/Reception */
    VOICE_AND_DATA_LINK_TRANSMISSION_RECEPTION (3, "Voice and Data Link Transmission/Reception"),
    /** Instrumented Landing System (ILS) Glideslope Transmitter */
    INSTRUMENTED_LANDING_SYSTEM_ILS_GLIDESLOPE_TRANSMITTER (4, "Instrumented Landing System (ILS) Glideslope Transmitter"),
    /** Instrumented Landing System (ILS) Localizer Transmitter */
    INSTRUMENTED_LANDING_SYSTEM_ILS_LOCALIZER_TRANSMITTER (5, "Instrumented Landing System (ILS) Localizer Transmitter"),
    /** Instrumented Landing System (ILS) Outer Marker Beacon */
    INSTRUMENTED_LANDING_SYSTEM_ILS_OUTER_MARKER_BEACON (6, "Instrumented Landing System (ILS) Outer Marker Beacon"),
    /** Instrumented Landing System (ILS) Middle Marker Beacon */
    INSTRUMENTED_LANDING_SYSTEM_ILS_MIDDLE_MARKER_BEACON (7, "Instrumented Landing System (ILS) Middle Marker Beacon"),
    /** Instrumented Landing System (ILS) Inner Marker Beacon */
    INSTRUMENTED_LANDING_SYSTEM_ILS_INNER_MARKER_BEACON (8, "Instrumented Landing System (ILS) Inner Marker Beacon"),
    /** Instrumented Landing System (ILS) Receiver (Platform Radio) */
    INSTRUMENTED_LANDING_SYSTEM_ILS_RECEIVER_PLATFORM_RADIO (9, "Instrumented Landing System (ILS) Receiver (Platform Radio)"),
    /** Tactical Air Navigation (TACAN) Transmitter (Ground Fixed Equipment) */
    TACTICAL_AIR_NAVIGATION_TACAN_TRANSMITTER_GROUND_FIXED_EQUIPMENT (10, "Tactical Air Navigation (TACAN) Transmitter (Ground Fixed Equipment)"),
    /** Tactical Air Navigation (TACAN) Receiver (Moving Platform Equipment) */
    TACTICAL_AIR_NAVIGATION_TACAN_RECEIVER_MOVING_PLATFORM_EQUIPMENT (11, "Tactical Air Navigation (TACAN) Receiver (Moving Platform Equipment)"),
    /** Tactical Air Navigation (TACAN) Transmitter/Receiver (Moving Platform Equipment) */
    TACTICAL_AIR_NAVIGATION_TACAN_TRANSMITTER_RECEIVER_MOVING_PLATFORM_EQUIPMENT (12, "Tactical Air Navigation (TACAN) Transmitter/Receiver (Moving Platform Equipment)"),
    /** Variable Omni-Ranging (VOR) Transmitter (Ground Fixed Equipment) */
    VARIABLE_OMNI_RANGING_VOR_TRANSMITTER_GROUND_FIXED_EQUIPMENT (13, "Variable Omni-Ranging (VOR) Transmitter (Ground Fixed Equipment)"),
    /** Variable Omni-Ranging (VOR) with Distance Measuring Equipment (DME) Transmitter (Ground Fixed Equipment) */
    VARIABLE_OMNI_RANGING_VOR_WITH_DISTANCE_MEASURING_EQUIPMENT_DME_TRANSMITTER_GROUND_FIXED_EQUIPMENT (14, "Variable Omni-Ranging (VOR) with Distance Measuring Equipment (DME) Transmitter (Ground Fixed Equipment)"),
    /** Combined VOR/ILS Receiver (Moving Platform Equipment) */
    COMBINED_VOR_ILS_RECEIVER_MOVING_PLATFORM_EQUIPMENT (15, "Combined VOR/ILS Receiver (Moving Platform Equipment)"),
    /** Combined VOR and TACAN (VORTAC) Transmitter */
    COMBINED_VOR_TACAN_VORTAC_TRANSMITTER (16, "Combined VOR & TACAN (VORTAC) Transmitter"),
    /** Non-Directional Beacon (NDB) Transmitter */
    NON_DIRECTIONAL_BEACON_NDB_TRANSMITTER (17, "Non-Directional Beacon (NDB) Transmitter"),
    /** Non-Directional Beacon (NDB) Receiver */
    NON_DIRECTIONAL_BEACON_NDB_RECEIVER (18, "Non-Directional Beacon (NDB) Receiver"),
    /** Non-Directional Beacon (NDB) with Distance Measuring Equipment (DME) Transmitter */
    NON_DIRECTIONAL_BEACON_NDB_WITH_DISTANCE_MEASURING_EQUIPMENT_DME_TRANSMITTER (19, "Non-Directional Beacon (NDB) with Distance Measuring Equipment (DME) Transmitter"),
    /** Distance Measuring Equipment (DME) */
    DISTANCE_MEASURING_EQUIPMENT_DME (20, "Distance Measuring Equipment (DME)"),
    /** Link 16 Terminal */
    LINK_16_TERMINAL (21, "Link 16 Terminal"),
    /** Link 11 Terminal */
    LINK_11_TERMINAL (22, "Link 11 Terminal"),
    /** Link 11B Terminal */
    LINK_11B_TERMINAL (23, "Link 11B Terminal"),
    /** EPLRS/SADL Terminal */
    EPLRS_SADL_TERMINAL (24, "EPLRS/SADL Terminal"),
    /** F-22 Intra-Flight Data Link (IFDL) */
    F_22_INTRA_FLIGHT_DATA_LINK_IFDL (25, "F-22 Intra-Flight Data Link (IFDL)"),
    /** F-35 Multifunction Advanced Data Link (MADL) */
    F_35_MULTIFUNCTION_ADVANCED_DATA_LINK_MADL (26, "F-35 Multifunction Advanced Data Link (MADL)"),
    /** SINCGARS Terminal */
    SINCGARS_TERMINAL (27, "SINCGARS Terminal"),
    /** L-Band SATCOM Terminal */
    L_BAND_SATCOM_TERMINAL (28, "L-Band SATCOM Terminal"),
    /** IBS Terminal */
    IBS_TERMINAL (29, "IBS Terminal"),
    /** GPS */
    GPS (30, "GPS"),
    /** Tactical Video */
    TACTICAL_VIDEO (31, "Tactical Video"),
    /** Air-to-Air Missile Datalink */
    AIR_TO_AIR_MISSILE_DATALINK (32, "Air-to-Air Missile Datalink"),
    /** Link 16 Surrogate for Non-NATO TDL Terminal, Using Link 16 and SISO-STD-002 to simulate a non-NATO TDL system */
    LINK_16_SURROGATE_FOR_NON_NATO_TDL_TERMINAL (33, "Link 16 Surrogate for Non-NATO TDL Terminal"),
    /** MQ-1/9 C-Band LOS Datalink */
    MQ_1_9_C_BAND_LOS_DATALINK (34, "MQ-1/9 C-Band LOS Datalink"),
    /** MQ-1/9 Ku-Band SATCOM Datalink */
    MQ_1_9_KU_BAND_SATCOM_DATALINK (35, "MQ-1/9 Ku-Band SATCOM Datalink"),
    /** Air-to-Ground Weapon Datalink */
    AIR_TO_GROUND_WEAPON_DATALINK (36, "Air-to-Ground Weapon Datalink"),
    /** Automatic Identification System (AIS) */
    AUTOMATIC_IDENTIFICATION_SYSTEM_AIS (37, "Automatic Identification System (AIS)"),
    /** JPALS Data Link */
    JPALS_DATA_LINK (38, "JPALS Data Link"),
    /** Combat Search and Rescue (CSAR) Radio */
    COMBAT_SEARCH_AND_RESCUE_CSAR_RADIO (40, "Combat Search and Rescue (CSAR) Radio"),
    /** Counter Unmanned Aircraft System (C-UAS) Radio */
    COUNTER_UNMANNED_AIRCRAFT_SYSTEM_C_UAS_RADIO (41, "Counter Unmanned Aircraft System (C-UAS) Radio"),
    /** Electronic Attack Systems */
    ELECTRONIC_ATTACK_SYSTEMS (50, "Electronic Attack Systems");

    private int value;
    private final String description;

    RadioCategory(int value, String description)
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
      return 8;
    }

    public static RadioCategory getEnumForValue(int i)
    {
       for(RadioCategory val: RadioCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration RadioCategory");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
    }

    public static RadioCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static RadioCategory unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "RadioCategory: " + name() + ": " + getValue(); 
    }
}
