package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 607 marshal size 8<br>
 * Class 7 Supply Category - Major Items
 */
public enum Class7SupplyCategoryMajorItems implements Category
{
    /** Other */
    OTHER (1, "Other"),
    /** A - Air (Not used, as described in Air Domain) */
    A_AIR_NOT_USED_AS_DESCRIBED_IN_AIR_DOMAIN (2, "A - Air (Not used, as described in Air Domain)"),
    /** B - Ground Support Materiel */
    B_GROUND_SUPPORT_MATERIEL (3, "B - Ground Support Materiel"),
    /** D - Admin Vehicles (Not used, as described in Land Domain) */
    D_ADMIN_VEHICLES_NOT_USED_AS_DESCRIBED_IN_LAND_DOMAIN (4, "D - Admin Vehicles (Not used, as described in Land Domain)"),
    /** G - Electronics */
    G_ELECTRONICS (5, "G - Electronics"),
    /** J - Racks, Adaptors, Pylons */
    J_RACKS_ADAPTORS_PYLONS (6, "J - Racks, Adaptors, Pylons"),
    /** K - Tactical Vehicles (Not used, as described in Land Domain) */
    K_TACTICAL_VEHICLES_NOT_USED_AS_DESCRIBED_IN_LAND_DOMAIN (7, "K - Tactical Vehicles (Not used, as described in Land Domain)"),
    /** L - Missiles (Not used, as described in Munition Domain) */
    L_MISSILES_NOT_USED_AS_DESCRIBED_IN_MUNITION_DOMAIN (8, "L - Missiles (Not used, as described in Munition Domain)"),
    /** M - Weapons */
    M_WEAPONS (9, "M - Weapons"),
    /** N - Special Weapons */
    N_SPECIAL_WEAPONS (10, "N - Special Weapons"),
    /** X - Aircraft Engines */
    X_AIRCRAFT_ENGINES (11, "X - Aircraft Engines"),
    /** Drop Tank */
    DROP_TANK (20, "Drop Tank"),
    /** Conformal Fuel Tank */
    CONFORMAL_FUEL_TANK (21, "Conformal Fuel Tank"),
    /** Luggage Pod */
    LUGGAGE_POD (22, "Luggage Pod"),
    /** ECM Pod */
    ECM_POD (23, "ECM Pod"),
    /** Para-Drogue */
    PARA_DROGUE (24, "Para-Drogue"),
    /** Targeting Pod */
    TARGETING_POD (25, "Targeting Pod"),
    /** Fairing */
    FAIRING (26, "Fairing"),
    /** Air Refuelling Pod */
    AIR_REFUELLING_POD (27, "Air Refuelling Pod"),
    /** Heavy Airdrop */
    HEAVY_AIRDROP (28, "Heavy Airdrop"),
    /** Container Delivery System (CDS) Airdrop */
    CONTAINER_DELIVERY_SYSTEM_CDS_AIRDROP (29, "Container Delivery System (CDS) Airdrop"),
    /** Rocket Pod/Launcher */
    ROCKET_POD_LAUNCHER (30, "Rocket Pod/Launcher"),
    /** Tactical Pod */
    TACTICAL_POD (31, "Tactical Pod");

    private int value;
    private final String description;

    Class7SupplyCategoryMajorItems(int value, String description)
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

    public static Class7SupplyCategoryMajorItems getEnumForValue(int i)
    {
       for(Class7SupplyCategoryMajorItems val: Class7SupplyCategoryMajorItems.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Class7SupplyCategoryMajorItems");
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

    public static Class7SupplyCategoryMajorItems unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static Class7SupplyCategoryMajorItems unmarshalEnum(ByteBuffer buff) throws Exception
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
