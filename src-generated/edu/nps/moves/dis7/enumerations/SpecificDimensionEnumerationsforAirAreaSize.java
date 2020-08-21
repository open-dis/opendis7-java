package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 132 marshal size 8<br>
 * SpecificDimensionEnumerationsforAirAreaSize<br>
 * The gaps in enumeration values are intentional and are reserved for future additions.
 */
public enum SpecificDimensionEnumerationsforAirAreaSize 
{

    /** Small Flock/Swarm (.5km long x 5m wide - 1km x 5m) */
    SMALL_FLOCK_SWARM_5KM_LONG_X_5M_WIDE_1KM_X_5M (222, "Small Flock/Swarm (.5km long x 5m wide - 1km x 5m)"),
    /** Small Flock/Swarm, Dense (.5km long x 5m wide - 1km x 5m) */
    SMALL_FLOCK_SWARM_DENSE_5KM_LONG_X_5M_WIDE_1KM_X_5M (223, "Small Flock/Swarm, Dense (.5km long x 5m wide - 1km x 5m)"),
    /** Medium Flock/Swarm (1km long x 10m wide - 2km x 10m) */
    MEDIUM_FLOCK_SWARM_1KM_LONG_X_10M_WIDE_2KM_X_10M (224, "Medium Flock/Swarm (1km long x 10m wide - 2km x 10m)"),
    /** Medium Flock/Swarm, Dense (1km long x 10m wide - 2km x 10m) */
    MEDIUM_FLOCK_SWARM_DENSE_1KM_LONG_X_10M_WIDE_2KM_X_10M (225, "Medium Flock/Swarm, Dense (1km long x 10m wide - 2km x 10m)"),
    /** Large Flock/Swarm (10km long x 100m wide - 20km x 100m) */
    LARGE_FLOCK_SWARM_10KM_LONG_X_100M_WIDE_20KM_X_100M (226, "Large Flock/Swarm (10km long x 100m wide - 20km x 100m)"),
    /** Large Flock/Swarm, Dense (10km long x 100m wide - 20km x 100m) */
    LARGE_FLOCK_SWARM_DENSE_10KM_LONG_X_100M_WIDE_20KM_X_100M (227, "Large Flock/Swarm, Dense (10km long x 100m wide - 20km x 100m)");

    private int value;
    private final String description;

    SpecificDimensionEnumerationsforAirAreaSize(int value, String description)
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

    public static SpecificDimensionEnumerationsforAirAreaSize getEnumForValue(int i)
    {
       for(SpecificDimensionEnumerationsforAirAreaSize val: SpecificDimensionEnumerationsforAirAreaSize.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SpecificDimensionEnumerationsforAirAreaSize");
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

    public static SpecificDimensionEnumerationsforAirAreaSize unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SpecificDimensionEnumerationsforAirAreaSize unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "SpecificDimensionEnumerationsforAirAreaSize: " + name() + ": " + getValue(); 
    }
}
