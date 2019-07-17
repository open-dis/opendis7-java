package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Identifies the type of Entity
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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


public EntityType setEntityKind(EntityKind pEntityKind)
{
    entityKind = pEntityKind;
    return this;
}

public EntityKind getEntityKind()
{
    return entityKind; 
}

public EntityType setDomain(Domain pDomain)
{
    domain = pDomain;
    return this;
}

public Domain getDomain()
{
    return domain; 
}

public EntityType setCountry(Country pCountry)
{
    country = pCountry;
    return this;
}

public Country getCountry()
{
    return country; 
}

public EntityType setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}

public byte getCategory()
{
    return category; 
}

public EntityType setSubCategory(byte pSubCategory)
{
    subCategory = pSubCategory;
    return this;
}

public byte getSubCategory()
{
    return subCategory; 
}

public EntityType setSpecific(byte pSpecific)
{
    specific = pSpecific;
    return this;
}

public byte getSpecific()
{
    return specific; 
}

public EntityType setExtra(byte pExtra)
{
    extra = pExtra;
    return this;
}

public byte getExtra()
{
    return extra; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    try 
    {
       entityKind.marshal(dos);
       domain.marshal(dos);
       country.marshal(dos);
       dos.writeByte( (byte)category);
       dos.writeByte( (byte)subCategory);
       dos.writeByte( (byte)specific);
       dos.writeByte( (byte)extra);
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
}

/**
 * Unserializes an object from a DataInputStream.
 * @see java.io.DataInputStream
 * @param dis The DataInputStream
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis)
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
      System.out.println(e); 
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
  * The equals method doesn't always work--mostly it works only on classes that consist only of primitives. Be careful.
  */
@Override
 public boolean equals(Object obj)
 {
    if(this == obj)
      return true;

    if(obj == null)
       return false;

    if(getClass() != obj.getClass())
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

    if(!(obj instanceof EntityType))
        return false;

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
} // end of class
