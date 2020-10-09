package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 294 marshal size 8<br>
 * IOCommsNodeRecordCommsNodeType
 */
public enum IOCommsNodeRecordCommsNodeType 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Sender Node ID */
    SENDER_NODE_ID (1, "Sender Node ID"),
    /** Receiver Node ID */
    RECEIVER_NODE_ID (2, "Receiver Node ID"),
    /** Sender/Receiver Node ID */
    SENDER_RECEIVER_NODE_ID (3, "Sender/Receiver Node ID");

    private int value;
    private final String description;

    IOCommsNodeRecordCommsNodeType(int value, String description)
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

    public static IOCommsNodeRecordCommsNodeType getEnumForValue(int i)
    {
       for(IOCommsNodeRecordCommsNodeType val: IOCommsNodeRecordCommsNodeType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IOCommsNodeRecordCommsNodeType");
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

    public static IOCommsNodeRecordCommsNodeType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static IOCommsNodeRecordCommsNodeType unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "IOCommsNodeRecordCommsNodeType " + getValue() + " " + name(); 
    }
}
