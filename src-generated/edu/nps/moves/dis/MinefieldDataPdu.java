package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Information about individual mines within a minefield. This is very, very wrong. Section 7.9.4 UNFINISHED
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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


public MinefieldDataPdu setMinefieldID(MinefieldIdentifier pMinefieldID)
{
    minefieldID = pMinefieldID;
    return this;
}

public MinefieldIdentifier getMinefieldID()
{
    return minefieldID; 
}

public MinefieldDataPdu setRequestingEntityID(SimulationIdentifier pRequestingEntityID)
{
    requestingEntityID = pRequestingEntityID;
    return this;
}

public SimulationIdentifier getRequestingEntityID()
{
    return requestingEntityID; 
}

public MinefieldDataPdu setMinefieldSequenceNumbeer(short pMinefieldSequenceNumbeer)
{
    minefieldSequenceNumbeer = pMinefieldSequenceNumbeer;
    return this;
}

public short getMinefieldSequenceNumbeer()
{
    return minefieldSequenceNumbeer; 
}

public MinefieldDataPdu setRequestID(byte pRequestID)
{
    requestID = pRequestID;
    return this;
}

public byte getRequestID()
{
    return requestID; 
}

public MinefieldDataPdu setPduSequenceNumber(byte pPduSequenceNumber)
{
    pduSequenceNumber = pPduSequenceNumber;
    return this;
}

public byte getPduSequenceNumber()
{
    return pduSequenceNumber; 
}

public MinefieldDataPdu setNumberOfPdus(byte pNumberOfPdus)
{
    numberOfPdus = pNumberOfPdus;
    return this;
}

public byte getNumberOfPdus()
{
    return numberOfPdus; 
}

public MinefieldDataPdu setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

public byte getPadding()
{
    return padding; 
}

public MinefieldDataPdu setDataFilter(DataFilterRecord pDataFilter)
{
    dataFilter = pDataFilter;
    return this;
}

public DataFilterRecord getDataFilter()
{
    return dataFilter; 
}

public MinefieldDataPdu setMineType(EntityType pMineType)
{
    mineType = pMineType;
    return this;
}

public EntityType getMineType()
{
    return mineType; 
}

public MinefieldDataPdu setSensorTypes(List<MinefieldSensorType> pSensorTypes)
{
    sensorTypes = pSensorTypes;
    return this;
}

public List<MinefieldSensorType> getSensorTypes()
{
    return sensorTypes; 
}

public MinefieldDataPdu setMineLocation(List<Vector3Float> pMineLocation)
{
    mineLocation = pMineLocation;
    return this;
}

public List<Vector3Float> getMineLocation()
{
    return mineLocation; 
}

public MinefieldDataPdu setGroundBurialDepthOffset(float[] pGroundBurialDepthOffset)
{
    groundBurialDepthOffset = pGroundBurialDepthOffset;
    return this;
}

public float[] getGroundBurialDepthOffset()
{
    return groundBurialDepthOffset; 
}

public MinefieldDataPdu setWaterBurialDepthOffset(float[] pWaterBurialDepthOffset)
{
    waterBurialDepthOffset = pWaterBurialDepthOffset;
    return this;
}

public float[] getWaterBurialDepthOffset()
{
    return waterBurialDepthOffset; 
}

public MinefieldDataPdu setSnowBurialDepthOffset(float[] pSnowBurialDepthOffset)
{
    snowBurialDepthOffset = pSnowBurialDepthOffset;
    return this;
}

public float[] getSnowBurialDepthOffset()
{
    return snowBurialDepthOffset; 
}

public MinefieldDataPdu setMineOrientation(List<EulerAngles> pMineOrientation)
{
    mineOrientation = pMineOrientation;
    return this;
}

public List<EulerAngles> getMineOrientation()
{
    return mineOrientation; 
}

public MinefieldDataPdu setThermalContrast(float[] pThermalContrast)
{
    thermalContrast = pThermalContrast;
    return this;
}

public float[] getThermalContrast()
{
    return thermalContrast; 
}

public MinefieldDataPdu setReflectance(float[] pReflectance)
{
    reflectance = pReflectance;
    return this;
}

public float[] getReflectance()
{
    return reflectance; 
}

