package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 734 marshal size 8<br>
 * Link11SignalWaveform
 */
public enum Link11SignalWaveform 
{
    /** No Statement - CLEW Format */
    NO_STATEMENT_CLEW_FORMAT (0, "No Statement - CLEW Format"),
    /** Conventional Link Eleven Waveform (CLEW) */
    CONVENTIONAL_LINK_ELEVEN_WAVEFORM_CLEW (1, "Conventional Link Eleven Waveform (CLEW)"),
    /** Single Tone Link Eleven Waveform (SLEW) */
    SINGLE_TONE_LINK_ELEVEN_WAVEFORM_SLEW (2, "Single Tone Link Eleven Waveform (SLEW)");

    private int value;
    private final String description;

    Link11SignalWaveform(int value, String description)
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

    public static Link11SignalWaveform getEnumForValue(int i)
    {
       for(Link11SignalWaveform val: Link11SignalWaveform.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link11SignalWaveform");
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

    public static Link11SignalWaveform unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Link11SignalWaveform unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "Link11SignalWaveform " + getValue() + " " + name(); 
    }
}
