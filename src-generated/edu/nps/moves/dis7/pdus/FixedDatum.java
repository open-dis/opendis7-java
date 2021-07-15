/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Fixed Datum Record. Section 6.2.37
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class FixedDatum extends Object implements Serializable
{
   /** ID of the fixed datum, an enumeration uid 66 */
   protected VariableRecordType fixedDatumID = VariableRecordType.values()[0];

   /** Value for the fixed datum */
   protected int  fixedDatumValue;


/** Constructor */
 public FixedDatum()
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

   marshalSize += fixedDatumID.getMarshalledSize();
   marshalSize += 4;  // fixedDatumValue

   return marshalSize;
}


/** Setter for {@link FixedDatum#fixedDatumID}
  * @param pFixedDatumID new value of interest
  * @return same object to permit progressive setters */
public FixedDatum setFixedDatumID(VariableRecordType pFixedDatumID)
{
    fixedDatumID = pFixedDatumID;
    return this;
}

/** Getter for {@link FixedDatum#fixedDatumID}
  * @return value of interest */
public VariableRecordType getFixedDatumID()
{
    return fixedDatumID; 
}

/** Setter for {@link FixedDatum#fixedDatumValue}
  * @param pFixedDatumValue new value of interest
  * @return same object to permit progressive setters */
public FixedDatum setFixedDatumValue(int pFixedDatumValue)
{
    fixedDatumValue = pFixedDatumValue;
    return this;
}

/** Getter for {@link FixedDatum#fixedDatumValue}
  * @return value of interest */
public int getFixedDatumValue()
{
    return fixedDatumValue; 
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
       fixedDatumID.marshal(dos);
       dos.writeInt(fixedDatumValue);
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
        fixedDatumID = VariableRecordType.unmarshalEnum(dis);
        uPosition += fixedDatumID.getMarshalledSize();
        fixedDatumValue = dis.readInt();
        uPosition += 4;
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
   fixedDatumID.marshal(byteBuffer);
   byteBuffer.putInt( (int)fixedDatumValue);
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
    fixedDatumID = VariableRecordType.unmarshalEnum(byteBuffer);
    fixedDatumValue = byteBuffer.getInt();
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

     final FixedDatum rhs = (FixedDatum)obj;

     if( ! (fixedDatumID == rhs.fixedDatumID)) ivarsEqual = false;
     if( ! (fixedDatumValue == rhs.fixedDatumValue)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" fixedDatumID: ").append(fixedDatumID).append("\n");
    sb.append(" fixedDatumValue: ").append(fixedDatumValue).append("\n");

   return sb.toString();
 }
} // end of class
