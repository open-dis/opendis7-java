/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 16 bit fixed binaries
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class LiveEntityOrientation16 extends Object implements Serializable
{
   protected short  psi;

   protected short  theta;

   protected short  phi;


/** Constructor */
 public LiveEntityOrientation16()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 2;  // psi
   marshalSize += 2;  // theta
   marshalSize += 2;  // phi

   return marshalSize;
}


/** Setter for {@link LiveEntityOrientation16#psi}*/
public LiveEntityOrientation16 setPsi(short pPsi)
{
    psi = pPsi;
    return this;
}

/** Getter for {@link LiveEntityOrientation16#psi}*/
public short getPsi()
{
    return psi; 
}

/** Setter for {@link LiveEntityOrientation16#theta}*/
public LiveEntityOrientation16 setTheta(short pTheta)
{
    theta = pTheta;
    return this;
}

/** Getter for {@link LiveEntityOrientation16#theta}*/
public short getTheta()
{
    return theta; 
}

/** Setter for {@link LiveEntityOrientation16#phi}*/
public LiveEntityOrientation16 setPhi(short pPhi)
{
    phi = pPhi;
    return this;
}

/** Getter for {@link LiveEntityOrientation16#phi}*/
public short getPhi()
{
    return phi; 
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
       dos.writeShort( (short)psi);
       dos.writeShort( (short)theta);
       dos.writeShort( (short)phi);
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
        psi = (short)dis.readUnsignedShort();
        uPosition += 2;
        theta = (short)dis.readUnsignedShort();
        uPosition += 2;
        phi = (short)dis.readUnsignedShort();
        uPosition += 2;
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
   buff.putShort( (short)psi);
   buff.putShort( (short)theta);
   buff.putShort( (short)phi);
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
    psi = (short)(buff.getShort() & 0xFFFF);
    theta = (short)(buff.getShort() & 0xFFFF);
    phi = (short)(buff.getShort() & 0xFFFF);
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

     final LiveEntityOrientation16 rhs = (LiveEntityOrientation16)obj;

     if( ! (psi == rhs.psi)) ivarsEqual = false;
     if( ! (theta == rhs.theta)) ivarsEqual = false;
     if( ! (phi == rhs.phi)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" psi: ").append(psi).append("\n");
    sb.append(" theta: ").append(theta).append("\n");
    sb.append(" phi: ").append(phi).append("\n");

   return sb.toString();
 }
} // end of class
