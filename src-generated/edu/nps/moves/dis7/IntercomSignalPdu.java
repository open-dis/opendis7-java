/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */
package edu.nps.moves.dis7;

import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.8.6 Conveys the audio or digital data that is used to communicate between simulated intercom devices
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class IntercomSignalPdu extends RadioCommunicationsFamilyPdu implements Serializable
{

    /**
     *
     */
    protected IntercomReferenceID intercomReferenceID = new IntercomReferenceID();

  /**
   * ID of communications device
   */
  protected short intercomNumber;

  /**
   * encoding scheme
   */
  protected short encodingScheme;

  /**
   * tactical data link type uid 178
   */
  protected SignalTDLType tdlType = SignalTDLType.values()[0];

  /**
   * sample rate
   */
  protected int sampleRate;

  /**
   * data length
   */
  protected Short dataLength;

  /**
   * samples
   */
  protected short samples;

  /**
   * data bytes
   */
  protected byte[] data = new byte[1]; //Wireshark complains if no data 

  private byte[] padTo32 = new byte[0]; // pad to 32-bit boundary

  /**
   * Constructor
   */
  public IntercomSignalPdu()
  {
    setPduType(DISPDUType.INTERCOM_SIGNAL);
  }

  /**
   * Returns the size of this serialized object in bytes
   * @return size in bytes
   */
  @Override
  public int getMarshalledSize()
  {
    int marshalSize = super.getMarshalledSize();
    marshalSize += intercomReferenceID.getMarshalledSize();
    marshalSize += 2;  // intercomNumber
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
   * Setter for {@link IntercomSignalPdu#intercomReferenceID}
   * @param pIntercomReferenceID
   * @return 
   */
  public IntercomSignalPdu setIntercomReferenceID(IntercomReferenceID pIntercomReferenceID)
  {
    intercomReferenceID = pIntercomReferenceID;
    return this;
  }

  /**
   * Getter for {@link IntercomSignalPdu#intercomReferenceID}
   * @return 
   */
  public IntercomReferenceID getIntercomReferenceID()
  {
    return intercomReferenceID;
  }

  /**
   * Setter for {@link IntercomSignalPdu#intercomNumber}
   * @param pIntercomNumber
   * @return 
   */
  public IntercomSignalPdu setIntercomNumber(short pIntercomNumber)
  {
    intercomNumber = pIntercomNumber;
    return this;
  }

  /**
   * Getter for {@link IntercomSignalPdu#intercomNumber}
   * @return 
   */
  public short getIntercomNumber()
  {
    return intercomNumber;
  }

  /**
   * Setter for {@link IntercomSignalPdu#encodingScheme}
   * @param pEncodingScheme
   * @return 
   */
  public IntercomSignalPdu setEncodingScheme(short pEncodingScheme)
  {
    encodingScheme = pEncodingScheme;
    return this;
  }

  /**
   * Getter for {@link IntercomSignalPdu#encodingScheme}
   * @return 
   */
  public short getEncodingScheme()
  {
    return encodingScheme;
  }

  /**
   * Setter for {@link IntercomSignalPdu#tdlType}
   * @param pTdlType
   * @return 
   */
  public IntercomSignalPdu setTdlType(SignalTDLType pTdlType)
  {
    tdlType = pTdlType;
    return this;
  }

  /**
   * Getter for {@link IntercomSignalPdu#tdlType}
   * @return 
   */
  public SignalTDLType getTdlType()
  {
    return tdlType;
  }

  /**
   * Setter for {@link IntercomSignalPdu#sampleRate}
   * @param pSampleRate
   * @return 
   */
  public IntercomSignalPdu setSampleRate(int pSampleRate)
  {
    sampleRate = pSampleRate;
    return this;
  }

  /**
   * Getter for {@link IntercomSignalPdu#sampleRate}
   * @return 
   */
  public int getSampleRate()
  {
    return sampleRate;
  }

  /**
   * Setter for {@link IntercomSignalPdu#dataLength}
   * <p>
   * This value is the size IN BITS of the {@link IntercomSignalPdu#dataLength} field. Since that field
   * is a byte array, its size must be large enough to contain the specified number of bits. If this size is NOT
   * set and this pdu is issued (marshaled), the value used for this field will be the size of the byte
   * array times 8.
   *
   * @param pDataLength value for field
   * @return this object
   */
  public IntercomSignalPdu setDataLength(short pDataLength)
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
   * Setter for {@link IntercomSignalPdu#samples}
   * @param pSamples
   * @return 
   */
  public IntercomSignalPdu setSamples(short pSamples)
  {
    samples = pSamples;
    return this;
  }

  /**
   * Getter for {@link IntercomSignalPdu#samples}
   * @return 
   */
  public short getSamples()
  {
    return samples;
  }

  /**
   * Setter for {@link IntercomSignalPdu#data}
   * @param pData
   * @return 
   */
  public IntercomSignalPdu setData(byte[] pData)
  {
    data = pData;
    return this;
  }

  /**
   * Getter for {@link IntercomSignalPdu#data}
   * @return 
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
     * @throws java.lang.Exception
   * @see java.io.DataOutputStream
   * @param dos The DataOutputStream
   */
  @Override
  public void marshal(DataOutputStream dos) throws Exception
  {
    super.marshal(dos);
    try {
      intercomReferenceID.marshal(dos);
      dos.writeShort(intercomNumber);
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
    catch (Exception e) {
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
  @Override
  public int unmarshal(DataInputStream dis) throws Exception
  {
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    uPosition += intercomReferenceID.unmarshal(dis);
    intercomNumber = (short) dis.readUnsignedShort();
    uPosition += 2;
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
    intercomReferenceID.marshal(buff);
    buff.putShort(intercomNumber);
    buff.putShort(encodingScheme);
    tdlType.marshal(buff);
    buff.putInt(sampleRate);

    if (dataLength != null)
      buff.putShort(dataLength);
    else
      buff.putShort((dataLength = calculateDataLength()));

    buff.putShort(samples);

    for (int idx = 0; idx < data.length; idx++) {
      buff.put(data[idx]);
    }
    buff.flip(); // will cause BufferOverflowException if we don't flip here
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

    intercomReferenceID.unmarshal(buff);
    intercomNumber = (short) (buff.getShort() & 0xFFFF);
    encodingScheme = (short) (buff.getShort() & 0xFFFF);
    tdlType = SignalTDLType.unmarshalEnum(buff);
    sampleRate = buff.getInt();
    dataLength = (short) (buff.getShort() & 0xFFFF);
    int byteLength = (dataLength + 7) / 8;
    data = new byte[byteLength];
    samples = (short) (buff.getShort() & 0xFFFF);
    for (int idx = 0; idx < byteLength; idx++) {
      data[idx] = buff.get();
    }
    buff.flip(); // will cause BufferUnderflowException if we don't flip here
    padTo32 = new byte[Align.from32bits(buff)];
    return getMarshalledSize();
  }

  private short calculateDataLength()
  {
    return (short) (data.length * 8);
  }

  /*
  * Override of default equals method.  Calls equalsImpl() for content comparison.
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

    final IntercomSignalPdu rhs = (IntercomSignalPdu) obj;

    if (!(intercomReferenceID.equals(rhs.intercomReferenceID)))
      ivarsEqual = false;
    if (!(intercomNumber == rhs.intercomNumber))
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
