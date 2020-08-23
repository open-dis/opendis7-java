package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 173 marshal size 8<br>
 * ___________________________________________________________________
 */
public enum JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode 
{
    /** NTR */
    NTR (1, "NTR"),
    /** JTIDS Unit Participant */
    JTIDS_UNIT_PARTICIPANT (2, "JTIDS Unit Participant");

    private int value;
    private final String description;

    JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode(int value, String description)
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

    public static JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode getEnumForValue(int i)
    {
       for(JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode val: JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode");
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

    public static JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode unmarshalEnum(ByteBuffer buff) throws Exception
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

    /** Returns the size of this serialized object in bytes
     *@return size in bytes*/  
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode: " + name() + ": " + getValue(); 
    }
}
