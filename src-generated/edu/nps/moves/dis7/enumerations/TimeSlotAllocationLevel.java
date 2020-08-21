package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 172 marshal size 8<br>
 * TimeSlotAllocationLevel
 */
public enum TimeSlotAllocationLevel 
{
    /** Low Fidelity Level 0 */
    LOW_FIDELITY_LEVEL_0 (0, "Low Fidelity Level 0"),
    /** Low Fidelity Level 1 */
    LOW_FIDELITY_LEVEL_1 (1, "Low Fidelity Level 1"),
    /** Medium Fidelity Level 2 */
    MEDIUM_FIDELITY_LEVEL_2 (2, "Medium Fidelity Level 2"),
    /** Medium Fidelity Level 3 */
    MEDIUM_FIDELITY_LEVEL_3 (3, "Medium Fidelity Level 3"),
    /** High Fidelity Level 4 */
    HIGH_FIDELITY_LEVEL_4 (4, "High Fidelity Level 4");

    private int value;
    private final String description;

    TimeSlotAllocationLevel(int value, String description)
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

    public static TimeSlotAllocationLevel getEnumForValue(int i)
    {
       for(TimeSlotAllocationLevel val: TimeSlotAllocationLevel.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TimeSlotAllocationLevel");
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

    public static TimeSlotAllocationLevel unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static TimeSlotAllocationLevel unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "TimeSlotAllocationLevel: " + name() + ": " + getValue(); 
    }
}
