package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 224 marshal size 8<br>
 * Transfer Control-Transfer Type
 */
public enum TransferControlTransferType 
{
    /** Other */
    OTHER (0, "Other"),
    /** Push Transfer - Entity */
    PUSH_TRANSFER_ENTITY (1, "Push Transfer - Entity"),
    /** Automatic Pull Transfer - Entity */
    AUTOMATIC_PULL_TRANSFER_ENTITY (2, "Automatic Pull Transfer - Entity"),
    /** Not Used */
    NOT_USED (3, "Not Used"),
    /** Push Transfer - Environmental Process */
    PUSH_TRANSFER_ENVIRONMENTAL_PROCESS (4, "Push Transfer - Environmental Process"),
    /** Automatic Pull Transfer - Environmental Process */
    AUTOMATIC_PULL_TRANSFER_ENVIRONMENTAL_PROCESS (5, "Automatic Pull Transfer - Environmental Process"),
    /** Not Used */
    NOT_USED_2 (6, "Not Used"),
    /** Cancel Transfer */
    CANCEL_TRANSFER (7, "Cancel Transfer"),
    /** Manual Pull Transfer - Entity */
    MANUAL_PULL_TRANSFER_ENTITY (8, "Manual Pull Transfer - Entity"),
    /** Manual Pull Transfer - Environmental Process */
    MANUAL_PULL_TRANSFER_ENVIRONMENTAL_PROCESS (9, "Manual Pull Transfer - Environmental Process"),
    /** Remove Entity */
    REMOVE_ENTITY (10, "Remove Entity");

    private int value;
    private final String description;

    TransferControlTransferType(int value, String description)
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

    public static TransferControlTransferType getEnumForValue(int i)
    {
       for(TransferControlTransferType val: TransferControlTransferType.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransferControlTransferType");
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

    public static TransferControlTransferType unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static TransferControlTransferType unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "TransferControlTransferType: " + name() + ": " + getValue(); 
    }
}
