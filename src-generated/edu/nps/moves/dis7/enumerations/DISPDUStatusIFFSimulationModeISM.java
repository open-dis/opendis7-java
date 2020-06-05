package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 308 marshal size 1<br>
 * DIS-PDU Status-IFF Simulation Mode (ISM)
 */
public enum DISPDUStatusIFFSimulationModeISM 
{
    /** Regeneration */
    REGENERATION (0, "Regeneration"),
    /** Interactive */
    INTERACTIVE (1, "Interactive");

    private int value;
    private final String description;

    DISPDUStatusIFFSimulationModeISM(int value, String description)
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

    public static DISPDUStatusIFFSimulationModeISM getEnumForValue(int i)
    {
       for(DISPDUStatusIFFSimulationModeISM val: DISPDUStatusIFFSimulationModeISM.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration DISPDUStatusIFFSimulationModeISM");
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

    public static DISPDUStatusIFFSimulationModeISM unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static DISPDUStatusIFFSimulationModeISM unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "DISPDUStatusIFFSimulationModeISM: " + name() + ": " + getValue(); 
    }
}
