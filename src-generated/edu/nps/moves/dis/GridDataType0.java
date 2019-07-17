package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * 6.2.41, table 68
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class GridDataType0 extends GridData implements Serializable
{
   protected short  numberOfBytes;

   protected byte[]  dataValues = new byte[0]; 

   private byte[] padding = new byte[0]; // pad to 16-bit boundary


/** Constructor */
 public GridDataType0()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize = super.getMarshalledSize();
   marshalSize += 2;  // numberOfBytes
   marshalSize += dataValues.length * 1;
   marshalSize += padding.length;

   return marshalSize;
}


public GridDataType0 setDataValues(byte[] pDataValues)
{
    dataValues = pDataValues;
    return this;
}

public byte[] getDataValues()
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
       dos.writeShort( (short)numberOfBytes);

       for(int idx = 0; idx < dataValues.length; idx++)
           dos.writeByte(dataValues[idx]);

       padding = new byte[Align.to16bits(dos)];
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
        numberOfBytes = (short)dis.readUnsignedShort();
        uPosition += 2;
        for(int idx = 0; idx < dataValues.length; idx++)
            dataValues[idx] = dis.readByte(); // mike check
        uPosition += dataValues.length; // todo, multiply by prim size mike
        padding = new byte[Align.from16bits(uPosition,dis)];
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
   buff.putShort( (short)numberOfBytes);

   for(int idx = 0; idx < dataValues.length; idx++)
       buff.put((byte)dataValues[idx]);

   padding = new byte[Align.to16bits(buff)];
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

    numberOfBytes = (short)(buff.getShort() & 0xFFFF);
    for(int idx = 0; idx < dataValues.length; idx++)
        dataValues[idx] = buff.get();
    padding = new byte[Align.from16bits(buff)];
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

    if(!(obj instanceof GridDataType0))
        return false;

     final GridDataType0 rhs = (GridDataType0)obj;

     if( ! (numberOfBytes == rhs.numberOfBytes)) ivarsEqual = false;

     for(int idx = 0; idx < 0; idx++)
     {
          if(!(dataValues[idx] == rhs.dataValues[idx])) ivarsEqual = false;
     }

    return ivarsEqual && super.equalsImpl(rhs);
 }
} // end of class
