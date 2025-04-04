/**
 * Copyright (c) 2008-2023, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD-style open-source license, see project
 * <a href="https://savage.nps.edu/opendis7-java/license.html" target="_blank">license.html</a> and <a href="https://savage.nps.edu/opendis7-java/license.txt" target="_blank">license.txt</a>
 */
// header autogenerated using string template dis7javalicense.txt



package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The relationship of the part entity to its host entity. Section 6.2.74.
 * @see <a href="https://ieeexplore.ieee.org/document/6387564" target="_blank">IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols</a> 
 */
public class Relationship extends Object implements Serializable
{
   /** The nature or purpose for joining of the part entity to the host entity and shall be represented by a 16-bit enumeration uid 210 */
   protected IsPartOfNature nature = IsPartOfNature.values()[0];

   /** The position of the part entity with respect to the host entity and shall be represented by a 16-bit enumeration uid 211 */
   protected IsPartOfPosition position = IsPartOfPosition.values()[0];


/** Constructor creates and configures a new instance object */
 public Relationship()
 {
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public synchronized int getMarshalledSize()
{
   int marshalSize = 0; 

   if (nature != null)
       marshalSize += nature.getMarshalledSize();
   if (position != null)
       marshalSize += position.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link Relationship#nature}
  * @param pNature new value of interest
  * @return same object to permit progressive setters */
public synchronized Relationship setNature(IsPartOfNature pNature)
{
    nature = pNature;
    return this;
}
/** Getter for {@link Relationship#nature}
  * @return value of interest */
public IsPartOfNature getNature()
{
    return nature; 
}

/** Setter for {@link Relationship#position}
  * @param pPosition new value of interest
  * @return same object to permit progressive setters */
public synchronized Relationship setPosition(IsPartOfPosition pPosition)
{
    position = pPosition;
    return this;
}
/** Getter for {@link Relationship#position}
  * @return value of interest */
public IsPartOfPosition getPosition()
{
    return position; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public synchronized void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       nature.marshal(dos);
       position.marshal(dos);
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
public synchronized int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        nature = IsPartOfNature.unmarshalEnum(dis);
        uPosition += nature.getMarshalledSize();
        position = IsPartOfPosition.unmarshalEnum(dis);
        uPosition += position.getMarshalledSize();
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
public synchronized void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   nature.marshal(byteBuffer);
   position.marshal(byteBuffer);
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
public synchronized int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    try
    {
        // attribute nature marked as not serialized
        nature = IsPartOfNature.unmarshalEnum(byteBuffer);
        // attribute position marked as not serialized
        position = IsPartOfPosition.unmarshalEnum(byteBuffer);
    }
    catch (java.nio.BufferUnderflowException bue)
    {
        System.err.println("*** buffer underflow error while unmarshalling " + this.getClass().getName());
    }
    return getMarshalledSize();
}

 /*
  * Override of default equals method.  Calls equalsImpl() for content comparison.
  */
@Override
 public synchronized boolean equals(Object obj)
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
 public synchronized boolean equalsImpl(Object obj)
 {
     final Relationship rhs = (Relationship)obj;

     if( ! (nature == rhs.nature)) return false;
     if( ! (position == rhs.position)) return false;
    return true;
 }

 @Override
 public synchronized String toString()
 {
    StringBuilder sb  = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" nature:").append(nature); // writeOneToString
    sb.append(" position:").append(position); // writeOneToString

   return sb.toString();
 }

 @Override
 public int hashCode()
 {
	 return Objects.hash(this.nature,
	                     this.position);
 }
} // end of Relationship
