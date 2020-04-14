/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Grid axis descriptor fo variable spacing axis data.
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class GridAxisDescriptorVariable extends GridAxisDescriptor implements Serializable
{
   /** Number of grid locations along Xi axis */
   protected short  numberOfPointsOnXiAxis;

   /** initial grid point for the current pdu */
   protected short  initialIndex;

   /** value that linearly scales the coordinates of the grid locations for the xi axis */
   protected double  coordinateScaleXi;

   /** The constant offset value that shall be applied to the grid locations for the xi axis */
   protected double  coordinateOffsetXi = (double)0.0;

   /** list of coordinates */
   protected short[]  xiValues = new short[0]; 

   private byte[] padding = new byte[0]; // pad to 64-bit boundary


/** Constructor */
 public GridAxisDescriptorVariable()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 2;  // numberOfPointsOnXiAxis
   marshalSize += 2;  // initialIndex
   marshalSize += 8;  // coordinateScaleXi
   marshalSize += 8;  // coordinateOffsetXi
   marshalSize += xiValues.length * 2;
   marshalSize += padding.length;

   return marshalSize;
}


/** Setter for {@link GridAxisDescriptorVariable#numberOfPointsOnXiAxis}*/
public GridAxisDescriptorVariable setNumberOfPointsOnXiAxis(short pNumberOfPointsOnXiAxis)
{
    numberOfPointsOnXiAxis = pNumberOfPointsOnXiAxis;
    return this;
}

/** Getter for {@link GridAxisDescriptorVariable#numberOfPointsOnXiAxis}*/
public short getNumberOfPointsOnXiAxis()
{
    return numberOfPointsOnXiAxis; 
}

/** Setter for {@link GridAxisDescriptorVariable#initialIndex}*/
public GridAxisDescriptorVariable setInitialIndex(short pInitialIndex)
{
    initialIndex = pInitialIndex;
    return this;
}

/** Getter for {@link GridAxisDescriptorVariable#initialIndex}*/
public short getInitialIndex()
{
    return initialIndex; 
}

/** Setter for {@link GridAxisDescriptorVariable#coordinateScaleXi}*/
public GridAxisDescriptorVariable setCoordinateScaleXi(double pCoordinateScaleXi)
{
    coordinateScaleXi = pCoordinateScaleXi;
    return this;
}

/** Getter for {@link GridAxisDescriptorVariable#coordinateScaleXi}*/
public double getCoordinateScaleXi()
{
    return coordinateScaleXi; 
}

/** Setter for {@link GridAxisDescriptorVariable#coordinateOffsetXi}*/
public GridAxisDescriptorVariable setCoordinateOffsetXi(double pCoordinateOffsetXi)
{
    coordinateOffsetXi = pCoordinateOffsetXi;
    return this;
}

/** Getter for {@link GridAxisDescriptorVariable#coordinateOffsetXi}*/
public double getCoordinateOffsetXi()
{
    return coordinateOffsetXi; 
}

/** Setter for {@link GridAxisDescriptorVariable#xiValues}*/
public GridAxisDescriptorVariable setXiValues(short[] pXiValues)
{
    xiValues = pXiValues;
    return this;
}

/** Getter for {@link GridAxisDescriptorVariable#xiValues}*/
public short[] getXiValues()
{
    return xiValues; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       dos.writeShort( (short)numberOfPointsOnXiAxis);
       dos.writeShort( (short)initialIndex);
       dos.writeDouble( (double)coordinateScaleXi);
       dos.writeDouble( (double)coordinateOffsetXi);

       for(int idx = 0; idx < xiValues.length; idx++)
           dos.writeShort(xiValues[idx]);

       padding = new byte[Align.to64bits(dos)];
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
    uPosition += super.unmarshal(dis);

    try 
    {
        numberOfPointsOnXiAxis = (short)dis.readUnsignedShort();
        uPosition += 2;
        initialIndex = (short)dis.readUnsignedShort();
        uPosition += 2;
        coordinateScaleXi = dis.readDouble();
        uPosition += 4;
        coordinateOffsetXi = dis.readDouble();
        uPosition += 4;
        for(int idx = 0; idx < xiValues.length; idx++)
            xiValues[idx] = dis.readShort();
        uPosition += (xiValues.length * 2);
        padding = new byte[Align.from64bits(uPosition,dis)];
        uPosition += padding.length;
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
   super.marshal(buff);
   buff.putShort( (short)numberOfPointsOnXiAxis);
   buff.putShort( (short)initialIndex);
   buff.putDouble( (double)coordinateScaleXi);
   buff.putDouble( (double)coordinateOffsetXi);

   for(int idx = 0; idx < xiValues.length; idx++)
       buff.putShort((short)xiValues[idx]);

   padding = new byte[Align.to64bits(buff)];
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
    super.unmarshal(buff);

    numberOfPointsOnXiAxis = (short)(buff.getShort() & 0xFFFF);
    initialIndex = (short)(buff.getShort() & 0xFFFF);
    coordinateScaleXi = buff.getDouble();
    coordinateOffsetXi = buff.getDouble();
    for(int idx = 0; idx < xiValues.length; idx++)
        xiValues[idx] = buff.getShort();
    padding = new byte[Align.from64bits(buff)];
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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

     final GridAxisDescriptorVariable rhs = (GridAxisDescriptorVariable)obj;

     if( ! (numberOfPointsOnXiAxis == rhs.numberOfPointsOnXiAxis)) ivarsEqual = false;
     if( ! (initialIndex == rhs.initialIndex)) ivarsEqual = false;
     if( ! (coordinateScaleXi == rhs.coordinateScaleXi)) ivarsEqual = false;
     if( ! (coordinateOffsetXi == rhs.coordinateOffsetXi)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(xiValues[idx] == rhs.xiValues[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" numberOfPointsOnXiAxis: ").append(numberOfPointsOnXiAxis).append("\n");
    sb.append(" initialIndex: ").append(initialIndex).append("\n");
    sb.append(" coordinateScaleXi: ").append(coordinateScaleXi).append("\n");
    sb.append(" coordinateOffsetXi: ").append(coordinateOffsetXi).append("\n");
    sb.append(" xiValues: ").append("\n");
    sb.append(Arrays.toString(xiValues)).append("\n");
    sb.append(" padding: ").append(padding).append("\n");

   return sb.toString();
 }
} // end of class
