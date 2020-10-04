package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 513 marshal size 8<br>
 * LifeFormHumanSpecificHandGuns
 */
public enum LifeFormHumanSpecificHandGuns 
{
    /** Other */
    OTHER (0, "Other"),
    /** 5.45mm PSM */
    _545MM_PSM (1, "5.45mm PSM"),
    /** 9mm MK3 SLP */
    _9MM_MK3_SLP (30, "9mm MK3 SLP"),
    /** 9mm Beretta 92S/92FS (M9) */
    _9MM_BERETTA_92S_92FS_M9 (31, "9mm Beretta 92S/92FS (M9)"),
    /** 9mm HandK USP */
    _9MM_HK_USP (32, "9mm H&K USP"),
    /** 9mm Stechkin APS */
    _9MM_STECHKIN_APS (33, "9mm Stechkin APS"),
    /** 9mm Makarov PM */
    _9MM_MAKAROV_PM (34, "9mm Makarov PM"),
    /** 9mm Smith and Wesson SD (Sigma) */
    _9MM_SMITH_AND_WESSON_SD_SIGMA (35, "9mm Smith and Wesson SD (Sigma)"),
    /** 9mm Glock 17 */
    _9MM_GLOCK_17 (36, "9mm Glock 17"),
    /** 9mm SIG Pro */
    _9MM_SIG_PRO (38, "9mm SIG Pro"),
    /** 9mm Smith and Wesson SW1911 */
    _9MM_SMITH_AND_WESSON_SW1911 (39, "9mm Smith and Wesson SW1911"),
    /** 9mm Smith and Wesson 5900-series */
    _9MM_SMITH_AND_WESSON_5900_SERIES (40, "9mm Smith and Wesson 5900-series"),
    /** .45 Cal M1911 */
    _45_CAL_M1911 (41, ".45 Cal M1911"),
    /** 9.07mm Ruger GP 100 */
    _907MM_RUGER_GP_100 (50, "9.07mm Ruger GP 100"),
    /** 10mm Glock 20 */
    _10MM_GLOCK_20 (60, "10mm Glock 20");

    private int value;
    private final String description;

    LifeFormHumanSpecificHandGuns(int value, String description)
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

    public static LifeFormHumanSpecificHandGuns getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificHandGuns val: LifeFormHumanSpecificHandGuns.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificHandGuns");
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

    public static LifeFormHumanSpecificHandGuns unmarshalEnum (DataInputStream dis) throws Exception
    {
       /* try {
            value = dis.readUnsignedByte();
        }
        catch(IOException ex) {
            showError(ex);
        } */
        
        return getEnumForValue(dis.readByte());
    } 

    public static LifeFormHumanSpecificHandGuns unmarshalEnum(ByteBuffer byteBuffer) throws Exception
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
        return "LifeFormHumanSpecificHandGuns " + getValue() + " " + name(); 
    }
}
