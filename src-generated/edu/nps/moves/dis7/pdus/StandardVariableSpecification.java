/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Does not work, and causes failure in anything it is embedded in. Section 6.2.83
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class StandardVariableSpecification extends Object implements Serializable
{
   /** Number of static variable records */
   protected short  numberOfStandardVariableRecords;

   /** variable length list of standard variables, The class type and length here are WRONG and will cause the incorrect serialization of any class in whihc it is embedded. */
   protected List< StandardVariableRecord > standardVariables = new ArrayList< StandardVariableRecord >();
 

/** Constructor */
 public StandardVariableSpecification()
 {
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // numberOfStandardVariableRecords
   for(int idx=0; idx < standardVariables.size(); idx++)
   {
        StandardVariableRecord listElement = standardVariables.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public short getNumberOfStandardVariableRecords()
{
    return (short)standardVariables.size(); 
}

/* Note that setting this value will not change the marshalled value. The list whose length this describes is used for that purpose.
 * The getnumberOfStandardVariableRecords method will also be based on the actual list length rather than this value. 
 * The method is simply here for java bean completeness.
 */
public StandardVariableSpecification setNumberOfStandardVariableRecords(short pNumberOfStandardVariableRecords)
{
    numberOfStandardVariableRecords = pNumberOfStandardVariableRecords;
    return this;
}

/** Setter for {@link StandardVariableSpecification#standardVariables}
  * @param pStandardVariables new value of interest
  * @return same object to permit progressive setters */
public StandardVariableSpecification setStandardVariables(List<StandardVariableRecord> pStandardVariables)
{
    standardVariables = pStandardVariables;
    return this;
}

/** Getter for {@link StandardVariableSpecification#standardVariables}
  * @return value of interest */
public List<StandardVariableRecord> getStandardVariables()
{
    return standardVariables; 
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
       dos.writeShort(standardVariables.size());

       for(int idx = 0; idx < standardVariables.size(); idx++)
       {
            StandardVariableRecord aStandardVariableRecord = standardVariables.get(idx);
            aStandardVariableRecord.marshal(dos);
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
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        numberOfStandardVariableRecords = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfStandardVariableRecords; idx++)
        {
            StandardVariableRecord anX = new StandardVariableRecord();
            uPosition += anX.unmarshal(dis);
            standardVariables.add(anX);
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
 * @throws java.nio.BufferOverflowException if byteBuffer is too small
 * @throws java.nio.ReadOnlyBufferException if byteBuffer is read only
 * @see java.nio.ByteBuffer
 * @param byteBuffer The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   byteBuffer.putShort( (short)standardVariables.size());

   for(int idx = 0; idx < standardVariables.size(); idx++)
   {
        StandardVariableRecord aStandardVariableRecord = standardVariables.get(idx);
        aStandardVariableRecord.marshal(byteBuffer);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    numberOfStandardVariableRecords = (short)(byteBuffer.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfStandardVariableRecords; idx++)
    {
    StandardVariableRecord anX = new StandardVariableRecord();
    anX.unmarshal(byteBuffer);
    standardVariables.add(anX);
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

     final StandardVariableSpecification rhs = (StandardVariableSpecification)obj;

     if( ! (numberOfStandardVariableRecords == rhs.numberOfStandardVariableRecords)) ivarsEqual = false;

     for(int idx = 0; idx < standardVariables.size(); idx++)
        if( ! ( standardVariables.get(idx).equals(rhs.standardVariables.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" numberOfStandardVariableRecords: ").append(numberOfStandardVariableRecords).append("\n");
    sb.append(" standardVariables: ").append("\n");
    standardVariables.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
