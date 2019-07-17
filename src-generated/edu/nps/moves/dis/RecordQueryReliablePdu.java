package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Section 5.3.12.13: A request for one or more records of data from an entity.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class RecordQueryReliablePdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
{
   /** request ID */
   protected int  requestID;

   /** level of reliability service used for this transaction uid 74 */
   protected RequiredReliabilityService requiredReliabilityService = RequiredReliabilityService.values()[0];

   /** padding */
   protected byte  pad1;

   /** event type uid 334 */
   protected RecordQueryREventType eventType = RecordQueryREventType.values()[0];

   /** time */
   protected int  time;

   /** numberOfRecords */
   protected int  numberOfRecords;

   /** record IDs */
   protected List< RecordQuerySpecification > recordIDs = new ArrayList< RecordQuerySpecification >();
 

/** Constructor */
 public RecordQueryReliablePdu()
 {
    setPduType( DISPDUType.RECORD_QUERY_R );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 4;  // requestID
   marshalSize += requiredReliabilityService.getMarshalledSize();
   marshalSize += 1;  // pad1
   marshalSize += eventType.getMarshalledSize();
   marshalSize += 4;  // time
   marshalSize += 4;  // numberOfRecords
   for(int idx=0; idx < recordIDs.size(); idx++)
   {
        RecordQuerySpecification listElement = recordIDs.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public RecordQueryReliablePdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

public int getRequestID()
{
    return requestID; 
}

public RecordQueryReliablePdu setRequiredReliabilityService(RequiredReliabilityService pRequiredReliabilityService)
{
    requiredReliabilityService = pRequiredReliabilityService;
    return this;
}

public RequiredReliabilityService getRequiredReliabilityService()
{
    return requiredReliabilityService; 
}

public RecordQueryReliablePdu setPad1(byte pPad1)
{
    pad1 = pPad1;
    return this;
}

public byte getPad1()
{
    return pad1; 
}

public RecordQueryReliablePdu setEventType(RecordQueryREventType pEventType)
{
    eventType = pEventType;
    return this;
}

public RecordQueryREventType getEventType()
{
    return eventType; 
}

public RecordQueryReliablePdu setTime(int pTime)
{
    time = pTime;
    return this;
}

public int getTime()
{
    return time; 
}

public RecordQueryReliablePdu setRecordIDs(List<RecordQuerySpecification> pRecordIDs)
{
    recordIDs = pRecordIDs;
    return this;
}

public List<RecordQuerySpecification> getRecordIDs()
{
    return recordIDs; 
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
       dos.writeInt( (int)requestID);
       requiredReliabilityService.marshal(dos);
       dos.writeByte( (byte)pad1);
       eventType.marshal(dos);
       dos.writeInt( (int)time);
       dos.writeInt( (int)recordIDs.size());

       for(int idx = 0; idx < recordIDs.size(); idx++)
       {
            RecordQuerySpecification aRecordQuerySpecification = recordIDs.get(idx);
            aRecordQuerySpecification.marshal(dos);
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
    uPosition += super.unmarshal(dis);

    try 
    {
        requestID = dis.readInt();
        uPosition += 4;
        requiredReliabilityService = RequiredReliabilityService.unmarshalEnum(dis);
        uPosition += requiredReliabilityService.getMarshalledSize();
        pad1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        eventType = RecordQueryREventType.unmarshalEnum(dis);
        uPosition += eventType.getMarshalledSize();
        time = dis.readInt();
        uPosition += 4;
        numberOfRecords = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < numberOfRecords; idx++)
        {
            RecordQuerySpecification anX = new RecordQuerySpecification();
            uPosition += anX.unmarshal(dis);
            recordIDs.add(anX);
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
   super.marshal(buff);
   buff.putInt( (int)requestID);
   requiredReliabilityService.marshal(buff);
   buff.put( (byte)pad1);
   eventType.marshal(buff);
   buff.putInt( (int)time);
   buff.putInt( (int)recordIDs.size());

   for(int idx = 0; idx < recordIDs.size(); idx++)
   {
        RecordQuerySpecification aRecordQuerySpecification = (RecordQuerySpecification)recordIDs.get(idx);
        aRecordQuerySpecification.marshal(buff);
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
    super.unmarshal(buff);

    requestID = buff.getInt();
    requiredReliabilityService = RequiredReliabilityService.unmarshalEnum(buff);
    pad1 = (byte)(buff.get() & 0xFF);
    eventType = RecordQueryREventType.unmarshalEnum(buff);
    time = buff.getInt();
    numberOfRecords = buff.getInt();
    for(int idx = 0; idx < numberOfRecords; idx++)
    {
    RecordQuerySpecification anX = new RecordQuerySpecification();
    anX.unmarshal(buff);
    recordIDs.add(anX);
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof RecordQueryReliablePdu))
        return false;

     final RecordQueryReliablePdu rhs = (RecordQueryReliablePdu)obj;

     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (requiredReliabilityService == rhs.requiredReliabilityService)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (eventType == rhs.eventType)) ivarsEqual = false;
     if( ! (time == rhs.time)) ivarsEqual = false;
     if( ! (numberOfRecords == rhs.numberOfRecords)) ivarsEqual = false;

     for(int idx = 0; idx < recordIDs.size(); idx++)
        if( ! ( recordIDs.get(idx).equals(rhs.recordIDs.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
