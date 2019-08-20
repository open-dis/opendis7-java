/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Association or disassociation of two entities.  Section 6.2.94.5
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class EntityTypeVP extends Object implements Serializable
{
   /** the identification of the Variable Parameter record. uid 56 */
   protected VariableParameterRecordType recordType = VariableParameterRecordType.ENTITY_TYPE;

   /** Indicates if this VP has changed since last issuance uid 320 */
   protected EntityVPRecordChangeIndicator changeIndicator = EntityVPRecordChangeIndicator.values()[0];

   /**  */
   protected EntityType  entityType = new EntityType(); 

   /** padding */
   protected short  padding = (short)0;

   /** padding */
   protected int  padding1 = (int)0;


/** Constructor */
 public EntityTypeVP()
 {
 }

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link EntityTypeVP#recordType}*/
public EntityTypeVP setRecordType(VariableParameterRecordType pRecordType)
{
    recordType = pRecordType;
    return this;
}

/** Getter for {@link EntityTypeVP#recordType}*/
public VariableParameterRecordType getRecordType()
{
    return recordType; 
}

/** Setter for {@link EntityTypeVP#changeIndicator}*/
public EntityTypeVP setChangeIndicator(EntityVPRecordChangeIndicator pChangeIndicator)
{
    changeIndicator = pChangeIndicator;
    return this;
}

/** Getter for {@link EntityTypeVP#changeIndicator}*/
public EntityVPRecordChangeIndicator getChangeIndicator()
{
    return changeIndicator; 
}

/** Setter for {@link EntityTypeVP#entityType}*/
public EntityTypeVP setEntityType(EntityType pEntityType)
{
    entityType = pEntityType;
    return this;
}

/** Getter for {@link EntityTypeVP#entityType}*/
public EntityType getEntityType()
{
    return entityType; 
}

/** Setter for {@link EntityTypeVP#padding}*/
public EntityTypeVP setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link EntityTypeVP#padding}*/
public short getPadding()
{
    return padding; 
}

/** Setter for {@link EntityTypeVP#padding1}*/
public EntityTypeVP setPadding1(int pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link EntityTypeVP#padding1}*/
public int getPadding1()
{
    return padding1; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    try 
    {
       recordType.marshal(dos);
       changeIndicator.marshal(dos);
       entityType.marshal(dos);
       dos.writeShort( (short)padding);
       dos.writeInt( (int)padding1);
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
   recordType.marshal(buff);
   changeIndicator.marshal(buff);
   entityType.marshal(buff);
   buff.putShort( (short)padding);
   buff.putInt( (int)padding1);
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
    recordType = VariableParameterRecordType.unmarshalEnum(buff);
    changeIndicator = EntityVPRecordChangeIndicator.unmarshalEnum(buff);
    entityType.unmarshal(buff);
    padding = (short)(buff.getShort() & 0xFFFF);
    padding1 = buff.getInt();
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

 /**
  * Compare all fields that contribute to the state, ignoring
  * transient and static fields, for <code>this</code> and the supplied object
  * @param obj the object to compare to
  * @return true if the objects are equal, false otherwise.
  */
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof EntityTypeVP))
        return false;

     final EntityTypeVP rhs = (EntityTypeVP)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (changeIndicator == rhs.changeIndicator)) ivarsEqual = false;
     if( ! (entityType.equals( rhs.entityType) )) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
