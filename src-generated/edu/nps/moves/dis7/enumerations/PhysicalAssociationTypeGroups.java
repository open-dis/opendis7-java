package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 322 marshal size 8<br>
 * PhysicalAssociationTypeGroups
 */
public enum PhysicalAssociationTypeGroups 
{
    /** Not Specified */
    NOT_SPECIFIED (0, "Not Specified"),
    /** Towed / Mounted / Sling Load */
    TOWED_MOUNTED_SLING_LOAD (1, "Towed / Mounted / Sling Load"),
    /** Restrained */
    RESTRAINED (2, "Restrained"),
    /** Mission */
    MISSION (3, "Mission"),
    /** Other Connections */
    OTHER_CONNECTIONS (4, "Other Connections");

    private int value;
    private final String description;

    PhysicalAssociationTypeGroups(int value, String description)
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

    public static PhysicalAssociationTypeGroups getEnumForValue(int i)
    {
       for(PhysicalAssociationTypeGroups val: PhysicalAssociationTypeGroups.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration PhysicalAssociationTypeGroups");
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

    public static PhysicalAssociationTypeGroups unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static PhysicalAssociationTypeGroups unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "PhysicalAssociationTypeGroups: " + name() + ": " + getValue(); 
    }
}