public MinefieldDataPdu setMineEmplacementTime(List<MineEmplacementTime> pMineEmplacementTime)
{
    mineEmplacementTime = pMineEmplacementTime;
    return this;
}

public List<MineEmplacementTime> getMineEmplacementTime()
{
    return mineEmplacementTime; 
}

public MinefieldDataPdu setMineEntityNumber(short[] pMineEntityNumber)
{
    mineEntityNumber = pMineEntityNumber;
    return this;
}

public short[] getMineEntityNumber()
{
    return mineEntityNumber; 
}

public MinefieldDataPdu setFusing(List<MinefieldDataFusing> pFusing)
{
    fusing = pFusing;
    return this;
}

public List<MinefieldDataFusing> getFusing()
{
    return fusing; 
}

public MinefieldDataPdu setScalarDetectionCoefficient(byte[] pScalarDetectionCoefficient)
{
    scalarDetectionCoefficient = pScalarDetectionCoefficient;
    return this;
}

public byte[] getScalarDetectionCoefficient()
{
    return scalarDetectionCoefficient; 
}

public MinefieldDataPdu setPaintScheme(List<MinefieldDataPaintScheme> pPaintScheme)
{
    paintScheme = pPaintScheme;
    return this;
}

public List<MinefieldDataPaintScheme> getPaintScheme()
{
    return paintScheme; 
}

public MinefieldDataPdu setNumberOfTripDetonationWires(byte[] pNumberOfTripDetonationWires)
{
    numberOfTripDetonationWires = pNumberOfTripDetonationWires;
    return this;
}

public byte[] getNumberOfTripDetonationWires()
{
    return numberOfTripDetonationWires; 
}

public MinefieldDataPdu setNumberOfVertices(byte[] pNumberOfVertices)
{
    numberOfVertices = pNumberOfVertices;
    return this;
}

