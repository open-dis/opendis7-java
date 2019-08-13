package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 467 marshal size 8<br>
 * Link 11/11B Fidelity Level
 */
public enum Link1111BFidelityLevel 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Fidelity Level 1 */
    FIDELITY_LEVEL_1 (1, "Fidelity Level 1"),
    /** Fidelity Level 2 */
    FIDELITY_LEVEL_2 (2, "Fidelity Level 2");

    private int value;
    private final String description;

    Link1111BFidelityLevel(int value, String description)
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

    public static Link1111BFidelityLevel getEnumForValue(int i)
    {
       for(Link1111BFidelityLevel val: Link1111BFidelityLevel.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link1111BFidelityLevel");
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

    public static Link1111BFidelityLevel unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static Link1111BFidelityLevel unmarshalEnum(ByteBuffer buff) throws Exception
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
