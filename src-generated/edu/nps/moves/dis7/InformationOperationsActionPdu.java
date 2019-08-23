/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.13.3.1 Used to communicate an IO attack or the effects of an IO attack on one or more target entities.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link InformationOperationsActionPdu#receivingSimID}*/
public InformationOperationsActionPdu setReceivingSimID(EntityID pReceivingSimID)
{
    receivingSimID = pReceivingSimID;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#receivingSimID}*/
public EntityID getReceivingSimID()
{
    return receivingSimID; 
}

/** Setter for {@link InformationOperationsActionPdu#requestID}*/
public InformationOperationsActionPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#requestID}*/
public int getRequestID()
{
    return requestID; 
}

/** Setter for {@link InformationOperationsActionPdu#IOWarfareType}*/
public InformationOperationsActionPdu setIOWarfareType(IOActionIOWarfareType pIOWarfareType)
{
    IOWarfareType = pIOWarfareType;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#IOWarfareType}*/
public IOActionIOWarfareType getIOWarfareType()
{
    return IOWarfareType; 
}

/** Setter for {@link InformationOperationsActionPdu#IOSimulationSource}*/
public InformationOperationsActionPdu setIOSimulationSource(IOActionIOSimulationSource pIOSimulationSource)
{
    IOSimulationSource = pIOSimulationSource;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#IOSimulationSource}*/
public IOActionIOSimulationSource getIOSimulationSource()
{
    return IOSimulationSource; 
}

/** Setter for {@link InformationOperationsActionPdu#IOActionType}*/
public InformationOperationsActionPdu setIOActionType(IOActionIOActionType pIOActionType)
{
    IOActionType = pIOActionType;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#IOActionType}*/
public IOActionIOActionType getIOActionType()
{
    return IOActionType; 
}

/** Setter for {@link InformationOperationsActionPdu#IOActionPhase}*/
public InformationOperationsActionPdu setIOActionPhase(IOActionIOActionPhase pIOActionPhase)
{
    IOActionPhase = pIOActionPhase;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#IOActionPhase}*/
public IOActionIOActionPhase getIOActionPhase()
{
    return IOActionPhase; 
}

/** Setter for {@link InformationOperationsActionPdu#padding1}*/
public InformationOperationsActionPdu setPadding1(int pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#padding1}*/
public int getPadding1()
{
    return padding1; 
}

/** Setter for {@link InformationOperationsActionPdu#ioAttackerID}*/
public InformationOperationsActionPdu setIoAttackerID(EntityID pIoAttackerID)
{
    ioAttackerID = pIoAttackerID;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#ioAttackerID}*/
public EntityID getIoAttackerID()
{
    return ioAttackerID; 
}

/** Setter for {@link InformationOperationsActionPdu#ioPrimaryTargetID}*/
public InformationOperationsActionPdu setIoPrimaryTargetID(EntityID pIoPrimaryTargetID)
{
    ioPrimaryTargetID = pIoPrimaryTargetID;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#ioPrimaryTargetID}*/
public EntityID getIoPrimaryTargetID()
{
    return ioPrimaryTargetID; 
}

/** Setter for {@link InformationOperationsActionPdu#padding2}*/
public InformationOperationsActionPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#padding2}*/
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link InformationOperationsActionPdu#ioRecords}*/
public InformationOperationsActionPdu setIoRecords(List<IORecord> pIoRecords)
{
    ioRecords = pIoRecords;
    return this;
}

/** Getter for {@link InformationOperationsActionPdu#ioRecords}*/
public List<IORecord> getIoRecords()
{
    return ioRecords; 
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
       receivingSimID.marshal(dos);
       dos.writeInt( (int)requestID);
       IOWarfareType.marshal(dos);
       IOSimulationSource.marshal(dos);
       IOActionType.marshal(dos);
       IOActionPhase.marshal(dos);
       dos.writeInt( (int)padding1);
       ioAttackerID.marshal(dos);
       ioPrimaryTargetID.marshal(dos);
       dos.writeShort( (short)padding2);
       dos.writeShort( (short)ioRecords.size());

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
   receivingSimID.marshal(buff);
   buff.putInt( (int)requestID);
   IOWarfareType.marshal(buff);
   IOSimulationSource.marshal(buff);
   IOActionType.marshal(buff);
   IOActionPhase.marshal(buff);
   buff.putInt( (int)padding1);
   ioAttackerID.marshal(buff);
   ioPrimaryTargetID.marshal(buff);
   buff.putShort( (short)padding2);
   buff.putShort( (short)ioRecords.size());

   for(int idx = 0; idx < ioRecords.size(); idx++)
   {
        IORecord aIORecord = (IORecord)ioRecords.get(idx);
        aIORecord.marshal(buff);
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

    receivingSimID.unmarshal(buff);
    requestID = buff.getInt();
    IOWarfareType = IOActionIOWarfareType.unmarshalEnum(buff);
    IOSimulationSource = IOActionIOSimulationSource.unmarshalEnum(buff);
    IOActionType = IOActionIOActionType.unmarshalEnum(buff);
    IOActionPhase = IOActionIOActionPhase.unmarshalEnum(buff);
    padding1 = buff.getInt();
    ioAttackerID.unmarshal(buff);
    ioPrimaryTargetID.unmarshal(buff);
    padding2 = (short)(buff.getShort() & 0xFFFF);
    numberOfIORecords = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfIORecords; idx++)
    {
    IORecord anX = new IORecord();
    anX.unmarshal(buff);
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

    if(getClass() != obj.getClass())
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
} // end of class
