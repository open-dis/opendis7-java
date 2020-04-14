/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.12.4.14 Used to communicate a request for data in record format.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class RecordQueryRPdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
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
 public RecordQueryRPdu()
 {
    setPduType( DISPDUType.RECORD_QUERY_RELIABLE );
 }

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link RecordQueryRPdu#requestID}*/
public RecordQueryRPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link RecordQueryRPdu#requestID}*/
public int getRequestID()
{
    return requestID; 
}

/** Setter for {@link RecordQueryRPdu#requiredReliabilityService}*/
public RecordQueryRPdu setRequiredReliabilityService(RequiredReliabilityService pRequiredReliabilityService)
{
    requiredReliabilityService = pRequiredReliabilityService;
    return this;
}

/** Getter for {@link RecordQueryRPdu#requiredReliabilityService}*/
public RequiredReliabilityService getRequiredReliabilityService()
{
    return requiredReliabilityService; 
}

/** Setter for {@link RecordQueryRPdu#pad1}*/
public RecordQueryRPdu setPad1(byte pPad1)
{
    pad1 = pPad1;
    return this;
}

/** Getter for {@link RecordQueryRPdu#pad1}*/
public byte getPad1()
{
    return pad1; 
}

/** Setter for {@link RecordQueryRPdu#eventType}*/
public RecordQueryRPdu setEventType(RecordQueryREventType pEventType)
{
    eventType = pEventType;
    return this;
}

/** Getter for {@link RecordQueryRPdu#eventType}*/
public RecordQueryREventType getEventType()
{
    return eventType; 
}

/** Setter for {@link RecordQueryRPdu#time}*/
public RecordQueryRPdu setTime(int pTime)
{
    time = pTime;
    return this;
}

/** Getter for {@link RecordQueryRPdu#time}*/
public int getTime()
{
    return time; 
}

/** Setter for {@link RecordQueryRPdu#recordIDs}*/
public RecordQueryRPdu setRecordIDs(List<RecordQuerySpecification> pRecordIDs)
{
    recordIDs = pRecordIDs;
    return this;
}

/** Getter for {@link RecordQueryRPdu#recordIDs}*/
public List<RecordQuerySpecification> getRecordIDs()
{
    return recordIDs; 
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
public int unmarshal(DataInputStream dis) throws Exception
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

     final RecordQueryRPdu rhs = (RecordQueryRPdu)obj;

     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (requiredReliabilityService == rhs.requiredReliabilityService)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (eventType == rhs.eventType)) ivarsEqual = false;
     if( ! (time == rhs.time)) ivarsEqual = false;

     for(int idx = 0; idx < recordIDs.size(); idx++)
        if( ! ( recordIDs.get(idx).equals(rhs.recordIDs.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" requestID: ").append(requestID).append("\n");
    sb.append(" requiredReliabilityService: ").append(requiredReliabilityService).append("\n");
    sb.append(" pad1: ").append(pad1).append("\n");
    sb.append(" eventType: ").append(eventType).append("\n");
    sb.append(" time: ").append(time).append("\n");
    sb.append(" recordIDs: ").append("\n");
    recordIDs.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
