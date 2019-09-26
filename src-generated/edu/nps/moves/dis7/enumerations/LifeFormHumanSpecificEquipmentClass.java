package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 505 marshal size 8<br>
 * Life Form-Human-Specific-Equipment Class
 */
public enum LifeFormHumanSpecificEquipmentClass 
{
    /** Signal Smoke */
    SIGNAL_SMOKE (1, "Signal Smoke"),
    /** Flash Light */
    FLASH_LIGHT (2, "Flash Light"),
    /** Signal Mirror */
    SIGNAL_MIRROR (3, "Signal Mirror"),
    /** IR Strobe */
    IR_STROBE (4, "IR Strobe"),
    /** IR Illuminator */
    IR_ILLUMINATOR (5, "IR Illuminator");

    private int value;
    private final String description;

    LifeFormHumanSpecificEquipmentClass(int value, String description)
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

    public static LifeFormHumanSpecificEquipmentClass getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificEquipmentClass val: LifeFormHumanSpecificEquipmentClass.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificEquipmentClass");
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

    public static LifeFormHumanSpecificEquipmentClass unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static LifeFormHumanSpecificEquipmentClass unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormHumanSpecificEquipmentClass: " + name() + ": " + getValue(); 
    }
}
