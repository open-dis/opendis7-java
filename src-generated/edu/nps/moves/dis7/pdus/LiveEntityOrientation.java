/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 8-bit fixed binaries
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class LiveEntityOrientation extends Object implements Serializable
{
   protected byte  psi;

   protected byte  theta;

   protected byte  phi;


/** Constructor */
 public LiveEntityOrientation()
 {
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * See <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // psi
   marshalSize += 1;  // theta
   marshalSize += 1;  // phi

   return marshalSize;
}


/** Setter for {@link LiveEntityOrientation#psi}
  * @param pPsi new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientation setPsi(byte pPsi)
{
    psi = pPsi;
    return this;
}
/** Utility setter for {@link LiveEntityOrientation#psi}
  * @param pPsi new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientation setPsi(int pPsi){
    psi = (byte) pPsi;
    return this;
}

/** Getter for {@link LiveEntityOrientation#psi}
  * @return value of interest */
public byte getPsi()
{
    return psi; 
}

/** Setter for {@link LiveEntityOrientation#theta}
  * @param pTheta new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientation setTheta(byte pTheta)
{
    theta = pTheta;
    return this;
}
/** Utility setter for {@link LiveEntityOrientation#theta}
  * @param pTheta new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientation setTheta(int pTheta){
    theta = (byte) pTheta;
    return this;
}

/** Getter for {@link LiveEntityOrientation#theta}
  * @return value of interest */
public byte getTheta()
{
    return theta; 
}

/** Setter for {@link LiveEntityOrientation#phi}
  * @param pPhi new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientation setPhi(byte pPhi)
{
    phi = pPhi;
    return this;
}
/** Utility setter for {@link LiveEntityOrientation#phi}
  * @param pPhi new value of interest
  * @return same object to permit progressive setters */
public LiveEntityOrientation setPhi(int pPhi){
    phi = (byte) pPhi;
    return this;
}

/** Getter for {@link LiveEntityOrientation#phi}
  * @return value of interest */
public byte getPhi()
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
       dos.writeByte(psi);
       dos.writeByte(theta);
       dos.writeByte(phi);
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
    try 
    {
        psi = (byte)dis.readUnsignedByte();
        uPosition += 1;
        theta = (byte)dis.readUnsignedByte();
        uPosition += 1;
        phi = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   byteBuffer.put( (byte)psi);
   byteBuffer.put( (byte)theta);
   byteBuffer.put( (byte)phi);
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
    psi = (byte)(byteBuffer.get() & 0xFF);
    theta = (byte)(byteBuffer.get() & 0xFF);
    phi = (byte)(byteBuffer.get() & 0xFF);
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

     final LiveEntityOrientation rhs = (LiveEntityOrientation)obj;

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
