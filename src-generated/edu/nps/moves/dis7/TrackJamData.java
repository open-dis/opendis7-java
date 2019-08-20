/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  Track-Jam data Section 6.2.89
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class TrackJamData extends Object implements Serializable
{
   /** the entity tracked or illumated, or an emitter beam targeted with jamming */
   protected EntityID  entityID = new EntityID(); 

   /** Emitter system associated with the entity */
   protected byte  emitterNumber;

   /** Beam associated with the entity */
   protected byte  beamNumber;


/** Constructor */
 public TrackJamData()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += entityID.getMarshalledSize();
   marshalSize += 1;  // emitterNumber
   marshalSize += 1;  // beamNumber

   return marshalSize;
}


/** Setter for {@link TrackJamData#entityID}*/
public TrackJamData setEntityID(EntityID pEntityID)
{
    entityID = pEntityID;
    return this;
}

/** Getter for {@link TrackJamData#entityID}*/
public EntityID getEntityID()
{
    return entityID; 
}

/** Setter for {@link TrackJamData#emitterNumber}*/
public TrackJamData setEmitterNumber(byte pEmitterNumber)
{
    emitterNumber = pEmitterNumber;
    return this;
}

/** Getter for {@link TrackJamData#emitterNumber}*/
public byte getEmitterNumber()
{
    return emitterNumber; 
}

/** Setter for {@link TrackJamData#beamNumber}*/
public TrackJamData setBeamNumber(byte pBeamNumber)
{
    beamNumber = pBeamNumber;
    return this;
}

/** Getter for {@link TrackJamData#beamNumber}*/
public byte getBeamNumber()
{
    return beamNumber; 
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
       entityID.marshal(dos);
       dos.writeByte( (byte)emitterNumber);
       dos.writeByte( (byte)beamNumber);
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
        uPosition += entityID.unmarshal(dis);
        emitterNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        beamNumber = (byte)dis.readUnsignedByte();
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
   entityID.marshal(buff);
   buff.put( (byte)emitterNumber);
   buff.put( (byte)beamNumber);
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
    entityID.unmarshal(buff);
    emitterNumber = (byte)(buff.get() & 0xFF);
    beamNumber = (byte)(buff.get() & 0xFF);
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

    if(!(obj instanceof TrackJamData))
        return false;

     final TrackJamData rhs = (TrackJamData)obj;

     if( ! (entityID.equals( rhs.entityID) )) ivarsEqual = false;
     if( ! (emitterNumber == rhs.emitterNumber)) ivarsEqual = false;
     if( ! (beamNumber == rhs.beamNumber)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
