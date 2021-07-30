/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.10.3 Used to communicate information about global, spatially varying environmental effects.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
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

   /** valid time of the enviormental data sample, 64-bit unsigned int */
   protected ClockTime  sampleTime = new ClockTime(); 

   /** total number of all data values for all pdus for an environmental sample */
   protected int  totalValues;

   /** total number of data values at each grid point. */
   protected byte  vectorDimension;

   /** padding */
   protected byte  padding1;

   /** padding */
   protected short  padding2;

   /** gridAxisDescriptors is an undescribed parameter... */
   protected List< GridAxisDescriptor > gridAxisDescriptors = new ArrayList< GridAxisDescriptor >();
 
   /** gridDataRecords is an undescribed parameter... */
   protected List< GridData > gridDataRecords = new ArrayList< GridData >();
 

/** Constructor */
 public GriddedDataPdu()
 {
    setPduType( DisPduType.GRIDDED_DATA );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
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


/** Setter for {@link GriddedDataPdu#environmentalSimulationApplicationID}
  * @param pEnvironmentalSimulationApplicationID new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setEnvironmentalSimulationApplicationID(SimulationIdentifier pEnvironmentalSimulationApplicationID)
{
    environmentalSimulationApplicationID = pEnvironmentalSimulationApplicationID;
    return this;
}

/** Getter for {@link GriddedDataPdu#environmentalSimulationApplicationID}
  * @return value of interest */
public SimulationIdentifier getEnvironmentalSimulationApplicationID()
{
    return environmentalSimulationApplicationID; 
}

/** Setter for {@link GriddedDataPdu#fieldNumber}
  * @param pFieldNumber new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setFieldNumber(short pFieldNumber)
{
    fieldNumber = pFieldNumber;
    return this;
}
/** Utility setter for {@link GriddedDataPdu#fieldNumber}
  * @param pFieldNumber new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setFieldNumber(int pFieldNumber){
    fieldNumber = (short) pFieldNumber;
    return this;
}

/** Getter for {@link GriddedDataPdu#fieldNumber}
  * @return value of interest */
public short getFieldNumber()
{
    return fieldNumber; 
}

/** Setter for {@link GriddedDataPdu#pduNumber}
  * @param pPduNumber new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setPduNumber(short pPduNumber)
{
    pduNumber = pPduNumber;
    return this;
}
/** Utility setter for {@link GriddedDataPdu#pduNumber}
  * @param pPduNumber new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setPduNumber(int pPduNumber){
    pduNumber = (short) pPduNumber;
    return this;
}

/** Getter for {@link GriddedDataPdu#pduNumber}
  * @return value of interest */
public short getPduNumber()
{
    return pduNumber; 
}

/** Setter for {@link GriddedDataPdu#pduTotal}
  * @param pPduTotal new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setPduTotal(short pPduTotal)
{
    pduTotal = pPduTotal;
    return this;
}
/** Utility setter for {@link GriddedDataPdu#pduTotal}
  * @param pPduTotal new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setPduTotal(int pPduTotal){
    pduTotal = (short) pPduTotal;
    return this;
}

/** Getter for {@link GriddedDataPdu#pduTotal}
  * @return value of interest */
public short getPduTotal()
{
    return pduTotal; 
}

/** Setter for {@link GriddedDataPdu#coordinateSystem}
  * @param pCoordinateSystem new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setCoordinateSystem(GriddedDataCoordinateSystem pCoordinateSystem)
{
    coordinateSystem = pCoordinateSystem;
    return this;
}

/** Getter for {@link GriddedDataPdu#coordinateSystem}
  * @return value of interest */
public GriddedDataCoordinateSystem getCoordinateSystem()
{
    return coordinateSystem; 
}

/** Setter for {@link GriddedDataPdu#constantGrid}
  * @param pConstantGrid new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setConstantGrid(GriddedDataConstantGrid pConstantGrid)
{
    constantGrid = pConstantGrid;
    return this;
}

/** Getter for {@link GriddedDataPdu#constantGrid}
  * @return value of interest */
public GriddedDataConstantGrid getConstantGrid()
{
    return constantGrid; 
}

/** Setter for {@link GriddedDataPdu#environmentType}
  * @param pEnvironmentType new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setEnvironmentType(EntityType pEnvironmentType)
{
    environmentType = pEnvironmentType;
    return this;
}

/** Getter for {@link GriddedDataPdu#environmentType}
  * @return value of interest */
public EntityType getEnvironmentType()
{
    return environmentType; 
}

/** Setter for {@link GriddedDataPdu#orientation}
  * @param pOrientation new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setOrientation(EulerAngles pOrientation)
{
    orientation = pOrientation;
    return this;
}

/** Getter for {@link GriddedDataPdu#orientation}
  * @return value of interest */
public EulerAngles getOrientation()
{
    return orientation; 
}

/** Setter for {@link GriddedDataPdu#sampleTime}
  * @param pSampleTime new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setSampleTime(ClockTime pSampleTime)
{
    sampleTime = pSampleTime;
    return this;
}

/** Getter for {@link GriddedDataPdu#sampleTime}
  * @return value of interest */
public ClockTime getSampleTime()
{
    return sampleTime; 
}

/** Setter for {@link GriddedDataPdu#totalValues}
  * @param pTotalValues new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setTotalValues(int pTotalValues)
{
    totalValues = pTotalValues;
    return this;
}

/** Getter for {@link GriddedDataPdu#totalValues}
  * @return value of interest */
public int getTotalValues()
{
    return totalValues; 
}

/** Setter for {@link GriddedDataPdu#vectorDimension}
  * @param pVectorDimension new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setVectorDimension(byte pVectorDimension)
{
    vectorDimension = pVectorDimension;
    return this;
}
/** Utility setter for {@link GriddedDataPdu#vectorDimension}
  * @param pVectorDimension new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setVectorDimension(int pVectorDimension){
    vectorDimension = (byte) pVectorDimension;
    return this;
}

/** Getter for {@link GriddedDataPdu#vectorDimension}
  * @return value of interest */
public byte getVectorDimension()
{
    return vectorDimension; 
}

/** Setter for {@link GriddedDataPdu#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}
/** Utility setter for {@link GriddedDataPdu#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setPadding1(int pPadding1){
    padding1 = (byte) pPadding1;
    return this;
}

/** Getter for {@link GriddedDataPdu#padding1}
  * @return value of interest */
public byte getPadding1()
{
    return padding1; 
}

/** Setter for {@link GriddedDataPdu#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}
/** Utility setter for {@link GriddedDataPdu#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setPadding2(int pPadding2){
    padding2 = (short) pPadding2;
    return this;
}

/** Getter for {@link GriddedDataPdu#padding2}
  * @return value of interest */
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link GriddedDataPdu#gridAxisDescriptors}
  * @param pGridAxisDescriptors new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setGridAxisDescriptors(List<GridAxisDescriptor> pGridAxisDescriptors)
{
    gridAxisDescriptors = pGridAxisDescriptors;
    return this;
}

/** Getter for {@link GriddedDataPdu#gridAxisDescriptors}
  * @return value of interest */
public List<GridAxisDescriptor> getGridAxisDescriptors()
{
    return gridAxisDescriptors; 
}

/** Setter for {@link GriddedDataPdu#gridDataRecords}
  * @param pGridDataRecords new value of interest
  * @return same object to permit progressive setters */
public GriddedDataPdu setGridDataRecords(List<GridData> pGridDataRecords)
{
    gridDataRecords = pGridDataRecords;
    return this;
}

/** Getter for {@link GriddedDataPdu#gridDataRecords}
  * @return value of interest */
public List<GridData> getGridDataRecords()
{
    return gridDataRecords; 
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
       environmentalSimulationApplicationID.marshal(dos);
       dos.writeShort(fieldNumber);
       dos.writeShort(pduNumber);
       dos.writeShort(pduTotal);
       coordinateSystem.marshal(dos);
       dos.writeByte(gridDataRecords.size());
       constantGrid.marshal(dos);
       environmentType.marshal(dos);
       orientation.marshal(dos);
       sampleTime.marshal(dos);
       dos.writeInt(totalValues);
       dos.writeByte(vectorDimension);
       dos.writeByte(padding1);
       dos.writeShort(padding2);

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
 * Deserializes an object from a DataInputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataInputStream
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
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
   environmentalSimulationApplicationID.marshal(byteBuffer);
   byteBuffer.putShort( (short)fieldNumber);
   byteBuffer.putShort( (short)pduNumber);
   byteBuffer.putShort( (short)pduTotal);
   coordinateSystem.marshal(byteBuffer);
   byteBuffer.put( (byte)gridDataRecords.size());
   constantGrid.marshal(byteBuffer);
   environmentType.marshal(byteBuffer);
   orientation.marshal(byteBuffer);
   sampleTime.marshal(byteBuffer);
   byteBuffer.putInt( (int)totalValues);
   byteBuffer.put( (byte)vectorDimension);
   byteBuffer.put( (byte)padding1);
   byteBuffer.putShort( (short)padding2);

   for(int idx = 0; idx < gridAxisDescriptors.size(); idx++)
   {
        GridAxisDescriptor aGridAxisDescriptor = gridAxisDescriptors.get(idx);
        aGridAxisDescriptor.marshal(byteBuffer);
   }


   for(int idx = 0; idx < gridDataRecords.size(); idx++)
   {
        GridData aGridData = gridDataRecords.get(idx);
        aGridData.marshal(byteBuffer);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    environmentalSimulationApplicationID.unmarshal(byteBuffer);
    fieldNumber = (short)(byteBuffer.getShort() & 0xFFFF);
    pduNumber = (short)(byteBuffer.getShort() & 0xFFFF);
    pduTotal = (short)(byteBuffer.getShort() & 0xFFFF);
    coordinateSystem = GriddedDataCoordinateSystem.unmarshalEnum(byteBuffer);
    numberOfGridAxes = (byte)(byteBuffer.get() & 0xFF);
    constantGrid = GriddedDataConstantGrid.unmarshalEnum(byteBuffer);
    environmentType.unmarshal(byteBuffer);
    orientation.unmarshal(byteBuffer);
    sampleTime.unmarshal(byteBuffer);
    totalValues = byteBuffer.getInt();
    vectorDimension = (byte)(byteBuffer.get() & 0xFF);
    padding1 = (byte)(byteBuffer.get() & 0xFF);
    padding2 = (short)(byteBuffer.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfGridAxes; idx++)
    {
    GridAxisDescriptor anX = new GridAxisDescriptor();
    anX.unmarshal(byteBuffer);
    gridAxisDescriptors.add(anX);
    }

    for(int idx = 0; idx < numberOfGridAxes; idx++)
    {
    GridData anX = new GridData();
    anX.unmarshal(byteBuffer);
    gridDataRecords.add(anX);
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

     final GriddedDataPdu rhs = (GriddedDataPdu)obj;

     if( ! (environmentalSimulationApplicationID.equals( rhs.environmentalSimulationApplicationID) )) ivarsEqual = false;
     if( ! (fieldNumber == rhs.fieldNumber)) ivarsEqual = false;
     if( ! (pduNumber == rhs.pduNumber)) ivarsEqual = false;
     if( ! (pduTotal == rhs.pduTotal)) ivarsEqual = false;
     if( ! (coordinateSystem == rhs.coordinateSystem)) ivarsEqual = false;
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

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" environmentalSimulationApplicationID: ").append(environmentalSimulationApplicationID).append("\n");
    sb.append(" fieldNumber: ").append(fieldNumber).append("\n");
    sb.append(" pduNumber: ").append(pduNumber).append("\n");
    sb.append(" pduTotal: ").append(pduTotal).append("\n");
    sb.append(" coordinateSystem: ").append(coordinateSystem).append("\n");
    sb.append(" constantGrid: ").append(constantGrid).append("\n");
    sb.append(" environmentType: ").append(environmentType).append("\n");
    sb.append(" orientation: ").append(orientation).append("\n");
    sb.append(" sampleTime: ").append(sampleTime).append("\n");
    sb.append(" totalValues: ").append(totalValues).append("\n");
    sb.append(" vectorDimension: ").append(vectorDimension).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");
    sb.append(" gridAxisDescriptors: ").append("\n");
    gridAxisDescriptors.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" gridDataRecords: ").append("\n");
    gridDataRecords.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
