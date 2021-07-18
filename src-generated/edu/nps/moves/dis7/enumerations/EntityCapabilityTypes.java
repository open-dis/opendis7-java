package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 55 marshal size 32<br>
 * EntityCapabilities
 */
public enum EntityCapabilityTypes 
{
    /** LandPlatformCapabilities */    LAND_PLATFORM_ENTITY_CAPABILITIES_2 (0, "Land Platform Entity Capabilities"),
    /** AirPlatformCapabilities */    AIR_PLATFORM_ENTITY_CAPABILITIES_2 (1, "Air Platform Entity Capabilities"),
    /** SurfacePlatformCapabilities */    SURFACE_PLATFORM_ENTITY_CAPABILITIES_2 (2, "Surface Platform Entity Capabilities"),
    /** SubsurfacePlatformCapabilities */    SUBSURFACE_PLATFORM_ENTITY_CAPABILITIES_2 (3, "Subsurface Platform Entity Capabilities"),
    /** SpacePlatformCapabilities */    SPACE_PLATFORM_ENTITY_CAPABILITIES_2 (4, "Space Platform Entity Capabilities"),
    /** MunitionCapabilities */    MUNITION_ENTITY_CAPABILITIES_2 (5, "Munition Entity Capabilities"),
    /** LifeFormsCapabilities */    LIFE_FORMS_ENTITY_CAPABILITIES_2 (6, "Life Forms Entity Capabilities"),
    /** EnvironmentalCapabilities */    ENVIRONMENTAL_ENTITY_CAPABILITIES_2 (7, "Environmental Entity Capabilities"),
    /** CulturalFeatureCapabilities */    CULTURAL_FEATURE_ENTITY_CAPABILITIES_2 (8, "Cultural Feature Entity Capabilities"),
    /** SupplyCapabilities */    SUPPLY_ENTITY_CAPABILITIES_2 (9, "Supply Entity Capabilities"),
    /** RadioCapabilities */    RADIO_ENTITY_CAPABILITIES_2 (10, "Radio Entity Capabilities"),
    /** ExpendableCapabilities */    EXPENDABLE_ENTITY_CAPABILITIES_2 (11, "Expendable Entity Capabilities"),
    /** SensorEmitterCapabilities */    SENSOR_EMITTER_ENTITY_CAPABILITIES_2 (12, "Sensor/Emitter Entity Capabilities");

    private int value;
    private final String description;

    /** Constructor */
    EntityCapabilityTypes(int value, String description)
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
      return 32;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static EntityCapabilityTypes getEnumForValue(int i)
    {
       for(EntityCapabilityTypes val: EntityCapabilityTypes.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration EntityCapabilityTypes");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output */
    public void marshal(ByteBuffer byteBuffer)
    {
        byteBuffer.putInt(getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static EntityCapabilityTypes unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @return enumeration of interest */
    public static EntityCapabilityTypes unmarshalEnum (ByteBuffer byteBuffer)
    {
        return getEnumForValue(byteBuffer.getInt());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 4; // 32 bits
    }
    
    @Override
    public String toString()
    {
        return "EntityCapabilityTypes: " + getValue() + " " + name();
    }
}
