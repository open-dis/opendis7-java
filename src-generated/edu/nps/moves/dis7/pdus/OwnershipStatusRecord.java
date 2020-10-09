/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * used to convey entity and conflict status information associated with transferring ownership of an entity. Section 6.2.65
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class OwnershipStatusRecord extends Object implements Serializable
{
   /** EntityID */
   protected EntityID  entityId = new EntityID(); 

   /** The ownership and/or ownership conflict status of the entity represented by the Entity ID field. uid 332 */
   protected OwnershipStatus ownershipStatus = OwnershipStatus.values()[0];

   /** padding */
   protected byte  padding = (byte)0;


/** Constructor */
 public OwnershipStatusRecord()
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

   marshalSize += entityId.getMarshalledSize();
   marshalSize += ownershipStatus.getMarshalledSize();
   marshalSize += 1;  // padding

   return marshalSize;
}


/** Setter for {@link OwnershipStatusRecord#entityId}
  * @param pEntityId new value of interest
  * @return same object to permit progressive setters */
public OwnershipStatusRecord setEntityId(EntityID pEntityId)
{
    entityId = pEntityId;
    return this;
}

/** Getter for {@link OwnershipStatusRecord#entityId}
  * @return value of interest */
public EntityID getEntityId()
{
    return entityId; 
}

/** Setter for {@link OwnershipStatusRecord#ownershipStatus}
  * @param pOwnershipStatus new value of interest
  * @return same object to permit progressive setters */
public OwnershipStatusRecord setOwnershipStatus(OwnershipStatus pOwnershipStatus)
{
    ownershipStatus = pOwnershipStatus;
    return this;
}

/** Getter for {@link OwnershipStatusRecord#ownershipStatus}
  * @return value of interest */
public OwnershipStatus getOwnershipStatus()
{
    return ownershipStatus; 
}

/** Setter for {@link OwnershipStatusRecord#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public OwnershipStatusRecord setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}
/** Utility setter for {@link OwnershipStatusRecord#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public OwnershipStatusRecord setPadding(int pPadding){
    padding = (byte) pPadding;
    return this;
}

/** Getter for {@link OwnershipStatusRecord#padding}
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
    try 
    {
       entityId.marshal(dos);
       ownershipStatus.marshal(dos);
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
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        uPosition += entityId.unmarshal(dis);
        ownershipStatus = OwnershipStatus.unmarshalEnum(dis);
        uPosition += ownershipStatus.getMarshalledSize();
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
   entityId.marshal(byteBuffer);
   ownershipStatus.marshal(byteBuffer);
   byteBuffer.put( (byte)padding);
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
    entityId.unmarshal(byteBuffer);
    ownershipStatus = OwnershipStatus.unmarshalEnum(byteBuffer);
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final OwnershipStatusRecord rhs = (OwnershipStatusRecord)obj;

     if( ! (entityId.equals( rhs.entityId) )) ivarsEqual = false;
     if( ! (ownershipStatus == rhs.ownershipStatus)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" entityId: ").append(entityId).append("\n");
    sb.append(" ownershipStatus: ").append(ownershipStatus).append("\n");
    sb.append(" padding: ").append(padding).append("\n");

   return sb.toString();
 }
} // end of class
