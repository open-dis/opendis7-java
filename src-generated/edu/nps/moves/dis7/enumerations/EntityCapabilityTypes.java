package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
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

    EntityCapabilityTypes(int value, String description)
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
      return 32;
    }

    public static EntityCapabilityTypes getEnumForValue(int i)
    {
       for(EntityCapabilityTypes val: EntityCapabilityTypes.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityCapabilityTypes");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeInt(getValue());
    }

    public void marshal(ByteBuffer byteBuffer)
    {
        byteBuffer.putInt(getValue());
    }

    public static EntityCapabilityTypes unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readInt());
    } 

    public static EntityCapabilityTypes unmarshalEnum (ByteBuffer byteBuffer)
    {
        return getEnumForValue(byteBuffer.getInt());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
