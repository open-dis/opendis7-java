/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public abstract class SimulationManagementWithReliabilityFamilyPdu extends PduBase implements Serializable
{
   /** IDs the simulation or entity, either a simulation or an entity. Either 6.2.80 or 6.2.28 */
   protected SimulationIdentifier  originatingID = new SimulationIdentifier(); 

   /** simulation, all simulations, a special ID, or an entity. See 5.6.5 and 5.12.4 */
   protected SimulationIdentifier  receivingID = new SimulationIdentifier(); 


/** Constructor */
 public SimulationManagementWithReliabilityFamilyPdu()
 {
    setProtocolFamily( DISProtocolFamily.SIMULATION_MANAGEMENT_WITH_RELIABILITY );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += originatingID.getMarshalledSize();
   marshalSize += receivingID.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link SimulationManagementWithReliabilityFamilyPdu#originatingID}*/
public SimulationManagementWithReliabilityFamilyPdu setOriginatingID(SimulationIdentifier pOriginatingID)
{
    originatingID = pOriginatingID;
    return this;
}

/** Getter for {@link SimulationManagementWithReliabilityFamilyPdu#originatingID}*/
public SimulationIdentifier getOriginatingID()
{
    return originatingID; 
}

/** Setter for {@link SimulationManagementWithReliabilityFamilyPdu#receivingID}*/
public SimulationManagementWithReliabilityFamilyPdu setReceivingID(SimulationIdentifier pReceivingID)
{
    receivingID = pReceivingID;
    return this;
}

/** Getter for {@link SimulationManagementWithReliabilityFamilyPdu#receivingID}*/
public SimulationIdentifier getReceivingID()
{
    return receivingID; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       originatingID.marshal(dos);
       receivingID.marshal(dos);
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
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += originatingID.unmarshal(dis);
        uPosition += receivingID.unmarshal(dis);
    }
    catch(Exception e)
    { 
      System.err.println(e); 
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
   super.marshal(buff);
   originatingID.marshal(buff);
   receivingID.marshal(buff);
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
    super.unmarshal(buff);

    originatingID.unmarshal(buff);
    receivingID.unmarshal(buff);
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final SimulationManagementWithReliabilityFamilyPdu rhs = (SimulationManagementWithReliabilityFamilyPdu)obj;

     if( ! (originatingID.equals( rhs.originatingID) )) ivarsEqual = false;
     if( ! (receivingID.equals( rhs.receivingID) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" originatingID: ").append(originatingID).append("\n");
    sb.append(" receivingID: ").append(receivingID).append("\n");

   return sb.toString();
 }
} // end of class
