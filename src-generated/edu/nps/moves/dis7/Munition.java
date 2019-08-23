/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * An entity's munition (e.g., bomb, missile) information shall be represented by one or more Munition records. For each type or location of munition, this record shall specify the type, location, quantity and status of munitions that an entity contains. Section 6.2.60 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class Munition extends Object implements Serializable
{
   /**  This field shall identify the entity type of the munition. See section 6.2.30. */
   protected EntityType  munitionType = new EntityType(); 

   /** the station or launcher to which the munition is assigned. See Annex I */
   protected int  station;

   /** the quantity remaining of this munition. */
   protected short  quantity;

   /**  the status of the munition. It shall be represented by an 8-bit enumeration.  uid 327 */
   protected MunitionExpendableStatus munitionStatus = MunitionExpendableStatus.values()[0];

   /** padding  */
   protected byte  padding = (byte)0;


/** Constructor */
 public Munition()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += munitionType.getMarshalledSize();
   marshalSize += 4;  // station
   marshalSize += 2;  // quantity
   marshalSize += munitionStatus.getMarshalledSize();
   marshalSize += 1;  // padding

   return marshalSize;
}


/** Setter for {@link Munition#munitionType}*/
public Munition setMunitionType(EntityType pMunitionType)
{
    munitionType = pMunitionType;
    return this;
}

/** Getter for {@link Munition#munitionType}*/
public EntityType getMunitionType()
{
    return munitionType; 
}

/** Setter for {@link Munition#station}*/
public Munition setStation(int pStation)
{
    station = pStation;
    return this;
}

/** Getter for {@link Munition#station}*/
public int getStation()
{
    return station; 
}

/** Setter for {@link Munition#quantity}*/
public Munition setQuantity(short pQuantity)
{
    quantity = pQuantity;
    return this;
}

/** Getter for {@link Munition#quantity}*/
public short getQuantity()
{
    return quantity; 
}

/** Setter for {@link Munition#munitionStatus}*/
public Munition setMunitionStatus(MunitionExpendableStatus pMunitionStatus)
{
    munitionStatus = pMunitionStatus;
    return this;
}

/** Getter for {@link Munition#munitionStatus}*/
public MunitionExpendableStatus getMunitionStatus()
{
    return munitionStatus; 
}

/** Setter for {@link Munition#padding}*/
public Munition setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link Munition#padding}*/
public byte getPadding()
{
    return padding; 
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
       munitionType.marshal(dos);
       dos.writeInt( (int)station);
       dos.writeShort( (short)quantity);
       munitionStatus.marshal(dos);
       dos.writeByte( (byte)padding);
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
        uPosition += munitionType.unmarshal(dis);
        station = dis.readInt();
        uPosition += 4;
        quantity = (short)dis.readUnsignedShort();
        uPosition += 2;
        munitionStatus = MunitionExpendableStatus.unmarshalEnum(dis);
        uPosition += munitionStatus.getMarshalledSize();
        padding = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   munitionType.marshal(buff);
   buff.putInt( (int)station);
   buff.putShort( (short)quantity);
   munitionStatus.marshal(buff);
   buff.put( (byte)padding);
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
    munitionType.unmarshal(buff);
    station = buff.getInt();
    quantity = (short)(buff.getShort() & 0xFFFF);
    munitionStatus = MunitionExpendableStatus.unmarshalEnum(buff);
    padding = (byte)(buff.get() & 0xFF);
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

     final Munition rhs = (Munition)obj;

     if( ! (munitionType.equals( rhs.munitionType) )) ivarsEqual = false;
     if( ! (station == rhs.station)) ivarsEqual = false;
     if( ! (quantity == rhs.quantity)) ivarsEqual = false;
     if( ! (munitionStatus == rhs.munitionStatus)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
