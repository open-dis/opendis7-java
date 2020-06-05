/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The Blanking Sector attribute record may be used to convey persistent areas within a scan volume where emitter power for a specific active emitter beam is reduced to an insignificant value. Section 6.2.21.2
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class BlankingSector extends Object implements Serializable
{
   protected int  recordType = (int)3500;

   protected short  recordLength = (short)40;

   protected short  padding = (short)0;

   protected byte  emitterNumber;

   protected byte  beamNumber;

   /**  uid 300 */
   protected EEAttributeStateIndicator stateIndicator = EEAttributeStateIndicator.values()[0];

   protected byte  padding2 = (byte)0;

   protected float  leftAzimuth;

   protected float  rightAzimuth;

   protected float  lowerElevation;

   protected float  upperElevation;

   protected float  residualPower;

   protected long  padding3 = (long)0;


/** Constructor */
 public BlankingSector()
 {
 }

/** Returns the size of this serialized object in bytes*/
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
   marshalSize += 4;  // leftAzimuth
   marshalSize += 4;  // rightAzimuth
   marshalSize += 4;  // lowerElevation
   marshalSize += 4;  // upperElevation
   marshalSize += 4;  // residualPower
   marshalSize += 8;  // padding3

   return marshalSize;
}


/** Setter for {@link BlankingSector#recordType}*/
public BlankingSector setRecordType(int pRecordType)
{
    recordType = pRecordType;
    return this;
}

/** Getter for {@link BlankingSector#recordType}*/
public int getRecordType()
{
    return recordType; 
}

/** Setter for {@link BlankingSector#recordLength}*/
public BlankingSector setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}

/** Getter for {@link BlankingSector#recordLength}*/
public short getRecordLength()
{
    return recordLength; 
}

/** Setter for {@link BlankingSector#padding}*/
public BlankingSector setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link BlankingSector#padding}*/
public short getPadding()
{
    return padding; 
}

/** Setter for {@link BlankingSector#emitterNumber}*/
public BlankingSector setEmitterNumber(byte pEmitterNumber)
{
    emitterNumber = pEmitterNumber;
    return this;
}

/** Getter for {@link BlankingSector#emitterNumber}*/
public byte getEmitterNumber()
{
    return emitterNumber; 
}

/** Setter for {@link BlankingSector#beamNumber}*/
public BlankingSector setBeamNumber(byte pBeamNumber)
{
    beamNumber = pBeamNumber;
    return this;
}

/** Getter for {@link BlankingSector#beamNumber}*/
public byte getBeamNumber()
{
    return beamNumber; 
}

/** Setter for {@link BlankingSector#stateIndicator}*/
public BlankingSector setStateIndicator(EEAttributeStateIndicator pStateIndicator)
{
    stateIndicator = pStateIndicator;
    return this;
}

/** Getter for {@link BlankingSector#stateIndicator}*/
public EEAttributeStateIndicator getStateIndicator()
{
    return stateIndicator; 
}

/** Setter for {@link BlankingSector#padding2}*/
public BlankingSector setPadding2(byte pPadding2)
{
    padding2 = pPadding2;
    return this;
}

/** Getter for {@link BlankingSector#padding2}*/
public byte getPadding2()
{
    return padding2; 
}

/** Setter for {@link BlankingSector#leftAzimuth}*/
public BlankingSector setLeftAzimuth(float pLeftAzimuth)
{
    leftAzimuth = pLeftAzimuth;
    return this;
}

/** Getter for {@link BlankingSector#leftAzimuth}*/
public float getLeftAzimuth()
{
    return leftAzimuth; 
}

/** Setter for {@link BlankingSector#rightAzimuth}*/
public BlankingSector setRightAzimuth(float pRightAzimuth)
{
    rightAzimuth = pRightAzimuth;
    return this;
}

/** Getter for {@link BlankingSector#rightAzimuth}*/
public float getRightAzimuth()
{
    return rightAzimuth; 
}

/** Setter for {@link BlankingSector#lowerElevation}*/
public BlankingSector setLowerElevation(float pLowerElevation)
{
    lowerElevation = pLowerElevation;
    return this;
}

/** Getter for {@link BlankingSector#lowerElevation}*/
public float getLowerElevation()
{
    return lowerElevation; 
}

