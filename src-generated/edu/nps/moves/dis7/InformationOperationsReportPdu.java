/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.13.4.1 Used to communicate the effects of an IO attack on one or more target entities.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class InformationOperationsReportPdu extends InformationOperationsFamilyPdu implements Serializable
{
   /**  uid 286 */
   protected IOActionIOSimulationSource ioSimSource = IOActionIOSimulationSource.values()[0];

   /** request ID uid 289 */
   protected IOReportIOReportType ioReportType = IOReportIOReportType.values()[0];

   protected byte  padding1;

   protected EntityID  ioAttackerID = new EntityID(); 

   protected EntityID  ioPrimaryTargetID = new EntityID(); 

   protected short  padding2;

   protected short  padding3;

   protected short  numberOfIORecords;

   protected List< IORecord > ioRecords = new ArrayList< IORecord >();
 

/** Constructor */
 public InformationOperationsReportPdu()
 {
    setPduType( DISPDUType.INFORMATION_OPERATIONS_REPORT );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += ioSimSource.getMarshalledSize();
   marshalSize += ioReportType.getMarshalledSize();
   marshalSize += 1;  // padding1
   marshalSize += ioAttackerID.getMarshalledSize();
   marshalSize += ioPrimaryTargetID.getMarshalledSize();
   marshalSize += 2;  // padding2
   marshalSize += 2;  // padding3
   marshalSize += 2;  // numberOfIORecords
   for(int idx=0; idx < ioRecords.size(); idx++)
   {
        IORecord listElement = ioRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link InformationOperationsReportPdu#ioSimSource}*/
public InformationOperationsReportPdu setIoSimSource(IOActionIOSimulationSource pIoSimSource)
{
    ioSimSource = pIoSimSource;
    return this;
}

/** Getter for {@link InformationOperationsReportPdu#ioSimSource}*/
public IOActionIOSimulationSource getIoSimSource()
{
    return ioSimSource; 
}

/** Setter for {@link InformationOperationsReportPdu#ioReportType}*/
public InformationOperationsReportPdu setIoReportType(IOReportIOReportType pIoReportType)
{
    ioReportType = pIoReportType;
    return this;
}

/** Getter for {@link InformationOperationsReportPdu#ioReportType}*/
public IOReportIOReportType getIoReportType()
{
    return ioReportType; 
}

/** Setter for {@link InformationOperationsReportPdu#padding1}*/
public InformationOperationsReportPdu setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link InformationOperationsReportPdu#padding1}*/
public byte getPadding1()
{
    return padding1; 
}

/** Setter for {@link InformationOperationsReportPdu#ioAttackerID}*/
public InformationOperationsReportPdu setIoAttackerID(EntityID pIoAttackerID)
{
    ioAttackerID = pIoAttackerID;
    return this;
}

/** Getter for {@link InformationOperationsReportPdu#ioAttackerID}*/
public EntityID getIoAttackerID()
{
    return ioAttackerID; 
}

/** Setter for {@link InformationOperationsReportPdu#ioPrimaryTargetID}*/
public InformationOperationsReportPdu setIoPrimaryTargetID(EntityID pIoPrimaryTargetID)
{
    ioPrimaryTargetID = pIoPrimaryTargetID;
    return this;
}

/** Getter for {@link InformationOperationsReportPdu#ioPrimaryTargetID}*/
public EntityID getIoPrimaryTargetID()
{
    return ioPrimaryTargetID; 
}

/** Setter for {@link InformationOperationsReportPdu#padding2}*/
public InformationOperationsReportPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

/** Getter for {@link InformationOperationsReportPdu#padding2}*/
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link InformationOperationsReportPdu#padding3}*/
public InformationOperationsReportPdu setPadding3(short pPadding3)
{
    padding3 = pPadding3;
    return this;
}

/** Getter for {@link InformationOperationsReportPdu#padding3}*/
public short getPadding3()
{
    return padding3; 
}

/** Setter for {@link InformationOperationsReportPdu#ioRecords}*/
public InformationOperationsReportPdu setIoRecords(List<IORecord> pIoRecords)
{
    ioRecords = pIoRecords;
    return this;
}

/** Getter for {@link InformationOperationsReportPdu#ioRecords}*/
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
       ioSimSource.marshal(dos);
       ioReportType.marshal(dos);
       dos.writeByte( (byte)padding1);
       ioAttackerID.marshal(dos);
       ioPrimaryTargetID.marshal(dos);
       dos.writeShort( (short)padding2);
       dos.writeShort( (short)padding3);
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
        ioSimSource = IOActionIOSimulationSource.unmarshalEnum(dis);
        uPosition += ioSimSource.getMarshalledSize();
        ioReportType = IOReportIOReportType.unmarshalEnum(dis);
        uPosition += ioReportType.getMarshalledSize();
        padding1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += ioAttackerID.unmarshal(dis);
        uPosition += ioPrimaryTargetID.unmarshal(dis);
        padding2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        padding3 = (short)dis.readUnsignedShort();
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
   ioSimSource.marshal(buff);
   ioReportType.marshal(buff);
   buff.put( (byte)padding1);
   ioAttackerID.marshal(buff);
   ioPrimaryTargetID.marshal(buff);
   buff.putShort( (short)padding2);
   buff.putShort( (short)padding3);
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

    ioSimSource = IOActionIOSimulationSource.unmarshalEnum(buff);
    ioReportType = IOReportIOReportType.unmarshalEnum(buff);
    padding1 = (byte)(buff.get() & 0xFF);
    ioAttackerID.unmarshal(buff);
    ioPrimaryTargetID.unmarshal(buff);
    padding2 = (short)(buff.getShort() & 0xFFFF);
    padding3 = (short)(buff.getShort() & 0xFFFF);
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

    if(!getClass().isAssignableFrom(obj.getClass())) //if(getClass() != obj.getClass())
        return false;

    return equalsImpl(obj);
 }

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final InformationOperationsReportPdu rhs = (InformationOperationsReportPdu)obj;

     if( ! (ioSimSource == rhs.ioSimSource)) ivarsEqual = false;
     if( ! (ioReportType == rhs.ioReportType)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (ioAttackerID.equals( rhs.ioAttackerID) )) ivarsEqual = false;
     if( ! (ioPrimaryTargetID.equals( rhs.ioPrimaryTargetID) )) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (padding3 == rhs.padding3)) ivarsEqual = false;

     for(int idx = 0; idx < ioRecords.size(); idx++)
        if( ! ( ioRecords.get(idx).equals(rhs.ioRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" ioSimSource: ").append(ioSimSource).append("\n");
    sb.append(" ioReportType: ").append(ioReportType).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" ioAttackerID: ").append(ioAttackerID).append("\n");
    sb.append(" ioPrimaryTargetID: ").append(ioPrimaryTargetID).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");
    sb.append(" padding3: ").append(padding3).append("\n");
    sb.append(" ioRecords: ").append("\n");
    ioRecords.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
