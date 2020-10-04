package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 501 marshal size 8<br>
 * LifeFormCategoriesAfghanistan
 */
public enum LifeFormCategoriesAfghanistan 
{
    /** Afghan National Army (ANA) */
    AFGHAN_NATIONAL_ARMY_ANA (11, "Afghan National Army (ANA)"),
    /** Afghan Air Force (AAF) */
    AFGHAN_AIR_FORCE_AAF (13, "Afghan Air Force (AAF)"),
    /** National Directorate of Security (NDS) */
    NATIONAL_DIRECTORATE_OF_SECURITY_NDS (51, "National Directorate of Security (NDS)"),
    /** Afghan National Police (ANP) */
    AFGHAN_NATIONAL_POLICE_ANP (52, "Afghan National Police (ANP)"),
    /** Afghan Border Police (ABP) */
    AFGHAN_BORDER_POLICE_ABP (53, "Afghan Border Police (ABP)"),
    /** Afghan National Civil Order Police (ANCOP) */
    AFGHAN_NATIONAL_CIVIL_ORDER_POLICE_ANCOP (54, "Afghan National Civil Order Police (ANCOP)"),
    /** Afghan Public Protection Force (APPF) */
    AFGHAN_PUBLIC_PROTECTION_FORCE_APPF (55, "Afghan Public Protection Force (APPF)"),
    /** Non-Military National Government Agencies */
    NON_MILITARY_NATIONAL_GOVERNMENT_AGENCIES (70, "Non-Military National Government Agencies"),
    /** Terrorist Combatant */
    TERRORIST_COMBATANT (101, "Terrorist Combatant"),
    /** Humanitarian Organizations */
    HUMANITARIAN_ORGANIZATIONS (120, "Humanitarian Organizations"),
    /** Red Crescent */
    RED_CRESCENT (121, "Red Crescent"),
    /** Civilian */
    CIVILIAN (130, "Civilian"),
    /** Press */
    PRESS (133, "Press");

    private int value;
    private final String description;

    LifeFormCategoriesAfghanistan(int value, String description)
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

    public static LifeFormCategoriesAfghanistan getEnumForValue(int i)
    {
       for(LifeFormCategoriesAfghanistan val: LifeFormCategoriesAfghanistan.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormCategoriesAfghanistan");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    public static LifeFormCategoriesAfghanistan unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormCategoriesAfghanistan unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        return "LifeFormCategoriesAfghanistan " + getValue() + " " + name(); 
    }
}
