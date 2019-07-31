/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * 5.10.2 Communicate information about the minefield, including the location, perimeter, and types of mines contained within it.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class MinefieldStatePdu extends MinefieldFamilyPdu implements Serializable
{
   /** Minefield ID */
   protected MinefieldIdentifier  minefieldID = new MinefieldIdentifier(); 

   /** Minefield sequence */
   protected short  minefieldSequence;

   /** force ID uid 6 */
   protected ForceID forceID = ForceID.values()[0];

   /** Number of permieter points */
   protected byte  numberOfPerimeterPoints;

   /** type of minefield */
   protected EntityType  minefieldType = new EntityType(); 

   /** how many mine types */
   protected short  numberOfMineTypes;

   /** location of center of minefield in world coords */
   protected Vector3Double  minefieldLocation = new Vector3Double(); 

   /** orientation of minefield */
   protected EulerAngles  minefieldOrientation = new EulerAngles(); 

   /** appearance bitflags uid 190 */
   protected MinefieldStateAppearanceBitMap appearance = new MinefieldStateAppearanceBitMap();

   /** protocolMode. First two bits are the protocol mode, 14 bits reserved. */
   protected ProtocolMode  protocolMode = new ProtocolMode(); 

   /** perimeter points for the minefield */
   protected List< Vector2Float > perimeterPoints = new ArrayList< Vector2Float >();
 
   /** Type of mines */
   protected List< EntityType > mineType = new ArrayList< EntityType >();
 

/** Constructor */
 public MinefieldStatePdu()
 {
    setPduType( DISPDUType.MINEFIELD_STATE );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += minefieldID.getMarshalledSize();
   marshalSize += 2;  // minefieldSequence
   marshalSize += forceID.getMarshalledSize();
   marshalSize += 1;  // numberOfPerimeterPoints
   marshalSize += minefieldType.getMarshalledSize();
   marshalSize += 2;  // numberOfMineTypes
   marshalSize += minefieldLocation.getMarshalledSize();
   marshalSize += minefieldOrientation.getMarshalledSize();
   marshalSize += protocolMode.getMarshalledSize();
   for(int idx=0; idx < perimeterPoints.size(); idx++)
   {
        Vector2Float listElement = perimeterPoints.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < mineType.size(); idx++)
   {
        EntityType listElement = mineType.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public MinefieldStatePdu setMinefieldID(MinefieldIdentifier pMinefieldID)
{
    minefieldID = pMinefieldID;
    return this;
}

public MinefieldIdentifier getMinefieldID()
{
    return minefieldID; 
}

public MinefieldStatePdu setMinefieldSequence(short pMinefieldSequence)
{
    minefieldSequence = pMinefieldSequence;
    return this;
}

public short getMinefieldSequence()
{
    return minefieldSequence; 
}

public MinefieldStatePdu setForceID(ForceID pForceID)
{
    forceID = pForceID;
    return this;
}

public ForceID getForceID()
{
    return forceID; 
}

public MinefieldStatePdu setMinefieldType(EntityType pMinefieldType)
{
    minefieldType = pMinefieldType;
    return this;
}

public EntityType getMinefieldType()
{
    return minefieldType; 
}

public MinefieldStatePdu setMinefieldLocation(Vector3Double pMinefieldLocation)
{
    minefieldLocation = pMinefieldLocation;
    return this;
}

public Vector3Double getMinefieldLocation()
{
    return minefieldLocation; 
}

public MinefieldStatePdu setMinefieldOrientation(EulerAngles pMinefieldOrientation)
{
    minefieldOrientation = pMinefieldOrientation;
    return this;
}

public EulerAngles getMinefieldOrientation()
{
    return minefieldOrientation; 
}

public MinefieldStatePdu setAppearance(MinefieldStateAppearanceBitMap pAppearance)
{
    appearance = pAppearance;
    return this;
}

public MinefieldStateAppearanceBitMap getAppearance()
{
    return appearance; 
}

public MinefieldStatePdu setProtocolMode(ProtocolMode pProtocolMode)
{
    protocolMode = pProtocolMode;
    return this;
}

public ProtocolMode getProtocolMode()
{
    return protocolMode; 
}

public MinefieldStatePdu setPerimeterPoints(List<Vector2Float> pPerimeterPoints)
{
    perimeterPoints = pPerimeterPoints;
    return this;
}

public List<Vector2Float> getPerimeterPoints()
{
    return perimeterPoints; 
}

public MinefieldStatePdu setMineType(List<EntityType> pMineType)
{
    mineType = pMineType;
    return this;
}

public List<EntityType> getMineType()
{
    return mineType; 
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
       minefieldID.marshal(dos);
       dos.writeShort( (short)minefieldSequence);
       forceID.marshal(dos);
       dos.writeByte( (byte)perimeterPoints.size());
       minefieldType.marshal(dos);
       dos.writeShort( (short)mineType.size());
       minefieldLocation.marshal(dos);
       minefieldOrientation.marshal(dos);
       appearance.marshal(dos);
       protocolMode.marshal(dos);

       for(int idx = 0; idx < perimeterPoints.size(); idx++)
       {
            Vector2Float aVector2Float = perimeterPoints.get(idx);
            aVector2Float.marshal(dos);
       }


       for(int idx = 0; idx < mineType.size(); idx++)
       {
            EntityType aEntityType = mineType.get(idx);
            aEntityType.marshal(dos);
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
        uPosition += minefieldID.unmarshal(dis);
        minefieldSequence = (short)dis.readUnsignedShort();
        uPosition += 2;
        forceID = ForceID.unmarshalEnum(dis);
        uPosition += forceID.getMarshalledSize();
        numberOfPerimeterPoints = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += minefieldType.unmarshal(dis);
        numberOfMineTypes = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += minefieldLocation.unmarshal(dis);
        uPosition += minefieldOrientation.unmarshal(dis);
        uPosition += appearance.unmarshal(dis);
        uPosition += protocolMode.unmarshal(dis);
        for(int idx = 0; idx < numberOfPerimeterPoints; idx++)
        {
            Vector2Float anX = new Vector2Float();
            uPosition += anX.unmarshal(dis);
            perimeterPoints.add(anX);
        }

        for(int idx = 0; idx < numberOfMineTypes; idx++)
        {
            EntityType anX = new EntityType();
            uPosition += anX.unmarshal(dis);
            mineType.add(anX);
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
   minefieldID.marshal(buff);
   buff.putShort( (short)minefieldSequence);
   forceID.marshal(buff);
   buff.put( (byte)perimeterPoints.size());
   minefieldType.marshal(buff);
   buff.putShort( (short)mineType.size());
   minefieldLocation.marshal(buff);
   minefieldOrientation.marshal(buff);
   appearance.marshal(buff);
   protocolMode.marshal(buff);

   for(int idx = 0; idx < perimeterPoints.size(); idx++)
   {
        Vector2Float aVector2Float = (Vector2Float)perimeterPoints.get(idx);
        aVector2Float.marshal(buff);
   }


   for(int idx = 0; idx < mineType.size(); idx++)
   {
        EntityType aEntityType = (EntityType)mineType.get(idx);
        aEntityType.marshal(buff);
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

    minefieldID.unmarshal(buff);
    minefieldSequence = (short)(buff.getShort() & 0xFFFF);
    forceID = ForceID.unmarshalEnum(buff);
    numberOfPerimeterPoints = (byte)(buff.get() & 0xFF);
    minefieldType.unmarshal(buff);
    numberOfMineTypes = (short)(buff.getShort() & 0xFFFF);
    minefieldLocation.unmarshal(buff);
    minefieldOrientation.unmarshal(buff);
    appearance.unmarshal(buff);
    protocolMode.unmarshal(buff);
    for(int idx = 0; idx < numberOfPerimeterPoints; idx++)
    {
    Vector2Float anX = new Vector2Float();
    anX.unmarshal(buff);
    perimeterPoints.add(anX);
    }

    for(int idx = 0; idx < numberOfMineTypes; idx++)
    {
    EntityType anX = new EntityType();
    anX.unmarshal(buff);
    mineType.add(anX);
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

    if(!(obj instanceof MinefieldStatePdu))
        return false;

     final MinefieldStatePdu rhs = (MinefieldStatePdu)obj;

     if( ! (minefieldID.equals( rhs.minefieldID) )) ivarsEqual = false;
     if( ! (minefieldSequence == rhs.minefieldSequence)) ivarsEqual = false;
     if( ! (forceID == rhs.forceID)) ivarsEqual = false;
     if( ! (numberOfPerimeterPoints == rhs.numberOfPerimeterPoints)) ivarsEqual = false;
     if( ! (minefieldType.equals( rhs.minefieldType) )) ivarsEqual = false;
     if( ! (numberOfMineTypes == rhs.numberOfMineTypes)) ivarsEqual = false;
     if( ! (minefieldLocation.equals( rhs.minefieldLocation) )) ivarsEqual = false;
     if( ! (minefieldOrientation.equals( rhs.minefieldOrientation) )) ivarsEqual = false;
     if( ! (protocolMode.equals( rhs.protocolMode) )) ivarsEqual = false;

     for(int idx = 0; idx < perimeterPoints.size(); idx++)
        if( ! ( perimeterPoints.get(idx).equals(rhs.perimeterPoints.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < mineType.size(); idx++)
        if( ! ( mineType.get(idx).equals(rhs.mineType.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
