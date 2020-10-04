/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 6.2.48.2
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class IOCommsNodeRecord extends IORecord implements Serializable
{
   /**  uid 66 */
   protected VariableRecordType recordType = VariableRecordType.IO_COMMUNICATIONS_NODE;

   protected short  recordLength;

   /**  uid 294 */
   protected IOCommsNodeRecordCommsNodeType commsNodeType = IOCommsNodeRecordCommsNodeType.values()[0];

   protected byte  padding;

   protected CommunicationsNodeID  commsNodeId = new CommunicationsNodeID(); 


/** Constructor */
 public IOCommsNodeRecord()
 {
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += recordType.getMarshalledSize();
   marshalSize += 2;  // recordLength
   marshalSize += commsNodeType.getMarshalledSize();
   marshalSize += 1;  // padding
   marshalSize += commsNodeId.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link IOCommsNodeRecord#recordType}
  * @param pRecordType new value of interest
  * @return same object to permit progressive setters */
public IOCommsNodeRecord setRecordType(VariableRecordType pRecordType)
{
    recordType = pRecordType;
    return this;
}

/** Getter for {@link IOCommsNodeRecord#recordType}
  * @return value of interest */
public VariableRecordType getRecordType()
{
    return recordType; 
}

/** Setter for {@link IOCommsNodeRecord#recordLength}
  * @param pRecordLength new value of interest
  * @return same object to permit progressive setters */
public IOCommsNodeRecord setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}
/** Utility setter for {@link IOCommsNodeRecord#recordLength}
  * @param pRecordLength new value of interest
  * @return same object to permit progressive setters */
public IOCommsNodeRecord setRecordLength(int pRecordLength){
    recordLength = (short) pRecordLength;
    return this;
}

/** Getter for {@link IOCommsNodeRecord#recordLength}
  * @return value of interest */
public short getRecordLength()
{
    return recordLength; 
}

/** Setter for {@link IOCommsNodeRecord#commsNodeType}
  * @param pCommsNodeType new value of interest
  * @return same object to permit progressive setters */
public IOCommsNodeRecord setCommsNodeType(IOCommsNodeRecordCommsNodeType pCommsNodeType)
{
    commsNodeType = pCommsNodeType;
    return this;
}

/** Getter for {@link IOCommsNodeRecord#commsNodeType}
  * @return value of interest */
public IOCommsNodeRecordCommsNodeType getCommsNodeType()
{
    return commsNodeType; 
}

/** Setter for {@link IOCommsNodeRecord#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public IOCommsNodeRecord setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}
/** Utility setter for {@link IOCommsNodeRecord#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public IOCommsNodeRecord setPadding(int pPadding){
    padding = (byte) pPadding;
    return this;
}

/** Getter for {@link IOCommsNodeRecord#padding}
  * @return value of interest */
public byte getPadding()
{
    return padding; 
}

/** Setter for {@link IOCommsNodeRecord#commsNodeId}
  * @param pCommsNodeId new value of interest
  * @return same object to permit progressive setters */
public IOCommsNodeRecord setCommsNodeId(CommunicationsNodeID pCommsNodeId)
{
    commsNodeId = pCommsNodeId;
    return this;
}

/** Getter for {@link IOCommsNodeRecord#commsNodeId}
  * @return value of interest */
public CommunicationsNodeID getCommsNodeId()
{
    return commsNodeId; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       recordType.marshal(dos);
       dos.writeShort(recordLength);
       commsNodeType.marshal(dos);
       dos.writeByte(padding);
       commsNodeId.marshal(dos);
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
}

/**
 * Deserializes an object from a DataInputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataInputStream
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        recordType = VariableRecordType.unmarshalEnum(dis);
        uPosition += recordType.getMarshalledSize();
        recordLength = (short)dis.readUnsignedShort();
        uPosition += 2;
        commsNodeType = IOCommsNodeRecordCommsNodeType.unmarshalEnum(dis);
        uPosition += commsNodeType.getMarshalledSize();
        padding = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += commsNodeId.unmarshal(dis);
    }
    catch(Exception e)
    { 
      System.err.println(e); 
    }
    return getMarshalledSize();
}

/**
 * Packs an object into the ByteBuffer.
 * @throws java.nio.BufferOverflowException if byteBuffer is too small
 * @throws java.nio.ReadOnlyBufferException if byteBuffer is read only
 * @see java.nio.ByteBuffer
 * @param byteBuffer The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   super.marshal(byteBuffer);
   recordType.marshal(byteBuffer);
   byteBuffer.putShort( (short)recordLength);
   commsNodeType.marshal(byteBuffer);
   byteBuffer.put( (byte)padding);
   commsNodeId.marshal(byteBuffer);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    recordType = VariableRecordType.unmarshalEnum(byteBuffer);
    recordLength = (short)(byteBuffer.getShort() & 0xFFFF);
    commsNodeType = IOCommsNodeRecordCommsNodeType.unmarshalEnum(byteBuffer);
    padding = (byte)(byteBuffer.get() & 0xFF);
    commsNodeId.unmarshal(byteBuffer);
    return getMarshalledSize();
}

 /*
  * Override of default equals method.  Calls equalsImpl() for content comparison.
  */
@Override
 public boolean equals(Object obj)
 {
    if(this == obj)
      return true;

    if(obj == null)
       return false;

    if(!getClass().isAssignableFrom(obj.getClass())) //if(getClass() != obj.getClass())
        return false;

    return equalsImpl(obj);
 }

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final IOCommsNodeRecord rhs = (IOCommsNodeRecord)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (commsNodeType == rhs.commsNodeType)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (commsNodeId.equals( rhs.commsNodeId) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" recordType: ").append(recordType).append("\n");
    sb.append(" recordLength: ").append(recordLength).append("\n");
    sb.append(" commsNodeType: ").append(commsNodeType).append("\n");
    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" commsNodeId: ").append(commsNodeId).append("\n");

   return sb.toString();
 }
} // end of class
