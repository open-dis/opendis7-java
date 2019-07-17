package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 286 marshal size 16<br>
 * IO Action-IO Simulation Source<br>
 * Values 1-999 are reserved for United States IO Simulation Sources – See applicable agreement of the organizers of the event (training, exercise, etc.) in which information operations is included.
 */
public enum IOActionIOSimulationSource 
{

    /** No Statement */
    NO_STATEMENT (0, "No Statement");

    private int value;
    private final String description;

    IOActionIOSimulationSource(int value, String description)
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

    public static IOActionIOSimulationSource getEnumForValue(int i)
    {
       for(IOActionIOSimulationSource val: IOActionIOSimulationSource.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IOActionIOSimulationSource");
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

    public static IOActionIOSimulationSource unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static IOActionIOSimulationSource unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
