package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 740 marshal size 8<br>
 * Link11BDataSignalingRate
 */
public enum Link11BDataSignalingRate 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Not Used */
    NOT_USED (1, "Not Used"),
    /** Not Used */
    NOT_USED_2 (2, "Not Used"),
    /** 1200 bps */
    _1200_BPS (3, "1200 bps"),
    /** 2400 bps */
    _2400_BPS (4, "2400 bps"),
    /** 600 bps */
    _600_BPS (5, "600 bps");

    private int value;
    private final String description;

    Link11BDataSignalingRate(int value, String description)
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

    public static Link11BDataSignalingRate getEnumForValue(int i)
    {
       for(Link11BDataSignalingRate val: Link11BDataSignalingRate.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link11BDataSignalingRate");
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

    public static Link11BDataSignalingRate unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Link11BDataSignalingRate unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "Link11BDataSignalingRate " + getValue() + " " + name(); 
    }
}
