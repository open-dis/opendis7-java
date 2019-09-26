package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 366 marshal size 2<br>
 * Turn Rate Source
 */
public enum TurnRateSource 
{
    /** Compute Locally */
    COMPUTE_LOCALLY (0, "Compute Locally"),
    /** Less Than 1-Degree Turn or Not Turning */
    LESS_THAN_1_DEGREE_TURN_OR_NOT_TURNING (1, "Less Than 1-Degree Turn or Not Turning"),
    /** 1-Degree or Greater Turn Rate */
    $1_DEGREE_OR_GREATER_TURN_RATE (2, "1-Degree or Greater Turn Rate");

    private int value;
    private final String description;

    TurnRateSource(int value, String description)
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
      return 2;
    }

    public static TurnRateSource getEnumForValue(int i)
    {
       for(TurnRateSource val: TurnRateSource.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TurnRateSource");
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

    public static TurnRateSource unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static TurnRateSource unmarshalEnum(ByteBuffer buff) throws Exception
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
    
    @Override
    public String toString()
    {
        return "TurnRateSource: " + name() + ": " + getValue(); 
    }
}
