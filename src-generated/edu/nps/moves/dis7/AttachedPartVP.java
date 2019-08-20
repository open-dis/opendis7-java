/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Removable parts that may be attached to an entity.  Section 6.2.93.3
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class AttachedPartVP extends Object implements Serializable
{
   /** the identification of the Variable Parameter record. Enumeration from EBV uid 56 */
   protected VariableParameterRecordType recordType = VariableParameterRecordType.ATTACHED_PART;

   /** 0 = attached, 1 = detached. See I.2.3.1 for state transition diagram uid 415 */
   protected AttachedPartDetachedIndicator detachedIndicator = AttachedPartDetachedIndicator.values()[0];

   /** the identification of the articulated part to which this articulation parameter is attached. This field shall be specified by a 16-bit unsigned integer. This field shall contain the value zero if the articulated part is attached directly to the entity. */
   protected short  partAttachedTo = (short)0;

   /** The location or station to which the part is attached uid 57 */
   protected AttachedParts parameterType = AttachedParts.values()[0];

   /** The definition of the 64 bits shall be determined based on the type of parameter specified in the Parameter Type field  */
   protected EntityType  attachedPartType = new EntityType(); 


/** Constructor */
 public AttachedPartVP()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += recordType.getMarshalledSize();
   marshalSize += detachedIndicator.getMarshalledSize();
   marshalSize += 2;  // partAttachedTo
   marshalSize += parameterType.getMarshalledSize();
   marshalSize += attachedPartType.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link AttachedPartVP#recordType}*/
public AttachedPartVP setRecordType(VariableParameterRecordType pRecordType)
{
    recordType = pRecordType;
    return this;
}

/** Getter for {@link AttachedPartVP#recordType}*/
public VariableParameterRecordType getRecordType()
{
    return recordType; 
}

/** Setter for {@link AttachedPartVP#detachedIndicator}*/
public AttachedPartVP setDetachedIndicator(AttachedPartDetachedIndicator pDetachedIndicator)
{
    detachedIndicator = pDetachedIndicator;
    return this;
}

/** Getter for {@link AttachedPartVP#detachedIndicator}*/
public AttachedPartDetachedIndicator getDetachedIndicator()
{
    return detachedIndicator; 
}

/** Setter for {@link AttachedPartVP#partAttachedTo}*/
public AttachedPartVP setPartAttachedTo(short pPartAttachedTo)
{
    partAttachedTo = pPartAttachedTo;
    return this;
}

/** Getter for {@link AttachedPartVP#partAttachedTo}*/
public short getPartAttachedTo()
{
    return partAttachedTo; 
}

/** Setter for {@link AttachedPartVP#parameterType}*/
public AttachedPartVP setParameterType(AttachedParts pParameterType)
{
    parameterType = pParameterType;
    return this;
}

/** Getter for {@link AttachedPartVP#parameterType}*/
public AttachedParts getParameterType()
{
    return parameterType; 
}

/** Setter for {@link AttachedPartVP#attachedPartType}*/
public AttachedPartVP setAttachedPartType(EntityType pAttachedPartType)
{
    attachedPartType = pAttachedPartType;
    return this;
}

/** Getter for {@link AttachedPartVP#attachedPartType}*/
public EntityType getAttachedPartType()
{
    return attachedPartType; 
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
       detachedIndicator.marshal(dos);
       dos.writeShort( (short)partAttachedTo);
       parameterType.marshal(dos);
       attachedPartType.marshal(dos);
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
        detachedIndicator = AttachedPartDetachedIndicator.unmarshalEnum(dis);
        uPosition += detachedIndicator.getMarshalledSize();
        partAttachedTo = (short)dis.readUnsignedShort();
        uPosition += 2;
        parameterType = AttachedParts.unmarshalEnum(dis);
        uPosition += parameterType.getMarshalledSize();
        uPosition += attachedPartType.unmarshal(dis);
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
   detachedIndicator.marshal(buff);
   buff.putShort( (short)partAttachedTo);
   parameterType.marshal(buff);
   attachedPartType.marshal(buff);
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
    detachedIndicator = AttachedPartDetachedIndicator.unmarshalEnum(buff);
    partAttachedTo = (short)(buff.getShort() & 0xFFFF);
    parameterType = AttachedParts.unmarshalEnum(buff);
    attachedPartType.unmarshal(buff);
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

    if(!(obj instanceof AttachedPartVP))
        return false;

     final AttachedPartVP rhs = (AttachedPartVP)obj;

     if( ! (recordType == rhs.recordType)) ivarsEqual = false;
     if( ! (detachedIndicator == rhs.detachedIndicator)) ivarsEqual = false;
     if( ! (partAttachedTo == rhs.partAttachedTo)) ivarsEqual = false;
     if( ! (parameterType == rhs.parameterType)) ivarsEqual = false;
     if( ! (attachedPartType.equals( rhs.attachedPartType) )) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
