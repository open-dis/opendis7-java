package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Represents the postion and state of one entity in the world. This is identical in function to entity state pdu, but generates less garbage to collect in the Java world. Section 7.2.2.
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class FastEntityStatePdu extends EntityInformationFamilyPdu implements Serializable
{
   /** The site ID */
   protected short  site;

   /** The application ID */
   protected short  application;

   /** the entity ID */
   protected short  entity;

   /** what force this entity is affiliated with, eg red, blue, neutral, etc */
   protected byte  forceId;

   /** How many variable (nee articulation) parameters are in the variable length list */
   protected byte  numberOfVariableParameters;

   /** Kind of entity */
   protected byte  entityKind;

   /** Domain of entity (air, surface, subsurface, space, etc) */
   protected byte  domain;

   /** country to which the design of the entity is attributed */
   protected short  country;

   /** category of entity */
   protected byte  category;

   /** subcategory of entity */
   protected byte  subcategory;

   /** specific info based on subcategory field */
   protected byte  specific;

   protected byte  extra;

   /** Kind of entity */
   protected byte  altEntityKind;

   /** Domain of entity (air, surface, subsurface, space, etc) */
   protected byte  altDomain;

   /** country to which the design of the entity is attributed */
   protected short  altCountry;

   /** category of entity */
   protected byte  altCategory;

   /** subcategory of entity */
   protected byte  altSubcategory;

   /** specific info based on subcategory field */
   protected byte  altSpecific;

   protected byte  altExtra;

   /** X velo */
   protected float  xVelocity;

   /** y Value */
   protected float  yVelocity;

   /** Z value */
   protected float  zVelocity;

   /** X value */
   protected double  xLocation;

   /** y Value */
   protected double  yLocation;

   /** Z value */
   protected double  zLocation;

   protected float  psi;

   protected float  theta;

   protected float  phi;

   /** a series of bit flags that are used to help draw the entity, such as smoking, on fire, etc. */
   protected int  entityAppearance;

   /** enumeration of what dead reckoning algorighm to use */
   protected byte  deadReckoningAlgorithm;

   /** other parameters to use in the dead reckoning algorithm */
   protected byte[]  otherParameters = new byte[15]; 

   /** X value */
   protected float  xAcceleration;

   /** y Value */
   protected float  yAcceleration;

   /** Z value */
   protected float  zAcceleration;

   /** X value */
   protected float  xAngularVelocity;

   /** y Value */
   protected float  yAngularVelocity;

   /** Z value */
   protected float  zAngularVelocity;

   /** characters that can be used for debugging, or to draw unique strings on the side of entities in the world */
   protected byte[]  marking = new byte[12]; 

   /** a series of bit flags */
   protected short  capabilities;

   /** variable length list of variable parameters. In earlier versions of DIS these were known as articulation parameters */
   protected List< VariableParameter > variableParameters = new ArrayList< VariableParameter >();
 

/** Constructor */
 public FastEntityStatePdu()
 {
    setPduType( DISPDUType.ENTITY_STATE );
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 2;  // site
   marshalSize += 2;  // application
   marshalSize += 2;  // entity
   marshalSize += 1;  // forceId
   marshalSize += 1;  // numberOfVariableParameters
   marshalSize += 1;  // entityKind
   marshalSize += 1;  // domain
   marshalSize += 2;  // country
   marshalSize += 1;  // category
   marshalSize += 1;  // subcategory
   marshalSize += 1;  // specific
   marshalSize += 1;  // extra
   marshalSize += 1;  // altEntityKind
   marshalSize += 1;  // altDomain
   marshalSize += 2;  // altCountry
   marshalSize += 1;  // altCategory
   marshalSize += 1;  // altSubcategory
   marshalSize += 1;  // altSpecific
   marshalSize += 1;  // altExtra
   marshalSize += 4;  // xVelocity
   marshalSize += 4;  // yVelocity
   marshalSize += 4;  // zVelocity
   marshalSize += 8;  // xLocation
   marshalSize += 8;  // yLocation
   marshalSize += 8;  // zLocation
   marshalSize += 4;  // psi
   marshalSize += 4;  // theta
   marshalSize += 4;  // phi
   marshalSize += 4;  // entityAppearance
   marshalSize += 1;  // deadReckoningAlgorithm
   marshalSize += otherParameters.length * 1;
   marshalSize += 4;  // xAcceleration
   marshalSize += 4;  // yAcceleration
   marshalSize += 4;  // zAcceleration
   marshalSize += 4;  // xAngularVelocity
   marshalSize += 4;  // yAngularVelocity
   marshalSize += 4;  // zAngularVelocity
   marshalSize += marking.length * 1;
   marshalSize += 2;  // capabilities
   for(int idx=0; idx < variableParameters.size(); idx++)
   {
        VariableParameter listElement = variableParameters.get(idx);
        marshalSize += listElement.getMarshalledSize();
   }

   return marshalSize;
}


public FastEntityStatePdu setSite(short pSite)
{
    site = pSite;
    return this;
}

public short getSite()
{
    return site; 
}

public FastEntityStatePdu setApplication(short pApplication)
{
    application = pApplication;
    return this;
}

public short getApplication()
{
    return application; 
}

public FastEntityStatePdu setEntity(short pEntity)
{
    entity = pEntity;
    return this;
}

public short getEntity()
{
    return entity; 
}

public FastEntityStatePdu setForceId(byte pForceId)
{
    forceId = pForceId;
    return this;
}

public byte getForceId()
{
    return forceId; 
}

public FastEntityStatePdu setEntityKind(byte pEntityKind)
{
    entityKind = pEntityKind;
    return this;
}

public byte getEntityKind()
{
    return entityKind; 
}

public FastEntityStatePdu setDomain(byte pDomain)
{
    domain = pDomain;
    return this;
}

public byte getDomain()
{
    return domain; 
}

public FastEntityStatePdu setCountry(short pCountry)
{
    country = pCountry;
    return this;
}

public short getCountry()
{
    return country; 
}

public FastEntityStatePdu setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}

