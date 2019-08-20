/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * An entity's expendable (chaff, flares, etc) information. Section 6.2.37
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class ExpendableReload extends Object implements Serializable
{
   /** Type of expendable */
   protected EntityType  expendable = new EntityType(); 

   protected int  station;

   protected short  standardQuantity;

   protected short  maximumQuantity;

   protected int  standardQuantityReloadTime;

   protected int  maximumQuantityReloadTime;


/** Constructor */
 public ExpendableReload()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += expendable.getMarshalledSize();
   marshalSize += 4;  // station
   marshalSize += 2;  // standardQuantity
   marshalSize += 2;  // maximumQuantity
   marshalSize += 4;  // standardQuantityReloadTime
   marshalSize += 4;  // maximumQuantityReloadTime

   return marshalSize;
}


/** Setter for {@link ExpendableReload#expendable}*/
public ExpendableReload setExpendable(EntityType pExpendable)
{
    expendable = pExpendable;
    return this;
}

/** Getter for {@link ExpendableReload#expendable}*/
public EntityType getExpendable()
{
    return expendable; 
}

/** Setter for {@link ExpendableReload#station}*/
public ExpendableReload setStation(int pStation)
{
    station = pStation;
    return this;
}

/** Getter for {@link ExpendableReload#station}*/
public int getStation()
{
    return station; 
}

/** Setter for {@link ExpendableReload#standardQuantity}*/
public ExpendableReload setStandardQuantity(short pStandardQuantity)
{
    standardQuantity = pStandardQuantity;
    return this;
}

/** Getter for {@link ExpendableReload#standardQuantity}*/
public short getStandardQuantity()
{
    return standardQuantity; 
}

/** Setter for {@link ExpendableReload#maximumQuantity}*/
public ExpendableReload setMaximumQuantity(short pMaximumQuantity)
{
    maximumQuantity = pMaximumQuantity;
    return this;
}

/** Getter for {@link ExpendableReload#maximumQuantity}*/
public short getMaximumQuantity()
{
    return maximumQuantity; 
}

/** Setter for {@link ExpendableReload#standardQuantityReloadTime}*/
public ExpendableReload setStandardQuantityReloadTime(int pStandardQuantityReloadTime)
{
    standardQuantityReloadTime = pStandardQuantityReloadTime;
    return this;
}

/** Getter for {@link ExpendableReload#standardQuantityReloadTime}*/
public int getStandardQuantityReloadTime()
{
    return standardQuantityReloadTime; 
}

/** Setter for {@link ExpendableReload#maximumQuantityReloadTime}*/
public ExpendableReload setMaximumQuantityReloadTime(int pMaximumQuantityReloadTime)
{
    maximumQuantityReloadTime = pMaximumQuantityReloadTime;
    return this;
}

/** Getter for {@link ExpendableReload#maximumQuantityReloadTime}*/
public int getMaximumQuantityReloadTime()
{
    return maximumQuantityReloadTime; 
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
       dos.writeShort( (short)standardQuantity);
       dos.writeShort( (short)maximumQuantity);
       dos.writeInt( (int)standardQuantityReloadTime);
       dos.writeInt( (int)maximumQuantityReloadTime);
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
        standardQuantity = (short)dis.readUnsignedShort();
        uPosition += 2;
        maximumQuantity = (short)dis.readUnsignedShort();
        uPosition += 2;
        standardQuantityReloadTime = dis.readInt();
        uPosition += 4;
        maximumQuantityReloadTime = dis.readInt();
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
   expendable.marshal(buff);
   buff.putInt( (int)station);
   buff.putShort( (short)standardQuantity);
   buff.putShort( (short)maximumQuantity);
   buff.putInt( (int)standardQuantityReloadTime);
   buff.putInt( (int)maximumQuantityReloadTime);
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
    standardQuantity = (short)(buff.getShort() & 0xFFFF);
    maximumQuantity = (short)(buff.getShort() & 0xFFFF);
    standardQuantityReloadTime = buff.getInt();
    maximumQuantityReloadTime = buff.getInt();
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

    if(!(obj instanceof ExpendableReload))
        return false;

     final ExpendableReload rhs = (ExpendableReload)obj;

     if( ! (expendable.equals( rhs.expendable) )) ivarsEqual = false;
     if( ! (station == rhs.station)) ivarsEqual = false;
     if( ! (standardQuantity == rhs.standardQuantity)) ivarsEqual = false;
     if( ! (maximumQuantity == rhs.maximumQuantity)) ivarsEqual = false;
     if( ! (standardQuantityReloadTime == rhs.standardQuantityReloadTime)) ivarsEqual = false;
     if( ! (maximumQuantityReloadTime == rhs.maximumQuantityReloadTime)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
