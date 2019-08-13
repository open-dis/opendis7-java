/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
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


public LaunchedMunitionRecord setFireEventID(EventIdentifier pFireEventID)
{
    fireEventID = pFireEventID;
    return this;
}

public EventIdentifier getFireEventID()
{
    return fireEventID; 
}

public LaunchedMunitionRecord setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

public short getPadding()
{
    return padding; 
}

public LaunchedMunitionRecord setFiringEntityID(EntityID pFiringEntityID)
{
    firingEntityID = pFiringEntityID;
    return this;
}

public EntityID getFiringEntityID()
{
    return firingEntityID; 
}

public LaunchedMunitionRecord setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

public short getPadding2()
{
    return padding2; 
}

public LaunchedMunitionRecord setTargetEntityID(EntityID pTargetEntityID)
{
    targetEntityID = pTargetEntityID;
    return this;
}

public EntityID getTargetEntityID()
{
    return targetEntityID; 
}

public LaunchedMunitionRecord setPadding3(short pPadding3)
{
    padding3 = pPadding3;
    return this;
}

public short getPadding3()
{
    return padding3; 
}

public LaunchedMunitionRecord setTargetLocation(Vector3Double pTargetLocation)
{
    targetLocation = pTargetLocation;
    return this;
}

public Vector3Double getTargetLocation()
{
    return targetLocation; 
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
public int unmarshal(DataInputStream dis)
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

    if(!(obj instanceof LaunchedMunitionRecord))
        return false;

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
} // end of class
