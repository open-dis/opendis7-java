package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 523 marshal size 8<br>
 * LifeFormHumanSpecificFlameThrowers
 */
public enum LifeFormHumanSpecificFlameThrowers 
{
    /** Other */
    OTHER (0, "Other"),
    /** Handflammpatrone */
    HANDFLAMMPATRONE (10, "Handflammpatrone"),
    /** FmW 41 */
    FMW_41 (11, "FmW 41"),
    /** M1A1 */
    M1A1 (20, "M1A1"),
    /** M2A1-7 */
    M2A1_7 (21, "M2A1-7"),
    /** M9A1-7 */
    M9A1_7 (22, "M9A1-7"),
    /** LPO-50 */
    LPO_50 (30, "LPO-50"),
    /** K Pattern */
    K_PATTERN (35, "K Pattern"),
    /** Portable, No 2 Ack Pack */
    PORTABLE_NO_2_ACK_PACK (36, "Portable, No 2 Ack Pack"),
    /** Marsden */
    MARSDEN (37, "Marsden"),
    /** Harvey */
    HARVEY (38, "Harvey"),
    /** ROKS-2 */
    ROKS_2 (45, "ROKS-2"),
    /** ROKS-3 */
    ROKS_3 (46, "ROKS-3"),
    /** Type-93 */
    TYPE_93 (50, "Type-93"),
    /** Type-100 */
    TYPE_100 (51, "Type-100");

    private int value;
    private final String description;

    LifeFormHumanSpecificFlameThrowers(int value, String description)
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

    public static LifeFormHumanSpecificFlameThrowers getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificFlameThrowers val: LifeFormHumanSpecificFlameThrowers.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificFlameThrowers");
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

    public static LifeFormHumanSpecificFlameThrowers unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormHumanSpecificFlameThrowers unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "LifeFormHumanSpecificFlameThrowers: " + name() + ": " + getValue(); 
    }
}
