/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * DE energy depostion properties for a target entity. Section 6.2.20.4
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += targetEntityID.getMarshalledSize();
   marshalSize += 2;  // padding
   marshalSize += 4;  // peakIrradiance

   return marshalSize;
}


/** Setter for {@link DirectedEnergyTargetEnergyDeposition#targetEntityID}*/
public DirectedEnergyTargetEnergyDeposition setTargetEntityID(EntityID pTargetEntityID)
{
    targetEntityID = pTargetEntityID;
    return this;
}

/** Getter for {@link DirectedEnergyTargetEnergyDeposition#targetEntityID}*/
public EntityID getTargetEntityID()
{
    return targetEntityID; 
}

/** Setter for {@link DirectedEnergyTargetEnergyDeposition#padding}*/
public DirectedEnergyTargetEnergyDeposition setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link DirectedEnergyTargetEnergyDeposition#padding}*/
public short getPadding()
{
    return padding; 
}

/** Setter for {@link DirectedEnergyTargetEnergyDeposition#peakIrradiance}*/
public DirectedEnergyTargetEnergyDeposition setPeakIrradiance(float pPeakIrradiance)
{
    peakIrradiance = pPeakIrradiance;
    return this;
}

/** Getter for {@link DirectedEnergyTargetEnergyDeposition#peakIrradiance}*/
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
