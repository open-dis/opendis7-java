package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Fixed Datum Record. Section 6.2.38
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class FixedDatum extends Object implements Serializable
{
   /** ID of the fixed datum, an enumeration uid 66 */
   protected VariableRecordTypes fixedDatumID = VariableRecordTypes.values()[0];

   /** Value for the fixed datum */
   protected int  fixedDatumValue;


/** Constructor */
 public FixedDatum()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += fixedDatumID.getMarshalledSize();
   marshalSize += 4;  // fixedDatumValue

   return marshalSize;
}


public FixedDatum setFixedDatumID(VariableRecordTypes pFixedDatumID)
{
    fixedDatumID = pFixedDatumID;
    return this;
}

public VariableRecordTypes getFixedDatumID()
{
    return fixedDatumID; 
}

public FixedDatum setFixedDatumValue(int pFixedDatumValue)
{
    fixedDatumValue = pFixedDatumValue;
    return this;
}

public int getFixedDatumValue()
{
    return fixedDatumValue; 
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
       fixedDatumID.marshal(dos);
       dos.writeInt( (int)fixedDatumValue);
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
        fixedDatumID = VariableRecordTypes.unmarshalEnum(dis);
        uPosition += fixedDatumID.getMarshalledSize();
        fixedDatumValue = dis.readInt();
        uPosition += 4;
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
   fixedDatumID.marshal(buff);
   buff.putInt( (int)fixedDatumValue);
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
    fixedDatumID = VariableRecordTypes.unmarshalEnum(buff);
    fixedDatumValue = buff.getInt();
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

    if(!(obj instanceof FixedDatum))
        return false;

     final FixedDatum rhs = (FixedDatum)obj;

     if( ! (fixedDatumID == rhs.fixedDatumID)) ivarsEqual = false;
     if( ! (fixedDatumValue == rhs.fixedDatumValue)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
