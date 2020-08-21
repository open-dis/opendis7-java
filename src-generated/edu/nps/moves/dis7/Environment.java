/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  Information about a geometry, a state associated with a geometry, a bounding volume, or an associated entity ID.  6.2.31, not fully defined. 'The current definitions can be found in DIS PCR 240'
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
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

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link Environment#environmentType}*/
public Environment setEnvironmentType(EnvironmentalProcessRecordType pEnvironmentType)
{
    environmentType = pEnvironmentType;
    return this;
}

/** Getter for {@link Environment#environmentType}*/
public EnvironmentalProcessRecordType getEnvironmentType()
{
    return environmentType; 
}

/** Setter for {@link Environment#length}*/
public Environment setLength(short pLength)
{
    length = pLength;
    return this;
}

/** Getter for {@link Environment#length}*/
public short getLength()
{
    return length; 
}

/** Setter for {@link Environment#index}*/
public Environment setIndex(byte pIndex)
{
    index = pIndex;
    return this;
}

/** Getter for {@link Environment#index}*/
public byte getIndex()
{
    return index; 
}

/** Setter for {@link Environment#padding1}*/
public Environment setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link Environment#padding1}*/
public byte getPadding1()
{
    return padding1; 
}

/** Setter for {@link Environment#geometry}*/
public Environment setGeometry(byte[] pGeometry)
{
    geometry = pGeometry;
    return this;
}

/** Getter for {@link Environment#geometry}*/
public byte[] getGeometry()
{
    return geometry; 
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
       environmentType.marshal(dos);
       dos.writeShort(length);
       dos.writeByte(index);
       dos.writeByte(padding1);

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
        environmentType = EnvironmentalProcessRecordType.unmarshalEnum(dis);
        uPosition += environmentType.getMarshalledSize();
        length = (short)dis.readUnsignedShort();
        uPosition += 2;
        index = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        for(int idx = 0; idx < geometry.length; idx++)
            geometry[idx] = dis.readByte();
        uPosition += (geometry.length * 1);
        padding2 = new byte[Align.from64bits(uPosition,dis)];
        uPosition += padding2.length;
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
 * @return marshalled size
 * @throws Exception ByteBuffer-generated exception
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

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" environmentType: ").append(environmentType).append("\n");
    sb.append(" length: ").append(length).append("\n");
    sb.append(" index: ").append(index).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" geometry: ").append("\n");
    sb.append(Arrays.toString(geometry)).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");

   return sb.toString();
 }
} // end of class
