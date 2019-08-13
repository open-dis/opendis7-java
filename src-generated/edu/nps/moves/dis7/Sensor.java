/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * An entity's sensor information.  Section 6.2.77.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class Sensor extends Object implements Serializable
{
   /**  the source of the Sensor Type field  uid 414 */
   protected SensorTypeSource sensorTypeSource = SensorTypeSource.values()[0];

   /** the on/off status of the sensor uid 331 */
   protected SensorOnOffStatus sensorOnOffStatus = SensorOnOffStatus.values()[0];

   /** for Source 'other':SensorRecordOtherActiveSensors/325,'em':EmitterName/75,'passive':SensorRecordSensorTypePassiveSensors/326,'mine':6.2.57,'ua':UAAcousticSystemName/144,'lasers':DesignatorSystemName/80 */
   protected short  sensorType;

   /**  the station to which the sensor is assigned. A zero value shall indi- cate that this Sensor record is not associated with any particular station and represents the total quan- tity of this sensor for this entity. If this field is non-zero, it shall either reference an attached part or an articulated part */
   protected int  station;

   /** quantity of the sensor  */
   protected short  quantity;

   /** padding */
   protected short  padding = (short)0;


/** Constructor */
 public Sensor()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += sensorTypeSource.getMarshalledSize();
   marshalSize += sensorOnOffStatus.getMarshalledSize();
   marshalSize += 2;  // sensorType
   marshalSize += 4;  // station
   marshalSize += 2;  // quantity
   marshalSize += 2;  // padding

   return marshalSize;
}


public Sensor setSensorTypeSource(SensorTypeSource pSensorTypeSource)
{
    sensorTypeSource = pSensorTypeSource;
    return this;
}

public SensorTypeSource getSensorTypeSource()
{
    return sensorTypeSource; 
}

public Sensor setSensorOnOffStatus(SensorOnOffStatus pSensorOnOffStatus)
{
    sensorOnOffStatus = pSensorOnOffStatus;
    return this;
}

public SensorOnOffStatus getSensorOnOffStatus()
{
    return sensorOnOffStatus; 
}

public Sensor setSensorType(short pSensorType)
{
    sensorType = pSensorType;
    return this;
}

public short getSensorType()
{
    return sensorType; 
}

public Sensor setStation(int pStation)
{
    station = pStation;
    return this;
}

public int getStation()
{
    return station; 
}

public Sensor setQuantity(short pQuantity)
{
    quantity = pQuantity;
    return this;
}

public short getQuantity()
{
    return quantity; 
}

public Sensor setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

public short getPadding()
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
       sensorTypeSource.marshal(dos);
       sensorOnOffStatus.marshal(dos);
       dos.writeShort( (short)sensorType);
       dos.writeInt( (int)station);
       dos.writeShort( (short)quantity);
       dos.writeShort( (short)padding);
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
        sensorTypeSource = SensorTypeSource.unmarshalEnum(dis);
        uPosition += sensorTypeSource.getMarshalledSize();
        sensorOnOffStatus = SensorOnOffStatus.unmarshalEnum(dis);
        uPosition += sensorOnOffStatus.getMarshalledSize();
        sensorType = (short)dis.readUnsignedShort();
        uPosition += 2;
        station = dis.readInt();
        uPosition += 4;
        quantity = (short)dis.readUnsignedShort();
        uPosition += 2;
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   sensorTypeSource.marshal(buff);
   sensorOnOffStatus.marshal(buff);
   buff.putShort( (short)sensorType);
   buff.putInt( (int)station);
   buff.putShort( (short)quantity);
   buff.putShort( (short)padding);
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
    sensorTypeSource = SensorTypeSource.unmarshalEnum(buff);
    sensorOnOffStatus = SensorOnOffStatus.unmarshalEnum(buff);
    sensorType = (short)(buff.getShort() & 0xFFFF);
    station = buff.getInt();
    quantity = (short)(buff.getShort() & 0xFFFF);
    padding = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof Sensor))
        return false;

     final Sensor rhs = (Sensor)obj;

     if( ! (sensorTypeSource == rhs.sensorTypeSource)) ivarsEqual = false;
     if( ! (sensorOnOffStatus == rhs.sensorOnOffStatus)) ivarsEqual = false;
     if( ! (sensorType == rhs.sensorType)) ivarsEqual = false;
     if( ! (station == rhs.station)) ivarsEqual = false;
     if( ! (quantity == rhs.quantity)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
