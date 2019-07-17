package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * 16 bit fixed binaries
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // referencePoint
   marshalSize += 2;  // deltaX
   marshalSize += 2;  // deltaY
   marshalSize += 2;  // deltaZ

   return marshalSize;
}


public LiveEntityRelativeWorldCoordinates setReferencePoint(short pReferencePoint)
{
    referencePoint = pReferencePoint;
    return this;
}

public short getReferencePoint()
{
    return referencePoint; 
}

public LiveEntityRelativeWorldCoordinates setDeltaX(short pDeltaX)
{
    deltaX = pDeltaX;
    return this;
}

public short getDeltaX()
{
    return deltaX; 
}

public LiveEntityRelativeWorldCoordinates setDeltaY(short pDeltaY)
{
    deltaY = pDeltaY;
    return this;
}

public short getDeltaY()
{
    return deltaY; 
}

public LiveEntityRelativeWorldCoordinates setDeltaZ(short pDeltaZ)
{
    deltaZ = pDeltaZ;
    return this;
}

public short getDeltaZ()
{
    return deltaZ; 
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
 */
public int unmarshal(DataInputStream dis)
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

    if(!(obj instanceof LiveEntityRelativeWorldCoordinates))
        return false;

     final LiveEntityRelativeWorldCoordinates rhs = (LiveEntityRelativeWorldCoordinates)obj;

     if( ! (referencePoint == rhs.referencePoint)) ivarsEqual = false;
     if( ! (deltaX == rhs.deltaX)) ivarsEqual = false;
     if( ! (deltaY == rhs.deltaY)) ivarsEqual = false;
     if( ! (deltaZ == rhs.deltaZ)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
