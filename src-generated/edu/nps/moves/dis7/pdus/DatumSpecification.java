/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * List of fixed and variable datum records. Section 6.2.18 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class DatumSpecification extends Object implements Serializable
{
   /** Number of fixed datums */
   protected int  numberOfFixedDatums;

   /** Number of variable datums */
   protected int  numberOfVariableDatums;

   /** variable length list fixed datums */
   protected List< FixedDatum > fixedDatumIDList = new ArrayList< FixedDatum >();
 
   /** variable length list of variable datums */
   protected List< VariableDatum > variableDatumIDList = new ArrayList< VariableDatum >();
 

/** Constructor */
 public DatumSpecification()
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

   marshalSize += 4;  // numberOfFixedDatums
   marshalSize += 4;  // numberOfVariableDatums
   for(int idx=0; idx < fixedDatumIDList.size(); idx++)
   {
        FixedDatum listElement = fixedDatumIDList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < variableDatumIDList.size(); idx++)
   {
        VariableDatum listElement = variableDatumIDList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link DatumSpecification#fixedDatumIDList}
  * @param pFixedDatumIDList new value of interest
  * @return same object to permit progressive setters */
public DatumSpecification setFixedDatumIDList(List<FixedDatum> pFixedDatumIDList)
{
    fixedDatumIDList = pFixedDatumIDList;
    return this;
}

/** Getter for {@link DatumSpecification#fixedDatumIDList}
  * @return value of interest */
public List<FixedDatum> getFixedDatumIDList()
{
    return fixedDatumIDList; 
}

/** Setter for {@link DatumSpecification#variableDatumIDList}
  * @param pVariableDatumIDList new value of interest
  * @return same object to permit progressive setters */
public DatumSpecification setVariableDatumIDList(List<VariableDatum> pVariableDatumIDList)
{
    variableDatumIDList = pVariableDatumIDList;
    return this;
}

/** Getter for {@link DatumSpecification#variableDatumIDList}
  * @return value of interest */
public List<VariableDatum> getVariableDatumIDList()
{
    return variableDatumIDList; 
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
       dos.writeInt(fixedDatumIDList.size());
       dos.writeInt(variableDatumIDList.size());

       for(int idx = 0; idx < fixedDatumIDList.size(); idx++)
       {
            FixedDatum aFixedDatum = fixedDatumIDList.get(idx);
            aFixedDatum.marshal(dos);
       }


       for(int idx = 0; idx < variableDatumIDList.size(); idx++)
       {
            VariableDatum aVariableDatum = variableDatumIDList.get(idx);
            aVariableDatum.marshal(dos);
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
        numberOfFixedDatums = dis.readInt();
        uPosition += 4;
        numberOfVariableDatums = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < numberOfFixedDatums; idx++)
        {
            FixedDatum anX = new FixedDatum();
            uPosition += anX.unmarshal(dis);
            fixedDatumIDList.add(anX);
        }

        for(int idx = 0; idx < numberOfVariableDatums; idx++)
        {
            VariableDatum anX = new VariableDatum();
            uPosition += anX.unmarshal(dis);
            variableDatumIDList.add(anX);
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
   byteBuffer.putInt( (int)fixedDatumIDList.size());
   byteBuffer.putInt( (int)variableDatumIDList.size());

   for(int idx = 0; idx < fixedDatumIDList.size(); idx++)
   {
        FixedDatum aFixedDatum = fixedDatumIDList.get(idx);
        aFixedDatum.marshal(byteBuffer);
   }


   for(int idx = 0; idx < variableDatumIDList.size(); idx++)
   {
        VariableDatum aVariableDatum = variableDatumIDList.get(idx);
        aVariableDatum.marshal(byteBuffer);
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
    numberOfFixedDatums = byteBuffer.getInt();
    numberOfVariableDatums = byteBuffer.getInt();
    for(int idx = 0; idx < numberOfFixedDatums; idx++)
    {
    FixedDatum anX = new FixedDatum();
    anX.unmarshal(byteBuffer);
    fixedDatumIDList.add(anX);
    }

    for(int idx = 0; idx < numberOfVariableDatums; idx++)
    {
    VariableDatum anX = new VariableDatum();
    anX.unmarshal(byteBuffer);
    variableDatumIDList.add(anX);
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

     final DatumSpecification rhs = (DatumSpecification)obj;


     for(int idx = 0; idx < fixedDatumIDList.size(); idx++)
        if( ! ( fixedDatumIDList.get(idx).equals(rhs.fixedDatumIDList.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < variableDatumIDList.size(); idx++)
        if( ! ( variableDatumIDList.get(idx).equals(rhs.variableDatumIDList.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" fixedDatumIDList: ").append("\n");
    fixedDatumIDList.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" variableDatumIDList: ").append("\n");
    variableDatumIDList.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
