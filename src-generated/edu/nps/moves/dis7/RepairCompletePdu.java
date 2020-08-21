/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.5.10 Used by the repairing entity to communicate the repair that has been performed for the entity that requested repair service.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class RepairCompletePdu extends LogisticsFamilyPdu implements Serializable
{
   /** Entity that is receiving service.  See 6.2.28 */
   protected EntityID  receivingEntityID = new EntityID(); 

   /** Entity that is supplying.  See 6.2.28 */
   protected EntityID  repairingEntityID = new EntityID(); 

   /** Enumeration for type of repair.  See 6.2.74 uid 64 */
   protected RepairCompleteRepair repair = RepairCompleteRepair.values()[0];

   /** padding, number prevents conflict with superclass ivar name */
   protected short  padding4 = (short)0;


/** Constructor */
 public RepairCompletePdu()
 {
    setPduType( DISPDUType.REPAIR_COMPLETE );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += receivingEntityID.getMarshalledSize();
   marshalSize += repairingEntityID.getMarshalledSize();
   marshalSize += repair.getMarshalledSize();
   marshalSize += 2;  // padding4

   return marshalSize;
}


/** Setter for {@link RepairCompletePdu#receivingEntityID}*/
public RepairCompletePdu setReceivingEntityID(EntityID pReceivingEntityID)
{
    receivingEntityID = pReceivingEntityID;
    return this;
}

/** Getter for {@link RepairCompletePdu#receivingEntityID}*/
public EntityID getReceivingEntityID()
{
    return receivingEntityID; 
}

/** Setter for {@link RepairCompletePdu#repairingEntityID}*/
public RepairCompletePdu setRepairingEntityID(EntityID pRepairingEntityID)
{
    repairingEntityID = pRepairingEntityID;
    return this;
}

/** Getter for {@link RepairCompletePdu#repairingEntityID}*/
public EntityID getRepairingEntityID()
{
    return repairingEntityID; 
}

/** Setter for {@link RepairCompletePdu#repair}*/
public RepairCompletePdu setRepair(RepairCompleteRepair pRepair)
{
    repair = pRepair;
    return this;
}

/** Getter for {@link RepairCompletePdu#repair}*/
public RepairCompleteRepair getRepair()
{
    return repair; 
}

/** Setter for {@link RepairCompletePdu#padding4}*/
public RepairCompletePdu setPadding4(short pPadding4)
{
    padding4 = pPadding4;
    return this;
}

/** Getter for {@link RepairCompletePdu#padding4}*/
public short getPadding4()
{
    return padding4; 
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
       receivingEntityID.marshal(dos);
       repairingEntityID.marshal(dos);
       repair.marshal(dos);
       dos.writeShort(padding4);
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
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += receivingEntityID.unmarshal(dis);
        uPosition += repairingEntityID.unmarshal(dis);
        repair = RepairCompleteRepair.unmarshalEnum(dis);
        uPosition += repair.getMarshalledSize();
        padding4 = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   super.marshal(buff);
   receivingEntityID.marshal(buff);
   repairingEntityID.marshal(buff);
   repair.marshal(buff);
   buff.putShort( (short)padding4);
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

    receivingEntityID.unmarshal(buff);
    repairingEntityID.unmarshal(buff);
    repair = RepairCompleteRepair.unmarshalEnum(buff);
    padding4 = (short)(buff.getShort() & 0xFFFF);
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

     final RepairCompletePdu rhs = (RepairCompletePdu)obj;

     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;
     if( ! (repairingEntityID.equals( rhs.repairingEntityID) )) ivarsEqual = false;
     if( ! (repair == rhs.repair)) ivarsEqual = false;
     if( ! (padding4 == rhs.padding4)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" receivingEntityID: ").append(receivingEntityID).append("\n");
    sb.append(" repairingEntityID: ").append(repairingEntityID).append("\n");
    sb.append(" repair: ").append(repair).append("\n");
    sb.append(" padding4: ").append(padding4).append("\n");

   return sb.toString();
 }
} // end of class
