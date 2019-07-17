package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 *  Communication of a receiver state. Section 7.7.4
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class ReceiverPdu extends RadioCommunicationsFamilyPdu implements Serializable
{
   protected RadioCommsHeader  header = new RadioCommsHeader(); 

   /** encoding scheme used, and enumeration uid 179 */
   protected ReceiverReceiverState receiverState = ReceiverReceiverState.values()[0];

   protected short  padding1;

   /** received power */
   protected float  receivedPower;

   /** ID of transmitter */
   protected EntityID  transmitterEntityId = new EntityID(); 

   /** ID of transmitting radio */
   protected short  transmitterRadioId;


/** Constructor */
 public ReceiverPdu()
 {
    setPduType( DISPDUType.RECEIVER );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += header.getMarshalledSize();
   marshalSize += receiverState.getMarshalledSize();
   marshalSize += 2;  // padding1
   marshalSize += 4;  // receivedPower
   marshalSize += transmitterEntityId.getMarshalledSize();
   marshalSize += 2;  // transmitterRadioId

   return marshalSize;
}


public ReceiverPdu setHeader(RadioCommsHeader pHeader)
{
    header = pHeader;
    return this;
}

public RadioCommsHeader getHeader()
{
    return header; 
}

public ReceiverPdu setReceiverState(ReceiverReceiverState pReceiverState)
{
    receiverState = pReceiverState;
    return this;
}

public ReceiverReceiverState getReceiverState()
{
    return receiverState; 
}

public ReceiverPdu setPadding1(short pPadding1)
{
    padding1 = pPadding1;
    return this;
}

public short getPadding1()
{
    return padding1; 
}

public ReceiverPdu setReceivedPower(float pReceivedPower)
{
    receivedPower = pReceivedPower;
    return this;
}

public float getReceivedPower()
{
    return receivedPower; 
}

public ReceiverPdu setTransmitterEntityId(EntityID pTransmitterEntityId)
{
    transmitterEntityId = pTransmitterEntityId;
    return this;
}

public EntityID getTransmitterEntityId()
{
    return transmitterEntityId; 
}

public ReceiverPdu setTransmitterRadioId(short pTransmitterRadioId)
{
    transmitterRadioId = pTransmitterRadioId;
    return this;
}

public short getTransmitterRadioId()
{
    return transmitterRadioId; 
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
       header.marshal(dos);
       receiverState.marshal(dos);
       dos.writeShort( (short)padding1);
       dos.writeFloat( (float)receivedPower);
       transmitterEntityId.marshal(dos);
       dos.writeShort( (short)transmitterRadioId);
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
        uPosition += header.unmarshal(dis);
        receiverState = ReceiverReceiverState.unmarshalEnum(dis);
        uPosition += receiverState.getMarshalledSize();
        padding1 = (short)dis.readUnsignedShort();
        uPosition += 2;
        receivedPower = dis.readFloat();
        uPosition += 4;
        uPosition += transmitterEntityId.unmarshal(dis);
        transmitterRadioId = (short)dis.readUnsignedShort();
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
   super.marshal(buff);
   header.marshal(buff);
   receiverState.marshal(buff);
   buff.putShort( (short)padding1);
   buff.putFloat( (float)receivedPower);
   transmitterEntityId.marshal(buff);
   buff.putShort( (short)transmitterRadioId);
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

    header.unmarshal(buff);
    receiverState = ReceiverReceiverState.unmarshalEnum(buff);
    padding1 = (short)(buff.getShort() & 0xFFFF);
    receivedPower = buff.getFloat();
    transmitterEntityId.unmarshal(buff);
    transmitterRadioId = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof ReceiverPdu))
        return false;

     final ReceiverPdu rhs = (ReceiverPdu)obj;

     if( ! (header.equals( rhs.header) )) ivarsEqual = false;
     if( ! (receiverState == rhs.receiverState)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (receivedPower == rhs.receivedPower)) ivarsEqual = false;
     if( ! (transmitterEntityId.equals( rhs.transmitterEntityId) )) ivarsEqual = false;
     if( ! (transmitterRadioId == rhs.transmitterRadioId)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
