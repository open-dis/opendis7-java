/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 16 bit fixed binaries
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class LiveEntityRelativeWorldCoordinates extends Object implements Serializable
{
   protected short  referencePoint;

   protected short  deltaX;

   protected short  deltaY;

   protected short  deltaZ;


/** Constructor */
 public LiveEntityRelativeWorldCoordinates()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // referencePoint
   marshalSize += 2;  // deltaX
   marshalSize += 2;  // deltaY
   marshalSize += 2;  // deltaZ

   return marshalSize;
}


/** Setter for {@link LiveEntityRelativeWorldCoordinates#referencePoint}*/
public LiveEntityRelativeWorldCoordinates setReferencePoint(short pReferencePoint)
{
    referencePoint = pReferencePoint;
    return this;
}

/** Getter for {@link LiveEntityRelativeWorldCoordinates#referencePoint}*/
public short getReferencePoint()
{
    return referencePoint; 
}

/** Setter for {@link LiveEntityRelativeWorldCoordinates#deltaX}*/
public LiveEntityRelativeWorldCoordinates setDeltaX(short pDeltaX)
{
    deltaX = pDeltaX;
    return this;
}

/** Getter for {@link LiveEntityRelativeWorldCoordinates#deltaX}*/
public short getDeltaX()
{
    return deltaX; 
}

/** Setter for {@link LiveEntityRelativeWorldCoordinates#deltaY}*/
public LiveEntityRelativeWorldCoordinates setDeltaY(short pDeltaY)
{
    deltaY = pDeltaY;
    return this;
}

/** Getter for {@link LiveEntityRelativeWorldCoordinates#deltaY}*/
public short getDeltaY()
{
    return deltaY; 
}

/** Setter for {@link LiveEntityRelativeWorldCoordinates#deltaZ}*/
public LiveEntityRelativeWorldCoordinates setDeltaZ(short pDeltaZ)
{
    deltaZ = pDeltaZ;
    return this;
}

/** Getter for {@link LiveEntityRelativeWorldCoordinates#deltaZ}*/
public short getDeltaZ()
{
    return deltaZ; 
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
       dos.writeShort( (short)referencePoint);
       dos.writeShort( (short)deltaX);
       dos.writeShort( (short)deltaY);
       dos.writeShort( (short)deltaZ);
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
        referencePoint = (short)dis.readUnsignedShort();
        uPosition += 2;
        deltaX = (short)dis.readUnsignedShort();
        uPosition += 2;
        deltaY = (short)dis.readUnsignedShort();
        uPosition += 2;
        deltaZ = (short)dis.readUnsignedShort();
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
   buff.putShort( (short)referencePoint);
   buff.putShort( (short)deltaX);
   buff.putShort( (short)deltaY);
   buff.putShort( (short)deltaZ);
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
    referencePoint = (short)(buff.getShort() & 0xFFFF);
    deltaX = (short)(buff.getShort() & 0xFFFF);
    deltaY = (short)(buff.getShort() & 0xFFFF);
    deltaZ = (short)(buff.getShort() & 0xFFFF);
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

     final LiveEntityRelativeWorldCoordinates rhs = (LiveEntityRelativeWorldCoordinates)obj;

     if( ! (referencePoint == rhs.referencePoint)) ivarsEqual = false;
     if( ! (deltaX == rhs.deltaX)) ivarsEqual = false;
     if( ! (deltaY == rhs.deltaY)) ivarsEqual = false;
     if( ! (deltaZ == rhs.deltaZ)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
