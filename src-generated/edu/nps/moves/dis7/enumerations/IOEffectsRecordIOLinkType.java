package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 291 marshal size 8<br>
 * IO Effects Record-IO Link Type
 */
public enum IOEffectsRecordIOLinkType 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Logical Link */
    LOGICAL_LINK (1, "Logical Link"),
    /** Physical Node */
    PHYSICAL_NODE (2, "Physical Node"),
    /** Physical Link */
    PHYSICAL_LINK (3, "Physical Link");

    private int value;
    private final String description;

    IOEffectsRecordIOLinkType(int value, String description)
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

    public static IOEffectsRecordIOLinkType getEnumForValue(int i)
    {
       for(IOEffectsRecordIOLinkType val: IOEffectsRecordIOLinkType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration IOEffectsRecordIOLinkType");
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

    public static IOEffectsRecordIOLinkType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static IOEffectsRecordIOLinkType unmarshalEnum(ByteBuffer buff) throws Exception
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
