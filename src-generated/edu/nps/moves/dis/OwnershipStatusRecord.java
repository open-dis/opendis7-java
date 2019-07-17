package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * used to convey entity and conflict status information associated with transferring ownership of an entity. Section 6.2.65
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class OwnershipStatusRecord extends Object implements Serializable
{
   /** EntityID */
   protected EntityID  entityId = new EntityID(); 

   /** The ownership and/or ownership conflict status of the entity represented by the Entity ID field. uid 332 */
   protected OwnershipStatus ownershipStatus = OwnershipStatus.values()[0];

   /** padding */
   protected byte  padding = (byte)0;


/** Constructor */
 public OwnershipStatusRecord()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += entityId.getMarshalledSize();
   marshalSize += ownershipStatus.getMarshalledSize();
   marshalSize += 1;  // padding

   return marshalSize;
}


public OwnershipStatusRecord setEntityId(EntityID pEntityId)
{
    entityId = pEntityId;
    return this;
}

public EntityID getEntityId()
{
    return entityId; 
}

public OwnershipStatusRecord setOwnershipStatus(OwnershipStatus pOwnershipStatus)
{
    ownershipStatus = pOwnershipStatus;
    return this;
}

public OwnershipStatus getOwnershipStatus()
{
    return ownershipStatus; 
}

public OwnershipStatusRecord setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

public byte getPadding()
{
    return padding; 
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
       entityId.marshal(dos);
       ownershipStatus.marshal(dos);
       dos.writeByte( (byte)padding);
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
        uPosition += entityId.unmarshal(dis);
        ownershipStatus = OwnershipStatus.unmarshalEnum(dis);
        uPosition += ownershipStatus.getMarshalledSize();
        padding = (byte)dis.readUnsignedByte();
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
   entityId.marshal(buff);
   ownershipStatus.marshal(buff);
   buff.put( (byte)padding);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    entityId.unmarshal(buff);
    ownershipStatus = OwnershipStatus.unmarshalEnum(buff);
    padding = (byte)(buff.get() & 0xFF);
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

    if(!(obj instanceof OwnershipStatusRecord))
        return false;

     final OwnershipStatusRecord rhs = (OwnershipStatusRecord)obj;

     if( ! (entityId.equals( rhs.entityId) )) ivarsEqual = false;
     if( ! (ownershipStatus == rhs.ownershipStatus)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
