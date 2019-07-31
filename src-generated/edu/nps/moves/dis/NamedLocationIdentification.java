/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * Information about the discrete positional relationship of the part entity with respect to the its host entity Section 6.2.62 
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class NamedLocationIdentification extends Object implements Serializable
{
   /** the station name within the host at which the part entity is located. If the part entity is On Station, this field shall specify the representation of the part's location data fields. This field shall be specified by a 16-bit enumeration  uid 212 */
   protected IsPartOfStationName stationName = IsPartOfStationName.values()[0];

   /** the number of the particular wing station, cargo hold etc., at which the part is attached.  */
   protected short  stationNumber;


/** Constructor */
 public NamedLocationIdentification()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += stationName.getMarshalledSize();
   marshalSize += 2;  // stationNumber

   return marshalSize;
}


public NamedLocationIdentification setStationName(IsPartOfStationName pStationName)
{
    stationName = pStationName;
    return this;
}

public IsPartOfStationName getStationName()
{
    return stationName; 
}

public NamedLocationIdentification setStationNumber(short pStationNumber)
{
    stationNumber = pStationNumber;
    return this;
}

public short getStationNumber()
{
    return stationNumber; 
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
       stationName.marshal(dos);
       dos.writeShort( (short)stationNumber);
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
        stationName = IsPartOfStationName.unmarshalEnum(dis);
        uPosition += stationName.getMarshalledSize();
        stationNumber = (short)dis.readUnsignedShort();
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
   stationName.marshal(buff);
   buff.putShort( (short)stationNumber);
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
    stationName = IsPartOfStationName.unmarshalEnum(buff);
    stationNumber = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof NamedLocationIdentification))
        return false;

     final NamedLocationIdentification rhs = (NamedLocationIdentification)obj;

     if( ! (stationName == rhs.stationName)) ivarsEqual = false;
     if( ! (stationNumber == rhs.stationNumber)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
