/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 *  7.2.2. Represents the position and state of one entity in the world. See 5.3.2.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
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

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
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


/** Setter for {@link EntityStatePdu#entityID}
  * @param pEntityID new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setEntityID(EntityID pEntityID)
{
    entityID = pEntityID;
    return this;
}

/** Getter for {@link EntityStatePdu#entityID}
  * @return value of interest */
public EntityID getEntityID()
{
    return entityID; 
}

/** Setter for {@link EntityStatePdu#forceId}
  * @param pForceId new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setForceId(ForceID pForceId)
{
    forceId = pForceId;
    return this;
}

/** Getter for {@link EntityStatePdu#forceId}
  * @return value of interest */
public ForceID getForceId()
{
    return forceId; 
}

/** Setter for {@link EntityStatePdu#entityType}
  * @param pEntityType new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setEntityType(EntityType pEntityType)
{
    entityType = pEntityType;
    return this;
}

/** Getter for {@link EntityStatePdu#entityType}
  * @return value of interest */
public EntityType getEntityType()
{
    return entityType; 
}

/** Setter for {@link EntityStatePdu#alternativeEntityType}
  * @param pAlternativeEntityType new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setAlternativeEntityType(EntityType pAlternativeEntityType)
{
    alternativeEntityType = pAlternativeEntityType;
    return this;
}

/** Getter for {@link EntityStatePdu#alternativeEntityType}
  * @return value of interest */
public EntityType getAlternativeEntityType()
{
    return alternativeEntityType; 
}

/** Setter for {@link EntityStatePdu#entityLinearVelocity}
  * @param pEntityLinearVelocity new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setEntityLinearVelocity(Vector3Float pEntityLinearVelocity)
{
    entityLinearVelocity = pEntityLinearVelocity;
    return this;
}

/** Getter for {@link EntityStatePdu#entityLinearVelocity}
  * @return value of interest */
public Vector3Float getEntityLinearVelocity()
{
    return entityLinearVelocity; 
}

/** Setter for {@link EntityStatePdu#entityLocation}
  * @param pEntityLocation new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setEntityLocation(Vector3Double pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

/** Getter for {@link EntityStatePdu#entityLocation}
  * @return value of interest */
public Vector3Double getEntityLocation()
{
    return entityLocation; 
}

/** Setter for {@link EntityStatePdu#entityOrientation}
  * @param pEntityOrientation new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setEntityOrientation(EulerAngles pEntityOrientation)
{
    entityOrientation = pEntityOrientation;
    return this;
}

/** Getter for {@link EntityStatePdu#entityOrientation}
  * @return value of interest */
public EulerAngles getEntityOrientation()
{
    return entityOrientation; 
}

/** Setter for {@link EntityStatePdu#entityAppearance}
  * @param pEntityAppearance new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setEntityAppearance(int pEntityAppearance)
{
    entityAppearance = pEntityAppearance;
    return this;
}

/** Getter for {@link EntityStatePdu#entityAppearance}
  * @return value of interest */
public int getEntityAppearance()
{
    return entityAppearance; 
}

/** Setter for {@link EntityStatePdu#deadReckoningParameters}
  * @param pDeadReckoningParameters new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setDeadReckoningParameters(DeadReckoningParameters pDeadReckoningParameters)
{
    deadReckoningParameters = pDeadReckoningParameters;
    return this;
}

/** Getter for {@link EntityStatePdu#deadReckoningParameters}
  * @return value of interest */
public DeadReckoningParameters getDeadReckoningParameters()
{
    return deadReckoningParameters; 
}

/** Setter for {@link EntityStatePdu#marking}
  * @param pMarking new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setMarking(EntityMarking pMarking)
{
    marking = pMarking;
    return this;
}

/** Getter for {@link EntityStatePdu#marking}
  * @return value of interest */
public EntityMarking getMarking()
{
    return marking; 
}

/** Setter for {@link EntityStatePdu#capabilities}
  * @param pCapabilities new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setCapabilities(EntityCapabilities pCapabilities)
{
    capabilities = pCapabilities;
    return this;
}

/** Getter for {@link EntityStatePdu#capabilities}
  * @return value of interest */
public EntityCapabilities getCapabilities()
{
    return capabilities; 
}

/** Setter for {@link EntityStatePdu#variableParameters}
  * @param pVariableParameters new value of interest
  * @return same object to permit progressive setters */
public EntityStatePdu setVariableParameters(List<VariableParameter> pVariableParameters)
{
    variableParameters = pVariableParameters;
    return this;
}

/** Getter for {@link EntityStatePdu#variableParameters}
  * @return value of interest */
public List<VariableParameter> getVariableParameters()
{
    return variableParameters; 
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
       entityID.marshal(dos);
       forceId.marshal(dos);
       dos.writeByte(variableParameters.size());
       entityType.marshal(dos);
       alternativeEntityType.marshal(dos);
       entityLinearVelocity.marshal(dos);
       entityLocation.marshal(dos);
       entityOrientation.marshal(dos);
       dos.writeInt(entityAppearance);
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
 * Deserializes an object from a DataInputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataInputStream
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
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
   entityID.marshal(byteBuffer);
   forceId.marshal(byteBuffer);
   byteBuffer.put( (byte)variableParameters.size());
   entityType.marshal(byteBuffer);
   alternativeEntityType.marshal(byteBuffer);
   entityLinearVelocity.marshal(byteBuffer);
   entityLocation.marshal(byteBuffer);
   entityOrientation.marshal(byteBuffer);
   byteBuffer.putInt( (int)entityAppearance);
   deadReckoningParameters.marshal(byteBuffer);
   marking.marshal(byteBuffer);
   capabilities.marshal(byteBuffer);

   for(int idx = 0; idx < variableParameters.size(); idx++)
   {
        VariableParameter aVariableParameter = variableParameters.get(idx);
        aVariableParameter.marshal(byteBuffer);
   }

}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    entityID.unmarshal(byteBuffer);
    forceId = ForceID.unmarshalEnum(byteBuffer);
    numberOfVariableParameters = (byte)(byteBuffer.get() & 0xFF);
    entityType.unmarshal(byteBuffer);
    alternativeEntityType.unmarshal(byteBuffer);
    entityLinearVelocity.unmarshal(byteBuffer);
    entityLocation.unmarshal(byteBuffer);
    entityOrientation.unmarshal(byteBuffer);
    entityAppearance = byteBuffer.getInt();
    deadReckoningParameters.unmarshal(byteBuffer);
    marking.unmarshal(byteBuffer);
    capabilities.unmarshal(byteBuffer);
    for(int idx = 0; idx < numberOfVariableParameters; idx++)
    {
    VariableParameter anX = new VariableParameter();
    anX.unmarshal(byteBuffer);
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
    sb.append(getClass().getSimpleName()).append(":\n");

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
