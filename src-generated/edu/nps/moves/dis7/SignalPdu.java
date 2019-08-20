/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.8.4 Conveys the audio or digital data carried by the simulated radio or intercom transmission.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class SignalPdu extends RadioCommunicationsFamilyPdu implements Serializable
{
   protected RadioCommsHeader  header = new RadioCommsHeader(); 

   /** encoding scheme used, and enumeration */
   protected short  encodingScheme;

   /** tdl type uid 178 */
   protected SignalTDLType tdlType = SignalTDLType.values()[0];

   /** sample rate */
   protected int  sampleRate;

   /** length of data in bits */
   protected short  dataLength;

   /** number of samples */
   protected short  samples;

   /** list of eight bit values */
   protected byte[]  data = new byte[0]; 

   private byte[] padTo32 = new byte[0]; // pad to 32-bit boundary


/** Constructor */
 public SignalPdu()
 {
    setPduType( DISPDUType.SIGNAL );
 }

/** Returns the size of this serialized object in bytes*/
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
   marshalSize += data.length * 1;
   marshalSize += padTo32.length;

   return marshalSize;
}


/** Setter for {@link SignalPdu#header}*/
public SignalPdu setHeader(RadioCommsHeader pHeader)
{
    header = pHeader;
    return this;
}

/** Getter for {@link SignalPdu#header}*/
public RadioCommsHeader getHeader()
{
    return header; 
}

/** Setter for {@link SignalPdu#encodingScheme}*/
public SignalPdu setEncodingScheme(short pEncodingScheme)
{
    encodingScheme = pEncodingScheme;
    return this;
}

/** Getter for {@link SignalPdu#encodingScheme}*/
public short getEncodingScheme()
{
    return encodingScheme; 
}

/** Setter for {@link SignalPdu#tdlType}*/
public SignalPdu setTdlType(SignalTDLType pTdlType)
{
    tdlType = pTdlType;
    return this;
}

/** Getter for {@link SignalPdu#tdlType}*/
public SignalTDLType getTdlType()
{
    return tdlType; 
}

/** Setter for {@link SignalPdu#sampleRate}*/
public SignalPdu setSampleRate(int pSampleRate)
{
    sampleRate = pSampleRate;
    return this;
}

/** Getter for {@link SignalPdu#sampleRate}*/
public int getSampleRate()
{
    return sampleRate; 
}

/** Setter for {@link SignalPdu#dataLength}*/
public SignalPdu setDataLength(short pDataLength)
{
    dataLength = pDataLength;
    return this;
}

/** Getter for {@link SignalPdu#dataLength}*/
public short getDataLength()
{
    return dataLength; 
}

/** Setter for {@link SignalPdu#samples}*/
public SignalPdu setSamples(short pSamples)
{
    samples = pSamples;
    return this;
}

/** Getter for {@link SignalPdu#samples}*/
public short getSamples()
{
    return samples; 
}

/** Setter for {@link SignalPdu#data}*/
public SignalPdu setData(byte[] pData)
{
    data = pData;
    return this;
}

/** Getter for {@link SignalPdu#data}*/
public byte[] getData()
{
    return data; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       header.marshal(dos);
       dos.writeShort( (short)encodingScheme);
       tdlType.marshal(dos);
       dos.writeInt( (int)sampleRate);
       dos.writeShort( (short)dataLength);
       dos.writeShort( (short)samples);

       for(int idx = 0; idx < data.length; idx++)
           dos.writeByte(data[idx]);

       padTo32 = new byte[Align.to32bits(dos)];
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
}

/**
 * Unserializes an object from a DataInputStream.
 * @see java.io.DataInputStream
 * @param dis The DataInputStream
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += header.unmarshal(dis);
        encodingScheme = (short)dis.readUnsignedShort();
        uPosition += 2;
        tdlType = SignalTDLType.unmarshalEnum(dis);
        uPosition += tdlType.getMarshalledSize();
        sampleRate = dis.readInt();
        uPosition += 4;
        dataLength = (short)dis.readUnsignedShort();
        uPosition += 2;
        samples = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < data.length; idx++)
            data[idx] = dis.readByte(); // mike check
        uPosition += data.length; // todo, multiply by prim size mike
        padTo32 = new byte[Align.from32bits(uPosition,dis)];
        uPosition += padTo32.length;
    }
    catch(Exception e)
    { 
      System.out.println(e); 
    }
    return getMarshalledSize();
}

/**
 * Packs an object into the ByteBuffer.
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   super.marshal(buff);
   header.marshal(buff);
   buff.putShort( (short)encodingScheme);
   tdlType.marshal(buff);
   buff.putInt( (int)sampleRate);
   buff.putShort( (short)dataLength);
   buff.putShort( (short)samples);

   for(int idx = 0; idx < data.length; idx++)
       buff.put((byte)data[idx]);

   padTo32 = new byte[Align.to32bits(buff)];
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 * @return marshalled size
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    super.unmarshal(buff);

    header.unmarshal(buff);
    encodingScheme = (short)(buff.getShort() & 0xFFFF);
    tdlType = SignalTDLType.unmarshalEnum(buff);
    sampleRate = buff.getInt();
    dataLength = (short)(buff.getShort() & 0xFFFF);
    samples = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < data.length; idx++)
        data[idx] = buff.get();
    padTo32 = new byte[Align.from32bits(buff)];
    return getMarshalledSize();
}

 /*
  * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
  */
@Override
 public boolean equals(Object obj)
 {
    if(this == obj)
      return true;

    if(obj == null)
       return false;

    if(getClass() != obj.getClass())
        return false;

    return equalsImpl(obj);
 }

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof SignalPdu))
        return false;

     final SignalPdu rhs = (SignalPdu)obj;

     if( ! (header.equals( rhs.header) )) ivarsEqual = false;
     if( ! (encodingScheme == rhs.encodingScheme)) ivarsEqual = false;
     if( ! (tdlType == rhs.tdlType)) ivarsEqual = false;
     if( ! (sampleRate == rhs.sampleRate)) ivarsEqual = false;
     if( ! (dataLength == rhs.dataLength)) ivarsEqual = false;
     if( ! (samples == rhs.samples)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(data[idx] == rhs.data[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
