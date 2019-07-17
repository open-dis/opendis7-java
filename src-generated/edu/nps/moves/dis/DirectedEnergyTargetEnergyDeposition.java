package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * DE energy depostion properties for a target entity. Section 6.2.20.4
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class DirectedEnergyTargetEnergyDeposition extends Object implements Serializable
{
   /** Unique ID of the target entity. */
   protected EntityID  targetEntityID = new EntityID(); 

   /** padding */
   protected short  padding = (short)0;

   /** Peak irradiance */
   protected float  peakIrradiance;


/** Constructor */
 public DirectedEnergyTargetEnergyDeposition()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += targetEntityID.getMarshalledSize();
   marshalSize += 2;  // padding
   marshalSize += 4;  // peakIrradiance

   return marshalSize;
}


public DirectedEnergyTargetEnergyDeposition setTargetEntityID(EntityID pTargetEntityID)
{
    targetEntityID = pTargetEntityID;
    return this;
}

public EntityID getTargetEntityID()
{
    return targetEntityID; 
}

public DirectedEnergyTargetEnergyDeposition setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

public short getPadding()
{
    return padding; 
}

public DirectedEnergyTargetEnergyDeposition setPeakIrradiance(float pPeakIrradiance)
{
    peakIrradiance = pPeakIrradiance;
    return this;
}

public float getPeakIrradiance()
{
    return peakIrradiance; 
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
       targetEntityID.marshal(dos);
       dos.writeShort( (short)padding);
       dos.writeFloat( (float)peakIrradiance);
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
        uPosition += targetEntityID.unmarshal(dis);
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
        peakIrradiance = dis.readFloat();
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
   targetEntityID.marshal(buff);
   buff.putShort( (short)padding);
   buff.putFloat( (float)peakIrradiance);
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
    targetEntityID.unmarshal(buff);
    padding = (short)(buff.getShort() & 0xFFFF);
    peakIrradiance = buff.getFloat();
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

    if(!(obj instanceof DirectedEnergyTargetEnergyDeposition))
        return false;

     final DirectedEnergyTargetEnergyDeposition rhs = (DirectedEnergyTargetEnergyDeposition)obj;

     if( ! (targetEntityID.equals( rhs.targetEntityID) )) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (peakIrradiance == rhs.peakIrradiance)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
