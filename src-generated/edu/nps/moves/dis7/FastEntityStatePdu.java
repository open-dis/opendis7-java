/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Represents the postion and state of one entity in the world. This is identical in function to entity state pdu, but generates less garbage to collect in the Java world. Section 7.2.2.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
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

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
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


/** Setter for {@link FastEntityStatePdu#site}*/
public FastEntityStatePdu setSite(short pSite)
{
    site = pSite;
    return this;
}

/** Getter for {@link FastEntityStatePdu#site}*/
public short getSite()
{
    return site; 
}

/** Setter for {@link FastEntityStatePdu#application}*/
public FastEntityStatePdu setApplication(short pApplication)
{
    application = pApplication;
    return this;
}

/** Getter for {@link FastEntityStatePdu#application}*/
public short getApplication()
{
    return application; 
}

/** Setter for {@link FastEntityStatePdu#entity}*/
public FastEntityStatePdu setEntity(short pEntity)
{
    entity = pEntity;
    return this;
}

/** Getter for {@link FastEntityStatePdu#entity}*/
public short getEntity()
{
    return entity; 
}

/** Setter for {@link FastEntityStatePdu#forceId}*/
public FastEntityStatePdu setForceId(byte pForceId)
{
    forceId = pForceId;
    return this;
}

/** Getter for {@link FastEntityStatePdu#forceId}*/
public byte getForceId()
{
    return forceId; 
}

/** Setter for {@link FastEntityStatePdu#entityKind}*/
public FastEntityStatePdu setEntityKind(byte pEntityKind)
{
    entityKind = pEntityKind;
    return this;
}

/** Getter for {@link FastEntityStatePdu#entityKind}*/
public byte getEntityKind()
{
    return entityKind; 
}

/** Setter for {@link FastEntityStatePdu#domain}*/
public FastEntityStatePdu setDomain(byte pDomain)
{
    domain = pDomain;
    return this;
}

/** Getter for {@link FastEntityStatePdu#domain}*/
public byte getDomain()
{
    return domain; 
}

/** Setter for {@link FastEntityStatePdu#country}*/
public FastEntityStatePdu setCountry(short pCountry)
{
    country = pCountry;
    return this;
}

/** Getter for {@link FastEntityStatePdu#country}*/
public short getCountry()
{
    return country; 
}

/** Setter for {@link FastEntityStatePdu#category}*/
public FastEntityStatePdu setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}

/** Getter for {@link FastEntityStatePdu#category}*/
public byte getCategory()
{
    return category; 
}

/** Setter for {@link FastEntityStatePdu#subcategory}*/
public FastEntityStatePdu setSubcategory(byte pSubcategory)
{
    subcategory = pSubcategory;
    return this;
}

/** Getter for {@link FastEntityStatePdu#subcategory}*/
public byte getSubcategory()
{
    return subcategory; 
}

/** Setter for {@link FastEntityStatePdu#specific}*/
public FastEntityStatePdu setSpecific(byte pSpecific)
{
    specific = pSpecific;
    return this;
}

/** Getter for {@link FastEntityStatePdu#specific}*/
public byte getSpecific()
{
    return specific; 
}

/** Setter for {@link FastEntityStatePdu#extra}*/
public FastEntityStatePdu setExtra(byte pExtra)
{
    extra = pExtra;
    return this;
}

/** Getter for {@link FastEntityStatePdu#extra}*/
public byte getExtra()
{
    return extra; 
}

/** Setter for {@link FastEntityStatePdu#altEntityKind}*/
public FastEntityStatePdu setAltEntityKind(byte pAltEntityKind)
{
    altEntityKind = pAltEntityKind;
    return this;
}

/** Getter for {@link FastEntityStatePdu#altEntityKind}*/
public byte getAltEntityKind()
{
    return altEntityKind; 
}

/** Setter for {@link FastEntityStatePdu#altDomain}*/
public FastEntityStatePdu setAltDomain(byte pAltDomain)
{
    altDomain = pAltDomain;
    return this;
}

/** Getter for {@link FastEntityStatePdu#altDomain}*/
public byte getAltDomain()
{
    return altDomain; 
}

/** Setter for {@link FastEntityStatePdu#altCountry}*/
public FastEntityStatePdu setAltCountry(short pAltCountry)
{
    altCountry = pAltCountry;
    return this;
}

/** Getter for {@link FastEntityStatePdu#altCountry}*/
public short getAltCountry()
{
    return altCountry; 
}

/** Setter for {@link FastEntityStatePdu#altCategory}*/
public FastEntityStatePdu setAltCategory(byte pAltCategory)
{
    altCategory = pAltCategory;
    return this;
}

