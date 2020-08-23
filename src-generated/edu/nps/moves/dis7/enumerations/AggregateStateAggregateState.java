package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 204 marshal size 8<br>
 * _______________________________
 */
public enum AggregateStateAggregateState 
{
    /** Other */
    OTHER (0, "Other"),
    /** Aggregated */
    AGGREGATED (1, "Aggregated"),
    /** Disaggregated */
    DISAGGREGATED (2, "Disaggregated"),
    /** Fully disaggregated */
    FULLY_DISAGGREGATED (3, "Fully disaggregated"),
    /** Pseudo-disaggregated */
    PSEUDO_DISAGGREGATED (4, "Pseudo-disaggregated"),
    /** Partially-disaggregated */
    PARTIALLY_DISAGGREGATED (5, "Partially-disaggregated");

    private int value;
    private final String description;

    AggregateStateAggregateState(int value, String description)
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

    public static AggregateStateAggregateState getEnumForValue(int i)
    {
       for(AggregateStateAggregateState val: AggregateStateAggregateState.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AggregateStateAggregateState");
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

    public static AggregateStateAggregateState unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static AggregateStateAggregateState unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AggregateStateAggregateState: " + name() + ": " + getValue(); 
    }
}
