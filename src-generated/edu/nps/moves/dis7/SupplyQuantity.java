/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  A supply, and the amount of that supply. Section 6.2.86
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class SupplyQuantity extends Object implements Serializable
{
   /** Type of supply */
   protected EntityType  supplyType = new EntityType(); 

   /** the number of units of a supply type.  */
   protected float  quantity;


/** Constructor */
 public SupplyQuantity()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += supplyType.getMarshalledSize();
   marshalSize += 4;  // quantity

   return marshalSize;
}


/** Setter for {@link SupplyQuantity#supplyType}*/
public SupplyQuantity setSupplyType(EntityType pSupplyType)
{
    supplyType = pSupplyType;
    return this;
}

/** Getter for {@link SupplyQuantity#supplyType}*/
public EntityType getSupplyType()
{
    return supplyType; 
}

/** Setter for {@link SupplyQuantity#quantity}*/
public SupplyQuantity setQuantity(float pQuantity)
{
    quantity = pQuantity;
    return this;
}

/** Getter for {@link SupplyQuantity#quantity}*/
public float getQuantity()
{
    return quantity; 
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
       supplyType.marshal(dos);
       dos.writeFloat( (float)quantity);
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
        uPosition += supplyType.unmarshal(dis);
        quantity = dis.readFloat();
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
   supplyType.marshal(buff);
   buff.putFloat( (float)quantity);
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
    supplyType.unmarshal(buff);
    quantity = buff.getFloat();
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

     final SupplyQuantity rhs = (SupplyQuantity)obj;

     if( ! (supplyType.equals( rhs.supplyType) )) ivarsEqual = false;
     if( ! (quantity == rhs.quantity)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
