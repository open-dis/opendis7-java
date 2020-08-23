/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class UABeam extends Object implements Serializable
{
   protected byte  beamDataLength;

   protected byte  beamNumber;

   protected short  padding;

   protected UAFundamentalParameter  fundamentalParameterData = new UAFundamentalParameter(); 


/** Constructor */
 public UABeam()
 {
 }

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // beamDataLength
   marshalSize += 1;  // beamNumber
   marshalSize += 2;  // padding
   marshalSize += fundamentalParameterData.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link UABeam#beamDataLength}*/
public UABeam setBeamDataLength(byte pBeamDataLength)
{
    beamDataLength = pBeamDataLength;
    return this;
}

/** Getter for {@link UABeam#beamDataLength}*/
public byte getBeamDataLength()
{
    return beamDataLength; 
}

/** Setter for {@link UABeam#beamNumber}*/
public UABeam setBeamNumber(byte pBeamNumber)
{
    beamNumber = pBeamNumber;
    return this;
}

/** Getter for {@link UABeam#beamNumber}*/
public byte getBeamNumber()
{
    return beamNumber; 
}

/** Setter for {@link UABeam#padding}*/
public UABeam setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link UABeam#padding}*/
public short getPadding()
{
    return padding; 
}

/** Setter for {@link UABeam#fundamentalParameterData}*/
public UABeam setFundamentalParameterData(UAFundamentalParameter pFundamentalParameterData)
{
    fundamentalParameterData = pFundamentalParameterData;
    return this;
}

/** Getter for {@link UABeam#fundamentalParameterData}*/
public UAFundamentalParameter getFundamentalParameterData()
{
    return fundamentalParameterData; 
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
       dos.writeByte(beamDataLength);
       dos.writeByte(beamNumber);
       dos.writeShort(padding);
       fundamentalParameterData.marshal(dos);
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
        beamDataLength = (byte)dis.readUnsignedByte();
        uPosition += 1;
        beamNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
        uPosition += fundamentalParameterData.unmarshal(dis);
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
   buff.put( (byte)beamDataLength);
   buff.put( (byte)beamNumber);
   buff.putShort( (short)padding);
   fundamentalParameterData.marshal(buff);
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
    beamDataLength = (byte)(buff.get() & 0xFF);
    beamNumber = (byte)(buff.get() & 0xFF);
    padding = (short)(buff.getShort() & 0xFFFF);
    fundamentalParameterData.unmarshal(buff);
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

     final UABeam rhs = (UABeam)obj;

     if( ! (beamDataLength == rhs.beamDataLength)) ivarsEqual = false;
     if( ! (beamNumber == rhs.beamNumber)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
     if( ! (fundamentalParameterData.equals( rhs.fundamentalParameterData) )) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" beamDataLength: ").append(beamDataLength).append("\n");
    sb.append(" beamNumber: ").append(beamNumber).append("\n");
    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" fundamentalParameterData: ").append(fundamentalParameterData).append("\n");

   return sb.toString();
 }
} // end of class
