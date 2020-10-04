/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * For each type or location of engine fuell, this record specifies the type, location, fuel measurement units, and reload quantity and maximum quantity. Section 6.2.25.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EngineFuelReload extends Object implements Serializable
{
   /** standard quantity of fuel loaded */
   protected int  standardQuantity;

   /** maximum quantity of fuel loaded */
   protected int  maximumQuantity;

   /** seconds normally required to to reload standard qty */
   protected int  standardQuantityReloadTime;

   /** seconds normally required to to reload maximum qty */
   protected int  maximumQuantityReloadTime;

   /** Units of measure uid 328 */
   protected FuelMeasurementUnits fuelMeasurmentUnits = FuelMeasurementUnits.values()[0];

   /**  uid 413 */
   protected SupplyFuelType fuelType = SupplyFuelType.values()[0];

   /** fuel  location as related to the entity uid 329 */
   protected FuelLocation fuelLocation = FuelLocation.values()[0];

   /** padding */
   protected byte  padding = (byte)0;


/** Constructor */
 public EngineFuelReload()
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

   marshalSize += 4;  // standardQuantity
   marshalSize += 4;  // maximumQuantity
   marshalSize += 4;  // standardQuantityReloadTime
   marshalSize += 4;  // maximumQuantityReloadTime
   marshalSize += fuelMeasurmentUnits.getMarshalledSize();
   marshalSize += fuelType.getMarshalledSize();
   marshalSize += fuelLocation.getMarshalledSize();
   marshalSize += 1;  // padding

   return marshalSize;
}


/** Setter for {@link EngineFuelReload#standardQuantity}
  * @param pStandardQuantity new value of interest
  * @return same object to permit progressive setters */
public EngineFuelReload setStandardQuantity(int pStandardQuantity)
{
    standardQuantity = pStandardQuantity;
    return this;
}

/** Getter for {@link EngineFuelReload#standardQuantity}
  * @return value of interest */
public int getStandardQuantity()
{
    return standardQuantity; 
}

/** Setter for {@link EngineFuelReload#maximumQuantity}
  * @param pMaximumQuantity new value of interest
  * @return same object to permit progressive setters */
public EngineFuelReload setMaximumQuantity(int pMaximumQuantity)
{
    maximumQuantity = pMaximumQuantity;
    return this;
}

/** Getter for {@link EngineFuelReload#maximumQuantity}
  * @return value of interest */
public int getMaximumQuantity()
{
    return maximumQuantity; 
}

/** Setter for {@link EngineFuelReload#standardQuantityReloadTime}
  * @param pStandardQuantityReloadTime new value of interest
  * @return same object to permit progressive setters */
public EngineFuelReload setStandardQuantityReloadTime(int pStandardQuantityReloadTime)
{
    standardQuantityReloadTime = pStandardQuantityReloadTime;
    return this;
}

/** Getter for {@link EngineFuelReload#standardQuantityReloadTime}
  * @return value of interest */
public int getStandardQuantityReloadTime()
{
    return standardQuantityReloadTime; 
}

/** Setter for {@link EngineFuelReload#maximumQuantityReloadTime}
  * @param pMaximumQuantityReloadTime new value of interest
  * @return same object to permit progressive setters */
public EngineFuelReload setMaximumQuantityReloadTime(int pMaximumQuantityReloadTime)
{
    maximumQuantityReloadTime = pMaximumQuantityReloadTime;
    return this;
}

/** Getter for {@link EngineFuelReload#maximumQuantityReloadTime}
  * @return value of interest */
public int getMaximumQuantityReloadTime()
{
    return maximumQuantityReloadTime; 
}

/** Setter for {@link EngineFuelReload#fuelMeasurmentUnits}
  * @param pFuelMeasurmentUnits new value of interest
  * @return same object to permit progressive setters */
public EngineFuelReload setFuelMeasurmentUnits(FuelMeasurementUnits pFuelMeasurmentUnits)
{
    fuelMeasurmentUnits = pFuelMeasurmentUnits;
    return this;
}

/** Getter for {@link EngineFuelReload#fuelMeasurmentUnits}
  * @return value of interest */
public FuelMeasurementUnits getFuelMeasurmentUnits()
{
    return fuelMeasurmentUnits; 
}

/** Setter for {@link EngineFuelReload#fuelType}
  * @param pFuelType new value of interest
  * @return same object to permit progressive setters */
public EngineFuelReload setFuelType(SupplyFuelType pFuelType)
{
    fuelType = pFuelType;
    return this;
}

/** Getter for {@link EngineFuelReload#fuelType}
  * @return value of interest */
