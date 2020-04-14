/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Not specified in the standard. This is used by the ESPDU
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class DeadReckoningParameters extends Object implements Serializable
{
   /** Algorithm to use in computing dead reckoning. See EBV doc. uid 44 */
   protected DeadReckoningAlgorithm deadReckoningAlgorithm = DeadReckoningAlgorithm.values()[0];

   /** Dead reckoning parameters. Contents depends on algorithm. */
   protected byte[]  parameters = new byte[15]; 

   /** Linear acceleration of the entity */
   protected Vector3Float  entityLinearAcceleration = new Vector3Float(); 

   /** Angular velocity of the entity */
   protected Vector3Float  entityAngularVelocity = new Vector3Float(); 


/** Constructor */
 public DeadReckoningParameters()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += deadReckoningAlgorithm.getMarshalledSize();
   marshalSize += parameters.length * 1;
   marshalSize += entityLinearAcceleration.getMarshalledSize();
   marshalSize += entityAngularVelocity.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link DeadReckoningParameters#deadReckoningAlgorithm}*/
public DeadReckoningParameters setDeadReckoningAlgorithm(DeadReckoningAlgorithm pDeadReckoningAlgorithm)
{
    deadReckoningAlgorithm = pDeadReckoningAlgorithm;
    return this;
}

/** Getter for {@link DeadReckoningParameters#deadReckoningAlgorithm}*/
public DeadReckoningAlgorithm getDeadReckoningAlgorithm()
{
    return deadReckoningAlgorithm; 
}

/** Setter for {@link DeadReckoningParameters#parameters}*/
public DeadReckoningParameters setParameters(byte[] pParameters)
{
    parameters = Arrays.copyOf(pParameters, parameters.length);
    return this;
}

/** Getter for {@link DeadReckoningParameters#parameters}*/
public byte[] getParameters()
{
    return parameters; 
}

/** Setter for {@link DeadReckoningParameters#entityLinearAcceleration}*/
public DeadReckoningParameters setEntityLinearAcceleration(Vector3Float pEntityLinearAcceleration)
{
    entityLinearAcceleration = pEntityLinearAcceleration;
    return this;
}

/** Getter for {@link DeadReckoningParameters#entityLinearAcceleration}*/
public Vector3Float getEntityLinearAcceleration()
{
    return entityLinearAcceleration; 
}

/** Setter for {@link DeadReckoningParameters#entityAngularVelocity}*/
public DeadReckoningParameters setEntityAngularVelocity(Vector3Float pEntityAngularVelocity)
{
    entityAngularVelocity = pEntityAngularVelocity;
    return this;
}

/** Getter for {@link DeadReckoningParameters#entityAngularVelocity}*/
public Vector3Float getEntityAngularVelocity()
{
    return entityAngularVelocity; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    try 
    {
       deadReckoningAlgorithm.marshal(dos);

       for(int idx = 0; idx < parameters.length; idx++)
           dos.writeByte(parameters[idx]);

       entityLinearAcceleration.marshal(dos);
       entityAngularVelocity.marshal(dos);
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
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    try 
    {
        deadReckoningAlgorithm = DeadReckoningAlgorithm.unmarshalEnum(dis);
        uPosition += deadReckoningAlgorithm.getMarshalledSize();
        for(int idx = 0; idx < parameters.length; idx++)
            parameters[idx] = dis.readByte();
        uPosition += (parameters.length * 1);
        uPosition += entityLinearAcceleration.unmarshal(dis);
        uPosition += entityAngularVelocity.unmarshal(dis);
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
   deadReckoningAlgorithm.marshal(buff);

   for(int idx = 0; idx < parameters.length; idx++)
       buff.put((byte)parameters[idx]);

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
    for(int idx = 0; idx < parameters.length; idx++)
        parameters[idx] = buff.get();
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

     final DeadReckoningParameters rhs = (DeadReckoningParameters)obj;

     if( ! (deadReckoningAlgorithm == rhs.deadReckoningAlgorithm)) ivarsEqual = false;

     for(int idx = 0; idx < 15; idx++)
     {
          if(!(parameters[idx] == rhs.parameters[idx])) ivarsEqual = false;
     }

     if( ! (entityLinearAcceleration.equals( rhs.entityLinearAcceleration) )) ivarsEqual = false;
     if( ! (entityAngularVelocity.equals( rhs.entityAngularVelocity) )) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" deadReckoningAlgorithm: ").append(deadReckoningAlgorithm).append("\n");
    sb.append(" parameters: ").append("\n");
    sb.append(Arrays.toString(parameters)).append("\n");
    sb.append(" entityLinearAcceleration: ").append(entityLinearAcceleration).append("\n");
    sb.append(" entityAngularVelocity: ").append(entityAngularVelocity).append("\n");

   return sb.toString();
 }
} // end of class
