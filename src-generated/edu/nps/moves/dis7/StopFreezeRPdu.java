/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.12.4.5 Serves the same function as the Stop/Freeze PDU (see 5.6.5.5.1) but with the addition of reliability service levels.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class StopFreezeRPdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
{
   /** time in real world for this operation to happen */
   protected ClockTime  realWorldTime = new ClockTime(); 

   /** Reason for stopping/freezing simulation uid 67 */
   protected StopFreezeReason reason = StopFreezeReason.values()[0];

   /** internal behvior of the simulation while frozen uid 68 */
   protected StopFreezeFrozenBehavior frozenBehavior = new StopFreezeFrozenBehavior();

   /** reliablity level uid 74 */
   protected RequiredReliabilityService requiredReliablityService = RequiredReliabilityService.values()[0];

   /** padding */
   protected byte  pad1;

   /** Request ID */
   protected int  requestID;


/** Constructor */
 public StopFreezeRPdu()
 {
    setPduType( DISPDUType.STOP_FREEZE_RELIABLE );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += realWorldTime.getMarshalledSize();
   marshalSize += reason.getMarshalledSize();
   marshalSize += frozenBehavior.getMarshalledSize();
   marshalSize += requiredReliablityService.getMarshalledSize();
   marshalSize += 1;  // pad1
   marshalSize += 4;  // requestID

   return marshalSize;
}


/** Setter for {@link StopFreezeRPdu#realWorldTime}*/
public StopFreezeRPdu setRealWorldTime(ClockTime pRealWorldTime)
{
    realWorldTime = pRealWorldTime;
    return this;
}

/** Getter for {@link StopFreezeRPdu#realWorldTime}*/
public ClockTime getRealWorldTime()
{
    return realWorldTime; 
}

/** Setter for {@link StopFreezeRPdu#reason}*/
public StopFreezeRPdu setReason(StopFreezeReason pReason)
{
    reason = pReason;
    return this;
}

/** Getter for {@link StopFreezeRPdu#reason}*/
public StopFreezeReason getReason()
{
    return reason; 
}

/** Setter for {@link StopFreezeRPdu#frozenBehavior}*/
public StopFreezeRPdu setFrozenBehavior(StopFreezeFrozenBehavior pFrozenBehavior)
{
    frozenBehavior = pFrozenBehavior;
    return this;
}

/** Setter for {@link StopFreezeRPdu#frozenBehavior}*/
public StopFreezeFrozenBehavior getFrozenBehavior()
{
    return frozenBehavior; 
}

/** Setter for {@link StopFreezeRPdu#requiredReliablityService}*/
public StopFreezeRPdu setRequiredReliablityService(RequiredReliabilityService pRequiredReliablityService)
{
    requiredReliablityService = pRequiredReliablityService;
    return this;
}

/** Getter for {@link StopFreezeRPdu#requiredReliablityService}*/
public RequiredReliabilityService getRequiredReliablityService()
{
    return requiredReliablityService; 
}

/** Setter for {@link StopFreezeRPdu#pad1}*/
public StopFreezeRPdu setPad1(byte pPad1)
{
    pad1 = pPad1;
    return this;
}

/** Getter for {@link StopFreezeRPdu#pad1}*/
public byte getPad1()
{
    return pad1; 
}

/** Setter for {@link StopFreezeRPdu#requestID}*/
public StopFreezeRPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link StopFreezeRPdu#requestID}*/
public int getRequestID()
{
    return requestID; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       realWorldTime.marshal(dos);
       reason.marshal(dos);
       frozenBehavior.marshal(dos);
       requiredReliablityService.marshal(dos);
       dos.writeByte( (byte)pad1);
       dos.writeInt( (int)requestID);
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
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += realWorldTime.unmarshal(dis);
        reason = StopFreezeReason.unmarshalEnum(dis);
        uPosition += reason.getMarshalledSize();
        uPosition += frozenBehavior.unmarshal(dis);
        requiredReliablityService = RequiredReliabilityService.unmarshalEnum(dis);
        uPosition += requiredReliablityService.getMarshalledSize();
        pad1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        requestID = dis.readInt();
        uPosition += 4;
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
   super.marshal(buff);
   realWorldTime.marshal(buff);
   reason.marshal(buff);
   frozenBehavior.marshal(buff);
   requiredReliablityService.marshal(buff);
   buff.put( (byte)pad1);
   buff.putInt( (int)requestID);
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

    realWorldTime.unmarshal(buff);
    reason = StopFreezeReason.unmarshalEnum(buff);
    frozenBehavior.unmarshal(buff);
    requiredReliablityService = RequiredReliabilityService.unmarshalEnum(buff);
    pad1 = (byte)(buff.get() & 0xFF);
    requestID = buff.getInt();
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

     final StopFreezeRPdu rhs = (StopFreezeRPdu)obj;

     if( ! (realWorldTime.equals( rhs.realWorldTime) )) ivarsEqual = false;
     if( ! (reason == rhs.reason)) ivarsEqual = false;
     if( ! (frozenBehavior.equals( rhs.frozenBehavior) )) ivarsEqual = false;
     if( ! (requiredReliablityService == rhs.requiredReliablityService)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" realWorldTime: ").append(realWorldTime).append("\n");
    sb.append(" reason: ").append(reason).append("\n");
    sb.append(" frozenBehavior: ").append(frozenBehavior).append("\n");
    sb.append(" requiredReliablityService: ").append(requiredReliablityService).append("\n");
    sb.append(" pad1: ").append(pad1).append("\n");
    sb.append(" requestID: ").append(requestID).append("\n");

   return sb.toString();
 }
} // end of class
