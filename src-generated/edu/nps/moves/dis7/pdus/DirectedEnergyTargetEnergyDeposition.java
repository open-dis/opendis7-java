/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * DE energy depostion properties for a target entity. Section 6.2.20.4
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
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

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += targetEntityID.getMarshalledSize();
   marshalSize += 2;  // padding
   marshalSize += 4;  // peakIrradiance

   return marshalSize;
}


/** Setter for {@link DirectedEnergyTargetEnergyDeposition#targetEntityID}
  * @param pTargetEntityID new value of interest
  * @return same object to permit progressive setters */
public DirectedEnergyTargetEnergyDeposition setTargetEntityID(EntityID pTargetEntityID)
{
    targetEntityID = pTargetEntityID;
    return this;
}

/** Getter for {@link DirectedEnergyTargetEnergyDeposition#targetEntityID}
  * @return value of interest */
public EntityID getTargetEntityID()
{
    return targetEntityID; 
}

/** Setter for {@link DirectedEnergyTargetEnergyDeposition#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public DirectedEnergyTargetEnergyDeposition setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}
/** Utility setter for {@link DirectedEnergyTargetEnergyDeposition#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public DirectedEnergyTargetEnergyDeposition setPadding(int pPadding){
    padding = (short) pPadding;
    return this;
}

/** Getter for {@link DirectedEnergyTargetEnergyDeposition#padding}
  * @return value of interest */
public short getPadding()
{
    return padding; 
}

/** Setter for {@link DirectedEnergyTargetEnergyDeposition#peakIrradiance}
  * @param pPeakIrradiance new value of interest
  * @return same object to permit progressive setters */
public DirectedEnergyTargetEnergyDeposition setPeakIrradiance(float pPeakIrradiance)
{
    peakIrradiance = pPeakIrradiance;
    return this;
}

/** Getter for {@link DirectedEnergyTargetEnergyDeposition#peakIrradiance}
  * @return value of interest */
public float getPeakIrradiance()
{
    return peakIrradiance; 
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
       targetEntityID.marshal(dos);
       dos.writeShort(padding);
       dos.writeFloat(peakIrradiance);
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
   targetEntityID.marshal(byteBuffer);
   byteBuffer.putShort( (short)padding);
   byteBuffer.putFloat( (float)peakIrradiance);
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
    targetEntityID.unmarshal(byteBuffer);
    padding = (short)(byteBuffer.getShort() & 0xFFFF);
    peakIrradiance = byteBuffer.getFloat();
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

     final DirectedEnergyTargetEnergyDeposition rhs = (DirectedEnergyTargetEnergyDeposition)obj;

     if( ! (targetEntityID.equals( rhs.targetEntityID) )) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (peakIrradiance == rhs.peakIrradiance)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" targetEntityID: ").append(targetEntityID).append("\n");
    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" peakIrradiance: ").append(peakIrradiance).append("\n");

   return sb.toString();
 }
} // end of class
