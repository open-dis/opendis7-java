/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 9.4.6 Communicate information associated with the impact or detonation of a munition.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class LEDetonationPdu extends LiveEntityFamilyPdu implements Serializable
{
   protected EntityID  firingLiveEntityId = new EntityID(); 

   protected byte  detonationFlag1;

   protected byte  detonationFlag2;

   protected EntityID  targetLiveEntityId = new EntityID(); 

   protected EntityID  munitionLiveEntityId = new EntityID(); 

   protected EventIdentifier  eventId = new EventIdentifier(); 

   protected LiveEntityRelativeWorldCoordinates  worldLocation = new LiveEntityRelativeWorldCoordinates(); 

   protected LiveEntityLinearVelocity  velocity = new LiveEntityLinearVelocity(); 

   /** spec error? 16-bit fields vs. 8-bit in TspiPdu? */
   protected LiveEntityOrientation16  munitionOrientation = new LiveEntityOrientation16(); 

   protected MunitionDescriptor  munitionDescriptor = new MunitionDescriptor(); 

   protected LiveEntityLinearVelocity  entityLocation = new LiveEntityLinearVelocity(); 

   protected byte  detonationResult;


/** Constructor */
 public LEDetonationPdu()
 {
    setPduType( DISPDUType.LIVE_ENTITY_DETONATION );
 }

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link LEDetonationPdu#firingLiveEntityId}*/
public LEDetonationPdu setFiringLiveEntityId(EntityID pFiringLiveEntityId)
{
    firingLiveEntityId = pFiringLiveEntityId;
    return this;
}

/** Getter for {@link LEDetonationPdu#firingLiveEntityId}*/
public EntityID getFiringLiveEntityId()
{
    return firingLiveEntityId; 
}

/** Setter for {@link LEDetonationPdu#detonationFlag1}*/
public LEDetonationPdu setDetonationFlag1(byte pDetonationFlag1)
{
    detonationFlag1 = pDetonationFlag1;
    return this;
}

/** Getter for {@link LEDetonationPdu#detonationFlag1}*/
public byte getDetonationFlag1()
{
    return detonationFlag1; 
}

/** Setter for {@link LEDetonationPdu#detonationFlag2}*/
public LEDetonationPdu setDetonationFlag2(byte pDetonationFlag2)
{
    detonationFlag2 = pDetonationFlag2;
    return this;
}

/** Getter for {@link LEDetonationPdu#detonationFlag2}*/
public byte getDetonationFlag2()
{
    return detonationFlag2; 
}

/** Setter for {@link LEDetonationPdu#targetLiveEntityId}*/
public LEDetonationPdu setTargetLiveEntityId(EntityID pTargetLiveEntityId)
{
    targetLiveEntityId = pTargetLiveEntityId;
    return this;
}

/** Getter for {@link LEDetonationPdu#targetLiveEntityId}*/
public EntityID getTargetLiveEntityId()
{
    return targetLiveEntityId; 
}

/** Setter for {@link LEDetonationPdu#munitionLiveEntityId}*/
public LEDetonationPdu setMunitionLiveEntityId(EntityID pMunitionLiveEntityId)
{
    munitionLiveEntityId = pMunitionLiveEntityId;
    return this;
}

/** Getter for {@link LEDetonationPdu#munitionLiveEntityId}*/
public EntityID getMunitionLiveEntityId()
{
    return munitionLiveEntityId; 
}

/** Setter for {@link LEDetonationPdu#eventId}*/
public LEDetonationPdu setEventId(EventIdentifier pEventId)
{
    eventId = pEventId;
    return this;
}

/** Getter for {@link LEDetonationPdu#eventId}*/
public EventIdentifier getEventId()
{
    return eventId; 
}

/** Setter for {@link LEDetonationPdu#worldLocation}*/
public LEDetonationPdu setWorldLocation(LiveEntityRelativeWorldCoordinates pWorldLocation)
{
    worldLocation = pWorldLocation;
    return this;
}

/** Getter for {@link LEDetonationPdu#worldLocation}*/
public LiveEntityRelativeWorldCoordinates getWorldLocation()
{
    return worldLocation; 
}

/** Setter for {@link LEDetonationPdu#velocity}*/
public LEDetonationPdu setVelocity(LiveEntityLinearVelocity pVelocity)
{
    velocity = pVelocity;
    return this;
}

/** Getter for {@link LEDetonationPdu#velocity}*/
public LiveEntityLinearVelocity getVelocity()
{
    return velocity; 
}

/** Setter for {@link LEDetonationPdu#munitionOrientation}*/
public LEDetonationPdu setMunitionOrientation(LiveEntityOrientation16 pMunitionOrientation)
{
    munitionOrientation = pMunitionOrientation;
    return this;
}

/** Getter for {@link LEDetonationPdu#munitionOrientation}*/
public LiveEntityOrientation16 getMunitionOrientation()
{
    return munitionOrientation; 
}

/** Setter for {@link LEDetonationPdu#munitionDescriptor}*/
public LEDetonationPdu setMunitionDescriptor(MunitionDescriptor pMunitionDescriptor)
{
    munitionDescriptor = pMunitionDescriptor;
    return this;
}

/** Getter for {@link LEDetonationPdu#munitionDescriptor}*/
public MunitionDescriptor getMunitionDescriptor()
{
    return munitionDescriptor; 
}

/** Setter for {@link LEDetonationPdu#entityLocation}*/
public LEDetonationPdu setEntityLocation(LiveEntityLinearVelocity pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

/** Getter for {@link LEDetonationPdu#entityLocation}*/
public LiveEntityLinearVelocity getEntityLocation()
{
    return entityLocation; 
}

/** Setter for {@link LEDetonationPdu#detonationResult}*/
public LEDetonationPdu setDetonationResult(byte pDetonationResult)
{
    detonationResult = pDetonationResult;
    return this;
}

/** Getter for {@link LEDetonationPdu#detonationResult}*/
public byte getDetonationResult()
{
    return detonationResult; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       firingLiveEntityId.marshal(dos);
       dos.writeByte( (byte)detonationFlag1);
       dos.writeByte( (byte)detonationFlag2);
       targetLiveEntityId.marshal(dos);
       munitionLiveEntityId.marshal(dos);
       eventId.marshal(dos);
       worldLocation.marshal(dos);
       velocity.marshal(dos);
       munitionOrientation.marshal(dos);
       munitionDescriptor.marshal(dos);
       entityLocation.marshal(dos);
       dos.writeByte( (byte)detonationResult);
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
   firingLiveEntityId.marshal(buff);
   buff.put( (byte)detonationFlag1);
   buff.put( (byte)detonationFlag2);
   targetLiveEntityId.marshal(buff);
   munitionLiveEntityId.marshal(buff);
   eventId.marshal(buff);
   worldLocation.marshal(buff);
   velocity.marshal(buff);
   munitionOrientation.marshal(buff);
   munitionDescriptor.marshal(buff);
   entityLocation.marshal(buff);
   buff.put( (byte)detonationResult);
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

    firingLiveEntityId.unmarshal(buff);
    detonationFlag1 = (byte)(buff.get() & 0xFF);
    detonationFlag2 = (byte)(buff.get() & 0xFF);
    targetLiveEntityId.unmarshal(buff);
    munitionLiveEntityId.unmarshal(buff);
    eventId.unmarshal(buff);
    worldLocation.unmarshal(buff);
    velocity.unmarshal(buff);
    munitionOrientation.unmarshal(buff);
    munitionDescriptor.unmarshal(buff);
    entityLocation.unmarshal(buff);
    detonationResult = (byte)(buff.get() & 0xFF);
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
    sb.append(getClass().getSimpleName()+":\n");

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
