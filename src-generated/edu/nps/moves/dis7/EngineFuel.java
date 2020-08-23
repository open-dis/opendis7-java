/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Information about an entity's engine fuel. Section 6.2.24.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EngineFuel extends Object implements Serializable
{
   /** Fuel quantity, units specified by next field */
   protected int  fuelQuantity;

   /** Units in which the fuel is measured uid 328 */
   protected FuelMeasurementUnits fuelMeasurementUnits = FuelMeasurementUnits.values()[0];

   /** Type of fuel uid 413 */
   protected SupplyFuelType fuelType = SupplyFuelType.values()[0];

   /** Location of fuel as related to entity. See section 14 of EBV document uid 329 */
   protected FuelLocation fuelLocation = FuelLocation.values()[0];

   /** padding */
   protected byte  padding = (byte)0;


/** Constructor */
 public EngineFuel()
 {
 }

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // fuelQuantity
   marshalSize += fuelMeasurementUnits.getMarshalledSize();
   marshalSize += fuelType.getMarshalledSize();
   marshalSize += fuelLocation.getMarshalledSize();
   marshalSize += 1;  // padding

   return marshalSize;
}


/** Setter for {@link EngineFuel#fuelQuantity}*/
public EngineFuel setFuelQuantity(int pFuelQuantity)
{
    fuelQuantity = pFuelQuantity;
    return this;
}

/** Getter for {@link EngineFuel#fuelQuantity}*/
public int getFuelQuantity()
{
    return fuelQuantity; 
}

/** Setter for {@link EngineFuel#fuelMeasurementUnits}*/
public EngineFuel setFuelMeasurementUnits(FuelMeasurementUnits pFuelMeasurementUnits)
{
    fuelMeasurementUnits = pFuelMeasurementUnits;
    return this;
}

/** Getter for {@link EngineFuel#fuelMeasurementUnits}*/
public FuelMeasurementUnits getFuelMeasurementUnits()
{
    return fuelMeasurementUnits; 
}

/** Setter for {@link EngineFuel#fuelType}*/
public EngineFuel setFuelType(SupplyFuelType pFuelType)
{
    fuelType = pFuelType;
    return this;
}

/** Getter for {@link EngineFuel#fuelType}*/
public SupplyFuelType getFuelType()
{
    return fuelType; 
}

/** Setter for {@link EngineFuel#fuelLocation}*/
public EngineFuel setFuelLocation(FuelLocation pFuelLocation)
{
    fuelLocation = pFuelLocation;
    return this;
}

/** Getter for {@link EngineFuel#fuelLocation}*/
public FuelLocation getFuelLocation()
{
    return fuelLocation; 
}

/** Setter for {@link EngineFuel#padding}*/
public EngineFuel setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link EngineFuel#padding}*/
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
       dos.writeInt(fuelQuantity);
       fuelMeasurementUnits.marshal(dos);
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
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        fuelQuantity = dis.readInt();
        uPosition += 4;
        fuelMeasurementUnits = FuelMeasurementUnits.unmarshalEnum(dis);
        uPosition += fuelMeasurementUnits.getMarshalledSize();
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
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.putInt( (int)fuelQuantity);
   fuelMeasurementUnits.marshal(buff);
   fuelType.marshal(buff);
   fuelLocation.marshal(buff);
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
    fuelQuantity = buff.getInt();
    fuelMeasurementUnits = FuelMeasurementUnits.unmarshalEnum(buff);
    fuelType = SupplyFuelType.unmarshalEnum(buff);
    fuelLocation = FuelLocation.unmarshalEnum(buff);
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

     final EngineFuel rhs = (EngineFuel)obj;

     if( ! (fuelQuantity == rhs.fuelQuantity)) ivarsEqual = false;
     if( ! (fuelMeasurementUnits == rhs.fuelMeasurementUnits)) ivarsEqual = false;
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

    sb.append(" fuelQuantity: ").append(fuelQuantity).append("\n");
    sb.append(" fuelMeasurementUnits: ").append(fuelMeasurementUnits).append("\n");
    sb.append(" fuelType: ").append(fuelType).append("\n");
    sb.append(" fuelLocation: ").append(fuelLocation).append("\n");
    sb.append(" padding: ").append(padding).append("\n");

   return sb.toString();
 }
} // end of class
