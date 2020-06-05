/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * An entity's associations with other entities and/or locations. For each association, this record shall specify the type of the association, the associated entity's EntityID and/or the associated location's world coordinates. This record may be used (optionally) in a transfer transaction to send internal state data from the divesting simulation to the acquiring simulation (see 5.9.4). This record may also be used for other purposes. Section 6.2.9
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class Association extends Object implements Serializable
{
   /**  330 */
   protected EntityAssociationAssociationType associationType = EntityAssociationAssociationType.values()[0];

   protected byte  padding;

   /** identity of associated entity. If none, NO_SPECIFIC_ENTITY */
   protected EntityIdentifier  associatedEntityID = new EntityIdentifier(); 

   /** location, in world coordinates */
   protected Vector3Double  associatedLocation = new Vector3Double(); 


/** Constructor */
 public Association()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += associationType.getMarshalledSize();
   marshalSize += 1;  // padding
   marshalSize += associatedEntityID.getMarshalledSize();
   marshalSize += associatedLocation.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link Association#associationType}*/
public Association setAssociationType(EntityAssociationAssociationType pAssociationType)
{
    associationType = pAssociationType;
    return this;
}

/** Getter for {@link Association#associationType}*/
public EntityAssociationAssociationType getAssociationType()
{
    return associationType; 
}

/** Setter for {@link Association#padding}*/
public Association setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link Association#padding}*/
public byte getPadding()
{
    return padding; 
}

/** Setter for {@link Association#associatedEntityID}*/
public Association setAssociatedEntityID(EntityIdentifier pAssociatedEntityID)
{
    associatedEntityID = pAssociatedEntityID;
    return this;
}

/** Getter for {@link Association#associatedEntityID}*/
public EntityIdentifier getAssociatedEntityID()
{
    return associatedEntityID; 
}

/** Setter for {@link Association#associatedLocation}*/
public Association setAssociatedLocation(Vector3Double pAssociatedLocation)
{
    associatedLocation = pAssociatedLocation;
    return this;
}

/** Getter for {@link Association#associatedLocation}*/
public Vector3Double getAssociatedLocation()
{
    return associatedLocation; 
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
       associationType.marshal(dos);
       dos.writeByte(padding);
       associatedEntityID.marshal(dos);
       associatedLocation.marshal(dos);
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
}

/**
 * Unserializes an object from a DataInputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataInputStream
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        associationType = EntityAssociationAssociationType.unmarshalEnum(dis);
        uPosition += associationType.getMarshalledSize();
        padding = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += associatedEntityID.unmarshal(dis);
        uPosition += associatedLocation.unmarshal(dis);
    }
    catch(Exception e)
    { 
      System.err.println(e); 
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
   associationType.marshal(buff);
   buff.put( (byte)padding);
   associatedEntityID.marshal(buff);
   associatedLocation.marshal(buff);
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
    associationType = EntityAssociationAssociationType.unmarshalEnum(buff);
    padding = (byte)(buff.get() & 0xFF);
    associatedEntityID.unmarshal(buff);
    associatedLocation.unmarshal(buff);
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

     final Association rhs = (Association)obj;

     if( ! (associationType == rhs.associationType)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (associatedEntityID.equals( rhs.associatedEntityID) )) ivarsEqual = false;
     if( ! (associatedLocation.equals( rhs.associatedLocation) )) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" associationType: ").append(associationType).append("\n");
    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" associatedEntityID: ").append(associatedEntityID).append("\n");
    sb.append(" associatedLocation: ").append(associatedLocation).append("\n");

   return sb.toString();
 }
} // end of class
