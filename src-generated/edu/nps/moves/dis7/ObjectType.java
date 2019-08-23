/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The unique designation of an environmental object. Section 6.2.64
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class ObjectType extends Object implements Serializable
{
   /** Domain of entity (air, surface, subsurface, space, etc) uid 8 */
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

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += domain.getMarshalledSize();
   marshalSize += objectKind.getMarshalledSize();
   marshalSize += 1;  // category
   marshalSize += 1;  // subCategory

   return marshalSize;
}


/** Setter for {@link ObjectType#domain}*/
public ObjectType setDomain(PlatformDomain pDomain)
{
    domain = pDomain;
    return this;
}

/** Getter for {@link ObjectType#domain}*/
public PlatformDomain getDomain()
{
    return domain; 
}

/** Setter for {@link ObjectType#objectKind}*/
public ObjectType setObjectKind(ObjectKind pObjectKind)
{
    objectKind = pObjectKind;
    return this;
}

/** Getter for {@link ObjectType#objectKind}*/
public ObjectKind getObjectKind()
{
    return objectKind; 
}

/** Setter for {@link ObjectType#category}*/
public ObjectType setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}

/** Getter for {@link ObjectType#category}*/
public byte getCategory()
{
    return category; 
}

/** Setter for {@link ObjectType#subCategory}*/
public ObjectType setSubCategory(byte pSubCategory)
{
    subCategory = pSubCategory;
    return this;
}

/** Getter for {@link ObjectType#subCategory}*/
public byte getSubCategory()
{
    return subCategory; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       domain.marshal(dos);
       objectKind.marshal(dos);
       dos.writeByte( (byte)category);
       dos.writeByte( (byte)subCategory);
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
   domain.marshal(buff);
   objectKind.marshal(buff);
   buff.put( (byte)category);
   buff.put( (byte)subCategory);
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
    domain = PlatformDomain.unmarshalEnum(buff);
    objectKind = ObjectKind.unmarshalEnum(buff);
    category = (byte)(buff.get() & 0xFF);
    subCategory = (byte)(buff.get() & 0xFF);
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

     final ObjectType rhs = (ObjectType)obj;

     if( ! (domain == rhs.domain)) ivarsEqual = false;
     if( ! (objectKind == rhs.objectKind)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subCategory == rhs.subCategory)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
