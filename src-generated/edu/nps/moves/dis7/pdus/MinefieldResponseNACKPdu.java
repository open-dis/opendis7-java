/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.10.5 Contains information about the requesting entity and the PDU(s) that were not received in response to a query.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class MinefieldResponseNACKPdu extends MinefieldFamilyPdu implements Serializable
{
   /** Minefield ID */
   protected MinefieldIdentifier  minefieldID = new MinefieldIdentifier(); 

   /** entity ID making the request */
   protected SimulationIdentifier  requestingEntityID = new SimulationIdentifier(); 

   /** request ID */
   protected byte  requestID;

   /** how many pdus were missing */
   protected byte  numberOfMissingPdus;

   /** PDU sequence numbers that were missing */
   protected byte[]  missingPduSequenceNumbers = new byte[0]; 


/** Constructor */
 public MinefieldResponseNACKPdu()
 {
    setPduType( DisPduType.MINEFIELD_RESPONSE_NACK );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += minefieldID.getMarshalledSize();
   marshalSize += requestingEntityID.getMarshalledSize();
   marshalSize += 1;  // requestID
   marshalSize += 1;  // numberOfMissingPdus
   marshalSize += missingPduSequenceNumbers.length * 1;

   return marshalSize;
}


/** Setter for {@link MinefieldResponseNACKPdu#minefieldID}
  * @param pMinefieldID new value of interest
  * @return same object to permit progressive setters */
public MinefieldResponseNACKPdu setMinefieldID(MinefieldIdentifier pMinefieldID)
{
    minefieldID = pMinefieldID;
    return this;
}

/** Getter for {@link MinefieldResponseNACKPdu#minefieldID}
  * @return value of interest */
public MinefieldIdentifier getMinefieldID()
{
    return minefieldID; 
}

/** Setter for {@link MinefieldResponseNACKPdu#requestingEntityID}
  * @param pRequestingEntityID new value of interest
  * @return same object to permit progressive setters */
public MinefieldResponseNACKPdu setRequestingEntityID(SimulationIdentifier pRequestingEntityID)
{
    requestingEntityID = pRequestingEntityID;
    return this;
}

/** Getter for {@link MinefieldResponseNACKPdu#requestingEntityID}
  * @return value of interest */
public SimulationIdentifier getRequestingEntityID()
{
    return requestingEntityID; 
}

/** Setter for {@link MinefieldResponseNACKPdu#requestID}
  * @param pRequestID new value of interest
  * @return same object to permit progressive setters */
public MinefieldResponseNACKPdu setRequestID(byte pRequestID)
{
    requestID = pRequestID;
    return this;
}
/** Utility setter for {@link MinefieldResponseNACKPdu#requestID}
  * @param pRequestID new value of interest
  * @return same object to permit progressive setters */
public MinefieldResponseNACKPdu setRequestID(int pRequestID){
    requestID = (byte) pRequestID;
    return this;
}

/** Getter for {@link MinefieldResponseNACKPdu#requestID}
  * @return value of interest */
public byte getRequestID()
{
    return requestID; 
}

/** Setter for {@link MinefieldResponseNACKPdu#missingPduSequenceNumbers}
  * @param pMissingPduSequenceNumbers new value of interest
  * @return same object to permit progressive setters */
public MinefieldResponseNACKPdu setMissingPduSequenceNumbers(byte[] pMissingPduSequenceNumbers)
{
    missingPduSequenceNumbers = pMissingPduSequenceNumbers;
    return this;
}

/** Getter for {@link MinefieldResponseNACKPdu#missingPduSequenceNumbers}
  * @return value of interest */
public byte[] getMissingPduSequenceNumbers()
{
    return missingPduSequenceNumbers; 
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
       minefieldID.marshal(dos);
       requestingEntityID.marshal(dos);
       dos.writeByte(requestID);
       dos.writeByte(missingPduSequenceNumbers.length);

       for(int idx = 0; idx < missingPduSequenceNumbers.length; idx++)
           dos.writeByte(missingPduSequenceNumbers[idx]);

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
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += minefieldID.unmarshal(dis);
        uPosition += requestingEntityID.unmarshal(dis);
        requestID = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfMissingPdus = (byte)dis.readUnsignedByte();
        uPosition += 1;
        for(int idx = 0; idx < missingPduSequenceNumbers.length; idx++)
            missingPduSequenceNumbers[idx] = dis.readByte();
        uPosition += (missingPduSequenceNumbers.length * 1);
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
   minefieldID.marshal(byteBuffer);
   requestingEntityID.marshal(byteBuffer);
   byteBuffer.put( (byte)requestID);
   byteBuffer.put( (byte)missingPduSequenceNumbers.length);

   for(int idx = 0; idx < missingPduSequenceNumbers.length; idx++)
       byteBuffer.put((byte)missingPduSequenceNumbers[idx]);

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    minefieldID.unmarshal(byteBuffer);
    requestingEntityID.unmarshal(byteBuffer);
    requestID = (byte)(byteBuffer.get() & 0xFF);
    numberOfMissingPdus = (byte)(byteBuffer.get() & 0xFF);
    for(int idx = 0; idx < missingPduSequenceNumbers.length; idx++)
        missingPduSequenceNumbers[idx] = byteBuffer.get();
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

     final MinefieldResponseNACKPdu rhs = (MinefieldResponseNACKPdu)obj;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(missingPduSequenceNumbers[idx] == rhs.missingPduSequenceNumbers[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" minefieldID: ").append(minefieldID).append("\n");
    sb.append(" requestingEntityID: ").append(requestingEntityID).append("\n");
    sb.append(" requestID: ").append(requestID).append("\n");
    sb.append(" missingPduSequenceNumbers: ").append("\n");
    sb.append(Arrays.toString(missingPduSequenceNumbers)).append("\n");

   return sb.toString();
 }
} // end of class
