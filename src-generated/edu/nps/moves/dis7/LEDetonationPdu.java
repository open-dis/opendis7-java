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
    setPduType( DISPDUType.LE_DETONATION );
 }

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


public LEDetonationPdu setFiringLiveEntityId(EntityID pFiringLiveEntityId)
{
    firingLiveEntityId = pFiringLiveEntityId;
    return this;
}

public EntityID getFiringLiveEntityId()
{
    return firingLiveEntityId; 
}

public LEDetonationPdu setDetonationFlag1(byte pDetonationFlag1)
{
    detonationFlag1 = pDetonationFlag1;
    return this;
}

public byte getDetonationFlag1()
{
    return detonationFlag1; 
}

public LEDetonationPdu setDetonationFlag2(byte pDetonationFlag2)
{
    detonationFlag2 = pDetonationFlag2;
    return this;
}

public byte getDetonationFlag2()
{
    return detonationFlag2; 
}

public LEDetonationPdu setTargetLiveEntityId(EntityID pTargetLiveEntityId)
{
    targetLiveEntityId = pTargetLiveEntityId;
    return this;
}

public EntityID getTargetLiveEntityId()
{
    return targetLiveEntityId; 
}

public LEDetonationPdu setMunitionLiveEntityId(EntityID pMunitionLiveEntityId)
{
    munitionLiveEntityId = pMunitionLiveEntityId;
    return this;
}

public EntityID getMunitionLiveEntityId()
{
    return munitionLiveEntityId; 
}

public LEDetonationPdu setEventId(EventIdentifier pEventId)
{
    eventId = pEventId;
    return this;
}

public EventIdentifier getEventId()
{
    return eventId; 
}

public LEDetonationPdu setWorldLocation(LiveEntityRelativeWorldCoordinates pWorldLocation)
{
    worldLocation = pWorldLocation;
    return this;
}

public LiveEntityRelativeWorldCoordinates getWorldLocation()
{
    return worldLocation; 
}

public LEDetonationPdu setVelocity(LiveEntityLinearVelocity pVelocity)
{
    velocity = pVelocity;
    return this;
}

public LiveEntityLinearVelocity getVelocity()
{
    return velocity; 
}

public LEDetonationPdu setMunitionOrientation(LiveEntityOrientation16 pMunitionOrientation)
{
    munitionOrientation = pMunitionOrientation;
    return this;
}

public LiveEntityOrientation16 getMunitionOrientation()
{
    return munitionOrientation; 
}

public LEDetonationPdu setMunitionDescriptor(MunitionDescriptor pMunitionDescriptor)
{
    munitionDescriptor = pMunitionDescriptor;
    return this;
}

public MunitionDescriptor getMunitionDescriptor()
{
    return munitionDescriptor; 
}

public LEDetonationPdu setEntityLocation(LiveEntityLinearVelocity pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

public LiveEntityLinearVelocity getEntityLocation()
{
    return entityLocation; 
}

public LEDetonationPdu setDetonationResult(byte pDetonationResult)
{
    detonationResult = pDetonationResult;
    return this;
}

public byte getDetonationResult()
{
    return detonationResult; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
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
public int unmarshal(DataInputStream dis)
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof LEDetonationPdu))
        return false;

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
} // end of class
