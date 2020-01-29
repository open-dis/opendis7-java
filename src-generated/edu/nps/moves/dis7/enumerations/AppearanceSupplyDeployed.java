package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v25, 2018-08-29<br>
 * UID 399 marshal size 2<br>
 * Appearance-Supply Deployed
 */
public enum AppearanceSupplyDeployed 
{
    /** Not Applicable */
    NOT_APPLICABLE (0, "Not Applicable"),
    /** Stowed */
    STOWED (1, "Stowed"),
    /** Deployed */
    DEPLOYED (2, "Deployed"),
    /** Deployed and Active */
    DEPLOYED_AND_ACTIVE (3, "Deployed and Active");

    private int value;
    private final String description;

    AppearanceSupplyDeployed(int value, String description)
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

    public static AppearanceSupplyDeployed getEnumForValue(int i)
    {
       for(AppearanceSupplyDeployed val: AppearanceSupplyDeployed.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AppearanceSupplyDeployed");
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

    public static AppearanceSupplyDeployed unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue((int)dis.readByte());
    } 

    public static AppearanceSupplyDeployed unmarshalEnum(ByteBuffer buff) throws Exception
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
        return "AppearanceSupplyDeployed: " + name() + ": " + getValue(); 
    }
}
