/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Angular velocity measured in radians per second out each of the entity's own coordinate axes. Order of measurement is angular velocity around the x, y, and z axis of the entity. The positive direction is determined by the right hand rule. Section 6.2.7
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class AngularVelocityVector extends Object implements Serializable
{
   /** velocity about the x axis */
   protected float  x = (float)0;

   /** velocity about the y axis */
   protected float  y = (float)0;

   /** velocity about the zaxis */
   protected float  z = (float)0;


/** Constructor */
 public AngularVelocityVector()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // x
   marshalSize += 4;  // y
   marshalSize += 4;  // z

   return marshalSize;
}


/** Setter for {@link AngularVelocityVector#x}*/
public AngularVelocityVector setX(float pX)
{
    x = pX;
    return this;
}

/** Getter for {@link AngularVelocityVector#x}*/
public float getX()
{
    return x; 
}

/** Setter for {@link AngularVelocityVector#y}*/
public AngularVelocityVector setY(float pY)
{
    y = pY;
    return this;
}

/** Getter for {@link AngularVelocityVector#y}*/
public float getY()
{
    return y; 
}

/** Setter for {@link AngularVelocityVector#z}*/
public AngularVelocityVector setZ(float pZ)
{
    z = pZ;
    return this;
}

/** Getter for {@link AngularVelocityVector#z}*/
public float getZ()
{
    return z; 
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
       dos.writeFloat( (float)x);
       dos.writeFloat( (float)y);
       dos.writeFloat( (float)z);
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
        x = dis.readFloat();
        uPosition += 4;
        y = dis.readFloat();
        uPosition += 4;
        z = dis.readFloat();
        uPosition += 4;
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
   buff.putFloat( (float)x);
   buff.putFloat( (float)y);
   buff.putFloat( (float)z);
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
    x = buff.getFloat();
    y = buff.getFloat();
    z = buff.getFloat();
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

     final AngularVelocityVector rhs = (AngularVelocityVector)obj;

     if( ! (x == rhs.x)) ivarsEqual = false;
     if( ! (y == rhs.y)) ivarsEqual = false;
     if( ! (z == rhs.z)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" x: ").append(x).append("\n");
    sb.append(" y: ").append(y).append("\n");
    sb.append(" z: ").append(z).append("\n");

   return sb.toString();
 }
} // end of class
