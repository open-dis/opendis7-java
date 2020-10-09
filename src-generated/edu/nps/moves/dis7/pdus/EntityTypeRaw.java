/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Identifies the type of Entity
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EntityTypeRaw extends Object implements Serializable
{
   /** Kind of entity uid 7 */
   protected EntityKind entityKind = EntityKind.values()[0];

   /** Domain of entity (air, surface, subsurface, space, etc.) */
   protected byte  domain;

   /** country to which the design of the entity is attributed */
   protected short  country;

   /** category of entity */
   protected byte  category;

   /** subcategory of entity */
   protected byte  subCategory;

   /** specific info based on subcategory field. Renamed from specific because that is a reserved word in SQL. */
   protected byte  specific;

   protected byte  extra;


/** Constructor */
 public EntityTypeRaw()
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

   marshalSize += entityKind.getMarshalledSize();
   marshalSize += 1;  // domain
   marshalSize += 2;  // country
   marshalSize += 1;  // category
   marshalSize += 1;  // subCategory
   marshalSize += 1;  // specific
   marshalSize += 1;  // extra

   return marshalSize;
}


/** Setter for {@link EntityTypeRaw#entityKind}
  * @param pEntityKind new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setEntityKind(EntityKind pEntityKind)
{
    entityKind = pEntityKind;
    return this;
}

/** Getter for {@link EntityTypeRaw#entityKind}
  * @return value of interest */
public EntityKind getEntityKind()
{
    return entityKind; 
}

/** Setter for {@link EntityTypeRaw#domain}
  * @param pDomain new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setDomain(byte pDomain)
{
    domain = pDomain;
    return this;
}
/** Utility setter for {@link EntityTypeRaw#domain}
  * @param pDomain new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setDomain(int pDomain){
    domain = (byte) pDomain;
    return this;
}

/** Getter for {@link EntityTypeRaw#domain}
  * @return value of interest */
public byte getDomain()
{
    return domain; 
}

/** Setter for {@link EntityTypeRaw#country}
  * @param pCountry new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setCountry(short pCountry)
{
    country = pCountry;
    return this;
}
/** Utility setter for {@link EntityTypeRaw#country}
  * @param pCountry new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setCountry(int pCountry){
    country = (short) pCountry;
    return this;
}

/** Getter for {@link EntityTypeRaw#country}
  * @return value of interest */
public short getCountry()
{
    return country; 
}

/** Setter for {@link EntityTypeRaw#category}
  * @param pCategory new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}
/** Utility setter for {@link EntityTypeRaw#category}
  * @param pCategory new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setCategory(int pCategory){
    category = (byte) pCategory;
    return this;
}

/** Getter for {@link EntityTypeRaw#category}
  * @return value of interest */
public byte getCategory()
{
    return category; 
}

/** Setter for {@link EntityTypeRaw#subCategory}
  * @param pSubCategory new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setSubCategory(byte pSubCategory)
{
    subCategory = pSubCategory;
    return this;
}
/** Utility setter for {@link EntityTypeRaw#subCategory}
  * @param pSubCategory new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setSubCategory(int pSubCategory){
    subCategory = (byte) pSubCategory;
    return this;
}

/** Getter for {@link EntityTypeRaw#subCategory}
  * @return value of interest */
public byte getSubCategory()
{
    return subCategory; 
}

/** Setter for {@link EntityTypeRaw#specific}
  * @param pSpecific new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setSpecific(byte pSpecific)
{
    specific = pSpecific;
    return this;
}
/** Utility setter for {@link EntityTypeRaw#specific}
  * @param pSpecific new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setSpecific(int pSpecific){
    specific = (byte) pSpecific;
    return this;
}

/** Getter for {@link EntityTypeRaw#specific}
  * @return value of interest */
public byte getSpecific()
{
    return specific; 
}

/** Setter for {@link EntityTypeRaw#extra}
  * @param pExtra new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setExtra(byte pExtra)
{
    extra = pExtra;
    return this;
}
/** Utility setter for {@link EntityTypeRaw#extra}
  * @param pExtra new value of interest
  * @return same object to permit progressive setters */
public EntityTypeRaw setExtra(int pExtra){
    extra = (byte) pExtra;
    return this;
}

/** Getter for {@link EntityTypeRaw#extra}
  * @return value of interest */
public byte getExtra()
{
    return extra; 
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
       entityKind.marshal(dos);
       dos.writeByte(domain);
       dos.writeShort(country);
       dos.writeByte(category);
       dos.writeByte(subCategory);
       dos.writeByte(specific);
       dos.writeByte(extra);
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
        entityKind = EntityKind.unmarshalEnum(dis);
        uPosition += entityKind.getMarshalledSize();
        domain = (byte)dis.readUnsignedByte();
        uPosition += 1;
        country = (short)dis.readUnsignedShort();
        uPosition += 2;
        category = (byte)dis.readUnsignedByte();
        uPosition += 1;
        subCategory = (byte)dis.readUnsignedByte();
        uPosition += 1;
        specific = (byte)dis.readUnsignedByte();
        uPosition += 1;
        extra = (byte)dis.readUnsignedByte();
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
   entityKind.marshal(byteBuffer);
   byteBuffer.put( (byte)domain);
   byteBuffer.putShort( (short)country);
   byteBuffer.put( (byte)category);
   byteBuffer.put( (byte)subCategory);
   byteBuffer.put( (byte)specific);
   byteBuffer.put( (byte)extra);
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
    entityKind = EntityKind.unmarshalEnum(byteBuffer);
    domain = (byte)(byteBuffer.get() & 0xFF);
    country = (short)(byteBuffer.getShort() & 0xFFFF);
    category = (byte)(byteBuffer.get() & 0xFF);
    subCategory = (byte)(byteBuffer.get() & 0xFF);
    specific = (byte)(byteBuffer.get() & 0xFF);
    extra = (byte)(byteBuffer.get() & 0xFF);
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

     final EntityTypeRaw rhs = (EntityTypeRaw)obj;

     if( ! (entityKind == rhs.entityKind)) ivarsEqual = false;
     if( ! (domain == rhs.domain)) ivarsEqual = false;
     if( ! (country == rhs.country)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subCategory == rhs.subCategory)) ivarsEqual = false;
     if( ! (specific == rhs.specific)) ivarsEqual = false;
     if( ! (extra == rhs.extra)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" entityKind: ").append(entityKind).append("\n");
    sb.append(" domain: ").append(domain).append("\n");
    sb.append(" country: ").append(country).append("\n");
    sb.append(" category: ").append(category).append("\n");
    sb.append(" subCategory: ").append(subCategory).append("\n");
    sb.append(" specific: ").append(specific).append("\n");
    sb.append(" extra: ").append(extra).append("\n");

   return sb.toString();
 }
} // end of class
