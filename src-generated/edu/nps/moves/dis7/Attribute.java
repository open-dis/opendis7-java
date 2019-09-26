/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Used to convey information for one or more attributes. Attributes conform to the standard variable record format of 6.2.82. Section 6.2.10.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class Attribute extends Object implements Serializable
{
   protected int  recordType;

   protected short  recordLength;

   protected byte[]  recordSpecificFields = new byte[0]; 

   private byte[] padding = new byte[0]; // pad to 64-bit boundary


/** Constructor */
 public Attribute()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // recordType
   marshalSize += 2;  // recordLength
   marshalSize += recordSpecificFields.length * 1;
   marshalSize += padding.length;

   return marshalSize;
}


/** Setter for {@link Attribute#recordType}*/
public Attribute setRecordType(int pRecordType)
{
    recordType = pRecordType;
    return this;
}

/** Getter for {@link Attribute#recordType}*/
public int getRecordType()
{
    return recordType; 
}

/** Setter for {@link Attribute#recordSpecificFields}*/
public Attribute setRecordSpecificFields(byte[] pRecordSpecificFields)
{
    recordSpecificFields = pRecordSpecificFields;
    return this;
}

/** Getter for {@link Attribute#recordSpecificFields}*/
public byte[] getRecordSpecificFields()
{
    return recordSpecificFields; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       dos.writeInt( (int)recordType);
       dos.writeShort( (short)recordSpecificFields.length);

       for(int idx = 0; idx < recordSpecificFields.length; idx++)
           dos.writeByte(recordSpecificFields[idx]);

       padding = new byte[Align.to64bits(dos)];
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
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        recordType = dis.readInt();
        uPosition += 4;
        recordLength = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < recordSpecificFields.length; idx++)
            recordSpecificFields[idx] = dis.readByte();
        uPosition += (recordSpecificFields.length * 1);
        padding = new byte[Align.from64bits(uPosition,dis)];
        uPosition += padding.length;
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
   buff.putInt( (int)recordType);
   buff.putShort( (short)recordSpecificFields.length);

   for(int idx = 0; idx < recordSpecificFields.length; idx++)
       buff.put((byte)recordSpecificFields[idx]);

   padding = new byte[Align.to64bits(buff)];
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
    recordType = buff.getInt();
    recordLength = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < recordSpecificFields.length; idx++)
        recordSpecificFields[idx] = buff.get();
    padding = new byte[Align.from64bits(buff)];
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

     final Attribute rhs = (Attribute)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(recordSpecificFields[idx] == rhs.recordSpecificFields[idx])) ivarsEqual = false;
     }

    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" recordType: ").append(recordType).append("\n");
    sb.append(" recordSpecificFields: ").append("\n");
    sb.append(Arrays.toString(recordSpecificFields)).append("\n");
    sb.append(" padding: ").append(padding).append("\n");

   return sb.toString();
 }
} // end of class
