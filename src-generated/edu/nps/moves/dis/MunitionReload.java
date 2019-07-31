/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * indicate weapons (munitions) previously communicated via the Munition record. Section 6.2.61 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class MunitionReload extends Object implements Serializable
{
   /**  This field shall identify the entity type of the munition. See section 6.2.30. */
   protected EntityType  munitionType = new EntityType(); 

   /** the station or launcher to which the munition is assigned. See Annex I */
   protected int  station;

   /** the standard quantity of this munition type normally loaded at this station/launcher if a station/launcher is specified. */
   protected short  standardQuantity;

   /** the maximum quantity of this munition type that this station/launcher is capable of holding when a station/launcher is specified  */
   protected short  maximumQuantity;

   /** numer of seconds of sim time required to reload the std qty */
   protected int  standardQuantityReloadTime;

   /** the number of seconds of sim time required to reload the max possible quantity */
   protected int  maximumQuantityReloadTime;


/** Constructor */
 public MunitionReload()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += munitionType.getMarshalledSize();
   marshalSize += 4;  // station
   marshalSize += 2;  // standardQuantity
   marshalSize += 2;  // maximumQuantity
   marshalSize += 4;  // standardQuantityReloadTime
   marshalSize += 4;  // maximumQuantityReloadTime

   return marshalSize;
}


public MunitionReload setMunitionType(EntityType pMunitionType)
{
    munitionType = pMunitionType;
    return this;
}

public EntityType getMunitionType()
{
    return munitionType; 
}

public MunitionReload setStation(int pStation)
{
    station = pStation;
    return this;
}

public int getStation()
{
    return station; 
}

public MunitionReload setStandardQuantity(short pStandardQuantity)
{
    standardQuantity = pStandardQuantity;
    return this;
}

public short getStandardQuantity()
{
    return standardQuantity; 
}

public MunitionReload setMaximumQuantity(short pMaximumQuantity)
{
    maximumQuantity = pMaximumQuantity;
    return this;
}

public short getMaximumQuantity()
{
    return maximumQuantity; 
}

public MunitionReload setStandardQuantityReloadTime(int pStandardQuantityReloadTime)
{
    standardQuantityReloadTime = pStandardQuantityReloadTime;
    return this;
}

public int getStandardQuantityReloadTime()
{
    return standardQuantityReloadTime; 
}

public MunitionReload setMaximumQuantityReloadTime(int pMaximumQuantityReloadTime)
{
    maximumQuantityReloadTime = pMaximumQuantityReloadTime;
    return this;
}

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
       munitionType.marshal(dos);
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
        uPosition += munitionType.unmarshal(dis);
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
   munitionType.marshal(buff);
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
    munitionType.unmarshal(buff);
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

    if(!(obj instanceof MunitionReload))
        return false;

     final MunitionReload rhs = (MunitionReload)obj;

     if( ! (munitionType.equals( rhs.munitionType) )) ivarsEqual = false;
     if( ! (station == rhs.station)) ivarsEqual = false;
     if( ! (standardQuantity == rhs.standardQuantity)) ivarsEqual = false;
     if( ! (maximumQuantity == rhs.maximumQuantity)) ivarsEqual = false;
     if( ! (standardQuantityReloadTime == rhs.standardQuantityReloadTime)) ivarsEqual = false;
     if( ! (maximumQuantityReloadTime == rhs.maximumQuantityReloadTime)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
