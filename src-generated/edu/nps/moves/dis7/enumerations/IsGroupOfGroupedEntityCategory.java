package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 213 marshal size 8<br>
 * IsGroupOf-Grouped Entity Category
 */
public enum IsGroupOfGroupedEntityCategory implements Category
{
    /** Undefined */
    UNDEFINED (0, "Undefined"),
    /** Basic Ground Combat Vehicle */
    BASIC_GROUND_COMBAT_VEHICLE (1, "Basic Ground Combat Vehicle"),
    /** Enhanced Ground Combat Vehicle */
    ENHANCED_GROUND_COMBAT_VEHICLE (2, "Enhanced Ground Combat Vehicle"),
    /** Basic Ground Combat Soldier */
    BASIC_GROUND_COMBAT_SOLDIER (3, "Basic Ground Combat Soldier"),
    /** Enhanced Ground Combat Soldier */
    ENHANCED_GROUND_COMBAT_SOLDIER (4, "Enhanced Ground Combat Soldier"),
    /** Basic Rotor Wing Aircraft */
    BASIC_ROTOR_WING_AIRCRAFT (5, "Basic Rotor Wing Aircraft"),
    /** Enhanced Rotor Wing Aircraft */
    ENHANCED_ROTOR_WING_AIRCRAFT (6, "Enhanced Rotor Wing Aircraft"),
    /** Basic Fixed Wing Aircraft */
    BASIC_FIXED_WING_AIRCRAFT (7, "Basic Fixed Wing Aircraft"),
    /** Enhanced Fixed Wing Aircraft */
    ENHANCED_FIXED_WING_AIRCRAFT (8, "Enhanced Fixed Wing Aircraft"),
    /** Ground Logistics Vehicle */
    GROUND_LOGISTICS_VEHICLE (9, "Ground Logistics Vehicle");

    private int value;
    private final String description;

    IsGroupOfGroupedEntityCategory(int value, String description)
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

    public static IsGroupOfGroupedEntityCategory getEnumForValue(int i)
    {
       for(IsGroupOfGroupedEntityCategory val: IsGroupOfGroupedEntityCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IsGroupOfGroupedEntityCategory");
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

    public static IsGroupOfGroupedEntityCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static IsGroupOfGroupedEntityCategory unmarshalEnum(ByteBuffer buff) throws Exception
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
}
