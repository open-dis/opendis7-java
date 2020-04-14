/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Used when the antenna pattern type field has a value of 1. Specifies the direction, pattern, and polarization of radiation from an antenna. Section 6.2.9.2
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class BeamAntennaPattern extends Object implements Serializable
{
   /** The rotation that transforms the reference coordinate sytem into the beam coordinate system. Either world coordinates or entity coordinates may be used as the reference coordinate system, as specified by the reference system field of the antenna pattern record. */
   protected EulerAngles  beamDirection = new EulerAngles(); 

   protected float  azimuthBeamwidth = (float)0;

   protected float  elevationBeamwidth = (float)0;

   /**  uid 168 */
   protected TransmitterAntennaPatternReferenceSystem referenceSystem = TransmitterAntennaPatternReferenceSystem.values()[0];

   protected byte  padding1 = (byte)0;

   protected short  padding2 = (short)0;

   /** This field shall specify the magnitude of the Z-component (in beam coordinates) of the Electrical field at some arbitrary single point in the main beam and in the far field of the antenna.  */
   protected float  ez = (float)0.0;

   /** This field shall specify the magnitude of the X-component (in beam coordinates) of the Electri- cal field at some arbitrary single point in the main beam and in the far field of the antenna. */
   protected float  ex = (float)0.0;

   /** This field shall specify the phase angle between EZ and EX in radians. If fully omni-direc- tional antenna is modeled using beam pattern type one, the omni-directional antenna shall be repre- sented by beam direction Euler angles psi, theta, and phi of zero, an azimuth beamwidth of 2PI, and an elevation beamwidth of PI */
   protected float  phase = (float)0.0;

   /** padding */
   protected int  padding3 = (int)0;


/** Constructor */
 public BeamAntennaPattern()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += beamDirection.getMarshalledSize();
   marshalSize += 4;  // azimuthBeamwidth
   marshalSize += 4;  // elevationBeamwidth
   marshalSize += referenceSystem.getMarshalledSize();
   marshalSize += 1;  // padding1
   marshalSize += 2;  // padding2
   marshalSize += 4;  // ez
   marshalSize += 4;  // ex
   marshalSize += 4;  // phase
   marshalSize += 4;  // padding3

   return marshalSize;
}


/** Setter for {@link BeamAntennaPattern#beamDirection}*/
public BeamAntennaPattern setBeamDirection(EulerAngles pBeamDirection)
{
    beamDirection = pBeamDirection;
    return this;
}

/** Getter for {@link BeamAntennaPattern#beamDirection}*/
public EulerAngles getBeamDirection()
{
    return beamDirection; 
}

/** Setter for {@link BeamAntennaPattern#azimuthBeamwidth}*/
public BeamAntennaPattern setAzimuthBeamwidth(float pAzimuthBeamwidth)
{
    azimuthBeamwidth = pAzimuthBeamwidth;
    return this;
}

/** Getter for {@link BeamAntennaPattern#azimuthBeamwidth}*/
public float getAzimuthBeamwidth()
{
    return azimuthBeamwidth; 
}

/** Setter for {@link BeamAntennaPattern#elevationBeamwidth}*/
public BeamAntennaPattern setElevationBeamwidth(float pElevationBeamwidth)
{
    elevationBeamwidth = pElevationBeamwidth;
    return this;
}

/** Getter for {@link BeamAntennaPattern#elevationBeamwidth}*/
public float getElevationBeamwidth()
{
    return elevationBeamwidth; 
}

/** Setter for {@link BeamAntennaPattern#referenceSystem}*/
public BeamAntennaPattern setReferenceSystem(TransmitterAntennaPatternReferenceSystem pReferenceSystem)
{
    referenceSystem = pReferenceSystem;
    return this;
}

/** Getter for {@link BeamAntennaPattern#referenceSystem}*/
public TransmitterAntennaPatternReferenceSystem getReferenceSystem()
{
    return referenceSystem; 
}

/** Setter for {@link BeamAntennaPattern#padding1}*/
public BeamAntennaPattern setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}

/** Getter for {@link BeamAntennaPattern#padding1}*/
public byte getPadding1()
{
    return padding1; 
}

/** Setter for {@link BeamAntennaPattern#padding2}*/
public BeamAntennaPattern setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

/** Getter for {@link BeamAntennaPattern#padding2}*/
public short getPadding2()
{
    return padding2; 
}

/** Setter for {@link BeamAntennaPattern#ez}*/
public BeamAntennaPattern setEz(float pEz)
{
    ez = pEz;
    return this;
}

/** Getter for {@link BeamAntennaPattern#ez}*/
public float getEz()
{
    return ez; 
}

