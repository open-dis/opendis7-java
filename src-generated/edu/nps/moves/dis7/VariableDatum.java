/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * the variable datum type, the datum length, and the value for that variable datum type. Section 6.2.93
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class VariableDatum extends Object implements Serializable
{
  /**
   * Type of variable datum to be transmitted. 32 bit enumeration defined in EBV uid 66
   */
  protected VariableRecordType variableDatumID = VariableRecordType.values()[0];

  /**
   * Length, IN BITS, of the variable datum.
   */
  protected Integer variableDatumLength;

  /**
   * This field shall specify the value for a particular Variable Datum ID. The
   * field format shall depend on the type of datum as specified by the Variable Datum ID. Variable
   * datums can be any number of bits long.
   */
  protected byte[] variableDatumValue = new byte[0];

  private byte[] padding = new byte[0]; // pad to 64-bit boundary

  /**
   * @return the size of this serialized object in bytes
   */
  public int getMarshalledSize()
  {
    int marshalSize = 0;

    marshalSize += variableDatumID.getMarshalledSize();
    marshalSize += 4;  // variableDatumLength
    marshalSize += variableDatumValue.length;
    marshalSize += padding.length;

    return marshalSize;
  }

  /**
   * Setter for {@link VariableDatum#variableDatumID}
   *
   * @param pVariableDatumID
   * @return this object
   */
  public VariableDatum setVariableDatumID(VariableRecordType pVariableDatumID)
  {
    variableDatumID = pVariableDatumID;
    return this;
  }

  /**
   * Getter for {@link VariableDatum#variableDatumID}
   *
   * @return value of field
   */
  public VariableRecordType getVariableDatumID()
  {
    return variableDatumID;
  }

  /**
   * Setter for {@link VariableDatum#variableDatumLength}
   * <p>
   * This value is the size IN BITS of the {@link VariableDatum#variableDatumValue} field. Since that field
   * is a byte array, its size must be large enough to contain the specified number of bits. If
   * {@link VariableDatum#variableDatumValue} is NOT
   * set and this pdu is issued (marshaled), the value used when marshaling this field will be
   * the size of the byte array times 8.
   * @param bitLength
   * @return 
   */
  public VariableDatum setVariableDatumLengthInBits(int bitLength)
  {
    variableDatumLength = bitLength;
    return this;
  }

 /**
   * Setter for {@link VariableDatum#variableDatumLength}
   * <p>
   * This value is the size in bytes of the {@link VariableDatum#variableDatumValue} field. Since that field
   * is a byte array, its size must be large enough to contain the value specified here. If
   * {@link VariableDatum#variableDatumValue} is NOT
   * set and this pdu is issued (marshaled), the value used when marshaling this field will be
   * the size of the byte array times 8.
   * @param byteLength
   * @return 
   */
  public VariableDatum setVariableDatumLengthInBytes(int byteLength)
  {
    variableDatumLength = byteLength * Byte.SIZE;
    return this;
  }
  
  /**
   * Getter for {@link VariableDatum#variableDatumLength}
   * @return 
   */
  public int getVariableDatumLength()
  {
    return variableDatumLength;
  }

  /**
   * Setter for {@link VariableDatum#variableDatumValue}
   * <p>
   * This is described in the specification as a stream of bits, but is implemented in Java as a byte array.
   * The size of the byte array reflects the value of {@link VariableDatum#variableDatumLength} rounded to the next
   * highest byte boundary. If {@link VariableDatum#variableDatumLength} is not set when the Pdu is sent, the
   * receiver will read a bit length equal to the size of the byte array times 8.
   * @param pVariableDatumValue
   * @return this object
   */
  public VariableDatum setVariableDatumValue(byte[] pVariableDatumValue)
  {
    variableDatumValue = pVariableDatumValue;
    return this;
  }

  /**
   * Getter for {@link VariableDatum#variableDatumValue}
   * @return 
   */
  public byte[] getVariableDatumValue()
  {
    return variableDatumValue;
  }

  /* *************************** */
  /* Marshal / unmarshal methods */
  /* *************************** */
  
  /**
   * Serializes an object to a DataOutputStream.
   *
   * @throws java.lang.Exception
   * @see java.io.DataOutputStream
   * @param dos The DataOutputStream
   */
  public void marshal(DataOutputStream dos) throws Exception
  {
    try {
      variableDatumID.marshal(dos);
      if (variableDatumLength != null)
        dos.writeInt(variableDatumLength);
      else
        dos.writeInt(variableDatumLength = calculateDatumLength());

      for (int idx = 0; idx < variableDatumValue.length; idx++) {
        dos.writeByte(variableDatumValue[idx]);
      }

      padding = new byte[Align.to64bits(dos)];
    }
    catch (IOException e) {
      System.err.println(e);
    }
  }

  /**
   * Unserializes an object from a DataInputStream.
   *
   * @throws java.lang.Exception
   * @see java.io.DataInputStream
   * @param dis The DataInputStream
   * @return marshalled size
   */
  public int unmarshal(DataInputStream dis) throws Exception
  {
    int uPosition = 0;
    try {
      variableDatumID = VariableRecordType.unmarshalEnum(dis);
      uPosition += variableDatumID.getMarshalledSize();
      variableDatumLength = dis.readInt();
      int byteLength = (variableDatumLength + 7) / 8;
      variableDatumValue = new byte[byteLength];
      uPosition += 4;
      for (int idx = 0; idx < byteLength; idx++) {
        variableDatumValue[idx] = dis.readByte();
      }
      uPosition += variableDatumLength;
      padding = new byte[Align.from64bits(uPosition, dis)];
      //uPosition += padding.length;
    }
    catch (Exception e) {
      System.out.println(e);
    }
    return getMarshalledSize();
  }

  /**
   * Packs an object into the ByteBuffer.
   *
   * @throws java.nio.BufferOverflowException if buff is too small
   * @throws java.nio.ReadOnlyBufferException if buff is read only
   * @see java.nio.ByteBuffer
   * @param buff The ByteBuffer at the position to begin writing
   * @throws Exception ByteBuffer-generated exception
   */
  public void marshal(java.nio.ByteBuffer buff) throws Exception
  {
    variableDatumID.marshal(buff);

    if (variableDatumLength != null)
      buff.putInt(variableDatumLength);
    else
      buff.putInt(variableDatumLength = calculateDatumLength());
    for (int idx = 0; idx < variableDatumLength; idx++) //for(int idx = 0; idx < variableDatumValue.length; idx++)
    {
      buff.put(variableDatumValue[idx]);
    }
    padding = new byte[Align.to64bits(buff)];
  }

  /**
   * Unpacks a Pdu from the underlying data.
   *
   * @throws java.nio.BufferUnderflowException if buff is too small
   * @see java.nio.ByteBuffer
   * @param buff The ByteBuffer at the position to begin reading
   * @return marshalled size
   * @throws Exception ByteBuffer-generated exception
   */
  public int unmarshal(java.nio.ByteBuffer buff) throws Exception
  {
    variableDatumID = VariableRecordType.unmarshalEnum(buff);
    variableDatumLength = buff.getInt();
    int byteLength = (variableDatumLength + 7) / 8;
    variableDatumValue = new byte[byteLength];
    for (int idx = 0; idx < byteLength; idx++) {
      variableDatumValue[idx] = buff.get();
    }
    padding = new byte[Align.from64bits(buff)];
    return getMarshalledSize();
  }

  private int calculateDatumLength()
  {
    return variableDatumValue.length * 8;
  }

  /*
  * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
   */
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;

    if (obj == null)
      return false;

    if (getClass() != obj.getClass())
      return false;

    return equalsImpl(obj);
  }

  /**
   * Compare all fields that contribute to the state, ignoring
   * transient and static fields, for <code>this</code> and the supplied object
   *
   * @param obj the object to compare to
   * @return true if the objects are equal, false otherwise.
   */
  public boolean equalsImpl(Object obj)
  {
    boolean ivarsEqual = true;

    if (!(obj instanceof VariableDatum))
      return false;

    final VariableDatum rhs = (VariableDatum) obj;

    if (!(variableDatumID == rhs.variableDatumID))
      ivarsEqual = false;
    if (!(variableDatumLength.equals(rhs.variableDatumLength)))
      ivarsEqual = false;
    for (int idx = 0; idx < 0; idx++) {
      if (!(variableDatumValue[idx] == rhs.variableDatumValue[idx]))
        ivarsEqual = false;
    }
    return ivarsEqual;
  }
}
