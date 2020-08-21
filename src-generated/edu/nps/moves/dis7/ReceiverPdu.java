/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.8.5 Communicates the state of a particular radio receiver. Its primary application is in communicating state information to radio network monitors, data loggers, and similar applications for use in debugging, supervision, and after-action review.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
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

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link ReceiverPdu#header}*/
public ReceiverPdu setHeader(RadioCommsHeader pHeader)
{
    header = pHeader;
    return this;
}

/** Getter for {@link ReceiverPdu#header}*/
public RadioCommsHeader getHeader()
{
    return header; 
}

/** Setter for {@link ReceiverPdu#receiverState}*/
public ReceiverPdu setReceiverState(ReceiverReceiverState pReceiverState)
{
    receiverState = pReceiverState;
    return this;
}

/** Getter for {@link ReceiverPdu#receiverState}*/
public ReceiverReceiverState getReceiverState()
{
    return receiverState; 
}

/** Setter for {@link ReceiverPdu#padding1}*/
public ReceiverPdu setPadding1(short pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link ReceiverPdu#padding1}*/
public short getPadding1()
{
    return padding1; 
}

/** Setter for {@link ReceiverPdu#receivedPower}*/
public ReceiverPdu setReceivedPower(float pReceivedPower)
{
    receivedPower = pReceivedPower;
    return this;
}

/** Getter for {@link ReceiverPdu#receivedPower}*/
public float getReceivedPower()
{
    return receivedPower; 
}

/** Setter for {@link ReceiverPdu#transmitterEntityId}*/
public ReceiverPdu setTransmitterEntityId(EntityID pTransmitterEntityId)
{
    transmitterEntityId = pTransmitterEntityId;
    return this;
}

/** Getter for {@link ReceiverPdu#transmitterEntityId}*/
public EntityID getTransmitterEntityId()
{
    return transmitterEntityId; 
}

/** Setter for {@link ReceiverPdu#transmitterRadioId}*/
public ReceiverPdu setTransmitterRadioId(short pTransmitterRadioId)
{
    transmitterRadioId = pTransmitterRadioId;
    return this;
}

/** Getter for {@link ReceiverPdu#transmitterRadioId}*/
public short getTransmitterRadioId()
{
    return transmitterRadioId; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       header.marshal(dos);
       receiverState.marshal(dos);
       dos.writeShort(padding1);
       dos.writeFloat(receivedPower);
       transmitterEntityId.marshal(dos);
       dos.writeShort(transmitterRadioId);
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final ReceiverPdu rhs = (ReceiverPdu)obj;

     if( ! (header.equals( rhs.header) )) ivarsEqual = false;
     if( ! (receiverState == rhs.receiverState)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (receivedPower == rhs.receivedPower)) ivarsEqual = false;
     if( ! (transmitterEntityId.equals( rhs.transmitterEntityId) )) ivarsEqual = false;
     if( ! (transmitterRadioId == rhs.transmitterRadioId)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" header: ").append(header).append("\n");
    sb.append(" receiverState: ").append(receiverState).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" receivedPower: ").append(receivedPower).append("\n");
    sb.append(" transmitterEntityId: ").append(transmitterEntityId).append("\n");
    sb.append(" transmitterRadioId: ").append(transmitterRadioId).append("\n");

   return sb.toString();
 }
} // end of class
