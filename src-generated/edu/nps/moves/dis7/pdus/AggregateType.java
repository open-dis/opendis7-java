/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Identifies the type and organization of an aggregate. Section 6.2.5
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class AggregateType extends Object implements Serializable
{
   /** Grouping criterion used to group the aggregate. Enumeration from EBV document uid 206 */
   protected AggregateStateAggregateKind aggregateKind = AggregateStateAggregateKind.values()[0];

   /** Domain of entity (air, surface, subsurface, space, etc.) where zero means domain does not apply. uid 8 */
   protected PlatformDomain domain = PlatformDomain.values()[0];

   /** country to which the design of the entity is attributed uid 29 */
   protected Country country = Country.values()[0];

   /** category of entity */
   protected byte  category;

   /** subcategory of entity uid 208 */
   protected AggregateStateSubcategory subcategory = AggregateStateSubcategory.values()[0];

   /** specific info based on subcategory field. specific is a reserved word in sql. uid 209 */
   protected AggregateStateSpecific specificInfo = AggregateStateSpecific.values()[0];

   /** extra is an undescribed parameter... */
   protected byte  extra;


/** Constructor */
 public AggregateType()
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

   marshalSize += aggregateKind.getMarshalledSize();
   marshalSize += domain.getMarshalledSize();
   marshalSize += country.getMarshalledSize();
   marshalSize += 1;  // category
   marshalSize += subcategory.getMarshalledSize();
   marshalSize += specificInfo.getMarshalledSize();
   marshalSize += 1;  // extra

   return marshalSize;
}


/** Setter for {@link AggregateType#aggregateKind}
  * @param pAggregateKind new value of interest
  * @return same object to permit progressive setters */
public AggregateType setAggregateKind(AggregateStateAggregateKind pAggregateKind)
{
    aggregateKind = pAggregateKind;
    return this;
}

/** Getter for {@link AggregateType#aggregateKind}
  * @return value of interest */
public AggregateStateAggregateKind getAggregateKind()
{
    return aggregateKind; 
}

/** Setter for {@link AggregateType#domain}
  * @param pDomain new value of interest
  * @return same object to permit progressive setters */
public AggregateType setDomain(PlatformDomain pDomain)
{
    domain = pDomain;
    return this;
}

/** Getter for {@link AggregateType#domain}
  * @return value of interest */
public PlatformDomain getDomain()
{
    return domain; 
}

/** Setter for {@link AggregateType#country}
  * @param pCountry new value of interest
  * @return same object to permit progressive setters */
public AggregateType setCountry(Country pCountry)
{
    country = pCountry;
    return this;
}

/** Getter for {@link AggregateType#country}
  * @return value of interest */
public Country getCountry()
{
    return country; 
}

/** Setter for {@link AggregateType#category}
  * @param pCategory new value of interest
  * @return same object to permit progressive setters */
public AggregateType setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}
/** Utility setter for {@link AggregateType#category}
  * @param pCategory new value of interest
  * @return same object to permit progressive setters */
public AggregateType setCategory(int pCategory){
    category = (byte) pCategory;
    return this;
}

/** Getter for {@link AggregateType#category}
  * @return value of interest */
public byte getCategory()
{
    return category; 
}

/** Setter for {@link AggregateType#subcategory}
  * @param pSubcategory new value of interest
  * @return same object to permit progressive setters */
public AggregateType setSubcategory(AggregateStateSubcategory pSubcategory)
{
    subcategory = pSubcategory;
    return this;
}

/** Getter for {@link AggregateType#subcategory}
  * @return value of interest */
public AggregateStateSubcategory getSubcategory()
{
    return subcategory; 
}

/** Setter for {@link AggregateType#specificInfo}
  * @param pSpecificInfo new value of interest
  * @return same object to permit progressive setters */
public AggregateType setSpecificInfo(AggregateStateSpecific pSpecificInfo)
{
    specificInfo = pSpecificInfo;
    return this;
}

/** Getter for {@link AggregateType#specificInfo}
  * @return value of interest */
public AggregateStateSpecific getSpecificInfo()
{
    return specificInfo; 
}

/** Setter for {@link AggregateType#extra}
  * @param pExtra new value of interest
  * @return same object to permit progressive setters */
public AggregateType setExtra(byte pExtra)
{
    extra = pExtra;
    return this;
}
/** Utility setter for {@link AggregateType#extra}
  * @param pExtra new value of interest
  * @return same object to permit progressive setters */
public AggregateType setExtra(int pExtra){
    extra = (byte) pExtra;
    return this;
}

/** Getter for {@link AggregateType#extra}
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
       aggregateKind.marshal(dos);
       domain.marshal(dos);
       country.marshal(dos);
       dos.writeByte(category);
       subcategory.marshal(dos);
       specificInfo.marshal(dos);
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
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        aggregateKind = AggregateStateAggregateKind.unmarshalEnum(dis);
        uPosition += aggregateKind.getMarshalledSize();
        domain = PlatformDomain.unmarshalEnum(dis);
        uPosition += domain.getMarshalledSize();
        country = Country.unmarshalEnum(dis);
        uPosition += country.getMarshalledSize();
        category = (byte)dis.readUnsignedByte();
        uPosition += 1;
        subcategory = AggregateStateSubcategory.unmarshalEnum(dis);
        uPosition += subcategory.getMarshalledSize();
        specificInfo = AggregateStateSpecific.unmarshalEnum(dis);
        uPosition += specificInfo.getMarshalledSize();
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
   aggregateKind.marshal(byteBuffer);
   domain.marshal(byteBuffer);
   country.marshal(byteBuffer);
   byteBuffer.put( (byte)category);
   subcategory.marshal(byteBuffer);
   specificInfo.marshal(byteBuffer);
   byteBuffer.put( (byte)extra);
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
    aggregateKind = AggregateStateAggregateKind.unmarshalEnum(byteBuffer);
    domain = PlatformDomain.unmarshalEnum(byteBuffer);
    country = Country.unmarshalEnum(byteBuffer);
    category = (byte)(byteBuffer.get() & 0xFF);
    subcategory = AggregateStateSubcategory.unmarshalEnum(byteBuffer);
    specificInfo = AggregateStateSpecific.unmarshalEnum(byteBuffer);
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

     final AggregateType rhs = (AggregateType)obj;

     if( ! (aggregateKind == rhs.aggregateKind)) ivarsEqual = false;
     if( ! (domain == rhs.domain)) ivarsEqual = false;
     if( ! (country == rhs.country)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subcategory == rhs.subcategory)) ivarsEqual = false;
     if( ! (specificInfo == rhs.specificInfo)) ivarsEqual = false;
     if( ! (extra == rhs.extra)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" aggregateKind: ").append(aggregateKind).append("\n");
    sb.append(" domain: ").append(domain).append("\n");
    sb.append(" country: ").append(country).append("\n");
    sb.append(" category: ").append(category).append("\n");
    sb.append(" subcategory: ").append(subcategory).append("\n");
    sb.append(" specificInfo: ").append(specificInfo).append("\n");
    sb.append(" extra: ").append(extra).append("\n");

   return sb.toString();
 }
} // end of class
