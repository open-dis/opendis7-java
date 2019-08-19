/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
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


public TSPIPdu setLiveEntityId(EntityID pLiveEntityId)
{
    liveEntityId = pLiveEntityId;
    return this;
}

public EntityID getLiveEntityId()
{
    return liveEntityId; 
}

public TSPIPdu setTSPIFlag(byte pTSPIFlag)
{
    TSPIFlag = pTSPIFlag;
    return this;
}

public byte getTSPIFlag()
{
    return TSPIFlag; 
}

public TSPIPdu setEntityLocation(LiveEntityRelativeWorldCoordinates pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

public LiveEntityRelativeWorldCoordinates getEntityLocation()
{
    return entityLocation; 
}

public TSPIPdu setEntityLinearVelocity(LiveEntityLinearVelocity pEntityLinearVelocity)
{
    entityLinearVelocity = pEntityLinearVelocity;
    return this;
}

public LiveEntityLinearVelocity getEntityLinearVelocity()
{
    return entityLinearVelocity; 
}

public TSPIPdu setEntityOrientation(LiveEntityOrientation pEntityOrientation)
{
    entityOrientation = pEntityOrientation;
    return this;
}

public LiveEntityOrientation getEntityOrientation()
{
    return entityOrientation; 
}

public TSPIPdu setPositionError(LiveEntityPositionError pPositionError)
{
    positionError = pPositionError;
    return this;
}

public LiveEntityPositionError getPositionError()
{
    return positionError; 
}

public TSPIPdu setOrientationError(LiveEntityOrientationError pOrientationError)
{
    orientationError = pOrientationError;
    return this;
}

public LiveEntityOrientationError getOrientationError()
{
    return orientationError; 
}

public TSPIPdu setDeadReckoningParameters(LiveDeadReckoningParameters pDeadReckoningParameters)
{
    deadReckoningParameters = pDeadReckoningParameters;
    return this;
}

public LiveDeadReckoningParameters getDeadReckoningParameters()
{
    return deadReckoningParameters; 
}

public TSPIPdu setMeasuredSpeed(short pMeasuredSpeed)
{
    measuredSpeed = pMeasuredSpeed;
    return this;
}

public short getMeasuredSpeed()
{
    return measuredSpeed; 
}

public TSPIPdu setSystemSpecificData(byte[] pSystemSpecificData)
{
    systemSpecificData = pSystemSpecificData;
    return this;
}

public byte[] getSystemSpecificData()
{
    return systemSpecificData; 
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
       liveEntityId.marshal(dos);
       dos.writeByte( (byte)TSPIFlag);
       entityLocation.marshal(dos);
       entityLinearVelocity.marshal(dos);
       entityOrientation.marshal(dos);
       positionError.marshal(dos);
       orientationError.marshal(dos);
       deadReckoningParameters.marshal(dos);
       dos.writeShort( (short)measuredSpeed);
       dos.writeByte( (byte)systemSpecificDataLength);

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
public int unmarshal(DataInputStream dis)
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
            systemSpecificData[idx] = dis.readByte(); // mike check
        uPosition += systemSpecificData.length; // todo, multiply by prim size mike
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
   buff.put( (byte)systemSpecificDataLength);

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

    if(!(obj instanceof TSPIPdu))
        return false;

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
     if( ! (systemSpecificDataLength == rhs.systemSpecificDataLength)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(systemSpecificData[idx] == rhs.systemSpecificData[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
