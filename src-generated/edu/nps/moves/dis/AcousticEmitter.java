package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 *  information about a specific UA emitter. Section 6.2.2.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += acousticSystemName.getMarshalledSize();
   marshalSize += acousticFunction.getMarshalledSize();
   marshalSize += 1;  // acousticIDNumber

   return marshalSize;
}


public AcousticEmitter setAcousticSystemName(UAAcousticSystemName pAcousticSystemName)
{
    acousticSystemName = pAcousticSystemName;
    return this;
}

public UAAcousticSystemName getAcousticSystemName()
{
    return acousticSystemName; 
}

public AcousticEmitter setAcousticFunction(UAAcousticEmitterSystemFunction pAcousticFunction)
{
    acousticFunction = pAcousticFunction;
    return this;
}

public UAAcousticEmitterSystemFunction getAcousticFunction()
{
    return acousticFunction; 
}

public AcousticEmitter setAcousticIDNumber(byte pAcousticIDNumber)
{
    acousticIDNumber = pAcousticIDNumber;
    return this;
}

public byte getAcousticIDNumber()
{
    return acousticIDNumber; 
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
       acousticSystemName.marshal(dos);
       acousticFunction.marshal(dos);
       dos.writeByte( (byte)acousticIDNumber);
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
 */
public int unmarshal(DataInputStream dis)
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
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    acousticSystemName = UAAcousticSystemName.unmarshalEnum(buff);
    acousticFunction = UAAcousticEmitterSystemFunction.unmarshalEnum(buff);
    acousticIDNumber = (byte)(buff.get() & 0xFF);
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

    if(!(obj instanceof AcousticEmitter))
        return false;

     final AcousticEmitter rhs = (AcousticEmitter)obj;

     if( ! (acousticSystemName == rhs.acousticSystemName)) ivarsEqual = false;
     if( ! (acousticFunction == rhs.acousticFunction)) ivarsEqual = false;
     if( ! (acousticIDNumber == rhs.acousticIDNumber)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
