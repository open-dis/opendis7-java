package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 *  SEES PDU, supplemental emissions entity state information. Section 7.6.6
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class SeesPdu extends DistributedEmissionsFamilyPdu implements Serializable
{
   /** Originating entity ID */
   protected EntityID  orginatingEntityID = new EntityID(); 

   /** IR Signature representation index */
   protected short  infraredSignatureRepresentationIndex;

   /** acoustic Signature representation index */
   protected short  acousticSignatureRepresentationIndex;

   /** radar cross section representation index */
   protected short  radarCrossSectionSignatureRepresentationIndex;

   /** how many propulsion systems */
   protected short  numberOfPropulsionSystems;

   /** how many vectoring nozzle systems */
   protected short  numberOfVectoringNozzleSystems;

   /** variable length list of propulsion system data */
   protected List< PropulsionSystemData > propulsionSystemData = new ArrayList< PropulsionSystemData >();
 
   /** variable length list of vectoring system data */
   protected List< VectoringNozzleSystem > vectoringSystemData = new ArrayList< VectoringNozzleSystem >();
 

/** Constructor */
 public SeesPdu()
 {
    setPduType( DISPDUType.SUPPLEMENTAL_EMISSION_ENTITY_STATE );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += orginatingEntityID.getMarshalledSize();
   marshalSize += 2;  // infraredSignatureRepresentationIndex
   marshalSize += 2;  // acousticSignatureRepresentationIndex
   marshalSize += 2;  // radarCrossSectionSignatureRepresentationIndex
   marshalSize += 2;  // numberOfPropulsionSystems
   marshalSize += 2;  // numberOfVectoringNozzleSystems
   for(int idx=0; idx < propulsionSystemData.size(); idx++)
   {
        PropulsionSystemData listElement = propulsionSystemData.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }
   for(int idx=0; idx < vectoringSystemData.size(); idx++)
   {
        VectoringNozzleSystem listElement = vectoringSystemData.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public SeesPdu setOrginatingEntityID(EntityID pOrginatingEntityID)
{
    orginatingEntityID = pOrginatingEntityID;
    return this;
}

public EntityID getOrginatingEntityID()
{
    return orginatingEntityID; 
}

public SeesPdu setInfraredSignatureRepresentationIndex(short pInfraredSignatureRepresentationIndex)
{
    infraredSignatureRepresentationIndex = pInfraredSignatureRepresentationIndex;
    return this;
}

public short getInfraredSignatureRepresentationIndex()
{
    return infraredSignatureRepresentationIndex; 
}

public SeesPdu setAcousticSignatureRepresentationIndex(short pAcousticSignatureRepresentationIndex)
{
    acousticSignatureRepresentationIndex = pAcousticSignatureRepresentationIndex;
    return this;
}

public short getAcousticSignatureRepresentationIndex()
{
    return acousticSignatureRepresentationIndex; 
}

public SeesPdu setRadarCrossSectionSignatureRepresentationIndex(short pRadarCrossSectionSignatureRepresentationIndex)
{
    radarCrossSectionSignatureRepresentationIndex = pRadarCrossSectionSignatureRepresentationIndex;
    return this;
}

public short getRadarCrossSectionSignatureRepresentationIndex()
{
    return radarCrossSectionSignatureRepresentationIndex; 
}

public SeesPdu setPropulsionSystemData(List<PropulsionSystemData> pPropulsionSystemData)
{
    propulsionSystemData = pPropulsionSystemData;
    return this;
}

public List<PropulsionSystemData> getPropulsionSystemData()
{
    return propulsionSystemData; 
}

public SeesPdu setVectoringSystemData(List<VectoringNozzleSystem> pVectoringSystemData)
{
    vectoringSystemData = pVectoringSystemData;
    return this;
}

public List<VectoringNozzleSystem> getVectoringSystemData()
{
    return vectoringSystemData; 
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
       orginatingEntityID.marshal(dos);
       dos.writeShort( (short)infraredSignatureRepresentationIndex);
       dos.writeShort( (short)acousticSignatureRepresentationIndex);
       dos.writeShort( (short)radarCrossSectionSignatureRepresentationIndex);
       dos.writeShort( (short)propulsionSystemData.size());
       dos.writeShort( (short)vectoringSystemData.size());

       for(int idx = 0; idx < propulsionSystemData.size(); idx++)
       {
            PropulsionSystemData aPropulsionSystemData = propulsionSystemData.get(idx);
            aPropulsionSystemData.marshal(dos);
       }


       for(int idx = 0; idx < vectoringSystemData.size(); idx++)
       {
            VectoringNozzleSystem aVectoringNozzleSystem = vectoringSystemData.get(idx);
            aVectoringNozzleSystem.marshal(dos);
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
        uPosition += orginatingEntityID.unmarshal(dis);
        infraredSignatureRepresentationIndex = (short)dis.readUnsignedShort();
        uPosition += 2;
        acousticSignatureRepresentationIndex = (short)dis.readUnsignedShort();
        uPosition += 2;
        radarCrossSectionSignatureRepresentationIndex = (short)dis.readUnsignedShort();
        uPosition += 2;
        numberOfPropulsionSystems = (short)dis.readUnsignedShort();
        uPosition += 2;
        numberOfVectoringNozzleSystems = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfPropulsionSystems; idx++)
        {
            PropulsionSystemData anX = new PropulsionSystemData();
            uPosition += anX.unmarshal(dis);
            propulsionSystemData.add(anX);
        }

        for(int idx = 0; idx < numberOfVectoringNozzleSystems; idx++)
        {
            VectoringNozzleSystem anX = new VectoringNozzleSystem();
            uPosition += anX.unmarshal(dis);
            vectoringSystemData.add(anX);
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
   orginatingEntityID.marshal(buff);
   buff.putShort( (short)infraredSignatureRepresentationIndex);
   buff.putShort( (short)acousticSignatureRepresentationIndex);
   buff.putShort( (short)radarCrossSectionSignatureRepresentationIndex);
   buff.putShort( (short)propulsionSystemData.size());
   buff.putShort( (short)vectoringSystemData.size());

   for(int idx = 0; idx < propulsionSystemData.size(); idx++)
   {
        PropulsionSystemData aPropulsionSystemData = (PropulsionSystemData)propulsionSystemData.get(idx);
        aPropulsionSystemData.marshal(buff);
   }


   for(int idx = 0; idx < vectoringSystemData.size(); idx++)
   {
        VectoringNozzleSystem aVectoringNozzleSystem = (VectoringNozzleSystem)vectoringSystemData.get(idx);
        aVectoringNozzleSystem.marshal(buff);
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

    orginatingEntityID.unmarshal(buff);
    infraredSignatureRepresentationIndex = (short)(buff.getShort() & 0xFFFF);
    acousticSignatureRepresentationIndex = (short)(buff.getShort() & 0xFFFF);
    radarCrossSectionSignatureRepresentationIndex = (short)(buff.getShort() & 0xFFFF);
    numberOfPropulsionSystems = (short)(buff.getShort() & 0xFFFF);
    numberOfVectoringNozzleSystems = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfPropulsionSystems; idx++)
    {
    PropulsionSystemData anX = new PropulsionSystemData();
    anX.unmarshal(buff);
    propulsionSystemData.add(anX);
    }

    for(int idx = 0; idx < numberOfVectoringNozzleSystems; idx++)
    {
    VectoringNozzleSystem anX = new VectoringNozzleSystem();
    anX.unmarshal(buff);
    vectoringSystemData.add(anX);
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

    if(!(obj instanceof SeesPdu))
        return false;

     final SeesPdu rhs = (SeesPdu)obj;

     if( ! (orginatingEntityID.equals( rhs.orginatingEntityID) )) ivarsEqual = false;
     if( ! (infraredSignatureRepresentationIndex == rhs.infraredSignatureRepresentationIndex)) ivarsEqual = false;
     if( ! (acousticSignatureRepresentationIndex == rhs.acousticSignatureRepresentationIndex)) ivarsEqual = false;
     if( ! (radarCrossSectionSignatureRepresentationIndex == rhs.radarCrossSectionSignatureRepresentationIndex)) ivarsEqual = false;
     if( ! (numberOfPropulsionSystems == rhs.numberOfPropulsionSystems)) ivarsEqual = false;
     if( ! (numberOfVectoringNozzleSystems == rhs.numberOfVectoringNozzleSystems)) ivarsEqual = false;

     for(int idx = 0; idx < propulsionSystemData.size(); idx++)
        if( ! ( propulsionSystemData.get(idx).equals(rhs.propulsionSystemData.get(idx)))) ivarsEqual = false;


     for(int idx = 0; idx < vectoringSystemData.size(); idx++)
        if( ! ( vectoringSystemData.get(idx).equals(rhs.vectoringSystemData.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
