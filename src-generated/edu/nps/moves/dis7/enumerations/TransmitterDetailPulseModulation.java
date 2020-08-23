package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 160 marshal size 16<br>
 * ___________________________________
 */
public enum TransmitterDetailPulseModulation 
{
    /** Other */
    OTHER (0, "Other"),
    /** Pulse */
    PULSE (1, "Pulse"),
    /** X Band TACAN Pulse */
    X_BAND_TACAN_PULSE (2, "X Band TACAN Pulse"),
    /** Y Band TACAN Pulse */
    Y_BAND_TACAN_PULSE (3, "Y Band TACAN Pulse");

    private int value;
    private final String description;

    TransmitterDetailPulseModulation(int value, String description)
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

    public static TransmitterDetailPulseModulation getEnumForValue(int i)
    {
       for(TransmitterDetailPulseModulation val: TransmitterDetailPulseModulation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterDetailPulseModulation");
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

    public static TransmitterDetailPulseModulation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static TransmitterDetailPulseModulation unmarshalEnum (ByteBuffer buff) throws Exception
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
        return "TransmitterDetailPulseModulation: " + name() + ": " + getValue(); 
    }
}
