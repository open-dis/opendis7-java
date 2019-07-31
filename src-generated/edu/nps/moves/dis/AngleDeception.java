/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * The Angle Deception attribute record may be used to communicate discrete values that are associated with angle deception jamming that cannot be referenced to an emitter mode. The values provided in the record records (provided in the associated Electromagnetic Emission PDU). (The victim radar beams are those that are targeted by the jammer.) Section 6.2.21.2.2
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class AngleDeception extends Object implements Serializable
{
   protected int  recordType = (int)3501;

   protected short  recordLength = (short)48;

   protected short  padding = (short)0;

   protected byte  emitterNumber;

   protected byte  beamNumber;

   /**  uid 300 */
   protected EEAttributeStateIndicator stateIndicator = EEAttributeStateIndicator.values()[0];

   protected byte  padding2 = (byte)0;

   protected float  azimuthOffset;

   protected float  azimuthWidth;

   protected float  azimuthPullRate;

   protected float  azimuthPullAcceleration;

   protected float  elevationOffset;

   protected float  elevationWidth;

   protected float  elevationPullRate;

   protected float  elevationPullAcceleration;

   protected int  padding3 = (int)0;


/** Constructor */
 public AngleDeception()
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
   marshalSize += 4;  // azimuthOffset
   marshalSize += 4;  // azimuthWidth
   marshalSize += 4;  // azimuthPullRate
   marshalSize += 4;  // azimuthPullAcceleration
   marshalSize += 4;  // elevationOffset
   marshalSize += 4;  // elevationWidth
   marshalSize += 4;  // elevationPullRate
   marshalSize += 4;  // elevationPullAcceleration
   marshalSize += 4;  // padding3

   return marshalSize;
}


public AngleDeception setRecordType(int pRecordType)
{
    recordType = pRecordType;
    return this;
}

public int getRecordType()
{
    return recordType; 
}

public AngleDeception setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}

public short getRecordLength()
{
    return recordLength; 
}

public AngleDeception setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

public short getPadding()
{
    return padding; 
}

public AngleDeception setEmitterNumber(byte pEmitterNumber)
{
    emitterNumber = pEmitterNumber;
    return this;
}

public byte getEmitterNumber()
{
    return emitterNumber; 
}

public AngleDeception setBeamNumber(byte pBeamNumber)
{
    beamNumber = pBeamNumber;
    return this;
}

public byte getBeamNumber()
{
    return beamNumber; 
}

public AngleDeception setStateIndicator(EEAttributeStateIndicator pStateIndicator)
{
    stateIndicator = pStateIndicator;
    return this;
}

public EEAttributeStateIndicator getStateIndicator()
{
    return stateIndicator; 
}

public AngleDeception setPadding2(byte pPadding2)
{
    padding2 = pPadding2;
    return this;
}

public byte getPadding2()
{
    return padding2; 
}

public AngleDeception setAzimuthOffset(float pAzimuthOffset)
{
    azimuthOffset = pAzimuthOffset;
    return this;
}

public float getAzimuthOffset()
{
    return azimuthOffset; 
}

public AngleDeception setAzimuthWidth(float pAzimuthWidth)
{
    azimuthWidth = pAzimuthWidth;
    return this;
}

public float getAzimuthWidth()
{
    return azimuthWidth; 
}

public AngleDeception setAzimuthPullRate(float pAzimuthPullRate)
{
    azimuthPullRate = pAzimuthPullRate;
    return this;
}

public float getAzimuthPullRate()
{
    return azimuthPullRate; 
}

public AngleDeception setAzimuthPullAcceleration(float pAzimuthPullAcceleration)
{
    azimuthPullAcceleration = pAzimuthPullAcceleration;
    return this;
}

public float getAzimuthPullAcceleration()
{
    return azimuthPullAcceleration; 
}

public AngleDeception setElevationOffset(float pElevationOffset)
{
    elevationOffset = pElevationOffset;
    return this;
}

public float getElevationOffset()
{
    return elevationOffset; 
}

