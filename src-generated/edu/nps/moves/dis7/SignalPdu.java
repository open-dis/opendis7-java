/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.8.4, 7.7.3 Conveys the audio or digital data carried by the simulated radio or intercom transmission.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class SignalPdu extends RadioCommunicationsFamilyPdu implements Serializable
{

    /**
     *
     */
    protected RadioCommsHeader header = new RadioCommsHeader();

  /**
   * encoding scheme used, and enumeration
   */
  protected short encodingScheme;

  /**
   * tdl type uid 178
   */
  protected SignalTDLType tdlType = SignalTDLType.values()[0];

  /**
   * sample rate
   */
  protected int sampleRate;

  /**
   * length of data in bits
   */
  protected Short dataLength;

  /**
   * number of samples
   */
  protected short samples;

  /**
   * list of eight bit values
   */
  protected byte[] data = new byte[1];  // Wireshark complains if no data

  private byte[] padTo32 = new byte[0]; // pad to 32-bit boundary

  /**
   * Constructor
   */
  public SignalPdu()
  {
    setPduType(DISPDUType.SIGNAL);
  }

  /**
   * Returns the size of this serialized object in bytes
   */
  @Override
  public int getMarshalledSize()
  {
    int marshalSize = 0;

    marshalSize = super.getMarshalledSize();
    marshalSize += header.getMarshalledSize();
    marshalSize += 2;  // encodingScheme
    marshalSize += tdlType.getMarshalledSize();
    marshalSize += 4;  // sampleRate
    marshalSize += 2;  // dataLength
    marshalSize += 2;  // samples
    marshalSize += data.length;
    marshalSize += padTo32.length;

    return marshalSize;
  }

  /**
   * Setter for {@link SignalPdu#header}
   */
  public SignalPdu setHeader(RadioCommsHeader pHeader)
  {
    header = pHeader;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#header}
   */
  public RadioCommsHeader getHeader()
  {
    return header;
  }

  /**
   * Setter for {@link SignalPdu#encodingScheme}
   */
  public SignalPdu setEncodingScheme(short pEncodingScheme)
  {
    encodingScheme = pEncodingScheme;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#encodingScheme}
   */
  public short getEncodingScheme()
  {
    return encodingScheme;
  }

  /**
   * Setter for {@link SignalPdu#tdlType}
   *
   * @return this object
   */
  public SignalPdu setTdlType(SignalTDLType pTdlType)
  {
    tdlType = pTdlType;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#tdlType}
   */
  public SignalTDLType getTdlType()
  {
    return tdlType;
  }

  /**
   * Setter for {@link SignalPdu#sampleRate}
   *
   * @return this object
   */
  public SignalPdu setSampleRate(int pSampleRate)
  {
    sampleRate = pSampleRate;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#sampleRate}
   */
  public int getSampleRate()
  {
    return sampleRate;
  }

  /**
   * Setter for {@link SignalPdu#dataLength}
   * <p>
   * This value is the size IN BITS of the {@link SignalPdu#dataLength} field. Since that field
   * is a byte array, its size must be large enough to contain the specified number of bits. If this size is NOT
   * set and this pdu is issued (marshaled), the value used for this field will be the size of the byte
   * array times 8.
   *
   * @param pDataLength value for field
   * @return this object
   */
  public SignalPdu setDataLength(short pDataLength)
  {
    dataLength = pDataLength;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#dataLength}
   *
   * @return value of field
   */
  public short getDataLength()
  {
    return dataLength;
  }

  /**
   * Setter for {@link SignalPdu#samples}
   *
   * @param pSamples value for field
   * @return this object
   */
  public SignalPdu setSamples(short pSamples)
  {
    samples = pSamples;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#samples}
   *
   * @return value of field
   */
  public short getSamples()
  {
    return samples;
  }

  /**
   * Setter for {@link SignalPdu#data}
   * <p>
   * This is described in the specification as a stream of bits, but is implemented in Java as a byte array.
   * The size of the byte array reflects the value of {@link SignalPdu#dataLength} rounded to the next
   * highest byte boundary. If {@link SignalPdu#dataLength} is not set when the Pdu is sent, the
   * receiver will read a bit length equal to the size of the byte array times 8.
   *
   * @return this object
   * @param pData data
   */
  public SignalPdu setData(byte[] pData)
  {
    data = pData;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#data}
   *
   * @return value of field
   */
  public byte[] getData()
  {
    return data;
  }

  /* *************************** */
  /* Marshal / unmarshal methods */
  /* *************************** */
  
  /**
   * Serializes an object to a DataOutputStream.
   *
   * @see java.io.DataOutputStream
   * @param dos The DataOutputStream
   */
  @Override
  public void marshal(DataOutputStream dos) throws Exception
  {
    super.marshal(dos);

    header.marshal(dos);
    dos.writeShort(encodingScheme);
    tdlType.marshal(dos);
    dos.writeInt(sampleRate);

    if (dataLength != null)
      dos.writeShort(dataLength);
    else
      dos.writeShort((dataLength = calculateDataLength()));

    dos.writeShort(samples);
    for (int idx = 0; idx < data.length; idx++) {
      dos.writeByte(data[idx]);
    }
    padTo32 = new byte[Align.to32bits(dos)];

  }

  /**
   * Unserializes an object from a DataInputStream.
   *
   * @see java.io.DataInputStream
   * @param dis The DataInputStream
   * @return marshaled size
   */
  @Override
  public int unmarshal(DataInputStream dis) throws Exception
  {
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    uPosition += header.unmarshal(dis);
    encodingScheme = (short) dis.readUnsignedShort();
    uPosition += 2;
    tdlType = SignalTDLType.unmarshalEnum(dis);
    uPosition += tdlType.getMarshalledSize();
    sampleRate = dis.readInt();
    uPosition += 4;
    dataLength = (short) dis.readUnsignedShort();
    int byteLength = (dataLength + 7) / 8;
    data = new byte[byteLength];
    uPosition += 2;
    samples = (short) dis.readUnsignedShort();
    uPosition += 2;
    
    for (int idx = 0; idx < byteLength; idx++) {
      data[idx] = dis.readByte();
    }
    uPosition += (data.length * 1);
    padTo32 = new byte[Align.from32bits(uPosition, dis)];
    //uPosition += padTo32.length;

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
  @Override
  public void marshal(java.nio.ByteBuffer buff) throws Exception
  {
    super.marshal(buff);
    header.marshal(buff);
    buff.putShort(encodingScheme);
    tdlType.marshal(buff);
    buff.putInt(sampleRate);
    
    if(dataLength != null)
      buff.putShort(dataLength);
    else
      buff.putShort((dataLength = calculateDataLength()));
    
    buff.putShort(samples);

    for (int idx = 0; idx < data.length; idx++) {
      buff.put(data[idx]);
    }

    padTo32 = new byte[Align.to32bits(buff)];
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
  @Override
  public int unmarshal(java.nio.ByteBuffer buff) throws Exception
  {
    super.unmarshal(buff);

    header.unmarshal(buff);
    encodingScheme = (short) (buff.getShort() & 0xFFFF);
    tdlType = SignalTDLType.unmarshalEnum(buff);
    sampleRate = buff.getInt();
    dataLength = (short) (buff.getShort() & 0xFFFF);
    int byteLength = (dataLength+7)/8;
    data = new byte[byteLength];
    samples = (short) (buff.getShort() & 0xFFFF);
    for (int idx = 0; idx < byteLength; idx++) {
      data[idx] = buff.get();
    }
    padTo32 = new byte[Align.from32bits(buff)];
    return getMarshalledSize();
  }

  private short calculateDataLength()
  {
    return (short) (data.length * 8);
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

  @Override
  public boolean equalsImpl(Object obj)
  {
    boolean ivarsEqual = true;

    if (!(obj instanceof SignalPdu))
      return false;

    final SignalPdu rhs = (SignalPdu) obj;

    if (!(header.equals(rhs.header)))
      ivarsEqual = false;
    if (!(encodingScheme == rhs.encodingScheme))
      ivarsEqual = false;
    if (!(tdlType == rhs.tdlType))
      ivarsEqual = false;
    if (!(sampleRate == rhs.sampleRate))
      ivarsEqual = false;
    if (!(dataLength.equals(rhs.dataLength)))
      ivarsEqual = false;
    if (!(samples == rhs.samples))
      ivarsEqual = false;

    for (int idx = 0; idx < 0; idx++) {
      if (!(data[idx] == rhs.data[idx]))
        ivarsEqual = false;
    }

    return ivarsEqual && super.equalsImpl(rhs);
  }
} // end of class
