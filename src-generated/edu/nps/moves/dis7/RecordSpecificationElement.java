/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Synthetic record, made up from section 6.2.72. This is used to acheive a repeating variable list element.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class RecordSpecificationElement extends Object implements Serializable
{
   /** the data structure used to convey the parameter values of the record for each record. 32 bit enumeration. uid = 66 */
   protected VariableRecordTypes recordID = VariableRecordTypes.values()[0];

   /** the serial number of the first record in the block of records */
   protected int  recordSetSerialNumber;

   protected int  padding;

   /**  the length, in bits, of the record. Note, bits, not bytes. */
   protected short  recordLength;

   /**  the number of records included in the record set  */
   protected short  recordCount;

   /** the concatenated records of the format specified by the Record ID field. The length of this field is the Record Length multiplied by the Record Count, in units of bits. */
   protected byte[]  recordValues = new byte[0]; 

   private byte[] padTo64 = new byte[0]; // pad to 64-bit boundary


/** Constructor */
 public RecordSpecificationElement()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += recordID.getMarshalledSize();
   marshalSize += 4;  // recordSetSerialNumber
   marshalSize += 4;  // padding
   marshalSize += 2;  // recordLength
   marshalSize += 2;  // recordCount
   marshalSize += recordValues.length * 1;
   marshalSize += padTo64.length;

   return marshalSize;
}


/** Setter for {@link RecordSpecificationElement#recordID}*/
public RecordSpecificationElement setRecordID(VariableRecordTypes pRecordID)
{
    recordID = pRecordID;
    return this;
}

/** Getter for {@link RecordSpecificationElement#recordID}*/
public VariableRecordTypes getRecordID()
{
    return recordID; 
}

/** Setter for {@link RecordSpecificationElement#recordSetSerialNumber}*/
public RecordSpecificationElement setRecordSetSerialNumber(int pRecordSetSerialNumber)
{
    recordSetSerialNumber = pRecordSetSerialNumber;
    return this;
}

/** Getter for {@link RecordSpecificationElement#recordSetSerialNumber}*/
public int getRecordSetSerialNumber()
{
    return recordSetSerialNumber; 
}

/** Setter for {@link RecordSpecificationElement#padding}*/
public RecordSpecificationElement setPadding(int pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link RecordSpecificationElement#padding}*/
public int getPadding()
{
    return padding; 
}

/** Setter for {@link RecordSpecificationElement#recordLength}*/
public RecordSpecificationElement setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}

/** Getter for {@link RecordSpecificationElement#recordLength}*/
public short getRecordLength()
{
    return recordLength; 
}

/** Setter for {@link RecordSpecificationElement#recordCount}*/
public RecordSpecificationElement setRecordCount(short pRecordCount)
{
    recordCount = pRecordCount;
    return this;
}

/** Getter for {@link RecordSpecificationElement#recordCount}*/
public short getRecordCount()
{
    return recordCount; 
}

/** Setter for {@link RecordSpecificationElement#recordValues}*/
public RecordSpecificationElement setRecordValues(byte[] pRecordValues)
{
    recordValues = pRecordValues;
    return this;
}

/** Getter for {@link RecordSpecificationElement#recordValues}*/
public byte[] getRecordValues()
{
    return recordValues; 
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
       recordID.marshal(dos);
       dos.writeInt( (int)recordSetSerialNumber);
       dos.writeInt( (int)padding);
       dos.writeShort( (short)recordLength);
       dos.writeShort( (short)recordCount);

       for(int idx = 0; idx < recordValues.length; idx++)
           dos.writeByte(recordValues[idx]);

       padTo64 = new byte[Align.to64bits(dos)];
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
        recordID = VariableRecordTypes.unmarshalEnum(dis);
        uPosition += recordID.getMarshalledSize();
        recordSetSerialNumber = dis.readInt();
        uPosition += 4;
        padding = dis.readInt();
        uPosition += 4;
        recordLength = (short)dis.readUnsignedShort();
        uPosition += 2;
        recordCount = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < recordValues.length; idx++)
            recordValues[idx] = dis.readByte(); // mike check
        uPosition += recordValues.length; // todo, multiply by prim size mike
        padTo64 = new byte[Align.from64bits(uPosition,dis)];
        uPosition += padTo64.length;
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
   recordID.marshal(buff);
   buff.putInt( (int)recordSetSerialNumber);
   buff.putInt( (int)padding);
   buff.putShort( (short)recordLength);
   buff.putShort( (short)recordCount);

   for(int idx = 0; idx < recordValues.length; idx++)
       buff.put((byte)recordValues[idx]);

   padTo64 = new byte[Align.to64bits(buff)];
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
    recordID = VariableRecordTypes.unmarshalEnum(buff);
    recordSetSerialNumber = buff.getInt();
    padding = buff.getInt();
    recordLength = (short)(buff.getShort() & 0xFFFF);
    recordCount = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < recordValues.length; idx++)
        recordValues[idx] = buff.get();
    padTo64 = new byte[Align.from64bits(buff)];
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

    if(!(obj instanceof RecordSpecificationElement))
        return false;

     final RecordSpecificationElement rhs = (RecordSpecificationElement)obj;

     if( ! (recordID == rhs.recordID)) ivarsEqual = false;
     if( ! (recordSetSerialNumber == rhs.recordSetSerialNumber)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (recordCount == rhs.recordCount)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(recordValues[idx] == rhs.recordValues[idx])) ivarsEqual = false;
     }

    return ivarsEqual;
 }
} // end of class
