/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Identity of a communications node. Section 6.2.50
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class LaunchedMunitionRecord extends Object implements Serializable
{
   /** fireEventID is an undescribed parameter... */
   protected EventIdentifier  fireEventID = new EventIdentifier(); 

   /** padding is an undescribed parameter... */
   protected short  padding;

   /** firingEntityID is an undescribed parameter... */
   protected EntityID  firingEntityID = new EntityID(); 

   /** padding2 is an undescribed parameter... */
   protected short  padding2;

   /** targetEntityID is an undescribed parameter... */
   protected EntityID  targetEntityID = new EntityID(); 

   /** padding3 is an undescribed parameter... */
   protected short  padding3;

   /** targetLocation is an undescribed parameter... */
   protected Vector3Double  targetLocation = new Vector3Double(); 


/** Constructor */
 public LaunchedMunitionRecord()
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

   marshalSize += fireEventID.getMarshalledSize();
   marshalSize += 2;  // padding
   marshalSize += firingEntityID.getMarshalledSize();
   marshalSize += 2;  // padding2
   marshalSize += targetEntityID.getMarshalledSize();
   marshalSize += 2;  // padding3
   marshalSize += targetLocation.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link LaunchedMunitionRecord#fireEventID}
  * @param pFireEventID new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setFireEventID(EventIdentifier pFireEventID)
{
    fireEventID = pFireEventID;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#fireEventID}
  * @return value of interest */
public EventIdentifier getFireEventID()
{
    return fireEventID; 
}

/** Setter for {@link LaunchedMunitionRecord#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}
/** Utility setter for {@link LaunchedMunitionRecord#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setPadding(int pPadding){
    padding = (short) pPadding;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#padding}
  * @return value of interest */
public short getPadding()
{
    return padding; 
}

/** Setter for {@link LaunchedMunitionRecord#firingEntityID}
  * @param pFiringEntityID new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setFiringEntityID(EntityID pFiringEntityID)
{
    firingEntityID = pFiringEntityID;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#firingEntityID}
  * @return value of interest */
public EntityID getFiringEntityID()
{
    return firingEntityID; 
}

/** Setter for {@link LaunchedMunitionRecord#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}
/** Utility setter for {@link LaunchedMunitionRecord#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setPadding2(int pPadding2){
    padding2 = (short) pPadding2;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#padding2}
  * @return value of interest */
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link LaunchedMunitionRecord#targetEntityID}
  * @param pTargetEntityID new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setTargetEntityID(EntityID pTargetEntityID)
{
    targetEntityID = pTargetEntityID;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#targetEntityID}
  * @return value of interest */
public EntityID getTargetEntityID()
{
    return targetEntityID; 
}

/** Setter for {@link LaunchedMunitionRecord#padding3}
  * @param pPadding3 new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setPadding3(short pPadding3)
{
    padding3 = pPadding3;
    return this;
}
/** Utility setter for {@link LaunchedMunitionRecord#padding3}
  * @param pPadding3 new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setPadding3(int pPadding3){
    padding3 = (short) pPadding3;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#padding3}
  * @return value of interest */
public short getPadding3()
{
    return padding3; 
}

/** Setter for {@link LaunchedMunitionRecord#targetLocation}
  * @param pTargetLocation new value of interest
  * @return same object to permit progressive setters */
public LaunchedMunitionRecord setTargetLocation(Vector3Double pTargetLocation)
{
    targetLocation = pTargetLocation;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#targetLocation}
  * @return value of interest */
public Vector3Double getTargetLocation()
{
    return targetLocation; 
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
       fireEventID.marshal(dos);
       dos.writeShort(padding);
       firingEntityID.marshal(dos);
       dos.writeShort(padding2);
       targetEntityID.marshal(dos);
       dos.writeShort(padding3);
       targetLocation.marshal(dos);
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
        uPosition += fireEventID.unmarshal(dis);
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += firingEntityID.unmarshal(dis);
        padding2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += targetEntityID.unmarshal(dis);
        padding3 = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += targetLocation.unmarshal(dis);
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
   fireEventID.marshal(byteBuffer);
   byteBuffer.putShort( (short)padding);
   firingEntityID.marshal(byteBuffer);
   byteBuffer.putShort( (short)padding2);
   targetEntityID.marshal(byteBuffer);
   byteBuffer.putShort( (short)padding3);
   targetLocation.marshal(byteBuffer);
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
    fireEventID.unmarshal(byteBuffer);
    padding = (short)(byteBuffer.getShort() & 0xFFFF);
    firingEntityID.unmarshal(byteBuffer);
    padding2 = (short)(byteBuffer.getShort() & 0xFFFF);
    targetEntityID.unmarshal(byteBuffer);
    padding3 = (short)(byteBuffer.getShort() & 0xFFFF);
    targetLocation.unmarshal(byteBuffer);
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

     final LaunchedMunitionRecord rhs = (LaunchedMunitionRecord)obj;

     if( ! (fireEventID.equals( rhs.fireEventID) )) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (firingEntityID.equals( rhs.firingEntityID) )) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (targetEntityID.equals( rhs.targetEntityID) )) ivarsEqual = false;
     if( ! (padding3 == rhs.padding3)) ivarsEqual = false;
     if( ! (targetLocation.equals( rhs.targetLocation) )) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" fireEventID: ").append(fireEventID).append("\n");
    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" firingEntityID: ").append(firingEntityID).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");
    sb.append(" targetEntityID: ").append(targetEntityID).append("\n");
    sb.append(" padding3: ").append(padding3).append("\n");
    sb.append(" targetLocation: ").append(targetLocation).append("\n");

   return sb.toString();
 }
} // end of class