public byte getCategory()
{
    return category; 
}

public FastEntityStatePdu setSubcategory(byte pSubcategory)
{
    subcategory = pSubcategory;
    return this;
}

public byte getSubcategory()
{
    return subcategory; 
}

public FastEntityStatePdu setSpecific(byte pSpecific)
{
    specific = pSpecific;
    return this;
}

public byte getSpecific()
{
    return specific; 
}

public FastEntityStatePdu setExtra(byte pExtra)
{
    extra = pExtra;
    return this;
}

public byte getExtra()
{
    return extra; 
}

public FastEntityStatePdu setAltEntityKind(byte pAltEntityKind)
{
    altEntityKind = pAltEntityKind;
    return this;
}

public byte getAltEntityKind()
{
    return altEntityKind; 
}

public FastEntityStatePdu setAltDomain(byte pAltDomain)
{
    altDomain = pAltDomain;
    return this;
}

public byte getAltDomain()
{
    return altDomain; 
}

public FastEntityStatePdu setAltCountry(short pAltCountry)
{
    altCountry = pAltCountry;
    return this;
}

public short getAltCountry()
{
    return altCountry; 
}

public FastEntityStatePdu setAltCategory(byte pAltCategory)
{
    altCategory = pAltCategory;
    return this;
}

public byte getAltCategory()
{
    return altCategory; 
}

public FastEntityStatePdu setAltSubcategory(byte pAltSubcategory)
{
    altSubcategory = pAltSubcategory;
    return this;
}

public byte getAltSubcategory()
{
    return altSubcategory; 
}

public FastEntityStatePdu setAltSpecific(byte pAltSpecific)
{
    altSpecific = pAltSpecific;
    return this;
}

public byte getAltSpecific()
{
    return altSpecific; 
}

public FastEntityStatePdu setAltExtra(byte pAltExtra)
{
    altExtra = pAltExtra;
    return this;
}

public byte getAltExtra()
{
    return altExtra; 
}

public FastEntityStatePdu setXVelocity(float pXVelocity)
{
    xVelocity = pXVelocity;
    return this;
}

public float getXVelocity()
{
    return xVelocity; 
}

public FastEntityStatePdu setYVelocity(float pYVelocity)
{
    yVelocity = pYVelocity;
    return this;
}

public float getYVelocity()
{
    return yVelocity; 
}

public FastEntityStatePdu setZVelocity(float pZVelocity)
{
    zVelocity = pZVelocity;
    return this;
}

public float getZVelocity()
{
    return zVelocity; 
}

