package edu.nps.moves.dis7.enumerations;

import java.nio.ByteBuffer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import edu.nps.moves.dis7.pdus.*;

/**
 * Generated from XML, <br>
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

    /** Constructor */
    TransmitterCryptoSystem(int value, String description)
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
      return 16;
    }

    /** provide enumeration for a given value
     * @param i integer value of interest
     * @return enumeration corresponding to numeric value
     */
    public static TransmitterCryptoSystem getEnumForValue(int i)
    {
       for(TransmitterCryptoSystem val: TransmitterCryptoSystem.values()) {
          if(val.getValue()==i)
              return val;
       }
       System.out.flush(); // ensure contiguous console outputs
       System.err.println("No enumeration found for value " + i + " of enumeration TransmitterCryptoSystem");
       System.err.flush(); // ensure contiguous console outputs
       return null;
    }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
        dos.writeShort(getValue());
    }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for output
     * @throws IOException input-output error */
    public void marshal(ByteBuffer byteBuffer) throws Exception
    {
        byteBuffer.putShort((short)getValue());
    }
    /** Unmarshal value to DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dis DataInputStream for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static TransmitterCryptoSystem unmarshalEnum (DataInputStream dis) throws Exception
    {
        return getEnumForValue(dis.readUnsignedShort());
    } 

    /** Unmarshal enumeration value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer ByteBuffer for input
     * @throws Exception unmarshalling input-output error
     * @return enumeration of interest */
    public static TransmitterCryptoSystem unmarshalEnum (ByteBuffer byteBuffer) throws Exception
    {
        return getEnumForValue(byteBuffer.getShort());
    }   

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
    public int getMarshalledSize()
    {
        return 2; // 16 bits
    }
    
  /**
   * Provide simple identifier
   * @return ID number and name
   */
    @Override
    public String toString()
    {
        return "TransmitterCryptoSystem " + getValue() + " " + name(); 
    }
}