/** Setter for {@link BlankingSector#upperElevation}*/
public BlankingSector setUpperElevation(float pUpperElevation)
{
    upperElevation = pUpperElevation;
    return this;
}

/** Getter for {@link BlankingSector#upperElevation}*/
public float getUpperElevation()
{
    return upperElevation; 
}

/** Setter for {@link BlankingSector#residualPower}*/
public BlankingSector setResidualPower(float pResidualPower)
{
    residualPower = pResidualPower;
    return this;
}

/** Getter for {@link BlankingSector#residualPower}*/
public float getResidualPower()
{
    return residualPower; 
}

/** Setter for {@link BlankingSector#padding3}*/
public BlankingSector setPadding3(long pPadding3)
{
    padding3 = pPadding3;
    return this;
}

/** Getter for {@link BlankingSector#padding3}*/
public long getPadding3()
{
    return padding3; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       dos.writeInt(recordType);
       dos.writeShort(recordLength);
       dos.writeShort(padding);
       dos.writeByte(emitterNumber);
       dos.writeByte(beamNumber);
       stateIndicator.marshal(dos);
       dos.writeByte(padding2);
       dos.writeFloat(leftAzimuth);
       dos.writeFloat(rightAzimuth);
       dos.writeFloat(lowerElevation);
       dos.writeFloat(upperElevation);
       dos.writeFloat(residualPower);
       dos.writeLong(padding3);
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
}

/**
 * Unserializes an object from a DataInputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataInputStream
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
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
        leftAzimuth = dis.readFloat();
        uPosition += 4;
        rightAzimuth = dis.readFloat();
        uPosition += 4;
        lowerElevation = dis.readFloat();
        uPosition += 4;
        upperElevation = dis.readFloat();
        uPosition += 4;
        residualPower = dis.readFloat();
        uPosition += 4;
        padding3 = dis.readLong();
        uPosition += 4;
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
   buff.putInt( (int)recordType);
   buff.putShort( (short)recordLength);
   buff.putShort( (short)padding);
   buff.put( (byte)emitterNumber);
   buff.put( (byte)beamNumber);
   stateIndicator.marshal(buff);
   buff.put( (byte)padding2);
   buff.putFloat( (float)leftAzimuth);
   buff.putFloat( (float)rightAzimuth);
   buff.putFloat( (float)lowerElevation);
   buff.putFloat( (float)upperElevation);
   buff.putFloat( (float)residualPower);
   buff.putLong( (long)padding3);
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
    leftAzimuth = buff.getFloat();
    rightAzimuth = buff.getFloat();
    lowerElevation = buff.getFloat();
    upperElevation = buff.getFloat();
    residualPower = buff.getFloat();
    padding3 = buff.getLong();
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final BlankingSector rhs = (BlankingSector)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (emitterNumber == rhs.emitterNumber)) ivarsEqual = false;
     if( ! (beamNumber == rhs.beamNumber)) ivarsEqual = false;
     if( ! (stateIndicator == rhs.stateIndicator)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (leftAzimuth == rhs.leftAzimuth)) ivarsEqual = false;
     if( ! (rightAzimuth == rhs.rightAzimuth)) ivarsEqual = false;
     if( ! (lowerElevation == rhs.lowerElevation)) ivarsEqual = false;
     if( ! (upperElevation == rhs.upperElevation)) ivarsEqual = false;
     if( ! (residualPower == rhs.residualPower)) ivarsEqual = false;
     if( ! (padding3 == rhs.padding3)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" recordType: ").append(recordType).append("\n");
    sb.append(" recordLength: ").append(recordLength).append("\n");
    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" emitterNumber: ").append(emitterNumber).append("\n");
    sb.append(" beamNumber: ").append(beamNumber).append("\n");
    sb.append(" stateIndicator: ").append(stateIndicator).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");
    sb.append(" leftAzimuth: ").append(leftAzimuth).append("\n");
    sb.append(" rightAzimuth: ").append(rightAzimuth).append("\n");
    sb.append(" lowerElevation: ").append(lowerElevation).append("\n");
    sb.append(" upperElevation: ").append(upperElevation).append("\n");
    sb.append(" residualPower: ").append(residualPower).append("\n");
    sb.append(" padding3: ").append(padding3).append("\n");

   return sb.toString();
 }
} // end of class
