/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.10.2 Used to communicate information about environmental effects and processes.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class EnvironmentalProcessPdu extends SyntheticEnvironmentFamilyPdu implements Serializable
{
   /** Environmental process ID */
   protected ObjectIdentifier  environementalProcessID = new ObjectIdentifier(); 

   /** Environment type */
   protected EntityType  environmentType = new EntityType(); 

   /** model type uid 248 */
   protected EnvironmentalProcessModelType modelType = EnvironmentalProcessModelType.values()[0];

   /** Environment status uid 249 */
   protected EnvironmentalProcessEnvironmentStatus environmentStatus = new EnvironmentalProcessEnvironmentStatus();

   /** number of environment records  */
   protected short  numberOfEnvironmentRecords;

   /** PDU sequence number for the environmental process if pdu sequencing required */
   protected short  sequenceNumber;

   /** environmemt records */
   protected List< Environment > environmentRecords = new ArrayList< Environment >();
 

/** Constructor */
 public EnvironmentalProcessPdu()
 {
    setPduType( DISPDUType.ENVIRONMENTAL_PROCESS );
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += environementalProcessID.getMarshalledSize();
   marshalSize += environmentType.getMarshalledSize();
   marshalSize += modelType.getMarshalledSize();
   marshalSize += environmentStatus.getMarshalledSize();
   marshalSize += 2;  // numberOfEnvironmentRecords
   marshalSize += 2;  // sequenceNumber
   for(int idx=0; idx < environmentRecords.size(); idx++)
   {
        Environment listElement = environmentRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


/** Setter for {@link EnvironmentalProcessPdu#environementalProcessID}*/
public EnvironmentalProcessPdu setEnvironementalProcessID(ObjectIdentifier pEnvironementalProcessID)
{
    environementalProcessID = pEnvironementalProcessID;
    return this;
}

/** Getter for {@link EnvironmentalProcessPdu#environementalProcessID}*/
public ObjectIdentifier getEnvironementalProcessID()
{
    return environementalProcessID; 
}

/** Setter for {@link EnvironmentalProcessPdu#environmentType}*/
public EnvironmentalProcessPdu setEnvironmentType(EntityType pEnvironmentType)
{
    environmentType = pEnvironmentType;
    return this;
}

/** Getter for {@link EnvironmentalProcessPdu#environmentType}*/
public EntityType getEnvironmentType()
{
    return environmentType; 
}

/** Setter for {@link EnvironmentalProcessPdu#modelType}*/
public EnvironmentalProcessPdu setModelType(EnvironmentalProcessModelType pModelType)
{
    modelType = pModelType;
    return this;
}

/** Getter for {@link EnvironmentalProcessPdu#modelType}*/
public EnvironmentalProcessModelType getModelType()
{
    return modelType; 
}

/** Setter for {@link EnvironmentalProcessPdu#environmentStatus}*/
public EnvironmentalProcessPdu setEnvironmentStatus(EnvironmentalProcessEnvironmentStatus pEnvironmentStatus)
{
    environmentStatus = pEnvironmentStatus;
    return this;
}

/** Setter for {@link EnvironmentalProcessPdu#environmentStatus}*/
public EnvironmentalProcessEnvironmentStatus getEnvironmentStatus()
{
    return environmentStatus; 
}

/** Setter for {@link EnvironmentalProcessPdu#sequenceNumber}*/
public EnvironmentalProcessPdu setSequenceNumber(short pSequenceNumber)
{
    sequenceNumber = pSequenceNumber;
    return this;
}

/** Getter for {@link EnvironmentalProcessPdu#sequenceNumber}*/
public short getSequenceNumber()
{
    return sequenceNumber; 
}

/** Setter for {@link EnvironmentalProcessPdu#environmentRecords}*/
public EnvironmentalProcessPdu setEnvironmentRecords(List<Environment> pEnvironmentRecords)
{
    environmentRecords = pEnvironmentRecords;
    return this;
}

/** Getter for {@link EnvironmentalProcessPdu#environmentRecords}*/
public List<Environment> getEnvironmentRecords()
{
    return environmentRecords; 
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
       environementalProcessID.marshal(dos);
       environmentType.marshal(dos);
       modelType.marshal(dos);
       environmentStatus.marshal(dos);
       dos.writeShort(environmentRecords.size());
       dos.writeShort(sequenceNumber);

       for(int idx = 0; idx < environmentRecords.size(); idx++)
       {
            Environment aEnvironment = environmentRecords.get(idx);
            aEnvironment.marshal(dos);
       }

    }
    catch(Exception e)
    {
      System.err.println(e);
    }
}

/**
 * Unserializes an object from a DataInputStream.
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
        uPosition += environementalProcessID.unmarshal(dis);
        uPosition += environmentType.unmarshal(dis);
        modelType = EnvironmentalProcessModelType.unmarshalEnum(dis);
        uPosition += modelType.getMarshalledSize();
        uPosition += environmentStatus.unmarshal(dis);
        numberOfEnvironmentRecords = (short)dis.readUnsignedShort();
        uPosition += 2;
        sequenceNumber = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfEnvironmentRecords; idx++)
        {
            Environment anX = new Environment();
            uPosition += anX.unmarshal(dis);
            environmentRecords.add(anX);
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
   environementalProcessID.marshal(buff);
   environmentType.marshal(buff);
   modelType.marshal(buff);
   environmentStatus.marshal(buff);
   buff.putShort( (short)environmentRecords.size());
   buff.putShort( (short)sequenceNumber);

   for(int idx = 0; idx < environmentRecords.size(); idx++)
   {
        Environment aEnvironment = environmentRecords.get(idx);
        aEnvironment.marshal(buff);
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

    environementalProcessID.unmarshal(buff);
    environmentType.unmarshal(buff);
    modelType = EnvironmentalProcessModelType.unmarshalEnum(buff);
    environmentStatus.unmarshal(buff);
    numberOfEnvironmentRecords = (short)(buff.getShort() & 0xFFFF);
    sequenceNumber = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfEnvironmentRecords; idx++)
    {
    Environment anX = new Environment();
    anX.unmarshal(buff);
    environmentRecords.add(anX);
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

     final EnvironmentalProcessPdu rhs = (EnvironmentalProcessPdu)obj;

     if( ! (environementalProcessID.equals( rhs.environementalProcessID) )) ivarsEqual = false;
     if( ! (environmentType.equals( rhs.environmentType) )) ivarsEqual = false;
     if( ! (modelType == rhs.modelType)) ivarsEqual = false;
     if( ! (environmentStatus.equals( rhs.environmentStatus) )) ivarsEqual = false;
     if( ! (sequenceNumber == rhs.sequenceNumber)) ivarsEqual = false;

     for(int idx = 0; idx < environmentRecords.size(); idx++)
        if( ! ( environmentRecords.get(idx).equals(rhs.environmentRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" environementalProcessID: ").append(environementalProcessID).append("\n");
    sb.append(" environmentType: ").append(environmentType).append("\n");
    sb.append(" modelType: ").append(modelType).append("\n");
    sb.append(" environmentStatus: ").append(environmentStatus).append("\n");
    sb.append(" sequenceNumber: ").append(sequenceNumber).append("\n");
    sb.append(" environmentRecords: ").append("\n");
    environmentRecords.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
