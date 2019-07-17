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
public class EntityTypeRaw extends Object implements Serializable
{
   /** Kind of entity uid 7 */
   protected EntityKind entityKind = EntityKind.values()[0];

   /** Domain of entity (air, surface, subsurface, space, etc) */
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


public EntityTypeRaw setEntityKind(EntityKind pEntityKind)
{
    entityKind = pEntityKind;
    return this;
}

public EntityKind getEntityKind()
{
    return entityKind; 
}

public EntityTypeRaw setDomain(byte pDomain)
{
    domain = pDomain;
    return this;
}

public byte getDomain()
{
    return domain; 
}

public EntityTypeRaw setCountry(short pCountry)
{
    country = pCountry;
    return this;
}

public short getCountry()
{
    return country; 
}

public EntityTypeRaw setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}

public byte getCategory()
{
    return category; 
}

public EntityTypeRaw setSubCategory(byte pSubCategory)
{
    subCategory = pSubCategory;
    return this;
}

public byte getSubCategory()
{
    return subCategory; 
}

public EntityTypeRaw setSpecific(byte pSpecific)
{
    specific = pSpecific;
    return this;
}

public byte getSpecific()
{
    return specific; 
}

public EntityTypeRaw setExtra(byte pExtra)
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
       dos.writeByte( (byte)domain);
       dos.writeShort( (short)country);
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
 */
public int unmarshal(DataInputStream dis)
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
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   entityKind.marshal(buff);
   buff.put( (byte)domain);
   buff.putShort( (short)country);
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
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    entityKind = EntityKind.unmarshalEnum(buff);
    domain = (byte)(buff.get() & 0xFF);
    country = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof EntityTypeRaw))
        return false;

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
} // end of class