public FastEntityStatePdu setXLocation(double pXLocation)
{
    xLocation = pXLocation;
    return this;
}

public double getXLocation()
{
    return xLocation; 
}

public FastEntityStatePdu setYLocation(double pYLocation)
{
    yLocation = pYLocation;
    return this;
}

public double getYLocation()
{
    return yLocation; 
}

public FastEntityStatePdu setZLocation(double pZLocation)
{
    zLocation = pZLocation;
    return this;
}

public double getZLocation()
{
    return zLocation; 
}

public FastEntityStatePdu setPsi(float pPsi)
{
    psi = pPsi;
    return this;
}

public float getPsi()
{
    return psi; 
}

public FastEntityStatePdu setTheta(float pTheta)
{
    theta = pTheta;
    return this;
}

public float getTheta()
{
    return theta; 
}

public FastEntityStatePdu setPhi(float pPhi)
{
    phi = pPhi;
    return this;
}

public float getPhi()
{
    return phi; 
}

public FastEntityStatePdu setEntityAppearance(int pEntityAppearance)
{
    entityAppearance = pEntityAppearance;
    return this;
}

public int getEntityAppearance()
{
    return entityAppearance; 
}

public FastEntityStatePdu setDeadReckoningAlgorithm(byte pDeadReckoningAlgorithm)
{
    deadReckoningAlgorithm = pDeadReckoningAlgorithm;
    return this;
}

public byte getDeadReckoningAlgorithm()
{
    return deadReckoningAlgorithm; 
}

public FastEntityStatePdu setOtherParameters(byte[] pOtherParameters)
{
    otherParameters = Arrays.copyOf(pOtherParameters, otherParameters.length);
    return this;
}

public byte[] getOtherParameters()
{
    return otherParameters; 
}

public FastEntityStatePdu setXAcceleration(float pXAcceleration)
{
    xAcceleration = pXAcceleration;
    return this;
}

public float getXAcceleration()
{
    return xAcceleration; 
}

public FastEntityStatePdu setYAcceleration(float pYAcceleration)
{
    yAcceleration = pYAcceleration;
    return this;
}

public float getYAcceleration()
{
    return yAcceleration; 
}

public FastEntityStatePdu setZAcceleration(float pZAcceleration)
{
    zAcceleration = pZAcceleration;
    return this;
}

public float getZAcceleration()
{
    return zAcceleration; 
}

public FastEntityStatePdu setXAngularVelocity(float pXAngularVelocity)
{
    xAngularVelocity = pXAngularVelocity;
    return this;
}

public float getXAngularVelocity()
{
    return xAngularVelocity; 
}

public FastEntityStatePdu setYAngularVelocity(float pYAngularVelocity)
{
    yAngularVelocity = pYAngularVelocity;
    return this;
}

public float getYAngularVelocity()
{
    return yAngularVelocity; 
}

public FastEntityStatePdu setZAngularVelocity(float pZAngularVelocity)
{
    zAngularVelocity = pZAngularVelocity;
    return this;
}

public float getZAngularVelocity()
{
    return zAngularVelocity; 
}

public FastEntityStatePdu setMarking(byte[] pMarking)
{
    marking = Arrays.copyOf(pMarking, marking.length);
    return this;
}

public byte[] getMarking()
{
    return marking; 
}

public FastEntityStatePdu setCapabilities(short pCapabilities)
{
    capabilities = pCapabilities;
    return this;
}

public short getCapabilities()
{
    return capabilities; 
}

public FastEntityStatePdu setVariableParameters(List<VariableParameter> pVariableParameters)
{
    variableParameters = pVariableParameters;
    return this;
}

