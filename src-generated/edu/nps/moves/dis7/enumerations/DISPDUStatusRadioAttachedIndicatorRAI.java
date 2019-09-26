package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 306 marshal size 2<br>
 * DIS-PDU Status-Radio Attached Indicator (RAI)
 */
public enum DISPDUStatusRadioAttachedIndicatorRAI 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Unattached */
    UNATTACHED (1, "Unattached"),
    /** Attached */
    ATTACHED (2, "Attached");

    private int value;
    private final String description;

    DISPDUStatusRadioAttachedIndicatorRAI(int value, String description)
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
      return 2;
    }

    public static DISPDUStatusRadioAttachedIndicatorRAI getEnumForValue(int i)
    {
       for(DISPDUStatusRadioAttachedIndicatorRAI val: DISPDUStatusRadioAttachedIndicatorRAI.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DISPDUStatusRadioAttachedIndicatorRAI");
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

    public static DISPDUStatusRadioAttachedIndicatorRAI unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static DISPDUStatusRadioAttachedIndicatorRAI unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "DISPDUStatusRadioAttachedIndicatorRAI: " + name() + ": " + getValue(); 
    }
}
