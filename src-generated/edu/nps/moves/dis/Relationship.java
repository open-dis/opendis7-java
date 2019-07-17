package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * The relationship of the part entity to its host entity. Section 6.2.74.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class Relationship extends Object implements Serializable
{
   /** the nature or purpose for joining of the part entity to the host entity and shall be represented by a 16-bit enumeration uid 210 */
   protected IsPartOfNature nature = IsPartOfNature.values()[0];

   /** the position of the part entity with respect to the host entity and shall be represented by a 16-bit enumeration uid 211 */
   protected IsPartOfPosition position = IsPartOfPosition.values()[0];


/** Constructor */
 public Relationship()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += nature.getMarshalledSize();
   marshalSize += position.getMarshalledSize();

   return marshalSize;
}


public Relationship setNature(IsPartOfNature pNature)
{
    nature = pNature;
    return this;
}

public IsPartOfNature getNature()
{
    return nature; 
}

public Relationship setPosition(IsPartOfPosition pPosition)
{
    position = pPosition;
    return this;
}

public IsPartOfPosition getPosition()
{
    return position; 
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
       nature.marshal(dos);
       position.marshal(dos);
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
        nature = IsPartOfNature.unmarshalEnum(dis);
        uPosition += nature.getMarshalledSize();
        position = IsPartOfPosition.unmarshalEnum(dis);
        uPosition += position.getMarshalledSize();
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
   nature.marshal(buff);
   position.marshal(buff);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    nature = IsPartOfNature.unmarshalEnum(buff);
    position = IsPartOfPosition.unmarshalEnum(buff);
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

    if(!(obj instanceof Relationship))
        return false;

     final Relationship rhs = (Relationship)obj;

     if( ! (nature == rhs.nature)) ivarsEqual = false;
     if( ! (position == rhs.position)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
