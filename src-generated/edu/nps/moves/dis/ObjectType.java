package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * The unique designation of an environmental object. Section 6.2.64
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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
   protected byte  subcategory;


/** Constructor */
 public ObjectType()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += domain.getMarshalledSize();
   marshalSize += objectKind.getMarshalledSize();
   marshalSize += 1;  // category
   marshalSize += 1;  // subcategory

   return marshalSize;
}


public ObjectType setDomain(PlatformDomain pDomain)
{
    domain = pDomain;
    return this;
}

public PlatformDomain getDomain()
{
    return domain; 
}

public ObjectType setObjectKind(ObjectKind pObjectKind)
{
    objectKind = pObjectKind;
    return this;
}

public ObjectKind getObjectKind()
{
    return objectKind; 
}

public ObjectType setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}

public byte getCategory()
{
    return category; 
}

public ObjectType setSubcategory(byte pSubcategory)
{
    subcategory = pSubcategory;
    return this;
}

public byte getSubcategory()
{
    return subcategory; 
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
       domain.marshal(dos);
       objectKind.marshal(dos);
       dos.writeByte( (byte)category);
       dos.writeByte( (byte)subcategory);
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
        domain = PlatformDomain.unmarshalEnum(dis);
        uPosition += domain.getMarshalledSize();
        objectKind = ObjectKind.unmarshalEnum(dis);
        uPosition += objectKind.getMarshalledSize();
        category = (byte)dis.readUnsignedByte();
        uPosition += 1;
        subcategory = (byte)dis.readUnsignedByte();
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
   domain.marshal(buff);
   objectKind.marshal(buff);
   buff.put( (byte)category);
   buff.put( (byte)subcategory);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    domain = PlatformDomain.unmarshalEnum(buff);
    objectKind = ObjectKind.unmarshalEnum(buff);
    category = (byte)(buff.get() & 0xFF);
    subcategory = (byte)(buff.get() & 0xFF);
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

    if(!(obj instanceof ObjectType))
        return false;

     final ObjectType rhs = (ObjectType)obj;

     if( ! (domain == rhs.domain)) ivarsEqual = false;
     if( ! (objectKind == rhs.objectKind)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subcategory == rhs.subcategory)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
