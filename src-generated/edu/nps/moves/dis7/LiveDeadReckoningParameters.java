/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 16 bit fixed binaries
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class LiveDeadReckoningParameters extends Object implements Serializable
{
   /**  uid 44 */
   protected DeadReckoningAlgorithm deadReckoningAlgorithm = DeadReckoningAlgorithm.values()[0];

   protected LEVector3FixedByte  entityLinearAcceleration = new LEVector3FixedByte(); 

   protected LEVector3FixedByte  entityAngularVelocity = new LEVector3FixedByte(); 


/** Constructor */
 public LiveDeadReckoningParameters()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += deadReckoningAlgorithm.getMarshalledSize();
   marshalSize += entityLinearAcceleration.getMarshalledSize();
   marshalSize += entityAngularVelocity.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link LiveDeadReckoningParameters#deadReckoningAlgorithm}*/
public LiveDeadReckoningParameters setDeadReckoningAlgorithm(DeadReckoningAlgorithm pDeadReckoningAlgorithm)
{
    deadReckoningAlgorithm = pDeadReckoningAlgorithm;
    return this;
}

/** Getter for {@link LiveDeadReckoningParameters#deadReckoningAlgorithm}*/
public DeadReckoningAlgorithm getDeadReckoningAlgorithm()
{
    return deadReckoningAlgorithm; 
}

/** Setter for {@link LiveDeadReckoningParameters#entityLinearAcceleration}*/
public LiveDeadReckoningParameters setEntityLinearAcceleration(LEVector3FixedByte pEntityLinearAcceleration)
{
    entityLinearAcceleration = pEntityLinearAcceleration;
    return this;
}

/** Getter for {@link LiveDeadReckoningParameters#entityLinearAcceleration}*/
public LEVector3FixedByte getEntityLinearAcceleration()
{
    return entityLinearAcceleration; 
}

/** Setter for {@link LiveDeadReckoningParameters#entityAngularVelocity}*/
public LiveDeadReckoningParameters setEntityAngularVelocity(LEVector3FixedByte pEntityAngularVelocity)
{
    entityAngularVelocity = pEntityAngularVelocity;
    return this;
}

/** Getter for {@link LiveDeadReckoningParameters#entityAngularVelocity}*/
public LEVector3FixedByte getEntityAngularVelocity()
{
    return entityAngularVelocity; 
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
       deadReckoningAlgorithm.marshal(dos);
       entityLinearAcceleration.marshal(dos);
       entityAngularVelocity.marshal(dos);
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
    try 
    {
        deadReckoningAlgorithm = DeadReckoningAlgorithm.unmarshalEnum(dis);
        uPosition += deadReckoningAlgorithm.getMarshalledSize();
        uPosition += entityLinearAcceleration.unmarshal(dis);
        uPosition += entityAngularVelocity.unmarshal(dis);
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
   deadReckoningAlgorithm.marshal(buff);
   entityLinearAcceleration.marshal(buff);
   entityAngularVelocity.marshal(buff);
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
    deadReckoningAlgorithm = DeadReckoningAlgorithm.unmarshalEnum(buff);
    entityLinearAcceleration.unmarshal(buff);
    entityAngularVelocity.unmarshal(buff);
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

     final LiveDeadReckoningParameters rhs = (LiveDeadReckoningParameters)obj;

     if( ! (deadReckoningAlgorithm == rhs.deadReckoningAlgorithm)) ivarsEqual = false;
     if( ! (entityLinearAcceleration.equals( rhs.entityLinearAcceleration) )) ivarsEqual = false;
     if( ! (entityAngularVelocity.equals( rhs.entityAngularVelocity) )) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" deadReckoningAlgorithm: ").append(deadReckoningAlgorithm).append("\n");
    sb.append(" entityLinearAcceleration: ").append(entityLinearAcceleration).append("\n");
    sb.append(" entityAngularVelocity: ").append(entityAngularVelocity).append("\n");

   return sb.toString();
 }
} // end of class
