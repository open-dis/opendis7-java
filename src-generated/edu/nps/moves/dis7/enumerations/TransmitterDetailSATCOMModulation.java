package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 589 marshal size 16<br>
 * ____________________________________
 */
public enum TransmitterDetailSATCOMModulation 
{
    /** Other */
    OTHER (0, "Other"),
    /** No Delay, A low-fidelity representation of SATCOM modulation */
    NO_DELAY (1, "No Delay");

    private int value;
    private final String description;

    TransmitterDetailSATCOMModulation(int value, String description)
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

    public static TransmitterDetailSATCOMModulation getEnumForValue(int i)
    {
       for(TransmitterDetailSATCOMModulation val: TransmitterDetailSATCOMModulation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterDetailSATCOMModulation");
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

    public static TransmitterDetailSATCOMModulation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static TransmitterDetailSATCOMModulation unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "TransmitterDetailSATCOMModulation: " + name() + ": " + getValue(); 
    }
}
