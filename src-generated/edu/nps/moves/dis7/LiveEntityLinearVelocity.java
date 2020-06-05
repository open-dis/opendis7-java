/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 16 bit fixed binaries
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class LiveEntityLinearVelocity extends Object implements Serializable
{
   protected short  xComponent;

   protected short  yComponent;

   protected short  zComponent;


/** Constructor */
 public LiveEntityLinearVelocity()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // xComponent
   marshalSize += 2;  // yComponent
   marshalSize += 2;  // zComponent

   return marshalSize;
}


/** Setter for {@link LiveEntityLinearVelocity#xComponent}*/
public LiveEntityLinearVelocity setXComponent(short pXComponent)
{
    xComponent = pXComponent;
    return this;
}

/** Getter for {@link LiveEntityLinearVelocity#xComponent}*/
public short getXComponent()
{
    return xComponent; 
}

/** Setter for {@link LiveEntityLinearVelocity#yComponent}*/
public LiveEntityLinearVelocity setYComponent(short pYComponent)
{
    yComponent = pYComponent;
    return this;
}

/** Getter for {@link LiveEntityLinearVelocity#yComponent}*/
public short getYComponent()
{
    return yComponent; 
}

/** Setter for {@link LiveEntityLinearVelocity#zComponent}*/
public LiveEntityLinearVelocity setZComponent(short pZComponent)
{
    zComponent = pZComponent;
    return this;
}

/** Getter for {@link LiveEntityLinearVelocity#zComponent}*/
public short getZComponent()
{
    return zComponent; 
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
       dos.writeShort(xComponent);
       dos.writeShort(yComponent);
       dos.writeShort(zComponent);
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
        xComponent = (short)dis.readUnsignedShort();
        uPosition += 2;
        yComponent = (short)dis.readUnsignedShort();
        uPosition += 2;
        zComponent = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   buff.putShort( (short)xComponent);
   buff.putShort( (short)yComponent);
   buff.putShort( (short)zComponent);
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
    xComponent = (short)(buff.getShort() & 0xFFFF);
    yComponent = (short)(buff.getShort() & 0xFFFF);
    zComponent = (short)(buff.getShort() & 0xFFFF);
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

     final LiveEntityLinearVelocity rhs = (LiveEntityLinearVelocity)obj;

     if( ! (xComponent == rhs.xComponent)) ivarsEqual = false;
     if( ! (yComponent == rhs.yComponent)) ivarsEqual = false;
     if( ! (zComponent == rhs.zComponent)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" xComponent: ").append(xComponent).append("\n");
    sb.append(" yComponent: ").append(yComponent).append("\n");
    sb.append(" zComponent: ").append(zComponent).append("\n");

   return sb.toString();
 }
} // end of class
