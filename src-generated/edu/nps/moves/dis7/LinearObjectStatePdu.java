/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.10.5 Used to communicate detailed information about the addition/modification of a synthetic environment object that is geometrically anchored to the terrain with one point and has size and orientation.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class LinearObjectStatePdu extends SyntheticEnvironmentFamilyPdu implements Serializable
{
   /** Object in synthetic environment */
   protected ObjectIdentifier  objectID = new ObjectIdentifier(); 

   /** Object with which this point object is associated */
   protected ObjectIdentifier  referencedObjectID = new ObjectIdentifier(); 

   /** unique update number of each state transition of an object */
   protected short  updateNumber;

   /** force ID uid 6 */
   protected ForceID forceID = ForceID.values()[0];

   /** number of linear segment parameters */
   protected byte  numberOfLinearSegments;

   /** requesterID */
   protected SimulationAddress  requesterID = new SimulationAddress(); 

   /** receiver ID */
   protected SimulationAddress  receivingID = new SimulationAddress(); 

   /** Object type */
   protected ObjectType  objectType = new ObjectType(); 

   /** Linear segment parameters */
   protected List< LinearSegmentParameter > linearSegmentParameters = new ArrayList< LinearSegmentParameter >();
 

/** Constructor */
 public LinearObjectStatePdu()
 {
    setPduType( DISPDUType.LINEAR_OBJECT_STATE );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += objectID.getMarshalledSize();
   marshalSize += referencedObjectID.getMarshalledSize();
   marshalSize += 2;  // updateNumber
   marshalSize += forceID.getMarshalledSize();
   marshalSize += 1;  // numberOfLinearSegments
   marshalSize += requesterID.getMarshalledSize();
   marshalSize += receivingID.getMarshalledSize();
   marshalSize += objectType.getMarshalledSize();
   for(int idx=0; idx < linearSegmentParameters.size(); idx++)
   {
        LinearSegmentParameter listElement = linearSegmentParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link LinearObjectStatePdu#objectID}*/
public LinearObjectStatePdu setObjectID(ObjectIdentifier pObjectID)
{
    objectID = pObjectID;
    return this;
}

/** Getter for {@link LinearObjectStatePdu#objectID}*/
public ObjectIdentifier getObjectID()
{
    return objectID; 
}

/** Setter for {@link LinearObjectStatePdu#referencedObjectID}*/
public LinearObjectStatePdu setReferencedObjectID(ObjectIdentifier pReferencedObjectID)
{
    referencedObjectID = pReferencedObjectID;
    return this;
}

/** Getter for {@link LinearObjectStatePdu#referencedObjectID}*/
public ObjectIdentifier getReferencedObjectID()
{
    return referencedObjectID; 
}

/** Setter for {@link LinearObjectStatePdu#updateNumber}*/
public LinearObjectStatePdu setUpdateNumber(short pUpdateNumber)
{
    updateNumber = pUpdateNumber;
    return this;
}

/** Getter for {@link LinearObjectStatePdu#updateNumber}*/
public short getUpdateNumber()
{
    return updateNumber; 
}

/** Setter for {@link LinearObjectStatePdu#forceID}*/
public LinearObjectStatePdu setForceID(ForceID pForceID)
{
    forceID = pForceID;
    return this;
}

/** Getter for {@link LinearObjectStatePdu#forceID}*/
public ForceID getForceID()
{
    return forceID; 
}

/** Setter for {@link LinearObjectStatePdu#requesterID}*/
public LinearObjectStatePdu setRequesterID(SimulationAddress pRequesterID)
{
    requesterID = pRequesterID;
    return this;
}

/** Getter for {@link LinearObjectStatePdu#requesterID}*/
public SimulationAddress getRequesterID()
{
    return requesterID; 
}

/** Setter for {@link LinearObjectStatePdu#receivingID}*/
public LinearObjectStatePdu setReceivingID(SimulationAddress pReceivingID)
{
    receivingID = pReceivingID;
    return this;
}

/** Getter for {@link LinearObjectStatePdu#receivingID}*/
public SimulationAddress getReceivingID()
{
    return receivingID; 
}

/** Setter for {@link LinearObjectStatePdu#objectType}*/
public LinearObjectStatePdu setObjectType(ObjectType pObjectType)
{
    objectType = pObjectType;
    return this;
}

/** Getter for {@link LinearObjectStatePdu#objectType}*/
public ObjectType getObjectType()
{
    return objectType; 
}

/** Setter for {@link LinearObjectStatePdu#linearSegmentParameters}*/
public LinearObjectStatePdu setLinearSegmentParameters(List<LinearSegmentParameter> pLinearSegmentParameters)
{
    linearSegmentParameters = pLinearSegmentParameters;
    return this;
}

/** Getter for {@link LinearObjectStatePdu#linearSegmentParameters}*/
public List<LinearSegmentParameter> getLinearSegmentParameters()
{
    return linearSegmentParameters; 
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
       objectID.marshal(dos);
       referencedObjectID.marshal(dos);
       dos.writeShort(updateNumber);
       forceID.marshal(dos);
       dos.writeByte(linearSegmentParameters.size());
       requesterID.marshal(dos);
       receivingID.marshal(dos);
       objectType.marshal(dos);

       for(int idx = 0; idx < linearSegmentParameters.size(); idx++)
       {
            LinearSegmentParameter aLinearSegmentParameter = linearSegmentParameters.get(idx);
            aLinearSegmentParameter.marshal(dos);
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
 * @param dis the InputStream
 * @return unmarshalled size
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += objectID.unmarshal(dis);
        uPosition += referencedObjectID.unmarshal(dis);
        updateNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        forceID = ForceID.unmarshalEnum(dis);
        uPosition += forceID.getMarshalledSize();
        numberOfLinearSegments = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += requesterID.unmarshal(dis);
        uPosition += receivingID.unmarshal(dis);
        uPosition += objectType.unmarshal(dis);
        for(int idx = 0; idx < numberOfLinearSegments; idx++)
        {
            LinearSegmentParameter anX = new LinearSegmentParameter();
            uPosition += anX.unmarshal(dis);
            linearSegmentParameters.add(anX);
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
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   super.marshal(buff);
   objectID.marshal(buff);
   referencedObjectID.marshal(buff);
   buff.putShort( (short)updateNumber);
   forceID.marshal(buff);
   buff.put( (byte)linearSegmentParameters.size());
   requesterID.marshal(buff);
   receivingID.marshal(buff);
   objectType.marshal(buff);

   for(int idx = 0; idx < linearSegmentParameters.size(); idx++)
   {
        LinearSegmentParameter aLinearSegmentParameter = linearSegmentParameters.get(idx);
        aLinearSegmentParameter.marshal(buff);
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

    objectID.unmarshal(buff);
    referencedObjectID.unmarshal(buff);
    updateNumber = (short)(buff.getShort() & 0xFFFF);
    forceID = ForceID.unmarshalEnum(buff);
    numberOfLinearSegments = (byte)(buff.get() & 0xFF);
    requesterID.unmarshal(buff);
    receivingID.unmarshal(buff);
    objectType.unmarshal(buff);
    for(int idx = 0; idx < numberOfLinearSegments; idx++)
    {
    LinearSegmentParameter anX = new LinearSegmentParameter();
    anX.unmarshal(buff);
    linearSegmentParameters.add(anX);
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

     final LinearObjectStatePdu rhs = (LinearObjectStatePdu)obj;

     if( ! (objectID.equals( rhs.objectID) )) ivarsEqual = false;
     if( ! (referencedObjectID.equals( rhs.referencedObjectID) )) ivarsEqual = false;
     if( ! (updateNumber == rhs.updateNumber)) ivarsEqual = false;
     if( ! (forceID == rhs.forceID)) ivarsEqual = false;
     if( ! (requesterID.equals( rhs.requesterID) )) ivarsEqual = false;
     if( ! (receivingID.equals( rhs.receivingID) )) ivarsEqual = false;
     if( ! (objectType.equals( rhs.objectType) )) ivarsEqual = false;

     for(int idx = 0; idx < linearSegmentParameters.size(); idx++)
        if( ! ( linearSegmentParameters.get(idx).equals(rhs.linearSegmentParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" objectID: ").append(objectID).append("\n");
    sb.append(" referencedObjectID: ").append(referencedObjectID).append("\n");
    sb.append(" updateNumber: ").append(updateNumber).append("\n");
    sb.append(" forceID: ").append(forceID).append("\n");
    sb.append(" requesterID: ").append(requesterID).append("\n");
    sb.append(" receivingID: ").append(receivingID).append("\n");
    sb.append(" objectType: ").append(objectType).append("\n");
    sb.append(" linearSegmentParameters: ").append("\n");
    linearSegmentParameters.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
