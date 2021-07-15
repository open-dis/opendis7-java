/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 16-bit fixed binaries
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class LiveEntityOrientationError extends Object implements Serializable
{
   /** azimuthError is an undescribed parameter... */
   protected short  azimuthError;

   /** elevationError is an undescribed parameter... */
   protected short  elevationError;

   /** rotationError is an undescribed parameter... */
   protected short  rotationError;


/** Constructor */
 public LiveEntityOrientationError()
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

   marshalSize += 2;  // azimuthError
   marshalSize += 2;  // elevationError
   marshalSize += 2;  // rotationError

   return marshalSize;
}


/** Setter for {@link LiveEntityOrientationError#azimuthError}
  * @param pAzimuthError new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientationError setAzimuthError(short pAzimuthError)
{
    azimuthError = pAzimuthError;
    return this;
}
/** Utility setter for {@link LiveEntityOrientationError#azimuthError}
  * @param pAzimuthError new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientationError setAzimuthError(int pAzimuthError){
    azimuthError = (short) pAzimuthError;
    return this;
}

/** Getter for {@link LiveEntityOrientationError#azimuthError}
  * @return value of interest */
public short getAzimuthError()
{
    return azimuthError; 
}

/** Setter for {@link LiveEntityOrientationError#elevationError}
  * @param pElevationError new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientationError setElevationError(short pElevationError)
{
    elevationError = pElevationError;
    return this;
}
/** Utility setter for {@link LiveEntityOrientationError#elevationError}
  * @param pElevationError new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientationError setElevationError(int pElevationError){
    elevationError = (short) pElevationError;
    return this;
}

/** Getter for {@link LiveEntityOrientationError#elevationError}
  * @return value of interest */
public short getElevationError()
{
    return elevationError; 
}

/** Setter for {@link LiveEntityOrientationError#rotationError}
  * @param pRotationError new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientationError setRotationError(short pRotationError)
{
    rotationError = pRotationError;
    return this;
}
/** Utility setter for {@link LiveEntityOrientationError#rotationError}
  * @param pRotationError new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientationError setRotationError(int pRotationError){
    rotationError = (short) pRotationError;
    return this;
}

/** Getter for {@link LiveEntityOrientationError#rotationError}
  * @return value of interest */
public short getRotationError()
{
    return rotationError; 
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
       dos.writeShort(azimuthError);
       dos.writeShort(elevationError);
       dos.writeShort(rotationError);
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
        azimuthError = (short)dis.readUnsignedShort();
        uPosition += 2;
        elevationError = (short)dis.readUnsignedShort();
        uPosition += 2;
        rotationError = (short)dis.readUnsignedShort();
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
 * @throws java.nio.BufferOverflowException if byteBuffer is too small
 * @throws java.nio.ReadOnlyBufferException if byteBuffer is read only
 * @see java.nio.ByteBuffer
 * @param byteBuffer The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   byteBuffer.putShort( (short)azimuthError);
   byteBuffer.putShort( (short)elevationError);
   byteBuffer.putShort( (short)rotationError);
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
    azimuthError = (short)(byteBuffer.getShort() & 0xFFFF);
    elevationError = (short)(byteBuffer.getShort() & 0xFFFF);
    rotationError = (short)(byteBuffer.getShort() & 0xFFFF);
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

     final LiveEntityOrientationError rhs = (LiveEntityOrientationError)obj;

     if( ! (azimuthError == rhs.azimuthError)) ivarsEqual = false;
     if( ! (elevationError == rhs.elevationError)) ivarsEqual = false;
     if( ! (rotationError == rhs.rotationError)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" azimuthError: ").append(azimuthError).append("\n");
    sb.append(" elevationError: ").append(elevationError).append("\n");
    sb.append(" rotationError: ").append(rotationError).append("\n");

   return sb.toString();
 }
} // end of class
