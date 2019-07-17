package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * This field shall specify information about a particular emitter system. Section 6.2.23.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += emitterName.getMarshalledSize();
   marshalSize += emitterFunction.getMarshalledSize();
   marshalSize += 1;  // emitterIDNumber

   return marshalSize;
}


public EmitterSystem setEmitterName(EmitterName pEmitterName)
{
    emitterName = pEmitterName;
    return this;
}

public EmitterName getEmitterName()
{
    return emitterName; 
}

public EmitterSystem setEmitterFunction(EmitterSystemFunction pEmitterFunction)
{
    emitterFunction = pEmitterFunction;
    return this;
}

public EmitterSystemFunction getEmitterFunction()
{
    return emitterFunction; 
}

public EmitterSystem setEmitterIDNumber(byte pEmitterIDNumber)
{
    emitterIDNumber = pEmitterIDNumber;
    return this;
}

public byte getEmitterIDNumber()
{
    return emitterIDNumber; 
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
       emitterName.marshal(dos);
       emitterFunction.marshal(dos);
       dos.writeByte( (byte)emitterIDNumber);
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
        emitterName = EmitterName.unmarshalEnum(dis);
        uPosition += emitterName.getMarshalledSize();
        emitterFunction = EmitterSystemFunction.unmarshalEnum(dis);
        uPosition += emitterFunction.getMarshalledSize();
        emitterIDNumber = (byte)dis.readUnsignedByte();
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

    if(!(obj instanceof EmitterSystem))
        return false;

     final EmitterSystem rhs = (EmitterSystem)obj;

     if( ! (emitterName == rhs.emitterName)) ivarsEqual = false;
     if( ! (emitterFunction == rhs.emitterFunction)) ivarsEqual = false;
     if( ! (emitterIDNumber == rhs.emitterIDNumber)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
