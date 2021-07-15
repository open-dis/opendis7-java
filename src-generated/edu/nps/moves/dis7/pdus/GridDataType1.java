/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 6.2.41, table 69
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class GridDataType1 extends GridData implements Serializable
{
   /** fieldScale is an undescribed parameter... */
   protected float  fieldScale;

   /** fieldOffset is an undescribed parameter... */
   protected float  fieldOffset;

   /** numberOfValues is an undescribed parameter... */
   protected short  numberOfValues;

   /** dataValues is an undescribed parameter... */
   protected short[]  dataValues = new short[0]; 

   /** pad to 32-bit boundary */

   private byte[] padding = new byte[0];


/** Constructor */
 public GridDataType1()
 {
 }

  /**
   * Returns size of this serialized (marshalled) object in bytes
   * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
   * @return serialized size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 4;  // fieldScale
   marshalSize += 4;  // fieldOffset
   marshalSize += 2;  // numberOfValues
   marshalSize += dataValues.length * 2;
   marshalSize += padding.length;

   return marshalSize;
}


/** Setter for {@link GridDataType1#fieldScale}
  * @param pFieldScale new value of interest
  * @return same object to permit progressive setters */
public GridDataType1 setFieldScale(float pFieldScale)
{
    fieldScale = pFieldScale;
    return this;
}

/** Getter for {@link GridDataType1#fieldScale}
  * @return value of interest */
public float getFieldScale()
{
    return fieldScale; 
}

/** Setter for {@link GridDataType1#fieldOffset}
  * @param pFieldOffset new value of interest
  * @return same object to permit progressive setters */
public GridDataType1 setFieldOffset(float pFieldOffset)
{
    fieldOffset = pFieldOffset;
    return this;
}

/** Getter for {@link GridDataType1#fieldOffset}
  * @return value of interest */
public float getFieldOffset()
{
    return fieldOffset; 
}

/** Setter for {@link GridDataType1#dataValues}
  * @param pDataValues new value of interest
  * @return same object to permit progressive setters */
public GridDataType1 setDataValues(short[] pDataValues)
{
    dataValues = pDataValues;
    return this;
}

/** Getter for {@link GridDataType1#dataValues}
  * @return value of interest */
public short[] getDataValues()
{
    return dataValues; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @throws java.lang.Exception if something goes wrong
 * @see java.io.DataOutputStream
 * @param dos the OutputStream
 */
public void marshal(DataOutputStream dos) throws Exception
{
    super.marshal(dos);
    try 
    {
       dos.writeFloat(fieldScale);
       dos.writeFloat(fieldOffset);
       dos.writeShort(dataValues.length);

       for(int idx = 0; idx < dataValues.length; idx++)
           dos.writeShort(dataValues[idx]);

       padding = new byte[Align.to32bits(dos)];
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
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param dis the InputStream
 * @return marshalled serialized size in bytes
 */
public int unmarshal(DataInputStream dis) throws Exception
{
    int uPosition = 0;
    uPosition += super.unmarshal(dis);

    try 
    {
        fieldScale = dis.readFloat();
        uPosition += 4;
        fieldOffset = dis.readFloat();
        uPosition += 4;
        numberOfValues = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < dataValues.length; idx++)
            dataValues[idx] = dis.readShort();
        uPosition += (dataValues.length * 2);
        padding = new byte[Align.from32bits(uPosition,dis)];
        uPosition += padding.length;
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
   super.marshal(byteBuffer);
   byteBuffer.putFloat( (float)fieldScale);
   byteBuffer.putFloat( (float)fieldOffset);
   byteBuffer.putShort( (short)dataValues.length);

   for(int idx = 0; idx < dataValues.length; idx++)
       byteBuffer.putShort((short)dataValues[idx]);

   padding = new byte[Align.to32bits(byteBuffer)];
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if byteBuffer is too small
 * @see java.nio.ByteBuffer
 * @see <a href="https://en.wikipedia.org/wiki/Marshalling_(computer_science)" target="_blank">https://en.wikipedia.org/wiki/Marshalling_(computer_science)</a>
 * @param byteBuffer The ByteBuffer at the position to begin reading
 * @return marshalled serialized size in bytes
 * @throws Exception ByteBuffer-generated exception
 */
public int unmarshal(java.nio.ByteBuffer byteBuffer) throws Exception
{
    super.unmarshal(byteBuffer);

    fieldScale = byteBuffer.getFloat();
    fieldOffset = byteBuffer.getFloat();
    numberOfValues = (short)(byteBuffer.getShort() & 0xFFFF);
    for(int idx = 0; idx < dataValues.length; idx++)
        dataValues[idx] = byteBuffer.getShort();
    padding = new byte[Align.from32bits(byteBuffer)];
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

     final GridDataType1 rhs = (GridDataType1)obj;

     if( ! (fieldScale == rhs.fieldScale)) ivarsEqual = false;
     if( ! (fieldOffset == rhs.fieldOffset)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(dataValues[idx] == rhs.dataValues[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" fieldScale: ").append(fieldScale).append("\n");
    sb.append(" fieldOffset: ").append(fieldOffset).append("\n");
    sb.append(" dataValues: ").append("\n");
    sb.append(Arrays.toString(dataValues)).append("\n");
    sb.append(" padding: ").append(padding).append("\n");

   return sb.toString();
 }
} // end of class
