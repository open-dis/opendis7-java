package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 731 marshal size 8<br>
 * Link11MessageTypeIdentifier
 */
public enum Link11MessageTypeIdentifier 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Net Test */
    NET_TEST (1, "Net Test"),
    /** Roll Call */
    ROLL_CALL (2, "Roll Call"),
    /** Picket Reply */
    PICKET_REPLY (3, "Picket Reply"),
    /** Short Broadcast */
    SHORT_BROADCAST (4, "Short Broadcast"),
    /** Broadcast */
    BROADCAST (5, "Broadcast"),
    /** Net Sync */
    NET_SYNC (6, "Net Sync");

    private int value;
    private final String description;

    Link11MessageTypeIdentifier(int value, String description)
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

    public static Link11MessageTypeIdentifier getEnumForValue(int i)
    {
       for(Link11MessageTypeIdentifier val: Link11MessageTypeIdentifier.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link11MessageTypeIdentifier");
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

    public static Link11MessageTypeIdentifier unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Link11MessageTypeIdentifier unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "Link11MessageTypeIdentifier " + getValue() + " " + name(); 
    }
}
