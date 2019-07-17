package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Section 7.5.5. Stop or freeze an enity (or exercise).
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class StopFreezePdu extends SimulationManagementFamilyPdu implements Serializable
{
   /** real-world(UTC) time at which the entity shall stop or freeze in the exercise */
   protected ClockTime  realWorldTime = new ClockTime(); 

   /** Reason the simulation was stopped or frozen (see section 7 of SISO-REF-010) represented by an 8-bit enumeration uid 67 */
   protected StopFreezeReason reason = StopFreezeReason.values()[0];

   /** Internal behavior of the entity(or simulation) and its appearance while frozen to the other participants uid 68 */
   protected StopFreezeFrozenBehavior frozenBehavior = new StopFreezeFrozenBehavior();

   /** padding */
   protected short  padding1 = (short)0;

   /** Request ID that is unique */
   protected int  requestID;


/** Constructor */
 public StopFreezePdu()
 {
    setPduType( DISPDUType.STOP_FREEZE );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += realWorldTime.getMarshalledSize();
   marshalSize += reason.getMarshalledSize();
   marshalSize += 2;  // padding1
   marshalSize += 4;  // requestID

   return marshalSize;
}


public StopFreezePdu setRealWorldTime(ClockTime pRealWorldTime)
{
    realWorldTime = pRealWorldTime;
    return this;
}

public ClockTime getRealWorldTime()
{
    return realWorldTime; 
}

public StopFreezePdu setReason(StopFreezeReason pReason)
{
    reason = pReason;
    return this;
}

public StopFreezeReason getReason()
{
    return reason; 
}

public StopFreezePdu setFrozenBehavior(StopFreezeFrozenBehavior pFrozenBehavior)
{
    frozenBehavior = pFrozenBehavior;
    return this;
}

public StopFreezeFrozenBehavior getFrozenBehavior()
{
    return frozenBehavior; 
}

public StopFreezePdu setPadding1(short pPadding1)
{
    padding1 = pPadding1;
    return this;
}

public short getPadding1()
{
    return padding1; 
}

public StopFreezePdu setRequestID(int pRequestID)
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
       dos.writeShort( (short)padding1);
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
        padding1 = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   buff.putShort( (short)padding1);
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
    padding1 = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof StopFreezePdu))
        return false;

     final StopFreezePdu rhs = (StopFreezePdu)obj;

     if( ! (realWorldTime.equals( rhs.realWorldTime) )) ivarsEqual = false;
     if( ! (reason == rhs.reason)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
