/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * The False Targets attribute record shall be used to communicate discrete values that are associated with false targets jamming that cannot be referenced to an emitter mode. The values provided in the False Targets attri- bute record shall be considered valid only for the victim radar beams listed in the jamming beam's Track/Jam Data records (provided in the associated Electromagnetic Emission PDU). Section 6.2.21.3
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class FalseTargetsAttribute extends Object implements Serializable
{
   protected int  recordType = (int)3502;

   protected short  recordLength = (short)40;

   protected short  padding = (short)0;

   protected byte  emitterNumber;

   protected byte  beamNumber;

   /**  uid 300 */
   protected EEAttributeStateIndicator stateIndicator = EEAttributeStateIndicator.values()[0];

   protected byte  padding2 = (byte)0;

   protected short  padding3 = (short)0;

   protected short  falseTargetCount;

   protected float  walkSpeed;

   protected float  walkAcceleration;

   protected float  maximumWalkDistance;

   protected float  keepTime;

   protected float  echoSpacing;

   protected float  firstTargetOffset;


/** Constructor */
 public FalseTargetsAttribute()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // recordType
   marshalSize += 2;  // recordLength
   marshalSize += 2;  // padding
   marshalSize += 1;  // emitterNumber
   marshalSize += 1;  // beamNumber
   marshalSize += stateIndicator.getMarshalledSize();
   marshalSize += 1;  // padding2
   marshalSize += 2;  // padding3
   marshalSize += 2;  // falseTargetCount
   marshalSize += 4;  // walkSpeed
   marshalSize += 4;  // walkAcceleration
   marshalSize += 4;  // maximumWalkDistance
   marshalSize += 4;  // keepTime
   marshalSize += 4;  // echoSpacing
   marshalSize += 4;  // firstTargetOffset

   return marshalSize;
}


public FalseTargetsAttribute setRecordType(int pRecordType)
{
    recordType = pRecordType;
    return this;
}

public int getRecordType()
{
    return recordType; 
}

public FalseTargetsAttribute setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}

public short getRecordLength()
{
    return recordLength; 
}

public FalseTargetsAttribute setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

public short getPadding()
{
    return padding; 
}

public FalseTargetsAttribute setEmitterNumber(byte pEmitterNumber)
{
    emitterNumber = pEmitterNumber;
    return this;
}

public byte getEmitterNumber()
{
    return emitterNumber; 
}

public FalseTargetsAttribute setBeamNumber(byte pBeamNumber)
{
    beamNumber = pBeamNumber;
    return this;
}

public byte getBeamNumber()
{
    return beamNumber; 
}

public FalseTargetsAttribute setStateIndicator(EEAttributeStateIndicator pStateIndicator)
{
    stateIndicator = pStateIndicator;
    return this;
}

public EEAttributeStateIndicator getStateIndicator()
{
    return stateIndicator; 
}

public FalseTargetsAttribute setPadding2(byte pPadding2)
{
    padding2 = pPadding2;
    return this;
}

public byte getPadding2()
{
    return padding2; 
}

public FalseTargetsAttribute setPadding3(short pPadding3)
{
    padding3 = pPadding3;
    return this;
}

public short getPadding3()
{
    return padding3; 
}

public FalseTargetsAttribute setFalseTargetCount(short pFalseTargetCount)
{
    falseTargetCount = pFalseTargetCount;
    return this;
}

public short getFalseTargetCount()
{
    return falseTargetCount; 
}

public FalseTargetsAttribute setWalkSpeed(float pWalkSpeed)
{
    walkSpeed = pWalkSpeed;
    return this;
}

public float getWalkSpeed()
{
    return walkSpeed; 
}

public FalseTargetsAttribute setWalkAcceleration(float pWalkAcceleration)
{
    walkAcceleration = pWalkAcceleration;
    return this;
}

public float getWalkAcceleration()
{
    return walkAcceleration; 
}

public FalseTargetsAttribute setMaximumWalkDistance(float pMaximumWalkDistance)
{
    maximumWalkDistance = pMaximumWalkDistance;
    return this;
}

public float getMaximumWalkDistance()
{
    return maximumWalkDistance; 
}

public FalseTargetsAttribute setKeepTime(float pKeepTime)
{
    keepTime = pKeepTime;
    return this;
}

public float getKeepTime()
{
    return keepTime; 
}

public FalseTargetsAttribute setEchoSpacing(float pEchoSpacing)
{
    echoSpacing = pEchoSpacing;
    return this;
}

public float getEchoSpacing()
{
    return echoSpacing; 
}

