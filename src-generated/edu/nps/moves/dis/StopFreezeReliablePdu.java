package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Section 5.3.12.4: Stop freeze simulation, relaible.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class StopFreezeReliablePdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
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
 public StopFreezeReliablePdu()
 {
    setPduType( DISPDUType.STOP_FREEZE_R );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += realWorldTime.getMarshalledSize();
   marshalSize += reason.getMarshalledSize();
   marshalSize += requiredReliablityService.getMarshalledSize();
   marshalSize += 1;  // pad1
   marshalSize += 4;  // requestID

   return marshalSize;
}


public StopFreezeReliablePdu setRealWorldTime(ClockTime pRealWorldTime)
{
    realWorldTime = pRealWorldTime;
    return this;
}

public ClockTime getRealWorldTime()
{
    return realWorldTime; 
}

public StopFreezeReliablePdu setReason(StopFreezeReason pReason)
{
    reason = pReason;
    return this;
}

public StopFreezeReason getReason()
{
    return reason; 
}

public StopFreezeReliablePdu setFrozenBehavior(StopFreezeFrozenBehavior pFrozenBehavior)
{
    frozenBehavior = pFrozenBehavior;
    return this;
}

public StopFreezeFrozenBehavior getFrozenBehavior()
{
    return frozenBehavior; 
}

public StopFreezeReliablePdu setRequiredReliablityService(RequiredReliabilityService pRequiredReliablityService)
{
    requiredReliablityService = pRequiredReliablityService;
    return this;
}

public RequiredReliabilityService getRequiredReliablityService()
{
    return requiredReliablityService; 
}

public StopFreezeReliablePdu setPad1(byte pPad1)
{
    pad1 = pPad1;
    return this;
}

public byte getPad1()
{
    return pad1; 
}

public StopFreezeReliablePdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

public int getRequestID()
{
    return requestID; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
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
 */
public int unmarshal(DataInputStream dis)
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof StopFreezeReliablePdu))
        return false;

     final StopFreezeReliablePdu rhs = (StopFreezeReliablePdu)obj;

     if( ! (realWorldTime.equals( rhs.realWorldTime) )) ivarsEqual = false;
     if( ! (reason == rhs.reason)) ivarsEqual = false;
     if( ! (requiredReliablityService == rhs.requiredReliablityService)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
