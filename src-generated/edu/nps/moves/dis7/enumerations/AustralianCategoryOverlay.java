package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 500 marshal size 8<br>
 * Australian Category Overlay
 */
public enum AustralianCategoryOverlay 
{
    /** Australian Army */
    AUSTRALIAN_ARMY (11, "Australian Army"),
    /** Royal Australian Air Force (RAAF) */
    ROYAL_AUSTRALIAN_AIR_FORCE_RAAF (13, "Royal Australian Air Force (RAAF)"),
    /** Royal Australian Navy (RAN) */
    ROYAL_AUSTRALIAN_NAVY_RAN (14, "Royal Australian Navy (RAN)"),
    /** Australian Special Operations Command (SOCOMD) */
    AUSTRALIAN_SPECIAL_OPERATIONS_COMMAND_SOCOMD (30, "Australian Special Operations Command (SOCOMD)"),
    /** Australian Department of Home Affairs */
    AUSTRALIAN_DEPARTMENT_OF_HOME_AFFAIRS (51, "Australian Department of Home Affairs"),
    /** Australian Federal Police (AFP) */
    AUSTRALIAN_FEDERAL_POLICE_AFP (52, "Australian Federal Police (AFP)");

    private int value;
    private final String description;

    AustralianCategoryOverlay(int value, String description)
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

    public static AustralianCategoryOverlay getEnumForValue(int i)
    {
       for(AustralianCategoryOverlay val: AustralianCategoryOverlay.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AustralianCategoryOverlay");
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

    public static AustralianCategoryOverlay unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static AustralianCategoryOverlay unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AustralianCategoryOverlay: " + name() + ": " + getValue(); 
    }
}
