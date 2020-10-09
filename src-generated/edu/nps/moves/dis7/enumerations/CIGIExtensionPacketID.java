package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 780 marshal size 16<br>
 * CIGIExtensionPacketID<br>
 * Registered extension packet IDs shall be in the range of 1000h - 7FFFh. If the extension capability includes both a request and response packet, it is recommended they be given sequential packet ID numbers. Submitters are welcome to request any ID within this range, but are encouraged to cluster packet IDs for similar capabilities if the next available sequential ID from the beginning of the range is not requested.
 */
public enum CIGIExtensionPacketID 
{

    /** Image Capture Request packet ID */
    IMAGE_CAPTURE_REQUEST_PACKET_ID (4096, "Image Capture Request packet ID"),
    /** Image Capture Response packet ID */
    IMAGE_CAPTURE_RESPONSE_PACKET_ID (4097, "Image Capture Response packet ID");

    private int value;
    private final String description;

    CIGIExtensionPacketID(int value, String description)
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

    public static CIGIExtensionPacketID getEnumForValue(int i)
    {
       for(CIGIExtensionPacketID val: CIGIExtensionPacketID.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration CIGIExtensionPacketID");
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

    public static CIGIExtensionPacketID unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static CIGIExtensionPacketID unmarshalEnum (ByteBuffer byteBuffer) throws Exception
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
        return "CIGIExtensionPacketID " + getValue() + " " + name(); 
    }
}
