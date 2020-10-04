package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 470 marshal size 16<br>
 * Link11ModeofOperation
 */
public enum Link1111BModeofOperation 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Net Sync */
    NET_SYNC (1, "Net Sync"),
    /** Net Test */
    NET_TEST (2, "Net Test"),
    /** Roll Call */
    ROLL_CALL (3, "Roll Call"),
    /** Short Broadcast */
    SHORT_BROADCAST (4, "Short Broadcast"),
    /** Broadcast */
    BROADCAST (5, "Broadcast");

    private int value;
    private final String description;

    Link1111BModeofOperation(int value, String description)
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

    public static Link1111BModeofOperation getEnumForValue(int i)
    {
       for(Link1111BModeofOperation val: Link1111BModeofOperation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link1111BModeofOperation");
       return null;
    }

 
   public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }

    public static Link1111BModeofOperation unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static Link1111BModeofOperation unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "Link1111BModeofOperation " + getValue() + " " + name(); 
    }
}
