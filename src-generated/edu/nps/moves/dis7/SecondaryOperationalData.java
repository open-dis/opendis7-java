/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Additional operational data for an IFF emitting system and the number of IFF Fundamental Parameter Data records Section 6.2.76.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class SecondaryOperationalData extends Object implements Serializable
{
   /** additional operational characteristics of the IFF emitting system. Each 8-bit field will vary depending on the system type. */
   protected byte  operationalData1;

   /** additional operational characteristics of the IFF emitting system. Each 8-bit field will vary depending on the system type. */
   protected byte  operationalData2;

   /** the number of IFF Fundamental Parameter Data records that follow */
   protected short  numberOfIFFFundamentalParameterRecords;


/** Constructor */
 public SecondaryOperationalData()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // operationalData1
   marshalSize += 1;  // operationalData2
   marshalSize += 2;  // numberOfIFFFundamentalParameterRecords

   return marshalSize;
}


/** Setter for {@link SecondaryOperationalData#operationalData1}*/
public SecondaryOperationalData setOperationalData1(byte pOperationalData1)
{
    operationalData1 = pOperationalData1;
    return this;
}

/** Getter for {@link SecondaryOperationalData#operationalData1}*/
public byte getOperationalData1()
{
    return operationalData1; 
}

/** Setter for {@link SecondaryOperationalData#operationalData2}*/
public SecondaryOperationalData setOperationalData2(byte pOperationalData2)
{
    operationalData2 = pOperationalData2;
    return this;
}

/** Getter for {@link SecondaryOperationalData#operationalData2}*/
public byte getOperationalData2()
{
    return operationalData2; 
}

/** Setter for {@link SecondaryOperationalData#numberOfIFFFundamentalParameterRecords}*/
public SecondaryOperationalData setNumberOfIFFFundamentalParameterRecords(short pNumberOfIFFFundamentalParameterRecords)
{
    numberOfIFFFundamentalParameterRecords = pNumberOfIFFFundamentalParameterRecords;
    return this;
}

/** Getter for {@link SecondaryOperationalData#numberOfIFFFundamentalParameterRecords}*/
public short getNumberOfIFFFundamentalParameterRecords()
{
    return numberOfIFFFundamentalParameterRecords; 
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
       dos.writeByte( (byte)operationalData1);
       dos.writeByte( (byte)operationalData2);
       dos.writeShort( (short)numberOfIFFFundamentalParameterRecords);
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
        operationalData1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        operationalData2 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfIFFFundamentalParameterRecords = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   buff.put( (byte)operationalData1);
   buff.put( (byte)operationalData2);
   buff.putShort( (short)numberOfIFFFundamentalParameterRecords);
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
    operationalData1 = (byte)(buff.get() & 0xFF);
    operationalData2 = (byte)(buff.get() & 0xFF);
    numberOfIFFFundamentalParameterRecords = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof SecondaryOperationalData))
        return false;

     final SecondaryOperationalData rhs = (SecondaryOperationalData)obj;

     if( ! (operationalData1 == rhs.operationalData1)) ivarsEqual = false;
     if( ! (operationalData2 == rhs.operationalData2)) ivarsEqual = false;
     if( ! (numberOfIFFFundamentalParameterRecords == rhs.numberOfIFFFundamentalParameterRecords)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
