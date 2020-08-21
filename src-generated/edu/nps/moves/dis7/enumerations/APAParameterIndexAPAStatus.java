package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 281 marshal size 2<br>
 * APAParameterIndexAPAStatus
 */
public enum APAParameterIndexAPAStatus 
{
    /** Deselected/Off */
    DESELECTED_OFF (0, "Deselected/Off"),
    /** APA Value Change Only */
    APA_VALUE_CHANGE_ONLY (1, "APA Value Change Only"),
    /** State Change */
    STATE_CHANGE (2, "State Change"),
    /** Record Activation */
    RECORD_ACTIVATION (3, "Record Activation");

    private int value;
    private final String description;

    APAParameterIndexAPAStatus(int value, String description)
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

    public static APAParameterIndexAPAStatus getEnumForValue(int i)
    {
       for(APAParameterIndexAPAStatus val: APAParameterIndexAPAStatus.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration APAParameterIndexAPAStatus");
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

    public static APAParameterIndexAPAStatus unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static APAParameterIndexAPAStatus unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "APAParameterIndexAPAStatus: " + name() + ": " + getValue(); 
    }
}
