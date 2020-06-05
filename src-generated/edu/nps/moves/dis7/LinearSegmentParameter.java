/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * The specification of an individual segment of a linear segment synthetic environment object in a Linear Object State PDU Section 6.2.52
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class LinearSegmentParameter extends Object implements Serializable
{
   /** the individual segment of the linear segment */
   protected byte  segmentNumber;

   /**  whether a modification has been made to the point object's location or orientation UID 241 */
   protected ObjectStateModificationLinearObject segmentModification = new ObjectStateModificationLinearObject();

   /** general dynamic appearance attributes of the segment. This record shall be defined as a 16-bit record of enumerations. The values defined for this record are included in Section 12 of SISO-REF-010. UID 229 */
   protected ObjectStateAppearanceGeneral generalSegmentAppearance = new ObjectStateAppearanceGeneral();

   /** This field shall specify specific dynamic appearance attributes of the segment. This record shall be defined as a 32-bit record of enumerations. */
   protected int  specificSegmentAppearance;

   /** This field shall specify the location of the linear segment in the simulated world and shall be represented by a World Coordinates record  */
   protected Vector3Double  segmentLocation = new Vector3Double(); 

   /** orientation of the linear segment about the segment location and shall be represented by a Euler Angles record  */
   protected EulerAngles  segmentOrientation = new EulerAngles(); 

   /** length of the linear segment, in meters, extending in the positive X direction */
   protected float  segmentLength;

   /** The total width of the linear segment, in meters, shall be specified by a 16-bit unsigned integer. One-half of the width shall extend in the positive Y direction, and one-half of the width shall extend in the negative Y direction. */
   protected float  segmentWidth;

   /** The height of the linear segment, in meters, above ground shall be specified by a 16-bit unsigned integer. */
   protected float  segmentHeight;

   /** The depth of the linear segment, in meters, below ground level  */
   protected float  segmentDepth;

   /** padding */
   protected int  padding;


/** Constructor */
 public LinearSegmentParameter()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // segmentNumber
   marshalSize += segmentModification.getMarshalledSize();
   marshalSize += generalSegmentAppearance.getMarshalledSize();
   marshalSize += 4;  // specificSegmentAppearance
   marshalSize += segmentLocation.getMarshalledSize();
   marshalSize += segmentOrientation.getMarshalledSize();
   marshalSize += 4;  // segmentLength
   marshalSize += 4;  // segmentWidth
   marshalSize += 4;  // segmentHeight
   marshalSize += 4;  // segmentDepth
   marshalSize += 4;  // padding

   return marshalSize;
}


/** Setter for {@link LinearSegmentParameter#segmentNumber}*/
public LinearSegmentParameter setSegmentNumber(byte pSegmentNumber)
{
    segmentNumber = pSegmentNumber;
    return this;
}

/** Getter for {@link LinearSegmentParameter#segmentNumber}*/
public byte getSegmentNumber()
{
    return segmentNumber; 
}

/** Setter for {@link LinearSegmentParameter#segmentModification}*/
public LinearSegmentParameter setSegmentModification(ObjectStateModificationLinearObject pSegmentModification)
{
    segmentModification = pSegmentModification;
    return this;
}

/** Setter for {@link LinearSegmentParameter#segmentModification}*/
public ObjectStateModificationLinearObject getSegmentModification()
{
    return segmentModification; 
}

/** Setter for {@link LinearSegmentParameter#generalSegmentAppearance}*/
public LinearSegmentParameter setGeneralSegmentAppearance(ObjectStateAppearanceGeneral pGeneralSegmentAppearance)
{
    generalSegmentAppearance = pGeneralSegmentAppearance;
    return this;
}

/** Setter for {@link LinearSegmentParameter#generalSegmentAppearance}*/
public ObjectStateAppearanceGeneral getGeneralSegmentAppearance()
{
    return generalSegmentAppearance; 
}

/** Setter for {@link LinearSegmentParameter#specificSegmentAppearance}*/
public LinearSegmentParameter setSpecificSegmentAppearance(int pSpecificSegmentAppearance)
{
    specificSegmentAppearance = pSpecificSegmentAppearance;
    return this;
}

/** Getter for {@link LinearSegmentParameter#specificSegmentAppearance}*/
public int getSpecificSegmentAppearance()
{
    return specificSegmentAppearance; 
}

/** Setter for {@link LinearSegmentParameter#segmentLocation}*/
public LinearSegmentParameter setSegmentLocation(Vector3Double pSegmentLocation)
{
    segmentLocation = pSegmentLocation;
    return this;
}

/** Getter for {@link LinearSegmentParameter#segmentLocation}*/
public Vector3Double getSegmentLocation()
{
    return segmentLocation; 
}

/** Setter for {@link LinearSegmentParameter#segmentOrientation}*/
public LinearSegmentParameter setSegmentOrientation(EulerAngles pSegmentOrientation)
{
    segmentOrientation = pSegmentOrientation;
    return this;
}

/** Getter for {@link LinearSegmentParameter#segmentOrientation}*/
public EulerAngles getSegmentOrientation()
{
    return segmentOrientation; 
}

/** Setter for {@link LinearSegmentParameter#segmentLength}*/
public LinearSegmentParameter setSegmentLength(float pSegmentLength)
{
    segmentLength = pSegmentLength;
    return this;
}

/** Getter for {@link LinearSegmentParameter#segmentLength}*/
public float getSegmentLength()
{
    return segmentLength; 
}

