/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  Information initiating the dyanic allocation and control of simulation entities between two simulation applications.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class TransferOwnershipPdu extends EntityManagementFamilyPdu implements Serializable
{
   /** ID of entity originating request */
   protected EntityID  originatingEntityID = new EntityID(); 

   /** ID of entity receiving request */
   protected EntityID  receivingEntityID = new EntityID(); 

   /** ID of request */
   protected int  requestID;

   /** required level of reliability service. uid 74 */
   protected RequiredReliabilityService requiredReliabilityService = RequiredReliabilityService.values()[0];

   /** type of transfer desired uid 224 */
   protected TransferControlTransferType transferType = TransferControlTransferType.values()[0];

   /** The entity for which control is being requested to transfer */
   protected EntityID  transferEntityID = new EntityID(); 

   protected RecordSpecification  recordSets = new RecordSpecification(); 


/** Constructor */
 public TransferOwnershipPdu()
 {
    setPduType( DISPDUType.TRANSFER_OWNERSHIP );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += originatingEntityID.getMarshalledSize();
   marshalSize += receivingEntityID.getMarshalledSize();
   marshalSize += 4;  // requestID
   marshalSize += requiredReliabilityService.getMarshalledSize();
   marshalSize += transferType.getMarshalledSize();
   marshalSize += transferEntityID.getMarshalledSize();
   marshalSize += recordSets.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link TransferOwnershipPdu#originatingEntityID}*/
public TransferOwnershipPdu setOriginatingEntityID(EntityID pOriginatingEntityID)
{
    originatingEntityID = pOriginatingEntityID;
    return this;
}

/** Getter for {@link TransferOwnershipPdu#originatingEntityID}*/
public EntityID getOriginatingEntityID()
{
    return originatingEntityID; 
}

/** Setter for {@link TransferOwnershipPdu#receivingEntityID}*/
public TransferOwnershipPdu setReceivingEntityID(EntityID pReceivingEntityID)
{
    receivingEntityID = pReceivingEntityID;
    return this;
}

/** Getter for {@link TransferOwnershipPdu#receivingEntityID}*/
public EntityID getReceivingEntityID()
{
    return receivingEntityID; 
}

/** Setter for {@link TransferOwnershipPdu#requestID}*/
public TransferOwnershipPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link TransferOwnershipPdu#requestID}*/
public int getRequestID()
{
    return requestID; 
}

/** Setter for {@link TransferOwnershipPdu#requiredReliabilityService}*/
public TransferOwnershipPdu setRequiredReliabilityService(RequiredReliabilityService pRequiredReliabilityService)
{
    requiredReliabilityService = pRequiredReliabilityService;
    return this;
}

/** Getter for {@link TransferOwnershipPdu#requiredReliabilityService}*/
public RequiredReliabilityService getRequiredReliabilityService()
{
    return requiredReliabilityService; 
}

/** Setter for {@link TransferOwnershipPdu#transferType}*/
public TransferOwnershipPdu setTransferType(TransferControlTransferType pTransferType)
{
    transferType = pTransferType;
    return this;
}

/** Getter for {@link TransferOwnershipPdu#transferType}*/
public TransferControlTransferType getTransferType()
{
    return transferType; 
}

/** Setter for {@link TransferOwnershipPdu#transferEntityID}*/
public TransferOwnershipPdu setTransferEntityID(EntityID pTransferEntityID)
{
    transferEntityID = pTransferEntityID;
    return this;
}

/** Getter for {@link TransferOwnershipPdu#transferEntityID}*/
public EntityID getTransferEntityID()
{
    return transferEntityID; 
}

/** Setter for {@link TransferOwnershipPdu#recordSets}*/
public TransferOwnershipPdu setRecordSets(RecordSpecification pRecordSets)
{
    recordSets = pRecordSets;
    return this;
}

/** Getter for {@link TransferOwnershipPdu#recordSets}*/
public RecordSpecification getRecordSets()
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
       originatingEntityID.marshal(dos);
       receivingEntityID.marshal(dos);
       dos.writeInt(requestID);
       requiredReliabilityService.marshal(dos);
       transferType.marshal(dos);
       transferEntityID.marshal(dos);
       recordSets.marshal(dos);
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
}

/**
 * Unserializes an object from a DataInputStream.
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
        uPosition += originatingEntityID.unmarshal(dis);
        uPosition += receivingEntityID.unmarshal(dis);
        requestID = dis.readInt();
        uPosition += 4;
        requiredReliabilityService = RequiredReliabilityService.unmarshalEnum(dis);
        uPosition += requiredReliabilityService.getMarshalledSize();
        transferType = TransferControlTransferType.unmarshalEnum(dis);
        uPosition += transferType.getMarshalledSize();
        uPosition += transferEntityID.unmarshal(dis);
        uPosition += recordSets.unmarshal(dis);
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
   originatingEntityID.marshal(buff);
   receivingEntityID.marshal(buff);
   buff.putInt( (int)requestID);
   requiredReliabilityService.marshal(buff);
   transferType.marshal(buff);
   transferEntityID.marshal(buff);
   recordSets.marshal(buff);
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

    originatingEntityID.unmarshal(buff);
    receivingEntityID.unmarshal(buff);
    requestID = buff.getInt();
    requiredReliabilityService = RequiredReliabilityService.unmarshalEnum(buff);
    transferType = TransferControlTransferType.unmarshalEnum(buff);
    transferEntityID.unmarshal(buff);
    recordSets.unmarshal(buff);
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

     final TransferOwnershipPdu rhs = (TransferOwnershipPdu)obj;

     if( ! (originatingEntityID.equals( rhs.originatingEntityID) )) ivarsEqual = false;
     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (requiredReliabilityService == rhs.requiredReliabilityService)) ivarsEqual = false;
     if( ! (transferType == rhs.transferType)) ivarsEqual = false;
     if( ! (transferEntityID.equals( rhs.transferEntityID) )) ivarsEqual = false;
     if( ! (recordSets.equals( rhs.recordSets) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" originatingEntityID: ").append(originatingEntityID).append("\n");
    sb.append(" receivingEntityID: ").append(receivingEntityID).append("\n");
    sb.append(" requestID: ").append(requestID).append("\n");
    sb.append(" requiredReliabilityService: ").append(requiredReliabilityService).append("\n");
    sb.append(" transferType: ").append(transferType).append("\n");
    sb.append(" transferEntityID: ").append(transferEntityID).append("\n");
    sb.append(" recordSets: ").append(recordSets).append("\n");

   return sb.toString();
 }
} // end of class
