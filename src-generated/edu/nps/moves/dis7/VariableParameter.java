/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * used in DetonationPdu, ArticulatedPartsPdu among others
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class VariableParameter extends Object implements Serializable
{
   /** the identification of the Variable Parameter record. Enumeration from EBV uid 56 */
   protected VariableParameterRecordType recordType = VariableParameterRecordType.values()[0];

   /** 120 bits */
   protected byte[]  recordSpecificFields = new byte[15]; 


/** Constructor */
 public VariableParameter()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += recordType.getMarshalledSize();
   marshalSize += recordSpecificFields.length * 1;

   return marshalSize;
}


/** Setter for {@link VariableParameter#recordType}*/
public VariableParameter setRecordType(VariableParameterRecordType pRecordType)
{
    recordType = pRecordType;
    return this;
}

/** Getter for {@link VariableParameter#recordType}*/
public VariableParameterRecordType getRecordType()
{
    return recordType; 
}

/** Setter for {@link VariableParameter#recordSpecificFields}*/
public VariableParameter setRecordSpecificFields(byte[] pRecordSpecificFields)
{
    recordSpecificFields = Arrays.copyOf(pRecordSpecificFields, recordSpecificFields.length);
    return this;
}

/** Getter for {@link VariableParameter#recordSpecificFields}*/
public byte[] getRecordSpecificFields()
{
    return recordSpecificFields; 
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
       recordType.marshal(dos);

       for(int idx = 0; idx < recordSpecificFields.length; idx++)
           dos.writeByte(recordSpecificFields[idx]);

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
        recordType = VariableParameterRecordType.unmarshalEnum(dis);
        uPosition += recordType.getMarshalledSize();
        for(int idx = 0; idx < recordSpecificFields.length; idx++)
            recordSpecificFields[idx] = dis.readByte();
        uPosition += (recordSpecificFields.length * 1);
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
   recordType.marshal(buff);

   for(int idx = 0; idx < recordSpecificFields.length; idx++)
       buff.put((byte)recordSpecificFields[idx]);

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
    recordType = VariableParameterRecordType.unmarshalEnum(buff);
    for(int idx = 0; idx < recordSpecificFields.length; idx++)
        recordSpecificFields[idx] = buff.get();
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

     final VariableParameter rhs = (VariableParameter)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;

     for(int idx = 0; idx < 15; idx++)
     {
          if(!(recordSpecificFields[idx] == rhs.recordSpecificFields[idx])) ivarsEqual = false;
     }

    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" recordType: ").append(recordType).append("\n");
    sb.append(" recordSpecificFields: ").append("\n");
    sb.append(Arrays.toString(recordSpecificFields)).append("\n");

   return sb.toString();
 }
} // end of class
