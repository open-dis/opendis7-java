/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * This field shall specify information about a particular emitter system. Section 6.2.23.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EmitterSystem extends Object implements Serializable
{
   /** Name of the emitter, 16 bit enumeration uid 75 */
   protected EmitterName emitterName = EmitterName.values()[0];

   /** function of the emitter, 8 bit enumeration uid 76 */
   protected EmitterSystemFunction emitterFunction = EmitterSystemFunction.values()[0];

   /** emitter ID, 8 bit enumeration */
   protected byte  emitterIDNumber;


/** Constructor */
 public EmitterSystem()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += emitterName.getMarshalledSize();
   marshalSize += emitterFunction.getMarshalledSize();
   marshalSize += 1;  // emitterIDNumber

   return marshalSize;
}


/** Setter for {@link EmitterSystem#emitterName}*/
public EmitterSystem setEmitterName(EmitterName pEmitterName)
{
    emitterName = pEmitterName;
    return this;
}

/** Getter for {@link EmitterSystem#emitterName}*/
public EmitterName getEmitterName()
{
    return emitterName; 
}

/** Setter for {@link EmitterSystem#emitterFunction}*/
public EmitterSystem setEmitterFunction(EmitterSystemFunction pEmitterFunction)
{
    emitterFunction = pEmitterFunction;
    return this;
}

/** Getter for {@link EmitterSystem#emitterFunction}*/
public EmitterSystemFunction getEmitterFunction()
{
    return emitterFunction; 
}

/** Setter for {@link EmitterSystem#emitterIDNumber}*/
public EmitterSystem setEmitterIDNumber(byte pEmitterIDNumber)
{
    emitterIDNumber = pEmitterIDNumber;
    return this;
}

/** Getter for {@link EmitterSystem#emitterIDNumber}*/
public byte getEmitterIDNumber()
{
    return emitterIDNumber; 
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
       emitterName.marshal(dos);
       emitterFunction.marshal(dos);
       dos.writeByte(emitterIDNumber);
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
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        emitterName = EmitterName.unmarshalEnum(dis);
        uPosition += emitterName.getMarshalledSize();
        emitterFunction = EmitterSystemFunction.unmarshalEnum(dis);
        uPosition += emitterFunction.getMarshalledSize();
        emitterIDNumber = (byte)dis.readUnsignedByte();
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
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   emitterName.marshal(buff);
   emitterFunction.marshal(buff);
   buff.put( (byte)emitterIDNumber);
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
    emitterName = EmitterName.unmarshalEnum(buff);
    emitterFunction = EmitterSystemFunction.unmarshalEnum(buff);
    emitterIDNumber = (byte)(buff.get() & 0xFF);
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

     final EmitterSystem rhs = (EmitterSystem)obj;

     if( ! (emitterName == rhs.emitterName)) ivarsEqual = false;
     if( ! (emitterFunction == rhs.emitterFunction)) ivarsEqual = false;
     if( ! (emitterIDNumber == rhs.emitterIDNumber)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" emitterName: ").append(emitterName).append("\n");
    sb.append(" emitterFunction: ").append(emitterFunction).append("\n");
    sb.append(" emitterIDNumber: ").append(emitterIDNumber).append("\n");

   return sb.toString();
 }
} // end of class
