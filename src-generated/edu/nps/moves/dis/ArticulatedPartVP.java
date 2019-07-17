package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 *  articulated parts for movable parts and a combination of moveable/attached parts of an entity. Section 6.2.94.2
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class ArticulatedPartVP extends Object implements Serializable
{
   /** the identification of the Variable Parameter record. Enumeration from EBV uid 56 */
   protected VariableParameterRecordType recordType = VariableParameterRecordType.ARTICULATED_PART;

   /** indicate the change of any parameter for any articulated part. Starts at zero, incremented for each change  */
   protected byte  changeIndicator = (byte)0;

   /** the identification of the articulated part to which this articulation parameter is attached. This field shall be specified by a 16-bit unsigned integer. This field shall contain the value zero if the articulated part is attached directly to the entity. */
   protected short  partAttachedTo = (short)0;

   /** the type of parameter represented, 32 bit enumeration */
   protected int  parameterType;

   /** The definition of the 64 bits shall be determined based on the type of parameter specified in the Parameter Type field  */
   protected float  parameterValue;

   protected int  padding;


/** Constructor */
 public ArticulatedPartVP()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += recordType.getMarshalledSize();
   marshalSize += 1;  // changeIndicator
   marshalSize += 2;  // partAttachedTo
   marshalSize += 4;  // parameterType
   marshalSize += 4;  // parameterValue
   marshalSize += 4;  // padding

   return marshalSize;
}


public ArticulatedPartVP setRecordType(VariableParameterRecordType pRecordType)
{
    recordType = pRecordType;
    return this;
}

public VariableParameterRecordType getRecordType()
{
    return recordType; 
}

public ArticulatedPartVP setChangeIndicator(byte pChangeIndicator)
{
    changeIndicator = pChangeIndicator;
    return this;
}

public byte getChangeIndicator()
{
    return changeIndicator; 
}

public ArticulatedPartVP setPartAttachedTo(short pPartAttachedTo)
{
    partAttachedTo = pPartAttachedTo;
    return this;
}

public short getPartAttachedTo()
{
    return partAttachedTo; 
}

public ArticulatedPartVP setParameterType(int pParameterType)
{
    parameterType = pParameterType;
    return this;
}

public int getParameterType()
{
    return parameterType; 
}

public ArticulatedPartVP setParameterValue(float pParameterValue)
{
    parameterValue = pParameterValue;
    return this;
}

public float getParameterValue()
{
    return parameterValue; 
}

public ArticulatedPartVP setPadding(int pPadding)
{
    padding = pPadding;
    return this;
}

public int getPadding()
{
    return padding; 
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
       recordType.marshal(dos);
       dos.writeByte( (byte)changeIndicator);
       dos.writeShort( (short)partAttachedTo);
       dos.writeInt( (int)parameterType);
       dos.writeFloat( (float)parameterValue);
       dos.writeInt( (int)padding);
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
        recordType = VariableParameterRecordType.unmarshalEnum(dis);
        uPosition += recordType.getMarshalledSize();
        changeIndicator = (byte)dis.readUnsignedByte();
        uPosition += 1;
        partAttachedTo = (short)dis.readUnsignedShort();
        uPosition += 2;
        parameterType = dis.readInt();
        uPosition += 4;
        parameterValue = dis.readFloat();
        uPosition += 4;
        padding = dis.readInt();
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
   recordType.marshal(buff);
   buff.put( (byte)changeIndicator);
   buff.putShort( (short)partAttachedTo);
   buff.putInt( (int)parameterType);
   buff.putFloat( (float)parameterValue);
   buff.putInt( (int)padding);
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
    recordType = VariableParameterRecordType.unmarshalEnum(buff);
    changeIndicator = (byte)(buff.get() & 0xFF);
    partAttachedTo = (short)(buff.getShort() & 0xFFFF);
    parameterType = buff.getInt();
    parameterValue = buff.getFloat();
    padding = buff.getInt();
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

    if(!(obj instanceof ArticulatedPartVP))
        return false;

     final ArticulatedPartVP rhs = (ArticulatedPartVP)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (changeIndicator == rhs.changeIndicator)) ivarsEqual = false;
     if( ! (partAttachedTo == rhs.partAttachedTo)) ivarsEqual = false;
     if( ! (parameterType == rhs.parameterType)) ivarsEqual = false;
     if( ! (parameterValue == rhs.parameterValue)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
