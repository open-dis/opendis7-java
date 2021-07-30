package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
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
    SUPPLEMENTAL_EMISSION_ENTITY_STATE (30, "9mm MK3 SLP"),
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
    LIVE_ENTITY_DETONATION (50, "9.07mm Ruger GP 100"),
    /** 10mm Glock 20 */
    DATA_RELIABLE (60, "10mm Glock 20");

    private int value;
    private final String description;

    /** Constructor */
    LifeFormHumanSpecificHandGuns(int value, String description)
    {
        this.value = value;
        this.description = description;
    }
    /** Provide enumeration value
      * @return integer value */
    public int getValue()
    {
        return value;
    }

    /** Provide enumeration description
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /** bit width for this enumeration
     * @return number of bits wide
     */
    public static int getEnumBitWidth()
    {
      return 8;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static LifeFormHumanSpecificHandGuns getEnumForValue(int i)
    {
       for(LifeFormHumanSpecificHandGuns val: LifeFormHumanSpecificHandGuns.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration LifeFormHumanSpecificHandGuns");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    private boolean TRACE = false;

    /** Set tracing on/off for this object 
     * @param value whether tracing is on or off */
    public void setTRACE (boolean value)
    {
        TRACE = value;
    }

    /** Whether tracing is on or off for this object
     * @return whether tracing is on or off */
    public boolean getTRACE ()
    {
        return TRACE;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeByte(getValue());
    }
    
    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.put((byte)getValue());
    }

    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
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
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
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
        String padding = new String();
        if (this.getClass().getName().endsWith("DisPduType") && (getValue() < 10))
            padding = "0"; // leading zero for column spacing
        String result = "DisPduType " + padding + getValue() + " " + name();
        if (getTRACE())
            System.out.println ("*** enum " + this.getClass().getName() + " name=" + name() + ", value=" + getValue() + "; " +
               result); // debug diagnostic
        return result;
    }
}
