package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 *  Information about a geometry, a state associated with a geometry, a bounding volume, or an associated entity ID.  6.2.31, not fully defined. 'The current definitions can be found in DIS PCR 240'
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class Environment extends Object implements Serializable
{
   /** Record type uid 250 */
   protected EnvironmentalProcessRecordType environmentType = EnvironmentalProcessRecordType.values()[0];

   /** length, in bits */
   protected short  length;

   /** Identify the sequentially numbered record index */
   protected byte  index;

   /** padding */
   protected byte  padding1;

   /** Geometry or state record */
   protected byte[]  geometry = new byte[0]; 

   private byte[] padding2 = new byte[0]; // pad to 64-bit boundary


/** Constructor */
 public Environment()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += environmentType.getMarshalledSize();
   marshalSize += 2;  // length
   marshalSize += 1;  // index
   marshalSize += 1;  // padding1
   marshalSize += geometry.length * 1;
   marshalSize += padding2.length;

   return marshalSize;
}


public Environment setEnvironmentType(EnvironmentalProcessRecordType pEnvironmentType)
{
    environmentType = pEnvironmentType;
    return this;
}

public EnvironmentalProcessRecordType getEnvironmentType()
{
    return environmentType; 
}

public Environment setLength(short pLength)
{
    length = pLength;
    return this;
}

public short getLength()
{
    return length; 
}

public Environment setIndex(byte pIndex)
{
    index = pIndex;
    return this;
}

public byte getIndex()
{
    return index; 
}

public Environment setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}

public byte getPadding1()
{
    return padding1; 
}

public Environment setGeometry(byte[] pGeometry)
{
    geometry = pGeometry;
    return this;
}

public byte[] getGeometry()
{
    return geometry; 
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
       environmentType.marshal(dos);
       dos.writeShort( (short)length);
       dos.writeByte( (byte)index);
       dos.writeByte( (byte)padding1);

       for(int idx = 0; idx < geometry.length; idx++)
           dos.writeByte(geometry[idx]);

       padding2 = new byte[Align.to64bits(dos)];
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
        environmentType = EnvironmentalProcessRecordType.unmarshalEnum(dis);
        uPosition += environmentType.getMarshalledSize();
        length = (short)dis.readUnsignedShort();
        uPosition += 2;
        index = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        for(int idx = 0; idx < geometry.length; idx++)
            geometry[idx] = dis.readByte(); // mike check
        uPosition += geometry.length; // todo, multiply by prim size mike
        padding2 = new byte[Align.from64bits(uPosition,dis)];
        uPosition += padding2.length;
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
   environmentType.marshal(buff);
   buff.putShort( (short)length);
   buff.put( (byte)index);
   buff.put( (byte)padding1);

   for(int idx = 0; idx < geometry.length; idx++)
       buff.put((byte)geometry[idx]);

   padding2 = new byte[Align.to64bits(buff)];
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    environmentType = EnvironmentalProcessRecordType.unmarshalEnum(buff);
    length = (short)(buff.getShort() & 0xFFFF);
    index = (byte)(buff.get() & 0xFF);
    padding1 = (byte)(buff.get() & 0xFF);
    for(int idx = 0; idx < geometry.length; idx++)
        geometry[idx] = buff.get();
    padding2 = new byte[Align.from64bits(buff)];
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

    if(!(obj instanceof Environment))
        return false;

     final Environment rhs = (Environment)obj;

     if( ! (environmentType == rhs.environmentType)) ivarsEqual = false;
     if( ! (length == rhs.length)) ivarsEqual = false;
     if( ! (index == rhs.index)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(geometry[idx] == rhs.geometry[idx])) ivarsEqual = false;
     }

    return ivarsEqual;
 }
} // end of class
