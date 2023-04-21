/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.pdus;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * PduStatus.java, section 6.2.67
 * <p>
 * Sample use:
 * import static edu.nps.moves.dis7.PduStatus.*;
 * All pdus:
 * PduStatus stat = new PduStatus((byte)(CEI_COUPLED | LVC_LIVE));
 * EntityState pdu:
 * PduStatus stat = new PduStatus();
 * stat.setValue((byte)(CEI_NOT_COUPLED | LVC_VIRTUAL | TEI_NO_DIFFERENCE));
 *
 * @author Mike Bailey, jmbailey@nps.edu
 * @version $Id$
 */
public class PduStatus
{
  /** PduStatus bit mask */
  public static byte TEI_NO_DIFFERENCE = (byte) 0b00000000; // bit 0
  /** PduStatus bit mask */
  public static byte TEI_DIFFERENCE = (byte) 0b00000001;

  /** PduStatus bit mask */
  public static byte LVC_NO_STATEMENT = (byte) 0b00000000; // bits 1-2
  /** PduStatus bit mask */
  public static byte LVC_LIVE = (byte) 0b00000010;
  /** PduStatus bit mask */
  public static byte LVC_VIRTUAL = (byte) 0b00000100;
  /** PduStatus bit mask */
  public static byte LVC_CONSTRUCTIVE = (byte) 0b00000110;

  /** PduStatus bit mask */
  public static byte CEI_NOT_COUPLED = (byte) 0b00000000; // bit 3
  /** PduStatus bit mask */
  public static byte CEI_COUPLED = (byte) 0b00001000;

  /** PduStatus bit mask */
  public static byte FTI_MUNITION = (byte) 0b00000000; // bit 4
  /** PduStatus bit mask */
  public static byte FTI_EXPENDABLE = (byte) 0b00010000;

  /** PduStatus bit mask */
  public static byte DTI_MUNITION = (byte) 0b00000000; // bits 4-5
  /** PduStatus bit mask */
  public static byte DTI_EXPENDABLE = (byte) 0b00010000;
  /** PduStatus bit mask */
  public static byte DTI_NON_MUNITION_EXPLOSION = (byte) 0b00100000;

  /** PduStatus bit mask */
  public static byte RAI_NO_STATEMENT = (byte) 0b00000000; // bits 4-5
  /** PduStatus bit mask */
  public static byte RAI_UNATTACHED = (byte) 0b00010000;
  /** PduStatus bit mask */
  public static byte RAI_ATTACHED = (byte) 0b00100000;

  /** PduStatus bit mask */
  public static byte IAI_NOSTATEMENT = (byte) 0b00000000; // bits 4-5
  /** PduStatus bit mask */
  public static byte IAI_UNATTACHED = (byte) 0b00010000;
  /** PduStatus bit mask */
  public static byte IAI_ATTACHED = (byte) 0b00100000;

  /** PduStatus bit mask */
  public static byte ISM_REGENERATION = (byte) 0b00000000; // bit 4
  /** PduStatus bit mask */
  public static byte ISM_INTERACTIVE = (byte) 0b00010000;

  /** PduStatus bit mask */
  public static byte AII_NOT_ACTIVE = (byte) 0b00000000; // bit 5
  /** PduStatus bit mask */
  public static byte AII_ACTIVE = (byte) 0b00100000;

  private byte value = 0;

  /** Constructor */
  public PduStatus()
  {
  }

    /**
     * Constructor
     * @param byteValue byte value of interest
     */
    public PduStatus(byte byteValue)
    {
      value = byteValue;
    }

    /**
     * Accessor method to set value
     * @param byteValue byte value of interest
     */
    public void setValue(byte byteValue)
    {
      value = byteValue;
    }

    /**
     * Accessor method to get value
     * @return byteValue byte value of interest
     */
    public byte getValue()
    {
      return value;
    }

    /**
     * Apply | "or" operator using mask
     * @param orMask mask to apply
     * @return resulting value
     */
    public byte orTo(byte orMask)
    {
      value |= orMask;
      return value;
    }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
  public int getMarshalledSize()
  {
    return 1;
  }

    /** Marshal value to DataOutputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param dos DataOutputStream for output
     * @throws java.io.IOException input-output error */
    public void marshal(DataOutputStream dos) throws IOException
    {
      dos.writeByte(value);
    }

    /**
     * Deserializes an object from a DataInputStream.
     * @param dis DataInputStream
     * @see java.io.DataInputStream
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @return marshalled serialized size in bytes
     * @throws IOException in case something goes wrong
     */
  public int unmarshal(DataInputStream dis) throws IOException
  {
    value = dis.readByte();
    return 1;
  }

    /** Marshal value to ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @see <a href="https://en.wikipedia.org/wiki/Endianness" target="_blank">https://en.wikipedia.org/wiki/Endianness</a>
     * @param byteBuffer to receive result */
    public void marshal(ByteBuffer byteBuffer)
    {
      byteBuffer.put(value);
    }

    /**
     * Unpacks a Pdu from the underlying data.
     *
     * @see java.nio.ByteBuffer
     * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
     * @param byteBuffer The ByteBuffer at the position to begin writing
     * @return marshalled serialized size in bytes
     */
    public int unmarshal(ByteBuffer byteBuffer)
    {
      value = byteBuffer.get();
      return 1;
    }

    /**
     * Object equality comparison
     * @param obj object to compare
     * @return result
     */
    @Override
    public boolean equals(Object obj)
    {
      return obj instanceof PduStatus && ((PduStatus) obj).getValue() == getValue();
    }
  
    /**
     * Provide string representation of this object
     * @return string representation of this object
     */
    @Override
  public String toString()
  {
    return "PduStatus: "+ Integer.toBinaryString(getValue()+256).substring(1); // dont want to lose leading zeros
  }
}
