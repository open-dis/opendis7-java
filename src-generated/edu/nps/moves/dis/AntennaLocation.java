package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * Location of the radiating portion of the antenna, specified in world coordinates and entity coordinates. Section 6.2.8
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
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

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += antennaLocation.getMarshalledSize();
   marshalSize += relativeAntennaLocation.getMarshalledSize();

   return marshalSize;
}


public AntennaLocation setAntennaLocation(Vector3Double pAntennaLocation)
{
    antennaLocation = pAntennaLocation;
    return this;
}

public Vector3Double getAntennaLocation()
{
    return antennaLocation; 
}

public AntennaLocation setRelativeAntennaLocation(Vector3Float pRelativeAntennaLocation)
{
    relativeAntennaLocation = pRelativeAntennaLocation;
    return this;
}

public Vector3Float getRelativeAntennaLocation()
{
    return relativeAntennaLocation; 
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
       antennaLocation.marshal(dos);
       relativeAntennaLocation.marshal(dos);
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
        uPosition += antennaLocation.unmarshal(dis);
        uPosition += relativeAntennaLocation.unmarshal(dis);
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
   antennaLocation.marshal(buff);
   relativeAntennaLocation.marshal(buff);
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
    antennaLocation.unmarshal(buff);
    relativeAntennaLocation.unmarshal(buff);
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

    if(!(obj instanceof AntennaLocation))
        return false;

     final AntennaLocation rhs = (AntennaLocation)obj;

     if( ! (antennaLocation.equals( rhs.antennaLocation) )) ivarsEqual = false;
     if( ! (relativeAntennaLocation.equals( rhs.relativeAntennaLocation) )) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
