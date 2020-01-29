/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.3.3 Used to communicate the detonation or impact of munitions, as well as non-munition explosions, the burst or initial bloom of chaff, and the ignition of a flare.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class DetonationPdu extends WarfareFamilyPdu implements Serializable
{
   /** ID of the entity that shot */
   protected EntityID  sourceEntityID = new EntityID(); 

   /** ID of the entity that is being shot at */
   protected EntityID  targetEntityID = new EntityID(); 

   /** ID of the expendable entity, Section 7.3.3  */
   protected EntityID  explodingEntityID = new EntityID(); 

   /** ID of event, Section 7.3.3 */
   protected EventIdentifier  eventID = new EventIdentifier(); 

   /** velocity of the munition immediately before detonation/impact, Section 7.3.3  */
   protected Vector3Float  velocity = new Vector3Float(); 

   /** location of the munition detonation, the expendable detonation, Section 7.3.3  */
   protected Vector3Double  locationInWorldCoordinates = new Vector3Double(); 

   /** Describes the detonation represented, Section 7.3.3  */
   protected MunitionDescriptor  descriptor = new MunitionDescriptor(); 

   /** Velocity of the ammunition, Section 7.3.3  */
   protected Vector3Float  locationOfEntityCoordinates = new Vector3Float(); 

   /** result of the detonation, Section 7.3.3  uid 62 */
   protected DetonationResult detonationResult = DetonationResult.values()[0];

   /** How many articulation parameters we have, Section 7.3.3  */
   protected byte  numberOfVariableParameters;

   /** padding */
   protected short  pad;

   /** specify the parameter values for each Variable Parameter record, Section 7.3.3  */
   protected List< VariableParameter > variableParameters = new ArrayList< VariableParameter >();
 

/** Constructor */
 public DetonationPdu()
 {
    setPduType( DISPDUType.DETONATION );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += sourceEntityID.getMarshalledSize();
   marshalSize += targetEntityID.getMarshalledSize();
   marshalSize += explodingEntityID.getMarshalledSize();
   marshalSize += eventID.getMarshalledSize();
   marshalSize += velocity.getMarshalledSize();
   marshalSize += locationInWorldCoordinates.getMarshalledSize();
   marshalSize += descriptor.getMarshalledSize();
   marshalSize += locationOfEntityCoordinates.getMarshalledSize();
   marshalSize += detonationResult.getMarshalledSize();
   marshalSize += 1;  // numberOfVariableParameters
   marshalSize += 2;  // pad
   for(int idx=0; idx < variableParameters.size(); idx++)
   {
        VariableParameter listElement = variableParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link DetonationPdu#sourceEntityID}*/
public DetonationPdu setSourceEntityID(EntityID pSourceEntityID)
{
    sourceEntityID = pSourceEntityID;
    return this;
}

/** Getter for {@link DetonationPdu#sourceEntityID}*/
public EntityID getSourceEntityID()
{
    return sourceEntityID; 
}

/** Setter for {@link DetonationPdu#targetEntityID}*/
public DetonationPdu setTargetEntityID(EntityID pTargetEntityID)
{
    targetEntityID = pTargetEntityID;
    return this;
}

/** Getter for {@link DetonationPdu#targetEntityID}*/
public EntityID getTargetEntityID()
{
    return targetEntityID; 
}

/** Setter for {@link DetonationPdu#explodingEntityID}*/
public DetonationPdu setExplodingEntityID(EntityID pExplodingEntityID)
{
    explodingEntityID = pExplodingEntityID;
    return this;
}

/** Getter for {@link DetonationPdu#explodingEntityID}*/
public EntityID getExplodingEntityID()
{
    return explodingEntityID; 
}

/** Setter for {@link DetonationPdu#eventID}*/
public DetonationPdu setEventID(EventIdentifier pEventID)
{
    eventID = pEventID;
    return this;
}

/** Getter for {@link DetonationPdu#eventID}*/
public EventIdentifier getEventID()
{
    return eventID; 
}

/** Setter for {@link DetonationPdu#velocity}*/
public DetonationPdu setVelocity(Vector3Float pVelocity)
{
    velocity = pVelocity;
    return this;
}

/** Getter for {@link DetonationPdu#velocity}*/
public Vector3Float getVelocity()
{
    return velocity; 
}

/** Setter for {@link DetonationPdu#locationInWorldCoordinates}*/
public DetonationPdu setLocationInWorldCoordinates(Vector3Double pLocationInWorldCoordinates)
{
    locationInWorldCoordinates = pLocationInWorldCoordinates;
    return this;
}

/** Getter for {@link DetonationPdu#locationInWorldCoordinates}*/
public Vector3Double getLocationInWorldCoordinates()
{
    return locationInWorldCoordinates; 
}

/** Setter for {@link DetonationPdu#descriptor}*/
public DetonationPdu setDescriptor(MunitionDescriptor pDescriptor)
{
    descriptor = pDescriptor;
    return this;
}

/** Getter for {@link DetonationPdu#descriptor}*/
public MunitionDescriptor getDescriptor()
{
    return descriptor; 
}

/** Setter for {@link DetonationPdu#locationOfEntityCoordinates}*/
public DetonationPdu setLocationOfEntityCoordinates(Vector3Float pLocationOfEntityCoordinates)
{
    locationOfEntityCoordinates = pLocationOfEntityCoordinates;
    return this;
}

/** Getter for {@link DetonationPdu#locationOfEntityCoordinates}*/
public Vector3Float getLocationOfEntityCoordinates()
{
    return locationOfEntityCoordinates; 
}

/** Setter for {@link DetonationPdu#detonationResult}*/
public DetonationPdu setDetonationResult(DetonationResult pDetonationResult)
{
    detonationResult = pDetonationResult;
    return this;
}

/** Getter for {@link DetonationPdu#detonationResult}*/
public DetonationResult getDetonationResult()
{
    return detonationResult; 
}

/** Setter for {@link DetonationPdu#pad}*/
public DetonationPdu setPad(short pPad)
{
    pad = pPad;
    return this;
}

/** Getter for {@link DetonationPdu#pad}*/
public short getPad()
{
    return pad; 
}

/** Setter for {@link DetonationPdu#variableParameters}*/
public DetonationPdu setVariableParameters(List<VariableParameter> pVariableParameters)
{
    variableParameters = pVariableParameters;
    return this;
}

/** Getter for {@link DetonationPdu#variableParameters}*/
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
       sourceEntityID.marshal(dos);
       targetEntityID.marshal(dos);
       explodingEntityID.marshal(dos);
       eventID.marshal(dos);
       velocity.marshal(dos);
       locationInWorldCoordinates.marshal(dos);
       descriptor.marshal(dos);
       locationOfEntityCoordinates.marshal(dos);
       detonationResult.marshal(dos);
       dos.writeByte( (byte)variableParameters.size());
       dos.writeShort( (short)pad);

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
        uPosition += sourceEntityID.unmarshal(dis);
        uPosition += targetEntityID.unmarshal(dis);
        uPosition += explodingEntityID.unmarshal(dis);
        uPosition += eventID.unmarshal(dis);
        uPosition += velocity.unmarshal(dis);
        uPosition += locationInWorldCoordinates.unmarshal(dis);
        uPosition += descriptor.unmarshal(dis);
        uPosition += locationOfEntityCoordinates.unmarshal(dis);
        detonationResult = DetonationResult.unmarshalEnum(dis);
        uPosition += detonationResult.getMarshalledSize();
        numberOfVariableParameters = (byte)dis.readUnsignedByte();
        uPosition += 1;
        pad = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   sourceEntityID.marshal(buff);
   targetEntityID.marshal(buff);
   explodingEntityID.marshal(buff);
   eventID.marshal(buff);
   velocity.marshal(buff);
   locationInWorldCoordinates.marshal(buff);
   descriptor.marshal(buff);
   locationOfEntityCoordinates.marshal(buff);
   detonationResult.marshal(buff);
   buff.put( (byte)variableParameters.size());
   buff.putShort( (short)pad);

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

    sourceEntityID.unmarshal(buff);
    targetEntityID.unmarshal(buff);
    explodingEntityID.unmarshal(buff);
    eventID.unmarshal(buff);
    velocity.unmarshal(buff);
    locationInWorldCoordinates.unmarshal(buff);
    descriptor.unmarshal(buff);
    locationOfEntityCoordinates.unmarshal(buff);
    detonationResult = DetonationResult.unmarshalEnum(buff);
    numberOfVariableParameters = (byte)(buff.get() & 0xFF);
    pad = (short)(buff.getShort() & 0xFFFF);
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

     final DetonationPdu rhs = (DetonationPdu)obj;

     if( ! (sourceEntityID.equals( rhs.sourceEntityID) )) ivarsEqual = false;
     if( ! (targetEntityID.equals( rhs.targetEntityID) )) ivarsEqual = false;
     if( ! (explodingEntityID.equals( rhs.explodingEntityID) )) ivarsEqual = false;
     if( ! (eventID.equals( rhs.eventID) )) ivarsEqual = false;
     if( ! (velocity.equals( rhs.velocity) )) ivarsEqual = false;
     if( ! (locationInWorldCoordinates.equals( rhs.locationInWorldCoordinates) )) ivarsEqual = false;
     if( ! (descriptor.equals( rhs.descriptor) )) ivarsEqual = false;
     if( ! (locationOfEntityCoordinates.equals( rhs.locationOfEntityCoordinates) )) ivarsEqual = false;
     if( ! (detonationResult == rhs.detonationResult)) ivarsEqual = false;
     if( ! (pad == rhs.pad)) ivarsEqual = false;

     for(int idx = 0; idx < variableParameters.size(); idx++)
        if( ! ( variableParameters.get(idx).equals(rhs.variableParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" sourceEntityID: ").append(sourceEntityID).append("\n");
    sb.append(" targetEntityID: ").append(targetEntityID).append("\n");
    sb.append(" explodingEntityID: ").append(explodingEntityID).append("\n");
    sb.append(" eventID: ").append(eventID).append("\n");
    sb.append(" velocity: ").append(velocity).append("\n");
    sb.append(" locationInWorldCoordinates: ").append(locationInWorldCoordinates).append("\n");
    sb.append(" descriptor: ").append(descriptor).append("\n");
    sb.append(" locationOfEntityCoordinates: ").append(locationOfEntityCoordinates).append("\n");
    sb.append(" detonationResult: ").append(detonationResult).append("\n");
    sb.append(" pad: ").append(pad).append("\n");
    sb.append(" variableParameters: ").append("\n");
    variableParameters.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