/** Getter for {@link FastEntityStatePdu#altCategory}*/
public byte getAltCategory()
{
    return altCategory; 
}

/** Setter for {@link FastEntityStatePdu#altSubcategory}*/
public FastEntityStatePdu setAltSubcategory(byte pAltSubcategory)
{
    altSubcategory = pAltSubcategory;
    return this;
}

/** Getter for {@link FastEntityStatePdu#altSubcategory}*/
public byte getAltSubcategory()
{
    return altSubcategory; 
}

/** Setter for {@link FastEntityStatePdu#altSpecific}*/
public FastEntityStatePdu setAltSpecific(byte pAltSpecific)
{
    altSpecific = pAltSpecific;
    return this;
}

/** Getter for {@link FastEntityStatePdu#altSpecific}*/
public byte getAltSpecific()
{
    return altSpecific; 
}

/** Setter for {@link FastEntityStatePdu#altExtra}*/
public FastEntityStatePdu setAltExtra(byte pAltExtra)
{
    altExtra = pAltExtra;
    return this;
}

/** Getter for {@link FastEntityStatePdu#altExtra}*/
public byte getAltExtra()
{
    return altExtra; 
}

/** Setter for {@link FastEntityStatePdu#xVelocity}*/
public FastEntityStatePdu setXVelocity(float pXVelocity)
{
    xVelocity = pXVelocity;
    return this;
}

/** Getter for {@link FastEntityStatePdu#xVelocity}*/
public float getXVelocity()
{
    return xVelocity; 
}

/** Setter for {@link FastEntityStatePdu#yVelocity}*/
public FastEntityStatePdu setYVelocity(float pYVelocity)
{
    yVelocity = pYVelocity;
    return this;
}

/** Getter for {@link FastEntityStatePdu#yVelocity}*/
public float getYVelocity()
{
    return yVelocity; 
}

/** Setter for {@link FastEntityStatePdu#zVelocity}*/
public FastEntityStatePdu setZVelocity(float pZVelocity)
{
    zVelocity = pZVelocity;
    return this;
}

/** Getter for {@link FastEntityStatePdu#zVelocity}*/
public float getZVelocity()
{
    return zVelocity; 
}

/** Setter for {@link FastEntityStatePdu#xLocation}*/
public FastEntityStatePdu setXLocation(double pXLocation)
{
    xLocation = pXLocation;
    return this;
}

/** Getter for {@link FastEntityStatePdu#xLocation}*/
public double getXLocation()
{
    return xLocation; 
}

/** Setter for {@link FastEntityStatePdu#yLocation}*/
public FastEntityStatePdu setYLocation(double pYLocation)
{
    yLocation = pYLocation;
    return this;
}

/** Getter for {@link FastEntityStatePdu#yLocation}*/
public double getYLocation()
{
    return yLocation; 
}

/** Setter for {@link FastEntityStatePdu#zLocation}*/
public FastEntityStatePdu setZLocation(double pZLocation)
{
    zLocation = pZLocation;
    return this;
}

/** Getter for {@link FastEntityStatePdu#zLocation}*/
public double getZLocation()
{
    return zLocation; 
}

/** Setter for {@link FastEntityStatePdu#psi}*/
public FastEntityStatePdu setPsi(float pPsi)
{
    psi = pPsi;
    return this;
}

/** Getter for {@link FastEntityStatePdu#psi}*/
public float getPsi()
{
    return psi; 
}

/** Setter for {@link FastEntityStatePdu#theta}*/
public FastEntityStatePdu setTheta(float pTheta)
{
    theta = pTheta;
    return this;
}

/** Getter for {@link FastEntityStatePdu#theta}*/
public float getTheta()
{
    return theta; 
}

/** Setter for {@link FastEntityStatePdu#phi}*/
public FastEntityStatePdu setPhi(float pPhi)
{
    phi = pPhi;
    return this;
}

/** Getter for {@link FastEntityStatePdu#phi}*/
public float getPhi()
{
    return phi; 
}

/** Setter for {@link FastEntityStatePdu#entityAppearance}*/
public FastEntityStatePdu setEntityAppearance(int pEntityAppearance)
{
    entityAppearance = pEntityAppearance;
    return this;
}

/** Getter for {@link FastEntityStatePdu#entityAppearance}*/
public int getEntityAppearance()
{
    return entityAppearance; 
}

/** Setter for {@link FastEntityStatePdu#deadReckoningAlgorithm}*/
public FastEntityStatePdu setDeadReckoningAlgorithm(byte pDeadReckoningAlgorithm)
{
    deadReckoningAlgorithm = pDeadReckoningAlgorithm;
    return this;
}

