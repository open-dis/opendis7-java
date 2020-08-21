package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 301 marshal size 1<br>
 * DISPDUStatusTransferredEntityIndicator(TEI)
 */
public enum DISPDUStatusTransferredEntityIndicatorTEI 
{
    /** No Difference */
    NO_DIFFERENCE (0, "No Difference"),
    /** Difference */
    DIFFERENCE (1, "Difference");

    private int value;
    private final String description;

    DISPDUStatusTransferredEntityIndicatorTEI(int value, String description)
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
      return 1;
    }

    public static DISPDUStatusTransferredEntityIndicatorTEI getEnumForValue(int i)
    {
       for(DISPDUStatusTransferredEntityIndicatorTEI val: DISPDUStatusTransferredEntityIndicatorTEI.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DISPDUStatusTransferredEntityIndicatorTEI");
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

    public static DISPDUStatusTransferredEntityIndicatorTEI unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static DISPDUStatusTransferredEntityIndicatorTEI unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "DISPDUStatusTransferredEntityIndicatorTEI: " + name() + ": " + getValue(); 
    }
}
