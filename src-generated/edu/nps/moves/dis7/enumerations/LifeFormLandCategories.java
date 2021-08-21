package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 472 marshal size 8<br>
 * LifeFormLandCategories
 */
public enum LifeFormLandCategories implements Category
{
    /** Conventional Armed Forces, Values from 10-29 are restricted to Conventional Armed Forces and may be further clarified by country code-specific values. */
    CONVENTIONAL_ARMED_FORCES (10, "Conventional Armed Forces"),
    /** Army */
    ARMY (11, "Army"),
    /** Naval Infantry (Marines) */
    NAVAL_INFANTRY_MARINES (12, "Naval Infantry (Marines)"),
    /** Air Force */
    AIR_FORCE (13, "Air Force"),
    /** Navy */
    NAVY (14, "Navy"),
    /** Coast Guard */
    COAST_GUARD (15, "Coast Guard"),
    /** United Nations */
    UNITED_NATIONS (16, "United Nations"),
    /** Special Operations Forces (SOF), Values from 30-49 are restricted to Special Operations Forces and may be further clarified by country code-specific values. */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Special Operations Forces (SOF)"),
    /** Law Enforcement, Values from 50-69 are restricted to Law Enforcement and may be further clarified by country code-specific values. */
    LIVE_ENTITY_DETONATION (50, "Law Enforcement"),
    /** Non-Military National Government Agencies, Values from 70-89 are restricted to Non-Military National Government Agencies and may be further clarified by country code-specific values. */
    NON_MILITARY_NATIONAL_GOVERNMENT_AGENCIES (70, "Non-Military National Government Agencies"),
    /** Regional / Local Forces, Values from 90-99 are restricted to Regional / Local Forces (e.g., state guard) and may be further clarified by country code-specific values. */
    REGIONAL_LOCAL_FORCES (90, "Regional / Local Forces"),
    /** Irregular Forces, Values from 100-109 are restricted to Irregular Forces and may be further clarified by country code-specific values. */
    IRREGULAR_FORCES (100, "Irregular Forces"),
    /** Terrorist Combatant */
    TERRORIST_COMBATANT (101, "Terrorist Combatant"),
    /** Insurgent */
    INSURGENT (102, "Insurgent"),
    /** Paramilitary Forces, Values from 110-119 are restricted to Paramilitary Forces and may be further clarified by country code-specific values. */
    PARAMILITARY_FORCES (110, "Paramilitary Forces"),
    /** Humanitarian Organizations, Values from 120-129 are restricted to non-governmental Humanitarian Organizations and may be further clarified by country code-specific values. */
    HUMANITARIAN_ORGANIZATIONS (120, "Humanitarian Organizations"),
    /** Civilian, Values from 130-159 are restricted to Civilians and may be further clarified by country code-specific values. */
    CIVILIAN (130, "Civilian"),
    /** Emergency Medical Technician (EMT) */
    EMERGENCY_MEDICAL_TECHNICIAN_EMT (131, "Emergency Medical Technician (EMT)"),
    /** Firefighter */
    FIREFIGHTER (132, "Firefighter"),
    /** Press */
    PRESS (133, "Press"),
    /** SubcategoriesforLandCategory200Mammal */    MAMMAL_2 (200, "Mammal"),
    /** SubcategoriesforLandCategory201Reptile */    REPTILE_2 (201, "Reptile"),
    /** SubcategoriesforLandCategory202Amphibian */    AMPHIBIAN_2 (202, "Amphibian"),
    /** SubcategoriesforLandCategory203Insect */    INSECT_2 (203, "Insect"),
    /** SubcategoriesforLandCategory204Arachnid */    ARACHNID_2 (204, "Arachnid"),
    /** SubcategoriesforLandCategory205Mollusk */    MOLLUSK_2 (205, "Mollusk"),
    /** SubcategoriesforLandCategory206Marsupial */    MARSUPIAL_2 (206, "Marsupial");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormLandCategories(int value, String description)
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
    public static LifeFormLandCategories getEnumForValue(int i)
    {
       for(LifeFormLandCategories val: LifeFormLandCategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormLandCategories");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    private boolean TRACE = false;

    /** Set tracing on/off for this object 
     * @param value whether tracing is on or off */
    public void setTRACE (boolean value)
    {
        TRACE = value;
    }

    /** Whether tracing is on or off for this object
     * @return whether tracing is on or off */
    public boolean getTRACE ()
    {
        return TRACE;
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
    public static LifeFormLandCategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static LifeFormLandCategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        if (this.getClass().getName().endsWith("DisPduType") && (getValue() < 10))
            padding = "0"; // leading zero for column spacing
        String result = "DisPduType " + padding + getValue() + " " + name();
        if (getTRACE())
            System.out.println ("*** enum " + this.getClass().getName() + " name=" + name() + ", value=" + getValue() + "; " +
               result); // debug diagnostic
        return result;
    }
}
