/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.5.6 Acknowledges the receipt of a Start/Resume PDU, Stop/Freeze PDU, Create Entity PDU, or Remove Entity PDU. See 5.6.5.6.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += acknowledgeFlag.getMarshalledSize();
   marshalSize += responseFlag.getMarshalledSize();
   marshalSize += 4;  // requestID

   return marshalSize;
}


/** Setter for {@link AcknowledgePdu#acknowledgeFlag}*/
public AcknowledgePdu setAcknowledgeFlag(AcknowledgeAcknowledgeFlag pAcknowledgeFlag)
{
    acknowledgeFlag = pAcknowledgeFlag;
    return this;
}

/** Getter for {@link AcknowledgePdu#acknowledgeFlag}*/
public AcknowledgeAcknowledgeFlag getAcknowledgeFlag()
{
    return acknowledgeFlag; 
}

/** Setter for {@link AcknowledgePdu#responseFlag}*/
public AcknowledgePdu setResponseFlag(AcknowledgeResponseFlag pResponseFlag)
{
    responseFlag = pResponseFlag;
    return this;
}

/** Getter for {@link AcknowledgePdu#responseFlag}*/
public AcknowledgeResponseFlag getResponseFlag()
{
    return responseFlag; 
}

/** Setter for {@link AcknowledgePdu#requestID}*/
public AcknowledgePdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link AcknowledgePdu#requestID}*/
public int getRequestID()
{
    return requestID; 
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
       acknowledgeFlag.marshal(dos);
       responseFlag.marshal(dos);
       dos.writeInt( (int)requestID);
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
        acknowledgeFlag = AcknowledgeAcknowledgeFlag.unmarshalEnum(dis);
        uPosition += acknowledgeFlag.getMarshalledSize();
        responseFlag = AcknowledgeResponseFlag.unmarshalEnum(dis);
        uPosition += responseFlag.getMarshalledSize();
        requestID = dis.readInt();
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
   super.marshal(buff);
   acknowledgeFlag.marshal(buff);
   responseFlag.marshal(buff);
   buff.putInt( (int)requestID);
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

    acknowledgeFlag = AcknowledgeAcknowledgeFlag.unmarshalEnum(buff);
    responseFlag = AcknowledgeResponseFlag.unmarshalEnum(buff);
    requestID = buff.getInt();
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

    if(!(obj instanceof AcknowledgePdu))
        return false;

     final AcknowledgePdu rhs = (AcknowledgePdu)obj;

     if( ! (acknowledgeFlag == rhs.acknowledgeFlag)) ivarsEqual = false;
     if( ! (responseFlag == rhs.responseFlag)) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
