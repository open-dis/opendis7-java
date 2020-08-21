/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 3 x 8-bit fixed binary
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class LEVector3FixedByte extends Object implements Serializable
{
   /** X value */
   protected byte  x;

   /** y Value */
   protected byte  y;

   /** Z value */
   protected byte  z;


/** Constructor */
 public LEVector3FixedByte()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // x
   marshalSize += 1;  // y
   marshalSize += 1;  // z

   return marshalSize;
}


/** Setter for {@link LEVector3FixedByte#x}*/
public LEVector3FixedByte setX(byte pX)
{
    x = pX;
    return this;
}

/** Getter for {@link LEVector3FixedByte#x}*/
public byte getX()
{
    return x; 
}

/** Setter for {@link LEVector3FixedByte#y}*/
public LEVector3FixedByte setY(byte pY)
{
    y = pY;
    return this;
}

/** Getter for {@link LEVector3FixedByte#y}*/
public byte getY()
{
    return y; 
}

/** Setter for {@link LEVector3FixedByte#z}*/
public LEVector3FixedByte setZ(byte pZ)
{
    z = pZ;
    return this;
}

/** Getter for {@link LEVector3FixedByte#z}*/
public byte getZ()
{
    return z; 
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
       dos.writeByte(x);
       dos.writeByte(y);
       dos.writeByte(z);
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
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        x = (byte)dis.readUnsignedByte();
        uPosition += 1;
        y = (byte)dis.readUnsignedByte();
        uPosition += 1;
        z = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   buff.put( (byte)x);
   buff.put( (byte)y);
   buff.put( (byte)z);
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
    x = (byte)(buff.get() & 0xFF);
    y = (byte)(buff.get() & 0xFF);
    z = (byte)(buff.get() & 0xFF);
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

     final LEVector3FixedByte rhs = (LEVector3FixedByte)obj;

     if( ! (x == rhs.x)) ivarsEqual = false;
     if( ! (y == rhs.y)) ivarsEqual = false;
     if( ! (z == rhs.z)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" x: ").append(x).append("\n");
    sb.append(" y: ").append(y).append("\n");
    sb.append(" z: ").append(z).append("\n");

   return sb.toString();
 }
} // end of class