public List<VariableParameter> getVariableParameters()
{
    return variableParameters; 
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
       dos.writeShort( (short)site);
       dos.writeShort( (short)application);
       dos.writeShort( (short)entity);
       dos.writeByte( (byte)forceId);
       dos.writeByte( (byte)variableParameters.size());
       dos.writeByte( (byte)entityKind);
       dos.writeByte( (byte)domain);
       dos.writeShort( (short)country);
       dos.writeByte( (byte)category);
       dos.writeByte( (byte)subcategory);
       dos.writeByte( (byte)specific);
       dos.writeByte( (byte)extra);
       dos.writeByte( (byte)altEntityKind);
       dos.writeByte( (byte)altDomain);
       dos.writeShort( (short)altCountry);
       dos.writeByte( (byte)altCategory);
       dos.writeByte( (byte)altSubcategory);
       dos.writeByte( (byte)altSpecific);
       dos.writeByte( (byte)altExtra);
       dos.writeFloat( (float)xVelocity);
       dos.writeFloat( (float)yVelocity);
       dos.writeFloat( (float)zVelocity);
       dos.writeDouble( (double)xLocation);
       dos.writeDouble( (double)yLocation);
       dos.writeDouble( (double)zLocation);
       dos.writeFloat( (float)psi);
       dos.writeFloat( (float)theta);
       dos.writeFloat( (float)phi);
       dos.writeInt( (int)entityAppearance);
       dos.writeByte( (byte)deadReckoningAlgorithm);

       for(int idx = 0; idx < otherParameters.length; idx++)
           dos.writeByte(otherParameters[idx]);

       dos.writeFloat( (float)xAcceleration);
       dos.writeFloat( (float)yAcceleration);
       dos.writeFloat( (float)zAcceleration);
       dos.writeFloat( (float)xAngularVelocity);
       dos.writeFloat( (float)yAngularVelocity);
       dos.writeFloat( (float)zAngularVelocity);

       for(int idx = 0; idx < marking.length; idx++)
           dos.writeByte(marking[idx]);

       dos.writeShort( (short)capabilities);

       for(int idx = 0; idx < variableParameters.size(); idx++)
       {
            VariableParameter aVariableParameter = variableParameters.get(idx);
            aVariableParameter.marshal(dos);
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
        site = (short)dis.readUnsignedShort();
        uPosition += 2;
        application = (short)dis.readUnsignedShort();
        uPosition += 2;
        entity = (short)dis.readUnsignedShort();
        uPosition += 2;
        forceId = (byte)dis.readUnsignedByte();
        uPosition += 1;
        numberOfVariableParameters = (byte)dis.readUnsignedByte();
        uPosition += 1;
        entityKind = (byte)dis.readUnsignedByte();
        uPosition += 1;
        domain = (byte)dis.readUnsignedByte();
        uPosition += 1;
        country = (short)dis.readUnsignedShort();
        uPosition += 2;
        category = (byte)dis.readUnsignedByte();
        uPosition += 1;
        subcategory = (byte)dis.readUnsignedByte();
        uPosition += 1;
        specific = (byte)dis.readUnsignedByte();
        uPosition += 1;
        extra = (byte)dis.readUnsignedByte();
        uPosition += 1;
        altEntityKind = (byte)dis.readUnsignedByte();
        uPosition += 1;
        altDomain = (byte)dis.readUnsignedByte();
        uPosition += 1;
        altCountry = (short)dis.readUnsignedShort();
        uPosition += 2;
        altCategory = (byte)dis.readUnsignedByte();
        uPosition += 1;
        altSubcategory = (byte)dis.readUnsignedByte();
        uPosition += 1;
        altSpecific = (byte)dis.readUnsignedByte();
        uPosition += 1;
        altExtra = (byte)dis.readUnsignedByte();
        uPosition += 1;
        xVelocity = dis.readFloat();
        uPosition += 4;
        yVelocity = dis.readFloat();
        uPosition += 4;
        zVelocity = dis.readFloat();
        uPosition += 4;
        xLocation = dis.readDouble();
        uPosition += 4;
        yLocation = dis.readDouble();
        uPosition += 4;
        zLocation = dis.readDouble();
        uPosition += 4;
        psi = dis.readFloat();
        uPosition += 4;
        theta = dis.readFloat();
        uPosition += 4;
        phi = dis.readFloat();
        uPosition += 4;
        entityAppearance = dis.readInt();
        uPosition += 4;
        deadReckoningAlgorithm = (byte)dis.readUnsignedByte();
        uPosition += 1;
        for(int idx = 0; idx < otherParameters.length; idx++)
            otherParameters[idx] = dis.readByte(); // mike check
        uPosition += otherParameters.length; // todo, multiply by prim size mike
        xAcceleration = dis.readFloat();
        uPosition += 4;
        yAcceleration = dis.readFloat();
        uPosition += 4;
        zAcceleration = dis.readFloat();
        uPosition += 4;
        xAngularVelocity = dis.readFloat();
        uPosition += 4;
        yAngularVelocity = dis.readFloat();
        uPosition += 4;
        zAngularVelocity = dis.readFloat();
        uPosition += 4;
        for(int idx = 0; idx < marking.length; idx++)
            marking[idx] = dis.readByte(); // mike check
        uPosition += marking.length; // todo, multiply by prim size mike
        capabilities = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < numberOfVariableParameters; idx++)
        {
            VariableParameter anX = new VariableParameter();
            uPosition += anX.unmarshal(dis);
            variableParameters.add(anX);
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
   buff.putShort( (short)site);
   buff.putShort( (short)application);
   buff.putShort( (short)entity);
   buff.put( (byte)forceId);
   buff.put( (byte)variableParameters.size());
   buff.put( (byte)entityKind);
   buff.put( (byte)domain);
   buff.putShort( (short)country);
   buff.put( (byte)category);
   buff.put( (byte)subcategory);
   buff.put( (byte)specific);
   buff.put( (byte)extra);
   buff.put( (byte)altEntityKind);
   buff.put( (byte)altDomain);
   buff.putShort( (short)altCountry);
   buff.put( (byte)altCategory);
   buff.put( (byte)altSubcategory);
   buff.put( (byte)altSpecific);
   buff.put( (byte)altExtra);
   buff.putFloat( (float)xVelocity);
   buff.putFloat( (float)yVelocity);
   buff.putFloat( (float)zVelocity);
   buff.putDouble( (double)xLocation);
   buff.putDouble( (double)yLocation);
   buff.putDouble( (double)zLocation);
   buff.putFloat( (float)psi);
   buff.putFloat( (float)theta);
   buff.putFloat( (float)phi);
   buff.putInt( (int)entityAppearance);
   buff.put( (byte)deadReckoningAlgorithm);

   for(int idx = 0; idx < otherParameters.length; idx++)
       buff.put((byte)otherParameters[idx]);

   buff.putFloat( (float)xAcceleration);
   buff.putFloat( (float)yAcceleration);
   buff.putFloat( (float)zAcceleration);
   buff.putFloat( (float)xAngularVelocity);
   buff.putFloat( (float)yAngularVelocity);
   buff.putFloat( (float)zAngularVelocity);

   for(int idx = 0; idx < marking.length; idx++)
       buff.put((byte)marking[idx]);

   buff.putShort( (short)capabilities);

   for(int idx = 0; idx < variableParameters.size(); idx++)
   {
        VariableParameter aVariableParameter = (VariableParameter)variableParameters.get(idx);
        aVariableParameter.marshal(buff);
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

    site = (short)(buff.getShort() & 0xFFFF);
    application = (short)(buff.getShort() & 0xFFFF);
    entity = (short)(buff.getShort() & 0xFFFF);
    forceId = (byte)(buff.get() & 0xFF);
    numberOfVariableParameters = (byte)(buff.get() & 0xFF);
    entityKind = (byte)(buff.get() & 0xFF);
    domain = (byte)(buff.get() & 0xFF);
    country = (short)(buff.getShort() & 0xFFFF);
    category = (byte)(buff.get() & 0xFF);
    subcategory = (byte)(buff.get() & 0xFF);
    specific = (byte)(buff.get() & 0xFF);
    extra = (byte)(buff.get() & 0xFF);
    altEntityKind = (byte)(buff.get() & 0xFF);
    altDomain = (byte)(buff.get() & 0xFF);
    altCountry = (short)(buff.getShort() & 0xFFFF);
    altCategory = (byte)(buff.get() & 0xFF);
    altSubcategory = (byte)(buff.get() & 0xFF);
    altSpecific = (byte)(buff.get() & 0xFF);
    altExtra = (byte)(buff.get() & 0xFF);
    xVelocity = buff.getFloat();
    yVelocity = buff.getFloat();
    zVelocity = buff.getFloat();
    xLocation = buff.getDouble();
    yLocation = buff.getDouble();
    zLocation = buff.getDouble();
    psi = buff.getFloat();
    theta = buff.getFloat();
    phi = buff.getFloat();
    entityAppearance = buff.getInt();
    deadReckoningAlgorithm = (byte)(buff.get() & 0xFF);
    for(int idx = 0; idx < otherParameters.length; idx++)
        otherParameters[idx] = buff.get();
    xAcceleration = buff.getFloat();
    yAcceleration = buff.getFloat();
    zAcceleration = buff.getFloat();
    xAngularVelocity = buff.getFloat();
    yAngularVelocity = buff.getFloat();
    zAngularVelocity = buff.getFloat();
    for(int idx = 0; idx < marking.length; idx++)
        marking[idx] = buff.get();
    capabilities = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < numberOfVariableParameters; idx++)
    {
    VariableParameter anX = new VariableParameter();
    anX.unmarshal(buff);
    variableParameters.add(anX);
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

    if(!(obj instanceof FastEntityStatePdu))
        return false;

     final FastEntityStatePdu rhs = (FastEntityStatePdu)obj;

     if( ! (site == rhs.site)) ivarsEqual = false;
     if( ! (application == rhs.application)) ivarsEqual = false;
     if( ! (entity == rhs.entity)) ivarsEqual = false;
     if( ! (forceId == rhs.forceId)) ivarsEqual = false;
     if( ! (numberOfVariableParameters == rhs.numberOfVariableParameters)) ivarsEqual = false;
     if( ! (entityKind == rhs.entityKind)) ivarsEqual = false;
     if( ! (domain == rhs.domain)) ivarsEqual = false;
     if( ! (country == rhs.country)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subcategory == rhs.subcategory)) ivarsEqual = false;
     if( ! (specific == rhs.specific)) ivarsEqual = false;
     if( ! (extra == rhs.extra)) ivarsEqual = false;
     if( ! (altEntityKind == rhs.altEntityKind)) ivarsEqual = false;
     if( ! (altDomain == rhs.altDomain)) ivarsEqual = false;
     if( ! (altCountry == rhs.altCountry)) ivarsEqual = false;
     if( ! (altCategory == rhs.altCategory)) ivarsEqual = false;
     if( ! (altSubcategory == rhs.altSubcategory)) ivarsEqual = false;
     if( ! (altSpecific == rhs.altSpecific)) ivarsEqual = false;
     if( ! (altExtra == rhs.altExtra)) ivarsEqual = false;
     if( ! (xVelocity == rhs.xVelocity)) ivarsEqual = false;
     if( ! (yVelocity == rhs.yVelocity)) ivarsEqual = false;
     if( ! (zVelocity == rhs.zVelocity)) ivarsEqual = false;
     if( ! (xLocation == rhs.xLocation)) ivarsEqual = false;
     if( ! (yLocation == rhs.yLocation)) ivarsEqual = false;
     if( ! (zLocation == rhs.zLocation)) ivarsEqual = false;
     if( ! (psi == rhs.psi)) ivarsEqual = false;
     if( ! (theta == rhs.theta)) ivarsEqual = false;
     if( ! (phi == rhs.phi)) ivarsEqual = false;
     if( ! (entityAppearance == rhs.entityAppearance)) ivarsEqual = false;
     if( ! (deadReckoningAlgorithm == rhs.deadReckoningAlgorithm)) ivarsEqual = false;

     for(int idx = 0; idx < 15; idx++)
     {
          if(!(otherParameters[idx] == rhs.otherParameters[idx])) ivarsEqual = false;
     }

     if( ! (xAcceleration == rhs.xAcceleration)) ivarsEqual = false;
     if( ! (yAcceleration == rhs.yAcceleration)) ivarsEqual = false;
     if( ! (zAcceleration == rhs.zAcceleration)) ivarsEqual = false;
     if( ! (xAngularVelocity == rhs.xAngularVelocity)) ivarsEqual = false;
     if( ! (yAngularVelocity == rhs.yAngularVelocity)) ivarsEqual = false;
     if( ! (zAngularVelocity == rhs.zAngularVelocity)) ivarsEqual = false;

     for(int idx = 0; idx < 12; idx++)
     {
          if(!(marking[idx] == rhs.marking[idx])) ivarsEqual = false;
     }

     if( ! (capabilities == rhs.capabilities)) ivarsEqual = false;

     for(int idx = 0; idx < variableParameters.size(); idx++)
        if( ! ( variableParameters.get(idx).equals(rhs.variableParameters.get(idx)))) ivarsEqual = false;

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
