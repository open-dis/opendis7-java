package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Section 5.3.7.2. Handles designating operations.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class DesignatorPdu extends DistributedEmissionsFamilyPdu implements Serializable
{
   /** ID of the entity designating */
   protected EntityID  designatingEntityID = new EntityID(); 

   /** This field shall specify a unique emitter database number assigned to  differentiate between otherwise similar or identical emitter beams within an emitter system. uid 80 */
   protected DesignatorSystemName codeName = DesignatorSystemName.values()[0];

   /** ID of the entity being designated */
   protected EntityID  designatedEntityID = new EntityID(); 

   /** This field shall identify the designator code being used by the designating entity  uid 81 */
   protected DesignatorDesignatorCode designatorCode = DesignatorDesignatorCode.values()[0];

   /** This field shall identify the designator output power in watts */
   protected float  designatorPower;

   /** This field shall identify the designator wavelength in units of microns */
   protected float  designatorWavelength;

   /** designtor spot wrt the designated entity */
   protected Vector3Float  designatorSpotWrtDesignated = new Vector3Float(); 

   /** designtor spot wrt the designated entity */
   protected Vector3Double  designatorSpotLocation = new Vector3Double(); 

   /** Dead reckoning algorithm uid 44 */
   protected DeadReckoningAlgorithm deadReckoningAlgorithm = DeadReckoningAlgorithm.values()[0];

   /** padding */
   protected byte  padding1;

   /** padding */
   protected short  padding2;

   /** linear accelleration of entity */
   protected Vector3Float  entityLinearAcceleration = new Vector3Float(); 


/** Constructor */
 public DesignatorPdu()
 {
    setPduType( DISPDUType.DESIGNATOR );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += designatingEntityID.getMarshalledSize();
   marshalSize += codeName.getMarshalledSize();
   marshalSize += designatedEntityID.getMarshalledSize();
   marshalSize += designatorCode.getMarshalledSize();
   marshalSize += 4;  // designatorPower
   marshalSize += 4;  // designatorWavelength
   marshalSize += designatorSpotWrtDesignated.getMarshalledSize();
   marshalSize += designatorSpotLocation.getMarshalledSize();
   marshalSize += deadReckoningAlgorithm.getMarshalledSize();
   marshalSize += 1;  // padding1
   marshalSize += 2;  // padding2
   marshalSize += entityLinearAcceleration.getMarshalledSize();

   return marshalSize;
}


public DesignatorPdu setDesignatingEntityID(EntityID pDesignatingEntityID)
{
    designatingEntityID = pDesignatingEntityID;
    return this;
}

public EntityID getDesignatingEntityID()
{
    return designatingEntityID; 
}

public DesignatorPdu setCodeName(DesignatorSystemName pCodeName)
{
    codeName = pCodeName;
    return this;
}

public DesignatorSystemName getCodeName()
{
    return codeName; 
}

public DesignatorPdu setDesignatedEntityID(EntityID pDesignatedEntityID)
{
    designatedEntityID = pDesignatedEntityID;
    return this;
}

public EntityID getDesignatedEntityID()
{
    return designatedEntityID; 
}

public DesignatorPdu setDesignatorCode(DesignatorDesignatorCode pDesignatorCode)
{
    designatorCode = pDesignatorCode;
    return this;
}

public DesignatorDesignatorCode getDesignatorCode()
{
    return designatorCode; 
}

public DesignatorPdu setDesignatorPower(float pDesignatorPower)
{
    designatorPower = pDesignatorPower;
    return this;
}

public float getDesignatorPower()
{
    return designatorPower; 
}

public DesignatorPdu setDesignatorWavelength(float pDesignatorWavelength)
{
    designatorWavelength = pDesignatorWavelength;
    return this;
}

public float getDesignatorWavelength()
{
    return designatorWavelength; 
}

public DesignatorPdu setDesignatorSpotWrtDesignated(Vector3Float pDesignatorSpotWrtDesignated)
{
    designatorSpotWrtDesignated = pDesignatorSpotWrtDesignated;
    return this;
}

public Vector3Float getDesignatorSpotWrtDesignated()
{
    return designatorSpotWrtDesignated; 
}

public DesignatorPdu setDesignatorSpotLocation(Vector3Double pDesignatorSpotLocation)
{
    designatorSpotLocation = pDesignatorSpotLocation;
    return this;
}

public Vector3Double getDesignatorSpotLocation()
{
    return designatorSpotLocation; 
}

public DesignatorPdu setDeadReckoningAlgorithm(DeadReckoningAlgorithm pDeadReckoningAlgorithm)
{
    deadReckoningAlgorithm = pDeadReckoningAlgorithm;
    return this;
}

public DeadReckoningAlgorithm getDeadReckoningAlgorithm()
{
    return deadReckoningAlgorithm; 
}

public DesignatorPdu setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}

