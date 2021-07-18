package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 413 marshal size 8<br>
 * SupplyFuelType<br>
 * Specific values for Supply Subcategory Fuels (1).
 */
public enum SupplyFuelType 
{

    /** Other */
    OTHER (0, "Other"),
    /** Gasoline */
    GASOLINE (1, "Gasoline"),
    /** Diesel Fuel (F-54/DF-2) */
    DIESEL_FUEL_F_54_DF_2 (2, "Diesel Fuel (F-54/DF-2)"),
    /** JP-4 (F-40/JET B) */
    JP_4_F_40_JET_B (3, "JP-4 (F-40/JET B)"),
    /** Fuel Oil */
    FUEL_OIL (4, "Fuel Oil"),
    /** JP-8 (F-34/JET A-1) */
    JP_8_F_34_JET_A_1 (5, "JP-8 (F-34/JET A-1)"),
    /** Fog Oil */
    FOG_OIL (6, "Fog Oil"),
    /** Multi-Spectral Fog Oil */
    MULTI_SPECTRAL_FOG_OIL (7, "Multi-Spectral Fog Oil"),
    /** JP-5 (F-44/JET A) */
    JP_5_F_44_JET_A (8, "JP-5 (F-44/JET A)"),
    /** JPTS */
    JPTS (9, "JPTS"),
    /** TS-1 (Russia (RUS)) */
    TS_1_RUSSIA_RUS (10, "TS-1 (Russia (RUS))");

    private int value;
    private final String description;

    /** Constructor */
    SupplyFuelType(int value, String description)
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
    public static SupplyFuelType getEnumForValue(int i)
    {
       for(SupplyFuelType val: SupplyFuelType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration SupplyFuelType");
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
    public static SupplyFuelType unmarshalEnum (DataInputStream dis) throws Exception
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
    public static SupplyFuelType unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "SupplyFuelType " + padding + getValue() + " " + name();
    }
}
