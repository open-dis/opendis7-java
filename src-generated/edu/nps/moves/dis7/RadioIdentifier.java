/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The unique designation of an attached or unattached radio in an event or exercise Section 6.2.70
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class RadioIdentifier extends Object implements Serializable
{
   /**  site */
   protected short  siteNumber;

   /** application number */
   protected short  applicationNumber;

   /**  reference number */
   protected short  referenceNumber;

   /**  Radio number */
   protected short  radioNumber;


/** Constructor */
 public RadioIdentifier()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // siteNumber
   marshalSize += 2;  // applicationNumber
   marshalSize += 2;  // referenceNumber
   marshalSize += 2;  // radioNumber

   return marshalSize;
}


/** Setter for {@link RadioIdentifier#siteNumber}*/
public RadioIdentifier setSiteNumber(short pSiteNumber)
{
    siteNumber = pSiteNumber;
    return this;
}

/** Getter for {@link RadioIdentifier#siteNumber}*/
public short getSiteNumber()
{
    return siteNumber; 
}

/** Setter for {@link RadioIdentifier#applicationNumber}*/
public RadioIdentifier setApplicationNumber(short pApplicationNumber)
{
    applicationNumber = pApplicationNumber;
    return this;
}

/** Getter for {@link RadioIdentifier#applicationNumber}*/
public short getApplicationNumber()
{
    return applicationNumber; 
}

/** Setter for {@link RadioIdentifier#referenceNumber}*/
public RadioIdentifier setReferenceNumber(short pReferenceNumber)
{
    referenceNumber = pReferenceNumber;
    return this;
}

/** Getter for {@link RadioIdentifier#referenceNumber}*/
public short getReferenceNumber()
{
    return referenceNumber; 
}

/** Setter for {@link RadioIdentifier#radioNumber}*/
public RadioIdentifier setRadioNumber(short pRadioNumber)
{
    radioNumber = pRadioNumber;
    return this;
}

/** Getter for {@link RadioIdentifier#radioNumber}*/
public short getRadioNumber()
{
    return radioNumber; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       dos.writeShort( (short)siteNumber);
       dos.writeShort( (short)applicationNumber);
       dos.writeShort( (short)referenceNumber);
       dos.writeShort( (short)radioNumber);
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
public int unmarshal(DataInputStream dis) throws Exception
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
        radioNumber = (short)dis.readUnsignedShort();
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
   buff.putShort( (short)radioNumber);
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
    radioNumber = (short)(buff.getShort() & 0xFFFF);
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final RadioIdentifier rhs = (RadioIdentifier)obj;

     if( ! (siteNumber == rhs.siteNumber)) ivarsEqual = false;
     if( ! (applicationNumber == rhs.applicationNumber)) ivarsEqual = false;
     if( ! (referenceNumber == rhs.referenceNumber)) ivarsEqual = false;
     if( ! (radioNumber == rhs.radioNumber)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" siteNumber: ").append(siteNumber).append("\n");
    sb.append(" applicationNumber: ").append(applicationNumber).append("\n");
    sb.append(" referenceNumber: ").append(referenceNumber).append("\n");
    sb.append(" radioNumber: ").append(radioNumber).append("\n");

   return sb.toString();
 }
} // end of class
