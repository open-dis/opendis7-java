package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Requires hand coding to be useful. Section 6.2.43
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class IffDataSpecification extends Object implements Serializable
{
   /** Number of iff records */
   protected short  numberOfIffDataRecords;

   /** IFF data records */
   protected List< IFFData > iffDataRecords = new ArrayList< IFFData >();
 

/** Constructor */
 public IffDataSpecification()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // numberOfIffDataRecords
   for(int idx=0; idx < iffDataRecords.size(); idx++)
   {
        IFFData listElement = iffDataRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public IffDataSpecification setIffDataRecords(List<IFFData> pIffDataRecords)
{
    iffDataRecords = pIffDataRecords;
    return this;
}

public List<IFFData> getIffDataRecords()
{
    return iffDataRecords; 
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
       dos.writeShort( (short)iffDataRecords.size());

       for(int idx = 0; idx < iffDataRecords.size(); idx++)
       {
            IFFData aIFFData = iffDataRecords.get(idx);
            aIFFData.marshal(dos);
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
        numberOfIffDataRecords = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfIffDataRecords; idx++)
        {
            IFFData anX = new IFFData();
            uPosition += anX.unmarshal(dis);
            iffDataRecords.add(anX);
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
   buff.putShort( (short)iffDataRecords.size());

   for(int idx = 0; idx < iffDataRecords.size(); idx++)
   {
        IFFData aIFFData = (IFFData)iffDataRecords.get(idx);
        aIFFData.marshal(buff);
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
    numberOfIffDataRecords = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfIffDataRecords; idx++)
    {
    IFFData anX = new IFFData();
    anX.unmarshal(buff);
    iffDataRecords.add(anX);
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

    if(!(obj instanceof IffDataSpecification))
        return false;

     final IffDataSpecification rhs = (IffDataSpecification)obj;

     if( ! (numberOfIffDataRecords == rhs.numberOfIffDataRecords)) ivarsEqual = false;

     for(int idx = 0; idx < iffDataRecords.size(); idx++)
        if( ! ( iffDataRecords.get(idx).equals(rhs.iffDataRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
