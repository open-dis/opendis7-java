/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.10.4 Used to communicate detailed information about the addition/modification of a synthetic environment object that is geometrically anchored to the terrain with a single point.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class PointObjectStatePdu extends SyntheticEnvironmentFamilyPdu implements Serializable
{
   /** Object in synthetic environment */
   protected EntityID  objectID = new EntityID(); 

   /** Object with which this point object is associated */
   protected ObjectIdentifier  referencedObjectID = new ObjectIdentifier(); 

   /** unique update number of each state transition of an object */
   protected int  updateNumber;

   /** force ID uid 6 */
   protected ForceID forceID = ForceID.values()[0];

   /** modifications uid 240 */
   protected ObjectStateModificationPointObject modifications = new ObjectStateModificationPointObject();

   /** Object type */
   protected ObjectType  objectType = new ObjectType(); 

   /** Object location */
   protected Vector3Double  objectLocation = new Vector3Double(); 

   /** Object orientation */
   protected EulerAngles  objectOrientation = new EulerAngles(); 

   /** Specific object apperance */
   protected int  specificObjectAppearance;

   /** General object apperance uid 229 */
   protected ObjectStateAppearanceGeneral generObjectAppearance = new ObjectStateAppearanceGeneral();

   protected short  padding1;

   /** requesterID */
   protected SimulationAddress  requesterID = new SimulationAddress(); 

   /** receiver ID */
   protected SimulationAddress  receivingID = new SimulationAddress(); 

   /** padding */
   protected int  pad2;


/** Constructor */
 public PointObjectStatePdu()
 {
    setPduType( DISPDUType.POINT_OBJECT_STATE );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += objectID.getMarshalledSize();
   marshalSize += referencedObjectID.getMarshalledSize();
   marshalSize += 4;  // updateNumber
   marshalSize += forceID.getMarshalledSize();
   marshalSize += modifications.getMarshalledSize();
   marshalSize += objectType.getMarshalledSize();
   marshalSize += objectLocation.getMarshalledSize();
   marshalSize += objectOrientation.getMarshalledSize();
   marshalSize += 4;  // specificObjectAppearance
   marshalSize += generObjectAppearance.getMarshalledSize();
   marshalSize += 2;  // padding1
   marshalSize += requesterID.getMarshalledSize();
   marshalSize += receivingID.getMarshalledSize();
   marshalSize += 4;  // pad2

   return marshalSize;
}


/** Setter for {@link PointObjectStatePdu#objectID}*/
public PointObjectStatePdu setObjectID(EntityID pObjectID)
{
    objectID = pObjectID;
    return this;
}

/** Getter for {@link PointObjectStatePdu#objectID}*/
public EntityID getObjectID()
{
    return objectID; 
}

/** Setter for {@link PointObjectStatePdu#referencedObjectID}*/
public PointObjectStatePdu setReferencedObjectID(ObjectIdentifier pReferencedObjectID)
{
    referencedObjectID = pReferencedObjectID;
    return this;
}

/** Getter for {@link PointObjectStatePdu#referencedObjectID}*/
public ObjectIdentifier getReferencedObjectID()
{
    return referencedObjectID; 
}

/** Setter for {@link PointObjectStatePdu#updateNumber}*/
public PointObjectStatePdu setUpdateNumber(int pUpdateNumber)
{
    updateNumber = pUpdateNumber;
    return this;
}

/** Getter for {@link PointObjectStatePdu#updateNumber}*/
public int getUpdateNumber()
{
    return updateNumber; 
}

/** Setter for {@link PointObjectStatePdu#forceID}*/
public PointObjectStatePdu setForceID(ForceID pForceID)
{
    forceID = pForceID;
    return this;
}

/** Getter for {@link PointObjectStatePdu#forceID}*/
public ForceID getForceID()
{
    return forceID; 
}

/** Setter for {@link PointObjectStatePdu#modifications}*/
public PointObjectStatePdu setModifications(ObjectStateModificationPointObject pModifications)
{
    modifications = pModifications;
    return this;
}

/** Setter for {@link PointObjectStatePdu#modifications}*/
public ObjectStateModificationPointObject getModifications()
{
    return modifications; 
}

/** Setter for {@link PointObjectStatePdu#objectType}*/
public PointObjectStatePdu setObjectType(ObjectType pObjectType)
{
    objectType = pObjectType;
    return this;
}

/** Getter for {@link PointObjectStatePdu#objectType}*/
public ObjectType getObjectType()
{
    return objectType; 
}

/** Setter for {@link PointObjectStatePdu#objectLocation}*/
public PointObjectStatePdu setObjectLocation(Vector3Double pObjectLocation)
{
    objectLocation = pObjectLocation;
    return this;
}

/** Getter for {@link PointObjectStatePdu#objectLocation}*/
public Vector3Double getObjectLocation()
{
    return objectLocation; 
}

/** Setter for {@link PointObjectStatePdu#objectOrientation}*/
public PointObjectStatePdu setObjectOrientation(EulerAngles pObjectOrientation)
{
    objectOrientation = pObjectOrientation;
    return this;
}

/** Getter for {@link PointObjectStatePdu#objectOrientation}*/
public EulerAngles getObjectOrientation()
{
    return objectOrientation; 
}

/** Setter for {@link PointObjectStatePdu#specificObjectAppearance}*/
public PointObjectStatePdu setSpecificObjectAppearance(int pSpecificObjectAppearance)
{
    specificObjectAppearance = pSpecificObjectAppearance;
    return this;
}

/** Getter for {@link PointObjectStatePdu#specificObjectAppearance}*/
public int getSpecificObjectAppearance()
{
    return specificObjectAppearance; 
}

/** Setter for {@link PointObjectStatePdu#generObjectAppearance}*/
public PointObjectStatePdu setGenerObjectAppearance(ObjectStateAppearanceGeneral pGenerObjectAppearance)
{
    generObjectAppearance = pGenerObjectAppearance;
    return this;
}

/** Setter for {@link PointObjectStatePdu#generObjectAppearance}*/
public ObjectStateAppearanceGeneral getGenerObjectAppearance()
{
    return generObjectAppearance; 
}

/** Setter for {@link PointObjectStatePdu#padding1}*/
public PointObjectStatePdu setPadding1(short pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link PointObjectStatePdu#padding1}*/
public short getPadding1()
{
    return padding1; 
}

/** Setter for {@link PointObjectStatePdu#requesterID}*/
public PointObjectStatePdu setRequesterID(SimulationAddress pRequesterID)
{
    requesterID = pRequesterID;
    return this;
}

/** Getter for {@link PointObjectStatePdu#requesterID}*/
public SimulationAddress getRequesterID()
{
    return requesterID; 
}

/** Setter for {@link PointObjectStatePdu#receivingID}*/
public PointObjectStatePdu setReceivingID(SimulationAddress pReceivingID)
{
    receivingID = pReceivingID;
    return this;
}

/** Getter for {@link PointObjectStatePdu#receivingID}*/
public SimulationAddress getReceivingID()
{
    return receivingID; 
}

/** Setter for {@link PointObjectStatePdu#pad2}*/
public PointObjectStatePdu setPad2(int pPad2)
{
    pad2 = pPad2;
    return this;
}

/** Getter for {@link PointObjectStatePdu#pad2}*/
public int getPad2()
{
    return pad2; 
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
       objectID.marshal(dos);
       referencedObjectID.marshal(dos);
       dos.writeInt( (int)updateNumber);
       forceID.marshal(dos);
       modifications.marshal(dos);
       objectType.marshal(dos);
       objectLocation.marshal(dos);
       objectOrientation.marshal(dos);
       dos.writeInt( (int)specificObjectAppearance);
       generObjectAppearance.marshal(dos);
       dos.writeShort( (short)padding1);
       requesterID.marshal(dos);
       receivingID.marshal(dos);
       dos.writeInt( (int)pad2);
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
        uPosition += objectID.unmarshal(dis);
        uPosition += referencedObjectID.unmarshal(dis);
        updateNumber = dis.readInt();
        uPosition += 4;
        forceID = ForceID.unmarshalEnum(dis);
        uPosition += forceID.getMarshalledSize();
        uPosition += modifications.unmarshal(dis);
        uPosition += objectType.unmarshal(dis);
        uPosition += objectLocation.unmarshal(dis);
        uPosition += objectOrientation.unmarshal(dis);
        specificObjectAppearance = dis.readInt();
        uPosition += 4;
        uPosition += generObjectAppearance.unmarshal(dis);
        padding1 = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += requesterID.unmarshal(dis);
        uPosition += receivingID.unmarshal(dis);
        pad2 = dis.readInt();
        uPosition += 4;
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
   buff.putInt( (int)updateNumber);
   forceID.marshal(buff);
   modifications.marshal(buff);
   objectType.marshal(buff);
   objectLocation.marshal(buff);
   objectOrientation.marshal(buff);
   buff.putInt( (int)specificObjectAppearance);
   generObjectAppearance.marshal(buff);
   buff.putShort( (short)padding1);
   requesterID.marshal(buff);
   receivingID.marshal(buff);
   buff.putInt( (int)pad2);
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
    updateNumber = buff.getInt();
    forceID = ForceID.unmarshalEnum(buff);
    modifications.unmarshal(buff);
    objectType.unmarshal(buff);
    objectLocation.unmarshal(buff);
    objectOrientation.unmarshal(buff);
    specificObjectAppearance = buff.getInt();
    generObjectAppearance.unmarshal(buff);
    padding1 = (short)(buff.getShort() & 0xFFFF);
    requesterID.unmarshal(buff);
    receivingID.unmarshal(buff);
    pad2 = buff.getInt();
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

     final PointObjectStatePdu rhs = (PointObjectStatePdu)obj;

     if( ! (objectID.equals( rhs.objectID) )) ivarsEqual = false;
     if( ! (referencedObjectID.equals( rhs.referencedObjectID) )) ivarsEqual = false;
     if( ! (updateNumber == rhs.updateNumber)) ivarsEqual = false;
     if( ! (forceID == rhs.forceID)) ivarsEqual = false;
     if( ! (modifications.equals( rhs.modifications) )) ivarsEqual = false;
     if( ! (objectType.equals( rhs.objectType) )) ivarsEqual = false;
     if( ! (objectLocation.equals( rhs.objectLocation) )) ivarsEqual = false;
     if( ! (objectOrientation.equals( rhs.objectOrientation) )) ivarsEqual = false;
     if( ! (specificObjectAppearance == rhs.specificObjectAppearance)) ivarsEqual = false;
     if( ! (generObjectAppearance.equals( rhs.generObjectAppearance) )) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (requesterID.equals( rhs.requesterID) )) ivarsEqual = false;
     if( ! (receivingID.equals( rhs.receivingID) )) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" objectID: ").append(objectID).append("\n");
    sb.append(" referencedObjectID: ").append(referencedObjectID).append("\n");
    sb.append(" updateNumber: ").append(updateNumber).append("\n");
    sb.append(" forceID: ").append(forceID).append("\n");
    sb.append(" modifications: ").append(modifications).append("\n");
    sb.append(" objectType: ").append(objectType).append("\n");
    sb.append(" objectLocation: ").append(objectLocation).append("\n");
    sb.append(" objectOrientation: ").append(objectOrientation).append("\n");
    sb.append(" specificObjectAppearance: ").append(specificObjectAppearance).append("\n");
    sb.append(" generObjectAppearance: ").append(generObjectAppearance).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" requesterID: ").append(requesterID).append("\n");
    sb.append(" receivingID: ").append(receivingID).append("\n");
    sb.append(" pad2: ").append(pad2).append("\n");

   return sb.toString();
 }
} // end of class
