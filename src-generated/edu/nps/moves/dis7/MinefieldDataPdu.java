/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.10.4 Information about the location and status of a collection of mines in a minefield is conveyed through the Minefield Data PDU on an individual mine basis.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class MinefieldDataPdu extends MinefieldFamilyPdu implements Serializable
{
   /** Minefield ID */
   protected MinefieldIdentifier  minefieldID = new MinefieldIdentifier(); 

   /** ID of entity making request */
   protected SimulationIdentifier  requestingEntityID = new SimulationIdentifier(); 

   /** Minefield sequence number */
   protected short  minefieldSequenceNumbeer;

   /** request ID */
   protected byte  requestID;

   /** pdu sequence number */
   protected byte  pduSequenceNumber;

   /** number of pdus in response */
   protected byte  numberOfPdus;

   /** how many mines are in this PDU */
   protected byte  numberOfMinesInThisPdu;

   /** how many sensor type are in this PDU */
   protected byte  numberOfSensorTypes;

   /** padding */
   protected byte  padding = (byte)0;

   /** 32 boolean field */
   protected DataFilterRecord  dataFilter = new DataFilterRecord(); 

   /** Mine type */
   protected EntityType  mineType = new EntityType(); 

   /** Sensor types, each 16 bits long */
   protected List< MinefieldSensorType > sensorTypes = new ArrayList< MinefieldSensorType >();
 
   private byte[] padTo32 = new byte[0]; // pad to 32-bit boundary

   /** Mine locations */
   protected List< Vector3Float > mineLocation = new ArrayList< Vector3Float >();
 
   protected float[]  groundBurialDepthOffset = new float[0]; 

   protected float[]  waterBurialDepthOffset = new float[0]; 

   protected float[]  snowBurialDepthOffset = new float[0]; 

   protected List< EulerAngles > mineOrientation = new ArrayList< EulerAngles >();
 
   protected float[]  thermalContrast = new float[0]; 

   protected float[]  reflectance = new float[0]; 

   protected List< MineEmplacementTime > mineEmplacementTime = new ArrayList< MineEmplacementTime >();
 
   protected short[]  mineEntityNumber = new short[0]; 

   /**  uid 192 */
   protected List< MinefieldDataFusing > fusing = new ArrayList< MinefieldDataFusing >();
 
   protected byte[]  scalarDetectionCoefficient = new byte[0]; 

   /**  uid 202 */
   protected List< MinefieldDataPaintScheme > paintScheme = new ArrayList< MinefieldDataPaintScheme >();
 
   private byte[] padTo32_2 = new byte[0]; // pad to 32-bit boundary

   protected byte[]  numberOfTripDetonationWires = new byte[0]; 

   private byte[] padTo32_3 = new byte[0]; // pad to 32-bit boundary

   protected byte[]  numberOfVertices = new byte[0]; 


/** Constructor */
 public MinefieldDataPdu()
 {
    setPduType( DISPDUType.MINEFIELD_DATA );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += minefieldID.getMarshalledSize();
   marshalSize += requestingEntityID.getMarshalledSize();
   marshalSize += 2;  // minefieldSequenceNumbeer
   marshalSize += 1;  // requestID
   marshalSize += 1;  // pduSequenceNumber
   marshalSize += 1;  // numberOfPdus
   marshalSize += 1;  // numberOfMinesInThisPdu
   marshalSize += 1;  // numberOfSensorTypes
   marshalSize += 1;  // padding
   marshalSize += dataFilter.getMarshalledSize();
   marshalSize += mineType.getMarshalledSize();
   for(int idx=0; idx < sensorTypes.size(); idx++)
   {
        MinefieldSensorType listElement = sensorTypes.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   marshalSize += padTo32.length;
   for(int idx=0; idx < mineLocation.size(); idx++)
   {
        Vector3Float listElement = mineLocation.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   marshalSize += groundBurialDepthOffset.length * 4;
   marshalSize += waterBurialDepthOffset.length * 4;
   marshalSize += snowBurialDepthOffset.length * 4;
   for(int idx=0; idx < mineOrientation.size(); idx++)
   {
        EulerAngles listElement = mineOrientation.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   marshalSize += thermalContrast.length * 4;
   marshalSize += reflectance.length * 4;
   for(int idx=0; idx < mineEmplacementTime.size(); idx++)
   {
        MineEmplacementTime listElement = mineEmplacementTime.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   marshalSize += mineEntityNumber.length * 2;
   for(int idx=0; idx < fusing.size(); idx++)
   {
        MinefieldDataFusing listElement = fusing.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   marshalSize += scalarDetectionCoefficient.length * 1;
   for(int idx=0; idx < paintScheme.size(); idx++)
   {
        MinefieldDataPaintScheme listElement = paintScheme.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   marshalSize += padTo32_2.length;
   marshalSize += numberOfTripDetonationWires.length * 1;
   marshalSize += padTo32_3.length;
   marshalSize += numberOfVertices.length * 1;

   return marshalSize;
}


/** Setter for {@link MinefieldDataPdu#minefieldID}*/
public MinefieldDataPdu setMinefieldID(MinefieldIdentifier pMinefieldID)
{
    minefieldID = pMinefieldID;
    return this;
}

/** Getter for {@link MinefieldDataPdu#minefieldID}*/
public MinefieldIdentifier getMinefieldID()
{
    return minefieldID; 
}

/** Setter for {@link MinefieldDataPdu#requestingEntityID}*/
public MinefieldDataPdu setRequestingEntityID(SimulationIdentifier pRequestingEntityID)
{
    requestingEntityID = pRequestingEntityID;
    return this;
}

/** Getter for {@link MinefieldDataPdu#requestingEntityID}*/
public SimulationIdentifier getRequestingEntityID()
{
    return requestingEntityID; 
}

/** Setter for {@link MinefieldDataPdu#minefieldSequenceNumbeer}*/
public MinefieldDataPdu setMinefieldSequenceNumbeer(short pMinefieldSequenceNumbeer)
{
    minefieldSequenceNumbeer = pMinefieldSequenceNumbeer;
    return this;
}

/** Getter for {@link MinefieldDataPdu#minefieldSequenceNumbeer}*/
public short getMinefieldSequenceNumbeer()
{
    return minefieldSequenceNumbeer; 
}

/** Setter for {@link MinefieldDataPdu#requestID}*/
public MinefieldDataPdu setRequestID(byte pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link MinefieldDataPdu#requestID}*/
public byte getRequestID()
{
    return requestID; 
}

/** Setter for {@link MinefieldDataPdu#pduSequenceNumber}*/
public MinefieldDataPdu setPduSequenceNumber(byte pPduSequenceNumber)
{
    pduSequenceNumber = pPduSequenceNumber;
    return this;
}

/** Getter for {@link MinefieldDataPdu#pduSequenceNumber}*/
public byte getPduSequenceNumber()
{
    return pduSequenceNumber; 
}

/** Setter for {@link MinefieldDataPdu#numberOfPdus}*/
public MinefieldDataPdu setNumberOfPdus(byte pNumberOfPdus)
{
    numberOfPdus = pNumberOfPdus;
    return this;
}

/** Getter for {@link MinefieldDataPdu#numberOfPdus}*/
public byte getNumberOfPdus()
{
    return numberOfPdus; 
}

/** Setter for {@link MinefieldDataPdu#padding}*/
public MinefieldDataPdu setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link MinefieldDataPdu#padding}*/
public byte getPadding()
{
    return padding; 
}

/** Setter for {@link MinefieldDataPdu#dataFilter}*/
public MinefieldDataPdu setDataFilter(DataFilterRecord pDataFilter)
{
    dataFilter = pDataFilter;
    return this;
}

/** Getter for {@link MinefieldDataPdu#dataFilter}*/
public DataFilterRecord getDataFilter()
{
    return dataFilter; 
}

/** Setter for {@link MinefieldDataPdu#mineType}*/
public MinefieldDataPdu setMineType(EntityType pMineType)
{
    mineType = pMineType;
    return this;
}

/** Getter for {@link MinefieldDataPdu#mineType}*/
public EntityType getMineType()
{
    return mineType; 
}

/** Setter for {@link MinefieldDataPdu#sensorTypes}*/
public MinefieldDataPdu setSensorTypes(List<MinefieldSensorType> pSensorTypes)
{
    sensorTypes = pSensorTypes;
    return this;
}

/** Getter for {@link MinefieldDataPdu#sensorTypes}*/
public List<MinefieldSensorType> getSensorTypes()
{
    return sensorTypes; 
}

/** Setter for {@link MinefieldDataPdu#mineLocation}*/
public MinefieldDataPdu setMineLocation(List<Vector3Float> pMineLocation)
{
    mineLocation = pMineLocation;
    return this;
}

/** Getter for {@link MinefieldDataPdu#mineLocation}*/
public List<Vector3Float> getMineLocation()
{
    return mineLocation; 
}

/** Setter for {@link MinefieldDataPdu#groundBurialDepthOffset}*/
public MinefieldDataPdu setGroundBurialDepthOffset(float[] pGroundBurialDepthOffset)
{
    groundBurialDepthOffset = pGroundBurialDepthOffset;
    return this;
}

/** Getter for {@link MinefieldDataPdu#groundBurialDepthOffset}*/
public float[] getGroundBurialDepthOffset()
{
    return groundBurialDepthOffset; 
}

/** Setter for {@link MinefieldDataPdu#waterBurialDepthOffset}*/
public MinefieldDataPdu setWaterBurialDepthOffset(float[] pWaterBurialDepthOffset)
{
    waterBurialDepthOffset = pWaterBurialDepthOffset;
    return this;
}

/** Getter for {@link MinefieldDataPdu#waterBurialDepthOffset}*/
public float[] getWaterBurialDepthOffset()
{
    return waterBurialDepthOffset; 
}

/** Setter for {@link MinefieldDataPdu#snowBurialDepthOffset}*/
public MinefieldDataPdu setSnowBurialDepthOffset(float[] pSnowBurialDepthOffset)
{
    snowBurialDepthOffset = pSnowBurialDepthOffset;
    return this;
}

/** Getter for {@link MinefieldDataPdu#snowBurialDepthOffset}*/
public float[] getSnowBurialDepthOffset()
{
    return snowBurialDepthOffset; 
}

/** Setter for {@link MinefieldDataPdu#mineOrientation}*/
public MinefieldDataPdu setMineOrientation(List<EulerAngles> pMineOrientation)
{
    mineOrientation = pMineOrientation;
    return this;
}

/** Getter for {@link MinefieldDataPdu#mineOrientation}*/
public List<EulerAngles> getMineOrientation()
{
    return mineOrientation; 
}

/** Setter for {@link MinefieldDataPdu#thermalContrast}*/
public MinefieldDataPdu setThermalContrast(float[] pThermalContrast)
{
    thermalContrast = pThermalContrast;
    return this;
}

/** Getter for {@link MinefieldDataPdu#thermalContrast}*/
public float[] getThermalContrast()
{
    return thermalContrast; 
}

/** Setter for {@link MinefieldDataPdu#reflectance}*/
public MinefieldDataPdu setReflectance(float[] pReflectance)
{
    reflectance = pReflectance;
    return this;
}

/** Getter for {@link MinefieldDataPdu#reflectance}*/
public float[] getReflectance()
{
    return reflectance; 
}

/** Setter for {@link MinefieldDataPdu#mineEmplacementTime}*/
public MinefieldDataPdu setMineEmplacementTime(List<MineEmplacementTime> pMineEmplacementTime)
{
    mineEmplacementTime = pMineEmplacementTime;
    return this;
}

/** Getter for {@link MinefieldDataPdu#mineEmplacementTime}*/
public List<MineEmplacementTime> getMineEmplacementTime()
{
    return mineEmplacementTime; 
}

/** Setter for {@link MinefieldDataPdu#mineEntityNumber}*/
public MinefieldDataPdu setMineEntityNumber(short[] pMineEntityNumber)
{
    mineEntityNumber = pMineEntityNumber;
    return this;
}

/** Getter for {@link MinefieldDataPdu#mineEntityNumber}*/
public short[] getMineEntityNumber()
{
    return mineEntityNumber; 
}

/** Setter for {@link MinefieldDataPdu#fusing}*/
public MinefieldDataPdu setFusing(List<MinefieldDataFusing> pFusing)
{
    fusing = pFusing;
    return this;
}

/** Getter for {@link MinefieldDataPdu#fusing}*/
public List<MinefieldDataFusing> getFusing()
{
    return fusing; 
}

/** Setter for {@link MinefieldDataPdu#scalarDetectionCoefficient}*/
public MinefieldDataPdu setScalarDetectionCoefficient(byte[] pScalarDetectionCoefficient)
{
    scalarDetectionCoefficient = pScalarDetectionCoefficient;
    return this;
}

/** Getter for {@link MinefieldDataPdu#scalarDetectionCoefficient}*/
public byte[] getScalarDetectionCoefficient()
{
    return scalarDetectionCoefficient; 
}

/** Setter for {@link MinefieldDataPdu#paintScheme}*/
public MinefieldDataPdu setPaintScheme(List<MinefieldDataPaintScheme> pPaintScheme)
{
    paintScheme = pPaintScheme;
    return this;
}

/** Getter for {@link MinefieldDataPdu#paintScheme}*/
public List<MinefieldDataPaintScheme> getPaintScheme()
{
    return paintScheme; 
}

/** Setter for {@link MinefieldDataPdu#numberOfTripDetonationWires}*/
public MinefieldDataPdu setNumberOfTripDetonationWires(byte[] pNumberOfTripDetonationWires)
{
    numberOfTripDetonationWires = pNumberOfTripDetonationWires;
    return this;
}

/** Getter for {@link MinefieldDataPdu#numberOfTripDetonationWires}*/
public byte[] getNumberOfTripDetonationWires()
{
    return numberOfTripDetonationWires; 
}

/** Setter for {@link MinefieldDataPdu#numberOfVertices}*/
public MinefieldDataPdu setNumberOfVertices(byte[] pNumberOfVertices)
{
    numberOfVertices = pNumberOfVertices;
    return this;
}

/** Getter for {@link MinefieldDataPdu#numberOfVertices}*/
public byte[] getNumberOfVertices()
{
    return numberOfVertices; 
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
       minefieldID.marshal(dos);
       requestingEntityID.marshal(dos);
       dos.writeShort(minefieldSequenceNumbeer);
       dos.writeByte(requestID);
       dos.writeByte(pduSequenceNumber);
       dos.writeByte(numberOfPdus);
       dos.writeByte(numberOfVertices.length);
       dos.writeByte(sensorTypes.size());
       dos.writeByte(padding);
       dataFilter.marshal(dos);
       mineType.marshal(dos);

       for(int idx = 0; idx < sensorTypes.size(); idx++)
       {
            MinefieldSensorType aMinefieldSensorType = sensorTypes.get(idx);
            aMinefieldSensorType.marshal(dos);
       }

       padTo32 = new byte[Align.to32bits(dos)];

       for(int idx = 0; idx < mineLocation.size(); idx++)
       {
            Vector3Float aVector3Float = mineLocation.get(idx);
            aVector3Float.marshal(dos);
       }


       for(int idx = 0; idx < groundBurialDepthOffset.length; idx++)
           dos.writeFloat(groundBurialDepthOffset[idx]);


       for(int idx = 0; idx < waterBurialDepthOffset.length; idx++)
           dos.writeFloat(waterBurialDepthOffset[idx]);


       for(int idx = 0; idx < snowBurialDepthOffset.length; idx++)
           dos.writeFloat(snowBurialDepthOffset[idx]);


       for(int idx = 0; idx < mineOrientation.size(); idx++)
       {
            EulerAngles aEulerAngles = mineOrientation.get(idx);
            aEulerAngles.marshal(dos);
       }


       for(int idx = 0; idx < thermalContrast.length; idx++)
           dos.writeFloat(thermalContrast[idx]);


       for(int idx = 0; idx < reflectance.length; idx++)
           dos.writeFloat(reflectance[idx]);


       for(int idx = 0; idx < mineEmplacementTime.size(); idx++)
       {
            MineEmplacementTime aMineEmplacementTime = mineEmplacementTime.get(idx);
            aMineEmplacementTime.marshal(dos);
       }


       for(int idx = 0; idx < mineEntityNumber.length; idx++)
           dos.writeShort(mineEntityNumber[idx]);


       for(int idx = 0; idx < fusing.size(); idx++)
       {
            MinefieldDataFusing aMinefieldDataFusing = fusing.get(idx);
            aMinefieldDataFusing.marshal(dos);
       }


       for(int idx = 0; idx < scalarDetectionCoefficient.length; idx++)
           dos.writeByte(scalarDetectionCoefficient[idx]);


       for(int idx = 0; idx < paintScheme.size(); idx++)
       {
            MinefieldDataPaintScheme aMinefieldDataPaintScheme = paintScheme.get(idx);
            aMinefieldDataPaintScheme.marshal(dos);
       }

       padTo32_2 = new byte[Align.to32bits(dos)];

       for(int idx = 0; idx < numberOfTripDetonationWires.length; idx++)
           dos.writeByte(numberOfTripDetonationWires[idx]);

       padTo32_3 = new byte[Align.to32bits(dos)];

       for(int idx = 0; idx < numberOfVertices.length; idx++)
           dos.writeByte(numberOfVertices[idx]);

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
        uPosition += minefieldID.unmarshal(dis);
        uPosition += requestingEntityID.unmarshal(dis);
        minefieldSequenceNumbeer = (short)dis.readUnsignedShort();
        uPosition += 2;
        requestID = (byte)dis.readUnsignedByte();
        uPosition += 1;
        pduSequenceNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfPdus = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfMinesInThisPdu = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfSensorTypes = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += dataFilter.unmarshal(dis);
        uPosition += mineType.unmarshal(dis);
        for(int idx = 0; idx < numberOfSensorTypes; idx++)
        {
            MinefieldSensorType anX = new MinefieldSensorType();
            uPosition += anX.unmarshal(dis);
            sensorTypes.add(anX);
        }

        padTo32 = new byte[Align.from32bits(uPosition,dis)];
        uPosition += padTo32.length;
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
            Vector3Float anX = new Vector3Float();
            uPosition += anX.unmarshal(dis);
            mineLocation.add(anX);
        }

        for(int idx = 0; idx < groundBurialDepthOffset.length; idx++)
            groundBurialDepthOffset[idx] = dis.readFloat();
        uPosition += (groundBurialDepthOffset.length * 4);
        for(int idx = 0; idx < waterBurialDepthOffset.length; idx++)
            waterBurialDepthOffset[idx] = dis.readFloat();
        uPosition += (waterBurialDepthOffset.length * 4);
        for(int idx = 0; idx < snowBurialDepthOffset.length; idx++)
            snowBurialDepthOffset[idx] = dis.readFloat();
        uPosition += (snowBurialDepthOffset.length * 4);
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
            EulerAngles anX = new EulerAngles();
            uPosition += anX.unmarshal(dis);
            mineOrientation.add(anX);
        }

        for(int idx = 0; idx < thermalContrast.length; idx++)
            thermalContrast[idx] = dis.readFloat();
        uPosition += (thermalContrast.length * 4);
        for(int idx = 0; idx < reflectance.length; idx++)
            reflectance[idx] = dis.readFloat();
        uPosition += (reflectance.length * 4);
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
            MineEmplacementTime anX = new MineEmplacementTime();
            uPosition += anX.unmarshal(dis);
            mineEmplacementTime.add(anX);
        }

        for(int idx = 0; idx < mineEntityNumber.length; idx++)
            mineEntityNumber[idx] = dis.readShort();
        uPosition += (mineEntityNumber.length * 2);
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
            MinefieldDataFusing anX = new MinefieldDataFusing();
            uPosition += anX.unmarshal(dis);
            fusing.add(anX);
        }

        for(int idx = 0; idx < scalarDetectionCoefficient.length; idx++)
            scalarDetectionCoefficient[idx] = dis.readByte();
        uPosition += (scalarDetectionCoefficient.length * 1);
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
            MinefieldDataPaintScheme anX = new MinefieldDataPaintScheme();
            uPosition += anX.unmarshal(dis);
            paintScheme.add(anX);
        }

        padTo32_2 = new byte[Align.from32bits(uPosition,dis)];
        uPosition += padTo32_2.length;
        for(int idx = 0; idx < numberOfTripDetonationWires.length; idx++)
            numberOfTripDetonationWires[idx] = dis.readByte();
        uPosition += (numberOfTripDetonationWires.length * 1);
        padTo32_3 = new byte[Align.from32bits(uPosition,dis)];
        uPosition += padTo32_3.length;
        for(int idx = 0; idx < numberOfVertices.length; idx++)
            numberOfVertices[idx] = dis.readByte();
        uPosition += (numberOfVertices.length * 1);
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
   minefieldID.marshal(buff);
   requestingEntityID.marshal(buff);
   buff.putShort( (short)minefieldSequenceNumbeer);
   buff.put( (byte)requestID);
   buff.put( (byte)pduSequenceNumber);
   buff.put( (byte)numberOfPdus);
   buff.put( (byte)numberOfVertices.length);
   buff.put( (byte)sensorTypes.size());
   buff.put( (byte)padding);
   dataFilter.marshal(buff);
   mineType.marshal(buff);

   for(int idx = 0; idx < sensorTypes.size(); idx++)
   {
        MinefieldSensorType aMinefieldSensorType = sensorTypes.get(idx);
        aMinefieldSensorType.marshal(buff);
   }

   padTo32 = new byte[Align.to32bits(buff)];

   for(int idx = 0; idx < mineLocation.size(); idx++)
   {
        Vector3Float aVector3Float = mineLocation.get(idx);
        aVector3Float.marshal(buff);
   }


   for(int idx = 0; idx < groundBurialDepthOffset.length; idx++)
       buff.putFloat((float)groundBurialDepthOffset[idx]);


   for(int idx = 0; idx < waterBurialDepthOffset.length; idx++)
       buff.putFloat((float)waterBurialDepthOffset[idx]);


   for(int idx = 0; idx < snowBurialDepthOffset.length; idx++)
       buff.putFloat((float)snowBurialDepthOffset[idx]);


   for(int idx = 0; idx < mineOrientation.size(); idx++)
   {
        EulerAngles aEulerAngles = mineOrientation.get(idx);
        aEulerAngles.marshal(buff);
   }


   for(int idx = 0; idx < thermalContrast.length; idx++)
       buff.putFloat((float)thermalContrast[idx]);


   for(int idx = 0; idx < reflectance.length; idx++)
       buff.putFloat((float)reflectance[idx]);


   for(int idx = 0; idx < mineEmplacementTime.size(); idx++)
   {
        MineEmplacementTime aMineEmplacementTime = mineEmplacementTime.get(idx);
        aMineEmplacementTime.marshal(buff);
   }


   for(int idx = 0; idx < mineEntityNumber.length; idx++)
       buff.putShort((short)mineEntityNumber[idx]);


   for(int idx = 0; idx < fusing.size(); idx++)
   {
        MinefieldDataFusing aMinefieldDataFusing = fusing.get(idx);
        aMinefieldDataFusing.marshal(buff);
   }


   for(int idx = 0; idx < scalarDetectionCoefficient.length; idx++)
       buff.put((byte)scalarDetectionCoefficient[idx]);


   for(int idx = 0; idx < paintScheme.size(); idx++)
   {
        MinefieldDataPaintScheme aMinefieldDataPaintScheme = paintScheme.get(idx);
        aMinefieldDataPaintScheme.marshal(buff);
   }

   padTo32_2 = new byte[Align.to32bits(buff)];

   for(int idx = 0; idx < numberOfTripDetonationWires.length; idx++)
       buff.put((byte)numberOfTripDetonationWires[idx]);

   padTo32_3 = new byte[Align.to32bits(buff)];

   for(int idx = 0; idx < numberOfVertices.length; idx++)
       buff.put((byte)numberOfVertices[idx]);

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

    minefieldID.unmarshal(buff);
    requestingEntityID.unmarshal(buff);
    minefieldSequenceNumbeer = (short)(buff.getShort() & 0xFFFF);
    requestID = (byte)(buff.get() & 0xFF);
    pduSequenceNumber = (byte)(buff.get() & 0xFF);
    numberOfPdus = (byte)(buff.get() & 0xFF);
    numberOfMinesInThisPdu = (byte)(buff.get() & 0xFF);
    numberOfSensorTypes = (byte)(buff.get() & 0xFF);
    padding = (byte)(buff.get() & 0xFF);
    dataFilter.unmarshal(buff);
    mineType.unmarshal(buff);
    for(int idx = 0; idx < numberOfSensorTypes; idx++)
    {
    MinefieldSensorType anX = new MinefieldSensorType();
    anX.unmarshal(buff);
    sensorTypes.add(anX);
    }

    padTo32 = new byte[Align.from32bits(buff)];
    for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
    {
    Vector3Float anX = new Vector3Float();
    anX.unmarshal(buff);
    mineLocation.add(anX);
    }

    for(int idx = 0; idx < groundBurialDepthOffset.length; idx++)
        groundBurialDepthOffset[idx] = buff.getFloat();
    for(int idx = 0; idx < waterBurialDepthOffset.length; idx++)
        waterBurialDepthOffset[idx] = buff.getFloat();
    for(int idx = 0; idx < snowBurialDepthOffset.length; idx++)
        snowBurialDepthOffset[idx] = buff.getFloat();
    for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
    {
    EulerAngles anX = new EulerAngles();
    anX.unmarshal(buff);
    mineOrientation.add(anX);
    }

    for(int idx = 0; idx < thermalContrast.length; idx++)
        thermalContrast[idx] = buff.getFloat();
    for(int idx = 0; idx < reflectance.length; idx++)
        reflectance[idx] = buff.getFloat();
    for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
    {
    MineEmplacementTime anX = new MineEmplacementTime();
    anX.unmarshal(buff);
    mineEmplacementTime.add(anX);
    }

    for(int idx = 0; idx < mineEntityNumber.length; idx++)
        mineEntityNumber[idx] = buff.getShort();
    for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
    {
    MinefieldDataFusing anX = new MinefieldDataFusing();
    anX.unmarshal(buff);
    fusing.add(anX);
    }

    for(int idx = 0; idx < scalarDetectionCoefficient.length; idx++)
        scalarDetectionCoefficient[idx] = buff.get();
    for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
    {
    MinefieldDataPaintScheme anX = new MinefieldDataPaintScheme();
    anX.unmarshal(buff);
    paintScheme.add(anX);
    }

    padTo32_2 = new byte[Align.from32bits(buff)];
    for(int idx = 0; idx < numberOfTripDetonationWires.length; idx++)
        numberOfTripDetonationWires[idx] = buff.get();
    padTo32_3 = new byte[Align.from32bits(buff)];
    for(int idx = 0; idx < numberOfVertices.length; idx++)
        numberOfVertices[idx] = buff.get();
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

     final MinefieldDataPdu rhs = (MinefieldDataPdu)obj;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (minefieldSequenceNumbeer == rhs.minefieldSequenceNumbeer)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (pduSequenceNumber == rhs.pduSequenceNumber)) ivarsEqual = false;
     if( ! (numberOfPdus == rhs.numberOfPdus)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (dataFilter.equals( rhs.dataFilter) )) ivarsEqual = false;
     if( ! (mineType.equals( rhs.mineType) )) ivarsEqual = false;

     for(int idx = 0; idx < sensorTypes.size(); idx++)
        if( ! ( sensorTypes.get(idx).equals(rhs.sensorTypes.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < mineLocation.size(); idx++)
        if( ! ( mineLocation.get(idx).equals(rhs.mineLocation.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < 0; idx++)
     {
          if(!(groundBurialDepthOffset[idx] == rhs.groundBurialDepthOffset[idx])) ivarsEqual = false;
     }


     for(int idx = 0; idx < 0; idx++)
     {
          if(!(waterBurialDepthOffset[idx] == rhs.waterBurialDepthOffset[idx])) ivarsEqual = false;
     }


     for(int idx = 0; idx < 0; idx++)
     {
          if(!(snowBurialDepthOffset[idx] == rhs.snowBurialDepthOffset[idx])) ivarsEqual = false;
     }


     for(int idx = 0; idx < mineOrientation.size(); idx++)
        if( ! ( mineOrientation.get(idx).equals(rhs.mineOrientation.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < 0; idx++)
     {
          if(!(thermalContrast[idx] == rhs.thermalContrast[idx])) ivarsEqual = false;
     }


     for(int idx = 0; idx < 0; idx++)
     {
          if(!(reflectance[idx] == rhs.reflectance[idx])) ivarsEqual = false;
     }


     for(int idx = 0; idx < mineEmplacementTime.size(); idx++)
        if( ! ( mineEmplacementTime.get(idx).equals(rhs.mineEmplacementTime.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < 0; idx++)
     {
          if(!(mineEntityNumber[idx] == rhs.mineEntityNumber[idx])) ivarsEqual = false;
     }


     for(int idx = 0; idx < fusing.size(); idx++)
        if( ! ( fusing.get(idx).equals(rhs.fusing.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < 0; idx++)
     {
          if(!(scalarDetectionCoefficient[idx] == rhs.scalarDetectionCoefficient[idx])) ivarsEqual = false;
     }


     for(int idx = 0; idx < paintScheme.size(); idx++)
        if( ! ( paintScheme.get(idx).equals(rhs.paintScheme.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < 0; idx++)
     {
          if(!(numberOfTripDetonationWires[idx] == rhs.numberOfTripDetonationWires[idx])) ivarsEqual = false;
     }


     for(int idx = 0; idx < 0; idx++)
     {
          if(!(numberOfVertices[idx] == rhs.numberOfVertices[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" minefieldID: ").append(minefieldID).append("\n");
    sb.append(" requestingEntityID: ").append(requestingEntityID).append("\n");
    sb.append(" minefieldSequenceNumbeer: ").append(minefieldSequenceNumbeer).append("\n");
    sb.append(" requestID: ").append(requestID).append("\n");
    sb.append(" pduSequenceNumber: ").append(pduSequenceNumber).append("\n");
    sb.append(" numberOfPdus: ").append(numberOfPdus).append("\n");
    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" dataFilter: ").append(dataFilter).append("\n");
    sb.append(" mineType: ").append(mineType).append("\n");
    sb.append(" padTo32: ").append(padTo32).append("\n");
    sb.append(" groundBurialDepthOffset: ").append("\n");
    sb.append(Arrays.toString(groundBurialDepthOffset)).append("\n");
    sb.append(" waterBurialDepthOffset: ").append("\n");
    sb.append(Arrays.toString(waterBurialDepthOffset)).append("\n");
    sb.append(" snowBurialDepthOffset: ").append("\n");
    sb.append(Arrays.toString(snowBurialDepthOffset)).append("\n");
    sb.append(" thermalContrast: ").append("\n");
    sb.append(Arrays.toString(thermalContrast)).append("\n");
    sb.append(" reflectance: ").append("\n");
    sb.append(Arrays.toString(reflectance)).append("\n");
    sb.append(" mineEntityNumber: ").append("\n");
    sb.append(Arrays.toString(mineEntityNumber)).append("\n");
    sb.append(" scalarDetectionCoefficient: ").append("\n");
    sb.append(Arrays.toString(scalarDetectionCoefficient)).append("\n");
    sb.append(" padTo32_2: ").append(padTo32_2).append("\n");
    sb.append(" numberOfTripDetonationWires: ").append("\n");
    sb.append(Arrays.toString(numberOfTripDetonationWires)).append("\n");
    sb.append(" padTo32_3: ").append(padTo32_3).append("\n");
    sb.append(" numberOfVertices: ").append("\n");
    sb.append(Arrays.toString(numberOfVertices)).append("\n");
    sb.append(" sensorTypes: ").append("\n");
    sensorTypes.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" mineLocation: ").append("\n");
    mineLocation.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" mineOrientation: ").append("\n");
    mineOrientation.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" mineEmplacementTime: ").append("\n");
    mineEmplacementTime.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" fusing: ").append("\n");
    fusing.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});
    sb.append(" paintScheme: ").append("\n");
    paintScheme.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
