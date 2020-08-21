/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  information about a specific UA emitter. Section 6.2.2.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class AcousticEmitter extends Object implements Serializable
{
   /** the system for a particular UA emitter, and an enumeration uid 144 */
   protected UAAcousticSystemName acousticSystemName = UAAcousticSystemName.values()[0];

   /** The function of the acoustic system uid 145 */
   protected UAAcousticEmitterSystemFunction acousticFunction = UAAcousticEmitterSystemFunction.values()[0];

   /** The UA emitter identification number relative to a specific system */
   protected byte  acousticIDNumber;


/** Constructor */
 public AcousticEmitter()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += acousticSystemName.getMarshalledSize();
   marshalSize += acousticFunction.getMarshalledSize();
   marshalSize += 1;  // acousticIDNumber

   return marshalSize;
}


/** Setter for {@link AcousticEmitter#acousticSystemName}*/
public AcousticEmitter setAcousticSystemName(UAAcousticSystemName pAcousticSystemName)
{
    acousticSystemName = pAcousticSystemName;
    return this;
}

/** Getter for {@link AcousticEmitter#acousticSystemName}*/
public UAAcousticSystemName getAcousticSystemName()
{
    return acousticSystemName; 
}

/** Setter for {@link AcousticEmitter#acousticFunction}*/
public AcousticEmitter setAcousticFunction(UAAcousticEmitterSystemFunction pAcousticFunction)
{
    acousticFunction = pAcousticFunction;
    return this;
}

/** Getter for {@link AcousticEmitter#acousticFunction}*/
public UAAcousticEmitterSystemFunction getAcousticFunction()
{
    return acousticFunction; 
}

/** Setter for {@link AcousticEmitter#acousticIDNumber}*/
public AcousticEmitter setAcousticIDNumber(byte pAcousticIDNumber)
{
    acousticIDNumber = pAcousticIDNumber;
    return this;
}

/** Getter for {@link AcousticEmitter#acousticIDNumber}*/
public byte getAcousticIDNumber()
{
    return acousticIDNumber; 
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
       acousticSystemName.marshal(dos);
       acousticFunction.marshal(dos);
       dos.writeByte(acousticIDNumber);
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
        acousticSystemName = UAAcousticSystemName.unmarshalEnum(dis);
        uPosition += acousticSystemName.getMarshalledSize();
        acousticFunction = UAAcousticEmitterSystemFunction.unmarshalEnum(dis);
        uPosition += acousticFunction.getMarshalledSize();
        acousticIDNumber = (byte)dis.readUnsignedByte();
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
   acousticSystemName.marshal(buff);
   acousticFunction.marshal(buff);
   buff.put( (byte)acousticIDNumber);
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
    acousticSystemName = UAAcousticSystemName.unmarshalEnum(buff);
    acousticFunction = UAAcousticEmitterSystemFunction.unmarshalEnum(buff);
    acousticIDNumber = (byte)(buff.get() & 0xFF);
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

     final AcousticEmitter rhs = (AcousticEmitter)obj;

     if( ! (acousticSystemName == rhs.acousticSystemName)) ivarsEqual = false;
     if( ! (acousticFunction == rhs.acousticFunction)) ivarsEqual = false;
     if( ! (acousticIDNumber == rhs.acousticIDNumber)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" acousticSystemName: ").append(acousticSystemName).append("\n");
    sb.append(" acousticFunction: ").append(acousticFunction).append("\n");
    sb.append(" acousticIDNumber: ").append(acousticIDNumber).append("\n");

   return sb.toString();
 }
} // end of class
