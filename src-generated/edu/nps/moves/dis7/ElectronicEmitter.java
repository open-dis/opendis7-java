/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class ElectronicEmitter extends Object implements Serializable
{
   /**  this field shall specify the length of this emitter system's data in 32-bit words. */
   protected byte  systemDataLength;

   /** the number of beams being described in the current PDU for the emitter system being described.  */
   protected byte  numberOfBeams;

   /**  information about a particular emitter system and shall be represented by an Emitter System record (see 6.2.23). */
   protected EmitterSystem  emitterSystem = new EmitterSystem(); 

   /** the location of the antenna beam source with respect to the emitting entity's coordinate system. This location shall be the origin of the emitter coordinate system that shall have the same orientation as the entity coordinate system. This field shall be represented by an Entity Coordinate Vector record see 6.2.95  */
   protected Vector3Float  location = new Vector3Float(); 

   /** Electronic emmission beams */
   protected List< EmitterBeam > beams = new ArrayList< EmitterBeam >();
 

/** Constructor */
 public ElectronicEmitter()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // systemDataLength
   marshalSize += 1;  // numberOfBeams
   marshalSize += emitterSystem.getMarshalledSize();
   marshalSize += location.getMarshalledSize();
   for(int idx=0; idx < beams.size(); idx++)
   {
        EmitterBeam listElement = beams.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link ElectronicEmitter#systemDataLength}*/
public ElectronicEmitter setSystemDataLength(byte pSystemDataLength)
{
    systemDataLength = pSystemDataLength;
    return this;
}

/** Getter for {@link ElectronicEmitter#systemDataLength}*/
public byte getSystemDataLength()
{
    return systemDataLength; 
}

/** Setter for {@link ElectronicEmitter#emitterSystem}*/
public ElectronicEmitter setEmitterSystem(EmitterSystem pEmitterSystem)
{
    emitterSystem = pEmitterSystem;
    return this;
}

/** Getter for {@link ElectronicEmitter#emitterSystem}*/
public EmitterSystem getEmitterSystem()
{
    return emitterSystem; 
}

/** Setter for {@link ElectronicEmitter#location}*/
public ElectronicEmitter setLocation(Vector3Float pLocation)
{
    location = pLocation;
    return this;
}

/** Getter for {@link ElectronicEmitter#location}*/
public Vector3Float getLocation()
{
    return location; 
}

/** Setter for {@link ElectronicEmitter#beams}*/
public ElectronicEmitter setBeams(List<EmitterBeam> pBeams)
{
    beams = pBeams;
    return this;
}

/** Getter for {@link ElectronicEmitter#beams}*/
public List<EmitterBeam> getBeams()
{
    return beams; 
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
       dos.writeByte( (byte)systemDataLength);
       dos.writeByte( (byte)beams.size());
       emitterSystem.marshal(dos);
       location.marshal(dos);

       for(int idx = 0; idx < beams.size(); idx++)
       {
            EmitterBeam aEmitterBeam = beams.get(idx);
            aEmitterBeam.marshal(dos);
       }

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
        systemDataLength = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfBeams = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += emitterSystem.unmarshal(dis);
        uPosition += location.unmarshal(dis);
        for(int idx = 0; idx < numberOfBeams; idx++)
        {
            EmitterBeam anX = new EmitterBeam();
            uPosition += anX.unmarshal(dis);
            beams.add(anX);
        }

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
   buff.put( (byte)systemDataLength);
   buff.put( (byte)beams.size());
   emitterSystem.marshal(buff);
   location.marshal(buff);

   for(int idx = 0; idx < beams.size(); idx++)
   {
        EmitterBeam aEmitterBeam = (EmitterBeam)beams.get(idx);
        aEmitterBeam.marshal(buff);
   }

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
    systemDataLength = (byte)(buff.get() & 0xFF);
    numberOfBeams = (byte)(buff.get() & 0xFF);
    emitterSystem.unmarshal(buff);
    location.unmarshal(buff);
    for(int idx = 0; idx < numberOfBeams; idx++)
    {
    EmitterBeam anX = new EmitterBeam();
    anX.unmarshal(buff);
    beams.add(anX);
    }

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

    if(!(obj instanceof ElectronicEmitter))
        return false;

     final ElectronicEmitter rhs = (ElectronicEmitter)obj;

     if( ! (systemDataLength == rhs.systemDataLength)) ivarsEqual = false;
     if( ! (numberOfBeams == rhs.numberOfBeams)) ivarsEqual = false;
     if( ! (emitterSystem.equals( rhs.emitterSystem) )) ivarsEqual = false;
     if( ! (location.equals( rhs.location) )) ivarsEqual = false;

     for(int idx = 0; idx < beams.size(); idx++)
        if( ! ( beams.get(idx).equals(rhs.beams.get(idx)))) ivarsEqual = false;

    return ivarsEqual;
 }
} // end of class
