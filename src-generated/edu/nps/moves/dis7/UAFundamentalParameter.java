/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Regeneration parameters for active emission systems that are variable throughout a scenario. Section 6.2.91
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class UAFundamentalParameter extends Object implements Serializable
{
   /** Which database record shall be used uid 146 */
   protected UAActiveEmissionParameterIndex activeEmissionParameterIndex = UAActiveEmissionParameterIndex.values()[0];

   /** The type of scan pattern, If not used, zero uid 147 */
   protected UAScanPattern scanPattern = UAScanPattern.values()[0];

   /** center azimuth bearing of th emain beam. In radians. */
   protected float  beamCenterAzimuthHorizontal;

   /** Horizontal beamwidth of th emain beam Meastued at the 3dB down point of peak radiated power. In radians. */
   protected float  azimuthalBeamwidthHorizontal;

   /** center of the d/e angle of th emain beam relative to the stablised de angle of the target. In radians. */
   protected float  beamCenterDepressionElevation;

   /** vertical beamwidth of the main beam. Meastured at the 3dB down point of peak radiated power. In radians. */
   protected float  depressionElevationBeamWidth;


/** Constructor */
 public UAFundamentalParameter()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += activeEmissionParameterIndex.getMarshalledSize();
   marshalSize += scanPattern.getMarshalledSize();
   marshalSize += 4;  // beamCenterAzimuthHorizontal
   marshalSize += 4;  // azimuthalBeamwidthHorizontal
   marshalSize += 4;  // beamCenterDepressionElevation
   marshalSize += 4;  // depressionElevationBeamWidth

   return marshalSize;
}


/** Setter for {@link UAFundamentalParameter#activeEmissionParameterIndex}*/
public UAFundamentalParameter setActiveEmissionParameterIndex(UAActiveEmissionParameterIndex pActiveEmissionParameterIndex)
{
    activeEmissionParameterIndex = pActiveEmissionParameterIndex;
    return this;
}

/** Getter for {@link UAFundamentalParameter#activeEmissionParameterIndex}*/
public UAActiveEmissionParameterIndex getActiveEmissionParameterIndex()
{
    return activeEmissionParameterIndex; 
}

/** Setter for {@link UAFundamentalParameter#scanPattern}*/
public UAFundamentalParameter setScanPattern(UAScanPattern pScanPattern)
{
    scanPattern = pScanPattern;
    return this;
}

/** Getter for {@link UAFundamentalParameter#scanPattern}*/
public UAScanPattern getScanPattern()
{
    return scanPattern; 
}

/** Setter for {@link UAFundamentalParameter#beamCenterAzimuthHorizontal}*/
public UAFundamentalParameter setBeamCenterAzimuthHorizontal(float pBeamCenterAzimuthHorizontal)
{
    beamCenterAzimuthHorizontal = pBeamCenterAzimuthHorizontal;
    return this;
}

/** Getter for {@link UAFundamentalParameter#beamCenterAzimuthHorizontal}*/
public float getBeamCenterAzimuthHorizontal()
{
    return beamCenterAzimuthHorizontal; 
}

/** Setter for {@link UAFundamentalParameter#azimuthalBeamwidthHorizontal}*/
public UAFundamentalParameter setAzimuthalBeamwidthHorizontal(float pAzimuthalBeamwidthHorizontal)
{
    azimuthalBeamwidthHorizontal = pAzimuthalBeamwidthHorizontal;
    return this;
}

/** Getter for {@link UAFundamentalParameter#azimuthalBeamwidthHorizontal}*/
public float getAzimuthalBeamwidthHorizontal()
{
    return azimuthalBeamwidthHorizontal; 
}

/** Setter for {@link UAFundamentalParameter#beamCenterDepressionElevation}*/
public UAFundamentalParameter setBeamCenterDepressionElevation(float pBeamCenterDepressionElevation)
{
    beamCenterDepressionElevation = pBeamCenterDepressionElevation;
    return this;
}

