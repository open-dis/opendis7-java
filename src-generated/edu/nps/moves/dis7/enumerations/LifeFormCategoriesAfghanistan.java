package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
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
    CREATE_ENTITY_RELIABLE (51, "National Directorate of Security (NDS)"),
    /** Afghan National Police (ANP) */
    REMOVE_ENTITY_RELIABLE (52, "Afghan National Police (ANP)"),
    /** Afghan Border Police (ABP) */
    START_RESUME_RELIABLE (53, "Afghan Border Police (ABP)"),
    /** Afghan National Civil Order Police (ANCOP) */
    STOP_FREEZE_RELIABLE (54, "Afghan National Civil Order Police (ANCOP)"),
    /** Afghan Public Protection Force (APPF) */
    ACKNOWLEDGE_RELIABLE (55, "Afghan Public Protection Force (APPF)"),
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

    /** Constructor */
    LifeFormCategoriesAfghanistan(int value, String description)
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
    public static LifeFormCategoriesAfghanistan getEnumForValue(int i)
    {
       for(LifeFormCategoriesAfghanistan val: LifeFormCategoriesAfghanistan.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormCategoriesAfghanistan");
       return null;
    }

    /** Marshal value to DataOutputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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
        String padding = new String();
        if (name().equalsIgnoreCase("DISPDUType") && getValue() < 10)
            padding = "0"; // leading zero for column spacing
        return "LifeFormCategoriesAfghanistan " + padding + getValue() + " " + name();
    }
}
