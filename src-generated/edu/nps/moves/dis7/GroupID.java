/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Unique designation of a group of entities contained in the isGroupOfPdu. Represents a group of entities rather than a single entity. Section 6.2.43
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class GroupID extends Object implements Serializable
{
   /** Simulation address (site and application number) */
   protected SimulationAddress  simulationAddress = new SimulationAddress(); 

   /** group number */
   protected short  groupNumber;


/** Constructor */
 public GroupID()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += simulationAddress.getMarshalledSize();
   marshalSize += 2;  // groupNumber

   return marshalSize;
}


/** Setter for {@link GroupID#simulationAddress}*/
public GroupID setSimulationAddress(SimulationAddress pSimulationAddress)
{
    simulationAddress = pSimulationAddress;
    return this;
}

/** Getter for {@link GroupID#simulationAddress}*/
public SimulationAddress getSimulationAddress()
{
    return simulationAddress; 
}

/** Setter for {@link GroupID#groupNumber}*/
public GroupID setGroupNumber(short pGroupNumber)
{
    groupNumber = pGroupNumber;
    return this;
}

/** Getter for {@link GroupID#groupNumber}*/
public short getGroupNumber()
{
    return groupNumber; 
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
       simulationAddress.marshal(dos);
       dos.writeShort( (short)groupNumber);
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
        uPosition += simulationAddress.unmarshal(dis);
        groupNumber = (short)dis.readUnsignedShort();
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
   buff.putShort( (short)groupNumber);
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
    groupNumber = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof GroupID))
        return false;

     final GroupID rhs = (GroupID)obj;

     if( ! (simulationAddress.equals( rhs.simulationAddress) )) ivarsEqual = false;
     if( ! (groupNumber == rhs.groupNumber)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
