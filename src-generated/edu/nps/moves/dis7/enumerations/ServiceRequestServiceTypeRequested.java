package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 63 marshal size 8<br>
 * Service Request-Service Type Requested
 */
public enum ServiceRequestServiceTypeRequested 
{
    /** Other */
    OTHER (0, "Other"),
    /** Resupply */
    RESUPPLY (1, "Resupply"),
    /** Repair */
    REPAIR (2, "Repair"),
    /** Aerial Refueling High Fidelity */
    AERIAL_REFUELING_HIGH_FIDELITY (3, "Aerial Refueling High Fidelity"),
    /** Aerial Refueling Low Fidelity */
    AERIAL_REFUELING_LOW_FIDELITY (4, "Aerial Refueling Low Fidelity");

    private int value;
    private final String description;

    ServiceRequestServiceTypeRequested(int value, String description)
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

    public static ServiceRequestServiceTypeRequested getEnumForValue(int i)
    {
       for(ServiceRequestServiceTypeRequested val: ServiceRequestServiceTypeRequested.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ServiceRequestServiceTypeRequested");
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

    public static ServiceRequestServiceTypeRequested unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static ServiceRequestServiceTypeRequested unmarshalEnum(ByteBuffer buff) throws Exception
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
