package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 589 marshal size 16<br>
 * Transmitter-Detail-SATCOM-Modulation
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
        return getEnumForValue((int)dis.readUnsignedShort());
    } 

    public static TransmitterDetailSATCOMModulation unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue((int)buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
}
