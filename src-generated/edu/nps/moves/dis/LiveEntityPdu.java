package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * The live entity PDUs have a slightly different header
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class LiveEntityPdu extends Pdu implements Serializable
{
   /** Subprotocol used to decode the PDU. Section 13 of EBV. uid 417 */
   protected DISLiveEntitySubprotocolNumber subprotocolNumber = DISLiveEntitySubprotocolNumber.values()[0];

   /** zero-filled array of padding */
   protected byte  padding = (byte)0;


/** Constructor */
 public LiveEntityPdu()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += subprotocolNumber.getMarshalledSize();
   marshalSize += 1;  // padding

   return marshalSize;
}


public LiveEntityPdu setSubprotocolNumber(DISLiveEntitySubprotocolNumber pSubprotocolNumber)
{
    subprotocolNumber = pSubprotocolNumber;
    return this;
}

public DISLiveEntitySubprotocolNumber getSubprotocolNumber()
{
    return subprotocolNumber; 
}

public LiveEntityPdu setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

public byte getPadding()
{
    return padding; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       subprotocolNumber.marshal(dos);
       dos.writeByte( (byte)padding);
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
    uPosition += super.unmarshal(dis);

    try 
    {
        subprotocolNumber = DISLiveEntitySubprotocolNumber.unmarshalEnum(dis);
        uPosition += subprotocolNumber.getMarshalledSize();
        padding = (byte)dis.readUnsignedByte();
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
   super.marshal(buff);
   subprotocolNumber.marshal(buff);
   buff.put( (byte)padding);
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
    super.unmarshal(buff);

    subprotocolNumber = DISLiveEntitySubprotocolNumber.unmarshalEnum(buff);
    padding = (byte)(buff.get() & 0xFF);
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof LiveEntityPdu))
        return false;

     final LiveEntityPdu rhs = (LiveEntityPdu)obj;

     if( ! (subprotocolNumber == rhs.subprotocolNumber)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
