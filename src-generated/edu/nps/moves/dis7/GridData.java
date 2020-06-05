/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 6.2.41, table 68
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class GridData extends Object implements Serializable
{
   /**  uid 246 */
   protected GriddedDataSampleType sampleType = GriddedDataSampleType.values()[0];

   /**  uid 247 */
   protected GriddedDataDataRepresentation dataRepresentation = GriddedDataDataRepresentation.values()[0];


/** Constructor */
 public GridData()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += sampleType.getMarshalledSize();
   marshalSize += dataRepresentation.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link GridData#sampleType}*/
public GridData setSampleType(GriddedDataSampleType pSampleType)
{
    sampleType = pSampleType;
    return this;
}

/** Getter for {@link GridData#sampleType}*/
public GriddedDataSampleType getSampleType()
{
    return sampleType; 
}

/** Setter for {@link GridData#dataRepresentation}*/
public GridData setDataRepresentation(GriddedDataDataRepresentation pDataRepresentation)
{
    dataRepresentation = pDataRepresentation;
    return this;
}

/** Getter for {@link GridData#dataRepresentation}*/
public GriddedDataDataRepresentation getDataRepresentation()
{
    return dataRepresentation; 
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
       sampleType.marshal(dos);
       dataRepresentation.marshal(dos);
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
        sampleType = GriddedDataSampleType.unmarshalEnum(dis);
        uPosition += sampleType.getMarshalledSize();
        dataRepresentation = GriddedDataDataRepresentation.unmarshalEnum(dis);
        uPosition += dataRepresentation.getMarshalledSize();
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
   sampleType.marshal(buff);
   dataRepresentation.marshal(buff);
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
    sampleType = GriddedDataSampleType.unmarshalEnum(buff);
    dataRepresentation = GriddedDataDataRepresentation.unmarshalEnum(buff);
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

     final GridData rhs = (GridData)obj;

     if( ! (sampleType == rhs.sampleType)) ivarsEqual = false;
     if( ! (dataRepresentation == rhs.dataRepresentation)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" sampleType: ").append(sampleType).append("\n");
    sb.append(" dataRepresentation: ").append(dataRepresentation).append("\n");

   return sb.toString();
 }
} // end of class
