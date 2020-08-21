package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 609 marshal size 8<br>
 * Class9SupplyCategoryRepairPartsandComponents
 */
public enum Class9SupplyCategoryRepairPartsandComponents implements Category
{
    /** Other */
    OTHER (1, "Other"),
    /** A - Air */
    A_AIR (2, "A - Air"),
    /** B - Ground Support Materiel */
    B_GROUND_SUPPORT_MATERIEL (3, "B - Ground Support Materiel"),
    /** D - Admin Vehicles */
    D_ADMIN_VEHICLES (4, "D - Admin Vehicles"),
    /** G - Electronics */
    G_ELECTRONICS (5, "G - Electronics"),
    /** K - Tactical Vehicles, Any repair part for a modelled function of a platform, not related to Mobility, Firepower, Sensor, or Communications, e.g. Bulldozer Blade, Crane, Winch, Mine Plow, etc. */
    K_TACTICAL_VEHICLES (6, "K - Tactical Vehicles"),
    /** L - Missiles */
    L_MISSILES (7, "L - Missiles"),
    /** M - Weapons */
    M_WEAPONS (8, "M - Weapons"),
    /** N - Special Weapons */
    N_SPECIAL_WEAPONS (9, "N - Special Weapons"),
    /** X - Aircraft Engines */
    X_AIRCRAFT_ENGINES (10, "X - Aircraft Engines");

    private int value;
    private final String description;

    Class9SupplyCategoryRepairPartsandComponents(int value, String description)
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

    public static Class9SupplyCategoryRepairPartsandComponents getEnumForValue(int i)
    {
       for(Class9SupplyCategoryRepairPartsandComponents val: Class9SupplyCategoryRepairPartsandComponents.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Class9SupplyCategoryRepairPartsandComponents");
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

    public static Class9SupplyCategoryRepairPartsandComponents unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Class9SupplyCategoryRepairPartsandComponents unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Class9SupplyCategoryRepairPartsandComponents: " + name() + ": " + getValue(); 
    }
}
