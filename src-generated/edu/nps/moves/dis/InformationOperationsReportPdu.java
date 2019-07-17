package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Section 7.12.3: The information operations status of an entity shall be conveyed with this PDU
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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


public InformationOperationsReportPdu setIoSimSource(IOActionIOSimulationSource pIoSimSource)
{
    ioSimSource = pIoSimSource;
    return this;
}

public IOActionIOSimulationSource getIoSimSource()
{
    return ioSimSource; 
}

public InformationOperationsReportPdu setIoReportType(IOReportIOReportType pIoReportType)
{
    ioReportType = pIoReportType;
    return this;
}

public IOReportIOReportType getIoReportType()
{
    return ioReportType; 
}

public InformationOperationsReportPdu setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}

public byte getPadding1()
{
    return padding1; 
}

public InformationOperationsReportPdu setIoAttackerID(EntityID pIoAttackerID)
{
    ioAttackerID = pIoAttackerID;
    return this;
}

public EntityID getIoAttackerID()
{
    return ioAttackerID; 
}

public InformationOperationsReportPdu setIoPrimaryTargetID(EntityID pIoPrimaryTargetID)
{
    ioPrimaryTargetID = pIoPrimaryTargetID;
    return this;
}

public EntityID getIoPrimaryTargetID()
{
    return ioPrimaryTargetID; 
}

public InformationOperationsReportPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

public short getPadding2()
{
    return padding2; 
}

public InformationOperationsReportPdu setPadding3(short pPadding3)
{
    padding3 = pPadding3;
    return this;
}

public short getPadding3()
{
    return padding3; 
}

public InformationOperationsReportPdu setIoRecords(List<IORecord> pIoRecords)
{
    ioRecords = pIoRecords;
    return this;
}

public List<IORecord> getIoRecords()
{
    return ioRecords; 
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
 */
public int unmarshal(DataInputStream dis)
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

    if(!(obj instanceof InformationOperationsReportPdu))
        return false;

     final InformationOperationsReportPdu rhs = (InformationOperationsReportPdu)obj;

     if( ! (ioSimSource == rhs.ioSimSource)) ivarsEqual = false;
     if( ! (ioReportType == rhs.ioReportType)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (ioAttackerID.equals( rhs.ioAttackerID) )) ivarsEqual = false;
     if( ! (ioPrimaryTargetID.equals( rhs.ioPrimaryTargetID) )) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (padding3 == rhs.padding3)) ivarsEqual = false;
     if( ! (numberOfIORecords == rhs.numberOfIORecords)) ivarsEqual = false;

     for(int idx = 0; idx < ioRecords.size(); idx++)
        if( ! ( ioRecords.get(idx).equals(rhs.ioRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
