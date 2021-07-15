/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 7.6.3 Handles designating operations. See 5.3.7.2.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
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

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
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


/** Setter for {@link DesignatorPdu#designatingEntityID}
  * @param pDesignatingEntityID new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setDesignatingEntityID(EntityID pDesignatingEntityID)
{
    designatingEntityID = pDesignatingEntityID;
    return this;
}

/** Getter for {@link DesignatorPdu#designatingEntityID}
  * @return value of interest */
public EntityID getDesignatingEntityID()
{
    return designatingEntityID; 
}

/** Setter for {@link DesignatorPdu#codeName}
  * @param pCodeName new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setCodeName(DesignatorSystemName pCodeName)
{
    codeName = pCodeName;
    return this;
}

/** Getter for {@link DesignatorPdu#codeName}
  * @return value of interest */
public DesignatorSystemName getCodeName()
{
    return codeName; 
}

/** Setter for {@link DesignatorPdu#designatedEntityID}
  * @param pDesignatedEntityID new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setDesignatedEntityID(EntityID pDesignatedEntityID)
{
    designatedEntityID = pDesignatedEntityID;
    return this;
}

/** Getter for {@link DesignatorPdu#designatedEntityID}
  * @return value of interest */
public EntityID getDesignatedEntityID()
{
    return designatedEntityID; 
}

/** Setter for {@link DesignatorPdu#designatorCode}
  * @param pDesignatorCode new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setDesignatorCode(DesignatorDesignatorCode pDesignatorCode)
{
    designatorCode = pDesignatorCode;
    return this;
}

/** Getter for {@link DesignatorPdu#designatorCode}
  * @return value of interest */
public DesignatorDesignatorCode getDesignatorCode()
{
    return designatorCode; 
}

/** Setter for {@link DesignatorPdu#designatorPower}
  * @param pDesignatorPower new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setDesignatorPower(float pDesignatorPower)
{
    designatorPower = pDesignatorPower;
    return this;
}

/** Getter for {@link DesignatorPdu#designatorPower}
  * @return value of interest */
public float getDesignatorPower()
{
    return designatorPower; 
}

/** Setter for {@link DesignatorPdu#designatorWavelength}
  * @param pDesignatorWavelength new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setDesignatorWavelength(float pDesignatorWavelength)
{
    designatorWavelength = pDesignatorWavelength;
    return this;
}

/** Getter for {@link DesignatorPdu#designatorWavelength}
  * @return value of interest */
public float getDesignatorWavelength()
{
    return designatorWavelength; 
}

/** Setter for {@link DesignatorPdu#designatorSpotWrtDesignated}
  * @param pDesignatorSpotWrtDesignated new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setDesignatorSpotWrtDesignated(Vector3Float pDesignatorSpotWrtDesignated)
{
    designatorSpotWrtDesignated = pDesignatorSpotWrtDesignated;
    return this;
}

/** Getter for {@link DesignatorPdu#designatorSpotWrtDesignated}
  * @return value of interest */
public Vector3Float getDesignatorSpotWrtDesignated()
{
    return designatorSpotWrtDesignated; 
}

/** Setter for {@link DesignatorPdu#designatorSpotLocation}
  * @param pDesignatorSpotLocation new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setDesignatorSpotLocation(Vector3Double pDesignatorSpotLocation)
{
    designatorSpotLocation = pDesignatorSpotLocation;
    return this;
}

/** Getter for {@link DesignatorPdu#designatorSpotLocation}
  * @return value of interest */
public Vector3Double getDesignatorSpotLocation()
{
    return designatorSpotLocation; 
}

/** Setter for {@link DesignatorPdu#deadReckoningAlgorithm}
  * @param pDeadReckoningAlgorithm new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setDeadReckoningAlgorithm(DeadReckoningAlgorithm pDeadReckoningAlgorithm)
{
    deadReckoningAlgorithm = pDeadReckoningAlgorithm;
    return this;
}

/** Getter for {@link DesignatorPdu#deadReckoningAlgorithm}
  * @return value of interest */
public DeadReckoningAlgorithm getDeadReckoningAlgorithm()
{
    return deadReckoningAlgorithm; 
}

