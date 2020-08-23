/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.5.8 Used to communicate the canceling of a resupply service provided through logistics support.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class ResupplyCancelPdu extends LogisticsFamilyPdu implements Serializable
{
   /** Requesting entity, Section 7.4.5 */
   protected EntityID  receivingEntityID = new EntityID(); 

   /** Supplying entity, Section 7.4.5 */
   protected EntityID  supplyingEntityID = new EntityID(); 


/** Constructor */
 public ResupplyCancelPdu()
 {
    setPduType( DISPDUType.RESUPPLY_CANCEL );
 }

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += receivingEntityID.getMarshalledSize();
   marshalSize += supplyingEntityID.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link ResupplyCancelPdu#receivingEntityID}*/
public ResupplyCancelPdu setReceivingEntityID(EntityID pReceivingEntityID)
{
    receivingEntityID = pReceivingEntityID;
    return this;
}

/** Getter for {@link ResupplyCancelPdu#receivingEntityID}*/
public EntityID getReceivingEntityID()
{
    return receivingEntityID; 
}

/** Setter for {@link ResupplyCancelPdu#supplyingEntityID}*/
public ResupplyCancelPdu setSupplyingEntityID(EntityID pSupplyingEntityID)
{
    supplyingEntityID = pSupplyingEntityID;
    return this;
}

/** Getter for {@link ResupplyCancelPdu#supplyingEntityID}*/
public EntityID getSupplyingEntityID()
{
    return supplyingEntityID; 
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
       receivingEntityID.marshal(dos);
       supplyingEntityID.marshal(dos);
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
        uPosition += receivingEntityID.unmarshal(dis);
        uPosition += supplyingEntityID.unmarshal(dis);
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
   receivingEntityID.marshal(buff);
   supplyingEntityID.marshal(buff);
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

    receivingEntityID.unmarshal(buff);
    supplyingEntityID.unmarshal(buff);
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

     final ResupplyCancelPdu rhs = (ResupplyCancelPdu)obj;

     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;
     if( ! (supplyingEntityID.equals( rhs.supplyingEntityID) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" receivingEntityID: ").append(receivingEntityID).append("\n");
    sb.append(" supplyingEntityID: ").append(supplyingEntityID).append("\n");

   return sb.toString();
 }
} // end of class
