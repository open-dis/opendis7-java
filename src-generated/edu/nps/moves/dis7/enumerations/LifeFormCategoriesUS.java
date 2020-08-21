package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 476 marshal size 8<br>
 * LifeFormCategoriesU.S.
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
    FEDERAL_BUREAU_OF_INVESTIGATION_FBI (51, "Federal Bureau of Investigation (FBI)"),
    /** Central Intelligence Agency (CIA) */
    CENTRAL_INTELLIGENCE_AGENCY_CIA (52, "Central Intelligence Agency (CIA)"),
    /** Department of Homeland Security (DHS) */
    DEPARTMENT_OF_HOMELAND_SECURITY_DHS (53, "Department of Homeland Security (DHS)"),
    /** Bureau of Alcohol, Tobacco, Firearms and Explosives (ATF) */
    BUREAU_OF_ALCOHOL_TOBACCO_FIREARMS_AND_EXPLOSIVES_ATF (54, "Bureau of Alcohol, Tobacco, Firearms and Explosives (ATF)"),
    /** U.S. Secret Service (USSS) */
    US_SECRET_SERVICE_USSS (55, "U.S. Secret Service (USSS)"),
    /** U.S. Marshal */
    US_MARSHAL (56, "U.S. Marshal"),
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

    LifeFormCategoriesUS(int value, String description)
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

    public static LifeFormCategoriesUS getEnumForValue(int i)
    {
       for(LifeFormCategoriesUS val: LifeFormCategoriesUS.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormCategoriesUS");
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

    public static LifeFormCategoriesUS unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormCategoriesUS: " + name() + ": " + getValue(); 
    }
}
