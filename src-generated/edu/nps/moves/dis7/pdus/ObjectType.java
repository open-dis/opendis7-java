/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The unique designation of an environmental object. Section 6.2.64
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class ObjectType extends Object implements Serializable
{
   /** Domain of entity (air, surface, subsurface, space, etc.) uid 8 */
   protected PlatformDomain domain = PlatformDomain.values()[0];

   /** country to which the design of the entity is attributed uid 225 */
   protected ObjectKind objectKind = ObjectKind.values()[0];

   /** category of entity */
   protected byte  category;

   /** subcategory of entity */
   protected byte  subCategory;


/** Constructor */
 public ObjectType()
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

   marshalSize += domain.getMarshalledSize();
   marshalSize += objectKind.getMarshalledSize();
   marshalSize += 1;  // category
   marshalSize += 1;  // subCategory

   return marshalSize;
}


/** Setter for {@link ObjectType#domain}
  * @param pDomain new value of interest
  * @return same object to permit progressive setters */
public ObjectType setDomain(PlatformDomain pDomain)
{
    domain = pDomain;
    return this;
}

/** Getter for {@link ObjectType#domain}
  * @return value of interest */
public PlatformDomain getDomain()
{
    return domain; 
}

/** Setter for {@link ObjectType#objectKind}
  * @param pObjectKind new value of interest
  * @return same object to permit progressive setters */
public ObjectType setObjectKind(ObjectKind pObjectKind)
{
    objectKind = pObjectKind;
    return this;
}

/** Getter for {@link ObjectType#objectKind}
  * @return value of interest */
public ObjectKind getObjectKind()
{
    return objectKind; 
}

/** Setter for {@link ObjectType#category}
  * @param pCategory new value of interest
  * @return same object to permit progressive setters */
public ObjectType setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}
/** Utility setter for {@link ObjectType#category}
  * @param pCategory new value of interest
  * @return same object to permit progressive setters */
public ObjectType setCategory(int pCategory){
    category = (byte) pCategory;
    return this;
}

/** Getter for {@link ObjectType#category}
  * @return value of interest */
public byte getCategory()
{
    return category; 
}

/** Setter for {@link ObjectType#subCategory}
  * @param pSubCategory new value of interest
  * @return same object to permit progressive setters */
public ObjectType setSubCategory(byte pSubCategory)
{
    subCategory = pSubCategory;
    return this;
}
/** Utility setter for {@link ObjectType#subCategory}
  * @param pSubCategory new value of interest
  * @return same object to permit progressive setters */
public ObjectType setSubCategory(int pSubCategory){
    subCategory = (byte) pSubCategory;
    return this;
}

/** Getter for {@link ObjectType#subCategory}
  * @return value of interest */
public byte getSubCategory()
{
    return subCategory; 
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
       domain.marshal(dos);
       objectKind.marshal(dos);
       dos.writeByte(category);
       dos.writeByte(subCategory);
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
        domain = PlatformDomain.unmarshalEnum(dis);
        uPosition += domain.getMarshalledSize();
        objectKind = ObjectKind.unmarshalEnum(dis);
        uPosition += objectKind.getMarshalledSize();
        category = (byte)dis.readUnsignedByte();
        uPosition += 1;
        subCategory = (byte)dis.readUnsignedByte();
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
   domain.marshal(byteBuffer);
   objectKind.marshal(byteBuffer);
   byteBuffer.put( (byte)category);
   byteBuffer.put( (byte)subCategory);
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
    domain = PlatformDomain.unmarshalEnum(byteBuffer);
    objectKind = ObjectKind.unmarshalEnum(byteBuffer);
    category = (byte)(byteBuffer.get() & 0xFF);
    subCategory = (byte)(byteBuffer.get() & 0xFF);
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

     final ObjectType rhs = (ObjectType)obj;

     if( ! (domain == rhs.domain)) ivarsEqual = false;
     if( ! (objectKind == rhs.objectKind)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subCategory == rhs.subCategory)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" domain: ").append(domain).append("\n");
    sb.append(" objectKind: ").append(objectKind).append("\n");
    sb.append(" category: ").append(category).append("\n");
    sb.append(" subCategory: ").append(subCategory).append("\n");

   return sb.toString();
 }
} // end of class