/** Getter for {@link UAFundamentalParameter#beamCenterDepressionElevation}*/
public float getBeamCenterDepressionElevation()
{
    return beamCenterDepressionElevation; 
}

/** Setter for {@link UAFundamentalParameter#depressionElevationBeamWidth}*/
public UAFundamentalParameter setDepressionElevationBeamWidth(float pDepressionElevationBeamWidth)
{
    depressionElevationBeamWidth = pDepressionElevationBeamWidth;
    return this;
}

/** Getter for {@link UAFundamentalParameter#depressionElevationBeamWidth}*/
public float getDepressionElevationBeamWidth()
{
    return depressionElevationBeamWidth; 
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
       activeEmissionParameterIndex.marshal(dos);
       scanPattern.marshal(dos);
       dos.writeFloat( (float)beamCenterAzimuthHorizontal);
       dos.writeFloat( (float)azimuthalBeamwidthHorizontal);
       dos.writeFloat( (float)beamCenterDepressionElevation);
       dos.writeFloat( (float)depressionElevationBeamWidth);
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
        activeEmissionParameterIndex = UAActiveEmissionParameterIndex.unmarshalEnum(dis);
        uPosition += activeEmissionParameterIndex.getMarshalledSize();
        scanPattern = UAScanPattern.unmarshalEnum(dis);
        uPosition += scanPattern.getMarshalledSize();
        beamCenterAzimuthHorizontal = dis.readFloat();
        uPosition += 4;
        azimuthalBeamwidthHorizontal = dis.readFloat();
        uPosition += 4;
        beamCenterDepressionElevation = dis.readFloat();
        uPosition += 4;
        depressionElevationBeamWidth = dis.readFloat();
        uPosition += 4;
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
   activeEmissionParameterIndex.marshal(buff);
   scanPattern.marshal(buff);
   buff.putFloat( (float)beamCenterAzimuthHorizontal);
   buff.putFloat( (float)azimuthalBeamwidthHorizontal);
   buff.putFloat( (float)beamCenterDepressionElevation);
   buff.putFloat( (float)depressionElevationBeamWidth);
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
    activeEmissionParameterIndex = UAActiveEmissionParameterIndex.unmarshalEnum(buff);
    scanPattern = UAScanPattern.unmarshalEnum(buff);
    beamCenterAzimuthHorizontal = buff.getFloat();
    azimuthalBeamwidthHorizontal = buff.getFloat();
    beamCenterDepressionElevation = buff.getFloat();
    depressionElevationBeamWidth = buff.getFloat();
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

     final UAFundamentalParameter rhs = (UAFundamentalParameter)obj;

     if( ! (activeEmissionParameterIndex == rhs.activeEmissionParameterIndex)) ivarsEqual = false;
     if( ! (scanPattern == rhs.scanPattern)) ivarsEqual = false;
     if( ! (beamCenterAzimuthHorizontal == rhs.beamCenterAzimuthHorizontal)) ivarsEqual = false;
     if( ! (azimuthalBeamwidthHorizontal == rhs.azimuthalBeamwidthHorizontal)) ivarsEqual = false;
     if( ! (beamCenterDepressionElevation == rhs.beamCenterDepressionElevation)) ivarsEqual = false;
     if( ! (depressionElevationBeamWidth == rhs.depressionElevationBeamWidth)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" activeEmissionParameterIndex: ").append(activeEmissionParameterIndex).append("\n");
    sb.append(" scanPattern: ").append(scanPattern).append("\n");
    sb.append(" beamCenterAzimuthHorizontal: ").append(beamCenterAzimuthHorizontal).append("\n");
    sb.append(" azimuthalBeamwidthHorizontal: ").append(azimuthalBeamwidthHorizontal).append("\n");
    sb.append(" beamCenterDepressionElevation: ").append(beamCenterDepressionElevation).append("\n");
    sb.append(" depressionElevationBeamWidth: ").append(depressionElevationBeamWidth).append("\n");

   return sb.toString();
 }
} // end of class
