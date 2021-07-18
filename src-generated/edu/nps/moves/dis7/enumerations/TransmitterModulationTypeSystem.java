package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
 * UID 163 marshal size 16<br>
 * TransmitterModulationTypeSystem
 */
public enum TransmitterModulationTypeSystem 
{
    /** Other */
    OTHER (0, "Other"),
    /** Generic Radio or Simple Intercom */
    GENERIC_RADIO_OR_SIMPLE_INTERCOM (1, "Generic Radio or Simple Intercom"),
    /** HAVE QUICK */
    HAVE_QUICK (2, "HAVE QUICK"),
    /** HAVE QUICK II */
    HAVE_QUICK_II (3, "HAVE QUICK II"),
    /** HAVE QUICK IIA */
    HAVE_QUICK_IIA (4, "HAVE QUICK IIA"),
    /** SINCGARS */
    SINCGARS (5, "SINCGARS"),
    /** CCTT SINCGARS */
    CCTT_SINCGARS (6, "CCTT SINCGARS"),
    /** EPLRS (Enhanced Position Location Reporting System) */
    EPLRS_ENHANCED_POSITION_LOCATION_REPORTING_SYSTEM (7, "EPLRS (Enhanced Position Location Reporting System)"),
    /** JTIDS/MIDS, See SISO-STD-002, Standard for: Link 16 Simulations */
    JTIDS_MIDS (8, "JTIDS/MIDS"),
    /** Link 11, See SISO-STD-005 DRAFT, Standard for: Link 11/11B Simulation */
    LINK_11 (9, "Link 11"),
    /** Link 11B, See SISO-STD-005 DRAFT, Standard for: Link 11/11B Simulation */
    LINK_11B (10, "Link 11B"),
    /** L-Band SATCOM */
    L_BAND_SATCOM (11, "L-Band SATCOM"),
    /** Enhanced SINCGARS 7.3 */
    ENHANCED_SINCGARS_73 (12, "Enhanced SINCGARS 7.3"),
    /** Navigation Aid */
    NAVIGATION_AID (13, "Navigation Aid");

    private int value;
    private final String description;

    /** Constructor */
    TransmitterModulationTypeSystem(int value, String description)
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
      return 16;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static TransmitterModulationTypeSystem getEnumForValue(int i)
    {
       for(TransmitterModulationTypeSystem val: TransmitterModulationTypeSystem.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterModulationTypeSystem");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static TransmitterModulationTypeSystem unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static TransmitterModulationTypeSystem unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "TransmitterModulationTypeSystem " + getValue() + " " + name(); 
    }
}