public FalseTargetsAttribute setFirstTargetOffset(float pFirstTargetOffset)
{
    firstTargetOffset = pFirstTargetOffset;
    return this;
}

public float getFirstTargetOffset()
{
    return firstTargetOffset; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    try 
    {
       dos.writeInt( (int)recordType);
       dos.writeShort( (short)recordLength);
       dos.writeShort( (short)padding);
       dos.writeByte( (byte)emitterNumber);
       dos.writeByte( (byte)beamNumber);
       stateIndicator.marshal(dos);
       dos.writeByte( (byte)padding2);
       dos.writeShort( (short)padding3);
       dos.writeShort( (short)falseTargetCount);
       dos.writeFloat( (float)walkSpeed);
       dos.writeFloat( (float)walkAcceleration);
       dos.writeFloat( (float)maximumWalkDistance);
       dos.writeFloat( (float)keepTime);
       dos.writeFloat( (float)echoSpacing);
       dos.writeFloat( (float)firstTargetOffset);
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
    try 
    {
        recordType = dis.readInt();
        uPosition += 4;
        recordLength = (short)dis.readUnsignedShort();
        uPosition += 2;
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
        emitterNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        beamNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        stateIndicator = EEAttributeStateIndicator.unmarshalEnum(dis);
        uPosition += stateIndicator.getMarshalledSize();
        padding2 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding3 = (short)dis.readUnsignedShort();
        uPosition += 2;
        falseTargetCount = (short)dis.readUnsignedShort();
        uPosition += 2;
        walkSpeed = dis.readFloat();
        uPosition += 4;
        walkAcceleration = dis.readFloat();
        uPosition += 4;
        maximumWalkDistance = dis.readFloat();
        uPosition += 4;
        keepTime = dis.readFloat();
        uPosition += 4;
        echoSpacing = dis.readFloat();
        uPosition += 4;
        firstTargetOffset = dis.readFloat();
        uPosition += 4;
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
   buff.putInt( (int)recordType);
   buff.putShort( (short)recordLength);
   buff.putShort( (short)padding);
   buff.put( (byte)emitterNumber);
   buff.put( (byte)beamNumber);
   stateIndicator.marshal(buff);
   buff.put( (byte)padding2);
   buff.putShort( (short)padding3);
   buff.putShort( (short)falseTargetCount);
   buff.putFloat( (float)walkSpeed);
   buff.putFloat( (float)walkAcceleration);
   buff.putFloat( (float)maximumWalkDistance);
   buff.putFloat( (float)keepTime);
   buff.putFloat( (float)echoSpacing);
   buff.putFloat( (float)firstTargetOffset);
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
    recordType = buff.getInt();
    recordLength = (short)(buff.getShort() & 0xFFFF);
    padding = (short)(buff.getShort() & 0xFFFF);
    emitterNumber = (byte)(buff.get() & 0xFF);
    beamNumber = (byte)(buff.get() & 0xFF);
    stateIndicator = EEAttributeStateIndicator.unmarshalEnum(buff);
    padding2 = (byte)(buff.get() & 0xFF);
    padding3 = (short)(buff.getShort() & 0xFFFF);
    falseTargetCount = (short)(buff.getShort() & 0xFFFF);
    walkSpeed = buff.getFloat();
    walkAcceleration = buff.getFloat();
    maximumWalkDistance = buff.getFloat();
    keepTime = buff.getFloat();
    echoSpacing = buff.getFloat();
    firstTargetOffset = buff.getFloat();
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof FalseTargetsAttribute))
        return false;

     final FalseTargetsAttribute rhs = (FalseTargetsAttribute)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (emitterNumber == rhs.emitterNumber)) ivarsEqual = false;
     if( ! (beamNumber == rhs.beamNumber)) ivarsEqual = false;
     if( ! (stateIndicator == rhs.stateIndicator)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (padding3 == rhs.padding3)) ivarsEqual = false;
     if( ! (falseTargetCount == rhs.falseTargetCount)) ivarsEqual = false;
     if( ! (walkSpeed == rhs.walkSpeed)) ivarsEqual = false;
     if( ! (walkAcceleration == rhs.walkAcceleration)) ivarsEqual = false;
     if( ! (maximumWalkDistance == rhs.maximumWalkDistance)) ivarsEqual = false;
     if( ! (keepTime == rhs.keepTime)) ivarsEqual = false;
     if( ! (echoSpacing == rhs.echoSpacing)) ivarsEqual = false;
     if( ! (firstTargetOffset == rhs.firstTargetOffset)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
