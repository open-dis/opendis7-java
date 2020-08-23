/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Three floating point values representing an orientation, psi, theta, and phi, aka the euler angles, in radians. Section 6.2.33
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class EulerAngles extends Object implements Serializable
{
   protected float  psi;

   protected float  theta;

   protected float  phi;


/** Constructor */
 public EulerAngles()
 {
 }

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // psi
   marshalSize += 4;  // theta
   marshalSize += 4;  // phi

   return marshalSize;
}


/** Setter for {@link EulerAngles#psi}*/
public EulerAngles setPsi(float pPsi)
{
    psi = pPsi;
    return this;
}

/** Getter for {@link EulerAngles#psi}*/
public float getPsi()
{
    return psi; 
}

/** Setter for {@link EulerAngles#theta}*/
public EulerAngles setTheta(float pTheta)
{
    theta = pTheta;
    return this;
}

/** Getter for {@link EulerAngles#theta}*/
public float getTheta()
{
    return theta; 
}

/** Setter for {@link EulerAngles#phi}*/
public EulerAngles setPhi(float pPhi)
{
    phi = pPhi;
    return this;
}

/** Getter for {@link EulerAngles#phi}*/
public float getPhi()
{
    return phi; 
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
       dos.writeFloat(psi);
       dos.writeFloat(theta);
       dos.writeFloat(phi);
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
        psi = dis.readFloat();
        uPosition += 4;
        theta = dis.readFloat();
        uPosition += 4;
        phi = dis.readFloat();
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
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.putFloat( (float)psi);
   buff.putFloat( (float)theta);
   buff.putFloat( (float)phi);
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
    psi = buff.getFloat();
    theta = buff.getFloat();
    phi = buff.getFloat();
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

     final EulerAngles rhs = (EulerAngles)obj;

     if( ! (psi == rhs.psi)) ivarsEqual = false;
     if( ! (theta == rhs.theta)) ivarsEqual = false;
     if( ! (phi == rhs.phi)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" psi: ").append(psi).append("\n");
    sb.append(" theta: ").append(theta).append("\n");
    sb.append(" phi: ").append(phi).append("\n");

   return sb.toString();
 }
} // end of class
