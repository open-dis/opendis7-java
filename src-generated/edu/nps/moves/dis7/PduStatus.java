/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

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
  public static byte TEI_NO_DIFFERENCE = (byte) 0b00000000; // bit 0
  public static byte TEI_DIFFERENCE = (byte) 0b00000001;

  public static byte LVC_NO_STATEMENT = (byte) 0b00000000; // bits 1-2
  public static byte LVC_LIVE = (byte) 0b00000010;
  public static byte LVC_VIRTUAL = (byte) 0b00000100;
  public static byte LVC_CONSTRUCTIVE = (byte) 0b00000110;

  public static byte CEI_NOT_COUPLED = (byte) 0b00000000; // bit 3
  public static byte CEI_COUPLED = (byte) 0b00001000;

  public static byte FTI_MUNITION = (byte) 0b00000000; // bit 4
  public static byte FTI_EXPENDABLE = (byte) 0b00010000;

  public static byte DTI_MUNITION = (byte) 0b00000000; // bits 4-5 
  public static byte DTI_EXPENDABLE = (byte) 0b00010000;
  public static byte DTI_NON_MUNITION_EXPLOSION = (byte) 0b00100000;

  public static byte RAI_NO_STATEMENT = (byte) 0b00000000; // bits 4-5
  public static byte RAI_UNATTACHED = (byte) 0b00010000;
  public static byte RAI_ATTACHED = (byte) 0b00100000;

  public static byte IAI_NOSTATEMENT = (byte) 0b00000000; // bits 4-5
  public static byte IAI_UNATTACHED = (byte) 0b00010000;
  public static byte IAI_ATTACHED = (byte) 0b00100000;

  public static byte ISM_REGENERATION = (byte) 0b00000000; // bit 4
  public static byte ISM_INTERACTIVE = (byte) 0b00010000;

  public static byte AII_NOT_ACTIVE = (byte) 0b00000000; // bit 5
  public static byte AII_ACTIVE = (byte) 0b00100000;

  private byte value = 0;

  public PduStatus()
  {
  }

  public PduStatus(byte b)
  {
    value = b;
  }

  public void setValue(byte b)
  {
    value = b;
  }

  public byte getValue()
  {
    return value;
  }

  public byte orTo(byte b)
  {
    value |= b;
    return value;
  }

  public int getMarshalledSize()
  {
    return 1;
  }

  public void marshal(DataOutputStream dos) throws IOException
  {
    dos.writeByte(value);
  }

  public int unmarshal(DataInputStream dis) throws IOException
  {
    value = dis.readByte();
    return 1;
  }

  public void marshal(ByteBuffer buff)
  {
    buff.put(value);
  }

  public int unmarshal(ByteBuffer buff)
  {
    value = buff.get();
    return 1;
  }

  @Override
  public boolean equals(Object obj)
  {
    return obj instanceof PduStatus && ((PduStatus) obj).getValue() == getValue();
  }
  
  @Override
  public String toString()
  {
    return "PduStatus: "+ Integer.toBinaryString(getValue()+256).substring(1); // dont want to lose leading zeros
  }
}
