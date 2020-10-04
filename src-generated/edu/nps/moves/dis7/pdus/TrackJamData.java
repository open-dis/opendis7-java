/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  Track-Jam data Section 6.2.89
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class TrackJamData extends Object implements Serializable
{
   /** The entity tracked or illumated, or an emitter beam targeted with jamming */
   protected EntityID  entityID = new EntityID(); 

   /** Emitter system associated with the entity */
   protected byte  emitterNumber;

   /** Beam associated with the entity */
   protected byte  beamNumber;


/** Constructor */
 public TrackJamData()
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

   marshalSize += entityID.getMarshalledSize();
   marshalSize += 1;  // emitterNumber
   marshalSize += 1;  // beamNumber

   return marshalSize;
}


/** Setter for {@link TrackJamData#entityID}
  * @param pEntityID new value of interest
  * @return same object to permit progressive setters */
public TrackJamData setEntityID(EntityID pEntityID)
{
    entityID = pEntityID;
    return this;
}

/** Getter for {@link TrackJamData#entityID}
  * @return value of interest */
public EntityID getEntityID()
{
    return entityID; 
}

/** Setter for {@link TrackJamData#emitterNumber}
  * @param pEmitterNumber new value of interest
  * @return same object to permit progressive setters */
public TrackJamData setEmitterNumber(byte pEmitterNumber)
{
    emitterNumber = pEmitterNumber;
    return this;
}
/** Utility setter for {@link TrackJamData#emitterNumber}
  * @param pEmitterNumber new value of interest
  * @return same object to permit progressive setters */
public TrackJamData setEmitterNumber(int pEmitterNumber){
    emitterNumber = (byte) pEmitterNumber;
    return this;
}

/** Getter for {@link TrackJamData#emitterNumber}
  * @return value of interest */
public byte getEmitterNumber()
{
    return emitterNumber; 
}

/** Setter for {@link TrackJamData#beamNumber}
  * @param pBeamNumber new value of interest
  * @return same object to permit progressive setters */
public TrackJamData setBeamNumber(byte pBeamNumber)
{
    beamNumber = pBeamNumber;
    return this;
}
/** Utility setter for {@link TrackJamData#beamNumber}
  * @param pBeamNumber new value of interest
  * @return same object to permit progressive setters */
public TrackJamData setBeamNumber(int pBeamNumber){
    beamNumber = (byte) pBeamNumber;
    return this;
}

/** Getter for {@link TrackJamData#beamNumber}
  * @return value of interest */
public byte getBeamNumber()
{
    return beamNumber; 
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
       entityID.marshal(dos);
       dos.writeByte(emitterNumber);
       dos.writeByte(beamNumber);
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
        uPosition += entityID.unmarshal(dis);
        emitterNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        beamNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   entityID.marshal(byteBuffer);
   byteBuffer.put( (byte)emitterNumber);
   byteBuffer.put( (byte)beamNumber);
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
    entityID.unmarshal(byteBuffer);
    emitterNumber = (byte)(byteBuffer.get() & 0xFF);
    beamNumber = (byte)(byteBuffer.get() & 0xFF);
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

     final TrackJamData rhs = (TrackJamData)obj;

     if( ! (entityID.equals( rhs.entityID) )) ivarsEqual = false;
     if( ! (emitterNumber == rhs.emitterNumber)) ivarsEqual = false;
     if( ! (beamNumber == rhs.beamNumber)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" entityID: ").append(entityID).append("\n");
    sb.append(" emitterNumber: ").append(emitterNumber).append("\n");
    sb.append(" beamNumber: ").append(beamNumber).append("\n");

   return sb.toString();
 }
} // end of class
