/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Identity of a communications node. Section 6.2.50
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class LaunchedMunitionRecord extends Object implements Serializable
{
   protected EventIdentifier  fireEventID = new EventIdentifier(); 

   protected short  padding;

   protected EntityID  firingEntityID = new EntityID(); 

   protected short  padding2;

   protected EntityID  targetEntityID = new EntityID(); 

   protected short  padding3;

   protected Vector3Double  targetLocation = new Vector3Double(); 


/** Constructor */
 public LaunchedMunitionRecord()
 {
 }

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link LaunchedMunitionRecord#fireEventID}*/
public LaunchedMunitionRecord setFireEventID(EventIdentifier pFireEventID)
{
    fireEventID = pFireEventID;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#fireEventID}*/
public EventIdentifier getFireEventID()
{
    return fireEventID; 
}

/** Setter for {@link LaunchedMunitionRecord#padding}*/
public LaunchedMunitionRecord setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#padding}*/
public short getPadding()
{
    return padding; 
}

/** Setter for {@link LaunchedMunitionRecord#firingEntityID}*/
public LaunchedMunitionRecord setFiringEntityID(EntityID pFiringEntityID)
{
    firingEntityID = pFiringEntityID;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#firingEntityID}*/
public EntityID getFiringEntityID()
{
    return firingEntityID; 
}

/** Setter for {@link LaunchedMunitionRecord#padding2}*/
public LaunchedMunitionRecord setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#padding2}*/
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link LaunchedMunitionRecord#targetEntityID}*/
public LaunchedMunitionRecord setTargetEntityID(EntityID pTargetEntityID)
{
    targetEntityID = pTargetEntityID;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#targetEntityID}*/
public EntityID getTargetEntityID()
{
    return targetEntityID; 
}

/** Setter for {@link LaunchedMunitionRecord#padding3}*/
public LaunchedMunitionRecord setPadding3(short pPadding3)
{
    padding3 = pPadding3;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#padding3}*/
public short getPadding3()
{
    return padding3; 
}

/** Setter for {@link LaunchedMunitionRecord#targetLocation}*/
public LaunchedMunitionRecord setTargetLocation(Vector3Double pTargetLocation)
{
    targetLocation = pTargetLocation;
    return this;
}

/** Getter for {@link LaunchedMunitionRecord#targetLocation}*/
public Vector3Double getTargetLocation()
{
    return targetLocation; 
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
       fireEventID.marshal(dos);
       dos.writeShort( (short)padding);
       firingEntityID.marshal(dos);
       dos.writeShort( (short)padding2);
       targetEntityID.marshal(dos);
       dos.writeShort( (short)padding3);
       targetLocation.marshal(dos);
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
   fireEventID.marshal(buff);
   buff.putShort( (short)padding);
   firingEntityID.marshal(buff);
   buff.putShort( (short)padding2);
   targetEntityID.marshal(buff);
   buff.putShort( (short)padding3);
   targetLocation.marshal(buff);
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
    fireEventID.unmarshal(buff);
    padding = (short)(buff.getShort() & 0xFFFF);
    firingEntityID.unmarshal(buff);
    padding2 = (short)(buff.getShort() & 0xFFFF);
    targetEntityID.unmarshal(buff);
    padding3 = (short)(buff.getShort() & 0xFFFF);
    targetLocation.unmarshal(buff);
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
    sb.append(getClass().getSimpleName()+":\n");

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
