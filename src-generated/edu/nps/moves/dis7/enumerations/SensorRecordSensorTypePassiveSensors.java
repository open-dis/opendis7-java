package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 326 marshal size 16<br>
 * SensorRecordSensorTypePassiveSensors
 */
public enum SensorRecordSensorTypePassiveSensors 
{
    /** ALR-400 */
    ALR_400 (60000, "ALR-400"),
    /** AN/AAR-47 */
    AN_AAR_47 (60001, "AN/AAR-47"),
    /** AN/AAR-50 */
    AN_AAR_50 (60002, "AN/AAR-50"),
    /** AN/AAR-54 */
    AN_AAR_54 (60003, "AN/AAR-54"),
    /** AN/AAR-56 */
    AN_AAR_56 (60004, "AN/AAR-56"),
    /** AN/AAR-57 */
    AN_AAR_57 (60005, "AN/AAR-57"),
    /** AN/ALQ-142 */
    AN_ALQ_142 (60006, "AN/ALQ-142"),
    /** AN/ALR-45 */
    AN_ALR_45 (60007, "AN/ALR-45"),
    /** AN/ALR-46 */
    AN_ALR_46 (60008, "AN/ALR-46"),
    /** AN/ALR-56 */
    AN_ALR_56 (60009, "AN/ALR-56"),
    /** AN/ALR-59 */
    AN_ALR_59 (60010, "AN/ALR-59"),
    /** AN/ALR-64 */
    AN_ALR_64 (60011, "AN/ALR-64"),
    /** AN/ALR-66 */
    AN_ALR_66 (60012, "AN/ALR-66"),
    /** AN/ALR-67 */
    AN_ALR_67 (60013, "AN/ALR-67"),
    /** AN/ALR-69 */
    AN_ALR_69 (60014, "AN/ALR-69"),
    /** AN/ALR-73 */
    AN_ALR_73 (60015, "AN/ALR-73"),
    /** AN/ALR-76 */
    AN_ALR_76 (60016, "AN/ALR-76"),
    /** AN/ALR-91 */
    AN_ALR_91 (60017, "AN/ALR-91"),
    /** AN/ALR-93 */
    AN_ALR_93 (60018, "AN/ALR-93"),
    /** AN/ALR-94 */
    AN_ALR_94 (60019, "AN/ALR-94"),
    /** AN/ALR-801 */
    AN_ALR_801 (60020, "AN/ALR-801"),
    /** AN/APR-39 */
    AN_APR_39 (60021, "AN/APR-39"),
    /** AN/AYR-2 */
    AN_AYR_2 (60022, "AN/AYR-2"),
    /** ARI 18223 */
    ARI_18223 (60023, "ARI 18223"),
    /** BOW-21 */
    BOW_21 (60024, "BOW-21"),
    /** Chaparral IRST */
    CHAPARRAL_IRST (60025, "Chaparral IRST"),
    /** NATOID_Flanker IRST */
    NATOID_FLANKER_IRST (60026, "NATOID_Flanker IRST"),
    /** NATOID_Foxbat IRST */
    NATOID_FOXBAT_IRST (60027, "NATOID_Foxbat IRST"),
    /** NATOID_Foxhound IRST */
    NATOID_FOXHOUND_IRST (60028, "NATOID_Foxhound IRST"),
    /** NATOID_Fulcrum IRST */
    NATOID_FULCRUM_IRST (60029, "NATOID_Fulcrum IRST"),
    /** NATOID_Havoc IRST */
    NATOID_HAVOC_IRST (60030, "NATOID_Havoc IRST"),
    /** NATOID_Hind IRST */
    NATOID_HIND_IRST (60031, "NATOID_Hind IRST"),
    /** KJ-200 */
    KJ_200 (60032, "KJ-200"),
    /** KJ-8602 */
    KJ_8602 (60033, "KJ-8602"),
    /** L-150 Pastel */
    L_150_PASTEL (60034, "L-150 Pastel"),
    /** Serval */
    SERVAL (60035, "Serval"),
    /** Sherloc */
    SHERLOC (60036, "Sherloc"),
    /** Sherlocvf */
    SHERLOCVF (60037, "Sherlocvf"),
    /** Sirena-2 */
    SIRENA_2 (60038, "Sirena-2"),
    /** Sirena-3 */
    SIRENA_3 (60039, "Sirena-3"),
    /** Sirena-3M */
    SIRENA_3M (60040, "Sirena-3M"),
    /** Sky Guardian */
    SKY_GUARDIAN (60041, "Sky Guardian"),
    /** SPO-15 */
    SPO_15 (60042, "SPO-15"),
    /** SPS-200 */
    SPS_200 (60043, "SPS-200"),
    /** Tarang */
    TARANG (60044, "Tarang");

    private int value;
    private final String description;

    /** Constructor */
    SensorRecordSensorTypePassiveSensors(int value, String description)
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
    public static SensorRecordSensorTypePassiveSensors getEnumForValue(int i)
    {
       for(SensorRecordSensorTypePassiveSensors val: SensorRecordSensorTypePassiveSensors.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration SensorRecordSensorTypePassiveSensors");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static SensorRecordSensorTypePassiveSensors unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static SensorRecordSensorTypePassiveSensors unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        return "SensorRecordSensorTypePassiveSensors " + getValue() + " " + name(); 
    }
}
