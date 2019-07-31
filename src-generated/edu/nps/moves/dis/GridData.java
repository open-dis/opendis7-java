/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

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

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += sampleType.getMarshalledSize();
   marshalSize += dataRepresentation.getMarshalledSize();

   return marshalSize;
}


public GridData setSampleType(GriddedDataSampleType pSampleType)
{
    sampleType = pSampleType;
    return this;
}

public GriddedDataSampleType getSampleType()
{
    return sampleType; 
}

public GridData setDataRepresentation(GriddedDataDataRepresentation pDataRepresentation)
{
    dataRepresentation = pDataRepresentation;
    return this;
}

public GriddedDataDataRepresentation getDataRepresentation()
{
    return dataRepresentation; 
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
 * @see java.io.DataInputStream
 * @param dis The DataInputStream
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis)
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

    if(!(obj instanceof GridData))
        return false;

     final GridData rhs = (GridData)obj;

     if( ! (sampleType == rhs.sampleType)) ivarsEqual = false;
     if( ! (dataRepresentation == rhs.dataRepresentation)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
