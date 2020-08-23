package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 513 marshal size 8<br>
 * __________________________________
 */
public enum LifeFormHumanSpecificHandGuns 
{
    /** Other */
    OTHER (0, "Other"),
    /** 5.45mm PSM */
    NAME_545MM_PSM (1, "5.45mm PSM"),
    /** 9mm MK3 SLP */
    NAME_9MM_MK3_SLP (30, "9mm MK3 SLP"),
    /** 9mm Beretta 92S/92FS (M9) */
    NAME_9MM_BERETTA_92S_92FS_M9 (31, "9mm Beretta 92S/92FS (M9)"),
    /** 9mm HandK USP */
    NAME_9MM_HK_USP (32, "9mm H&K USP"),
    /** 9mm Stechkin APS */
    NAME_9MM_STECHKIN_APS (33, "9mm Stechkin APS"),
    /** 9mm Makarov PM */
    NAME_9MM_MAKAROV_PM (34, "9mm Makarov PM"),
    /** 9mm Smith and Wesson SD (Sigma) */
    NAME_9MM_SMITH_AND_WESSON_SD_SIGMA (35, "9mm Smith and Wesson SD (Sigma)"),
    /** 9mm Glock 17 */
    NAME_9MM_GLOCK_17 (36, "9mm Glock 17"),
    /** 9mm SIG Pro */
    NAME_9MM_SIG_PRO (38, "9mm SIG Pro"),
    /** 9mm Smith and Wesson SW1911 */
    NAME_9MM_SMITH_AND_WESSON_SW1911 (39, "9mm Smith and Wesson SW1911"),
    /** 9mm Smith and Wesson 5900-series */
    NAME_9MM_SMITH_AND_WESSON_5900_SERIES (40, "9mm Smith and Wesson 5900-series"),
    /** .45 Cal M1911 */
    NAME_45_CAL_M1911 (41, ".45 Cal M1911"),
    /** 9.07mm Ruger GP 100 */
    NAME_907MM_RUGER_GP_100 (50, "9.07mm Ruger GP 100"),
    /** 10mm Glock 20 */
    NAME_10MM_GLOCK_20 (60, "10mm Glock 20");

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
    
    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.put((byte)getValue());
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

    public static LifeFormHumanSpecificHandGuns unmarshalEnum(ByteBuffer buff) throws Exception
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

    /** Returns the size of this serialized object in bytes
     *@return size in bytes*/  
    public int getMarshalledSize()
    {
        return 1; // 8 bits
    }
    
    @Override
    public String toString()
    {
        return "LifeFormHumanSpecificHandGuns: " + name() + ": " + getValue(); 
    }
}
