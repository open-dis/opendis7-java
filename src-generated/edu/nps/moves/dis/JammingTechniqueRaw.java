/**
 * Copyright (c) 2008-2019, MOVES Institute, Naval Postgraduate School. All rights reserved.
 * This work is licensed under the BSD open source license, available at https://www.movesinstitute.org/licenses/bsd.html
 */

package edu.nps.moves.dis;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis.enumerations.*;

/**
 * Jamming technique. Section 6.2.49, uid 284
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation—Application Protocols
 */
public class JammingTechniqueRaw extends Object implements Serializable
{
   protected byte  kind;

   protected byte  category;

   protected byte  subcategory;

   protected byte  specific;


/** Constructor */
 public JammingTechniqueRaw()
 {
 }

public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 1;  // kind
   marshalSize += 1;  // category
   marshalSize += 1;  // subcategory
   marshalSize += 1;  // specific

   return marshalSize;
}


public JammingTechniqueRaw setKind(byte pKind)
{
    kind = pKind;
    return this;
}

public byte getKind()
{
    return kind; 
}

public JammingTechniqueRaw setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}

public byte getCategory()
{
    return category; 
}

public JammingTechniqueRaw setSubcategory(byte pSubcategory)
{
    subcategory = pSubcategory;
    return this;
}

public byte getSubcategory()
{
    return subcategory; 
}

public JammingTechniqueRaw setSpecific(byte pSpecific)
{
    specific = pSpecific;
    return this;
}

public byte getSpecific()
{
    return specific; 
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
       dos.writeByte( (byte)kind);
       dos.writeByte( (byte)category);
       dos.writeByte( (byte)subcategory);
       dos.writeByte( (byte)specific);
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
        kind = (byte)dis.readUnsignedByte();
        uPosition += 1;
        category = (byte)dis.readUnsignedByte();
        uPosition += 1;
        subcategory = (byte)dis.readUnsignedByte();
        uPosition += 1;
        specific = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   buff.put( (byte)kind);
   buff.put( (byte)category);
   buff.put( (byte)subcategory);
   buff.put( (byte)specific);
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
    kind = (byte)(buff.get() & 0xFF);
    category = (byte)(buff.get() & 0xFF);
    subcategory = (byte)(buff.get() & 0xFF);
    specific = (byte)(buff.get() & 0xFF);
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

    if(!(obj instanceof JammingTechniqueRaw))
        return false;

     final JammingTechniqueRaw rhs = (JammingTechniqueRaw)obj;

     if( ! (kind == rhs.kind)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subcategory == rhs.subcategory)) ivarsEqual = false;
     if( ! (specific == rhs.specific)) ivarsEqual = false;
    return ivarsEqual;
 }
} // end of class
