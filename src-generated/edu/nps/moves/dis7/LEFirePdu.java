/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 9.4.5 Representation of weapons fire in a DIS exercise involving LEs.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class LEFirePdu extends LiveEntityFamilyPdu implements Serializable
{
   protected EntityID  firingLiveEntityId = new EntityID(); 

   /** Bits defined in IEE Std. */
   protected byte  flags;

   protected EntityID  targetLiveEntityId = new EntityID(); 

   protected EntityID  munitionLiveEntityId = new EntityID(); 

   protected EventIdentifier  eventId = new EventIdentifier(); 

   protected LiveEntityRelativeWorldCoordinates  location = new LiveEntityRelativeWorldCoordinates(); 

   protected MunitionDescriptor  munitionDescriptor = new MunitionDescriptor(); 

   protected LiveEntityLinearVelocity  velocity = new LiveEntityLinearVelocity(); 

   protected short  range;


/** Constructor */
 public LEFirePdu()
 {
    setPduType( DISPDUType.LIVE_ENTITY_FIRE );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += firingLiveEntityId.getMarshalledSize();
   marshalSize += 1;  // flags
   marshalSize += targetLiveEntityId.getMarshalledSize();
   marshalSize += munitionLiveEntityId.getMarshalledSize();
   marshalSize += eventId.getMarshalledSize();
   marshalSize += location.getMarshalledSize();
   marshalSize += munitionDescriptor.getMarshalledSize();
   marshalSize += velocity.getMarshalledSize();
   marshalSize += 2;  // range

   return marshalSize;
}


public LEFirePdu setFiringLiveEntityId(EntityID pFiringLiveEntityId)
{
    firingLiveEntityId = pFiringLiveEntityId;
    return this;
}

public EntityID getFiringLiveEntityId()
{
    return firingLiveEntityId; 
}

public LEFirePdu setFlags(byte pFlags)
{
    flags = pFlags;
    return this;
}

public byte getFlags()
{
    return flags; 
}

public LEFirePdu setTargetLiveEntityId(EntityID pTargetLiveEntityId)
{
    targetLiveEntityId = pTargetLiveEntityId;
    return this;
}

public EntityID getTargetLiveEntityId()
{
    return targetLiveEntityId; 
}

public LEFirePdu setMunitionLiveEntityId(EntityID pMunitionLiveEntityId)
{
    munitionLiveEntityId = pMunitionLiveEntityId;
    return this;
}

public EntityID getMunitionLiveEntityId()
{
    return munitionLiveEntityId; 
}

public LEFirePdu setEventId(EventIdentifier pEventId)
{
    eventId = pEventId;
    return this;
}

public EventIdentifier getEventId()
{
    return eventId; 
}

public LEFirePdu setLocation(LiveEntityRelativeWorldCoordinates pLocation)
{
    location = pLocation;
    return this;
}

public LiveEntityRelativeWorldCoordinates getLocation()
{
    return location; 
}

public LEFirePdu setMunitionDescriptor(MunitionDescriptor pMunitionDescriptor)
{
    munitionDescriptor = pMunitionDescriptor;
    return this;
}

public MunitionDescriptor getMunitionDescriptor()
{
    return munitionDescriptor; 
}

public LEFirePdu setVelocity(LiveEntityLinearVelocity pVelocity)
{
    velocity = pVelocity;
    return this;
}

public LiveEntityLinearVelocity getVelocity()
{
    return velocity; 
}

public LEFirePdu setRange(short pRange)
{
    range = pRange;
    return this;
}

public short getRange()
{
    return range; 
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
       dos.writeByte( (byte)flags);
       targetLiveEntityId.marshal(dos);
       munitionLiveEntityId.marshal(dos);
       eventId.marshal(dos);
       location.marshal(dos);
       munitionDescriptor.marshal(dos);
       velocity.marshal(dos);
       dos.writeShort( (short)range);
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
        flags = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += targetLiveEntityId.unmarshal(dis);
        uPosition += munitionLiveEntityId.unmarshal(dis);
        uPosition += eventId.unmarshal(dis);
        uPosition += location.unmarshal(dis);
        uPosition += munitionDescriptor.unmarshal(dis);
        uPosition += velocity.unmarshal(dis);
        range = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   buff.put( (byte)flags);
   targetLiveEntityId.marshal(buff);
   munitionLiveEntityId.marshal(buff);
   eventId.marshal(buff);
   location.marshal(buff);
   munitionDescriptor.marshal(buff);
   velocity.marshal(buff);
   buff.putShort( (short)range);
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
    flags = (byte)(buff.get() & 0xFF);
    targetLiveEntityId.unmarshal(buff);
    munitionLiveEntityId.unmarshal(buff);
    eventId.unmarshal(buff);
    location.unmarshal(buff);
    munitionDescriptor.unmarshal(buff);
    velocity.unmarshal(buff);
    range = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof LEFirePdu))
        return false;

     final LEFirePdu rhs = (LEFirePdu)obj;

     if( ! (firingLiveEntityId.equals( rhs.firingLiveEntityId) )) ivarsEqual = false;
     if( ! (flags == rhs.flags)) ivarsEqual = false;
     if( ! (targetLiveEntityId.equals( rhs.targetLiveEntityId) )) ivarsEqual = false;
     if( ! (munitionLiveEntityId.equals( rhs.munitionLiveEntityId) )) ivarsEqual = false;
     if( ! (eventId.equals( rhs.eventId) )) ivarsEqual = false;
     if( ! (location.equals( rhs.location) )) ivarsEqual = false;
     if( ! (munitionDescriptor.equals( rhs.munitionDescriptor) )) ivarsEqual = false;
     if( ! (velocity.equals( rhs.velocity) )) ivarsEqual = false;
     if( ! (range == rhs.range)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
