/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 8 bit fixed binaries
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // psi
   marshalSize += 1;  // theta
   marshalSize += 1;  // phi

   return marshalSize;
}


/** Setter for {@link LiveEntityOrientation#psi}*/
public LiveEntityOrientation setPsi(byte pPsi)
{
    psi = pPsi;
    return this;
}

/** Getter for {@link LiveEntityOrientation#psi}*/
public byte getPsi()
{
    return psi; 
}

/** Setter for {@link LiveEntityOrientation#theta}*/
public LiveEntityOrientation setTheta(byte pTheta)
{
    theta = pTheta;
    return this;
}

/** Getter for {@link LiveEntityOrientation#theta}*/
public byte getTheta()
{
    return theta; 
}

/** Setter for {@link LiveEntityOrientation#phi}*/
public LiveEntityOrientation setPhi(byte pPhi)
{
    phi = pPhi;
    return this;
}

/** Getter for {@link LiveEntityOrientation#phi}*/
public byte getPhi()
{
    return phi; 
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
       dos.writeByte( (byte)psi);
       dos.writeByte( (byte)theta);
       dos.writeByte( (byte)phi);
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
        psi = (byte)dis.readUnsignedByte();
        uPosition += 1;
        theta = (byte)dis.readUnsignedByte();
        uPosition += 1;
        phi = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   buff.put( (byte)psi);
   buff.put( (byte)theta);
   buff.put( (byte)phi);
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
    psi = (byte)(buff.get() & 0xFF);
    theta = (byte)(buff.get() & 0xFF);
    phi = (byte)(buff.get() & 0xFF);
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

    if(!(obj instanceof LiveEntityOrientation))
        return false;

     final LiveEntityOrientation rhs = (LiveEntityOrientation)obj;

     if( ! (psi == rhs.psi)) ivarsEqual = false;
     if( ! (theta == rhs.theta)) ivarsEqual = false;
     if( ! (phi == rhs.phi)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
