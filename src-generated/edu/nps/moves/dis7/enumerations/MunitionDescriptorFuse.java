package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 61 marshal size 16<br>
 * Munition Descriptor-Fuse
 */
public enum MunitionDescriptorFuse 
{
    /** Other */
    OTHER (0000, "Other"),
    /** Intelligent Influence */
    INTELLIGENT_INFLUENCE (0010, "Intelligent Influence"),
    /** Sensor */
    SENSOR (0020, "Sensor"),
    /** Self-destruct */
    SELF_DESTRUCT (0030, "Self-destruct"),
    /** Ultra Quick */
    ULTRA_QUICK (0040, "Ultra Quick"),
    /** Body */
    BODY (0050, "Body"),
    /** Deep Intrusion */
    DEEP_INTRUSION (0060, "Deep Intrusion"),
    /** Multifunction */
    MULTIFUNCTION (0100, "Multifunction"),
    /** Point Detonation (PD) */
    POINT_DETONATION_PD (0200, "Point Detonation (PD)"),
    /** Base Detonation (BD) */
    BASE_DETONATION_BD (0300, "Base Detonation (BD)"),
    /** Contact */
    CONTACT (1000, "Contact"),
    /** Contact, Instant (Impact) */
    CONTACT_INSTANT_IMPACT (1100, "Contact, Instant (Impact)"),
    /** Contact, Delayed */
    CONTACT_DELAYED (1200, "Contact, Delayed"),
    /** 10 ms Delay */
    $10_MS_DELAY (1201, "10 ms Delay"),
    /** 20 ms Delay */
    $20_MS_DELAY (1202, "20 ms Delay"),
    /** 50 ms Delay */
    $50_MS_DELAY (1205, "50 ms Delay"),
    /** 60 ms Delay */
    $60_MS_DELAY (1206, "60 ms Delay"),
    /** 100 ms Delay */
    $100_MS_DELAY (1210, "100 ms Delay"),
    /** 125 ms Delay */
    $125_MS_DELAY (1212, "125 ms Delay"),
    /** 250 ms Delay */
    $250_MS_DELAY (1225, "250 ms Delay"),
    /** 5 ms Delay */
    $5_MS_DELAY (1250, "5 ms Delay"),
    /** 15 ms Delay */
    $15_MS_DELAY (1251, "15 ms Delay"),
    /** 25 ms Delay */
    $25_MS_DELAY (1252, "25 ms Delay"),
    /** 30 ms Delay */
    $30_MS_DELAY (1253, "30 ms Delay"),
    /** 35 ms Delay */
    $35_MS_DELAY (1254, "35 ms Delay"),
    /** 40 ms Delay */
    $40_MS_DELAY (1255, "40 ms Delay"),
    /** 45 ms Delay */
    $45_MS_DELAY (1256, "45 ms Delay"),
    /** 90 ms Delay */
    $90_MS_DELAY (1257, "90 ms Delay"),
    /** 120 ms Delay */
    $120_MS_DELAY (1258, "120 ms Delay"),
    /** 180 ms Delay */
    $180_MS_DELAY (1259, "180 ms Delay"),
    /** 240 ms Delay */
    $240_MS_DELAY (1260, "240 ms Delay"),
    /** Contact, Electronic (Oblique Contact) */
    CONTACT_ELECTRONIC_OBLIQUE_CONTACT (1300, "Contact, Electronic (Oblique Contact)"),
    /** Contact, Graze */
    CONTACT_GRAZE (1400, "Contact, Graze"),
    /** Contact, Crush */
    CONTACT_CRUSH (1500, "Contact, Crush"),
    /** Contact, Hydrostatic */
    CONTACT_HYDROSTATIC (1600, "Contact, Hydrostatic"),
    /** Contact, Mechanical */
    CONTACT_MECHANICAL (1700, "Contact, Mechanical"),
    /** Contact, Chemical */
    CONTACT_CHEMICAL (1800, "Contact, Chemical"),
    /** Contact, Piezoelectric */
    CONTACT_PIEZOELECTRIC (1900, "Contact, Piezoelectric"),
    /** Contact, Point Initiating */
    CONTACT_POINT_INITIATING (1910, "Contact, Point Initiating"),
    /** Contact, Point Initiating, Base Detonating */
    CONTACT_POINT_INITIATING_BASE_DETONATING (1920, "Contact, Point Initiating, Base Detonating"),
    /** Contact, Base Detonating */
    CONTACT_BASE_DETONATING (1930, "Contact, Base Detonating"),
    /** Contact, Ballistic Cap and Base */
    CONTACT_BALLISTIC_CAP_AND_BASE (1940, "Contact, Ballistic Cap and Base"),
    /** Contact, Base */
    CONTACT_BASE (1950, "Contact, Base"),
    /** Contact, Nose */
    CONTACT_NOSE (1960, "Contact, Nose"),
    /** Contact, Fitted in Standoff Probe */
    CONTACT_FITTED_IN_STANDOFF_PROBE (1970, "Contact, Fitted in Standoff Probe"),
    /** Contact, Non-aligned */
    CONTACT_NON_ALIGNED (1980, "Contact, Non-aligned"),
    /** Timed */
    TIMED (2000, "Timed"),
    /** Timed, Programmable */
    TIMED_PROGRAMMABLE (2100, "Timed, Programmable"),
    /** Timed, Burnout */
    TIMED_BURNOUT (2200, "Timed, Burnout"),
    /** Timed, Pyrotechnic */
    TIMED_PYROTECHNIC (2300, "Timed, Pyrotechnic"),
    /** Timed, Electronic */
    TIMED_ELECTRONIC (2400, "Timed, Electronic"),
    /** Timed, Base Delay */
    TIMED_BASE_DELAY (2500, "Timed, Base Delay"),
    /** Timed, Reinforced Nose Impact Delay */
    TIMED_REINFORCED_NOSE_IMPACT_DELAY (2600, "Timed, Reinforced Nose Impact Delay"),
    /** Timed, Short Delay Impact */
    TIMED_SHORT_DELAY_IMPACT (2700, "Timed, Short Delay Impact"),
    /** 10 ms Delay */
    $10_MS_DELAY_2 (2701, "10 ms Delay"),
    /** 20 ms Delay */
    $20_MS_DELAY_2 (2702, "20 ms Delay"),
    /** 50 ms Delay */
    $50_MS_DELAY_2 (2705, "50 ms Delay"),
    /** 60 ms Delay */
    $60_MS_DELAY_2 (2706, "60 ms Delay"),
    /** 100 ms Delay */
    $100_MS_DELAY_2 (2710, "100 ms Delay"),
    /** 125 ms Delay */
    $125_MS_DELAY_2 (2712, "125 ms Delay"),
    /** 250 ms Delay */
    $250_MS_DELAY_2 (2725, "250 ms Delay"),
    /** Timed, Nose Mounted Variable Delay */
    TIMED_NOSE_MOUNTED_VARIABLE_DELAY (2800, "Timed, Nose Mounted Variable Delay"),
    /** Timed, Long Delay Side */
    TIMED_LONG_DELAY_SIDE (2900, "Timed, Long Delay Side"),
    /** Timed, Selectable Delay */
    TIMED_SELECTABLE_DELAY (2910, "Timed, Selectable Delay"),
    /** Timed, Impact */
    TIMED_IMPACT (2920, "Timed, Impact"),
    /** Timed, Sequence */
    TIMED_SEQUENCE (2930, "Timed, Sequence"),
    /** Proximity */
    PROXIMITY (3000, "Proximity"),
    /** Proximity, Active Laser */
    PROXIMITY_ACTIVE_LASER (3100, "Proximity, Active Laser"),
    /** Proximity, Magnetic (Magpolarity) */
    PROXIMITY_MAGNETIC_MAGPOLARITY (3200, "Proximity, Magnetic (Magpolarity)"),
    /** Proximity, Active Radar (Doppler Radar) */
    PROXIMITY_ACTIVE_RADAR_DOPPLER_RADAR (3300, "Proximity, Active Radar (Doppler Radar)"),
    /** Proximity, Radio Frequency (RF) */
    PROXIMITY_RADIO_FREQUENCY_RF (3400, "Proximity, Radio Frequency (RF)"),
    /** Proximity, Programmable */
    PROXIMITY_PROGRAMMABLE (3500, "Proximity, Programmable"),
    /** Proximity, Programmable, Prefragmented */
    PROXIMITY_PROGRAMMABLE_PREFRAGMENTED (3600, "Proximity, Programmable, Prefragmented"),
    /** Proximity, Infrared */
    PROXIMITY_INFRARED (3700, "Proximity, Infrared"),
    /** Command */
    COMMAND (4000, "Command"),
    /** Command, Electronic, Remotely Set */
    COMMAND_ELECTRONIC_REMOTELY_SET (4100, "Command, Electronic, Remotely Set"),
    /** Altitude */
    ALTITUDE (5000, "Altitude"),
    /** Altitude, Radio Altimeter */
    ALTITUDE_RADIO_ALTIMETER (5100, "Altitude, Radio Altimeter"),
    /** Altitude, Air Burst */
    ALTITUDE_AIR_BURST (5200, "Altitude, Air Burst"),
    /** Depth */
    DEPTH (6000, "Depth"),
    /** Acoustic */
    ACOUSTIC (7000, "Acoustic"),
    /** Pressure */
    PRESSURE (8000, "Pressure"),
    /** Pressure, Delay */
    PRESSURE_DELAY (8010, "Pressure, Delay"),
    /** Inert */
    INERT (8100, "Inert"),
    /** Dummy */
    DUMMY (8110, "Dummy"),
    /** Practice */
    PRACTICE (8120, "Practice"),
    /** Plug Representing */
    PLUG_REPRESENTING (8130, "Plug Representing"),
    /** Training */
    TRAINING (8150, "Training"),
    /** Pyrotechnic */
    PYROTECHNIC (9000, "Pyrotechnic"),
    /** Pyrotechnic, Delay */
    PYROTECHNIC_DELAY (9010, "Pyrotechnic, Delay"),
    /** Electro-optical */
    ELECTRO_OPTICAL (9100, "Electro-optical"),
    /** Electromechanical */
    ELECTROMECHANICAL (9110, "Electromechanical"),
    /** Electromechanical, Nose */
    ELECTROMECHANICAL_NOSE (9120, "Electromechanical, Nose"),
    /** Strikerless */
    STRIKERLESS (9200, "Strikerless"),
    /** Strikerless, Nose Impact */
    STRIKERLESS_NOSE_IMPACT (9210, "Strikerless, Nose Impact"),
    /** Strikerless, Compression-Ignition */
    STRIKERLESS_COMPRESSION_IGNITION (9220, "Strikerless, Compression-Ignition"),
    /** Compression-Ignition */
    COMPRESSION_IGNITION (9300, "Compression-Ignition"),
    /** Compression-Ignition, Strikerless, Nose Impact */
    COMPRESSION_IGNITION_STRIKERLESS_NOSE_IMPACT (9310, "Compression-Ignition, Strikerless, Nose Impact"),
    /** Percussion */
    PERCUSSION (9400, "Percussion"),
    /** Percussion, Instantaneous */
    PERCUSSION_INSTANTANEOUS (9410, "Percussion, Instantaneous"),
    /** Electronic */
    ELECTRONIC (9500, "Electronic"),
    /** Electronic, Internally Mounted */
    ELECTRONIC_INTERNALLY_MOUNTED (9510, "Electronic, Internally Mounted"),
    /** Electronic, Range Setting */
    ELECTRONIC_RANGE_SETTING (9520, "Electronic, Range Setting"),
    /** Electronic, Programmed */
    ELECTRONIC_PROGRAMMED (9530, "Electronic, Programmed"),
    /** Mechanical */
    MECHANICAL (9600, "Mechanical"),
    /** Mechanical, Nose */
    MECHANICAL_NOSE (9610, "Mechanical, Nose"),
    /** Mechanical, Tail */
    MECHANICAL_TAIL (9620, "Mechanical, Tail");

    private int value;
    private final String description;

    MunitionDescriptorFuse(int value, String description)
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

    public static MunitionDescriptorFuse getEnumForValue(int i)
    {
       for(MunitionDescriptorFuse val: MunitionDescriptorFuse.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MunitionDescriptorFuse");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static MunitionDescriptorFuse unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static MunitionDescriptorFuse unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
