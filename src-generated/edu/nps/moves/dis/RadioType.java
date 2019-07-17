package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Identifies the type of radio. Section 6.2.71
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class RadioType extends Object implements Serializable
{
   /** Kind of entity uid 7 */
   protected EntityKind entityKind = EntityKind.RADIO;

   /** Domain of entity (air, surface, subsurface, space, etc) */
   protected byte  domain;

   /** country to which the design of the entity is attributed uid 29 */
   protected Country country = Country.values()[0];

   /** category of entity uid 22 */
   protected RadioCategory category = RadioCategory.values()[0];

   /** specific info based on subcategory field uid 23 */
   protected RadioSubcategory subcategory = RadioSubcategory.values()[0];

   protected byte  specific;

   protected byte  extra;


/** Constructor */
 public RadioType()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += entityKind.getMarshalledSize();
   marshalSize += 1;  // domain
   marshalSize += country.getMarshalledSize();
   marshalSize += category.getMarshalledSize();
   marshalSize += subcategory.getMarshalledSize();
   marshalSize += 1;  // specific
   marshalSize += 1;  // extra

   return marshalSize;
}


public RadioType setEntityKind(EntityKind pEntityKind)
{
    entityKind = pEntityKind;
    return this;
}

public EntityKind getEntityKind()
{
    return entityKind; 
}

public RadioType setDomain(byte pDomain)
{
    domain = pDomain;
    return this;
}

public byte getDomain()
{
    return domain; 
}

public RadioType setCountry(Country pCountry)
{
    country = pCountry;
    return this;
}

public Country getCountry()
{
    return country; 
}

public RadioType setCategory(RadioCategory pCategory)
{
    category = pCategory;
    return this;
}

public RadioCategory getCategory()
{
    return category; 
}

public RadioType setSubcategory(RadioSubcategory pSubcategory)
{
    subcategory = pSubcategory;
    return this;
}

public RadioSubcategory getSubcategory()
{
    return subcategory; 
}

public RadioType setSpecific(byte pSpecific)
{
    specific = pSpecific;
    return this;
}

public byte getSpecific()
{
    return specific; 
}

public RadioType setExtra(byte pExtra)
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
       country.marshal(dos);
       category.marshal(dos);
       subcategory.marshal(dos);
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
        country = Country.unmarshalEnum(dis);
        uPosition += country.getMarshalledSize();
        category = RadioCategory.unmarshalEnum(dis);
        uPosition += category.getMarshalledSize();
        subcategory = RadioSubcategory.unmarshalEnum(dis);
        uPosition += subcategory.getMarshalledSize();
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
   country.marshal(buff);
   category.marshal(buff);
   subcategory.marshal(buff);
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
    country = Country.unmarshalEnum(buff);
    category = RadioCategory.unmarshalEnum(buff);
    subcategory = RadioSubcategory.unmarshalEnum(buff);
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

    if(!(obj instanceof RadioType))
        return false;

     final RadioType rhs = (RadioType)obj;

     if( ! (entityKind == rhs.entityKind)) ivarsEqual = false;
     if( ! (domain == rhs.domain)) ivarsEqual = false;
     if( ! (country == rhs.country)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subcategory == rhs.subcategory)) ivarsEqual = false;
     if( ! (specific == rhs.specific)) ivarsEqual = false;
     if( ! (extra == rhs.extra)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
