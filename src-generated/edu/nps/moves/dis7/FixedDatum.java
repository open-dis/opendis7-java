/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Fixed Datum Record. Section 6.2.38
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += fixedDatumID.getMarshalledSize();
   marshalSize += 4;  // fixedDatumValue

   return marshalSize;
}


/** Setter for {@link FixedDatum#fixedDatumID}*/
public FixedDatum setFixedDatumID(VariableRecordType pFixedDatumID)
{
    fixedDatumID = pFixedDatumID;
    return this;
}

/** Getter for {@link FixedDatum#fixedDatumID}*/
public VariableRecordType getFixedDatumID()
{
    return fixedDatumID; 
}

/** Setter for {@link FixedDatum#fixedDatumValue}*/
public FixedDatum setFixedDatumValue(int pFixedDatumValue)
{
    fixedDatumValue = pFixedDatumValue;
    return this;
}

/** Getter for {@link FixedDatum#fixedDatumValue}*/
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
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   fixedDatumID.marshal(buff);
   buff.putInt( (int)fixedDatumValue);
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
    fixedDatumID = VariableRecordType.unmarshalEnum(buff);
    fixedDatumValue = buff.getInt();
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
