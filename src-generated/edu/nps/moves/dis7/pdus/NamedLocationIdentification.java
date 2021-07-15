/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Information about the discrete positional relationship of the part entity with respect to the its host entity Section 6.2.62 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class NamedLocationIdentification extends Object implements Serializable
{
   /** The station name within the host at which the part entity is located. If the part entity is On Station, this field shall specify the representation of the part's location data fields. This field shall be specified by a 16-bit enumeration  uid 212 */
   protected IsPartOfStationName stationName = IsPartOfStationName.values()[0];

   /** The number of the particular wing station, cargo hold etc., at which the part is attached.  */
   protected short  stationNumber;


/** Constructor */
 public NamedLocationIdentification()
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

   marshalSize += stationName.getMarshalledSize();
   marshalSize += 2;  // stationNumber

   return marshalSize;
}


/** Setter for {@link NamedLocationIdentification#stationName}
  * @param pStationName new value of interest
  * @return same object to permit progressive setters */
public NamedLocationIdentification setStationName(IsPartOfStationName pStationName)
{
    stationName = pStationName;
    return this;
}

/** Getter for {@link NamedLocationIdentification#stationName}
  * @return value of interest */
public IsPartOfStationName getStationName()
{
    return stationName; 
}

/** Setter for {@link NamedLocationIdentification#stationNumber}
  * @param pStationNumber new value of interest
  * @return same object to permit progressive setters */
public NamedLocationIdentification setStationNumber(short pStationNumber)
{
    stationNumber = pStationNumber;
    return this;
}
/** Utility setter for {@link NamedLocationIdentification#stationNumber}
  * @param pStationNumber new value of interest
  * @return same object to permit progressive setters */
public NamedLocationIdentification setStationNumber(int pStationNumber){
    stationNumber = (short) pStationNumber;
    return this;
}

/** Getter for {@link NamedLocationIdentification#stationNumber}
  * @return value of interest */
public short getStationNumber()
{
    return stationNumber; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       stationName.marshal(dos);
       dos.writeShort(stationNumber);
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
    try 
    {
        stationName = IsPartOfStationName.unmarshalEnum(dis);
        uPosition += stationName.getMarshalledSize();
        stationNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   stationName.marshal(byteBuffer);
   byteBuffer.putShort( (short)stationNumber);
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
    stationName = IsPartOfStationName.unmarshalEnum(byteBuffer);
    stationNumber = (short)(byteBuffer.getShort() & 0xFFFF);
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final NamedLocationIdentification rhs = (NamedLocationIdentification)obj;

     if( ! (stationName == rhs.stationName)) ivarsEqual = false;
     if( ! (stationNumber == rhs.stationNumber)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" stationName: ").append(stationName).append("\n");
    sb.append(" stationNumber: ").append(stationNumber).append("\n");

   return sb.toString();
 }
} // end of class
