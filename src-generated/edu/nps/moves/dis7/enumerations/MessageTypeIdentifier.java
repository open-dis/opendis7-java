package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 176 marshal size 8<br>
 * MessageTypeIdentifier
 */
public enum MessageTypeIdentifier 
{
    /** JTIDS Header/Messages */
    JTIDS_HEADER_MESSAGES (0, "JTIDS Header/Messages"),
    /** RTT A/B */
    RTT_A_B (1, "RTT A/B"),
    /** RTT Reply */
    RTT_REPLY (2, "RTT Reply"),
    /** JTIDS Voice CVSD */
    JTIDS_VOICE_CVSD (3, "JTIDS Voice CVSD"),
    /** JTIDS Voice LPC10 */
    JTIDS_VOICE_LPC10 (4, "JTIDS Voice LPC10"),
    /** JTIDS Voice LPC12 */
    JTIDS_VOICE_LPC12 (5, "JTIDS Voice LPC12"),
    /** JTIDS LET */
    JTIDS_LET (6, "JTIDS LET"),
    /** VMF */
    VMF (7, "VMF");

    private int value;
    private final String description;

    MessageTypeIdentifier(int value, String description)
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

    public static MessageTypeIdentifier getEnumForValue(int i)
    {
       for(MessageTypeIdentifier val: MessageTypeIdentifier.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration MessageTypeIdentifier");
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

    public static MessageTypeIdentifier unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static MessageTypeIdentifier unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "MessageTypeIdentifier " + getValue() + " " + name(); 
    }
}
