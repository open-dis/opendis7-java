/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The unique designation of each entity in an event or exercise that is contained in a Live Entity PDU. Section 6.2.54 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class LiveEntityIdentifier extends Object implements Serializable
{
   /** Live Simulation Address record (see 6.2.54)  */
   protected LiveSimulationAddress  liveSimulationAddress = new LiveSimulationAddress(); 

   /** Live entity number  */
   protected short  entityNumber;


/** Constructor */
 public LiveEntityIdentifier()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += liveSimulationAddress.getMarshalledSize();
   marshalSize += 2;  // entityNumber

   return marshalSize;
}


/** Setter for {@link LiveEntityIdentifier#liveSimulationAddress}*/
public LiveEntityIdentifier setLiveSimulationAddress(LiveSimulationAddress pLiveSimulationAddress)
{
    liveSimulationAddress = pLiveSimulationAddress;
    return this;
}

/** Getter for {@link LiveEntityIdentifier#liveSimulationAddress}*/
public LiveSimulationAddress getLiveSimulationAddress()
{
    return liveSimulationAddress; 
}

/** Setter for {@link LiveEntityIdentifier#entityNumber}*/
public LiveEntityIdentifier setEntityNumber(short pEntityNumber)
{
    entityNumber = pEntityNumber;
    return this;
}

/** Getter for {@link LiveEntityIdentifier#entityNumber}*/
public short getEntityNumber()
{
    return entityNumber; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       liveSimulationAddress.marshal(dos);
       dos.writeShort( (short)entityNumber);
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
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        uPosition += liveSimulationAddress.unmarshal(dis);
        entityNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   liveSimulationAddress.marshal(buff);
   buff.putShort( (short)entityNumber);
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
    liveSimulationAddress.unmarshal(buff);
    entityNumber = (short)(buff.getShort() & 0xFFFF);
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

     final LiveEntityIdentifier rhs = (LiveEntityIdentifier)obj;

     if( ! (liveSimulationAddress.equals( rhs.liveSimulationAddress) )) ivarsEqual = false;
     if( ! (entityNumber == rhs.entityNumber)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" liveSimulationAddress: ").append(liveSimulationAddress).append("\n");
    sb.append(" entityNumber: ").append(entityNumber).append("\n");

   return sb.toString();
 }
} // end of class
