/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Identifies the type of Entity
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EntityType extends Object implements Serializable
{
   /** Kind of entity uid 7 */
   protected EntityKind entityKind = EntityKind.values()[0];

   /** Domain of entity (air, surface, subsurface, space, etc) */
   protected Domain  domain =  Domain.inst(PlatformDomain.OTHER); 

   /** country to which the design of the entity is attributed uid 29 */
   protected Country country = Country.values()[0];

   /** category of entity */
   protected byte  category;

   /** subcategory based on category */
   protected byte  subCategory;

   /** specific info based on subcategory */
   protected byte  specific;

   protected byte  extra;


/** Constructor */
 public EntityType()
 {
 }

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += entityKind.getMarshalledSize();
   marshalSize += domain.getMarshalledSize();
   marshalSize += country.getMarshalledSize();
   marshalSize += 1;  // category
   marshalSize += 1;  // subCategory
   marshalSize += 1;  // specific
   marshalSize += 1;  // extra

   return marshalSize;
}


/** Setter for {@link EntityType#entityKind}*/
public EntityType setEntityKind(EntityKind pEntityKind)
{
    entityKind = pEntityKind;
    return this;
}

/** Getter for {@link EntityType#entityKind}*/
public EntityKind getEntityKind()
{
    return entityKind; 
}

/** Setter for {@link EntityType#domain}*/
public EntityType setDomain(Domain pDomain)
{
    domain = pDomain;
    return this;
}

/** Getter for {@link EntityType#domain}*/
public Domain getDomain()
{
    return domain; 
}

/** Setter for {@link EntityType#country}*/
public EntityType setCountry(Country pCountry)
{
    country = pCountry;
    return this;
}

/** Getter for {@link EntityType#country}*/
public Country getCountry()
{
    return country; 
}

/** Setter for {@link EntityType#category}*/
public EntityType setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}

/** Getter for {@link EntityType#category}*/
public byte getCategory()
{
    return category; 
}

/** Setter for {@link EntityType#subCategory}*/
public EntityType setSubCategory(byte pSubCategory)
{
    subCategory = pSubCategory;
    return this;
}

/** Getter for {@link EntityType#subCategory}*/
public byte getSubCategory()
{
    return subCategory; 
}

/** Setter for {@link EntityType#specific}*/
public EntityType setSpecific(byte pSpecific)
{
    specific = pSpecific;
    return this;
}

/** Getter for {@link EntityType#specific}*/
public byte getSpecific()
{
    return specific; 
}

/** Setter for {@link EntityType#extra}*/
public EntityType setExtra(byte pExtra)
{
    extra = pExtra;
    return this;
}

/** Getter for {@link EntityType#extra}*/
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
       domain.marshal(dos);
       country.marshal(dos);
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
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        entityKind = EntityKind.unmarshalEnum(dis);
        uPosition += entityKind.getMarshalledSize();
        uPosition += domain.unmarshal(dis);
        country = Country.unmarshalEnum(dis);
        uPosition += country.getMarshalledSize();
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
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   entityKind.marshal(buff);
   domain.marshal(buff);
   country.marshal(buff);
   buff.put( (byte)category);
   buff.put( (byte)subCategory);
   buff.put( (byte)specific);
   buff.put( (byte)extra);
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
    entityKind = EntityKind.unmarshalEnum(buff);
    domain.unmarshal(buff);
    country = Country.unmarshalEnum(buff);
    category = (byte)(buff.get() & 0xFF);
    subCategory = (byte)(buff.get() & 0xFF);
    specific = (byte)(buff.get() & 0xFF);
    extra = (byte)(buff.get() & 0xFF);
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

     final EntityType rhs = (EntityType)obj;

     if( ! (entityKind == rhs.entityKind)) ivarsEqual = false;
     if( ! (domain.equals( rhs.domain) )) ivarsEqual = false;
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
