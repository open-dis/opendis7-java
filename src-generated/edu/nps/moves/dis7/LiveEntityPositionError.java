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
public class LiveEntityPositionError extends Object implements Serializable
{
   protected short  horizontalError;

   protected short  verticalError;


/** Constructor */
 public LiveEntityPositionError()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // horizontalError
   marshalSize += 2;  // verticalError

   return marshalSize;
}


/** Setter for {@link LiveEntityPositionError#horizontalError}*/
public LiveEntityPositionError setHorizontalError(short pHorizontalError)
{
    horizontalError = pHorizontalError;
    return this;
}

/** Getter for {@link LiveEntityPositionError#horizontalError}*/
public short getHorizontalError()
{
    return horizontalError; 
}

/** Setter for {@link LiveEntityPositionError#verticalError}*/
public LiveEntityPositionError setVerticalError(short pVerticalError)
{
    verticalError = pVerticalError;
    return this;
}

/** Getter for {@link LiveEntityPositionError#verticalError}*/
public short getVerticalError()
{
    return verticalError; 
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
       dos.writeShort( (short)horizontalError);
       dos.writeShort( (short)verticalError);
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
        horizontalError = (short)dis.readUnsignedShort();
        uPosition += 2;
        verticalError = (short)dis.readUnsignedShort();
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
   buff.putShort( (short)horizontalError);
   buff.putShort( (short)verticalError);
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
    horizontalError = (short)(buff.getShort() & 0xFFFF);
    verticalError = (short)(buff.getShort() & 0xFFFF);
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

     final LiveEntityPositionError rhs = (LiveEntityPositionError)obj;

     if( ! (horizontalError == rhs.horizontalError)) ivarsEqual = false;
     if( ! (verticalError == rhs.verticalError)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" horizontalError: ").append(horizontalError).append("\n");
    sb.append(" verticalError: ").append(verticalError).append("\n");

   return sb.toString();
 }
} // end of class
