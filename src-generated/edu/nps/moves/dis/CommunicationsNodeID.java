package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Identity of a communications node. Section 6.2.48.4
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class CommunicationsNodeID extends Object implements Serializable
{
   protected EntityID  entityID = new EntityID(); 

   protected short  elementID;


/** Constructor */
 public CommunicationsNodeID()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += entityID.getMarshalledSize();
   marshalSize += 2;  // elementID

   return marshalSize;
}


public CommunicationsNodeID setEntityID(EntityID pEntityID)
{
    entityID = pEntityID;
    return this;
}

public EntityID getEntityID()
{
    return entityID; 
}

public CommunicationsNodeID setElementID(short pElementID)
{
    elementID = pElementID;
    return this;
}

public short getElementID()
{
    return elementID; 
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
       entityID.marshal(dos);
       dos.writeShort( (short)elementID);
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
        uPosition += entityID.unmarshal(dis);
        elementID = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   entityID.marshal(buff);
   buff.putShort( (short)elementID);
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
    entityID.unmarshal(buff);
    elementID = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof CommunicationsNodeID))
        return false;

     final CommunicationsNodeID rhs = (CommunicationsNodeID)obj;

     if( ! (entityID.equals( rhs.entityID) )) ivarsEqual = false;
     if( ! (elementID == rhs.elementID)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
