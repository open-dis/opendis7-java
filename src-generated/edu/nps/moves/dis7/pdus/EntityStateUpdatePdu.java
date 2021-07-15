/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.2.5. Nonstatic information about a particular entity may be communicated by issuing an Entity State Update PDU. 5.3.5.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EntityStateUpdatePdu extends EntityInformationFamilyPdu implements Serializable
{
   /** This field shall identify the entity issuing the PDU, and shall be represented by an Entity Identifier record (see 6.2.28). */
   protected EntityID  entityID = new EntityID(); 

   /** Padding */
   protected byte  padding1;

   /** This field shall specify the number of variable parameters present. This field shall be represented by an 8-bit unsigned integer (see Annex I). */
   protected byte  numberOfVariableParameters;

   /** This field shall specify an entity's linear velocity. The coordinate system for an entity's linear velocity depends on the dead reckoning algorithm used. This field shall be represented by a Linear Velocity Vector record [see 6.2.95 item c)]). */
   protected Vector3Float  entityLinearVelocity = new Vector3Float(); 

   /** This field shall specify an entity's physical location in the simulated world and shall be represented by a World Coordinates record (see 6.2.97). */
   protected Vector3Double  entityLocation = new Vector3Double(); 

   /** This field shall specify an entity's orientation and shall be represented by an Euler Angles record (see 6.2.33). */
   protected EulerAngles  entityOrientation = new EulerAngles(); 

   /** This field shall specify the dynamic changes to the entity's appearance attributes. This field shall be represented by an Entity Appearance record (see 6.2.26). */
   protected int  entityAppearance;

   /** This field shall specify the parameter values for each Variable Parameter record that is included (see 6.2.93 and Annex I). */
   protected List< VariableParameter > variableParameters = new ArrayList< VariableParameter >();
 

/** Constructor */
 public EntityStateUpdatePdu()
 {
    setPduType( DISPDUType.ENTITY_STATE_UPDATE );
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
   marshalSize += entityID.getMarshalledSize();
   marshalSize += 1;  // padding1
   marshalSize += 1;  // numberOfVariableParameters
   marshalSize += entityLinearVelocity.getMarshalledSize();
   marshalSize += entityLocation.getMarshalledSize();
   marshalSize += entityOrientation.getMarshalledSize();
   marshalSize += 4;  // entityAppearance
   for(int idx=0; idx < variableParameters.size(); idx++)
   {
        VariableParameter listElement = variableParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link EntityStateUpdatePdu#entityID}
  * @param pEntityID new value of interest
  * @return same object to permit progressive setters */
public EntityStateUpdatePdu setEntityID(EntityID pEntityID)
{
    entityID = pEntityID;
    return this;
}

/** Getter for {@link EntityStateUpdatePdu#entityID}
  * @return value of interest */
public EntityID getEntityID()
{
    return entityID; 
}

/** Setter for {@link EntityStateUpdatePdu#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public EntityStateUpdatePdu setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}
/** Utility setter for {@link EntityStateUpdatePdu#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public EntityStateUpdatePdu setPadding1(int pPadding1){
    padding1 = (byte) pPadding1;
    return this;
}

/** Getter for {@link EntityStateUpdatePdu#padding1}
  * @return value of interest */
public byte getPadding1()
{
    return padding1; 
}

/** Setter for {@link EntityStateUpdatePdu#entityLinearVelocity}
  * @param pEntityLinearVelocity new value of interest
  * @return same object to permit progressive setters */
public EntityStateUpdatePdu setEntityLinearVelocity(Vector3Float pEntityLinearVelocity)
{
    entityLinearVelocity = pEntityLinearVelocity;
    return this;
}

/** Getter for {@link EntityStateUpdatePdu#entityLinearVelocity}
  * @return value of interest */
public Vector3Float getEntityLinearVelocity()
{
    return entityLinearVelocity; 
}

/** Setter for {@link EntityStateUpdatePdu#entityLocation}
  * @param pEntityLocation new value of interest
  * @return same object to permit progressive setters */
public EntityStateUpdatePdu setEntityLocation(Vector3Double pEntityLocation)
{
    entityLocation = pEntityLocation;
    return this;
}

/** Getter for {@link EntityStateUpdatePdu#entityLocation}
  * @return value of interest */
public Vector3Double getEntityLocation()
{
    return entityLocation; 
}

/** Setter for {@link EntityStateUpdatePdu#entityOrientation}
  * @param pEntityOrientation new value of interest
  * @return same object to permit progressive setters */
public EntityStateUpdatePdu setEntityOrientation(EulerAngles pEntityOrientation)
{
    entityOrientation = pEntityOrientation;
    return this;
}

/** Getter for {@link EntityStateUpdatePdu#entityOrientation}
  * @return value of interest */
public EulerAngles getEntityOrientation()
{
    return entityOrientation; 
}

/** Setter for {@link EntityStateUpdatePdu#entityAppearance}
  * @param pEntityAppearance new value of interest
  * @return same object to permit progressive setters */
public EntityStateUpdatePdu setEntityAppearance(int pEntityAppearance)
{
    entityAppearance = pEntityAppearance;
    return this;
}

/** Getter for {@link EntityStateUpdatePdu#entityAppearance}
  * @return value of interest */
public int getEntityAppearance()
{
    return entityAppearance; 
}

/** Setter for {@link EntityStateUpdatePdu#variableParameters}
  * @param pVariableParameters new value of interest
  * @return same object to permit progressive setters */
public EntityStateUpdatePdu setVariableParameters(List<VariableParameter> pVariableParameters)
{
    variableParameters = pVariableParameters;
    return this;
}

/** Getter for {@link EntityStateUpdatePdu#variableParameters}
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
       dos.writeByte(padding1);
       dos.writeByte(variableParameters.size());
       entityLinearVelocity.marshal(dos);
       entityLocation.marshal(dos);
       entityOrientation.marshal(dos);
       dos.writeInt(entityAppearance);

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
        uPosition += entityID.unmarshal(dis);
        padding1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfVariableParameters = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += entityLinearVelocity.unmarshal(dis);
        uPosition += entityLocation.unmarshal(dis);
        uPosition += entityOrientation.unmarshal(dis);
        entityAppearance = dis.readInt();
        uPosition += 4;
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
   byteBuffer.put( (byte)padding1);
   byteBuffer.put( (byte)variableParameters.size());
   entityLinearVelocity.marshal(byteBuffer);
   entityLocation.marshal(byteBuffer);
   entityOrientation.marshal(byteBuffer);
   byteBuffer.putInt( (int)entityAppearance);

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
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    entityID.unmarshal(byteBuffer);
    padding1 = (byte)(byteBuffer.get() & 0xFF);
    numberOfVariableParameters = (byte)(byteBuffer.get() & 0xFF);
    entityLinearVelocity.unmarshal(byteBuffer);
    entityLocation.unmarshal(byteBuffer);
    entityOrientation.unmarshal(byteBuffer);
    entityAppearance = byteBuffer.getInt();
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

     final EntityStateUpdatePdu rhs = (EntityStateUpdatePdu)obj;

     if( ! (entityID.equals( rhs.entityID) )) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (entityLinearVelocity.equals( rhs.entityLinearVelocity) )) ivarsEqual = false;
     if( ! (entityLocation.equals( rhs.entityLocation) )) ivarsEqual = false;
     if( ! (entityOrientation.equals( rhs.entityOrientation) )) ivarsEqual = false;
     if( ! (entityAppearance == rhs.entityAppearance)) ivarsEqual = false;

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
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" entityLinearVelocity: ").append(entityLinearVelocity).append("\n");
    sb.append(" entityLocation: ").append(entityLocation).append("\n");
    sb.append(" entityOrientation: ").append(entityOrientation).append("\n");
    sb.append(" entityAppearance: ").append(entityAppearance).append("\n");
    sb.append(" variableParameters: ").append("\n");
    variableParameters.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
