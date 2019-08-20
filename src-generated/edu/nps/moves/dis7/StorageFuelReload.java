/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * For each type or location of Storage Fuel, this record shall specify the type, location, fuel measure- ment units, reload quantity and maximum quantity for storage fuel either for the whole entity or a specific storage fuel location (tank). Section 6.2.85.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class StorageFuelReload extends Object implements Serializable
{
   /**  the standard quantity of this fuel type normally loaded at this station/launcher if a station/launcher is specified. If the Station/Launcher field is set to zero, then this is the total quantity of this fuel type that would be present in a standard reload of all appli- cable stations/launchers associated with this entity. */
   protected int  standardQuantity;

   /** the maximum quantity of this fuel type that this sta- tion/launcher is capable of holding when a station/launcher is specified. This would be the value used when a maximum reload was desired to be set for this station/launcher. If the Station/launcher field is set to zero, then this is the maximum quantity of this fuel type that would be present on this entity at all stations/launchers that can accept this fuel type. */
   protected int  maximumQuantity;

   /** the seconds normally required to reload the standard quantity of this fuel type at this specific station/launcher. When the Station/Launcher field is set to zero, this shall be the time it takes to perform a standard quantity reload of this fuel type at all applicable stations/launchers for this entity. */
   protected int  standardQuantityReloadTime;

   /** the seconds normally required to reload the maximum possible quantity of this fuel type at this station/launcher. When the Station/Launcher field is set to zero, this shall be the time it takes to perform a maximum quantity load/reload of this fuel type at all applicable stations/launchers for this entity. */
   protected int  maximumQuantityReloadTime;

   /** the fuel measurement units. Enumeration uid 328 */
   protected FuelMeasurementUnits fuelMeasurementUnits = FuelMeasurementUnits.values()[0];

   /** Fuel type uid 413 */
   protected SupplyFuelType fuelType = SupplyFuelType.values()[0];

   /** Location of fuel as related to entity. See section 14 of EBV document uid 329 */
   protected FuelLocation fuelLocation = FuelLocation.values()[0];

   /** padding */
   protected byte  padding = (byte)0;


/** Constructor */
 public StorageFuelReload()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // standardQuantity
   marshalSize += 4;  // maximumQuantity
   marshalSize += 4;  // standardQuantityReloadTime
   marshalSize += 4;  // maximumQuantityReloadTime
   marshalSize += fuelMeasurementUnits.getMarshalledSize();
   marshalSize += fuelType.getMarshalledSize();
   marshalSize += fuelLocation.getMarshalledSize();
   marshalSize += 1;  // padding

   return marshalSize;
}


/** Setter for {@link StorageFuelReload#standardQuantity}*/
public StorageFuelReload setStandardQuantity(int pStandardQuantity)
{
    standardQuantity = pStandardQuantity;
    return this;
}

/** Getter for {@link StorageFuelReload#standardQuantity}*/
public int getStandardQuantity()
{
    return standardQuantity; 
}

/** Setter for {@link StorageFuelReload#maximumQuantity}*/
public StorageFuelReload setMaximumQuantity(int pMaximumQuantity)
{
    maximumQuantity = pMaximumQuantity;
    return this;
}

/** Getter for {@link StorageFuelReload#maximumQuantity}*/
public int getMaximumQuantity()
{
    return maximumQuantity; 
}

/** Setter for {@link StorageFuelReload#standardQuantityReloadTime}*/
public StorageFuelReload setStandardQuantityReloadTime(int pStandardQuantityReloadTime)
{
    standardQuantityReloadTime = pStandardQuantityReloadTime;
    return this;
}

/** Getter for {@link StorageFuelReload#standardQuantityReloadTime}*/
public int getStandardQuantityReloadTime()
{
    return standardQuantityReloadTime; 
}

/** Setter for {@link StorageFuelReload#maximumQuantityReloadTime}*/
public StorageFuelReload setMaximumQuantityReloadTime(int pMaximumQuantityReloadTime)
{
    maximumQuantityReloadTime = pMaximumQuantityReloadTime;
    return this;
}

/** Getter for {@link StorageFuelReload#maximumQuantityReloadTime}*/
public int getMaximumQuantityReloadTime()
{
    return maximumQuantityReloadTime; 
}

/** Setter for {@link StorageFuelReload#fuelMeasurementUnits}*/
public StorageFuelReload setFuelMeasurementUnits(FuelMeasurementUnits pFuelMeasurementUnits)
{
    fuelMeasurementUnits = pFuelMeasurementUnits;
    return this;
}

/** Getter for {@link StorageFuelReload#fuelMeasurementUnits}*/
public FuelMeasurementUnits getFuelMeasurementUnits()
{
    return fuelMeasurementUnits; 
}

/** Setter for {@link StorageFuelReload#fuelType}*/
public StorageFuelReload setFuelType(SupplyFuelType pFuelType)
{
    fuelType = pFuelType;
    return this;
}

/** Getter for {@link StorageFuelReload#fuelType}*/
public SupplyFuelType getFuelType()
{
    return fuelType; 
}

/** Setter for {@link StorageFuelReload#fuelLocation}*/
public StorageFuelReload setFuelLocation(FuelLocation pFuelLocation)
{
    fuelLocation = pFuelLocation;
    return this;
}

/** Getter for {@link StorageFuelReload#fuelLocation}*/
public FuelLocation getFuelLocation()
{
    return fuelLocation; 
}

/** Setter for {@link StorageFuelReload#padding}*/
public StorageFuelReload setPadding(byte pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link StorageFuelReload#padding}*/
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
       fuelMeasurementUnits.marshal(dos);
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
 * @return marshalled size
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
   buff.putInt( (int)standardQuantity);
   buff.putInt( (int)maximumQuantity);
   buff.putInt( (int)standardQuantityReloadTime);
   buff.putInt( (int)maximumQuantityReloadTime);
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
    standardQuantity = buff.getInt();
    maximumQuantity = buff.getInt();
    standardQuantityReloadTime = buff.getInt();
    maximumQuantityReloadTime = buff.getInt();
    fuelMeasurementUnits = FuelMeasurementUnits.unmarshalEnum(buff);
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

    if(!(obj instanceof StorageFuelReload))
        return false;

     final StorageFuelReload rhs = (StorageFuelReload)obj;

     if( ! (standardQuantity == rhs.standardQuantity)) ivarsEqual = false;
     if( ! (maximumQuantity == rhs.maximumQuantity)) ivarsEqual = false;
     if( ! (standardQuantityReloadTime == rhs.standardQuantityReloadTime)) ivarsEqual = false;
     if( ! (maximumQuantityReloadTime == rhs.maximumQuantityReloadTime)) ivarsEqual = false;
     if( ! (fuelMeasurementUnits == rhs.fuelMeasurementUnits)) ivarsEqual = false;
     if( ! (fuelType == rhs.fuelType)) ivarsEqual = false;
     if( ! (fuelLocation == rhs.fuelLocation)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