public AngleDeception setElevationWidth(float pElevationWidth)
{
    elevationWidth = pElevationWidth;
    return this;
}

public float getElevationWidth()
{
    return elevationWidth; 
}

public AngleDeception setElevationPullRate(float pElevationPullRate)
{
    elevationPullRate = pElevationPullRate;
    return this;
}

public float getElevationPullRate()
{
    return elevationPullRate; 
}

public AngleDeception setElevationPullAcceleration(float pElevationPullAcceleration)
{
    elevationPullAcceleration = pElevationPullAcceleration;
    return this;
}

public float getElevationPullAcceleration()
{
    return elevationPullAcceleration; 
}

public AngleDeception setPadding3(int pPadding3)
{
    padding3 = pPadding3;
    return this;
}

public int getPadding3()
{
    return padding3; 
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
       dos.writeFloat( (float)azimuthOffset);
       dos.writeFloat( (float)azimuthWidth);
       dos.writeFloat( (float)azimuthPullRate);
       dos.writeFloat( (float)azimuthPullAcceleration);
       dos.writeFloat( (float)elevationOffset);
       dos.writeFloat( (float)elevationWidth);
       dos.writeFloat( (float)elevationPullRate);
       dos.writeFloat( (float)elevationPullAcceleration);
       dos.writeInt( (int)padding3);
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
        azimuthOffset = dis.readFloat();
        uPosition += 4;
        azimuthWidth = dis.readFloat();
        uPosition += 4;
        azimuthPullRate = dis.readFloat();
        uPosition += 4;
        azimuthPullAcceleration = dis.readFloat();
        uPosition += 4;
        elevationOffset = dis.readFloat();
        uPosition += 4;
        elevationWidth = dis.readFloat();
        uPosition += 4;
        elevationPullRate = dis.readFloat();
        uPosition += 4;
        elevationPullAcceleration = dis.readFloat();
        uPosition += 4;
        padding3 = dis.readInt();
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
   buff.putFloat( (float)azimuthOffset);
   buff.putFloat( (float)azimuthWidth);
   buff.putFloat( (float)azimuthPullRate);
   buff.putFloat( (float)azimuthPullAcceleration);
   buff.putFloat( (float)elevationOffset);
   buff.putFloat( (float)elevationWidth);
   buff.putFloat( (float)elevationPullRate);
   buff.putFloat( (float)elevationPullAcceleration);
   buff.putInt( (int)padding3);
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
    azimuthOffset = buff.getFloat();
    azimuthWidth = buff.getFloat();
    azimuthPullRate = buff.getFloat();
    azimuthPullAcceleration = buff.getFloat();
    elevationOffset = buff.getFloat();
    elevationWidth = buff.getFloat();
    elevationPullRate = buff.getFloat();
    elevationPullAcceleration = buff.getFloat();
    padding3 = buff.getInt();
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

    if(!(obj instanceof AngleDeception))
        return false;

     final AngleDeception rhs = (AngleDeception)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (emitterNumber == rhs.emitterNumber)) ivarsEqual = false;
     if( ! (beamNumber == rhs.beamNumber)) ivarsEqual = false;
     if( ! (stateIndicator == rhs.stateIndicator)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (azimuthOffset == rhs.azimuthOffset)) ivarsEqual = false;
     if( ! (azimuthWidth == rhs.azimuthWidth)) ivarsEqual = false;
     if( ! (azimuthPullRate == rhs.azimuthPullRate)) ivarsEqual = false;
     if( ! (azimuthPullAcceleration == rhs.azimuthPullAcceleration)) ivarsEqual = false;
     if( ! (elevationOffset == rhs.elevationOffset)) ivarsEqual = false;
     if( ! (elevationWidth == rhs.elevationWidth)) ivarsEqual = false;
     if( ! (elevationPullRate == rhs.elevationPullRate)) ivarsEqual = false;
     if( ! (elevationPullAcceleration == rhs.elevationPullAcceleration)) ivarsEqual = false;
     if( ! (padding3 == rhs.padding3)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
