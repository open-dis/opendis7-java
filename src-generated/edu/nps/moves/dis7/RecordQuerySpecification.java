/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The identification of the records being queried 6.2.72
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class RecordQuerySpecification extends Object implements Serializable
{
   protected int  numberOfRecords;

   /** variable length list of 32 bit record types uid = 66 */
   protected List< VariableRecordTypes > recordIDs = new ArrayList< VariableRecordTypes >();
 

/** Constructor */
 public RecordQuerySpecification()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // numberOfRecords
   for(int idx=0; idx < recordIDs.size(); idx++)
   {
        VariableRecordTypes listElement = recordIDs.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link RecordQuerySpecification#recordIDs}*/
public RecordQuerySpecification setRecordIDs(List<VariableRecordTypes> pRecordIDs)
{
    recordIDs = pRecordIDs;
    return this;
}

/** Getter for {@link RecordQuerySpecification#recordIDs}*/
public List<VariableRecordTypes> getRecordIDs()
{
    return recordIDs; 
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
       dos.writeInt( (int)recordIDs.size());

       for(int idx = 0; idx < recordIDs.size(); idx++)
       {
            VariableRecordTypes aVariableRecordTypes = recordIDs.get(idx);
            aVariableRecordTypes.marshal(dos);
       }

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
        numberOfRecords = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < numberOfRecords; idx++)
        {
            VariableRecordTypes anX = VariableRecordTypes.unmarshalEnum(dis);
            recordIDs.add(anX);
            uPosition += anX.getMarshalledSize();
        }

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
   buff.putInt( (int)recordIDs.size());

   for(int idx = 0; idx < recordIDs.size(); idx++)
   {
        VariableRecordTypes aVariableRecordTypes = (VariableRecordTypes)recordIDs.get(idx);
        aVariableRecordTypes.marshal(buff);
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
    numberOfRecords = buff.getInt();
    for(int idx = 0; idx < numberOfRecords; idx++)
    {
    VariableRecordTypes anX = VariableRecordTypes.unmarshalEnum(buff);
    recordIDs.add(anX);
    }

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

    if(!(obj instanceof RecordQuerySpecification))
        return false;

     final RecordQuerySpecification rhs = (RecordQuerySpecification)obj;

     if( ! (numberOfRecords == rhs.numberOfRecords)) ivarsEqual = false;

     for(int idx = 0; idx < recordIDs.size(); idx++)
        if( ! ( recordIDs.get(idx).equals(rhs.recordIDs.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
