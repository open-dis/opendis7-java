/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Unique designation of an attached or unattached intercom in an event or exercirse. Section 6.2.48
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class IntercomIdentifier extends Object implements Serializable
{
   protected short  siteNumber;

   protected short  applicationNumber;

   protected short  referenceNumber;

   protected short  intercomNumber;


/** Constructor */
 public IntercomIdentifier()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // siteNumber
   marshalSize += 2;  // applicationNumber
   marshalSize += 2;  // referenceNumber
   marshalSize += 2;  // intercomNumber

   return marshalSize;
}


/** Setter for {@link IntercomIdentifier#siteNumber}*/
public IntercomIdentifier setSiteNumber(short pSiteNumber)
{
    siteNumber = pSiteNumber;
    return this;
}

/** Getter for {@link IntercomIdentifier#siteNumber}*/
public short getSiteNumber()
{
    return siteNumber; 
}

/** Setter for {@link IntercomIdentifier#applicationNumber}*/
public IntercomIdentifier setApplicationNumber(short pApplicationNumber)
{
    applicationNumber = pApplicationNumber;
    return this;
}

/** Getter for {@link IntercomIdentifier#applicationNumber}*/
public short getApplicationNumber()
{
    return applicationNumber; 
}

/** Setter for {@link IntercomIdentifier#referenceNumber}*/
public IntercomIdentifier setReferenceNumber(short pReferenceNumber)
{
    referenceNumber = pReferenceNumber;
    return this;
}

/** Getter for {@link IntercomIdentifier#referenceNumber}*/
public short getReferenceNumber()
{
    return referenceNumber; 
}

/** Setter for {@link IntercomIdentifier#intercomNumber}*/
public IntercomIdentifier setIntercomNumber(short pIntercomNumber)
{
    intercomNumber = pIntercomNumber;
    return this;
}

/** Getter for {@link IntercomIdentifier#intercomNumber}*/
public short getIntercomNumber()
{
    return intercomNumber; 
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
       dos.writeShort( (short)siteNumber);
       dos.writeShort( (short)applicationNumber);
       dos.writeShort( (short)referenceNumber);
       dos.writeShort( (short)intercomNumber);
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
        siteNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        applicationNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        referenceNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        intercomNumber = (short)dis.readUnsignedShort();
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
   buff.putShort( (short)siteNumber);
   buff.putShort( (short)applicationNumber);
   buff.putShort( (short)referenceNumber);
   buff.putShort( (short)intercomNumber);
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
    siteNumber = (short)(buff.getShort() & 0xFFFF);
    applicationNumber = (short)(buff.getShort() & 0xFFFF);
    referenceNumber = (short)(buff.getShort() & 0xFFFF);
    intercomNumber = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof IntercomIdentifier))
        return false;

     final IntercomIdentifier rhs = (IntercomIdentifier)obj;

     if( ! (siteNumber == rhs.siteNumber)) ivarsEqual = false;
     if( ! (applicationNumber == rhs.applicationNumber)) ivarsEqual = false;
     if( ! (referenceNumber == rhs.referenceNumber)) ivarsEqual = false;
     if( ! (intercomNumber == rhs.intercomNumber)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
