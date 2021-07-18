package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 473 marshal size 8<br>
 * LifeFormHumanSubcategoryEquipmentClass
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
    /** LifeFormHumanSpecificGrenadeLaunchers */    GRENADE_LAUNCHERS (30, "Grenade Launchers"),
    /** LifeFormHumanSpecificMachineGuns */    MACHINE_GUNS_2 (35, "Machine Guns"),
    /** LifeFormHumanSpecificGrenadeLaunchingMachineGun */    GRENADE_LAUNCHING_MACHINE_GUN_2 (40, "Grenade Launching Machine Gun"),
    /** LifeFormHumanSpecificAntiTankRockets */    ANTI_TANK_ROCKETS_2 (45, "Anti-Tank Rockets"),
    /** LifeFormHumanSpecificAntiTankMissiles */    ANTI_TANK_MISSILES (50, "Anti-Tank Missiles"),
    /** Anti-Tank Guns */
    ACKNOWLEDGE_RELIABLE (55, "Anti-Tank Guns"),
    /** LifeFormHumanSpecificFlameRockets */    FLAME_ROCKETS (60, "Flame Rockets"),
    /** LifeFormHumanSpecificFlameThrowers */    FLAME_THROWERS (65, "Flame Throwers"),
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
    /** LifeFormHumanSpecificLasersClass */    LASERS_2 (153, "Lasers"),
    /** Animal Companion, Subcategories 160-169 are restricted to animal companion classes. */
    ANIMAL_COMPANION (160, "Animal Companion"),
    /** LifeFormHumanSpecificPersonalElectronicsClass */    PERSONAL_ELECTRONICS_2 (171, "Personal Electronics"),
    /** LifeFormHumanSpecificLogisticsEQClass */    LOGISTICS_EQUIPMENT_2 (172, "Logistics Equipment");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSubcategoryEquipmentClass(int value, String description)
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
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static LifeFormHumanSubcategoryEquipmentClass getEnumForValue(int i)
    {
       for(LifeFormHumanSubcategoryEquipmentClass val: LifeFormHumanSubcategoryEquipmentClass.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSubcategoryEquipmentClass");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static LifeFormHumanSubcategoryEquipmentClass unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static LifeFormHumanSubcategoryEquipmentClass unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        String padding = new String();
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "LifeFormHumanSubcategoryEquipmentClass " + padding + getValue() + " " + name();
    }
}
