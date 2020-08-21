/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * This record shall specify the number of record sets contained in the Record Specification record and the record details. Section 6.2.73.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class RecordSpecification extends Object implements Serializable
{
   /** The number of record sets */
   protected int  numberOfRecordSets;

   /** variable length list record specifications. */
   protected List< RecordSpecificationElement > recordSets = new ArrayList< RecordSpecificationElement >();
 

/** Constructor */
 public RecordSpecification()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // numberOfRecordSets
   for(int idx=0; idx < recordSets.size(); idx++)
   {
        RecordSpecificationElement listElement = recordSets.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link RecordSpecification#recordSets}*/
public RecordSpecification setRecordSets(List<RecordSpecificationElement> pRecordSets)
{
    recordSets = pRecordSets;
    return this;
}

/** Getter for {@link RecordSpecification#recordSets}*/
public List<RecordSpecificationElement> getRecordSets()
{
    return recordSets; 
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
       dos.writeInt(recordSets.size());

       for(int idx = 0; idx < recordSets.size(); idx++)
       {
            RecordSpecificationElement aRecordSpecificationElement = recordSets.get(idx);
            aRecordSpecificationElement.marshal(dos);
       }

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
        numberOfRecordSets = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < numberOfRecordSets; idx++)
        {
            RecordSpecificationElement anX = new RecordSpecificationElement();
            uPosition += anX.unmarshal(dis);
            recordSets.add(anX);
        }

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
   buff.putInt( (int)recordSets.size());

   for(int idx = 0; idx < recordSets.size(); idx++)
   {
        RecordSpecificationElement aRecordSpecificationElement = recordSets.get(idx);
        aRecordSpecificationElement.marshal(buff);
   }

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
    numberOfRecordSets = buff.getInt();
    for(int idx = 0; idx < numberOfRecordSets; idx++)
    {
    RecordSpecificationElement anX = new RecordSpecificationElement();
    anX.unmarshal(buff);
    recordSets.add(anX);
    }

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

     final RecordSpecification rhs = (RecordSpecification)obj;


     for(int idx = 0; idx < recordSets.size(); idx++)
        if( ! ( recordSets.get(idx).equals(rhs.recordSets.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" recordSets: ").append("\n");
    recordSets.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
