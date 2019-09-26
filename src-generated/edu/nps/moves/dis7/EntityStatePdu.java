/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  7.2.2. Represents the postion and state of one entity in the world. See 5.3.2.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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

/** Returns the size of this serialized object in bytes*/
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
   marshalSize += capabilities.getMarshalledSize();
   for(int idx=0; idx < variableParameters.size(); idx++)
   {
        VariableParameter listElement = variableParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link EntityStatePdu#entityID}*/
public EntityStatePdu setEntityID(EntityID pEntityID)
{
    entityID = pEntityID;
    return this;
}

/** Getter for {@link EntityStatePdu#entityID}*/
public EntityID getEntityID()
{
    return entityID; 
}

/** Setter for {@link EntityStatePdu#forceId}*/
public EntityStatePdu setForceId(ForceID pForceId)
{
    forceId = pForceId;
    return this;
}

/** Getter for {@link EntityStatePdu#forceId}*/
public ForceID getForceId()
{
    return forceId; 
}

/** Setter for {@link EntityStatePdu#entityType}*/
public EntityStatePdu setEntityType(EntityType pEntityType)
{
    entityType = pEntityType;
    return this;
}

/** Getter for {@link EntityStatePdu#entityType}*/
public EntityType getEntityType()
{
    return entityType; 
}

/** Setter for {@link EntityStatePdu#alternativeEntityType}*/
public EntityStatePdu setAlternativeEntityType(EntityType pAlternativeEntityType)
{
    alternativeEntityType = pAlternativeEntityType;
    return this;
}

/** Getter for {@link EntityStatePdu#alternativeEntityType}*/
public EntityType getAlternativeEntityType()
{
    return alternativeEntityType; 
}

/** Setter for {@link EntityStatePdu#entityLinearVelocity}*/
public EntityStatePdu setEntityLinearVelocity(Vector3Float pEntityLinearVelocity)
{
    entityLinearVelocity = pEntityLinearVelocity;
    return this;
}

/** Getter for {@link EntityStatePdu#entityLinearVelocity}*/
public Vector3Float getEntityLinearVelocity()
{
    return entityLinearVelocity; 
}

/** Setter for {@link EntityStatePdu#entityLocation}*/
public EntityStatePdu setEntityLocation(Vector3Double pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

/** Getter for {@link EntityStatePdu#entityLocation}*/
public Vector3Double getEntityLocation()
{
    return entityLocation; 
}

/** Setter for {@link EntityStatePdu#entityOrientation}*/
public EntityStatePdu setEntityOrientation(EulerAngles pEntityOrientation)
{
    entityOrientation = pEntityOrientation;
    return this;
}

/** Getter for {@link EntityStatePdu#entityOrientation}*/
public EulerAngles getEntityOrientation()
{
    return entityOrientation; 
}

/** Setter for {@link EntityStatePdu#entityAppearance}*/
public EntityStatePdu setEntityAppearance(int pEntityAppearance)
{
    entityAppearance = pEntityAppearance;
    return this;
}

/** Getter for {@link EntityStatePdu#entityAppearance}*/
public int getEntityAppearance()
{
    return entityAppearance; 
}

/** Setter for {@link EntityStatePdu#deadReckoningParameters}*/
public EntityStatePdu setDeadReckoningParameters(DeadReckoningParameters pDeadReckoningParameters)
{
    deadReckoningParameters = pDeadReckoningParameters;
    return this;
}

/** Getter for {@link EntityStatePdu#deadReckoningParameters}*/
public DeadReckoningParameters getDeadReckoningParameters()
{
    return deadReckoningParameters; 
}

/** Setter for {@link EntityStatePdu#marking}*/
public EntityStatePdu setMarking(EntityMarking pMarking)
{
    marking = pMarking;
    return this;
}

/** Getter for {@link EntityStatePdu#marking}*/
public EntityMarking getMarking()
{
    return marking; 
}

/** Setter for {@link EntityStatePdu#capabilities}*/
public EntityStatePdu setCapabilities(EntityCapabilities pCapabilities)
{
    capabilities = pCapabilities;
    return this;
}

/** Setter for {@link EntityStatePdu#capabilities}*/
public EntityCapabilities getCapabilities()
{
    return capabilities; 
}

/** Setter for {@link EntityStatePdu#variableParameters}*/
public EntityStatePdu setVariableParameters(List<VariableParameter> pVariableParameters)
{
    variableParameters = pVariableParameters;
    return this;
}

/** Getter for {@link EntityStatePdu#variableParameters}*/
public List<VariableParameter> getVariableParameters()
{
    return variableParameters; 
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
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
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
 * @throws Exception ByteBuffer-generated exception
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
 * @return marshalled size
 * @throws Exception ByteBuffer-generated exception
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

     final EntityStatePdu rhs = (EntityStatePdu)obj;

     if( ! (entityID.equals( rhs.entityID) )) ivarsEqual = false;
     if( ! (forceId == rhs.forceId)) ivarsEqual = false;
     if( ! (entityType.equals( rhs.entityType) )) ivarsEqual = false;
     if( ! (alternativeEntityType.equals( rhs.alternativeEntityType) )) ivarsEqual = false;
     if( ! (entityLinearVelocity.equals( rhs.entityLinearVelocity) )) ivarsEqual = false;
     if( ! (entityLocation.equals( rhs.entityLocation) )) ivarsEqual = false;
     if( ! (entityOrientation.equals( rhs.entityOrientation) )) ivarsEqual = false;
     if( ! (entityAppearance == rhs.entityAppearance)) ivarsEqual = false;
     if( ! (deadReckoningParameters.equals( rhs.deadReckoningParameters) )) ivarsEqual = false;
     if( ! (marking.equals( rhs.marking) )) ivarsEqual = false;
     if( ! (capabilities.equals( rhs.capabilities) )) ivarsEqual = false;

     for(int idx = 0; idx < variableParameters.size(); idx++)
        if( ! ( variableParameters.get(idx).equals(rhs.variableParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" entityID: ").append(entityID).append("\n");
    sb.append(" forceId: ").append(forceId).append("\n");
    sb.append(" entityType: ").append(entityType).append("\n");
    sb.append(" alternativeEntityType: ").append(alternativeEntityType).append("\n");
    sb.append(" entityLinearVelocity: ").append(entityLinearVelocity).append("\n");
    sb.append(" entityLocation: ").append(entityLocation).append("\n");
    sb.append(" entityOrientation: ").append(entityOrientation).append("\n");
    sb.append(" entityAppearance: ").append(entityAppearance).append("\n");
    sb.append(" deadReckoningParameters: ").append(deadReckoningParameters).append("\n");
    sb.append(" marking: ").append(marking).append("\n");
    sb.append(" capabilities: ").append(capabilities).append("\n");
    sb.append(" variableParameters: ").append("\n");
    variableParameters.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
