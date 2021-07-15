/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Identity of a communications node. Section 6.2.48.4
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class CommunicationsNodeID extends Object implements Serializable
{
   /** entityID is an undescribed parameter... */
   protected EntityID  entityID = new EntityID(); 

   /** elementID is an undescribed parameter... */
   protected short  elementID;


/** Constructor */
 public CommunicationsNodeID()
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

   marshalSize += entityID.getMarshalledSize();
   marshalSize += 2;  // elementID

   return marshalSize;
}


/** Setter for {@link CommunicationsNodeID#entityID}
  * @param pEntityID new value of interest
  * @return same object to permit progressive setters */
public CommunicationsNodeID setEntityID(EntityID pEntityID)
{
    entityID = pEntityID;
    return this;
}

/** Getter for {@link CommunicationsNodeID#entityID}
  * @return value of interest */
public EntityID getEntityID()
{
    return entityID; 
}

/** Setter for {@link CommunicationsNodeID#elementID}
  * @param pElementID new value of interest
  * @return same object to permit progressive setters */
public CommunicationsNodeID setElementID(short pElementID)
{
    elementID = pElementID;
    return this;
}
/** Utility setter for {@link CommunicationsNodeID#elementID}
  * @param pElementID new value of interest
  * @return same object to permit progressive setters */
public CommunicationsNodeID setElementID(int pElementID){
    elementID = (short) pElementID;
    return this;
}

/** Getter for {@link CommunicationsNodeID#elementID}
  * @return value of interest */
public short getElementID()
{
    return elementID; 
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
       entityID.marshal(dos);
       dos.writeShort(elementID);
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
        uPosition += entityID.unmarshal(dis);
        elementID = (short)dis.readUnsignedShort();
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
   entityID.marshal(byteBuffer);
   byteBuffer.putShort( (short)elementID);
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
    entityID.unmarshal(byteBuffer);
    elementID = (short)(byteBuffer.getShort() & 0xFFFF);
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

     final CommunicationsNodeID rhs = (CommunicationsNodeID)obj;

     if( ! (entityID.equals( rhs.entityID) )) ivarsEqual = false;
     if( ! (elementID == rhs.elementID)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" entityID: ").append(entityID).append("\n");
    sb.append(" elementID: ").append(elementID).append("\n");

   return sb.toString();
 }
} // end of class