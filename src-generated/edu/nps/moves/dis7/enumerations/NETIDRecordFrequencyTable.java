package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 299 marshal size 2<br>
 * NETIDRecordFrequencyTable
 */
public enum NETIDRecordFrequencyTable 
{
    /** HQ I Operations */
    HQ_I_OPERATIONS (0, "HQ I Operations"),
    /** All HQII, HQIIA FM - NATO/Europe Area Operations */
    ALL_HQII_HQIIA_FM_NATO_EUROPE_AREA_OPERATIONS (1, "All HQII, HQIIA FM - NATO/Europe Area Operations"),
    /** All HQII, HQIIA FM - Non-NATO/Europe Operations */
    ALL_HQII_HQIIA_FM_NON_NATO_EUROPE_OPERATIONS (2, "All HQII, HQIIA FM - Non-NATO/Europe Operations"),
    /** HQIIA (SATURN) */
    HQIIA_SATURN (3, "HQIIA (SATURN)");

    private int value;
    private final String description;

    NETIDRecordFrequencyTable(int value, String description)
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
      return 2;
    }

    public static NETIDRecordFrequencyTable getEnumForValue(int i)
    {
       for(NETIDRecordFrequencyTable val: NETIDRecordFrequencyTable.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration NETIDRecordFrequencyTable");
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

    public static NETIDRecordFrequencyTable unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static NETIDRecordFrequencyTable unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "NETIDRecordFrequencyTable: " + name() + ": " + getValue(); 
    }
}
