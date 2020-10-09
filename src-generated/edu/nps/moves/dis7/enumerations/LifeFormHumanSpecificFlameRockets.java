package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 522 marshal size 8<br>
 * LifeFormHumanSpecificFlameRockets
 */
public enum LifeFormHumanSpecificFlameRockets 
{
    /** Other */
    OTHER (0, "Other"),
    /** 66mm M202 Flash */
    _66MM_M202_FLASH (20, "66mm M202 Flash"),
    /** 62mm FHJ-84 */
    _62MM_FHJ_84 (30, "62mm FHJ-84"),
    /** 90mm C90-CR-FIM (M3) */
    _90MM_C90_CR_FIM_M3 (40, "90mm C90-CR-FIM (M3)"),
    /** 93mm RPO-A Shmel */
    _93MM_RPO_A_SHMEL (50, "93mm RPO-A Shmel"),
    /** 93mm RPO-Z Shmel */
    _93MM_RPO_Z_SHMEL (51, "93mm RPO-Z Shmel"),
    /** 93mm RPO-D Shmel */
    _93MM_RPO_D_SHMEL (52, "93mm RPO-D Shmel");

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
    
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
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

    public static LifeFormHumanSpecificFlameRockets unmarshalEnum(ByteBuffer byteBuffer) throws Exception
    {
        /*
        try {
            value = (int)byteBuffer.get();
        }
        catch(Exception ex) {
            showError(ex);
        }
        */
        return getEnumForValue(byteBuffer.get());
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "LifeFormHumanSpecificFlameRockets " + getValue() + " " + name(); 
    }
}
