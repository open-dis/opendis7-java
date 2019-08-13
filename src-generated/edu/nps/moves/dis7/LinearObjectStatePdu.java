/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.10.5 Used to communicate detailed information about the addition/modification of a synthetic environment object that is geometrically anchored to the terrain with one point and has size and orientation.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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


public LinearObjectStatePdu setObjectID(ObjectIdentifier pObjectID)
{
    objectID = pObjectID;
    return this;
}

public ObjectIdentifier getObjectID()
{
    return objectID; 
}

public LinearObjectStatePdu setReferencedObjectID(ObjectIdentifier pReferencedObjectID)
{
    referencedObjectID = pReferencedObjectID;
    return this;
}

public ObjectIdentifier getReferencedObjectID()
{
    return referencedObjectID; 
}

public LinearObjectStatePdu setUpdateNumber(short pUpdateNumber)
{
    updateNumber = pUpdateNumber;
    return this;
}

public short getUpdateNumber()
{
    return updateNumber; 
}

public LinearObjectStatePdu setForceID(ForceID pForceID)
{
    forceID = pForceID;
    return this;
}

public ForceID getForceID()
{
    return forceID; 
}

public LinearObjectStatePdu setRequesterID(SimulationAddress pRequesterID)
{
    requesterID = pRequesterID;
    return this;
}

public SimulationAddress getRequesterID()
{
    return requesterID; 
}

public LinearObjectStatePdu setReceivingID(SimulationAddress pReceivingID)
{
    receivingID = pReceivingID;
    return this;
}

public SimulationAddress getReceivingID()
{
    return receivingID; 
}

public LinearObjectStatePdu setObjectType(ObjectType pObjectType)
{
    objectType = pObjectType;
    return this;
}

public ObjectType getObjectType()
{
    return objectType; 
}

public LinearObjectStatePdu setLinearSegmentParameters(List<LinearSegmentParameter> pLinearSegmentParameters)
{
    linearSegmentParameters = pLinearSegmentParameters;
    return this;
}

public List<LinearSegmentParameter> getLinearSegmentParameters()
{
    return linearSegmentParameters; 
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
       objectID.marshal(dos);
       referencedObjectID.marshal(dos);
       dos.writeShort( (short)updateNumber);
       forceID.marshal(dos);
       dos.writeByte( (byte)linearSegmentParameters.size());
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
        LinearSegmentParameter aLinearSegmentParameter = (LinearSegmentParameter)linearSegmentParameters.get(idx);
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

    if(!(obj instanceof LinearObjectStatePdu))
        return false;

     final LinearObjectStatePdu rhs = (LinearObjectStatePdu)obj;

     if( ! (objectID.equals( rhs.objectID) )) ivarsEqual = false;
     if( ! (referencedObjectID.equals( rhs.referencedObjectID) )) ivarsEqual = false;
     if( ! (updateNumber == rhs.updateNumber)) ivarsEqual = false;
     if( ! (forceID == rhs.forceID)) ivarsEqual = false;
     if( ! (numberOfLinearSegments == rhs.numberOfLinearSegments)) ivarsEqual = false;
     if( ! (requesterID.equals( rhs.requesterID) )) ivarsEqual = false;
     if( ! (receivingID.equals( rhs.receivingID) )) ivarsEqual = false;
     if( ! (objectType.equals( rhs.objectType) )) ivarsEqual = false;

     for(int idx = 0; idx < linearSegmentParameters.size(); idx++)
        if( ! ( linearSegmentParameters.get(idx).equals(rhs.linearSegmentParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
