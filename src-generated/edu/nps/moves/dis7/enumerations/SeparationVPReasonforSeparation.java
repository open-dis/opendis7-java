package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 282 marshal size 8<br>
 * Separation VP-Reason for Separation
 */
public enum SeparationVPReasonforSeparation 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Attached Part Separation */
    ATTACHED_PART_SEPARATION (1, "Attached Part Separation"),
    /** Submunition Separation */
    SUBMUNITION_SEPARATION (2, "Submunition Separation");

    private int value;
    private final String description;

    SeparationVPReasonforSeparation(int value, String description)
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

    public static SeparationVPReasonforSeparation getEnumForValue(int i)
    {
       for(SeparationVPReasonforSeparation val: SeparationVPReasonforSeparation.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration SeparationVPReasonforSeparation");
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

    public static SeparationVPReasonforSeparation unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static SeparationVPReasonforSeparation unmarshalEnum(ByteBuffer buff) throws Exception
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
    
    @Override
    public String toString()
    {
        return "SeparationVPReasonforSeparation: " + name() + ": " + getValue(); 
    }
}
