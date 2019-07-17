package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;


/**
 * The identification of the additional information layer number, layer-specific information, and the length of the layer. Section 6.2.51
 *
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 *
 * @author DMcG
 */
public class LayerHeader extends Object implements Serializable
{
   protected byte  layerNumber;

   /** field shall specify layer-specific information that varies by System Type (see 6.2.86) and Layer Number. */
   protected byte  layerSpecificInformation;

   /** This field shall specify the length in octets of the layer, including the Layer Header record */
   protected short  length;


/** Constructor */
 public LayerHeader()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // layerNumber
   marshalSize += 1;  // layerSpecificInformation
   marshalSize += 2;  // length

   return marshalSize;
}


public LayerHeader setLayerNumber(byte pLayerNumber)
{
    layerNumber = pLayerNumber;
    return this;
}

public byte getLayerNumber()
{
    return layerNumber; 
}

public LayerHeader setLayerSpecificInformation(byte pLayerSpecificInformation)
{
    layerSpecificInformation = pLayerSpecificInformation;
    return this;
}

public byte getLayerSpecificInformation()
{
    return layerSpecificInformation; 
}

public LayerHeader setLength(short pLength)
{
    length = pLength;
    return this;
}

public short getLength()
{
    return length; 
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
       dos.writeByte( (byte)layerNumber);
       dos.writeByte( (byte)layerSpecificInformation);
       dos.writeShort( (short)length);
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
 */
public int unmarshal(DataInputStream dis)
{
    int uPosition = 0;
    try 
    {
        layerNumber = (byte)dis.readUnsignedByte();
        uPosition += 1;
        layerSpecificInformation = (byte)dis.readUnsignedByte();
        uPosition += 1;
        length = (short)dis.readUnsignedShort();
        uPosition += 2;
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
 */
public void marshal(java.nio.ByteBuffer buff) throws Exception
{
   buff.put( (byte)layerNumber);
   buff.put( (byte)layerSpecificInformation);
   buff.putShort( (short)length);
}

/**
 * Unpacks a Pdu from the underlying data.
 * @throws java.nio.BufferUnderflowException if buff is too small
 * @see java.nio.ByteBuffer
 * @param buff The ByteBuffer at the position to begin reading
 */
public int unmarshal(java.nio.ByteBuffer buff) throws Exception
{
    layerNumber = (byte)(buff.get() & 0xFF);
    layerSpecificInformation = (byte)(buff.get() & 0xFF);
    length = (short)(buff.getShort() & 0xFFFF);
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

    if(!(obj instanceof LayerHeader))
        return false;

     final LayerHeader rhs = (LayerHeader)obj;

     if( ! (layerNumber == rhs.layerNumber)) ivarsEqual = false;
     if( ! (layerSpecificInformation == rhs.layerSpecificInformation)) ivarsEqual = false;
     if( ! (length == rhs.length)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
