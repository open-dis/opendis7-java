package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 476 marshal size 8<br>
 * LifeFormCategoriesUS
 */
public enum LifeFormCategoriesUS 
{
    /** U.S. Army (USA) */
    US_ARMY_USA (11, "U.S. Army (USA)"),
    /** U.S. Marine Corps (USMC) */
    US_MARINE_CORPS_USMC (12, "U.S. Marine Corps (USMC)"),
    /** U.S. Air Force (USAF) */
    US_AIR_FORCE_USAF (13, "U.S. Air Force (USAF)"),
    /** U.S. Navy (USN) */
    US_NAVY_USN (14, "U.S. Navy (USN)"),
    /** U.S. Coast Guard (USCG) */
    US_COAST_GUARD_USCG (15, "U.S. Coast Guard (USCG)"),
    /** Rangers */
    RANGERS (31, "Rangers"),
    /** ARSOF */
    ARSOF (32, "ARSOF"),
    /** Force Reconnaissance */
    FORCE_RECONNAISSANCE (33, "Force Reconnaissance"),
    /** Navy SEAL */
    NAVY_SEAL (34, "Navy SEAL"),
    /** AFSOF */
    AFSOF (35, "AFSOF"),
    /** Delta Force */
    DELTA_FORCE (36, "Delta Force"),
    /** Federal Bureau of Investigation (FBI) */
    CREATE_ENTITY_RELIABLE (51, "Federal Bureau of Investigation (FBI)"),
    /** Central Intelligence Agency (CIA) */
    REMOVE_ENTITY_RELIABLE (52, "Central Intelligence Agency (CIA)"),
    /** Department of Homeland Security (DHS) */
    START_RESUME_RELIABLE (53, "Department of Homeland Security (DHS)"),
    /** Bureau of Alcohol, Tobacco, Firearms and Explosives (ATF) */
    STOP_FREEZE_RELIABLE (54, "Bureau of Alcohol, Tobacco, Firearms and Explosives (ATF)"),
    /** U.S. Secret Service (USSS) */
    ACKNOWLEDGE_RELIABLE (55, "U.S. Secret Service (USSS)"),
    /** U.S. Marshal */
    ACTION_REQUEST_RELIABLE (56, "U.S. Marshal"),
    /** State Police (Highway Patrol) */
    STATE_POLICE_HIGHWAY_PATROL (71, "State Police (Highway Patrol)"),
    /** County Sheriff/Police */
    COUNTY_SHERIFF_POLICE (72, "County Sheriff/Police"),
    /** Municipal Police */
    MUNICIPAL_POLICE (73, "Municipal Police"),
    /** Red Cross */
    RED_CROSS (124, "Red Cross");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormCategoriesUS(int value, String description)
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
    public static LifeFormCategoriesUS getEnumForValue(int i)
    {
       for(LifeFormCategoriesUS val: LifeFormCategoriesUS.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormCategoriesUS");
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
    public static LifeFormCategoriesUS unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormCategoriesUS unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "LifeFormCategoriesUS " + padding + getValue() + " " + name();
    }
}
