/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * 6.2.41, table 69
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
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


public GridDataType1 setFieldScale(float pFieldScale)
{
    fieldScale = pFieldScale;
    return this;
}

public float getFieldScale()
{
    return fieldScale; 
}

public GridDataType1 setFieldOffset(float pFieldOffset)
{
    fieldOffset = pFieldOffset;
    return this;
}

public float getFieldOffset()
{
    return fieldOffset; 
}

public GridDataType1 setDataValues(short[] pDataValues)
{
    dataValues = pDataValues;
    return this;
}

public short[] getDataValues()
{
    return dataValues; 
}

/**
 * Serializes an object to a DataOutputStream.
 * @see java.io.DataOutputStream
 * @param dos The DataOutputStream
 */
public void marshal(DataOutputStream dos)
{
    super.marshal(dos);
    try 
    {
       dos.writeFloat( (float)fieldScale);
       dos.writeFloat( (float)fieldOffset);
       dos.writeShort( (short)numberOfValues);

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
 * Unserializes an object from a DataInputStream.
 * @see java.io.DataInputStream
 * @param dis The DataInputStream
 * @return marshalled size
 */
public int unmarshal(DataInputStream dis)
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
            dataValues[idx] = dis.readShort(); // mike check
        uPosition += dataValues.length; // todo, multiply by prim size mike
        padding = new byte[Align.from32bits(uPosition,dis)];
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
   buff.putFloat( (float)fieldScale);
   buff.putFloat( (float)fieldOffset);
   buff.putShort( (short)numberOfValues);

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

@Override
 public boolean equalsImpl(Object obj)
 {
     boolean ivarsEqual = true;

    if(!(obj instanceof GridDataType1))
        return false;

     final GridDataType1 rhs = (GridDataType1)obj;

     if( ! (fieldScale == rhs.fieldScale)) ivarsEqual = false;
     if( ! (fieldOffset == rhs.fieldOffset)) ivarsEqual = false;
     if( ! (numberOfValues == rhs.numberOfValues)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(dataValues[idx] == rhs.dataValues[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
