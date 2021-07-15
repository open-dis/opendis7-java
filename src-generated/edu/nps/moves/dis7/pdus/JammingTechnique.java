/**
 * Copyright (c) 2008-2021, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7.pdus;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * Jamming technique. Section 6.2.49, uid 284
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class JammingTechnique extends Object implements Serializable
{
   /** kind is an undescribed parameter... */
   protected byte  kind;

   /** category is an undescribed parameter... */
   protected byte  category;

   /** subCategory is an undescribed parameter... */
   protected byte  subCategory;

   /** specific is an undescribed parameter... */
   protected byte  specific;


/** Constructor */
 public JammingTechnique()
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

   marshalSize += 1;  // kind
   marshalSize += 1;  // category
   marshalSize += 1;  // subCategory
   marshalSize += 1;  // specific

   return marshalSize;
}


/** Setter for {@link JammingTechnique#kind}
  * @param pKind new value of interest
  * @return same object to permit progressive setters */
public JammingTechnique setKind(byte pKind)
{
    kind = pKind;
    return this;
}
/** Utility setter for {@link JammingTechnique#kind}
  * @param pKind new value of interest
  * @return same object to permit progressive setters */
public JammingTechnique setKind(int pKind){
    kind = (byte) pKind;
    return this;
}

/** Getter for {@link JammingTechnique#kind}
  * @return value of interest */
public byte getKind()
{
    return kind; 
}

/** Setter for {@link JammingTechnique#category}
  * @param pCategory new value of interest
  * @return same object to permit progressive setters */
public JammingTechnique setCategory(byte pCategory)
{
    category = pCategory;
    return this;
}
/** Utility setter for {@link JammingTechnique#category}
  * @param pCategory new value of interest
  * @return same object to permit progressive setters */
public JammingTechnique setCategory(int pCategory){
    category = (byte) pCategory;
    return this;
}

/** Getter for {@link JammingTechnique#category}
  * @return value of interest */
public byte getCategory()
{
    return category; 
}

/** Setter for {@link JammingTechnique#subCategory}
  * @param pSubCategory new value of interest
  * @return same object to permit progressive setters */
public JammingTechnique setSubCategory(byte pSubCategory)
{
    subCategory = pSubCategory;
    return this;
}
/** Utility setter for {@link JammingTechnique#subCategory}
  * @param pSubCategory new value of interest
  * @return same object to permit progressive setters */
public JammingTechnique setSubCategory(int pSubCategory){
    subCategory = (byte) pSubCategory;
    return this;
}

/** Getter for {@link JammingTechnique#subCategory}
  * @return value of interest */
public byte getSubCategory()
{
    return subCategory; 
}

/** Setter for {@link JammingTechnique#specific}
  * @param pSpecific new value of interest
  * @return same object to permit progressive setters */
public JammingTechnique setSpecific(byte pSpecific)
{
    specific = pSpecific;
    return this;
}
/** Utility setter for {@link JammingTechnique#specific}
  * @param pSpecific new value of interest
  * @return same object to permit progressive setters */
public JammingTechnique setSpecific(int pSpecific){
    specific = (byte) pSpecific;
    return this;
}

/** Getter for {@link JammingTechnique#specific}
  * @return value of interest */
public byte getSpecific()
{
    return specific; 
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
       dos.writeByte(kind);
       dos.writeByte(category);
       dos.writeByte(subCategory);
       dos.writeByte(specific);
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
    try 
    {
        kind = (byte)dis.readUnsignedByte();
        uPosition += 1;
        category = (byte)dis.readUnsignedByte();
        uPosition += 1;
        subCategory = (byte)dis.readUnsignedByte();
        uPosition += 1;
        specific = (byte)dis.readUnsignedByte();
        uPosition += 1;
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
   byteBuffer.put( (byte)kind);
   byteBuffer.put( (byte)category);
   byteBuffer.put( (byte)subCategory);
   byteBuffer.put( (byte)specific);
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
    kind = (byte)(byteBuffer.get() & 0xFF);
    category = (byte)(byteBuffer.get() & 0xFF);
    subCategory = (byte)(byteBuffer.get() & 0xFF);
    specific = (byte)(byteBuffer.get() & 0xFF);
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

     final JammingTechnique rhs = (JammingTechnique)obj;

     if( ! (kind == rhs.kind)) ivarsEqual = false;
     if( ! (category == rhs.category)) ivarsEqual = false;
     if( ! (subCategory == rhs.subCategory)) ivarsEqual = false;
     if( ! (specific == rhs.specific)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" kind: ").append(kind).append("\n");
    sb.append(" category: ").append(category).append("\n");
    sb.append(" subCategory: ").append(subCategory).append("\n");
    sb.append(" specific: ").append(specific).append("\n");

   return sb.toString();
 }
} // end of class
