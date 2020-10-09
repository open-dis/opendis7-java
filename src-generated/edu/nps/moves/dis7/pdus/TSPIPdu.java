/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 9.4.2 The Time Space Position Information (TSPI) PDU shall communicate information about the LE’s state vector.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class TSPIPdu extends LiveEntityFamilyPdu implements Serializable
{
   protected EntityID  liveEntityId = new EntityID(); 

   /** bit field */
   protected byte  TSPIFlag;

   protected LiveEntityRelativeWorldCoordinates  entityLocation = new LiveEntityRelativeWorldCoordinates(); 

   protected LiveEntityLinearVelocity  entityLinearVelocity = new LiveEntityLinearVelocity(); 

   protected LiveEntityOrientation  entityOrientation = new LiveEntityOrientation(); 

   protected LiveEntityPositionError  positionError = new LiveEntityPositionError(); 

   protected LiveEntityOrientationError  orientationError = new LiveEntityOrientationError(); 

   protected LiveDeadReckoningParameters  deadReckoningParameters = new LiveDeadReckoningParameters(); 

   protected short  measuredSpeed;

   protected byte  systemSpecificDataLength;

   protected byte[]  systemSpecificData = new byte[0]; 


/** Constructor */
 public TSPIPdu()
 {
    setPduType( DISPDUType.TIME_SPACE_POSITION_INFORMATION );
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
   marshalSize += liveEntityId.getMarshalledSize();
   marshalSize += 1;  // TSPIFlag
   marshalSize += entityLocation.getMarshalledSize();
   marshalSize += entityLinearVelocity.getMarshalledSize();
   marshalSize += entityOrientation.getMarshalledSize();
   marshalSize += positionError.getMarshalledSize();
   marshalSize += orientationError.getMarshalledSize();
   marshalSize += deadReckoningParameters.getMarshalledSize();
   marshalSize += 2;  // measuredSpeed
   marshalSize += 1;  // systemSpecificDataLength
   marshalSize += systemSpecificData.length * 1;

   return marshalSize;
}


/** Setter for {@link TSPIPdu#liveEntityId}
  * @param pLiveEntityId new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setLiveEntityId(EntityID pLiveEntityId)
{
    liveEntityId = pLiveEntityId;
    return this;
}

/** Getter for {@link TSPIPdu#liveEntityId}
  * @return value of interest */
public EntityID getLiveEntityId()
{
    return liveEntityId; 
}

/** Setter for {@link TSPIPdu#TSPIFlag}
  * @param pTSPIFlag new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setTSPIFlag(byte pTSPIFlag)
{
    TSPIFlag = pTSPIFlag;
    return this;
}
/** Utility setter for {@link TSPIPdu#TSPIFlag}
  * @param pTSPIFlag new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setTSPIFlag(int pTSPIFlag){
    TSPIFlag = (byte) pTSPIFlag;
    return this;
}

/** Getter for {@link TSPIPdu#TSPIFlag}
  * @return value of interest */
public byte getTSPIFlag()
{
    return TSPIFlag; 
}

/** Setter for {@link TSPIPdu#entityLocation}
  * @param pEntityLocation new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setEntityLocation(LiveEntityRelativeWorldCoordinates pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

/** Getter for {@link TSPIPdu#entityLocation}
  * @return value of interest */
public LiveEntityRelativeWorldCoordinates getEntityLocation()
{
    return entityLocation; 
}

/** Setter for {@link TSPIPdu#entityLinearVelocity}
  * @param pEntityLinearVelocity new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setEntityLinearVelocity(LiveEntityLinearVelocity pEntityLinearVelocity)
{
    entityLinearVelocity = pEntityLinearVelocity;
    return this;
}

/** Getter for {@link TSPIPdu#entityLinearVelocity}
  * @return value of interest */
public LiveEntityLinearVelocity getEntityLinearVelocity()
{
    return entityLinearVelocity; 
}

/** Setter for {@link TSPIPdu#entityOrientation}
  * @param pEntityOrientation new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setEntityOrientation(LiveEntityOrientation pEntityOrientation)
{
    entityOrientation = pEntityOrientation;
    return this;
}

/** Getter for {@link TSPIPdu#entityOrientation}
  * @return value of interest */
public LiveEntityOrientation getEntityOrientation()
{
    return entityOrientation; 
}

/** Setter for {@link TSPIPdu#positionError}
  * @param pPositionError new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setPositionError(LiveEntityPositionError pPositionError)
{
    positionError = pPositionError;
    return this;
}

/** Getter for {@link TSPIPdu#positionError}
  * @return value of interest */
public LiveEntityPositionError getPositionError()
{
    return positionError; 
}

/** Setter for {@link TSPIPdu#orientationError}
  * @param pOrientationError new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setOrientationError(LiveEntityOrientationError pOrientationError)
{
    orientationError = pOrientationError;
    return this;
}

/** Getter for {@link TSPIPdu#orientationError}
  * @return value of interest */
public LiveEntityOrientationError getOrientationError()
{
    return orientationError; 
}

/** Setter for {@link TSPIPdu#deadReckoningParameters}
  * @param pDeadReckoningParameters new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setDeadReckoningParameters(LiveDeadReckoningParameters pDeadReckoningParameters)
{
    deadReckoningParameters = pDeadReckoningParameters;
    return this;
}

/** Getter for {@link TSPIPdu#deadReckoningParameters}
  * @return value of interest */
public LiveDeadReckoningParameters getDeadReckoningParameters()
{
    return deadReckoningParameters; 
}

/** Setter for {@link TSPIPdu#measuredSpeed}
  * @param pMeasuredSpeed new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setMeasuredSpeed(short pMeasuredSpeed)
{
    measuredSpeed = pMeasuredSpeed;
    return this;
}
/** Utility setter for {@link TSPIPdu#measuredSpeed}
  * @param pMeasuredSpeed new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setMeasuredSpeed(int pMeasuredSpeed){
    measuredSpeed = (short) pMeasuredSpeed;
    return this;
}

/** Getter for {@link TSPIPdu#measuredSpeed}
  * @return value of interest */
public short getMeasuredSpeed()
{
    return measuredSpeed; 
}

/** Setter for {@link TSPIPdu#systemSpecificData}
  * @param pSystemSpecificData new value of interest
  * @return same object to permit progressive setters */
public TSPIPdu setSystemSpecificData(byte[] pSystemSpecificData)
{
    systemSpecificData = pSystemSpecificData;
    return this;
}

/** Getter for {@link TSPIPdu#systemSpecificData}
  * @return value of interest */
public byte[] getSystemSpecificData()
{
    return systemSpecificData; 
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
       liveEntityId.marshal(dos);
       dos.writeByte(TSPIFlag);
       entityLocation.marshal(dos);
       entityLinearVelocity.marshal(dos);
       entityOrientation.marshal(dos);
       positionError.marshal(dos);
       orientationError.marshal(dos);
       deadReckoningParameters.marshal(dos);
       dos.writeShort(measuredSpeed);
       dos.writeByte(systemSpecificData.length);

       for(int idx = 0; idx < systemSpecificData.length; idx++)
           dos.writeByte(systemSpecificData[idx]);

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
        uPosition += liveEntityId.unmarshal(dis);
        TSPIFlag = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += entityLocation.unmarshal(dis);
        uPosition += entityLinearVelocity.unmarshal(dis);
        uPosition += entityOrientation.unmarshal(dis);
        uPosition += positionError.unmarshal(dis);
        uPosition += orientationError.unmarshal(dis);
        uPosition += deadReckoningParameters.unmarshal(dis);
        measuredSpeed = (short)dis.readUnsignedShort();
        uPosition += 2;
        systemSpecificDataLength = (byte)dis.readUnsignedByte();
        uPosition += 1;
        for(int idx = 0; idx < systemSpecificData.length; idx++)
            systemSpecificData[idx] = dis.readByte();
        uPosition += (systemSpecificData.length * 1);
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
   liveEntityId.marshal(byteBuffer);
   byteBuffer.put( (byte)TSPIFlag);
   entityLocation.marshal(byteBuffer);
   entityLinearVelocity.marshal(byteBuffer);
   entityOrientation.marshal(byteBuffer);
   positionError.marshal(byteBuffer);
   orientationError.marshal(byteBuffer);
   deadReckoningParameters.marshal(byteBuffer);
   byteBuffer.putShort( (short)measuredSpeed);
   byteBuffer.put( (byte)systemSpecificData.length);

   for(int idx = 0; idx < systemSpecificData.length; idx++)
       byteBuffer.put((byte)systemSpecificData[idx]);

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

    liveEntityId.unmarshal(byteBuffer);
    TSPIFlag = (byte)(byteBuffer.get() & 0xFF);
    entityLocation.unmarshal(byteBuffer);
    entityLinearVelocity.unmarshal(byteBuffer);
    entityOrientation.unmarshal(byteBuffer);
    positionError.unmarshal(byteBuffer);
    orientationError.unmarshal(byteBuffer);
    deadReckoningParameters.unmarshal(byteBuffer);
    measuredSpeed = (short)(byteBuffer.getShort() & 0xFFFF);
    systemSpecificDataLength = (byte)(byteBuffer.get() & 0xFF);
    for(int idx = 0; idx < systemSpecificData.length; idx++)
        systemSpecificData[idx] = byteBuffer.get();
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

     final TSPIPdu rhs = (TSPIPdu)obj;

     if( ! (liveEntityId.equals( rhs.liveEntityId) )) ivarsEqual = false;
     if( ! (TSPIFlag == rhs.TSPIFlag)) ivarsEqual = false;
     if( ! (entityLocation.equals( rhs.entityLocation) )) ivarsEqual = false;
     if( ! (entityLinearVelocity.equals( rhs.entityLinearVelocity) )) ivarsEqual = false;
     if( ! (entityOrientation.equals( rhs.entityOrientation) )) ivarsEqual = false;
     if( ! (positionError.equals( rhs.positionError) )) ivarsEqual = false;
     if( ! (orientationError.equals( rhs.orientationError) )) ivarsEqual = false;
     if( ! (deadReckoningParameters.equals( rhs.deadReckoningParameters) )) ivarsEqual = false;
     if( ! (measuredSpeed == rhs.measuredSpeed)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(systemSpecificData[idx] == rhs.systemSpecificData[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" liveEntityId: ").append(liveEntityId).append("\n");
    sb.append(" TSPIFlag: ").append(TSPIFlag).append("\n");
    sb.append(" entityLocation: ").append(entityLocation).append("\n");
    sb.append(" entityLinearVelocity: ").append(entityLinearVelocity).append("\n");
    sb.append(" entityOrientation: ").append(entityOrientation).append("\n");
    sb.append(" positionError: ").append(positionError).append("\n");
    sb.append(" orientationError: ").append(orientationError).append("\n");
    sb.append(" deadReckoningParameters: ").append(deadReckoningParameters).append("\n");
    sb.append(" measuredSpeed: ").append(measuredSpeed).append("\n");
    sb.append(" systemSpecificData: ").append("\n");
    sb.append(Arrays.toString(systemSpecificData)).append("\n");

   return sb.toString();
 }
} // end of class
