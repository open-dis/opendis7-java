package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 278 marshal size 8<br>
 * PlatformAirCivilianHelicopterSubcategories<br>
 * Subcategories for Air Platform Categories 90-92. Subcategory values have the number of rotors in the 10s digit and the rotor configuration in the 1s digit.
 */
public enum PlatformAirCivilianHelicopterSubcategories implements SubCategory
{

    /** Single Rotor, Piston Engine */
    SINGLE_ROTOR_PISTON_ENGINE (11, "Single Rotor, Piston Engine"),
    /** Single Rotor, Turboshaft Engine, Conventional Tail Rotor */
    SINGLE_ROTOR_TURBOSHAFT_ENGINE_CONVENTIONAL_TAIL_ROTOR (12, "Single Rotor, Turboshaft Engine, Conventional Tail Rotor"),
    /** Single Rotor, Turboshaft Engine, Shrouded Tail Rotor */
    SINGLE_ROTOR_TURBOSHAFT_ENGINE_SHROUDED_TAIL_ROTOR (13, "Single Rotor, Turboshaft Engine, Shrouded Tail Rotor"),
    /** Single Rotor, Turboshaft Engine, No Tail Rotor */
    SINGLE_ROTOR_TURBOSHAFT_ENGINE_NO_TAIL_ROTOR (14, "Single Rotor, Turboshaft Engine, No Tail Rotor"),
    /** Tandem Rotor */
    TANDEM_ROTOR (21, "Tandem Rotor"),
    /** Coaxial Rotor */
    COAXIAL_ROTOR (22, "Coaxial Rotor"),
    /** Intermeshing Rotor */
    INTERMESHING_ROTOR (23, "Intermeshing Rotor");

    private int value;
    private final String description;

    /** Constructor */
    PlatformAirCivilianHelicopterSubcategories(int value, String description)
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
    public static PlatformAirCivilianHelicopterSubcategories getEnumForValue(int i)
    {
       for(PlatformAirCivilianHelicopterSubcategories val: PlatformAirCivilianHelicopterSubcategories.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration PlatformAirCivilianHelicopterSubcategories");
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
    public static PlatformAirCivilianHelicopterSubcategories unmarshalEnum (DataInputStream dis) throws Exception
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
    public static PlatformAirCivilianHelicopterSubcategories unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "PlatformAirCivilianHelicopterSubcategories " + padding + getValue() + " " + name();
    }
}
