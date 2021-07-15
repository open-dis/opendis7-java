/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Association or disassociation of two entities.  Section 6.2.94.5
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EntityTypeVP extends Object implements Serializable
{
   /** The identification of the Variable Parameter record. uid 56 */
   protected VariableParameterRecordType recordType = VariableParameterRecordType.ENTITY_TYPE;

   /** Indicates if this VP has changed since last issuance uid 320 */
   protected EntityVPRecordChangeIndicator changeIndicator = EntityVPRecordChangeIndicator.values()[0];

   /** entityType is an undescribed parameter... */
   protected EntityType  entityType = new EntityType(); 

   /** padding */
   protected short  padding = (short)0;

   /** padding */
   protected int  padding1 = (int)0;


/** Constructor */
 public EntityTypeVP()
 {
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += recordType.getMarshalledSize();
   marshalSize += changeIndicator.getMarshalledSize();
   marshalSize += entityType.getMarshalledSize();
   marshalSize += 2;  // padding
   marshalSize += 4;  // padding1

   return marshalSize;
}


/** Setter for {@link EntityTypeVP#recordType}
  * @param pRecordType new value of interest
  * @return same object to permit progressive setters */
public EntityTypeVP setRecordType(VariableParameterRecordType pRecordType)
{
    recordType = pRecordType;
    return this;
}

/** Getter for {@link EntityTypeVP#recordType}
  * @return value of interest */
public VariableParameterRecordType getRecordType()
{
    return recordType; 
}

/** Setter for {@link EntityTypeVP#changeIndicator}
  * @param pChangeIndicator new value of interest
  * @return same object to permit progressive setters */
public EntityTypeVP setChangeIndicator(EntityVPRecordChangeIndicator pChangeIndicator)
{
    changeIndicator = pChangeIndicator;
    return this;
}

/** Getter for {@link EntityTypeVP#changeIndicator}
  * @return value of interest */
public EntityVPRecordChangeIndicator getChangeIndicator()
{
    return changeIndicator; 
}

/** Setter for {@link EntityTypeVP#entityType}
  * @param pEntityType new value of interest
  * @return same object to permit progressive setters */
public EntityTypeVP setEntityType(EntityType pEntityType)
{
    entityType = pEntityType;
    return this;
}

/** Getter for {@link EntityTypeVP#entityType}
  * @return value of interest */
public EntityType getEntityType()
{
    return entityType; 
}

/** Setter for {@link EntityTypeVP#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public EntityTypeVP setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}
/** Utility setter for {@link EntityTypeVP#padding}
  * @param pPadding new value of interest
  * @return same object to permit progressive setters */
public EntityTypeVP setPadding(int pPadding){
    padding = (short) pPadding;
    return this;
}

/** Getter for {@link EntityTypeVP#padding}
  * @return value of interest */
public short getPadding()
{
    return padding; 
}

/** Setter for {@link EntityTypeVP#padding1}
  * @param pPadding1 new value of interest
  * @return same object to permit progressive setters */
public EntityTypeVP setPadding1(int pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link EntityTypeVP#padding1}
  * @return value of interest */
public int getPadding1()
{
    return padding1; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       recordType.marshal(dos);
       changeIndicator.marshal(dos);
       entityType.marshal(dos);
       dos.writeShort(padding);
       dos.writeInt(padding1);
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
    try 
    {
        recordType = VariableParameterRecordType.unmarshalEnum(dis);
        uPosition += recordType.getMarshalledSize();
        changeIndicator = EntityVPRecordChangeIndicator.unmarshalEnum(dis);
        uPosition += changeIndicator.getMarshalledSize();
        uPosition += entityType.unmarshal(dis);
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
        padding1 = dis.readInt();
        uPosition += 4;
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
   recordType.marshal(byteBuffer);
   changeIndicator.marshal(byteBuffer);
   entityType.marshal(byteBuffer);
   byteBuffer.putShort( (short)padding);
   byteBuffer.putInt( (int)padding1);
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
    recordType = VariableParameterRecordType.unmarshalEnum(byteBuffer);
    changeIndicator = EntityVPRecordChangeIndicator.unmarshalEnum(byteBuffer);
    entityType.unmarshal(byteBuffer);
    padding = (short)(byteBuffer.getShort() & 0xFFFF);
    padding1 = byteBuffer.getInt();
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final EntityTypeVP rhs = (EntityTypeVP)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (changeIndicator == rhs.changeIndicator)) ivarsEqual = false;
     if( ! (entityType.equals( rhs.entityType) )) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" recordType: ").append(recordType).append("\n");
    sb.append(" changeIndicator: ").append(changeIndicator).append("\n");
    sb.append(" entityType: ").append(entityType).append("\n");
    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");

   return sb.toString();
 }
} // end of class
