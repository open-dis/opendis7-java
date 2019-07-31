/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

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


public BeamAntennaPattern setBeamDirection(EulerAngles pBeamDirection)
{
    beamDirection = pBeamDirection;
    return this;
}

public EulerAngles getBeamDirection()
{
    return beamDirection; 
}

public BeamAntennaPattern setAzimuthBeamwidth(float pAzimuthBeamwidth)
{
    azimuthBeamwidth = pAzimuthBeamwidth;
    return this;
}

public float getAzimuthBeamwidth()
{
    return azimuthBeamwidth; 
}

public BeamAntennaPattern setElevationBeamwidth(float pElevationBeamwidth)
{
    elevationBeamwidth = pElevationBeamwidth;
    return this;
}

public float getElevationBeamwidth()
{
    return elevationBeamwidth; 
}

public BeamAntennaPattern setReferenceSystem(TransmitterAntennaPatternReferenceSystem pReferenceSystem)
{
    referenceSystem = pReferenceSystem;
    return this;
}

public TransmitterAntennaPatternReferenceSystem getReferenceSystem()
{
    return referenceSystem; 
}

public BeamAntennaPattern setPadding1(byte pPadding1)
{
    padding1 = pPadding1;
    return this;
}

public byte getPadding1()
{
    return padding1; 
}

public BeamAntennaPattern setPadding2(short pPadding2)
{
    padding2 = pPadding2;
    return this;
}

public short getPadding2()
{
    return padding2; 
}

public BeamAntennaPattern setEz(float pEz)
{
    ez = pEz;
    return this;
}

public float getEz()
{
    return ez; 
}

public BeamAntennaPattern setEx(float pEx)
{
    ex = pEx;
    return this;
}

public float getEx()
{
    return ex; 
}

public BeamAntennaPattern setPhase(float pPhase)
{
    phase = pPhase;
    return this;
}

public float getPhase()
{
    return phase; 
}

public BeamAntennaPattern setPadding3(int pPadding3)
{
    padding3 = pPadding3;
    return this;
}

public int getPadding3()
{
    return padding3; 
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
public int unmarshal(DataInputStream dis)
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

    if(!(obj instanceof BeamAntennaPattern))
        return false;

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
} // end of class
