package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.*;

/**
 * Generated from XML, SISO-REF-010-v28, 2020-05-07<br>
 * UID 166 marshal size 16<br>
 * TransmitterCryptoSystem
 */
public enum TransmitterCryptoSystem 
{
    /** No Encryption Device */
    NO_ENCRYPTION_DEVICE (0, "No Encryption Device"),
    /** KY-28 */
    KY_28 (1, "KY-28"),
    /** KY-58 */
    KY_58 (2, "KY-58"),
    /** Narrow Spectrum Secure Voice (NSVE) */
    NARROW_SPECTRUM_SECURE_VOICE_NSVE (3, "Narrow Spectrum Secure Voice (NSVE)"),
    /** Wide Spectrum Secure Voice (WSVE) */
    WIDE_SPECTRUM_SECURE_VOICE_WSVE (4, "Wide Spectrum Secure Voice (WSVE)"),
    /** SINCGARS ICOM */
    SINCGARS_ICOM (5, "SINCGARS ICOM"),
    /** KY-75 */
    KY_75 (6, "KY-75"),
    /** KY-100 */
    KY_100 (7, "KY-100"),
    /** KY-57 */
    KY_57 (8, "KY-57"),
    /** KYV-5 */
    KYV_5 (9, "KYV-5"),
    /** Link 11 KG-40A-P (NTDS) */
    LINK_11_KG_40A_P_NTDS (10, "Link 11 KG-40A-P (NTDS)"),
    /** Link 11B KG-40A-S */
    LINK_11B_KG_40A_S (11, "Link 11B KG-40A-S"),
    /** Link 11 KG-40AR */
    LINK_11_KG_40AR (12, "Link 11 KG-40AR"),
    /** KGV-135A */
    KGV_135A (13, "KGV-135A");

    private int value;
    private final String description;

    TransmitterCryptoSystem(int value, String description)
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
      return 16;
    }

    public static TransmitterCryptoSystem getEnumForValue(int i)
    {
       for(TransmitterCryptoSystem val: TransmitterCryptoSystem.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterCryptoSystem");
       return null;
    }


    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    public void marshal(ByteBuffer buff) throws Exception
    {
        buff.putShort((short)getValue());
    }

    public static TransmitterCryptoSystem unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    public static TransmitterCryptoSystem unmarshalEnum (ByteBuffer buff) throws Exception
    {
        return getEnumForValue(buff.getShort());
    }   

    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
    @Override
    public String toString()
    {
        return "TransmitterCryptoSystem: " + name() + ": " + getValue(); 
    }
}
