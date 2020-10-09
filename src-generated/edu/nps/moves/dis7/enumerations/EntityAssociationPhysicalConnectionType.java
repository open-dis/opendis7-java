package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 324 marshal size 8<br>
 * EntityAssociationPhysicalConnectionType
 */
public enum EntityAssociationPhysicalConnectionType 
{
    /** Not Specified */
    NOT_SPECIFIED (0, "Not Specified"),
    /** Attached Directly to Surface */
    ATTACHED_DIRECTLY_TO_SURFACE (1, "Attached Directly to Surface"),
    /** Cable Wire */
    CABLE_WIRE (2, "Cable Wire"),
    /** Rope */
    ROPE (3, "Rope"),
    /** Chain */
    CHAIN (4, "Chain"),
    /** Power Line */
    POWER_LINE (5, "Power Line"),
    /** Telephone Line */
    TELEPHONE_LINE (6, "Telephone Line"),
    /** Cable Line */
    CABLE_LINE (7, "Cable Line"),
    /** Refueling Drogue */
    REFUELING_DROGUE (8, "Refueling Drogue"),
    /** Refueling Boom */
    REFUELING_BOOM (9, "Refueling Boom"),
    /** Handcuffs */
    HANDCUFFS (10, "Handcuffs"),
    /** In Contact With */
    IN_CONTACT_WITH (11, "In Contact With"),
    /** Fast Rope */
    FAST_ROPE (12, "Fast Rope");

    private int value;
    private final String description;

    EntityAssociationPhysicalConnectionType(int value, String description)
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

    public static EntityAssociationPhysicalConnectionType getEnumForValue(int i)
    {
       for(EntityAssociationPhysicalConnectionType val: EntityAssociationPhysicalConnectionType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityAssociationPhysicalConnectionType");
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

    public static EntityAssociationPhysicalConnectionType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static EntityAssociationPhysicalConnectionType unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "EntityAssociationPhysicalConnectionType " + getValue() + " " + name(); 
    }
}