public byte[] getNumberOfVertices()
{
    return numberOfVertices; 
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
       minefieldID.marshal(dos);
       requestingEntityID.marshal(dos);
       dos.writeShort( (short)minefieldSequenceNumbeer);
       dos.writeByte( (byte)requestID);
       dos.writeByte( (byte)pduSequenceNumber);
       dos.writeByte( (byte)numberOfPdus);
       dos.writeByte( (byte)paintScheme.size());
       dos.writeByte( (byte)sensorTypes.size());
       dos.writeByte( (byte)padding);
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
            groundBurialDepthOffset[idx] = dis.readFloat(); // mike check
        uPosition += groundBurialDepthOffset.length; // todo, multiply by prim size mike
        for(int idx = 0; idx < waterBurialDepthOffset.length; idx++)
            waterBurialDepthOffset[idx] = dis.readFloat(); // mike check
        uPosition += waterBurialDepthOffset.length; // todo, multiply by prim size mike
        for(int idx = 0; idx < snowBurialDepthOffset.length; idx++)
            snowBurialDepthOffset[idx] = dis.readFloat(); // mike check
        uPosition += snowBurialDepthOffset.length; // todo, multiply by prim size mike
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
            EulerAngles anX = new EulerAngles();
            uPosition += anX.unmarshal(dis);
            mineOrientation.add(anX);
        }

        for(int idx = 0; idx < thermalContrast.length; idx++)
            thermalContrast[idx] = dis.readFloat(); // mike check
        uPosition += thermalContrast.length; // todo, multiply by prim size mike
        for(int idx = 0; idx < reflectance.length; idx++)
            reflectance[idx] = dis.readFloat(); // mike check
        uPosition += reflectance.length; // todo, multiply by prim size mike
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
            MineEmplacementTime anX = new MineEmplacementTime();
            uPosition += anX.unmarshal(dis);
            mineEmplacementTime.add(anX);
        }

        for(int idx = 0; idx < mineEntityNumber.length; idx++)
            mineEntityNumber[idx] = dis.readShort(); // mike check
        uPosition += mineEntityNumber.length; // todo, multiply by prim size mike
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
            MinefieldDataFusing anX = new MinefieldDataFusing();
            uPosition += anX.unmarshal(dis);
            fusing.add(anX);
        }

        for(int idx = 0; idx < scalarDetectionCoefficient.length; idx++)
            scalarDetectionCoefficient[idx] = dis.readByte(); // mike check
        uPosition += scalarDetectionCoefficient.length; // todo, multiply by prim size mike
        for(int idx = 0; idx < numberOfMinesInThisPdu; idx++)
        {
            MinefieldDataPaintScheme anX = new MinefieldDataPaintScheme();
            uPosition += anX.unmarshal(dis);
            paintScheme.add(anX);
        }

        padTo32_2 = new byte[Align.from32bits(uPosition,dis)];
        uPosition += padTo32_2.length;
        for(int idx = 0; idx < numberOfTripDetonationWires.length; idx++)
            numberOfTripDetonationWires[idx] = dis.readByte(); // mike check
        uPosition += numberOfTripDetonationWires.length; // todo, multiply by prim size mike
        padTo32_3 = new byte[Align.from32bits(uPosition,dis)];
        uPosition += padTo32_3.length;
        for(int idx = 0; idx < numberOfVertices.length; idx++)
            numberOfVertices[idx] = dis.readByte(); // mike check
        uPosition += numberOfVertices.length; // todo, multiply by prim size mike
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
   minefieldID.marshal(buff);
   requestingEntityID.marshal(buff);
   buff.putShort( (short)minefieldSequenceNumbeer);
   buff.put( (byte)requestID);
   buff.put( (byte)pduSequenceNumber);
   buff.put( (byte)numberOfPdus);
   buff.put( (byte)paintScheme.size());
   buff.put( (byte)sensorTypes.size());
   buff.put( (byte)padding);
   dataFilter.marshal(buff);
   mineType.marshal(buff);

   for(int idx = 0; idx < sensorTypes.size(); idx++)
   {
        MinefieldSensorType aMinefieldSensorType = (MinefieldSensorType)sensorTypes.get(idx);
        aMinefieldSensorType.marshal(buff);
   }

   padTo32 = new byte[Align.to32bits(buff)];

   for(int idx = 0; idx < mineLocation.size(); idx++)
   {
        Vector3Float aVector3Float = (Vector3Float)mineLocation.get(idx);
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
        EulerAngles aEulerAngles = (EulerAngles)mineOrientation.get(idx);
        aEulerAngles.marshal(buff);
   }


   for(int idx = 0; idx < thermalContrast.length; idx++)
       buff.putFloat((float)thermalContrast[idx]);


   for(int idx = 0; idx < reflectance.length; idx++)
       buff.putFloat((float)reflectance[idx]);


   for(int idx = 0; idx < mineEmplacementTime.size(); idx++)
   {
        MineEmplacementTime aMineEmplacementTime = (MineEmplacementTime)mineEmplacementTime.get(idx);
        aMineEmplacementTime.marshal(buff);
   }


   for(int idx = 0; idx < mineEntityNumber.length; idx++)
       buff.putShort((short)mineEntityNumber[idx]);


   for(int idx = 0; idx < fusing.size(); idx++)
   {
        MinefieldDataFusing aMinefieldDataFusing = (MinefieldDataFusing)fusing.get(idx);
        aMinefieldDataFusing.marshal(buff);
   }


   for(int idx = 0; idx < scalarDetectionCoefficient.length; idx++)
       buff.put((byte)scalarDetectionCoefficient[idx]);


   for(int idx = 0; idx < paintScheme.size(); idx++)
   {
        MinefieldDataPaintScheme aMinefieldDataPaintScheme = (MinefieldDataPaintScheme)paintScheme.get(idx);
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

    if(!(obj instanceof MinefieldDataPdu))
        return false;

     final MinefieldDataPdu rhs = (MinefieldDataPdu)obj;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (minefieldSequenceNumbeer == rhs.minefieldSequenceNumbeer)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (pduSequenceNumber == rhs.pduSequenceNumber)) ivarsEqual = false;
     if( ! (numberOfPdus == rhs.numberOfPdus)) ivarsEqual = false;
     if( ! (numberOfMinesInThisPdu == rhs.numberOfMinesInThisPdu)) ivarsEqual = false;
     if( ! (numberOfSensorTypes == rhs.numberOfSensorTypes)) ivarsEqual = false;
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
} // end of class
