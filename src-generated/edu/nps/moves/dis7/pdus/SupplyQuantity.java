/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  A supply, and the amount of that supply. Section 6.2.86
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class SupplyQuantity extends Object implements Serializable
{
   /** Type of supply */
   protected EntityType  supplyType = new EntityType(); 

   /** The number of units of a supply type.  */
   protected float  quantity;


/** Constructor */
 public SupplyQuantity()
 {
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += supplyType.getMarshalledSize();
   marshalSize += 4;  // quantity

   return marshalSize;
}


/** Setter for {@link SupplyQuantity#supplyType}
  * @param pSupplyType new value of interest
  * @return same object to permit progressive setters */
public SupplyQuantity setSupplyType(EntityType pSupplyType)
{
    supplyType = pSupplyType;
    return this;
}

/** Getter for {@link SupplyQuantity#supplyType}
  * @return value of interest */
public EntityType getSupplyType()
{
    return supplyType; 
}

/** Setter for {@link SupplyQuantity#quantity}
  * @param pQuantity new value of interest
  * @return same object to permit progressive setters */
public SupplyQuantity setQuantity(float pQuantity)
{
    quantity = pQuantity;
    return this;
}

/** Getter for {@link SupplyQuantity#quantity}
  * @return value of interest */
public float getQuantity()
{
    return quantity; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       supplyType.marshal(dos);
       dos.writeFloat(quantity);
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
    try 
    {
        uPosition += supplyType.unmarshal(dis);
        quantity = dis.readFloat();
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
   supplyType.marshal(byteBuffer);
   byteBuffer.putFloat( (float)quantity);
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
    supplyType.unmarshal(byteBuffer);
    quantity = byteBuffer.getFloat();
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

     final SupplyQuantity rhs = (SupplyQuantity)obj;

     if( ! (supplyType.equals( rhs.supplyType) )) ivarsEqual = false;
     if( ! (quantity == rhs.quantity)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" supplyType: ").append(supplyType).append("\n");
    sb.append(" quantity: ").append(quantity).append("\n");

   return sb.toString();
 }
} // end of class
