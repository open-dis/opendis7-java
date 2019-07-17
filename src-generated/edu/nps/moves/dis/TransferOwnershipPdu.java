package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 *  Information initiating the dyanic allocation and control of simulation entities between two simulation applications.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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


public TransferOwnershipPdu setOriginatingEntityID(EntityID pOriginatingEntityID)
{
    originatingEntityID = pOriginatingEntityID;
    return this;
}

public EntityID getOriginatingEntityID()
{
    return originatingEntityID; 
}

public TransferOwnershipPdu setReceivingEntityID(EntityID pReceivingEntityID)
{
    receivingEntityID = pReceivingEntityID;
    return this;
}

public EntityID getReceivingEntityID()
{
    return receivingEntityID; 
}

public TransferOwnershipPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

public int getRequestID()
{
    return requestID; 
}

public TransferOwnershipPdu setRequiredReliabilityService(RequiredReliabilityService pRequiredReliabilityService)
{
    requiredReliabilityService = pRequiredReliabilityService;
    return this;
}

public RequiredReliabilityService getRequiredReliabilityService()
{
    return requiredReliabilityService; 
}

public TransferOwnershipPdu setTransferType(TransferControlTransferType pTransferType)
{
    transferType = pTransferType;
    return this;
}

public TransferControlTransferType getTransferType()
{
    return transferType; 
}

public TransferOwnershipPdu setTransferEntityID(EntityID pTransferEntityID)
{
    transferEntityID = pTransferEntityID;
    return this;
}

public EntityID getTransferEntityID()
{
    return transferEntityID; 
}

public TransferOwnershipPdu setRecordSets(RecordSpecification pRecordSets)
{
    recordSets = pRecordSets;
    return this;
}

public RecordSpecification getRecordSets()
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
       originatingEntityID.marshal(dos);
       receivingEntityID.marshal(dos);
       dos.writeInt( (int)requestID);
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
 * @see java.io.DataInputStream
 * @param dis The DataInputStream
 */
public int unmarshal(DataInputStream dis)
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

    if(!(obj instanceof TransferOwnershipPdu))
        return false;

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
} // end of class