/** Setter for {@link DesignatorPdu#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}
/** Utility setter for {@link DesignatorPdu#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setPadding1(int pPadding1){
    padding1 = (byte) pPadding1;
    return this;
}

/** Getter for {@link DesignatorPdu#padding1}
  * @return value of interest */
public byte getPadding1()
{
    return padding1; 
}

/** Setter for {@link DesignatorPdu#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}
/** Utility setter for {@link DesignatorPdu#padding2}
  * @param pPadding2 new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setPadding2(int pPadding2){
    padding2 = (short) pPadding2;
    return this;
}

/** Getter for {@link DesignatorPdu#padding2}
  * @return value of interest */
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link DesignatorPdu#entityLinearAcceleration}
  * @param pEntityLinearAcceleration new value of interest
  * @return same object to permit progressive setters */
public DesignatorPdu setEntityLinearAcceleration(Vector3Float pEntityLinearAcceleration)
{
    entityLinearAcceleration = pEntityLinearAcceleration;
    return this;
}

/** Getter for {@link DesignatorPdu#entityLinearAcceleration}
  * @return value of interest */
public Vector3Float getEntityLinearAcceleration()
{
    return entityLinearAcceleration; 
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
       designatingEntityID.marshal(dos);
       codeName.marshal(dos);
       designatedEntityID.marshal(dos);
       designatorCode.marshal(dos);
       dos.writeFloat(designatorPower);
       dos.writeFloat(designatorWavelength);
       designatorSpotWrtDesignated.marshal(dos);
       designatorSpotLocation.marshal(dos);
       deadReckoningAlgorithm.marshal(dos);
       dos.writeByte(padding1);
       dos.writeShort(padding2);
       entityLinearAcceleration.marshal(dos);
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
   designatingEntityID.marshal(byteBuffer);
   codeName.marshal(byteBuffer);
   designatedEntityID.marshal(byteBuffer);
   designatorCode.marshal(byteBuffer);
   byteBuffer.putFloat( (float)designatorPower);
   byteBuffer.putFloat( (float)designatorWavelength);
   designatorSpotWrtDesignated.marshal(byteBuffer);
   designatorSpotLocation.marshal(byteBuffer);
   deadReckoningAlgorithm.marshal(byteBuffer);
   byteBuffer.put( (byte)padding1);
   byteBuffer.putShort( (short)padding2);
   entityLinearAcceleration.marshal(byteBuffer);
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

    designatingEntityID.unmarshal(byteBuffer);
    codeName = DesignatorSystemName.unmarshalEnum(byteBuffer);
    designatedEntityID.unmarshal(byteBuffer);
    designatorCode = DesignatorDesignatorCode.unmarshalEnum(byteBuffer);
    designatorPower = byteBuffer.getFloat();
    designatorWavelength = byteBuffer.getFloat();
    designatorSpotWrtDesignated.unmarshal(byteBuffer);
    designatorSpotLocation.unmarshal(byteBuffer);
    deadReckoningAlgorithm = DeadReckoningAlgorithm.unmarshalEnum(byteBuffer);
    padding1 = (byte)(byteBuffer.get() & 0xFF);
    padding2 = (short)(byteBuffer.getShort() & 0xFFFF);
    entityLinearAcceleration.unmarshal(byteBuffer);
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

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" designatingEntityID: ").append(designatingEntityID).append("\n");
    sb.append(" codeName: ").append(codeName).append("\n");
    sb.append(" designatedEntityID: ").append(designatedEntityID).append("\n");
    sb.append(" designatorCode: ").append(designatorCode).append("\n");
    sb.append(" designatorPower: ").append(designatorPower).append("\n");
    sb.append(" designatorWavelength: ").append(designatorWavelength).append("\n");
    sb.append(" designatorSpotWrtDesignated: ").append(designatorSpotWrtDesignated).append("\n");
    sb.append(" designatorSpotLocation: ").append(designatorSpotLocation).append("\n");
    sb.append(" deadReckoningAlgorithm: ").append(deadReckoningAlgorithm).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");
    sb.append(" entityLinearAcceleration: ").append(entityLinearAcceleration).append("\n");

   return sb.toString();
 }
} // end of class
