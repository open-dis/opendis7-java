/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.5.6 Acknowledges the receipt of a Start/Resume PDU, Stop/Freeze PDU, Create Entity PDU, or Remove Entity PDU. See 5.6.5.6.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class AcknowledgePdu extends SimulationManagementFamilyPdu implements Serializable
{
   /** type of message being acknowledged uid 69 */
   protected AcknowledgeAcknowledgeFlag acknowledgeFlag = AcknowledgeAcknowledgeFlag.values()[0];

   /** Whether or not the receiving entity was able to comply with the request uid 70 */
   protected AcknowledgeResponseFlag responseFlag = AcknowledgeResponseFlag.values()[0];

   /** Request ID that is unique */
   protected int  requestID;


/** Constructor */
 public AcknowledgePdu()
 {
    setPduType( DISPDUType.ACKNOWLEDGE );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += acknowledgeFlag.getMarshalledSize();
   marshalSize += responseFlag.getMarshalledSize();
   marshalSize += 4;  // requestID

   return marshalSize;
}


/** Setter for {@link AcknowledgePdu#acknowledgeFlag}
  * @param pAcknowledgeFlag new value of interest
  * @return same object to permit progressive setters */
public AcknowledgePdu setAcknowledgeFlag(AcknowledgeAcknowledgeFlag pAcknowledgeFlag)
{
    acknowledgeFlag = pAcknowledgeFlag;
    return this;
}

/** Getter for {@link AcknowledgePdu#acknowledgeFlag}
  * @return value of interest */
public AcknowledgeAcknowledgeFlag getAcknowledgeFlag()
{
    return acknowledgeFlag; 
}

/** Setter for {@link AcknowledgePdu#responseFlag}
  * @param pResponseFlag new value of interest
  * @return same object to permit progressive setters */
public AcknowledgePdu setResponseFlag(AcknowledgeResponseFlag pResponseFlag)
{
    responseFlag = pResponseFlag;
    return this;
}

/** Getter for {@link AcknowledgePdu#responseFlag}
  * @return value of interest */
public AcknowledgeResponseFlag getResponseFlag()
{
    return responseFlag; 
}

/** Setter for {@link AcknowledgePdu#requestID}
  * @param pRequestID new value of interest
  * @return same object to permit progressive setters */
public AcknowledgePdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link AcknowledgePdu#requestID}
  * @return value of interest */
public int getRequestID()
{
    return requestID; 
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
       acknowledgeFlag.marshal(dos);
       responseFlag.marshal(dos);
       dos.writeInt(requestID);
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
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        acknowledgeFlag = AcknowledgeAcknowledgeFlag.unmarshalEnum(dis);
        uPosition += acknowledgeFlag.getMarshalledSize();
        responseFlag = AcknowledgeResponseFlag.unmarshalEnum(dis);
        uPosition += responseFlag.getMarshalledSize();
        requestID = dis.readInt();
        uPosition += 4;
    }
    catch(Exception e)
    { 
      System.err.println(e); 
    }
    return getMarshalledSize();
}

/**
 * Packs an object into the ByteBuffer.
 * @throws java.nio.BufferOverflowException if byteBuffer is too small
 * @throws java.nio.ReadOnlyBufferException if byteBuffer is read only
 * @see java.nio.ByteBuffer
 * @param byteBuffer The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   super.marshal(byteBuffer);
   acknowledgeFlag.marshal(byteBuffer);
   responseFlag.marshal(byteBuffer);
   byteBuffer.putInt( (int)requestID);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    acknowledgeFlag = AcknowledgeAcknowledgeFlag.unmarshalEnum(byteBuffer);
    responseFlag = AcknowledgeResponseFlag.unmarshalEnum(byteBuffer);
    requestID = byteBuffer.getInt();
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

     final AcknowledgePdu rhs = (AcknowledgePdu)obj;

     if( ! (acknowledgeFlag == rhs.acknowledgeFlag)) ivarsEqual = false;
     if( ! (responseFlag == rhs.responseFlag)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" acknowledgeFlag: ").append(acknowledgeFlag).append("\n");
    sb.append(" responseFlag: ").append(responseFlag).append("\n");
    sb.append(" requestID: ").append(requestID).append("\n");

   return sb.toString();
 }
} // end of class
