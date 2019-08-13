/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 5.9.2.2 The Aggregate State PDU shall be used to communicate the state and other pertinent information about an aggregated unit.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class AggregateStatePdu extends EntityManagementFamilyPdu implements Serializable
{
   /** ID of aggregated entities */
   protected AggregateIdentifier  aggregateID = new AggregateIdentifier(); 

   /** force ID uid 6 */
   protected ForceID forceID = ForceID.values()[0];

   /** state of aggregate uid 204 */
   protected AggregateStateAggregateState aggregateState = AggregateStateAggregateState.values()[0];

   /** entity type of the aggregated entities */
   protected AggregateType  aggregateType = new AggregateType(); 

   /** formation of aggregated entities uid 205 */
   protected AggregateStateFormation formation = AggregateStateFormation.values()[0];

   /** marking for aggregate; first char is charset type, rest is char data */
   protected AggregateMarking  aggregateMarking = new AggregateMarking(); 

   /** dimensions of bounding box for the aggregated entities, origin at the center of mass */
   protected Vector3Float  dimensions = new Vector3Float(); 

   /** orientation of the bounding box */
   protected Vector3Float  orientation = new Vector3Float(); 

   /** center of mass of the aggregation */
   protected Vector3Double  centerOfMass = new Vector3Double(); 

   /** velocity of aggregation */
   protected Vector3Float  velocity = new Vector3Float(); 

   /** number of aggregates */
   protected short  numberOfDisAggregates;

   /** number of entities */
   protected short  numberOfDisEntities;

   /** number of silent aggregate types */
   protected short  numberOfSilentAggregateTypes;

   /** number of silent entity types */
   protected short  numberOfSilentEntityTypes;

   /** aggregates  list */
   protected List< AggregateIdentifier > aggregateIDList = new ArrayList< AggregateIdentifier >();
 
   /** entity ID list */
   protected List< EntityID > entityIDList = new ArrayList< EntityID >();
 
   private byte[] padTo32 = new byte[0]; // pad to 32-bit boundary

   /** silent entity types */
   protected List< EntityType > silentAggregateSystemList = new ArrayList< EntityType >();
 
   /** silent entity types */
   protected List< EntityType > silentEntitySystemList = new ArrayList< EntityType >();
 
   /** number of variable datum records */
   protected int  numberOfVariableDatumRecords;

   /** variableDatums */
   protected List< VariableDatum > variableDatumList = new ArrayList< VariableDatum >();
 

/** Constructor */
 public AggregateStatePdu()
 {
    setPduType( DISPDUType.AGGREGATE_STATE );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += aggregateID.getMarshalledSize();
   marshalSize += forceID.getMarshalledSize();
   marshalSize += aggregateState.getMarshalledSize();
   marshalSize += aggregateType.getMarshalledSize();
   marshalSize += formation.getMarshalledSize();
   marshalSize += aggregateMarking.getMarshalledSize();
   marshalSize += dimensions.getMarshalledSize();
   marshalSize += orientation.getMarshalledSize();
   marshalSize += centerOfMass.getMarshalledSize();
   marshalSize += velocity.getMarshalledSize();
   marshalSize += 2;  // numberOfDisAggregates
   marshalSize += 2;  // numberOfDisEntities
   marshalSize += 2;  // numberOfSilentAggregateTypes
   marshalSize += 2;  // numberOfSilentEntityTypes
   for(int idx=0; idx < aggregateIDList.size(); idx++)
   {
        AggregateIdentifier listElement = aggregateIDList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < entityIDList.size(); idx++)
   {
        EntityID listElement = entityIDList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   marshalSize += padTo32.length;
   for(int idx=0; idx < silentAggregateSystemList.size(); idx++)
   {
        EntityType listElement = silentAggregateSystemList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < silentEntitySystemList.size(); idx++)
   {
        EntityType listElement = silentEntitySystemList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   marshalSize += 4;  // numberOfVariableDatumRecords
   for(int idx=0; idx < variableDatumList.size(); idx++)
   {
        VariableDatum listElement = variableDatumList.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public AggregateStatePdu setAggregateID(AggregateIdentifier pAggregateID)
{
    aggregateID = pAggregateID;
    return this;
}

public AggregateIdentifier getAggregateID()
{
    return aggregateID; 
}

public AggregateStatePdu setForceID(ForceID pForceID)
{
    forceID = pForceID;
    return this;
}

public ForceID getForceID()
{
    return forceID; 
}

public AggregateStatePdu setAggregateState(AggregateStateAggregateState pAggregateState)
{
    aggregateState = pAggregateState;
    return this;
}

public AggregateStateAggregateState getAggregateState()
{
    return aggregateState; 
}

public AggregateStatePdu setAggregateType(AggregateType pAggregateType)
{
    aggregateType = pAggregateType;
    return this;
}

public AggregateType getAggregateType()
{
    return aggregateType; 
}

public AggregateStatePdu setFormation(AggregateStateFormation pFormation)
{
    formation = pFormation;
    return this;
}

public AggregateStateFormation getFormation()
{
    return formation; 
}

public AggregateStatePdu setAggregateMarking(AggregateMarking pAggregateMarking)
{
    aggregateMarking = pAggregateMarking;
    return this;
}

public AggregateMarking getAggregateMarking()
{
    return aggregateMarking; 
}

public AggregateStatePdu setDimensions(Vector3Float pDimensions)
{
    dimensions = pDimensions;
    return this;
}

public Vector3Float getDimensions()
{
    return dimensions; 
}

public AggregateStatePdu setOrientation(Vector3Float pOrientation)
{
    orientation = pOrientation;
    return this;
}

public Vector3Float getOrientation()
{
    return orientation; 
}

public AggregateStatePdu setCenterOfMass(Vector3Double pCenterOfMass)
{
    centerOfMass = pCenterOfMass;
    return this;
}

public Vector3Double getCenterOfMass()
{
    return centerOfMass; 
}

public AggregateStatePdu setVelocity(Vector3Float pVelocity)
{
    velocity = pVelocity;
    return this;
}

public Vector3Float getVelocity()
{
    return velocity; 
}

public AggregateStatePdu setAggregateIDList(List<AggregateIdentifier> pAggregateIDList)
{
    aggregateIDList = pAggregateIDList;
    return this;
}

public List<AggregateIdentifier> getAggregateIDList()
{
    return aggregateIDList; 
}

public AggregateStatePdu setEntityIDList(List<EntityID> pEntityIDList)
{
    entityIDList = pEntityIDList;
    return this;
}

public List<EntityID> getEntityIDList()
{
    return entityIDList; 
}

public AggregateStatePdu setSilentAggregateSystemList(List<EntityType> pSilentAggregateSystemList)
{
    silentAggregateSystemList = pSilentAggregateSystemList;
    return this;
}

public List<EntityType> getSilentAggregateSystemList()
{
    return silentAggregateSystemList; 
}

public AggregateStatePdu setSilentEntitySystemList(List<EntityType> pSilentEntitySystemList)
{
    silentEntitySystemList = pSilentEntitySystemList;
    return this;
}

public List<EntityType> getSilentEntitySystemList()
{
    return silentEntitySystemList; 
}

public AggregateStatePdu setVariableDatumList(List<VariableDatum> pVariableDatumList)
{
    variableDatumList = pVariableDatumList;
    return this;
}

public List<VariableDatum> getVariableDatumList()
{
    return variableDatumList; 
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
       aggregateID.marshal(dos);
       forceID.marshal(dos);
       aggregateState.marshal(dos);
       aggregateType.marshal(dos);
       formation.marshal(dos);
       aggregateMarking.marshal(dos);
       dimensions.marshal(dos);
       orientation.marshal(dos);
       centerOfMass.marshal(dos);
       velocity.marshal(dos);
       dos.writeShort( (short)aggregateIDList.size());
       dos.writeShort( (short)entityIDList.size());
       dos.writeShort( (short)silentAggregateSystemList.size());
       dos.writeShort( (short)silentEntitySystemList.size());

       for(int idx = 0; idx < aggregateIDList.size(); idx++)
       {
            AggregateIdentifier aAggregateIdentifier = aggregateIDList.get(idx);
            aAggregateIdentifier.marshal(dos);
       }


       for(int idx = 0; idx < entityIDList.size(); idx++)
       {
            EntityID aEntityID = entityIDList.get(idx);
            aEntityID.marshal(dos);
       }

       padTo32 = new byte[Align.to32bits(dos)];

       for(int idx = 0; idx < silentAggregateSystemList.size(); idx++)
       {
            EntityType aEntityType = silentAggregateSystemList.get(idx);
            aEntityType.marshal(dos);
       }


       for(int idx = 0; idx < silentEntitySystemList.size(); idx++)
       {
            EntityType aEntityType = silentEntitySystemList.get(idx);
            aEntityType.marshal(dos);
       }

       dos.writeInt( (int)variableDatumList.size());

       for(int idx = 0; idx < variableDatumList.size(); idx++)
       {
            VariableDatum aVariableDatum = variableDatumList.get(idx);
            aVariableDatum.marshal(dos);
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
        uPosition += aggregateID.unmarshal(dis);
        forceID = ForceID.unmarshalEnum(dis);
        uPosition += forceID.getMarshalledSize();
        aggregateState = AggregateStateAggregateState.unmarshalEnum(dis);
        uPosition += aggregateState.getMarshalledSize();
        uPosition += aggregateType.unmarshal(dis);
        formation = AggregateStateFormation.unmarshalEnum(dis);
        uPosition += formation.getMarshalledSize();
        uPosition += aggregateMarking.unmarshal(dis);
        uPosition += dimensions.unmarshal(dis);
        uPosition += orientation.unmarshal(dis);
        uPosition += centerOfMass.unmarshal(dis);
        uPosition += velocity.unmarshal(dis);
        numberOfDisAggregates = (short)dis.readUnsignedShort();
        uPosition += 2;
        numberOfDisEntities = (short)dis.readUnsignedShort();
        uPosition += 2;
        numberOfSilentAggregateTypes = (short)dis.readUnsignedShort();
        uPosition += 2;
        numberOfSilentEntityTypes = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfDisAggregates; idx++)
        {
            AggregateIdentifier anX = new AggregateIdentifier();
            uPosition += anX.unmarshal(dis);
            aggregateIDList.add(anX);
        }

        for(int idx = 0; idx < numberOfDisEntities; idx++)
        {
            EntityID anX = new EntityID();
            uPosition += anX.unmarshal(dis);
            entityIDList.add(anX);
        }

        padTo32 = new byte[Align.from32bits(uPosition,dis)];
        uPosition += padTo32.length;
        for(int idx = 0; idx < numberOfSilentAggregateTypes; idx++)
        {
            EntityType anX = new EntityType();
            uPosition += anX.unmarshal(dis);
            silentAggregateSystemList.add(anX);
        }

        for(int idx = 0; idx < numberOfSilentEntityTypes; idx++)
        {
            EntityType anX = new EntityType();
            uPosition += anX.unmarshal(dis);
            silentEntitySystemList.add(anX);
        }

        numberOfVariableDatumRecords = dis.readInt();
        uPosition += 4;
        for(int idx = 0; idx < numberOfVariableDatumRecords; idx++)
        {
            VariableDatum anX = new VariableDatum();
            uPosition += anX.unmarshal(dis);
            variableDatumList.add(anX);
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
   aggregateID.marshal(buff);
   forceID.marshal(buff);
   aggregateState.marshal(buff);
   aggregateType.marshal(buff);
   formation.marshal(buff);
   aggregateMarking.marshal(buff);
   dimensions.marshal(buff);
   orientation.marshal(buff);
   centerOfMass.marshal(buff);
   velocity.marshal(buff);
   buff.putShort( (short)aggregateIDList.size());
   buff.putShort( (short)entityIDList.size());
   buff.putShort( (short)silentAggregateSystemList.size());
   buff.putShort( (short)silentEntitySystemList.size());

   for(int idx = 0; idx < aggregateIDList.size(); idx++)
   {
        AggregateIdentifier aAggregateIdentifier = (AggregateIdentifier)aggregateIDList.get(idx);
        aAggregateIdentifier.marshal(buff);
   }


   for(int idx = 0; idx < entityIDList.size(); idx++)
   {
        EntityID aEntityID = (EntityID)entityIDList.get(idx);
        aEntityID.marshal(buff);
   }

   padTo32 = new byte[Align.to32bits(buff)];

   for(int idx = 0; idx < silentAggregateSystemList.size(); idx++)
   {
        EntityType aEntityType = (EntityType)silentAggregateSystemList.get(idx);
        aEntityType.marshal(buff);
   }


   for(int idx = 0; idx < silentEntitySystemList.size(); idx++)
   {
        EntityType aEntityType = (EntityType)silentEntitySystemList.get(idx);
        aEntityType.marshal(buff);
   }

   buff.putInt( (int)variableDatumList.size());

   for(int idx = 0; idx < variableDatumList.size(); idx++)
   {
        VariableDatum aVariableDatum = (VariableDatum)variableDatumList.get(idx);
        aVariableDatum.marshal(buff);
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

    aggregateID.unmarshal(buff);
    forceID = ForceID.unmarshalEnum(buff);
    aggregateState = AggregateStateAggregateState.unmarshalEnum(buff);
    aggregateType.unmarshal(buff);
    formation = AggregateStateFormation.unmarshalEnum(buff);
    aggregateMarking.unmarshal(buff);
    dimensions.unmarshal(buff);
    orientation.unmarshal(buff);
    centerOfMass.unmarshal(buff);
    velocity.unmarshal(buff);
    numberOfDisAggregates = (short)(buff.getShort() & 0xFFFF);
    numberOfDisEntities = (short)(buff.getShort() & 0xFFFF);
    numberOfSilentAggregateTypes = (short)(buff.getShort() & 0xFFFF);
    numberOfSilentEntityTypes = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfDisAggregates; idx++)
    {
    AggregateIdentifier anX = new AggregateIdentifier();
    anX.unmarshal(buff);
    aggregateIDList.add(anX);
    }

    for(int idx = 0; idx < numberOfDisEntities; idx++)
    {
    EntityID anX = new EntityID();
    anX.unmarshal(buff);
    entityIDList.add(anX);
    }

    padTo32 = new byte[Align.from32bits(buff)];
    for(int idx = 0; idx < numberOfSilentAggregateTypes; idx++)
    {
    EntityType anX = new EntityType();
    anX.unmarshal(buff);
    silentAggregateSystemList.add(anX);
    }

    for(int idx = 0; idx < numberOfSilentEntityTypes; idx++)
    {
    EntityType anX = new EntityType();
    anX.unmarshal(buff);
    silentEntitySystemList.add(anX);
    }

    numberOfVariableDatumRecords = buff.getInt();
    for(int idx = 0; idx < numberOfVariableDatumRecords; idx++)
    {
    VariableDatum anX = new VariableDatum();
    anX.unmarshal(buff);
    variableDatumList.add(anX);
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

    if(!(obj instanceof AggregateStatePdu))
        return false;

     final AggregateStatePdu rhs = (AggregateStatePdu)obj;

     if( ! (aggregateID.equals( rhs.aggregateID) )) ivarsEqual = false;
     if( ! (forceID == rhs.forceID)) ivarsEqual = false;
     if( ! (aggregateState == rhs.aggregateState)) ivarsEqual = false;
     if( ! (aggregateType.equals( rhs.aggregateType) )) ivarsEqual = false;
     if( ! (formation == rhs.formation)) ivarsEqual = false;
     if( ! (aggregateMarking.equals( rhs.aggregateMarking) )) ivarsEqual = false;
     if( ! (dimensions.equals( rhs.dimensions) )) ivarsEqual = false;
     if( ! (orientation.equals( rhs.orientation) )) ivarsEqual = false;
     if( ! (centerOfMass.equals( rhs.centerOfMass) )) ivarsEqual = false;
     if( ! (velocity.equals( rhs.velocity) )) ivarsEqual = false;
     if( ! (numberOfDisAggregates == rhs.numberOfDisAggregates)) ivarsEqual = false;
     if( ! (numberOfDisEntities == rhs.numberOfDisEntities)) ivarsEqual = false;
     if( ! (numberOfSilentAggregateTypes == rhs.numberOfSilentAggregateTypes)) ivarsEqual = false;
     if( ! (numberOfSilentEntityTypes == rhs.numberOfSilentEntityTypes)) ivarsEqual = false;

     for(int idx = 0; idx < aggregateIDList.size(); idx++)
        if( ! ( aggregateIDList.get(idx).equals(rhs.aggregateIDList.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < entityIDList.size(); idx++)
        if( ! ( entityIDList.get(idx).equals(rhs.entityIDList.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < silentAggregateSystemList.size(); idx++)
        if( ! ( silentAggregateSystemList.get(idx).equals(rhs.silentAggregateSystemList.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < silentEntitySystemList.size(); idx++)
        if( ! ( silentEntitySystemList.get(idx).equals(rhs.silentEntitySystemList.get(idx)))) ivarsEqual = false;

     if( ! (numberOfVariableDatumRecords == rhs.numberOfVariableDatumRecords)) ivarsEqual = false;

     for(int idx = 0; idx < variableDatumList.size(); idx++)
        if( ! ( variableDatumList.get(idx).equals(rhs.variableDatumList.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
