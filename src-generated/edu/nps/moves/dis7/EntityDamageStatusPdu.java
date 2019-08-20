/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.3.5 Used to communicate detailed damage information sustained by an entity regardless of the source of the damage.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class EntityDamageStatusPdu extends WarfareFamilyPdu implements Serializable
{
   /** Field shall identify the damaged entity (see 6.2.28), Section 7.3.4 */
   protected EntityID  damagedEntityID = new EntityID(); 

   protected short  padding1 = (short)0;

   protected short  padding2 = (short)0;

   /** field shall specify the number of Damage Description records, Section 7.3.5 */
   protected short  numberOfDamageDescription = (short)0;

   /** Fields shall contain one or more Damage Description records (see 6.2.17) and may contain other Standard Variable records, Section 7.3.5 */
   protected List< DirectedEnergyDamage > damageDescriptionRecords = new ArrayList< DirectedEnergyDamage >();
 

/** Constructor */
 public EntityDamageStatusPdu()
 {
    setPduType( DISPDUType.ENTITY_DAMAGE_STATUS );
 }

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link EntityDamageStatusPdu#damagedEntityID}*/
public EntityDamageStatusPdu setDamagedEntityID(EntityID pDamagedEntityID)
{
    damagedEntityID = pDamagedEntityID;
    return this;
}

/** Getter for {@link EntityDamageStatusPdu#damagedEntityID}*/
public EntityID getDamagedEntityID()
{
    return damagedEntityID; 
}

/** Setter for {@link EntityDamageStatusPdu#padding1}*/
public EntityDamageStatusPdu setPadding1(short pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link EntityDamageStatusPdu#padding1}*/
public short getPadding1()
{
    return padding1; 
}

/** Setter for {@link EntityDamageStatusPdu#padding2}*/
public EntityDamageStatusPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

/** Getter for {@link EntityDamageStatusPdu#padding2}*/
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link EntityDamageStatusPdu#damageDescriptionRecords}*/
public EntityDamageStatusPdu setDamageDescriptionRecords(List<DirectedEnergyDamage> pDamageDescriptionRecords)
{
    damageDescriptionRecords = pDamageDescriptionRecords;
    return this;
}

/** Getter for {@link EntityDamageStatusPdu#damageDescriptionRecords}*/
public List<DirectedEnergyDamage> getDamageDescriptionRecords()
{
    return damageDescriptionRecords; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       damagedEntityID.marshal(dos);
       dos.writeShort( (short)padding1);
       dos.writeShort( (short)padding2);
       dos.writeShort( (short)damageDescriptionRecords.size());

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
 * Unserializes an object from a DataInputStream.
 * @see java.io.DataInputStream
 * @param dis The DataInputStream
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis)
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
   super.marshal(buff);
   damagedEntityID.marshal(buff);
   buff.putShort( (short)padding1);
   buff.putShort( (short)padding2);
   buff.putShort( (short)damageDescriptionRecords.size());

   for(int idx = 0; idx < damageDescriptionRecords.size(); idx++)
   {
        DirectedEnergyDamage aDirectedEnergyDamage = (DirectedEnergyDamage)damageDescriptionRecords.get(idx);
        aDirectedEnergyDamage.marshal(buff);
   }

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
    super.unmarshal(buff);

    damagedEntityID.unmarshal(buff);
    padding1 = (short)(buff.getShort() & 0xFFFF);
    padding2 = (short)(buff.getShort() & 0xFFFF);
    numberOfDamageDescription = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfDamageDescription; idx++)
    {
    DirectedEnergyDamage anX = new DirectedEnergyDamage();
    anX.unmarshal(buff);
    damageDescriptionRecords.add(anX);
    }

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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof EntityDamageStatusPdu))
        return false;

     final EntityDamageStatusPdu rhs = (EntityDamageStatusPdu)obj;

     if( ! (damagedEntityID.equals( rhs.damagedEntityID) )) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (numberOfDamageDescription == rhs.numberOfDamageDescription)) ivarsEqual = false;

     for(int idx = 0; idx < damageDescriptionRecords.size(); idx++)
        if( ! ( damageDescriptionRecords.get(idx).equals(rhs.damageDescriptionRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
