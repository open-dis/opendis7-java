/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Describes the scan volue of an emitter beam. Section 6.2.11.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class BeamData extends Object implements Serializable
{
   /** Specifies the beam azimuth an elevation centers and corresponding half-angles to describe the scan volume */
   protected float  beamAzimuthCenter;

   /** Specifies the beam azimuth sweep to determine scan volume */
   protected float  beamAzimuthSweep;

   /** Specifies the beam elevation center to determine scan volume */
   protected float  beamElevationCenter;

   /** Specifies the beam elevation sweep to determine scan volume */
   protected float  beamElevationSweep;

   /** allows receiver to synchronize its regenerated scan pattern to that of the emmitter. Specifies the percentage of time a scan is through its pattern from its origion. */
   protected float  beamSweepSync;


/** Constructor */
 public BeamData()
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

   marshalSize += 4;  // beamAzimuthCenter
   marshalSize += 4;  // beamAzimuthSweep
   marshalSize += 4;  // beamElevationCenter
   marshalSize += 4;  // beamElevationSweep
   marshalSize += 4;  // beamSweepSync

   return marshalSize;
}


/** Setter for {@link BeamData#beamAzimuthCenter}
  * @param pBeamAzimuthCenter new value of interest
  * @return same object to permit progressive setters */
public BeamData setBeamAzimuthCenter(float pBeamAzimuthCenter)
{
    beamAzimuthCenter = pBeamAzimuthCenter;
    return this;
}

/** Getter for {@link BeamData#beamAzimuthCenter}
  * @return value of interest */
public float getBeamAzimuthCenter()
{
    return beamAzimuthCenter; 
}

/** Setter for {@link BeamData#beamAzimuthSweep}
  * @param pBeamAzimuthSweep new value of interest
  * @return same object to permit progressive setters */
public BeamData setBeamAzimuthSweep(float pBeamAzimuthSweep)
{
    beamAzimuthSweep = pBeamAzimuthSweep;
    return this;
}

/** Getter for {@link BeamData#beamAzimuthSweep}
  * @return value of interest */
public float getBeamAzimuthSweep()
{
    return beamAzimuthSweep; 
}

/** Setter for {@link BeamData#beamElevationCenter}
  * @param pBeamElevationCenter new value of interest
  * @return same object to permit progressive setters */
public BeamData setBeamElevationCenter(float pBeamElevationCenter)
{
    beamElevationCenter = pBeamElevationCenter;
    return this;
}

/** Getter for {@link BeamData#beamElevationCenter}
  * @return value of interest */
public float getBeamElevationCenter()
{
    return beamElevationCenter; 
}

/** Setter for {@link BeamData#beamElevationSweep}
  * @param pBeamElevationSweep new value of interest
  * @return same object to permit progressive setters */
public BeamData setBeamElevationSweep(float pBeamElevationSweep)
{
    beamElevationSweep = pBeamElevationSweep;
    return this;
}

/** Getter for {@link BeamData#beamElevationSweep}
  * @return value of interest */
public float getBeamElevationSweep()
{
    return beamElevationSweep; 
}

/** Setter for {@link BeamData#beamSweepSync}
  * @param pBeamSweepSync new value of interest
  * @return same object to permit progressive setters */
public BeamData setBeamSweepSync(float pBeamSweepSync)
{
    beamSweepSync = pBeamSweepSync;
    return this;
}

/** Getter for {@link BeamData#beamSweepSync}
  * @return value of interest */
public float getBeamSweepSync()
{
    return beamSweepSync; 
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
       dos.writeFloat(beamAzimuthCenter);
       dos.writeFloat(beamAzimuthSweep);
       dos.writeFloat(beamElevationCenter);
       dos.writeFloat(beamElevationSweep);
       dos.writeFloat(beamSweepSync);
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
        beamAzimuthCenter = dis.readFloat();
        uPosition += 4;
        beamAzimuthSweep = dis.readFloat();
        uPosition += 4;
        beamElevationCenter = dis.readFloat();
        uPosition += 4;
        beamElevationSweep = dis.readFloat();
        uPosition += 4;
        beamSweepSync = dis.readFloat();
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
 * @throws java.nio.BufferOverflowException if byteBuffer is too small
 * @throws java.nio.ReadOnlyBufferException if byteBuffer is read only
 * @see java.nio.ByteBuffer
 * @param byteBuffer The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
   byteBuffer.putFloat( (float)beamAzimuthCenter);
   byteBuffer.putFloat( (float)beamAzimuthSweep);
   byteBuffer.putFloat( (float)beamElevationCenter);
   byteBuffer.putFloat( (float)beamElevationSweep);
   byteBuffer.putFloat( (float)beamSweepSync);
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
    beamAzimuthCenter = byteBuffer.getFloat();
    beamAzimuthSweep = byteBuffer.getFloat();
    beamElevationCenter = byteBuffer.getFloat();
    beamElevationSweep = byteBuffer.getFloat();
    beamSweepSync = byteBuffer.getFloat();
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

     final BeamData rhs = (BeamData)obj;

     if( ! (beamAzimuthCenter == rhs.beamAzimuthCenter)) ivarsEqual = false;
     if( ! (beamAzimuthSweep == rhs.beamAzimuthSweep)) ivarsEqual = false;
     if( ! (beamElevationCenter == rhs.beamElevationCenter)) ivarsEqual = false;
     if( ! (beamElevationSweep == rhs.beamElevationSweep)) ivarsEqual = false;
     if( ! (beamSweepSync == rhs.beamSweepSync)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" beamAzimuthCenter: ").append(beamAzimuthCenter).append("\n");
    sb.append(" beamAzimuthSweep: ").append(beamAzimuthSweep).append("\n");
    sb.append(" beamElevationCenter: ").append(beamElevationCenter).append("\n");
    sb.append(" beamElevationSweep: ").append(beamElevationSweep).append("\n");
    sb.append(" beamSweepSync: ").append(beamSweepSync).append("\n");

   return sb.toString();
 }
} // end of class
