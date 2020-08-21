package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 730 marshal size 8<br>
 * Link11MessageSubType
 */
public enum Link11MessageSubType 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Interrogation */
    INTERROGATION (1, "Interrogation"),
    /** Intermediate Data */
    INTERMEDIATE_DATA (2, "Intermediate Data"),
    /** Final Data */
    FINAL_DATA (3, "Final Data"),
    /** Final Data and Interrogation */
    FINAL_DATA_AND_INTERROGATION (4, "Final Data and Interrogation");

    private int value;
    private final String description;

    Link11MessageSubType(int value, String description)
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

    public static Link11MessageSubType getEnumForValue(int i)
    {
       for(Link11MessageSubType val: Link11MessageSubType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link11MessageSubType");
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

    public static Link11MessageSubType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Link11MessageSubType unmarshalEnum(ByteBuffer buff) throws Exception
    {
        /*
        try {
            value = (int)buff.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(buff.get());
    }

    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "Link11MessageSubType: " + name() + ": " + getValue(); 
    }
}
