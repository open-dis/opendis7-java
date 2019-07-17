package edu.nps.moves.dis.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 302 marshal size 2<br>
 * DIS-PDU Status-LVC Indicator (LVC)
 */
public enum DISPDUStatusLVCIndicatorLVC 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** Live */
    LIVE (1, "Live"),
    /** Virtual */
    VIRTUAL (2, "Virtual"),
    /** Constructive */
    CONSTRUCTIVE (3, "Constructive");

    private int value;
    private final String description;

    DISPDUStatusLVCIndicatorLVC(int value, String description)
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

    public static DISPDUStatusLVCIndicatorLVC getEnumForValue(int i)
    {
       for(DISPDUStatusLVCIndicatorLVC val: DISPDUStatusLVCIndicatorLVC.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DISPDUStatusLVCIndicatorLVC");
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

    public static DISPDUStatusLVCIndicatorLVC unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static DISPDUStatusLVCIndicatorLVC unmarshalEnum(ByteBuffer buff) throws Exception
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
