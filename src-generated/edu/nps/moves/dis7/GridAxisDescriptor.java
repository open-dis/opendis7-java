/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class GridAxisDescriptor extends Object implements Serializable
{
   /** coordinate of the grid origin or initial value */
   protected double  domainInitialXi;

   /** coordinate of the endpoint or final value */
   protected double  domainFinalXi;

   /** The number of grid points along the Xi domain axis for the enviornmental state data */
   protected short  domainPointsXi;

   /** interleaf factor along the domain axis. */
   protected byte  interleafFactor;

   /** type of grid axis uid 377 */
   protected GridAxisDescriptorAxisType axisType = GridAxisDescriptorAxisType.values()[0];


/** Constructor */
 public GridAxisDescriptor()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 8;  // domainInitialXi
   marshalSize += 8;  // domainFinalXi
   marshalSize += 2;  // domainPointsXi
   marshalSize += 1;  // interleafFactor
   marshalSize += axisType.getMarshalledSize();

   return marshalSize;
}


/** Setter for {@link GridAxisDescriptor#domainInitialXi}*/
public GridAxisDescriptor setDomainInitialXi(double pDomainInitialXi)
{
    domainInitialXi = pDomainInitialXi;
    return this;
}

/** Getter for {@link GridAxisDescriptor#domainInitialXi}*/
public double getDomainInitialXi()
{
    return domainInitialXi; 
}

/** Setter for {@link GridAxisDescriptor#domainFinalXi}*/
public GridAxisDescriptor setDomainFinalXi(double pDomainFinalXi)
{
    domainFinalXi = pDomainFinalXi;
    return this;
}

/** Getter for {@link GridAxisDescriptor#domainFinalXi}*/
public double getDomainFinalXi()
{
    return domainFinalXi; 
}

/** Setter for {@link GridAxisDescriptor#domainPointsXi}*/
public GridAxisDescriptor setDomainPointsXi(short pDomainPointsXi)
{
    domainPointsXi = pDomainPointsXi;
    return this;
}

/** Getter for {@link GridAxisDescriptor#domainPointsXi}*/
public short getDomainPointsXi()
{
    return domainPointsXi; 
}

/** Setter for {@link GridAxisDescriptor#interleafFactor}*/
public GridAxisDescriptor setInterleafFactor(byte pInterleafFactor)
{
    interleafFactor = pInterleafFactor;
    return this;
}

/** Getter for {@link GridAxisDescriptor#interleafFactor}*/
public byte getInterleafFactor()
{
    return interleafFactor; 
}

/** Setter for {@link GridAxisDescriptor#axisType}*/
public GridAxisDescriptor setAxisType(GridAxisDescriptorAxisType pAxisType)
{
    axisType = pAxisType;
    return this;
}

/** Getter for {@link GridAxisDescriptor#axisType}*/
public GridAxisDescriptorAxisType getAxisType()
{
    return axisType; 
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
       dos.writeDouble( (double)domainInitialXi);
       dos.writeDouble( (double)domainFinalXi);
       dos.writeShort( (short)domainPointsXi);
       dos.writeByte( (byte)interleafFactor);
       axisType.marshal(dos);
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
        domainInitialXi = dis.readDouble();
        uPosition += 4;
        domainFinalXi = dis.readDouble();
        uPosition += 4;
        domainPointsXi = (short)dis.readUnsignedShort();
        uPosition += 2;
        interleafFactor = (byte)dis.readUnsignedByte();
        uPosition += 1;
        axisType = GridAxisDescriptorAxisType.unmarshalEnum(dis);
        uPosition += axisType.getMarshalledSize();
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
   buff.putDouble( (double)domainInitialXi);
   buff.putDouble( (double)domainFinalXi);
   buff.putShort( (short)domainPointsXi);
   buff.put( (byte)interleafFactor);
   axisType.marshal(buff);
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
    domainInitialXi = buff.getDouble();
    domainFinalXi = buff.getDouble();
    domainPointsXi = (short)(buff.getShort() & 0xFFFF);
    interleafFactor = (byte)(buff.get() & 0xFF);
    axisType = GridAxisDescriptorAxisType.unmarshalEnum(buff);
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

     final GridAxisDescriptor rhs = (GridAxisDescriptor)obj;

     if( ! (domainInitialXi == rhs.domainInitialXi)) ivarsEqual = false;
     if( ! (domainFinalXi == rhs.domainFinalXi)) ivarsEqual = false;
     if( ! (domainPointsXi == rhs.domainPointsXi)) ivarsEqual = false;
     if( ! (interleafFactor == rhs.interleafFactor)) ivarsEqual = false;
     if( ! (axisType == rhs.axisType)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
