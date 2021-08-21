package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 607 marshal size 8<br>
 * Class7SupplyCategoryMajorItems
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
    IDENTIFICATION_FRIEND_OR_FOE (28, "Heavy Airdrop"),
    /** Container Delivery System (CDS) Airdrop */
    CONTAINER_DELIVERY_SYSTEM_CDS_AIRDROP (29, "Container Delivery System (CDS) Airdrop"),
    /** Rocket Pod/Launcher */
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "Rocket Pod/Launcher"),
    /** Tactical Pod */
    TACTICAL_POD (31, "Tactical Pod");

    private int value;
    private final String description;

    /** Constructor */
    Class7SupplyCategoryMajorItems(int value, String description)
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
    public static Class7SupplyCategoryMajorItems getEnumForValue(int i)
    {
       for(Class7SupplyCategoryMajorItems val: Class7SupplyCategoryMajorItems.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration Class7SupplyCategoryMajorItems");
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
    public static Class7SupplyCategoryMajorItems unmarshalEnum (DataInputStream dis) throws Exception
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
    public static Class7SupplyCategoryMajorItems unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
