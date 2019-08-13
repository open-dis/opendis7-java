/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * List of fixed and variable datum records. Section 6.2.18 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class DatumSpecification extends Object implements Serializable
{
   /** Number of fixed datums */
   protected int  numberOfFixedDatums;

   /** Number of variable datums */
   protected int  numberOfVariableDatums;

   /** variable length list fixed datums */
   protected List< FixedDatum > fixedDatumIDList = new ArrayList< FixedDatum >();
 
   /** variable length list variable datums */
   protected List< VariableDatum > variableDatumIDList = new ArrayList< VariableDatum >();
 

/** Constructor */
 public DatumSpecification()
 {
 }

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


public DatumSpecification setFixedDatumIDList(List<FixedDatum> pFixedDatumIDList)
{
    fixedDatumIDList = pFixedDatumIDList;
    return this;
}

public List<FixedDatum> getFixedDatumIDList()
{
    return fixedDatumIDList; 
}

public DatumSpecification setVariableDatumIDList(List<VariableDatum> pVariableDatumIDList)
{
    variableDatumIDList = pVariableDatumIDList;
    return this;
}

public List<VariableDatum> getVariableDatumIDList()
{
    return variableDatumIDList; 
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
       dos.writeInt( (int)fixedDatumIDList.size());
       dos.writeInt( (int)variableDatumIDList.size());

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
   buff.putInt( (int)fixedDatumIDList.size());
   buff.putInt( (int)variableDatumIDList.size());

   for(int idx = 0; idx < fixedDatumIDList.size(); idx++)
   {
        FixedDatum aFixedDatum = (FixedDatum)fixedDatumIDList.get(idx);
        aFixedDatum.marshal(buff);
   }


   for(int idx = 0; idx < variableDatumIDList.size(); idx++)
   {
        VariableDatum aVariableDatum = (VariableDatum)variableDatumIDList.get(idx);
        aVariableDatum.marshal(buff);
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
    numberOfFixedDatums = buff.getInt();
    numberOfVariableDatums = buff.getInt();
    for(int idx = 0; idx < numberOfFixedDatums; idx++)
    {
    FixedDatum anX = new FixedDatum();
    anX.unmarshal(buff);
    fixedDatumIDList.add(anX);
    }

    for(int idx = 0; idx < numberOfVariableDatums; idx++)
    {
    VariableDatum anX = new VariableDatum();
    anX.unmarshal(buff);
    variableDatumIDList.add(anX);
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

    if(!(obj instanceof DatumSpecification))
        return false;

     final DatumSpecification rhs = (DatumSpecification)obj;

     if( ! (numberOfFixedDatums == rhs.numberOfFixedDatums)) ivarsEqual = false;
     if( ! (numberOfVariableDatums == rhs.numberOfVariableDatums)) ivarsEqual = false;

     for(int idx = 0; idx < fixedDatumIDList.size(); idx++)
        if( ! ( fixedDatumIDList.get(idx).equals(rhs.fixedDatumIDList.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < variableDatumIDList.size(); idx++)
        if( ! ( variableDatumIDList.get(idx).equals(rhs.variableDatumIDList.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
