/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.12.4.16 Used to respond to a Record Query-R PDU or a Set Record-R PDU. It is used to provide information requested in a Record Query-R PDU, to confirm the information received in a Set Record-R PDU, and to confirm the receipt of a periodic or unsolicited Record-R PDU when the acknowledged service level is used.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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


public RecordRPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

public int getRequestID()
{
    return requestID; 
}

public RecordRPdu setRequiredReliabilityService(RequiredReliabilityService pRequiredReliabilityService)
{
    requiredReliabilityService = pRequiredReliabilityService;
    return this;
}

public RequiredReliabilityService getRequiredReliabilityService()
{
    return requiredReliabilityService; 
}

public RecordRPdu setPad1(byte pPad1)
{
    pad1 = pPad1;
    return this;
}

public byte getPad1()
{
    return pad1; 
}

public RecordRPdu setEventType(RecordREventType pEventType)
{
    eventType = pEventType;
    return this;
}

public RecordREventType getEventType()
{
    return eventType; 
}

public RecordRPdu setRecordSets(List<RecordSpecification> pRecordSets)
{
    recordSets = pRecordSets;
    return this;
}

public List<RecordSpecification> getRecordSets()
{
    return recordSets; 
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
       dos.writeInt( (int)recordSets.size());

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
   buff.putInt( (int)recordSets.size());

   for(int idx = 0; idx < recordSets.size(); idx++)
   {
        RecordSpecification aRecordSpecification = (RecordSpecification)recordSets.get(idx);
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

    if(!(obj instanceof RecordRPdu))
        return false;

     final RecordRPdu rhs = (RecordRPdu)obj;

     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (requiredReliabilityService == rhs.requiredReliabilityService)) ivarsEqual = false;
     if( ! (pad1 == rhs.pad1)) ivarsEqual = false;
     if( ! (eventType == rhs.eventType)) ivarsEqual = false;
     if( ! (numberOfRecordSets == rhs.numberOfRecordSets)) ivarsEqual = false;

     for(int idx = 0; idx < recordSets.size(); idx++)
        if( ! ( recordSets.get(idx).equals(rhs.recordSets.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
