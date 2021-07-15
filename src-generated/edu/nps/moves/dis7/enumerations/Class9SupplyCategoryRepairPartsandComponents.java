package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
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

    /** Constructor */
    Class9SupplyCategoryRepairPartsandComponents(int value, String description)
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
    public static Class9SupplyCategoryRepairPartsandComponents getEnumForValue(int i)
    {
       for(Class9SupplyCategoryRepairPartsandComponents val: Class9SupplyCategoryRepairPartsandComponents.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Class9SupplyCategoryRepairPartsandComponents");
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

    /** Unmarshal enumeration value to ByteBuffer
     * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static Class9SupplyCategoryRepairPartsandComponents unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "Class9SupplyCategoryRepairPartsandComponents " + padding + getValue() + " " + name();
    }
}
