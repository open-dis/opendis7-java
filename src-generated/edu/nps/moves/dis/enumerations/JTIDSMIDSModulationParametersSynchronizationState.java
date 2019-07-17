package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 175 marshal size 8<br>
 * JTIDS/MIDS Modulation Parameters-Synchronization State
 */
public enum JTIDSMIDSModulationParametersSynchronizationState 
{
    /** Initial Net Entry */
    INITIAL_NET_ENTRY (1, "Initial Net Entry"),
    /** Coarse Synchronization */
    COARSE_SYNCHRONIZATION (2, "Coarse Synchronization"),
    /** Fine Synchronization */
    FINE_SYNCHRONIZATION (3, "Fine Synchronization"),
    /** Synchronization Maintenance */
    SYNCHRONIZATION_MAINTENANCE (4, "Synchronization Maintenance");

    private int value;
    private final String description;

    JTIDSMIDSModulationParametersSynchronizationState(int value, String description)
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

    public static JTIDSMIDSModulationParametersSynchronizationState getEnumForValue(int i)
    {
       for(JTIDSMIDSModulationParametersSynchronizationState val: JTIDSMIDSModulationParametersSynchronizationState.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration JTIDSMIDSModulationParametersSynchronizationState");
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

    public static JTIDSMIDSModulationParametersSynchronizationState unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static JTIDSMIDSModulationParametersSynchronizationState unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
}
