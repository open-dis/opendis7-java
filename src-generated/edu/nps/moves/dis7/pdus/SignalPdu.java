/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7.pdus;

import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.8.4, 7.7.3 Conveys the audio or digital data carried by the simulated radio or intercom transmission.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class SignalPdu extends RadioCommunicationsFamilyPdu implements Serializable
{

  /**
   * Radio communications header
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

  /** bit padding */
  private byte[] padTo32 = new byte[0]; // pad to 32-bit boundary

  /**
   * Constructor
   */
  public SignalPdu()
  {
    setPduType(DisPduType.SIGNAL);
  }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
  @Override
  public synchronized int getMarshalledSize()
  {
    int marshalSize = super.getMarshalledSize();
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
   * @param pHeader value of interest
   * @return same object to permit progressive setters
   */
  public SignalPdu setHeader(RadioCommsHeader pHeader)
  {
    header = pHeader;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#header}
   * @return header
   */
  public RadioCommsHeader getHeader()
  {
    return header;
  }

  /**
   * Setter for {@link SignalPdu#encodingScheme}
   * @param pEncodingScheme value of interest
   * @return same object to permit progressive setters
   */
  public SignalPdu setEncodingScheme(short pEncodingScheme)
  {
    encodingScheme = pEncodingScheme;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#encodingScheme}
   * @return encodingScheme
   */
  public short getEncodingScheme()
  {
    return encodingScheme;
  }

  /**
   * Setter for {@link SignalPdu#tdlType}
   *
   * @param pTdlType of interest
   * @return same object to permit progressive setters
   */
  public SignalPdu setTdlType(SignalTDLType pTdlType)
  {
    tdlType = pTdlType;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#tdlType}
   * @return value of interest
   */
  public SignalTDLType getTdlType()
  {
    return tdlType;
  }

  /**
   * Setter for {@link SignalPdu#sampleRate}
   *
   * @param pSampleRate of interest
   * @return same object to permit progressive setters
   */
  public SignalPdu setSampleRate(int pSampleRate)
  {
    sampleRate = pSampleRate;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#sampleRate}
   * @return sampleRate
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
   * @return same object to permit progressive setters
   */
  public synchronized SignalPdu setDataLength(short pDataLength)
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
   * @return same object to permit progressive setters
   */
  public synchronized SignalPdu setSamples(short pSamples)
  {
    samples = pSamples;
    return this;
  }

  /**
   * Getter for {@link SignalPdu#samples}
   *
   * @return value of field
   */
  public synchronized short getSamples()
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
   * @param pData data of interest
   * @return same object to permit progressive setters
   */
  public synchronized SignalPdu setData(byte[] pData)
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
  public synchronized void marshal(DataOutputStream dos) throws Exception
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
   * Deserializes an object from a DataInputStream.
   * @param dis DataInputStream
   * @see java.io.DataInputStream
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return marshalled serialized size in bytes
   */
  @Override
  public synchronized int unmarshal(DataInputStream dis) throws Exception
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
   * @param byteBuffer The ByteBuffer at the position to begin writing
   * @throws Exception ByteBuffer-generated exception
   */
  @Override
  public synchronized void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
  {
    super.marshal(byteBuffer);
    header.marshal(byteBuffer);
    byteBuffer.putShort(encodingScheme);
    tdlType.marshal(byteBuffer);
    byteBuffer.putInt(sampleRate);
    
    if(dataLength != null)
      byteBuffer.putShort(dataLength);
    else
      byteBuffer.putShort((dataLength = calculateDataLength()));
    
    byteBuffer.putShort(samples);

    for (int idx = 0; idx < data.length; idx++) {
      byteBuffer.put(data[idx]);
    }
    byteBuffer.flip(); // will cause BufferOverflowException if we don't flip here
    padTo32 = new byte[Align.to32bits(byteBuffer)];
  }

  /**
   * Unpacks a Pdu from the underlying data.
   *
   * @throws java.nio.BufferUnderflowException if buff is too small
   * @see java.nio.ByteBuffer
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @param byteBuffer The ByteBuffer at the position to begin reading
   * @return marshalled serialized size in bytes
   * @throws Exception ByteBuffer-generated exception
   */
  @Override
  public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
  {
    super.unmarshal(byteBuffer);

    header.unmarshal(byteBuffer);
    encodingScheme = (short) (byteBuffer.getShort() & 0xFFFF);
    tdlType = SignalTDLType.unmarshalEnum(byteBuffer);
    sampleRate = byteBuffer.getInt();
    dataLength = (short) (byteBuffer.getShort() & 0xFFFF);
    int byteLength = (dataLength+7)/8;
    data = new byte[byteLength];
    samples = (short) (byteBuffer.getShort() & 0xFFFF);
    for (int idx = 0; idx < byteLength; idx++) {
      data[idx] = byteBuffer.get();
    }
    byteBuffer.flip(); // will cause BufferUnderflowException if we don't flip here
    padTo32 = new byte[Align.from32bits(byteBuffer)];
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
  public synchronized boolean equals(Object obj)
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
  public synchronized boolean equalsImpl(Object obj)
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