/** Getter for {@link FastEntityStatePdu#deadReckoningAlgorithm}*/
public byte getDeadReckoningAlgorithm()
{
    return deadReckoningAlgorithm; 
}

/** Setter for {@link FastEntityStatePdu#otherParameters}*/
public FastEntityStatePdu setOtherParameters(byte[] pOtherParameters)
{
    otherParameters = Arrays.copyOf(pOtherParameters, otherParameters.length);
    return this;
}

/** Getter for {@link FastEntityStatePdu#otherParameters}*/
public byte[] getOtherParameters()
{
    return otherParameters; 
}

/** Setter for {@link FastEntityStatePdu#xAcceleration}*/
public FastEntityStatePdu setXAcceleration(float pXAcceleration)
{
    xAcceleration = pXAcceleration;
    return this;
}

/** Getter for {@link FastEntityStatePdu#xAcceleration}*/
public float getXAcceleration()
{
    return xAcceleration; 
}

/** Setter for {@link FastEntityStatePdu#yAcceleration}*/
public FastEntityStatePdu setYAcceleration(float pYAcceleration)
{
    yAcceleration = pYAcceleration;
    return this;
}

/** Getter for {@link FastEntityStatePdu#yAcceleration}*/
public float getYAcceleration()
{
    return yAcceleration; 
}

/** Setter for {@link FastEntityStatePdu#zAcceleration}*/
public FastEntityStatePdu setZAcceleration(float pZAcceleration)
{
    zAcceleration = pZAcceleration;
    return this;
}

/** Getter for {@link FastEntityStatePdu#zAcceleration}*/
public float getZAcceleration()
{
    return zAcceleration; 
}

/** Setter for {@link FastEntityStatePdu#xAngularVelocity}*/
public FastEntityStatePdu setXAngularVelocity(float pXAngularVelocity)
{
    xAngularVelocity = pXAngularVelocity;
    return this;
}

/** Getter for {@link FastEntityStatePdu#xAngularVelocity}*/
public float getXAngularVelocity()
{
    return xAngularVelocity; 
}

/** Setter for {@link FastEntityStatePdu#yAngularVelocity}*/
public FastEntityStatePdu setYAngularVelocity(float pYAngularVelocity)
{
    yAngularVelocity = pYAngularVelocity;
    return this;
}

/** Getter for {@link FastEntityStatePdu#yAngularVelocity}*/
public float getYAngularVelocity()
{
    return yAngularVelocity; 
}

/** Setter for {@link FastEntityStatePdu#zAngularVelocity}*/
public FastEntityStatePdu setZAngularVelocity(float pZAngularVelocity)
{
    zAngularVelocity = pZAngularVelocity;
    return this;
}

/** Getter for {@link FastEntityStatePdu#zAngularVelocity}*/
public float getZAngularVelocity()
{
    return zAngularVelocity; 
}

/** Setter for {@link FastEntityStatePdu#marking}*/
public FastEntityStatePdu setMarking(byte[] pMarking)
{
    marking = Arrays.copyOf(pMarking, marking.length);
    return this;
}

/** Getter for {@link FastEntityStatePdu#marking}*/
public byte[] getMarking()
{
    return marking; 
}

/** Setter for {@link FastEntityStatePdu#capabilities}*/
public FastEntityStatePdu setCapabilities(short pCapabilities)
{
    capabilities = pCapabilities;
    return this;
}

/** Getter for {@link FastEntityStatePdu#capabilities}*/
public short getCapabilities()
{
    return capabilities; 
}

/** Setter for {@link FastEntityStatePdu#variableParameters}*/
public FastEntityStatePdu setVariableParameters(List<VariableParameter> pVariableParameters)
{
    variableParameters = pVariableParameters;
    return this;
}

