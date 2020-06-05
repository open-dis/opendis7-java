package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 522 marshal size 8<br>
 * Life Form-Human-Specific-Flame Rockets
 */
public enum LifeFormHumanSpecificFlameRockets 
{
    /** Other */
    OTHER (0, "Other"),
    /** 66mm M202 Flash */
    $66MM_M202_FLASH (20, "66mm M202 Flash"),
    /** 62mm FHJ-84 */
    $62MM_FHJ_84 (30, "62mm FHJ-84"),
    /** 90mm C90-CR-FIM (M3) */
    $90MM_C90_CR_FIM_M3 (40, "90mm C90-CR-FIM (M3)"),
    /** 93mm RPO-A Shmel */
    $93MM_RPO_A_SHMEL (50, "93mm RPO-A Shmel"),
    /** 93mm RPO-Z Shmel */
    $93MM_RPO_Z_SHMEL (51, "93mm RPO-Z Shmel"),
    /** 93mm RPO-D Shmel */
    $93MM_RPO_D_SHMEL (52, "93mm RPO-D Shmel");

    private int value;
    private final String description;

    LifeFormHumanSpecificFlameRockets(int value, String description)
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

    public static LifeFormHumanSpecificFlameRockets getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificFlameRockets val: LifeFormHumanSpecificFlameRockets.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificFlameRockets");
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

    public static LifeFormHumanSpecificFlameRockets unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormHumanSpecificFlameRockets unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormHumanSpecificFlameRockets: " + name() + ": " + getValue(); 
    }
}