public byte getPadding1()
{
    return padding1; 
}

public DesignatorPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

public short getPadding2()
{
    return padding2; 
}

public DesignatorPdu setEntityLinearAcceleration(Vector3Float pEntityLinearAcceleration)
{
    entityLinearAcceleration = pEntityLinearAcceleration;
    return this;
}

public Vector3Float getEntityLinearAcceleration()
{
    return entityLinearAcceleration; 
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
       designatingEntityID.marshal(dos);
       codeName.marshal(dos);
       designatedEntityID.marshal(dos);
       designatorCode.marshal(dos);
       dos.writeFloat( (float)designatorPower);
       dos.writeFloat( (float)designatorWavelength);
       designatorSpotWrtDesignated.marshal(dos);
       designatorSpotLocation.marshal(dos);
       deadReckoningAlgorithm.marshal(dos);
       dos.writeByte( (byte)padding1);
       dos.writeShort( (short)padding2);
       entityLinearAcceleration.marshal(dos);
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
        uPosition += designatingEntityID.unmarshal(dis);
        codeName = DesignatorSystemName.unmarshalEnum(dis);
        uPosition += codeName.getMarshalledSize();
        uPosition += designatedEntityID.unmarshal(dis);
        designatorCode = DesignatorDesignatorCode.unmarshalEnum(dis);
        uPosition += designatorCode.getMarshalledSize();
        designatorPower = dis.readFloat();
        uPosition += 4;
        designatorWavelength = dis.readFloat();
        uPosition += 4;
        uPosition += designatorSpotWrtDesignated.unmarshal(dis);
        uPosition += designatorSpotLocation.unmarshal(dis);
        deadReckoningAlgorithm = DeadReckoningAlgorithm.unmarshalEnum(dis);
        uPosition += deadReckoningAlgorithm.getMarshalledSize();
        padding1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += entityLinearAcceleration.unmarshal(dis);
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
   designatingEntityID.marshal(buff);
   codeName.marshal(buff);
   designatedEntityID.marshal(buff);
   designatorCode.marshal(buff);
   buff.putFloat( (float)designatorPower);
   buff.putFloat( (float)designatorWavelength);
   designatorSpotWrtDesignated.marshal(buff);
   designatorSpotLocation.marshal(buff);
   deadReckoningAlgorithm.marshal(buff);
   buff.put( (byte)padding1);
   buff.putShort( (short)padding2);
   entityLinearAcceleration.marshal(buff);
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

    designatingEntityID.unmarshal(buff);
    codeName = DesignatorSystemName.unmarshalEnum(buff);
    designatedEntityID.unmarshal(buff);
    designatorCode = DesignatorDesignatorCode.unmarshalEnum(buff);
    designatorPower = buff.getFloat();
    designatorWavelength = buff.getFloat();
    designatorSpotWrtDesignated.unmarshal(buff);
    designatorSpotLocation.unmarshal(buff);
    deadReckoningAlgorithm = DeadReckoningAlgorithm.unmarshalEnum(buff);
    padding1 = (byte)(buff.get() & 0xFF);
    padding2 = (short)(buff.getShort() & 0xFFFF);
    entityLinearAcceleration.unmarshal(buff);
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

    if(!(obj instanceof DesignatorPdu))
        return false;

     final DesignatorPdu rhs = (DesignatorPdu)obj;

     if( ! (designatingEntityID.equals( rhs.designatingEntityID) )) ivarsEqual = false;
     if( ! (codeName == rhs.codeName)) ivarsEqual = false;
     if( ! (designatedEntityID.equals( rhs.designatedEntityID) )) ivarsEqual = false;
     if( ! (designatorCode == rhs.designatorCode)) ivarsEqual = false;
     if( ! (designatorPower == rhs.designatorPower)) ivarsEqual = false;
     if( ! (designatorWavelength == rhs.designatorWavelength)) ivarsEqual = false;
     if( ! (designatorSpotWrtDesignated.equals( rhs.designatorSpotWrtDesignated) )) ivarsEqual = false;
     if( ! (designatorSpotLocation.equals( rhs.designatorSpotLocation) )) ivarsEqual = false;
     if( ! (deadReckoningAlgorithm == rhs.deadReckoningAlgorithm)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (entityLinearAcceleration.equals( rhs.entityLinearAcceleration) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
