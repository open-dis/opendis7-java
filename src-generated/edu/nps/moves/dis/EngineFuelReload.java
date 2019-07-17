package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * For each type or location of engine fuell, this record specifies the type, location, fuel measurement units, and reload quantity and maximum quantity. Section 6.2.25.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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


public EngineFuelReload setStandardQuantity(int pStandardQuantity)
{
    standardQuantity = pStandardQuantity;
    return this;
}

public int getStandardQuantity()
{
    return standardQuantity; 
}

public EngineFuelReload setMaximumQuantity(int pMaximumQuantity)
{
    maximumQuantity = pMaximumQuantity;
    return this;
}

public int getMaximumQuantity()
{
    return maximumQuantity; 
}

public EngineFuelReload setStandardQuantityReloadTime(int pStandardQuantityReloadTime)
{
    standardQuantityReloadTime = pStandardQuantityReloadTime;
    return this;
}

public int getStandardQuantityReloadTime()
{
    return standardQuantityReloadTime; 
}

public EngineFuelReload setMaximumQuantityReloadTime(int pMaximumQuantityReloadTime)
{
    maximumQuantityReloadTime = pMaximumQuantityReloadTime;
    return this;
}

public int getMaximumQuantityReloadTime()
{
    return maximumQuantityReloadTime; 
}

public EngineFuelReload setFuelMeasurmentUnits(FuelMeasurementUnits pFuelMeasurmentUnits)
{
    fuelMeasurmentUnits = pFuelMeasurmentUnits;
    return this;
}

public FuelMeasurementUnits getFuelMeasurmentUnits()
{
    return fuelMeasurmentUnits; 
}

public EngineFuelReload setFuelType(SupplyFuelType pFuelType)
{
    fuelType = pFuelType;
    return this;
}

public SupplyFuelType getFuelType()
{
    return fuelType; 
}

public EngineFuelReload setFuelLocation(FuelLocation pFuelLocation)
{
    fuelLocation = pFuelLocation;
    return this;
}

public FuelLocation getFuelLocation()
{
    return fuelLocation; 
}

public EngineFuelReload setPadding(byte pPadding)
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
       dos.writeInt( (int)standardQuantity);
       dos.writeInt( (int)maximumQuantity);
       dos.writeInt( (int)standardQuantityReloadTime);
       dos.writeInt( (int)maximumQuantityReloadTime);
       fuelMeasurmentUnits.marshal(dos);
       fuelType.marshal(dos);
       fuelLocation.marshal(dos);
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
 */
public int unmarshal(DataInputStream dis)
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
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.putInt( (int)standardQuantity);
   buff.putInt( (int)maximumQuantity);
   buff.putInt( (int)standardQuantityReloadTime);
   buff.putInt( (int)maximumQuantityReloadTime);
   fuelMeasurmentUnits.marshal(buff);
   fuelType.marshal(buff);
   fuelLocation.marshal(buff);
   buff.put( (byte)padding);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    standardQuantity = buff.getInt();
    maximumQuantity = buff.getInt();
    standardQuantityReloadTime = buff.getInt();
    maximumQuantityReloadTime = buff.getInt();
    fuelMeasurmentUnits = FuelMeasurementUnits.unmarshalEnum(buff);
    fuelType = SupplyFuelType.unmarshalEnum(buff);
    fuelLocation = FuelLocation.unmarshalEnum(buff);
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

    if(!(obj instanceof EngineFuelReload))
        return false;

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
} // end of class
