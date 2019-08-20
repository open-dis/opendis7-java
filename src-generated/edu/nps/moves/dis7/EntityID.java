/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * more laconically named EntityIdentifier
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class EntityID extends Object implements Serializable
{
   /** Site ID */
   protected short  siteID;

   /** application number ID */
   protected short  applicationID;

   /** Entity number ID */
   protected short  entityID;


/** Constructor */
 public EntityID()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // siteID
   marshalSize += 2;  // applicationID
   marshalSize += 2;  // entityID

   return marshalSize;
}


/** Setter for {@link EntityID#siteID}*/
public EntityID setSiteID(short pSiteID)
{
    siteID = pSiteID;
    return this;
}

/** Getter for {@link EntityID#siteID}*/
public short getSiteID()
{
    return siteID; 
}

/** Setter for {@link EntityID#applicationID}*/
public EntityID setApplicationID(short pApplicationID)
{
    applicationID = pApplicationID;
    return this;
}

/** Getter for {@link EntityID#applicationID}*/
public short getApplicationID()
{
    return applicationID; 
}

/** Setter for {@link EntityID#entityID}*/
public EntityID setEntityID(short pEntityID)
{
    entityID = pEntityID;
    return this;
}

/** Getter for {@link EntityID#entityID}*/
public short getEntityID()
{
    return entityID; 
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
       dos.writeShort( (short)siteID);
       dos.writeShort( (short)applicationID);
       dos.writeShort( (short)entityID);
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
        siteID = (short)dis.readUnsignedShort();
        uPosition += 2;
        applicationID = (short)dis.readUnsignedShort();
        uPosition += 2;
        entityID = (short)dis.readUnsignedShort();
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
   buff.putShort( (short)siteID);
   buff.putShort( (short)applicationID);
   buff.putShort( (short)entityID);
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
    siteID = (short)(buff.getShort() & 0xFFFF);
    applicationID = (short)(buff.getShort() & 0xFFFF);
    entityID = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof EntityID))
        return false;

     final EntityID rhs = (EntityID)obj;

     if( ! (siteID == rhs.siteID)) ivarsEqual = false;
     if( ! (applicationID == rhs.applicationID)) ivarsEqual = false;
     if( ! (entityID == rhs.entityID)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
