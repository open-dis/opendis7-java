package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 65 marshal size 8<br>
 * RepairResponseRepairResult
 */
public enum RepairResponseRepairResult 
{
    /** other */
    OTHER (0, "other"),
    /** repair ended */
    REPAIR_ENDED (1, "repair ended"),
    /** invalid repair */
    INVALID_REPAIR (2, "invalid repair"),
    /** repair interrupted */
    REPAIR_INTERRUPTED (3, "repair interrupted"),
    /** service canceled by the supplier */
    SERVICE_CANCELED_BY_THE_SUPPLIER (4, "service canceled by the supplier");

    private int value;
    private final String description;

    RepairResponseRepairResult(int value, String description)
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

    public static RepairResponseRepairResult getEnumForValue(int i)
    {
       for(RepairResponseRepairResult val: RepairResponseRepairResult.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration RepairResponseRepairResult");
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

    public static RepairResponseRepairResult unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static RepairResponseRepairResult unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "RepairResponseRepairResult " + getValue() + " " + name(); 
    }
}
