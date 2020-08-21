package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 800 marshal size 8<br>
 * Link16Version
 */
public enum Link16Version 
{
    /** No Statement */
    NO_STATEMENT (0, "No Statement"),
    /** MIL-STD-6016C */
    MIL_STD_6016C (1, "MIL-STD-6016C"),
    /** MIL-STD-6016D */
    MIL_STD_6016D (2, "MIL-STD-6016D"),
    /** MIL-STD-6016E */
    MIL_STD_6016E (3, "MIL-STD-6016E"),
    /** MIL-STD-6016F */
    MIL_STD_6016F (4, "MIL-STD-6016F"),
    /** MIL-STD-6016F C1 */
    MIL_STD_6016F_C1 (5, "MIL-STD-6016F C1"),
    /** STANAG 5516 Ed 3 */
    STANAG_5516_ED_3 (103, "STANAG 5516 Ed 3"),
    /** STANAG 5516 Ed 4 */
    STANAG_5516_ED_4 (104, "STANAG 5516 Ed 4"),
    /** STANAG 5516 Ed 5 */
    STANAG_5516_ED_5 (105, "STANAG 5516 Ed 5"),
    /** STANAG 5516 Ed 6 */
    STANAG_5516_ED_6 (106, "STANAG 5516 Ed 6");

    private int value;
    private final String description;

    Link16Version(int value, String description)
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

    public static Link16Version getEnumForValue(int i)
    {
       for(Link16Version val: Link16Version.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration Link16Version");
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

    public static Link16Version unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static Link16Version unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "Link16Version: " + name() + ": " + getValue(); 
    }
}
