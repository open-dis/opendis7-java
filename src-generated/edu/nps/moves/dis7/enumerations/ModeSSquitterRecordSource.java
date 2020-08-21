package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 355 marshal size 1<br>
 * ModeSSquitterRecordSource
 */
public enum ModeSSquitterRecordSource 
{
    /** Layer 4 IFF Data Records */
    LAYER_4_IFF_DATA_RECORDS (0, "Layer 4 IFF Data Records"),
    /** Layer 5 GICB IFF Data Records */
    LAYER_5_GICB_IFF_DATA_RECORDS (1, "Layer 5 GICB IFF Data Records");

    private int value;
    private final String description;

    ModeSSquitterRecordSource(int value, String description)
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

    public static ModeSSquitterRecordSource getEnumForValue(int i)
    {
       for(ModeSSquitterRecordSource val: ModeSSquitterRecordSource.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ModeSSquitterRecordSource");
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

    public static ModeSSquitterRecordSource unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static ModeSSquitterRecordSource unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "ModeSSquitterRecordSource: " + name() + ": " + getValue(); 
    }
}
