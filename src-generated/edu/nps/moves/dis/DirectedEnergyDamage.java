package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Damage sustained by an entity due to directed energy. Location of the damage based on a relative x,y,z location from the center of the entity. Section 6.2.15.2
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class DirectedEnergyDamage extends Object implements Serializable
{
   /** DE Record Type. */
   protected int  recordType = (int)4500;

   /** DE Record Length (bytes) */
   protected short  recordLength = (short)40;

   /** padding */
   protected short  padding = (short)0;

   /** location of damage, relative to center of entity */
   protected Vector3Float  damageLocation = new Vector3Float(); 

   /** Size of damaged area, in meters */
   protected float  damageDiameter;

   /** average temp of the damaged area, in degrees celsius. If firing entitty does not model this, use a value of -273.15 */
   protected float  temperature = (float)-273.15;

   /** enumeration uid 314 */
   protected EntityDamageStatusComponentIdentification componentIdentification = EntityDamageStatusComponentIdentification.values()[0];

   /** enumeration uid 315 */
   protected DEDamageDescriptionComponentDamageStatus componentDamageStatus = DEDamageDescriptionComponentDamageStatus.values()[0];

   /** enumeration uid 317 */
   protected DEDamageDescriptionComponentVisualDamageStatus componentVisualDamageStatus = new DEDamageDescriptionComponentVisualDamageStatus();

   /** enumeration uid 316 */
   protected DEDamageDescriptionComponentVisualSmokeColor componentVisualSmokeColor = DEDamageDescriptionComponentVisualSmokeColor.values()[0];

   /** For any component damage resulting this field shall be set to the fire event ID from that PDU. */
   protected EventIdentifier  fireEventID = new EventIdentifier(); 

   /** padding */
   protected short  padding2 = (short)0;


/** Constructor */
 public DirectedEnergyDamage()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // recordType
   marshalSize += 2;  // recordLength
   marshalSize += 2;  // padding
   marshalSize += damageLocation.getMarshalledSize();
   marshalSize += 4;  // damageDiameter
   marshalSize += 4;  // temperature
   marshalSize += componentIdentification.getMarshalledSize();
   marshalSize += componentDamageStatus.getMarshalledSize();
   marshalSize += componentVisualSmokeColor.getMarshalledSize();
   marshalSize += fireEventID.getMarshalledSize();
   marshalSize += 2;  // padding2

   return marshalSize;
}


public DirectedEnergyDamage setRecordType(int pRecordType)
{
    recordType = pRecordType;
    return this;
}

public int getRecordType()
{
    return recordType; 
}

public DirectedEnergyDamage setRecordLength(short pRecordLength)
{
    recordLength = pRecordLength;
    return this;
}

public short getRecordLength()
{
    return recordLength; 
}

public DirectedEnergyDamage setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

public short getPadding()
{
    return padding; 
}

public DirectedEnergyDamage setDamageLocation(Vector3Float pDamageLocation)
{
    damageLocation = pDamageLocation;
    return this;
}

public Vector3Float getDamageLocation()
{
    return damageLocation; 
}

public DirectedEnergyDamage setDamageDiameter(float pDamageDiameter)
{
    damageDiameter = pDamageDiameter;
    return this;
}

public float getDamageDiameter()
{
    return damageDiameter; 
}

public DirectedEnergyDamage setTemperature(float pTemperature)
{
    temperature = pTemperature;
    return this;
}

public float getTemperature()
{
    return temperature; 
}

public DirectedEnergyDamage setComponentIdentification(EntityDamageStatusComponentIdentification pComponentIdentification)
{
    componentIdentification = pComponentIdentification;
    return this;
}

public EntityDamageStatusComponentIdentification getComponentIdentification()
{
    return componentIdentification; 
}

public DirectedEnergyDamage setComponentDamageStatus(DEDamageDescriptionComponentDamageStatus pComponentDamageStatus)
{
    componentDamageStatus = pComponentDamageStatus;
    return this;
}

public DEDamageDescriptionComponentDamageStatus getComponentDamageStatus()
{
    return componentDamageStatus; 
}

public DirectedEnergyDamage setComponentVisualDamageStatus(DEDamageDescriptionComponentVisualDamageStatus pComponentVisualDamageStatus)
{
    componentVisualDamageStatus = pComponentVisualDamageStatus;
    return this;
}

