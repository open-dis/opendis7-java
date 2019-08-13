/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 9.4.3 Communicate information about the appearance of a live entity.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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

   protected EntityCapabilities  capabilities =  new LandPlatformCapabilities(); 

   protected Appearance  appearanceFields = new Appearance(); 


/** Constructor */
 public AppearancePdu()
 {
    setPduType( DISPDUType.APPEARANCE );
 }

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


public AppearancePdu setLiveEntityId(EntityID pLiveEntityId)
{
    liveEntityId = pLiveEntityId;
    return this;
}

public EntityID getLiveEntityId()
{
    return liveEntityId; 
}

public AppearancePdu setAppearanceFlags(short pAppearanceFlags)
{
    appearanceFlags = pAppearanceFlags;
    return this;
}

public short getAppearanceFlags()
{
    return appearanceFlags; 
}

public AppearancePdu setForceId(ForceID pForceId)
{
    forceId = pForceId;
    return this;
}

public ForceID getForceId()
{
    return forceId; 
}

public AppearancePdu setEntityType(EntityType pEntityType)
{
    entityType = pEntityType;
    return this;
}

public EntityType getEntityType()
{
    return entityType; 
}

public AppearancePdu setAlternateEntityType(EntityType pAlternateEntityType)
{
    alternateEntityType = pAlternateEntityType;
    return this;
}

public EntityType getAlternateEntityType()
{
    return alternateEntityType; 
}

public AppearancePdu setEntityMarking(EntityMarking pEntityMarking)
{
    entityMarking = pEntityMarking;
    return this;
}

public EntityMarking getEntityMarking()
{
    return entityMarking; 
}

public AppearancePdu setCapabilities(EntityCapabilities pCapabilities)
{
    capabilities = pCapabilities;
    return this;
}

public EntityCapabilities getCapabilities()
{
    return capabilities; 
}

public AppearancePdu setAppearanceFields(Appearance pAppearanceFields)
{
    appearanceFields = pAppearanceFields;
    return this;
}

public Appearance getAppearanceFields()
{
    return appearanceFields; 
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
       liveEntityId.marshal(dos);
       dos.writeShort( (short)appearanceFlags);
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
   liveEntityId.marshal(buff);
   buff.putShort( (short)appearanceFlags);
   forceId.marshal(buff);
   entityType.marshal(buff);
   alternateEntityType.marshal(buff);
   entityMarking.marshal(buff);
   capabilities.marshal(buff);
   appearanceFields.marshal(buff);
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

    liveEntityId.unmarshal(buff);
    appearanceFlags = (short)(buff.getShort() & 0xFFFF);
    forceId = ForceID.unmarshalEnum(buff);
    entityType.unmarshal(buff);
    alternateEntityType.unmarshal(buff);
    entityMarking.unmarshal(buff);
    capabilities.unmarshal(buff);
    appearanceFields.unmarshal(buff);
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

    if(!(obj instanceof AppearancePdu))
        return false;

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
} // end of class
