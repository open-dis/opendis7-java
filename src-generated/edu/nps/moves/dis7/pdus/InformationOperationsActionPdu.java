/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.13.3.1 Used to communicate an IO attack or the effects of an IO attack on one or more target entities.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class InformationOperationsActionPdu extends InformationOperationsFamilyPdu implements Serializable
{
   /** the simulation to which this PDU is addressed */
   protected EntityID  receivingSimID = new EntityID(); 

   /** request ID */
   protected int  requestID;

   /**  uid 285 */
   protected IOActionIOWarfareType IOWarfareType = IOActionIOWarfareType.values()[0];

   /**  uid 286 */
   protected IOActionIOSimulationSource IOSimulationSource = IOActionIOSimulationSource.values()[0];

   /**  uid 287 */
   protected IOActionIOActionType IOActionType = IOActionIOActionType.values()[0];

   /**  uid 288 */
   protected IOActionIOActionPhase IOActionPhase = IOActionIOActionPhase.values()[0];

   protected int  padding1;

   protected EntityID  ioAttackerID = new EntityID(); 

   protected EntityID  ioPrimaryTargetID = new EntityID(); 

   protected short  padding2;

   protected short  numberOfIORecords;

   protected List< IORecord > ioRecords = new ArrayList< IORecord >();
 

/** Constructor */
 public InformationOperationsActionPdu()
 {
    setPduType( DISPDUType.INFORMATION_OPERATIONS_ACTION );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += receivingSimID.getMarshalledSize();
   marshalSize += 4;  // requestID
   marshalSize += IOWarfareType.getMarshalledSize();
   marshalSize += IOSimulationSource.getMarshalledSize();
   marshalSize += IOActionType.getMarshalledSize();
   marshalSize += IOActionPhase.getMarshalledSize();
   marshalSize += 4;  // padding1
   marshalSize += ioAttackerID.getMarshalledSize();
   marshalSize += ioPrimaryTargetID.getMarshalledSize();
   marshalSize += 2;  // padding2
   marshalSize += 2;  // numberOfIORecords
   for(int idx=0; idx < ioRecords.size(); idx++)
   {
        IORecord listElement = ioRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link InformationOperationsActionPdu#receivingSimID}
  * @param pReceivingSimID new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setReceivingSimID(EntityID pReceivingSimID)
{
    receivingSimID = pReceivingSimID;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#receivingSimID}
  * @return value of interest */
public EntityID getReceivingSimID()
{
    return receivingSimID; 
}

/** Setter for {@link InformationOperationsActionPdu#requestID}
  * @param pRequestID new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#requestID}
  * @return value of interest */
public int getRequestID()
{
    return requestID; 
}

/** Setter for {@link InformationOperationsActionPdu#IOWarfareType}
  * @param pIOWarfareType new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setIOWarfareType(IOActionIOWarfareType pIOWarfareType)
{
    IOWarfareType = pIOWarfareType;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#IOWarfareType}
  * @return value of interest */
public IOActionIOWarfareType getIOWarfareType()
{
    return IOWarfareType; 
}

/** Setter for {@link InformationOperationsActionPdu#IOSimulationSource}
  * @param pIOSimulationSource new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setIOSimulationSource(IOActionIOSimulationSource pIOSimulationSource)
{
    IOSimulationSource = pIOSimulationSource;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#IOSimulationSource}
  * @return value of interest */
public IOActionIOSimulationSource getIOSimulationSource()
{
    return IOSimulationSource; 
}

/** Setter for {@link InformationOperationsActionPdu#IOActionType}
  * @param pIOActionType new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setIOActionType(IOActionIOActionType pIOActionType)
{
    IOActionType = pIOActionType;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#IOActionType}
  * @return value of interest */
public IOActionIOActionType getIOActionType()
{
    return IOActionType; 
}

/** Setter for {@link InformationOperationsActionPdu#IOActionPhase}
  * @param pIOActionPhase new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setIOActionPhase(IOActionIOActionPhase pIOActionPhase)
{
    IOActionPhase = pIOActionPhase;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#IOActionPhase}
  * @return value of interest */
public IOActionIOActionPhase getIOActionPhase()
{
    return IOActionPhase; 
}

/** Setter for {@link InformationOperationsActionPdu#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setPadding1(int pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#padding1}
  * @return value of interest */
public int getPadding1()
{
    return padding1; 
}

/** Setter for {@link InformationOperationsActionPdu#ioAttackerID}
  * @param pIoAttackerID new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setIoAttackerID(EntityID pIoAttackerID)
{
    ioAttackerID = pIoAttackerID;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#ioAttackerID}
  * @return value of interest */
public EntityID getIoAttackerID()
{
    return ioAttackerID; 
}

/** Setter for {@link InformationOperationsActionPdu#ioPrimaryTargetID}
  * @param pIoPrimaryTargetID new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setIoPrimaryTargetID(EntityID pIoPrimaryTargetID)
{
    ioPrimaryTargetID = pIoPrimaryTargetID;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#ioPrimaryTargetID}
  * @return value of interest */
public EntityID getIoPrimaryTargetID()
{
    return ioPrimaryTargetID; 
}

/** Setter for {@link InformationOperationsActionPdu#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}
/** Utility setter for {@link InformationOperationsActionPdu#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setPadding2(int pPadding2){
    padding2 = (short) pPadding2;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#padding2}
  * @return value of interest */
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link InformationOperationsActionPdu#ioRecords}
  * @param pIoRecords new value of interest
  * @return same object to permit progressive setters */
public InformationOperationsActionPdu setIoRecords(List<IORecord> pIoRecords)
{
    ioRecords = pIoRecords;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#ioRecords}
  * @return value of interest */
public List<IORecord> getIoRecords()
{
    return ioRecords; 
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
       receivingSimID.marshal(dos);
       dos.writeInt(requestID);
       IOWarfareType.marshal(dos);
       IOSimulationSource.marshal(dos);
       IOActionType.marshal(dos);
       IOActionPhase.marshal(dos);
       dos.writeInt(padding1);
       ioAttackerID.marshal(dos);
       ioPrimaryTargetID.marshal(dos);
       dos.writeShort(padding2);
       dos.writeShort(ioRecords.size());

       for(int idx = 0; idx < ioRecords.size(); idx++)
       {
            IORecord aIORecord = ioRecords.get(idx);
            aIORecord.marshal(dos);
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
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += receivingSimID.unmarshal(dis);
        requestID = dis.readInt();
        uPosition += 4;
        IOWarfareType = IOActionIOWarfareType.unmarshalEnum(dis);
        uPosition += IOWarfareType.getMarshalledSize();
        IOSimulationSource = IOActionIOSimulationSource.unmarshalEnum(dis);
        uPosition += IOSimulationSource.getMarshalledSize();
        IOActionType = IOActionIOActionType.unmarshalEnum(dis);
        uPosition += IOActionType.getMarshalledSize();
        IOActionPhase = IOActionIOActionPhase.unmarshalEnum(dis);
        uPosition += IOActionPhase.getMarshalledSize();
        padding1 = dis.readInt();
        uPosition += 4;
        uPosition += ioAttackerID.unmarshal(dis);
        uPosition += ioPrimaryTargetID.unmarshal(dis);
        padding2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        numberOfIORecords = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfIORecords; idx++)
        {
            IORecord anX = new IORecord();
            uPosition += anX.unmarshal(dis);
            ioRecords.add(anX);
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
 * @throws java.nio.BufferOverflowException if byteBuffer is too small
 * @throws java.nio.ReadOnlyBufferException if byteBuffer is read only
 * @see java.nio.ByteBuffer
 * @param byteBuffer The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   super.marshal(byteBuffer);
   receivingSimID.marshal(byteBuffer);
   byteBuffer.putInt( (int)requestID);
   IOWarfareType.marshal(byteBuffer);
   IOSimulationSource.marshal(byteBuffer);
   IOActionType.marshal(byteBuffer);
   IOActionPhase.marshal(byteBuffer);
   byteBuffer.putInt( (int)padding1);
   ioAttackerID.marshal(byteBuffer);
   ioPrimaryTargetID.marshal(byteBuffer);
   byteBuffer.putShort( (short)padding2);
   byteBuffer.putShort( (short)ioRecords.size());

   for(int idx = 0; idx < ioRecords.size(); idx++)
   {
        IORecord aIORecord = ioRecords.get(idx);
        aIORecord.marshal(byteBuffer);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    receivingSimID.unmarshal(byteBuffer);
    requestID = byteBuffer.getInt();
    IOWarfareType = IOActionIOWarfareType.unmarshalEnum(byteBuffer);
    IOSimulationSource = IOActionIOSimulationSource.unmarshalEnum(byteBuffer);
    IOActionType = IOActionIOActionType.unmarshalEnum(byteBuffer);
    IOActionPhase = IOActionIOActionPhase.unmarshalEnum(byteBuffer);
    padding1 = byteBuffer.getInt();
    ioAttackerID.unmarshal(byteBuffer);
    ioPrimaryTargetID.unmarshal(byteBuffer);
    padding2 = (short)(byteBuffer.getShort() & 0xFFFF);
    numberOfIORecords = (short)(byteBuffer.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfIORecords; idx++)
    {
    IORecord anX = new IORecord();
    anX.unmarshal(byteBuffer);
    ioRecords.add(anX);
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

     final InformationOperationsActionPdu rhs = (InformationOperationsActionPdu)obj;

     if( ! (receivingSimID.equals( rhs.receivingSimID) )) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (IOWarfareType == rhs.IOWarfareType)) ivarsEqual = false;
     if( ! (IOSimulationSource == rhs.IOSimulationSource)) ivarsEqual = false;
     if( ! (IOActionType == rhs.IOActionType)) ivarsEqual = false;
     if( ! (IOActionPhase == rhs.IOActionPhase)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (ioAttackerID.equals( rhs.ioAttackerID) )) ivarsEqual = false;
     if( ! (ioPrimaryTargetID.equals( rhs.ioPrimaryTargetID) )) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;

     for(int idx = 0; idx < ioRecords.size(); idx++)
        if( ! ( ioRecords.get(idx).equals(rhs.ioRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" receivingSimID: ").append(receivingSimID).append("\n");
    sb.append(" requestID: ").append(requestID).append("\n");
    sb.append(" IOWarfareType: ").append(IOWarfareType).append("\n");
    sb.append(" IOSimulationSource: ").append(IOSimulationSource).append("\n");
    sb.append(" IOActionType: ").append(IOActionType).append("\n");
    sb.append(" IOActionPhase: ").append(IOActionPhase).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" ioAttackerID: ").append(ioAttackerID).append("\n");
    sb.append(" ioPrimaryTargetID: ").append(ioPrimaryTargetID).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");
    sb.append(" ioRecords: ").append("\n");
    ioRecords.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
