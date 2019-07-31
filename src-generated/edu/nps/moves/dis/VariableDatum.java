/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * the variable datum type, the datum length, and the value for that variable datum type. Section 6.2.93
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class VariableDatum extends Object implements Serializable
{
   /** Type of variable datum to be transmitted. 32 bit enumeration defined in EBV uid 66 */
   protected VariableRecordTypes variableDatumID = VariableRecordTypes.values()[0];

   /** Length, IN BITS, of the variable datum. */
   protected int  variableDatumLength;

   /** This can be any number of bits long, depending on the datum. */
   protected byte[]  variableDatumValue = new byte[0]; 

   private byte[] padding = new byte[0]; // pad to 64-bit boundary


/** Constructor */
 public VariableDatum()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += variableDatumID.getMarshalledSize();
   marshalSize += 4;  // variableDatumLength
   marshalSize += variableDatumValue.length * 1;
   marshalSize += padding.length;

   return marshalSize;
}


public VariableDatum setVariableDatumID(VariableRecordTypes pVariableDatumID)
{
    variableDatumID = pVariableDatumID;
    return this;
}

public VariableRecordTypes getVariableDatumID()
{
    return variableDatumID; 
}

public VariableDatum setVariableDatumLength(int pVariableDatumLength)
{
    variableDatumLength = pVariableDatumLength;
    return this;
}

public int getVariableDatumLength()
{
    return variableDatumLength; 
}

public VariableDatum setVariableDatumValue(byte[] pVariableDatumValue)
{
    variableDatumValue = pVariableDatumValue;
    return this;
}

public byte[] getVariableDatumValue()
{
    return variableDatumValue; 
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
       variableDatumID.marshal(dos);
       dos.writeInt( (int)variableDatumLength);

       for(int idx = 0; idx < variableDatumValue.length; idx++)
           dos.writeByte(variableDatumValue[idx]);

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
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    try 
    {
        variableDatumID = VariableRecordTypes.unmarshalEnum(dis);
        uPosition += variableDatumID.getMarshalledSize();
        variableDatumLength = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < variableDatumValue.length; idx++)
            variableDatumValue[idx] = dis.readByte(); // mike check
        uPosition += variableDatumValue.length; // todo, multiply by prim size mike
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
   variableDatumID.marshal(buff);
   buff.putInt( (int)variableDatumLength);

   for(int idx = 0; idx < variableDatumValue.length; idx++)
       buff.put((byte)variableDatumValue[idx]);

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
    variableDatumID = VariableRecordTypes.unmarshalEnum(buff);
    variableDatumLength = buff.getInt();
    for(int idx = 0; idx < variableDatumValue.length; idx++)
        variableDatumValue[idx] = buff.get();
    padding = new byte[Align.from64bits(buff)];
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

    if(!(obj instanceof VariableDatum))
        return false;

     final VariableDatum rhs = (VariableDatum)obj;

     if( ! (variableDatumID == rhs.variableDatumID)) ivarsEqual = false;
     if( ! (variableDatumLength == rhs.variableDatumLength)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(variableDatumValue[idx] == rhs.variableDatumValue[idx])) ivarsEqual = false;
     }

    return ivarsEqual;
 }
} // end of class
