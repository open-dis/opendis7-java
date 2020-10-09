/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 9.4.3 Communicate information about the appearance of a live entity.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class AppearancePdu extends LiveEntityFamilyPdu implements Serializable
{
   protected EntityID  liveEntityId = new EntityID(); 

   /** 16-bit bit field */
   protected short  appearanceFlags;

   /**  uid 6 */
   protected ForceID forceId = ForceID.values()[0];

   protected EntityType  entityType = new EntityType(); 

   protected EntityType  alternateEntityType = new EntityType(); 

   protected EntityMarking  entityMarking = new EntityMarking(); 

   /**  uid 55 */
   protected EntityCapabilities capabilities = new LandPlatformCapabilities();

   protected Appearance  appearanceFields = new Appearance(); 


/** Constructor */
 public AppearancePdu()
 {
    setPduType( DISPDUType.APPEARANCE );
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += liveEntityId.getMarshalledSize();
   marshalSize += 2;  // appearanceFlags
   marshalSize += forceId.getMarshalledSize();
   marshalSize += entityType.getMarshalledSize();
   marshalSize += alternateEntityType.getMarshalledSize();
   marshalSize += entityMarking.getMarshalledSize();
   marshalSize += capabilities.getMarshalledSize();
   marshalSize += appearanceFields.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link AppearancePdu#liveEntityId}
  * @param pLiveEntityId new value of interest
  * @return same object to permit progressive setters */
public AppearancePdu setLiveEntityId(EntityID pLiveEntityId)
{
    liveEntityId = pLiveEntityId;
    return this;
}

/** Getter for {@link AppearancePdu#liveEntityId}
  * @return value of interest */
public EntityID getLiveEntityId()
{
    return liveEntityId; 
}

/** Setter for {@link AppearancePdu#appearanceFlags}
  * @param pAppearanceFlags new value of interest
  * @return same object to permit progressive setters */
public AppearancePdu setAppearanceFlags(short pAppearanceFlags)
{
    appearanceFlags = pAppearanceFlags;
    return this;
}
/** Utility setter for {@link AppearancePdu#appearanceFlags}
  * @param pAppearanceFlags new value of interest
  * @return same object to permit progressive setters */
public AppearancePdu setAppearanceFlags(int pAppearanceFlags){
    appearanceFlags = (short) pAppearanceFlags;
    return this;
}

/** Getter for {@link AppearancePdu#appearanceFlags}
  * @return value of interest */
public short getAppearanceFlags()
{
    return appearanceFlags; 
}

/** Setter for {@link AppearancePdu#forceId}
  * @param pForceId new value of interest
  * @return same object to permit progressive setters */
public AppearancePdu setForceId(ForceID pForceId)
{
    forceId = pForceId;
    return this;
}

/** Getter for {@link AppearancePdu#forceId}
  * @return value of interest */
public ForceID getForceId()
{
    return forceId; 
}

/** Setter for {@link AppearancePdu#entityType}
  * @param pEntityType new value of interest
  * @return same object to permit progressive setters */
public AppearancePdu setEntityType(EntityType pEntityType)
{
    entityType = pEntityType;
    return this;
}

/** Getter for {@link AppearancePdu#entityType}
  * @return value of interest */
public EntityType getEntityType()
{
    return entityType; 
}

/** Setter for {@link AppearancePdu#alternateEntityType}
  * @param pAlternateEntityType new value of interest
  * @return same object to permit progressive setters */
public AppearancePdu setAlternateEntityType(EntityType pAlternateEntityType)
{
    alternateEntityType = pAlternateEntityType;
    return this;
}

/** Getter for {@link AppearancePdu#alternateEntityType}
  * @return value of interest */
public EntityType getAlternateEntityType()
{
    return alternateEntityType; 
}

/** Setter for {@link AppearancePdu#entityMarking}
  * @param pEntityMarking new value of interest
  * @return same object to permit progressive setters */
public AppearancePdu setEntityMarking(EntityMarking pEntityMarking)
{
    entityMarking = pEntityMarking;
    return this;
}

/** Getter for {@link AppearancePdu#entityMarking}
  * @return value of interest */
public EntityMarking getEntityMarking()
{
    return entityMarking; 
}

/** Setter for {@link AppearancePdu#capabilities}
  * @param pCapabilities new value of interest
  * @return same object to permit progressive setters */
public AppearancePdu setCapabilities(EntityCapabilities pCapabilities)
{
    capabilities = pCapabilities;
    return this;
}

/** Getter for {@link AppearancePdu#capabilities}
  * @return value of interest */
public EntityCapabilities getCapabilities()
{
    return capabilities; 
}

/** Setter for {@link AppearancePdu#appearanceFields}
  * @param pAppearanceFields new value of interest
  * @return same object to permit progressive setters */
public AppearancePdu setAppearanceFields(Appearance pAppearanceFields)
{
    appearanceFields = pAppearanceFields;
    return this;
}

/** Getter for {@link AppearancePdu#appearanceFields}
  * @return value of interest */
public Appearance getAppearanceFields()
{
    return appearanceFields; 
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
       liveEntityId.marshal(dos);
       dos.writeShort(appearanceFlags);
       forceId.marshal(dos);
       entityType.marshal(dos);
       alternateEntityType.marshal(dos);
       entityMarking.marshal(dos);
       capabilities.marshal(dos);
       appearanceFields.marshal(dos);
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
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        uPosition += liveEntityId.unmarshal(dis);
        appearanceFlags = (short)dis.readUnsignedShort();
        uPosition += 2;
        forceId = ForceID.unmarshalEnum(dis);
        uPosition += forceId.getMarshalledSize();
        uPosition += entityType.unmarshal(dis);
        uPosition += alternateEntityType.unmarshal(dis);
        uPosition += entityMarking.unmarshal(dis);
        uPosition += capabilities.unmarshal(dis);
        uPosition += appearanceFields.unmarshal(dis);
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
   liveEntityId.marshal(byteBuffer);
   byteBuffer.putShort( (short)appearanceFlags);
   forceId.marshal(byteBuffer);
   entityType.marshal(byteBuffer);
   alternateEntityType.marshal(byteBuffer);
   entityMarking.marshal(byteBuffer);
   capabilities.marshal(byteBuffer);
   appearanceFields.marshal(byteBuffer);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    liveEntityId.unmarshal(byteBuffer);
    appearanceFlags = (short)(byteBuffer.getShort() & 0xFFFF);
    forceId = ForceID.unmarshalEnum(byteBuffer);
    entityType.unmarshal(byteBuffer);
    alternateEntityType.unmarshal(byteBuffer);
    entityMarking.unmarshal(byteBuffer);
    capabilities.unmarshal(byteBuffer);
    appearanceFields.unmarshal(byteBuffer);
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

     final AppearancePdu rhs = (AppearancePdu)obj;

     if( ! (liveEntityId.equals( rhs.liveEntityId) )) ivarsEqual = false;
     if( ! (appearanceFlags == rhs.appearanceFlags)) ivarsEqual = false;
     if( ! (forceId == rhs.forceId)) ivarsEqual = false;
     if( ! (entityType.equals( rhs.entityType) )) ivarsEqual = false;
     if( ! (alternateEntityType.equals( rhs.alternateEntityType) )) ivarsEqual = false;
     if( ! (entityMarking.equals( rhs.entityMarking) )) ivarsEqual = false;
     if( ! (capabilities.equals( rhs.capabilities) )) ivarsEqual = false;
     if( ! (appearanceFields.equals( rhs.appearanceFields) )) ivarsEqual = false;
    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" liveEntityId: ").append(liveEntityId).append("\n");
    sb.append(" appearanceFlags: ").append(appearanceFlags).append("\n");
    sb.append(" forceId: ").append(forceId).append("\n");
    sb.append(" entityType: ").append(entityType).append("\n");
    sb.append(" alternateEntityType: ").append(alternateEntityType).append("\n");
    sb.append(" entityMarking: ").append(entityMarking).append("\n");
    sb.append(" capabilities: ").append(capabilities).append("\n");
    sb.append(" appearanceFields: ").append(appearanceFields).append("\n");

   return sb.toString();
 }
} // end of class
