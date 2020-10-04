package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 393 marshal size 2<br>
 * AppearanceLifeFormWeaponImplement
 */
public enum AppearanceLifeFormWeaponImplement 
{
    /** Not Present */
    NOT_PRESENT (0, "Not Present"),
    /** Stowed */
    STOWED (1, "Stowed"),
    /** Deployed/Active */
    DEPLOYED_ACTIVE (2, "Deployed/Active"),
    /** Firing Position/In Use */
    FIRING_POSITION_IN_USE (3, "Firing Position/In Use");

    private int value;
    private final String description;

    AppearanceLifeFormWeaponImplement(int value, String description)
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

    public static AppearanceLifeFormWeaponImplement getEnumForValue(int i)
    {
       for(AppearanceLifeFormWeaponImplement val: AppearanceLifeFormWeaponImplement.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration AppearanceLifeFormWeaponImplement");
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

    public static AppearanceLifeFormWeaponImplement unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static AppearanceLifeFormWeaponImplement unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "AppearanceLifeFormWeaponImplement " + getValue() + " " + name(); 
    }
}
