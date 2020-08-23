package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 206 marshal size 8<br>
 * ______________________________
 */
public enum AggregateStateAggregateKind 
{
    /** Other */
    OTHER (0, "Other"),
    /** Military Hierarchy */
    MILITARY_HIERARCHY (1, "Military Hierarchy"),
    /** Common Type */
    COMMON_TYPE (2, "Common Type"),
    /** Common Mission */
    COMMON_MISSION (3, "Common Mission"),
    /** Similar Capabilities */
    SIMILAR_CAPABILITIES (4, "Similar Capabilities"),
    /** Common Location */
    COMMON_LOCATION (5, "Common Location");

    private int value;
    private final String description;

    AggregateStateAggregateKind(int value, String description)
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

    public static AggregateStateAggregateKind getEnumForValue(int i)
    {
       for(AggregateStateAggregateKind val: AggregateStateAggregateKind.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AggregateStateAggregateKind");
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

    public static AggregateStateAggregateKind unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static AggregateStateAggregateKind unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AggregateStateAggregateKind: " + name() + ": " + getValue(); 
    }
}
