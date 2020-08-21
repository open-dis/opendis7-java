/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 6.2.41, table 69
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class GridDataType1 extends GridData implements Serializable
{
   protected float  fieldScale;

   protected float  fieldOffset;

   protected short  numberOfValues;

   protected short[]  dataValues = new short[0]; 

   private byte[] padding = new byte[0]; // pad to 32-bit boundary


/** Constructor */
 public GridDataType1()
 {
 }

/** Returns the size of this serialized object in bytes*/
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


/** Setter for {@link GridDataType1#fieldScale}*/
public GridDataType1 setFieldScale(float pFieldScale)
{
    fieldScale = pFieldScale;
    return this;
}

/** Getter for {@link GridDataType1#fieldScale}*/
public float getFieldScale()
{
    return fieldScale; 
}

/** Setter for {@link GridDataType1#fieldOffset}*/
public GridDataType1 setFieldOffset(float pFieldOffset)
{
    fieldOffset = pFieldOffset;
    return this;
}

/** Getter for {@link GridDataType1#fieldOffset}*/
public float getFieldOffset()
{
    return fieldOffset; 
}

/** Setter for {@link GridDataType1#dataValues}*/
public GridDataType1 setDataValues(short[] pDataValues)
{
    dataValues = pDataValues;
    return this;
}

/** Getter for {@link GridDataType1#dataValues}*/
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
 * @param dis the InputStream
 * @return unmarshalled size
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
 * @throws java.nio.BufferOverflowException if buff is too small
 * @throws java.nio.ReadOnlyBufferException if buff is read only
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin writing
 * @throws Exception ByteBuffer-generated exception
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   super.marshal(buff);
   buff.putFloat( (float)fieldScale);
   buff.putFloat( (float)fieldOffset);
   buff.putShort( (short)dataValues.length);

   for(int idx = 0; idx < dataValues.length; idx++)
       buff.putShort((short)dataValues[idx]);

   padding = new byte[Align.to32bits(buff)];
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

    fieldScale = buff.getFloat();
    fieldOffset = buff.getFloat();
    numberOfValues = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < dataValues.length; idx++)
        dataValues[idx] = buff.getShort();
    padding = new byte[Align.from32bits(buff)];
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
