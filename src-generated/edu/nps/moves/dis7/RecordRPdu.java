/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.12.4.16 Used to respond to a Record Query-R PDU or a Set Record-R PDU. It is used to provide information requested in a Record Query-R PDU, to confirm the information received in a Set Record-R PDU, and to confirm the receipt of a periodic or unsolicited Record-R PDU when the acknowledged service level is used.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class RecordRPdu extends SimulationManagementWithReliabilityFamilyPdu implements Serializable
{
   /** request ID */
   protected int  requestID;

   /** level of reliability service used for this transaction uid 74 */
   protected RequiredReliabilityService requiredReliabilityService = RequiredReliabilityService.values()[0];

   protected byte  pad1;

   /**  uid 333 */
   protected RecordREventType eventType = RecordREventType.values()[0];

   /** Number of record sets in list */
   protected int  numberOfRecordSets;

   /** record sets */
   protected List< RecordSpecification > recordSets = new ArrayList< RecordSpecification >();
 

/** Constructor */
 public RecordRPdu()
 {
    setPduType( DISPDUType.RECORD_RELIABLE );
 }

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 4;  // requestID
   marshalSize += requiredReliabilityService.getMarshalledSize();
   marshalSize += 1;  // pad1
   marshalSize += eventType.getMarshalledSize();
   marshalSize += 4;  // numberOfRecordSets
   for(int idx=0; idx < recordSets.size(); idx++)
   {
        RecordSpecification listElement = recordSets.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link RecordRPdu#requestID}*/
public RecordRPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link RecordRPdu#requestID}*/
public int getRequestID()
{
    return requestID; 
}

/** Setter for {@link RecordRPdu#requiredReliabilityService}*/
public RecordRPdu setRequiredReliabilityService(RequiredReliabilityService pRequiredReliabilityService)
{
    requiredReliabilityService = pRequiredReliabilityService;
    return this;
}

/** Getter for {@link RecordRPdu#requiredReliabilityService}*/
public RequiredReliabilityService getRequiredReliabilityService()
{
    return requiredReliabilityService; 
}

/** Setter for {@link RecordRPdu#pad1}*/
public RecordRPdu setPad1(byte pPad1)
{
    pad1 = pPad1;
    return this;
}

/** Getter for {@link RecordRPdu#pad1}*/
public byte getPad1()
{
    return pad1; 
}

/** Setter for {@link RecordRPdu#eventType}*/
public RecordRPdu setEventType(RecordREventType pEventType)
{
    eventType = pEventType;
    return this;
}

/** Getter for {@link RecordRPdu#eventType}*/
public RecordREventType getEventType()
{
    return eventType; 
}

/** Setter for {@link RecordRPdu#recordSets}*/
public RecordRPdu setRecordSets(List<RecordSpecification> pRecordSets)
{
    recordSets = pRecordSets;
    return this;
}

/** Getter for {@link RecordRPdu#recordSets}*/
public List<RecordSpecification> getRecordSets()
{
    return recordSets; 
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
       dos.writeInt(requestID);
       requiredReliabilityService.marshal(dos);
       dos.writeByte(pad1);
       eventType.marshal(dos);
       dos.writeInt(recordSets.size());

       for(int idx = 0; idx < recordSets.size(); idx++)
       {
            RecordSpecification aRecordSpecification = recordSets.get(idx);
            aRecordSpecification.marshal(dos);
       }

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
        requestID = dis.readInt();
        uPosition += 4;
        requiredReliabilityService = RequiredReliabilityService.unmarshalEnum(dis);
        uPosition += requiredReliabilityService.getMarshalledSize();
        pad1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        eventType = RecordREventType.unmarshalEnum(dis);
        uPosition += eventType.getMarshalledSize();
        numberOfRecordSets = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < numberOfRecordSets; idx++)
        {
            RecordSpecification anX = new RecordSpecification();
            uPosition += anX.unmarshal(dis);
            recordSets.add(anX);
        }

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
   buff.putInt( (int)requestID);
   requiredReliabilityService.marshal(buff);
   buff.put( (byte)pad1);
   eventType.marshal(buff);
   buff.putInt( (int)recordSets.size());

   for(int idx = 0; idx < recordSets.size(); idx++)
   {
        RecordSpecification aRecordSpecification = recordSets.get(idx);
        aRecordSpecification.marshal(buff);
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
    eventType = RecordREventType.unmarshalEnum(buff);
    numberOfRecordSets = buff.getInt();
    for(int idx = 0; idx < numberOfRecordSets; idx++)
    {
    RecordSpecification anX = new RecordSpecification();
    anX.unmarshal(buff);
    recordSets.add(anX);
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

     final RecordRPdu rhs = (RecordRPdu)obj;

     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (requiredReliabilityService == rhs.requiredReliabilityService)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (eventType == rhs.eventType)) ivarsEqual = false;

     for(int idx = 0; idx < recordSets.size(); idx++)
        if( ! ( recordSets.get(idx).equals(rhs.recordSets.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" requestID: ").append(requestID).append("\n");
    sb.append(" requiredReliabilityService: ").append(requiredReliabilityService).append("\n");
    sb.append(" pad1: ").append(pad1).append("\n");
    sb.append(" eventType: ").append(eventType).append("\n");
    sb.append(" recordSets: ").append("\n");
    recordSets.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
