/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

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

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += environementalProcessID.getMarshalledSize();
   marshalSize += environmentType.getMarshalledSize();
   marshalSize += modelType.getMarshalledSize();
   marshalSize += 2;  // numberOfEnvironmentRecords
   marshalSize += 2;  // sequenceNumber
   for(int idx=0; idx < environmentRecords.size(); idx++)
   {
        Environment listElement = environmentRecords.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public EnvironmentalProcessPdu setEnvironementalProcessID(ObjectIdentifier pEnvironementalProcessID)
{
    environementalProcessID = pEnvironementalProcessID;
    return this;
}

public ObjectIdentifier getEnvironementalProcessID()
{
    return environementalProcessID; 
}

public EnvironmentalProcessPdu setEnvironmentType(EntityType pEnvironmentType)
{
    environmentType = pEnvironmentType;
    return this;
}

public EntityType getEnvironmentType()
{
    return environmentType; 
}

public EnvironmentalProcessPdu setModelType(EnvironmentalProcessModelType pModelType)
{
    modelType = pModelType;
    return this;
}

public EnvironmentalProcessModelType getModelType()
{
    return modelType; 
}

public EnvironmentalProcessPdu setEnvironmentStatus(EnvironmentalProcessEnvironmentStatus pEnvironmentStatus)
{
    environmentStatus = pEnvironmentStatus;
    return this;
}

public EnvironmentalProcessEnvironmentStatus getEnvironmentStatus()
{
    return environmentStatus; 
}

public EnvironmentalProcessPdu setSequenceNumber(short pSequenceNumber)
{
    sequenceNumber = pSequenceNumber;
    return this;
}

public short getSequenceNumber()
{
    return sequenceNumber; 
}

public EnvironmentalProcessPdu setEnvironmentRecords(List<Environment> pEnvironmentRecords)
{
    environmentRecords = pEnvironmentRecords;
    return this;
}

public List<Environment> getEnvironmentRecords()
{
    return environmentRecords; 
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
       environementalProcessID.marshal(dos);
       environmentType.marshal(dos);
       modelType.marshal(dos);
       environmentStatus.marshal(dos);
       dos.writeShort( (short)environmentRecords.size());
       dos.writeShort( (short)sequenceNumber);

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
   environementalProcessID.marshal(buff);
   environmentType.marshal(buff);
   modelType.marshal(buff);
   environmentStatus.marshal(buff);
   buff.putShort( (short)environmentRecords.size());
   buff.putShort( (short)sequenceNumber);

   for(int idx = 0; idx < environmentRecords.size(); idx++)
   {
        Environment aEnvironment = (Environment)environmentRecords.get(idx);
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

    if(!(obj instanceof EnvironmentalProcessPdu))
        return false;

     final EnvironmentalProcessPdu rhs = (EnvironmentalProcessPdu)obj;

     if( ! (environementalProcessID.equals( rhs.environementalProcessID) )) ivarsEqual = false;
     if( ! (environmentType.equals( rhs.environmentType) )) ivarsEqual = false;
     if( ! (modelType == rhs.modelType)) ivarsEqual = false;
     if( ! (numberOfEnvironmentRecords == rhs.numberOfEnvironmentRecords)) ivarsEqual = false;
     if( ! (sequenceNumber == rhs.sequenceNumber)) ivarsEqual = false;

     for(int idx = 0; idx < environmentRecords.size(); idx++)
        if( ! ( environmentRecords.get(idx).equals(rhs.environmentRecords.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
