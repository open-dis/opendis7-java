/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Identifies an event in the world. Use this format for ONLY the LiveEntityPdu. Section 6.2.34.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EventIdentifierLiveEntity extends Object implements Serializable
{
   protected byte  siteNumber;

   protected byte  applicationNumber;

   protected short  eventNumber;


/** Constructor */
 public EventIdentifierLiveEntity()
 {
 }

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // siteNumber
   marshalSize += 1;  // applicationNumber
   marshalSize += 2;  // eventNumber

   return marshalSize;
}


/** Setter for {@link EventIdentifierLiveEntity#siteNumber}*/
public EventIdentifierLiveEntity setSiteNumber(byte pSiteNumber)
{
    siteNumber = pSiteNumber;
    return this;
}

/** Getter for {@link EventIdentifierLiveEntity#siteNumber}*/
public byte getSiteNumber()
{
    return siteNumber; 
}

/** Setter for {@link EventIdentifierLiveEntity#applicationNumber}*/
public EventIdentifierLiveEntity setApplicationNumber(byte pApplicationNumber)
{
    applicationNumber = pApplicationNumber;
    return this;
}

/** Getter for {@link EventIdentifierLiveEntity#applicationNumber}*/
public byte getApplicationNumber()
{
    return applicationNumber; 
}

/** Setter for {@link EventIdentifierLiveEntity#eventNumber}*/
public EventIdentifierLiveEntity setEventNumber(short pEventNumber)
{
    eventNumber = pEventNumber;
    return this;
}

/** Getter for {@link EventIdentifierLiveEntity#eventNumber}*/
public short getEventNumber()
{
    return eventNumber; 
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
       dos.writeByte(siteNumber);
       dos.writeByte(applicationNumber);
       dos.writeShort(eventNumber);
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
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        siteNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        applicationNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        eventNumber = (short)dis.readUnsignedShort();
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
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.put( (byte)siteNumber);
   buff.put( (byte)applicationNumber);
   buff.putShort( (short)eventNumber);
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
    siteNumber = (byte)(buff.get() & 0xFF);
    applicationNumber = (byte)(buff.get() & 0xFF);
    eventNumber = (short)(buff.getShort() & 0xFFFF);
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

     final EventIdentifierLiveEntity rhs = (EventIdentifierLiveEntity)obj;

     if( ! (siteNumber == rhs.siteNumber)) ivarsEqual = false;
     if( ! (applicationNumber == rhs.applicationNumber)) ivarsEqual = false;
     if( ! (eventNumber == rhs.eventNumber)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" siteNumber: ").append(siteNumber).append("\n");
    sb.append(" applicationNumber: ").append(applicationNumber).append("\n");
    sb.append(" eventNumber: ").append(eventNumber).append("\n");

   return sb.toString();
 }
} // end of class
