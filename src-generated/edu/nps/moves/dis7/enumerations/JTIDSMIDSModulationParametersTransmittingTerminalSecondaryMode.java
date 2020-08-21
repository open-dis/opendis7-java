package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 174 marshal size 8<br>
 * JTIDS/MIDSModulationParametersTransmittingTerminalSecondaryMode
 */
public enum JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode 
{
    /** None */
    NONE (0, "None"),
    /** Net Position Reference */
    NET_POSITION_REFERENCE (1, "Net Position Reference"),
    /** Primary Navigation Controller */
    PRIMARY_NAVIGATION_CONTROLLER (2, "Primary Navigation Controller"),
    /** Secondary Navigation Controller */
    SECONDARY_NAVIGATION_CONTROLLER (3, "Secondary Navigation Controller");

    private int value;
    private final String description;

    JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode(int value, String description)
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

    public static JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode getEnumForValue(int i)
    {
       for(JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode val: JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode");
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

    public static JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "JTIDSMIDSModulationParametersTransmittingTerminalSecondaryMode: " + name() + ": " + getValue(); 
    }
}
