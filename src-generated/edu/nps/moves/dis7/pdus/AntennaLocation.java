/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Location of the radiating portion of the antenna, specified in world coordinates and entity coordinates. Section 6.2.8
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class AntennaLocation extends Object implements Serializable
{
   /** Location of the radiating portion of the antenna in world coordinates */
   protected Vector3Double  antennaLocation = new Vector3Double(); 

   /** Location of the radiating portion of the antenna in entity coordinates */
   protected Vector3Float  relativeAntennaLocation = new Vector3Float(); 


/** Constructor */
 public AntennaLocation()
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

   marshalSize += antennaLocation.getMarshalledSize();
   marshalSize += relativeAntennaLocation.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link AntennaLocation#antennaLocation}
  * @param pAntennaLocation new value of interest
  * @return same object to permit progressive setters */
public AntennaLocation setAntennaLocation(Vector3Double pAntennaLocation)
{
    antennaLocation = pAntennaLocation;
    return this;
}

/** Getter for {@link AntennaLocation#antennaLocation}
  * @return value of interest */
public Vector3Double getAntennaLocation()
{
    return antennaLocation; 
}

/** Setter for {@link AntennaLocation#relativeAntennaLocation}
  * @param pRelativeAntennaLocation new value of interest
  * @return same object to permit progressive setters */
public AntennaLocation setRelativeAntennaLocation(Vector3Float pRelativeAntennaLocation)
{
    relativeAntennaLocation = pRelativeAntennaLocation;
    return this;
}

/** Getter for {@link AntennaLocation#relativeAntennaLocation}
  * @return value of interest */
public Vector3Float getRelativeAntennaLocation()
{
    return relativeAntennaLocation; 
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
       antennaLocation.marshal(dos);
       relativeAntennaLocation.marshal(dos);
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
        uPosition += antennaLocation.unmarshal(dis);
        uPosition += relativeAntennaLocation.unmarshal(dis);
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
   antennaLocation.marshal(byteBuffer);
   relativeAntennaLocation.marshal(byteBuffer);
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
    antennaLocation.unmarshal(byteBuffer);
    relativeAntennaLocation.unmarshal(byteBuffer);
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

     final AntennaLocation rhs = (AntennaLocation)obj;

     if( ! (antennaLocation.equals( rhs.antennaLocation) )) ivarsEqual = false;
     if( ! (relativeAntennaLocation.equals( rhs.relativeAntennaLocation) )) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" antennaLocation: ").append(antennaLocation).append("\n");
    sb.append(" relativeAntennaLocation: ").append(relativeAntennaLocation).append("\n");

   return sb.toString();
 }
} // end of class
