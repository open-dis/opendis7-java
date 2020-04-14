/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The unique designation of a minefield Section 6.2.56 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class MinefieldIdentifier extends Object implements Serializable
{
   /**  */
   protected SimulationAddress  simulationAddress = new SimulationAddress(); 

   /**  */
   protected short  minefieldNumber;


/** Constructor */
 public MinefieldIdentifier()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += simulationAddress.getMarshalledSize();
   marshalSize += 2;  // minefieldNumber

   return marshalSize;
}


/** Setter for {@link MinefieldIdentifier#simulationAddress}*/
public MinefieldIdentifier setSimulationAddress(SimulationAddress pSimulationAddress)
{
    simulationAddress = pSimulationAddress;
    return this;
}

/** Getter for {@link MinefieldIdentifier#simulationAddress}*/
public SimulationAddress getSimulationAddress()
{
    return simulationAddress; 
}

/** Setter for {@link MinefieldIdentifier#minefieldNumber}*/
public MinefieldIdentifier setMinefieldNumber(short pMinefieldNumber)
{
    minefieldNumber = pMinefieldNumber;
    return this;
}

/** Getter for {@link MinefieldIdentifier#minefieldNumber}*/
public short getMinefieldNumber()
{
    return minefieldNumber; 
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
       simulationAddress.marshal(dos);
       dos.writeShort( (short)minefieldNumber);
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
        uPosition += simulationAddress.unmarshal(dis);
        minefieldNumber = (short)dis.readUnsignedShort();
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
   simulationAddress.marshal(buff);
   buff.putShort( (short)minefieldNumber);
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
    simulationAddress.unmarshal(buff);
    minefieldNumber = (short)(buff.getShort() & 0xFFFF);
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

     final MinefieldIdentifier rhs = (MinefieldIdentifier)obj;

     if( ! (simulationAddress.equals( rhs.simulationAddress) )) ivarsEqual = false;
     if( ! (minefieldNumber == rhs.minefieldNumber)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" simulationAddress: ").append(simulationAddress).append("\n");
    sb.append(" minefieldNumber: ").append(minefieldNumber).append("\n");

   return sb.toString();
 }
} // end of class