/** Getter for {@link FastEntityStatePdu#variableParameters}*/
public List<VariableParameter> getVariableParameters()
{
    return variableParameters; 
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
       dos.writeShort(site);
       dos.writeShort(application);
       dos.writeShort(entity);
       dos.writeByte(forceId);
       dos.writeByte(variableParameters.size());
       dos.writeByte(entityKind);
       dos.writeByte(domain);
       dos.writeShort(country);
       dos.writeByte(category);
       dos.writeByte(subcategory);
       dos.writeByte(specific);
       dos.writeByte(extra);
       dos.writeByte(altEntityKind);
       dos.writeByte(altDomain);
       dos.writeShort(altCountry);
       dos.writeByte(altCategory);
       dos.writeByte(altSubcategory);
       dos.writeByte(altSpecific);
       dos.writeByte(altExtra);
       dos.writeFloat(xVelocity);
       dos.writeFloat(yVelocity);
       dos.writeFloat(zVelocity);
       dos.writeDouble(xLocation);
       dos.writeDouble(yLocation);
       dos.writeDouble(zLocation);
       dos.writeFloat(psi);
       dos.writeFloat(theta);
       dos.writeFloat(phi);
       dos.writeInt(entityAppearance);
       dos.writeByte(deadReckoningAlgorithm);

       for(int idx = 0; idx < otherParameters.length; idx++)
           dos.writeByte(otherParameters[idx]);

       dos.writeFloat(xAcceleration);
       dos.writeFloat(yAcceleration);
       dos.writeFloat(zAcceleration);
       dos.writeFloat(xAngularVelocity);
       dos.writeFloat(yAngularVelocity);
       dos.writeFloat(zAngularVelocity);

       for(int idx = 0; idx < marking.length; idx++)
           dos.writeByte(marking[idx]);

       dos.writeShort(capabilities);

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
 * Deserializes an object from a DataInputStream.
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
            otherParameters[idx] = dis.readByte();
        uPosition += (otherParameters.length * 1);
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
            marking[idx] = dis.readByte();
        uPosition += (marking.length * 1);
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
        VariableParameter aVariableParameter = variableParameters.get(idx);
        aVariableParameter.marshal(buff);
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

     final FastEntityStatePdu rhs = (FastEntityStatePdu)obj;

     if( ! (site == rhs.site)) ivarsEqual = false;
     if( ! (application == rhs.application)) ivarsEqual = false;
     if( ! (entity == rhs.entity)) ivarsEqual = false;
     if( ! (forceId == rhs.forceId)) ivarsEqual = false;
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

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" site: ").append(site).append("\n");
    sb.append(" application: ").append(application).append("\n");
    sb.append(" entity: ").append(entity).append("\n");
    sb.append(" forceId: ").append(forceId).append("\n");
    sb.append(" entityKind: ").append(entityKind).append("\n");
    sb.append(" domain: ").append(domain).append("\n");
    sb.append(" country: ").append(country).append("\n");
    sb.append(" category: ").append(category).append("\n");
    sb.append(" subcategory: ").append(subcategory).append("\n");
    sb.append(" specific: ").append(specific).append("\n");
    sb.append(" extra: ").append(extra).append("\n");
    sb.append(" altEntityKind: ").append(altEntityKind).append("\n");
    sb.append(" altDomain: ").append(altDomain).append("\n");
    sb.append(" altCountry: ").append(altCountry).append("\n");
    sb.append(" altCategory: ").append(altCategory).append("\n");
    sb.append(" altSubcategory: ").append(altSubcategory).append("\n");
    sb.append(" altSpecific: ").append(altSpecific).append("\n");
    sb.append(" altExtra: ").append(altExtra).append("\n");
    sb.append(" xVelocity: ").append(xVelocity).append("\n");
    sb.append(" yVelocity: ").append(yVelocity).append("\n");
    sb.append(" zVelocity: ").append(zVelocity).append("\n");
    sb.append(" xLocation: ").append(xLocation).append("\n");
    sb.append(" yLocation: ").append(yLocation).append("\n");
    sb.append(" zLocation: ").append(zLocation).append("\n");
    sb.append(" psi: ").append(psi).append("\n");
    sb.append(" theta: ").append(theta).append("\n");
    sb.append(" phi: ").append(phi).append("\n");
    sb.append(" entityAppearance: ").append(entityAppearance).append("\n");
    sb.append(" deadReckoningAlgorithm: ").append(deadReckoningAlgorithm).append("\n");
    sb.append(" otherParameters: ").append("\n");
    sb.append(Arrays.toString(otherParameters)).append("\n");
    sb.append(" xAcceleration: ").append(xAcceleration).append("\n");
    sb.append(" yAcceleration: ").append(yAcceleration).append("\n");
    sb.append(" zAcceleration: ").append(zAcceleration).append("\n");
    sb.append(" xAngularVelocity: ").append(xAngularVelocity).append("\n");
    sb.append(" yAngularVelocity: ").append(yAngularVelocity).append("\n");
    sb.append(" zAngularVelocity: ").append(zAngularVelocity).append("\n");
    sb.append(" marking: ").append("\n");
    sb.append(Arrays.toString(marking)).append("\n");
    sb.append(" capabilities: ").append(capabilities).append("\n");
    sb.append(" variableParameters: ").append("\n");
    variableParameters.forEach(r->{ sb.append(r.getClass().getSimpleName()).append(": ").append(r).append("\n");});

   return sb.toString();
 }
} // end of class
