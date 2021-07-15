/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The live entity PDUs have a slightly different header
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public abstract class LiveEntityPdu extends Pdu implements Serializable
{
   /** Subprotocol used to decode the PDU. Section 13 of EBV. uid 417 */
   protected DISLiveEntitySubprotocolNumber subprotocolNumber = DISLiveEntitySubprotocolNumber.values()[0];

   /** zero-filled array of padding */
   protected byte  padding = (byte)0;


/** Constructor */
 public LiveEntityPdu()
 {
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += subprotocolNumber.getMarshalledSize();
   marshalSize += 1;  // padding

   return marshalSize;
}


/** Setter for {@link LiveEntityPdu#subprotocolNumber}
  * @param pSubprotocolNumber new value of interest
  * @return same object to permit progressive setters */
public LiveEntityPdu setSubprotocolNumber(DISLiveEntitySubprotocolNumber pSubprotocolNumber)
{
    subprotocolNumber = pSubprotocolNumber;
    return this;
}

/** Getter for {@link LiveEntityPdu#subprotocolNumber}
  * @return value of interest */
public DISLiveEntitySubprotocolNumber getSubprotocolNumber()
{
    return subprotocolNumber; 
}

/** Setter for {@link LiveEntityPdu#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public LiveEntityPdu setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}
/** Utility setter for {@link LiveEntityPdu#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public LiveEntityPdu setPadding(int pPadding){
    padding = (byte) pPadding;
    return this;
}

/** Getter for {@link LiveEntityPdu#padding}
  * @return value of interest */
public byte getPadding()
{
    return padding; 
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
       subprotocolNumber.marshal(dos);
       dos.writeByte(padding);
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
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        subprotocolNumber = DISLiveEntitySubprotocolNumber.unmarshalEnum(dis);
        uPosition += subprotocolNumber.getMarshalledSize();
        padding = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   subprotocolNumber.marshal(byteBuffer);
   byteBuffer.put( (byte)padding);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    subprotocolNumber = DISLiveEntitySubprotocolNumber.unmarshalEnum(byteBuffer);
    padding = (byte)(byteBuffer.get() & 0xFF);
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

     final LiveEntityPdu rhs = (LiveEntityPdu)obj;

     if( ! (subprotocolNumber == rhs.subprotocolNumber)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" subprotocolNumber: ").append(subprotocolNumber).append("\n");
    sb.append(" padding: ").append(padding).append("\n");

   return sb.toString();
 }
} // end of class
