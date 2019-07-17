package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Association or disassociation of two entities.  Section 6.2.94.4.3
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class EntityAssociationVP extends Object implements Serializable
{
   /** the identification of the Variable Parameter record. Enumeration from EBV uid 56 */
   protected VariableParameterRecordType recordType = VariableParameterRecordType.ENTITY_ASSOCIATION;

   /** Indicates if this VP has changed since last issuance uid 320 */
   protected EntityVPRecordChangeIndicator changeIndicator = EntityVPRecordChangeIndicator.values()[0];

   /** Indicates association status between two entities uid 319 */
   protected EntityAssociationAssociationType associationStatus = EntityAssociationAssociationType.values()[0];

   /** Type of association; 8 bit enum uid 323 */
   protected EntityAssociationPhysicalAssociationType associationType = EntityAssociationPhysicalAssociationType.values()[0];

   /** Object ID of entity associated with this entity */
   protected EntityID  entityID = new EntityID(); 

   /** Station location on one's own entity uid 212 */
   protected IsPartOfStationName ownStationLocation = IsPartOfStationName.values()[0];

   /** Type of physical connection uid 324 */
   protected EntityAssociationPhysicalConnectionType physicalConnectionType = EntityAssociationPhysicalConnectionType.values()[0];

   /** Type of member the entity is within the group uid 321 */
   protected EntityAssociationGroupMemberType groupMemberType = EntityAssociationGroupMemberType.values()[0];

   /** Group if any to which the entity belongs */
   protected short  groupNumber;


/** Constructor */
 public EntityAssociationVP()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += recordType.getMarshalledSize();
   marshalSize += changeIndicator.getMarshalledSize();
   marshalSize += associationStatus.getMarshalledSize();
   marshalSize += associationType.getMarshalledSize();
   marshalSize += entityID.getMarshalledSize();
   marshalSize += ownStationLocation.getMarshalledSize();
   marshalSize += physicalConnectionType.getMarshalledSize();
   marshalSize += groupMemberType.getMarshalledSize();
   marshalSize += 2;  // groupNumber

   return marshalSize;
}


public EntityAssociationVP setRecordType(VariableParameterRecordType pRecordType)
{
    recordType = pRecordType;
    return this;
}

public VariableParameterRecordType getRecordType()
{
    return recordType; 
}

public EntityAssociationVP setChangeIndicator(EntityVPRecordChangeIndicator pChangeIndicator)
{
    changeIndicator = pChangeIndicator;
    return this;
}

public EntityVPRecordChangeIndicator getChangeIndicator()
{
    return changeIndicator; 
}

public EntityAssociationVP setAssociationStatus(EntityAssociationAssociationType pAssociationStatus)
{
    associationStatus = pAssociationStatus;
    return this;
}

public EntityAssociationAssociationType getAssociationStatus()
{
    return associationStatus; 
}

public EntityAssociationVP setAssociationType(EntityAssociationPhysicalAssociationType pAssociationType)
{
    associationType = pAssociationType;
    return this;
}

public EntityAssociationPhysicalAssociationType getAssociationType()
{
    return associationType; 
}

public EntityAssociationVP setEntityID(EntityID pEntityID)
{
    entityID = pEntityID;
    return this;
}

public EntityID getEntityID()
{
    return entityID; 
}

public EntityAssociationVP setOwnStationLocation(IsPartOfStationName pOwnStationLocation)
{
    ownStationLocation = pOwnStationLocation;
    return this;
}

public IsPartOfStationName getOwnStationLocation()
{
    return ownStationLocation; 
}

public EntityAssociationVP setPhysicalConnectionType(EntityAssociationPhysicalConnectionType pPhysicalConnectionType)
{
    physicalConnectionType = pPhysicalConnectionType;
    return this;
}

public EntityAssociationPhysicalConnectionType getPhysicalConnectionType()
{
    return physicalConnectionType; 
}

public EntityAssociationVP setGroupMemberType(EntityAssociationGroupMemberType pGroupMemberType)
{
    groupMemberType = pGroupMemberType;
    return this;
}

public EntityAssociationGroupMemberType getGroupMemberType()
{
    return groupMemberType; 
}

public EntityAssociationVP setGroupNumber(short pGroupNumber)
{
    groupNumber = pGroupNumber;
    return this;
}

public short getGroupNumber()
{
    return groupNumber; 
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
       recordType.marshal(dos);
       changeIndicator.marshal(dos);
       associationStatus.marshal(dos);
       associationType.marshal(dos);
       entityID.marshal(dos);
       ownStationLocation.marshal(dos);
       physicalConnectionType.marshal(dos);
       groupMemberType.marshal(dos);
       dos.writeShort( (short)groupNumber);
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
        recordType = VariableParameterRecordType.unmarshalEnum(dis);
        uPosition += recordType.getMarshalledSize();
        changeIndicator = EntityVPRecordChangeIndicator.unmarshalEnum(dis);
        uPosition += changeIndicator.getMarshalledSize();
        associationStatus = EntityAssociationAssociationType.unmarshalEnum(dis);
        uPosition += associationStatus.getMarshalledSize();
        associationType = EntityAssociationPhysicalAssociationType.unmarshalEnum(dis);
        uPosition += associationType.getMarshalledSize();
        uPosition += entityID.unmarshal(dis);
        ownStationLocation = IsPartOfStationName.unmarshalEnum(dis);
        uPosition += ownStationLocation.getMarshalledSize();
        physicalConnectionType = EntityAssociationPhysicalConnectionType.unmarshalEnum(dis);
        uPosition += physicalConnectionType.getMarshalledSize();
        groupMemberType = EntityAssociationGroupMemberType.unmarshalEnum(dis);
        uPosition += groupMemberType.getMarshalledSize();
        groupNumber = (short)dis.readUnsignedShort();
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
   recordType.marshal(buff);
   changeIndicator.marshal(buff);
   associationStatus.marshal(buff);
   associationType.marshal(buff);
   entityID.marshal(buff);
   ownStationLocation.marshal(buff);
   physicalConnectionType.marshal(buff);
   groupMemberType.marshal(buff);
   buff.putShort( (short)groupNumber);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    recordType = VariableParameterRecordType.unmarshalEnum(buff);
    changeIndicator = EntityVPRecordChangeIndicator.unmarshalEnum(buff);
    associationStatus = EntityAssociationAssociationType.unmarshalEnum(buff);
    associationType = EntityAssociationPhysicalAssociationType.unmarshalEnum(buff);
    entityID.unmarshal(buff);
    ownStationLocation = IsPartOfStationName.unmarshalEnum(buff);
    physicalConnectionType = EntityAssociationPhysicalConnectionType.unmarshalEnum(buff);
    groupMemberType = EntityAssociationGroupMemberType.unmarshalEnum(buff);
    groupNumber = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof EntityAssociationVP))
        return false;

     final EntityAssociationVP rhs = (EntityAssociationVP)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (changeIndicator == rhs.changeIndicator)) ivarsEqual = false;
     if( ! (associationStatus == rhs.associationStatus)) ivarsEqual = false;
     if( ! (associationType == rhs.associationType)) ivarsEqual = false;
     if( ! (entityID.equals( rhs.entityID) )) ivarsEqual = false;
     if( ! (ownStationLocation == rhs.ownStationLocation)) ivarsEqual = false;
     if( ! (physicalConnectionType == rhs.physicalConnectionType)) ivarsEqual = false;
     if( ! (groupMemberType == rhs.groupMemberType)) ivarsEqual = false;
     if( ! (groupNumber == rhs.groupNumber)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
