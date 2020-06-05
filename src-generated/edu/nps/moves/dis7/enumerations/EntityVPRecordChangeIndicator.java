package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 320 marshal size 8<br>
 * Entity VP Record-Change Indicator
 */
public enum EntityVPRecordChangeIndicator 
{
    /** Initial Report or No Change Since Last Issuance */
    INITIAL_REPORT_OR_NO_CHANGE_SINCE_LAST_ISSUANCE (0, "Initial Report or No Change Since Last Issuance"),
    /** Change Since Last Issuance */
    CHANGE_SINCE_LAST_ISSUANCE (1, "Change Since Last Issuance");

    private int value;
    private final String description;

    EntityVPRecordChangeIndicator(int value, String description)
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

    public static EntityVPRecordChangeIndicator getEnumForValue(int i)
    {
       for(EntityVPRecordChangeIndicator val: EntityVPRecordChangeIndicator.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration EntityVPRecordChangeIndicator");
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

    public static EntityVPRecordChangeIndicator unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static EntityVPRecordChangeIndicator unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "EntityVPRecordChangeIndicator: " + name() + ": " + getValue(); 
    }
}
