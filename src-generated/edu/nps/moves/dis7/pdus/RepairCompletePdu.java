/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

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

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
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


/** Setter for {@link RepairCompletePdu#receivingEntityID}
  * @param pReceivingEntityID new value of interest
  * @return same object to permit progressive setters */
public RepairCompletePdu setReceivingEntityID(EntityID pReceivingEntityID)
{
    receivingEntityID = pReceivingEntityID;
    return this;
}

/** Getter for {@link RepairCompletePdu#receivingEntityID}
  * @return value of interest */
public EntityID getReceivingEntityID()
{
    return receivingEntityID; 
}

/** Setter for {@link RepairCompletePdu#repairingEntityID}
  * @param pRepairingEntityID new value of interest
  * @return same object to permit progressive setters */
public RepairCompletePdu setRepairingEntityID(EntityID pRepairingEntityID)
{
    repairingEntityID = pRepairingEntityID;
    return this;
}

/** Getter for {@link RepairCompletePdu#repairingEntityID}
  * @return value of interest */
public EntityID getRepairingEntityID()
{
    return repairingEntityID; 
}

/** Setter for {@link RepairCompletePdu#repair}
  * @param pRepair new value of interest
  * @return same object to permit progressive setters */
public RepairCompletePdu setRepair(RepairCompleteRepair pRepair)
{
    repair = pRepair;
    return this;
}

/** Getter for {@link RepairCompletePdu#repair}
  * @return value of interest */
public RepairCompleteRepair getRepair()
{
    return repair; 
}

/** Setter for {@link RepairCompletePdu#padding4}
  * @param pPadding4 new value of interest
  * @return same object to permit progressive setters */
public RepairCompletePdu setPadding4(short pPadding4)
{
    padding4 = pPadding4;
    return this;
}
/** Utility setter for {@link RepairCompletePdu#padding4}
  * @param pPadding4 new value of interest
  * @return same object to permit progressive setters */
public RepairCompletePdu setPadding4(int pPadding4){
    padding4 = (short) pPadding4;
    return this;
}

/** Getter for {@link RepairCompletePdu#padding4}
  * @return value of interest */
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
 * @throws java.nio.BufferOverflowException if byteBuffer is too small
 * @throws java.nio.ReadOnlyBufferException if byteBuffer is read only
 * @see java.nio.ByteBuffer
 * @param byteBuffer The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   super.marshal(byteBuffer);
   receivingEntityID.marshal(byteBuffer);
   repairingEntityID.marshal(byteBuffer);
   repair.marshal(byteBuffer);
   byteBuffer.putShort( (short)padding4);
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

    receivingEntityID.unmarshal(byteBuffer);
    repairingEntityID.unmarshal(byteBuffer);
    repair = RepairCompleteRepair.unmarshalEnum(byteBuffer);
    padding4 = (short)(byteBuffer.getShort() & 0xFFFF);
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