/** Setter for {@link BeamAntennaPattern#ex}*/
public BeamAntennaPattern setEx(float pEx)
{
    ex = pEx;
    return this;
}

/** Getter for {@link BeamAntennaPattern#ex}*/
public float getEx()
{
    return ex; 
}

/** Setter for {@link BeamAntennaPattern#phase}*/
public BeamAntennaPattern setPhase(float pPhase)
{
    phase = pPhase;
    return this;
}

/** Getter for {@link BeamAntennaPattern#phase}*/
public float getPhase()
{
    return phase; 
}

/** Setter for {@link BeamAntennaPattern#padding3}*/
public BeamAntennaPattern setPadding3(int pPadding3)
{
    padding3 = pPadding3;
    return this;
}

/** Getter for {@link BeamAntennaPattern#padding3}*/
public int getPadding3()
{
    return padding3; 
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
       beamDirection.marshal(dos);
       dos.writeFloat( (float)azimuthBeamwidth);
       dos.writeFloat( (float)elevationBeamwidth);
       referenceSystem.marshal(dos);
       dos.writeByte( (byte)padding1);
       dos.writeShort( (short)padding2);
       dos.writeFloat( (float)ez);
       dos.writeFloat( (float)ex);
       dos.writeFloat( (float)phase);
       dos.writeInt( (int)padding3);
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
        uPosition += beamDirection.unmarshal(dis);
        azimuthBeamwidth = dis.readFloat();
        uPosition += 4;
        elevationBeamwidth = dis.readFloat();
        uPosition += 4;
        referenceSystem = TransmitterAntennaPatternReferenceSystem.unmarshalEnum(dis);
        uPosition += referenceSystem.getMarshalledSize();
        padding1 = (byte)dis.readUnsignedByte();
        uPosition += 1;
        padding2 = (short)dis.readUnsignedShort();
        uPosition += 2;
        ez = dis.readFloat();
        uPosition += 4;
        ex = dis.readFloat();
        uPosition += 4;
        phase = dis.readFloat();
        uPosition += 4;
        padding3 = dis.readInt();
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
   beamDirection.marshal(buff);
   buff.putFloat( (float)azimuthBeamwidth);
   buff.putFloat( (float)elevationBeamwidth);
   referenceSystem.marshal(buff);
   buff.put( (byte)padding1);
   buff.putShort( (short)padding2);
   buff.putFloat( (float)ez);
   buff.putFloat( (float)ex);
   buff.putFloat( (float)phase);
   buff.putInt( (int)padding3);
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
    beamDirection.unmarshal(buff);
    azimuthBeamwidth = buff.getFloat();
    elevationBeamwidth = buff.getFloat();
    referenceSystem = TransmitterAntennaPatternReferenceSystem.unmarshalEnum(buff);
    padding1 = (byte)(buff.get() & 0xFF);
    padding2 = (short)(buff.getShort() & 0xFFFF);
    ez = buff.getFloat();
    ex = buff.getFloat();
    phase = buff.getFloat();
    padding3 = buff.getInt();
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

     final BeamAntennaPattern rhs = (BeamAntennaPattern)obj;

     if( ! (beamDirection.equals( rhs.beamDirection) )) ivarsEqual = false;
     if( ! (azimuthBeamwidth == rhs.azimuthBeamwidth)) ivarsEqual = false;
     if( ! (elevationBeamwidth == rhs.elevationBeamwidth)) ivarsEqual = false;
     if( ! (referenceSystem == rhs.referenceSystem)) ivarsEqual = false;
     if( ! (padding1 == rhs.padding1)) ivarsEqual = false;
     if( ! (padding2 == rhs.padding2)) ivarsEqual = false;
     if( ! (ez == rhs.ez)) ivarsEqual = false;
     if( ! (ex == rhs.ex)) ivarsEqual = false;
     if( ! (phase == rhs.phase)) ivarsEqual = false;
     if( ! (padding3 == rhs.padding3)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" beamDirection: ").append(beamDirection).append("\n");
    sb.append(" azimuthBeamwidth: ").append(azimuthBeamwidth).append("\n");
    sb.append(" elevationBeamwidth: ").append(elevationBeamwidth).append("\n");
    sb.append(" referenceSystem: ").append(referenceSystem).append("\n");
    sb.append(" padding1: ").append(padding1).append("\n");
    sb.append(" padding2: ").append(padding2).append("\n");
    sb.append(" ez: ").append(ez).append("\n");
    sb.append(" ex: ").append(ex).append("\n");
    sb.append(" phase: ").append(phase).append("\n");
    sb.append(" padding3: ").append(padding3).append("\n");

   return sb.toString();
 }
} // end of class
