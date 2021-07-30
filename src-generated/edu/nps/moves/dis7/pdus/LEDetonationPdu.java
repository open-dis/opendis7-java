/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 9.4.6 Communicate information associated with the impact or detonation of a munition.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class LEDetonationPdu extends LiveEntityFamilyPdu implements Serializable
{
   /** firingLiveEntityId is an undescribed parameter... */
   protected EntityID  firingLiveEntityId = new EntityID(); 

   /** detonationFlag1 is an undescribed parameter... */
   protected byte  detonationFlag1;

   /** detonationFlag2 is an undescribed parameter... */
   protected byte  detonationFlag2;

   /** targetLiveEntityId is an undescribed parameter... */
   protected EntityID  targetLiveEntityId = new EntityID(); 

   /** munitionLiveEntityId is an undescribed parameter... */
   protected EntityID  munitionLiveEntityId = new EntityID(); 

   /** eventId is an undescribed parameter... */
   protected EventIdentifier  eventId = new EventIdentifier(); 

   /** worldLocation is an undescribed parameter... */
   protected LiveEntityRelativeWorldCoordinates  worldLocation = new LiveEntityRelativeWorldCoordinates(); 

   /** velocity is an undescribed parameter... */
   protected LiveEntityLinearVelocity  velocity = new LiveEntityLinearVelocity(); 

   /** spec error? 16-bit fields vs. 8-bit in TspiPdu? */
   protected LiveEntityOrientation16  munitionOrientation = new LiveEntityOrientation16(); 

   /** munitionDescriptor is an undescribed parameter... */
   protected MunitionDescriptor  munitionDescriptor = new MunitionDescriptor(); 

   /** entityLocation is an undescribed parameter... */
   protected LiveEntityLinearVelocity  entityLocation = new LiveEntityLinearVelocity(); 

   /** detonationResult is an undescribed parameter... */
   protected byte  detonationResult;


/** Constructor */
 public LEDetonationPdu()
 {
    setPduType( DisPduType.LIVE_ENTITY_DETONATION );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += firingLiveEntityId.getMarshalledSize();
   marshalSize += 1;  // detonationFlag1
   marshalSize += 1;  // detonationFlag2
   marshalSize += targetLiveEntityId.getMarshalledSize();
   marshalSize += munitionLiveEntityId.getMarshalledSize();
   marshalSize += eventId.getMarshalledSize();
   marshalSize += worldLocation.getMarshalledSize();
   marshalSize += velocity.getMarshalledSize();
   marshalSize += munitionOrientation.getMarshalledSize();
   marshalSize += munitionDescriptor.getMarshalledSize();
   marshalSize += entityLocation.getMarshalledSize();
   marshalSize += 1;  // detonationResult

   return marshalSize;
}


/** Setter for {@link LEDetonationPdu#firingLiveEntityId}
  * @param pFiringLiveEntityId new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setFiringLiveEntityId(EntityID pFiringLiveEntityId)
{
    firingLiveEntityId = pFiringLiveEntityId;
    return this;
}

/** Getter for {@link LEDetonationPdu#firingLiveEntityId}
  * @return value of interest */
public EntityID getFiringLiveEntityId()
{
    return firingLiveEntityId; 
}

/** Setter for {@link LEDetonationPdu#detonationFlag1}
  * @param pDetonationFlag1 new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setDetonationFlag1(byte pDetonationFlag1)
{
    detonationFlag1 = pDetonationFlag1;
    return this;
}
/** Utility setter for {@link LEDetonationPdu#detonationFlag1}
  * @param pDetonationFlag1 new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setDetonationFlag1(int pDetonationFlag1){
    detonationFlag1 = (byte) pDetonationFlag1;
    return this;
}

/** Getter for {@link LEDetonationPdu#detonationFlag1}
  * @return value of interest */
public byte getDetonationFlag1()
{
    return detonationFlag1; 
}

/** Setter for {@link LEDetonationPdu#detonationFlag2}
  * @param pDetonationFlag2 new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setDetonationFlag2(byte pDetonationFlag2)
{
    detonationFlag2 = pDetonationFlag2;
    return this;
}
/** Utility setter for {@link LEDetonationPdu#detonationFlag2}
  * @param pDetonationFlag2 new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setDetonationFlag2(int pDetonationFlag2){
    detonationFlag2 = (byte) pDetonationFlag2;
    return this;
}

/** Getter for {@link LEDetonationPdu#detonationFlag2}
  * @return value of interest */
public byte getDetonationFlag2()
{
    return detonationFlag2; 
}

/** Setter for {@link LEDetonationPdu#targetLiveEntityId}
  * @param pTargetLiveEntityId new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setTargetLiveEntityId(EntityID pTargetLiveEntityId)
{
    targetLiveEntityId = pTargetLiveEntityId;
    return this;
}

/** Getter for {@link LEDetonationPdu#targetLiveEntityId}
  * @return value of interest */
public EntityID getTargetLiveEntityId()
{
    return targetLiveEntityId; 
}

/** Setter for {@link LEDetonationPdu#munitionLiveEntityId}
  * @param pMunitionLiveEntityId new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setMunitionLiveEntityId(EntityID pMunitionLiveEntityId)
{
    munitionLiveEntityId = pMunitionLiveEntityId;
    return this;
}

/** Getter for {@link LEDetonationPdu#munitionLiveEntityId}
  * @return value of interest */
public EntityID getMunitionLiveEntityId()
{
    return munitionLiveEntityId; 
}

/** Setter for {@link LEDetonationPdu#eventId}
  * @param pEventId new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setEventId(EventIdentifier pEventId)
{
    eventId = pEventId;
    return this;
}

/** Getter for {@link LEDetonationPdu#eventId}
  * @return value of interest */
public EventIdentifier getEventId()
{
    return eventId; 
}

/** Setter for {@link LEDetonationPdu#worldLocation}
  * @param pWorldLocation new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setWorldLocation(LiveEntityRelativeWorldCoordinates pWorldLocation)
{
    worldLocation = pWorldLocation;
    return this;
}

/** Getter for {@link LEDetonationPdu#worldLocation}
  * @return value of interest */
public LiveEntityRelativeWorldCoordinates getWorldLocation()
{
    return worldLocation; 
}

/** Setter for {@link LEDetonationPdu#velocity}
  * @param pVelocity new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setVelocity(LiveEntityLinearVelocity pVelocity)
{
    velocity = pVelocity;
    return this;
}

/** Getter for {@link LEDetonationPdu#velocity}
  * @return value of interest */
public LiveEntityLinearVelocity getVelocity()
{
    return velocity; 
}

/** Setter for {@link LEDetonationPdu#munitionOrientation}
  * @param pMunitionOrientation new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setMunitionOrientation(LiveEntityOrientation16 pMunitionOrientation)
{
    munitionOrientation = pMunitionOrientation;
    return this;
}

/** Getter for {@link LEDetonationPdu#munitionOrientation}
  * @return value of interest */
public LiveEntityOrientation16 getMunitionOrientation()
{
    return munitionOrientation; 
}

/** Setter for {@link LEDetonationPdu#munitionDescriptor}
  * @param pMunitionDescriptor new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setMunitionDescriptor(MunitionDescriptor pMunitionDescriptor)
{
    munitionDescriptor = pMunitionDescriptor;
    return this;
}

/** Getter for {@link LEDetonationPdu#munitionDescriptor}
  * @return value of interest */
public MunitionDescriptor getMunitionDescriptor()
{
    return munitionDescriptor; 
}

/** Setter for {@link LEDetonationPdu#entityLocation}
  * @param pEntityLocation new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setEntityLocation(LiveEntityLinearVelocity pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

/** Getter for {@link LEDetonationPdu#entityLocation}
  * @return value of interest */
public LiveEntityLinearVelocity getEntityLocation()
{
    return entityLocation; 
}

/** Setter for {@link LEDetonationPdu#detonationResult}
  * @param pDetonationResult new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setDetonationResult(byte pDetonationResult)
{
    detonationResult = pDetonationResult;
    return this;
}
/** Utility setter for {@link LEDetonationPdu#detonationResult}
  * @param pDetonationResult new value of interest
  * @return same object to permit progressive setters */
public LEDetonationPdu setDetonationResult(int pDetonationResult){
    detonationResult = (byte) pDetonationResult;
    return this;
}

/** Getter for {@link LEDetonationPdu#detonationResult}
  * @return value of interest */
public byte getDetonationResult()
{
    return detonationResult; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       firingLiveEntityId.marshal(dos);
       dos.writeByte(detonationFlag1);
       dos.writeByte(detonationFlag2);
       targetLiveEntityId.marshal(dos);
       munitionLiveEntityId.marshal(dos);
       eventId.marshal(dos);
       worldLocation.marshal(dos);
       velocity.marshal(dos);
       munitionOrientation.marshal(dos);
       munitionDescriptor.marshal(dos);
       entityLocation.marshal(dos);
       dos.writeByte(detonationResult);
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
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += firingLiveEntityId.unmarshal(dis);
        detonationFlag1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        detonationFlag2 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += targetLiveEntityId.unmarshal(dis);
        uPosition += munitionLiveEntityId.unmarshal(dis);
        uPosition += eventId.unmarshal(dis);
        uPosition += worldLocation.unmarshal(dis);
        uPosition += velocity.unmarshal(dis);
        uPosition += munitionOrientation.unmarshal(dis);
        uPosition += munitionDescriptor.unmarshal(dis);
        uPosition += entityLocation.unmarshal(dis);
        detonationResult = (byte)dis.readUnsignedByte();
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
   super.marshal(byteBuffer);
   firingLiveEntityId.marshal(byteBuffer);
   byteBuffer.put( (byte)detonationFlag1);
   byteBuffer.put( (byte)detonationFlag2);
   targetLiveEntityId.marshal(byteBuffer);
   munitionLiveEntityId.marshal(byteBuffer);
   eventId.marshal(byteBuffer);
   worldLocation.marshal(byteBuffer);
   velocity.marshal(byteBuffer);
   munitionOrientation.marshal(byteBuffer);
   munitionDescriptor.marshal(byteBuffer);
   entityLocation.marshal(byteBuffer);
   byteBuffer.put( (byte)detonationResult);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    firingLiveEntityId.unmarshal(byteBuffer);
    detonationFlag1 = (byte)(byteBuffer.get() & 0xFF);
    detonationFlag2 = (byte)(byteBuffer.get() & 0xFF);
    targetLiveEntityId.unmarshal(byteBuffer);
    munitionLiveEntityId.unmarshal(byteBuffer);
    eventId.unmarshal(byteBuffer);
    worldLocation.unmarshal(byteBuffer);
    velocity.unmarshal(byteBuffer);
    munitionOrientation.unmarshal(byteBuffer);
    munitionDescriptor.unmarshal(byteBuffer);
    entityLocation.unmarshal(byteBuffer);
    detonationResult = (byte)(byteBuffer.get() & 0xFF);
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

     final LEDetonationPdu rhs = (LEDetonationPdu)obj;

     if( ! (firingLiveEntityId.equals( rhs.firingLiveEntityId) )) ivarsEqual = false;
     if( ! (detonationFlag1 == rhs.detonationFlag1)) ivarsEqual = false;
     if( ! (detonationFlag2 == rhs.detonationFlag2)) ivarsEqual = false;
     if( ! (targetLiveEntityId.equals( rhs.targetLiveEntityId) )) ivarsEqual = false;
     if( ! (munitionLiveEntityId.equals( rhs.munitionLiveEntityId) )) ivarsEqual = false;
     if( ! (eventId.equals( rhs.eventId) )) ivarsEqual = false;
     if( ! (worldLocation.equals( rhs.worldLocation) )) ivarsEqual = false;
     if( ! (velocity.equals( rhs.velocity) )) ivarsEqual = false;
     if( ! (munitionOrientation.equals( rhs.munitionOrientation) )) ivarsEqual = false;
     if( ! (munitionDescriptor.equals( rhs.munitionDescriptor) )) ivarsEqual = false;
     if( ! (entityLocation.equals( rhs.entityLocation) )) ivarsEqual = false;
     if( ! (detonationResult == rhs.detonationResult)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" firingLiveEntityId: ").append(firingLiveEntityId).append("\n");
    sb.append(" detonationFlag1: ").append(detonationFlag1).append("\n");
    sb.append(" detonationFlag2: ").append(detonationFlag2).append("\n");
    sb.append(" targetLiveEntityId: ").append(targetLiveEntityId).append("\n");
    sb.append(" munitionLiveEntityId: ").append(munitionLiveEntityId).append("\n");
    sb.append(" eventId: ").append(eventId).append("\n");
    sb.append(" worldLocation: ").append(worldLocation).append("\n");
    sb.append(" velocity: ").append(velocity).append("\n");
    sb.append(" munitionOrientation: ").append(munitionOrientation).append("\n");
    sb.append(" munitionDescriptor: ").append(munitionDescriptor).append("\n");
    sb.append(" entityLocation: ").append(entityLocation).append("\n");
    sb.append(" detonationResult: ").append(detonationResult).append("\n");

   return sb.toString();
 }
} // end of class
