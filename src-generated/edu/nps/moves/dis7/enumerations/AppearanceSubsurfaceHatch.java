package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 388 marshal size 3<br>
 * ___________________________
 */
public enum AppearanceSubsurfaceHatch 
{
    /** Not Applicable */
    NOT_APPLICABLE (0, "Not Applicable"),
    /** Hatch Is Closed */
    HATCH_IS_CLOSED (1, "Hatch Is Closed"),
    /** Hatch Is Open */
    HATCH_IS_OPEN (4, "Hatch Is Open");

    private int value;
    private final String description;

    AppearanceSubsurfaceHatch(int value, String description)
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
      return 3;
    }

    public static AppearanceSubsurfaceHatch getEnumForValue(int i)
    {
       for(AppearanceSubsurfaceHatch val: AppearanceSubsurfaceHatch.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AppearanceSubsurfaceHatch");
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

    public static AppearanceSubsurfaceHatch unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static AppearanceSubsurfaceHatch unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AppearanceSubsurfaceHatch: " + name() + ": " + getValue(); 
    }
}
