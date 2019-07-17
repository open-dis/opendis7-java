package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * proivde the means to request a retransmit of a minefield data pdu. Section 7.9.5
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class MinefieldResponseNackPdu extends MinefieldFamilyPdu implements Serializable
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
 public MinefieldResponseNackPdu()
 {
    setPduType( DISPDUType.MINEFIELD_RESPONSE_NACK );
 }

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


public MinefieldResponseNackPdu setMinefieldID(MinefieldIdentifier pMinefieldID)
{
    minefieldID = pMinefieldID;
    return this;
}

public MinefieldIdentifier getMinefieldID()
{
    return minefieldID; 
}

public MinefieldResponseNackPdu setRequestingEntityID(SimulationIdentifier pRequestingEntityID)
{
    requestingEntityID = pRequestingEntityID;
    return this;
}

public SimulationIdentifier getRequestingEntityID()
{
    return requestingEntityID; 
}

public MinefieldResponseNackPdu setRequestID(byte pRequestID)
{
    requestID = pRequestID;
    return this;
}

public byte getRequestID()
{
    return requestID; 
}

public MinefieldResponseNackPdu setMissingPduSequenceNumbers(byte[] pMissingPduSequenceNumbers)
{
    missingPduSequenceNumbers = pMissingPduSequenceNumbers;
    return this;
}

public byte[] getMissingPduSequenceNumbers()
{
    return missingPduSequenceNumbers; 
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
       minefieldID.marshal(dos);
       requestingEntityID.marshal(dos);
       dos.writeByte( (byte)requestID);
       dos.writeByte( (byte)numberOfMissingPdus);

       for(int idx = 0; idx < missingPduSequenceNumbers.length; idx++)
           dos.writeByte(missingPduSequenceNumbers[idx]);

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
        uPosition += minefieldID.unmarshal(dis);
        uPosition += requestingEntityID.unmarshal(dis);
        requestID = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfMissingPdus = (byte)dis.readUnsignedByte();
        uPosition += 1;
        for(int idx = 0; idx < missingPduSequenceNumbers.length; idx++)
            missingPduSequenceNumbers[idx] = dis.readByte(); // mike check
        uPosition += missingPduSequenceNumbers.length; // todo, multiply by prim size mike
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
   minefieldID.marshal(buff);
   requestingEntityID.marshal(buff);
   buff.put( (byte)requestID);
   buff.put( (byte)numberOfMissingPdus);

   for(int idx = 0; idx < missingPduSequenceNumbers.length; idx++)
       buff.put((byte)missingPduSequenceNumbers[idx]);

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

    minefieldID.unmarshal(buff);
    requestingEntityID.unmarshal(buff);
    requestID = (byte)(buff.get() & 0xFF);
    numberOfMissingPdus = (byte)(buff.get() & 0xFF);
    for(int idx = 0; idx < missingPduSequenceNumbers.length; idx++)
        missingPduSequenceNumbers[idx] = buff.get();
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

    if(!(obj instanceof MinefieldResponseNackPdu))
        return false;

     final MinefieldResponseNackPdu rhs = (MinefieldResponseNackPdu)obj;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (requestingEntityID.equals( rhs.requestingEntityID) )) ivarsEqual = false;
     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
     if( ! (numberOfMissingPdus == rhs.numberOfMissingPdus)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(missingPduSequenceNumbers[idx] == rhs.missingPduSequenceNumbers[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
