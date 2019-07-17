package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Represents the postion and state of one entity in the world. Section 7.2.2.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class EntityStatePdu extends EntityInformationFamilyPdu implements Serializable
{
   /** Unique ID for an entity that is tied to this state information */
   protected EntityID  entityID = new EntityID(); 

   /** What force this entity is affiliated with, eg red, blue, neutral, etc uid 6 */
   protected ForceID forceId = ForceID.values()[0];

   /** How many variable parameters are in the variable length list. In earlier versions of DIS these were known as articulation parameters */
   protected byte  numberOfVariableParameters;

   /** Describes the type of entity in the world */
   protected EntityType  entityType = new EntityType(); 

   protected EntityType  alternativeEntityType = new EntityType(); 

   /** Describes the speed of the entity in the world */
   protected Vector3Float  entityLinearVelocity = new Vector3Float(); 

   /** describes the location of the entity in the world */
   protected Vector3Double  entityLocation = new Vector3Double(); 

   /** describes the orientation of the entity, in euler angles */
   protected EulerAngles  entityOrientation = new EulerAngles(); 

   /** a series of bit flags that are used to help draw the entity, such as smoking, on fire, etc. */
   protected int  entityAppearance;

   /** parameters used for dead reckoning */
   protected DeadReckoningParameters  deadReckoningParameters = new DeadReckoningParameters(); 

   /** characters that can be used for debugging, or to draw unique strings on the side of entities in the world */
   protected EntityMarking  marking = new EntityMarking(); 

   /** a series of bit flags uid 55 */
   protected EntityCapabilities capabilities = new LandPlatformCapabilities();

   /** variable length list of variable parameters. In earlier DIS versions this was articulation parameters. */
   protected List< VariableParameter > variableParameters = new ArrayList< VariableParameter >();
 

/** Constructor */
 public EntityStatePdu()
 {
    setPduType( DISPDUType.ENTITY_STATE );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += entityID.getMarshalledSize();
   marshalSize += forceId.getMarshalledSize();
   marshalSize += 1;  // numberOfVariableParameters
   marshalSize += entityType.getMarshalledSize();
   marshalSize += alternativeEntityType.getMarshalledSize();
   marshalSize += entityLinearVelocity.getMarshalledSize();
   marshalSize += entityLocation.getMarshalledSize();
   marshalSize += entityOrientation.getMarshalledSize();
   marshalSize += 4;  // entityAppearance
   marshalSize += deadReckoningParameters.getMarshalledSize();
   marshalSize += marking.getMarshalledSize();
   for(int idx=0; idx < variableParameters.size(); idx++)
   {
        VariableParameter listElement = variableParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public EntityStatePdu setEntityID(EntityID pEntityID)
{
    entityID = pEntityID;
    return this;
}

public EntityID getEntityID()
{
    return entityID; 
}

public EntityStatePdu setForceId(ForceID pForceId)
{
    forceId = pForceId;
    return this;
}

public ForceID getForceId()
{
    return forceId; 
}

public EntityStatePdu setEntityType(EntityType pEntityType)
{
    entityType = pEntityType;
    return this;
}

public EntityType getEntityType()
{
    return entityType; 
}

public EntityStatePdu setAlternativeEntityType(EntityType pAlternativeEntityType)
{
    alternativeEntityType = pAlternativeEntityType;
    return this;
}

public EntityType getAlternativeEntityType()
{
    return alternativeEntityType; 
}

public EntityStatePdu setEntityLinearVelocity(Vector3Float pEntityLinearVelocity)
{
    entityLinearVelocity = pEntityLinearVelocity;
    return this;
}

public Vector3Float getEntityLinearVelocity()
{
    return entityLinearVelocity; 
}

public EntityStatePdu setEntityLocation(Vector3Double pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

public Vector3Double getEntityLocation()
{
    return entityLocation; 
}

public EntityStatePdu setEntityOrientation(EulerAngles pEntityOrientation)
{
    entityOrientation = pEntityOrientation;
    return this;
}

public EulerAngles getEntityOrientation()
{
    return entityOrientation; 
}

public EntityStatePdu setEntityAppearance(int pEntityAppearance)
{
    entityAppearance = pEntityAppearance;
    return this;
}

public int getEntityAppearance()
{
    return entityAppearance; 
}

public EntityStatePdu setDeadReckoningParameters(DeadReckoningParameters pDeadReckoningParameters)
{
    deadReckoningParameters = pDeadReckoningParameters;
    return this;
}

public DeadReckoningParameters getDeadReckoningParameters()
{
    return deadReckoningParameters; 
}

public EntityStatePdu setMarking(EntityMarking pMarking)
{
    marking = pMarking;
    return this;
}

public EntityMarking getMarking()
{
    return marking; 
}

public EntityStatePdu setCapabilities(EntityCapabilities pCapabilities)
{
    capabilities = pCapabilities;
    return this;
}

public EntityCapabilities getCapabilities()
{
    return capabilities; 
}

public EntityStatePdu setVariableParameters(List<VariableParameter> pVariableParameters)
{
    variableParameters = pVariableParameters;
    return this;
}

public List<VariableParameter> getVariableParameters()
{
    return variableParameters; 
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
       entityID.marshal(dos);
       forceId.marshal(dos);
       dos.writeByte( (byte)variableParameters.size());
       entityType.marshal(dos);
       alternativeEntityType.marshal(dos);
       entityLinearVelocity.marshal(dos);
       entityLocation.marshal(dos);
       entityOrientation.marshal(dos);
       dos.writeInt( (int)entityAppearance);
       deadReckoningParameters.marshal(dos);
       marking.marshal(dos);
       capabilities.marshal(dos);

       for(int idx = 0; idx < variableParameters.size(); idx++)
       {
            VariableParameter aVariableParameter = variableParameters.get(idx);
            aVariableParameter.marshal(dos);
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
 */
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += entityID.unmarshal(dis);
        forceId = ForceID.unmarshalEnum(dis);
        uPosition += forceId.getMarshalledSize();
        numberOfVariableParameters = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += entityType.unmarshal(dis);
        uPosition += alternativeEntityType.unmarshal(dis);
        uPosition += entityLinearVelocity.unmarshal(dis);
        uPosition += entityLocation.unmarshal(dis);
        uPosition += entityOrientation.unmarshal(dis);
        entityAppearance = dis.readInt();
        uPosition += 4;
        uPosition += deadReckoningParameters.unmarshal(dis);
        uPosition += marking.unmarshal(dis);
        uPosition += capabilities.unmarshal(dis);
        for(int idx = 0; idx < numberOfVariableParameters; idx++)
        {
            VariableParameter anX = new VariableParameter();
            uPosition += anX.unmarshal(dis);
            variableParameters.add(anX);
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
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   super.marshal(buff);
   entityID.marshal(buff);
   forceId.marshal(buff);
   buff.put( (byte)variableParameters.size());
   entityType.marshal(buff);
   alternativeEntityType.marshal(buff);
   entityLinearVelocity.marshal(buff);
   entityLocation.marshal(buff);
   entityOrientation.marshal(buff);
   buff.putInt( (int)entityAppearance);
   deadReckoningParameters.marshal(buff);
   marking.marshal(buff);
   capabilities.marshal(buff);

   for(int idx = 0; idx < variableParameters.size(); idx++)
   {
        VariableParameter aVariableParameter = (VariableParameter)variableParameters.get(idx);
        aVariableParameter.marshal(buff);
   }

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

    entityID.unmarshal(buff);
    forceId = ForceID.unmarshalEnum(buff);
    numberOfVariableParameters = (byte)(buff.get() & 0xFF);
    entityType.unmarshal(buff);
    alternativeEntityType.unmarshal(buff);
    entityLinearVelocity.unmarshal(buff);
    entityLocation.unmarshal(buff);
    entityOrientation.unmarshal(buff);
    entityAppearance = buff.getInt();
    deadReckoningParameters.unmarshal(buff);
    marking.unmarshal(buff);
    capabilities.unmarshal(buff);
    for(int idx = 0; idx < numberOfVariableParameters; idx++)
    {
    VariableParameter anX = new VariableParameter();
    anX.unmarshal(buff);
    variableParameters.add(anX);
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

    if(!(obj instanceof EntityStatePdu))
        return false;

     final EntityStatePdu rhs = (EntityStatePdu)obj;

     if( ! (entityID.equals( rhs.entityID) )) ivarsEqual = false;
     if( ! (forceId == rhs.forceId)) ivarsEqual = false;
     if( ! (numberOfVariableParameters == rhs.numberOfVariableParameters)) ivarsEqual = false;
     if( ! (entityType.equals( rhs.entityType) )) ivarsEqual = false;
     if( ! (alternativeEntityType.equals( rhs.alternativeEntityType) )) ivarsEqual = false;
     if( ! (entityLinearVelocity.equals( rhs.entityLinearVelocity) )) ivarsEqual = false;
     if( ! (entityLocation.equals( rhs.entityLocation) )) ivarsEqual = false;
     if( ! (entityOrientation.equals( rhs.entityOrientation) )) ivarsEqual = false;
     if( ! (entityAppearance == rhs.entityAppearance)) ivarsEqual = false;
     if( ! (deadReckoningParameters.equals( rhs.deadReckoningParameters) )) ivarsEqual = false;
     if( ! (marking.equals( rhs.marking) )) ivarsEqual = false;

     for(int idx = 0; idx < variableParameters.size(); idx++)
        if( ! ( variableParameters.get(idx).equals(rhs.variableParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
