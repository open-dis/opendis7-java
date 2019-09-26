/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.9.5 Used to request hierarchical linkage of separately hosted simulation entities
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link IsPartOfPdu#orginatingEntityID}*/
public IsPartOfPdu setOrginatingEntityID(EntityID pOrginatingEntityID)
{
    orginatingEntityID = pOrginatingEntityID;
    return this;
}

/** Getter for {@link IsPartOfPdu#orginatingEntityID}*/
public EntityID getOrginatingEntityID()
{
    return orginatingEntityID; 
}

/** Setter for {@link IsPartOfPdu#receivingEntityID}*/
public IsPartOfPdu setReceivingEntityID(EntityID pReceivingEntityID)
{
    receivingEntityID = pReceivingEntityID;
    return this;
}

/** Getter for {@link IsPartOfPdu#receivingEntityID}*/
public EntityID getReceivingEntityID()
{
    return receivingEntityID; 
}

/** Setter for {@link IsPartOfPdu#relationship}*/
public IsPartOfPdu setRelationship(Relationship pRelationship)
{
    relationship = pRelationship;
    return this;
}

/** Getter for {@link IsPartOfPdu#relationship}*/
public Relationship getRelationship()
{
    return relationship; 
}

/** Setter for {@link IsPartOfPdu#partLocation}*/
public IsPartOfPdu setPartLocation(Vector3Float pPartLocation)
{
    partLocation = pPartLocation;
    return this;
}

/** Getter for {@link IsPartOfPdu#partLocation}*/
public Vector3Float getPartLocation()
{
    return partLocation; 
}

/** Setter for {@link IsPartOfPdu#namedLocationID}*/
public IsPartOfPdu setNamedLocationID(NamedLocationIdentification pNamedLocationID)
{
    namedLocationID = pNamedLocationID;
    return this;
}

/** Getter for {@link IsPartOfPdu#namedLocationID}*/
public NamedLocationIdentification getNamedLocationID()
{
    return namedLocationID; 
}

/** Setter for {@link IsPartOfPdu#partEntityType}*/
public IsPartOfPdu setPartEntityType(EntityType pPartEntityType)
{
    partEntityType = pPartEntityType;
    return this;
}

/** Getter for {@link IsPartOfPdu#partEntityType}*/
public EntityType getPartEntityType()
{
    return partEntityType; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
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
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
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
 * @throws Exception ByteBuffer-generated exception
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
 * @return marshalled size
 * @throws Exception ByteBuffer-generated exception
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

     final IsPartOfPdu rhs = (IsPartOfPdu)obj;

     if( ! (orginatingEntityID.equals( rhs.orginatingEntityID) )) ivarsEqual = false;
     if( ! (receivingEntityID.equals( rhs.receivingEntityID) )) ivarsEqual = false;
     if( ! (relationship.equals( rhs.relationship) )) ivarsEqual = false;
     if( ! (partLocation.equals( rhs.partLocation) )) ivarsEqual = false;
     if( ! (namedLocationID.equals( rhs.namedLocationID) )) ivarsEqual = false;
     if( ! (partEntityType.equals( rhs.partEntityType) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" orginatingEntityID: ").append(orginatingEntityID).append("\n");
    sb.append(" receivingEntityID: ").append(receivingEntityID).append("\n");
    sb.append(" relationship: ").append(relationship).append("\n");
    sb.append(" partLocation: ").append(partLocation).append("\n");
    sb.append(" namedLocationID: ").append(namedLocationID).append("\n");
    sb.append(" partEntityType: ").append(partEntityType).append("\n");

   return sb.toString();
 }
} // end of class
