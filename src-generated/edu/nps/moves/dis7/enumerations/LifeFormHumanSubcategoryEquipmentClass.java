package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 473 marshal size 8<br>
 * Life Form-Human-Subcategory-Equipment Class
 */
public enum LifeFormHumanSubcategoryEquipmentClass 
{
    /** None */
    NONE (0, "None"),
    /** LifeFormHumanSpecificWeaponNonspecific */    WEAPON_NON_SPECIFIC_2 (1, "Weapon, Non-specific"),
    /** LifeFormHumanSpecificAssaultRifles */    ASSAULT_RIFLES_2 (5, "Assault Rifles"),
    /** LifeFormHumanSpecificHighPowerRifles */    HIGH_POWER_RIFLES_2 (10, "High Power Rifles"),
    /** LifeFormHumanSpecificSniper */    SNIPER_RIFLES_2 (15, "Sniper Rifles"),
    /** LifeFormHumanSpecificAntiMaterielRifles */    ANTI_MATERIEL_RIFLE_AMR_2 (17, "Anti-Materiel Rifle (AMR)"),
    /** LifeFormHumanSpecificSubMachineGun */    SUB_MACHINE_GUNS_2 (20, "Sub Machine Guns"),
    /** LifeFormHumanSpecificShotGuns */    SHOT_GUNS_2 (25, "Shot Guns"),
    /** LifeFormHumanSpecificGrenadeLaunchers */    GRENADE_LAUNCHERS_2 (30, "Grenade Launchers"),
    /** LifeFormHumanSpecificMachineGuns */    MACHINE_GUNS_2 (35, "Machine Guns"),
    /** LifeFormHumanSpecificGrenadeLaunchingMachineGun */    GRENADE_LAUNCHING_MACHINE_GUN_2 (40, "Grenade Launching Machine Gun"),
    /** LifeFormHumanSpecificAntiTankRockets */    ANTI_TANK_ROCKETS_2 (45, "Anti-Tank Rockets"),
    /** LifeFormHumanSpecificAntiTankMissiles */    ANTI_TANK_MISSILES_2 (50, "Anti-Tank Missiles"),
    /** Anti-Tank Guns */
    ANTI_TANK_GUNS (55, "Anti-Tank Guns"),
    /** LifeFormHumanSpecificFlameRockets */    FLAME_ROCKETS_2 (60, "Flame Rockets"),
    /** LifeFormHumanSpecificFlameThrowers */    FLAME_THROWERS_2 (65, "Flame Throwers"),
    /** Rocket Launchers */
    ROCKET_LAUNCHERS (70, "Rocket Launchers"),
    /** LifeFormHumanSpecificMortars */    MORTARS_2 (75, "Mortars"),
    /** LifeFormHumanSpecificHandGuns */    HAND_GUNS_2 (80, "Hand Guns"),
    /** LifeFormHumanSpecificManPortableAirDefenseSystem */    MAN_PORTABLE_AIR_DEFENSE_SYSTEM_MANPADS_2 (85, "Man-Portable Air Defense System (MANPADS)"),
    /** LifeFormHumanSpecificRecoillessRifles */    RECOILLESS_RIFLES_2 (90, "Recoilless Rifles"),
    /** LifeFormHumanSpecificDroneGuns */    DRONE_GUNS_2 (95, "Drone Guns"),
    /** Equipment, Non-specific, Subcategories 150-199 are restricted to non-weapon equipment classes. */
    EQUIPMENT_NON_SPECIFIC (150, "Equipment, Non-specific"),
    /** Sensors, Subcategories 151-159 are restricted to sensor equipment classes. */
    SENSORS (151, "Sensors"),
    /** LifeFormHumanSpecificEquipmentClass */    SIGNAL_SENSOR_2 (152, "Signal Sensor"),
    /** Animal Companion, Subcategories 160-169 are restricted to animal companion classes. */
    ANIMAL_COMPANION (160, "Animal Companion");

    private int value;
    private final String description;

    LifeFormHumanSubcategoryEquipmentClass(int value, String description)
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

    public static LifeFormHumanSubcategoryEquipmentClass getEnumForValue(int i)
    {
       for(LifeFormHumanSubcategoryEquipmentClass val: LifeFormHumanSubcategoryEquipmentClass.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSubcategoryEquipmentClass");
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

    public static LifeFormHumanSubcategoryEquipmentClass unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static LifeFormHumanSubcategoryEquipmentClass unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormHumanSubcategoryEquipmentClass: " + name() + ": " + getValue(); 
    }
}
