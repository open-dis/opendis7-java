package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 173 marshal size 8<br>
 * JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode
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
    
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
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

    public static JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "JTIDSMIDSModulationParametersTransmittingTerminalPrimaryMode " + getValue() + " " + name(); 
    }
}
