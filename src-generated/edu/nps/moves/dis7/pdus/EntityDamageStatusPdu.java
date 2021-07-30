/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.3.5 Used to communicate detailed damage information sustained by an entity regardless of the source of the damage.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EntityDamageStatusPdu extends WarfareFamilyPdu implements Serializable
{
   /** Field shall identify the damaged entity (see 6.2.28), Section 7.3.4 */
   protected EntityID  damagedEntityID = new EntityID(); 

   /** padding1 is an undescribed parameter... */
   protected short  padding1 = (short)0;

   /** padding2 is an undescribed parameter... */
   protected short  padding2 = (short)0;

   /** field shall specify the number of Damage Description records, Section 7.3.5 */
   protected short  numberOfDamageDescription = (short)0;

   /** Fields shall contain one or more Damage Description records (see 6.2.17) and may contain other Standard Variable records, Section 7.3.5 */
   protected List< DirectedEnergyDamage > damageDescriptionRecords = new ArrayList< DirectedEnergyDamage >();
 

/** Constructor */
 public EntityDamageStatusPdu()
 {
    setPduType( DisPduType.ENTITY_DAMAGE_STATUS );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += damagedEntityID.getMarshalledSize();
   marshalSize += 2;  // padding1
   marshalSize += 2;  // padding2
   marshalSize += 2;  // numberOfDamageDescription
   for(int idx=0; idx < damageDescriptionRecords.size(); idx++)
   {
        DirectedEnergyDamage listElement = damageDescriptionRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link EntityDamageStatusPdu#damagedEntityID}
  * @param pDamagedEntityID new value of interest
  * @return same object to permit progressive setters */
public EntityDamageStatusPdu setDamagedEntityID(EntityID pDamagedEntityID)
{
    damagedEntityID = pDamagedEntityID;
    return this;
}

/** Getter for {@link EntityDamageStatusPdu#damagedEntityID}
  * @return value of interest */
public EntityID getDamagedEntityID()
{
    return damagedEntityID; 
}

/** Setter for {@link EntityDamageStatusPdu#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public EntityDamageStatusPdu setPadding1(short pPadding1)
{
    padding1 = pPadding1;
    return this;
}
/** Utility setter for {@link EntityDamageStatusPdu#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public EntityDamageStatusPdu setPadding1(int pPadding1){
    padding1 = (short) pPadding1;
    return this;
}

/** Getter for {@link EntityDamageStatusPdu#padding1}
  * @return value of interest */
public short getPadding1()
{
    return padding1; 
}

/** Setter for {@link EntityDamageStatusPdu#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public EntityDamageStatusPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}
/** Utility setter for {@link EntityDamageStatusPdu#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public EntityDamageStatusPdu setPadding2(int pPadding2){
    padding2 = (short) pPadding2;
    return this;
}

/** Getter for {@link EntityDamageStatusPdu#padding2}
  * @return value of interest */
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link EntityDamageStatusPdu#damageDescriptionRecords}
  * @param pDamageDescriptionRecords new value of interest
  * @return same object to permit progressive setters */
public EntityDamageStatusPdu setDamageDescriptionRecords(List<DirectedEnergyDamage> pDamageDescriptionRecords)
{
    damageDescriptionRecords = pDamageDescriptionRecords;
    return this;
}

/** Getter for {@link EntityDamageStatusPdu#damageDescriptionRecords}
  * @return value of interest */
public List<DirectedEnergyDamage> getDamageDescriptionRecords()
{
    return damageDescriptionRecords; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       damagedEntityID.marshal(dos);
       dos.writeShort(padding1);
       dos.writeShort(padding2);
       dos.writeShort(damageDescriptionRecords.size());

       for(int idx = 0; idx < damageDescriptionRecords.size(); idx++)
       {
            DirectedEnergyDamage aDirectedEnergyDamage = damageDescriptionRecords.get(idx);
            aDirectedEnergyDamage.marshal(dos);
       }

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
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += damagedEntityID.unmarshal(dis);
        padding1 = (short)dis.readUnsignedShort();
        uPosition += 2;
        padding2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        numberOfDamageDescription = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfDamageDescription; idx++)
        {
            DirectedEnergyDamage anX = new DirectedEnergyDamage();
            uPosition += anX.unmarshal(dis);
            damageDescriptionRecords.add(anX);
        }

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
   super.marshal(byteBuffer);
   damagedEntityID.marshal(byteBuffer);
   byteBuffer.putShort( (short)padding1);
   byteBuffer.putShort( (short)padding2);
   byteBuffer.putShort( (short)damageDescriptionRecords.size());

   for(int idx = 0; idx < damageDescriptionRecords.size(); idx++)
   {
        DirectedEnergyDamage aDirectedEnergyDamage = damageDescriptionRecords.get(idx);
        aDirectedEnergyDamage.marshal(byteBuffer);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    damagedEntityID.unmarshal(byteBuffer);
    padding1 = (short)(byteBuffer.getShort() & 0xFFFF);
    padding2 = (short)(byteBuffer.getShort() & 0xFFFF);
    numberOfDamageDescription = (short)(byteBuffer.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfDamageDescription; idx++)
    {
    DirectedEnergyDamage anX = new DirectedEnergyDamage();
    anX.unmarshal(byteBuffer);
    damageDescriptionRecords.add(anX);
    }

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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final EntityDamageStatusPdu rhs = (EntityDamageStatusPdu)obj;

     if( ! (damagedEntityID.equals( rhs.damagedEntityID) )) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;

     for(int idx = 0; idx < damageDescriptionRecords.size(); idx++)
        if( ! ( damageDescriptionRecords.get(idx).equals(rhs.damageDescriptionRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" damagedEntityID: ").append(damagedEntityID).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");
    sb.append(" damageDescriptionRecords: ").append("\n");
    damageDescriptionRecords.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
