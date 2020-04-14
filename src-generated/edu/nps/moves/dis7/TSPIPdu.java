/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 9.4.2 The Time Space Position Information (TSPI) PDU shall communicate information about the LE’s state vector.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link TSPIPdu#liveEntityId}*/
public TSPIPdu setLiveEntityId(EntityID pLiveEntityId)
{
    liveEntityId = pLiveEntityId;
    return this;
}

/** Getter for {@link TSPIPdu#liveEntityId}*/
public EntityID getLiveEntityId()
{
    return liveEntityId; 
}

/** Setter for {@link TSPIPdu#TSPIFlag}*/
public TSPIPdu setTSPIFlag(byte pTSPIFlag)
{
    TSPIFlag = pTSPIFlag;
    return this;
}

/** Getter for {@link TSPIPdu#TSPIFlag}*/
public byte getTSPIFlag()
{
    return TSPIFlag; 
}

/** Setter for {@link TSPIPdu#entityLocation}*/
public TSPIPdu setEntityLocation(LiveEntityRelativeWorldCoordinates pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

/** Getter for {@link TSPIPdu#entityLocation}*/
public LiveEntityRelativeWorldCoordinates getEntityLocation()
{
    return entityLocation; 
}

/** Setter for {@link TSPIPdu#entityLinearVelocity}*/
public TSPIPdu setEntityLinearVelocity(LiveEntityLinearVelocity pEntityLinearVelocity)
{
    entityLinearVelocity = pEntityLinearVelocity;
    return this;
}

/** Getter for {@link TSPIPdu#entityLinearVelocity}*/
public LiveEntityLinearVelocity getEntityLinearVelocity()
{
    return entityLinearVelocity; 
}

/** Setter for {@link TSPIPdu#entityOrientation}*/
public TSPIPdu setEntityOrientation(LiveEntityOrientation pEntityOrientation)
{
    entityOrientation = pEntityOrientation;
    return this;
}

/** Getter for {@link TSPIPdu#entityOrientation}*/
public LiveEntityOrientation getEntityOrientation()
{
    return entityOrientation; 
}

/** Setter for {@link TSPIPdu#positionError}*/
public TSPIPdu setPositionError(LiveEntityPositionError pPositionError)
{
    positionError = pPositionError;
    return this;
}

/** Getter for {@link TSPIPdu#positionError}*/
public LiveEntityPositionError getPositionError()
{
    return positionError; 
}

/** Setter for {@link TSPIPdu#orientationError}*/
public TSPIPdu setOrientationError(LiveEntityOrientationError pOrientationError)
{
    orientationError = pOrientationError;
    return this;
}

/** Getter for {@link TSPIPdu#orientationError}*/
public LiveEntityOrientationError getOrientationError()
{
    return orientationError; 
}

/** Setter for {@link TSPIPdu#deadReckoningParameters}*/
public TSPIPdu setDeadReckoningParameters(LiveDeadReckoningParameters pDeadReckoningParameters)
{
    deadReckoningParameters = pDeadReckoningParameters;
    return this;
}

/** Getter for {@link TSPIPdu#deadReckoningParameters}*/
public LiveDeadReckoningParameters getDeadReckoningParameters()
{
    return deadReckoningParameters; 
}

/** Setter for {@link TSPIPdu#measuredSpeed}*/
public TSPIPdu setMeasuredSpeed(short pMeasuredSpeed)
{
    measuredSpeed = pMeasuredSpeed;
    return this;
}

/** Getter for {@link TSPIPdu#measuredSpeed}*/
public short getMeasuredSpeed()
{
    return measuredSpeed; 
}

/** Setter for {@link TSPIPdu#systemSpecificData}*/
public TSPIPdu setSystemSpecificData(byte[] pSystemSpecificData)
{
    systemSpecificData = pSystemSpecificData;
    return this;
}

/** Getter for {@link TSPIPdu#systemSpecificData}*/
public byte[] getSystemSpecificData()
{
    return systemSpecificData; 
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
       liveEntityId.marshal(dos);
       dos.writeByte( (byte)TSPIFlag);
       entityLocation.marshal(dos);
       entityLinearVelocity.marshal(dos);
       entityOrientation.marshal(dos);
       positionError.marshal(dos);
       orientationError.marshal(dos);
       deadReckoningParameters.marshal(dos);
       dos.writeShort( (short)measuredSpeed);
       dos.writeByte( (byte)systemSpecificData.length);

       for(int idx = 0; idx < systemSpecificData.length; idx++)
           dos.writeByte(systemSpecificData[idx]);

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
   liveEntityId.marshal(buff);
   buff.put( (byte)TSPIFlag);
   entityLocation.marshal(buff);
   entityLinearVelocity.marshal(buff);
   entityOrientation.marshal(buff);
   positionError.marshal(buff);
   orientationError.marshal(buff);
   deadReckoningParameters.marshal(buff);
   buff.putShort( (short)measuredSpeed);
   buff.put( (byte)systemSpecificData.length);

   for(int idx = 0; idx < systemSpecificData.length; idx++)
       buff.put((byte)systemSpecificData[idx]);

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

    liveEntityId.unmarshal(buff);
    TSPIFlag = (byte)(buff.get() & 0xFF);
    entityLocation.unmarshal(buff);
    entityLinearVelocity.unmarshal(buff);
    entityOrientation.unmarshal(buff);
    positionError.unmarshal(buff);
    orientationError.unmarshal(buff);
    deadReckoningParameters.unmarshal(buff);
    measuredSpeed = (short)(buff.getShort() & 0xFFFF);
    systemSpecificDataLength = (byte)(buff.get() & 0xFF);
    for(int idx = 0; idx < systemSpecificData.length; idx++)
        systemSpecificData[idx] = buff.get();
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
    sb.append(getClass().getSimpleName()+":\n");

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
