/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * An entity's expendable (chaff, flares, etc) information. Section 6.2.36
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class Expendable extends Object implements Serializable
{
   /** Type of expendable */
   protected EntityType  expendable = new EntityType(); 

   protected int  station;

   protected short  quantity;

   /**  uid 327 */
   protected MunitionExpendableStatus expendableStatus = MunitionExpendableStatus.values()[0];

   protected byte  padding = (byte)0;


/** Constructor */
 public Expendable()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += expendable.getMarshalledSize();
   marshalSize += 4;  // station
   marshalSize += 2;  // quantity
   marshalSize += expendableStatus.getMarshalledSize();
   marshalSize += 1;  // padding

   return marshalSize;
}


public Expendable setExpendable(EntityType pExpendable)
{
    expendable = pExpendable;
    return this;
}

public EntityType getExpendable()
{
    return expendable; 
}

public Expendable setStation(int pStation)
{
    station = pStation;
    return this;
}

public int getStation()
{
    return station; 
}

public Expendable setQuantity(short pQuantity)
{
    quantity = pQuantity;
    return this;
}

public short getQuantity()
{
    return quantity; 
}

public Expendable setExpendableStatus(MunitionExpendableStatus pExpendableStatus)
{
    expendableStatus = pExpendableStatus;
    return this;
}

public MunitionExpendableStatus getExpendableStatus()
{
    return expendableStatus; 
}

public Expendable setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

public byte getPadding()
{
    return padding; 
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
       expendable.marshal(dos);
       dos.writeInt( (int)station);
       dos.writeShort( (short)quantity);
       expendableStatus.marshal(dos);
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
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    try 
    {
        uPosition += expendable.unmarshal(dis);
        station = dis.readInt();
        uPosition += 4;
        quantity = (short)dis.readUnsignedShort();
        uPosition += 2;
        expendableStatus = MunitionExpendableStatus.unmarshalEnum(dis);
        uPosition += expendableStatus.getMarshalledSize();
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
   expendable.marshal(buff);
   buff.putInt( (int)station);
   buff.putShort( (short)quantity);
   expendableStatus.marshal(buff);
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
    expendable.unmarshal(buff);
    station = buff.getInt();
    quantity = (short)(buff.getShort() & 0xFFFF);
    expendableStatus = MunitionExpendableStatus.unmarshalEnum(buff);
    padding = (byte)(buff.get() & 0xFF);
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

    if(!(obj instanceof Expendable))
        return false;

     final Expendable rhs = (Expendable)obj;

     if( ! (expendable.equals( rhs.expendable) )) ivarsEqual = false;
     if( ! (station == rhs.station)) ivarsEqual = false;
     if( ! (quantity == rhs.quantity)) ivarsEqual = false;
     if( ! (expendableStatus == rhs.expendableStatus)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
