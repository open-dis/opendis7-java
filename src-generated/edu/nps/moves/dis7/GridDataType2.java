/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * 6.2.41, table 70
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class GridDataType2 extends GridData implements Serializable
{
   protected short  numberOfValues;

   protected short  padding;

   protected float[]  dataValues = new float[0]; 


/** Constructor */
 public GridDataType2()
 {
 }

/** Returns the size of this serialized object in bytes*/
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 2;  // numberOfValues
   marshalSize += 2;  // padding
   marshalSize += dataValues.length * 4;

   return marshalSize;
}


/** Setter for {@link GridDataType2#padding}*/
public GridDataType2 setPadding(short pPadding)
{
    padding = pPadding;
    return this;
}

/** Getter for {@link GridDataType2#padding}*/
public short getPadding()
{
    return padding; 
}

/** Setter for {@link GridDataType2#dataValues}*/
public GridDataType2 setDataValues(float[] pDataValues)
{
    dataValues = pDataValues;
    return this;
}

/** Getter for {@link GridDataType2#dataValues}*/
public float[] getDataValues()
{
    return dataValues; 
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
       dos.writeShort( (short)dataValues.length);
       dos.writeShort( (short)padding);

       for(int idx = 0; idx < dataValues.length; idx++)
           dos.writeFloat(dataValues[idx]);

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
        numberOfValues = (short)dis.readUnsignedShort();
        uPosition += 2;
        padding = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < dataValues.length; idx++)
            dataValues[idx] = dis.readFloat();
        uPosition += (dataValues.length * 4);
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
   buff.putShort( (short)dataValues.length);
   buff.putShort( (short)padding);

   for(int idx = 0; idx < dataValues.length; idx++)
       buff.putFloat((float)dataValues[idx]);

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

    numberOfValues = (short)(buff.getShort() & 0xFFFF);
    padding = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < dataValues.length; idx++)
        dataValues[idx] = buff.getFloat();
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

     final GridDataType2 rhs = (GridDataType2)obj;

     if( ! (padding == rhs.padding)) ivarsEqual = false;

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
    sb.append(getClass().getSimpleName()+":\n");

    sb.append(" padding: ").append(padding).append("\n");
    sb.append(" dataValues: ").append("\n");
    sb.append(Arrays.toString(dataValues)).append("\n");

   return sb.toString();
 }
} // end of class
