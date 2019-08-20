/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * repeating element in IFF Data specification record
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class IFFData extends Object implements Serializable
{
   /** enumeration for type of record uid 66 */
   protected VariableRecordTypes recordType = VariableRecordTypes.values()[0];

   /** length of record, including padding */
   protected short  recordLength;

   protected byte[]  recordSpecificFields = new byte[0]; 

   private byte[] padding = new byte[0]; // pad to 32-bit boundary


/** Constructor */
 public IFFData()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += recordType.getMarshalledSize();
   marshalSize += 2;  // recordLength
   marshalSize += recordSpecificFields.length * 1;
   marshalSize += padding.length;

   return marshalSize;
}


/** Setter for {@link IFFData#recordType}*/
public IFFData setRecordType(VariableRecordTypes pRecordType)
{
    recordType = pRecordType;
    return this;
}

/** Getter for {@link IFFData#recordType}*/
public VariableRecordTypes getRecordType()
{
    return recordType; 
}

/** Setter for {@link IFFData#recordLength}*/
public IFFData setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}

/** Getter for {@link IFFData#recordLength}*/
public short getRecordLength()
{
    return recordLength; 
}

/** Setter for {@link IFFData#recordSpecificFields}*/
public IFFData setRecordSpecificFields(byte[] pRecordSpecificFields)
{
    recordSpecificFields = pRecordSpecificFields;
    return this;
}

/** Getter for {@link IFFData#recordSpecificFields}*/
public byte[] getRecordSpecificFields()
{
    return recordSpecificFields; 
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
       recordType.marshal(dos);
       dos.writeShort( (short)recordLength);

       for(int idx = 0; idx < recordSpecificFields.length; idx++)
           dos.writeByte(recordSpecificFields[idx]);

       padding = new byte[Align.to32bits(dos)];
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
        recordType = VariableRecordTypes.unmarshalEnum(dis);
        uPosition += recordType.getMarshalledSize();
        recordLength = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < recordSpecificFields.length; idx++)
            recordSpecificFields[idx] = dis.readByte(); // mike check
        uPosition += recordSpecificFields.length; // todo, multiply by prim size mike
        padding = new byte[Align.from32bits(uPosition,dis)];
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
   recordType.marshal(buff);
   buff.putShort( (short)recordLength);

   for(int idx = 0; idx < recordSpecificFields.length; idx++)
       buff.put((byte)recordSpecificFields[idx]);

   padding = new byte[Align.to32bits(buff)];
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
    recordType = VariableRecordTypes.unmarshalEnum(buff);
    recordLength = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < recordSpecificFields.length; idx++)
        recordSpecificFields[idx] = buff.get();
    padding = new byte[Align.from32bits(buff)];
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

    if(!(obj instanceof IFFData))
        return false;

     final IFFData rhs = (IFFData)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(recordSpecificFields[idx] == rhs.recordSpecificFields[idx])) ivarsEqual = false;
     }

    return ivarsEqual;
 }
} // end of class
