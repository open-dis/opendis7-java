package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Section 5.3.11.2: Information about global, spatially varying environmental effects. This requires manual cleanup; the grid axis            records are variable sized. UNFINISHED
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class GriddedDataPdu extends SyntheticEnvironmentFamilyPdu implements Serializable
{
   /** environmental simulation application ID */
   protected SimulationIdentifier  environmentalSimulationApplicationID = new SimulationIdentifier(); 

   /** unique identifier for each piece of environmental data */
   protected short  fieldNumber;

   /** sequence number for the total set of PDUS used to transmit the data */
   protected short  pduNumber;

   /** Total number of PDUS used to transmit the data */
   protected short  pduTotal;

   /** coordinate system of the grid uid 244 */
   protected GriddedDataCoordinateSystem coordinateSystem = GriddedDataCoordinateSystem.values()[0];

   /** number of grid axes for the environmental data */
   protected byte  numberOfGridAxes;

   /** are domain grid axes identidal to those of the priveious domain update? uid 245 */
   protected GriddedDataConstantGrid constantGrid = GriddedDataConstantGrid.values()[0];

   /** type of environment */
   protected EntityType  environmentType = new EntityType(); 

   /** orientation of the data grid */
   protected EulerAngles  orientation = new EulerAngles(); 

   /** valid time of the enviormental data sample, 64 bit unsigned int */
   protected ClockTime  sampleTime = new ClockTime(); 

   /** total number of all data values for all pdus for an environmental sample */
   protected int  totalValues;

   /** total number of data values at each grid point. */
   protected byte  vectorDimension;

   /** padding */
   protected byte  padding1;

   /** padding */
   protected short  padding2;

   /**  */
   protected List< GridAxisDescriptor > gridAxisDescriptors = new ArrayList< GridAxisDescriptor >();
 
   /**  */
   protected List< GridData > gridDataRecords = new ArrayList< GridData >();
 

/** Constructor */
 public GriddedDataPdu()
 {
    setPduType( DISPDUType.GRIDDED_DATA );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += environmentalSimulationApplicationID.getMarshalledSize();
   marshalSize += 2;  // fieldNumber
   marshalSize += 2;  // pduNumber
   marshalSize += 2;  // pduTotal
   marshalSize += coordinateSystem.getMarshalledSize();
   marshalSize += 1;  // numberOfGridAxes
   marshalSize += constantGrid.getMarshalledSize();
   marshalSize += environmentType.getMarshalledSize();
   marshalSize += orientation.getMarshalledSize();
   marshalSize += sampleTime.getMarshalledSize();
   marshalSize += 4;  // totalValues
   marshalSize += 1;  // vectorDimension
   marshalSize += 1;  // padding1
   marshalSize += 2;  // padding2
   for(int idx=0; idx < gridAxisDescriptors.size(); idx++)
   {
        GridAxisDescriptor listElement = gridAxisDescriptors.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < gridDataRecords.size(); idx++)
   {
        GridData listElement = gridDataRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public GriddedDataPdu setEnvironmentalSimulationApplicationID(SimulationIdentifier pEnvironmentalSimulationApplicationID)
{
    environmentalSimulationApplicationID = pEnvironmentalSimulationApplicationID;
    return this;
}

public SimulationIdentifier getEnvironmentalSimulationApplicationID()
{
    return environmentalSimulationApplicationID; 
}

public GriddedDataPdu setFieldNumber(short pFieldNumber)
{
    fieldNumber = pFieldNumber;
    return this;
}

public short getFieldNumber()
{
    return fieldNumber; 
}

public GriddedDataPdu setPduNumber(short pPduNumber)
{
    pduNumber = pPduNumber;
    return this;
}

public short getPduNumber()
{
    return pduNumber; 
}

public GriddedDataPdu setPduTotal(short pPduTotal)
{
    pduTotal = pPduTotal;
    return this;
}

public short getPduTotal()
{
    return pduTotal; 
}

public GriddedDataPdu setCoordinateSystem(GriddedDataCoordinateSystem pCoordinateSystem)
{
    coordinateSystem = pCoordinateSystem;
    return this;
}

public GriddedDataCoordinateSystem getCoordinateSystem()
{
    return coordinateSystem; 
}

public GriddedDataPdu setConstantGrid(GriddedDataConstantGrid pConstantGrid)
{
    constantGrid = pConstantGrid;
    return this;
}

public GriddedDataConstantGrid getConstantGrid()
{
    return constantGrid; 
}

public GriddedDataPdu setEnvironmentType(EntityType pEnvironmentType)
{
    environmentType = pEnvironmentType;
    return this;
}

public EntityType getEnvironmentType()
{
    return environmentType; 
}

public GriddedDataPdu setOrientation(EulerAngles pOrientation)
{
    orientation = pOrientation;
    return this;
}

public EulerAngles getOrientation()
{
    return orientation; 
}

public GriddedDataPdu setSampleTime(ClockTime pSampleTime)
{
    sampleTime = pSampleTime;
    return this;
}

public ClockTime getSampleTime()
{
    return sampleTime; 
}

public GriddedDataPdu setTotalValues(int pTotalValues)
{
    totalValues = pTotalValues;
    return this;
}

public int getTotalValues()
{
    return totalValues; 
}

public GriddedDataPdu setVectorDimension(byte pVectorDimension)
{
    vectorDimension = pVectorDimension;
    return this;
}

public byte getVectorDimension()
{
    return vectorDimension; 
}

public GriddedDataPdu setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}

public byte getPadding1()
{
    return padding1; 
}

public GriddedDataPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

public short getPadding2()
{
    return padding2; 
}

public GriddedDataPdu setGridAxisDescriptors(List<GridAxisDescriptor> pGridAxisDescriptors)
{
    gridAxisDescriptors = pGridAxisDescriptors;
    return this;
}

public List<GridAxisDescriptor> getGridAxisDescriptors()
{
    return gridAxisDescriptors; 
}

public GriddedDataPdu setGridDataRecords(List<GridData> pGridDataRecords)
{
    gridDataRecords = pGridDataRecords;
    return this;
}

public List<GridData> getGridDataRecords()
{
    return gridDataRecords; 
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
       environmentalSimulationApplicationID.marshal(dos);
       dos.writeShort( (short)fieldNumber);
       dos.writeShort( (short)pduNumber);
       dos.writeShort( (short)pduTotal);
       coordinateSystem.marshal(dos);
       dos.writeByte( (byte)gridDataRecords.size());
       constantGrid.marshal(dos);
       environmentType.marshal(dos);
       orientation.marshal(dos);
       sampleTime.marshal(dos);
       dos.writeInt( (int)totalValues);
       dos.writeByte( (byte)vectorDimension);
       dos.writeByte( (byte)padding1);
       dos.writeShort( (short)padding2);

       for(int idx = 0; idx < gridAxisDescriptors.size(); idx++)
       {
            GridAxisDescriptor aGridAxisDescriptor = gridAxisDescriptors.get(idx);
            aGridAxisDescriptor.marshal(dos);
       }


       for(int idx = 0; idx < gridDataRecords.size(); idx++)
       {
            GridData aGridData = gridDataRecords.get(idx);
            aGridData.marshal(dos);
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
        uPosition += environmentalSimulationApplicationID.unmarshal(dis);
        fieldNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        pduNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        pduTotal = (short)dis.readUnsignedShort();
        uPosition += 2;
        coordinateSystem = GriddedDataCoordinateSystem.unmarshalEnum(dis);
        uPosition += coordinateSystem.getMarshalledSize();
        numberOfGridAxes = (byte)dis.readUnsignedByte();
        uPosition += 1;
        constantGrid = GriddedDataConstantGrid.unmarshalEnum(dis);
        uPosition += constantGrid.getMarshalledSize();
        uPosition += environmentType.unmarshal(dis);
        uPosition += orientation.unmarshal(dis);
        uPosition += sampleTime.unmarshal(dis);
        totalValues = dis.readInt();
        uPosition += 4;
        vectorDimension = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfGridAxes; idx++)
        {
            GridAxisDescriptor anX = new GridAxisDescriptor();
            uPosition += anX.unmarshal(dis);
            gridAxisDescriptors.add(anX);
        }

        for(int idx = 0; idx < numberOfGridAxes; idx++)
        {
            GridData anX = new GridData();
            uPosition += anX.unmarshal(dis);
            gridDataRecords.add(anX);
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
   environmentalSimulationApplicationID.marshal(buff);
   buff.putShort( (short)fieldNumber);
   buff.putShort( (short)pduNumber);
   buff.putShort( (short)pduTotal);
   coordinateSystem.marshal(buff);
   buff.put( (byte)gridDataRecords.size());
   constantGrid.marshal(buff);
   environmentType.marshal(buff);
   orientation.marshal(buff);
   sampleTime.marshal(buff);
   buff.putInt( (int)totalValues);
   buff.put( (byte)vectorDimension);
   buff.put( (byte)padding1);
   buff.putShort( (short)padding2);

   for(int idx = 0; idx < gridAxisDescriptors.size(); idx++)
   {
        GridAxisDescriptor aGridAxisDescriptor = (GridAxisDescriptor)gridAxisDescriptors.get(idx);
        aGridAxisDescriptor.marshal(buff);
   }


   for(int idx = 0; idx < gridDataRecords.size(); idx++)
   {
        GridData aGridData = (GridData)gridDataRecords.get(idx);
        aGridData.marshal(buff);
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

    environmentalSimulationApplicationID.unmarshal(buff);
    fieldNumber = (short)(buff.getShort() & 0xFFFF);
    pduNumber = (short)(buff.getShort() & 0xFFFF);
    pduTotal = (short)(buff.getShort() & 0xFFFF);
    coordinateSystem = GriddedDataCoordinateSystem.unmarshalEnum(buff);
    numberOfGridAxes = (byte)(buff.get() & 0xFF);
    constantGrid = GriddedDataConstantGrid.unmarshalEnum(buff);
    environmentType.unmarshal(buff);
    orientation.unmarshal(buff);
    sampleTime.unmarshal(buff);
    totalValues = buff.getInt();
    vectorDimension = (byte)(buff.get() & 0xFF);
    padding1 = (byte)(buff.get() & 0xFF);
    padding2 = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfGridAxes; idx++)
    {
    GridAxisDescriptor anX = new GridAxisDescriptor();
    anX.unmarshal(buff);
    gridAxisDescriptors.add(anX);
    }

    for(int idx = 0; idx < numberOfGridAxes; idx++)
    {
    GridData anX = new GridData();
    anX.unmarshal(buff);
    gridDataRecords.add(anX);
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

    if(!(obj instanceof GriddedDataPdu))
        return false;

     final GriddedDataPdu rhs = (GriddedDataPdu)obj;

     if( ! (environmentalSimulationApplicationID.equals( rhs.environmentalSimulationApplicationID) )) ivarsEqual = false;
     if( ! (fieldNumber == rhs.fieldNumber)) ivarsEqual = false;
     if( ! (pduNumber == rhs.pduNumber)) ivarsEqual = false;
     if( ! (pduTotal == rhs.pduTotal)) ivarsEqual = false;
     if( ! (coordinateSystem == rhs.coordinateSystem)) ivarsEqual = false;
     if( ! (numberOfGridAxes == rhs.numberOfGridAxes)) ivarsEqual = false;
     if( ! (constantGrid == rhs.constantGrid)) ivarsEqual = false;
     if( ! (environmentType.equals( rhs.environmentType) )) ivarsEqual = false;
     if( ! (orientation.equals( rhs.orientation) )) ivarsEqual = false;
     if( ! (sampleTime.equals( rhs.sampleTime) )) ivarsEqual = false;
     if( ! (totalValues == rhs.totalValues)) ivarsEqual = false;
     if( ! (vectorDimension == rhs.vectorDimension)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;

     for(int idx = 0; idx < gridAxisDescriptors.size(); idx++)
        if( ! ( gridAxisDescriptors.get(idx).equals(rhs.gridAxisDescriptors.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < gridDataRecords.size(); idx++)
        if( ! ( gridDataRecords.get(idx).equals(rhs.gridDataRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