public SupplyFuelType getFuelType()
{
    return fuelType; 
}

/** Setter for {@link EngineFuelReload#fuelLocation}
  * @param pFuelLocation new value of interest
  * @return same object to permit progressive setters */
public EngineFuelReload setFuelLocation(FuelLocation pFuelLocation)
{
    fuelLocation = pFuelLocation;
    return this;
}

/** Getter for {@link EngineFuelReload#fuelLocation}
  * @return value of interest */
public FuelLocation getFuelLocation()
{
    return fuelLocation; 
}

/** Setter for {@link EngineFuelReload#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public EngineFuelReload setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}
/** Utility setter for {@link EngineFuelReload#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public EngineFuelReload setPadding(int pPadding){
    padding = (byte) pPadding;
    return this;
}

/** Getter for {@link EngineFuelReload#padding}
  * @return value of interest */
public byte getPadding()
{
    return padding; 
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
       dos.writeInt(standardQuantity);
       dos.writeInt(maximumQuantity);
       dos.writeInt(standardQuantityReloadTime);
       dos.writeInt(maximumQuantityReloadTime);
       fuelMeasurmentUnits.marshal(dos);
       fuelType.marshal(dos);
       fuelLocation.marshal(dos);
       dos.writeByte(padding);
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
        standardQuantity = dis.readInt();
        uPosition += 4;
        maximumQuantity = dis.readInt();
        uPosition += 4;
        standardQuantityReloadTime = dis.readInt();
        uPosition += 4;
        maximumQuantityReloadTime = dis.readInt();
        uPosition += 4;
        fuelMeasurmentUnits = FuelMeasurementUnits.unmarshalEnum(dis);
        uPosition += fuelMeasurmentUnits.getMarshalledSize();
        fuelType = SupplyFuelType.unmarshalEnum(dis);
        uPosition += fuelType.getMarshalledSize();
        fuelLocation = FuelLocation.unmarshalEnum(dis);
        uPosition += fuelLocation.getMarshalledSize();
        padding = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   byteBuffer.putInt( (int)standardQuantity);
   byteBuffer.putInt( (int)maximumQuantity);
   byteBuffer.putInt( (int)standardQuantityReloadTime);
   byteBuffer.putInt( (int)maximumQuantityReloadTime);
   fuelMeasurmentUnits.marshal(byteBuffer);
   fuelType.marshal(byteBuffer);
   fuelLocation.marshal(byteBuffer);
   byteBuffer.put( (byte)padding);
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
    standardQuantity = byteBuffer.getInt();
    maximumQuantity = byteBuffer.getInt();
    standardQuantityReloadTime = byteBuffer.getInt();
    maximumQuantityReloadTime = byteBuffer.getInt();
    fuelMeasurmentUnits = FuelMeasurementUnits.unmarshalEnum(byteBuffer);
    fuelType = SupplyFuelType.unmarshalEnum(byteBuffer);
    fuelLocation = FuelLocation.unmarshalEnum(byteBuffer);
    padding = (byte)(byteBuffer.get() & 0xFF);
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

     final EngineFuelReload rhs = (EngineFuelReload)obj;

     if( ! (standardQuantity == rhs.standardQuantity)) ivarsEqual = false;
     if( ! (maximumQuantity == rhs.maximumQuantity)) ivarsEqual = false;
     if( ! (standardQuantityReloadTime == rhs.standardQuantityReloadTime)) ivarsEqual = false;
     if( ! (maximumQuantityReloadTime == rhs.maximumQuantityReloadTime)) ivarsEqual = false;
     if( ! (fuelMeasurmentUnits == rhs.fuelMeasurmentUnits)) ivarsEqual = false;
     if( ! (fuelType == rhs.fuelType)) ivarsEqual = false;
     if( ! (fuelLocation == rhs.fuelLocation)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" standardQuantity: ").append(standardQuantity).append("\n");
    sb.append(" maximumQuantity: ").append(maximumQuantity).append("\n");
    sb.append(" standardQuantityReloadTime: ").append(standardQuantityReloadTime).append("\n");
    sb.append(" maximumQuantityReloadTime: ").append(maximumQuantityReloadTime).append("\n");
    sb.append(" fuelMeasurmentUnits: ").append(fuelMeasurmentUnits).append("\n");
    sb.append(" fuelType: ").append(fuelType).append("\n");
    sb.append(" fuelLocation: ").append(fuelLocation).append("\n");
    sb.append(" padding: ").append(padding).append("\n");

   return sb.toString();
 }
} // end of class
