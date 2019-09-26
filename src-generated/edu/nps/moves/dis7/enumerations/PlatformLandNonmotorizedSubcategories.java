package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 438 marshal size 8<br>
 * Platform-Land-Non-motorized Subcategories<br>
 * Subcategories for Land Platform Category 91
 */
public enum PlatformLandNonmotorizedSubcategories 
{

    /** Other */
    OTHER (0, "Other"),
    /** Unicycle */
    UNICYCLE (1, "Unicycle"),
    /** Bicycle */
    BICYCLE (2, "Bicycle"),
    /** Bicycle, Mountain */
    BICYCLE_MOUNTAIN (3, "Bicycle, Mountain"),
    /** Bicycle, Racing */
    BICYCLE_RACING (4, "Bicycle, Racing"),
    /** Tricycle */
    TRICYCLE (5, "Tricycle"),
    /** Quadricycle */
    QUADRICYCLE (6, "Quadricycle"),
    /** Rickshaw, Two Person */
    RICKSHAW_TWO_PERSON (7, "Rickshaw, Two Person"),
    /** Rickshaw, One Person */
    RICKSHAW_ONE_PERSON (8, "Rickshaw, One Person"),
    /** Tandem Bicycle */
    TANDEM_BICYCLE (9, "Tandem Bicycle"),
    /** Cycle Trailer */
    CYCLE_TRAILER (10, "Cycle Trailer"),
    /** Cycle Sidecar */
    CYCLE_SIDECAR (11, "Cycle Sidecar"),
    /** Sled */
    SLED (12, "Sled"),
    /** Skis */
    SKIS (13, "Skis"),
    /** Snowboard */
    SNOWBOARD (14, "Snowboard"),
    /** Skateboard */
    SKATEBOARD (15, "Skateboard"),
    /** Skates */
    SKATES (16, "Skates"),
    /** Skates, In-Line */
    SKATES_IN_LINE (17, "Skates, In-Line"),
    /** Wagon Cart */
    WAGON_CART (18, "Wagon Cart"),
    /** Dolly */
    DOLLY (19, "Dolly"),
    /** Handtruck */
    HANDTRUCK (20, "Handtruck"),
    /** Push Cart */
    PUSH_CART (21, "Push Cart"),
    /** Wheelbarrow */
    WHEELBARROW (22, "Wheelbarrow"),
    /** Kick Scooter */
    KICK_SCOOTER (23, "Kick Scooter"),
    /** Wheelchair */
    WHEELCHAIR (24, "Wheelchair");

    private int value;
    private final String description;

    PlatformLandNonmotorizedSubcategories(int value, String description)
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

    public static PlatformLandNonmotorizedSubcategories getEnumForValue(int i)
    {
       for(PlatformLandNonmotorizedSubcategories val: PlatformLandNonmotorizedSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformLandNonmotorizedSubcategories");
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

    public static PlatformLandNonmotorizedSubcategories unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static PlatformLandNonmotorizedSubcategories unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PlatformLandNonmotorizedSubcategories: " + name() + ": " + getValue(); 
    }
}
