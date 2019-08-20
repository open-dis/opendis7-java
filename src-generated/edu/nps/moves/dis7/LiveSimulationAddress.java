/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * A simulation's designation associated with all Live Entity IDs contained in Live Entity PDUs. Section 6.2.55 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class LiveSimulationAddress extends Object implements Serializable
{
   /** facility, installation, organizational unit or geographic location may have multiple sites associated with it. The Site Number is the first component of the Live Simulation Address, which defines a live simulation. */
   protected byte  liveSiteNumber;

   /** An application associated with a live site is termed a live application. Each live application participating in an event  */
   protected byte  liveApplicationNumber;


/** Constructor */
 public LiveSimulationAddress()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // liveSiteNumber
   marshalSize += 1;  // liveApplicationNumber

   return marshalSize;
}


/** Setter for {@link LiveSimulationAddress#liveSiteNumber}*/
public LiveSimulationAddress setLiveSiteNumber(byte pLiveSiteNumber)
{
    liveSiteNumber = pLiveSiteNumber;
    return this;
}

/** Getter for {@link LiveSimulationAddress#liveSiteNumber}*/
public byte getLiveSiteNumber()
{
    return liveSiteNumber; 
}

/** Setter for {@link LiveSimulationAddress#liveApplicationNumber}*/
public LiveSimulationAddress setLiveApplicationNumber(byte pLiveApplicationNumber)
{
    liveApplicationNumber = pLiveApplicationNumber;
    return this;
}

/** Getter for {@link LiveSimulationAddress#liveApplicationNumber}*/
public byte getLiveApplicationNumber()
{
    return liveApplicationNumber; 
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
       dos.writeByte( (byte)liveSiteNumber);
       dos.writeByte( (byte)liveApplicationNumber);
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
        liveSiteNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        liveApplicationNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   buff.put( (byte)liveSiteNumber);
   buff.put( (byte)liveApplicationNumber);
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
    liveSiteNumber = (byte)(buff.get() & 0xFF);
    liveApplicationNumber = (byte)(buff.get() & 0xFF);
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

    if(!(obj instanceof LiveSimulationAddress))
        return false;

     final LiveSimulationAddress rhs = (LiveSimulationAddress)obj;

     if( ! (liveSiteNumber == rhs.liveSiteNumber)) ivarsEqual = false;
     if( ! (liveApplicationNumber == rhs.liveApplicationNumber)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
