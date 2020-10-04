package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 283 marshal size 8<br>
 * SeparationVPPreEntityIndicator
 */
public enum SeparationVPPreEntityIndicator 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Entity ID Existed Prior to Separation without Entity State PDU */
    ENTITY_ID_EXISTED_PRIOR_TO_SEPARATION_WITHOUT_ENTITY_STATE_PDU (1, "Entity ID Existed Prior to Separation without Entity State PDU"),
    /** Entity ID Existed Prior to Separation with Entity State PDU Issued */
    ENTITY_ID_EXISTED_PRIOR_TO_SEPARATION_WITH_ENTITY_STATE_PDU_ISSUED (2, "Entity ID Existed Prior to Separation with Entity State PDU Issued"),
    /** Entity Initially Created at Separation Event */
    ENTITY_INITIALLY_CREATED_AT_SEPARATION_EVENT (3, "Entity Initially Created at Separation Event");

    private int value;
    private final String description;

    SeparationVPPreEntityIndicator(int value, String description)
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

    public static SeparationVPPreEntityIndicator getEnumForValue(int i)
    {
       for(SeparationVPPreEntityIndicator val: SeparationVPPreEntityIndicator.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SeparationVPPreEntityIndicator");
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

    public static SeparationVPPreEntityIndicator unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static SeparationVPPreEntityIndicator unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "SeparationVPPreEntityIndicator " + getValue() + " " + name(); 
    }
}
