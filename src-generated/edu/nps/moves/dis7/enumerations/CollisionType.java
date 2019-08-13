package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 189 marshal size 8<br>
 * Collision Type
 */
public enum CollisionType 
{
    /** Inelastic */
    INELASTIC (0, "Inelastic"),
    /** Elastic */
    ELASTIC (1, "Elastic"),
    /** Boom nozzle has cleared the receiver's refueling receptacle, Collision Type 55 indicates that during an aerial refueling exercise the boom nozzle has cleared the receiver's refueling receptacle. */
    BOOM_NOZZLE_HAS_CLEARED_THE_RECEIVERS_REFUELING_RECEPTACLE (55, "Boom nozzle has cleared the receiver's refueling receptacle");

    private int value;
    private final String description;

    CollisionType(int value, String description)
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

    public static CollisionType getEnumForValue(int i)
    {
       for(CollisionType val: CollisionType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration CollisionType");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
    }

    public static CollisionType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static CollisionType unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue((int)buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
}
