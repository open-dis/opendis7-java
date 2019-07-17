package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Used for XML compatability. A container that holds PDUs
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class PduContainer extends Object implements Serializable
{
   /** Number of PDUs in the container list */
   protected int  numberOfPdus;

   /** record sets */
   protected List< Pdu > pdus = new ArrayList< Pdu >();
 

/** Constructor */
 public PduContainer()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // numberOfPdus
   for(int idx=0; idx < pdus.size(); idx++)
   {
        Pdu listElement = pdus.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public PduContainer setPdus(List<Pdu> pPdus)
{
    pdus = pPdus;
    return this;
}

public List<Pdu> getPdus()
{
    return pdus; 
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
       dos.writeInt( (int)pdus.size());

       for(int idx = 0; idx < pdus.size(); idx++)
       {
            Pdu aPdu = pdus.get(idx);
            aPdu.marshal(dos);
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
 */
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    try 
    {
        numberOfPdus = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < numberOfPdus; idx++)
        {
            Pdu anX = new Pdu();
            uPosition += anX.unmarshal(dis);
            pdus.add(anX);
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
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.putInt( (int)pdus.size());

   for(int idx = 0; idx < pdus.size(); idx++)
   {
        Pdu aPdu = (Pdu)pdus.get(idx);
        aPdu.marshal(buff);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    numberOfPdus = buff.getInt();
    for(int idx = 0; idx < numberOfPdus; idx++)
    {
    Pdu anX = new Pdu();
    anX.unmarshal(buff);
    pdus.add(anX);
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

    if(!(obj instanceof PduContainer))
        return false;

     final PduContainer rhs = (PduContainer)obj;

     if( ! (numberOfPdus == rhs.numberOfPdus)) ivarsEqual = false;

     for(int idx = 0; idx < pdus.size(); idx++)
        if( ! ( pdus.get(idx).equals(rhs.pdus.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
