package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 163 marshal size 16<br>
 * Transmitter-Modulation Type System
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

    TransmitterModulationTypeSystem(int value, String description)
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
      return 16;
    }

    public static TransmitterModulationTypeSystem getEnumForValue(int i)
    {
       for(TransmitterModulationTypeSystem val: TransmitterModulationTypeSystem.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterModulationTypeSystem");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static TransmitterModulationTypeSystem unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static TransmitterModulationTypeSystem unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "TransmitterModulationTypeSystem: " + name() + ": " + getValue(); 
    }
}
