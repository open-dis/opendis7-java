package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 26 marshal size 8<br>
 * ___________________________
 */
public enum ExpendableSurfaceCategory implements Category
{
    /** Other */
    OTHER (0, "Other"),
    /** Flare */
    FLARE (2, "Flare"),
    /** Active Emitter */
    ACTIVE_EMITTER (4, "Active Emitter"),
    /** Passive Decoy */
    PASSIVE_DECOY (5, "Passive Decoy"),
    /** Smoke Generator */
    SMOKE_GENERATOR (8, "Smoke Generator"),
    /** Combined Flare and Smoke Generator */
    COMBINED_FLARE_AND_SMOKE_GENERATOR (12, "Combined Flare and Smoke Generator"),
    /** SAR Buoy */
    SAR_BUOY (14, "SAR Buoy");

    private int value;
    private final String description;

    ExpendableSurfaceCategory(int value, String description)
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

    public static ExpendableSurfaceCategory getEnumForValue(int i)
    {
       for(ExpendableSurfaceCategory val: ExpendableSurfaceCategory.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration ExpendableSurfaceCategory");
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

    public static ExpendableSurfaceCategory unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static ExpendableSurfaceCategory unmarshalEnum(ByteBuffer buff) throws Exception
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

    /** Returns the size of this serialized object in bytes
     *@return size in bytes*/  
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "ExpendableSurfaceCategory: " + name() + ": " + getValue(); 
    }
}
