package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Section 7.4.6. Service Request PDU is received and repair is complete.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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


public RepairCompletePdu setReceivingEntityID(EntityID pReceivingEntityID)
{
    receivingEntityID = pReceivingEntityID;
    return this;
}

public EntityID getReceivingEntityID()
{
    return receivingEntityID; 
}

public RepairCompletePdu setRepairingEntityID(EntityID pRepairingEntityID)
{
    repairingEntityID = pRepairingEntityID;
    return this;
}

public EntityID getRepairingEntityID()
{
    return repairingEntityID; 
}

public RepairCompletePdu setRepair(RepairCompleteRepair pRepair)
{
    repair = pRepair;
    return this;
}

public RepairCompleteRepair getRepair()
{
    return repair; 
}

public RepairCompletePdu setPadding4(short pPadding4)
{
    padding4 = pPadding4;
    return this;
}

public short getPadding4()
{
    return padding4; 
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
       receivingEntityID.marshal(dos);
       repairingEntityID.marshal(dos);
       repair.marshal(dos);
       dos.writeShort( (short)padding4);
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

    if(!(obj instanceof RepairCompletePdu))
        return false;

     final RepairCompletePdu rhs = (RepairCompletePdu)obj;

     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;
     if( ! (repairingEntityID.equals( rhs.repairingEntityID) )) ivarsEqual = false;
     if( ! (repair == rhs.repair)) ivarsEqual = false;
     if( ! (padding4 == rhs.padding4)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
