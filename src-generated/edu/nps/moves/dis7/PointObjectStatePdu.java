/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
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

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += objectID.getMarshalledSize();
   marshalSize += referencedObjectID.getMarshalledSize();
   marshalSize += 4;  // updateNumber
   marshalSize += forceID.getMarshalledSize();
   marshalSize += objectType.getMarshalledSize();
   marshalSize += objectLocation.getMarshalledSize();
   marshalSize += objectOrientation.getMarshalledSize();
   marshalSize += 4;  // specificObjectAppearance
   marshalSize += 2;  // padding1
   marshalSize += requesterID.getMarshalledSize();
   marshalSize += receivingID.getMarshalledSize();
   marshalSize += 4;  // pad2

   return marshalSize;
}


public PointObjectStatePdu setObjectID(EntityID pObjectID)
{
    objectID = pObjectID;
    return this;
}

public EntityID getObjectID()
{
    return objectID; 
}

public PointObjectStatePdu setReferencedObjectID(ObjectIdentifier pReferencedObjectID)
{
    referencedObjectID = pReferencedObjectID;
    return this;
}

public ObjectIdentifier getReferencedObjectID()
{
    return referencedObjectID; 
}

public PointObjectStatePdu setUpdateNumber(int pUpdateNumber)
{
    updateNumber = pUpdateNumber;
    return this;
}

public int getUpdateNumber()
{
    return updateNumber; 
}

public PointObjectStatePdu setForceID(ForceID pForceID)
{
    forceID = pForceID;
    return this;
}

public ForceID getForceID()
{
    return forceID; 
}

public PointObjectStatePdu setModifications(ObjectStateModificationPointObject pModifications)
{
    modifications = pModifications;
    return this;
}

public ObjectStateModificationPointObject getModifications()
{
    return modifications; 
}

public PointObjectStatePdu setObjectType(ObjectType pObjectType)
{
    objectType = pObjectType;
    return this;
}

public ObjectType getObjectType()
{
    return objectType; 
}

public PointObjectStatePdu setObjectLocation(Vector3Double pObjectLocation)
{
    objectLocation = pObjectLocation;
    return this;
}

public Vector3Double getObjectLocation()
{
    return objectLocation; 
}

public PointObjectStatePdu setObjectOrientation(EulerAngles pObjectOrientation)
{
    objectOrientation = pObjectOrientation;
    return this;
}

public EulerAngles getObjectOrientation()
{
    return objectOrientation; 
}

public PointObjectStatePdu setSpecificObjectAppearance(int pSpecificObjectAppearance)
{
    specificObjectAppearance = pSpecificObjectAppearance;
    return this;
}

public int getSpecificObjectAppearance()
{
    return specificObjectAppearance; 
}

public PointObjectStatePdu setGenerObjectAppearance(ObjectStateAppearanceGeneral pGenerObjectAppearance)
{
    generObjectAppearance = pGenerObjectAppearance;
    return this;
}

public ObjectStateAppearanceGeneral getGenerObjectAppearance()
{
    return generObjectAppearance; 
}

public PointObjectStatePdu setPadding1(short pPadding1)
{
    padding1 = pPadding1;
    return this;
}

public short getPadding1()
{
    return padding1; 
}

public PointObjectStatePdu setRequesterID(SimulationAddress pRequesterID)
{
    requesterID = pRequesterID;
    return this;
}

public SimulationAddress getRequesterID()
{
    return requesterID; 
}

public PointObjectStatePdu setReceivingID(SimulationAddress pReceivingID)
{
    receivingID = pReceivingID;
    return this;
}

public SimulationAddress getReceivingID()
{
    return receivingID; 
}

public PointObjectStatePdu setPad2(int pPad2)
{
    pad2 = pPad2;
    return this;
}

public int getPad2()
{
    return pad2; 
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
public int unmarshal(DataInputStream dis)
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

    if(!(obj instanceof PointObjectStatePdu))
        return false;

     final PointObjectStatePdu rhs = (PointObjectStatePdu)obj;

     if( ! (objectID.equals( rhs.objectID) )) ivarsEqual = false;
     if( ! (referencedObjectID.equals( rhs.referencedObjectID) )) ivarsEqual = false;
     if( ! (updateNumber == rhs.updateNumber)) ivarsEqual = false;
     if( ! (forceID == rhs.forceID)) ivarsEqual = false;
     if( ! (objectType.equals( rhs.objectType) )) ivarsEqual = false;
     if( ! (objectLocation.equals( rhs.objectLocation) )) ivarsEqual = false;
     if( ! (objectOrientation.equals( rhs.objectOrientation) )) ivarsEqual = false;
     if( ! (specificObjectAppearance == rhs.specificObjectAppearance)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (requesterID.equals( rhs.requesterID) )) ivarsEqual = false;
     if( ! (receivingID.equals( rhs.receivingID) )) ivarsEqual = false;
     if( ! (pad2 == rhs.pad2)) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
