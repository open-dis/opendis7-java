package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 *  The joining of two or more simulation entities is communicated by this PDU. Section 7.8.5
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class IsPartOfPdu extends EntityManagementFamilyPdu implements Serializable
{
   /** ID of entity originating PDU */
   protected EntityID  orginatingEntityID = new EntityID(); 

   /** ID of entity receiving PDU */
   protected EntityID  receivingEntityID = new EntityID(); 

   /** relationship of joined parts */
   protected Relationship  relationship = new Relationship(); 

   /** location of part; centroid of part in host's coordinate system. x=range, y=bearing, z=0 */
   protected Vector3Float  partLocation = new Vector3Float(); 

   /** named location */
   protected NamedLocationIdentification  namedLocationID = new NamedLocationIdentification(); 

   /** entity type */
   protected EntityType  partEntityType = new EntityType(); 


/** Constructor */
 public IsPartOfPdu()
 {
    setPduType( DISPDUType.ISPARTOF );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += orginatingEntityID.getMarshalledSize();
   marshalSize += receivingEntityID.getMarshalledSize();
   marshalSize += relationship.getMarshalledSize();
   marshalSize += partLocation.getMarshalledSize();
   marshalSize += namedLocationID.getMarshalledSize();
   marshalSize += partEntityType.getMarshalledSize();

   return marshalSize;
}


public IsPartOfPdu setOrginatingEntityID(EntityID pOrginatingEntityID)
{
    orginatingEntityID = pOrginatingEntityID;
    return this;
}

public EntityID getOrginatingEntityID()
{
    return orginatingEntityID; 
}

public IsPartOfPdu setReceivingEntityID(EntityID pReceivingEntityID)
{
    receivingEntityID = pReceivingEntityID;
    return this;
}

public EntityID getReceivingEntityID()
{
    return receivingEntityID; 
}

public IsPartOfPdu setRelationship(Relationship pRelationship)
{
    relationship = pRelationship;
    return this;
}

public Relationship getRelationship()
{
    return relationship; 
}

public IsPartOfPdu setPartLocation(Vector3Float pPartLocation)
{
    partLocation = pPartLocation;
    return this;
}

public Vector3Float getPartLocation()
{
    return partLocation; 
}

public IsPartOfPdu setNamedLocationID(NamedLocationIdentification pNamedLocationID)
{
    namedLocationID = pNamedLocationID;
    return this;
}

public NamedLocationIdentification getNamedLocationID()
{
    return namedLocationID; 
}

public IsPartOfPdu setPartEntityType(EntityType pPartEntityType)
{
    partEntityType = pPartEntityType;
    return this;
}

public EntityType getPartEntityType()
{
    return partEntityType; 
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
       orginatingEntityID.marshal(dos);
       receivingEntityID.marshal(dos);
       relationship.marshal(dos);
       partLocation.marshal(dos);
       namedLocationID.marshal(dos);
       partEntityType.marshal(dos);
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
        uPosition += orginatingEntityID.unmarshal(dis);
        uPosition += receivingEntityID.unmarshal(dis);
        uPosition += relationship.unmarshal(dis);
        uPosition += partLocation.unmarshal(dis);
        uPosition += namedLocationID.unmarshal(dis);
        uPosition += partEntityType.unmarshal(dis);
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
   orginatingEntityID.marshal(buff);
   receivingEntityID.marshal(buff);
   relationship.marshal(buff);
   partLocation.marshal(buff);
   namedLocationID.marshal(buff);
   partEntityType.marshal(buff);
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

    orginatingEntityID.unmarshal(buff);
    receivingEntityID.unmarshal(buff);
    relationship.unmarshal(buff);
    partLocation.unmarshal(buff);
    namedLocationID.unmarshal(buff);
    partEntityType.unmarshal(buff);
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

    if(!(obj instanceof IsPartOfPdu))
        return false;

     final IsPartOfPdu rhs = (IsPartOfPdu)obj;

     if( ! (orginatingEntityID.equals( rhs.orginatingEntityID) )) ivarsEqual = false;
     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;
     if( ! (relationship.equals( rhs.relationship) )) ivarsEqual = false;
     if( ! (partLocation.equals( rhs.partLocation) )) ivarsEqual = false;
     if( ! (namedLocationID.equals( rhs.namedLocationID) )) ivarsEqual = false;
     if( ! (partEntityType.equals( rhs.partEntityType) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