public DEDamageDescriptionComponentVisualDamageStatus getComponentVisualDamageStatus()
{
    return componentVisualDamageStatus; 
}

public DirectedEnergyDamage setComponentVisualSmokeColor(DEDamageDescriptionComponentVisualSmokeColor pComponentVisualSmokeColor)
{
    componentVisualSmokeColor = pComponentVisualSmokeColor;
    return this;
}

public DEDamageDescriptionComponentVisualSmokeColor getComponentVisualSmokeColor()
{
    return componentVisualSmokeColor; 
}

public DirectedEnergyDamage setFireEventID(EventIdentifier pFireEventID)
{
    fireEventID = pFireEventID;
    return this;
}

public EventIdentifier getFireEventID()
{
    return fireEventID; 
}

public DirectedEnergyDamage setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

public short getPadding2()
{
    return padding2; 
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
       dos.writeInt( (int)recordType);
       dos.writeShort( (short)recordLength);
       dos.writeShort( (short)padding);
       damageLocation.marshal(dos);
       dos.writeFloat( (float)damageDiameter);
       dos.writeFloat( (float)temperature);
       componentIdentification.marshal(dos);
       componentDamageStatus.marshal(dos);
       componentVisualDamageStatus.marshal(dos);
       componentVisualSmokeColor.marshal(dos);
       fireEventID.marshal(dos);
       dos.writeShort( (short)padding2);
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
        recordType = dis.readInt();
        uPosition += 4;
        recordLength = (short)dis.readUnsignedShort();
        uPosition += 2;
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += damageLocation.unmarshal(dis);
        damageDiameter = dis.readFloat();
        uPosition += 4;
        temperature = dis.readFloat();
        uPosition += 4;
        componentIdentification = EntityDamageStatusComponentIdentification.unmarshalEnum(dis);
        uPosition += componentIdentification.getMarshalledSize();
        componentDamageStatus = DEDamageDescriptionComponentDamageStatus.unmarshalEnum(dis);
        uPosition += componentDamageStatus.getMarshalledSize();
        uPosition += componentVisualDamageStatus.unmarshal(dis);
        componentVisualSmokeColor = DEDamageDescriptionComponentVisualSmokeColor.unmarshalEnum(dis);
        uPosition += componentVisualSmokeColor.getMarshalledSize();
        uPosition += fireEventID.unmarshal(dis);
        padding2 = (short)dis.readUnsignedShort();
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
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.putInt( (int)recordType);
   buff.putShort( (short)recordLength);
   buff.putShort( (short)padding);
   damageLocation.marshal(buff);
   buff.putFloat( (float)damageDiameter);
   buff.putFloat( (float)temperature);
   componentIdentification.marshal(buff);
   componentDamageStatus.marshal(buff);
   componentVisualDamageStatus.marshal(buff);
   componentVisualSmokeColor.marshal(buff);
   fireEventID.marshal(buff);
   buff.putShort( (short)padding2);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    recordType = buff.getInt();
    recordLength = (short)(buff.getShort() & 0xFFFF);
    padding = (short)(buff.getShort() & 0xFFFF);
    damageLocation.unmarshal(buff);
    damageDiameter = buff.getFloat();
    temperature = buff.getFloat();
    componentIdentification = EntityDamageStatusComponentIdentification.unmarshalEnum(buff);
    componentDamageStatus = DEDamageDescriptionComponentDamageStatus.unmarshalEnum(buff);
    componentVisualDamageStatus.unmarshal(buff);
    componentVisualSmokeColor = DEDamageDescriptionComponentVisualSmokeColor.unmarshalEnum(buff);
    fireEventID.unmarshal(buff);
    padding2 = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof DirectedEnergyDamage))
        return false;

     final DirectedEnergyDamage rhs = (DirectedEnergyDamage)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (recordLength == rhs.recordLength)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (damageLocation.equals( rhs.damageLocation) )) ivarsEqual = false;
     if( ! (damageDiameter == rhs.damageDiameter)) ivarsEqual = false;
     if( ! (temperature == rhs.temperature)) ivarsEqual = false;
     if( ! (componentIdentification == rhs.componentIdentification)) ivarsEqual = false;
     if( ! (componentDamageStatus == rhs.componentDamageStatus)) ivarsEqual = false;
     if( ! (componentVisualSmokeColor == rhs.componentVisualSmokeColor)) ivarsEqual = false;
     if( ! (fireEventID.equals( rhs.fireEventID) )) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