/** Setter for {@link LinearSegmentParameter#segmentWidth}*/
public LinearSegmentParameter setSegmentWidth(float pSegmentWidth)
{
    segmentWidth = pSegmentWidth;
    return this;
}

/** Getter for {@link LinearSegmentParameter#segmentWidth}*/
public float getSegmentWidth()
{
    return segmentWidth; 
}

/** Setter for {@link LinearSegmentParameter#segmentHeight}*/
public LinearSegmentParameter setSegmentHeight(float pSegmentHeight)
{
    segmentHeight = pSegmentHeight;
    return this;
}

/** Getter for {@link LinearSegmentParameter#segmentHeight}*/
public float getSegmentHeight()
{
    return segmentHeight; 
}

/** Setter for {@link LinearSegmentParameter#segmentDepth}*/
public LinearSegmentParameter setSegmentDepth(float pSegmentDepth)
{
    segmentDepth = pSegmentDepth;
    return this;
}

/** Getter for {@link LinearSegmentParameter#segmentDepth}*/
public float getSegmentDepth()
{
    return segmentDepth; 
}

/** Setter for {@link LinearSegmentParameter#padding}*/
public LinearSegmentParameter setPadding(int pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link LinearSegmentParameter#padding}*/
public int getPadding()
{
    return padding; 
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
       dos.writeByte(segmentNumber);
       segmentModification.marshal(dos);
       generalSegmentAppearance.marshal(dos);
       dos.writeInt(specificSegmentAppearance);
       segmentLocation.marshal(dos);
       segmentOrientation.marshal(dos);
       dos.writeFloat(segmentLength);
       dos.writeFloat(segmentWidth);
       dos.writeFloat(segmentHeight);
       dos.writeFloat(segmentDepth);
       dos.writeInt(padding);
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
}

/**
 * Unserializes an object from a DataInputStream.
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
        segmentNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        uPosition += segmentModification.unmarshal(dis);
        uPosition += generalSegmentAppearance.unmarshal(dis);
        specificSegmentAppearance = dis.readInt();
        uPosition += 4;
        uPosition += segmentLocation.unmarshal(dis);
        uPosition += segmentOrientation.unmarshal(dis);
        segmentLength = dis.readFloat();
        uPosition += 4;
        segmentWidth = dis.readFloat();
        uPosition += 4;
        segmentHeight = dis.readFloat();
        uPosition += 4;
        segmentDepth = dis.readFloat();
        uPosition += 4;
        padding = dis.readInt();
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
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.put( (byte)segmentNumber);
   segmentModification.marshal(buff);
   generalSegmentAppearance.marshal(buff);
   buff.putInt( (int)specificSegmentAppearance);
   segmentLocation.marshal(buff);
   segmentOrientation.marshal(buff);
   buff.putFloat( (float)segmentLength);
   buff.putFloat( (float)segmentWidth);
   buff.putFloat( (float)segmentHeight);
   buff.putFloat( (float)segmentDepth);
   buff.putInt( (int)padding);
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
    segmentNumber = (byte)(buff.get() & 0xFF);
    segmentModification.unmarshal(buff);
    generalSegmentAppearance.unmarshal(buff);
    specificSegmentAppearance = buff.getInt();
    segmentLocation.unmarshal(buff);
    segmentOrientation.unmarshal(buff);
    segmentLength = buff.getFloat();
    segmentWidth = buff.getFloat();
    segmentHeight = buff.getFloat();
    segmentDepth = buff.getFloat();
    padding = buff.getInt();
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

     final LinearSegmentParameter rhs = (LinearSegmentParameter)obj;

     if( ! (segmentNumber == rhs.segmentNumber)) ivarsEqual = false;
     if( ! (segmentModification.equals( rhs.segmentModification) )) ivarsEqual = false;
     if( ! (generalSegmentAppearance.equals( rhs.generalSegmentAppearance) )) ivarsEqual = false;
     if( ! (specificSegmentAppearance == rhs.specificSegmentAppearance)) ivarsEqual = false;
     if( ! (segmentLocation.equals( rhs.segmentLocation) )) ivarsEqual = false;
     if( ! (segmentOrientation.equals( rhs.segmentOrientation) )) ivarsEqual = false;
     if( ! (segmentLength == rhs.segmentLength)) ivarsEqual = false;
     if( ! (segmentWidth == rhs.segmentWidth)) ivarsEqual = false;
     if( ! (segmentHeight == rhs.segmentHeight)) ivarsEqual = false;
     if( ! (segmentDepth == rhs.segmentDepth)) ivarsEqual = false;
     if( ! (padding == rhs.padding)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" segmentNumber: ").append(segmentNumber).append("\n");
    sb.append(" segmentModification: ").append(segmentModification).append("\n");
    sb.append(" generalSegmentAppearance: ").append(generalSegmentAppearance).append("\n");
    sb.append(" specificSegmentAppearance: ").append(specificSegmentAppearance).append("\n");
    sb.append(" segmentLocation: ").append(segmentLocation).append("\n");
    sb.append(" segmentOrientation: ").append(segmentOrientation).append("\n");
    sb.append(" segmentLength: ").append(segmentLength).append("\n");
    sb.append(" segmentWidth: ").append(segmentWidth).append("\n");
    sb.append(" segmentHeight: ").append(segmentHeight).append("\n");
    sb.append(" segmentDepth: ").append(segmentDepth).append("\n");
    sb.append(" padding: ").append(padding).append("\n");

   return sb.toString();
 }
} // end of class
