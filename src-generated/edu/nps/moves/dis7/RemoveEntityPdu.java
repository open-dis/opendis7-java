/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Section 7.5.3 The removal of an entity from an exercise shall be communicated with a Remove Entity PDU. See 5.6.5.3.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class RemoveEntityPdu extends SimulationManagementFamilyPdu implements Serializable
{
   /** This field shall identify the specific and unique start/resume request being made by the SM */
   protected int  requestID;


/** Constructor */
 public RemoveEntityPdu()
 {
    setPduType( DISPDUType.REMOVE_ENTITY );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 4;  // requestID

   return marshalSize;
}


/** Setter for {@link RemoveEntityPdu#requestID}*/
public RemoveEntityPdu setRequestID(int pRequestID)
{
    requestID = pRequestID;
    return this;
}

/** Getter for {@link RemoveEntityPdu#requestID}*/
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

    if(!(obj instanceof RemoveEntityPdu))
        return false;

     final RemoveEntityPdu rhs = (RemoveEntityPdu)obj;

     if( ! (requestID == rhs.requestID)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
