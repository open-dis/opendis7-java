package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 512 marshal size 8<br>
 * Life Form-Human-Specific-Mortars
 */
public enum LifeFormHumanSpecificMortars 
{
    /** Others */
    OTHERS (0, "Others"),
    /** 60mm M224 */
    $60MM_M224 (30, "60mm M224"),
    /** 81mm F2 */
    $81MM_F2 (50, "81mm F2"),
    /** 81mm L16 */
    $81MM_L16 (51, "81mm L16"),
    /** 81mm M252 */
    $81MM_M252 (52, "81mm M252");

    private int value;
    private final String description;

    LifeFormHumanSpecificMortars(int value, String description)
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

    public static LifeFormHumanSpecificMortars getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificMortars val: LifeFormHumanSpecificMortars.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificMortars");
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

    public static LifeFormHumanSpecificMortars unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static LifeFormHumanSpecificMortars unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormHumanSpecificMortars: " + name() + ": " + getValue(); 
    }
}
