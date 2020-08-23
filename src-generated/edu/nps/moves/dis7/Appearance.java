/**
 * Copyright (c) 2008-2020, MOVES Institute, Naval Postgraduate School (NPS). All rights reserved.
 * This work is provided under a BSD open-source license, see project license.html and license.txt
 */

package edu.nps.moves.dis7;

import java.util.*;
import java.io.*;
import edu.nps.moves.dis7.enumerations.*;

/**
 * used in AppearancePdu
 * IEEE Std 1278.1-2012, IEEE Standard for Distributed Interactive Simulation - Application Protocols
 */
public class Appearance extends Object implements Serializable
{
   protected int  visual;

   protected int  ir;

   protected int  em;

   protected int  audio;


/** Constructor */
 public Appearance()
 {
 }

  /**
   * Returns size of this serialized object in bytes
   * @return size in bytes
   */
public int getMarshalledSize()
{
   int marshalSize = 0; 

   marshalSize += 4;  // visual
   marshalSize += 4;  // ir
   marshalSize += 4;  // em
   marshalSize += 4;  // audio

   return marshalSize;
}


/** Setter for {@link Appearance#visual}*/
public Appearance setVisual(int pVisual)
{
    visual = pVisual;
    return this;
}

/** Getter for {@link Appearance#visual}*/
public int getVisual()
{
    return visual; 
}

/** Setter for {@link Appearance#ir}*/
public Appearance setIr(int pIr)
{
    ir = pIr;
    return this;
}

/** Getter for {@link Appearance#ir}*/
public int getIr()
{
    return ir; 
}

/** Setter for {@link Appearance#em}*/
public Appearance setEm(int pEm)
{
    em = pEm;
    return this;
}

/** Getter for {@link Appearance#em}*/
public int getEm()
{
    return em; 
}

/** Setter for {@link Appearance#audio}*/
public Appearance setAudio(int pAudio)
{
    audio = pAudio;
    return this;
}

/** Getter for {@link Appearance#audio}*/
public int getAudio()
{
    return audio; 
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
       dos.writeInt(visual);
       dos.writeInt(ir);
       dos.writeInt(em);
       dos.writeInt(audio);
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
    try 
    {
        visual = dis.readInt();
        uPosition += 4;
        ir = dis.readInt();
        uPosition += 4;
        em = dis.readInt();
        uPosition += 4;
        audio = dis.readInt();
        uPosition += 4;
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
   buff.putInt( (int)visual);
   buff.putInt( (int)ir);
   buff.putInt( (int)em);
   buff.putInt( (int)audio);
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
    visual = buff.getInt();
    ir = buff.getInt();
    em = buff.getInt();
    audio = buff.getInt();
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

     final Appearance rhs = (Appearance)obj;

     if( ! (visual == rhs.visual)) ivarsEqual = false;
     if( ! (ir == rhs.ir)) ivarsEqual = false;
     if( ! (em == rhs.em)) ivarsEqual = false;
     if( ! (audio == rhs.audio)) ivarsEqual = false;
    return ivarsEqual;
 }

 @Override
 public String toString()
 {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName()).append(":\n");

    sb.append(" visual: ").append(visual).append("\n");
    sb.append(" ir: ").append(ir).append("\n");
    sb.append(" em: ").append(em).append("\n");
    sb.append(" audio: ").append(audio).append("\n");

   return sb.toString();
 }
} // end of class
