package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 382 marshal size 3<br>
 * AppearanceHatch
 */
public enum AppearanceHatch 
{
    /** Not Applicable */
    NOT_APPLICABLE (0, "Not Applicable"),
    /** Closed */
    CLOSED (1, "Closed"),
    /** Popped */
    POPPED (2, "Popped"),
    /** Popped and Person Is Visible */
    POPPED_AND_PERSON_IS_VISIBLE (3, "Popped and Person Is Visible"),
    /** Open */
    OPEN (4, "Open"),
    /** Open and Person Is Visible */
    OPEN_AND_PERSON_IS_VISIBLE (5, "Open and Person Is Visible");

    private int value;
    private final String description;

    AppearanceHatch(int value, String description)
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

    public static AppearanceHatch getEnumForValue(int i)
    {
       for(AppearanceHatch val: AppearanceHatch.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AppearanceHatch");
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

    public static AppearanceHatch unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static AppearanceHatch unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AppearanceHatch: " + name() + ": " + getValue(); 
    }
}
